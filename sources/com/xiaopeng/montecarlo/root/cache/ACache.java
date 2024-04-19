package com.xiaopeng.montecarlo.root.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import com.xiaopeng.montecarlo.root.cache.ACache;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ACache {
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private ACacheManager mCache;
    private static final L.Tag TAG = new L.Tag("ACache");
    private static Map<String, ACache> sInstanceMap = new HashMap();
    private static ACache sACache = null;

    public static synchronized ACache getInstance() {
        ACache aCache;
        synchronized (ACache.class) {
            if (sACache == null) {
                sACache = get(ContextUtils.getContext());
            }
            aCache = sACache;
        }
        return aCache;
    }

    private static ACache get(Context context) {
        return get(context, "ACache");
    }

    private static ACache get(Context context, String str) {
        return get(new File(context.getCacheDir(), str), 50000000L, Integer.MAX_VALUE);
    }

    private static ACache get(File file) {
        return get(file, 50000000L, Integer.MAX_VALUE);
    }

    private static ACache get(Context context, long j, int i) {
        return get(new File(context.getCacheDir(), "ACache"), j, i);
    }

    private static ACache get(File file, long j, int i) {
        Map<String, ACache> map = sInstanceMap;
        ACache aCache = map.get(file.getAbsoluteFile() + myPid());
        if (aCache == null) {
            ACache aCache2 = new ACache(file, j, i);
            Map<String, ACache> map2 = sInstanceMap;
            map2.put(file.getAbsolutePath() + myPid(), aCache2);
            return aCache2;
        }
        return aCache;
    }

    private static String myPid() {
        return DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + Process.myPid();
    }

    private ACache(File file, long j, int i) {
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("can't make dirs in " + file.getAbsolutePath());
        }
        this.mCache = new ACacheManager(file, j, i);
    }

    public void put(String str, String str2) {
        File newFile = this.mCache.newFile(str);
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile), 1024);
                try {
                    bufferedWriter.write(str2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (th != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        } else {
                            bufferedWriter.close();
                        }
                        throw th2;
                    }
                }
            } finally {
                this.mCache.put(newFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void put(String str, String str2, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "put key:" + str + ",saveTime:" + i);
        }
        put(str, Utils.newStringWithDateInfo(i, str2));
    }

    public String getAsString(String str) {
        File file = this.mCache.get(str);
        if (file.exists()) {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String str2 = "";
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str2 = str2 + readLine;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                if (th != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                } else {
                                    bufferedReader.close();
                                }
                                throw th2;
                            }
                        }
                    }
                    if (Utils.isDue(str2)) {
                        bufferedReader.close();
                        remove(str);
                        return null;
                    }
                    String clearDateInfo = Utils.clearDateInfo(str2);
                    bufferedReader.close();
                    return clearDateInfo;
                } catch (IOException e) {
                    e.printStackTrace();
                    if (0 != 0) {
                        remove(str);
                    }
                    return null;
                }
            } catch (Throwable th4) {
                if (0 != 0) {
                    remove(str);
                }
                throw th4;
            }
        }
        return null;
    }

    public void put(String str, JSONObject jSONObject) {
        put(str, jSONObject.toString());
    }

    public void put(String str, JSONObject jSONObject, int i) {
        put(str, jSONObject.toString(), i);
    }

    public JSONObject getAsJSONObject(String str) {
        try {
            return new JSONObject(getAsString(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void put(String str, JSONArray jSONArray) {
        put(str, jSONArray.toString());
    }

    public void put(String str, JSONArray jSONArray, int i) {
        put(str, jSONArray.toString(), i);
    }

    public JSONArray getAsJSONArray(String str) {
        try {
            return new JSONArray(getAsString(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void put(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File newFile = this.mCache.newFile(str);
        try {
            try {
                fileOutputStream = new FileOutputStream(newFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (th != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    } else {
                        fileOutputStream.close();
                    }
                    throw th2;
                }
            }
        } finally {
            this.mCache.put(newFile);
        }
    }

    public void put(String str, byte[] bArr, int i) {
        put(str, Utils.newByteArrayWithDateInfo(i, bArr));
    }

    public byte[] getAsBinary(String str) {
        File file = this.mCache.get(str);
        if (file.exists()) {
            try {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        byte[] bArr = new byte[(int) randomAccessFile.length()];
                        randomAccessFile.read(bArr);
                        if (Utils.isDue(bArr)) {
                            randomAccessFile.close();
                            remove(str);
                            return null;
                        }
                        byte[] clearDateInfo = Utils.clearDateInfo(bArr);
                        randomAccessFile.close();
                        return clearDateInfo;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (th != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            } else {
                                randomAccessFile.close();
                            }
                            throw th2;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (0 != 0) {
                        remove(str);
                    }
                    return null;
                }
            } catch (Throwable th4) {
                if (0 != 0) {
                    remove(str);
                }
                throw th4;
            }
        }
        return null;
    }

    public void put(String str, Serializable serializable) {
        put(str, serializable, -1);
    }

    public void put(String str, Serializable serializable, int i) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(serializable);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (i != -1) {
                    put(str, byteArray, i);
                } else {
                    put(str, byteArray);
                }
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (th != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    } else {
                        objectOutputStream.close();
                    }
                    throw th2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public java.lang.Object getAsObject(java.lang.String r6) {
        /*
            r5 = this;
            byte[] r6 = r5.getAsBinary(r6)
            r0 = 0
            if (r6 == 0) goto L50
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L4c
            r1.<init>(r6)     // Catch: java.lang.Exception -> L4c
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L37
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L37
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.Throwable -> L1f
            r6.close()     // Catch: java.lang.Throwable -> L37
            r1.close()     // Catch: java.lang.Exception -> L4c
            return r2
        L1c:
            r2 = move-exception
            r3 = r0
            goto L25
        L1f:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> L21
        L21:
            r3 = move-exception
            r4 = r3
            r3 = r2
            r2 = r4
        L25:
            if (r3 == 0) goto L30
            r6.close()     // Catch: java.lang.Throwable -> L2b
            goto L33
        L2b:
            r6 = move-exception
            r3.addSuppressed(r6)     // Catch: java.lang.Throwable -> L37
            goto L33
        L30:
            r6.close()     // Catch: java.lang.Throwable -> L37
        L33:
            throw r2     // Catch: java.lang.Throwable -> L37
        L34:
            r6 = move-exception
            r2 = r0
            goto L3d
        L37:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L39
        L39:
            r2 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
        L3d:
            if (r2 == 0) goto L48
            r1.close()     // Catch: java.lang.Throwable -> L43
            goto L4b
        L43:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch: java.lang.Exception -> L4c
            goto L4b
        L48:
            r1.close()     // Catch: java.lang.Exception -> L4c
        L4b:
            throw r6     // Catch: java.lang.Exception -> L4c
        L4c:
            r6 = move-exception
            r6.printStackTrace()
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.cache.ACache.getAsObject(java.lang.String):java.lang.Object");
    }

    public void put(String str, Bitmap bitmap) {
        put(str, Utils.bitmap2Bytes(bitmap));
    }

    public void put(String str, Bitmap bitmap, int i) {
        byte[] bitmap2Bytes = Utils.bitmap2Bytes(bitmap);
        if (bitmap2Bytes != null) {
            put(str, bitmap2Bytes, i);
        }
    }

    public Bitmap getAsBitmap(String str) {
        if (getAsBinary(str) == null) {
            return null;
        }
        return Utils.bytes2Bimap(getAsBinary(str));
    }

    public void put(String str, Drawable drawable) {
        put(str, Utils.drawable2Bitmap(drawable));
    }

    public void put(String str, Drawable drawable, int i) {
        put(str, Utils.drawable2Bitmap(drawable), i);
    }

    public Drawable getAsDrawable(String str) {
        if (getAsBinary(str) == null) {
            return null;
        }
        return Utils.bitmap2Drawable(Utils.bytes2Bimap(getAsBinary(str)));
    }

    public File file(String str) {
        File newFile = this.mCache.newFile(str);
        if (newFile.exists()) {
            return newFile;
        }
        return null;
    }

    public boolean remove(String str) {
        return this.mCache.remove(str);
    }

    public void clear() {
        this.mCache.clear();
    }

    /* loaded from: classes3.dex */
    public class ACacheManager {
        private final AtomicInteger mCacheCount;
        protected File mCacheDir;
        private final AtomicLong mCacheSize;
        private final int mCountLimit;
        private final Map<File, Long> mLastUsageDates;
        private final long mSizeLimit;

        private ACacheManager(File file, long j, int i) {
            this.mLastUsageDates = Collections.synchronizedMap(new HashMap());
            this.mCacheDir = file;
            this.mSizeLimit = j;
            this.mCountLimit = i;
            this.mCacheSize = new AtomicLong();
            this.mCacheCount = new AtomicInteger();
            calculateCacheSizeAndCacheCount();
        }

        private void calculateCacheSizeAndCacheCount() {
            new Thread(new Runnable() { // from class: com.xiaopeng.montecarlo.root.cache.-$$Lambda$ACache$ACacheManager$YdJK_XaY4hMdtjljGHz6b4mVAzc
                @Override // java.lang.Runnable
                public final void run() {
                    ACache.ACacheManager.this.lambda$calculateCacheSizeAndCacheCount$0$ACache$ACacheManager();
                }
            }).start();
        }

        public /* synthetic */ void lambda$calculateCacheSizeAndCacheCount$0$ACache$ACacheManager() {
            File[] listFiles = this.mCacheDir.listFiles();
            if (listFiles != null) {
                int i = 0;
                int i2 = 0;
                for (File file : listFiles) {
                    i = (int) (i + calculateSize(file));
                    i2++;
                    this.mLastUsageDates.put(file, Long.valueOf(file.lastModified()));
                }
                this.mCacheSize.set(i);
                this.mCacheCount.set(i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void put(File file) {
            int i = this.mCacheCount.get();
            while (i + 1 > this.mCountLimit) {
                this.mCacheSize.addAndGet(-removeNext());
                i = this.mCacheCount.addAndGet(-1);
            }
            this.mCacheCount.addAndGet(1);
            long calculateSize = calculateSize(file);
            long j = this.mCacheSize.get();
            while (j + calculateSize > this.mSizeLimit) {
                j = this.mCacheSize.addAndGet(-removeNext());
            }
            this.mCacheSize.addAndGet(calculateSize);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.mLastUsageDates.put(file, valueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File get(String str) {
            File newFile = newFile(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            newFile.setLastModified(valueOf.longValue());
            this.mLastUsageDates.put(newFile, valueOf);
            return newFile;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File newFile(String str) {
            File file = this.mCacheDir;
            return new File(file, str.hashCode() + "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean remove(String str) {
            return get(str).delete();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.mLastUsageDates.clear();
            this.mCacheSize.set(0L);
            File[] listFiles = this.mCacheDir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
        }

        private long removeNext() {
            File file;
            if (this.mLastUsageDates.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> entrySet = this.mLastUsageDates.entrySet();
            synchronized (this.mLastUsageDates) {
                file = null;
                Long l = null;
                for (Map.Entry<File, Long> entry : entrySet) {
                    if (file == null) {
                        file = entry.getKey();
                        l = entry.getValue();
                    } else {
                        Long value = entry.getValue();
                        if (value.longValue() < l.longValue()) {
                            file = entry.getKey();
                            l = value;
                        }
                    }
                }
            }
            if (file == null) {
                return 0L;
            }
            long calculateSize = calculateSize(file);
            if (file.delete()) {
                this.mLastUsageDates.remove(file);
            }
            return calculateSize;
        }

        private long calculateSize(File file) {
            return file.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Utils {
        private static final char sSeparator = ' ';

        private Utils() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isDue(String str) {
            return isDue(str.getBytes());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isDue(byte[] bArr) {
            String[] dateInfoFromDate = getDateInfoFromDate(bArr);
            if (dateInfoFromDate != null && dateInfoFromDate.length == 2) {
                String str = dateInfoFromDate[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(dateInfoFromDate[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String newStringWithDateInfo(int i, String str) {
            return createDateInfo(i) + str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] newByteArrayWithDateInfo(int i, byte[] bArr) {
            byte[] bytes = createDateInfo(i).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String clearDateInfo(String str) {
            return (str == null || !hasDateInfo(str.getBytes())) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] clearDateInfo(byte[] bArr) {
            return hasDateInfo(bArr) ? copyOfRange(bArr, indexOf(bArr, sSeparator) + 1, bArr.length) : bArr;
        }

        private static boolean hasDateInfo(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && indexOf(bArr, sSeparator) > 14;
        }

        private static String[] getDateInfoFromDate(byte[] bArr) {
            if (hasDateInfo(bArr)) {
                return new String[]{new String(copyOfRange(bArr, 0, 13)), new String(copyOfRange(bArr, 14, indexOf(bArr, sSeparator)))};
            }
            return null;
        }

        private static int indexOf(byte[] bArr, char c) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == c) {
                    return i;
                }
            }
            return -1;
        }

        private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException(i + " > " + i2);
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
            return bArr2;
        }

        private static String createDateInfo(int i) {
            String str = System.currentTimeMillis() + "";
            while (str.length() < 13) {
                str = "0" + str;
            }
            return str + "-" + i + sSeparator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] bitmap2Bytes(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Bitmap bytes2Bimap(byte[] bArr) {
            if (bArr.length == 0) {
                return null;
            }
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Bitmap drawable2Bitmap(Drawable drawable) {
            if (drawable == null) {
                return null;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Drawable bitmap2Drawable(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            return new BitmapDrawable(bitmap);
        }
    }
}
