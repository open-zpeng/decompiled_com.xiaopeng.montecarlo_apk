package com.autonavi.gbl.user.group.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.group.model.GroupResponseCreate;
import com.autonavi.gbl.user.group.model.GroupResponseDissolve;
import com.autonavi.gbl.user.group.model.GroupResponseFriendList;
import com.autonavi.gbl.user.group.model.GroupResponseInfo;
import com.autonavi.gbl.user.group.model.GroupResponseInvite;
import com.autonavi.gbl.user.group.model.GroupResponseInviteQRUrl;
import com.autonavi.gbl.user.group.model.GroupResponseJoin;
import com.autonavi.gbl.user.group.model.GroupResponseKick;
import com.autonavi.gbl.user.group.model.GroupResponseQuit;
import com.autonavi.gbl.user.group.model.GroupResponseSetNickName;
import com.autonavi.gbl.user.group.model.GroupResponseStatus;
import com.autonavi.gbl.user.group.model.GroupResponseUpdate;
import com.autonavi.gbl.user.group.model.GroupResponseUrlTranslate;
import com.autonavi.gbl.user.router.GroupServiceObserverRouter;
import com.autonavi.gbl.util.model.ErrorCode;
@IntfAuto(target = GroupServiceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGroupServiceObserver {
    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseCreate groupResponseCreate);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseDissolve groupResponseDissolve);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseFriendList groupResponseFriendList);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseInfo groupResponseInfo);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseInvite groupResponseInvite);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseInviteQRUrl groupResponseInviteQRUrl);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseJoin groupResponseJoin);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseKick groupResponseKick);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseQuit groupResponseQuit);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseSetNickName groupResponseSetNickName);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseStatus groupResponseStatus);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseUpdate groupResponseUpdate);

    void onNotify(@ErrorCode.ErrorCode1 int i, long j, GroupResponseUrlTranslate groupResponseUrlTranslate);
}
