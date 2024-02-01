package com.xiaopeng.montecarlo.scenes.cruisescene;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.cruisescene.view.PoiConflictRecommendChargeView;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.RecommendChargerView;
import com.xiaopeng.vui.commons.VuiElementType;
/* loaded from: classes3.dex */
public class CruiseVuiHelper {
    private static final L.Tag TAG = new L.Tag("CruiseVuiHelper");
    private static volatile CruiseVuiHelper sInstance = new CruiseVuiHelper();
    private static final String sContainerVuiLabel = ContextUtils.getString(R.string.vui_label_cruise_charge_icon_container);
    private static final String sVuiAction = ContextUtils.getString(R.string.vui_action_click_select_navi);
    private static final String sItemVuiLabelPattern = ContextUtils.getString(R.string.vui_label_search_item_index);

    public static CruiseVuiHelper getInstance() {
        return sInstance;
    }

    public void syncRecommendChargeViewToVui(PoiConflictRecommendChargeView poiConflictRecommendChargeView, IBaseScene iBaseScene) {
        IBaseScene topChildScene = iBaseScene.getTopChildScene();
        if (topChildScene != null) {
            L.w(TAG, L.formatVoiceFullScenesLog("syncRecommendChargeViewToVui has child scene:" + topChildScene));
        } else if (poiConflictRecommendChargeView != null && iBaseScene.isSceneLegal()) {
            if (L.ENABLE) {
                L.d(TAG, L.formatVoiceFullScenesLog("syncRecommendChargeViewToVui scene:" + iBaseScene));
            }
            poiConflictRecommendChargeView.setVuiLayoutLoadable(true);
            poiConflictRecommendChargeView.setVuiLabel(sContainerVuiLabel);
            for (int i = 0; i < poiConflictRecommendChargeView.getChildCount(); i++) {
                RecommendChargerView recommendChargerView = (RecommendChargerView) poiConflictRecommendChargeView.getChildAt(i);
                String str = "2131297668_" + i;
                recommendChargerView.setVuiElementType(VuiElementType.GROUP);
                recommendChargerView.setVuiAction(sVuiAction);
                String indexString = CommonVuiHelper.getInstance().getIndexString(i);
                if (!TextUtils.isEmpty(indexString)) {
                    recommendChargerView.setVuiLabel(String.format(sItemVuiLabelPattern, indexString));
                }
                VoiceFullScenesUtil.setVuiElementTag(recommendChargerView, str);
            }
            VoiceFullScenesUtil.updateScene(iBaseScene, poiConflictRecommendChargeView);
        } else {
            L.w(TAG, L.formatVoiceFullScenesLog("syncRecommendChargeViewToVui failure,container is null or scene is illegal"));
        }
    }
}
