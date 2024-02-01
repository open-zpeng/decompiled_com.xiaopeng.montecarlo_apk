package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.AccountTypeView;
import com.xiaopeng.montecarlo.views.XpGroup;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class MapSeamlessNaviViewHolder_ViewBinding implements Unbinder {
    private MapSeamlessNaviViewHolder target;
    private View view7f0903ff;
    private View view7f090400;

    @UiThread
    public MapSeamlessNaviViewHolder_ViewBinding(final MapSeamlessNaviViewHolder mapSeamlessNaviViewHolder, View view) {
        this.target = mapSeamlessNaviViewHolder;
        View findRequiredView = Utils.findRequiredView(view, R.id.setting_map_seamless_navi_layout, "field 'mSeamlessLayout' and method 'onClick'");
        mapSeamlessNaviViewHolder.mSeamlessLayout = (XpGroup) Utils.castView(findRequiredView, R.id.setting_map_seamless_navi_layout, "field 'mSeamlessLayout'", XpGroup.class);
        this.view7f090400 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapSeamlessNaviViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapSeamlessNaviViewHolder.onClick(view2);
            }
        });
        mapSeamlessNaviViewHolder.mSettingMapUserSeamlessNaviName = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_map_user_seamless_navi_name, "field 'mSettingMapUserSeamlessNaviName'", XTextView.class);
        mapSeamlessNaviViewHolder.mSettingAccountSubtitleContent = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_account_subtitle_content, "field 'mSettingAccountSubtitleContent'", XTextView.class);
        mapSeamlessNaviViewHolder.mMapBindGuideIcon = (AccountTypeView) Utils.findRequiredViewAsType(view, R.id.setting_map_bind_guide_icon, "field 'mMapBindGuideIcon'", AccountTypeView.class);
        mapSeamlessNaviViewHolder.mXpengGuideIcon = (AccountTypeView) Utils.findRequiredViewAsType(view, R.id.setting_map_xpeng_guide_icon, "field 'mXpengGuideIcon'", AccountTypeView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.setting_map_seamless_icon, "method 'onClick'");
        this.view7f0903ff = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MapSeamlessNaviViewHolder_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mapSeamlessNaviViewHolder.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MapSeamlessNaviViewHolder mapSeamlessNaviViewHolder = this.target;
        if (mapSeamlessNaviViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mapSeamlessNaviViewHolder.mSeamlessLayout = null;
        mapSeamlessNaviViewHolder.mSettingMapUserSeamlessNaviName = null;
        mapSeamlessNaviViewHolder.mSettingAccountSubtitleContent = null;
        mapSeamlessNaviViewHolder.mMapBindGuideIcon = null;
        mapSeamlessNaviViewHolder.mXpengGuideIcon = null;
        this.view7f090400.setOnClickListener(null);
        this.view7f090400 = null;
        this.view7f0903ff.setOnClickListener(null);
        this.view7f0903ff = null;
    }
}
