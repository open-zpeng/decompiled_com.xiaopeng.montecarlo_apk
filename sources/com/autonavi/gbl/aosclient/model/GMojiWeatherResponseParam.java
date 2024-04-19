package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GMojiWeatherResponseParam extends BLResponseBase implements Serializable {
    public String Temperature = "";
    public String ImageURL = "";
    public String AqiQualityLevel = "";
    public int WeatherIconNum = 0;
    public String WeatherCondition = "";
    public String Humidity = "";
    public String UpdateTime = "";
    public String PM25 = "";
    public String PM10 = "";
    public String TrafficRestrictPlateNO = "";
    public String TrafficRestrictInfo = "";
    public int TrafficRestrictCityFlag = 0;
    public String CarWashingDecs = "";
    public String CarWashingCode = "";
    public String ThemeColor = "";
    public int ThemeIconIndex = 0;
    public String LocalInfoProvince = "";
    public String LocalInfoCity = "";
    public String LocalInfoDistrict = "";
    public String LocalInfoAdcode = "";
    public ArrayList<GMojiWeatherForecast> LstForecast = new ArrayList<>();
}
