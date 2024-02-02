package com.xiaopeng.montecarlo.util.uirelationship;

import com.xiaopeng.montecarlo.root.util.L;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class UIRelationshipHelper implements IUIRelationshipHelper, IUIRelationshipElementFinder {
    private static final L.Tag TAG = new L.Tag("UIRelationshipHelper");
    private Object mRegister;
    private long mRegisterTime;
    private HashMap<String, UIRelationshipElement> mUIRelationshipElements = new HashMap<>();
    private final UIRelationshipConfig mRelationshipConfig = new UIRelationshipConfig();

    public UIRelationshipHelper(Object obj) {
        this.mRegister = obj;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipHelper
    public void register() {
        Method[] declaredMethods;
        String[] strArr;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("register start time: ");
            long currentTimeMillis = System.currentTimeMillis();
            this.mRegisterTime = currentTimeMillis;
            sb.append(currentTimeMillis);
            L.d(tag, sb.toString());
        }
        for (Method method : this.mRegister.getClass().getDeclaredMethods()) {
            UIAction uIAction = (UIAction) method.getAnnotation(UIAction.class);
            if (uIAction != null) {
                UIRelationshipElement uIRelationshipElement = this.mUIRelationshipElements.get(uIAction.name());
                if (uIRelationshipElement == null) {
                    uIRelationshipElement = createElement(uIAction.name());
                    this.mUIRelationshipElements.put(uIAction.name(), uIRelationshipElement);
                }
                int methodType = uIAction.methodType();
                if (methodType == 1) {
                    uIRelationshipElement.mShowMethod = method;
                } else if (methodType == 0) {
                    uIRelationshipElement.mHideMethod = method;
                } else {
                    uIRelationshipElement.mUpdateMethod = method;
                }
                if (L.ENABLE) {
                    L.d(TAG, "find method: " + uIAction.name() + ", " + uIRelationshipElement.toString());
                }
            }
        }
        for (String str : this.mRelationshipConfig.ELEMENTS) {
            if (this.mUIRelationshipElements.get(str) == null) {
                UIRelationshipElement createElement = createElement(str);
                if (L.ENABLE) {
                    L.d(TAG, "put element: " + str + ", " + createElement.toString());
                }
                this.mUIRelationshipElements.put(str, createElement);
            }
        }
        if (L.ENABLE) {
            L.d(TAG, "register end: " + (System.currentTimeMillis() - this.mRegisterTime));
        }
    }

    private UIRelationshipElement createElement(String str) {
        UIRelationshipElement createElement = UIElementFactory.createElement(str);
        createElement.mPriority = this.mRelationshipConfig.getPriority(str);
        createElement.mRegister = this.mRegister;
        createElement.setElementFinder(this);
        return createElement;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipHelper
    public boolean canElementShow(String str) {
        UIRelationshipElement uIRelationshipElement = this.mUIRelationshipElements.get(str);
        L.Tag tag = TAG;
        L.i(tag, "canElementShow name: " + uIRelationshipElement);
        if (uIRelationshipElement == null) {
            return true;
        }
        return uIRelationshipElement.canElementShow();
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipHelper
    public void notifyElementShow(String str) {
        UIRelationshipElement uIRelationshipElement = this.mUIRelationshipElements.get(str);
        L.Tag tag = TAG;
        L.i(tag, "notifyElementShow name: " + str + ", showEle: " + uIRelationshipElement);
        if (uIRelationshipElement == null) {
            return;
        }
        L.i(TAG, " >>>>");
        uIRelationshipElement.onShow();
        uIRelationshipElement.initiativeUpdate();
        L.i(TAG, " <<<<");
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipHelper
    public void notifyElementHide(String str) {
        UIRelationshipElement uIRelationshipElement = this.mUIRelationshipElements.get(str);
        L.Tag tag = TAG;
        L.i(tag, "notifyElementHide name: " + str + ", hideEle: " + uIRelationshipElement);
        if (uIRelationshipElement == null) {
            return;
        }
        L.i(TAG, " >>>>");
        uIRelationshipElement.onHide();
        uIRelationshipElement.initiativeUpdate();
        L.i(TAG, " <<<<");
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipHelper
    public void notifyElementUpdate(String str) {
        UIRelationshipElement uIRelationshipElement = this.mUIRelationshipElements.get(str);
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("notifyElementUpdate name: ");
        sb.append(str);
        sb.append(", updateEle: ");
        sb.append(uIRelationshipElement == null ? "" : uIRelationshipElement.toString());
        L.i(tag, sb.toString());
        if (uIRelationshipElement == null || !uIRelationshipElement.visiable()) {
            return;
        }
        L.i(TAG, " >>>>");
        uIRelationshipElement.initiativeUpdate();
        L.i(TAG, " <<<<");
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipHelper
    public void notifyElementNeedRestore(String str) {
        UIRelationshipElement uIRelationshipElement = this.mUIRelationshipElements.get(str);
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("setNeedRestore name: ");
        sb.append(str);
        sb.append(", updateEle: ");
        sb.append(uIRelationshipElement == null ? "" : uIRelationshipElement.toString());
        L.i(tag, sb.toString());
        if (uIRelationshipElement == null) {
            return;
        }
        uIRelationshipElement.mNeedRestore = true;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipHelper
    public void unRegister() {
        this.mRegister = null;
        this.mUIRelationshipElements.clear();
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElementFinder
    public UIRelationshipElement findElementByName(String str) {
        return this.mUIRelationshipElements.get(str);
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElementFinder
    public HashMap<String, UIRelationshipElement> findAllElements() {
        return this.mUIRelationshipElements;
    }
}
