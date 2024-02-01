package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMGroupUserInfo implements Serializable {
    private static final long serialVersionUID = -1496751612783689591L;
    public HashMap<String, String> extension;
    public String nickName;
    public AIMUserId uid;

    public AIMGroupUserInfo(AIMUserId aIMUserId, String str, HashMap<String, String> hashMap) {
        this.uid = aIMUserId;
        this.nickName = str;
        this.extension = hashMap;
    }

    public AIMGroupUserInfo() {
    }

    public AIMUserId getUid() {
        return this.uid;
    }

    public String getNickName() {
        return this.nickName;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public String toString() {
        return "AIMGroupUserInfo{uid=" + this.uid + ",nickName=" + this.nickName + ",extension=" + this.extension + "}";
    }
}
