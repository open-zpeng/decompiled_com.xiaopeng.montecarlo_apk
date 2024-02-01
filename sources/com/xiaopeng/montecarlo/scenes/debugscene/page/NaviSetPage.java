package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.adasehp.EHPServiceManager;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.carservice.MockCarService;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.debugscene.AutoListView;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag;
import com.xiaopeng.montecarlo.views.dialog.XNoTitleDialog;
/* loaded from: classes3.dex */
public class NaviSetPage extends BasePage {
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

    @DebugItemTag(initMethod = "initSimluateGuide", value = R.string.debug_list_simluate_guide)
    public void menu01_SaveLoc(View view) {
        boolean isSimulateGuidance = TBTManager.getInstance().isSimulateGuidance();
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!isSimulateGuidance);
        TBTManager.getInstance().enableSimulateGuidance(!isSimulateGuidance);
    }

    public void initSimluateGuide(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(TBTManager.getInstance().isSimulateGuidance());
    }

    @DebugItemTag(initMethod = "initDebugCarservice", value = R.string.debug_list_debug_carservice)
    public void menu02_SaveLoc(View view) {
        boolean equals = MockCarService.SERVICE_NAME.equals(CarServiceManager.getInstance().getServiceName());
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!equals);
        if (equals) {
            return;
        }
        showAlertDialogToCarServiceDebugMode();
    }

    public void initDebugCarservice(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(MockCarService.SERVICE_NAME.equals(CarServiceManager.getInstance().getServiceName()));
    }

    @DebugItemTag(initMethod = "setIsRestoreExplore", value = R.string.debug_list_restore_explore)
    public void menu03_setIsRestoreExplore(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_RESTORE_EXPLORE_STATUS, false);
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_IS_RESTORE_EXPLORE_STATUS, !z);
    }

    public void setIsRestoreExplore(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_RESTORE_EXPLORE_STATUS, false));
    }

    @DebugItemTag(initMethod = "setIsNeedMinimap", value = R.string.debug_list_need_minimap)
    public void menu04_setIsNeedMinimap(View view) {
        boolean isNeedMiniMap = TBTManager.getInstance().isNeedMiniMap();
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!isNeedMiniMap);
        TBTManager.getInstance().setIsNeedMinimap(!isNeedMiniMap);
    }

    public void setIsNeedMinimap(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(TBTManager.getInstance().isNeedMiniMap());
    }

    @DebugItemTag(initMethod = "setIsSendV2DataBySocket", value = R.string.debug_list_send_v2_data_by_socket)
    public void menu05_setIsSendV2DataBySocket(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_SEND_V2_DATA_BY_SOCKET, false);
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_IS_SEND_V2_DATA_BY_SOCKET, !z);
        EHPServiceManager.getInstance().setIsSendV2DataBySocket(!z);
    }

    public void setIsSendV2DataBySocket(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_SEND_V2_DATA_BY_SOCKET, false));
    }

    @DebugItemTag(initMethod = "laneRecordPlay", value = R.string.debug_list_lane_record)
    public void menu07_LaneRecordAndPlay(View view) {
        Switch r3 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r3.setChecked(!r3.isChecked());
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LANE_RECORD_PLAY, r3.isChecked());
        this.mMainContext.showLaneRecordPlayBtn(r3.isChecked());
    }

    public void laneRecordPlay(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LANE_RECORD_PLAY, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_LANE_RECORD_PLAY));
    }

    private void showAlertDialogToCarServiceDebugMode() {
        final XNoTitleDialog xNoTitleDialog = new XNoTitleDialog(this.mContext);
        xNoTitleDialog.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.NaviSetPage.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NaviSetPage.this.onRebootNaviForCarServiceDebugMode();
                xNoTitleDialog.dismiss();
            }
        });
        xNoTitleDialog.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.NaviSetPage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xNoTitleDialog.dismiss();
            }
        });
        xNoTitleDialog.setContentText("打开车控调试功能需要重启导航，你确定吗？");
        xNoTitleDialog.show();
    }

    @DebugItemTag(initMethod = "setIsNaviDebugButtonEnable", value = R.string.debug_list_navi_debug_button)
    public void menu08_setIsNaviDebugButtonEnable(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_NAVI_DEBUG_BUTTON_ENABLE, false);
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_IS_NAVI_DEBUG_BUTTON_ENABLE, !z);
    }

    public void setIsNaviDebugButtonEnable(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_NAVI_DEBUG_BUTTON_ENABLE, false));
    }

    @DebugItemTag(enableInUserVersion = true, initMethod = "initLaneDisplayStatus", value = R.string.debug_list_lane_display_enable)
    public void menu09_enableLane(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_LANE_DISPLAY, true);
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_ENABLE_LANE_DISPLAY, !z);
        if (z) {
            RootUtil.delayExitApp(RootUtil.KILL_NAVI_DEBUG_MENU);
        }
    }

    public void initLaneDisplayStatus(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_LANE_DISPLAY, true));
    }

    @DebugItemTag(enableInUserVersion = true, initMethod = "initOddDisplayStatus", value = R.string.debug_list_odd_display_enable)
    public void menu10_enableOdd(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_ODD_DISPLAY, false);
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_ENABLE_ODD_DISPLAY, !z);
    }

    public void initOddDisplayStatus(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_ODD_DISPLAY, false));
    }

    @DebugItemTag(enableInUserVersion = true, initMethod = "initNGPStatus", value = R.string.debug_list_ngp_enable)
    public void menu11_enableNGP(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_NGP, false);
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_ENABLE_NGP, !z);
        RootUtil.delayExitApp(RootUtil.KILL_NAVI_DEBUG_SWITCH_NGP);
    }

    public void initNGPStatus(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_NGP, false));
    }

    @DebugItemTag(initMethod = "initIsPlayProto", value = R.string.debug_list_use_proto_play)
    public void menu12_setPlayProto(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_DEFAULT_PLAY_PROTO, false);
        Switch r4 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r4.setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_IS_DEFAULT_PLAY_PROTO, !z);
        this.mMainContext.showProtoPlayBtn(r4.isChecked());
    }

    public void initIsPlayProto(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_DEFAULT_PLAY_PROTO, false));
    }

    public void onRebootNaviForCarServiceDebugMode() {
        NavCoreUtil.setGpsDebugMode(true);
        RootUtil.setCarSerivceDebugMode(true);
        RootUtil.delayExitApp(RootUtil.KILL_NAVI_DEBUG_CARSERVICE);
    }

    @DebugItemTag(initMethod = "initSrLevel", value = R.string.debug_list_speed_level)
    public void menu13_initSpeedLevel(View view) {
        boolean isSRLevel = TBTManager.getInstance().isSRLevel();
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!isSRLevel);
        TBTManager.getInstance().enableSRLevel(!isSRLevel);
    }

    public void initSrLevel(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(TBTManager.getInstance().isSRLevel());
    }

    @DebugItemTag(initMethod = "initLccGeoFence", value = R.string.debug_lcc_geo_fence_feature)
    public void menu14_initLccGeoFence(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_LCC_GEO_FENCE, false);
        Switch r4 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r4.setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_ENABLE_LCC_GEO_FENCE, !z);
        this.mMainContext.enableLccGeoFenceTest(r4.isChecked());
    }

    public void initLccGeoFence(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_LCC_GEO_FENCE, false));
    }
}
