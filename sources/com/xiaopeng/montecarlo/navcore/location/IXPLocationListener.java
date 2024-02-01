package com.xiaopeng.montecarlo.navcore.location;

import android.location.Location;
import android.os.Bundle;
/* loaded from: classes3.dex */
public interface IXPLocationListener {
    void onGpsStatusChanged(int i);

    void onNmeaReceived(long j, String str);

    void onXPDebugCarLocationChanged(Location location);

    void onXPDebugLocationChanged(Location location);

    void onXPLocationChanged(Location location);

    void onXPProviderDisabled(String str);

    void onXPProviderEnabled(String str);

    void onXPStatusChanged(String str, int i, Bundle bundle);
}
