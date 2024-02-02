package com.xiaopeng.montecarlo.root.util.logcat;

import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
class LogDiskRecord implements Serializable {
    private static final long serialVersionUID = 2953541964313199928L;
    String mCurrentLogName = "";
    CopyOnWriteArrayList<LogOption> mLogOptionList = new CopyOnWriteArrayList<>();

    /* loaded from: classes2.dex */
    static class LogOption implements Serializable {
        private static final long serialVersionUID = -567071510474491464L;
        private String mFileName;
        private int mStatus;

        public LogOption(int i, String str) {
            this.mStatus = i;
            this.mFileName = str;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public void setFileName(String str) {
            this.mFileName = str;
        }
    }
}
