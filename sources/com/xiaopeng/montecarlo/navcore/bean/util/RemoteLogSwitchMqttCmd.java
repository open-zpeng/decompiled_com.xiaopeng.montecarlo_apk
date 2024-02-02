package com.xiaopeng.montecarlo.navcore.bean.util;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.common.util.DontProguardClass;
@DontProguardClass
/* loaded from: classes2.dex */
public class RemoteLogSwitchMqttCmd {
    @SerializedName("msg_content")
    private MsgContent mMsgContent;
    @SerializedName("msg_id")
    private String mMsgId;
    @SerializedName("msg_type")
    private int mMsgType;
    @SerializedName("service_type")
    private int mServiceType;

    protected boolean canEqual(Object obj) {
        return obj instanceof RemoteLogSwitchMqttCmd;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RemoteLogSwitchMqttCmd) {
            RemoteLogSwitchMqttCmd remoteLogSwitchMqttCmd = (RemoteLogSwitchMqttCmd) obj;
            if (remoteLogSwitchMqttCmd.canEqual(this) && getMsgType() == remoteLogSwitchMqttCmd.getMsgType() && getServiceType() == remoteLogSwitchMqttCmd.getServiceType()) {
                String msgId = getMsgId();
                String msgId2 = remoteLogSwitchMqttCmd.getMsgId();
                if (msgId != null ? msgId.equals(msgId2) : msgId2 == null) {
                    MsgContent msgContent = getMsgContent();
                    MsgContent msgContent2 = remoteLogSwitchMqttCmd.getMsgContent();
                    return msgContent != null ? msgContent.equals(msgContent2) : msgContent2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int msgType = ((getMsgType() + 59) * 59) + getServiceType();
        String msgId = getMsgId();
        int hashCode = (msgType * 59) + (msgId == null ? 43 : msgId.hashCode());
        MsgContent msgContent = getMsgContent();
        return (hashCode * 59) + (msgContent != null ? msgContent.hashCode() : 43);
    }

    public RemoteLogSwitchMqttCmd setMsgContent(MsgContent msgContent) {
        this.mMsgContent = msgContent;
        return this;
    }

    public RemoteLogSwitchMqttCmd setMsgId(String str) {
        this.mMsgId = str;
        return this;
    }

    public RemoteLogSwitchMqttCmd setMsgType(int i) {
        this.mMsgType = i;
        return this;
    }

    public RemoteLogSwitchMqttCmd setServiceType(int i) {
        this.mServiceType = i;
        return this;
    }

    public String toString() {
        return "RemoteLogSwitchMqttCmd(mMsgId=" + getMsgId() + ", mMsgType=" + getMsgType() + ", mServiceType=" + getServiceType() + ", mMsgContent=" + getMsgContent() + ")";
    }

    @DontProguardClass
    /* loaded from: classes2.dex */
    public class MsgContent {
        @SerializedName("naviLog")
        private String mNaviLog;

        public MsgContent() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof MsgContent;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MsgContent) {
                MsgContent msgContent = (MsgContent) obj;
                if (msgContent.canEqual(this)) {
                    String naviLog = getNaviLog();
                    String naviLog2 = msgContent.getNaviLog();
                    return naviLog != null ? naviLog.equals(naviLog2) : naviLog2 == null;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String naviLog = getNaviLog();
            return 59 + (naviLog == null ? 43 : naviLog.hashCode());
        }

        public MsgContent setNaviLog(String str) {
            this.mNaviLog = str;
            return this;
        }

        public String toString() {
            return "RemoteLogSwitchMqttCmd.MsgContent(mNaviLog=" + getNaviLog() + ")";
        }

        public String getNaviLog() {
            return this.mNaviLog;
        }
    }

    public String getMsgId() {
        return this.mMsgId;
    }

    public int getMsgType() {
        return this.mMsgType;
    }

    public int getServiceType() {
        return this.mServiceType;
    }

    public MsgContent getMsgContent() {
        return this.mMsgContent;
    }
}
