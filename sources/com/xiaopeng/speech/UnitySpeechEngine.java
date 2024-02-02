package com.xiaopeng.speech;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.lib.apirouter.server.ApiPublisherProvider;
import com.xiaopeng.lib.apirouter.server.IManifestHandler;
import com.xiaopeng.lib.apirouter.server.IManifestHelper;
import com.xiaopeng.lib.apirouter.server.ManifestHelper_VuiEngine;
import com.xiaopeng.speech.overall.OverallManager;
import com.xiaopeng.speech.overall.listener.IXpOverallListener;
import com.xiaopeng.speech.vui.VuiEngineImpl;
import com.xiaopeng.speech.vui.listener.IUnityVuiSceneListener;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.vui.commons.model.VuiElement;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class UnitySpeechEngine {
    private static String TAG = "UnitySpeechEngine";
    private static VuiEngineImpl impl;

    public static void setLoglevel(int i) {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setLoglevel(i);
        }
    }

    public static boolean isVuiFeatureDisabled() {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.isVuiFeatureDisabled();
        }
        return true;
    }

    public static boolean isInSpeech() {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.isInSpeech();
        }
        return false;
    }

    public static void setProcessName(String str) {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setProcessName(str);
        }
    }

    public static void dispatchVuiEvent(String str, String str2) {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.dispatchVuiEvent(str, str2);
        }
    }

    public static String getElementState(String str, String str2) {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.getElementState(str, str2);
        }
        return null;
    }

    public static void init(Context context) {
        if (ApiPublisherProvider.CONTEXT == null) {
            ApiPublisherProvider.CONTEXT = context.getApplicationContext();
        }
        initApiRouter();
        if (impl == null) {
            impl = new VuiEngineImpl(context, false);
        }
        impl.init("ApiRouterUnitySceneService");
        OverallManager.instance().init(context);
    }

    public static void init(Context context, IXpOverallListener iXpOverallListener) {
        LogUtils.logInfo(TAG, "init");
        if (ApiPublisherProvider.CONTEXT == null) {
            ApiPublisherProvider.CONTEXT = context.getApplicationContext();
        }
        initApiRouter();
        if (impl == null) {
            impl = new VuiEngineImpl(context, false);
            impl.init("ApiRouterUnitySceneService");
        }
        OverallManager.instance().init(context, iXpOverallListener);
    }

    public static void subScribeOverallCommand(String[] strArr, IXpOverallListener iXpOverallListener) {
        OverallManager.instance().addObserverEvents(strArr, null, iXpOverallListener);
    }

    public static void subScribeOverallCommand(String[] strArr, String[] strArr2, IXpOverallListener iXpOverallListener) {
        OverallManager.instance().addObserverEvents(strArr, strArr2, iXpOverallListener);
    }

    public static void setOverallListener(IXpOverallListener iXpOverallListener) {
        String str = TAG;
        LogUtils.logDebug(str, "setOverallListener:" + iXpOverallListener);
        OverallManager.instance().setOverallListener(iXpOverallListener);
    }

    public static void addOverallListener(IXpOverallListener iXpOverallListener) {
        String str = TAG;
        LogUtils.logDebug(str, "setOverallListener:" + iXpOverallListener);
        OverallManager.instance().addOverallListener(iXpOverallListener);
    }

    public static void removeOverallListener(IXpOverallListener iXpOverallListener) {
        String str = TAG;
        LogUtils.logDebug(str, "removeOverallListener:" + iXpOverallListener);
        OverallManager.instance().removeOverallListener(iXpOverallListener);
    }

    public static void registerVuiSceneListener(String str, IUnityVuiSceneListener iUnityVuiSceneListener) {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.addVuiSceneListener(str, null, iUnityVuiSceneListener, null, true);
        }
        String str2 = TAG;
        LogUtils.logInfo(str2, "registerVuiSceneListener:" + str + ",listener:" + iUnityVuiSceneListener);
    }

    public static void unregisterVuiSceneListener(String str, IUnityVuiSceneListener iUnityVuiSceneListener) {
        String str2 = TAG;
        LogUtils.logDebug(str2, "unregisterVuiSceneListener:" + str + ",listener:" + iUnityVuiSceneListener);
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeVuiSceneListener(str, iUnityVuiSceneListener, false);
        }
    }

    public static void setBuildElement(String str) {
        String str2 = TAG;
        LogUtils.logInfo(str2, "setBuildElement:" + str);
        if (impl != null) {
            VuiScene stringConvertToVuiScene = VuiUtils.stringConvertToVuiScene(str);
            impl.setBuildElements(stringConvertToVuiScene.getSceneId(), stringConvertToVuiScene.getElements());
        }
    }

    public static void setUpdateElement(String str) {
        if (impl != null) {
            VuiScene stringConvertToVuiScene = VuiUtils.stringConvertToVuiScene(str);
            impl.setUpdateElements(stringConvertToVuiScene.getSceneId(), stringConvertToVuiScene.getElements());
        }
    }

    public static void setUpdateElement(String str, String str2) {
        String str3 = TAG;
        LogUtils.logInfo(str3, "setBuildElement:" + str + ",data:" + str2);
        if (impl != null) {
            impl.setUpdateElements(str, Arrays.asList(VuiUtils.stringConvertToVuiElement(str2)));
        }
    }

    public static String getStatefulButtonString(int i, String str, String str2, String str3, String str4) {
        VuiElement generateStatefulButtonElement;
        if (TextUtils.isEmpty(str) || (generateStatefulButtonElement = VuiUtils.generateStatefulButtonElement(i, str.split(","), str2, str3, str4)) == null) {
            return null;
        }
        return VuiUtils.vuiElementGroupConvertToString(Arrays.asList(generateStatefulButtonElement));
    }

    public static void setUpdateElementValue(String str, String str2, Object obj) {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setUpdateElementValue(str, str2, obj);
        }
    }

    public static void setUpdateElementVisible(String str, String str2, boolean z) {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.setUpdateElementVisible(str, str2, z);
        }
    }

    public static VuiElement getVuiElement(String str, String str2) {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.getVuiElement(str, str2);
        }
        return null;
    }

    public static VuiScene getVuiScene(String str) {
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            return vuiEngineImpl.getVuiScene(str);
        }
        return null;
    }

    public static void enterScene(String str) {
        String str2 = TAG;
        LogUtils.logInfo(str2, "enterScene:" + str);
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.enterScene(str, true);
        }
    }

    public static void exitScene(String str) {
        String str2 = TAG;
        LogUtils.logInfo(str2, "exitScene:" + str);
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.exitScene(str, true);
        }
    }

    public static void dispatchOverallEvent(String str, String str2) {
        OverallManager.instance().dispatchOverallEvent(str, str2);
    }

    public static void dispatchOverallQuery(String str, String str2, String str3) {
        OverallManager.instance().dispatchOverallQuery(str, str2, str3);
    }

    public void addVuiElement(String str, String str2) {
        String str3 = TAG;
        LogUtils.logInfo(str3, "addVuiElement:" + str + ",data:" + str2);
        if (impl != null) {
            impl.setUpdateElements(str, Arrays.asList(VuiUtils.stringConvertToVuiElement(str2)));
        }
    }

    public void removeVuiElement(String str, String str2) {
        String str3 = TAG;
        LogUtils.logInfo(str3, "removeVuiElement:" + str + ",elementId:" + str2);
        VuiEngineImpl vuiEngineImpl = impl;
        if (vuiEngineImpl != null) {
            vuiEngineImpl.removeVuiElement(str, str2);
        }
    }

    public void vuiFeedback(String str, String str2, int i) {
        if (impl != null) {
            String str3 = TAG;
            Log.i(str3, "vuiFeedback elementId:" + str + ",feedback," + str2);
            impl.vuiFeedback(str, new VuiFeedback.Builder().state(i).content(str2).build());
        }
    }

    private static void initApiRouter() {
        ApiPublisherProvider.addManifestHandler(new IManifestHandler() { // from class: com.xiaopeng.speech.UnitySpeechEngine.1
            @Override // com.xiaopeng.lib.apirouter.server.IManifestHandler
            public IManifestHelper[] getManifestHelpers() {
                return new IManifestHelper[]{new ManifestHelper_VuiEngine()};
            }
        });
    }
}
