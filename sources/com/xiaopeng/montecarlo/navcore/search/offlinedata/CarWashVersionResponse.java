package com.xiaopeng.montecarlo.navcore.search.offlinedata;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class CarWashVersionResponse {
    public static final String RESPONSE_CODE_OK = "0";
    private static final L.Tag TAG = new L.Tag("CarWashVersionResponse");
    @SerializedName("data")
    private VersionData mData;
    @SerializedName("retCode")
    private String mRetCode;
    @SerializedName("retMsg")
    private String mRetMsg;

    protected boolean canEqual(Object obj) {
        return obj instanceof CarWashVersionResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CarWashVersionResponse) {
            CarWashVersionResponse carWashVersionResponse = (CarWashVersionResponse) obj;
            if (carWashVersionResponse.canEqual(this)) {
                String retCode = getRetCode();
                String retCode2 = carWashVersionResponse.getRetCode();
                if (retCode != null ? retCode.equals(retCode2) : retCode2 == null) {
                    String retMsg = getRetMsg();
                    String retMsg2 = carWashVersionResponse.getRetMsg();
                    if (retMsg != null ? retMsg.equals(retMsg2) : retMsg2 == null) {
                        VersionData data = getData();
                        VersionData data2 = carWashVersionResponse.getData();
                        return data != null ? data.equals(data2) : data2 == null;
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
        String retCode = getRetCode();
        int hashCode = retCode == null ? 43 : retCode.hashCode();
        String retMsg = getRetMsg();
        int hashCode2 = ((hashCode + 59) * 59) + (retMsg == null ? 43 : retMsg.hashCode());
        VersionData data = getData();
        return (hashCode2 * 59) + (data != null ? data.hashCode() : 43);
    }

    public void setData(VersionData versionData) {
        this.mData = versionData;
    }

    public void setRetCode(String str) {
        this.mRetCode = str;
    }

    public void setRetMsg(String str) {
        this.mRetMsg = str;
    }

    public String toString() {
        return "CarWashVersionResponse(mRetCode=" + getRetCode() + ", mRetMsg=" + getRetMsg() + ", mData=" + getData() + ")";
    }

    public String getRetCode() {
        return this.mRetCode;
    }

    public String getRetMsg() {
        return this.mRetMsg;
    }

    public VersionData getData() {
        return this.mData;
    }

    /* loaded from: classes3.dex */
    public class VersionData {
        @SerializedName("preTotal")
        private String mPreTotal;
        @SerializedName("preVer")
        private String mPreVer;
        @SerializedName("total")
        private String mTotal;
        @SerializedName("version")
        private String mVersion;

        public VersionData() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof VersionData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof VersionData) {
                VersionData versionData = (VersionData) obj;
                if (versionData.canEqual(this)) {
                    String version = getVersion();
                    String version2 = versionData.getVersion();
                    if (version != null ? version.equals(version2) : version2 == null) {
                        String preVer = getPreVer();
                        String preVer2 = versionData.getPreVer();
                        if (preVer != null ? preVer.equals(preVer2) : preVer2 == null) {
                            String total = getTotal();
                            String total2 = versionData.getTotal();
                            if (total != null ? total.equals(total2) : total2 == null) {
                                String preTotal = getPreTotal();
                                String preTotal2 = versionData.getPreTotal();
                                return preTotal != null ? preTotal.equals(preTotal2) : preTotal2 == null;
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
            String version = getVersion();
            int hashCode = version == null ? 43 : version.hashCode();
            String preVer = getPreVer();
            int hashCode2 = ((hashCode + 59) * 59) + (preVer == null ? 43 : preVer.hashCode());
            String total = getTotal();
            int hashCode3 = (hashCode2 * 59) + (total == null ? 43 : total.hashCode());
            String preTotal = getPreTotal();
            return (hashCode3 * 59) + (preTotal != null ? preTotal.hashCode() : 43);
        }

        public void setPreTotal(String str) {
            this.mPreTotal = str;
        }

        public void setPreVer(String str) {
            this.mPreVer = str;
        }

        public void setTotal(String str) {
            this.mTotal = str;
        }

        public void setVersion(String str) {
            this.mVersion = str;
        }

        public String toString() {
            return "CarWashVersionResponse.VersionData(mVersion=" + getVersion() + ", mPreVer=" + getPreVer() + ", mTotal=" + getTotal() + ", mPreTotal=" + getPreTotal() + ")";
        }

        public String getVersion() {
            return this.mVersion;
        }

        public String getPreVer() {
            return this.mPreVer;
        }

        public String getTotal() {
            return this.mTotal;
        }

        public String getPreTotal() {
            return this.mPreTotal;
        }
    }
}
