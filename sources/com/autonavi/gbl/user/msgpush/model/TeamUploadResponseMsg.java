package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TeamUploadResponseMsg extends MsgPushItem implements Serializable {
    public int state = -1;
    public int supNum = -1;
    public ArrayList<TeamMember> groupMembers = new ArrayList<>();
}
