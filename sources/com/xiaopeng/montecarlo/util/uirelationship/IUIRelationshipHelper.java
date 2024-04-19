package com.xiaopeng.montecarlo.util.uirelationship;

import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
/* loaded from: classes3.dex */
public interface IUIRelationshipHelper {
    boolean canElementShow(@UIRelationshipConfig.UIElementDef String str);

    void notifyElementHide(@UIRelationshipConfig.UIElementDef String str);

    void notifyElementNeedRestore(@UIRelationshipConfig.UIElementDef String str);

    void notifyElementShow(@UIRelationshipConfig.UIElementDef String str);

    void notifyElementUpdate(@UIRelationshipConfig.UIElementDef String str);

    void register();

    void unRegister();
}
