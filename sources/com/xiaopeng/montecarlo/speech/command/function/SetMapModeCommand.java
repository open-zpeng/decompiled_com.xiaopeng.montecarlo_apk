package com.xiaopeng.montecarlo.speech.command.function;

import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
import com.xiaopeng.montecarlo.util.SRUtil;
import com.xiaopeng.speech.protocol.SpeechUtils;
import com.xiaopeng.speech.protocol.event.query.QueryNaviEvent;
import java.util.ArrayList;
import java.util.List;
@CommandPriority(priority = 31)
/* loaded from: classes3.dex */
public class SetMapModeCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("SetMapModeCommand");
    private MapMode mMapMode;

    /* loaded from: classes3.dex */
    public enum MapMode {
        HEAD_UP_2D,
        HEAD_UP_3D,
        NORTH_UP
    }

    public MapMode getMapMode() {
        return this.mMapMode;
    }

    public SetMapModeCommand(MapMode mapMode) {
        this.mMapMode = mapMode;
    }

    /* renamed from: com.xiaopeng.montecarlo.speech.command.function.SetMapModeCommand$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$SetMapModeCommand$MapMode = new int[MapMode.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$SetMapModeCommand$MapMode[MapMode.NORTH_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$SetMapModeCommand$MapMode[MapMode.HEAD_UP_2D.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$SetMapModeCommand$MapMode[MapMode.HEAD_UP_3D.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        SpeechNaviEvent speechNaviEvent;
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$speech$command$function$SetMapModeCommand$MapMode[this.mMapMode.ordinal()];
        if (i == 1) {
            speechNaviEvent = new SpeechNaviEvent(407);
        } else if (i == 2) {
            speechNaviEvent = new SpeechNaviEvent(SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_2D);
        } else if (i == 3) {
            speechNaviEvent = new SpeechNaviEvent(SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_3D);
        } else {
            L.w(TAG, "doSomething, type error");
            return;
        }
        executeSpeechEvent(speechNaviEvent);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
        SpeechUtils.replyValue(QueryNaviEvent.REPLY_MAP_MODE_STATUS, 1);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        SpeechUtils.replyValue(QueryNaviEvent.REPLY_MAP_MODE_STATUS, 0);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$speech$command$function$SetMapModeCommand$MapMode[this.mMapMode.ordinal()];
        return i != 1 ? i != 2 ? i == 3 && 2 == getCurrentMapMode().intValue() : 1 == getCurrentMapMode().intValue() : getCurrentMapMode().intValue() == 0;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void noNeedToExecute() {
        SpeechUtils.replyValue(QueryNaviEvent.REPLY_MAP_MODE_STATUS, 4);
    }

    private Integer getCurrentMapMode() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10012);
        L.Tag tag = TAG;
        L.i(tag, "getCurrentMapMode " + postRequestForResult);
        if (postRequestForResult != null && (postRequestForResult instanceof Integer)) {
            return (Integer) postRequestForResult;
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if (t instanceof SetMapModeCommand) {
            if (((SetMapModeCommand) t).getMapMode() == this.mMapMode) {
                return true;
            }
            throw new MergeException();
        }
        return super.canMergeCommand(t);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public List<Class<? extends BaseSpeechCommand>> getFixContextList() {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(super.getFixContextList())) {
            arrayList.addAll(super.getFixContextList());
        }
        if (isConditionMatched()) {
            arrayList.add(ExitCross3DCommand.class);
            arrayList.add(EnterActiveStateCommand.class);
        }
        return arrayList;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand
    public boolean isConditionMatched() {
        XPCrossImageInfo naviCrossImageInfo = TBTManager.getInstance().getNaviCrossImageInfo();
        if (naviCrossImageInfo == null || 4 != naviCrossImageInfo.mType) {
            String currentTopMode = getCurrentTopMode(false);
            return (StatusConst.Mode.SEARCH.name().equals(currentTopMode) || StatusConst.Mode.ROUTE.name().equals(currentTopMode) || StatusConst.Mode.EXPLORE.name().equals(currentTopMode) || StatusConst.Mode.RESTRICT.name().equals(currentTopMode) || SRUtil.isLaneMode()) ? false : true;
        }
        return false;
    }
}
