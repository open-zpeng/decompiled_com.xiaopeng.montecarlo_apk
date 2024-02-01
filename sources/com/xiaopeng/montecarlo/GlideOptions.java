package com.xiaopeng.montecarlo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.RequestOptions;
/* loaded from: classes.dex */
public final class GlideOptions extends RequestOptions implements Cloneable {
    private static GlideOptions centerCropTransform2;
    private static GlideOptions centerInsideTransform1;
    private static GlideOptions circleCropTransform3;
    private static GlideOptions fitCenterTransform0;
    private static GlideOptions noAnimation5;
    private static GlideOptions noTransformation4;

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestOptions decode(@NonNull Class cls) {
        return decode((Class<?>) cls);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestOptions optionalTransform(@NonNull Transformation transformation) {
        return optionalTransform((Transformation<Bitmap>) transformation);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestOptions set(@NonNull Option option, @NonNull Object obj) {
        return set((Option<Option>) option, (Option) obj);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ RequestOptions transform(@NonNull Transformation transformation) {
        return transform((Transformation<Bitmap>) transformation);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @SafeVarargs
    @CheckResult
    public /* bridge */ /* synthetic */ RequestOptions transforms(@NonNull Transformation[] transformationArr) {
        return transforms((Transformation<Bitmap>[]) transformationArr);
    }

    @NonNull
    @CheckResult
    public static GlideOptions sizeMultiplierOf(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return new GlideOptions().sizeMultiplier(f);
    }

    @NonNull
    @CheckResult
    public static GlideOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return new GlideOptions().diskCacheStrategy(diskCacheStrategy);
    }

    @NonNull
    @CheckResult
    public static GlideOptions priorityOf(@NonNull Priority priority) {
        return new GlideOptions().priority(priority);
    }

    @NonNull
    @CheckResult
    public static GlideOptions placeholderOf(@Nullable Drawable drawable) {
        return new GlideOptions().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static GlideOptions placeholderOf(@DrawableRes int i) {
        return new GlideOptions().placeholder(i);
    }

    @NonNull
    @CheckResult
    public static GlideOptions errorOf(@Nullable Drawable drawable) {
        return new GlideOptions().error(drawable);
    }

    @NonNull
    @CheckResult
    public static GlideOptions errorOf(@DrawableRes int i) {
        return new GlideOptions().error(i);
    }

    @NonNull
    @CheckResult
    public static GlideOptions skipMemoryCacheOf(boolean z) {
        return new GlideOptions().skipMemoryCache(z);
    }

    @NonNull
    @CheckResult
    public static GlideOptions overrideOf(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        return new GlideOptions().override(i, i2);
    }

    @NonNull
    @CheckResult
    public static GlideOptions overrideOf(@IntRange(from = 0) int i) {
        return new GlideOptions().override(i);
    }

    @NonNull
    @CheckResult
    public static GlideOptions signatureOf(@NonNull Key key) {
        return new GlideOptions().signature(key);
    }

    @NonNull
    @CheckResult
    public static GlideOptions fitCenterTransform() {
        if (fitCenterTransform0 == null) {
            fitCenterTransform0 = new GlideOptions().fitCenter().autoClone();
        }
        return fitCenterTransform0;
    }

    @NonNull
    @CheckResult
    public static GlideOptions centerInsideTransform() {
        if (centerInsideTransform1 == null) {
            centerInsideTransform1 = new GlideOptions().centerInside().autoClone();
        }
        return centerInsideTransform1;
    }

    @NonNull
    @CheckResult
    public static GlideOptions centerCropTransform() {
        if (centerCropTransform2 == null) {
            centerCropTransform2 = new GlideOptions().centerCrop().autoClone();
        }
        return centerCropTransform2;
    }

    @NonNull
    @CheckResult
    public static GlideOptions circleCropTransform() {
        if (circleCropTransform3 == null) {
            circleCropTransform3 = new GlideOptions().circleCrop().autoClone();
        }
        return circleCropTransform3;
    }

    @NonNull
    @CheckResult
    public static GlideOptions bitmapTransform(@NonNull Transformation<Bitmap> transformation) {
        return new GlideOptions().transform(transformation);
    }

    @NonNull
    @CheckResult
    public static GlideOptions noTransformation() {
        if (noTransformation4 == null) {
            noTransformation4 = new GlideOptions().dontTransform().autoClone();
        }
        return noTransformation4;
    }

    @NonNull
    @CheckResult
    public static <T> GlideOptions option(@NonNull Option<T> option, @NonNull T t) {
        return new GlideOptions().set((Option<Option<T>>) option, (Option<T>) t);
    }

    @NonNull
    @CheckResult
    public static GlideOptions decodeTypeOf(@NonNull Class<?> cls) {
        return new GlideOptions().decode(cls);
    }

    @NonNull
    @CheckResult
    public static GlideOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        return new GlideOptions().format(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static GlideOptions frameOf(@IntRange(from = 0) long j) {
        return new GlideOptions().frame(j);
    }

    @NonNull
    @CheckResult
    public static GlideOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        return new GlideOptions().downsample(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static GlideOptions timeoutOf(@IntRange(from = 0) int i) {
        return new GlideOptions().timeout(i);
    }

    @NonNull
    @CheckResult
    public static GlideOptions encodeQualityOf(@IntRange(from = 0, to = 100) int i) {
        return new GlideOptions().encodeQuality(i);
    }

    @NonNull
    @CheckResult
    public static GlideOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return new GlideOptions().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static GlideOptions noAnimation() {
        if (noAnimation5 == null) {
            noAnimation5 = new GlideOptions().dontAnimate().autoClone();
        }
        return noAnimation5;
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (GlideOptions) super.sizeMultiplier(f);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return (GlideOptions) super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions useAnimationPool(boolean z) {
        return (GlideOptions) super.useAnimationPool(z);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions onlyRetrieveFromCache(boolean z) {
        return (GlideOptions) super.onlyRetrieveFromCache(z);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (GlideOptions) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions priority(@NonNull Priority priority) {
        return (GlideOptions) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions placeholder(@Nullable Drawable drawable) {
        return (GlideOptions) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions placeholder(@DrawableRes int i) {
        return (GlideOptions) super.placeholder(i);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions fallback(@Nullable Drawable drawable) {
        return (GlideOptions) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions fallback(@DrawableRes int i) {
        return (GlideOptions) super.fallback(i);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions error(@Nullable Drawable drawable) {
        return (GlideOptions) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions error(@DrawableRes int i) {
        return (GlideOptions) super.error(i);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions theme(@Nullable Resources.Theme theme) {
        return (GlideOptions) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions skipMemoryCache(boolean z) {
        return (GlideOptions) super.skipMemoryCache(z);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions override(int i, int i2) {
        return (GlideOptions) super.override(i, i2);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions override(int i) {
        return (GlideOptions) super.override(i);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions signature(@NonNull Key key) {
        return (GlideOptions) super.signature(key);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    /* renamed from: clone */
    public final GlideOptions mo84clone() {
        return (GlideOptions) super.mo84clone();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final <T> GlideOptions set(@NonNull Option<T> option, @NonNull T t) {
        return (GlideOptions) super.set((Option<Option<T>>) option, (Option<T>) t);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions decode(@NonNull Class<?> cls) {
        return (GlideOptions) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (GlideOptions) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions encodeQuality(@IntRange(from = 0, to = 100) int i) {
        return (GlideOptions) super.encodeQuality(i);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions frame(@IntRange(from = 0) long j) {
        return (GlideOptions) super.frame(j);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions format(@NonNull DecodeFormat decodeFormat) {
        return (GlideOptions) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions disallowHardwareConfig() {
        return (GlideOptions) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions timeout(@IntRange(from = 0) int i) {
        return (GlideOptions) super.timeout(i);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions optionalCenterCrop() {
        return (GlideOptions) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions centerCrop() {
        return (GlideOptions) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions optionalFitCenter() {
        return (GlideOptions) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions fitCenter() {
        return (GlideOptions) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions optionalCenterInside() {
        return (GlideOptions) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions centerInside() {
        return (GlideOptions) super.centerInside();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions optionalCircleCrop() {
        return (GlideOptions) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions circleCrop() {
        return (GlideOptions) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions transform(@NonNull Transformation<Bitmap> transformation) {
        return (GlideOptions) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @SafeVarargs
    @CheckResult
    public final GlideOptions transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (GlideOptions) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (GlideOptions) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final <T> GlideOptions optionalTransform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation) {
        return (GlideOptions) super.optionalTransform((Class) cls, (Transformation) transformation);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final <T> GlideOptions transform(@NonNull Class<T> cls, @NonNull Transformation<T> transformation) {
        return (GlideOptions) super.transform((Class) cls, (Transformation) transformation);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions dontTransform() {
        return (GlideOptions) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions dontAnimate() {
        return (GlideOptions) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    @CheckResult
    public final GlideOptions apply(@NonNull RequestOptions requestOptions) {
        return (GlideOptions) super.apply(requestOptions);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    public final GlideOptions lock() {
        return (GlideOptions) super.lock();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    public final GlideOptions autoClone() {
        return (GlideOptions) super.autoClone();
    }
}
