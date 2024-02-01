package com.autonavi.gbl.user.group.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class GroupRequestType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int GroupRequestTypeCreate = 2;
    public static final int GroupRequestTypeDissolve = 3;
    public static final int GroupRequestTypeFriendList = 11;
    public static final int GroupRequestTypeInfo = 8;
    public static final int GroupRequestTypeInvite = 6;
    public static final int GroupRequestTypeInviteQRUrl = 12;
    public static final int GroupRequestTypeJoin = 4;
    public static final int GroupRequestTypeKick = 7;
    public static final int GroupRequestTypeQuit = 5;
    public static final int GroupRequestTypeSetNickName = 10;
    public static final int GroupRequestTypeStatus = 1;
    public static final int GroupRequestTypeUnknown = 0;
    public static final int GroupRequestTypeUpdate = 9;
    public static final int GroupRequestTypeUrlTranslate = 13;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface GroupRequestType1 {
    }
}
