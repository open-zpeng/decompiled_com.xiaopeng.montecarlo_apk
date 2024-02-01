package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import com.xiaopeng.montecarlo.GlideApp;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.xpglide.IXpImageLoadListener;
import com.xiaopeng.montecarlo.xpglide.XpGlideCacheHelper;
/* loaded from: classes3.dex */
public class XpNetworkImageViewTarget extends ImageViewTarget<Bitmap> {
    private static final float DEFAULT_BASE_RATIO = 0.5f;
    private static final int DEFAULT_RETRY_DELAY = 100;
    private static final int DEFAULT_RETRY_TIME = 3;
    private static final int MAX_BITMAP_SIZE = 104857600;
    private static final L.Tag TAG = new L.Tag("XpGlideImageTarget");
    private Bitmap mBitmap;
    private final Context mContext;
    private final int mHeight;
    private String mImageUrl;
    private int mMaxRetryTimes;
    private RequestOptions mRequestOptions;
    private final Handler mRetryHandler;
    private int mRetryTimes;
    private final int mWidth;
    private final IXpImageLoadListener mXpImageLoadListener;

    public XpNetworkImageViewTarget(Context context, @NonNull ImageView imageView, int i, int i2, IXpImageLoadListener iXpImageLoadListener) {
        super(imageView);
        this.mMaxRetryTimes = 0;
        this.mRetryTimes = 0;
        this.mRetryHandler = new Handler();
        this.mBitmap = null;
        this.mContext = context;
        this.mXpImageLoadListener = iXpImageLoadListener;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void loadImageWithRetry(@NonNull RequestOptions requestOptions, String str) {
        this.mRequestOptions = requestOptions;
        this.mImageUrl = str;
        this.mMaxRetryTimes = 3;
        this.mRetryTimes = 0;
        innerLoadImage(this.mRequestOptions, this.mImageUrl);
    }

    public void reset() {
        this.mRetryHandler.removeCallbacksAndMessages(null);
        GlideApp.with(this.mContext).clear(this);
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.mBitmap.recycle();
    }

    private void innerLoadImage(RequestOptions requestOptions, String str) {
        Glide.with(this.mContext).asBitmap().apply(requestOptions).load(str).into((RequestBuilder<Bitmap>) this);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition transition) {
        IXpImageLoadListener iXpImageLoadListener = this.mXpImageLoadListener;
        if (iXpImageLoadListener != null) {
            iXpImageLoadListener.onLoadSuccess(bitmap);
        }
        if (bitmap.getByteCount() >= MAX_BITMAP_SIZE) {
            float byteCount = 5.24288E7f / bitmap.getByteCount();
            L.Tag tag = TAG;
            L.w(tag, "resource is too large. mImageUrl:" + this.mImageUrl + ", size:" + bitmap.getByteCount() + ", ratio:" + byteCount);
            Bitmap bitmap2 = this.mBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.mBitmap.recycle();
            }
            this.mBitmap = scaleBitmap(bitmap, byteCount);
            getView().setImageBitmap(this.mBitmap);
            return;
        }
        getView().setImageBitmap(bitmap);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(@Nullable Drawable drawable) {
        if (!TextUtils.isEmpty(this.mImageUrl)) {
            XpGlideCacheHelper.getInstance().removeCache(this, this.mImageUrl);
        }
        if (this.mRetryTimes < this.mMaxRetryTimes) {
            L.Tag tag = TAG;
            L.i(tag, "onLoadFailed retry:" + this.mRetryTimes);
            this.mRetryTimes = this.mRetryTimes + 1;
            this.mRetryHandler.postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.views.-$$Lambda$XpNetworkImageViewTarget$_cFuD7vFHH8_-tbaxz_yqLJ8O9k
                @Override // java.lang.Runnable
                public final void run() {
                    XpNetworkImageViewTarget.this.lambda$onLoadFailed$0$XpNetworkImageViewTarget();
                }
            }, 100L);
            return;
        }
        IXpImageLoadListener iXpImageLoadListener = this.mXpImageLoadListener;
        if (iXpImageLoadListener != null) {
            iXpImageLoadListener.onLoadFailed();
        }
    }

    public /* synthetic */ void lambda$onLoadFailed$0$XpNetworkImageViewTarget() {
        innerLoadImage(this.mRequestOptions, this.mImageUrl);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        IXpImageLoadListener iXpImageLoadListener = this.mXpImageLoadListener;
        if (iXpImageLoadListener != null) {
            iXpImageLoadListener.onLoadStarted();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(@Nullable Bitmap bitmap) {
        getView().setImageBitmap(bitmap);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.Target
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        int i;
        int i2 = this.mWidth;
        if (i2 > 0 && (i = this.mHeight) > 0) {
            sizeReadyCallback.onSizeReady(i2, i);
        } else {
            sizeReadyCallback.onSizeReady(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        super.getSize(sizeReadyCallback);
    }

    private Bitmap scaleBitmap(@NonNull Bitmap bitmap, float f) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }
}
