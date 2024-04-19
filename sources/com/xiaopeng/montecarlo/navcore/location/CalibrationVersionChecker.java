package com.xiaopeng.montecarlo.navcore.location;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.io.File;
/* loaded from: classes3.dex */
public class CalibrationVersionChecker {
    public static final String NEED_CALIBRATION_VERSION = "V1.2.0.17";
    public static final String[] DEFAULT_CONFIG_FILE_LIST = {"EhpConfig.dat", "GRestConfig.ini", "GblConfig.json"};
    public static final String[] SD_CARD_FILE_LIST = {"font_cn.ttf", "style.json", "GNaviConfig.xml", "GLndsConfig.xml", "res/global.db"};
    public static final String[] SD_CARD_BL_FOLDER_LIST = {"res/guide", "res/route", "LaneResource", "LayerAsset", "offline_conf", "voice_conf", "theme_conf", "network_conf", "localization"};
    protected static final L.Tag TAG = new L.Tag("CalibrationVersionChecker");

    @Nullable
    private static String getVersion() {
        if (ContextUtils.getContext().getContentResolver() != null) {
            String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_NAVI_VERSION, "");
            if (TextUtils.isEmpty(string)) {
                String string2 = DataSetHelper.AccountSet.getString(DataSetHelper.GlobalSet.KEY_NAVI_VERSION, "");
                if (TextUtils.isEmpty(string2)) {
                    return string2;
                }
                DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVI_VERSION, string2);
                return string2;
            }
            return string;
        }
        return null;
    }

    private static void saveVersion() {
        L.i(TAG, "Save version");
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVI_VERSION, RootUtil.getVersionName());
    }

    private static void removeBlDataFile() {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        for (String str : DEFAULT_CONFIG_FILE_LIST) {
            File file = new File(RootUtil.SD_CARD_NAVI_PATH, str);
            if (file.exists()) {
                L.i(TAG, "remove " + str);
                file.delete();
            }
        }
        for (String str2 : SD_CARD_FILE_LIST) {
            File file2 = new File(RootUtil.SD_CARD_NAVI_PATH, str2);
            if (file2.exists()) {
                L.i(TAG, "remove " + str2);
                file2.delete();
            }
        }
        for (String str3 : SD_CARD_BL_FOLDER_LIST) {
            File file3 = new File(RootUtil.SD_CARD_NAVI_PATH, str3);
            if (file3.exists()) {
                L.i(TAG, "remove " + str3);
                FileUtil.deleteDir(file3);
            }
        }
    }

    public static void checkAndRemoveOldBlDataFile() {
        String versionCode = RootUtil.getVersionCode();
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_NAVI_VERSION_CODE, "");
        String fullSystemVersion = BuildInfoUtils.getFullSystemVersion();
        String string2 = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_LAST_SYS_VERSION, "");
        String versionName = RootUtil.getVersionName();
        String string3 = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_NAVI_VERSION, "");
        L.Tag tag = TAG;
        L.i(tag, "checkAndRemoveOldBlDataFile newVersionCode:" + versionCode + ", oldVersionCode:" + string + ", newSysVersion:" + fullSystemVersion + ", oldSysVersion:" + string2 + ", newVersionName:" + versionName + ", oldVersionName:" + string3);
        if (!string3.equalsIgnoreCase(versionName)) {
            removeBlDataFile();
        }
        if (copyBLFile()) {
            saveVersion();
        }
        if (fullSystemVersion.equalsIgnoreCase(string2)) {
            return;
        }
        if (removeMapFontCache()) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_LAST_SYS_VERSION, fullSystemVersion);
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVI_VERSION_CODE, versionCode);
            return;
        }
        L.w(TAG, "removeMapFontCache failed ");
    }

    private static boolean copyBLFile() {
        String bLLogRootPath = RootUtil.getBLLogRootPath();
        String str = RootUtil.SD_CARD_DIR_PC_CHECK;
        File file = new File(RootUtil.SD_CARD_NAVI_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(bLLogRootPath);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(str);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        File file4 = new File(RootUtil.SD_CARD_NAVI_PATH + "/res");
        if (!file4.exists()) {
            file4.mkdirs();
        }
        boolean z = true;
        for (int i = 0; i < SD_CARD_FILE_LIST.length; i++) {
            File file5 = new File(RootUtil.SD_CARD_NAVI_PATH, SD_CARD_FILE_LIST[i]);
            if (!file5.exists() || !file5.canRead() || 0 == file5.length()) {
                z &= FileUtil.copyAssets(file5, "blRes/" + SD_CARD_FILE_LIST[i]);
                L.i(TAG, "copyAssets blRes/" + SD_CARD_FILE_LIST[i]);
            }
        }
        String configFolder = CarFeatureManager.INSTANCE.getConfigFolder();
        L.i(TAG, "configFolder " + configFolder);
        if (configFolder != null) {
            boolean z2 = z;
            for (int i2 = 0; i2 < DEFAULT_CONFIG_FILE_LIST.length; i2++) {
                File file6 = new File(RootUtil.SD_CARD_NAVI_PATH, DEFAULT_CONFIG_FILE_LIST[i2]);
                if (!file6.exists() || !file6.canRead() || 0 == file6.length()) {
                    z2 &= FileUtil.copyAssets(file6, "blRes/" + configFolder + DEFAULT_CONFIG_FILE_LIST[i2]);
                    L.i(TAG, "copyAssets blRes/" + configFolder + DEFAULT_CONFIG_FILE_LIST[i2]);
                }
            }
            z = z2;
        }
        for (int i3 = 0; i3 < SD_CARD_BL_FOLDER_LIST.length; i3++) {
            File file7 = new File(RootUtil.SD_CARD_NAVI_PATH, SD_CARD_BL_FOLDER_LIST[i3]);
            if (!file7.exists() || !file7.canRead() || 0 == file7.length()) {
                boolean copyAssetsFolder = FileUtil.copyAssetsFolder("blRes/" + SD_CARD_BL_FOLDER_LIST[i3], file7.getAbsolutePath()) & z;
                L.i(TAG, "copyAssets blRes/" + SD_CARD_BL_FOLDER_LIST[i3]);
                z = copyAssetsFolder;
            }
        }
        File file8 = new File(RootUtil.SD_CARD_DIR_POS_520_CONTEXT);
        if (!file8.exists()) {
            boolean mkdir = file8.mkdir();
            L.i(TAG, "mkdir " + RootUtil.SD_CARD_DIR_POS_520_CONTEXT + "=" + mkdir);
        }
        NavCoreUtil.convertAmapPositionData();
        File file9 = new File(RootUtil.SD_CARD_NAVI_PATH, "style_bl.json");
        if (file9.exists()) {
            file9.delete();
        }
        boolean copyAssets = FileUtil.copyAssets(file9, "style_bl.json") & z;
        File file10 = new File(RootUtil.SD_CARD_NAVI_PATH, "style_camera.json");
        if (file10.exists()) {
            file10.delete();
        }
        return copyAssets & FileUtil.copyAssets(file10, "style_camera.json");
    }

    private static boolean removeMapFontCache() {
        String[] strArr;
        boolean z = true;
        for (String str : RootUtil.BL_MAP_FONT_CACHE) {
            File file = new File(RootUtil.SD_CARD_DIR_MAP_FONT_CACHE_PATH, str);
            if (!file.exists()) {
                L.i(TAG, "removeMapFontCache " + str + " but file no exist!");
            } else if (!file.delete()) {
                L.i(TAG, "removeMapFontCache " + str + " failed");
                z = false;
            } else {
                L.i(TAG, "removeMapFontCache " + str + " succeed, the file was exist now = ?" + file.exists());
            }
        }
        return z;
    }
}
