package com.xiaopeng.montecarlo.scenes.downloadscene.operation.event;
/* loaded from: classes2.dex */
public enum DownloadStateEvent {
    DOWNLOAD_EVENT_START_OR_PAUSE(1, "START_OR_PAUSE"),
    DOWNLOAD_EVENT_CANCEL(2, "CANCEL"),
    DOWNLOAD_EVENT_DELETE(3, "DELETE");
    
    private int mId;
    private String mName;

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    DownloadStateEvent(int i, String str) {
        this.mId = i;
        this.mName = str;
    }

    public Integer getValue() {
        return Integer.valueOf(this.mId);
    }

    public static DownloadStateEvent parse(int i) {
        DownloadStateEvent[] values;
        for (DownloadStateEvent downloadStateEvent : values()) {
            if (downloadStateEvent.getId() == i) {
                return downloadStateEvent;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mName;
    }
}
