package com.xiaopeng.montecarlo.scenes.debugscene;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.AsyncTask;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class ScreenShotHelper {
    private ImageReader mImageReader = ImageReader.newInstance(getScreenWidth(), getScreenHeight(), 1, 1);
    private MediaProjection mMediaProjection;
    private OnScreenShotListener mOnScreenShotListener;
    private VirtualDisplay mVirtualDisplay;
    private static final L.Tag TAG = new L.Tag("ScreenShotHelper");
    public static int REQUEST_MEDIA_PROJECTION = BLParams.PopOverlayRouteAddViaPoint;

    /* loaded from: classes2.dex */
    public interface OnScreenShotListener {
        void onFinish(Bitmap bitmap);
    }

    public ScreenShotHelper(int i, Intent intent, OnScreenShotListener onScreenShotListener) {
        this.mOnScreenShotListener = onScreenShotListener;
        this.mMediaProjection = getMediaProjectionManager().getMediaProjection(i, intent);
    }

    public void startScreenShot() {
        createVirtualDisplay();
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.ScreenShotHelper.1
            @Override // java.lang.Runnable
            public void run() {
                new CreateBitmapTask().execute(new Image[0]);
            }
        }, 1000L);
    }

    /* loaded from: classes2.dex */
    public class CreateBitmapTask extends AsyncTask<Image, Void, Bitmap> {
        public CreateBitmapTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Image... imageArr) {
            Image acquireLatestImage = ScreenShotHelper.this.mImageReader.acquireLatestImage();
            int width = acquireLatestImage.getWidth();
            int height = acquireLatestImage.getHeight();
            Image.Plane[] planes = acquireLatestImage.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            int pixelStride = planes[0].getPixelStride();
            Bitmap createBitmap = Bitmap.createBitmap(((planes[0].getRowStride() - (pixelStride * width)) / pixelStride) + width, height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(buffer);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, width, height);
            acquireLatestImage.close();
            return createBitmap2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((CreateBitmapTask) bitmap);
            ScreenShotHelper.this.mVirtualDisplay.release();
            ScreenShotHelper.this.mMediaProjection.stop();
            ScreenShotHelper.this.writeBitmapToFile(bitmap);
            if (ScreenShotHelper.this.mOnScreenShotListener != null) {
                ScreenShotHelper.this.mOnScreenShotListener.onFinish(bitmap);
            }
        }
    }

    private MediaProjectionManager getMediaProjectionManager() {
        return (MediaProjectionManager) ContextUtils.getContext().getSystemService("media_projection");
    }

    private void createVirtualDisplay() {
        this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("screen-mirror", getScreenWidth(), getScreenHeight(), Resources.getSystem().getDisplayMetrics().densityDpi, 16, this.mImageReader.getSurface(), null, null);
    }

    public static void tryToScreenShot(Activity activity) {
        if (activity == null) {
            return;
        }
        activity.startActivityForResult(((MediaProjectionManager) activity.getSystemService("media_projection")).createScreenCaptureIntent(), REQUEST_MEDIA_PROJECTION);
    }

    private int getScreenWidth() {
        return RootUtil.getScreenWidth();
    }

    private int getScreenHeight() {
        return RootUtil.getScreenHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeBitmapToFile(final Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.ScreenShotHelper.2
            @Override // java.lang.Runnable
            public void run() {
                L.Tag tag;
                StringBuilder sb;
                String capturePath = RootUtil.getCapturePath();
                if (!FileIOUtil.makeDirs(capturePath)) {
                    L.e(ScreenShotHelper.TAG, "create capture dir fail");
                    return;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
                String str = capturePath + File.separator + "full-" + simpleDateFormat.format(new Date()) + ".png";
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                            try {
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                                try {
                                    fileOutputStream2.flush();
                                    fileOutputStream2.close();
                                    return;
                                } catch (IOException e) {
                                    e = e;
                                    tag = ScreenShotHelper.TAG;
                                    sb = new StringBuilder();
                                    sb.append("inputStream close IOException:");
                                    sb.append(e.getMessage());
                                    L.e(tag, sb.toString());
                                    return;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException e3) {
                                        e = e3;
                                        tag = ScreenShotHelper.TAG;
                                        sb = new StringBuilder();
                                        sb.append("inputStream close IOException:");
                                        sb.append(e.getMessage());
                                        L.e(tag, sb.toString());
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                    } catch (IOException e4) {
                                        L.e(ScreenShotHelper.TAG, "inputStream close IOException:" + e4.getMessage());
                                    }
                                }
                                throw th;
                            }
                        }
                        L.e(ScreenShotHelper.TAG, "bitmap isRecycled cause write bitmap to file failed");
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            }
        });
    }
}
