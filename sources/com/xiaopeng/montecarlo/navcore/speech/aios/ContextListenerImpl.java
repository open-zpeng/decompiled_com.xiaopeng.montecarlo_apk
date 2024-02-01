package com.xiaopeng.montecarlo.navcore.speech.aios;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.protocol.SpeechUtils;
import com.xiaopeng.speech.protocol.node.context.AbsContextListener;
import com.xiaopeng.speech.protocol.node.navi.bean.RouteSelectBean;
import com.xiaopeng.speech.protocol.node.navi.bean.SelectRouteBean;
import java.util.List;
/* loaded from: classes3.dex */
public class ContextListenerImpl extends AbsContextListener {
    private static final String SELECT_TYPE_ROUTE = "route";
    private static final L.Tag TAG = new L.Tag("NaviModel_ContextListenerImpl");
    private NaviModel mNaviModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContextListenerImpl(NaviModel naviModel) {
        this.mNaviModel = naviModel;
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onWidgetList(String str) {
        super.onWidgetList(str);
        if (this.mNaviModel.canHandleVoiceCommand()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onWidgetList data:" + str);
            }
            VoiceFusionUtil.getInstance().onWidgetList(str);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onScript(String str, String str2) {
        super.onScript(str, str2);
        if (this.mNaviModel.canHandleVoiceCommand()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onScript domain:" + str + ",scriptId:" + str2);
            }
            VoiceFusionUtil.getInstance().onScript(str, str2);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onScriptStatus(String str, String str2) {
        super.onScriptStatus(str, str2);
        if (this.mNaviModel.canHandleVoiceCommand()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onScriptStatus scriptId:" + str + ",status:" + str2);
            }
            VoiceFusionUtil.getInstance().onScriptStatus(str, str2);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onWidgetCustom(String str) {
        super.onWidgetCustom(str);
        int length = TextUtils.isEmpty(str) ? 0 : str.length();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onWidgetCustom data length:" + length);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onWidgetText(String str) {
        super.onWidgetText(str);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onWidgetText data:" + str);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onWidgetListFocus(String str, int i) {
        super.onWidgetListFocus(str, i);
        if (!this.mNaviModel.canHandleVoiceCommand(str, true)) {
            L.w(TAG, "onWidgetListFocus execute failure");
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "onWidgetListFocus source:" + str + ",index:" + i);
        VoiceFusionUtil.getInstance().onWidgetListFocus(str, i);
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onWidgetScroll(String str, int i) {
        super.onWidgetScroll(str, i);
        if (this.mNaviModel.canHandleVoiceCommand(str, true)) {
            L.Tag tag = TAG;
            L.i(tag, "onWidgetScroll source:" + str + ",index:" + i);
            VoiceFusionUtil.getInstance().onWidgetScroll(str, i);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onWidgetListSelect(String str, int i, String str2) {
        super.onWidgetListSelect(str, i, str2);
        if (this.mNaviModel.canHandleVoiceCommand(str, true) && "route".equals(str2)) {
            if (i <= 0) {
                L.w(TAG, "onWidgetListSelect index is illegal");
                return;
            }
            L.Tag tag = TAG;
            L.i(tag, "onWidgetListSelect source:" + str + ",index:" + i + ",type:" + str2);
            SelectRouteBean selectRouteBean = new SelectRouteBean();
            selectRouteBean.setNum(i);
            onSelectRouteCount(selectRouteBean);
            onRouteSelect(selectRouteBean);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onWidgetListExpend(String str, String str2) {
        super.onWidgetListExpend(str, str2);
        if (this.mNaviModel.canHandleVoiceCommand(str, true)) {
            L.Tag tag = TAG;
            L.i(tag, "onWidgetListExpend source:" + str + ",type:" + str2);
            VoiceFusionUtil.getInstance().onWidgetListExpend(str);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onWidgetListFold(String str, String str2) {
        super.onWidgetListFold(str, str2);
        if (this.mNaviModel.canHandleVoiceCommand(str, true) && L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onWidgetListFold source:" + str + ",type:" + str2);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
    public void onWidgetCancel(String str, String str2) {
        super.onWidgetCancel(str, str2);
        if (this.mNaviModel.canHandleVoiceCommand()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onWidgetCancel widgetId:" + str + ",cancelWay:" + str2);
            }
            if (TextUtils.isEmpty(str) || !str.toLowerCase().contains("route")) {
                return;
            }
            VoiceFusionUtil.getInstance().onWidgetCancel(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void syncRoute(List<RouteSelectBean> list, String str, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "syncRoute list:" + list + ",id:" + str + ",isBaseInfo:" + z);
        this.mNaviModel.getNaviNode().syncRoute(list, str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopSpeechDialog() {
        L.i(TAG, "stopSpeechDialog");
        this.mNaviModel.getNaviNode().stopSpeechDialog(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startSpeechDialog() {
        L.i(TAG, "startSpeechDialog");
        this.mNaviModel.getNaviNode().directNavigation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSelectRouteCount(@Nullable SelectRouteBean selectRouteBean) {
        if (selectRouteBean == null) {
            return;
        }
        boolean isSelectRouteEnable = NaviSpeechUtils.isSelectRouteEnable(selectRouteBean.getNum());
        L.Tag tag = TAG;
        L.i(tag, "onSelectRouteCount isSupport:" + isSelectRouteEnable);
        SpeechUtils.replySupport("native://navi.select.route.count", isSelectRouteEnable);
    }

    void onRouteSelect(@NonNull SelectRouteBean selectRouteBean) {
        this.mNaviModel.onRouteSelect(selectRouteBean);
    }
}
