package com.xiaopeng.montecarlo.navcore.speech.log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
/* loaded from: classes3.dex */
public class SpeechLogRecord {
    @SerializedName("child_thread")
    private int mChildThread;
    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private String mMsg;
    @SerializedName("process_thread")
    private int mProcessThread;
    @SerializedName("time_str")
    private String mTimeStr;
    @SerializedName(SpeechRequestFactory.PARAM_WHAT)
    private int mWhat;

    protected boolean canEqual(Object obj) {
        return obj instanceof SpeechLogRecord;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpeechLogRecord) {
            SpeechLogRecord speechLogRecord = (SpeechLogRecord) obj;
            if (speechLogRecord.canEqual(this) && getWhat() == speechLogRecord.getWhat() && getProcessThread() == speechLogRecord.getProcessThread() && getChildThread() == speechLogRecord.getChildThread()) {
                String timeStr = getTimeStr();
                String timeStr2 = speechLogRecord.getTimeStr();
                if (timeStr != null ? timeStr.equals(timeStr2) : timeStr2 == null) {
                    String msg = getMsg();
                    String msg2 = speechLogRecord.getMsg();
                    return msg != null ? msg.equals(msg2) : msg2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int what = ((((getWhat() + 59) * 59) + getProcessThread()) * 59) + getChildThread();
        String timeStr = getTimeStr();
        int hashCode = (what * 59) + (timeStr == null ? 43 : timeStr.hashCode());
        String msg = getMsg();
        return (hashCode * 59) + (msg != null ? msg.hashCode() : 43);
    }

    public SpeechLogRecord setChildThread(int i) {
        this.mChildThread = i;
        return this;
    }

    public SpeechLogRecord setMsg(String str) {
        this.mMsg = str;
        return this;
    }

    public SpeechLogRecord setProcessThread(int i) {
        this.mProcessThread = i;
        return this;
    }

    public SpeechLogRecord setTimeStr(String str) {
        this.mTimeStr = str;
        return this;
    }

    public SpeechLogRecord setWhat(int i) {
        this.mWhat = i;
        return this;
    }

    public int getWhat() {
        return this.mWhat;
    }

    public String getTimeStr() {
        return this.mTimeStr;
    }

    public int getProcessThread() {
        return this.mProcessThread;
    }

    public int getChildThread() {
        return this.mChildThread;
    }

    public String getMsg() {
        return this.mMsg;
    }

    @NonNull
    public String toString() {
        return this.mTimeStr + " " + this.mProcessThread + "-" + this.mChildThread + "  " + this.mWhat + "  " + this.mMsg;
    }
}
