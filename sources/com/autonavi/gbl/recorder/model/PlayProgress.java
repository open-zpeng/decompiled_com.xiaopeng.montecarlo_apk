package com.autonavi.gbl.recorder.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PlayProgress implements Serializable {
    public long currentMessageIndex;
    public long fileIndex;
    public long fileTotalCount;
    public String playName;
    public long totalMessageCount;
    public long unixTimestamp;

    public PlayProgress() {
        this.fileIndex = 0L;
        this.fileTotalCount = 0L;
        this.playName = "";
        this.currentMessageIndex = 0L;
        this.totalMessageCount = 0L;
        this.unixTimestamp = 0L;
    }

    public PlayProgress(long j, long j2, String str, long j3, long j4, long j5) {
        this.fileIndex = j;
        this.fileTotalCount = j2;
        this.playName = str;
        this.currentMessageIndex = j3;
        this.totalMessageCount = j4;
        this.unixTimestamp = j5;
    }
}
