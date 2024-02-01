package com.autonavi.gbl.common.model;

import com.autonavi.gbl.common.model.DetailCategory;
import java.io.Serializable;
/* loaded from: classes.dex */
public class STDetail implements Serializable {
    @DetailCategory.DetailCategory1
    public int detailCategory;
    public long detailType;
    public STTipsBaseElement element;

    public STDetail() {
        this.detailType = 0L;
        this.detailCategory = 0;
        this.element = new STTipsBaseElement();
    }

    public STDetail(long j, @DetailCategory.DetailCategory1 int i, STTipsBaseElement sTTipsBaseElement) {
        this.detailType = j;
        this.detailCategory = i;
        this.element = sTTipsBaseElement;
    }
}
