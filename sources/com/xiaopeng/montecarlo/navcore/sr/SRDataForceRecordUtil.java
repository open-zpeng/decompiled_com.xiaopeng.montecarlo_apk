package com.xiaopeng.montecarlo.navcore.sr;

import android.text.TextUtils;
import com.google.protobuf.ByteString;
import com.xiaopeng.montecarlo.navcore.configurationmodule.ConfigurationModuleManager;
import com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum;
import com.xiaopeng.montecarlo.navcore.datarecord.SrDataRecordStrategyInfo;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import xpilot.sr.proto.Overall;
/* loaded from: classes3.dex */
public class SRDataForceRecordUtil {
    public static final int DATA_JUMP_DEBUG = 1;
    public static final int DATA_JUMP_INVALID = -1;
    public static final int DATA_JUMP_NGP = 4;
    public static final int DATA_JUMP_NONE_NGP = 40;
    private static final long MAX_FOLDER_SIZE = 94371840;
    private static final long MAX_PER_FILE_SIZE = 5242880;
    private static final int MAX_RECORD_COUNT_IN_ONE_FILE = 1500;
    private static final int PER_OUTPUT_INFO_SIZE = 100;
    public static final String SR_RECORD_FILE_EXTENSION = ".proto";
    private static final L.Tag TAG = new L.Tag("SRDataRecordUtil");
    public static final String SR_RECORD_FILE_FOLDER = RootUtil.DIR_PROTO_DATA_LOG;
    private static final SRDataForceRecordUtil sInstance = new SRDataForceRecordUtil();
    private static SrDataRecordStrategyInfo sStrategyInfo = new SrDataRecordStrategyInfo();
    private int mProtoCount = 0;
    private Overall.total_overall.Builder mTotalBuilder = null;
    private String mFileNameForRelease = null;
    private boolean mIsDiskSizeChecked = false;
    private boolean mIsTestMode = false;

    static {
        sStrategyInfo.setUserRole("user");
        sStrategyInfo.setMaxTotalSize(Long.valueOf((long) MAX_FOLDER_SIZE));
        sStrategyInfo.setMaxPerFileSize(Long.valueOf((long) MAX_PER_FILE_SIZE));
        sStrategyInfo.setFramesCountForOneWrite(100);
        sStrategyInfo.setFramesCountForOneFile(1500);
        sStrategyInfo.setFramesJumpForInsertForSRActive(4);
        sStrategyInfo.setFramesJumpForInsertForSRUnActive(40);
    }

