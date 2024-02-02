package com.xiaopeng.speech.vui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.event.IVuiEvent;
import com.xiaopeng.speech.vui.event.ListItemClickEvent;
import com.xiaopeng.speech.vui.event.ScrollByXEvent;
import com.xiaopeng.speech.vui.event.ScrollByYEvent;
import com.xiaopeng.speech.vui.event.ScrollToEvent;
import com.xiaopeng.speech.vui.event.SetCheckEvent;
import com.xiaopeng.speech.vui.event.SetValueEvent;
import com.xiaopeng.speech.vui.listener.IUnityVuiSceneListener;
import com.xiaopeng.speech.vui.listener.IVuiEventListener;
import com.xiaopeng.speech.vui.model.VuiEventImpl;
import com.xiaopeng.speech.vui.model.VuiEventInfo;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiScene;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.speech.vui.vuiengine.R;
import com.xiaopeng.vui.commons.IVuiElementListener;
import com.xiaopeng.vui.commons.IVuiSceneListener;
import com.xiaopeng.vui.commons.VuiAction;
import com.xiaopeng.vui.commons.VuiElementType;
import com.xiaopeng.vui.commons.model.AnimationObj;
import com.xiaopeng.vui.commons.model.VuiElement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class EventDispatcher implements Runnable {
    private Context mContext;
    private VuiScene mEventData;
    private VuiElement vuiElement;
    private WeakReference<View> weakView;
    private Gson gson = new Gson();
    private Handler handler = new Handler(Looper.getMainLooper());
    private Map<String, IVuiEvent> events = new HashMap();
    private String TAG = "EventDispatcher";
    private String mDispatchSceneId = null;

    public EventDispatcher(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            initEvents();
        }
    }

    private void initEvents() {
        if (VuiUtils.isThirdApp(VuiSceneManager.instance().getmPackageName())) {
            return;
        }
        this.events.put("scrollTo", new ScrollToEvent());
        this.events.put("Click", new ListItemClickEvent());
        this.events.put("click", new ListItemClickEvent());
        this.events.put("SetCheck", new SetCheckEvent());
        this.events.put("listItemClick", new ListItemClickEvent());
        this.events.put(VuiAction.SCROLLBYY.getName(), new ScrollByYEvent());
        this.events.put(VuiAction.SCROLLBYX.getName(), new ScrollByXEvent());
        this.events.put(VuiAction.SETVALUE.getName(), new SetValueEvent());
    }

    public void dispatch(String str, String str2) {
        Object tag;
        if (str2 == null) {
            return;
        }
        String str3 = this.TAG;
        LogUtils.logInfo(str3, Thread.currentThread().getName() + "-----result datasource =====" + str2);
        final long currentTimeMillis = System.currentTimeMillis();
        this.mEventData = (VuiScene) this.gson.fromJson(str2, (Class<Object>) VuiScene.class);
        VuiScene vuiScene = this.mEventData;
        if (vuiScene == null) {
            LogUtils.e(this.TAG, "mEventData is Null");
        } else if (vuiScene.getSceneId() != null && VuiUtils.getPackageNameFromSceneId(this.mEventData.getSceneId()).equals(VuiSceneManager.instance().getmPackageName())) {
            if (!this.mEventData.getSceneId().equals(VuiEngineImpl.mActiveSceneId)) {
                LogUtils.e(this.TAG, "场景不是当前活跃场景，返回");
                return;
            }
            this.vuiElement = getHitVuiElements(this.mEventData.getElements());
            if (this.vuiElement == null) {
                LogUtils.e(this.TAG, "事件派发Element 为空");
                return;
            }
            String str4 = this.TAG;
            LogUtils.logDebug(str4, "VuiElement  ===== " + this.vuiElement.toString());
            if (VuiUtils.isThirdApp(VuiSceneManager.instance().getmPackageName())) {
                LogUtils.logInfo(this.TAG, "Event will dispatch to third app");
                final IVuiSceneListener vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(this.mEventData.getSceneId());
                if (vuiSceneListener != null) {
                    this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IVuiSceneListener iVuiSceneListener = vuiSceneListener;
                            if (iVuiSceneListener instanceof IUnityVuiSceneListener) {
                                ((IUnityVuiSceneListener) iVuiSceneListener).onVuiEvent(EventDispatcher.this.gson.toJson(EventDispatcher.this.vuiElement));
                            } else {
                                iVuiSceneListener.onVuiEvent(new VuiEventImpl(EventDispatcher.this.vuiElement));
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mDispatchSceneId = this.mEventData.getSceneId();
            String str5 = this.TAG;
            LogUtils.logInfo(str5, "dispatch Scene:" + this.mDispatchSceneId);
            if (VuiElementType.VIRTUALLIST.getType().equals(this.vuiElement.getType()) || VuiElementType.VIRTUALLISTITEM.getType().equals(this.vuiElement.getType())) {
                JsonObject props = this.vuiElement.getProps();
                if (props.has("parentId")) {
                    VuiEventInfo findView = VuiSceneManager.instance().findView(this.mDispatchSceneId, props.get("parentId").getAsString());
                    if (findView == null || findView.hitView == null) {
                        return;
                    }
                    this.weakView = new WeakReference<>(findView.hitView);
                    this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.2
                        @Override // java.lang.Runnable
                        public void run() {
                            EventDispatcher.this.run();
                        }
                    });
                    SetValueEvent setValueEvent = (SetValueEvent) this.events.get(VuiAction.SETVALUE.getName());
                    if (setValueEvent != null) {
                        setValueEvent.setSceneId(findView.sceneId);
                        return;
                    }
                    return;
                }
                return;
            }
            final VuiEventInfo findView2 = VuiSceneManager.instance().findView(this.mDispatchSceneId, this.vuiElement.getId());
            if (findView2 == null || findView2.hitView == null) {
                if (this.mDispatchSceneId.endsWith("Dialog") || this.mDispatchSceneId.endsWith("dialog")) {
                    final IVuiSceneListener vuiSceneListener2 = VuiSceneManager.instance().getVuiSceneListener(this.mEventData.getSceneId());
                    if (vuiSceneListener2 != null) {
                        this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.3
                            @Override // java.lang.Runnable
                            public void run() {
                                vuiSceneListener2.onVuiEvent(null, new VuiEventImpl(EventDispatcher.this.vuiElement));
                            }
                        });
                        return;
                    }
                    return;
                }
                LogUtils.e(this.TAG, "没找到正确的执行操作的view");
                return;
            }
            boolean booleanValue = ("com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) || (tag = findView2.hitView.getTag(R.id.customDoAction)) == null) ? false : ((Boolean) tag).booleanValue();
            if ((isCustomView(this.vuiElement) || booleanValue) && callOnVuiEvent(this.vuiElement, findView2)) {
                LogUtils.logInfo(this.TAG, "custom view dispatch success");
            } else if (TextUtils.isEmpty(this.vuiElement.getId())) {
            } else {
                if (findView2 != null && findView2.hitView != null) {
                    this.weakView = new WeakReference<>(findView2.hitView);
                    if (!findView2.hitView.isEnabled() && !isCustomHandle(this.vuiElement, findView2.hitView)) {
                        LogUtils.e(this.TAG, "view 不可操作");
                        if (isCustomFeedback(this.vuiElement, findView2.hitView)) {
                            return;
                        }
                        handleDisableFeedBack(this.vuiElement, findView2.hitView);
                        return;
                    }
                    final VuiEventImpl vuiEventImpl = new VuiEventImpl(this.vuiElement);
                    getResultAction(this.vuiElement);
                    AnimationObj animation = this.vuiElement.getAnimation();
                    final boolean isEffectOnly = animation == null ? false : animation.isEffectOnly();
                    this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (isEffectOnly) {
                                LogUtils.w(EventDispatcher.this.TAG, "不执行模拟点击");
                                return;
                            }
                            IVuiEventListener vuiEventListener = VuiSceneManager.instance().getVuiEventListener(findView2.sceneId);
                            if (vuiEventListener != null) {
                                vuiEventListener.onVuiEventExecutioned();
                            }
                            IVuiSceneListener vuiSceneListener3 = VuiSceneManager.instance().getVuiSceneListener(findView2.sceneId);
                            if (vuiSceneListener3 != null) {
                                vuiSceneListener3.onVuiEventExecutioned();
                            }
                            if (vuiSceneListener3 != null && vuiSceneListener3.onInterceptVuiEvent(findView2.hitView, vuiEventImpl)) {
                                LogUtils.i(EventDispatcher.this.TAG, "user intercept Events");
                            } else if ((findView2.hitView instanceof IVuiElementListener) && ((IVuiElementListener) findView2.hitView).onVuiElementEvent(findView2.hitView, vuiEventImpl)) {
                            } else {
                                EventDispatcher.this.run();
                                long currentTimeMillis2 = System.currentTimeMillis();
                                String str6 = EventDispatcher.this.TAG;
                                LogUtils.logInfo(str6, "程序运行时间： " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                            }
                        }
                    });
                    return;
                }
                LogUtils.e(this.TAG, "没找到正确的执行操作的view");
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IVuiEvent iVuiEvent;
        WeakReference<View> weakReference;
        List<String> resultActions = this.vuiElement.getResultActions();
        if (resultActions == null || resultActions.isEmpty() || (iVuiEvent = this.events.get(resultActions.get(0))) == null || (weakReference = this.weakView) == null || weakReference.get() == null) {
            return;
        }
        iVuiEvent.run(this.weakView.get(), this.vuiElement);
    }

    private VuiElement getHitVuiElements(List<VuiElement> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> resultActions = list.get(0).getResultActions();
        if (resultActions != null && !resultActions.isEmpty()) {
            return list.get(0);
        }
        if (list.get(0).getElements() == null || list.get(0).getElements().isEmpty()) {
            return list.get(0);
        }
        VuiElement vuiElement = list.get(0);
        if (vuiElement == null) {
            return null;
        }
        return isCustomView(vuiElement) ? vuiElement : getHitVuiElements(vuiElement.getElements());
    }

    private boolean callOnVuiEvent(VuiElement vuiElement, final VuiEventInfo vuiEventInfo) {
        if (vuiElement == null || vuiEventInfo == null || vuiEventInfo.hitView == null) {
            return false;
        }
        if (VuiElementType.STATEFULBUTTON.getType().equals(vuiElement.getType()) && !"com.android.systemui".equals(VuiSceneManager.instance().getmPackageName())) {
            if (vuiEventInfo.hitView.getTag(R.id.vuiStatefulButtonClick) != null) {
                vuiElement.setResultActions(Arrays.asList(VuiAction.CLICK.getName()));
                return false;
            }
            List<VuiElement> elements = vuiElement.getElements();
            if (elements != null && elements.size() == 2) {
                vuiElement.setResultActions(Arrays.asList(VuiAction.CLICK.getName()));
                return false;
            }
        }
        if (!vuiEventInfo.hitView.isEnabled() && !isCustomHandle(vuiElement, vuiEventInfo.hitView)) {
            LogUtils.e(this.TAG, "view 不可操作");
            if (!isCustomFeedback(vuiElement, vuiEventInfo.hitView)) {
                handleDisableFeedBack(vuiElement, vuiEventInfo.hitView);
            }
            return true;
        }
        final VuiEventImpl vuiEventImpl = new VuiEventImpl(vuiElement);
        IVuiEventListener vuiEventListener = VuiSceneManager.instance().getVuiEventListener(vuiEventInfo.sceneId);
        final IVuiSceneListener vuiSceneListener = VuiSceneManager.instance().getVuiSceneListener(vuiEventInfo.sceneId);
        if (!(vuiEventInfo.hitView instanceof IVuiElementListener)) {
            if (vuiSceneListener != null) {
                this.handler.post(new Runnable() { // from class: com.xiaopeng.speech.vui.EventDispatcher.5
                    @Override // java.lang.Runnable
                    public void run() {
                        vuiSceneListener.onVuiEvent(vuiEventInfo.hitView, vuiEventImpl);
                    }
                });
            }
            if (vuiEventListener != null) {
                vuiEventListener.onVuiEventExecutioned();
            }
            if (vuiSceneListener != null) {
                vuiSceneListener.onVuiEventExecutioned();
            }
            return true;
        }
        boolean onVuiElementEvent = ((IVuiElementListener) vuiEventInfo.hitView).onVuiElementEvent(vuiEventInfo.hitView, vuiEventImpl);
        if (onVuiElementEvent && vuiEventListener != null) {
            vuiEventListener.onVuiEventExecutioned();
        }
        if (onVuiElementEvent && vuiSceneListener != null) {
            vuiSceneListener.onVuiEventExecutioned();
        }
        return onVuiElementEvent;
    }

    private boolean isCustomView(VuiElement vuiElement) {
        if (vuiElement == null) {
            return false;
        }
        return VuiElementType.XTABLAYOUT.getType().equals(vuiElement.getType()) || VuiElementType.XSLIDER.getType().equals(vuiElement.getType()) || VuiElementType.STATEFULBUTTON.getType().equals(vuiElement.getType()) || VuiElementType.CUSTOM.getType().equals(vuiElement.getType());
    }

    private String getResultAction(VuiElement vuiElement) {
        List<String> resultActions = this.vuiElement.getResultActions();
        if (resultActions == null || resultActions.isEmpty()) {
            return null;
        }
        return resultActions.get(0);
    }

    private void handleDisableFeedBack(VuiElement vuiElement, View view) {
        JsonObject props;
        if (vuiElement.getProps() == null || (props = vuiElement.getProps()) == null || !props.has(VuiConstants.PROPS_FEEDBACK) || !props.get(VuiConstants.PROPS_FEEDBACK).getAsBoolean()) {
            return;
        }
        VuiEngine.getInstance(this.mContext).vuiFeedback(view, new VuiFeedback.Builder().state(-1).content((view == null || view.getTag(R.id.customDisableFeedbackTTS) == null) ? "当前该功能不可用" : (String) view.getTag(R.id.customDisableFeedbackTTS)).build());
    }

    private boolean isCustomHandle(VuiElement vuiElement, View view) {
        JsonObject props;
        if (vuiElement.getProps() == null || (props = vuiElement.getProps()) == null || !props.has(VuiConstants.PROPS_DISABLECONTROL)) {
            return (view == null || "com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) || view.getTag(R.id.customDisableControl) == null) ? false : true;
        }
        return props.get(VuiConstants.PROPS_DISABLECONTROL).getAsBoolean();
    }

    private boolean isCustomFeedback(VuiElement vuiElement, View view) {
        return (view == null || "com.android.systemui".equals(VuiSceneManager.instance().getmPackageName()) || view.getTag(R.id.customDisableFeedback) == null) ? false : true;
    }
}
