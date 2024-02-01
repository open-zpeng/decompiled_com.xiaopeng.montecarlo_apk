package com.xiaopeng.speech.protocol.node.scene;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.speech.SpeechNode;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import com.xiaopeng.speech.protocol.event.VuiEvent;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SceneNode extends SpeechNode<SceneListener> {
    List<String> supportAppNameList = Arrays.asList("com.android.systemui", "com.xiaopeng.chargecontrol", VuiConstants.SCENEDEMO, "com.xiaopeng.carspeechservice", "com.xiaopeng.caraccount");

    @SpeechAnnotation(event = VuiEvent.SCENE_CONTROL)
    public void onSceneEvent(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String optString = new JSONObject(str2).optString(VuiConstants.SCENE_ID);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            String str3 = null;
            if (optString.contains("-")) {
                str3 = optString.split("-")[0];
            } else if (optString.contains(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT)) {
                str3 = optString.split(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT)[0];
            }
            if (!TextUtils.isEmpty(str3) && this.supportAppNameList.contains(str3)) {
                callSceneEvent(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    @SpeechAnnotation(event = VuiEvent.SCENE_DM_START)
    public void onDMStart(String str, String str2) {
        callSceneEvent("jarvis.dm.start", str2);
    }

    @SpeechAnnotation(event = VuiEvent.SCENE_DM_END)
    public void onDMEnd(String str, String str2) {
        callSceneEvent("jarvis.dm.end", str2);
    }

    @SpeechAnnotation(event = VuiEvent.SCENE_VUI_ENABLE)
    public void onVuiEnable(String str, String str2) {
        callSceneEvent("enable.vui.feature", str2);
    }

    @SpeechAnnotation(event = VuiEvent.SCENE_VUI_DISABLE)
    public void onVuiDisable(String str, String str2) {
        callSceneEvent("disable.vui.feature", str2);
    }

    @SpeechAnnotation(event = "scene.rebuild")
    public void onRebuild(String str, String str2) {
        callSceneEvent(str, str2);
    }

    private void callSceneEvent(String str, String str2) {
        try {
            Object[] collectCallbacks = this.mListenerList.collectCallbacks();
            if (collectCallbacks != null) {
                for (Object obj : collectCallbacks) {
                    ((SceneListener) obj).onSceneEvent(str, str2);
                }
            }
        } catch (Exception unused) {
        }
    }
}
