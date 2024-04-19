package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.RoadSeqStageInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class AssistantPowerKRequest {
    @SerializedName("stages")
    private List<RoadSeqStageInfo> mStages;
    @SerializedName("ts")
    private Long mTs;
    @SerializedName("userId")
    private Long mUserId;
    @SerializedName("vin")
    private String mVin;

    protected boolean canEqual(Object obj) {
        return obj instanceof AssistantPowerKRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssistantPowerKRequest) {
            AssistantPowerKRequest assistantPowerKRequest = (AssistantPowerKRequest) obj;
            if (assistantPowerKRequest.canEqual(this)) {
                Long userId = getUserId();
                Long userId2 = assistantPowerKRequest.getUserId();
                if (userId != null ? userId.equals(userId2) : userId2 == null) {
                    Long ts = getTs();
                    Long ts2 = assistantPowerKRequest.getTs();
                    if (ts != null ? ts.equals(ts2) : ts2 == null) {
                        String vin = getVin();
                        String vin2 = assistantPowerKRequest.getVin();
                        if (vin != null ? vin.equals(vin2) : vin2 == null) {
                            List<RoadSeqStageInfo> stages = getStages();
                            List<RoadSeqStageInfo> stages2 = assistantPowerKRequest.getStages();
                            return stages != null ? stages.equals(stages2) : stages2 == null;
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
        Long userId = getUserId();
        int hashCode = userId == null ? 43 : userId.hashCode();
        Long ts = getTs();
        int hashCode2 = ((hashCode + 59) * 59) + (ts == null ? 43 : ts.hashCode());
        String vin = getVin();
        int hashCode3 = (hashCode2 * 59) + (vin == null ? 43 : vin.hashCode());
        List<RoadSeqStageInfo> stages = getStages();
        return (hashCode3 * 59) + (stages != null ? stages.hashCode() : 43);
    }

    public AssistantPowerKRequest setStages(List<RoadSeqStageInfo> list) {
        this.mStages = list;
        return this;
    }

    public AssistantPowerKRequest setTs(Long l) {
        this.mTs = l;
        return this;
    }

    public AssistantPowerKRequest setUserId(Long l) {
        this.mUserId = l;
        return this;
    }

    public AssistantPowerKRequest setVin(String str) {
        this.mVin = str;
        return this;
    }

    public String toString() {
        return "AssistantPowerKRequest(mVin=" + getVin() + ", mUserId=" + getUserId() + ", mStages=" + getStages() + ", mTs=" + getTs() + ")";
    }

    public String getVin() {
        return this.mVin;
    }

    public Long getUserId() {
        return this.mUserId;
    }

    public List<RoadSeqStageInfo> getStages() {
        return this.mStages;
    }

    public Long getTs() {
        return this.mTs;
    }
}
