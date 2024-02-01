package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.montecarlo.appengine.SearchService;
/* loaded from: classes.dex */
public class SearchService_Stub extends Binder implements IInterface {
    public SearchService provider = new SearchService();
    public SearchService_Manifest manifest = new SearchService_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 0) {
            if (i == 1598968902) {
                parcel2.writeString(SearchService_Manifest.DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(SearchService_Manifest.DESCRIPTOR);
        Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
        try {
            String searchByBL = this.provider.searchByBL((String) TransactTranslator.read(uri.getQueryParameter("requestJson"), "java.lang.String"), (String) TransactTranslator.read(uri.getQueryParameter("callbackUri"), "java.lang.String"));
            parcel2.writeNoException();
            TransactTranslator.reply(parcel2, searchByBL);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            parcel2.writeException(new IllegalStateException(e.getMessage()));
            return true;
        }
    }
}
