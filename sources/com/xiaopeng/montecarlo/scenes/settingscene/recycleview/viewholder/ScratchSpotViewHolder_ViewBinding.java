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
public class ScratchSpotViewHolder_ViewBinding implements Unbinder {
    private ScratchSpotViewHolder target;
    private View view7f090423;

    @UiThread
    public ScratchSpotViewHolder_ViewBinding(final ScratchSpotViewHolder scratchSpotViewHolder, View view) {
        this.target = scratchSpotViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_scratch_spot_switch_btn, "field 'mScratchSpotSwitchBtn' and method 'onCheckedChanged'");
        scratchSpotViewHolder.mScratchSpotSwitchBtn = (XSwitch) Utils.castView(findRequiredView, R.id.setting_scratch_spot_switch_btn, "field 'mScratchSpotSwitchBtn'", XSwitch.class);
        this.view7f090423 = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.ScratchSpotViewHolder_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                scratchSpotViewHolder.onCheckedChanged((XSwitch) Utils.castParam(compoundButton, "onCheckedChanged", 0, "onCheckedChanged", 0, XSwitch.class));
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ScratchSpotViewHolder scratchSpotViewHolder = this.target;
        if (scratchSpotViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        scratchSpotViewHolder.mScratchSpotSwitchBtn = null;
        ((CompoundButton) this.view7f090423).setOnCheckedChangeListener(null);
        this.view7f090423 = null;
    }
}
