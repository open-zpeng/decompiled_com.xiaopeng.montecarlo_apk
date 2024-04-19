package com.xiaopeng.montecarlo.scenes.mapscene;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseFullScenes;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.MapScaleLineView;
import com.xiaopeng.montecarlo.views.mapmode.DrawModeType;
import com.xiaopeng.montecarlo.views.mapmode.MapModeIconView;
import com.xiaopeng.vui.commons.VuiElementType;
import com.xiaopeng.vui.commons.model.VuiElement;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MapVuiHelper {
    private static final String PREFIX_PATTERN_STATE = "state_";
    public static final int TYPE_CLEAR_ON_GREATER_THAN_20KM = 2;
    public static final int TYPE_CLEAR_ON_NEW_ROUTE = 1;
    public static final int TYPE_CLEAR_PAGE_DESTORY = 0;
    private static final String[] sMapModeLabelArr;
    private static final Map<String, String> sMapModeLabelStateMap;
    private static final Map<String, DrawModeType> sMapModeLabelValueMap;
    private static final JSONArray sMapModeStates;
    private static final String[] sMapScaleLabelArr;
    private static final Map<String, String> sMapScaleLabelStateMap;
    private static final Map<String, Integer> sMapScaleLabelValueMap;
    private static final JSONArray sMapScaleSates;
    private static final SparseArray<Integer> sMapScaleValues;
    private static final Integer[] sMapScaleValuesArr;
    private static final JSONArray sMapSwitchStates;
    private static final L.Tag TAG = new L.Tag("MapVuiHelper");
    private static volatile MapVuiHelper sInstance = new MapVuiHelper();
    private static final SparseArray<DrawModeType> sMapModeValues = new SparseArray<>();
    private static final DrawModeType[] sMapModeValuesArr = {DrawModeType.NORTHUP, DrawModeType.HEADUP_2D, DrawModeType.HEADUP_3D};
    private Hashtable<Integer, String> mAlterLabelTable = new Hashtable<>();
    private MapPrepareLayerStyle.MultiAlternativePathLabelViewHolder mMultiRputeLabelHolder = null;
    private final String[] mAlterLabelStateArr = ContextUtils.getStringArray(R.array.vui_label_map_style_alternative_path_state_arr);
    private String[] mAlterLabelRealArr = null;

    static {
        formatValuesArr(sMapModeValues, sMapModeValuesArr);
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("init map mode values sMapModeValues:" + sMapModeValues));
        }
        sMapModeLabelArr = ContextUtils.getStringArray(R.array.vui_label_map_btn_map_mode_arr);
        sMapModeLabelStateMap = new HashMap();
        formatLabelStateMap(sMapModeLabelStateMap, sMapModeLabelArr);
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("init map mode label state map sMapModeLabelStateMap:" + sMapModeLabelStateMap));
        }
        sMapModeStates = new JSONArray();
        formatStates(sMapModeStates, sMapModeValues, sMapModeLabelArr);
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("init map mode states sMapModeStates:" + sMapModeStates));
        }
        sMapModeLabelValueMap = new HashMap();
        formatLabelValueMap(sMapModeLabelValueMap, sMapModeLabelArr, sMapModeValues);
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("init map mode value map sMapModeLabelValueMap:" + sMapModeLabelValueMap));
        }
        sMapScaleLabelArr = ContextUtils.getStringArray(R.array.vui_label_map_scale_arr);
        sMapScaleValuesArr = new Integer[]{19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3};
        sMapScaleValues = new SparseArray<>();
        formatValuesArr(sMapScaleValues, sMapScaleValuesArr);
        if (L.ENABLE) {
            L.d(TAG, "init map scale values sMapScaleValues:" + sMapScaleValues);
        }
        sMapScaleSates = new JSONArray();
        formatStates(sMapScaleSates, sMapScaleValues, sMapScaleLabelArr);
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("init map scale states sMapScaleSates:" + sMapScaleSates));
        }
        sMapScaleLabelStateMap = new HashMap();
        formatLabelStateMap(sMapScaleLabelStateMap, sMapScaleLabelArr);
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("init map scale label state map sMapScaleLabelStateMap:" + sMapScaleLabelStateMap));
        }
        sMapScaleLabelValueMap = new HashMap();
        formatLabelValueMap(sMapScaleLabelValueMap, sMapScaleLabelArr, sMapScaleValues);
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("init map scale label value map sMapScaleLabelValueMap:" + sMapScaleLabelValueMap));
        }
        sMapSwitchStates = new JSONArray();
        formatStates(sMapSwitchStates, 2, ContextUtils.getStringArray(R.array.vui_label_map_switch_arr));
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("init map switch label state map sMapSwitchStates:" + sMapSwitchStates));
        }
    }

    public static MapVuiHelper getInstance() {
        return sInstance;
    }

    private static void formatValuesArr(SparseArray sparseArray, Object[] objArr) {
        for (int i = 0; i < objArr.length; i++) {
            sparseArray.put(i, objArr[i]);
        }
    }

    private static void formatStates(JSONArray jSONArray, SparseArray sparseArray, String[] strArr) {
        int i = 0;
        while (i < sparseArray.size()) {
            try {
                JSONObject jSONObject = new JSONObject();
                int i2 = i + 1;
                jSONObject.put(String.format("%s%d", PREFIX_PATTERN_STATE, Integer.valueOf(i2)), strArr[i]);
                jSONArray.put(jSONObject);
                i = i2;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private static void formatStates(JSONArray jSONArray, int i, String[] strArr) {
        int i2 = 0;
        while (i2 < i) {
            try {
                JSONObject jSONObject = new JSONObject();
                int i3 = i2 + 1;
                jSONObject.put(String.format("%s%d", PREFIX_PATTERN_STATE, Integer.valueOf(i3)), strArr[i2]);
                jSONArray.put(jSONObject);
                i2 = i3;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private static void formatLabelValueMap(Map map, String[] strArr, SparseArray sparseArray) {
        if (map == null || strArr == null || sparseArray == null) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (!TextUtils.isEmpty(str)) {
                map.put(str, sparseArray.valueAt(i));
                String[] split = str.split("\\|");
                if (split != null) {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2)) {
                            map.put(str2, sparseArray.valueAt(i));
                        }
                    }
                }
            }
        }
    }

    private static void formatLabelStateMap(Map map, String[] strArr) {
        if (map == null || strArr == null) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (!TextUtils.isEmpty(str)) {
                int i2 = i + 1;
                map.put(str, String.format("%s%d", PREFIX_PATTERN_STATE, Integer.valueOf(i2)));
                String[] split = str.split("\\|");
                if (split != null) {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2)) {
                            map.put(str2, String.format("%s%d", PREFIX_PATTERN_STATE, Integer.valueOf(i2)));
                        }
                    }
                }
            }
        }
    }

    public void formatMapMode(final MainContext mainContext, final MapModeIconView mapModeIconView) {
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("formatMapMode for vui"));
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.1
            @Override // java.lang.Runnable
            public void run() {
                final JSONObject formatMapModeProps = MapVuiHelper.this.formatMapModeProps(mapModeIconView);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        mapModeIconView.setVuiElementType(VuiElementType.STATEFULBUTTON);
                        mapModeIconView.setVuiAction(String.format("%s|%s", ContextUtils.getString(R.string.vui_action_click), ContextUtils.getString(R.string.vui_action_set_value)));
                        mapModeIconView.setVuiProps(formatMapModeProps);
                        VoiceFullScenesUtil.updateScene(mainContext.getCurrentScene(), mapModeIconView);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject formatMapModeProps(MapModeIconView mapModeIconView) {
        JSONObject vuiProps = mapModeIconView.getVuiProps();
        if (vuiProps == null) {
            vuiProps = new JSONObject();
        }
        try {
            vuiProps.put(CommonVuiHelper.KEY_STATES, sMapModeStates);
            vuiProps.put(CommonVuiHelper.KEY_CURRENT_STATE, getCurrStateDesc(mapModeIconView));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("formatMapModeProps props:" + vuiProps));
        }
        return vuiProps;
    }

    public void formatSRSwitch(final MainContext mainContext, final XImageView xImageView, final boolean z) {
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("formatSRSwitch for vui"));
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.2
            @Override // java.lang.Runnable
            public void run() {
                final JSONObject formatSRSwitchProps = MapVuiHelper.this.formatSRSwitchProps(xImageView, z);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xImageView.setVuiElementType(VuiElementType.STATEFULBUTTON);
                        xImageView.setVuiAction(String.format("%s|%s", ContextUtils.getString(R.string.vui_action_click), ContextUtils.getString(R.string.vui_action_set_value)));
                        xImageView.setVuiProps(formatSRSwitchProps);
                        VoiceFullScenesUtil.updateScene(mainContext.getCurrentScene(), xImageView);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject formatSRSwitchProps(XImageView xImageView, boolean z) {
        JSONObject vuiProps = xImageView.getVuiProps();
        if (vuiProps == null) {
            vuiProps = new JSONObject();
        }
        int i = z ? 1 : 2;
        try {
            vuiProps.put(CommonVuiHelper.KEY_STATES, sMapSwitchStates);
            vuiProps.put(CommonVuiHelper.KEY_CURRENT_STATE, getStateDescByStateIndex(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("formatSRSwitchProps props:" + vuiProps));
        }
        return vuiProps;
    }

    private String getCurrStateDesc(MapModeIconView mapModeIconView) {
        String str = sMapModeLabelArr[sMapModeValues.indexOfValue(mapModeIconView.getMode())];
        String str2 = sMapModeLabelStateMap.get(str);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("getCurrStateDesc currentState:" + str2 + ",label:" + str));
        }
        return str2;
    }

    private String getStateDescByStateIndex(int i) {
        if (i > 0) {
            return String.format(Locale.getDefault(), "%s%d", PREFIX_PATTERN_STATE, Integer.valueOf(i));
        }
        throw new IllegalArgumentException("stateIndex must be greater than 1!");
    }

    public DrawModeType getStateToBeChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return sMapModeLabelValueMap.get(str);
    }

    public int getMapScaleToBeChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1000;
        }
        int intValue = sMapScaleLabelValueMap.get(str).intValue();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("getMapScaleToBeChanged query:" + str + ",level:" + intValue));
        }
        return intValue;
    }

    public boolean dispatchVuiEvent(MainContext mainContext, View view, VuiEvent vuiEvent) {
        VuiElement hitVuiElement;
        if (vuiEvent == null || view == null || (hitVuiElement = vuiEvent.getHitVuiElement()) == null) {
            return false;
        }
        switch (view.getId()) {
            case R.id.btn_map_mode /* 2131296431 */:
                handleMapModeVuiEvent(mainContext, hitVuiElement);
                return true;
            case R.id.btn_overview /* 2131296433 */:
                handleMapOverviewVuiEvent(mainContext, hitVuiElement, view);
                return true;
            case R.id.btn_parallel /* 2131296434 */:
                handleParallelVuiEvent(mainContext, hitVuiElement, view);
                return true;
            case R.id.map_scale_text_bg /* 2131296918 */:
                handleMapScaleVuiEvent(mainContext, hitVuiElement);
                return true;
            case R.id.sr_normal_switch /* 2131297385 */:
                view.performClick();
                return true;
            default:
                return false;
        }
    }

    private void handleParallelVuiEvent(final MainContext mainContext, VuiElement vuiElement, final View view) {
        Map map;
        try {
            Map map2 = (Map) vuiElement.getValues();
            if (map2 != null) {
                List<String> list = vuiElement.resultActions;
                if (CollectionUtils.isNotEmpty(list) && list.contains("SetValue") && (map = (Map) map2.get("SetValue")) != null) {
                    String str = (String) map.get("value");
                    L.Tag tag = TAG;
                    L.i(tag, L.formatVoiceFullScenesLog("handleParallelVuiEvent query:" + str));
                    String[] stringArray = ContextUtils.getStringArray(R.array.vui_label_map_btn_parallel_state_arr);
                    boolean z = mainContext.getRoadChangeStatus() == 1;
                    if (z && stringArray[0].equals(str)) {
                        L.w(TAG, L.formatVoiceFullScenesLog("handleParallelVuiEvent already in main road"));
                    } else if (!z && stringArray[1].equals(str)) {
                        L.w(TAG, L.formatVoiceFullScenesLog("handleParallelVuiEvent already in assist road"));
                    } else {
                        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.3
                            @Override // java.lang.Runnable
                            public void run() {
                                mainContext.switchRoadChangeForVui(view);
                            }
                        });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleMapOverviewVuiEvent(final MainContext mainContext, VuiElement vuiElement, final View view) {
        Map map;
        try {
            Map map2 = (Map) vuiElement.getValues();
            if (map2 != null) {
                List<String> list = vuiElement.resultActions;
                if (CollectionUtils.isNotEmpty(list) && list.contains("SetValue") && (map = (Map) map2.get("SetValue")) != null) {
                    String str = (String) map.get("value");
                    L.Tag tag = TAG;
                    L.i(tag, L.formatVoiceFullScenesLog("handleMapOverviewVuiEvent query:" + str));
                    String[] stringArray = ContextUtils.getStringArray(R.array.vui_label_map_btn_overview_state_arr);
                    if (view.isSelected() && stringArray[0].equals(str)) {
                        L.w(TAG, L.formatVoiceFullScenesLog("handleMapOverviewVuiEvent already exit overview"));
                    } else if (!view.isSelected() && stringArray[1].equals(str)) {
                        L.w(TAG, L.formatVoiceFullScenesLog("handleMapOverviewVuiEvent already in overview"));
                    } else {
                        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.4
                            @Override // java.lang.Runnable
                            public void run() {
                                mainContext.switchMapOverviewForVui(view);
                            }
                        });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleMapScaleVuiEvent(final MainContext mainContext, VuiElement vuiElement) {
        Map map;
        try {
            Map map2 = (Map) vuiElement.getValues();
            if (map2 != null) {
                List<String> list = vuiElement.resultActions;
                if (CollectionUtils.isNotEmpty(list) && list.contains("SetValue") && (map = (Map) map2.get("SetValue")) != null) {
                    String str = (String) map.get("value");
                    final int mapScaleToBeChanged = getMapScaleToBeChanged(str);
                    L.Tag tag = TAG;
                    L.i(tag, L.formatVoiceFullScenesLog("handleMapScaleVuiEvent level:" + mapScaleToBeChanged + ",query:" + str));
                    if (mapScaleToBeChanged != -1000) {
                        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.5
                            @Override // java.lang.Runnable
                            public void run() {
                                mainContext.switchMapScaleForVui(mapScaleToBeChanged);
                            }
                        });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleMapModeVuiEvent(final MainContext mainContext, VuiElement vuiElement) {
        try {
            Map map = (Map) vuiElement.getValues();
            if (map != null) {
                List<String> list = vuiElement.resultActions;
                if (CollectionUtils.isNotEmpty(list) && list.contains("SetValue")) {
                    Map map2 = (Map) map.get("SetValue");
                    if (map2 != null) {
                        final DrawModeType stateToBeChanged = getStateToBeChanged((String) map2.get("value"));
                        L.Tag tag = TAG;
                        L.i(tag, L.formatVoiceFullScenesLog("handleMapModeVuiEvent type:" + stateToBeChanged));
                        if (stateToBeChanged != null) {
                            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    mainContext.switchMapModeForVui(stateToBeChanged);
                                }
                            });
                        }
                    }
                } else {
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.7
                        @Override // java.lang.Runnable
                        public void run() {
                            mainContext.switchMapModeForVui(null);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void formatMapScaleTextContainer(final MainContext mainContext, final MapScaleLineView mapScaleLineView, final XTextView xTextView) {
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("formatMapScaleTextContainer for vui"));
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.8
            @Override // java.lang.Runnable
            public void run() {
                final JSONObject formatMapScaleTextContainerProps = MapVuiHelper.this.formatMapScaleTextContainerProps(mapScaleLineView, xTextView);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        mapScaleLineView.setVuiElementType(VuiElementType.STATEFULBUTTON);
                        mapScaleLineView.setVuiAction(String.format("%s|%s", ContextUtils.getString(R.string.vui_action_click), ContextUtils.getString(R.string.vui_action_set_value)));
                        mapScaleLineView.setVuiProps(formatMapScaleTextContainerProps);
                        VoiceFullScenesUtil.updateScene(mainContext.getCurrentScene(), mapScaleLineView);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject formatMapScaleTextContainerProps(MapScaleLineView mapScaleLineView, XTextView xTextView) {
        JSONObject vuiProps = mapScaleLineView.getVuiProps();
        if (vuiProps == null) {
            vuiProps = new JSONObject();
        }
        try {
            vuiProps.put(CommonVuiHelper.KEY_STATES, sMapScaleSates);
            vuiProps.put(CommonVuiHelper.KEY_CURRENT_STATE, getMapScaleCurrStateDesc(xTextView));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("formatMapScaleTextContainerProps props:" + vuiProps));
        }
        return vuiProps;
    }

    private String getMapScaleCurrStateDesc(XTextView xTextView) {
        if (xTextView != null) {
            CharSequence text = xTextView.getText();
            if (!TextUtils.isEmpty(text)) {
                String replaceAll = text.toString().replaceAll(FDManager.LINE_SEPERATOR, "");
                String str = sMapScaleLabelStateMap.get(replaceAll);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, L.formatVoiceFullScenesLog("getMapScaleCurrStateDesc text:" + replaceAll.toString() + ",currState:" + str));
                    return str;
                }
                return str;
            }
        }
        return null;
    }

    public void updateRoadChangeForVui(MainContext mainContext, boolean z, int i, XImageButton xImageButton) {
        String[] stringArray;
        if (xImageButton != null) {
            if (z) {
                stringArray = ContextUtils.getStringArray(R.array.vui_label_map_btn_parallel_state_bridge_arr);
            } else {
                stringArray = ContextUtils.getStringArray(R.array.vui_label_map_btn_parallel_state_arr);
            }
            String[] strArr = stringArray;
            CommonVuiHelper.getInstance().dynamicUpdateStatefullButtonAttr(mainContext, xImageButton, xImageButton, i == 1 ? strArr[0] : strArr[1], strArr);
        }
    }

    public void updateOverviewForVui(final MainContext mainContext, final XImageButton xImageButton) {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper.9
            @Override // java.lang.Runnable
            public void run() {
                if (xImageButton != null) {
                    String[] stringArray = ContextUtils.getStringArray(R.array.vui_label_map_btn_overview_state_arr);
                    String str = xImageButton.isSelected() ? stringArray[0] : stringArray[1];
                    CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
                    MainContext mainContext2 = mainContext;
                    XImageButton xImageButton2 = xImageButton;
                    commonVuiHelper.dynamicUpdateStatefullButtonAttr(mainContext2, xImageButton2, xImageButton2, str, stringArray);
                }
            }
        });
    }

    public void formatAlterLabelForVui(MainContext mainContext, MapPrepareLayerStyle.MultiAlternativePathLabelViewHolder multiAlternativePathLabelViewHolder, int i, long j) {
        if (VoiceFullScenesUtil.isSceneVuiSupport()) {
            this.mMultiRputeLabelHolder = multiAlternativePathLabelViewHolder;
            IBaseScene currentScene = mainContext.getCurrentScene();
            if (currentScene == null || !currentScene.isSceneVuiEnabled()) {
                return;
            }
            if (Utils.isRouteScene(currentScene) || Utils.isExploreScene(currentScene) || Utils.isNaviScene(currentScene)) {
                resetAlterLabelTable(j);
                CommonVuiHelper.getInstance().enableCanSpeechControl(mainContext, multiAlternativePathLabelViewHolder.mLayout, multiAlternativePathLabelViewHolder.mLayout, false);
                StringBuilder sb = new StringBuilder();
                sb.append(getRouteInfoIndexForVui(i));
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                if (!TextUtils.isEmpty(multiAlternativePathLabelViewHolder.mTvTime.getText())) {
                    sb.append(multiAlternativePathLabelViewHolder.mTvTime.getText().toString());
                    sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                }
                if (!TextUtils.isEmpty(multiAlternativePathLabelViewHolder.mTvDistance.getText())) {
                    sb.append(multiAlternativePathLabelViewHolder.mTvDistance.getText().toString());
                    sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                }
                if (!TextUtils.isEmpty(multiAlternativePathLabelViewHolder.mTvCost.getText())) {
                    sb.append(multiAlternativePathLabelViewHolder.mTvCost.getText().toString());
                    sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                }
                if (!TextUtils.isEmpty(multiAlternativePathLabelViewHolder.mTvTrafficLight.getText())) {
                    sb.append(multiAlternativePathLabelViewHolder.mTvTrafficLight.getText().toString());
                    sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                }
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
                this.mAlterLabelTable.put(Integer.valueOf(i), sb.toString());
                updateAlterForVui(mainContext, currentScene, multiAlternativePathLabelViewHolder.mLayout, j);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(L.formatVoiceFullScenesLog("formatAlterLabelForVui index:" + i + ",scene:" + currentScene + ",sceneId:" + currentScene.getVuiSceneId()));
                    sb2.append(",label:");
                    sb2.append((Object) sb);
                    L.d(tag, sb2.toString());
                }
            }
        }
    }

    private void resetAlterLabelTable(long j) {
        long size = this.mAlterLabelTable.size() - j;
        if (L.ENABLE) {
            L.d(TAG, "resetAlterLabelTable tableSize:" + this.mAlterLabelTable.size() + ",pathCount:" + j + ",diff:" + size);
        }
        if (size > 0) {
            int i = 0;
            while (true) {
                long j2 = i;
                if (j2 >= size) {
                    break;
                }
                if (L.ENABLE) {
                    L.d(TAG, "resetAlterLabelTable remove " + (j + j2));
                }
                this.mAlterLabelTable.remove(Integer.valueOf((int) (j2 + j)));
                i++;
            }
            if (L.ENABLE) {
                L.d(TAG, "resetAlterLabelTable tableSize after remove:" + this.mAlterLabelTable.size() + ",pathCount:" + j);
            }
        }
    }

    private String getRouteInfoIndexForVui(int i) {
        if (i != 0) {
            if (i != 1) {
                return i != 2 ? "" : ContextUtils.getString(R.string.vui_label_map_style_alternative_path_3);
            }
            return ContextUtils.getString(R.string.vui_label_map_style_alternative_path_2);
        }
        return ContextUtils.getString(R.string.vui_label_map_style_alternative_path_1);
    }

    private void updateAlterForVui(MainContext mainContext, IBaseScene iBaseScene, XLinearLayout xLinearLayout, long j) {
        if (this.mAlterLabelTable.isEmpty()) {
            L.w(TAG, L.formatVoiceFullScenesLog("updateAlterForVui vuiMap is empty"));
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("updateAlterForVui mAlterLabelTable:" + this.mAlterLabelTable));
        }
        this.mAlterLabelRealArr = new String[(int) j];
        for (int i = 0; i < j; i++) {
            String str = this.mAlterLabelTable.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(str)) {
                this.mAlterLabelRealArr[i] = str;
            } else {
                this.mAlterLabelRealArr[i] = this.mAlterLabelStateArr[i];
            }
        }
        int currentRoutePathIndex = TBTManager.getInstance().getCurrentRoutePathIndex() <= this.mAlterLabelRealArr.length ? TBTManager.getInstance().getCurrentRoutePathIndex() : -1;
        if (currentRoutePathIndex >= 0) {
            String[] strArr = this.mAlterLabelRealArr;
            if (currentRoutePathIndex < strArr.length) {
                if (strArr == null || strArr.length <= 0) {
                    return;
                }
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, L.formatVoiceFullScenesLog("updateAlterForVui stateArr size:" + this.mAlterLabelRealArr.length + ",curStateIndex:" + currentRoutePathIndex + ",mAlterLabelRealArr:" + this.mAlterLabelRealArr));
                }
                xLinearLayout.setVuiElementType(VuiElementType.STATEFULBUTTON);
                xLinearLayout.setVuiLabel(ContextUtils.getString(R.string.vui_label_map_style_alternative_path_container));
                CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
                String[] strArr2 = this.mAlterLabelRealArr;
                commonVuiHelper.dynamicUpdateStatefullButtonAttr(mainContext, xLinearLayout, xLinearLayout, strArr2[currentRoutePathIndex], strArr2, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(xLinearLayout);
                VoiceFullScenesUtil.addNewRootviewToScene(iBaseScene, arrayList);
                return;
            }
        }
        L.Tag tag3 = TAG;
        L.w(tag3, L.formatVoiceFullScenesLog("updateAlterForVui curStateIndex is illegal curStateIndex:" + currentRoutePathIndex));
    }

    public void clearAlterLabelTableForVui(int i) {
        if (CollectionUtils.isNotEmpty(this.mAlterLabelTable)) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "clearAlterLabelTableForVui type:" + i);
            }
            this.mAlterLabelTable.clear();
        }
    }

    public void removeAlterLabelTable(BaseFullScenes baseFullScenes) {
        if (this.mMultiRputeLabelHolder != null) {
            if (L.ENABLE) {
                L.d(TAG, "removeAlterLabelTable");
            }
            VoiceFullScenesUtil.removeSceneElementGroup(this.mMultiRputeLabelHolder.mLayout.getVuiElementId(), baseFullScenes.getVuiSceneId(), baseFullScenes);
            VoiceFullScenesUtil.updateScene(baseFullScenes, baseFullScenes.getBaseView());
        }
    }
}
