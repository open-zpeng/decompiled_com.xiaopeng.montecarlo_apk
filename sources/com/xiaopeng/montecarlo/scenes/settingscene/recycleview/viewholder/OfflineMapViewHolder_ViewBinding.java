package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class OfflineMapViewHolder_ViewBinding implements Unbinder {
    private OfflineMapViewHolder target;
    private View view7f090437;
    private View view7f090438;

    @UiThread
    public OfflineMapViewHolder_ViewBinding(final OfflineMapViewHolder offlineMapViewHolder, View view) {
        this.target = offlineMapViewHolder;
        offlineMapViewHolder.mSettingOfflineMapTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_offline_map_title, "field 'mSettingOfflineMapTitle'", XTextView.class);
        offlineMapViewHolder.mMapDownloadTv = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_offline_map_tv, "field 'mMapDownloadTv'", XTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_offline_map_btn, "method 'onClick'");
        this.view7f090437 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.OfflineMapViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                offlineMapViewHolder.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_offline_map_layout, "method 'onClick'");
        this.view7f090438 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.OfflineMapViewHolder_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                offlineMapViewHolder.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OfflineMapViewHolder offlineMapViewHolder = this.target;
        if (offlineMapViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        offlineMapViewHolder.mSettingOfflineMapTitle = null;
        offlineMapViewHolder.mMapDownloadTv = null;
        this.view7f090437.setOnClickListener(null);
        this.view7f090437 = null;
        this.view7f090438.setOnClickListener(null);
        this.view7f090438 = null;
    }
}
