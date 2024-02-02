package com.xiaopeng.montecarlo.util.uirelationship.elements;

import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement;
/* loaded from: classes3.dex */
public class Cross3DElement extends UIRelationshipElement {
    public Cross3DElement() {
        super(UIRelationshipConfig.ELEMENT_CROSS_3D);
        this.mType = UIRelationshipConfig.TYPE_CROSS;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onShow() {
        super.onShow();
        hideElement(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK, true);
        hideElement("offline", true);
        hideElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW, true);
        hideElement(UIRelationshipConfig.ELEMENT_SAPA, true);
        hideElement(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA, true);
        showElement(UIRelationshipConfig.ELEMENT_NAVI_PANEL);
        hideElement(UIRelationshipConfig.ELEMENT_NGP, true);
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onHide() {
        super.onHide();
        showElement(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
        showElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
        showElement(UIRelationshipConfig.ELEMENT_SAPA);
        showElement(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA);
        showElement(UIRelationshipConfig.ELEMENT_NAVI_PANEL);
        showElement(UIRelationshipConfig.ELEMENT_NGP);
        showElement("offline");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public void onHideUpdate() {
        super.onHideUpdate();
        updateElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
        if (Utils.isPortrait()) {
            updateElement("offline");
        }
    }
}
