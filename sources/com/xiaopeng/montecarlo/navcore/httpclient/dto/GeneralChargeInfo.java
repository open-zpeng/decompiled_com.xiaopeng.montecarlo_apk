package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import java.util.List;
/* loaded from: classes2.dex */
public class GeneralChargeInfo implements Comparable<GeneralChargeInfo> {
    @SerializedName("acFreeNums")
    private int mAcFreeNums;
    @SerializedName("acNums")
    private int mAcNums;
    @SerializedName(CPSearchParam.PARAM_KEY_AREACODE)
    private String mAreacode;
    @SerializedName("busiTime")
    private String mBusiTime;
    @SerializedName("canReach")
    private int mCanReach;
    @SerializedName("chargeAmt")
    private double mChargeAmt;
    @SerializedName("chargeITemList")
    private List<ChargePriceInfo> mChargeItemList;
    @SerializedName("chcRemark")
    private String mChcRemark;
    @SerializedName("chrgCnt")
    private int mChrgCnt;
    @SerializedName("citycode")
    private String mCitycode;
    @SerializedName("costDistance")
    private int mCostDistance;
    @SerializedName("dcFreeNums")
    private int mDcFreeNums;
    @SerializedName("dcNums")
    private int mDcNums;
    @SerializedName("distance")
    private int mDistance;
    @SerializedName("evaNum")
    private int mEvaNum;
    @SerializedName("evaScore")
    private int mEvaScore;
    @SerializedName("freeNums")
    private int mFreeNums;
    @SerializedName("gunList")
    private List<ChargeGunInfo> mGunList;
    @SerializedName("imgList")
    private List<ChargePicInfo> mImgList;
    @SerializedName("incrementItemList")
    private List<ChargeIncrementInfo> mIncrementItemList;
    @SerializedName("allXpPile")
    private boolean mIsAllXpPile;
    @SerializedName("freeStation")
    private boolean mIsFreeStation;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    private String mLat;
    @SerializedName("lineOrder")
    private String mLineOrder;
    @SerializedName(CPSearchParam.PARAM_KEY_LON)
    private String mLon;
    @SerializedName("nearbyChrgstaCnt")
    private int mNearbyChrgstaCnt;
    @SerializedName("operId")
    private String mOperId;
    @SerializedName("operName")
    private String mOperName;
    @SerializedName("payment")
    private String mPayment;
    @SerializedName("s4FreeNums")
    private int mS4FreeNums;
    @SerializedName("s4Nums")
    private int mS4Nums;
    @SerializedName("selfSupportFlag")
    private int mSelfSupportFlag;
    @SerializedName("serviceAmt")
    private double mServiceAmt;
    @SerializedName("serviceTel")
    private String mServiceTel;
    @SerializedName("siteGuide")
    private String mSiteGuide;
    @SerializedName("source")
    private int mSource;
    @SerializedName("stationAddr")
    private String mStationAddr;
    @SerializedName(CPSearchParam.PARAM_KEY_STATIONID)
    private String mStationId;
    @SerializedName("stationName")
    private String mStationName;
    @SerializedName("storeFlag")
    private String mStoreFlag;

