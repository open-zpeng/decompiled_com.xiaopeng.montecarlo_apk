package com.xiaopeng.montecarlo.navcore.httpclient.convert;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCarServiceInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.ChargeIncrementInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.ChargePicInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.ChargePriceInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.ChargeSearchByOneResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviDetailSearchResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviQueryResponse;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
/* loaded from: classes2.dex */
public class HttpResponseConverter {
    private static final int CHARGE_WEIGHTS_FAST_FREE = 64;
    private static final int CHARGE_WEIGHTS_FAST_FULL = 48;
    private static final int CHARGE_WEIGHTS_SLOW_FREE = 32;
    private static final int CHARGE_WEIGHTS_SLOW_FULL = 16;
    private static final int CHARGE_WEIGHTS_XP_FREE = 80;
    private static final int CHARGE_WEIGHTS_XP_FULL = 48;
    private static final L.Tag TAG = new L.Tag("HttpResponseConverter");

    public static List<XPPoiInfo> fetchXPPoiInfoListFromNaviDetailSearchResponse(NaviDetailSearchResponse naviDetailSearchResponse) {
        ArrayList arrayList = new ArrayList();
        if (naviDetailSearchResponse == null) {
            return arrayList;
        }
        List<NaviPoiInfo> data = naviDetailSearchResponse.getData();
        if (CollectionUtils.isEmpty(data)) {
            return arrayList;
        }
        for (NaviPoiInfo naviPoiInfo : data) {
            arrayList.add(naviPoiInfo2XPPoiInfo(naviPoiInfo));
        }
        return arrayList;
    }

    public static List<XPPoiInfo> fetchXPPoiInfoListFromSearchByOneResponse(ChargeSearchByOneResponse chargeSearchByOneResponse) {
        ArrayList arrayList = new ArrayList();
        if (chargeSearchByOneResponse == null) {
            return arrayList;
        }
        List<GeneralChargeInfo> list = chargeSearchByOneResponse.getList();
        if (CollectionUtils.isEmpty(list)) {
            return arrayList;
        }
        for (GeneralChargeInfo generalChargeInfo : list) {
            arrayList.add(generalChargeInfo2XPPoiInfo(generalChargeInfo));
        }
        sortByChargeWeight(arrayList);
        return arrayList;
    }

    public static List<XPPoiInfo> fetchXPPoiInfoListFromNaviQueryResponse(NaviQueryResponse naviQueryResponse) {
        ArrayList arrayList = new ArrayList();
        if (naviQueryResponse == null) {
            return arrayList;
        }
        List<NaviPoiInfo> pois = naviQueryResponse.getPois();
        if (CollectionUtils.isEmpty(pois)) {
            return arrayList;
        }
        for (NaviPoiInfo naviPoiInfo : pois) {
            arrayList.add(naviPoiInfo2XPPoiInfo(naviPoiInfo));
        }
        return arrayList;
    }

