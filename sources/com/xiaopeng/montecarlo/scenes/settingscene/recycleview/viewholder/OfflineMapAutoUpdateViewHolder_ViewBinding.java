package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XSwitch;
/* loaded from: classes3.dex */
public class OfflineMapAutoUpdateViewHolder_ViewBinding implements Unbinder {
    private OfflineMapAutoUpdateViewHolder target;
    private View view7f0903fe;

    @UiThread
    public OfflineMapAutoUpdateViewHolder_ViewBinding(final OfflineMapAutoUpdateViewHolder offlineMapAutoUpdateViewHolder, View view) {
        this.target = offlineMapAutoUpdateViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_map_data_update_switch_btn, "field 'mMapDataUpdateSwitchBtn' and method 'onCheckedChanged'");
        offlineMapAutoUpdateViewHolder.mMapDataUpdateSwitchBtn = (XSwitch) Utils.castView(findRequiredView, R.id.setting_map_data_update_switch_btn, "field 'mMapDataUpdateSwitchBtn'", XSwitch.class);
        this.view7f0903fe = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.OfflineMapAutoUpdateViewHolder_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                offlineMapAutoUpdateViewHolder.onCheckedChanged((XSwitch) Utils.castParam(compoundButton, "onCheckedChanged", 0, "onCheckedChanged", 0, XSwitch.class));
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OfflineMapAutoUpdateViewHolder offlineMapAutoUpdateViewHolder = this.target;
        if (offlineMapAutoUpdateViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        offlineMapAutoUpdateViewHolder.mMapDataUpdateSwitchBtn = null;
        ((CompoundButton) this.view7f0903fe).setOnCheckedChangeListener(null);
        this.view7f0903fe = null;
    }
}
