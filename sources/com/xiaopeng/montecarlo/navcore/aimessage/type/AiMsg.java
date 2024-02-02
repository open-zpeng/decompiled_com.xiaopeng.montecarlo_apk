package com.xiaopeng.montecarlo.navcore.aimessage.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class AiMsg implements Parcelable {
    public static final int AI_MSG_PERMANENT_SHOW = 1;
    public static final Parcelable.Creator<AiMsg> CREATOR = new Parcelable.Creator<AiMsg>() { // from class: com.xiaopeng.montecarlo.navcore.aimessage.type.AiMsg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AiMsg createFromParcel(Parcel parcel) {
            return new AiMsg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AiMsg[] newArray(int i) {
            return new AiMsg[i];
        }
    };
    @SerializedName("buttons")
    private MessageContentBean.MsgButton[] mButtons;
    @SerializedName("permanent")
    private int mPermanent;
    @SerializedName("position")
    private int mPosition;
    @SerializedName("titles")
    private String[] mTitles;
    @SerializedName("ts")
    private long mTs;
    @SerializedName("tts")
    private String mTts;
    @SerializedName("type")
    private int mType;
    @SerializedName("validEndTs")
    private long mValidEndTs;
    @SerializedName("validStartTs")
    private long mValidStartTs;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }

    public void setTitles(String[] strArr) {
        this.mTitles = strArr;
    }

    public String[] getTitles() {
        return this.mTitles;
    }

    public void setButtons(MessageContentBean.MsgButton[] msgButtonArr) {
        this.mButtons = msgButtonArr;
    }

    public MessageContentBean.MsgButton[] getButtons() {
        return this.mButtons;
    }

    public void setPermanent(int i) {
        this.mPermanent = i;
    }

    public int getPermanent() {
        return this.mPermanent;
    }

    public void setValidStartTs(long j) {
        this.mValidStartTs = j;
    }

    public long getValidStartTs() {
        return this.mValidStartTs;
    }

    public void setValidEndTs(long j) {
        this.mValidEndTs = j;
    }

    public long getValidEndTs() {
        return this.mValidEndTs;
    }

    public void setTs(long j) {
        this.mTs = j;
    }

    public long getTs() {
        return this.mTs;
    }

    public void setTts(String str) {
        this.mTts = str;
    }

    public String getTts() {
        return this.mTts;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public AiMsg() {
        this.mType = 1;
        this.mValidStartTs = 0L;
        this.mValidEndTs = 0L;
        this.mTs = 0L;
    }

    protected AiMsg(Parcel parcel) {
        this.mType = 1;
        this.mValidStartTs = 0L;
        this.mValidEndTs = 0L;
        this.mTs = 0L;
        this.mType = parcel.readInt();
        this.mPermanent = parcel.readInt();
        this.mValidStartTs = parcel.readLong();
        this.mValidEndTs = parcel.readLong();
        this.mTs = parcel.readLong();
        this.mPosition = parcel.readInt();
        parcel.readStringArray(this.mTitles);
    }

    public String toString() {
        return "AiMsg{mType=" + this.mType + ", mTitles=" + Arrays.toString(this.mTitles) + ", mButtons=" + Arrays.toString(this.mButtons) + ", mPermanent=" + this.mPermanent + ", mValidStartTs=" + this.mValidStartTs + ", mValidEndTs=" + this.mValidEndTs + ", mTs=" + this.mTs + ", mPostion=" + this.mPosition + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        parcel.writeStringArray(this.mTitles);
        parcel.writeInt(this.mPermanent);
        parcel.writeLong(this.mValidStartTs);
        parcel.writeLong(this.mValidEndTs);
        parcel.writeLong(this.mTs);
        parcel.writeInt(this.mPosition);
    }
}