    public static XPPoiInfo naviPoiInfo2XPPoiInfo(NaviPoiInfo naviPoiInfo) {
        if (naviPoiInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setPoiId(naviPoiInfo.getId());
        xPPoiInfo.setName(naviPoiInfo.getName());
        xPPoiInfo.setAddress(naviPoiInfo.getAddress());
        xPPoiInfo.setProvinceName(naviPoiInfo.getProvince());
        xPPoiInfo.setCityName(naviPoiInfo.getCity());
        xPPoiInfo.setDistrictName(naviPoiInfo.getSubCity());
        xPPoiInfo.setCityCode(naviPoiInfo.getCityCode());
        xPPoiInfo.setTag(naviPoiInfo.getBrandName());
        xPPoiInfo.setOpenTime(naviPoiInfo.getBusiTime());
        xPPoiInfo.setTel(naviPoiInfo.getPhone());
        xPPoiInfo.setImageUrlList(naviPoiInfo.getImgs());
        if (naviPoiInfo.getLocation() != null) {
            xPPoiInfo.setDisplayLon(naviPoiInfo.getLocation().getLon().doubleValue());
            xPPoiInfo.setDisplayLat(naviPoiInfo.getLocation().getLat().doubleValue());
            XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
            if (currentLocation != null) {
                xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(naviPoiInfo.getLocation().getLon().doubleValue(), naviPoiInfo.getLocation().getLat().doubleValue()), currentLocation));
            }
        }
        if (naviPoiInfo.getLocation() != null) {
            xPPoiInfo.setNaviLon(naviPoiInfo.getLocation().getLon().doubleValue());
            xPPoiInfo.setNaviLat(naviPoiInfo.getLocation().getLat().doubleValue());
        }
        if (naviPoiInfo.getPrice() != null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(naviPoiInfo.getPrice().getDescription())) {
                sb.append(naviPoiInfo.getPrice().getDescription());
            }
            if (CollectionUtils.isNotEmpty(naviPoiInfo.getPrice().getPriceDetails())) {
                for (NaviPoiInfo.Price.PriceDetail priceDetail : naviPoiInfo.getPrice().getPriceDetails()) {
                    if (priceDetail != null) {
                        if (!TextUtils.isEmpty(priceDetail.getDescription())) {
                            sb.append(priceDetail.getDescription());
                        }
                        if (!TextUtils.isEmpty(priceDetail.getPrice())) {
                            sb.append(priceDetail.getPrice());
                        }
                    }
                }
            }
            xPPoiInfo.setPrice(sb.toString());
        }
        if ("1".equalsIgnoreCase(naviPoiInfo.getSource())) {
            xPPoiInfo.setPoiSource(1);
        } else if ("3".equalsIgnoreCase(naviPoiInfo.getSource())) {
            xPPoiInfo.setPoiSource(3);
        } else if ("7".equalsIgnoreCase(naviPoiInfo.getSource())) {
            xPPoiInfo.setPoiSource(7);
        } else if (BLParams.AOS_ROUTE_TYPE_NO_FREEWAY.equalsIgnoreCase(naviPoiInfo.getSource())) {
            xPPoiInfo.setPoiSource(9);
        } else if ("9".equalsIgnoreCase(naviPoiInfo.getSource())) {
            xPPoiInfo.setPoiSource(10);
        }
        if (!TextUtils.isEmpty(naviPoiInfo.getCategory())) {
            String category = naviPoiInfo.getCategory();
            if (category.contains(XPNaviSearchParam.PARAM_CATEGORY_VALUE_CHARGE)) {
                xPPoiInfo.setCategory(108);
            } else if (category.contains("010500")) {
                xPPoiInfo.setCategory(111);
            } else if (category.contains(XPNaviSearchParam.PARAM_CATEGORY_VALUE_FOOD)) {
                xPPoiInfo.setCategory(115);
            } else if (category.contains(XPNaviSearchParam.CATEGORY_INTEGRATED_SERVER_CENTER) || category.contains(XPNaviSearchParam.CATEGORY_EXPERIENCE_CENTER) || category.contains(XPNaviSearchParam.CATEGORY_DELIVERY_CENTER) || category.contains(XPNaviSearchParam.CATEGORY_SERVER_CENTER)) {
                xPPoiInfo.setCategory(118);
            }
        }
        NaviPoiInfo.ShopInfo shopInfo = naviPoiInfo.getShopInfo();
        if (shopInfo != null) {
            xPPoiInfo.setTag(shopInfo.getTag());
            xPPoiInfo.setPrice(shopInfo.getCost());
            String rating = shopInfo.getRating();
            if (!TextUtils.isEmpty(rating)) {
                xPPoiInfo.setRating(Float.parseFloat(rating));
            }
        }
        if (naviPoiInfo.getCarService() != null) {
            NaviPoiInfo.CarService carService = naviPoiInfo.getCarService();
            XPCarServiceInfo xPCarServiceInfo = new XPCarServiceInfo();
            xPCarServiceInfo.setAutoId(naviPoiInfo.getAutoId());
            xPCarServiceInfo.setChargeable(carService.isChargeable());
            xPCarServiceInfo.setVisible(carService.isVisible());
            xPCarServiceInfo.setStatus(carService.getStatus());
            xPCarServiceInfo.setType(carService.getType());
            if (!TextUtils.isEmpty(naviPoiInfo.getCategory())) {
                String category2 = naviPoiInfo.getCategory();
                if (category2.contains(XPNaviSearchParam.CATEGORY_EXPERIENCE_CENTER)) {
                    xPCarServiceInfo.setExpCenter(true);
                }
                if (category2.contains(XPNaviSearchParam.CATEGORY_DELIVERY_CENTER)) {
                    xPCarServiceInfo.setDelCenter(true);
                }
                if (category2.contains(XPNaviSearchParam.CATEGORY_SERVER_CENTER)) {
                    xPCarServiceInfo.setSerCenter(true);
                }
            }
            xPPoiInfo.setXPCarServiceInfo(xPCarServiceInfo);
        }
        xPPoiInfo.setOffline(false);
        return xPPoiInfo;
    }

    public static XPPoiInfo generalChargeInfo2XPPoiInfo(GeneralChargeInfo generalChargeInfo) {
        if (generalChargeInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setKey(ContextUtils.getString(R.string.search_category_charge));
        xPPoiInfo.setPoiId(generalChargeInfo.getStationId());
        xPPoiInfo.setName(generalChargeInfo.getStationName());
        xPPoiInfo.setAddress(generalChargeInfo.getStationAddr());
        try {
            double parseDouble = Double.parseDouble(generalChargeInfo.getLon());
            double parseDouble2 = Double.parseDouble(generalChargeInfo.getLat());
            xPPoiInfo.setDisplayLon(parseDouble);
            xPPoiInfo.setDisplayLat(parseDouble2);
            xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(parseDouble, parseDouble2), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation()));
        } catch (Exception unused) {
            L.w(TAG, "parse error");
        }
        if (generalChargeInfo.getSelfSupportFlag() == 1) {
            xPPoiInfo.setCategory(107);
        } else if (generalChargeInfo.getSelfSupportFlag() == 2) {
            xPPoiInfo.setCategory(116);
        } else if (generalChargeInfo.getSelfSupportFlag() == 3) {
            xPPoiInfo.setCategory(117);
        } else if (generalChargeInfo.getSelfSupportFlag() == 0) {
            xPPoiInfo.setCategory(108);
        }
        xPPoiInfo.setTag(generalChargeInfo.getOperName());
        xPPoiInfo.setOpenTime(generalChargeInfo.getBusiTime());
        xPPoiInfo.setTel(generalChargeInfo.getServiceTel());
        xPPoiInfo.setOffline(false);
        xPPoiInfo.setPrice(toPriceString(generalChargeInfo));
        XPDeepCharging[] xPDeepChargingArr = {new XPDeepCharging()};
        xPDeepChargingArr[0].setNumFast(generalChargeInfo.getDcNums());
        if (generalChargeInfo.getDcNums() > 0) {
            xPDeepChargingArr[0].setNumFastFree(generalChargeInfo.getDcFreeNums());
        } else {
            xPDeepChargingArr[0].setNumFastFree(-1);
        }
        xPDeepChargingArr[0].setNumSlow(generalChargeInfo.getAcNums());
        if (generalChargeInfo.getAcNums() > 0) {
            xPDeepChargingArr[0].setNumSlowFree(generalChargeInfo.getAcFreeNums());
        } else {
            xPDeepChargingArr[0].setNumSlowFree(-1);
        }
        xPDeepChargingArr[0].setChargeSrcName(generalChargeInfo.getOperName());
        xPDeepChargingArr[0].setFreeStation(generalChargeInfo.isFreeStation());
        xPDeepChargingArr[0].setAllXpPile(generalChargeInfo.isAllXpPile());
        XPDeepInfoPoi xPDeepInfoPoi = new XPDeepInfoPoi();
        xPDeepInfoPoi.setChargeData(xPDeepChargingArr);
        xPPoiInfo.setXPDeepInfoPoi(xPDeepInfoPoi);
        xPPoiInfo.setPoiSource(3);
        xPPoiInfo.setVisitCount(generalChargeInfo.getChrgCnt());
        xPPoiInfo.setEvaluationCount(generalChargeInfo.getEvaNum());
        if (CollectionUtils.isNotEmpty(generalChargeInfo.getImgList())) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < generalChargeInfo.getImgList().size(); i++) {
                ChargePicInfo chargePicInfo = generalChargeInfo.getImgList().get(i);
                if (chargePicInfo != null) {
                    arrayList.add(chargePicInfo.getStationImgUrl());
                }
            }
            xPPoiInfo.setImageUrlList(arrayList);
        }
        return xPPoiInfo;
    }

    public static void sortByChargeWeight(List<XPPoiInfo> list) {
        Collections.sort(list, new Comparator<XPPoiInfo>() { // from class: com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter.1
            @Override // java.util.Comparator
            public int compare(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
                int sortWeight = HttpResponseConverter.getSortWeight(xPPoiInfo);
                int sortWeight2 = HttpResponseConverter.getSortWeight(xPPoiInfo2);
                if (sortWeight > sortWeight2) {
                    return -1;
                }
                if (sortWeight >= sortWeight2 && xPPoiInfo.getDistance() <= xPPoiInfo2.getDistance()) {
                    return xPPoiInfo.getDistance() < xPPoiInfo2.getDistance() ? -1 : 0;
                }
                return 1;
            }
        });
    }

    public static int getSortWeight(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return -1;
        }
        boolean z = true;
        boolean z2 = 107 == xPPoiInfo.getCategory();
        XPDeepCharging xPDeepCharging = (XPDeepCharging) Optional.ofNullable(xPPoiInfo).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.httpclient.convert.-$$Lambda$keL39oucN_Rjy4R361GtJ6_g2Go
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((XPPoiInfo) obj).getXPDeepInfoPoi();
            }
        }).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.httpclient.convert.-$$Lambda$FtjFyCh3jC3CGvdCU1dCI0T1CKc
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((XPDeepInfoPoi) obj).getChargeData();
            }
        }).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.httpclient.convert.-$$Lambda$HttpResponseConverter$koN_JBoNdfaaopU_mrTyuQMkFEQ
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return HttpResponseConverter.lambda$getSortWeight$0((XPDeepCharging[]) obj);
            }
        }).orElse(null);
        if (xPDeepCharging == null) {
            return -1;
        }
        boolean z3 = xPDeepCharging.getNumFast() > 0;
        if (!z3 ? xPDeepCharging.getNumSlowFree() > 0 : xPDeepCharging.getNumFastFree() > 0) {
            z = false;
        }
        return z2 ? z ? 48 : 80 : z3 ? z ? 48 : 64 : z ? 16 : 32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ XPDeepCharging lambda$getSortWeight$0(XPDeepCharging[] xPDeepChargingArr) {
        return xPDeepChargingArr[0];
    }

    public static String toPriceString(GeneralChargeInfo generalChargeInfo) {
        if (generalChargeInfo == null) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList();
        int i = 0;
        if (1 == generalChargeInfo.getSelfSupportFlag() || 2 == generalChargeInfo.getSelfSupportFlag() || 3 == generalChargeInfo.getSelfSupportFlag()) {
            if (CollectionUtils.isNotEmpty(generalChargeInfo.getChargeItemList())) {
                for (int i2 = 0; i2 < generalChargeInfo.getChargeItemList().size(); i2++) {
                    ChargePriceInfo chargePriceInfo = generalChargeInfo.getChargeItemList().get(i2);
                    if (chargePriceInfo != null) {
                        String str = chargePriceInfo.getStartValue() + "-" + chargePriceInfo.getEndValue() + "," + chargePriceInfo.getChargePrice() + ",";
                        arrayList.add(chargePriceInfo.getServiceAmt() > 0.0d ? str + chargePriceInfo.getServiceAmt() : str + generalChargeInfo.getServiceAmt());
                    }
                }
            } else {
                arrayList.add("00:00-24:00," + generalChargeInfo.getChargeAmt() + "," + generalChargeInfo.getServiceAmt());
                if (L.ENABLE) {
                    L.d(TAG, "ID:" + generalChargeInfo.getStationId() + " getChargeItemList is empty");
                }
            }
            if (CollectionUtils.isNotEmpty(generalChargeInfo.getIncrementItemList())) {
                while (i < generalChargeInfo.getIncrementItemList().size()) {
                    ChargeIncrementInfo chargeIncrementInfo = generalChargeInfo.getIncrementItemList().get(i);
                    if (chargeIncrementInfo != null && !TextUtils.isEmpty(chargeIncrementInfo.getItemCode()) && !TextUtils.isEmpty(chargeIncrementInfo.getItemDesc())) {
                        if (chargeIncrementInfo.getItemCode().equalsIgnoreCase("1000002002")) {
                            arrayList.add(ContextUtils.getString(R.string.charge_desc_park) + "," + chargeIncrementInfo.getItemDesc().replaceAll(",", "，"));
                        } else if (chargeIncrementInfo.getItemCode().equalsIgnoreCase("1000003000")) {
                            arrayList.add(ContextUtils.getString(R.string.charge_desc_low_speed) + "," + chargeIncrementInfo.getItemDesc().replaceAll(",", "，"));
                        }
                    }
                    i++;
                }
            }
        } else if (CollectionUtils.isNotEmpty(generalChargeInfo.getChargeItemList())) {
            while (i < generalChargeInfo.getChargeItemList().size()) {
                ChargePriceInfo chargePriceInfo2 = generalChargeInfo.getChargeItemList().get(i);
                if (chargePriceInfo2 != null) {
                    String str2 = chargePriceInfo2.getStartValue() + "-" + chargePriceInfo2.getEndValue() + "," + chargePriceInfo2.getChargePrice() + ",";
                    arrayList.add(chargePriceInfo2.getServiceAmt() > 0.0d ? str2 + chargePriceInfo2.getServiceAmt() : str2 + generalChargeInfo.getServiceAmt());
                }
                i++;
            }
        } else {
            arrayList.add("00:00-24:00," + generalChargeInfo.getChargeAmt() + "," + generalChargeInfo.getServiceAmt());
            if (L.ENABLE) {
                L.d(TAG, "ID:" + generalChargeInfo.getStationId() + " getChargeItemList is empty");
            }
        }
        StringBuilder sb = new StringBuilder();
        try {
            for (String str3 : arrayList) {
                sb.append(str3);
                sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
            }
        } catch (Exception e) {
            L.w(TAG, "Error : " + e.getMessage());
        }
        return sb.toString();
    }
}
