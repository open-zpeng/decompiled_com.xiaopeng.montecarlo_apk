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
import com.autonavi.gbl.util.model.BIZ_TASK_DEVICE_ID;
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
import java.util.Set;
import org.eclipse.paho.client.mqttv3.MqttTopic;
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
    private native void nativeClearMessage();

    @JniNativeMethod(parameters = {"data", CacheEntity.KEY})
    private native String nativeConfigDecrypt(byte[] bArr, String str);

    @JniNativeMethod(parameters = {"data", CacheEntity.KEY})
    private native byte[] nativeConfigEncrypt(String str, String str2);

    @JniNativeMethod(parameters = {})
    private static native String nativeGetEngineVeison();

    @JniNativeMethod(parameters = {"serviceID"})
    private native long nativeGetService(@SingleServiceID.SingleServiceID1 int i);

    @JniNativeMethod(parameters = {})
    private native long nativeGetServiceMgrInstance();

    @JniNativeMethod(parameters = {})
    private native ArrayList<String> nativeGetSupportLanguageList();

    @JniNativeMethod(parameters = {})
    private static native String nativeGetVersion();

    @JniNativeMethod(parameters = {"blInitParam"})
    @ErrorCode.ErrorCode1
    private native int nativeInitBL(BLInitParam bLInitParam);

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

    @JniNativeMethod(parameters = {VuiConstants.ELEMENT_ID})
    private native boolean nativeRemoveBizLooper(int i);

    @JniNativeMethod(parameters = {})
    private native void nativeRemoveServiceMgrInstance();

    @JniNativeMethod(parameters = {})
    private native void nativeResetMessage();

    @JniNativeMethod(parameters = {VuiConstants.ELEMENT_ID, "loop"})
    private native boolean nativeSetBizLooper(int i, Looper looper);

    @JniNativeMethod(parameters = {"groupMask"})
    private native void nativeSetGroupMask(long j);

    @JniNativeMethod(parameters = {"ip", "port"})
    private static native void nativeSetNetworkProxy(String str, int i);

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
        nativeResetMessage();
        if (bLInitParam.dataPath.cfgFilePath != null) {
            String str = bLInitParam.dataPath.cfgFilePath;
            if (!str.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                str = str + MqttTopic.TOPIC_LEVEL_SEPARATOR;
            }
            String str2 = str + "data/";
            return nativeInitBL(bLInitParam);
        }
        return 1;
    }

    public synchronized void unInitBL() {
        nativeClearMessage();
        for (IService iService : this.mutilServiceList) {
            iService.onDestroy();
        }
        Set<Integer> keySet = this.singleServiceList.keySet();
        for (Integer num : keySet) {
            IService iService2 = this.singleServiceList.get(num);
            if (iService2 != null) {
                iService2.onDestroy();
            }
        }
        nativeUnInitBL();
        for (IService iService3 : this.mutilServiceList) {
            invokeDeclaredMethodReflect(iService3, RequestParameters.SUBRESOURCE_DELETE, null, null);
        }
        this.mutilServiceList.clear();
        for (Integer num2 : keySet) {
            IService iService4 = this.singleServiceList.get(num2);
            if (iService4 != null) {
                invokeDeclaredMethodReflect(iService4, RequestParameters.SUBRESOURCE_DELETE, null, null);
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

    /* JADX WARN: Removed duplicated region for block: B:66:0x03d4 A[Catch: all -> 0x03e2, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x001b, B:13:0x0026, B:66:0x03d4, B:67:0x03d7, B:15:0x002b, B:17:0x0033, B:20:0x0059, B:21:0x005e, B:23:0x0066, B:26:0x008e, B:27:0x0093, B:28:0x00b5, B:29:0x00d7, B:30:0x00f9, B:32:0x0101, B:35:0x0128, B:36:0x012d, B:37:0x014f, B:39:0x0157, B:42:0x017e, B:43:0x0183, B:44:0x01a5, B:45:0x01c7, B:46:0x01e9, B:47:0x020b, B:48:0x022d, B:49:0x024f, B:50:0x0271, B:51:0x0293, B:52:0x02b5, B:54:0x02bd, B:57:0x02e4, B:58:0x02e9, B:59:0x030b, B:60:0x032d, B:61:0x034f, B:62:0x0370, B:63:0x0391, B:64:0x03b2), top: B:77:0x0001, inners: #0, #1, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.autonavi.gbl.servicemanager.IService getBLService(@com.autonavi.gbl.util.model.SingleServiceID.SingleServiceID1 int r10) {
        /*
            Method dump skipped, instructions count: 1054
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

    public boolean setBizLooper(@BIZ_TASK_DEVICE_ID.BIZ_TASK_DEVICE_ID1 int i, Looper looper) {
        return nativeSetBizLooper(i, looper);
    }

    public boolean removeBizLooper(@BIZ_TASK_DEVICE_ID.BIZ_TASK_DEVICE_ID1 int i) {
        return nativeRemoveBizLooper(i);
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
}
