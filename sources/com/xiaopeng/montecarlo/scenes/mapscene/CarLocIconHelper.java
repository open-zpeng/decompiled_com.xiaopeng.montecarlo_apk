package com.xiaopeng.montecarlo.scenes.mapscene;

import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.mapdisplay.ICarLocIconHelper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes2.dex */
public class CarLocIconHelper implements ICarLocIconHelper, CarServiceManager.IXPCarStateListener, ISRInfoChangedListener {
    private static final int BATTERY_DANGER_LEVEL = 2;
    private static final int BATTERY_LEVEL_INVALID = -1;
    private static final int BATTERY_NORMAL_LEVEL = 0;
    private static final int BATTERY_WARNING_LEVEL = 1;
    private static final int MSG_UPDATE = 0;
    private static final int REMAIN_DIST_30 = 30000;
    private static final int REMAIN_DIST_60 = 60000;
    private static final L.Tag TAG = new L.Tag("CarLocIconHelper");
    private static final int TICK_TIME = 1000;
    private MapViewWrapper mMapViewWrapper;
    private volatile int mScuDriveMode;
    private volatile CarServiceManager.XPolitDriveMode mXPolitDriveMode;
    private int mBatteryLevel = -1;
    private SparseArray<MarkUtils.MapTextureResource> mCarLocList = new SparseArray<>();
    private volatile boolean mIsStart = false;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.xiaopeng.montecarlo.scenes.mapscene.CarLocIconHelper.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            CarLocIconHelper.this.updateCarLocIconDynamicOnRun();
        }
    };
    private CharSequence[] mCarLogoKeys = ContextUtils.getContext().getResources().getTextArray(R.array.set_car_logo_key_arr);
    private TypedArray mCarIconNormalArray = ContextUtils.getContext().getResources().obtainTypedArray(R.array.set_car_logo_scr_arr);
    private TypedArray mCarIconAccArray = ContextUtils.getContext().getResources().obtainTypedArray(R.array.set_car_logo_scr_arr_acc_arr);
    private TypedArray mCarIconLccArray = ContextUtils.getContext().getResources().obtainTypedArray(R.array.set_car_logo_scr_arr_lcc_arr);
    private TypedArray mCarIconNgpArray = ContextUtils.getContext().getResources().obtainTypedArray(R.array.set_car_logo_scr_arr_ngp_arr);
    private TypedArray mCarIconNormal3dArray = ContextUtils.getContext().getResources().obtainTypedArray(R.array.set_car_logo_scr_3d_arr);
    private TypedArray mCarIconAcc3dArray = ContextUtils.getContext().getResources().obtainTypedArray(R.array.set_car_logo_scr_arr_3d_acc_arr);
    private TypedArray mCarIconLcc3dArray = ContextUtils.getContext().getResources().obtainTypedArray(R.array.set_car_logo_scr_arr_3d_lcc_arr);
    private TypedArray mCarIconNgp3dArray = ContextUtils.getContext().getResources().obtainTypedArray(R.array.set_car_logo_scr_arr_3d_ngp_arr);

    private int getRemainDistLevel(int i) {
        if (i <= 30000) {
            return 2;
        }
        return i <= 60000 ? 1 : 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnergyRecycleLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onHVACPowerModeChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmConnectionStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapDisplayStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapFpsChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapSizeChange(int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onImuNavDataChange(float[] fArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXpuNedcStatusChange(int i) {
    }

    public CarLocIconHelper(@NonNull MapViewWrapper mapViewWrapper) {
        this.mXPolitDriveMode = CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_NONE;
        this.mScuDriveMode = 1;
        this.mMapViewWrapper = null;
        this.mMapViewWrapper = mapViewWrapper;
        this.mXPolitDriveMode = CarServiceManager.getInstance().getXPolitDriveMode();
        this.mScuDriveMode = SRNaviManager.getInstance().getDriveMode();
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.ICarLocIconHelper
    @MainThread
    public void start() {
        CarServiceManager.getInstance().addCarStateListener(this);
        SRNaviManager.getInstance().addSRInfoChangedListener(this);
        this.mIsStart = true;
        int remainDistLevel = getRemainDistLevel(CarServiceManager.getInstance().getCarRemainDistance());
        CarServiceManager.XPolitDriveMode xPolitDriveMode = CarServiceManager.getInstance().getXPolitDriveMode();
        int driveMode = SRNaviManager.getInstance().getDriveMode();
        if (remainDistLevel != this.mBatteryLevel || driveMode != this.mScuDriveMode || xPolitDriveMode != this.mXPolitDriveMode) {
            this.mBatteryLevel = remainDistLevel;
            this.mXPolitDriveMode = xPolitDriveMode;
            this.mScuDriveMode = driveMode;
            updateCarLocIconDynamic();
        }
        L.Tag tag = TAG;
        L.i(tag, " start:" + this.mBatteryLevel + " " + this.mBatteryLevel);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.ICarLocIconHelper
    @MainThread
    public void stop() {
        L.i(TAG, " stop");
        CarServiceManager.getInstance().removeCarStateListener(this);
        SRNaviManager.getInstance().removeSRInfoChangedListener(this);
        this.mIsStart = false;
        SparseArray<MarkUtils.MapTextureResource> sparseArray = this.mCarLocList;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    private int getResId(int i) {
        return ThemeWatcherUtil.getDrawableResId(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void updateCarLocIconDynamicOnRun() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.mMapViewWrapper == null) {
            L.e(TAG, "mapView wrapper is null!");
            return;
        }
        this.mCarLocList.clear();
        String carLogo = SettingWrapper.getCarLogo();
        int i5 = -1;
        if (CollectionUtils.isNotEmpty(this.mCarLogoKeys)) {
            int i6 = 0;
            i = -1;
            while (true) {
                CharSequence[] charSequenceArr = this.mCarLogoKeys;
                if (i6 >= charSequenceArr.length) {
                    break;
                }
                if (charSequenceArr[i6].equals(carLogo)) {
                    i = i6;
                }
                i6++;
            }
        } else {
            i = -1;
        }
        L.i(TAG, "updateCarLocIconDynamicOnRun:mScuDriveMode=" + this.mScuDriveMode + " mXPolitDriveMode = " + this.mXPolitDriveMode + " mBatteryLevel=" + this.mBatteryLevel + "carLogo=" + carLogo + " matchIndex=" + i + " engineId=" + this.mMapViewWrapper.getMainEngineID());
        if (i <= 0) {
            i2 = -1;
        } else if (5 == this.mScuDriveMode || 6 == this.mScuDriveMode) {
            i2 = ThemeWatcherUtil.getDrawableResId(this.mCarIconNgpArray.getResourceId(i, -1));
            i5 = ThemeWatcherUtil.getDrawableResId(this.mCarIconNgp3dArray.getResourceId(i, -1));
        } else {
            int i7 = AnonymousClass2.$SwitchMap$com$xiaopeng$montecarlo$root$carservice$CarServiceManager$XPolitDriveMode[this.mXPolitDriveMode.ordinal()];
            if (i7 == 1) {
                i2 = ThemeWatcherUtil.getDrawableResId(this.mCarIconLccArray.getResourceId(i, -1));
                i5 = ThemeWatcherUtil.getDrawableResId(this.mCarIconLcc3dArray.getResourceId(i, -1));
            } else if (i7 == 2) {
                i2 = ThemeWatcherUtil.getDrawableResId(this.mCarIconAccArray.getResourceId(i, -1));
                i5 = ThemeWatcherUtil.getDrawableResId(this.mCarIconAcc3dArray.getResourceId(i, -1));
            } else {
                i2 = ThemeWatcherUtil.getDrawableResId(this.mCarIconNormalArray.getResourceId(i, -1));
                i5 = ThemeWatcherUtil.getDrawableResId(this.mCarIconNormal3dArray.getResourceId(i, -1));
            }
        }
        if (i2 < 0 || i5 < 0 || i <= 0) {
            if (5 == this.mScuDriveMode || 6 == this.mScuDriveMode) {
                int i8 = this.mBatteryLevel;
                if (i8 == 0) {
                    i3 = R.drawable.png_ic_xlarge_carlocation_normal_ngp;
                    i4 = R.drawable.png_ic_xlarge_carlocation_normal_3d_ngp;
                } else if (i8 != 1) {
                    if (i8 == 2) {
                        i3 = R.drawable.png_ic_xlarge_carlocation_danger_ngp;
                        i4 = R.drawable.png_ic_xlarge_carlocation_danger_3d_ngp;
                    }
                    L.e(TAG, "get resource error ! carid:" + i2 + "  car3did:" + i5);
                } else {
                    i3 = R.drawable.png_ic_xlarge_carlocation_warning_ngp;
                    i4 = R.drawable.png_ic_xlarge_carlocation_warning_3d_ngp;
                }
                i2 = i3;
                i5 = i4;
                L.e(TAG, "get resource error ! carid:" + i2 + "  car3did:" + i5);
            } else if (CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_LCC == this.mXPolitDriveMode) {
                int i9 = this.mBatteryLevel;
                if (i9 == 0) {
                    i3 = R.drawable.png_ic_xlarge_carlocation_normal_lcc;
                    i4 = R.drawable.png_ic_xlarge_carlocation_normal_3d_lcc;
                } else if (i9 != 1) {
                    if (i9 == 2) {
                        i3 = R.drawable.png_ic_xlarge_carlocation_danger_lcc;
                        i4 = R.drawable.png_ic_xlarge_carlocation_danger_3d_lcc;
                    }
                    L.e(TAG, "get resource error ! carid:" + i2 + "  car3did:" + i5);
                } else {
                    i3 = R.drawable.png_ic_xlarge_carlocation_warning_lcc;
                    i4 = R.drawable.png_ic_xlarge_carlocation_warning_3d_lcc;
                }
                i2 = i3;
                i5 = i4;
                L.e(TAG, "get resource error ! carid:" + i2 + "  car3did:" + i5);
            } else if (CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_ACC == this.mXPolitDriveMode) {
                int i10 = this.mBatteryLevel;
                if (i10 == 0) {
                    i3 = R.drawable.png_ic_xlarge_carlocation_normal_acc;
                    i4 = R.drawable.png_ic_xlarge_carlocation_normal_3d_acc;
                } else if (i10 != 1) {
                    if (i10 == 2) {
                        i3 = R.drawable.png_ic_xlarge_carlocation_danger_acc;
                        i4 = R.drawable.png_ic_xlarge_carlocation_danger_3d_acc;
                    }
                    L.e(TAG, "get resource error ! carid:" + i2 + "  car3did:" + i5);
                } else {
                    i3 = R.drawable.png_ic_xlarge_carlocation_warning_acc;
                    i4 = R.drawable.png_ic_xlarge_carlocation_warning_3d_acc;
                }
                i2 = i3;
                i5 = i4;
                L.e(TAG, "get resource error ! carid:" + i2 + "  car3did:" + i5);
            } else {
                int i11 = this.mBatteryLevel;
                if (i11 == 0) {
                    i3 = R.drawable.png_ic_xlarge_carlocation_normal;
                    i4 = R.drawable.png_ic_xlarge_carlocation_3d;
                } else if (i11 != 1) {
                    if (i11 == 2) {
                        i3 = R.drawable.png_ic_xlarge_carlocation_normal_danger;
                        i4 = R.drawable.png_ic_xlarge_carlocation_3d_danger;
                    }
                    L.e(TAG, "get resource error ! carid:" + i2 + "  car3did:" + i5);
                } else {
                    i3 = R.drawable.png_ic_xlarge_carlocation_normal_warning;
                    i4 = R.drawable.png_ic_xlarge_carlocation_3d_warning;
                }
                i2 = i3;
                i5 = i4;
                L.e(TAG, "get resource error ! carid:" + i2 + "  car3did:" + i5);
            }
        }
        putList(i2, i5);
        updateCarLocTextures();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.scenes.mapscene.CarLocIconHelper$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$root$carservice$CarServiceManager$XPolitDriveMode = new int[CarServiceManager.XPolitDriveMode.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$carservice$CarServiceManager$XPolitDriveMode[CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_LCC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$carservice$CarServiceManager$XPolitDriveMode[CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_ACC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void updateCarLocIconDynamic() {
        if (this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
        this.mHandler.sendEmptyMessageDelayed(0, 300L);
    }

    private void restoreIcon() {
        putList(R.drawable.png_ic_xlarge_carlocation_normal, R.drawable.png_ic_xlarge_carlocation_3d);
    }

    private void putList(int i, int i2) {
        this.mCarLocList.put(81, MapTextureResourcesHelper.createCarLocMapTextureByResId(getResId(i)));
        this.mCarLocList.put(MarkUtils.MARKER_ID_CAR_FLASH, null);
        this.mCarLocList.put(MarkUtils.MARKER_ID_CAR_NAVIGATION, MapTextureResourcesHelper.createCarLocMapTextureByResId(getResId(i)));
        this.mCarLocList.put(MarkUtils.MARKER_ID_CAR_NAVIGATION_3D, MapTextureResourcesHelper.createCarLocMapTextureByResId(getResId(i2)));
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.ICarLocIconHelper
    public void updateCarLocIcon() {
        this.mScuDriveMode = SRNaviManager.getInstance().getDriveMode();
        updateCarLocIconDynamic();
    }

    @MainThread
    private void updateCarLocTextures() {
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        if (mapViewWrapper == null || this.mCarLocList == null) {
            return;
        }
        mapViewWrapper.getBizControlManager().updateCarMarkStyle();
        MapViewWrapper mapViewWrapper2 = this.mMapViewWrapper;
        MarkUtils.addOverlayTexturesAsync(mapViewWrapper2, mapViewWrapper2.getMainEngineID(), this.mCarLocList);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarRemainDistanceChange(int i) {
        int remainDistLevel;
        if (this.mIsStart && this.mBatteryLevel != (remainDistLevel = getRemainDistLevel(i))) {
            this.mBatteryLevel = remainDistLevel;
            L.Tag tag = TAG;
            L.i(tag, "onCarRemainDistanceChange distance:" + i + ", mBatteryLevel:" + this.mBatteryLevel);
            updateCarLocIconDynamic();
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
        onCarRemainDistanceChange(CarServiceManager.getInstance().getCarRemainDistance());
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXPolitDriveModeStatusChange(CarServiceManager.XPolitDriveMode xPolitDriveMode) {
        if (this.mIsStart) {
            this.mXPolitDriveMode = xPolitDriveMode;
            L.Tag tag = TAG;
            L.i(tag, "onXPolitDriveModeStatusChange driveMode=" + xPolitDriveMode);
            updateCarLocIconDynamic();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onDriveModeChanged(int i) {
        if (this.mIsStart) {
            this.mScuDriveMode = i;
            L.Tag tag = TAG;
            L.i(tag, "onDriveModeChanged driveMode=" + this.mScuDriveMode);
            updateCarLocIconDynamic();
        }
    }
}
