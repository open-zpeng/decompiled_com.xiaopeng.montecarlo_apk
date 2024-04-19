package com.xiaopeng.montecarlo.root.util.bitmapfactory;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapCreateParam;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.DecodeByteParam;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.DecodeResourceParam;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class BitmapFactoryXP {
    private static final L.Tag TAG = new L.Tag("BitmapFactoryXP");

    /* loaded from: classes3.dex */
    public interface IDecodeResultListener {
        void onComplete();

        void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult);
    }

    public static void decodeResourceAsync(Resources resources, BitmapFactory.Options options, IDecodeResultListener iDecodeResultListener, int... iArr) {
        DecodeResourceParam.Builder builder = new DecodeResourceParam.Builder(resources);
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (iArr[i] != 0) {
                builder.putParam(iArr[i], options);
            }
        }
        decodeResourceAsync(builder.build(), iDecodeResultListener);
    }

    public static void decodeResourceAsync(Resources resources, IDecodeResultListener iDecodeResultListener, int... iArr) {
        decodeResourceAsync(resources, null, iDecodeResultListener, iArr);
    }

    public static void decodeResourceAsync(@NonNull DecodeResourceParam decodeResourceParam, @NonNull IDecodeResultListener iDecodeResultListener) {
        doAction(decodeResourceParam, iDecodeResultListener);
    }

    public static void decodeByteArrayAsync(byte[] bArr, int i, int i2, @NonNull IDecodeResultListener iDecodeResultListener) {
        decodeByteArrayAsync(bArr, i, i2, null, iDecodeResultListener);
    }

    public static void decodeByteArrayAsync(byte[] bArr, int i, int i2, BitmapFactory.Options options, @NonNull IDecodeResultListener iDecodeResultListener) {
        DecodeByteParam.Builder builder = new DecodeByteParam.Builder();
        builder.mData(bArr).mOffset(i).mLength(i2).mOpts(options);
        doAction(builder.build(), iDecodeResultListener);
    }

    public static void createScaledBitmapAsync(@NonNull Bitmap bitmap, int i, int i2, boolean z, @NonNull IDecodeResultListener iDecodeResultListener) {
        BitmapCreateParam.Builder builder = new BitmapCreateParam.Builder();
        builder.mSourceBitmap(bitmap).mDstWidth(i).mDstHeight(i2).mFilter(z);
        doAction(builder.build(), iDecodeResultListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doFetchAction(@NonNull BitmapFactoryParam bitmapFactoryParam, ObservableEmitter<BitmapFactoryResult> observableEmitter) {
        int i = bitmapFactoryParam.mType;
        if (i == 0) {
            doFetchDecodeResource(bitmapFactoryParam, observableEmitter);
        } else if (i == 1) {
            doFetchDecodeByte(bitmapFactoryParam, observableEmitter);
        } else if (i == 2) {
            doFetchCreateScaleBitmap(bitmapFactoryParam, observableEmitter);
        } else if (i == 3) {
            doFetchCreateBitmapByView(bitmapFactoryParam, observableEmitter);
        } else if (i != 4) {
        } else {
            doFetchDecodeTextures(bitmapFactoryParam, observableEmitter);
        }
    }

    private static void doAction(@NonNull final BitmapFactoryParam bitmapFactoryParam, @NonNull final IDecodeResultListener iDecodeResultListener) {
        Observable create = Observable.create(new ObservableOnSubscribe<BitmapFactoryResult>() { // from class: com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.1
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<BitmapFactoryResult> observableEmitter) throws Exception {
                BitmapFactoryXP.doFetchAction(BitmapFactoryParam.this, observableEmitter);
                observableEmitter.onComplete();
            }
        });
        create.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BitmapFactoryResult>() { // from class: com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.2
            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                L.e(BitmapFactoryXP.TAG, th.getMessage());
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                IDecodeResultListener.this.onComplete();
            }

            @Override // io.reactivex.Observer
            public void onNext(BitmapFactoryResult bitmapFactoryResult) {
                IDecodeResultListener.this.onDecodeSuccess(bitmapFactoryResult);
            }
        });
    }

    private static void doFetchDecodeByte(@NonNull BitmapFactoryParam bitmapFactoryParam, ObservableEmitter<BitmapFactoryResult> observableEmitter) {
        if (!(bitmapFactoryParam instanceof DecodeByteParam)) {
            throw new IllegalArgumentException();
        }
        DecodeByteParam decodeByteParam = (DecodeByteParam) bitmapFactoryParam;
        observableEmitter.onNext(new BitmapFactoryResult(0, BitmapFactory.decodeByteArray(decodeByteParam.mData, decodeByteParam.mOffset, decodeByteParam.mLength, decodeByteParam.mOpts)));
    }

    private static void doFetchDecodeResource(@NonNull BitmapFactoryParam bitmapFactoryParam, ObservableEmitter<BitmapFactoryResult> observableEmitter) {
        Bitmap decodeResource;
        Bitmap bitmap;
        Rect rect;
        if (!(bitmapFactoryParam instanceof DecodeResourceParam)) {
            throw new IllegalArgumentException();
        }
        DecodeResourceParam decodeResourceParam = (DecodeResourceParam) bitmapFactoryParam;
        HashMap<Integer, BitmapFactory.Options> hashMap = decodeResourceParam.mParams;
        if (CollectionUtils.isEmpty(hashMap)) {
            return;
        }
        for (Map.Entry<Integer, BitmapFactory.Options> entry : hashMap.entrySet()) {
            if (decodeResourceParam.mIsUseDrawable) {
                Drawable drawable = decodeResourceParam.mRes.getDrawable(entry.getKey().intValue(), null);
                if (drawable != null && (drawable instanceof VectorDrawable)) {
                    if (Build.VERSION.SDK_INT < 21) {
                        drawable = DrawableCompat.wrap(drawable).mutate();
                    }
                    decodeResource = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(decodeResource);
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawable.draw(canvas);
                } else {
                    decodeResource = BitmapFactory.decodeResource(decodeResourceParam.mRes, entry.getKey().intValue(), entry.getValue());
                }
            } else {
                decodeResource = BitmapFactory.decodeResource(decodeResourceParam.mRes, entry.getKey().intValue(), entry.getValue());
            }
            if (decodeResourceParam.mTextOption == null || decodeResource == null || decodeResource.isRecycled()) {
                bitmap = decodeResource;
            } else {
                Bitmap.Config config = decodeResource.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                bitmap = decodeResource.copy(config, true);
                decodeResource.recycle();
                Paint paint = new Paint((decodeResourceParam.mTextOption.mTextIsBold ? 32 : 0) | 1);
                paint.setColor(decodeResourceParam.mTextOption.mTextColor);
                paint.setTextSize(decodeResourceParam.mTextOption.mTextSize);
                paint.getTextBounds(decodeResourceParam.mTextOption.mTextName, 0, decodeResourceParam.mTextOption.mTextName.length(), new Rect());
                paint.setDither(true);
                paint.setFilterBitmap(true);
                new Canvas(bitmap).drawText(decodeResourceParam.mTextOption.mTextName, ((bitmap.getWidth() - rect.width()) / 2) + decodeResourceParam.mTextOption.mTextOffsetX, ((bitmap.getHeight() + rect.height()) / 2) + decodeResourceParam.mTextOption.mTextOffsetY, paint);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                String str = "doFetchDecodeResource bitmap error " + entry.getKey();
                L.w(TAG, str);
                observableEmitter.onError(new Throwable(str));
            }
            if (decodeResourceParam.mIsNeedScale && bitmap != null && !bitmap.isRecycled()) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * decodeResourceParam.mScalePercent) / 100, (bitmap.getHeight() * decodeResourceParam.mScalePercent) / 100, true);
                bitmap.recycle();
                observableEmitter.onNext(new BitmapFactoryResult(entry.getKey().intValue(), createScaledBitmap));
            } else {
                observableEmitter.onNext(new BitmapFactoryResult(entry.getKey().intValue(), bitmap));
            }
        }
    }

    private static void doFetchDecodeTextures(@NonNull BitmapFactoryParam bitmapFactoryParam, ObservableEmitter<BitmapFactoryResult> observableEmitter) {
        Bitmap decodeResource;
        Bitmap bitmap;
        Rect rect;
        if (!(bitmapFactoryParam instanceof DecodeResourceParam)) {
            throw new IllegalArgumentException();
        }
        DecodeResourceParam decodeResourceParam = (DecodeResourceParam) bitmapFactoryParam;
        HashMap<Integer, BitmapFactory.Options> hashMap = decodeResourceParam.mParams;
        if (CollectionUtils.isEmpty(hashMap)) {
            L.e(TAG, "doFetchDecodeTextures ids is null!");
            return;
        }
        for (Map.Entry<Integer, BitmapFactory.Options> entry : hashMap.entrySet()) {
            Integer num = decodeResourceParam.mTextureResIdMap.get(entry.getKey());
            if (num == null) {
                L.e(TAG, "doFetchDecodeTextures resIdObject is null! key:" + entry.getKey());
            } else {
                int intValue = num.intValue();
                if (intValue <= 0) {
                    L.e(TAG, "doFetchDecodeTextures resId <=0! key:" + entry.getKey());
                } else {
                    if (decodeResourceParam.mIsUseDrawable) {
                        Drawable drawable = decodeResourceParam.mRes.getDrawable(intValue, null);
                        if (drawable != null && (drawable instanceof VectorDrawable)) {
                            if (Build.VERSION.SDK_INT < 21) {
                                drawable = DrawableCompat.wrap(drawable).mutate();
                            }
                            decodeResource = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(decodeResource);
                            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            drawable.draw(canvas);
                        } else {
                            decodeResource = BitmapFactory.decodeResource(decodeResourceParam.mRes, intValue, entry.getValue());
                        }
                    } else {
                        decodeResource = BitmapFactory.decodeResource(decodeResourceParam.mRes, intValue, entry.getValue());
                    }
                    if (decodeResourceParam.mTextOption == null || decodeResource == null || decodeResource.isRecycled()) {
                        bitmap = decodeResource;
                    } else {
                        Bitmap.Config config = decodeResource.getConfig();
                        if (config == null) {
                            config = Bitmap.Config.ARGB_8888;
                        }
                        bitmap = decodeResource.copy(config, true);
                        decodeResource.recycle();
                        Paint paint = new Paint((decodeResourceParam.mTextOption.mTextIsBold ? 32 : 0) | 1);
                        paint.setColor(decodeResourceParam.mTextOption.mTextColor);
                        paint.setTextSize(decodeResourceParam.mTextOption.mTextSize);
                        paint.getTextBounds(decodeResourceParam.mTextOption.mTextName, 0, decodeResourceParam.mTextOption.mTextName.length(), new Rect());
                        paint.setDither(true);
                        paint.setFilterBitmap(true);
                        new Canvas(bitmap).drawText(decodeResourceParam.mTextOption.mTextName, ((bitmap.getWidth() - rect.width()) / 2) + decodeResourceParam.mTextOption.mTextOffsetX, ((bitmap.getHeight() + rect.height()) / 2) + decodeResourceParam.mTextOption.mTextOffsetY, paint);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        String str = "doFetchDecodeTextures bitmap error " + entry.getKey();
                        L.w(TAG, str);
                        observableEmitter.onError(new Throwable(str));
                    }
                    if (decodeResourceParam.mIsNeedScale && bitmap != null && !bitmap.isRecycled()) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * decodeResourceParam.mScalePercent) / 100, (bitmap.getHeight() * decodeResourceParam.mScalePercent) / 100, true);
                        bitmap.recycle();
                        BitmapFactoryResult bitmapFactoryResult = new BitmapFactoryResult(intValue, createScaledBitmap);
                        bitmapFactoryResult.mTextureId = entry.getKey().intValue();
                        observableEmitter.onNext(bitmapFactoryResult);
                    } else {
                        BitmapFactoryResult bitmapFactoryResult2 = new BitmapFactoryResult(intValue, bitmap);
                        bitmapFactoryResult2.mTextureId = entry.getKey().intValue();
                        observableEmitter.onNext(bitmapFactoryResult2);
                    }
                }
            }
        }
    }

    private static void doFetchCreateScaleBitmap(@NonNull BitmapFactoryParam bitmapFactoryParam, ObservableEmitter<BitmapFactoryResult> observableEmitter) {
        if (!(bitmapFactoryParam instanceof BitmapCreateParam)) {
            throw new IllegalArgumentException();
        }
        BitmapCreateParam bitmapCreateParam = (BitmapCreateParam) bitmapFactoryParam;
        Bitmap bitmap = null;
        if (bitmapCreateParam.mSourceBitmap != null && !bitmapCreateParam.mSourceBitmap.isRecycled()) {
            bitmap = Bitmap.createScaledBitmap(bitmapCreateParam.mSourceBitmap, bitmapCreateParam.mDstWidth, bitmapCreateParam.mDstHeight, bitmapCreateParam.mFilter);
        }
        if (bitmap == null || bitmap.isRecycled()) {
            L.w(TAG, "doFetchCreateScaleBitmap bitmap error");
            observableEmitter.onError(new Throwable("doFetchCreateScaleBitmap bitmap error"));
        }
        observableEmitter.onNext(new BitmapFactoryResult(0, bitmap));
    }

    private static void doFetchCreateBitmapByView(@NonNull BitmapFactoryParam bitmapFactoryParam, ObservableEmitter<BitmapFactoryResult> observableEmitter) {
        if (!(bitmapFactoryParam instanceof BitmapCreateByViewParam)) {
            throw new IllegalArgumentException();
        }
        BitmapCreateByViewParam bitmapCreateByViewParam = (BitmapCreateByViewParam) bitmapFactoryParam;
        if (bitmapCreateByViewParam.mView == null) {
            return;
        }
        bitmapCreateByViewParam.mView.setDrawingCacheEnabled(true);
        bitmapCreateByViewParam.mView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        bitmapCreateByViewParam.mView.layout(0, 0, bitmapCreateByViewParam.mView.getMeasuredWidth(), bitmapCreateByViewParam.mView.getMeasuredHeight());
        Bitmap bitmap = null;
        try {
            try {
                bitmap = Bitmap.createBitmap(bitmapCreateByViewParam.mView.getDrawingCache(true));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bitmap == null || bitmap.isRecycled()) {
                L.w(TAG, "doFetchCreateBitmapByView bitmap error");
                observableEmitter.onError(new Throwable("doFetchCreateBitmapByView bitmap error"));
            }
            if (bitmap != null && bitmapCreateByViewParam.mIsNeedScale && !bitmap.isRecycled()) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * bitmapCreateByViewParam.mScalePercent) / 100, (bitmap.getHeight() * bitmapCreateByViewParam.mScalePercent) / 100, true);
                bitmap.recycle();
                observableEmitter.onNext(new BitmapFactoryResult(0, createScaledBitmap));
                return;
            }
            observableEmitter.onNext(new BitmapFactoryResult(0, bitmap));
        } finally {
            bitmapCreateByViewParam.mView.destroyDrawingCache();
        }
    }
}
