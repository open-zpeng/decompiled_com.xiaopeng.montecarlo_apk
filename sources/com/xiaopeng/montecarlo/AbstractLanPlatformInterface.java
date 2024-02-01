package com.xiaopeng.montecarlo;

import android.app.Application;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.util.model.KeyValue;
import com.autonavi.gbl.util.observer.IPlatformInterface;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AbstractLanPlatformInterface implements IPlatformInterface {
    protected static final L.Tag TAG = new L.Tag("AbstractLanPlatformInterface");
    protected Application mContext;

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public String amapDecode(byte[] bArr) {
        return null;
    }

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public String amapEncode(byte[] bArr) {
        return null;
    }

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public String amapEncodeBinary(byte[] bArr) {
        return null;
    }

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public void copyAssetFile(String str, String str2) {
    }

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public boolean getAosSign(String str, String[] strArr) {
        return false;
    }

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public float getDensity(int i) {
        return 1080.0f;
    }

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public int getDensityDpi(int i) {
        return 320;
    }

    public void setContext(@NonNull Application application) {
        this.mContext = application;
    }

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public int getNetStatus() {
        return getNetWorkType();
    }

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public ArrayList<KeyValue> getCdnNetworkParam() {
        ArrayList<KeyValue> arrayList = new ArrayList<>();
        arrayList.add(new KeyValue("diu", NavCoreUtil.getDiu()));
        arrayList.add(new KeyValue("client_network_class", "4"));
        Coord2DDouble currentLonLat = LocationServiceManager.getInstance().getCurrentLonLat();
        arrayList.add(new KeyValue(CPSearchParam.PARAM_KEY_LON, currentLonLat.lon + ""));
        arrayList.add(new KeyValue(CPSearchParam.PARAM_KEY_LAT, currentLonLat.lat + ""));
        return arrayList;
    }

    @Override // com.autonavi.gbl.util.observer.IPlatformInterface
    public boolean getAosNetworkParam(ArrayList<KeyValue> arrayList) {
        arrayList.add(new KeyValue("diu", NavCoreUtil.getDiu()));
        arrayList.add(new KeyValue("client_network_class", "4"));
        arrayList.add(new KeyValue("os", "android"));
        arrayList.add(new KeyValue("dip", "19300"));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.AbstractLanPlatformInterface$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType = new int[XPNetworkManager.XPNetworkType.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_TBOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static int getNetWorkType() {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.INSTANCE.getNetworkType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 6 : 2;
            }
            return 5;
        }
        return 1;
    }
}
