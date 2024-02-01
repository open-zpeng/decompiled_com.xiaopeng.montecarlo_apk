package com.xiaopeng.montecarlo.navcore.bean.util;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.common.util.DontProguardClass;
@DontProguardClass
/* loaded from: classes3.dex */
public class RemoteLogSwitchMqttResponse {
    @SerializedName("app_id")
    private String mAppId;
    @SerializedName("is_can_log_enabled")
    private boolean mIsCanLogEnabled;
    @SerializedName("success")
    private boolean mIsSuccess;
    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private String mMsg;
    @SerializedName("msg_id")
    private String mMsgId;

    protected boolean canEqual(Object obj) {
        return obj instanceof RemoteLogSwitchMqttResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RemoteLogSwitchMqttResponse) {
            RemoteLogSwitchMqttResponse remoteLogSwitchMqttResponse = (RemoteLogSwitchMqttResponse) obj;
            if (remoteLogSwitchMqttResponse.canEqual(this) && isCanLogEnabled() == remoteLogSwitchMqttResponse.isCanLogEnabled() && isSuccess() == remoteLogSwitchMqttResponse.isSuccess()) {
                String msgId = getMsgId();
                String msgId2 = remoteLogSwitchMqttResponse.getMsgId();
                if (msgId != null ? msgId.equals(msgId2) : msgId2 == null) {
                    String appId = getAppId();
                    String appId2 = remoteLogSwitchMqttResponse.getAppId();
                    if (appId != null ? appId.equals(appId2) : appId2 == null) {
                        String msg = getMsg();
                        String msg2 = remoteLogSwitchMqttResponse.getMsg();
                        return msg != null ? msg.equals(msg2) : msg2 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = (((isCanLogEnabled() ? 79 : 97) + 59) * 59) + (isSuccess() ? 79 : 97);
        String msgId = getMsgId();
        int hashCode = (i * 59) + (msgId == null ? 43 : msgId.hashCode());
        String appId = getAppId();
        int hashCode2 = (hashCode * 59) + (appId == null ? 43 : appId.hashCode());
        String msg = getMsg();
        return (hashCode2 * 59) + (msg != null ? msg.hashCode() : 43);
    }

    public RemoteLogSwitchMqttResponse setAppId(String str) {
        this.mAppId = str;
        return this;
    }

    public RemoteLogSwitchMqttResponse setCanLogEnabled(boolean z) {
        this.mIsCanLogEnabled = z;
        return this;
    }

    public RemoteLogSwitchMqttResponse setMsg(String str) {
        this.mMsg = str;
        return this;
    }

    public RemoteLogSwitchMqttResponse setMsgId(String str) {
        this.mMsgId = str;
        return this;
    }

    public RemoteLogSwitchMqttResponse setSuccess(boolean z) {
        this.mIsSuccess = z;
        return this;
    }

    public String toString() {
        return "RemoteLogSwitchMqttResponse(mMsgId=" + getMsgId() + ", mAppId=" + getAppId() + ", mIsCanLogEnabled=" + isCanLogEnabled() + ", mIsSuccess=" + isSuccess() + ", mMsg=" + getMsg() + ")";
    }

    public RemoteLogSwitchMqttResponse(String str, String str2, boolean z, boolean z2, String str3) {
        this.mMsgId = str;
        this.mAppId = str2;
        this.mIsCanLogEnabled = z;
        this.mIsSuccess = z2;
        this.mMsg = str3;
    }

    public String getMsgId() {
        return this.mMsgId;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public boolean isCanLogEnabled() {
        return this.mIsCanLogEnabled;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public String getMsg() {
        return this.mMsg;
    }
}
