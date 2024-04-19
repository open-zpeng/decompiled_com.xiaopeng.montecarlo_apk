package com.xiaopeng.montecarlo.navcore.sr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
/* loaded from: classes3.dex */
public interface IXpuDataListener extends IInterface {
    public static final String DESCRIPTOR = "IServerDataListener";
    public static final int TRANSACTION_onReceiveServerData = 10;

    void onDispatchServerData(List<XpuBinderData> list) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IXpuDataListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IXpuDataListener.DESCRIPTOR);
        }

        public static IXpuDataListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IXpuDataListener.DESCRIPTOR);
            return queryLocalInterface instanceof IXpuDataListener ? (IXpuDataListener) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // android.os.Binder
        @RequiresApi(api = 27)
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 10) {
                if (i == 1598968902) {
                    parcel2.writeString(IXpuDataListener.DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(IXpuDataListener.DESCRIPTOR);
            onDispatchServerData(parcel.createTypedArrayList(XpuBinderData.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class Proxy implements IXpuDataListener {
        private final IBinder mRemote;

        Proxy(IBinder iBinder) {
            this.mRemote = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mRemote;
        }

        @Override // com.xiaopeng.montecarlo.navcore.sr.IXpuDataListener
        @RequiresApi(api = 27)
        public void onDispatchServerData(@NonNull List<XpuBinderData> list) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IXpuDataListener.DESCRIPTOR);
                obtain.writeTypedList(list);
                this.mRemote.transact(10, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
