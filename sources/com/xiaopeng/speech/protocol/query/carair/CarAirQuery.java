package com.xiaopeng.speech.protocol.query.carair;

import com.xiaopeng.speech.SpeechQuery;
import com.xiaopeng.speech.annotation.QueryAnnotation;
import com.xiaopeng.speech.protocol.event.query.QueryCarAirEvent;
/* loaded from: classes3.dex */
public class CarAirQuery extends SpeechQuery<ICarAirCaller> {
    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_AUTO_OFF)
    public boolean isSupportAutoOff(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportAutoOff();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_DEMIST_FOOT)
    public boolean isSupportDemistFoot(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportDemistFoot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_WIND_MAX)
    public int getWindMax(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getWindMax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_WIND_MIN)
    public int getWindMin(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getWindMin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_TEMP_MAX)
    public double getTempMax(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getTempMax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_TEMP_MIN)
    public double getTempMin(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getTempMin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_DECIMAL_VALUE)
    public boolean isSupportDecimalValue(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportDecimalValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_PURIFIER)
    public boolean isSupportPurifier(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportPurifier();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_PM25)
    public boolean isSupportPm25(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportPm25();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_AIR_LEVEL)
    public int getAirLevel(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getAirLevel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_SEAT_HEAT)
    public boolean isSupportSeatHeat(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportSeatHeat();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_PSN_SEAT_HEAT)
    public boolean isSupportPsnSeatHeat(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportPsnSeatHeat();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_HEAT_MAX)
    public int getHeatMax(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getHeatMax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_HEAT_MIN)
    public int getHeatMin(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getHeatMin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_SEAT_BLOW)
    public boolean isSupportSeatBlow(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportSeatBlow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_SEAT_BLOW_MAX)
    public int getSeatBlowMax(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getSeatBlowMax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_SEAT_BLOW_MIN)
    public int getSeatBlowMin(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getSeatBlowMin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_FAST_FRIDGE)
    public boolean isFastFridge(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isFastFridge();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_FRESH_AIR)
    public boolean isFreshAir(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isFreshAir();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_TEMP_DUAL)
    public boolean isSupportTempDual(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportTempDual();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_WINDS_STATUS)
    public int[] getWindsStatus(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getWindsStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_MP_QUERY)
    public int isSupportMpQuery(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportOutSidePm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "ac.wind.mode")
    public int getWindMode(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getCurrWindMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.IS_SUPPORT_MIRROR_HEAT)
    public int isSupportMirrorHeat(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportMirrorHeat();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.OUTSIDE_MP_QUERY)
    public int getOutSidePmQuality(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getOutSidePmQuality();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.DRI_WIND_DIRECTION_MODE)
    public int getDriWindDirectionMode(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getDriWindDirectionMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.PSN_WIND_DIRECTION_MODE)
    public int getPsnWindDirectionMode(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getPsnWindDirectionMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.AC_PANEL_STATUS)
    public int getAcPanelStatus(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getAcPanelStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.OUTSIDE_MP_LEVEL_QUERY)
    public int getPmLevelQuality(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getOutSidePmLevelQuality();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_AC_INTELLIGENT_PASSENGER)
    public int getIntelligentPassengerStatus(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getIntelligentPassengerStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.AC_SUPPORT_REAR_SEAT_HEAT)
    public boolean isSupportRearSeatHeat(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isSupportRearSeatHeat();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_AC_LEFT_REAR_SEAT_HEAT_LV)
    public int getLeftRearSeatHeatLevel(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getLeftRearSeatHeatLevel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.GET_AC_RIGHT_REAR_SEAT_HEAT_LV)
    public int getRightRearSeatHeatLevel(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).getRightRearSeatHeatLevel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryCarAirEvent.AC_IS_SUPPORT_PERFUME)
    public boolean isAcSupportPerfume(String str, String str2) {
        return ((ICarAirCaller) this.mQueryCaller).isAcSupportPerfume();
    }
}
