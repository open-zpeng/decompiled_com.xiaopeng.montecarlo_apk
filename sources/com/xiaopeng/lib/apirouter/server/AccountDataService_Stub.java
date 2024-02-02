package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.montecarlo.appengine.AccountDataService;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes2.dex */
public class AccountDataService_Stub extends Binder implements IInterface {
    public AccountDataService provider = new AccountDataService();
    public AccountDataService_Manifest manifest = new AccountDataService_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 0) {
            parcel.enforceInterface(AccountDataService_Manifest.DESCRIPTOR);
            Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                String accountId = this.provider.getAccountId();
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, accountId);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                parcel2.writeException(new IllegalStateException(e.getMessage()));
                return true;
            }
        } else if (i == 1) {
            parcel.enforceInterface(AccountDataService_Manifest.DESCRIPTOR);
            Uri uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                String accountOpenId = this.provider.getAccountOpenId();
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, accountOpenId);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                parcel2.writeException(new IllegalStateException(e2.getMessage()));
                return true;
            }
        } else if (i == 2) {
            parcel.enforceInterface(AccountDataService_Manifest.DESCRIPTOR);
            Uri uri3 = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                String accountSid = this.provider.getAccountSid();
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, accountSid);
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                parcel2.writeException(new IllegalStateException(e3.getMessage()));
                return true;
            }
        } else if (i != 3) {
            if (i == 1598968902) {
                parcel2.writeString(AccountDataService_Manifest.DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(AccountDataService_Manifest.DESCRIPTOR);
            try {
                String dataVersion = this.provider.getDataVersion(((Integer) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter(LocationUtils.DR_RECORD_TAG_DATA_TYPE), "int")).intValue());
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, dataVersion);
                return true;
            } catch (Exception e4) {
                e4.printStackTrace();
                parcel2.writeException(new IllegalStateException(e4.getMessage()));
                return true;
            }
        }
    }
}
