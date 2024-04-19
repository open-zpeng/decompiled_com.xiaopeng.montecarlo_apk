package com.autonavi.gbl.util.exception;

import android.app.Application;
import com.autonavi.common.tool.CrashLog;
/* loaded from: classes2.dex */
public class ExceptionMgr {
    private static boolean bEnable = true;
    private static ExceptionMgr mInstance = new ExceptionMgr();
    private ExceptionDumpDataControler mExceptionDumpDataObj = null;

    public static ExceptionMgr getInstance() {
        return mInstance;
    }

    public static void setExceptionParam(int i, String str) {
        ExceptionDumpDataControler.setExceptionParam(i, str);
    }

    public void Init(Application application) {
        if (true == bEnable) {
            this.mExceptionDumpDataObj = new ExceptionDumpDataControler(application);
            CrashLog.initCrashLog(this.mExceptionDumpDataObj);
            CrashLog.uploadCrash(true);
        }
    }

    public void unInit() {
        boolean z = bEnable;
    }
}
