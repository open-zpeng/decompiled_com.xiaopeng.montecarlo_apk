package com.dingtalk.mars.stn;

import com.dingtalk.mars.Mars;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class StnLogic {
    public static final int CONNECTED = 4;
    public static final int CONNECTTING = 3;
    public static int ECHECK_NEVER = 2;
    public static int ECHECK_NEXT = 1;
    public static int ECHECK_NOW = 0;
    public static final int GATEWAY_FAILED = 1;
    public static final int INVALID_TASK_ID = -1;
    public static final int NETWORK_UNAVAILABLE = 0;
    public static final int NETWORK_UNKNOWN = -1;
    public static int RESP_FAIL_HANDLE_DEFAULT = -1;
    public static int RESP_FAIL_HANDLE_NORMAL = 0;
    public static int RESP_FAIL_HANDLE_SESSION_TIMEOUT = -13;
    public static int RESP_FAIL_HANDLE_TASK_END = -14;
    public static final int SERVER_DOWN = 5;
    public static final int SERVER_FAILED = 2;
    public static final String TAG = "bifrost.StnLogic";
    private static ICallBack callBack = null;
    public static final int ectDial = 2;
    public static final int ectDns = 3;
    public static final int ectEnDecode = 7;
    public static final int ectFalse = 1;
    public static final int ectHttp = 5;
    public static final int ectLocal = 9;
    public static final int ectNetMsgXP = 6;
    public static final int ectOK = 0;
    public static final int ectServer = 8;
    public static final int ectSocket = 4;

    /* loaded from: classes2.dex */
    public interface ICallBack {
        int buf2Resp(int i, Object obj, byte[] bArr, byte[] bArr2, int[] iArr, int i2);

        int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr);

        boolean isLogoned();

        boolean makesureAuthed();

        boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2);

        String[] onNewDns(String str);

        void onPush(long j, int i, int i2, byte[] bArr, byte[] bArr2);

        int onTaskEnd(int i, Object obj, int i2, int i3);

        void reportConnectInfo(int i, int i2);

        void reportTaskProfile(String str);

        boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr, int i2);

        void requestDoSync();

        String[] requestNetCheckShortLinkHosts();

        void trafficData(int i, int i2);
    }

    public static native void clearTask();

    private static native ArrayList<String> getLoadLibraries();

    public static native boolean hasTask(int i);

    public static native void keepSignalling();

    public static native void makesureLongLinkConnected();

    public static native void redoTask();

    public static native void reset();

    public static native void setBackupIPs(String str, String[] strArr);

    public static native void setDebugIP(String str, String str2);

    public static native void setLonglinkSvrAddr(String str, int[] iArr, String str2);

    public static native void setProductID(short s);

    public static native void setShortlinkSvrAddr(int i, String str);

    public static native void setSignallingStrategy(long j, long j2);

    public static native void startTask(Task task);

    public static native void stopSignalling();

    public static native void stopTask(int i);

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

    /* loaded from: classes2.dex */
    public static class Task {
        public static final int EBoth = 3;
        public static final int EFAST = 1;
        public static final int ELong = 2;
        public static final int ENORMAL = 0;
        public static final int EShort = 1;
        public static final int ETASK_PRIORITY_0 = 0;
        public static final int ETASK_PRIORITY_1 = 1;
        public static final int ETASK_PRIORITY_2 = 2;
        public static final int ETASK_PRIORITY_3 = 3;
        public static final int ETASK_PRIORITY_4 = 4;
        public static final int ETASK_PRIORITY_5 = 5;
        public static final int ETASK_PRIORITY_HIGHEST = 0;
        public static final int ETASK_PRIORITY_LOWEST = 5;
        public static final int ETASK_PRIORITY_NORMAL = 3;
        private static AtomicInteger ai = new AtomicInteger(0);
        public String cgi;
        public int channelSelect;
        public int channelStrategy;
        public int cmdID;
        public boolean limitFlow;
        public boolean limitFrequency;
        public boolean needAuthed;
        public boolean networkStatusSensitive;
        public int priority;
        public String reportArg;
        public int retryCount;
        public boolean sendOnly;
        public int serverProcessCost;
        public ArrayList<String> shortLinkHostList;
        public int taskID;
        public int totalTimeout;
        public Object userContext;

        public Task() {
            this.retryCount = -1;
            this.taskID = ai.incrementAndGet();
        }

        public Task(int i, int i2, String str, ArrayList<String> arrayList) {
            this.retryCount = -1;
            this.taskID = ai.incrementAndGet();
            this.channelSelect = i;
            this.cmdID = i2;
            this.cgi = str;
            this.shortLinkHostList = arrayList;
            this.sendOnly = false;
            this.needAuthed = true;
            this.limitFlow = true;
            this.limitFrequency = true;
            this.channelStrategy = 0;
            this.networkStatusSensitive = false;
            this.priority = 3;
            this.retryCount = -1;
            this.serverProcessCost = 0;
            this.totalTimeout = 0;
            this.userContext = null;
        }
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    public static void setLonglinkSvrAddr(String str, int[] iArr) {
        setLonglinkSvrAddr(str, iArr, null);
    }

    public static void setShortlinkSvrAddr(int i) {
        setShortlinkSvrAddr(i, null);
    }

    private static String exception2String(Exception exc) {
        return exc.toString();
    }

    private static boolean makesureAuthed() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return false;
        }
        return iCallBack.makesureAuthed();
    }

    private static String[] onNewDns(String str) {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.onNewDns(str);
    }

    private static void onPush(long j, int i, int i2, byte[] bArr, byte[] bArr2) {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return;
        }
        iCallBack.onPush(j, i, i2, bArr, bArr2);
    }

    private static boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr, int i2) {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return false;
        }
        return iCallBack.req2Buf(i, obj, byteArrayOutputStream, byteArrayOutputStream2, iArr, i2);
    }

    private static int buf2Resp(int i, Object obj, byte[] bArr, byte[] bArr2, int[] iArr, int i2) {
        ICallBack iCallBack = callBack;
        return iCallBack == null ? RESP_FAIL_HANDLE_TASK_END : iCallBack.buf2Resp(i, obj, bArr, bArr2, iArr, i2);
    }

    private static int onTaskEnd(int i, Object obj, int i2, int i3) {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return 0;
        }
        return iCallBack.onTaskEnd(i, obj, i2, i3);
    }

    private static void reportTaskProfile(String str) {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return;
        }
        iCallBack.reportTaskProfile(str);
    }

    private static void reportConnectStatus(int i, int i2) {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return;
        }
        iCallBack.reportConnectInfo(i, i2);
    }

    private static int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr) {
        ICallBack iCallBack = callBack;
        return iCallBack == null ? ECHECK_NEVER : iCallBack.getLongLinkIdentifyCheckBuffer(byteArrayOutputStream, byteArrayOutputStream2, iArr);
    }

    private static boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2) {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return false;
        }
        return iCallBack.onLongLinkIdentifyResp(bArr, bArr2);
    }

    private static void trafficData(int i, int i2) {
        ICallBack iCallBack = callBack;
        if (iCallBack != null) {
            iCallBack.trafficData(i, i2);
        }
    }

    private static String[] requestNetCheckShortLinkHosts() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.requestNetCheckShortLinkHosts();
    }

    public static void requestDoSync() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return;
        }
        iCallBack.requestDoSync();
    }

    public static boolean isLogoned() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return false;
        }
        return iCallBack.isLogoned();
    }
}
