package com.xiaopeng.montecarlo.util.uirelationship;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class UIRelationshipElement implements IUIRelationshipElement {
    private static final L.Tag TAG = new L.Tag("UIRelationshipElement");
    private IUIRelationshipElementFinder mElementFinder;
    public String mName;
    public boolean mNeedRestore;
    public Object mRegister;
    public int mPriority = -1;
    public Method mShowMethod = null;
    public Method mHideMethod = null;
    public Method mUpdateMethod = null;
    public int mVisibility = 8;
    public String mType = "";

    protected boolean canShow() {
        return true;
    }

    protected boolean isCheckPriority() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onHideUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onShowUpdate() {
    }

    public UIRelationshipElement(String str) {
        this.mName = str;
    }

    public void setElementFinder(@NonNull IUIRelationshipElementFinder iUIRelationshipElementFinder) {
        this.mElementFinder = iUIRelationshipElementFinder;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public final boolean canElementShow() {
        if (isCheckPriority()) {
            IUIRelationshipElementFinder iUIRelationshipElementFinder = this.mElementFinder;
            if (iUIRelationshipElementFinder == null) {
                return false;
            }
            for (Map.Entry<String, UIRelationshipElement> entry : iUIRelationshipElementFinder.findAllElements().entrySet()) {
                UIRelationshipElement value = entry.getValue();
                if (value.mPriority < this.mPriority && value.mVisibility == 0) {
                    return false;
                }
            }
            return true;
        }
        return canShow();
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onShow() {
        this.mVisibility = 0;
        this.mNeedRestore = false;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public void onHide() {
        this.mVisibility = 8;
        this.mNeedRestore = false;
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public final void initiativeUpdate() {
        if (visiable()) {
            onShowUpdate();
        } else {
            onHideUpdate();
        }
    }

    @Override // com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipElement
    public boolean visiable() {
        return this.mVisibility == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UIRelationshipElement: ");
        sb.append("name: ");
        sb.append(this.mName);
        sb.append(", mPriority: ");
        sb.append(this.mPriority);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(", mShowMethod: ");
        Method method = this.mShowMethod;
        sb2.append(method != null ? method.getName() : "");
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(", mHideMethod: ");
        Method method2 = this.mHideMethod;
        sb3.append(method2 != null ? method2.getName() : "");
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(", mUpdateMethod: ");
        Method method3 = this.mUpdateMethod;
        sb4.append(method3 != null ? method3.getName() : "");
        sb.append(sb4.toString());
        sb.append(", mVisibility: " + this.mVisibility);
        sb.append(", mNeedRestore: " + this.mNeedRestore);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isElementVisible(String str) {
        UIRelationshipElement findElementByName;
        IUIRelationshipElementFinder iUIRelationshipElementFinder = this.mElementFinder;
        if (iUIRelationshipElementFinder == null || (findElementByName = iUIRelationshipElementFinder.findElementByName(str)) == null) {
            return false;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isElementVisible: " + str + ".visibility: " + findElementByName.mVisibility);
        }
        return findElementByName.visiable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideElement(String str, boolean z) {
        IUIRelationshipElementFinder iUIRelationshipElementFinder = this.mElementFinder;
        if (iUIRelationshipElementFinder == null) {
            return;
        }
        UIRelationshipElement findElementByName = iUIRelationshipElementFinder.findElementByName(str);
        if (findElementByName == null) {
            L.Tag tag = TAG;
            L.e(tag, str + " is not register");
            return;
        }
        hideElement(findElementByName, z);
    }

    private void hideElement(UIRelationshipElement uIRelationshipElement, boolean z) {
        if (uIRelationshipElement.visiable()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "hideElement: " + uIRelationshipElement + " , needRestore = " + z);
            }
            invoke(uIRelationshipElement.mHideMethod);
            uIRelationshipElement.mVisibility = 8;
            uIRelationshipElement.mNeedRestore = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showElement(String str) {
        IUIRelationshipElementFinder iUIRelationshipElementFinder = this.mElementFinder;
        if (iUIRelationshipElementFinder == null) {
            return;
        }
        UIRelationshipElement findElementByName = iUIRelationshipElementFinder.findElementByName(str);
        if (findElementByName == null) {
            L.Tag tag = TAG;
            L.e(tag, str + " is not register");
        } else if (!findElementByName.visiable() && findElementByName.mNeedRestore && canElementShow()) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "showElement: " + findElementByName + " needRestore = " + findElementByName.mNeedRestore);
            }
            invoke(findElementByName.mShowMethod);
            findElementByName.mVisibility = 0;
            findElementByName.mNeedRestore = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateElement(String str) {
        UIRelationshipElement findElementByName;
        IUIRelationshipElementFinder iUIRelationshipElementFinder = this.mElementFinder;
        if (iUIRelationshipElementFinder == null || (findElementByName = iUIRelationshipElementFinder.findElementByName(str)) == null || !findElementByName.visiable()) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateElement: " + findElementByName);
        }
        invoke(findElementByName.mUpdateMethod);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideOtherElements(String str, String str2) {
        IUIRelationshipElementFinder iUIRelationshipElementFinder;
        if (TextUtils.isEmpty(str) || (iUIRelationshipElementFinder = this.mElementFinder) == null) {
            return;
        }
        for (UIRelationshipElement uIRelationshipElement : iUIRelationshipElementFinder.findAllElements().values()) {
            if (str.equals(uIRelationshipElement.mType) && !uIRelationshipElement.mName.equals(str2)) {
                hideElement(uIRelationshipElement, false);
            }
        }
    }

    private void invoke(Method method) {
        if (method == null || this.mRegister == null) {
            return;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, " invoke method: " + method.getName());
            }
            method.invoke(this.mRegister, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            L.Tag tag2 = TAG;
            L.e(tag2, "invoke failed: " + method.getName());
        }
    }
}
