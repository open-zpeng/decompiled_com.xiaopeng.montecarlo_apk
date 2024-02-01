package com.autonavi.gbl.search.model;

import com.autonavi.gbl.search.model.SearchBusyStatus;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchParkingInfoBase implements Serializable {
    @SearchBusyStatus.SearchBusyStatus1
    public int busyStatus;
    public int spaceFree;
    public int spaceTotal;

    public SearchParkingInfoBase() {
        this.spaceTotal = -1;
        this.spaceFree = -1;
        this.busyStatus = 0;
    }

    public SearchParkingInfoBase(int i, int i2, @SearchBusyStatus.SearchBusyStatus1 int i3) {
        this.spaceTotal = i;
        this.spaceFree = i2;
        this.busyStatus = i3;
    }
}
