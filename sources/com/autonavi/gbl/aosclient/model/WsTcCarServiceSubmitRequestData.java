package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCarServiceSubmitRequestData implements Serializable {
    public String ajxVersion;
    public WsTcCarServiceSubmitBlackCardOrder blackCardOrder;
    public boolean blackCardSelected;
    public WsTcCarServiceSubmitCarServiceOrder carServiceOrder;
    public WsTcCarServiceSubmitDataCouponInfo couponInfo;
    public String totalPrice;
    public String user_adcode;

    public WsTcCarServiceSubmitRequestData() {
        this.ajxVersion = "";
        this.totalPrice = "";
        this.blackCardSelected = false;
        this.carServiceOrder = new WsTcCarServiceSubmitCarServiceOrder();
        this.blackCardOrder = new WsTcCarServiceSubmitBlackCardOrder();
        this.couponInfo = new WsTcCarServiceSubmitDataCouponInfo();
        this.user_adcode = "";
    }

    public WsTcCarServiceSubmitRequestData(String str, String str2, boolean z, WsTcCarServiceSubmitCarServiceOrder wsTcCarServiceSubmitCarServiceOrder, WsTcCarServiceSubmitBlackCardOrder wsTcCarServiceSubmitBlackCardOrder, WsTcCarServiceSubmitDataCouponInfo wsTcCarServiceSubmitDataCouponInfo, String str3) {
        this.ajxVersion = str;
        this.totalPrice = str2;
        this.blackCardSelected = z;
        this.carServiceOrder = wsTcCarServiceSubmitCarServiceOrder;
        this.blackCardOrder = wsTcCarServiceSubmitBlackCardOrder;
        this.couponInfo = wsTcCarServiceSubmitDataCouponInfo;
        this.user_adcode = str3;
    }
}
