package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.util.ChargeComparatorUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class CPDeepInfo {
    private static final L.Tag TAG = new L.Tag("CPDeepInfo");
    @SerializedName("busiTime")
    private String busiTime;
    @SerializedName("chargeAmt")
    private float chargeAmt;
    @SerializedName("chargeITemList")
    private List<ChargePrice> chargeItemList;
    @SerializedName("chcRemark")
    private String chcRemark;
    @SerializedName("chrgCnt")
    private int chrgCnt;
    @SerializedName("cityCode")
    private String cityCode;
    @SerializedName("distance")
    private String distance;
    @SerializedName("evaNum")
    private int evaNum;
    @SerializedName("evaScore")
    private float evaScore;
    @SerializedName("dcFreeNums")
    private int fastFreeNums;
    @SerializedName("dcNums")
    private int fastNums;
    @SerializedName("freeNums")
    private int freeNums;
    @SerializedName("gunList")
    private List<ChargeGun> gunList;
    @SerializedName(VuiConstants.ELEMENT_ID)
    private Long id;
    @SerializedName("imgList")
    private List<ChargePic> imgList;
    @SerializedName("incrementItemList")
    private List<ChargeIncrement> incrementItemList;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    private double lat;
    @SerializedName("lineOrder")
    private String lineOrder;
    @SerializedName(CPSearchParam.PARAM_KEY_LON)
    private double lon;
    @SerializedName("operId")
    private String operId;
    @SerializedName("operName")
    private String operName;
    @SerializedName("payment")
    private String payment;
    @SerializedName("selfSupportFlag")
    private byte selfSupportFlag;
    @SerializedName("serviceAmt")
    private float serviceAmt;
    @SerializedName("serviceTel")
    private String serviceTel;
    @SerializedName("acFreeNums")
    private int slowFreeNums;
    @SerializedName("acNums")
    private int slowNums;
    @SerializedName("stationAddr")
    private String stationAddr;
    @SerializedName(CPSearchParam.PARAM_KEY_STATIONID)
    private String stationId;
    @SerializedName("stationName")
    private String stationName;
    @SerializedName("storeFlag")
    private byte storeFlag;

    public CPDeepInfo(Long l, String str, String str2, String str3, String str4, String str5, String str6, byte b, double d, double d2, int i, int i2, int i3, int i4, int i5, String str7, String str8, String str9, String str10, String str11, float f, int i6, String str12, byte b2, float f2, float f3, int i7) {
        this.id = l;
        this.cityCode = str;
        this.stationId = str2;
        this.stationName = str3;
        this.stationAddr = str4;
        this.operId = str5;
        this.operName = str6;
        this.selfSupportFlag = b;
        this.lon = d;
        this.lat = d2;
        this.fastNums = i;
        this.fastFreeNums = i2;
        this.slowNums = i3;
        this.slowFreeNums = i4;
        this.freeNums = i5;
        this.distance = str7;
        this.serviceTel = str8;
        this.busiTime = str9;
        this.payment = str10;
        this.lineOrder = str11;
        this.evaScore = f;
        this.evaNum = i6;
        this.chcRemark = str12;
        this.storeFlag = b2;
        this.serviceAmt = f2;
        this.chargeAmt = f3;
        this.chrgCnt = i7;
    }

    public CPDeepInfo() {
    }

    public static XPPoiInfo toXPPoiInfo(CPDeepInfo cPDeepInfo) {
        if (cPDeepInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setKey(ContextUtils.getString(R.string.search_category_charge));
        xPPoiInfo.setDisplayLon(cPDeepInfo.getLon());
        xPPoiInfo.setDisplayLat(cPDeepInfo.getLat());
        xPPoiInfo.setName(cPDeepInfo.getStationName());
        xPPoiInfo.setAddress(cPDeepInfo.getStationAddr());
        if (cPDeepInfo.getSelfSupportFlag() == 1) {
            xPPoiInfo.setCategory(107);
        } else if (cPDeepInfo.getSelfSupportFlag() == 2) {
            xPPoiInfo.setCategory(116);
        } else if (cPDeepInfo.getSelfSupportFlag() == 3) {
            xPPoiInfo.setCategory(117);
        } else if (cPDeepInfo.getSelfSupportFlag() == 0) {
            xPPoiInfo.setCategory(108);
        }
        xPPoiInfo.setTag(cPDeepInfo.getOperName());
        xPPoiInfo.setPoiId(cPDeepInfo.getStationId());
        xPPoiInfo.setOpenTime(cPDeepInfo.getBusiTime());
        xPPoiInfo.setTel(cPDeepInfo.getServiceTel());
        xPPoiInfo.setOffline(false);
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(cPDeepInfo.getLon(), cPDeepInfo.getLat()), currentLocation));
        }
        String priceString = toPriceString(cPDeepInfo);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "price:" + priceString);
        }
        xPPoiInfo.setPrice(priceString);
        XPDeepCharging[] xPDeepChargingArr = {new XPDeepCharging()};
        xPDeepChargingArr[0].setNumFast(cPDeepInfo.getFastNums());
        if (cPDeepInfo.getFastNums() > 0) {
            xPDeepChargingArr[0].setNumFastFree(cPDeepInfo.getFastFreeNums());
        } else {
            xPDeepChargingArr[0].setNumFastFree(-1);
        }
        xPDeepChargingArr[0].setNumSlow(cPDeepInfo.getSlowNums());
        if (cPDeepInfo.getSlowNums() > 0) {
            xPDeepChargingArr[0].setNumSlowFree(cPDeepInfo.getSlowFreeNums());
        } else {
            xPDeepChargingArr[0].setNumSlowFree(-1);
        }
        xPDeepChargingArr[0].setChargeSrcName(cPDeepInfo.getOperName());
        XPDeepInfoPoi xPDeepInfoPoi = new XPDeepInfoPoi();
        xPDeepInfoPoi.setChargeData(xPDeepChargingArr);
        xPPoiInfo.setXPDeepInfoPoi(xPDeepInfoPoi);
        xPPoiInfo.setPoiSource(3);
        xPPoiInfo.setVisitCount(cPDeepInfo.getChrgCnt());
        xPPoiInfo.setEvaluationCount(cPDeepInfo.getEvaNum());
        if (CollectionUtils.isNotEmpty(cPDeepInfo.getImgList())) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < cPDeepInfo.getImgList().size(); i++) {
                arrayList.add(cPDeepInfo.getImgList().get(i).stationImgUrl);
            }
            xPPoiInfo.setImageUrlList(arrayList);
        }
        return xPPoiInfo;
    }

    public static ArrayList<XPPoiInfo> toXPPoiInfo(List<CPDeepInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList<XPPoiInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(toXPPoiInfo(list.get(i)));
        }
        Collections.sort(arrayList, new ChargeComparatorUtil());
        return arrayList;
    }

    public static String toPriceString(CPDeepInfo cPDeepInfo) {
        if (cPDeepInfo == null) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList();
        int i = 0;
        if (1 == cPDeepInfo.getSelfSupportFlag()) {
            if (CollectionUtils.isNotEmpty(cPDeepInfo.getChargeItemList())) {
                for (int i2 = 0; i2 < cPDeepInfo.getChargeItemList().size(); i2++) {
                    ChargePrice chargePrice = cPDeepInfo.getChargeItemList().get(i2);
                    if (chargePrice != null) {
                        String str = chargePrice.startValue + "-" + chargePrice.endValue + "," + chargePrice.chargePrice + ",";
                        arrayList.add(chargePrice.serviceAmt > 0.0d ? str + chargePrice.serviceAmt : str + cPDeepInfo.getServiceAmt());
                    }
                }
            } else {
                arrayList.add("00:00-24:00," + cPDeepInfo.chargeAmt + "," + cPDeepInfo.serviceAmt);
                if (L.ENABLE) {
                    L.d(TAG, "ID:" + cPDeepInfo.getStationId() + " getChargeItemList is empty");
                }
            }
            if (CollectionUtils.isNotEmpty(cPDeepInfo.getIncrementItemList())) {
                while (i < cPDeepInfo.getIncrementItemList().size()) {
                    ChargeIncrement chargeIncrement = cPDeepInfo.getIncrementItemList().get(i);
                    if (chargeIncrement != null && !TextUtils.isEmpty(chargeIncrement.itemCode) && !TextUtils.isEmpty(chargeIncrement.itemDesc)) {
                        if (chargeIncrement.itemCode.equalsIgnoreCase("1000002002")) {
                            arrayList.add(ContextUtils.getString(R.string.charge_desc_park) + "," + chargeIncrement.itemDesc.replaceAll(",", "，"));
                        } else if (chargeIncrement.itemCode.equalsIgnoreCase("1000003000")) {
                            arrayList.add(ContextUtils.getString(R.string.charge_desc_low_speed) + "," + chargeIncrement.itemDesc.replaceAll(",", "，"));
                        }
                    }
                    i++;
                }
            }
        } else if (CollectionUtils.isNotEmpty(cPDeepInfo.getChargeItemList())) {
            while (i < cPDeepInfo.getChargeItemList().size()) {
                ChargePrice chargePrice2 = cPDeepInfo.getChargeItemList().get(i);
                if (chargePrice2 != null) {
                    String str2 = chargePrice2.startValue + "-" + chargePrice2.endValue + "," + chargePrice2.chargePrice + ",";
                    arrayList.add(chargePrice2.serviceAmt > 0.0d ? str2 + chargePrice2.serviceAmt : str2 + cPDeepInfo.getServiceAmt());
                }
                i++;
            }
        } else {
            arrayList.add("00:00-24:00," + cPDeepInfo.chargeAmt + "," + cPDeepInfo.serviceAmt);
            if (L.ENABLE) {
                L.d(TAG, "ID:" + cPDeepInfo.getStationId() + " getChargeItemList is empty");
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str3 : arrayList) {
            sb.append(str3);
            sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
        }
        return sb.toString();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public String getStationId() {
        return this.stationId;
    }

    public void setStationId(String str) {
        this.stationId = str;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStationName(String str) {
        this.stationName = str;
    }

    public String getStationAddr() {
        return this.stationAddr;
    }

    public void setStationAddr(String str) {
        this.stationAddr = str;
    }

    public String getOperId() {
        return this.operId;
    }

    public void setOperId(String str) {
        this.operId = str;
    }

    public String getOperName() {
        return this.operName;
    }

    public void setOperName(String str) {
        this.operName = str;
    }

    public byte getSelfSupportFlag() {
        return this.selfSupportFlag;
    }

    public void setSelfSupportFlag(byte b) {
        this.selfSupportFlag = b;
    }

    public double getLon() {
        return this.lon;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public int getFastNums() {
        return this.fastNums;
    }

    public void setFastNums(int i) {
        this.fastNums = i;
    }

    public int getFastFreeNums() {
        return this.fastFreeNums;
    }

    public void setFastFreeNums(int i) {
        this.fastFreeNums = i;
    }

    public int getSlowNums() {
        return this.slowNums;
    }

    public void setSlowNums(int i) {
        this.slowNums = i;
    }

    public int getSlowFreeNums() {
        return this.slowFreeNums;
    }

    public void setSlowFreeNums(int i) {
        this.slowFreeNums = i;
    }

    public int getFreeNums() {
        return this.freeNums;
    }

    public void setFreeNums(int i) {
        this.freeNums = i;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public String getServiceTel() {
        return this.serviceTel;
    }

    public void setServiceTel(String str) {
        this.serviceTel = str;
    }

    public String getBusiTime() {
        return this.busiTime;
    }

    public void setBusiTime(String str) {
        this.busiTime = str;
    }

    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String str) {
        this.payment = str;
    }

    public String getLineOrder() {
        return this.lineOrder;
    }

    public void setLineOrder(String str) {
        this.lineOrder = str;
    }

    public float getEvaScore() {
        return this.evaScore;
    }

    public void setEvaScore(float f) {
        this.evaScore = f;
    }

    public int getEvaNum() {
        return this.evaNum;
    }

    public void setEvaNum(int i) {
        this.evaNum = i;
    }

    public String getChcRemark() {
        return this.chcRemark;
    }

    public void setChcRemark(String str) {
        this.chcRemark = str;
    }

    public byte getStoreFlag() {
        return this.storeFlag;
    }

    public void setStoreFlag(byte b) {
        this.storeFlag = b;
    }

    public float getServiceAmt() {
        return this.serviceAmt;
    }

    public void setServiceAmt(float f) {
        this.serviceAmt = f;
    }

    public float getChargeAmt() {
        return this.chargeAmt;
    }

    public void setChargeAmt(float f) {
        this.chargeAmt = f;
    }

    public int getChrgCnt() {
        return this.chrgCnt;
    }

    public void setChrgCnt(int i) {
        this.chrgCnt = i;
    }

    public List<ChargePrice> getChargeItemList() {
        return this.chargeItemList;
    }

    public void setChargeItemList(List<ChargePrice> list) {
        this.chargeItemList = list;
    }

    public List<ChargePic> getImgList() {
        return this.imgList;
    }

    public void setImgList(List<ChargePic> list) {
        this.imgList = list;
    }

    public List<ChargeGun> getGunList() {
        return this.gunList;
    }

    public void setGunList(List<ChargeGun> list) {
        this.gunList = list;
    }

    public List<ChargeIncrement> getIncrementItemList() {
        return this.incrementItemList;
    }

    public void setIncrementItemList(List<ChargeIncrement> list) {
        this.incrementItemList = list;
    }

    /* loaded from: classes3.dex */
    public class ChargePrice {
        @SerializedName("chargePrice")
        public double chargePrice;
        @SerializedName("endValue")
        public String endValue;
        @SerializedName("serviceAmt")
        public double serviceAmt;
        @SerializedName("startValue")
        public String startValue;
        @SerializedName("timeFlag")
        public String timeFlag;

        public ChargePrice() {
        }
    }

    /* loaded from: classes3.dex */
    public class ChargePic {
        @SerializedName("stationImgUrl")
        public String stationImgUrl;

        public ChargePic() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof ChargePic;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ChargePic) {
                ChargePic chargePic = (ChargePic) obj;
                if (chargePic.canEqual(this)) {
                    String stationImgUrl = getStationImgUrl();
                    String stationImgUrl2 = chargePic.getStationImgUrl();
                    return stationImgUrl != null ? stationImgUrl.equals(stationImgUrl2) : stationImgUrl2 == null;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String stationImgUrl = getStationImgUrl();
            return 59 + (stationImgUrl == null ? 43 : stationImgUrl.hashCode());
        }

        public void setStationImgUrl(String str) {
            this.stationImgUrl = str;
        }

        public String toString() {
            return "CPDeepInfo.ChargePic(stationImgUrl=" + getStationImgUrl() + ")";
        }

        public String getStationImgUrl() {
            return this.stationImgUrl;
        }
    }

    /* loaded from: classes3.dex */
    public class ChargeGun {
        @SerializedName("displayGunName")
        public String displayGunName;
        @SerializedName("gunBusiStatus")
        public String gunBusiStatus;
        @SerializedName("gunBusiStatusName")
        public String gunBusiStatusName;
        @SerializedName("gunId")
        public String gunId;
        @SerializedName("gunName")
        public String gunName;
        @SerializedName("gunSubtype")
        public String gunSubtype;
        @SerializedName("pileName")
        public String pileName;
        @SerializedName("pileNo")
        public String pileNo;
        @SerializedName("qrCode")
        public String qrCode;

        public ChargeGun() {
        }
    }

    /* loaded from: classes3.dex */
    public class ChargeIncrement {
        public static final String CODE_PARK_SERVICE1 = "1000002001";
        public static final String CODE_PARK_SERVICE2 = "1000002002";
        public static final String CODE_SERVICE = "1000001000";
        public static final String CODE_SLOW_CHARGE_SERVICE = "1000003000";
        @SerializedName("endValue")
        public String endValue;
        @SerializedName("itemCode")
        public String itemCode;
        @SerializedName("itemDesc")
        public String itemDesc;
        @SerializedName("itemName")
        public String itemName;
        @SerializedName("itemPrice")
        public String itemPrice;
        @SerializedName("itemUnitName")
        public String itemUnitName;
        @SerializedName("startValue")
        public String startValue;

        public ChargeIncrement() {
        }
    }
}
