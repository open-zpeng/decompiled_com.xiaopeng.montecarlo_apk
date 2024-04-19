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
    private View view7f0903ea;
    private View view7f0903eb;
    private View view7f09040d;
    private View view7f09041d;
    private View view7f09041e;
    private View view7f09041f;
    private View view7f090427;
    private View view7f09042a;
    private View view7f09042b;

    @UiThread
    public MapVersionViewHolder_ViewBinding(final MapVersionViewHolder mapVersionViewHolder, View view) {
        this.target = mapVersionViewHolder;
        mapVersionViewHolder.mSettingMapVersionTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_map_version_title, "field 'mSettingMapVersionTitle'", XTextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_map_version_explanation, "field 'mAboutUs' and method 'onClick'");
        mapVersionViewHolder.mAboutUs = (XTextView) Utils.castView(findRequiredView, R.id.setting_map_version_explanation, "field 'mAboutUs'", XTextView.class);
        this.view7f09042b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_map_version_expand, "field 'mVersionExpand' and method 'onClick'");
        mapVersionViewHolder.mVersionExpand = (XImageButton) Utils.castView(findRequiredView2, R.id.setting_map_version_expand, "field 'mVersionExpand'", XImageButton.class);
        this.view7f09042a = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        mapVersionViewHolder.mVersionContent = (XpGroup) Utils.findRequiredViewAsType(view, R.id.setting_map_version_content, "field 'mVersionContent'", XpGroup.class);
        mapVersionViewHolder.mSettingMapVersionContentTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_map_version_content_title, "field 'mSettingMapVersionContentTitle'", XTextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.setting_map_publication_num, "field 'mSettingMapPublicationNum' and method 'onClick'");
        mapVersionViewHolder.mSettingMapPublicationNum = (XTextView) Utils.castView(findRequiredView3, R.id.setting_map_publication_num, "field 'mSettingMapPublicationNum'", XTextView.class);
        this.view7f09041f = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.setting_map_internet_num, "field 'mSettingMapInternetNum' and method 'onClick'");
        mapVersionViewHolder.mSettingMapInternetNum = (XTextView) Utils.castView(findRequiredView4, R.id.setting_map_internet_num, "field 'mSettingMapInternetNum'", XTextView.class);
        this.view7f09041d = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.setting_map_lane_num, "field 'mSettingMapLaneNum' and method 'onClick'");
        mapVersionViewHolder.mSettingMapLaneNum = (XTextView) Utils.castView(findRequiredView5, R.id.setting_map_lane_num, "field 'mSettingMapLaneNum'", XTextView.class);
        this.view7f09041e = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.setting_about_auto_terms_service, "field 'mTermService' and method 'onClick'");
        mapVersionViewHolder.mTermService = (XTextView) Utils.castView(findRequiredView6, R.id.setting_about_auto_terms_service, "field 'mTermService'", XTextView.class);
        this.view7f0903eb = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.setting_about_auto_privacy_agreement, "field 'mAgreement' and method 'onClick'");
        mapVersionViewHolder.mAgreement = (XTextView) Utils.castView(findRequiredView7, R.id.setting_about_auto_privacy_agreement, "field 'mAgreement'", XTextView.class);
        this.view7f0903ea = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.setting_lane_map_introduction, "field 'mLaneIntroduceV' and method 'onClick'");
        mapVersionViewHolder.mLaneIntroduceV = (XTextView) Utils.castView(findRequiredView8, R.id.setting_lane_map_introduction, "field 'mLaneIntroduceV'", XTextView.class);
        this.view7f09040d = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapVersionViewHolder.onClick(view2);
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.setting_map_version_container, "method 'onClick'");
        this.view7f090427 = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapVersionViewHolder_ViewBinding.9
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
        mapVersionViewHolder.mSettingMapPublicationNum = null;
        mapVersionViewHolder.mSettingMapInternetNum = null;
        mapVersionViewHolder.mSettingMapLaneNum = null;
        mapVersionViewHolder.mTermService = null;
        mapVersionViewHolder.mAgreement = null;
        mapVersionViewHolder.mLaneIntroduceV = null;
        this.view7f09042b.setOnClickListener(null);
        this.view7f09042b = null;
        this.view7f09042a.setOnClickListener(null);
        this.view7f09042a = null;
        this.view7f09041f.setOnClickListener(null);
        this.view7f09041f = null;
        this.view7f09041d.setOnClickListener(null);
        this.view7f09041d = null;
        this.view7f09041e.setOnClickListener(null);
        this.view7f09041e = null;
        this.view7f0903eb.setOnClickListener(null);
        this.view7f0903eb = null;
        this.view7f0903ea.setOnClickListener(null);
        this.view7f0903ea = null;
        this.view7f09040d.setOnClickListener(null);
        this.view7f09040d = null;
        this.view7f090427.setOnClickListener(null);
        this.view7f090427 = null;
    }
}
