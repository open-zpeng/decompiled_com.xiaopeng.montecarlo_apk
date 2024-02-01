package com.dingtalk.mars.sdt;

import com.dingtalk.mars.Mars;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SdtLogic {
    public static final String TAG = "bifrost.SdtLogic";
    private static ICallBack callBack;

    /* loaded from: classes2.dex */
    public interface ICallBack {
        void reportSignalDetectResults(String str);
    }

    public static native int RequestSdtCheck(String str);

    private static native ArrayList<String> getLoadLibraries();

    public static native void setHttpNetcheckCGI(String str);

    public static void checkLibrary() {
        ArrayList<String> arrayList;
        try {
            arrayList = getLoadLibraries();
        } catch (Throwable unused) {
            Mars.loadDefaultMarsLibrary();
            arrayList = null;
        }
        Mars.checkLoadedModules(arrayList, TAG);
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    public static void reportSignalDetectResults(String str) {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return;
        }
        iCallBack.reportSignalDetectResults(str);
    }
}
