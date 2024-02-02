package com.xiaopeng.montecarlo.scenes.routescene;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.NaviUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RouteRequest implements Parcelable {
    public static final int REQUEST_FROM_AI_ASSISTANT = 2;
    public static final int REQUEST_FROM_DEFAULT = 0;
    public static final int REQUEST_FROM_SPEECH = 1;
    private XPPoiInfo mEndXP;
    private int mRequestFrom;
    private int mRoutePreference;
    private RouteRequestType mRouteRequestType;
    private int mRouteSelectRef;
    private int mStartType;
    private XPPoiInfo mStartXP;
    private int mViaIndex;
    private List<XPViaPoint> mVias;
    public static final Parcelable.Creator<RouteRequest> CREATOR = new Parcelable.Creator<RouteRequest>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteRequest createFromParcel(Parcel parcel) {
            return new RouteRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteRequest[] newArray(int i) {
            return new RouteRequest[i];
        }
    };
    private static final L.Tag TAG = new L.Tag("RouteRequest");

    /* loaded from: classes2.dex */
    public interface IRouteRequestCallback {
        void onFailed(String str);
    }

    /* loaded from: classes2.dex */
    public enum RouteRequestType {
        ROUTE_REQUEST_NORMAL,
        ROUTE_REQUEST_RESTORE,
        ROUTE_REQUEST_ADD_VIA,
        ROUTE_REQUEST_REMOVE_VIA,
        ROUTE_REQUEST_NEW_DESTINATION
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private RouteRequest(Builder builder) {
        this.mStartType = 0;
        this.mRouteSelectRef = 0;
        this.mRoutePreference = -1;
        this.mRequestFrom = 0;
        this.mStartXP = builder.mStartXP;
        this.mEndXP = builder.mEndXP;
        this.mVias = builder.mVias;
        this.mViaIndex = builder.mViaIndex;
        this.mRouteRequestType = builder.mRouteRequestType;
        this.mStartType = builder.mStartType;
        this.mRouteSelectRef = builder.mRouteSelectRef;
        this.mRoutePreference = builder.mRoutePreference;
        this.mRequestFrom = builder.mRequestFrom;
        int i = AnonymousClass2.$SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType[this.mRouteRequestType.ordinal()];
    }

    /* renamed from: com.xiaopeng.montecarlo.scenes.routescene.RouteRequest$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType = new int[RouteRequestType.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType[RouteRequestType.ROUTE_REQUEST_NEW_DESTINATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public RouteRequest(@NonNull RouteRequestType routeRequestType) {
        this.mStartType = 0;
        this.mRouteSelectRef = 0;
        this.mRoutePreference = -1;
        this.mRequestFrom = 0;
        this.mRouteRequestType = routeRequestType;
    }

    protected RouteRequest(Parcel parcel) {
        this.mStartType = 0;
        this.mRouteSelectRef = 0;
        this.mRoutePreference = -1;
        this.mRequestFrom = 0;
        this.mStartXP = (XPPoiInfo) parcel.readParcelable(XPPoiInfo.class.getClassLoader());
        this.mEndXP = (XPPoiInfo) parcel.readParcelable(XPPoiInfo.class.getClassLoader());
        this.mVias = parcel.createTypedArrayList(XPViaPoint.CREATOR);
        this.mViaIndex = parcel.readInt();
        this.mStartType = parcel.readInt();
        this.mRouteSelectRef = parcel.readInt();
        this.mRoutePreference = parcel.readInt();
        this.mRequestFrom = parcel.readInt();
    }

    public static RouteRequest createNormalRequest(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, List<XPViaPoint> list) {
        return createNormalRequest(xPPoiInfo, xPPoiInfo2, list, 0);
    }

    public static RouteRequest createNormalRequest(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, List<XPViaPoint> list, int i) {
        return createNormalRequest(xPPoiInfo, xPPoiInfo2, list, i, 0);
    }

    public static RouteRequest createNormalRequest(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, List<XPViaPoint> list, int i, int i2) {
        return new Builder(RouteRequestType.ROUTE_REQUEST_NORMAL).setStartXP(xPPoiInfo).setEndXP(xPPoiInfo2).setViasXP(list).setStartType(i).setRouteSelectRef(i2).build();
    }

    public static RouteRequest createRestoreRequest() {
        return new Builder(RouteRequestType.ROUTE_REQUEST_RESTORE).setStartXP(TBTManager.getInstance().getStartPOIFromCurrent()).build();
    }

    public static RouteRequest createUpdateViaRequest(List<XPViaPoint> list, long j) {
        RouteDataModel routeData = TBTManager.getInstance().isExistRoute() ? TBTManager.getInstance().getRouteData(j) : null;
        if (routeData == null) {
            return null;
        }
        return new Builder(RouteRequestType.ROUTE_REQUEST_ADD_VIA).setStartXP(TBTManager.getInstance().getStartPOIFromCurrent()).setEndXP(routeData.mRouteParams.mEndInfo).setViasXP(list).build();
    }

    public static RouteRequest createAddViaRequest(XPPoiInfo xPPoiInfo, long j) {
        RouteDataModel routeData = TBTManager.getInstance().isExistRoute() ? TBTManager.getInstance().getRouteData(j) : null;
        if (routeData == null) {
            return null;
        }
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        XPPoiInfo xPPoiInfo2 = routeData.mRouteParams.mEndInfo;
        List<XPViaPoint> list = routeData.mRouteParams.mViaInfos;
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            arrayList.addAll(list);
        }
        arrayList.add(new XPViaPoint(xPPoiInfo));
        return new Builder(RouteRequestType.ROUTE_REQUEST_ADD_VIA).setStartXP(startPOIFromCurrent).setEndXP(xPPoiInfo2).setViasXP(arrayList).build();
    }

    public static RouteRequest createRemoveViaRequest(int i, long j) {
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(j);
        XPPoiInfo xPPoiInfo = routeData.mRouteParams.mEndInfo;
        List<XPViaPoint> list = routeData.mRouteParams.mViaInfos;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 1 && i < list.size()) {
            arrayList.addAll(list);
            arrayList.remove(i);
        }
        return new Builder(RouteRequestType.ROUTE_REQUEST_REMOVE_VIA).setStartXP(startPOIFromCurrent).setEndXP(xPPoiInfo).setViasXP(arrayList).build();
    }

    public static RouteRequest createRemoveViaRequest(XPPoiInfo xPPoiInfo, long j) {
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(j);
        XPPoiInfo xPPoiInfo2 = routeData.mRouteParams.mEndInfo;
        List<XPViaPoint> list = routeData.mRouteParams.mViaInfos;
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (XPViaPoint xPViaPoint : list) {
                if (!NaviUtil.isSamePOI(xPPoiInfo, xPViaPoint.getPoiPoint())) {
                    arrayList.add(xPViaPoint);
                }
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(">>>createRemoveViaRequest oldVia size= ");
            sb.append(list == null ? 0 : list.size());
            sb.append(" newVia size= ");
            sb.append(arrayList.size());
            sb.append(" remove xpPoiInfo = ");
            sb.append(NaviLogUtil.dumpXPPOIInfo(xPPoiInfo));
            sb.append(" via = ");
            sb.append(arrayList);
            L.d(tag, sb.toString());
        }
        return new Builder(RouteRequestType.ROUTE_REQUEST_REMOVE_VIA).setStartXP(startPOIFromCurrent).setEndXP(xPPoiInfo2).setViasXP(arrayList).build();
    }

    public static RouteRequest createNewDesRequest(XPPoiInfo xPPoiInfo) {
        return createNewDesRequestWithVias(xPPoiInfo, null, -1);
    }

    public static RouteRequest createNewDesRequestWithVias(XPPoiInfo xPPoiInfo, List<XPViaPoint> list, int i) {
        return createNewDesRequestWithVias(null, xPPoiInfo, list, i, 0, 0);
    }

    public static RouteRequest createNewDesRequestWithVias(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, List<XPViaPoint> list, int i, int i2, int i3) {
        if (xPPoiInfo == null) {
            xPPoiInfo = TBTManager.getInstance().getStartPOIFromCurrent();
        }
        return new Builder(RouteRequestType.ROUTE_REQUEST_NEW_DESTINATION).setStartXP(xPPoiInfo).setEndXP(xPPoiInfo2).setViasXP(list).setRoutePreference(i).setStartType(i2).setRouteSelectRef(i3).build();
    }

    public String toString() {
        return "RouteRequest{mStartXP=" + this.mStartXP + ", mEndXP=" + this.mEndXP + ", mRouteRequestType=" + this.mRouteRequestType + ", mVias=" + this.mVias + ", mViaIndex=" + this.mViaIndex + ", mStartType=" + this.mStartType + ", mRouteSelectRef=" + this.mRouteSelectRef + ", mRoutePreference=" + this.mRoutePreference + ", mRequestFrom=" + this.mRequestFrom + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mStartXP, i);
        parcel.writeParcelable(this.mEndXP, i);
        parcel.writeTypedList(this.mVias);
        parcel.writeInt(this.mViaIndex);
        parcel.writeInt(this.mStartType);
        parcel.writeInt(this.mRouteSelectRef);
        parcel.writeInt(this.mRoutePreference);
        parcel.writeInt(this.mRequestFrom);
    }

    public XPPoiInfo getStartXP() {
        return this.mStartXP;
    }

    public XPPoiInfo getEndXP() {
        return this.mEndXP;
    }

    public RouteRequestType getRouteRequestType() {
        return this.mRouteRequestType;
    }

    public List<XPViaPoint> getVias() {
        return this.mVias;
    }

    public int getStartType() {
        return this.mStartType;
    }

    public int getRouteSelectRef() {
        return this.mRouteSelectRef;
    }

    public int getRoutePreference() {
        return this.mRoutePreference;
    }

    public RouteRequest setRoutePreference(int i) {
        this.mRoutePreference = i;
        return this;
    }

    public int getRequestFrom() {
        return this.mRequestFrom;
    }

    public RouteRequest setRequestFrom(int i) {
        this.mRequestFrom = i;
        return this;
    }

    public int getViaIndex() {
        return this.mViaIndex;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(RouteBridge.ROUTE_REQUEST, this);
        return bundle;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private XPPoiInfo mEndXP;
        private int mRequestFrom;
        private int mRoutePreference;
        private RouteRequestType mRouteRequestType;
        private XPPoiInfo mStartXP;
        private int mViaIndex;
        private List<XPViaPoint> mVias = new ArrayList();
        private int mStartType = 0;
        private int mRouteSelectRef = 0;

        public Builder(@NonNull RouteRequestType routeRequestType) {
            this.mRouteRequestType = routeRequestType;
        }

        public Builder setStartXP(XPPoiInfo xPPoiInfo) {
            this.mStartXP = xPPoiInfo;
            return this;
        }

        public Builder setEndXP(XPPoiInfo xPPoiInfo) {
            this.mEndXP = xPPoiInfo;
            return this;
        }

        public Builder setViasXP(List<XPViaPoint> list) {
            if (list != null) {
                this.mVias = list;
            }
            return this;
        }

        public Builder addViaXP(XPViaPoint xPViaPoint) {
            this.mVias.add(xPViaPoint);
            return this;
        }

        public Builder setViaIndex(int i) {
            this.mViaIndex = i;
            return this;
        }

        public Builder setStartType(int i) {
            this.mStartType = i;
            return this;
        }

        public Builder setRouteSelectRef(int i) {
            this.mRouteSelectRef = i;
            return this;
        }

        public Builder setRoutePreference(int i) {
            if (i > 0) {
                this.mRoutePreference = i;
            }
            return this;
        }

        public Builder setRequestFrom(int i) {
            this.mRequestFrom = i;
            return this;
        }

        public RouteRequest build() {
            return new RouteRequest(this);
        }
    }
}
