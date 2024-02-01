package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupMemberUpdateNick implements Serializable {
    private static final long serialVersionUID = 6681353976772920610L;
    public String cid;
    public String nick;
    public String operatorNick;
    public AIMUserId uid;

    public AIMGroupMemberUpdateNick(String str, String str2, AIMUserId aIMUserId, String str3) {
        this.operatorNick = str;
        this.cid = str2;
        this.uid = aIMUserId;
        this.nick = str3;
    }

    public AIMGroupMemberUpdateNick() {
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public String getCid() {
        return this.cid;
    }

    public AIMUserId getUid() {
        return this.uid;
    }

    public String getNick() {
        return this.nick;
    }

    public String toString() {
        return "AIMGroupMemberUpdateNick{operatorNick=" + this.operatorNick + ",cid=" + this.cid + ",uid=" + this.uid + ",nick=" + this.nick + "}";
    }
}
