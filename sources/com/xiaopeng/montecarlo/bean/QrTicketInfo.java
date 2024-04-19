package com.xiaopeng.montecarlo.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class QrTicketInfo implements Serializable {
    @SerializedName("qrTicket")
    private String mQrTicket;

    public void setQrTicket(String str) {
        this.mQrTicket = str;
    }

    public String getQrTicket() {
        return this.mQrTicket;
    }

    public String toString() {
        return "QrTicketInfo{mQrTicket='" + this.mQrTicket + "'}";
    }
}
