package com.xiaopeng.montecarlo.speech.command;

import android.os.Handler;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.speech.manager.ISpeechSchedue;
import com.xiaopeng.montecarlo.speech.manager.NaviSpeechManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
/* loaded from: classes3.dex */
public abstract class BaseSpeechCommand implements ICommandRecorder, ICommandFunction {
    private static final int MSG_EXECUTE_COMMAND_TIMEOUT = 101;
    private static final L.Tag TAG = new L.Tag("BaseSpeechCommand");
    private long mExecuteEndTime;
    private long mExecuteStartTime;
    private Semaphore mSemaphore = new Semaphore(1, true);
    private boolean mIsInterrupt = false;
    protected Handler mHandler = new Handler(WorkThreadUtil.getInstance().getSpeechAndAiThreadLooper());
    private ArrayList<SpeechNaviEvent> mEvents = new ArrayList<>();
    private ISpeechSchedue mNaviSpeechManager = NaviSpeechManager.getInstance().getSpeechSchedue();

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public abstract void doSomething();

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public List<Class<? extends BaseSpeechCommand>> getFixContextList() {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public abstract boolean isAchieveGoals();

    protected boolean isConditionMatched() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T, S extends BaseSpeechCommand> S mergeCommand(T t) {
        return this;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public abstract void onFailed();

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public abstract void onSuccess();

    public void executeCommand() {
        this.mExecuteStartTime = System.currentTimeMillis();
        if (isConditionMatched()) {
            if (isAchieveGoals()) {
                noNeedToExecute();
                onFinish();
                return;
            }
            L.Tag tag = TAG;
            L.i(tag, getClass().getSimpleName() + " start doSomething");
            doSomething();
            this.mHandler.postDelayed(new CommandRunnable(this), 100L);
            return;
        }
        L.i(TAG, "executeCommand condition not matched");
        onFailed();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public final void onFinish() {
        try {
            this.mSemaphore.acquire();
            if (this.mHandler.hasMessages(101)) {
                this.mHandler.removeMessages(101);
            }
            this.mExecuteEndTime = System.currentTimeMillis();
            long j = this.mExecuteEndTime - this.mExecuteStartTime;
            L.Tag tag = TAG;
            L.i(tag, "executeFinish, " + getClass().getSimpleName() + " cost " + j + " ms to execute");
            this.mNaviSpeechManager.onNextCommand();
            this.mSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (L.ENABLE) {
            Iterator<SpeechNaviEvent> it = this.mEvents.iterator();
            while (it.hasNext()) {
                SpeechNaviEvent next = it.next();
                next.record("onFinish " + next.what);
                next.printRecord();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onTimeOut() {
        L.Tag tag = TAG;
        L.i(tag, getClass().getSimpleName() + " onTimeOut");
        onFailed();
        onFinish();
        if (L.ENABLE) {
            return;
        }
        Iterator<SpeechNaviEvent> it = this.mEvents.iterator();
        while (it.hasNext()) {
            SpeechNaviEvent next = it.next();
            next.record("onTimeOut " + next.what);
            next.printRecord();
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void noNeedToExecute() {
        L.Tag tag = TAG;
        L.i(tag, getClass().getSimpleName() + " noNeedToExecute");
        onSuccess();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        return t != null && getClass().getSimpleName().equals(t.getClass().getSimpleName());
    }

    public int getPriority() {
        if (getClass().isAnnotationPresent(CommandPriority.class)) {
            return ((CommandPriority) getClass().getAnnotation(CommandPriority.class)).priority();
        }
        L.Tag tag = TAG;
        L.w(tag, getClass().getSimpleName() + " should define priority");
        return Integer.MAX_VALUE;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public final boolean isInterrupted() {
        return this.mIsInterrupt;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public final void onInterrupt() {
        this.mIsInterrupt = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void executeSpeechEvent(SpeechNaviEvent speechNaviEvent) {
        this.mEvents.add(speechNaviEvent);
        speechNaviEvent.record(getClass().getSimpleName(), "executeSpeechEvent at the beginning", new String[0]);
        executeSpeechEvent(speechNaviEvent, new ICommandCallback() { // from class: com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand.1
            @Override // com.xiaopeng.montecarlo.speech.command.ICommandCallback
            public void notSupport() {
                BaseSpeechCommand.this.onInterrupt();
            }

            @Override // com.xiaopeng.montecarlo.speech.command.ICommandCallback
            public void onTerminate() {
                BaseSpeechCommand.this.onInterrupt();
            }
        });
    }

    private void executeSpeechEvent(final SpeechNaviEvent speechNaviEvent, final ICommandCallback iCommandCallback) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand.2
            @Override // java.lang.Runnable
            public void run() {
                speechNaviEvent.record("BaseSpeechCommand", "executeSpeechEvent", "switch to UI thread ");
                L.Tag tag = BaseSpeechCommand.TAG;
                L.i(tag, "executeSpeechEvent, switch to UI thread " + speechNaviEvent.what);
                NaviSpeechManager.getInstance().getSpeechSchedue().executeSpeechEvent(speechNaviEvent, iCommandCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getCurrentTopMode(boolean z) {
        Object postRequestForResult;
        if (z) {
            postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10010);
        } else {
            postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10009);
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getCurrentTopMode: " + postRequestForResult);
        }
        if (postRequestForResult == null || !(postRequestForResult instanceof String)) {
            return null;
        }
        return (String) postRequestForResult;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
