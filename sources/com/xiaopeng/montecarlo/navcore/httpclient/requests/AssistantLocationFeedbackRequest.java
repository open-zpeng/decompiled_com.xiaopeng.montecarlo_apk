package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class AssistantLocationFeedbackRequest {
    @SerializedName("kind")
    private String mKind;
    @SerializedName("poiId")
    private String mPoiId;
    @SerializedName("ts")
    private Long mTs;
    @SerializedName("userId")
    private Long mUserId;
    @SerializedName("vin")
    private String mVin;

    protected boolean canEqual(Object obj) {
        return obj instanceof AssistantLocationFeedbackRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssistantLocationFeedbackRequest) {
            AssistantLocationFeedbackRequest assistantLocationFeedbackRequest = (AssistantLocationFeedbackRequest) obj;
            if (assistantLocationFeedbackRequest.canEqual(this)) {
                Long userId = getUserId();
                Long userId2 = assistantLocationFeedbackRequest.getUserId();
                if (userId != null ? userId.equals(userId2) : userId2 == null) {
                    Long ts = getTs();
                    Long ts2 = assistantLocationFeedbackRequest.getTs();
                    if (ts != null ? ts.equals(ts2) : ts2 == null) {
                        String vin = getVin();
                        String vin2 = assistantLocationFeedbackRequest.getVin();
                        if (vin != null ? vin.equals(vin2) : vin2 == null) {
                            String kind = getKind();
                            String kind2 = assistantLocationFeedbackRequest.getKind();
                            if (kind != null ? kind.equals(kind2) : kind2 == null) {
                                String poiId = getPoiId();
                                String poiId2 = assistantLocationFeedbackRequest.getPoiId();
                                return poiId != null ? poiId.equals(poiId2) : poiId2 == null;
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
        Long userId = getUserId();
        int hashCode = userId == null ? 43 : userId.hashCode();
        Long ts = getTs();
        int hashCode2 = ((hashCode + 59) * 59) + (ts == null ? 43 : ts.hashCode());
        String vin = getVin();
        int hashCode3 = (hashCode2 * 59) + (vin == null ? 43 : vin.hashCode());
        String kind = getKind();
        int hashCode4 = (hashCode3 * 59) + (kind == null ? 43 : kind.hashCode());
        String poiId = getPoiId();
        return (hashCode4 * 59) + (poiId != null ? poiId.hashCode() : 43);
    }

    public AssistantLocationFeedbackRequest setKind(String str) {
        this.mKind = str;
        return this;
    }

    public AssistantLocationFeedbackRequest setPoiId(String str) {
        this.mPoiId = str;
        return this;
    }

    public AssistantLocationFeedbackRequest setTs(Long l) {
        this.mTs = l;
        return this;
    }

    public AssistantLocationFeedbackRequest setUserId(Long l) {
        this.mUserId = l;
        return this;
    }

    public AssistantLocationFeedbackRequest setVin(String str) {
        this.mVin = str;
        return this;
    }

    public String toString() {
        return "AssistantLocationFeedbackRequest(mVin=" + getVin() + ", mUserId=" + getUserId() + ", mKind=" + getKind() + ", mPoiId=" + getPoiId() + ", mTs=" + getTs() + ")";
    }

    public String getVin() {
        return this.mVin;
    }

    public Long getUserId() {
        return this.mUserId;
    }

    public String getKind() {
        return this.mKind;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public Long getTs() {
        return this.mTs;
    }
}
