package com.xiaopeng.montecarlo.navcore.sr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.montecarlo.navcore.sr.IXpuDataListener;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public interface IXpuBinderDataProvider extends IInterface {
    public static final String DESCRIPTOR = "IBinderDataProvider";
    public static final int TRANSAVTION_notify_connection_ready = 1;
    public static final int TRANSAVTION_register_data_listener = 2;
    public static final int TRANSAVTION_unregister_data_listener = 3;

    void notifyConnectionReady() throws RemoteException;

    void registerListener(int i, IXpuDataListener iXpuDataListener) throws RemoteException;

    void unregisterListener(int i, IXpuDataListener iXpuDataListener) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IXpuBinderDataProvider {
        private static final L.Tag TAG = new L.Tag(Stub.class.getSimpleName());

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IXpuBinderDataProvider.DESCRIPTOR);
        }

        public static IXpuBinderDataProvider asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IXpuBinderDataProvider.DESCRIPTOR);
            if (queryLocalInterface instanceof IXpuBinderDataProvider) {
                L.i(TAG, "asInterface is IBinderDataProvider");
                return (IXpuBinderDataProvider) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            L.Tag tag = TAG;
            L.i(tag, "onTransact code:" + i);
            if (i == 1) {
                parcel.enforceInterface(IXpuBinderDataProvider.DESCRIPTOR);
                notifyConnectionReady();
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(IXpuBinderDataProvider.DESCRIPTOR);
                registerListener(parcel.readInt(), IXpuDataListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(IXpuBinderDataProvider.DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel.enforceInterface(IXpuBinderDataProvider.DESCRIPTOR);
                unregisterListener(parcel.readInt(), IXpuDataListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Proxy implements IXpuBinderDataProvider {
        private final IBinder mRemote;

        Proxy(IBinder iBinder) {
            this.mRemote = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mRemote;
        }

        @Override // com.xiaopeng.montecarlo.navcore.sr.IXpuBinderDataProvider
        public void registerListener(int i, IXpuDataListener iXpuDataListener) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IXpuBinderDataProvider.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeStrongBinder(iXpuDataListener != null ? iXpuDataListener.asBinder() : null);
                this.mRemote.transact(2, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.sr.IXpuBinderDataProvider
        public void unregisterListener(int i, IXpuDataListener iXpuDataListener) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IXpuBinderDataProvider.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeStrongBinder(iXpuDataListener != null ? iXpuDataListener.asBinder() : null);
                this.mRemote.transact(3, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.sr.IXpuBinderDataProvider
        public void notifyConnectionReady() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IXpuBinderDataProvider.DESCRIPTOR);
                this.mRemote.transact(1, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
