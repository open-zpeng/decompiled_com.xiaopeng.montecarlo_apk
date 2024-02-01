package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class CarLogoViewHolder_ViewBinding implements Unbinder {
    private CarLogoViewHolder target;
    private View view7f0903d9;
    private View view7f0903dc;

    @UiThread
    public CarLogoViewHolder_ViewBinding(final CarLogoViewHolder carLogoViewHolder, View view) {
        this.target = carLogoViewHolder;
        carLogoViewHolder.mCarTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_car_logo_title, "field 'mCarTitle'", XTextView.class);
        carLogoViewHolder.mCurrentCarLogo = (XImageView) Utils.findRequiredViewAsType(view, R.id.setting_current_car_logo_img, "field 'mCurrentCarLogo'", XImageView.class);
        carLogoViewHolder.mCarCurrentTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_current_car_logo_sub_title, "field 'mCarCurrentTitle'", XTextView.class);
        carLogoViewHolder.mSetCarLogoHintTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_current_car_logo_sub_title_hint, "field 'mSetCarLogoHintTitle'", XTextView.class);
        carLogoViewHolder.mCarLogoIconMore = (XImageView) Utils.findRequiredViewAsType(view, R.id.setting_car_logo_more, "field 'mCarLogoIconMore'", XImageView.class);
        carLogoViewHolder.mCarLogoMore = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_carlogo_hint_tv, "field 'mCarLogoMore'", XTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_car_logo_layout, "method 'onClickSetCarLogo'");
        this.view7f0903d9 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.CarLogoViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                carLogoViewHolder.onClickSetCarLogo(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_car_logo_next, "method 'onClickSetCarLogo'");
        this.view7f0903dc = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.CarLogoViewHolder_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                carLogoViewHolder.onClickSetCarLogo(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CarLogoViewHolder carLogoViewHolder = this.target;
        if (carLogoViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        carLogoViewHolder.mCarTitle = null;
        carLogoViewHolder.mCurrentCarLogo = null;
        carLogoViewHolder.mCarCurrentTitle = null;
        carLogoViewHolder.mSetCarLogoHintTitle = null;
        carLogoViewHolder.mCarLogoIconMore = null;
        carLogoViewHolder.mCarLogoMore = null;
        this.view7f0903d9.setOnClickListener(null);
        this.view7f0903d9 = null;
        this.view7f0903dc.setOnClickListener(null);
        this.view7f0903dc = null;
    }
}
