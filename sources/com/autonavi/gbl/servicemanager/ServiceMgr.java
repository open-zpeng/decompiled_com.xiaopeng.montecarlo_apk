package com.autonavi.gbl.servicemanager;

import android.app.Application;
import android.content.res.AssetManager;
import android.net.Proxy;
import android.os.Looper;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.bl.puglin.annotations.JniField;
import com.autonavi.auto.bl.puglin.annotations.JniNativeMethod;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.servicemanager.model.BLInitParam;
import com.autonavi.gbl.servicemanager.model.BaseInitParam;
import com.autonavi.gbl.servicemanager.model.ServiceDataPath;
import com.autonavi.gbl.util.WordBreaker;
import com.autonavi.gbl.util.errorcode.common.Service;
import com.autonavi.gbl.util.exception.ExceptionMgr;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.model.SingleServiceID;
import com.autonavi.gbl.util.observer.IWordBreakAdapter;
import com.lzy.okgo.cache.CacheEntity;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class ServiceMgr {
    private static ServiceMgr instance;
    private WordBreakAdapter wordBreakAdapter = new WordBreakAdapter();
    private Map<Integer, IService> singleServiceList = new HashMap();
    private List<IService> mutilServiceList = new ArrayList();
    @JniField
    private long ptr = nativeGetServiceMgrInstance();
    private long unityMainTid = 0;

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

    @JniNativeMethod(parameters = {"strFileId", "strFilePath"})
    private native boolean nativeCustomResPath(String str, String str2);

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

    @JniNativeMethod(parameters = {"blInitParam"})
    @Service.Service1
    private native int nativeInitBL(BLInitParam bLInitParam, Looper looper);

    @JniNativeMethod(parameters = {"baseInitParam", "assetManager", "bLogcat", "async"})
    @Service.Service1
    private native int nativeInitBaseLibs(BaseInitParam baseInitParam, AssetManager assetManager, boolean z, boolean z2);

    @JniNativeMethod(parameters = {})
    private static native void nativeLogStop();

    @JniNativeMethod(parameters = {"level"})
    private native void nativeLogSwitch(long j);

    @JniNativeMethod(parameters = {"eStates"})
    private native void nativeNetworkChange(@NetworkStatus.NetworkStatus1 int i);

    @JniNativeMethod(parameters = {"serviceID"})
    @Service.Service1
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

    @JniNativeMethod(parameters = {"maxFileSize", "maxFiles"})
    private native void nativeSetLogCache(long j, long j2);

    @JniNativeMethod(parameters = {"ip", "port"})
    private static native void nativeSetNetworkProxy(String str, int i);

    private native boolean nativeSetUiLooper(int i, Looper looper, long j);

    @JniNativeMethod(parameters = {"bEnable"})
    private native void nativeSetVirtualBusEnable(boolean z);

    @JniNativeMethod(parameters = {"path"})
    private native void nativeSwitchDataPath(ServiceDataPath serviceDataPath);

    @JniNativeMethod(parameters = {})
    private native void nativeUnInitBL();

    @JniNativeMethod(parameters = {})
    private native void nativeUnInitBaseLibs();

    /* loaded from: classes2.dex */
    private static class WordBreakAdapter implements IWordBreakAdapter {
        private WordBreakAdapter() {
        }

        @Override // com.autonavi.gbl.util.observer.IWordBreakAdapter
        public boolean breakText(String str, ArrayList<String> arrayList) {
            arrayList.clear();
            BreakIterator characterInstance = BreakIterator.getCharacterInstance();
            characterInstance.setText(str);
            int first = characterInstance.first();
            while (true) {
                int i = first;
                first = characterInstance.next();
                if (first == -1) {
                    return true;
                }
                arrayList.add(str.substring(i, first));
            }
        }
    }

    private ServiceMgr() {
        WordBreaker.getInstance().setAdapter(this.wordBreakAdapter);
    }

    @Service.Service1
    public int initBaseLibs(BaseInitParam baseInitParam, Application application) {
        if (baseInitParam == null || 0 == baseInitParam.getPlatformUtil()) {
            return 3;
        }
        ExceptionMgr.setExceptionParam(baseInitParam.serverType, baseInitParam.logPath);
        return nativeInitBaseLibs(baseInitParam, application.getAssets(), baseInitParam.bLogcat, baseInitParam.async);
    }

    @Service.Service1
    public int initBL(BLInitParam bLInitParam, Application application) {
        if (bLInitParam == null || bLInitParam.dataPath == null || application == null) {
            return 3;
        }
        ExceptionMgr.getInstance().Init(application);
        nativeResetAllMessage();
        return nativeInitBL(bLInitParam, Looper.getMainLooper());
    }

    public synchronized void unInitBL() {
        nativeClearAllMessage();
        removeBLService(0);
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

    public void setLogCache(long j, long j2) {
        nativeSetLogCache(j, j2);
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static String getEngineVersion() {
        return nativeGetEngineVeison();
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x05b5 A[Catch: all -> 0x05c3, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x001b, B:13:0x0026, B:98:0x05b5, B:99:0x05b8, B:15:0x002b, B:16:0x004d, B:17:0x006f, B:18:0x0091, B:19:0x00b3, B:21:0x00bb, B:24:0x00e2, B:25:0x00e7, B:27:0x00ef, B:30:0x0116, B:31:0x011b, B:32:0x013d, B:34:0x0145, B:37:0x016c, B:38:0x0171, B:39:0x0193, B:41:0x019b, B:44:0x01c2, B:45:0x01c7, B:46:0x01e9, B:48:0x01f1, B:51:0x0218, B:52:0x021d, B:54:0x0225, B:57:0x024c, B:58:0x0251, B:59:0x0273, B:60:0x0295, B:61:0x02b7, B:63:0x02bf, B:66:0x02e6, B:67:0x02eb, B:68:0x030d, B:70:0x0315, B:73:0x033c, B:74:0x0341, B:75:0x0363, B:76:0x0385, B:77:0x03a7, B:78:0x03c9, B:79:0x03eb, B:80:0x040d, B:81:0x042f, B:82:0x0451, B:83:0x0473, B:84:0x0495, B:86:0x049d, B:89:0x04c5, B:90:0x04ca, B:91:0x04ec, B:92:0x050e, B:93:0x0530, B:94:0x0551, B:95:0x0572, B:96:0x0593), top: B:107:0x0001, inners: #0, #2, #3, #4, #5, #6, #7, #8, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.autonavi.gbl.servicemanager.IService getBLService(@com.autonavi.gbl.util.model.SingleServiceID.SingleServiceID1 int r10) {
        /*
            Method dump skipped, instructions count: 1562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.gbl.servicemanager.ServiceMgr.getBLService(int):com.autonavi.gbl.servicemanager.IService");
    }

    @Service.Service1
    public synchronized int removeBLService(@SingleServiceID.SingleServiceID1 int i) {
        int i2;
        i2 = -1;
        try {
            if (i == 0) {
                for (int i3 = 0; i3 < this.mutilServiceList.size(); i3++) {
                    IService iService = this.mutilServiceList.get(i3);
                    if (iService != null) {
                        iService.onDestroy();
                        invokeDeclaredMethodReflect(iService, RequestParameters.SUBRESOURCE_DELETE, null, null);
                    }
                }
                this.mutilServiceList.clear();
                removeBLService(23);
                removeBLService(20);
                IService iService2 = this.singleServiceList.get(Integer.valueOf(i));
                if (iService2 != null) {
                    iService2.onDestroy();
                    i2 = nativeRemoveBLService(i);
                    invokeDeclaredMethodReflect(iService2, RequestParameters.SUBRESOURCE_DELETE, null, null);
                    this.singleServiceList.remove(Integer.valueOf(i));
                }
            } else {
                if (i != 13) {
                    if (i != 36) {
                        if (i != 16) {
                            if (i == 17) {
                                removeBLService(16);
                                IService iService3 = this.singleServiceList.get(Integer.valueOf(i));
                                if (iService3 != null) {
                                    iService3.onDestroy();
                                    i2 = nativeRemoveBLService(i);
                                    invokeDeclaredMethodReflect(iService3, RequestParameters.SUBRESOURCE_DELETE, null, null);
                                    this.singleServiceList.remove(Integer.valueOf(i));
                                }
                            } else {
                                IService iService4 = this.singleServiceList.get(Integer.valueOf(i));
                                if (iService4 != null) {
                                    iService4.onDestroy();
                                    i2 = nativeRemoveBLService(i);
                                    invokeDeclaredMethodReflect(iService4, RequestParameters.SUBRESOURCE_DELETE, null, null);
                                    this.singleServiceList.remove(Integer.valueOf(i));
                                }
                            }
                        }
                    }
                }
                removeBLService(14);
                IService iService5 = this.singleServiceList.get(13);
                IService iService6 = this.singleServiceList.get(16);
                if (iService5 != null) {
                    iService5.onDestroy();
                }
                if (iService6 != null) {
                    iService6.onDestroy();
                    i2 = nativeRemoveBLService(16);
                    invokeDeclaredMethodReflect(iService6, RequestParameters.SUBRESOURCE_DELETE, null, null);
                } else if (iService5 != null) {
                    i2 = nativeRemoveBLService(13);
                }
                if (iService5 != null) {
                    invokeDeclaredMethodReflect(iService5, RequestParameters.SUBRESOURCE_DELETE, null, null);
                }
                this.singleServiceList.remove(13);
                this.singleServiceList.remove(16);
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

    public void switchDataPath(ServiceDataPath serviceDataPath) {
        nativeSwitchDataPath(serviceDataPath);
    }

    public void setUnityMainTid(long j) {
        this.unityMainTid = j;
    }

    public boolean setUiLooper(int i, Looper looper) {
        long j = this.unityMainTid;
        if (looper == null) {
            LogUtils.d(String.format("loop is null", new Object[0]));
            return false;
        }
        if (j == 0) {
            j = getTidByLooper(looper);
        }
        LogUtils.d(String.format("setUiLooper threadID=%s", String.valueOf(j)));
        return nativeSetUiLooper(i, looper, j);
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

    public boolean customResPath(String str, String str2) {
        return nativeCustomResPath(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long getTidByLooper(android.os.Looper r8) {
        /*
            r7 = this;
            r0 = 1
            long[] r1 = new long[r0]
            r2 = 0
            r3 = 0
            r1[r2] = r3
            android.os.Looper r3 = android.os.Looper.myLooper()
            if (r3 == 0) goto L4c
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Thread r5 = r3.getThread()
            long r5 = r5.getId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r4[r2] = r5
            java.lang.Thread r5 = r8.getThread()
            long r5 = r5.getId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r4[r0] = r5
            java.lang.String r5 = "setUiLooper curLoop=%s, loop=%s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.autonavi.auto.util.LogUtils.d(r4)
            java.lang.Thread r3 = r3.getThread()
            long r3 = r3.getId()
            java.lang.Thread r5 = r8.getThread()
            long r5 = r5.getId()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L4c
            r3 = r0
            goto L4d
        L4c:
            r3 = r2
        L4d:
            if (r3 == 0) goto L6a
            int r8 = android.os.Process.myTid()
            long r3 = (long) r8
            r1[r2] = r3
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r3 = r1[r2]
            java.lang.String r0 = java.lang.String.valueOf(r3)
            r8[r2] = r0
            java.lang.String r0 = "setUiLooper isSame true threadID=%s"
            java.lang.String r8 = java.lang.String.format(r0, r8)
            com.autonavi.auto.util.LogUtils.d(r8)
            goto La5
        L6a:
            java.util.concurrent.CountDownLatch r3 = new java.util.concurrent.CountDownLatch
            r3.<init>(r0)
            com.autonavi.gbl.servicemanager.ServiceMgr$1 r0 = new com.autonavi.gbl.servicemanager.ServiceMgr$1
            r0.<init>(r8)
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.String r4 = "setUiLooper sendMessage start"
            java.lang.String r8 = java.lang.String.format(r4, r8)
            com.autonavi.auto.util.LogUtils.d(r8)
            android.os.Message r8 = new android.os.Message
            r8.<init>()
            r0.sendMessage(r8)
            java.lang.String r8 = "setUiLooper await start"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.InterruptedException -> La1
            java.lang.String r8 = java.lang.String.format(r8, r0)     // Catch: java.lang.InterruptedException -> La1
            com.autonavi.auto.util.LogUtils.d(r8)     // Catch: java.lang.InterruptedException -> La1
            r3.await()     // Catch: java.lang.InterruptedException -> La1
            java.lang.String r8 = "setUiLooper await end"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.InterruptedException -> La1
            java.lang.String r8 = java.lang.String.format(r8, r0)     // Catch: java.lang.InterruptedException -> La1
            com.autonavi.auto.util.LogUtils.d(r8)     // Catch: java.lang.InterruptedException -> La1
            goto La5
        La1:
            r8 = move-exception
            r8.printStackTrace()
        La5:
            r0 = r1[r2]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.gbl.servicemanager.ServiceMgr.getTidByLooper(android.os.Looper):long");
    }
}
