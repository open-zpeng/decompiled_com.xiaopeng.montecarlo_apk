package com.xiaopeng.montecarlo.scenes.downloadscene;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRecyclerView;
/* loaded from: classes2.dex */
public class MapDownloadFragment_ViewBinding implements Unbinder {
    private MapDownloadFragment target;
    private View view7f090084;
    private View view7f0900b9;

    @UiThread
    public MapDownloadFragment_ViewBinding(final MapDownloadFragment mapDownloadFragment, View view) {
        this.target = mapDownloadFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.btn_return, "field 'mBtnReturn' and method 'onBackPressed'");
        mapDownloadFragment.mBtnReturn = (XImageButton) Utils.castView(findRequiredView, R.id.btn_return, "field 'mBtnReturn'", XImageButton.class);
        this.view7f0900b9 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.MapDownloadFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapDownloadFragment.onBackPressed(view2);
            }
        });
        mapDownloadFragment.mAllCityRecyclerView = (XRecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_all_city, "field 'mAllCityRecyclerView'", XRecyclerView.class);
        mapDownloadFragment.mWaitingHitLayout = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.map_downlload_waiting_parent, "field 'mWaitingHitLayout'", XLinearLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.base_scene, "method 'onBackPressed'");
        this.view7f090084 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.MapDownloadFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapDownloadFragment.onBackPressed(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MapDownloadFragment mapDownloadFragment = this.target;
        if (mapDownloadFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mapDownloadFragment.mBtnReturn = null;
        mapDownloadFragment.mAllCityRecyclerView = null;
        mapDownloadFragment.mWaitingHitLayout = null;
        this.view7f0900b9.setOnClickListener(null);
        this.view7f0900b9 = null;
        this.view7f090084.setOnClickListener(null);
        this.view7f090084 = null;
    }
}
