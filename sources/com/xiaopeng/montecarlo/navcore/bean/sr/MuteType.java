package com.xiaopeng.montecarlo.navcore.bean.sr;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes2.dex */
public class MuteType {
    @SerializedName("subTypes")
    private List<Integer> mSubTypes;
    @SerializedName("type")
    private Integer mType;

    protected boolean canEqual(Object obj) {
        return obj instanceof MuteType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MuteType) {
            MuteType muteType = (MuteType) obj;
            if (muteType.canEqual(this)) {
                Integer type = getType();
                Integer type2 = muteType.getType();
                if (type != null ? type.equals(type2) : type2 == null) {
                    List<Integer> subTypes = getSubTypes();
                    List<Integer> subTypes2 = muteType.getSubTypes();
                    return subTypes != null ? subTypes.equals(subTypes2) : subTypes2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Integer type = getType();
        int hashCode = type == null ? 43 : type.hashCode();
        List<Integer> subTypes = getSubTypes();
        return ((hashCode + 59) * 59) + (subTypes != null ? subTypes.hashCode() : 43);
    }

    public MuteType setSubTypes(List<Integer> list) {
        this.mSubTypes = list;
        return this;
    }

    public MuteType setType(Integer num) {
        this.mType = num;
        return this;
    }

    public Integer getType() {
        return this.mType;
    }

    public List<Integer> getSubTypes() {
        return this.mSubTypes;
    }

    public String toString() {
        return "MuteType{mType=" + this.mType + ", mSubTypes=" + this.mSubTypes + '}';
    }
}
