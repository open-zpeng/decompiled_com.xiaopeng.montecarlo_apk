package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.montecarlo.appengine.GuideInfoService;
/* loaded from: classes2.dex */
public class GuideInfoService_Stub extends Binder implements IInterface {
    public GuideInfoService provider = new GuideInfoService();
    public GuideInfoService_Manifest manifest = new GuideInfoService_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 0) {
            parcel.enforceInterface(GuideInfoService_Manifest.DESCRIPTOR);
            Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                String highWayInfo = this.provider.getHighWayInfo();
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, highWayInfo);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                parcel2.writeException(new IllegalStateException(e.getMessage()));
                return true;
            }
        } else if (i == 1) {
            parcel.enforceInterface(GuideInfoService_Manifest.DESCRIPTOR);
            Uri uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                String congestionInfo = this.provider.getCongestionInfo();
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, congestionInfo);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                parcel2.writeException(new IllegalStateException(e2.getMessage()));
                return true;
            }
        } else if (i == 2) {
            parcel.enforceInterface(GuideInfoService_Manifest.DESCRIPTOR);
            Uri uri3 = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                String currentLocationInfo = this.provider.getCurrentLocationInfo();
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, currentLocationInfo);
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                parcel2.writeException(new IllegalStateException(e3.getMessage()));
                return true;
            }
        } else if (i != 3) {
            if (i == 1598968902) {
                parcel2.writeString(GuideInfoService_Manifest.DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(GuideInfoService_Manifest.DESCRIPTOR);
            Uri uri4 = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                String tBTStatus = this.provider.getTBTStatus();
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, tBTStatus);
                return true;
            } catch (Exception e4) {
                e4.printStackTrace();
                parcel2.writeException(new IllegalStateException(e4.getMessage()));
                return true;
            }
        }
    }
}
