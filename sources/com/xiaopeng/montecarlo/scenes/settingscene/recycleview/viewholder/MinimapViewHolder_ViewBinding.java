package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.views.XpGroup;
import com.xiaopeng.xui.widget.XTabLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class MinimapViewHolder_ViewBinding implements Unbinder {
    private MinimapViewHolder target;

    @UiThread
    public MinimapViewHolder_ViewBinding(MinimapViewHolder minimapViewHolder, View view) {
        this.target = minimapViewHolder;
        minimapViewHolder.mMinimapLayout = (XpGroup) Utils.findRequiredViewAsType(view, R.id.setting_minimap_layout, "field 'mMinimapLayout'", XpGroup.class);
        minimapViewHolder.mMinimapMapmodeXIndicator = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.setting_minimap_mapmode_xindicator, "field 'mMinimapMapmodeXIndicator'", XTabLayout.class);
        minimapViewHolder.mSettingMinimapTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.setting_minimap_title, "field 'mSettingMinimapTitle'", XTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MinimapViewHolder minimapViewHolder = this.target;
        if (minimapViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        minimapViewHolder.mMinimapLayout = null;
        minimapViewHolder.mMinimapMapmodeXIndicator = null;
        minimapViewHolder.mSettingMinimapTitle = null;
    }
}
