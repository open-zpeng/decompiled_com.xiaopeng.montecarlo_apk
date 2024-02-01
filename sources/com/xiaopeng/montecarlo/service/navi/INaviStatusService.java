package com.xiaopeng.montecarlo.service.navi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes3.dex */
public interface INaviStatusService extends IInterface {
    int getCarRemainDistance() throws RemoteException;

    float getCarSpeed() throws RemoteException;

    String getCommonAddress(String str) throws RemoteException;

    int getCurrentMapScaleLevel() throws RemoteException;

    String getCurrentSceneName(boolean z) throws RemoteException;

    String getEndPointName() throws RemoteException;

    int getEndRemainDist() throws RemoteException;

    int getEndRemainTime() throws RemoteException;

    String getHighWayInfo() throws RemoteException;

    int getMapMode() throws RemoteException;

    String getNavigationInfo() throws RemoteException;

    String getSettingInfo() throws RemoteException;

    String getViaPointName(int i) throws RemoteException;

    int getViaPointSize() throws RemoteException;

    int getViaPointType(int i) throws RemoteException;

    int getViaRemainDist(int i) throws RemoteException;

    int getViaRemainTime(int i) throws RemoteException;

    boolean isCruise() throws RemoteException;

    boolean isExplore() throws RemoteException;

    boolean isLaneMode() throws RemoteException;

    boolean isNavi() throws RemoteException;

    boolean isOpenOverViewMode() throws RemoteException;

    boolean isRoute() throws RemoteException;

    boolean isZoomInMax() throws RemoteException;

    boolean isZoomOutMin() throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements INaviStatusService {
        private static final String DESCRIPTOR = "com.xiaopeng.montecarlo.service.navi.INaviStatusService";
        static final int TRANSACTION_getCarRemainDistance = 13;
        static final int TRANSACTION_getCarSpeed = 14;
        static final int TRANSACTION_getCommonAddress = 15;
        static final int TRANSACTION_getCurrentMapScaleLevel = 25;
        static final int TRANSACTION_getCurrentSceneName = 20;
        static final int TRANSACTION_getEndPointName = 10;
        static final int TRANSACTION_getEndRemainDist = 11;
        static final int TRANSACTION_getEndRemainTime = 12;
        static final int TRANSACTION_getHighWayInfo = 21;
        static final int TRANSACTION_getMapMode = 23;
        static final int TRANSACTION_getNavigationInfo = 16;
        static final int TRANSACTION_getSettingInfo = 24;
        static final int TRANSACTION_getViaPointName = 6;
        static final int TRANSACTION_getViaPointSize = 5;
        static final int TRANSACTION_getViaPointType = 7;
        static final int TRANSACTION_getViaRemainDist = 8;
        static final int TRANSACTION_getViaRemainTime = 9;
        static final int TRANSACTION_isCruise = 1;
        static final int TRANSACTION_isExplore = 2;
        static final int TRANSACTION_isLaneMode = 4;
        static final int TRANSACTION_isNavi = 3;
        static final int TRANSACTION_isOpenOverViewMode = 22;
        static final int TRANSACTION_isRoute = 19;
        static final int TRANSACTION_isZoomInMax = 17;
        static final int TRANSACTION_isZoomOutMin = 18;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INaviStatusService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof INaviStatusService)) {
                return (INaviStatusService) queryLocalInterface;
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
                    boolean isCruise = isCruise();
                    parcel2.writeNoException();
                    parcel2.writeInt(isCruise ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isExplore = isExplore();
                    parcel2.writeNoException();
                    parcel2.writeInt(isExplore ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isNavi = isNavi();
                    parcel2.writeNoException();
                    parcel2.writeInt(isNavi ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isLaneMode = isLaneMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(isLaneMode ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    int viaPointSize = getViaPointSize();
                    parcel2.writeNoException();
                    parcel2.writeInt(viaPointSize);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    String viaPointName = getViaPointName(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(viaPointName);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int viaPointType = getViaPointType(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(viaPointType);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int viaRemainDist = getViaRemainDist(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(viaRemainDist);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int viaRemainTime = getViaRemainTime(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(viaRemainTime);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    String endPointName = getEndPointName();
                    parcel2.writeNoException();
                    parcel2.writeString(endPointName);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    int endRemainDist = getEndRemainDist();
                    parcel2.writeNoException();
                    parcel2.writeInt(endRemainDist);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    int endRemainTime = getEndRemainTime();
                    parcel2.writeNoException();
                    parcel2.writeInt(endRemainTime);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    int carRemainDistance = getCarRemainDistance();
                    parcel2.writeNoException();
                    parcel2.writeInt(carRemainDistance);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    float carSpeed = getCarSpeed();
                    parcel2.writeNoException();
                    parcel2.writeFloat(carSpeed);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    String commonAddress = getCommonAddress(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(commonAddress);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    String navigationInfo = getNavigationInfo();
                    parcel2.writeNoException();
                    parcel2.writeString(navigationInfo);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isZoomInMax = isZoomInMax();
                    parcel2.writeNoException();
                    parcel2.writeInt(isZoomInMax ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isZoomOutMin = isZoomOutMin();
                    parcel2.writeNoException();
                    parcel2.writeInt(isZoomOutMin ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isRoute = isRoute();
                    parcel2.writeNoException();
                    parcel2.writeInt(isRoute ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    String currentSceneName = getCurrentSceneName(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeString(currentSceneName);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    String highWayInfo = getHighWayInfo();
                    parcel2.writeNoException();
                    parcel2.writeString(highWayInfo);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isOpenOverViewMode = isOpenOverViewMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(isOpenOverViewMode ? 1 : 0);
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    int mapMode = getMapMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(mapMode);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    String settingInfo = getSettingInfo();
                    parcel2.writeNoException();
                    parcel2.writeString(settingInfo);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    int currentMapScaleLevel = getCurrentMapScaleLevel();
                    parcel2.writeNoException();
                    parcel2.writeInt(currentMapScaleLevel);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes3.dex */
        private static class Proxy implements INaviStatusService {
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

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public boolean isCruise() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public boolean isExplore() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public boolean isNavi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public boolean isLaneMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public int getViaPointSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public String getViaPointName(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public int getViaPointType(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public int getViaRemainDist(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public int getViaRemainTime(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public String getEndPointName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public int getEndRemainDist() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public int getEndRemainTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public int getCarRemainDistance() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public float getCarSpeed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public String getCommonAddress(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public String getNavigationInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public boolean isZoomInMax() throws RemoteException {
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

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public boolean isZoomOutMin() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public boolean isRoute() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public String getCurrentSceneName(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public String getHighWayInfo() throws RemoteException {
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

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public boolean isOpenOverViewMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public int getMapMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public String getSettingInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.montecarlo.service.navi.INaviStatusService
            public int getCurrentMapScaleLevel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
