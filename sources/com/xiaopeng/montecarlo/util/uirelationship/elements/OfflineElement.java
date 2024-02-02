package com.xiaopeng.montecarlo.util.uirelationship.elements;

import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement;
/* loaded from: classes3.dex */
public class OfflineElement extends UIRelationshipElement {
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public boolean isCheckPriority() {
        return false;
    }

    public OfflineElement() {
        super("offline");
        this.mType = UIRelationshipConfig.TYPE_COMMON;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public boolean canShow() {
        return (isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_3D) || isElementVisible(UIRelationshipConfig.ELEMENT_CROSS_2D)) ? false : true;
    }
}
