package com.xiaopeng.montecarlo.navcore.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.xiaopeng.lib.utils.view.ToastUtils;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class LocationServiceManager implements LocationListener, GpsStatus.Listener, OnNmeaMessageListener {
    private static final String EXTRA_GPS_ENABLED = "enabled";
    private static final boolean GPS_DISABLED_FLAG = false;
    private static final String GPS_ENABLED_CHANGE = "android.location.GPS_ENABLED_CHANGE";
    private static final boolean GPS_ENABLED_DEFAULT_STATUS = true;
    private static final boolean GPS_ENABLED_FLAG = true;
    public static final int XP_GPS_LOCATION_CUSTOM_CAR_STATE = 4;
    public static final int XP_GPS_LOCATION_SAVE_STATE = 1;
    public static final int XP_GPS_LOCATION_SIMULATE_STATE = 2;
    public static final int XP_GPS_LOCATION_SOCKET_STATE = 3;
    public static final int XP_GPS_LOCATION_STATE = 0;
    private ManualLocationService mCarLocationService;
    private Context mContext;
    private XPLocation mCurrentLocation;
    private String mFileDir;
    @Nullable
    private LocationManager mLocationManager;
    private IMapDelegate mMapDelegate;
    private SimulatedLogLocationService mSimulatedLocationService;
    private SocketLocationService mXPLocationSocketService;
    private static final LocationServiceManager sInstance = new LocationServiceManager();
    private static final L.Tag TAG = new L.Tag("LocationServiceManager");
    @NonNull
    private List<IXPLocationListener> mXPLocationChangeListeners = new CopyOnWriteArrayList();
    private int mCurrentStatus = 0;
    private volatile boolean mInitialized = false;
    private BroadcastReceiver mGpsEnabledStatusReceiver = new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.navcore.location.LocationServiceManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (LocationServiceManager.GPS_ENABLED_CHANGE.equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("enabled", true);
                L.Tag tag = LocationServiceManager.TAG;
                L.w(tag, "gps enabled change flag: " + booleanExtra);
                if (booleanExtra) {
                    return;
                }
                L.w(LocationServiceManager.TAG, "Gps off!");
                if (LocationServiceManager.this.mInitialized) {
                    LocationServiceManager.this.mGPSHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.location.LocationServiceManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LocationServiceManager.this.reInit();
                        }
                    });
                }
            }
        }
    };
    private final Handler mGPSHandler = new Handler(WorkThreadUtil.getInstance().getLocationThreadLooper());

    private LocationServiceManager() {
    }

    @NonNull
    public static LocationServiceManager getInstance() {
        return sInstance;
    }

    private void registerGpsStatusBroadcast(BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(GPS_ENABLED_CHANGE);
        ContextUtils.getContext().registerReceiver(broadcastReceiver, intentFilter);
    }

    private void unRegisterGpsStatusBroadcast(BroadcastReceiver broadcastReceiver) {
        ContextUtils.getContext().unregisterReceiver(broadcastReceiver);
    }

    @MainThread
    public void init(@NonNull Context context, @NonNull String str) {
        if (this.mInitialized) {
            return;
        }
        this.mInitialized = true;
        this.mFileDir = str;
        this.mContext = context;
        registerGpsStatusBroadcast(this.mGpsEnabledStatusReceiver);
        this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        if (this.mLocationManager == null) {
            throw new IllegalArgumentException("Init LocationServiceManager getSystemService(Context.LOCATION_SERVICE is null!");
        }
        if (ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            L.w(TAG, ">>> Init LocationServiceManager permission check fail");
            return;
        }
        XPLocation xPLocation = new XPLocation();
        xPLocation.setTypeWGS84(true);
        xPLocation.setLocation(this.mLocationManager.getLastKnownLocation("gps"));
        if (xPLocation.getLocation() == null) {
            Location location = new Location("gps");
            location.setLongitude(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LON, 113385075L) / 1000000.0d);
            location.setLatitude(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LAT, 23159586L) / 1000000.0d);
            xPLocation.setTypeWGS84(false);
            xPLocation.setLocation(location);
        }
        this.mCurrentLocation = xPLocation;
        this.mGPSHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.location.-$$Lambda$LocationServiceManager$VUgTchqPtONLy_jb6QJJYo1RzZw
            @Override // java.lang.Runnable
            public final void run() {
                LocationServiceManager.this.lambda$init$0$LocationServiceManager();
            }
        });
        this.mLocationManager.requestLocationUpdates("gps", 1000L, 0.0f, this, WorkThreadUtil.getInstance().getLocationThreadLooper());
        initDebugXPLocationState();
    }

    public /* synthetic */ void lambda$init$0$LocationServiceManager() {
        LocationManager locationManager = this.mLocationManager;
        if (locationManager != null) {
            locationManager.addGpsStatusListener(this);
            this.mLocationManager.addNmeaListener(this, new Handler(WorkThreadUtil.getInstance().getLocationThreadLooper()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reInit() {
        this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        if (this.mLocationManager == null) {
            throw new IllegalArgumentException("reInit LocationServiceManager getSystemService(Context.LOCATION_SERVICE is null!");
        }
        if (ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            L.w(TAG, ">>> reInit LocationServiceManager permission check fail");
            return;
        }
        XPLocation xPLocation = new XPLocation();
        xPLocation.setTypeWGS84(true);
        xPLocation.setLocation(this.mLocationManager.getLastKnownLocation("gps"));
        if (xPLocation.getLocation() == null) {
            Location location = new Location("gps");
            location.setLongitude(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LON, 113385075L) / 1000000.0d);
            location.setLatitude(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LAT, 23159586L) / 1000000.0d);
            xPLocation.setTypeWGS84(false);
            xPLocation.setLocation(location);
        }
        this.mCurrentLocation = xPLocation;
        this.mLocationManager.addGpsStatusListener(this);
        this.mLocationManager.addNmeaListener(this);
        this.mLocationManager.requestLocationUpdates("gps", 1000L, 0.0f, this, WorkThreadUtil.getInstance().getLocationThreadLooper());
    }

    public void addXPLocationListener(IXPLocationListener iXPLocationListener) {
        CollectionUtils.listAdd(this.mXPLocationChangeListeners, iXPLocationListener);
    }

    public void removeXPLocationListener(IXPLocationListener iXPLocationListener) {
        if (iXPLocationListener != null) {
            this.mXPLocationChangeListeners.remove(iXPLocationListener);
        }
    }

    public void updateLocation(@NonNull Location location) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> updateLocation location = " + location.toString() + " mCurrentStatus = " + this.mCurrentStatus);
        }
        updateOrRenewCurrentLocation(true, location);
        for (IXPLocationListener iXPLocationListener : this.mXPLocationChangeListeners) {
            if (iXPLocationListener != null) {
                if (4 == this.mCurrentStatus) {
                    iXPLocationListener.onXPDebugCarLocationChanged(location);
                } else {
                    iXPLocationListener.onXPDebugLocationChanged(location);
                }
            }
        }
    }

    public void updateLocationGCJ02(@NonNull Location location) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> updateLocationGCJ02 location = " + location.toString() + " mCurrentStatus = " + this.mCurrentStatus);
        }
        updateOrRenewCurrentLocation(false, location);
        for (IXPLocationListener iXPLocationListener : this.mXPLocationChangeListeners) {
            if (iXPLocationListener != null) {
                if (4 == this.mCurrentStatus) {
                    iXPLocationListener.onXPDebugCarLocationChanged(location);
                } else {
                    iXPLocationListener.onXPDebugLocationChanged(location);
                }
            }
        }
    }

    public void setCarLocation(Location location) {
        ManualLocationService manualLocationService = this.mCarLocationService;
        if (manualLocationService != null) {
            manualLocationService.setCarLocation(location);
        }
    }

    private void initDebugXPLocationState() {
        if (RootUtil.isLogcatEnabled() && RootUtil.isWriteLogToFile() && DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_RECORD_SET_LOCATION, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_RECORD_SET_LOCATION)) {
            startXPLocationState(1);
            this.mCurrentStatus = 1;
        }
    }

    public void startXPLocationState(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>>startXPLocationState=" + i);
        }
        checkState(this.mCurrentStatus);
        this.mCurrentStatus = i;
        int i2 = this.mCurrentStatus;
        if (i2 == 1) {
            if (this.mSimulatedLocationService == null) {
                this.mSimulatedLocationService = new SimulatedLogLocationService(this.mFileDir);
            }
        } else if (i2 == 2) {
            if (this.mSimulatedLocationService == null) {
                this.mSimulatedLocationService = new SimulatedLogLocationService(this.mFileDir);
            }
            this.mSimulatedLocationService.startDebugLocationSimulate();
        } else if (i2 == 3) {
            if (this.mXPLocationSocketService == null) {
                this.mXPLocationSocketService = new SocketLocationService();
            }
            this.mXPLocationSocketService.startServerSocket();
        } else if (i2 != 4) {
        } else {
            if (this.mCarLocationService == null) {
                this.mCarLocationService = new ManualLocationService(this.mContext, this.mMapDelegate);
                this.mCarLocationService.enableBroadCast();
            }
            ToastUtils.showToast(this.mContext, "请点击地图上任意位置为自车位置！！！");
        }
    }

    public void stopXPLocationState(int i) {
        checkState(i);
        this.mCurrentStatus = 0;
    }

    public void stopAll() {
        checkState(1);
        checkState(2);
        checkState(3);
        checkState(4);
        this.mCurrentStatus = 0;
    }

    public int getCurrentStatus() {
        return this.mCurrentStatus;
    }

    public XPLocation getCurrentLocation() {
        return this.mCurrentLocation;
    }

    public float getLocationSpeed() {
        XPLocation xPLocation = this.mCurrentLocation;
        if (xPLocation == null || xPLocation.getLocation() == null) {
            return 0.0f;
        }
        return this.mCurrentLocation.getLocation().getSpeed() * 3.6f;
    }

    private void checkState(int i) {
        SocketLocationService socketLocationService;
        if (i == -1 || i == 1) {
            return;
        }
        if (i != 2) {
            if (i == 3 && (socketLocationService = this.mXPLocationSocketService) != null) {
                socketLocationService.stopServerSocket();
                return;
            }
            return;
        }
        SimulatedLogLocationService simulatedLogLocationService = this.mSimulatedLocationService;
        if (simulatedLogLocationService != null) {
            simulatedLogLocationService.stopDebugLocationSimulate();
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(@NonNull Location location) {
        int i;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onLocationChanged location=" + location.toString() + " mCurrentStatus=" + this.mCurrentStatus);
        }
        updateOrRenewCurrentLocation(true, location);
        for (IXPLocationListener iXPLocationListener : this.mXPLocationChangeListeners) {
            if (iXPLocationListener != null && ((i = this.mCurrentStatus) == 0 || 1 == i)) {
                iXPLocationListener.onXPLocationChanged(location);
            }
        }
        SimulatedLogLocationService simulatedLogLocationService = this.mSimulatedLocationService;
        if (simulatedLogLocationService == null || 1 != this.mCurrentStatus) {
            return;
        }
        simulatedLogLocationService.saveLocationToSdcard(location);
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        int i2;
        for (IXPLocationListener iXPLocationListener : this.mXPLocationChangeListeners) {
            if (iXPLocationListener != null && ((i2 = this.mCurrentStatus) == 0 || 1 == i2)) {
                iXPLocationListener.onXPStatusChanged(str, i, bundle);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        int i;
        for (IXPLocationListener iXPLocationListener : this.mXPLocationChangeListeners) {
            if (iXPLocationListener != null && ((i = this.mCurrentStatus) == 0 || 1 == i)) {
                iXPLocationListener.onXPProviderEnabled(str);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        int i;
        for (IXPLocationListener iXPLocationListener : this.mXPLocationChangeListeners) {
            if (iXPLocationListener != null && ((i = this.mCurrentStatus) == 0 || 1 == i)) {
                iXPLocationListener.onXPProviderDisabled(str);
            }
        }
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        int i2;
        if (2 == i) {
            L.Tag tag = TAG;
            L.w(tag, "Gps is stopped:" + i);
        }
        for (IXPLocationListener iXPLocationListener : this.mXPLocationChangeListeners) {
            if (iXPLocationListener != null && ((i2 = this.mCurrentStatus) == 0 || i2 == 1)) {
                iXPLocationListener.onGpsStatusChanged(i);
            }
        }
    }

    public void onMockNmeaMessage(String str, long j, long j2) {
        int i;
        if (TextUtils.isEmpty(str) || !NmeaSentence.isValidSentence(str)) {
            return;
        }
        for (IXPLocationListener iXPLocationListener : this.mXPLocationChangeListeners) {
            if (iXPLocationListener != null && ((i = this.mCurrentStatus) == 0 || i == 1)) {
                iXPLocationListener.onMockNmeaReceived(j, str, j2);
            }
        }
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        int i;
        if (TextUtils.isEmpty(str) || !NmeaSentence.isValidSentence(str)) {
            return;
        }
        for (IXPLocationListener iXPLocationListener : this.mXPLocationChangeListeners) {
            if (iXPLocationListener != null && ((i = this.mCurrentStatus) == 0 || i == 1)) {
                iXPLocationListener.onNmeaReceived(j, str);
            }
        }
    }

    @NonNull
    public Coord2DDouble getCurrentLonLat() {
        Coord3DDouble encryptLonLat;
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        XPLocation currentLocation = getInstance().getCurrentLocation();
        if (currentLocation != null && currentLocation.getLocation() != null) {
            coord2DDouble.lon = currentLocation.getLocation().getLongitude();
            coord2DDouble.lat = currentLocation.getLocation().getLatitude();
            if (currentLocation.isTypeWGS84() && (encryptLonLat = TBTManager.getInstance().getPosServiceWrapper().encryptLonLat(currentLocation.getLocation())) != null) {
                coord2DDouble.lon = encryptLonLat.lon;
                coord2DDouble.lat = encryptLonLat.lat;
            }
        } else {
            long j = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LON, 113385075L);
            long j2 = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LAT, 23159586L);
            coord2DDouble.lon = j / 1000000.0d;
            coord2DDouble.lat = j2 / 1000000.0d;
        }
        return coord2DDouble;
    }

    public void setMapDelegate(IMapDelegate iMapDelegate) {
        this.mMapDelegate = iMapDelegate;
    }

    private void updateOrRenewCurrentLocation(boolean z, Location location) {
        if (Boolean.compare(this.mCurrentLocation.isTypeWGS84(), z) == 0) {
            this.mCurrentLocation.setLocation(location);
            return;
        }
        XPLocation xPLocation = new XPLocation();
        xPLocation.setTypeWGS84(z);
        xPLocation.setLocation(location);
        this.mCurrentLocation = xPLocation;
    }
}
