package com.autonavi.gbl.util.observer.impl;

import com.autonavi.gbl.util.model.KeyValue;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.model.ObjLifeState;
import com.autonavi.gbl.util.model.RuntimeInfo;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UtilModelObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IJniExceptionObserverImpl_onException(IJniExceptionObserverImpl iJniExceptionObserverImpl, String str) {
        iJniExceptionObserverImpl.onException(str);
    }

    public static long SwigDirector_TimeSourceImpl_getTickCountUS(TimeSourceImpl timeSourceImpl) {
        return timeSourceImpl.getTickCountUS();
    }

    public static long SwigDirector_TimeSourceImpl_getLocalTimeUS(TimeSourceImpl timeSourceImpl) {
        return timeSourceImpl.getLocalTimeUS();
    }

    public static boolean SwigDirector_IWordBreakAdapterImpl_breakText(IWordBreakAdapterImpl iWordBreakAdapterImpl, String str, ArrayList<String> arrayList) {
        return iWordBreakAdapterImpl.breakText(str, arrayList);
    }

    public static void SwigDirector_IObjLifeStateObserverImpl_inProgress(IObjLifeStateObserverImpl iObjLifeStateObserverImpl, @ObjLifeState.ObjLifeState1 int i, long j, String str) {
        iObjLifeStateObserverImpl.inProgress(i, j, str);
    }

    public static void SwigDirector_RunTaskImpl_run(RunTaskImpl runTaskImpl) {
        runTaskImpl.run();
    }

    public static void SwigDirector_RunTaskImpl_onCancel(RunTaskImpl runTaskImpl) {
        runTaskImpl.onCancel();
    }

    public static long SwigDirector_RunTaskImpl_getId(RunTaskImpl runTaskImpl) {
        return runTaskImpl.getId();
    }

    public static String SwigDirector_RunTaskImpl_getTaskName(RunTaskImpl runTaskImpl) {
        return runTaskImpl.getTaskName();
    }

    public static void SwigDirector_IRunTaskThreadImpl_post(IRunTaskThreadImpl iRunTaskThreadImpl, RunTaskImpl runTaskImpl, long j, BigInteger bigInteger) {
        iRunTaskThreadImpl.post(runTaskImpl, j, bigInteger);
    }

    public static void SwigDirector_IRunTaskThreadImpl_cancel__SWIG_0(IRunTaskThreadImpl iRunTaskThreadImpl, long j) {
        iRunTaskThreadImpl.cancel(j);
    }

    public static void SwigDirector_IRunTaskThreadImpl_cancel__SWIG_1(IRunTaskThreadImpl iRunTaskThreadImpl, ArrayList<Long> arrayList) {
        iRunTaskThreadImpl.cancel(arrayList);
    }

    public static void SwigDirector_IRunTaskThreadImpl_clear(IRunTaskThreadImpl iRunTaskThreadImpl) {
        iRunTaskThreadImpl.clear();
    }

    public static void SwigDirector_RuntimeInfoObserverImpl_onRuntimeInfoResponse(RuntimeInfoObserverImpl runtimeInfoObserverImpl, RuntimeInfo runtimeInfo) {
        runtimeInfoObserverImpl.onRuntimeInfoResponse(runtimeInfo);
    }

    public static void SwigDirector_UITaskImpl_run(UITaskImpl uITaskImpl) {
        uITaskImpl.run();
    }

    public static void SwigDirector_UITaskImpl_onCancel(UITaskImpl uITaskImpl) {
        uITaskImpl.onCancel();
    }

    public static long SwigDirector_UITaskImpl_getId(UITaskImpl uITaskImpl) {
        return uITaskImpl.getId();
    }

    public static String SwigDirector_UITaskImpl_getTaskName(UITaskImpl uITaskImpl) {
        return uITaskImpl.getTaskName();
    }

    public static void SwigDirector_IUITaskThreadImpl_post(IUITaskThreadImpl iUITaskThreadImpl, UITaskImpl uITaskImpl, long j, BigInteger bigInteger) {
        iUITaskThreadImpl.post(uITaskImpl, j, bigInteger);
    }

    public static void SwigDirector_IUITaskThreadImpl_cancel__SWIG_0(IUITaskThreadImpl iUITaskThreadImpl, long j) {
        iUITaskThreadImpl.cancel(j);
    }

    public static void SwigDirector_IUITaskThreadImpl_cancel__SWIG_1(IUITaskThreadImpl iUITaskThreadImpl, ArrayList<Long> arrayList) {
        iUITaskThreadImpl.cancel(arrayList);
    }

    public static void SwigDirector_IUITaskThreadImpl_clear(IUITaskThreadImpl iUITaskThreadImpl) {
        iUITaskThreadImpl.clear();
    }

    public static void SwigDirector_IPlatformInterfaceImpl_copyAssetFile(IPlatformInterfaceImpl iPlatformInterfaceImpl, String str, String str2) {
        iPlatformInterfaceImpl.copyAssetFile(str, str2);
    }

    public static float SwigDirector_IPlatformInterfaceImpl_getDensity(IPlatformInterfaceImpl iPlatformInterfaceImpl, int i) {
        return iPlatformInterfaceImpl.getDensity(i);
    }

    public static int SwigDirector_IPlatformInterfaceImpl_getDensityDpi(IPlatformInterfaceImpl iPlatformInterfaceImpl, int i) {
        return iPlatformInterfaceImpl.getDensityDpi(i);
    }

    @NetworkStatus.NetworkStatus1
    public static int SwigDirector_IPlatformInterfaceImpl_getNetStatus(IPlatformInterfaceImpl iPlatformInterfaceImpl) {
        return iPlatformInterfaceImpl.getNetStatus();
    }

    public static ArrayList<KeyValue> SwigDirector_IPlatformInterfaceImpl_getCdnNetworkParam(IPlatformInterfaceImpl iPlatformInterfaceImpl) {
        return iPlatformInterfaceImpl.getCdnNetworkParam();
    }

    public static boolean SwigDirector_IPlatformInterfaceImpl_getAosNetworkParam(IPlatformInterfaceImpl iPlatformInterfaceImpl, ArrayList<KeyValue> arrayList) {
        return iPlatformInterfaceImpl.getAosNetworkParam(arrayList);
    }

    public static String SwigDirector_IPlatformInterfaceImpl_amapEncode(IPlatformInterfaceImpl iPlatformInterfaceImpl, byte[] bArr) {
        return iPlatformInterfaceImpl.amapEncode(bArr);
    }

    public static String SwigDirector_IPlatformInterfaceImpl_amapEncodeBinary(IPlatformInterfaceImpl iPlatformInterfaceImpl, byte[] bArr) {
        return iPlatformInterfaceImpl.amapEncodeBinary(bArr);
    }

    public static String SwigDirector_IPlatformInterfaceImpl_amapDecode(IPlatformInterfaceImpl iPlatformInterfaceImpl, byte[] bArr) {
        return iPlatformInterfaceImpl.amapDecode(bArr);
    }

    public static boolean SwigDirector_IPlatformInterfaceImpl_getAosSign(IPlatformInterfaceImpl iPlatformInterfaceImpl, String str, String[] strArr) {
        return iPlatformInterfaceImpl.getAosSign(str, strArr);
    }
}
