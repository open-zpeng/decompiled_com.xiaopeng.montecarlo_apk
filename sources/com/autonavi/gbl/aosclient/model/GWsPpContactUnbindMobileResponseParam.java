package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpContactUnbindMobileResponseParam extends BLResponseBase implements Serializable {
    public String errmsg = "";
    public String err_order_id = "";
    public WsPpContactUnbindDataOrderConf order_conf = new WsPpContactUnbindDataOrderConf();
}
