package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.montecarlo.appengine.FatigueDrivingAssistanceService;
/* loaded from: classes2.dex */
public class FatigueDrivingAssistanceService_Stub extends Binder implements IInterface {
    public FatigueDrivingAssistanceService provider = new FatigueDrivingAssistanceService();
    public FatigueDrivingAssistanceService_Manifest manifest = new FatigueDrivingAssistanceService_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 0) {
            if (i == 1598968902) {
                parcel2.writeString(FatigueDrivingAssistanceService_Manifest.DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(FatigueDrivingAssistanceService_Manifest.DESCRIPTOR);
        try {
            String message = this.provider.getMessage((String) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("param"), "java.lang.String"));
            parcel2.writeNoException();
            TransactTranslator.reply(parcel2, message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            parcel2.writeException(new IllegalStateException(e.getMessage()));
            return true;
        }
    }
}
