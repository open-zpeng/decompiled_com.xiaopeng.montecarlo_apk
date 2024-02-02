package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import com.xiaopeng.montecarlo.scenes.debugscene.AutoListView;
import com.xiaopeng.montecarlo.scenes.debugscene.Copy2UsbDialog;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.speech.vui.utils.LogUtils;
/* loaded from: classes2.dex */
public class LogSetPage extends BasePage {
    private static final L.Tag TAG = new L.Tag("LogSetPage");
    AutoListView mAutoListView;
    private Context mContext;

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.mContext = viewGroup.getContext();
        this.mAutoListView = new AutoListView(this.mContext, null, 16842868);
        this.mAutoListView.setItemObj(this, R.layout.debug_list_item, R.id.debug_list_item_text);
        return this.mAutoListView;
    }

    @DebugItemTag(enableInUserVersion = true, initMethod = "initBlLog", value = R.string.debug_list_bl_log)
    public void menu01_BlLog(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_BL_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_BL_LOG);
        Switch r3 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r3.setChecked(!z);
        NaviLogUtil.quickSwitchBLLog(r3.isChecked());
    }

    public void initBlLog(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_BL_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_BL_LOG));
    }

    @DebugItemTag(enableInUserVersion = true, initMethod = "initLocLog", value = R.string.debug_list_loc_log)
    public void menu02_LocLog(View view) {
        Switch r2 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r2.setChecked(!r2.isChecked());
        NaviLogUtil.quickSwitchLoc(r2.isChecked());
    }

    public void initLocLog(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LOC_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_LOC_LOG));
    }

    @DebugItemTag(enableInUserVersion = true, initMethod = "initCopyDebugBugLog", value = R.string.debug_list_tv_copy_log_2_usb)
    public void menu03_CopyDebugLog(View view) {
        final Copy2UsbDialog copy2UsbDialog = new Copy2UsbDialog(this.mContext);
        copy2UsbDialog.setCancelable(false);
        copy2UsbDialog.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.LogSetPage.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                copy2UsbDialog.onOK();
            }
        });
        copy2UsbDialog.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.LogSetPage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                copy2UsbDialog.onCancel();
            }
        });
        copy2UsbDialog.show();
    }

    public void initCopyDebugBugLog(View view, int i) {
        View findViewById = view.findViewById(R.id.debug_list_item_switch);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    @DebugItemTag(enableInUserVersion = true, initMethod = "initXpLog", value = R.string.debug_list_xp_log)
    public void menu04_XpLog(View view) {
        Switch r3 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r3.setChecked(L.setLoggable(!r3.isChecked()));
        LogHelper.getInstance().quickSwitchXPLog(r3.isChecked());
        if (r3.isChecked()) {
            VoiceFullScenesUtil.setVuiLogLevel(LogUtils.LOG_DEBUG_LEVEL);
        } else {
            VoiceFullScenesUtil.setVuiLogLevel(LogUtils.LOG_INFO_LEVEL);
        }
    }

    public void initXpLog(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_XP_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_XP_LOG));
    }

    @DebugItemTag(enableInUserVersion = true, initMethod = "setIsSrDataRecord", value = R.string.debug_list_sr_data_record)
    public void menu05_setIsSrDataRecord(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_SR_DATA_RECORD, false);
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_IS_SR_DATA_RECORD, !z);
        SRNaviManager.getInstance().setIsSrDataRecord(!z);
    }

    public void setIsSrDataRecord(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_SR_DATA_RECORD, false));
    }

    @DebugItemTag(initMethod = "setIsShowSRData", value = R.string.debug_list_show_sr_data)
    public void menu06_setIsShowSRData(View view) {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_SHOW_SR_DATA, false);
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(!z);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_IS_SHOW_SR_DATA, !z);
        SRNaviManager.getInstance().setIsShowSRData(!z);
        this.mMainContext.showSRData(!z);
    }

    public void setIsShowSRData(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_SHOW_SR_DATA, false));
    }
}
