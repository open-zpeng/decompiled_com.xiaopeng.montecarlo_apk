package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class BizWeixinQrTicketResponse {
    @SerializedName("qrTicket")
    String mQrTicket;

    protected boolean canEqual(Object obj) {
        return obj instanceof BizWeixinQrTicketResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BizWeixinQrTicketResponse) {
            BizWeixinQrTicketResponse bizWeixinQrTicketResponse = (BizWeixinQrTicketResponse) obj;
            if (bizWeixinQrTicketResponse.canEqual(this)) {
                String qrTicket = getQrTicket();
                String qrTicket2 = bizWeixinQrTicketResponse.getQrTicket();
                return qrTicket != null ? qrTicket.equals(qrTicket2) : qrTicket2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String qrTicket = getQrTicket();
        return 59 + (qrTicket == null ? 43 : qrTicket.hashCode());
    }

    public BizWeixinQrTicketResponse setQrTicket(String str) {
        this.mQrTicket = str;
        return this;
    }

    public String toString() {
        return "BizWeixinQrTicketResponse(mQrTicket=" + getQrTicket() + ")";
    }

    public String getQrTicket() {
        return this.mQrTicket;
    }
}
