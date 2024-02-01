package com.autonavi.gbl.user.msgpush.model;

import com.autonavi.gbl.user.msgpush.model.MsgPushType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class AimPushMsg implements Serializable {
    public DestinationPushMsg aimDestMsg;
    public AimPoiPushMsg aimPoiMsg;
    public AimRoutePushMsg aimRouteMsg;
    @MsgPushType.MsgPushType1
    public int bizType;

    public AimPushMsg() {
        this.bizType = -1;
        this.aimPoiMsg = new AimPoiPushMsg();
        this.aimRouteMsg = new AimRoutePushMsg();
        this.aimDestMsg = new DestinationPushMsg();
    }

    public AimPushMsg(@MsgPushType.MsgPushType1 int i, AimPoiPushMsg aimPoiPushMsg, AimRoutePushMsg aimRoutePushMsg, DestinationPushMsg destinationPushMsg) {
        this.bizType = i;
        this.aimPoiMsg = aimPoiPushMsg;
        this.aimRouteMsg = aimRoutePushMsg;
        this.aimDestMsg = destinationPushMsg;
    }
}
