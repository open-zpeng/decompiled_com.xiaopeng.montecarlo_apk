package com.xiaopeng.montecarlo.util.uirelationship.elements;

import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement;
/* loaded from: classes3.dex */
public class RecommendParkElement extends UIRelationshipElement {
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public boolean isCheckPriority() {
        return false;
    }

    public RecommendParkElement() {
        super(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public boolean canShow() {
        return Utils.isPortrait() ? (isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_3D) || isElementVisible(UIRelationshipConfig.ELEMENT_RECOMMEND_CHARGE) || isElementVisible(UIRelationshipConfig.ELEMENT_TRAFFIC_EVENT)) ? false : true : (isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_3D) || isElementVisible(UIRelationshipConfig.ELEMENT_RECOMMEND_CHARGE) || isElementVisible(UIRelationshipConfig.ELEMENT_TRAFFIC_EVENT) || isElementVisible(UIRelationshipConfig.ELEMENT_POI_CARD) || isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_2D)) ? false : true;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onShow() {
        super.onShow();
        if (Utils.isLandscape()) {
            hideElement(UIRelationshipConfig.ELEMENT_NGP, true);
        }
        hideElement("offline", false);
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onHide() {
        super.onHide();
        if (Utils.isLandscape()) {
            showElement(UIRelationshipConfig.ELEMENT_NGP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public void onShowUpdate() {
        super.onShowUpdate();
        if (Utils.isPortrait()) {
            return;
        }
        updateElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public void onHideUpdate() {
        super.onHideUpdate();
        if (Utils.isPortrait()) {
            return;
        }
        updateElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
    }
}
