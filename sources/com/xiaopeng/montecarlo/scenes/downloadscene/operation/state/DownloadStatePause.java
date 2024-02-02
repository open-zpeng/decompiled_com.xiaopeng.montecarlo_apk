package com.xiaopeng.montecarlo.scenes.downloadscene.operation.state;

import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.event.DownloadStateEvent;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.transition.DownloadStateManager;
/* loaded from: classes2.dex */
public class DownloadStatePause extends AbstractDownloadState {
    private static final L.Tag TAG = new L.Tag("DownloadStatePause");

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.operation.action.IDownloadStateAction
    public AbstractDownloadState pause(Integer num) {
        return this;
    }

    public DownloadStatePause(DownloadStateManager downloadStateManager) {
        super(downloadStateManager);
    }

    /* renamed from: com.xiaopeng.montecarlo.scenes.downloadscene.operation.state.DownloadStatePause$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$scenes$downloadscene$operation$event$DownloadStateEvent = new int[DownloadStateEvent.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$downloadscene$operation$event$DownloadStateEvent[DownloadStateEvent.DOWNLOAD_EVENT_START_OR_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$downloadscene$operation$event$DownloadStateEvent[DownloadStateEvent.DOWNLOAD_EVENT_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$downloadscene$operation$event$DownloadStateEvent[DownloadStateEvent.DOWNLOAD_EVENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.operation.state.AbstractDownloadState
    public AbstractDownloadState handleEvent(DownloadStateEvent downloadStateEvent, Integer num) {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$scenes$downloadscene$operation$event$DownloadStateEvent[downloadStateEvent.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? this : delete(num);
            }
            return cancel(num);
        }
        return start(num);
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.operation.action.IDownloadStateAction
    public AbstractDownloadState cancel(Integer num) {
        this.mManager.getOperator().cancelDownload(num);
        return this.mManager.getDownloadIdleState();
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.operation.action.IDownloadStateAction
    public AbstractDownloadState start(Integer num) {
        this.mManager.getOperator().startDownload(num);
        return this.mManager.getDownloadDoingState();
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.operation.action.IDownloadStateAction
    public AbstractDownloadState delete(Integer num) {
        this.mManager.getOperator().deleteDownload(num);
        return this.mManager.getDownloadIdleState();
    }
}
