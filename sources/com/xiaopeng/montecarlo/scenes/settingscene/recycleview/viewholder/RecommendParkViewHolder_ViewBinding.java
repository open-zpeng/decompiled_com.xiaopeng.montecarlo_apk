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
public class RecommendParkViewHolder_ViewBinding implements Unbinder {
    private RecommendParkViewHolder target;
    private View view7f09041d;

    @UiThread
    public RecommendParkViewHolder_ViewBinding(final RecommendParkViewHolder recommendParkViewHolder, View view) {
        this.target = recommendParkViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_recommend_park_switch_btn, "field 'mSettingRecommendParkBtn' and method 'onCheckedChanged'");
        recommendParkViewHolder.mSettingRecommendParkBtn = (XSwitch) Utils.castView(findRequiredView, R.id.setting_recommend_park_switch_btn, "field 'mSettingRecommendParkBtn'", XSwitch.class);
        this.view7f09041d = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.RecommendParkViewHolder_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                recommendParkViewHolder.onCheckedChanged((XSwitch) Utils.castParam(compoundButton, "onCheckedChanged", 0, "onCheckedChanged", 0, XSwitch.class));
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecommendParkViewHolder recommendParkViewHolder = this.target;
        if (recommendParkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        recommendParkViewHolder.mSettingRecommendParkBtn = null;
        ((CompoundButton) this.view7f09041d).setOnCheckedChangeListener(null);
        this.view7f09041d = null;
    }
}
