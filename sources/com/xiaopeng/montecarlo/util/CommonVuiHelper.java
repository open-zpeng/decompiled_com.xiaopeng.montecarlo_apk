package com.xiaopeng.montecarlo.util;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.montecarlo.views.ChildPoiGridView;
import com.xiaopeng.montecarlo.views.poicard.PoiCardView;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.vui.commons.VuiElementType;
import com.xiaopeng.vui.commons.model.AnimationObj;
import com.xiaopeng.vui.commons.model.VuiElement;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.vui.IVuiViewScene;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.vui.utils.VuiUtils;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XTextView;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommonVuiHelper {
    public static final String KEY_CAN_SPEECH_CONTROL = "canVoiceControl";
    public static final String KEY_CURRENT_STATE = "curState";
    private static final String KEY_EXEC_ELEMENT = "execElementId";
    public static final String KEY_GENERAL_ACT = "generalAct";
    private static final String KEY_NAV_DESTINATION = "poiInfo";
    private static final String KEY_NAV_WAY_POINT = "waypointInfos";
    public static final String KEY_STATES = "states";
    private static final L.Tag TAG = new L.Tag("CommonVuiHelper");
    private static volatile CommonVuiHelper sInstance = new CommonVuiHelper();
    public static final String[] sIndexArr = ContextUtils.getStringArray(R.array.vui_label_cn_index_arr);

    public static CommonVuiHelper getInstance() {
        return sInstance;
    }

    public void formatChildPoi(ChildPoiGridView childPoiGridView, String str, int i, String str2, String str3) {
        String str4 = childPoiGridView.getId() + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + i;
        List<XTextView> subButtons = childPoiGridView.getSubButtons();
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("formatChildPoi subButtons:" + subButtons.size()));
        }
        if (CollectionUtils.isNotEmpty(subButtons)) {
            for (int i2 = 0; i2 < subButtons.size(); i2++) {
                if (L.ENABLE) {
                    L.d(TAG, L.formatVoiceFullScenesLog("formatChildPoi index:" + i2));
                }
                XTextView xTextView = subButtons.get(i2);
                String str5 = str4 + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + xTextView.getId() + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + i2 + "" + str2;
                if (L.ENABLE) {
                    L.d(TAG, L.formatVoiceFullScenesLog("formatChildPoi button tag:" + xTextView.getTag()));
                }
                VoiceFullScenesUtil.setVuiElementTag(xTextView, str5);
                if (L.ENABLE) {
                    L.d(TAG, L.formatVoiceFullScenesLog("formatChildPoi childPoiGridView item id:" + xTextView.getId() + ",elementId:" + xTextView.getVuiElementId() + ",label:" + xTextView.getVuiLabel()));
                }
            }
        }
        XImageButton ivExpand = childPoiGridView.getIvExpand();
        if (ivExpand != null) {
            ivExpand.setId(R.id.vui_element_id_sub_poi_expand);
            ivExpand.setVuiElementType(VuiElementType.BUTTON);
            VoiceFullScenesUtil.setVuiElementTag(ivExpand, str4 + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + ivExpand.getId() + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + i);
            ivExpand.setVuiLabel(ContextUtils.getString(R.string.vui_label_search_expand_sub_poi));
        }
    }

    public String getIndexString(int i) {
        if (i >= 0) {
            String[] strArr = sIndexArr;
            if (i >= strArr.length) {
                return null;
            }
            return strArr[i];
        }
        return null;
    }

    public void dialPhoneNumberForVui(XPPoiInfo xPPoiInfo, MainContext mainContext) {
        if (xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo.getTel())) {
            L.w(TAG, L.formatVoiceFullScenesLog("dialPhoneNumberForVui failure"));
            return;
        }
        String tel = xPPoiInfo.getTel();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "dialPhoneNumberForVui tel:" + tel);
        }
        String[] split = tel.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
        if (split == null || split.length <= 0) {
            return;
        }
        String str = split[0];
        IBaseScene currentScene = mainContext.getCurrentScene();
        if (currentScene != null) {
            currentScene.dialNum(str);
        }
    }

    public JSONObject formatNavElement(XPPoiInfo xPPoiInfo) {
        return formatNavElement(xPPoiInfo, null);
    }

    public JSONObject formatNavElement(XPPoiInfo xPPoiInfo, List<XPPoiInfo> list) {
        JSONObject jSONObject = new JSONObject();
        if (xPPoiInfo != null) {
            try {
                jSONObject.put("poiInfo", xPPoiInfo.toPoiBean().toJson());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (CollectionUtils.isNotEmpty(list)) {
            JSONArray jSONArray = new JSONArray();
            for (XPPoiInfo xPPoiInfo2 : list) {
                jSONArray.put(xPPoiInfo2.toPoiBean().toJson());
            }
            jSONObject.put("waypointInfos", jSONArray);
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("formatNavElement end:" + xPPoiInfo + ",vias:" + list + ",props:" + jSONObject));
        }
        return jSONObject;
    }

    public String formatElementFatherLabelForSearch(int i, CharSequence charSequence, CharSequence charSequence2) {
        return formatElementFatherLabelForSearch(i, charSequence, charSequence2, 0, null);
    }

    public String formatElementFatherLabelForSearch(int i, CharSequence charSequence, CharSequence charSequence2, int i2, TextView textView) {
        int i3;
        StringBuilder sb = new StringBuilder();
        if (textView != null && !TextUtils.isEmpty(textView.getText())) {
            String indexString = getIndexString(Integer.valueOf(textView.getText().toString()).intValue() - 1);
            if (!TextUtils.isEmpty(indexString)) {
                sb.append(String.format(ContextUtils.getString(R.string.vui_label_search_item_index), indexString));
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
            }
        } else if (i >= 0 && (i3 = i - i2) >= 0) {
            String indexString2 = getIndexString(i3);
            if (!TextUtils.isEmpty(indexString2)) {
                sb.append(String.format(ContextUtils.getString(R.string.vui_label_search_item_index), indexString2));
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence.toString());
            sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            sb.append(charSequence2.toString());
            sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "formatElementFatherLabelForSearch position:" + i + ",destName:" + ((Object) charSequence) + ",addressName:" + ((Object) charSequence2) + ",firstVisiblePosition:" + i2 + ",order:" + textView + ",label:" + sb.toString());
        }
        return sb.toString();
    }

    public void setVuiLabel(VuiView vuiView, String str, String str2) {
        if (vuiView != null) {
            vuiView.setVuiLabel(String.format("%s|%s", str, str2));
        }
    }

    public void setExecElement(VuiView vuiView, String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("setExecElement vuiView:" + vuiView + ",execElementId:" + str));
        }
        if (vuiView != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject vuiProps = vuiView.getVuiProps();
                if (vuiProps == null) {
                    vuiProps = new JSONObject();
                }
                vuiProps.put(KEY_EXEC_ELEMENT, str);
                vuiView.setVuiProps(vuiProps);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dynamicUpdateStatefullButtonAttr(MainContext mainContext, View view, VuiView vuiView, String str, String[] strArr) {
        dynamicUpdateStatefullButtonAttr(mainContext, view, vuiView, str, strArr, true);
    }

    public void dynamicUpdateStatefullButtonAttr(MainContext mainContext, View view, VuiView vuiView, String str, String[] strArr, boolean z) {
        if (mainContext == null || view == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                i = -1;
                break;
            } else if (str.equals(strArr[i])) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            vuiView.setVuiElementType(VuiElementType.STATEFULBUTTON);
            VuiUtils.setStatefulButtonAttr(vuiView, i, strArr);
            if (z) {
                VoiceFullScenesUtil.updateScene(mainContext.getCurrentScene(), view);
            }
        }
    }

    public boolean handleCommonVuiEvent(View view, VuiEvent vuiEvent, IBaseScene iBaseScene) {
        try {
            if (view.getId() != R.id.poi_btn_contact) {
                return false;
            }
            execPoiCardBtnContactClick(view, iBaseScene);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void execPoiCardBtnContactClick(View view, final IBaseScene iBaseScene) {
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.util.CommonVuiHelper.1
            @Override // java.lang.Runnable
            public void run() {
                PoiCardView poiCard = iBaseScene.getPoiCard();
                if (poiCard != null) {
                    poiCard.dialPhoneNumberForVui();
                }
            }
        }, 2000L);
    }

    public void updateCheckboxStateForVui(MainContext mainContext, View view, VuiView vuiView, boolean z, boolean z2) {
        if (mainContext == null || view == null || vuiView == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("updateCheckboxStateForVui view:" + view + ",isSelected:" + z + ",needUpdate:" + z2));
        }
        vuiView.setVuiAction(ContextUtils.getString(R.string.vui_action_set_check));
        vuiView.setVuiElementType(VuiElementType.CHECKBOX);
        view.setSelected(z);
        if (z2) {
            VoiceFullScenesUtil.updateScene(mainContext.getCurrentScene(), view);
        }
    }

    public void updateCheckboxStateForVui(MainContext mainContext, View view, VuiView vuiView, boolean z) {
        updateCheckboxStateForVui(mainContext, view, vuiView, z, true);
    }

    public void addDialogVuiSupport(IVuiViewScene iVuiViewScene, String str) {
        if (iVuiViewScene == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("addDialogVuiSupport sceneId:" + str + ",dialog:" + iVuiViewScene));
        }
        iVuiViewScene.setVuiEngine(VuiEngine.getInstance(ContextUtils.getContext()));
        iVuiViewScene.setVuiSceneId(str);
    }

    public void enableCanSpeechControl(MainContext mainContext, VuiView vuiView, View view) {
        enableCanSpeechControl(mainContext, vuiView, view, true);
    }

    public void disableCanSpeechControl(MainContext mainContext, VuiView vuiView, View view, boolean z) {
        switchCanSpeechControl(mainContext, vuiView, view, z, false);
    }

    public void enableCanSpeechControl(MainContext mainContext, VuiView vuiView, View view, boolean z) {
        switchCanSpeechControl(mainContext, vuiView, view, z, true);
    }

    public void switchCanSpeechControl(MainContext mainContext, VuiView vuiView, View view, boolean z, boolean z2) {
        if (mainContext == null || vuiView == null || vuiView == null) {
            return;
        }
        try {
            JSONObject vuiProps = vuiView.getVuiProps();
            if (vuiProps == null) {
                vuiProps = new JSONObject();
            }
            if (vuiProps.has("canVoiceControl") && vuiProps.getBoolean("canVoiceControl") == z2) {
                return;
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("switchCanSpeechControl vuiView:" + vuiView + ",enable:" + z2));
            }
            vuiProps.put("canVoiceControl", z2);
            vuiView.setVuiProps(vuiProps);
            if (z) {
                VoiceFullScenesUtil.updateScene(mainContext.getCurrentScene(), view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void markGeneralAction(String str, MainContext mainContext, VuiView vuiView, View view, boolean z) {
        if (mainContext == null || vuiView == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("markGeneralAction vuiView:" + vuiView + ",action:" + str));
        }
        if (vuiView != null) {
            try {
                JSONObject vuiProps = vuiView.getVuiProps();
                if (vuiProps == null) {
                    vuiProps = new JSONObject();
                }
                vuiProps.put("generalAct", str);
                vuiView.setVuiProps(vuiProps);
                if (z) {
                    VoiceFullScenesUtil.updateScene(mainContext.getCurrentScene(), view);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isCanUpdateVui(MainContext mainContext) {
        IBaseScene currentScene;
        if (mainContext == null || (currentScene = mainContext.getCurrentScene()) == null || Utils.isEmptyScene(currentScene) || !currentScene.isSceneVuiEnabled()) {
            return false;
        }
        IBaseScene topChildScene = currentScene.getTopChildScene();
        if (topChildScene != null) {
            L.Tag tag = TAG;
            L.w(tag, L.formatVoiceFullScenesLog("isCanUpdateVui is illegal topChild:" + topChildScene + "scene:" + currentScene));
            return false;
        }
        return true;
    }

    public void executeVuiEventBaseOperation(IBaseScene iBaseScene, View view) {
        if (iBaseScene == null || !iBaseScene.isSceneVuiEnabled() || Utils.isEmptyScene(iBaseScene)) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "executeVuiEventBaseOperation scene:" + iBaseScene + ",view:" + view);
        }
        iBaseScene.mockDispatchTouchEventForVui(view);
        StateManager.getInstance().switchActiveState();
    }

    public boolean isEffectOnly(View view, VuiEvent vuiEvent) {
        VuiElement hitVuiElement;
        if (vuiEvent == null || (hitVuiElement = vuiEvent.getHitVuiElement()) == null) {
            return false;
        }
        AnimationObj animationObj = hitVuiElement.animation;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onInterceptVuiEvent view:" + view + ",element:" + hitVuiElement + ",animationObj:" + animationObj));
        }
        if (animationObj == null || !animationObj.isEffectOnly()) {
            return false;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, L.formatVoiceFullScenesLog("onInterceptVuiEvent is only effect,view:" + view));
        return true;
    }

    public boolean isViewVisible(View view) {
        boolean isShown = view == null ? false : view.isShown();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("isViewVisible flag:" + isShown + ",view:" + view));
        }
        return isShown;
    }

    public boolean isSceneVuiSupport() {
        boolean isSceneVuiSupport = VoiceFullScenesUtil.isSceneVuiSupport();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isSceneVuiSupport isSupport:" + isSceneVuiSupport + ",carType:" + CarServiceManager.getInstance().getCarType());
        }
        return isSceneVuiSupport;
    }
}
