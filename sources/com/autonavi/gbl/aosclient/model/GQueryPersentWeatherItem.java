package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQueryPersentWeatherItem implements Serializable {
    public GQueryPersentWeatherItemAlert alert;
    public GQueryPersentWeatherItemAqi aqi;
    public GQueryPersentWeatherItemBaseInfo baseInfo;
    public GQueryPersentWeatherItemCarWashing carWashing;
    public GQueryPersentWeatherItemInfluenceShape influenceShape;

    public GQueryPersentWeatherItem() {
        this.alert = new GQueryPersentWeatherItemAlert();
        this.aqi = new GQueryPersentWeatherItemAqi();
        this.baseInfo = new GQueryPersentWeatherItemBaseInfo();
        this.carWashing = new GQueryPersentWeatherItemCarWashing();
        this.influenceShape = new GQueryPersentWeatherItemInfluenceShape();
    }

    public GQueryPersentWeatherItem(GQueryPersentWeatherItemAlert gQueryPersentWeatherItemAlert, GQueryPersentWeatherItemAqi gQueryPersentWeatherItemAqi, GQueryPersentWeatherItemBaseInfo gQueryPersentWeatherItemBaseInfo, GQueryPersentWeatherItemCarWashing gQueryPersentWeatherItemCarWashing, GQueryPersentWeatherItemInfluenceShape gQueryPersentWeatherItemInfluenceShape) {
        this.alert = gQueryPersentWeatherItemAlert;
        this.aqi = gQueryPersentWeatherItemAqi;
        this.baseInfo = gQueryPersentWeatherItemBaseInfo;
        this.carWashing = gQueryPersentWeatherItemCarWashing;
        this.influenceShape = gQueryPersentWeatherItemInfluenceShape;
    }
}
