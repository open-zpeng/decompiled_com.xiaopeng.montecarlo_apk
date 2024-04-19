package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.guide.model.SoundContentType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SoundContent implements Serializable {
    public String content;
    @SoundContentType.SoundContentType1
    public int contentType;

    public SoundContent() {
        this.content = "";
        this.contentType = 0;
    }

    public SoundContent(String str, @SoundContentType.SoundContentType1 int i) {
        this.content = str;
        this.contentType = i;
    }
}
