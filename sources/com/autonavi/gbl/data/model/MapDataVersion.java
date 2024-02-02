package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.MapDataFileType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MapDataVersion implements Serializable {
    @MapDataFileType.MapDataFileType1
    public int dataFileType;
    public String dataFileVersion;

    public MapDataVersion() {
        this.dataFileType = 0;
        this.dataFileVersion = "";
    }

    public MapDataVersion(@MapDataFileType.MapDataFileType1 int i, String str) {
        this.dataFileType = i;
        this.dataFileVersion = str;
    }
}
