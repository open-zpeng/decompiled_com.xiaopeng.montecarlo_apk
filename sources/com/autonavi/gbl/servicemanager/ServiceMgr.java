package com.autonavi.gbl.servicemanager;

import android.app.Application;
import android.net.Proxy;
import android.os.Looper;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.bl.puglin.annotations.JniField;
import com.autonavi.auto.bl.puglin.annotations.JniNativeMethod;
import com.autonavi.gbl.servicemanager.model.BLInitParam;
import com.autonavi.gbl.servicemanager.model.BaseInitParam;
import com.autonavi.gbl.servicemanager.model.ServiceDataPath;
import com.autonavi.gbl.util.exception.ExceptionMgr;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.model.SingleServiceID;
import com.lzy.okgo.cache.CacheEntity;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class ServiceMgr {
    private static ServiceMgr instance;
    private Map<Integer, IService> singleServiceList = new HashMap();
    private List<IService> mutilServiceList = new ArrayList();
    @JniField
    private long ptr = nativeGetServiceMgrInstance();

    @JniNativeMethod(parameters = {"pPosService", "pGuideService"})
    @ErrorCode.ErrorCode1
    private native int nativeBindPos2Guide(IService iService, IService iService2);

    @JniNativeMethod(parameters = {"strLanguage"})
    private native boolean nativeChangeLanguage(String str);

    @JniNativeMethod(parameters = {})
    private native void nativeClearAllMessage();

    @JniNativeMethod(parameters = {VuiConstants.ELEMENT_ID})
    private native void nativeClearMessage(int i);

    @JniNativeMethod(parameters = {"data", CacheEntity.KEY})
    private native String nativeConfigDecrypt(byte[] bArr, String str);

    @JniNativeMethod(parameters = {"data", CacheEntity.KEY})
    private native byte[] nativeConfigEncrypt(String str, String str2);

    @JniNativeMethod(parameters = {})
    private static native String nativeGetEngineVeison();

    @JniNativeMethod(parameters = {})
    private native long nativeGetSdkLimitTimeUTC();

    @JniNativeMethod(parameters = {"serviceID"})
    private native long nativeGetService(@SingleServiceID.SingleServiceID1 int i);

    @JniNativeMethod(parameters = {})
    private native long nativeGetServiceMgrInstance();

    @JniNativeMethod(parameters = {})
    private native ArrayList<String> nativeGetSupportLanguageList();

    @JniNativeMethod(parameters = {})
    private static native String nativeGetVersion();

    @JniNativeMethod(parameters = {"blInitParam", "blLooper"})
    @ErrorCode.ErrorCode1
    private native int nativeInitBL(BLInitParam bLInitParam, Looper looper);

    @JniNativeMethod(parameters = {"baseInitParam", "bLogcat", "async"})
    @ErrorCode.ErrorCode1
    private native int nativeInitBaseLibs(BaseInitParam baseInitParam, boolean z, boolean z2);

    @JniNativeMethod(parameters = {})
    private static native void nativeLogStop();

    @JniNativeMethod(parameters = {"level"})
    private native void nativeLogSwitch(long j);

    @JniNativeMethod(parameters = {"eStates"})
    private native void nativeNetworkChange(@NetworkStatus.NetworkStatus1 int i);

    @JniNativeMethod(parameters = {"serviceID"})
    @ErrorCode.ErrorCode1
    private native int nativeRemoveBLService(@SingleServiceID.SingleServiceID1 int i);

    @JniNativeMethod(parameters = {})
    private native void nativeRemoveServiceMgrInstance();

    @JniNativeMethod(parameters = {VuiConstants.ELEMENT_ID})
    private native boolean nativeRemoveUiLooper(int i);

    @JniNativeMethod(parameters = {})
    private native void nativeResetAllMessage();

    @JniNativeMethod(parameters = {VuiConstants.ELEMENT_ID})
    private native void nativeResetMessage(int i);

    @JniNativeMethod(parameters = {"groupMask"})
    private native void nativeSetGroupMask(long j);

    @JniNativeMethod(parameters = {"ip", "port"})
    private static native void nativeSetNetworkProxy(String str, int i);

    private native boolean nativeSetUiLooper(int i, Looper looper);

    @JniNativeMethod(parameters = {"bEnable"})
    private native void nativeSetVirtualBusEnable(boolean z);

    @JniNativeMethod(parameters = {"path"})
    private native void nativeSwitchDataPath(ServiceDataPath serviceDataPath);

    @JniNativeMethod(parameters = {})
    private native void nativeUnInitBL();

    @JniNativeMethod(parameters = {})
    private native void nativeUnInitBaseLibs();

    private ServiceMgr() {
    }

    @ErrorCode.ErrorCode1
    public int initBaseLibs(BaseInitParam baseInitParam) {
        if (baseInitParam == null || 0 == baseInitParam.getPlatformUtil()) {
            return 1;
        }
        ExceptionMgr.setExceptionParam(baseInitParam.serverType, baseInitParam.logPath);
        return nativeInitBaseLibs(baseInitParam, baseInitParam.bLogcat, baseInitParam.async);
    }

    @ErrorCode.ErrorCode1
    public int initBL(BLInitParam bLInitParam, Application application) {
        if (bLInitParam == null || bLInitParam.dataPath == null || application == null) {
            return 1;
        }
        ExceptionMgr.getInstance().Init(application);
        nativeResetAllMessage();
        if (bLInitParam.dataPath.cfgFilePath != null) {
            String str = bLInitParam.dataPath.cfgFilePath;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            String str2 = str + "data/";
            return nativeInitBL(bLInitParam, Looper.getMainLooper());
        }
        return 1;
    }

    public synchronized void unInitBL() {
        nativeClearAllMessage();
        for (IService iService : this.mutilServiceList) {
            iService.onDestroy();
        }
        for (Map.Entry<Integer, IService> entry : this.singleServiceList.entrySet()) {
            IService value = entry.getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        nativeUnInitBL();
        for (IService iService2 : this.mutilServiceList) {
            invokeDeclaredMethodReflect(iService2, RequestParameters.SUBRESOURCE_DELETE, null, null);
        }
        this.mutilServiceList.clear();
        for (Map.Entry<Integer, IService> entry2 : this.singleServiceList.entrySet()) {
            IService value2 = entry2.getValue();
            if (value2 != null) {
                invokeDeclaredMethodReflect(value2, RequestParameters.SUBRESOURCE_DELETE, null, null);
            }
        }
        this.singleServiceList.clear();
        ExceptionMgr.getInstance().unInit();
    }

    public synchronized void unInitBaseLibs() {
        nativeUnInitBaseLibs();
    }

    public void switchLog(long j) {
        nativeLogSwitch(j);
    }

    public void setGroupMask(long j) {
        nativeSetGroupMask(j);
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static String getEngineVersion() {
        return nativeGetEngineVeison();
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04d5 A[Catch: all -> 0x04e3, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x001b, B:13:0x0026, B:87:0x04d5, B:88:0x04d8, B:15:0x002b, B:17:0x0033, B:20:0x005a, B:21:0x005f, B:23:0x0067, B:26:0x008e, B:27:0x0093, B:28:0x00b5, B:29:0x00d7, B:31:0x00df, B:34:0x0105, B:35:0x010a, B:37:0x0112, B:40:0x0138, B:41:0x013d, B:43:0x0145, B:46:0x016d, B:47:0x0172, B:48:0x0194, B:49:0x01b6, B:50:0x01d8, B:51:0x01fa, B:53:0x0202, B:56:0x0229, B:57:0x022e, B:58:0x0250, B:60:0x0258, B:63:0x027f, B:64:0x0284, B:65:0x02a6, B:66:0x02c8, B:67:0x02ea, B:68:0x030c, B:69:0x032e, B:70:0x0350, B:71:0x0372, B:72:0x0394, B:73:0x03b6, B:75:0x03be, B:78:0x03e5, B:79:0x03ea, B:80:0x040c, B:81:0x042e, B:82:0x0450, B:83:0x0471, B:84:0x0492, B:85:0x04b3), top: B:100:0x0001, inners: #0, #1, #2, #4, #5, #6, #7, #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.autonavi.gbl.servicemanager.IService getBLService(@com.autonavi.gbl.util.model.SingleServiceID.SingleServiceID1 int r10) {
        /*
            Method dump skipped, instructions count: 1324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.gbl.servicemanager.ServiceMgr.getBLService(int):com.autonavi.gbl.servicemanager.IService");
    }

    @ErrorCode.ErrorCode1
    public synchronized int removeBLService(@SingleServiceID.SingleServiceID1 int i) {
        int i2;
        i2 = -1;
        try {
            switch (i) {
                case 0:
                    for (int i3 = 0; i3 < this.mutilServiceList.size(); i3++) {
                        IService iService = this.mutilServiceList.get(i3);
                        if (iService != null) {
                            iService.onDestroy();
                            invokeDeclaredMethodReflect(iService, RequestParameters.SUBRESOURCE_DELETE, null, null);
                        }
                    }
                    this.mutilServiceList.clear();
                    removeBLService(19);
                    IService iService2 = this.singleServiceList.get(Integer.valueOf(i));
                    if (iService2 != null) {
                        iService2.onDestroy();
                        i2 = nativeRemoveBLService(i);
                        invokeDeclaredMethodReflect(iService2, RequestParameters.SUBRESOURCE_DELETE, null, null);
                        this.singleServiceList.remove(Integer.valueOf(i));
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 13:
                case 14:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                    IService iService3 = this.singleServiceList.get(Integer.valueOf(i));
                    if (iService3 != null) {
                        iService3.onDestroy();
                        i2 = nativeRemoveBLService(i);
                        invokeDeclaredMethodReflect(iService3, RequestParameters.SUBRESOURCE_DELETE, null, null);
                        this.singleServiceList.remove(Integer.valueOf(i));
                        break;
                    }
                    break;
                case 12:
                case 15:
                    removeBLService(13);
                    IService iService4 = this.singleServiceList.get(12);
                    IService iService5 = this.singleServiceList.get(15);
                    if (iService4 != null) {
                        iService4.onDestroy();
                    }
                    if (iService5 != null) {
                        iService5.onDestroy();
                        i2 = nativeRemoveBLService(15);
                        invokeDeclaredMethodReflect(iService5, RequestParameters.SUBRESOURCE_DELETE, null, null);
                    } else if (iService4 != null) {
                        i2 = nativeRemoveBLService(12);
                    }
                    if (iService4 != null) {
                        invokeDeclaredMethodReflect(iService4, RequestParameters.SUBRESOURCE_DELETE, null, null);
                    }
                    this.singleServiceList.remove(12);
                    this.singleServiceList.remove(15);
                    break;
                case 16:
                    removeBLService(15);
                    IService iService6 = this.singleServiceList.get(Integer.valueOf(i));
                    if (iService6 != null) {
                        iService6.onDestroy();
                        i2 = nativeRemoveBLService(i);
                        invokeDeclaredMethodReflect(iService6, RequestParameters.SUBRESOURCE_DELETE, null, null);
                        this.singleServiceList.remove(Integer.valueOf(i));
                        break;
                    }
                    break;
            }
        } catch (Throwable th) {
            throw th;
        }
        return i2;
    }

    private <T> T createInstanceReflect(Class<T> cls, Class<?>[] clsArr, Object... objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            T newInstance = declaredConstructor.newInstance(objArr);
            declaredConstructor.setAccessible(false);
            return newInstance;
        } catch (Exception unused) {
            throw new RuntimeException("create service instance fail, reason is: \n");
        }
    }

    private static Object invokeDeclaredMethodReflect(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj, objArr);
            declaredMethod.setAccessible(false);
            return invoke;
        } catch (Exception unused) {
            throw new RuntimeException("InvokeDeclaredMethodSafe fail, reason is: \n");
        }
    }

    public static synchronized ServiceMgr getServiceMgrInstance() {
        ServiceMgr serviceMgr;
        synchronized (ServiceMgr.class) {
            if (instance == null) {
                synchronized (ServiceMgr.class) {
                    if (instance == null) {
                        instance = new ServiceMgr();
                    }
                }
            }
            serviceMgr = instance;
        }
        return serviceMgr;
    }

    public synchronized void removeServiceMgrInstance() {
        synchronized (ServiceMgr.class) {
            nativeRemoveServiceMgrInstance();
            this.ptr = 0L;
            instance = null;
        }
    }

    public void networkChange(@NetworkStatus.NetworkStatus1 int i) {
        nativeNetworkChange(i);
    }

    public byte[] configEncrypt(String str, String str2) {
        if (str == null) {
            return null;
        }
        return nativeConfigEncrypt(str, "empty");
    }

    public String configDecrypt(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return nativeConfigDecrypt(bArr, "empty");
    }

    public static void loadSystemNetworkProxy() {
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost == null || defaultPort <= 0) {
            return;
        }
        nativeSetNetworkProxy(defaultHost, defaultPort);
    }

    public static void setNetworkProxy(String str, int i) {
        nativeSetNetworkProxy(str, i);
    }

    public static void logStop() {
        nativeLogStop();
    }

    @ErrorCode.ErrorCode1
    public int bindPos2Guide(IService iService, IService iService2) {
        if (iService == null || iService2 == null) {
            return 3;
        }
        return nativeBindPos2Guide(iService, iService2);
    }

    public void switchDataPath(ServiceDataPath serviceDataPath) {
        nativeSwitchDataPath(serviceDataPath);
    }

    public boolean setUiLooper(int i, Looper looper) {
        return nativeSetUiLooper(i, looper);
    }

    public boolean removeUiLooper(int i) {
        return nativeRemoveUiLooper(i);
    }

    public void setVirtualBusEnable(boolean z) {
        nativeSetVirtualBusEnable(z);
    }

    public ArrayList<String> getSupportLanguageList() {
        return nativeGetSupportLanguageList();
    }

    public boolean changeLanguage(String str) {
        return nativeChangeLanguage(str);
    }

    public long getSdkLimitTimeUTC() {
        return nativeGetSdkLimitTimeUTC();
    }
}
