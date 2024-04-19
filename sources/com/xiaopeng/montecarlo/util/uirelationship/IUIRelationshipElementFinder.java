package com.xiaopeng.montecarlo.util.uirelationship;

import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public interface IUIRelationshipElementFinder {
    HashMap<String, UIRelationshipElement> findAllElements();

    UIRelationshipElement findElementByName(@UIRelationshipConfig.UIElementDef String str);
}
