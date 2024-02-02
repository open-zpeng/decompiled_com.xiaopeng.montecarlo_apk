package com.autonavi.gbl.map.adapter;

import android.graphics.Bitmap;
import com.autonavi.gbl.map.model.ScreenShotDataInfo;
import com.autonavi.gbl.map.observer.IEGLScreenshotObserver;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EGLScreenshotObserver implements IEGLScreenshotObserver {
    private static int ESCREEN_SHOT_CALLBACK_BITMAP = 1;
    private static int ESCREEN_SHOT_CALLBACK_BUFFER = 0;
    private static int ESCREEN_SHOT_CALLBACK_FILE = 2;
    private static int MAP_COLOR_FORMAT_RGBA_8888 = 1;
    private static int MAP_COLOR_FORMAT_RGB_565;
    private ArrayList<Bitmap> mScreenShotBitmaps = new ArrayList<>();

    private static Bitmap.Config getBitmapConfig(int i) {
        if (i == MAP_COLOR_FORMAT_RGB_565) {
            return Bitmap.Config.RGB_565;
        }
        return Bitmap.Config.ARGB_8888;
    }

    private Bitmap selectBitmap(int i, int i2, Bitmap.Config config) {
        int size = this.mScreenShotBitmaps.size();
        for (int i3 = 0; i3 < size; i3++) {
            Bitmap bitmap = this.mScreenShotBitmaps.get(i3);
            if (!bitmap.isRecycled() && bitmap.getWidth() == i && bitmap.getHeight() == i2 && bitmap.getConfig() == config) {
                return bitmap;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        this.mScreenShotBitmaps.add(0, createBitmap);
        return createBitmap;
    }

    @Override // com.autonavi.gbl.map.observer.IEGLScreenshotObserver
    public void onEGLScreenshot(int i, byte[] bArr, ScreenShotDataInfo screenShotDataInfo, int i2, long j) {
        Bitmap.Config bitmapConfig = getBitmapConfig(screenShotDataInfo.format);
        int i3 = screenShotDataInfo.pixelByte;
        selectBitmap(screenShotDataInfo.width, screenShotDataInfo.height, bitmapConfig).copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        if (i2 == ESCREEN_SHOT_CALLBACK_BUFFER) {
            return;
        }
        int i4 = ESCREEN_SHOT_CALLBACK_BITMAP;
    }
}
