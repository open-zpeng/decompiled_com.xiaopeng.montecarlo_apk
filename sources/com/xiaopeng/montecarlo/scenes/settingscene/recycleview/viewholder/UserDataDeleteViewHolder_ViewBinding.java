package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
/* loaded from: classes3.dex */
public class UserDataDeleteViewHolder_ViewBinding implements Unbinder {
    private UserDataDeleteViewHolder target;
    private View view7f090423;
    private View view7f090424;

    @UiThread
    public UserDataDeleteViewHolder_ViewBinding(final UserDataDeleteViewHolder userDataDeleteViewHolder, View view) {
        this.target = userDataDeleteViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_map_user_data_delete_layout, "method 'onClickButtonDelUserData'");
        this.view7f090424 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.UserDataDeleteViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                userDataDeleteViewHolder.onClickButtonDelUserData();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_map_user_data_delete_btn, "method 'onClickButtonDelUserData'");
        this.view7f090423 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.UserDataDeleteViewHolder_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                userDataDeleteViewHolder.onClickButtonDelUserData();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view7f090424.setOnClickListener(null);
        this.view7f090424 = null;
        this.view7f090423.setOnClickListener(null);
        this.view7f090423 = null;
    }
}
