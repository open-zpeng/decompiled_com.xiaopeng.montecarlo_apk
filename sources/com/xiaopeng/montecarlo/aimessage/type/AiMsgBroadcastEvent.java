package com.xiaopeng.montecarlo.aimessage.type;
/* loaded from: classes.dex */
public final class AiMsgBroadcastEvent {
    public static final int ID_AIMSG_SHOW = 1000;
    private int mId;
    private String mMessage;

    public AiMsgBroadcastEvent(int i) {
        this(i, null);
    }

    public AiMsgBroadcastEvent(int i, String str) {
        this.mId = 0;
        this.mId = i;
        this.mMessage = str;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }
}
