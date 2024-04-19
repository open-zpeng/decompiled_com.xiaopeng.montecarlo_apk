package com.xiaopeng.montecarlo.util.uirelationship.elements;

import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement;
/* loaded from: classes3.dex */
public class Cross2DElement extends UIRelationshipElement {
    public Cross2DElement() {
        super(UIRelationshipConfig.ELEMENT_CROSS_2D);
        this.mType = UIRelationshipConfig.TYPE_CROSS;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onShow() {
        super.onShow();
        if (Utils.isPortrait()) {
            hideElement(UIRelationshipConfig.ELEMENT_NAVI_PANEL, true);
            hideElement(UIRelationshipConfig.ELEMENT_NGP, true);
            hideElement(UIRelationshipConfig.ELEMENT_SAPA, true);
            hideElement(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA, true);
            hideElement("offline", true);
            hideElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW, true);
            return;
        }
        hideElement(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA, true);
        hideElement(UIRelationshipConfig.ELEMENT_NGP, true);
        hideElement(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK, true);
        hideElement("offline", true);
        hideElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW, true);
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onHide() {
        super.onHide();
        if (Utils.isPortrait()) {
            showElement(UIRelationshipConfig.ELEMENT_NAVI_PANEL);
            showElement(UIRelationshipConfig.ELEMENT_NGP);
            showElement(UIRelationshipConfig.ELEMENT_SAPA);
            showElement(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA);
            showElement("offline");
            showElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
            return;
        }
        showElement(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA);
        showElement(UIRelationshipConfig.ELEMENT_NGP);
        showElement("offline");
        showElement(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
        showElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public void onShowUpdate() {
        super.onShowUpdate();
        updateElement("offline");
        updateElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
        if (Utils.isPortrait()) {
            updateElement(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
        }
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public void onHideUpdate() {
        super.onHideUpdate();
        updateElement(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
        updateElement("offline");
        updateElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
    }
}
