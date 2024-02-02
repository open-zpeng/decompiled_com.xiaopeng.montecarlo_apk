package com.xiaopeng.montecarlo.root.util.logcat;

import com.autonavi.common.tool.FDManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes2.dex */
class LogCollector {
    private File mCurFile;
    private LogDiskManager mLogDiskManager;
    private BufferedWriter mWriter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogCollector(String str) {
        this.mLogDiskManager = new LogDiskManager(str);
    }

    public void init() {
        updateWriter(this.mLogDiskManager.getWriteFileName(false));
    }

    public void saveMessage(String str) {
        if (str == null || this.mCurFile == null || this.mWriter == null) {
            return;
        }
        write(str);
        if (this.mCurFile.length() > 1073741824) {
            String name = this.mCurFile.getName();
            updateWriter(this.mLogDiskManager.getWriteFileName(true));
            this.mLogDiskManager.recordLogFile(name);
        }
    }

    private void write(String str) {
        try {
            BufferedWriter bufferedWriter = this.mWriter;
            bufferedWriter.write(str + FDManager.LINE_SEPERATOR);
            this.mWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            if (this.mWriter != null) {
                this.mWriter.close();
                this.mWriter = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateWriter(String str) {
        try {
            this.mCurFile = new File(str);
            if (!this.mCurFile.exists()) {
                this.mCurFile.createNewFile();
            }
            if (this.mWriter != null) {
                this.mWriter.close();
            }
            this.mWriter = new BufferedWriter(new FileWriter(this.mCurFile, true));
        } catch (IOException e) {
            e.printStackTrace();
            this.mCurFile = null;
            this.mWriter = null;
        }
    }
}
