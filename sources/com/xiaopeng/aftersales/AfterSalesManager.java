package com.xiaopeng.aftersales;

import android.content.Context;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.android.internal.util.Preconditions;
import com.xiaopeng.aftersales.IAlertListener;
import com.xiaopeng.aftersales.IAuthModeListener;
import com.xiaopeng.aftersales.IEncryptShListener;
import com.xiaopeng.aftersales.ILogicActionListener;
import com.xiaopeng.aftersales.ILogicTreeUpgrader;
import com.xiaopeng.aftersales.IRepairModeListener;
import com.xiaopeng.aftersales.IShellCmdListener;
/* loaded from: classes2.dex */
public class AfterSalesManager {
    public static final int CMD_TYPE_CAT = 2;
    public static final int CMD_TYPE_COMMON = 0;
    public static final int CMD_TYPE_DF = 3;
    public static final int CMD_TYPE_DU = 5;
    public static final int CMD_TYPE_GETPROP = 1;
    public static final int CMD_TYPE_IFCONFIG = 9;
    public static final int CMD_TYPE_LS_AL = 8;
    public static final int CMD_TYPE_MOUNT = 4;
    public static final int CMD_TYPE_TOP_CPU = 6;
    public static final int CMD_TYPE_TOP_MEM = 7;
    public static final int ERROR_CODE_MODULE_4G = 10;
    public static final int ERROR_CODE_MODULE_AUDIO = 1;
    public static final int ERROR_CODE_MODULE_BLUETOOTH = 3;
    public static final int ERROR_CODE_MODULE_CAMERA = 2;
    public static final int ERROR_CODE_MODULE_CARSERVICE = 14;
    public static final int ERROR_CODE_MODULE_ICM_AUDIO = 17;
    public static final int ERROR_CODE_MODULE_ICM_ETH = 18;
    public static final int ERROR_CODE_MODULE_ICM_LCD = 16;
    public static final int ERROR_CODE_MODULE_ICM_SYSTEM = 19;
    public static final int ERROR_CODE_MODULE_LCD = 8;
    public static final int ERROR_CODE_MODULE_LIBHTTP = 6;
    public static final int ERROR_CODE_MODULE_NAVI = 9;
    public static final int ERROR_CODE_MODULE_PHY = 15;
    public static final int ERROR_CODE_MODULE_PM = 12;
    public static final int ERROR_CODE_MODULE_PSO = 5;
    public static final int ERROR_CODE_MODULE_SOC = 7;
    public static final int ERROR_CODE_MODULE_UFS = 11;
    public static final int ERROR_CODE_MODULE_USB = 13;
    public static final int ERROR_CODE_MODULE_WIFI = 4;
    public static final int MAX_ERROR_CODE_MODULE = 19;
    public static final int RESULT_FAIL = 0;
    public static final int RESULT_KEEP = 2;
    public static final int RESULT_PASS = 1;
    public static final int RESULT_UNKNOWN = -1;
    public static final String SERVICE_NAME = "xiaopeng_aftersales";
    private static final String TAG = "AfterSalesManager";
    private IAfterSalesManager mAfterSalesService;
    private Context mContext;
    private final ArrayMap<AlertListener, IAlertListener> mAlertListeners = new ArrayMap<>();
    private final ArrayMap<RepairModeListener, IRepairModeListener> mRepairModeListeners = new ArrayMap<>();
    private final ArrayMap<ShellCmdListener, IShellCmdListener> mShellCmdListeners = new ArrayMap<>();
    private final ArrayMap<EncryptShListener, IEncryptShListener> mEncryptShListeners = new ArrayMap<>();
    private final ArrayMap<AuthModeListener, IAuthModeListener> mAuthModeListeners = new ArrayMap<>();
    private final ArrayMap<LogicActionListener, ILogicActionListener> mLogicActionListeners = new ArrayMap<>();
    private final ArrayMap<LogicTreeUpgrader, ILogicTreeUpgrader> mLogicTreeUpgraders = new ArrayMap<>();

    public AfterSalesManager(Context context, IAfterSalesManager iAfterSalesManager) {
        this.mContext = context;
        this.mAfterSalesService = iAfterSalesManager;
    }

