package brave.sampler;

import brave.internal.Nullable;
import brave.propagation.SamplingFlags;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public final class DeclarativeSampler<M> {
    static final Sampler NULL_SENTINEL = new Sampler() { // from class: brave.sampler.DeclarativeSampler.3
        @Override // brave.sampler.Sampler
        public boolean isSampled(long j) {
            throw new AssertionError();
        }
    };
    final ConcurrentMap<M, Sampler> methodsToSamplers = new ConcurrentHashMap();
    final RateForMethod<M> rateForMethod;

    /* loaded from: classes.dex */
    public interface RateForMethod<M> {
        @Nullable
        Float get(M m);
    }

    public static <M> DeclarativeSampler<M> create(RateForMethod<M> rateForMethod) {
        return new DeclarativeSampler<>(rateForMethod);
    }

    DeclarativeSampler(RateForMethod<M> rateForMethod) {
        this.rateForMethod = rateForMethod;
    }

    public Sampler toSampler(final M m) {
        if (m == null) {
            throw new NullPointerException("method == null");
        }
        return new Sampler() { // from class: brave.sampler.DeclarativeSampler.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // brave.sampler.Sampler
            public boolean isSampled(long j) {
                Boolean sampled = DeclarativeSampler.this.sample((DeclarativeSampler) m).sampled();
                if (sampled != null) {
                    return sampled.booleanValue();
                }
                return false;
            }
        };
    }

    public Sampler toSampler(final M m, final Sampler sampler) {
        if (m != null) {
            if (sampler == null) {
                throw new NullPointerException("fallback == null");
            }
            return new Sampler() { // from class: brave.sampler.DeclarativeSampler.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // brave.sampler.Sampler
                public boolean isSampled(long j) {
                    Boolean sampled = DeclarativeSampler.this.sample((DeclarativeSampler) m).sampled();
                    if (sampled == null) {
                        return sampler.isSampled(j);
                    }
                    return sampled.booleanValue();
                }
            };
        }
        throw new NullPointerException("method == null");
    }

    public SamplingFlags sample(@Nullable M m) {
        if (m == null) {
            return SamplingFlags.EMPTY;
        }
        Sampler sampler = this.methodsToSamplers.get(m);
        if (sampler == NULL_SENTINEL) {
            return SamplingFlags.EMPTY;
        }
        if (sampler != null) {
            return sample(sampler);
        }
        Float f = this.rateForMethod.get(m);
        if (f == null) {
            this.methodsToSamplers.put(m, NULL_SENTINEL);
            return SamplingFlags.EMPTY;
        }
        Sampler create = CountingSampler.create(f.floatValue());
        Sampler putIfAbsent = this.methodsToSamplers.putIfAbsent(m, create);
        if (putIfAbsent == null) {
            putIfAbsent = create;
        }
        return sample(putIfAbsent);
    }

    private SamplingFlags sample(Sampler sampler) {
        if (sampler.isSampled(0L)) {
            return SamplingFlags.SAMPLED;
        }
        return SamplingFlags.NOT_SAMPLED;
    }
}
