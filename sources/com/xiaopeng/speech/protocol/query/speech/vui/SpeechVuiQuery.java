package com.xiaopeng.speech.protocol.query.speech.vui;

import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.SpeechQuery;
import com.xiaopeng.speech.annotation.QueryAnnotation;
import com.xiaopeng.speech.protocol.event.query.speech.SpeechVuiEvent;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SpeechVuiQuery extends SpeechQuery<ISpeechVuiQueryCaller> {
    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_XSWITCH_CHECKED)
    public boolean isSwitchChecked(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).isSwitchChecked(jSONObject.optString("elementId", ""), jSONObject.optString(VuiConstants.SCENE_ID, ""), jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, ""), jSONObject.optString("packageVersion", ""));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_XTABLAYOUT_SELECTED)
    public boolean isTableLayoutSelected(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).isTableLayoutSelected(jSONObject.optInt(CPSearchParam.PARAM_KEY_INDEX, 0), jSONObject.optString("elementId", ""), jSONObject.optString(VuiConstants.SCENE_ID, ""), jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, ""), jSONObject.optString("packageVersion", ""));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_XSLIDER_SETVALUE)
    public int getXSliderIndex(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).getXSliderIndex(jSONObject.optString("elementId", ""), jSONObject.optString(VuiConstants.SCENE_ID, ""), jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, ""), jSONObject.optString("packageVersion", ""));
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_STATEFULBUTTON_CHECKED)
    public boolean isStatefulButtonChecked(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).isStatefulButtonChecked(jSONObject.optString("elementId", ""), jSONObject.optString(VuiConstants.SCENE_ID, ""), jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, ""), jSONObject.optString("packageVersion", ""));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_STATEFULBUTTON_SETVALUE)
    public String getStatefulButtonValue(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).getStatefulButtonValue(jSONObject.optString("elementId", ""), jSONObject.optString(VuiConstants.SCENE_ID, ""), jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, ""), jSONObject.optString("packageVersion", ""));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_ELEMENT_ENABLED)
    public boolean isElementEnabled(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).isElementEnabled(jSONObject.optString("elementId", ""), jSONObject.optString(VuiConstants.SCENE_ID, ""), jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, ""), jSONObject.optString("packageVersion", ""));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_ELEMENT_SCROLL_STATE)
    public boolean isElementCanScrolled(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).isElementCanScrolled(jSONObject.optString(VuiConstants.EVENT_VALUE_DIRECTION, ""), jSONObject.optString("elementId", ""), jSONObject.optString(VuiConstants.SCENE_ID, ""), jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, ""), jSONObject.optString("packageVersion", ""));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_SWITCH_OPENED)
    public boolean isVuiSwitchOpened() {
        return ((ISpeechVuiQueryCaller) this.mQueryCaller).isVuiSwitchOpened();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_ELEMENT_CHECKBOX_CHECKED)
    public boolean isCheckBoxChecked(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).isCheckBoxChecked(jSONObject.optString("elementId", ""), jSONObject.optString(VuiConstants.SCENE_ID, ""), jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, ""), jSONObject.optString("packageVersion", ""));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_ELEMENT_RADIOBUTTON_CHECKED)
    public boolean isRadiobuttonChecked(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).isRadiobuttonChecked(jSONObject.optString("elementId", ""), jSONObject.optString(VuiConstants.SCENE_ID, ""), jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, ""), jSONObject.optString("packageVersion", ""));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_SCROLLVIEW_CHILD_VIEW_VISIBLE)
    public String isViewVisibleByScrollView(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONArray optJSONArray = jSONObject.optJSONArray(VuiConstants.SCENE_ELEMENTS);
            String optString = jSONObject.optString(VuiConstants.SCENE_ID, "");
            String optString2 = jSONObject.optString(VuiConstants.SCENE_PACKAGE_NAME, "");
            String optString3 = jSONObject.optString(VuiConstants.SCENE_APP_VERSION, "");
            String optString4 = jSONObject.optString("msgId");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("msgId", optString4);
            jSONObject2.put(VuiConstants.SCENE_ID, optString);
            jSONObject2.put(VuiConstants.SCENE_ELEMENTS, optJSONArray);
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).isViewVisibleByScrollView(optString2, optString, String.valueOf(jSONObject2), optString3);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = SpeechVuiEvent.VUI_REBUILD_SCENE)
    public boolean rebuildScene(String str, String str2) {
        try {
            JSONArray optJSONArray = new JSONObject(str2).optJSONArray("sceneIds");
            String[] strArr = null;
            if (optJSONArray != null) {
                strArr = new String[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    strArr[i] = optJSONArray.optString(i);
                }
            }
            return ((ISpeechVuiQueryCaller) this.mQueryCaller).reBuildScene(strArr);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
