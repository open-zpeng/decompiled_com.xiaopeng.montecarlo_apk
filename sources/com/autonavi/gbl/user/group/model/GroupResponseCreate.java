package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GroupResponseCreate extends GroupResponse implements Serializable {
    public String teamStamp = "";
    public String memberStamp = "";
    public GroupBaseInfo team = new GroupBaseInfo();
    public ArrayList<GroupMember> members = new ArrayList<>();
}
