package com.xiaopeng.montecarlo.scenes.setcarlogo;

import android.view.View;
import android.widget.GridView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XImageButton;
/* loaded from: classes3.dex */
public class SetCarLogoFragment_ViewBinding implements Unbinder {
    private SetCarLogoFragment target;
    private View view7f090084;
    private View view7f0903c7;

    @UiThread
    public SetCarLogoFragment_ViewBinding(final SetCarLogoFragment setCarLogoFragment, View view) {
        this.target = setCarLogoFragment;
        setCarLogoFragment.mGridView = (GridView) Utils.findRequiredViewAsType(view, R.id.set_car_logo_gridview, "field 'mGridView'", GridView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.set_car_logo_btn_return, "field 'mBtnReturn' and method 'onBackPressed'");
        setCarLogoFragment.mBtnReturn = (XImageButton) Utils.castView(findRequiredView, R.id.set_car_logo_btn_return, "field 'mBtnReturn'", XImageButton.class);
        this.view7f0903c7 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.setcarlogo.SetCarLogoFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                setCarLogoFragment.onBackPressed(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.base_scene, "method 'onBackPressed'");
        this.view7f090084 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.setcarlogo.SetCarLogoFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                setCarLogoFragment.onBackPressed(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SetCarLogoFragment setCarLogoFragment = this.target;
        if (setCarLogoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        setCarLogoFragment.mGridView = null;
        setCarLogoFragment.mBtnReturn = null;
        this.view7f0903c7.setOnClickListener(null);
        this.view7f0903c7 = null;
        this.view7f090084.setOnClickListener(null);
        this.view7f090084 = null;
    }
}
