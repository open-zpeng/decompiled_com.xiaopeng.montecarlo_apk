package com.xiaopeng.aftersales;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface IShellCmdListener extends IInterface {
    void onShellResponse(int i, String str, boolean z) throws RemoteException;

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IShellCmdListener {
        private static final String DESCRIPTOR = "com.xiaopeng.aftersales.IShellCmdListener";
        static final int TRANSACTION_onShellResponse = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IShellCmdListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IShellCmdListener)) {
                return (IShellCmdListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onShellResponse(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
                return true;
            } else if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes2.dex */
        private static class Proxy implements IShellCmdListener {
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

            @Override // com.xiaopeng.aftersales.IShellCmdListener
            public void onShellResponse(int i, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
