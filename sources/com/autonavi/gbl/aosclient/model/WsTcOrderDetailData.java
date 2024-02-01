package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderDetailData implements Serializable {
    public WsTcOrderDetailOrder order;
    public WsTcOrderDetailOrderExt orderExt;

    public WsTcOrderDetailData() {
        this.order = new WsTcOrderDetailOrder();
        this.orderExt = new WsTcOrderDetailOrderExt();
    }

    public WsTcOrderDetailData(WsTcOrderDetailOrder wsTcOrderDetailOrder, WsTcOrderDetailOrderExt wsTcOrderDetailOrderExt) {
        this.order = wsTcOrderDetailOrder;
        this.orderExt = wsTcOrderDetailOrderExt;
    }
}
