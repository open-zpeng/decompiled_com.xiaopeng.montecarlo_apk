package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.montecarlo.service.navi.parser.NaviSpeechParser;
/* loaded from: classes.dex */
public class NaviSpeechParser_Stub extends Binder implements IInterface {
    public NaviSpeechParser provider = new NaviSpeechParser();
    public NaviSpeechParser_Manifest manifest = new NaviSpeechParser_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 0) {
            if (i == 1598968902) {
                parcel2.writeString(NaviSpeechParser_Manifest.DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(NaviSpeechParser_Manifest.DESCRIPTOR);
        try {
            this.provider.handleSpeechCmdFromApiRouter((String) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("content"), "java.lang.String"));
            parcel2.writeNoException();
            TransactTranslator.reply(parcel2, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            parcel2.writeException(new IllegalStateException(e.getMessage()));
            return true;
        }
    }
}
