package com.xiaopeng.aftersales;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.aftersales.IAlertListener;
import com.xiaopeng.aftersales.IAuthModeListener;
import com.xiaopeng.aftersales.IEncryptShListener;
import com.xiaopeng.aftersales.ILogicActionListener;
import com.xiaopeng.aftersales.ILogicTreeUpgrader;
import com.xiaopeng.aftersales.IRepairModeListener;
import com.xiaopeng.aftersales.IShellCmdListener;
/* loaded from: classes2.dex */
public interface IAfterSalesManager extends IInterface {
    void disableAuthMode() throws RemoteException;

    void disableRepairMode() throws RemoteException;

    void enableAuthMode(String str, long j) throws RemoteException;

    void enableRepairMode() throws RemoteException;

    void enableRepairModeWithKey(String str) throws RemoteException;

    void enableRepairModeWithKeyId(String str) throws RemoteException;

    void executeEncryptSh(String str, boolean z) throws RemoteException;

    void executeShellCmd(int i, String str, boolean z) throws RemoteException;

    void executeShellCmdWithLimitLine(int i, String str, int i2, String str2, boolean z) throws RemoteException;

    long getAuthEndTime() throws RemoteException;

    boolean getAuthMode() throws RemoteException;

    String getAuthPass() throws RemoteException;

    boolean getRepairMode() throws RemoteException;

    String getRepairModeDisableTime() throws RemoteException;

    String getRepairModeEnableTime() throws RemoteException;

    String getRepairModeKeyId() throws RemoteException;

    String getSpeedLimitDisableTime() throws RemoteException;

    String getSpeedLimitEnableTime() throws RemoteException;

    boolean getSpeedLimitMode() throws RemoteException;

    void recordDiagnosisError(int i, int i2, long j, String str, boolean z) throws RemoteException;

