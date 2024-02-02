package com.xiaopeng.montecarlo.speech.manager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.MainActivity;
import com.xiaopeng.montecarlo.mapoverlay.StartPointDecorator;
import com.xiaopeng.montecarlo.mapoverlay.WayPointDecorator;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SpeechEventDispatcherHelper implements ISpeechEvent {
    private static final L.Tag TAG = new L.Tag("SpeechEventDispatcherHelper");
    private Handler mHandler = new Handler(WorkThreadUtil.getInstance().getSpeechAndAiThreadLooper()) { // from class: com.xiaopeng.montecarlo.speech.manager.SpeechEventDispatcherHelper.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.obj instanceof SpeechNaviEvent) {
                SpeechNaviEvent speechNaviEvent = (SpeechNaviEvent) message.obj;
                speechNaviEvent.record("SpeechEventDispatcherHelper", "onSpeechEvent", "work thread");
                int i = speechNaviEvent.what;
                if (i == 100) {
                    L.i(SpeechEventDispatcherHelper.TAG, "SPEECH_OPEN_FAVORITE");
                    SpeechEventDispatcherHelper.this.startNaviMap(SpeechNaviEvent.SPEECH_OPERATE_TYPE_OPEN_FAVORITE);
                } else if (i == 312) {
                    L.i(SpeechEventDispatcherHelper.TAG, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS");
                    SpeechEventDispatcherHelper.this.startRouteWithVias(ContextUtils.getContext(), speechNaviEvent.getOrig(), speechNaviEvent.getDest(), speechNaviEvent.getViaList(), speechNaviEvent.getSettingParam(), speechNaviEvent.isDebugRoute(), speechNaviEvent.getStartType(), speechNaviEvent.getRouteSelectRef());
                } else if (i != 902) {
                } else {
                    L.i(SpeechEventDispatcherHelper.TAG, "SPEECH_WAKE_UP_MAP startActivity");
                    SpeechEventDispatcherHelper.this.wakeNaviMap();
                }
            }
        }
    };

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public final boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        speechNaviEvent.record(getClass().getSimpleName(), "onInterceptSpeechEvent", new String[0]);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onInterceptSpeechEvent " + speechNaviEvent.what);
        }
        return speechNaviEvent.what == 902;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        speechNaviEvent.record(getClass().getSimpleName(), "onSpeechEvent", new String[0]);
        L.Tag tag = TAG;
        L.i(tag, "onSpeechEvent " + speechNaviEvent.what);
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.obj = speechNaviEvent;
        this.mHandler.sendMessage(obtainMessage);
        return false;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean dispatchSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        speechNaviEvent.record(getClass().getSimpleName(), "dispatchSpeechEvent", new String[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNaviMap(String str) {
        Intent intent = new Intent(ContextUtils.getContext(), MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_SPEECH_COMMAND_DISPATCH);
        bundle.putString("operate_type", str);
        intent.putExtras(bundle);
        ContextUtils.startActivityWithNewTask(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeNaviMap() {
        ContextUtils.startActivityWithNewTask(new Intent(ContextUtils.getContext(), MainActivity.class));
    }

    private void startRouteWithVias(@NonNull Context context, XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, ArrayList<XPViaPoint> arrayList, int i, boolean z) {
        startRouteWithVias(context, xPPoiInfo, xPPoiInfo2, arrayList, i, z, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRouteWithVias(@NonNull Context context, XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, ArrayList<XPViaPoint> arrayList, int i, boolean z, int i2, int i3) {
        L.Tag tag = TAG;
        L.i(tag, "startRouteWithVias: " + xPPoiInfo2.getName() + " via: " + arrayList + " settingParam: " + i + ",startType:" + i2 + ",routeSelectRef:" + i3);
        if (xPPoiInfo == null) {
            xPPoiInfo = TBTManager.getInstance().getStartPOIFromCurrent();
        }
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        arrayList2.add(xPPoiInfo);
        arrayList2.add(xPPoiInfo2);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, arrayList2);
        bundle.putParcelableArrayList(WayPointDecorator.KEY_VIA_LIST, arrayList);
        bundle.putInt(StartPointDecorator.KEY_SETTING_PARAM, i);
        bundle.putInt("start_type", i2);
        bundle.putInt(StartPointDecorator.KEY_ROUTE_SELECT_REF, i3);
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(268435456);
        intent.setAction(IntentActions.ACTION_SPEECH_COMMAND_DISPATCH);
        intent.putExtra("operate_type", SpeechNaviEvent.SPEECH_OPERATE_TYPE_START_ROUTE_WITH_VIA);
        intent.putExtra(IntentActions.ActionsKey.KEY_DEBUG_FLAG, z);
        intent.setExtrasClassLoader(XPDeepInfoPoi.class.getClassLoader());
        intent.putExtras(bundle);
        context.startActivity(intent);
        ContextUtils.startActivity(intent);
    }
}
