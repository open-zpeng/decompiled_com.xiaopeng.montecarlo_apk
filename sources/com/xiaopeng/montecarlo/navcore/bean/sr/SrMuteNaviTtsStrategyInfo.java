package com.xiaopeng.montecarlo.navcore.bean.sr;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes3.dex */
public class SrMuteNaviTtsStrategyInfo {
    @SerializedName("muteLevel")
    private Integer mMuteLevel;
    @SerializedName("muteTypes")
    private List<MuteType> mMuteTypes;

    protected boolean canEqual(Object obj) {
        return obj instanceof SrMuteNaviTtsStrategyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SrMuteNaviTtsStrategyInfo) {
            SrMuteNaviTtsStrategyInfo srMuteNaviTtsStrategyInfo = (SrMuteNaviTtsStrategyInfo) obj;
            if (srMuteNaviTtsStrategyInfo.canEqual(this)) {
                Integer muteLevel = getMuteLevel();
                Integer muteLevel2 = srMuteNaviTtsStrategyInfo.getMuteLevel();
                if (muteLevel != null ? muteLevel.equals(muteLevel2) : muteLevel2 == null) {
                    List<MuteType> muteTypes = getMuteTypes();
                    List<MuteType> muteTypes2 = srMuteNaviTtsStrategyInfo.getMuteTypes();
                    return muteTypes != null ? muteTypes.equals(muteTypes2) : muteTypes2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Integer muteLevel = getMuteLevel();
        int hashCode = muteLevel == null ? 43 : muteLevel.hashCode();
        List<MuteType> muteTypes = getMuteTypes();
        return ((hashCode + 59) * 59) + (muteTypes != null ? muteTypes.hashCode() : 43);
    }

    public SrMuteNaviTtsStrategyInfo setMuteLevel(Integer num) {
        this.mMuteLevel = num;
        return this;
    }

    public SrMuteNaviTtsStrategyInfo setMuteTypes(List<MuteType> list) {
        this.mMuteTypes = list;
        return this;
    }

    public Integer getMuteLevel() {
        return this.mMuteLevel;
    }

    public List<MuteType> getMuteTypes() {
        return this.mMuteTypes;
    }

    public String toString() {
        return "SrMuteNaviTtsStrategyInfo{mMuteLevel=" + this.mMuteLevel + ", mMuteTypes=" + this.mMuteTypes + '}';
    }
}
