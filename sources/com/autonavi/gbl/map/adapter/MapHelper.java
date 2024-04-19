package com.autonavi.gbl.map.adapter;

import android.content.res.AssetManager;
import android.view.MotionEvent;
import com.autonavi.gbl.map.model.TouchEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
        /* JADX WARN: Removed duplicated region for block: B:61:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public byte[] requireResource(android.content.Context r9, com.autonavi.gbl.map.model.MapResourceParam r10) {
            /*
                r8 = this;
                int r0 = r10.type
                r1 = 0
                if (r0 == 0) goto L6
                return r1
            L6:
                android.content.res.AssetManager r3 = r9.getAssets()
                java.lang.String r9 = r10.name     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                if (r9 == 0) goto L54
                java.lang.String r9 = r10.name     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                int r9 = r9.length()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                if (r9 != 0) goto L17
                goto L54
            L17:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r9.<init>()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r0 = "blRes/MapAsset/"
                r9.append(r0)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r10 = r10.name     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r9.append(r10)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.io.InputStream r9 = r3.open(r9)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                int r10 = r9.available()     // Catch: java.lang.OutOfMemoryError -> L52 java.lang.Throwable -> Lc3 java.io.IOException -> Lcc
                if (r10 != 0) goto L3a
                if (r9 == 0) goto L39
                r9.close()     // Catch: java.io.IOException -> L39
            L39:
                return r1
            L3a:
                int r0 = r10 + 1
                byte[] r0 = new byte[r0]     // Catch: java.lang.OutOfMemoryError -> L52 java.lang.Throwable -> Lc3 java.io.IOException -> Lcc
                r2 = 0
                r3 = r2
            L40:
                if (r3 >= r10) goto L4a
                int r4 = r10 - r3
                int r4 = r9.read(r0, r3, r4)     // Catch: java.lang.OutOfMemoryError -> L52 java.lang.Throwable -> Lc3 java.io.IOException -> Lcc
                int r3 = r3 + r4
                goto L40
            L4a:
                r0[r10] = r2     // Catch: java.lang.OutOfMemoryError -> L52 java.lang.Throwable -> Lc3 java.io.IOException -> Lcc
                if (r9 == 0) goto L51
                r9.close()     // Catch: java.io.IOException -> L51
            L51:
                return r0
            L52:
                r10 = move-exception
                goto Lba
            L54:
                r8.rlock()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r9.<init>()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r10 = r8.strRelativePathCache     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r9.append(r10)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r8.runlock()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r10 = r8.strRelativePathCache     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r0 = ""
                boolean r10 = r10.equals(r0)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                if (r10 == 0) goto Lab
                java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r6.<init>()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r10.<init>()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r4 = "blRes/MapAsset"
                java.lang.String r5 = ""
                r2 = r8
                r7 = r10
                r2.getAssetFilePathList(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
            L85:
                boolean r0 = r10.hasNext()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                if (r0 == 0) goto L9a
                java.lang.Object r0 = r10.next()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r9.append(r0)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r0 = "\r\n"
                r9.append(r0)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                goto L85
            L9a:
                java.lang.String r10 = "\u0000"
                r9.append(r10)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r8.wlock()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r10 = r9.toString()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r8.strRelativePathCache = r10     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                r8.wunlock()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
            Lab:
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                java.lang.String r10 = "UTF-8"
                byte[] r9 = r9.getBytes(r10)     // Catch: java.lang.Throwable -> Lb6 java.lang.OutOfMemoryError -> Lb8 java.io.IOException -> Lcb
                return r9
            Lb6:
                r10 = move-exception
                goto Lc5
            Lb8:
                r10 = move-exception
                r9 = r1
            Lba:
                r10.printStackTrace()     // Catch: java.lang.Throwable -> Lc3
                if (r9 == 0) goto Lc2
                r9.close()     // Catch: java.io.IOException -> Lc2
            Lc2:
                return r1
            Lc3:
                r10 = move-exception
                r1 = r9
            Lc5:
                if (r1 == 0) goto Lca
                r1.close()     // Catch: java.io.IOException -> Lca
            Lca:
                throw r10
            Lcb:
                r9 = r1
            Lcc:
                if (r9 == 0) goto Ld1
                r9.close()     // Catch: java.io.IOException -> Ld1
            Ld1:
                return r1
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

    /* loaded from: classes2.dex */
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
