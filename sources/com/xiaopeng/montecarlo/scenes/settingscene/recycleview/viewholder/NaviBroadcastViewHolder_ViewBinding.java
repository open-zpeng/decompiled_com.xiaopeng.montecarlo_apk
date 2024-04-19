package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XTabLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class NaviBroadcastViewHolder_ViewBinding implements Unbinder {
    private NaviBroadcastViewHolder target;

    @UiThread
    public NaviBroadcastViewHolder_ViewBinding(NaviBroadcastViewHolder naviBroadcastViewHolder, View view) {
        this.target = naviBroadcastViewHolder;
        naviBroadcastViewHolder.mSettingNaviTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_navi_title, "field 'mSettingNaviTitle'", XTextView.class);
        naviBroadcastViewHolder.mBroadcastXIndicator = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.setting_navi_broadcast_xindicator, "field 'mBroadcastXIndicator'", XTabLayout.class);
        naviBroadcastViewHolder.mSettingNaviExplanation = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_navi_explanation, "field 'mSettingNaviExplanation'", XTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NaviBroadcastViewHolder naviBroadcastViewHolder = this.target;
        if (naviBroadcastViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        naviBroadcastViewHolder.mSettingNaviTitle = null;
        naviBroadcastViewHolder.mBroadcastXIndicator = null;
        naviBroadcastViewHolder.mSettingNaviExplanation = null;
    }
}
