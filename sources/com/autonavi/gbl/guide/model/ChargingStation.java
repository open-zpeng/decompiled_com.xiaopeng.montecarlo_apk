package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.ChargeStationInfo;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class ChargingStation implements Serializable {
    public BigInteger chargeEnrgySum;
    public ChargeStationInfo chargeInfo;

    public ChargingStation() {
        this.chargeEnrgySum = new BigInteger("0");
        this.chargeInfo = new ChargeStationInfo();
    }

    public ChargingStation(BigInteger bigInteger, ChargeStationInfo chargeStationInfo) {
        this.chargeEnrgySum = bigInteger;
        this.chargeInfo = chargeStationInfo;
    }
}