    void recordLogicAction(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws RemoteException;

    void recordRepairmodeAction(String str, String str2) throws RemoteException;

    void recordSpeedLimitOff() throws RemoteException;

    void recordSpeedLimitOn() throws RemoteException;

    void registerAlertListener(IAlertListener iAlertListener) throws RemoteException;

    void registerAuthModeListener(IAuthModeListener iAuthModeListener) throws RemoteException;

    void registerEncryptShListener(IEncryptShListener iEncryptShListener) throws RemoteException;

    void registerLogicActionListener(ILogicActionListener iLogicActionListener) throws RemoteException;

    void registerLogicTreeUpgrader(ILogicTreeUpgrader iLogicTreeUpgrader) throws RemoteException;

    void registerRepairModeListener(IRepairModeListener iRepairModeListener) throws RemoteException;

    void registerShellCmdListener(IShellCmdListener iShellCmdListener) throws RemoteException;

    void requestUpgradeLogicTree(String str) throws RemoteException;

    void requestUploadLogicAction() throws RemoteException;

    void unregisterAlertListener(IAlertListener iAlertListener) throws RemoteException;

    void unregisterAuthModeListener(IAuthModeListener iAuthModeListener) throws RemoteException;

    void unregisterEncryptShListener(IEncryptShListener iEncryptShListener) throws RemoteException;

    void unregisterLogicActionListener(ILogicActionListener iLogicActionListener) throws RemoteException;

    void unregisterLogicTreeUpgrader(ILogicTreeUpgrader iLogicTreeUpgrader) throws RemoteException;

    void unregisterRepairModeListener(IRepairModeListener iRepairModeListener) throws RemoteException;

    void unregisterShellCmdListener(IShellCmdListener iShellCmdListener) throws RemoteException;

    void updateDiagnosisUploadStatus(int i, boolean z, int i2, long j, String str) throws RemoteException;

    void updateLogicActionUploadStatus(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7) throws RemoteException;

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IAfterSalesManager {
        private static final String DESCRIPTOR = "com.xiaopeng.aftersales.IAfterSalesManager";
        static final int TRANSACTION_disableAuthMode = 37;
        static final int TRANSACTION_disableRepairMode = 16;
        static final int TRANSACTION_enableAuthMode = 36;
        static final int TRANSACTION_enableRepairMode = 13;
        static final int TRANSACTION_enableRepairModeWithKey = 14;
        static final int TRANSACTION_enableRepairModeWithKeyId = 15;
        static final int TRANSACTION_executeEncryptSh = 33;
        static final int TRANSACTION_executeShellCmd = 29;
        static final int TRANSACTION_executeShellCmdWithLimitLine = 30;
        static final int TRANSACTION_getAuthEndTime = 40;
        static final int TRANSACTION_getAuthMode = 38;
        static final int TRANSACTION_getAuthPass = 39;
        static final int TRANSACTION_getRepairMode = 17;
        static final int TRANSACTION_getRepairModeDisableTime = 19;
        static final int TRANSACTION_getRepairModeEnableTime = 18;
        static final int TRANSACTION_getRepairModeKeyId = 23;
        static final int TRANSACTION_getSpeedLimitDisableTime = 22;
        static final int TRANSACTION_getSpeedLimitEnableTime = 21;
        static final int TRANSACTION_getSpeedLimitMode = 20;
        static final int TRANSACTION_recordDiagnosisError = 1;
        static final int TRANSACTION_recordLogicAction = 5;
        static final int TRANSACTION_recordRepairmodeAction = 28;
        static final int TRANSACTION_recordSpeedLimitOff = 25;
        static final int TRANSACTION_recordSpeedLimitOn = 24;
        static final int TRANSACTION_registerAlertListener = 3;
        static final int TRANSACTION_registerAuthModeListener = 41;
        static final int TRANSACTION_registerEncryptShListener = 34;
        static final int TRANSACTION_registerLogicActionListener = 9;
        static final int TRANSACTION_registerLogicTreeUpgrader = 11;
        static final int TRANSACTION_registerRepairModeListener = 26;
        static final int TRANSACTION_registerShellCmdListener = 31;
        static final int TRANSACTION_requestUpgradeLogicTree = 8;
        static final int TRANSACTION_requestUploadLogicAction = 7;
        static final int TRANSACTION_unregisterAlertListener = 4;
        static final int TRANSACTION_unregisterAuthModeListener = 42;
        static final int TRANSACTION_unregisterEncryptShListener = 35;
        static final int TRANSACTION_unregisterLogicActionListener = 10;
        static final int TRANSACTION_unregisterLogicTreeUpgrader = 12;
        static final int TRANSACTION_unregisterRepairModeListener = 27;
        static final int TRANSACTION_unregisterShellCmdListener = 32;
        static final int TRANSACTION_updateDiagnosisUploadStatus = 2;
        static final int TRANSACTION_updateLogicActionUploadStatus = 6;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAfterSalesManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IAfterSalesManager)) {
                return (IAfterSalesManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    recordDiagnosisError(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateDiagnosisUploadStatus(parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAlertListener(IAlertListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAlertListener(IAlertListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    recordLogicAction(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateLogicActionUploadStatus(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestUploadLogicAction();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestUpgradeLogicTree(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerLogicActionListener(ILogicActionListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterLogicActionListener(ILogicActionListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerLogicTreeUpgrader(ILogicTreeUpgrader.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterLogicTreeUpgrader(ILogicTreeUpgrader.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    enableRepairMode();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    enableRepairModeWithKey(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    enableRepairModeWithKeyId(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    disableRepairMode();
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean repairMode = getRepairMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(repairMode ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    String repairModeEnableTime = getRepairModeEnableTime();
                    parcel2.writeNoException();
                    parcel2.writeString(repairModeEnableTime);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    String repairModeDisableTime = getRepairModeDisableTime();
                    parcel2.writeNoException();
                    parcel2.writeString(repairModeDisableTime);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean speedLimitMode = getSpeedLimitMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(speedLimitMode ? 1 : 0);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    String speedLimitEnableTime = getSpeedLimitEnableTime();
                    parcel2.writeNoException();
                    parcel2.writeString(speedLimitEnableTime);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    String speedLimitDisableTime = getSpeedLimitDisableTime();
                    parcel2.writeNoException();
                    parcel2.writeString(speedLimitDisableTime);
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    String repairModeKeyId = getRepairModeKeyId();
                    parcel2.writeNoException();
                    parcel2.writeString(repairModeKeyId);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    recordSpeedLimitOn();
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    recordSpeedLimitOff();
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerRepairModeListener(IRepairModeListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterRepairModeListener(IRepairModeListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    recordRepairmodeAction(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    executeShellCmd(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    executeShellCmdWithLimitLine(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerShellCmdListener(IShellCmdListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterShellCmdListener(IShellCmdListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    executeEncryptSh(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerEncryptShListener(IEncryptShListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterEncryptShListener(IEncryptShListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    enableAuthMode(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    disableAuthMode();
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean authMode = getAuthMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(authMode ? 1 : 0);
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    String authPass = getAuthPass();
                    parcel2.writeNoException();
                    parcel2.writeString(authPass);
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    long authEndTime = getAuthEndTime();
                    parcel2.writeNoException();
                    parcel2.writeLong(authEndTime);
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAuthModeListener(IAuthModeListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAuthModeListener(IAuthModeListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes2.dex */
        private static class Proxy implements IAfterSalesManager {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void recordDiagnosisError(int i, int i2, long j, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void updateDiagnosisUploadStatus(int i, boolean z, int i2, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void registerAlertListener(IAlertListener iAlertListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAlertListener != null ? iAlertListener.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void unregisterAlertListener(IAlertListener iAlertListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAlertListener != null ? iAlertListener.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void recordLogicAction(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeString(str6);
                    obtain.writeString(str7);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void updateLogicActionUploadStatus(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeString(str6);
                    obtain.writeString(str7);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void requestUploadLogicAction() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void requestUpgradeLogicTree(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void registerLogicActionListener(ILogicActionListener iLogicActionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iLogicActionListener != null ? iLogicActionListener.asBinder() : null);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void unregisterLogicActionListener(ILogicActionListener iLogicActionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iLogicActionListener != null ? iLogicActionListener.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void registerLogicTreeUpgrader(ILogicTreeUpgrader iLogicTreeUpgrader) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iLogicTreeUpgrader != null ? iLogicTreeUpgrader.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void unregisterLogicTreeUpgrader(ILogicTreeUpgrader iLogicTreeUpgrader) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iLogicTreeUpgrader != null ? iLogicTreeUpgrader.asBinder() : null);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void enableRepairMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void enableRepairModeWithKey(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void enableRepairModeWithKeyId(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void disableRepairMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public boolean getRepairMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public String getRepairModeEnableTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public String getRepairModeDisableTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public boolean getSpeedLimitMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public String getSpeedLimitEnableTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public String getSpeedLimitDisableTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public String getRepairModeKeyId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void recordSpeedLimitOn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void recordSpeedLimitOff() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void registerRepairModeListener(IRepairModeListener iRepairModeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRepairModeListener != null ? iRepairModeListener.asBinder() : null);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void unregisterRepairModeListener(IRepairModeListener iRepairModeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRepairModeListener != null ? iRepairModeListener.asBinder() : null);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void recordRepairmodeAction(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void executeShellCmd(int i, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void executeShellCmdWithLimitLine(int i, String str, int i2, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void registerShellCmdListener(IShellCmdListener iShellCmdListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iShellCmdListener != null ? iShellCmdListener.asBinder() : null);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void unregisterShellCmdListener(IShellCmdListener iShellCmdListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iShellCmdListener != null ? iShellCmdListener.asBinder() : null);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void executeEncryptSh(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void registerEncryptShListener(IEncryptShListener iEncryptShListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEncryptShListener != null ? iEncryptShListener.asBinder() : null);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void unregisterEncryptShListener(IEncryptShListener iEncryptShListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEncryptShListener != null ? iEncryptShListener.asBinder() : null);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void enableAuthMode(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void disableAuthMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public boolean getAuthMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public String getAuthPass() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public long getAuthEndTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void registerAuthModeListener(IAuthModeListener iAuthModeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAuthModeListener != null ? iAuthModeListener.asBinder() : null);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.aftersales.IAfterSalesManager
            public void unregisterAuthModeListener(IAuthModeListener iAuthModeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAuthModeListener != null ? iAuthModeListener.asBinder() : null);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
