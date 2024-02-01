package com.xiaopeng.montecarlo.service.minimap;

import android.content.Context;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.view.Surface;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes3.dex */
public class LocalMiniMapSurface {
    private static final L.Tag TAG = new L.Tag("LocalMiniMapSurface");
    private final Callback mCallback;
    private ImageReader mImageReader;
    private int mImageReaderHeight;
    private int mImageReaderWidth;
    private Surface mMiniMapSurface;
    private ImageReader.OnImageAvailableListener mOnImageAvailableListener = new ImageReader.OnImageAvailableListener() { // from class: com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface.1
        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image image = null;
            try {
                try {
                    image = imageReader.acquireNextImage();
                    if (image == null) {
                        L.i(LocalMiniMapSurface.TAG, "onImageAvailable update but acquireNextImage was null");
                    } else {
                        Image.Plane[] planes = image.getPlanes();
                        if (planes.length > 0) {
                            int width = image.getWidth();
                            int height = image.getHeight();
                            int pixelStride = planes[0].getPixelStride();
                            LocalMiniMapSurface.this.mCallback.onFrameUpdate(planes[0], width + ((planes[0].getRowStride() - (pixelStride * width)) / pixelStride), height);
                        }
                    }
                    if (image == null) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    L.i(LocalMiniMapSurface.TAG, "onImageAvailable update but has Exception ");
                    LocalMiniMapSurface.this.mCallback.onImageReaderError();
                    if (0 == 0) {
                        return;
                    }
                }
                image.close();
            } catch (Throwable th) {
                if (0 != 0) {
                    image.close();
                }
                throw th;
            }
        }
    };
    private final Handler mHandler = new Handler(WorkThreadUtil.getInstance().getMiniMapThreadLooper());

    /* loaded from: classes3.dex */
    interface Callback {
        void onFrameUpdate(Image.Plane plane, int i, int i2);

        void onImageReaderError();

        void onReaderCreated(Surface surface, int i, int i2);

        void onReaderDestroy(Surface surface, int i, int i2);

        void onReaderSizeChanged(Surface surface, int i, int i2);
    }

    public LocalMiniMapSurface(Context context, Callback callback) {
        this.mCallback = callback;
    }

    public void initCodec(int i, int i2) {
        this.mImageReaderWidth = i;
        this.mImageReaderHeight = i2;
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface.2
            @Override // java.lang.Runnable
            public void run() {
                L.Tag tag = LocalMiniMapSurface.TAG;
                L.i(tag, "=====initCodec ImageReader.newInstance width:" + LocalMiniMapSurface.this.mImageReaderWidth + " height:" + LocalMiniMapSurface.this.mImageReaderHeight);
                LocalMiniMapSurface localMiniMapSurface = LocalMiniMapSurface.this;
                localMiniMapSurface.mImageReader = ImageReader.newInstance(localMiniMapSurface.mImageReaderWidth, LocalMiniMapSurface.this.mImageReaderHeight, 2, 2);
                LocalMiniMapSurface.this.mImageReader.setOnImageAvailableListener(LocalMiniMapSurface.this.mOnImageAvailableListener, LocalMiniMapSurface.this.mHandler);
                LocalMiniMapSurface localMiniMapSurface2 = LocalMiniMapSurface.this;
                localMiniMapSurface2.mMiniMapSurface = localMiniMapSurface2.mImageReader.getSurface();
                LocalMiniMapSurface.this.mCallback.onReaderCreated(LocalMiniMapSurface.this.mMiniMapSurface, LocalMiniMapSurface.this.mImageReaderWidth, LocalMiniMapSurface.this.mImageReaderHeight);
            }
        });
    }

    public void updateSize(int i, int i2) {
        this.mImageReaderWidth = i;
        this.mImageReaderHeight = i2;
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface.3
            @Override // java.lang.Runnable
            public void run() {
                ImageReader imageReader = LocalMiniMapSurface.this.mImageReader;
                Surface surface = LocalMiniMapSurface.this.mMiniMapSurface;
                L.Tag tag = LocalMiniMapSurface.TAG;
                L.i(tag, "=====updateSize ImageReader.newInstance width:" + LocalMiniMapSurface.this.mImageReaderWidth + " height:" + LocalMiniMapSurface.this.mImageReaderHeight);
                LocalMiniMapSurface localMiniMapSurface = LocalMiniMapSurface.this;
                localMiniMapSurface.mImageReader = ImageReader.newInstance(localMiniMapSurface.mImageReaderWidth, LocalMiniMapSurface.this.mImageReaderHeight, 2, 2);
                LocalMiniMapSurface.this.mImageReader.setOnImageAvailableListener(LocalMiniMapSurface.this.mOnImageAvailableListener, LocalMiniMapSurface.this.mHandler);
                LocalMiniMapSurface localMiniMapSurface2 = LocalMiniMapSurface.this;
                localMiniMapSurface2.mMiniMapSurface = localMiniMapSurface2.mImageReader.getSurface();
                LocalMiniMapSurface.this.mCallback.onReaderSizeChanged(LocalMiniMapSurface.this.mMiniMapSurface, LocalMiniMapSurface.this.mImageReaderWidth, LocalMiniMapSurface.this.mImageReaderHeight);
                if (surface != null) {
                    surface.release();
                }
                if (imageReader != null) {
                    imageReader.close();
                }
            }
        });
    }

    public void release() {
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface.4
            @Override // java.lang.Runnable
            public void run() {
                LocalMiniMapSurface.this.mCallback.onReaderDestroy(LocalMiniMapSurface.this.mMiniMapSurface, LocalMiniMapSurface.this.mImageReaderWidth, LocalMiniMapSurface.this.mImageReaderHeight);
                if (LocalMiniMapSurface.this.mMiniMapSurface != null) {
                    LocalMiniMapSurface.this.mMiniMapSurface.release();
                }
                if (LocalMiniMapSurface.this.mImageReader != null) {
                    LocalMiniMapSurface.this.mImageReader.close();
                    LocalMiniMapSurface.this.mImageReader = null;
                }
            }
        });
    }
}
