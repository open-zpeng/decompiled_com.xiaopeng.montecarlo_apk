package com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import java.util.List;
/* loaded from: classes3.dex */
public class CruiseReturnData extends BaseResultData implements Parcelable {
    public static final Parcelable.Creator<CruiseReturnData> CREATOR = new Parcelable.Creator<CruiseReturnData>() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseReturnData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CruiseReturnData createFromParcel(Parcel parcel) {
            return new CruiseReturnData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CruiseReturnData[] newArray(int i) {
            return new CruiseReturnData[i];
        }
    };
    private CommutingForecastResult mCommutingForecastResult;
    protected int mCruisType;
    private CruiseDistanceResult mCruiseDistanceResult;
    private GeneralChargeRequestParam mGeneralChargeRequestParam;
    private List<XPPoiInfo> mList;
    private int mRadius;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CruiseReturnData() {
    }

    protected CruiseReturnData(Parcel parcel) {
        super(parcel);
        this.mCruisType = parcel.readInt();
        this.mCruiseDistanceResult = (CruiseDistanceResult) parcel.readParcelable(CruiseDistanceResult.class.getClassLoader());
        this.mCommutingForecastResult = (CommutingForecastResult) parcel.readParcelable(CommutingForecastResult.class.getClassLoader());
        this.mGeneralChargeRequestParam = (GeneralChargeRequestParam) parcel.readParcelable(GeneralChargeRequestParam.class.getClassLoader());
        parcel.readTypedList(this.mList, XPPoiInfo.CREATOR);
        this.mRadius = parcel.readInt();
    }

    public void setGeneralChargeRequestParam(GeneralChargeRequestParam generalChargeRequestParam) {
        this.mGeneralChargeRequestParam = generalChargeRequestParam;
    }

    public GeneralChargeRequestParam getGeneralChargeRequestParam() {
        return this.mGeneralChargeRequestParam;
    }

    public CommutingForecastResult getCommutingForecastResult() {
        return this.mCommutingForecastResult;
    }

    public void setCommutingForecastResult(CommutingForecastResult commutingForecastResult) {
        this.mCommutingForecastResult = commutingForecastResult;
    }

    public CruiseDistanceResult getCruiseDistanceResult() {
        return this.mCruiseDistanceResult;
    }

    public void setCruiseDistanceResult(CruiseDistanceResult cruiseDistanceResult) {
        this.mCruiseDistanceResult = cruiseDistanceResult;
    }

    public int getCruisType() {
        return this.mCruisType;
    }

    public void setCruisType(int i) {
        this.mCruisType = i;
    }

    public List<XPPoiInfo> getList() {
        return this.mList;
    }

    public void setList(List<XPPoiInfo> list) {
        this.mList = list;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mCruisType);
        parcel.writeParcelable(this.mCruiseDistanceResult, i);
        parcel.writeParcelable(this.mCommutingForecastResult, i);
        parcel.writeParcelable(this.mGeneralChargeRequestParam, i);
        parcel.writeList(this.mList);
        parcel.writeInt(this.mRadius);
    }
}
