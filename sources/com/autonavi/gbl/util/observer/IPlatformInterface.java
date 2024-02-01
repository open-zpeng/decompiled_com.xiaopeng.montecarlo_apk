package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.model.KeyValue;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.router.PlatformInterfaceRouter;
import java.util.ArrayList;
@IntfAuto(target = PlatformInterfaceRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPlatformInterface {
    String amapDecode(byte[] bArr);

    String amapEncode(byte[] bArr);

    String amapEncodeBinary(byte[] bArr);

    default void copyAssetFile(String str, String str2) {
    }

    boolean getAosNetworkParam(ArrayList<KeyValue> arrayList);

    boolean getAosSign(String str, String[] strArr);

    ArrayList<KeyValue> getCdnNetworkParam();

    float getDensity(int i);

    int getDensityDpi(int i);

    @NetworkStatus.NetworkStatus1
    int getNetStatus();
}
