package com.xiaopeng.montecarlo.views;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class DetailRestrictRulesView_ViewBinding implements Unbinder {
    private DetailRestrictRulesView target;

    @UiThread
    public DetailRestrictRulesView_ViewBinding(DetailRestrictRulesView detailRestrictRulesView) {
        this(detailRestrictRulesView, detailRestrictRulesView);
    }

    @UiThread
    public DetailRestrictRulesView_ViewBinding(DetailRestrictRulesView detailRestrictRulesView, View view) {
        this.target = detailRestrictRulesView;
        detailRestrictRulesView.mRestrictedAreaRulesListView = (ListView) Utils.findRequiredViewAsType(view, R.id.left_list_view, "field 'mRestrictedAreaRulesListView'", ListView.class);
        detailRestrictRulesView.mRuleTime = (XTextView) Utils.findRequiredViewAsType(view, R.id.restrict_item_realtime, "field 'mRuleTime'", XTextView.class);
        detailRestrictRulesView.mRuleArea = (XTextView) Utils.findRequiredViewAsType(view, R.id.restrict_item_area, "field 'mRuleArea'", XTextView.class);
        detailRestrictRulesView.mRightImage = (XTextView) Utils.findRequiredViewAsType(view, R.id.right_image_content, "field 'mRightImage'", XTextView.class);
        detailRestrictRulesView.mDesc = (XTextView) Utils.findRequiredViewAsType(view, R.id.desc, "field 'mDesc'", XTextView.class);
        detailRestrictRulesView.mOtherDesc = (XTextView) Utils.findRequiredViewAsType(view, R.id.otherdesc, "field 'mOtherDesc'", XTextView.class);
        detailRestrictRulesView.mTimeTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.time_title, "field 'mTimeTitle'", XTextView.class);
        detailRestrictRulesView.mAreaTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.area_title, "field 'mAreaTitle'", XTextView.class);
        detailRestrictRulesView.mRuleTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.rule_title, "field 'mRuleTitle'", XTextView.class);
        detailRestrictRulesView.mOtherdesTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.otherdesc_title, "field 'mOtherdesTitle'", XTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DetailRestrictRulesView detailRestrictRulesView = this.target;
        if (detailRestrictRulesView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        detailRestrictRulesView.mRestrictedAreaRulesListView = null;
        detailRestrictRulesView.mRuleTime = null;
        detailRestrictRulesView.mRuleArea = null;
        detailRestrictRulesView.mRightImage = null;
        detailRestrictRulesView.mDesc = null;
        detailRestrictRulesView.mOtherDesc = null;
        detailRestrictRulesView.mTimeTitle = null;
        detailRestrictRulesView.mAreaTitle = null;
        detailRestrictRulesView.mRuleTitle = null;
        detailRestrictRulesView.mOtherdesTitle = null;
    }
}
