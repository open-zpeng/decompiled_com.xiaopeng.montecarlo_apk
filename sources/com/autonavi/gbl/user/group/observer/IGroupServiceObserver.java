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
@IntfAuto(target = GroupServiceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGroupServiceObserver {
    default void onNotify(int i, long j, GroupResponseCreate groupResponseCreate) {
    }

    default void onNotify(int i, long j, GroupResponseDissolve groupResponseDissolve) {
    }

    default void onNotify(int i, long j, GroupResponseFriendList groupResponseFriendList) {
    }

    default void onNotify(int i, long j, GroupResponseInfo groupResponseInfo) {
    }

    default void onNotify(int i, long j, GroupResponseInvite groupResponseInvite) {
    }

    default void onNotify(int i, long j, GroupResponseInviteQRUrl groupResponseInviteQRUrl) {
    }

    default void onNotify(int i, long j, GroupResponseJoin groupResponseJoin) {
    }

    default void onNotify(int i, long j, GroupResponseKick groupResponseKick) {
    }

    default void onNotify(int i, long j, GroupResponseQuit groupResponseQuit) {
    }

    default void onNotify(int i, long j, GroupResponseSetNickName groupResponseSetNickName) {
    }

    default void onNotify(int i, long j, GroupResponseStatus groupResponseStatus) {
    }

    default void onNotify(int i, long j, GroupResponseUpdate groupResponseUpdate) {
    }

    default void onNotify(int i, long j, GroupResponseUrlTranslate groupResponseUrlTranslate) {
    }
}
