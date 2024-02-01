package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMSearchConversationResult implements Serializable {
    private static final long serialVersionUID = 5685407940633367348L;
    public AIMConversation conversation;
    public AIMMessage firstMessage;
    public ArrayList<AIMSearchHighlightRange> ranges;

    public AIMSearchConversationResult(AIMConversation aIMConversation, AIMMessage aIMMessage, ArrayList<AIMSearchHighlightRange> arrayList) {
        this.conversation = aIMConversation;
        this.firstMessage = aIMMessage;
        this.ranges = arrayList;
    }

    public AIMSearchConversationResult() {
    }

    public AIMConversation getConversation() {
        return this.conversation;
    }

    public AIMMessage getFirstMessage() {
        return this.firstMessage;
    }

    public ArrayList<AIMSearchHighlightRange> getRanges() {
        return this.ranges;
    }

    public String toString() {
        return "AIMSearchConversationResult{conversation=" + this.conversation + ",firstMessage=" + this.firstMessage + ",ranges=" + this.ranges + "}";
    }
}
