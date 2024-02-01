package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMSearchChatResult implements Serializable {
    private static final long serialVersionUID = 6581211062623079970L;
    public AIMMessage message;
    public ArrayList<AIMSearchHighlightRange> ranges;

    public AIMSearchChatResult(AIMMessage aIMMessage, ArrayList<AIMSearchHighlightRange> arrayList) {
        this.message = aIMMessage;
        this.ranges = arrayList;
    }

    public AIMSearchChatResult() {
    }

    public AIMMessage getMessage() {
        return this.message;
    }

    public ArrayList<AIMSearchHighlightRange> getRanges() {
        return this.ranges;
    }

    public String toString() {
        return "AIMSearchChatResult{message=" + this.message + ",ranges=" + this.ranges + "}";
    }
}