    public void addAlertListener(final AlertListener alertListener) {
        IAlertListener.Stub stub = new IAlertListener.Stub() { // from class: com.xiaopeng.aftersales.AfterSalesManager.1
            @Override // com.xiaopeng.aftersales.IAlertListener
            public void alertDiagnosisError(int i, int i2, long j, String str) throws RemoteException {
                alertListener.alertDiagnosisError(i, i2, j, str);
            }
        };
        try {
            this.mAfterSalesService.registerAlertListener(stub);
            this.mAlertListeners.put(alertListener, stub);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void removeAlertListener(AlertListener alertListener) {
        IAlertListener iAlertListener = this.mAlertListeners.get(alertListener);
        Preconditions.checkArgument(iAlertListener != null, "AlertListener was not registered.");
        try {
            this.mAfterSalesService.unregisterAlertListener(iAlertListener);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void recordDiagnosisError(int i, int i2, long j, String str, boolean z) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.recordDiagnosisError(i, i2, j, str, z);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void updateDiagnosisUploadStatus(int i, boolean z, int i2, long j, String str) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.updateDiagnosisUploadStatus(i, z, i2, j, str);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void addLogicActionListener(final LogicActionListener logicActionListener) {
        ILogicActionListener.Stub stub = new ILogicActionListener.Stub() { // from class: com.xiaopeng.aftersales.AfterSalesManager.2
            @Override // com.xiaopeng.aftersales.ILogicActionListener
            public void uploadLogicAction(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws RemoteException {
                logicActionListener.uploadLogicAction(str, str2, str3, str4, str5, str6, str7);
            }
        };
        try {
            this.mAfterSalesService.registerLogicActionListener(stub);
            this.mLogicActionListeners.put(logicActionListener, stub);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void removeLogicActionListener(LogicActionListener logicActionListener) {
        ILogicActionListener iLogicActionListener = this.mLogicActionListeners.get(logicActionListener);
        Preconditions.checkArgument(iLogicActionListener != null, "LogicActionListener was not registered.");
        try {
            this.mAfterSalesService.unregisterLogicActionListener(iLogicActionListener);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void recordLogicAction(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.recordLogicAction(str, str2, str3, str4, str5, str6, str7);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void updateLogicActionUploadStatus(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.updateLogicActionUploadStatus(z, str, str2, str3, str4, str5, str6, str7);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void requestUploadLogicAction() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.requestUploadLogicAction();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void requestUpgradeLogicTree(String str) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.requestUpgradeLogicTree(str);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void addLogicTreeUpgrader(final LogicTreeUpgrader logicTreeUpgrader) {
        ILogicTreeUpgrader.Stub stub = new ILogicTreeUpgrader.Stub() { // from class: com.xiaopeng.aftersales.AfterSalesManager.3
            @Override // com.xiaopeng.aftersales.ILogicTreeUpgrader
            public void onUpgradeStatus(boolean z) throws RemoteException {
                logicTreeUpgrader.onUpgradeStatus(z);
            }
        };
        try {
            this.mAfterSalesService.registerLogicTreeUpgrader(stub);
            this.mLogicTreeUpgraders.put(logicTreeUpgrader, stub);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void removeLogicTreeUpgrader(LogicTreeUpgrader logicTreeUpgrader) {
        ILogicTreeUpgrader iLogicTreeUpgrader = this.mLogicTreeUpgraders.get(logicTreeUpgrader);
        Preconditions.checkArgument(iLogicTreeUpgrader != null, "LogicTreeUpgrader was not registered.");
        try {
            this.mAfterSalesService.unregisterLogicTreeUpgrader(iLogicTreeUpgrader);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void recordRepairModeAction(String str, String str2) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.recordRepairmodeAction(str, str2);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void enableRepairMode() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.enableRepairMode();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void enableRepairModeWithKey(String str) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.enableRepairModeWithKey(str);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void enableRepairModeWithKeyId(String str) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.enableRepairModeWithKeyId(str);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void disableRepairMode() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.disableRepairMode();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public boolean getRepairMode() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getRepairMode();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return false;
    }

    public String getRepairModeEnableTime() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getRepairModeEnableTime();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return null;
    }

    public String getRepairModeDisableTime() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getRepairModeDisableTime();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return null;
    }

    public boolean getSpeedLimitMode() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getSpeedLimitMode();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return false;
    }

    public String getSpeedLimitEnableTime() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getSpeedLimitEnableTime();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return null;
    }

    public String getSpeedLimitDisableTime() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getSpeedLimitDisableTime();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return null;
    }

    public String getRepairModeKeyId() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getRepairModeKeyId();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return null;
    }

    public void recordSpeedLimitOn() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.recordSpeedLimitOn();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void recordSpeedLimitOff() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.recordSpeedLimitOff();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void registerRepairModeListener(final RepairModeListener repairModeListener) {
        IRepairModeListener.Stub stub = new IRepairModeListener.Stub() { // from class: com.xiaopeng.aftersales.AfterSalesManager.4
            @Override // com.xiaopeng.aftersales.IRepairModeListener
            public void onRepairModeChanged(boolean z, int i) throws RemoteException {
                repairModeListener.onRepairModeChanged(z, i);
            }
        };
        try {
            this.mAfterSalesService.registerRepairModeListener(stub);
            this.mRepairModeListeners.put(repairModeListener, stub);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void unregisterRepairModeListener(RepairModeListener repairModeListener) {
        IRepairModeListener iRepairModeListener = this.mRepairModeListeners.get(repairModeListener);
        Preconditions.checkArgument(iRepairModeListener != null, "RepairModeListener was not registered.");
        try {
            this.mAfterSalesService.unregisterRepairModeListener(iRepairModeListener);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void executeShellCmd(int i, String str, boolean z) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.executeShellCmd(i, str, z);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void executeShellCmdWithLimitLine(int i, String str, int i2, String str2, boolean z) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.executeShellCmdWithLimitLine(i, str, i2, str2, z);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void registerShellCmdListener(final ShellCmdListener shellCmdListener) {
        IShellCmdListener.Stub stub = new IShellCmdListener.Stub() { // from class: com.xiaopeng.aftersales.AfterSalesManager.5
            @Override // com.xiaopeng.aftersales.IShellCmdListener
            public void onShellResponse(int i, String str, boolean z) throws RemoteException {
                shellCmdListener.onShellResponse(i, str, z);
            }
        };
        try {
            this.mAfterSalesService.registerShellCmdListener(stub);
            this.mShellCmdListeners.put(shellCmdListener, stub);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void unregisterShellCmdListener(ShellCmdListener shellCmdListener) {
        IShellCmdListener iShellCmdListener = this.mShellCmdListeners.get(shellCmdListener);
        Preconditions.checkArgument(iShellCmdListener != null, "ShellCmdListener was not registered.");
        try {
            this.mAfterSalesService.unregisterShellCmdListener(iShellCmdListener);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void executeEncryptSh(String str, boolean z) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.executeEncryptSh(str, z);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void registerEncryptShListener(final EncryptShListener encryptShListener) {
        IEncryptShListener.Stub stub = new IEncryptShListener.Stub() { // from class: com.xiaopeng.aftersales.AfterSalesManager.6
            @Override // com.xiaopeng.aftersales.IEncryptShListener
            public void onEncryptShResponse(int i, String str, String str2, boolean z) throws RemoteException {
                encryptShListener.onEncryptShResponse(i, str, str2, z);
            }
        };
        try {
            this.mAfterSalesService.registerEncryptShListener(stub);
            this.mEncryptShListeners.put(encryptShListener, stub);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void unregisterEncryptShListener(EncryptShListener encryptShListener) {
        IEncryptShListener iEncryptShListener = this.mEncryptShListeners.get(encryptShListener);
        Preconditions.checkArgument(iEncryptShListener != null, "EncryptShListener was not registered.");
        try {
            this.mAfterSalesService.unregisterEncryptShListener(iEncryptShListener);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void enableAuthMode(String str, long j) {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.enableAuthMode(str, j);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public void disableAuthMode() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                iAfterSalesManager.disableAuthMode();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public boolean getAuthMode() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getAuthMode();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return false;
    }

    public String getAuthPass() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getAuthPass();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return null;
    }

    public long getAuthEndTime() {
        IAfterSalesManager iAfterSalesManager = this.mAfterSalesService;
        if (iAfterSalesManager != null) {
            try {
                return iAfterSalesManager.getAuthEndTime();
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        return -1L;
    }

    public void registerAuthModeListener(final AuthModeListener authModeListener) {
        IAuthModeListener.Stub stub = new IAuthModeListener.Stub() { // from class: com.xiaopeng.aftersales.AfterSalesManager.7
            @Override // com.xiaopeng.aftersales.IAuthModeListener
            public void onAuthModeChanged(boolean z, int i) throws RemoteException {
                authModeListener.onAuthModeChanged(z, i);
            }
        };
        try {
            this.mAfterSalesService.registerAuthModeListener(stub);
            this.mAuthModeListeners.put(authModeListener, stub);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void unregisterAuthModeListener(AuthModeListener authModeListener) {
        IAuthModeListener iAuthModeListener = this.mAuthModeListeners.get(authModeListener);
        Preconditions.checkArgument(iAuthModeListener != null, "AuthModeListener was not registered.");
        try {
            this.mAfterSalesService.unregisterAuthModeListener(iAuthModeListener);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }
}
