package com.autonavi.gbl.route.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.route.model.WeatherType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class WeatherLabelItem implements Serializable {
    public int mCityID;
    public String mCityName;
    public long mDistance;
    public long mEta;
    public BigInteger mLinkId;
    public long mPathID;
    public Coord3DDouble mPosition;
    public int mRank;
    public String mText;
    public long mTimestamp;
    public int mWeatherID;
    public String mWeatherName;
    @WeatherType.WeatherType1
    public int mWeatherType;

    public WeatherLabelItem() {
        this.mPosition = new Coord3DDouble();
        this.mWeatherType = 0;
        this.mPathID = 0L;
        this.mWeatherID = 0;
        this.mCityID = 0;
        this.mTimestamp = 0L;
        this.mCityName = "";
        this.mWeatherName = "";
        this.mText = "";
        this.mRank = 0;
        this.mLinkId = new BigInteger("0");
        this.mDistance = 0L;
        this.mEta = 0L;
    }

    public WeatherLabelItem(Coord3DDouble coord3DDouble, @WeatherType.WeatherType1 int i, long j, int i2, int i3, long j2, String str, String str2, String str3, int i4, BigInteger bigInteger, long j3, long j4) {
        this.mPosition = coord3DDouble;
        this.mWeatherType = i;
        this.mPathID = j;
        this.mWeatherID = i2;
        this.mCityID = i3;
        this.mTimestamp = j2;
        this.mCityName = str;
        this.mWeatherName = str2;
        this.mText = str3;
        this.mRank = i4;
        this.mLinkId = bigInteger;
        this.mDistance = j3;
        this.mEta = j4;
    }
}
