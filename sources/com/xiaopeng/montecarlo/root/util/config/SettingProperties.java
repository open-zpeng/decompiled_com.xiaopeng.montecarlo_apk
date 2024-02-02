package com.xiaopeng.montecarlo.root.util.config;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes2.dex */
public class SettingProperties extends Properties {
    public static final String PATH_MAP_CONFIG_ASSETS = "carmapconfig.properties";
    public static final String PATH_MAP_CONFIG_ETC = "/system/etc/carmapconfig.properties";
    public static final String PATH_MAP_CONFIG_VENDOR = "/system/vendor/etc/carmapconfig.properties";
    private static volatile SettingProperties sInstance = null;
    private static final long serialVersionUID = -4800785546075953211L;

    public static void initSettingProperties(Context context) {
        try {
            build(context, PATH_MAP_CONFIG_ASSETS, PATH_MAP_CONFIG_VENDOR, PATH_MAP_CONFIG_ETC);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SettingProperties build(Context context, String str, String... strArr) throws IOException {
        if (sInstance == null) {
            synchronized (SettingProperties.class) {
                if (sInstance == null) {
                    sInstance = new SettingProperties();
                    String str2 = null;
                    if (strArr != null) {
                        int length = strArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            String str3 = strArr[i];
                            if (new File(str3).exists()) {
                                str2 = str3;
                                break;
                            }
                            i++;
                        }
                    }
                    sInstance.load(context, str, str2);
                }
            }
        }
        return sInstance;
    }

    public static SettingProperties getInstance() {
        SettingProperties settingProperties = sInstance;
        if (settingProperties != null) {
            return settingProperties;
        }
        throw new RuntimeException("SettingProperties has not be initialized.");
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public void load(Context context, String str, String str2) throws IOException {
        if (context != null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open(str));
            try {
                load(bufferedInputStream);
            } finally {
                closeQuietly(bufferedInputStream);
            }
        }
        if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            return;
        }
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(str2);
            try {
                load(fileReader2);
                closeQuietly(fileReader2);
            } catch (Throwable th) {
                th = th;
                fileReader = fileReader2;
                closeQuietly(fileReader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String get(String str, String str2) {
        return getProperty(str, str2);
    }

    public boolean getBoolean(String str, boolean z) {
        String property = getProperty(str, "");
        return TextUtils.isEmpty(property) ? z : "true".equals(property);
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public int getInt(String str, int i) {
        String property = getProperty(str, "");
        return TextUtils.isEmpty(property) ? i : Integer.parseInt(property);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public float getFloat(String str, float f) {
        String property = getProperty(str, "");
        return TextUtils.isEmpty(property) ? f : Float.parseFloat(property);
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }
}
