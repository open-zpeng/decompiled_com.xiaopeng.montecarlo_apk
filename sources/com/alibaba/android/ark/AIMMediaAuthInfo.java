package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMediaAuthInfo implements Serializable {
    private static final long serialVersionUID = -8262078204131479109L;
    public String bizType;
    public AIMGroupAvatorMediaAuthInfo groupAvatorAuth;
    public AIMMsgMediaAuthInfo msgAuth;
    public AIMMediaAuthScene scene;

    public AIMMediaAuthInfo(AIMMediaAuthScene aIMMediaAuthScene, String str, AIMGroupAvatorMediaAuthInfo aIMGroupAvatorMediaAuthInfo, AIMMsgMediaAuthInfo aIMMsgMediaAuthInfo) {
        this.scene = AIMMediaAuthScene.MAC_UNKNOWN;
        if (aIMMediaAuthScene != null) {
            this.scene = aIMMediaAuthScene;
        }
        this.bizType = str;
        this.groupAvatorAuth = aIMGroupAvatorMediaAuthInfo;
        this.msgAuth = aIMMsgMediaAuthInfo;
    }

    public AIMMediaAuthInfo() {
        this.scene = AIMMediaAuthScene.MAC_UNKNOWN;
    }

    public AIMMediaAuthScene getScene() {
        return this.scene;
    }

    public String getBizType() {
        return this.bizType;
    }

    public AIMGroupAvatorMediaAuthInfo getGroupAvatorAuth() {
        return this.groupAvatorAuth;
    }

    public AIMMsgMediaAuthInfo getMsgAuth() {
        return this.msgAuth;
    }

    public String toString() {
        return "AIMMediaAuthInfo{scene=" + this.scene + ",bizType=" + this.bizType + ",groupAvatorAuth=" + this.groupAvatorAuth + ",msgAuth=" + this.msgAuth + "}";
    }
}
