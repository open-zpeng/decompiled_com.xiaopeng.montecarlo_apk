package com.xiaopeng.montecarlo.util.uirelationship.elements;

import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement;
/* loaded from: classes3.dex */
public class NgpElement extends UIRelationshipElement {
    @Override // com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipElement
    public boolean isCheckPriority() {
        return true;
    }

    public NgpElement() {
        super(UIRelationshipConfig.ELEMENT_NGP);
        this.mType = UIRelationshipConfig.TYPE_COMMON;
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
