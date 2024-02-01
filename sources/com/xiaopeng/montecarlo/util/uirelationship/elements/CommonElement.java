package com.xiaopeng.montecarlo.util.uirelationship.elements;

import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement;
/* loaded from: classes3.dex */
public class CommonElement extends UIRelationshipElement {
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public boolean isCheckPriority() {
        return false;
    }

    public CommonElement(String str) {
        super(str);
        this.mType = UIRelationshipConfig.TYPE_COMMON;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public boolean canShow() {
        if (!UIRelationshipConfig.ELEMENT_SAPA.equals(this.mName)) {
            return !(isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_3D) || isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_2D)) || (UIRelationshipConfig.ELEMENT_RESTRICT_VIEW.equals(this.mName) && Utils.isLandscape() && !isElementVisible(UIRelationshipConfig.ELEMENT_POI_CARD));
        } else if (Utils.isPortrait()) {
            return (isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_3D) || isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_2D)) ? false : true;
        } else {
            return !isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_3D);
        }
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onShow() {
        super.onShow();
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement, com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onHide() {
        super.onHide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public void onShowUpdate() {
        super.onShowUpdate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public void onHideUpdate() {
        super.onHideUpdate();
    }
}
