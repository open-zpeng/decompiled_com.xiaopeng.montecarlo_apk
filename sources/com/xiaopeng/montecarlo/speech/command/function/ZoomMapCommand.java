package com.xiaopeng.montecarlo.speech.command.function;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
import java.util.ArrayList;
import java.util.List;
@CommandPriority(priority = 31)
/* loaded from: classes3.dex */
public class ZoomMapCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("ZoomMapCommand");
    private boolean mIsExecuted = false;
    private int mLevel;
    private ZoomType mType;

    /* loaded from: classes3.dex */
    public enum ZoomType {
        ZOOM_IN,
        ZOOM_OUT,
        ZOOM_OUT_MIN,
        ZOOM_IN_MAX,
        ZOOM_TO_SPECIFIED_LEVEL
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public ZoomType getType() {
        return this.mType;
    }

    public ZoomMapCommand(ZoomType zoomType, int i) {
        this.mLevel = -1000;
        this.mType = zoomType;
        this.mLevel = i;
    }

    /* renamed from: com.xiaopeng.montecarlo.speech.command.function.ZoomMapCommand$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$ZoomMapCommand$ZoomType = new int[ZoomType.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$ZoomMapCommand$ZoomType[ZoomType.ZOOM_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$ZoomMapCommand$ZoomType[ZoomType.ZOOM_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$ZoomMapCommand$ZoomType[ZoomType.ZOOM_IN_MAX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$ZoomMapCommand$ZoomType[ZoomType.ZOOM_OUT_MIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$speech$command$function$ZoomMapCommand$ZoomType[ZoomType.ZOOM_TO_SPECIFIED_LEVEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        SpeechNaviEvent speechNaviEvent;
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$speech$command$function$ZoomMapCommand$ZoomType[this.mType.ordinal()];
        if (i == 1) {
            speechNaviEvent = new SpeechNaviEvent(405);
        } else if (i == 2) {
            speechNaviEvent = new SpeechNaviEvent(406);
        } else if (i == 3) {
            speechNaviEvent = new SpeechNaviEvent(SpeechNaviEvent.SPEECH_CMD_CONTROL_ZOOM_IN_MAX);
        } else if (i == 4) {
            speechNaviEvent = new SpeechNaviEvent(SpeechNaviEvent.SPEECH_CMD_CONTROL_ZOOM_OUT_MIN);
        } else if (i == 5) {
            L.Tag tag = TAG;
            L.d(tag, "zoom to level = " + this.mLevel);
            speechNaviEvent = new SpeechNaviEvent(2010);
            speechNaviEvent.setLevel(this.mLevel);
        } else {
            L.w(TAG, "doSomething, type error");
            return;
        }
        executeSpeechEvent(speechNaviEvent);
        this.mIsExecuted = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$speech$command$function$ZoomMapCommand$ZoomType[this.mType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            SpeechStatProxy.getInstance().sendStatDataForSpeech(39, 3);
            return;
        }
        SpeechStatProxy.getInstance().sendStatDataForSpeech(38, 3);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecuted;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        ZoomType zoomType = this.mType;
        sb.append(zoomType != null ? zoomType.name() : "null");
        sb.append(")");
        return sb.toString();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public List<Class<? extends BaseSpeechCommand>> getFixContextList() {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(super.getFixContextList())) {
            arrayList.addAll(super.getFixContextList());
        }
        arrayList.add(ExitCross3DCommand.class);
        arrayList.add(EnterActiveStateCommand.class);
        return arrayList;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if (t instanceof ZoomMapCommand) {
            if (((ZoomMapCommand) t).getType() == this.mType) {
                return true;
            }
            throw new MergeException();
        }
        return super.canMergeCommand(t);
    }
}
