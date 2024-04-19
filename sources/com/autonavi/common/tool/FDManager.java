package com.autonavi.common.tool;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FDManager {
    public static final int FD_SIZE = 20;
    public static final String LINE_SEPERATOR = "\n";
    public static final String TAG = "DFManager";
    public static final String TMP_FILE_NAME = ".fd_tmp_file.txt";
    private static FDManager mInstance;
    private FileInputStream[] fisArr;
    private String mSaveFilePath;
    private File mTmpFile;

    public static FDManager getInstance() {
        if (mInstance == null) {
            synchronized (FDManager.class) {
                mInstance = new FDManager();
            }
        }
        return mInstance;
    }

    private FDManager() {
    }

    public void init(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mSaveFilePath = str;
        ensureSaveFilePathExsit();
        ensureTmpFileExist();
        if (this.mTmpFile != null) {
            initFd();
        }
    }

    public String getFDListStr() {
        if (TextUtils.isEmpty(this.mSaveFilePath)) {
            return null;
        }
        releaseFd();
        List<String> fDList = getFDList(false);
        if (fDList == null || fDList.size() == 0) {
            return null;
        }
        if (fDList.size() >= 300 || CrashLog.debugMode() || CrashLog.isNeedForceDumpAllFdList()) {
            StringBuilder sb = new StringBuilder();
            sb.append("FD List:");
            sb.append(LINE_SEPERATOR);
            for (String str : fDList) {
                sb.append(str);
                sb.append(LINE_SEPERATOR);
            }
            sb.append(LINE_SEPERATOR);
            sb.append(LINE_SEPERATOR);
            return sb.toString();
        }
        return null;
    }

    private void initFd() {
        this.fisArr = new FileInputStream[20];
        for (int i = 0; i < 20; i++) {
            try {
                this.fisArr[i] = new FileInputStream(this.mTmpFile);
            } catch (FileNotFoundException unused) {
            }
        }
    }

    public void releaseFd() {
        if (this.fisArr == null) {
            return;
        }
        for (int i = 0; i < 20; i++) {
            FileInputStream[] fileInputStreamArr = this.fisArr;
            if (fileInputStreamArr[i] != null) {
                try {
                    fileInputStreamArr[i].close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void ensureSaveFilePathExsit() {
        if (TextUtils.isEmpty(this.mSaveFilePath)) {
            return;
        }
        File file = new File(this.mSaveFilePath);
        try {
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        } catch (Exception unused) {
        }
    }

    private void ensureTmpFileExist() {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(this.mSaveFilePath)) {
            return;
        }
        this.mTmpFile = new File(this.mSaveFilePath, TMP_FILE_NAME);
        if (this.mTmpFile.exists()) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.mTmpFile);
            } catch (IOException unused) {
                return;
            }
        } catch (Exception unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(145);
            fileOutputStream.close();
        } catch (Exception unused3) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public static List<String> getFDList(boolean z) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] listFiles = new File("/proc/self/fd").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    String canonicalPath = file.getCanonicalPath();
                    if (!z || canonicalPath.contains("autonavi")) {
                        arrayList.add(file.getName() + " -> " + canonicalPath);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }
}
