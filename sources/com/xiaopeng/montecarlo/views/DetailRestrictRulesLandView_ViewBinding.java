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
public class DetailRestrictRulesLandView_ViewBinding implements Unbinder {
    private DetailRestrictRulesLandView target;

    @UiThread
    public DetailRestrictRulesLandView_ViewBinding(DetailRestrictRulesLandView detailRestrictRulesLandView) {
        this(detailRestrictRulesLandView, detailRestrictRulesLandView);
    }

    @UiThread
    public DetailRestrictRulesLandView_ViewBinding(DetailRestrictRulesLandView detailRestrictRulesLandView, View view) {
        this.target = detailRestrictRulesLandView;
        detailRestrictRulesLandView.mRestrictedAreaRulesListView = (ListView) Utils.findRequiredViewAsType(view, R.id.left_list_view, "field 'mRestrictedAreaRulesListView'", ListView.class);
        detailRestrictRulesLandView.mRuleTime = (XTextView) Utils.findRequiredViewAsType(view, R.id.restrict_item_realtime, "field 'mRuleTime'", XTextView.class);
        detailRestrictRulesLandView.mRuleArea = (XTextView) Utils.findRequiredViewAsType(view, R.id.restrict_item_area, "field 'mRuleArea'", XTextView.class);
        detailRestrictRulesLandView.mRightImage = (XTextView) Utils.findRequiredViewAsType(view, R.id.right_image_content, "field 'mRightImage'", XTextView.class);
        detailRestrictRulesLandView.mDesc = (XTextView) Utils.findRequiredViewAsType(view, R.id.desc, "field 'mDesc'", XTextView.class);
        detailRestrictRulesLandView.mOtherDesc = (XTextView) Utils.findRequiredViewAsType(view, R.id.otherdesc, "field 'mOtherDesc'", XTextView.class);
        detailRestrictRulesLandView.mTimeTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.time_title, "field 'mTimeTitle'", XTextView.class);
        detailRestrictRulesLandView.mAreaTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.area_title, "field 'mAreaTitle'", XTextView.class);
        detailRestrictRulesLandView.mRuleTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.rule_title, "field 'mRuleTitle'", XTextView.class);
        detailRestrictRulesLandView.mOtherdesTitle = (XTextView) Utils.findRequiredViewAsType(view, R.id.otherdesc_title, "field 'mOtherdesTitle'", XTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DetailRestrictRulesLandView detailRestrictRulesLandView = this.target;
        if (detailRestrictRulesLandView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        detailRestrictRulesLandView.mRestrictedAreaRulesListView = null;
        detailRestrictRulesLandView.mRuleTime = null;
        detailRestrictRulesLandView.mRuleArea = null;
        detailRestrictRulesLandView.mRightImage = null;
        detailRestrictRulesLandView.mDesc = null;
        detailRestrictRulesLandView.mOtherDesc = null;
        detailRestrictRulesLandView.mTimeTitle = null;
        detailRestrictRulesLandView.mAreaTitle = null;
        detailRestrictRulesLandView.mRuleTitle = null;
        detailRestrictRulesLandView.mOtherdesTitle = null;
    }
}
