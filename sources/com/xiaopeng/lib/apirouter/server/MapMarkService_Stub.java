package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.montecarlo.appengine.MapMarkService;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
/* loaded from: classes2.dex */
public class MapMarkService_Stub extends Binder implements IInterface {
    public MapMarkService provider = new MapMarkService();
    public MapMarkService_Manifest manifest = new MapMarkService_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 0) {
            parcel.enforceInterface(MapMarkService_Manifest.DESCRIPTOR);
            Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                this.provider.drawMark(((Integer) TransactTranslator.read(uri.getQueryParameter("type"), "int")).intValue(), (String) TransactTranslator.read(uri.getQueryParameter("coordinateType"), "java.lang.String"), ((Double) TransactTranslator.read(uri.getQueryParameter(CPSearchParam.PARAM_KEY_LON), "double")).doubleValue(), ((Double) TransactTranslator.read(uri.getQueryParameter(CPSearchParam.PARAM_KEY_LAT), "double")).doubleValue(), ((Double) TransactTranslator.read(uri.getQueryParameter(CompressorStreamFactory.Z), "double")).doubleValue());
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                parcel2.writeException(new IllegalStateException(e.getMessage()));
                return true;
            }
        } else if (i == 1) {
            parcel.enforceInterface(MapMarkService_Manifest.DESCRIPTOR);
            try {
                this.provider.clearMark(((Integer) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("type"), "int")).intValue());
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                parcel2.writeException(new IllegalStateException(e2.getMessage()));
                return true;
            }
        } else if (i != 2) {
            if (i == 1598968902) {
                parcel2.writeString(MapMarkService_Manifest.DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(MapMarkService_Manifest.DESCRIPTOR);
            Uri uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                this.provider.drawMarks(((Integer) TransactTranslator.read(uri2.getQueryParameter("type"), "int")).intValue(), (String) TransactTranslator.read(uri2.getQueryParameter("marks"), "java.lang.String"));
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                parcel2.writeException(new IllegalStateException(e3.getMessage()));
                return true;
            }
        }
    }
}
