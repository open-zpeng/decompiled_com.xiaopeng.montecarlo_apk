package com.xiaopeng.montecarlo.speech.manager;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class NaviSpeechManager {
    private static final L.Tag TAG = new L.Tag("NaviSpeechManager");
    private static final NaviSpeechManager sInstance = new NaviSpeechManager();
    private SpeechEventDispatcher mSpeechEventDispatcher;
    private SpeechCommandBuilder mSpeechCommandBuilder = new SpeechCommandBuilder();
    private final Object mLock = new Object();
    @NonNull
    private final ConcurrentLinkedQueue<BaseSpeechCommand> mCommandList = new ConcurrentLinkedQueue<BaseSpeechCommand>() { // from class: com.xiaopeng.montecarlo.speech.manager.NaviSpeechManager.1
        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<BaseSpeechCommand> it = iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                sb.append(" ");
            }
            return sb.toString();
        }
    };
    private ISpeechSchedue mSpeechSchedue = new ISpeechSchedue() { // from class: com.xiaopeng.montecarlo.speech.manager.NaviSpeechManager.2
        @Override // com.xiaopeng.montecarlo.speech.manager.ISpeechSchedue
        public boolean executeSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
            if (NaviSpeechManager.this.mSpeechEventDispatcher == null) {
                L.w(NaviSpeechManager.TAG, "executeSpeechEvent, mSpeechEventDispatcher is null");
                return false;
            }
            speechNaviEvent.record("NaviSpeechManager", "executeSpeechEvent", new String[0]);
            return NaviSpeechManager.this.mSpeechEventDispatcher.dispatchSpeechEvent(speechNaviEvent, iCommandCallback);
        }

        @Override // com.xiaopeng.montecarlo.speech.manager.ISpeechSchedue
        public void onNextCommand() {
            synchronized (NaviSpeechManager.this.mLock) {
                BaseSpeechCommand baseSpeechCommand = (BaseSpeechCommand) NaviSpeechManager.this.mCommandList.poll();
                if (baseSpeechCommand != null) {
                    baseSpeechCommand.executeCommand();
                }
            }
        }

        @Override // com.xiaopeng.montecarlo.speech.manager.ISpeechSchedue
        public List<BaseSpeechCommand> createCommands(String str) {
            return NaviSpeechManager.this.mSpeechCommandBuilder.createCommands(str);
        }

        @Override // com.xiaopeng.montecarlo.speech.manager.ISpeechSchedue
        public void scheduleCommands(List<BaseSpeechCommand> list) {
            if (list == null) {
                return;
            }
            synchronized (NaviSpeechManager.this.mLock) {
                NaviSpeechManager.this.mCommandList.addAll(list);
                list.clear();
                if (L.ENABLE) {
                    L.Tag tag = NaviSpeechManager.TAG;
                    L.d(tag, " remain " + NaviSpeechManager.this.mCommandList.size() + ": " + NaviSpeechManager.this.mCommandList.toString());
                }
                NaviSpeechManager.this.mSpeechSchedue.onNextCommand();
            }
        }
    };

    @NonNull
    public static NaviSpeechManager getInstance() {
        return sInstance;
    }

    public void initSpeechDispatcher(ISpeechEvent iSpeechEvent) {
        SpeechEventDispatcher speechEventDispatcher = this.mSpeechEventDispatcher;
        if (speechEventDispatcher == null) {
            this.mSpeechEventDispatcher = new SpeechEventDispatcher(iSpeechEvent);
        } else {
            speechEventDispatcher.setMainContext(iSpeechEvent);
        }
    }

    public void deinitSpeechDispatcher() {
        this.mSpeechEventDispatcher = null;
    }

    public ISpeechSchedue getSpeechSchedue() {
        return this.mSpeechSchedue;
    }
}
