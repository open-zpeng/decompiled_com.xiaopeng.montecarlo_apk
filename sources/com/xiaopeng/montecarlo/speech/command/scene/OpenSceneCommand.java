package com.xiaopeng.montecarlo.speech.command.scene;

import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
import com.xiaopeng.speech.protocol.SpeechUtils;
import java.util.ArrayList;
import java.util.List;
@CommandPriority(priority = 51)
/* loaded from: classes3.dex */
public class OpenSceneCommand extends BaseSpeechCommand {
    public static final int PAGE_TYPE_NONE = -1;
    public static final int PAGE_TYPE_SEARCH_FAVORITE = 1;
    public static final int PAGE_TYPE_SEARCH_NORMAL = 0;
    private static final L.Tag TAG = new L.Tag("OpenSceneCommand");
    private boolean mIsExecute;
    private StatusConst.Mode mMode;
    private int mPageType;

    public StatusConst.Mode getMode() {
        return this.mMode;
    }

    public OpenSceneCommand(StatusConst.Mode mode) {
        this(mode, -1);
    }

    public OpenSceneCommand(StatusConst.Mode mode, int i) {
        this.mIsExecute = false;
        this.mPageType = -1;
        this.mMode = mode;
        this.mPageType = i;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        L.Tag tag = TAG;
        L.i(tag, "OpenSceneCommand:" + this.mMode.name() + ",pageType:" + this.mPageType);
        if (notSupportMode()) {
            return;
        }
        SpeechNaviEvent speechNaviEvent = null;
        switch (this.mMode) {
            case SETTING:
                speechNaviEvent = new SpeechNaviEvent(103);
                break;
            case SEARCH:
                int i = this.mPageType;
                if (i != 1) {
                    if (i == 0) {
                        speechNaviEvent = new SpeechNaviEvent(109);
                        break;
                    }
                } else {
                    speechNaviEvent = new SpeechNaviEvent(100);
                    break;
                }
                break;
            case DEBUG:
                speechNaviEvent = new SpeechNaviEvent(104);
                break;
            case SETTING_LICENCE_PLATE:
                speechNaviEvent = new SpeechNaviEvent(105);
                break;
            case LINK_SEAMLESS_NAVI:
                speechNaviEvent = new SpeechNaviEvent(106);
                break;
            case SETTING_MAP_DOWNLOAD:
                speechNaviEvent = new SpeechNaviEvent(107);
                break;
        }
        if (speechNaviEvent != null) {
            executeSpeechEvent(speechNaviEvent);
        }
        this.mIsExecute = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[this.mMode.ordinal()];
        if (i == 1) {
            SpeechUtils.replySupport("native://navi.control.settings.open", true);
        } else if (i != 2) {
        } else {
            SpeechUtils.replySupport("command://navi.control.favorite.open", true);
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[this.mMode.ordinal()];
        if (i == 1) {
            SpeechUtils.replySupport("command://navi.control.favorite.open", false);
            SpeechStatProxy.getInstance().sendStatDataForSpeech(10, 3);
        } else if (i != 2) {
        } else {
            SpeechUtils.replySupport("command://navi.control.favorite.open", false);
            SpeechStatProxy.getInstance().sendStatDataForSpeech(9, 3);
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        if (notSupportMode()) {
            return true;
        }
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[this.mMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 5) {
                        if (i != 6) {
                            return false;
                        }
                        return StatusConst.Mode.SETTING_MAP_DOWNLOAD.name().equals(getCurrentTopMode(true));
                    }
                    return StatusConst.Mode.LINK_SEAMLESS_NAVI.name().equals(getCurrentTopMode(true));
                }
                return StatusConst.Mode.DEBUG.name().equals(getCurrentTopMode(true));
            }
            return this.mIsExecute;
        }
        return StatusConst.Mode.SETTING.name().equals(getCurrentTopMode(true));
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void noNeedToExecute() {
        if (notSupportMode()) {
            L.Tag tag = TAG;
            L.i(tag, "noNeedToExecute, " + this.mMode.name());
            return;
        }
        super.noNeedToExecute();
    }

    private boolean notSupportMode() {
        switch (this.mMode) {
            case CONTAINER_ROUTE:
            case CONTAINER_EXPLORE:
            case CONTAINER_SEARCH_RESULT:
            case NAVI:
            case ROUTE:
            case EXPLORE:
            case CRUISE:
            case EMPTY:
            case SEARCH_RESULT:
            case SCAN_SEARCH:
            case SET_HOME_OFFICE:
            case POPDIALOG:
            case RESTRICT:
            case NAVI_GUIDER:
            case DRIVING:
                return true;
            default:
                return false;
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if ((t instanceof CloseSceneCommand) && ((CloseSceneCommand) t).getMode() == this.mMode) {
            throw new MergeException();
        }
        if (t instanceof OpenSceneCommand) {
            return ((OpenSceneCommand) t).getMode() == this.mMode;
        }
        return super.canMergeCommand(t);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public List<Class<? extends BaseSpeechCommand>> getFixContextList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CheckTopChildSceneCommand.class);
        return arrayList;
    }
}
