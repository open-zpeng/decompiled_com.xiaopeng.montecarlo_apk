package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneLndsAutoDownloadMode;
import com.autonavi.gbl.lane.model.LndsSourceDataMode;
import java.io.Serializable;
import org.apache.commons.compress.archivers.tar.TarConstants;
/* loaded from: classes.dex */
public class LaneInitParam implements Serializable {
    @LndsSourceDataMode.LndsSourceDataMode1
    public int dataMode;
    @LaneLndsAutoDownloadMode.LaneLndsAutoDownloadMode1
    public int downloadMode;
    public boolean enableDiagnosis;
    public boolean offlineAutoDelete;
    public boolean offlineDebug;
    public int offlineLimitMB;
    public int tileLimitCount;

    public LaneInitParam() {
        this.offlineDebug = false;
        this.dataMode = 0;
        this.downloadMode = 1;
        this.offlineAutoDelete = false;
        this.offlineLimitMB = TarConstants.DEFAULT_BLKSIZE;
        this.tileLimitCount = 1000;
        this.enableDiagnosis = false;
    }

    public LaneInitParam(boolean z, @LndsSourceDataMode.LndsSourceDataMode1 int i, @LaneLndsAutoDownloadMode.LaneLndsAutoDownloadMode1 int i2, boolean z2, int i3, int i4, boolean z3) {
        this.offlineDebug = z;
        this.dataMode = i;
        this.downloadMode = i2;
        this.offlineAutoDelete = z2;
        this.offlineLimitMB = i3;
        this.tileLimitCount = i4;
        this.enableDiagnosis = z3;
    }
}
