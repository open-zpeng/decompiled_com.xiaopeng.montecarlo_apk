package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.VoiceEngineType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Voice extends FileDataItem implements Serializable {
    @VoiceEngineType.VoiceEngineType1
    public int engineType = 1;
    public String auditionUrl = "";
    public String imageUrl = "";
    public String fileMd5 = "";
}
