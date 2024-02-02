package com.autonavi.gbl.map.adapter;

import android.content.res.AssetManager;
import android.view.MotionEvent;
import com.autonavi.gbl.map.model.TouchEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public class MapHelper {
    private static TextTextureHelper textTextureHelper = new TextTextureHelper();
    private static MapAssetHelper mapAssetHelper = new MapAssetHelper();
    private static MotionEventHelper motionEventHelper = new MotionEventHelper();

    public static TextTextureHelper getTextTextureHelper() {
        return textTextureHelper;
    }

    public static MapAssetHelper getMapAssetHelper() {
        return mapAssetHelper;
    }

    public static MotionEventHelper getMotionEventHelper() {
        return motionEventHelper;
    }

    /* loaded from: classes.dex */
    public static class TextTextureHelper {
        private TextTextureGenerator textTextureGenerator = new TextTextureGenerator();

        public byte[] getCharBitmap(int i, int i2) {
            return this.textTextureGenerator.getTextPixelBuffer(i, i2);
        }

        public byte[] getCharsWidths(int[] iArr, int i) {
            byte[] charsWidths = this.textTextureGenerator.getCharsWidths(iArr, i);
            int length = iArr.length;
            if (charsWidths == null) {
                charsWidths = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    charsWidths[i2] = 24;
                }
            }
            return charsWidths;
        }

        public byte[] getCharsWidths(short[] sArr, int i) {
            byte[] charsWidths = this.textTextureGenerator.getCharsWidths(sArr, i);
            int length = sArr.length;
            if (charsWidths == null) {
                charsWidths = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    charsWidths[i2] = 24;
                }
            }
            return charsWidths;
        }
    }

    /* loaded from: classes.dex */
    public static class MapAssetHelper {
        private String strRelativePathCache = "";
        private ReentrantReadWriteLock lockCache = new ReentrantReadWriteLock();

        private void wlock() {
            ReentrantReadWriteLock reentrantReadWriteLock = this.lockCache;
            if (reentrantReadWriteLock != null) {
                reentrantReadWriteLock.writeLock().lock();
            }
        }

        private void wunlock() {
            ReentrantReadWriteLock reentrantReadWriteLock = this.lockCache;
            if (reentrantReadWriteLock != null) {
                reentrantReadWriteLock.writeLock().unlock();
            }
        }

        private void rlock() {
            ReentrantReadWriteLock reentrantReadWriteLock = this.lockCache;
            if (reentrantReadWriteLock != null) {
                reentrantReadWriteLock.readLock().lock();
            }
        }

        private void runlock() {
            ReentrantReadWriteLock reentrantReadWriteLock = this.lockCache;
            if (reentrantReadWriteLock != null) {
                reentrantReadWriteLock.readLock().unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:71:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public byte[] requireResource(android.content.Context r10, com.autonavi.gbl.map.model.MapResourceParam r11) {
            /*
                Method dump skipped, instructions count: 277
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autonavi.gbl.map.adapter.MapHelper.MapAssetHelper.requireResource(android.content.Context, com.autonavi.gbl.map.model.MapResourceParam):byte[]");
        }

        private boolean getAssetFilePathList(AssetManager assetManager, String str, String str2, List<String> list, List<String> list2) {
            if (assetManager == null || list == null || list2 == null) {
                return false;
            }
            String str3 = File.separator;
            try {
                String[] list3 = assetManager.list(str);
                for (int i = 0; i < list3.length; i++) {
                    list.add((str.endsWith(str3) ? str : str + str3) + list3[i]);
                    list2.add(str2 + list3[i]);
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MotionEventHelper {
        public static final int ACTION_CANCEL = 3;
        public static final int ACTION_DOWN = 0;
        public static final int ACTION_HOVER_ENTER = 9;
        public static final int ACTION_HOVER_EXIT = 10;
        public static final int ACTION_HOVER_MOVE = 7;
        public static final int ACTION_MOVE = 2;
        public static final int ACTION_OUTSIDE = 4;
        public static final int ACTION_POINTER_DOWN = 5;
        public static final int ACTION_POINTER_UP = 6;
        public static final int ACTION_SCROLL = 8;
        public static final int ACTION_UP = 1;

        private int translateAction(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                case 9:
                    return 9;
                case 10:
                    return 10;
                default:
                    return 0;
            }
        }

        public TouchEvent translateMotionEvent(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return null;
            }
            TouchEvent touchEvent = new TouchEvent();
            touchEvent.action = translateAction(motionEvent.getAction() & 255);
            touchEvent.x = (int) motionEvent.getX();
            touchEvent.y = (int) motionEvent.getY();
            int pointerCount = motionEvent.getPointerCount();
            touchEvent.eventTime = System.nanoTime();
            touchEvent.pointCount = pointerCount;
            touchEvent.actionIndex = motionEvent.getActionIndex();
            touchEvent.pointerCoordinate = new float[20];
            touchEvent.pointPressure = new float[10];
            touchEvent.pointId = new int[10];
            for (int i = 0; i < 10; i++) {
                touchEvent.pointId[i] = i;
            }
            for (int i2 = 0; i2 < 20; i2++) {
                touchEvent.pointerCoordinate[i2] = 0.0f;
            }
            for (int i3 = 0; i3 < 10; i3++) {
                touchEvent.pointPressure[i3] = 1.0f;
            }
            for (int i4 = 0; i4 < pointerCount; i4++) {
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                motionEvent.getPointerCoords(i4, pointerCoords);
                int i5 = i4 * 2;
                touchEvent.pointerCoordinate[i5] = pointerCoords.x;
                touchEvent.pointerCoordinate[i5 + 1] = pointerCoords.y;
                touchEvent.pointPressure[i4] = pointerCoords.pressure;
                touchEvent.pointId[i4] = motionEvent.getPointerId(i4);
            }
            return touchEvent;
        }
    }
}
