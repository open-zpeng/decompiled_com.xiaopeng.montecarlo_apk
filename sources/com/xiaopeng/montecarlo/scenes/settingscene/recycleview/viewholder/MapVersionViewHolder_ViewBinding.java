package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.XpGroup;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class MapVersionViewHolder_ViewBinding implements Unbinder {
    private MapVersionViewHolder target;
    private View view7f0903cc;
    private View view7f0903cd;
    private View view7f0903ef;
    private View view7f090406;
    private View view7f090409;
    private View view7f09040a;
    private View view7f09040b;

    @UiThread
    public MapVersionViewHolder_ViewBinding(final MapVersionViewHolder mapVersionViewHolder, View view) {
        this.target = mapVersionViewHolder;
        mapVersionViewHolder.mSettingMapVersionTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_map_version_title, "field 'mSettingMapVersionTitle'", XTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_map_version_explanation, "field 'mAboutUs' and method 'onClick'");
        mapVersionViewHolder.mAboutUs = (XTextView) Utils.castView(findRequiredView, R.id.setting_map_version_explanation, "field 'mAboutUs'", XTextView.class);
        this.view7f09040b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_map_version_expand, "field 'mVersionExpand' and method 'onClick'");
        mapVersionViewHolder.mVersionExpand = (XImageButton) Utils.castView(findRequiredView2, R.id.setting_map_version_expand, "field 'mVersionExpand'", XImageButton.class);
        this.view7f09040a = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        mapVersionViewHolder.mVersionContent = (XpGroup) Utils.findRequiredViewAsType(view, R.id.setting_map_version_content, "field 'mVersionContent'", XpGroup.class);
        mapVersionViewHolder.mSettingMapVersionContentTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_map_version_content_title, "field 'mSettingMapVersionContentTitle'", XTextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.setting_map_version_desc, "field 'mSettingMapVersionDesc' and method 'onClick'");
        mapVersionViewHolder.mSettingMapVersionDesc = (XTextView) Utils.castView(findRequiredView3, R.id.setting_map_version_desc, "field 'mSettingMapVersionDesc'", XTextView.class);
        this.view7f090409 = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.setting_about_auto_terms_service, "field 'mTermService' and method 'onClick'");
        mapVersionViewHolder.mTermService = (XTextView) Utils.castView(findRequiredView4, R.id.setting_about_auto_terms_service, "field 'mTermService'", XTextView.class);
        this.view7f0903cd = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.setting_about_auto_privacy_agreement, "field 'mAgreement' and method 'onClick'");
        mapVersionViewHolder.mAgreement = (XTextView) Utils.castView(findRequiredView5, R.id.setting_about_auto_privacy_agreement, "field 'mAgreement'", XTextView.class);
        this.view7f0903cc = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.setting_lane_map_introduction, "field 'mLaneIntroduceV' and method 'onClick'");
        mapVersionViewHolder.mLaneIntroduceV = (XTextView) Utils.castView(findRequiredView6, R.id.setting_lane_map_introduction, "field 'mLaneIntroduceV'", XTextView.class);
        this.view7f0903ef = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.setting_map_version_container, "method 'onClick'");
        this.view7f090406 = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MapVersionViewHolder mapVersionViewHolder = this.target;
        if (mapVersionViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mapVersionViewHolder.mSettingMapVersionTitle = null;
        mapVersionViewHolder.mAboutUs = null;
        mapVersionViewHolder.mVersionExpand = null;
        mapVersionViewHolder.mVersionContent = null;
        mapVersionViewHolder.mSettingMapVersionContentTitle = null;
        mapVersionViewHolder.mSettingMapVersionDesc = null;
        mapVersionViewHolder.mTermService = null;
        mapVersionViewHolder.mAgreement = null;
        mapVersionViewHolder.mLaneIntroduceV = null;
        this.view7f09040b.setOnClickListener(null);
        this.view7f09040b = null;
        this.view7f09040a.setOnClickListener(null);
        this.view7f09040a = null;
        this.view7f090409.setOnClickListener(null);
        this.view7f090409 = null;
        this.view7f0903cd.setOnClickListener(null);
        this.view7f0903cd = null;
        this.view7f0903cc.setOnClickListener(null);
        this.view7f0903cc = null;
        this.view7f0903ef.setOnClickListener(null);
        this.view7f0903ef = null;
        this.view7f090406.setOnClickListener(null);
        this.view7f090406 = null;
    }
}
