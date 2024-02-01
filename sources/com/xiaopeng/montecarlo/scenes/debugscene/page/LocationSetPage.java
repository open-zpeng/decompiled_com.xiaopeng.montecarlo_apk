package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.debugscene.AutoListView;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag;
import com.xiaopeng.montecarlo.views.dialog.XNoTitleDialog;
/* loaded from: classes3.dex */
public class LocationSetPage extends BasePage {
    private static final L.Tag TAG = new L.Tag("LocationSetPage");
    private static boolean sTboxLogOpen;
    private Context mContext;

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.mContext = viewGroup.getContext();
        AutoListView autoListView = new AutoListView(this.mContext, null, 16842868);
        autoListView.setItemObj(this, R.layout.debug_list_item, R.id.debug_list_item_text);
        return autoListView;
    }

    void startLocationDebugMode(int i) {
        LocationServiceManager.getInstance().startXPLocationState(i);
    }

    void stopLocationDebugMode(int i) {
        LocationServiceManager.getInstance().stopXPLocationState(i);
    }

    @DebugItemTag(initMethod = "initRecord", value = R.string.debug_list_save_mode)
    public void menu0_SaveLoc(View view, int i) {
        Switch r2 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r2.setChecked(!DRServiceManager.getInstance().isLocationRecordMode());
        DRServiceManager.getInstance().setLocationRecordMode(r2.isChecked());
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_RECORD_SET_LOCATION, r2.isChecked());
    }

    @DebugItemTag(initMethod = "initLoc", value = R.string.debug_list_simulate_gps_mode)
    public void menu1_Simulate(View view, int i) {
        boolean z = true;
        int i2 = i + 1;
        Switch r4 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        boolean z2 = false;
        if (i2 == LocationServiceManager.getInstance().getCurrentStatus()) {
            if (!DRServiceManager.getInstance().isDREnabled()) {
                r4.setChecked(false);
                stopLocationDebugMode(i2);
                z = false;
            }
        } else if (DRServiceManager.getInstance().isDREnabled()) {
            z2 = true;
        } else {
            r4.setChecked(true);
            startLocationDebugMode(i2);
            z = false;
        }
        if (z) {
            showAlertDialogToGpsDebugMode(z2);
        }
    }

    @DebugItemTag(initMethod = "initLoc", value = R.string.debug_list_socket_mode)
    public void menu2_Socket(View view, int i) {
        boolean z = true;
        int i2 = i + 1;
        Switch r4 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        boolean z2 = false;
        if (i2 == LocationServiceManager.getInstance().getCurrentStatus()) {
            if (!DRServiceManager.getInstance().isDREnabled()) {
                r4.setChecked(false);
                stopLocationDebugMode(i2);
                z = false;
            }
        } else if (DRServiceManager.getInstance().isDREnabled()) {
            z2 = true;
        } else {
            r4.setChecked(true);
            startLocationDebugMode(i2);
            z = false;
        }
        if (z) {
            showAlertDialogToGpsDebugMode(z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag(initMethod = "initLoc", value = com.xiaopeng.montecarlo.R.string.debug_list_custom_car_mode)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void menu3_CustomCar(android.view.View r4, int r5) {
        /*
            r3 = this;
            r0 = 1
            int r5 = r5 + r0
            r1 = 2131296573(0x7f09013d, float:1.8211066E38)
            android.view.View r4 = r4.findViewById(r1)
            android.widget.Switch r4 = (android.widget.Switch) r4
            com.xiaopeng.montecarlo.navcore.location.LocationServiceManager r1 = com.xiaopeng.montecarlo.navcore.location.LocationServiceManager.getInstance()
            int r1 = r1.getCurrentStatus()
            r2 = 0
            if (r5 != r1) goto L18
            r1 = r0
            goto L19
        L18:
            r1 = r2
        L19:
            if (r1 == 0) goto L22
            r4.setChecked(r2)
            r3.stopLocationDebugMode(r5)
            goto L32
        L22:
            com.xiaopeng.montecarlo.navcore.location.DRServiceManager r1 = com.xiaopeng.montecarlo.navcore.location.DRServiceManager.getInstance()
            boolean r1 = r1.isDREnabled()
            if (r1 != 0) goto L34
            r4.setChecked(r0)
            r3.startLocationDebugMode(r5)
        L32:
            r0 = r2
            goto L35
        L34:
            r2 = r0
        L35:
            if (r0 == 0) goto L3a
            r3.showAlertDialogToGpsDebugMode(r2)
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.debugscene.page.LocationSetPage.menu3_CustomCar(android.view.View, int):void");
    }

    @DebugItemTag(initMethod = "initLocInfo", value = R.string.debug_list_location_info)
    public void menu4_LocInfo(View view, int i) {
        boolean isLocationInfoShow = this.mMainContext.isLocationInfoShow();
        Switch r2 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r2.setChecked(!isLocationInfoShow);
        this.mMainContext.showLocationInfo(r2.isChecked());
    }

    @DebugItemTag(initMethod = "initSim", value = R.string.debug_list_simulate_dr_mode)
    public void menu5_Simulate(View view, int i) {
        Switch r1 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r1.setChecked(!DRServiceManager.getInstance().isLocationSimluateMode());
        DRServiceManager.getInstance().setLocationSimluateMode(r1.isChecked());
    }

    @DebugItemTag(initMethod = "initTboxGnssLog", value = R.string.debug_list_tbox_gnss_log)
    public void menu6_TboxGnssLog(View view, int i) {
        boolean z = sTboxLogOpen;
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!z);
        sTboxLogOpen = !z;
        CarServiceManager.getInstance().swtichTBOXGpsLog(sTboxLogOpen);
        L.Tag tag = TAG;
        L.i(tag, "swtichTBOXGpsLog:" + sTboxLogOpen + "ret:" + CarServiceManager.getInstance().isTBOXGpsLogOperSucceed());
    }

    @DebugItemTag(initMethod = "initSwitchImuSensor", value = R.string.debug_list_imu_sensor)
    public void menu7_SwitchImuSensor(View view, int i) {
        boolean isIMUSensorInDR = TBTManager.getInstance().isIMUSensorInDR();
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SwitchImuSensor:");
        sb.append(!isIMUSensorInDR);
        L.i(tag, sb.toString());
        TBTManager.getInstance().swtichSensor(!isIMUSensorInDR);
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(TBTManager.getInstance().isIMUSensorInDR());
    }

    public void initSwitchImuSensor(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(TBTManager.getInstance().isIMUSensorInDR());
    }

    public void initTboxGnssLog(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(sTboxLogOpen);
    }

    public void initRecord(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DRServiceManager.getInstance().isLocationRecordMode());
    }

    public void initLoc(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(i + 1 == LocationServiceManager.getInstance().getCurrentStatus());
    }

    public void initSim(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DRServiceManager.getInstance().isLocationSimluateMode());
    }

    public void initLocInfo(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(this.mMainContext.isLocationInfoShow());
    }

    public void showAlertDialogToGpsDebugMode(final boolean z) {
        String str = z ? "打开gps调试功能需要重启导航，关闭DR模式，你确定吗？" : "关闭gps调试功能需要重启导航，进入DR模式，你确定吗？";
        final XNoTitleDialog xNoTitleDialog = new XNoTitleDialog(this.mContext);
        xNoTitleDialog.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.LocationSetPage.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LocationSetPage.this.onRebootNaviForGpsDebugMode(z);
                xNoTitleDialog.dismiss();
            }
        });
        xNoTitleDialog.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.LocationSetPage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xNoTitleDialog.dismiss();
            }
        });
        xNoTitleDialog.setContentText(str);
        xNoTitleDialog.show();
    }

    public void onRebootNaviForGpsDebugMode(boolean z) {
        NavCoreUtil.setGpsDebugMode(z);
        RootUtil.delayExitApp(RootUtil.KILL_NAVI_DEBUG_SWITCH_GPS_MODE);
    }
}
