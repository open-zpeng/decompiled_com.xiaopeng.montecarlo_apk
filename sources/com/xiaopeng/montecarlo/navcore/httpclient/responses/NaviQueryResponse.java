package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviPoiInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class NaviQueryResponse {
    @SerializedName("current")
    private Integer mCurrent;
    @SerializedName("pages")
    private Integer mPages;
    @SerializedName("pois")
    private List<NaviPoiInfo> mPois;
    @SerializedName("size")
    private Integer mSize;
    @SerializedName("total")
    private Integer mTotal;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviQueryResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviQueryResponse) {
            NaviQueryResponse naviQueryResponse = (NaviQueryResponse) obj;
            if (naviQueryResponse.canEqual(this)) {
                Integer total = getTotal();
                Integer total2 = naviQueryResponse.getTotal();
                if (total != null ? total.equals(total2) : total2 == null) {
                    Integer size = getSize();
                    Integer size2 = naviQueryResponse.getSize();
                    if (size != null ? size.equals(size2) : size2 == null) {
                        Integer pages = getPages();
                        Integer pages2 = naviQueryResponse.getPages();
                        if (pages != null ? pages.equals(pages2) : pages2 == null) {
                            Integer current = getCurrent();
                            Integer current2 = naviQueryResponse.getCurrent();
                            if (current != null ? current.equals(current2) : current2 == null) {
                                List<NaviPoiInfo> pois = getPois();
                                List<NaviPoiInfo> pois2 = naviQueryResponse.getPois();
                                return pois != null ? pois.equals(pois2) : pois2 == null;
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
        Integer total = getTotal();
        int hashCode = total == null ? 43 : total.hashCode();
        Integer size = getSize();
        int hashCode2 = ((hashCode + 59) * 59) + (size == null ? 43 : size.hashCode());
        Integer pages = getPages();
        int hashCode3 = (hashCode2 * 59) + (pages == null ? 43 : pages.hashCode());
        Integer current = getCurrent();
        int hashCode4 = (hashCode3 * 59) + (current == null ? 43 : current.hashCode());
        List<NaviPoiInfo> pois = getPois();
        return (hashCode4 * 59) + (pois != null ? pois.hashCode() : 43);
    }

    public NaviQueryResponse setCurrent(Integer num) {
        this.mCurrent = num;
        return this;
    }

    public NaviQueryResponse setPages(Integer num) {
        this.mPages = num;
        return this;
    }

    public NaviQueryResponse setPois(List<NaviPoiInfo> list) {
        this.mPois = list;
        return this;
    }

    public NaviQueryResponse setSize(Integer num) {
        this.mSize = num;
        return this;
    }

    public NaviQueryResponse setTotal(Integer num) {
        this.mTotal = num;
        return this;
    }

    public String toString() {
        return "NaviQueryResponse(mTotal=" + getTotal() + ", mSize=" + getSize() + ", mPages=" + getPages() + ", mCurrent=" + getCurrent() + ", mPois=" + getPois() + ")";
    }

    public Integer getTotal() {
        return this.mTotal;
    }

    public Integer getSize() {
        return this.mSize;
    }

    public Integer getPages() {
        return this.mPages;
    }

    public Integer getCurrent() {
        return this.mCurrent;
    }

    public List<NaviPoiInfo> getPois() {
        return this.mPois;
    }
}
