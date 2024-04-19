package com.xiaopeng.montecarlo.navcore.parking;

import android.text.TextUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPNaviServerPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.XPNaviServerPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PoiConvert {
    public static XPNaviServerPoiInfo toNaviServerPoi(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return null;
        }
        XPNaviServerPoiInfo xPNaviServerPoiInfo = new XPNaviServerPoiInfo();
        xPNaviServerPoiInfo.setName(xPPoiInfo.getName()).setAddress(xPPoiInfo.getAddress()).setLocation(new XPNaviServerPoint(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat())).setNaviLocation(new XPNaviServerPoint(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat())).setId(xPPoiInfo.getPoiId()).setCity(xPPoiInfo.getCityName()).setSubCity(xPPoiInfo.getDistrictName()).setCategory(xPPoiInfo.getBlCategory()).setCityCode(xPPoiInfo.getCityCode()).setProvince(xPPoiInfo.getProvinceName());
        return xPNaviServerPoiInfo;
    }

    public static List<XPPoiInfo> toXpPoiInfoList(List<XPNaviServerPoiInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isEmpty(list)) {
            return arrayList;
        }
        for (XPNaviServerPoiInfo xPNaviServerPoiInfo : list) {
            XPPoiInfo xPPoiInfo = new XPPoiInfo();
            if (xPNaviServerPoiInfo != null) {
                xPPoiInfo.setPoiId(xPNaviServerPoiInfo.getId());
                if (TextUtils.isEmpty(xPNaviServerPoiInfo.getAddress())) {
                    xPPoiInfo.setAddress(xPNaviServerPoiInfo.getProvince() + xPNaviServerPoiInfo.getCity() + xPNaviServerPoiInfo.getSubCity());
                } else {
                    xPPoiInfo.setAddress(xPNaviServerPoiInfo.getAddress());
                }
                xPPoiInfo.setName(xPNaviServerPoiInfo.getName());
                if (xPNaviServerPoiInfo.getLocation() != null) {
                    xPPoiInfo.setDisplayLat(xPNaviServerPoiInfo.getLocation().getLat());
                    xPPoiInfo.setDisplayLon(xPNaviServerPoiInfo.getLocation().getLon());
                }
                if (xPNaviServerPoiInfo.getNaviLocation() != null) {
                    xPPoiInfo.setEnter(new Coord2DDouble(xPNaviServerPoiInfo.getNaviLocation().getLon(), xPNaviServerPoiInfo.getNaviLocation().getLat()));
                }
                if (xPNaviServerPoiInfo.getParkInfoBean() != null) {
                    xPPoiInfo.setTag(xPNaviServerPoiInfo.getParkInfoBean().getTag());
                    int parkTotal = xPNaviServerPoiInfo.getParkInfoBean().getParkTotal();
                    int parkRemain = xPNaviServerPoiInfo.getParkInfoBean().getParkRemain();
                    if (parkTotal == 0 && parkRemain == 0) {
                        parkTotal = -1;
                        parkRemain = -1;
                    }
                    xPPoiInfo.setParkTotal(parkTotal);
                    xPPoiInfo.setParkRemain(parkRemain);
                    xPPoiInfo.setDistance(xPNaviServerPoiInfo.getParkInfoBean().getWalkingDistance());
                    xPPoiInfo.setPrice(xPNaviServerPoiInfo.getParkInfoBean().getPrice());
                }
            }
            arrayList.add(xPPoiInfo);
        }
        return arrayList;
    }
}
