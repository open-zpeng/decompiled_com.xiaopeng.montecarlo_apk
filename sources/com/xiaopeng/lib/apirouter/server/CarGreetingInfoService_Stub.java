package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.xiaopeng.montecarlo.appengine.CarGreetingInfoService;
/* loaded from: classes.dex */
public class CarGreetingInfoService_Stub extends Binder implements IInterface {
    public CarGreetingInfoService provider = new CarGreetingInfoService();
    public CarGreetingInfoService_Manifest manifest = new CarGreetingInfoService_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 0) {
            parcel.enforceInterface(CarGreetingInfoService_Manifest.DESCRIPTOR);
            try {
                this.provider.setActiveState(((Boolean) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("activeState"), TypedValues.Custom.S_BOOLEAN)).booleanValue());
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                parcel2.writeException(new IllegalStateException(e.getMessage()));
                return true;
            }
        } else if (i == 1) {
            parcel.enforceInterface(CarGreetingInfoService_Manifest.DESCRIPTOR);
            try {
                this.provider.getAroundTrafficInfo(((Integer) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("ratioScale"), "int")).intValue());
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                parcel2.writeException(new IllegalStateException(e2.getMessage()));
                return true;
            }
        } else if (i == 2) {
            parcel.enforceInterface(CarGreetingInfoService_Manifest.DESCRIPTOR);
            try {
                this.provider.onMoveSearchBar(((Boolean) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("isDownMove"), TypedValues.Custom.S_BOOLEAN)).booleanValue());
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                parcel2.writeException(new IllegalStateException(e3.getMessage()));
                return true;
            }
        } else if (i == 3) {
            parcel.enforceInterface(CarGreetingInfoService_Manifest.DESCRIPTOR);
            Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                this.provider.clearRenderRoutes();
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e4) {
                e4.printStackTrace();
                parcel2.writeException(new IllegalStateException(e4.getMessage()));
                return true;
            }
        } else if (i != 4) {
            if (i == 1598968902) {
                parcel2.writeString(CarGreetingInfoService_Manifest.DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(CarGreetingInfoService_Manifest.DESCRIPTOR);
            try {
                this.provider.renderRoutes((String) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("endInfoData"), "java.lang.String"));
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e5) {
                e5.printStackTrace();
                parcel2.writeException(new IllegalStateException(e5.getMessage()));
                return true;
            }
        }
    }
}
