package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserFriendsResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceTeamUserFriendsRouter;
@IntfAuto(target = CallBackWsTserviceTeamUserFriendsRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceTeamUserFriends {
    void onRecvAck(GWsTserviceTeamUserFriendsResponseParam gWsTserviceTeamUserFriendsResponseParam);
}
