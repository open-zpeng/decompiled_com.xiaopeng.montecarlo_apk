package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.scenes.debugscene.AutoListView;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag;
/* loaded from: classes3.dex */
public class OtherPage extends BasePage {
    private static final L.Tag TAG = new L.Tag("OtherPage");
    private Context mContext;

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.mContext = viewGroup.getContext();
        AutoListView autoListView = new AutoListView(this.mContext, null, 16842868);
        autoListView.setItemObj(this, R.layout.debug_list_item, R.id.debug_list_item_text);
        return autoListView;
    }

    @DebugItemTag(initMethod = "initNoSwitch", stringValue = "清空充电站离线数据", value = 0)
    public void menu0_ClearChargeData() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_CHARGE_DB_VERSION, "");
        String formatTime = TimeFormatUtil.formatTime(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.SEARCH_CHARGE_UPDATE_TIME, 0L));
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(ContextUtils.getString(R.string.dialog_title_charge) + FDManager.LINE_SEPERATOR + string + " " + formatTime).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                XPOfflineDataManager.getInstance().clearChargeData();
                dialogInterface.dismiss();
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    @DebugItemTag(initMethod = "initNoSwitch", stringValue = "清空关键字配置", value = 0)
    public void menu0_ClearKeywordConfData() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_KEYWORD_CONFIG_VERSION, "");
        String formatTime = TimeFormatUtil.formatTime(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.KEY_KEYWORD_CONFIG_UPDATE_TIME, 0L));
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(ContextUtils.getString(R.string.dialog_title_keywordconfig) + FDManager.LINE_SEPERATOR + string + " " + formatTime).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                XPOfflineDataManager.getInstance().clearKeywordConfigData();
                dialogInterface.dismiss();
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    @DebugItemTag(initMethod = "initNoSwitch", stringValue = "清空汽车服务中心数据", value = 0)
    public void menu0_ClearCarServiceData() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_XPSERVICE_CENTER_DATA_VERSION, "");
        String formatTime = TimeFormatUtil.formatTime(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.KEY_XPSERVICE_CENTER_UPDATE_TIME, 0L));
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(ContextUtils.getString(R.string.dialog_title_car_service_center) + FDManager.LINE_SEPERATOR + string + " " + formatTime).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                XPOfflineDataManager.getInstance().clearServiceCenterData();
                dialogInterface.dismiss();
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    @DebugItemTag(initMethod = "initNoSwitch", stringValue = "清空无缝导航教程数据", value = 0)
    public void menu0_ClearSeamlessData() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_SEAMLESS_DATA_VERSION, "");
        String formatTime = TimeFormatUtil.formatTime(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.KEY_SEAMLESS_UPDATE_TIME, 0L));
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(ContextUtils.getString(R.string.dialog_title_seamless) + FDManager.LINE_SEPERATOR + string + " " + formatTime).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                XPOfflineDataManager.getInstance().clearSeamlessData();
                dialogInterface.dismiss();
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    @DebugItemTag(initMethod = "initNoSwitch", stringValue = "清空剐蹭点数据", value = 0)
    public void menu0_ClearScratchSpotData() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_XPSCRATCH_SPOT_DATA_VERSION, "");
        String formatTime = TimeFormatUtil.formatTime(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.KEY_XPSCRATCH_SPOT_UPDATE_TIME, 0L));
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(ContextUtils.getString(R.string.dialog_title_scratch_spot) + FDManager.LINE_SEPERATOR + string + " " + formatTime).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                XPOfflineDataManager.getInstance().clearScratchSpotData();
                dialogInterface.dismiss();
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    @DebugItemTag(initMethod = "initNoSwitch", stringValue = "清空LCC危险预警数据", value = 0)
    public void menu0_ClearLccGeoFenceData() {
        long lccGeoFenceDataVersion = SettingWrapper.getLccGeoFenceDataVersion();
        String formatTime = TimeFormatUtil.formatTime(SettingWrapper.getLccGeoFenceUpdateTime());
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(ContextUtils.getString(R.string.dialog_title_lcc_geo_fence) + FDManager.LINE_SEPERATOR + lccGeoFenceDataVersion + " " + formatTime).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                XPOfflineDataManager.getInstance().clearLccGeoFenceData();
                dialogInterface.dismiss();
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    @DebugItemTag(initMethod = "initCapture", value = R.string.debug_capture)
    public void menu2_Capture(View view) {
        Switch r3 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r3.setChecked(!r3.isChecked());
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_CAPTURE, r3.isChecked());
        this.mMainContext.showCaptureBtn(r3.isChecked());
    }

    @DebugItemTag(initMethod = "initRelaunch", value = R.string.debug_list_nav_relaunch)
    public void menu3_Relaunch(View view) {
        Switch r2 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r2.setChecked(!r2.isChecked());
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_RELAUNCH_NAVI, r2.isChecked());
    }

    @DebugItemTag(initMethod = "initCameraDegree", value = R.string.debug_camera_degree)
    public void menu4_Capture(View view) {
        Switch r3 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r3.setChecked(!r3.isChecked());
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_CAMERA_DEGREE, r3.isChecked());
        this.mMainContext.showCameraDegree(r3.isChecked());
    }

    public void initRelaunch(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_RELAUNCH_NAVI, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_RELAUNCH_NAVI));
    }

    @DebugItemTag(initMethod = "initNoSwitch", value = R.string.debug_list_nav_relaunch_now)
    public void menu4_RelaunchNow(View view) {
        new AlertDialog.Builder(this.mContext).setMessage(ContextUtils.getString(R.string.debug_list_nav_relaunch_now_tips)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RootUtil.delayExitApp(RootUtil.KILL_NAVI_DEBUG_MENU);
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.OtherPage.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    @DebugItemTag(initMethod = "initNavRestoreTimer", value = R.string.debug_navrestore_timer)
    public void menu5_NavRestoreTimer(View view) {
        boolean isNavRestoreTimerOpen = TBTManager.getInstance().isNavRestoreTimerOpen();
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!isNavRestoreTimerOpen);
        TBTManager.getInstance().setNavRestoreTimerOpen(!isNavRestoreTimerOpen);
    }

    public void initNavRestoreTimer(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(TBTManager.getInstance().isNavRestoreTimerOpen());
    }

    public void initCapture(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_CAPTURE, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_CAPTURE));
    }

    public void initCameraDegree(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_CAMERA_DEGREE, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_CAMERA_DEGREE));
    }

    public void initNoSwitch(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setVisibility(8);
    }
}
