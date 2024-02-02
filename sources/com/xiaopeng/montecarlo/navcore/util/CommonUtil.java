package com.xiaopeng.montecarlo.navcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.view.IWindowManager;
import android.widget.Toast;
import com.autonavi.gbl.map.layer.model.LayerPriorityType;
import com.autonavi.gbl.util.model.BinaryStream;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.configurationmodule.ConfigurationModuleManager;
import com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.MapSize;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CommonUtil {
    private static JSONObject sJsonBean;
    private static final L.Tag TAG = new L.Tag("CommonUtil");
    public static String sJsonStr = "";

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface JniCallMethod {
    }

    public static Resources getResources() {
        return ContextUtils.getContext().getResources();
    }

    public static MapSize calculateMapSize(boolean z) {
        int i;
        Rect xuiRectByType;
        int i2 = 0;
        try {
            xuiRectByType = IWindowManager.Stub.asInterface(ServiceManager.getService("window")).getXuiRectByType(5);
            L.i(TAG, "winRect bottom:" + xuiRectByType.bottom + "top:" + xuiRectByType.top + "left:" + xuiRectByType.left + "right:" + xuiRectByType.right);
            i = xuiRectByType.right - xuiRectByType.left;
        } catch (Exception e) {
            e = e;
            i = 0;
        }
        try {
            i2 = xuiRectByType.bottom - xuiRectByType.top;
        } catch (Exception e2) {
            e = e2;
            L.w(TAG, e.getMessage());
            if (!z) {
            }
            return new MapSize(i, i2);
        }
        if (!z && (i <= 0 || i2 <= 0)) {
            L.w(TAG, "pixel error use default value");
            return new MapSize(LayerPriorityType.LayerPriorityRoutePath, 956);
        }
        return new MapSize(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
    public static byte[] readAssetsFile(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ?? isEmpty = TextUtils.isEmpty(str);
        try {
            try {
                if (isEmpty != 0) {
                    return null;
                }
                try {
                    isEmpty = ContextUtils.getContext().getAssets().open(str);
                } catch (Exception e) {
                    e = e;
                    isEmpty = 0;
                    byteArrayOutputStream2 = null;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    isEmpty = 0;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    isEmpty = 0;
                    byteArrayOutputStream = null;
                }
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = isEmpty.read(bArr, 0, 1024);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        L.d(TAG, "readAssetsFile: " + str + ", len=" + byteArray.length);
                        if (isEmpty != 0) {
                            try {
                                isEmpty.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        return byteArray;
                    } catch (Exception e5) {
                        e = e5;
                        L.w(TAG, "readAssetsFile Exception: " + e.getMessage());
                        e.printStackTrace();
                        if (isEmpty != 0) {
                            try {
                                isEmpty.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        return null;
                    } catch (OutOfMemoryError e7) {
                        e = e7;
                        e.printStackTrace();
                        if (isEmpty != 0) {
                            try {
                                isEmpty.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        return null;
                    }
                } catch (Exception e9) {
                    e = e9;
                    byteArrayOutputStream2 = null;
                } catch (OutOfMemoryError e10) {
                    e = e10;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    if (isEmpty != 0) {
                        try {
                            isEmpty.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e13) {
                e13.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void copyAssetFile(String str, String str2) {
        String str3;
        FileOutputStream fileOutputStream;
        String byteArrayMD5;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File("/mnt/sdcard" + str2);
        FileOutputStream fileOutputStream2 = null;
        if (file.exists()) {
            str3 = IOUtils.getFileMD5(file.getAbsolutePath());
        } else {
            File file2 = new File("/mnt/sdcard" + str2.substring(0, str2.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR)));
            if (!file2.exists() || !file2.isDirectory()) {
                file2.mkdir();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            str3 = null;
        }
        byte[] decodeAssetResData = IOUtils.decodeAssetResData(ContextUtils.getContext(), str);
        if (decodeAssetResData != null) {
            if (str3 != null && (byteArrayMD5 = IOUtils.getByteArrayMD5(decodeAssetResData)) != null && !byteArrayMD5.equalsIgnoreCase(str3)) {
                file.delete();
            }
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                fileOutputStream.write(decodeAssetResData);
                IOUtils.closeQuietly(fileOutputStream);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                L.w(TAG, "copyAssetFile: " + str + " to " + str2 + " fail, " + e.getMessage());
                IOUtils.closeQuietly(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                IOUtils.closeQuietly(fileOutputStream2);
                throw th;
            }
        }
    }

    public static float getDensity() {
        return ContextUtils.getContext().getResources().getDisplayMetrics().density;
    }

    public static int getDensityDpi() {
        return ContextUtils.getContext().getResources().getDisplayMetrics().densityDpi;
    }

    public static void createSubDir(String str, String str2) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdir();
        }
        File file2 = new File(str + File.separator + str2);
        if (file2.exists() && file2.isDirectory()) {
            return;
        }
        file2.mkdir();
    }

    public static String getTime(long j) {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(j));
    }

    public static int randInt(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    public static String createAmap20Folder(String str) {
        String str2 = RootUtil.SD_CARD_NAVI_PATH + str;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static void initLayerStyle() {
        sJsonStr = getStyleJson(ContextUtils.getContext(), "style.json");
        try {
            if (sJsonBean == null) {
                sJsonBean = new JSONObject(sJsonStr);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String getStyleBeanJson(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            if (sJsonBean == null) {
                sJsonBean = new JSONObject(sJsonStr);
            }
            sb.append(sJsonBean.get(str).toString());
        } catch (JSONException e) {
            Toast.makeText(ContextUtils.getContext(), "解析出错", 0).show();
            e.printStackTrace();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getStyleBeanJsonWithKey: " + str + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + sb.toString());
        }
        return sb.toString();
    }

    public static String getStyleJson(Context context, String str) {
        if (TextUtils.isEmpty(sJsonStr)) {
            try {
                InputStream open = context.getResources().getAssets().open(str);
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                sJsonStr = new String(bArr, "UTF-8");
            } catch (Exception unused) {
            }
        }
        return sJsonStr;
    }

    public static boolean isInteger(String str) {
        return Pattern.compile("^[+-]?[0-9]+$").matcher(str).find();
    }

    public static byte[] getConfigBuffer(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        Throwable th2;
        InputStream inputStream;
        if (str == null) {
            return null;
        }
        String str2 = str + "/mapcache/vmap4res/mapprofile.data";
        File file = new File(str2);
        int i = 0;
        if (!file.exists()) {
            AssetManager assets = ContextUtils.getContext().getAssets();
            L.i(TAG, "GetConfigBuffer maprofile.data from blRes/MapAsset/mapprofile.data");
            try {
                inputStream = assets.open("blRes/MapAsset/mapprofile.data");
            } catch (IOException unused) {
                inputStream = null;
            } catch (OutOfMemoryError unused2) {
                inputStream = null;
            } catch (Throwable th3) {
                th2 = th3;
                inputStream = null;
            }
            try {
                int available = inputStream.available();
                if (available == 0) {
                    L.i(TAG, "GetConfigBuffer Error 0 ");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return null;
                }
                byte[] bArr = new byte[available];
                while (i < available) {
                    i += inputStream.read(bArr, i, available - i);
                }
                L.i(TAG, "GetConfigBuffer mapprofile.data cnt" + available);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                return bArr;
            } catch (IOException unused5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused6) {
                    }
                }
                return null;
            } catch (OutOfMemoryError unused7) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused8) {
                    }
                }
                return null;
            } catch (Throwable th4) {
                th2 = th4;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused9) {
                    }
                }
                throw th2;
            }
        }
        L.i(TAG, "GetConfigBuffer mapprofile.data from" + str2);
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException unused10) {
            fileInputStream = null;
        } catch (OutOfMemoryError unused11) {
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            int available2 = fileInputStream.available();
            if (available2 != 0) {
                byte[] bArr2 = new byte[available2];
                while (i < available2) {
                    i += fileInputStream.read(bArr2, i, available2 - i);
                }
                L.i(TAG, "GetConfigBuffer mapprofile.data cnt" + available2);
                try {
                    fileInputStream.close();
                } catch (Exception unused12) {
                }
                return bArr2;
            }
            try {
                fileInputStream.close();
            } catch (Exception unused13) {
            }
            return null;
        } catch (IOException unused14) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused15) {
                }
            }
            return null;
        } catch (OutOfMemoryError unused16) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused17) {
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused18) {
                }
            }
            throw th;
        }
    }

    public static BinaryStream bitmap2BinaryStream(Bitmap bitmap) {
        return new BinaryStream(RootUtil.bitmap2Byte(bitmap));
    }

    public static boolean isScratchSpotEnable() {
        boolean z = ContextUtils.getInt(R.integer.enable_scratch_spot) == 1;
        if (z) {
            Boolean bool = (Boolean) ConfigurationModuleManager.getInstance().getConfigurationFromDatabase(WebConfigurationEnum.SCRATCH_SPOT, Boolean.class);
            if (bool == null || bool.booleanValue()) {
                return z;
            }
            return false;
        }
        return false;
    }

    /* renamed from: com.xiaopeng.montecarlo.navcore.util.CommonUtil$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType = new int[XPNetworkManager.XPNetworkType.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_TBOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static int getBLNetworkStatus(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
        if (z) {
            int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[xPNetworkType.ordinal()];
            if (i == 1) {
                return 5;
            }
            if (i == 2) {
                return 2;
            }
            if (i != 3) {
                return 6;
            }
        }
        return 1;
    }
}
