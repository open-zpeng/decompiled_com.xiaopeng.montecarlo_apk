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
public class DynamicLevelViewHolder_ViewBinding implements Unbinder {
    private DynamicLevelViewHolder target;
    private View view7f0903ec;

    @UiThread
    public DynamicLevelViewHolder_ViewBinding(final DynamicLevelViewHolder dynamicLevelViewHolder, View view) {
        this.target = dynamicLevelViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_dynamic_level_switch_btn, "field 'mSettingDynamicLevelSwitchBtn' and method 'onCheckedChanged'");
        dynamicLevelViewHolder.mSettingDynamicLevelSwitchBtn = (XSwitch) Utils.castView(findRequiredView, R.id.setting_dynamic_level_switch_btn, "field 'mSettingDynamicLevelSwitchBtn'", XSwitch.class);
        this.view7f0903ec = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.DynamicLevelViewHolder_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                dynamicLevelViewHolder.onCheckedChanged((XSwitch) Utils.castParam(compoundButton, "onCheckedChanged", 0, "onCheckedChanged", 0, XSwitch.class));
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DynamicLevelViewHolder dynamicLevelViewHolder = this.target;
        if (dynamicLevelViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        dynamicLevelViewHolder.mSettingDynamicLevelSwitchBtn = null;
        ((CompoundButton) this.view7f0903ec).setOnCheckedChangeListener(null);
        this.view7f0903ec = null;
    }
}
