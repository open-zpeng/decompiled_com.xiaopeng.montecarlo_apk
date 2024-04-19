package com.xiaopeng.montecarlo.datalog;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class DataLogHelper {
    private static WeakReference<MainContext> sMainContext;

    public static void setMainContext(MainContext mainContext) {
        sMainContext = new WeakReference<>(mainContext);
    }

    private static MainContext getMainContext() {
        WeakReference<MainContext> weakReference = sMainContext;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static PageType getPageTypeByCurScene(MainContext mainContext) {
        if (mainContext == null) {
            return PageType.NONE;
        }
        IBaseScene currentScene = mainContext.getCurrentScene();
        if (currentScene != null) {
            if (currentScene.hasChildScene()) {
                currentScene = currentScene.getTopChildScene();
            }
            return currentScene.getPageType();
        }
        return PageType.NONE;
    }

    public static PageType getPageTypeByParentScene(MainContext mainContext) {
        if (mainContext == null) {
            return PageType.NONE;
        }
        IBaseScene currentScene = mainContext.getCurrentScene();
        if (currentScene != null) {
            return currentScene.getPageType();
        }
        return PageType.NONE;
    }

    public static PageType getPageTypeByScene(IBaseScene iBaseScene) {
        if (iBaseScene != null) {
            if (iBaseScene.hasChildScene()) {
                iBaseScene = iBaseScene.getTopChildScene();
            }
            return iBaseScene.getPageType();
        }
        return PageType.NONE;
    }

    public static PageType getPageType() {
        if (getMainContext() != null) {
            return getMainContext().getCurrentScene().getPageType();
        }
        return PageType.NONE;
    }
}