    protected boolean canEqual(Object obj) {
        return obj instanceof GeneralChargeInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GeneralChargeInfo) {
            GeneralChargeInfo generalChargeInfo = (GeneralChargeInfo) obj;
            if (generalChargeInfo.canEqual(this) && getSelfSupportFlag() == generalChargeInfo.getSelfSupportFlag() && getS4Nums() == generalChargeInfo.getS4Nums() && getS4FreeNums() == generalChargeInfo.getS4FreeNums() && getDcNums() == generalChargeInfo.getDcNums() && getDcFreeNums() == generalChargeInfo.getDcFreeNums() && getAcNums() == generalChargeInfo.getAcNums() && getAcFreeNums() == generalChargeInfo.getAcFreeNums() && getFreeNums() == generalChargeInfo.getFreeNums() && isAllXpPile() == generalChargeInfo.isAllXpPile() && isFreeStation() == generalChargeInfo.isFreeStation() && getEvaScore() == generalChargeInfo.getEvaScore() && getEvaNum() == generalChargeInfo.getEvaNum() && Double.compare(getServiceAmt(), generalChargeInfo.getServiceAmt()) == 0 && Double.compare(getChargeAmt(), generalChargeInfo.getChargeAmt()) == 0 && getChrgCnt() == generalChargeInfo.getChrgCnt() && getNearbyChrgstaCnt() == generalChargeInfo.getNearbyChrgstaCnt() && getDistance() == generalChargeInfo.getDistance() && getCostDistance() == generalChargeInfo.getCostDistance() && getCanReach() == generalChargeInfo.getCanReach() && getSource() == generalChargeInfo.getSource()) {
                String stationId = getStationId();
                String stationId2 = generalChargeInfo.getStationId();
                if (stationId != null ? stationId.equals(stationId2) : stationId2 == null) {
                    String stationName = getStationName();
                    String stationName2 = generalChargeInfo.getStationName();
                    if (stationName != null ? stationName.equals(stationName2) : stationName2 == null) {
                        String stationAddr = getStationAddr();
                        String stationAddr2 = generalChargeInfo.getStationAddr();
                        if (stationAddr != null ? stationAddr.equals(stationAddr2) : stationAddr2 == null) {
                            String lon = getLon();
                            String lon2 = generalChargeInfo.getLon();
                            if (lon != null ? lon.equals(lon2) : lon2 == null) {
                                String lat = getLat();
                                String lat2 = generalChargeInfo.getLat();
                                if (lat != null ? lat.equals(lat2) : lat2 == null) {
                                    String operId = getOperId();
                                    String operId2 = generalChargeInfo.getOperId();
                                    if (operId != null ? operId.equals(operId2) : operId2 == null) {
                                        String operName = getOperName();
                                        String operName2 = generalChargeInfo.getOperName();
                                        if (operName != null ? operName.equals(operName2) : operName2 == null) {
                                            String serviceTel = getServiceTel();
                                            String serviceTel2 = generalChargeInfo.getServiceTel();
                                            if (serviceTel != null ? serviceTel.equals(serviceTel2) : serviceTel2 == null) {
                                                String busiTime = getBusiTime();
                                                String busiTime2 = generalChargeInfo.getBusiTime();
                                                if (busiTime != null ? busiTime.equals(busiTime2) : busiTime2 == null) {
                                                    String payment = getPayment();
                                                    String payment2 = generalChargeInfo.getPayment();
                                                    if (payment != null ? payment.equals(payment2) : payment2 == null) {
                                                        String lineOrder = getLineOrder();
                                                        String lineOrder2 = generalChargeInfo.getLineOrder();
                                                        if (lineOrder != null ? lineOrder.equals(lineOrder2) : lineOrder2 == null) {
                                                            String chcRemark = getChcRemark();
                                                            String chcRemark2 = generalChargeInfo.getChcRemark();
                                                            if (chcRemark != null ? chcRemark.equals(chcRemark2) : chcRemark2 == null) {
                                                                String storeFlag = getStoreFlag();
                                                                String storeFlag2 = generalChargeInfo.getStoreFlag();
                                                                if (storeFlag != null ? storeFlag.equals(storeFlag2) : storeFlag2 == null) {
                                                                    List<ChargePriceInfo> chargeItemList = getChargeItemList();
                                                                    List<ChargePriceInfo> chargeItemList2 = generalChargeInfo.getChargeItemList();
                                                                    if (chargeItemList != null ? chargeItemList.equals(chargeItemList2) : chargeItemList2 == null) {
                                                                        List<ChargePicInfo> imgList = getImgList();
                                                                        List<ChargePicInfo> imgList2 = generalChargeInfo.getImgList();
                                                                        if (imgList != null ? imgList.equals(imgList2) : imgList2 == null) {
                                                                            List<ChargeGunInfo> gunList = getGunList();
                                                                            List<ChargeGunInfo> gunList2 = generalChargeInfo.getGunList();
                                                                            if (gunList != null ? gunList.equals(gunList2) : gunList2 == null) {
                                                                                List<ChargeIncrementInfo> incrementItemList = getIncrementItemList();
                                                                                List<ChargeIncrementInfo> incrementItemList2 = generalChargeInfo.getIncrementItemList();
                                                                                if (incrementItemList != null ? incrementItemList.equals(incrementItemList2) : incrementItemList2 == null) {
                                                                                    String siteGuide = getSiteGuide();
                                                                                    String siteGuide2 = generalChargeInfo.getSiteGuide();
                                                                                    if (siteGuide != null ? siteGuide.equals(siteGuide2) : siteGuide2 == null) {
                                                                                        String citycode = getCitycode();
                                                                                        String citycode2 = generalChargeInfo.getCitycode();
                                                                                        if (citycode != null ? citycode.equals(citycode2) : citycode2 == null) {
                                                                                            String areacode = getAreacode();
                                                                                            String areacode2 = generalChargeInfo.getAreacode();
                                                                                            return areacode != null ? areacode.equals(areacode2) : areacode2 == null;
                                                                                        }
                                                                                        return false;
                                                                                    }
                                                                                    return false;
                                                                                }
                                                                                return false;
                                                                            }
                                                                            return false;
                                                                        }
                                                                        return false;
                                                                    }
                                                                    return false;
                                                                }
                                                                return false;
                                                            }
                                                            return false;
                                                        }
                                                        return false;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int selfSupportFlag = ((((((((((((((((((((((getSelfSupportFlag() + 59) * 59) + getS4Nums()) * 59) + getS4FreeNums()) * 59) + getDcNums()) * 59) + getDcFreeNums()) * 59) + getAcNums()) * 59) + getAcFreeNums()) * 59) + getFreeNums()) * 59) + (isAllXpPile() ? 79 : 97)) * 59) + (isFreeStation() ? 79 : 97)) * 59) + getEvaScore()) * 59) + getEvaNum();
        long doubleToLongBits = Double.doubleToLongBits(getServiceAmt());
        int i = (selfSupportFlag * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(getChargeAmt());
        int chrgCnt = (((((((((((((i * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + getChrgCnt()) * 59) + getNearbyChrgstaCnt()) * 59) + getDistance()) * 59) + getCostDistance()) * 59) + getCanReach()) * 59) + getSource();
        String stationId = getStationId();
        int hashCode = (chrgCnt * 59) + (stationId == null ? 43 : stationId.hashCode());
        String stationName = getStationName();
        int hashCode2 = (hashCode * 59) + (stationName == null ? 43 : stationName.hashCode());
        String stationAddr = getStationAddr();
        int hashCode3 = (hashCode2 * 59) + (stationAddr == null ? 43 : stationAddr.hashCode());
        String lon = getLon();
        int hashCode4 = (hashCode3 * 59) + (lon == null ? 43 : lon.hashCode());
        String lat = getLat();
        int hashCode5 = (hashCode4 * 59) + (lat == null ? 43 : lat.hashCode());
        String operId = getOperId();
        int hashCode6 = (hashCode5 * 59) + (operId == null ? 43 : operId.hashCode());
        String operName = getOperName();
        int hashCode7 = (hashCode6 * 59) + (operName == null ? 43 : operName.hashCode());
        String serviceTel = getServiceTel();
        int hashCode8 = (hashCode7 * 59) + (serviceTel == null ? 43 : serviceTel.hashCode());
        String busiTime = getBusiTime();
        int hashCode9 = (hashCode8 * 59) + (busiTime == null ? 43 : busiTime.hashCode());
        String payment = getPayment();
        int hashCode10 = (hashCode9 * 59) + (payment == null ? 43 : payment.hashCode());
        String lineOrder = getLineOrder();
        int hashCode11 = (hashCode10 * 59) + (lineOrder == null ? 43 : lineOrder.hashCode());
        String chcRemark = getChcRemark();
        int hashCode12 = (hashCode11 * 59) + (chcRemark == null ? 43 : chcRemark.hashCode());
        String storeFlag = getStoreFlag();
        int hashCode13 = (hashCode12 * 59) + (storeFlag == null ? 43 : storeFlag.hashCode());
        List<ChargePriceInfo> chargeItemList = getChargeItemList();
        int hashCode14 = (hashCode13 * 59) + (chargeItemList == null ? 43 : chargeItemList.hashCode());
        List<ChargePicInfo> imgList = getImgList();
        int hashCode15 = (hashCode14 * 59) + (imgList == null ? 43 : imgList.hashCode());
        List<ChargeGunInfo> gunList = getGunList();
        int hashCode16 = (hashCode15 * 59) + (gunList == null ? 43 : gunList.hashCode());
        List<ChargeIncrementInfo> incrementItemList = getIncrementItemList();
        int hashCode17 = (hashCode16 * 59) + (incrementItemList == null ? 43 : incrementItemList.hashCode());
        String siteGuide = getSiteGuide();
        int hashCode18 = (hashCode17 * 59) + (siteGuide == null ? 43 : siteGuide.hashCode());
        String citycode = getCitycode();
        int hashCode19 = (hashCode18 * 59) + (citycode == null ? 43 : citycode.hashCode());
        String areacode = getAreacode();
        return (hashCode19 * 59) + (areacode != null ? areacode.hashCode() : 43);
    }

    public GeneralChargeInfo setAcFreeNums(int i) {
        this.mAcFreeNums = i;
        return this;
    }

    public GeneralChargeInfo setAcNums(int i) {
        this.mAcNums = i;
        return this;
    }

    public GeneralChargeInfo setAllXpPile(boolean z) {
        this.mIsAllXpPile = z;
        return this;
    }

    public GeneralChargeInfo setAreacode(String str) {
        this.mAreacode = str;
        return this;
    }

    public GeneralChargeInfo setBusiTime(String str) {
        this.mBusiTime = str;
        return this;
    }

    public GeneralChargeInfo setCanReach(int i) {
        this.mCanReach = i;
        return this;
    }

    public GeneralChargeInfo setChargeAmt(double d) {
        this.mChargeAmt = d;
        return this;
    }

    public GeneralChargeInfo setChargeItemList(List<ChargePriceInfo> list) {
        this.mChargeItemList = list;
        return this;
    }

    public GeneralChargeInfo setChcRemark(String str) {
        this.mChcRemark = str;
        return this;
    }

    public GeneralChargeInfo setChrgCnt(int i) {
        this.mChrgCnt = i;
        return this;
    }

    public GeneralChargeInfo setCitycode(String str) {
        this.mCitycode = str;
        return this;
    }

    public GeneralChargeInfo setCostDistance(int i) {
        this.mCostDistance = i;
        return this;
    }

    public GeneralChargeInfo setDcFreeNums(int i) {
        this.mDcFreeNums = i;
        return this;
    }

    public GeneralChargeInfo setDcNums(int i) {
        this.mDcNums = i;
        return this;
    }

    public GeneralChargeInfo setDistance(int i) {
        this.mDistance = i;
        return this;
    }

    public GeneralChargeInfo setEvaNum(int i) {
        this.mEvaNum = i;
        return this;
    }

    public GeneralChargeInfo setEvaScore(int i) {
        this.mEvaScore = i;
        return this;
    }

    public GeneralChargeInfo setFreeNums(int i) {
        this.mFreeNums = i;
        return this;
    }

    public GeneralChargeInfo setFreeStation(boolean z) {
        this.mIsFreeStation = z;
        return this;
    }

    public GeneralChargeInfo setGunList(List<ChargeGunInfo> list) {
        this.mGunList = list;
        return this;
    }

    public GeneralChargeInfo setImgList(List<ChargePicInfo> list) {
        this.mImgList = list;
        return this;
    }

    public GeneralChargeInfo setIncrementItemList(List<ChargeIncrementInfo> list) {
        this.mIncrementItemList = list;
        return this;
    }

    public GeneralChargeInfo setLat(String str) {
        this.mLat = str;
        return this;
    }

    public GeneralChargeInfo setLineOrder(String str) {
        this.mLineOrder = str;
        return this;
    }

    public GeneralChargeInfo setLon(String str) {
        this.mLon = str;
        return this;
    }

    public GeneralChargeInfo setNearbyChrgstaCnt(int i) {
        this.mNearbyChrgstaCnt = i;
        return this;
    }

    public GeneralChargeInfo setOperId(String str) {
        this.mOperId = str;
        return this;
    }

    public GeneralChargeInfo setOperName(String str) {
        this.mOperName = str;
        return this;
    }

    public GeneralChargeInfo setPayment(String str) {
        this.mPayment = str;
        return this;
    }

    public GeneralChargeInfo setS4FreeNums(int i) {
        this.mS4FreeNums = i;
        return this;
    }

    public GeneralChargeInfo setS4Nums(int i) {
        this.mS4Nums = i;
        return this;
    }

    public GeneralChargeInfo setSelfSupportFlag(int i) {
        this.mSelfSupportFlag = i;
        return this;
    }

    public GeneralChargeInfo setServiceAmt(double d) {
        this.mServiceAmt = d;
        return this;
    }

    public GeneralChargeInfo setServiceTel(String str) {
        this.mServiceTel = str;
        return this;
    }

    public GeneralChargeInfo setSiteGuide(String str) {
        this.mSiteGuide = str;
        return this;
    }

    public GeneralChargeInfo setSource(int i) {
        this.mSource = i;
        return this;
    }

    public GeneralChargeInfo setStationAddr(String str) {
        this.mStationAddr = str;
        return this;
    }

    public GeneralChargeInfo setStationId(String str) {
        this.mStationId = str;
        return this;
    }

    public GeneralChargeInfo setStationName(String str) {
        this.mStationName = str;
        return this;
    }

    public GeneralChargeInfo setStoreFlag(String str) {
        this.mStoreFlag = str;
        return this;
    }

    public String toString() {
        return "GeneralChargeInfo(mStationId=" + getStationId() + ", mStationName=" + getStationName() + ", mStationAddr=" + getStationAddr() + ", mLon=" + getLon() + ", mLat=" + getLat() + ", mOperId=" + getOperId() + ", mOperName=" + getOperName() + ", mSelfSupportFlag=" + getSelfSupportFlag() + ", mServiceTel=" + getServiceTel() + ", mBusiTime=" + getBusiTime() + ", mPayment=" + getPayment() + ", mLineOrder=" + getLineOrder() + ", mS4Nums=" + getS4Nums() + ", mS4FreeNums=" + getS4FreeNums() + ", mDcNums=" + getDcNums() + ", mDcFreeNums=" + getDcFreeNums() + ", mAcNums=" + getAcNums() + ", mAcFreeNums=" + getAcFreeNums() + ", mFreeNums=" + getFreeNums() + ", mIsAllXpPile=" + isAllXpPile() + ", mIsFreeStation=" + isFreeStation() + ", mEvaScore=" + getEvaScore() + ", mEvaNum=" + getEvaNum() + ", mChcRemark=" + getChcRemark() + ", mServiceAmt=" + getServiceAmt() + ", mChargeAmt=" + getChargeAmt() + ", mStoreFlag=" + getStoreFlag() + ", mChargeItemList=" + getChargeItemList() + ", mImgList=" + getImgList() + ", mGunList=" + getGunList() + ", mIncrementItemList=" + getIncrementItemList() + ", mSiteGuide=" + getSiteGuide() + ", mChrgCnt=" + getChrgCnt() + ", mNearbyChrgstaCnt=" + getNearbyChrgstaCnt() + ", mDistance=" + getDistance() + ", mCostDistance=" + getCostDistance() + ", mCanReach=" + getCanReach() + ", mSource=" + getSource() + ", mCitycode=" + getCitycode() + ", mAreacode=" + getAreacode() + ")";
    }

    public String getStationId() {
        return this.mStationId;
    }

    public String getStationName() {
        return this.mStationName;
    }

    public String getStationAddr() {
        return this.mStationAddr;
    }

    public String getLon() {
        return this.mLon;
    }

    public String getLat() {
        return this.mLat;
    }

    public String getOperId() {
        return this.mOperId;
    }

    public String getOperName() {
        return this.mOperName;
    }

    public int getSelfSupportFlag() {
        return this.mSelfSupportFlag;
    }

    public String getServiceTel() {
        return this.mServiceTel;
    }

    public String getBusiTime() {
        return this.mBusiTime;
    }

    public String getPayment() {
        return this.mPayment;
    }

    public String getLineOrder() {
        return this.mLineOrder;
    }

    public int getS4Nums() {
        return this.mS4Nums;
    }

    public int getS4FreeNums() {
        return this.mS4FreeNums;
    }

    public int getDcNums() {
        return this.mDcNums;
    }

    public int getDcFreeNums() {
        return this.mDcFreeNums;
    }

    public int getAcNums() {
        return this.mAcNums;
    }

    public int getAcFreeNums() {
        return this.mAcFreeNums;
    }

    public int getFreeNums() {
        return this.mFreeNums;
    }

    public boolean isAllXpPile() {
        return this.mIsAllXpPile;
    }

    public boolean isFreeStation() {
        return this.mIsFreeStation;
    }

    public int getEvaScore() {
        return this.mEvaScore;
    }

    public int getEvaNum() {
        return this.mEvaNum;
    }

    public String getChcRemark() {
        return this.mChcRemark;
    }

    public double getServiceAmt() {
        return this.mServiceAmt;
    }

    public double getChargeAmt() {
        return this.mChargeAmt;
    }

    public String getStoreFlag() {
        return this.mStoreFlag;
    }

    public List<ChargePriceInfo> getChargeItemList() {
        return this.mChargeItemList;
    }

    public List<ChargePicInfo> getImgList() {
        return this.mImgList;
    }

    public List<ChargeGunInfo> getGunList() {
        return this.mGunList;
    }

    public List<ChargeIncrementInfo> getIncrementItemList() {
        return this.mIncrementItemList;
    }

    public String getSiteGuide() {
        return this.mSiteGuide;
    }

    public int getChrgCnt() {
        return this.mChrgCnt;
    }

    public int getNearbyChrgstaCnt() {
        return this.mNearbyChrgstaCnt;
    }

    public int getDistance() {
        return this.mDistance;
    }

    public int getCostDistance() {
        return this.mCostDistance;
    }

    public int getCanReach() {
        return this.mCanReach;
    }

    public int getSource() {
        return this.mSource;
    }

    public String getCitycode() {
        return this.mCitycode;
    }

    public String getAreacode() {
        return this.mAreacode;
    }

    @Override // java.lang.Comparable
    public int compareTo(GeneralChargeInfo generalChargeInfo) {
        return Long.compare(getDistance(), generalChargeInfo.getDistance());
    }
}
