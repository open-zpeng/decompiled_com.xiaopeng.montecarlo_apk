package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
/* loaded from: classes3.dex */
public class DataResetViewHolder_ViewBinding implements Unbinder {
    private DataResetViewHolder target;
    private View view7f0903fc;
    private View view7f0903fd;

    @UiThread
    public DataResetViewHolder_ViewBinding(final DataResetViewHolder dataResetViewHolder, View view) {
        this.target = dataResetViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_map_data_reset_layout, "method 'onClickButtonRestoreDefaultData'");
        this.view7f0903fd = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.DataResetViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                dataResetViewHolder.onClickButtonRestoreDefaultData(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_map_data_reset_btn, "method 'onClickButtonRestoreDefaultData' and method 'onLongClickButtonRestoreDefaultData'");
        this.view7f0903fc = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.DataResetViewHolder_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                dataResetViewHolder.onClickButtonRestoreDefaultData(view2);
            }
        });
        findRequiredView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.DataResetViewHolder_ViewBinding.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return dataResetViewHolder.onLongClickButtonRestoreDefaultData(view2);
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
        this.view7f0903fd.setOnClickListener(null);
        this.view7f0903fd = null;
        this.view7f0903fc.setOnClickListener(null);
        this.view7f0903fc.setOnLongClickListener(null);
        this.view7f0903fc = null;
    }
}
