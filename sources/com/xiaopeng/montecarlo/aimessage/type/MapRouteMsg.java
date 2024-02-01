package com.xiaopeng.montecarlo.aimessage.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.aimessage.AiMsgUtils;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.speech.protocol.bean.FeedListUIValue;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class MapRouteMsg implements Parcelable {
    public static final Parcelable.Creator<MapRouteMsg> CREATOR = new Parcelable.Creator<MapRouteMsg>() { // from class: com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapRouteMsg createFromParcel(Parcel parcel) {
            return new MapRouteMsg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapRouteMsg[] newArray(int i) {
            return new MapRouteMsg[i];
        }
    };
    public static final int FUNCTION_CHARGE_SEARCH = 3;
    public static final int FUNCTION_FROM_PHONE_ROUTE = 4;
    public static final int FUNCTION_TRAFFIC = 0;
    public static final int FUNCTION_WECHAT = 1;
    public static final int FUNCTION_XP_APP = 2;
    public static final String MAPROUTEMSG_FUNCTION = "MapRouteMsg_funtion";
    public static final String MAPROUTEMSG_IS_FILTER_CHARGE = "MapRouteMsg_is_filter_charge";
    @SerializedName(DebugConfiguration.DebugIntentActionExtra.DEST)
    private MapPoint mDest;
    @SerializedName("function_id")
    private int mFunctionId = 0;
    @SerializedName(FeedListUIValue.TYPE_ROUTE)
    private boolean mIsRoute = false;
    @SerializedName("option")
    private MapRouteOption mOption;
    @SerializedName("start")
    private MapPoint mStart;
    @SerializedName(AiMsgUtils.KEY_EXTRA_VIA)
    private MapPoint[] mVia;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setStart(MapPoint mapPoint) {
        this.mStart = mapPoint;
    }

    public MapPoint getStart() {
        return this.mStart;
    }

    public void setDest(MapPoint mapPoint) {
        this.mDest = mapPoint;
    }

    public MapPoint getDest() {
        return this.mDest;
    }

    public void setVia(MapPoint[] mapPointArr) {
        this.mVia = mapPointArr;
    }

    public MapPoint[] getVia() {
        return this.mVia;
    }

    public void setOption(MapRouteOption mapRouteOption) {
        this.mOption = mapRouteOption;
    }

    public MapRouteOption getOption() {
        return this.mOption;
    }

    public void setFunctionId(int i) {
        this.mFunctionId = i;
    }

    public int getFunctionId() {
        return this.mFunctionId;
    }

    public void setRoute(boolean z) {
        this.mIsRoute = z;
    }

    public boolean isRoute() {
        return this.mIsRoute;
    }

    public MapRouteMsg() {
    }

    protected MapRouteMsg(Parcel parcel) {
        this.mStart = (MapPoint) parcel.readParcelable(MapPoint.class.getClassLoader());
        this.mDest = (MapPoint) parcel.readParcelable(MapPoint.class.getClassLoader());
        this.mVia = (MapPoint[]) parcel.createTypedArray(MapPoint.CREATOR);
        this.mOption = (MapRouteOption) parcel.readParcelable(MapRouteOption.class.getClassLoader());
    }

    public String toString() {
        return "MapRouteMsg{mStart=" + this.mStart + ", mDest=" + this.mDest + ", mVia=" + Arrays.toString(this.mVia) + ", mOption=" + this.mOption + ", mFunctionId=" + this.mFunctionId + ", mIsRoute=" + this.mIsRoute + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mStart, i);
        parcel.writeParcelable(this.mDest, i);
        parcel.writeTypedArray(this.mVia, i);
        parcel.writeParcelable(this.mOption, i);
    }
}
