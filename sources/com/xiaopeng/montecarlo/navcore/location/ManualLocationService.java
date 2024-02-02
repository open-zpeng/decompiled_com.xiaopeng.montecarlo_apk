package com.xiaopeng.montecarlo.navcore.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
/* loaded from: classes2.dex */
public class ManualLocationService {
    private static final String SET_LOCATION_ACTION = "com.xiaopeng.montecarlo.SET_LOCATION_ACTION";
    private static final String SET_LOCATION_ACTION_PARA_LAT = "LAT";
    private static final String SET_LOCATION_ACTION_PARA_LON = "LON";
    private static final L.Tag TAG = new L.Tag("ManualLocationService");
    private Context mContext;
    private IMapDelegate mMapDelegate;

    public ManualLocationService(Context context, IMapDelegate iMapDelegate) {
        this.mContext = context;
        this.mMapDelegate = iMapDelegate;
        if (iMapDelegate == null) {
            L.w(TAG, "null == mapDelegate");
        }
    }

    public void setCarLocation(Location location) {
        LocationServiceManager.getInstance().updateLocationGCJ02(location);
    }

    public void enableBroadCast() {
        if (RootUtil.isUserVersion()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SET_LOCATION_ACTION);
        if (this.mContext != null) {
            L.i(TAG, "registerReceiver: com.xiaopeng.montecarlo.SET_LOCATION_ACTION");
            this.mContext.registerReceiver(new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.navcore.location.ManualLocationService.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (ManualLocationService.SET_LOCATION_ACTION.equals(intent.getAction())) {
                        float floatExtra = intent.getFloatExtra(ManualLocationService.SET_LOCATION_ACTION_PARA_LAT, 23.159586f);
                        float floatExtra2 = intent.getFloatExtra(ManualLocationService.SET_LOCATION_ACTION_PARA_LON, 113.38508f);
                        L.Tag tag = ManualLocationService.TAG;
                        L.i(tag, "received location: " + floatExtra + ", " + floatExtra2);
                        Location location = new Location("gps");
                        double d = (double) floatExtra;
                        location.setLatitude(d);
                        double d2 = (double) floatExtra2;
                        location.setLongitude(d2);
                        LocationServiceManager.getInstance().updateLocationGCJ02(location);
                        if (ManualLocationService.this.mMapDelegate != null) {
                            CarLoc carLoc = new CarLoc();
                            PathMatchInfo pathMatchInfo = new PathMatchInfo();
                            pathMatchInfo.longitude = d2;
                            pathMatchInfo.latitude = d;
                            carLoc.vecPathMatchInfo.add(pathMatchInfo);
                            ManualLocationService.this.mMapDelegate.moveMapCenter(carLoc);
                        }
                    }
                }
            }, intentFilter);
        }
    }
}
