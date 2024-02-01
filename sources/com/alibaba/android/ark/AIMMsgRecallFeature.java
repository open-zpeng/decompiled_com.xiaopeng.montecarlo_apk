package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMMsgRecallFeature implements Serializable {
    private static final long serialVersionUID = -8300291652935505790L;
    public String code;
    public HashMap<String, String> extension;
    public AIMMsgRecallType operatorType;
    public AIMUserId operatorUid;

    public AIMMsgRecallFeature(AIMMsgRecallType aIMMsgRecallType, String str, AIMUserId aIMUserId, HashMap<String, String> hashMap) {
        this.operatorType = AIMMsgRecallType.RECALL_TYPE_UNKNOWN;
        if (aIMMsgRecallType != null) {
            this.operatorType = aIMMsgRecallType;
        }
        this.code = str;
        this.operatorUid = aIMUserId;
        this.extension = hashMap;
    }

    public AIMMsgRecallFeature() {
        this.operatorType = AIMMsgRecallType.RECALL_TYPE_UNKNOWN;
    }

    public AIMMsgRecallType getOperatorType() {
        return this.operatorType;
    }

    public String getCode() {
        return this.code;
    }

    public AIMUserId getOperatorUid() {
        return this.operatorUid;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public String toString() {
        return "AIMMsgRecallFeature{operatorType=" + this.operatorType + ",code=" + this.code + ",operatorUid=" + this.operatorUid + ",extension=" + this.extension + "}";
    }
}
