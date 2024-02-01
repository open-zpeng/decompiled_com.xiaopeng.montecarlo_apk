package com.xiaopeng.montecarlo.util.uirelationship.elements;

import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement;
/* loaded from: classes3.dex */
public class PopElement extends UIRelationshipElement {
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public boolean canShow() {
        return true;
    }

    public PopElement(String str) {
        super(str);
        this.mType = UIRelationshipConfig.TYPE_POP;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onShow() {
        super.onShow();
        hideOtherElements(this.mType, this.mName);
        if (Utils.isPortrait()) {
            return;
        }
        hideElement(UIRelationshipConfig.ELEMENT_NGP, true);
        hideElement("offline", true);
        if (UIRelationshipConfig.ELEMENT_POI_CARD.equals(this.mName)) {
            hideElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onHide() {
        super.onHide();
        if (Utils.isPortrait()) {
            return;
        }
        showElement(UIRelationshipConfig.ELEMENT_NGP);
        showElement("offline");
        if (UIRelationshipConfig.ELEMENT_POI_CARD.equals(this.mName)) {
            showElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public void onShowUpdate() {
        super.onShowUpdate();
        updateElement("offline");
        updateElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public void onHideUpdate() {
        super.onHideUpdate();
        updateElement("offline");
        updateElement(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
    }
}
