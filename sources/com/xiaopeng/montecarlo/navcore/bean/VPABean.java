package com.xiaopeng.montecarlo.navcore.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.List;
/* loaded from: classes.dex */
public class VPABean {
    @SerializedName("cities")
    public List<Cities> mCities;
    @SerializedName("version")
    public String mVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof VPABean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VPABean) {
            VPABean vPABean = (VPABean) obj;
            if (vPABean.canEqual(this)) {
                String version = getVersion();
                String version2 = vPABean.getVersion();
                if (version != null ? version.equals(version2) : version2 == null) {
                    List<Cities> cities = getCities();
                    List<Cities> cities2 = vPABean.getCities();
                    return cities != null ? cities.equals(cities2) : cities2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String version = getVersion();
        int hashCode = version == null ? 43 : version.hashCode();
        List<Cities> cities = getCities();
        return ((hashCode + 59) * 59) + (cities != null ? cities.hashCode() : 43);
    }

    public void setCities(List<Cities> list) {
        this.mCities = list;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String toString() {
        return "VPABean(mVersion=" + getVersion() + ", mCities=" + getCities() + ")";
    }

    public String getVersion() {
        return this.mVersion;
    }

    public List<Cities> getCities() {
        return this.mCities;
    }

    /* loaded from: classes.dex */
    public static class Cities {
        @SerializedName("city_id")
        public String mCityId;
        @SerializedName("garages")
        public List<Garages> mGarages;
        @SerializedName("name")
        public String mName;

        protected boolean canEqual(Object obj) {
            return obj instanceof Cities;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Cities) {
                Cities cities = (Cities) obj;
                if (cities.canEqual(this)) {
                    String cityId = getCityId();
                    String cityId2 = cities.getCityId();
                    if (cityId != null ? cityId.equals(cityId2) : cityId2 == null) {
                        String name = getName();
                        String name2 = cities.getName();
                        if (name != null ? name.equals(name2) : name2 == null) {
                            List<Garages> garages = getGarages();
                            List<Garages> garages2 = cities.getGarages();
                            return garages != null ? garages.equals(garages2) : garages2 == null;
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
            String cityId = getCityId();
            int hashCode = cityId == null ? 43 : cityId.hashCode();
            String name = getName();
            int hashCode2 = ((hashCode + 59) * 59) + (name == null ? 43 : name.hashCode());
            List<Garages> garages = getGarages();
            return (hashCode2 * 59) + (garages != null ? garages.hashCode() : 43);
        }

        public void setCityId(String str) {
            this.mCityId = str;
        }

        public void setGarages(List<Garages> list) {
            this.mGarages = list;
        }

        public void setName(String str) {
            this.mName = str;
        }

        public String toString() {
            return "VPABean.Cities(mCityId=" + getCityId() + ", mName=" + getName() + ", mGarages=" + getGarages() + ")";
        }

        public String getCityId() {
            return this.mCityId;
        }

        public String getName() {
            return this.mName;
        }

        public List<Garages> getGarages() {
            return this.mGarages;
        }

        /* loaded from: classes.dex */
        public static class Garages {
            @SerializedName("entrance_loc")
            public List<Double> mEntranceLoc;
            @SerializedName(VuiConstants.ELEMENT_ID)
            public String mId;
            @SerializedName("venue")
            public List<String> mVenue;

            protected boolean canEqual(Object obj) {
                return obj instanceof Garages;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof Garages) {
                    Garages garages = (Garages) obj;
                    if (garages.canEqual(this)) {
                        String id = getId();
                        String id2 = garages.getId();
                        if (id != null ? id.equals(id2) : id2 == null) {
                            List<String> venue = getVenue();
                            List<String> venue2 = garages.getVenue();
                            if (venue != null ? venue.equals(venue2) : venue2 == null) {
                                List<Double> entranceLoc = getEntranceLoc();
                                List<Double> entranceLoc2 = garages.getEntranceLoc();
                                return entranceLoc != null ? entranceLoc.equals(entranceLoc2) : entranceLoc2 == null;
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
                String id = getId();
                int hashCode = id == null ? 43 : id.hashCode();
                List<String> venue = getVenue();
                int hashCode2 = ((hashCode + 59) * 59) + (venue == null ? 43 : venue.hashCode());
                List<Double> entranceLoc = getEntranceLoc();
                return (hashCode2 * 59) + (entranceLoc != null ? entranceLoc.hashCode() : 43);
            }

            public void setEntranceLoc(List<Double> list) {
                this.mEntranceLoc = list;
            }

            public void setId(String str) {
                this.mId = str;
            }

            public void setVenue(List<String> list) {
                this.mVenue = list;
            }

            public String toString() {
                return "VPABean.Cities.Garages(mId=" + getId() + ", mVenue=" + getVenue() + ", mEntranceLoc=" + getEntranceLoc() + ")";
            }

            public String getId() {
                return this.mId;
            }

            public List<String> getVenue() {
                return this.mVenue;
            }

            public List<Double> getEntranceLoc() {
                return this.mEntranceLoc;
            }
        }
    }
}
