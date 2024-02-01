package com.xiaopeng.montecarlo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;
/* loaded from: classes.dex */
public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    GlideRequest(@NonNull Class<TranscodeType> cls, @NonNull RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GlideRequest(@NonNull Glide glide, @NonNull RequestManager requestManager, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(glide, requestManager, cls, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    public GlideRequest<File> getDownloadOnlyRequest() {
        return new GlideRequest(File.class, this).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).sizeMultiplier(f);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).sizeMultiplier(f);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).useUnlimitedSourceGeneratorsPool(z);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).useUnlimitedSourceGeneratorsPool(z);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> useAnimationPool(boolean z) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).useAnimationPool(z);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).useAnimationPool(z);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean z) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).onlyRetrieveFromCache(z);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).onlyRetrieveFromCache(z);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).diskCacheStrategy(diskCacheStrategy);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).diskCacheStrategy(diskCacheStrategy);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> priority(@NonNull Priority priority) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).priority(priority);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).priority(priority);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> placeholder(@Nullable Drawable drawable) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).placeholder(drawable);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).placeholder(drawable);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> placeholder(@DrawableRes int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).placeholder(i);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).placeholder(i);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> fallback(@Nullable Drawable drawable) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).fallback(drawable);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).fallback(drawable);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> fallback(@DrawableRes int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).fallback(i);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).fallback(i);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> error(@Nullable Drawable drawable) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).error(drawable);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).error(drawable);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> error(@DrawableRes int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).error(i);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).error(i);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> theme(@Nullable Resources.Theme theme) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).theme(theme);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).theme(theme);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> skipMemoryCache(boolean z) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).skipMemoryCache(z);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).skipMemoryCache(z);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> override(int i, int i2) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).override(i, i2);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).override(i, i2);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> override(int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).override(i);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).override(i);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> signature(@NonNull Key key) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).signature(key);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).signature(key);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public <T> GlideRequest<TranscodeType> set(@NonNull Option<T> option, @NonNull T t) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).set((Option<Option<T>>) option, (Option<T>) t);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).set((Option<Option<T>>) option, (Option<T>) t);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> decode(@NonNull Class<?> cls) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).decode(cls);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).decode(cls);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).encodeFormat(compressFormat);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).encodeFormat(compressFormat);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> encodeQuality(@IntRange(from = 0, to = 100) int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).encodeQuality(i);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).encodeQuality(i);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> frame(@IntRange(from = 0) long j) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).frame(j);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).frame(j);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> format(@NonNull DecodeFormat decodeFormat) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).format(decodeFormat);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).format(decodeFormat);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> disallowHardwareConfig() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).disallowHardwareConfig();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).disallowHardwareConfig();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).downsample(downsampleStrategy);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).downsample(downsampleStrategy);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> timeout(@IntRange(from = 0) int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).timeout(i);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).timeout(i);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalCenterCrop() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).optionalCenterCrop();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).optionalCenterCrop();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> centerCrop() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).centerCrop();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).centerCrop();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalFitCenter() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).optionalFitCenter();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).optionalFitCenter();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> fitCenter() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).fitCenter();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).fitCenter();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalCenterInside() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).optionalCenterInside();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).optionalCenterInside();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> centerInside() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).centerInside();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).centerInside();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalCircleCrop() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).optionalCircleCrop();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).optionalCircleCrop();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> circleCrop() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).circleCrop();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).circleCrop();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> transform(@NonNull Transformation<Bitmap> transformation) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).transform(transformation);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).transform(transformation);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).transforms(transformationArr);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).transforms(transformationArr);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).optionalTransform(transformation);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).optionalTransform(transformation);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public <T> GlideRequest<TranscodeType> optionalTransform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).optionalTransform((Class) cls, (Transformation) transformation);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).optionalTransform((Class) cls, (Transformation) transformation);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public <T> GlideRequest<TranscodeType> transform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).transform((Class) cls, (Transformation) transformation);
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).transform((Class) cls, (Transformation) transformation);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> dontTransform() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).dontTransform();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).dontTransform();
        }
        return this;
    }

    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> dontAnimate() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).dontAnimate();
        } else {
            this.requestOptions = new GlideOptions().apply(this.requestOptions).dontAnimate();
        }
        return this;
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> apply(@NonNull RequestOptions requestOptions) {
        return (GlideRequest) super.apply(requestOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (GlideRequest) super.transition((TransitionOptions) transitionOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.listener((RequestListener) requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.addListener((RequestListener) requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    public GlideRequest<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.error((RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.thumbnail((RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @SafeVarargs
    @CheckResult
    public final GlideRequest<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (GlideRequest) super.thumbnail((RequestBuilder[]) requestBuilderArr);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> thumbnail(float f) {
        return (GlideRequest) super.thumbnail(f);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> load(@Nullable Object obj) {
        return (GlideRequest) super.load(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> load(@Nullable Bitmap bitmap) {
        return (GlideRequest) super.load(bitmap);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> load(@Nullable Drawable drawable) {
        return (GlideRequest) super.load(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> load(@Nullable String str) {
        return (GlideRequest) super.load(str);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> load(@Nullable Uri uri) {
        return (GlideRequest) super.load(uri);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> load(@Nullable File file) {
        return (GlideRequest) super.load(file);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> load(@Nullable @DrawableRes @RawRes Integer num) {
        return (GlideRequest) super.load(num);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    public GlideRequest<TranscodeType> load(@Nullable URL url) {
        return (GlideRequest) super.load(url);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> load(@Nullable byte[] bArr) {
        return (GlideRequest) super.load(bArr);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @CheckResult
    /* renamed from: clone */
    public GlideRequest<TranscodeType> mo82clone() {
        return (GlideRequest) super.mo82clone();
    }
}
