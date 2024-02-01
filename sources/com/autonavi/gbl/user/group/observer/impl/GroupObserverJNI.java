package com.autonavi.gbl.user.group.observer.impl;

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
/* loaded from: classes2.dex */
public class GroupObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_0(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseStatus groupResponseStatus) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseStatus);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_1(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseCreate groupResponseCreate) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseCreate);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_2(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseDissolve groupResponseDissolve) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseDissolve);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_3(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseJoin groupResponseJoin) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseJoin);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_4(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseQuit groupResponseQuit) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseQuit);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_5(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseInvite groupResponseInvite) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseInvite);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_6(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseKick groupResponseKick) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseKick);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_7(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseInfo groupResponseInfo) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseInfo);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_8(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseUpdate groupResponseUpdate) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseUpdate);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_9(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseSetNickName groupResponseSetNickName) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseSetNickName);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_10(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseFriendList groupResponseFriendList) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseFriendList);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_11(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseInviteQRUrl groupResponseInviteQRUrl) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseInviteQRUrl);
    }

    public static void SwigDirector_IGroupServiceObserverImpl_onNotify__SWIG_12(IGroupServiceObserverImpl iGroupServiceObserverImpl, int i, long j, GroupResponseUrlTranslate groupResponseUrlTranslate) {
        iGroupServiceObserverImpl.onNotify(i, j, groupResponseUrlTranslate);
    }
}
