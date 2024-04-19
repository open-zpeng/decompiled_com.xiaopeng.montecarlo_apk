package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.XpGroup;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class AvoidLimitRouteLicensePlateViewHolder_ViewBinding implements Unbinder {
    private AvoidLimitRouteLicensePlateViewHolder target;
    private View view7f0903ee;
    private View view7f0903ef;

    @UiThread
    public AvoidLimitRouteLicensePlateViewHolder_ViewBinding(final AvoidLimitRouteLicensePlateViewHolder avoidLimitRouteLicensePlateViewHolder, View view) {
        this.target = avoidLimitRouteLicensePlateViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_avoid_limit_route_license_plate_layout, "field 'mLicencePlateEditBtn' and method 'onClick'");
        avoidLimitRouteLicensePlateViewHolder.mLicencePlateEditBtn = (XpGroup) Utils.castView(findRequiredView, R.id.setting_avoid_limit_route_license_plate_layout, "field 'mLicencePlateEditBtn'", XpGroup.class);
        this.view7f0903ef = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.AvoidLimitRouteLicensePlateViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                avoidLimitRouteLicensePlateViewHolder.onClick(view2);
            }
        });
        avoidLimitRouteLicensePlateViewHolder.mLicencePlateTv = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_avoid_limit_route_license_plate_tv, "field 'mLicencePlateTv'", XTextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_avoid_limit_route_license_plate_btn, "method 'onClick'");
        this.view7f0903ee = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.AvoidLimitRouteLicensePlateViewHolder_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                avoidLimitRouteLicensePlateViewHolder.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AvoidLimitRouteLicensePlateViewHolder avoidLimitRouteLicensePlateViewHolder = this.target;
        if (avoidLimitRouteLicensePlateViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        avoidLimitRouteLicensePlateViewHolder.mLicencePlateEditBtn = null;
        avoidLimitRouteLicensePlateViewHolder.mLicencePlateTv = null;
        this.view7f0903ef.setOnClickListener(null);
        this.view7f0903ef = null;
        this.view7f0903ee.setOnClickListener(null);
        this.view7f0903ee = null;
    }
}
