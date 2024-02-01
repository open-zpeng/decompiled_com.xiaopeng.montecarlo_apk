package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class IntervalCameraPair implements Serializable {
    public BigInteger endCameraId;
    public BigInteger matchID;
    public CameraSpeedLimit speedLimit;

    public IntervalCameraPair() {
        this.matchID = new BigInteger("0");
        this.endCameraId = new BigInteger("0");
        this.speedLimit = new CameraSpeedLimit();
    }

    public IntervalCameraPair(BigInteger bigInteger, BigInteger bigInteger2, CameraSpeedLimit cameraSpeedLimit) {
        this.matchID = bigInteger;
        this.endCameraId = bigInteger2;
        this.speedLimit = cameraSpeedLimit;
    }
}
