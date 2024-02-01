package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.model.InformationResponse;
import com.autonavi.gbl.information.trade.model.AgreementStatus;
import com.autonavi.gbl.information.trade.model.PayChannel;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AgreementStatusResult extends InformationResponse implements Serializable {
    public int code = 0;
    public String agreementNo = "";
    @AgreementStatus.AgreementStatus1
    public int agreementStatus = -1;
    @PayChannel.PayChannel1
    public int payChannel = -1;
}