    public static SRDataForceRecordUtil getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsTestMode(boolean z) {
        this.mIsTestMode = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isTestMode() {
        return this.mIsTestMode;
    }

    private int mergeData(Overall.overall.Builder builder) {
        if (this.mTotalBuilder == null) {
            this.mTotalBuilder = Overall.total_overall.newBuilder();
        }
        this.mTotalBuilder.addOverall(builder);
        return this.mTotalBuilder.getOverallCount();
    }

    private boolean createRecordFolder() {
        File file = new File(SR_RECORD_FILE_FOLDER);
        if (!file.exists()) {
            file.mkdirs();
            setProtoDataFilePermission(file);
        }
        return file.exists();
    }

    private void setProtoDataFilePermission(File file) {
        if (file != null && file.exists()) {
            FileUtil.setFileWith755Permission(file);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "setProtoDataFilePermission 755 file:" + file.getAbsolutePath());
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || RootUtil.MNT_VMAP.equals(parentFile.getAbsolutePath())) {
                return;
            }
            setProtoDataFilePermission(parentFile);
            return;
        }
        L.e(TAG, "setProtoDataFilePermission fail folder not exists");
    }

    private void outputFilePermission(File file) {
        if (file != null && file.exists()) {
            FileUtil.getFilePermission(file);
            File parentFile = file.getParentFile();
            if (parentFile == null || RootUtil.MNT_VMAP.equals(parentFile.getAbsolutePath())) {
                return;
            }
            outputFilePermission(parentFile);
            return;
        }
        L.e(TAG, "outputFilePermission fail folder not exists");
    }

    private void outputToFile() throws IOException {
        FileOutputStream fileOutputStream;
        if (!createRecordFolder()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "cannot create record folder when output: " + SR_RECORD_FILE_FOLDER);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mFileNameForRelease)) {
            this.mFileNameForRelease = String.format("%s%s", new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA).format(new Date()), SR_RECORD_FILE_EXTENSION);
        }
        File file = new File(SR_RECORD_FILE_FOLDER + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.mFileNameForRelease);
        if (!file.exists()) {
            checkFolderSize();
            outputFilePermission(new File(SR_RECORD_FILE_FOLDER));
            file.createNewFile();
            FileUtil.setFileWith755Permission(file);
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "recordData file:" + file.getPath() + ", count:" + this.mTotalBuilder.getOverallCount());
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.mTotalBuilder.build().writeTo(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    private void checkFolderSize() {
        long longValue = sStrategyInfo.getMaxTotalSize().longValue() - FileUtil.getDirSize(new File(SR_RECORD_FILE_FOLDER), false);
        long longValue2 = sStrategyInfo.getMaxPerFileSize().longValue();
        if (longValue < sStrategyInfo.getMaxPerFileSize().longValue()) {
            long j = 0;
            if (longValue < 0) {
                longValue2 += Math.abs(longValue);
            }
            if (L.ENABLE) {
                L.d(TAG, "checkFolderSize maxSizeToBeDelete:" + longValue2 + ",free:" + longValue + ",maxTotal:" + sStrategyInfo.getMaxTotalSize());
            }
            File[] listFileOrderByDate = listFileOrderByDate();
            if (listFileOrderByDate == null) {
                return;
            }
            for (File file : listFileOrderByDate) {
                j += file.length();
                if (L.ENABLE) {
                    L.d(TAG, "checkFolderSize delete file:" + file.getAbsolutePath() + ",size:" + file.length());
                }
                file.delete();
                if (j >= longValue2) {
                    return;
                }
            }
        }
    }

    private File[] listFileOrderByDate() {
        File file = new File(SR_RECORD_FILE_FOLDER);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.xiaopeng.montecarlo.navcore.sr.SRDataForceRecordUtil.1
                @Override // java.util.Comparator
                public boolean equals(Object obj) {
                    return true;
                }

                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    int i = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                    if (i > 0) {
                        return 1;
                    }
                    return i == 0 ? 0 : -1;
                }
            });
            return listFiles;
        }
        return null;
    }

    public void stopRecord() {
        this.mIsDiskSizeChecked = false;
        release();
    }

    private void release() {
        this.mProtoCount = 0;
        this.mFileNameForRelease = null;
        Overall.total_overall.Builder builder = this.mTotalBuilder;
        if (builder != null) {
            builder.clear();
            this.mTotalBuilder = null;
        }
    }

    public void record(Overall.overall overallVar) {
        if (sStrategyInfo.getFramesCountForOneWrite().intValue() == -1 || sStrategyInfo.getFramesCountForOneFile().intValue() == -1) {
            return;
        }
        if (!this.mIsDiskSizeChecked) {
            if (L.ENABLE) {
                L.d(TAG, "record check disk size");
            }
            this.mIsDiskSizeChecked = true;
            LogHelper.getInstance().checkLogDiskSize(true);
        }
        if (canRecord()) {
            int i = 0;
            try {
                try {
                    i = mergeData(overallVar.toBuilder().setXpPosInfo(ByteString.copyFromUtf8(GsonUtil.toJson(DRServiceManager.getInstance().getPosInfo()))));
                    if (i % sStrategyInfo.getFramesCountForOneWrite().intValue() == 0) {
                        outputToFile();
                    }
                    if (i < sStrategyInfo.getFramesCountForOneFile().intValue()) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (i < sStrategyInfo.getFramesCountForOneFile().intValue()) {
                        return;
                    }
                }
                release();
            } catch (Throwable th) {
                if (i >= sStrategyInfo.getFramesCountForOneFile().intValue()) {
                    release();
                }
                throw th;
            }
        }
    }

    private boolean canRecord() {
        int intValue;
        this.mProtoCount++;
        if (isTestMode()) {
            intValue = 1;
        } else if (SRNaviManager.getInstance().getSRDisplayState() == 2) {
            intValue = sStrategyInfo.getFramesJumpForInsertForSRUnActive().intValue();
        } else {
            intValue = sStrategyInfo.getFramesJumpForInsertForSRActive().intValue();
        }
        if (L.ENABLE) {
            L.d(TAG, "canRecord mProtoCount:" + this.mProtoCount + ",dataJump:" + intValue);
        }
        return this.mProtoCount % intValue == 0;
    }

    public void initRecordStrategy() {
        setProtoDataFilePermission(new File(SR_RECORD_FILE_FOLDER));
        getStrategyFormDb();
    }

    public void updateRecordStrategy() {
        getStrategyFormDb();
    }

    private void getStrategyFormDb() {
        SrDataRecordStrategyInfo srDataRecordStrategyInfo = (SrDataRecordStrategyInfo) ConfigurationModuleManager.getInstance().getConfigurationFromDatabase(WebConfigurationEnum.RECORD_DATA_STRATEGY, SrDataRecordStrategyInfo.class);
        if (srDataRecordStrategyInfo != null) {
            L.i(TAG, "getStrategyFormDb strategy changed with db setting");
            sStrategyInfo = srDataRecordStrategyInfo;
            if (SrDataRecordStrategyInfo.UserRole.USER_ROLE_TEST.equals(sStrategyInfo.getUserRole())) {
                this.mIsTestMode = true;
            } else {
                this.mIsTestMode = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_SR_DATA_RECORD, false);
            }
        }
        L.Tag tag = TAG;
        L.i(tag, "getStrategyFormDb isTestMode:" + this.mIsTestMode + ",record strategy:" + sStrategyInfo.toString());
    }
}
