package com.xiaopeng.montecarlo.navcore.datarecord;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class SrDataRecordStrategyInfo {
    @SerializedName("framesCountForOneFile")
    private Integer mFramesCountForOneFile;
    @SerializedName("framesCountForOneWrite")
    private Integer mFramesCountForOneWrite;
    @SerializedName("framesJumpForInsertForSRActive")
    private Integer mFramesJumpForInsertForSRActive;
    @SerializedName("framesJumpForInsertForSRUnActive")
    private Integer mFramesJumpForInsertForSRUnActive;
    @SerializedName("maxPerFileSize")
    private Long mMaxPerFileSize;
    @SerializedName("maxTotalSize")
    private Long mMaxTotalSize;
    @SerializedName("userRole")
    private String mUserRole;

    /* loaded from: classes3.dex */
    public static class UserRole {
        public static final String USER_ROLE_DEFAULT = "user";
        public static final String USER_ROLE_TEST = "test";
        public static final String USER_ROLE_USER = "user";
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof SrDataRecordStrategyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SrDataRecordStrategyInfo) {
            SrDataRecordStrategyInfo srDataRecordStrategyInfo = (SrDataRecordStrategyInfo) obj;
            if (srDataRecordStrategyInfo.canEqual(this)) {
                Long maxTotalSize = getMaxTotalSize();
                Long maxTotalSize2 = srDataRecordStrategyInfo.getMaxTotalSize();
                if (maxTotalSize != null ? maxTotalSize.equals(maxTotalSize2) : maxTotalSize2 == null) {
                    Long maxPerFileSize = getMaxPerFileSize();
                    Long maxPerFileSize2 = srDataRecordStrategyInfo.getMaxPerFileSize();
                    if (maxPerFileSize != null ? maxPerFileSize.equals(maxPerFileSize2) : maxPerFileSize2 == null) {
                        Integer framesCountForOneWrite = getFramesCountForOneWrite();
                        Integer framesCountForOneWrite2 = srDataRecordStrategyInfo.getFramesCountForOneWrite();
                        if (framesCountForOneWrite != null ? framesCountForOneWrite.equals(framesCountForOneWrite2) : framesCountForOneWrite2 == null) {
                            Integer framesCountForOneFile = getFramesCountForOneFile();
                            Integer framesCountForOneFile2 = srDataRecordStrategyInfo.getFramesCountForOneFile();
                            if (framesCountForOneFile != null ? framesCountForOneFile.equals(framesCountForOneFile2) : framesCountForOneFile2 == null) {
                                Integer framesJumpForInsertForSRActive = getFramesJumpForInsertForSRActive();
                                Integer framesJumpForInsertForSRActive2 = srDataRecordStrategyInfo.getFramesJumpForInsertForSRActive();
                                if (framesJumpForInsertForSRActive != null ? framesJumpForInsertForSRActive.equals(framesJumpForInsertForSRActive2) : framesJumpForInsertForSRActive2 == null) {
                                    Integer framesJumpForInsertForSRUnActive = getFramesJumpForInsertForSRUnActive();
                                    Integer framesJumpForInsertForSRUnActive2 = srDataRecordStrategyInfo.getFramesJumpForInsertForSRUnActive();
                                    if (framesJumpForInsertForSRUnActive != null ? framesJumpForInsertForSRUnActive.equals(framesJumpForInsertForSRUnActive2) : framesJumpForInsertForSRUnActive2 == null) {
                                        String userRole = getUserRole();
                                        String userRole2 = srDataRecordStrategyInfo.getUserRole();
                                        return userRole != null ? userRole.equals(userRole2) : userRole2 == null;
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
        Long maxTotalSize = getMaxTotalSize();
        int hashCode = maxTotalSize == null ? 43 : maxTotalSize.hashCode();
        Long maxPerFileSize = getMaxPerFileSize();
        int hashCode2 = ((hashCode + 59) * 59) + (maxPerFileSize == null ? 43 : maxPerFileSize.hashCode());
        Integer framesCountForOneWrite = getFramesCountForOneWrite();
        int hashCode3 = (hashCode2 * 59) + (framesCountForOneWrite == null ? 43 : framesCountForOneWrite.hashCode());
        Integer framesCountForOneFile = getFramesCountForOneFile();
        int hashCode4 = (hashCode3 * 59) + (framesCountForOneFile == null ? 43 : framesCountForOneFile.hashCode());
        Integer framesJumpForInsertForSRActive = getFramesJumpForInsertForSRActive();
        int hashCode5 = (hashCode4 * 59) + (framesJumpForInsertForSRActive == null ? 43 : framesJumpForInsertForSRActive.hashCode());
        Integer framesJumpForInsertForSRUnActive = getFramesJumpForInsertForSRUnActive();
        int hashCode6 = (hashCode5 * 59) + (framesJumpForInsertForSRUnActive == null ? 43 : framesJumpForInsertForSRUnActive.hashCode());
        String userRole = getUserRole();
        return (hashCode6 * 59) + (userRole != null ? userRole.hashCode() : 43);
    }

    public SrDataRecordStrategyInfo setFramesCountForOneFile(Integer num) {
        this.mFramesCountForOneFile = num;
        return this;
    }

    public SrDataRecordStrategyInfo setFramesCountForOneWrite(Integer num) {
        this.mFramesCountForOneWrite = num;
        return this;
    }

    public SrDataRecordStrategyInfo setFramesJumpForInsertForSRActive(Integer num) {
        this.mFramesJumpForInsertForSRActive = num;
        return this;
    }

    public SrDataRecordStrategyInfo setFramesJumpForInsertForSRUnActive(Integer num) {
        this.mFramesJumpForInsertForSRUnActive = num;
        return this;
    }

    public SrDataRecordStrategyInfo setMaxPerFileSize(Long l) {
        this.mMaxPerFileSize = l;
        return this;
    }

    public SrDataRecordStrategyInfo setMaxTotalSize(Long l) {
        this.mMaxTotalSize = l;
        return this;
    }

    public SrDataRecordStrategyInfo setUserRole(String str) {
        this.mUserRole = str;
        return this;
    }

    public String getUserRole() {
        return this.mUserRole;
    }

    public Long getMaxTotalSize() {
        return this.mMaxTotalSize;
    }

    public Long getMaxPerFileSize() {
        return this.mMaxPerFileSize;
    }

    public Integer getFramesCountForOneWrite() {
        return this.mFramesCountForOneWrite;
    }

    public Integer getFramesCountForOneFile() {
        return this.mFramesCountForOneFile;
    }

    public Integer getFramesJumpForInsertForSRActive() {
        return this.mFramesJumpForInsertForSRActive;
    }

    public Integer getFramesJumpForInsertForSRUnActive() {
        return this.mFramesJumpForInsertForSRUnActive;
    }

    public String toString() {
        return "SrDataRecordStrategyInfo{mUserRole='" + this.mUserRole + "', mMaxTotalSize=" + this.mMaxTotalSize + ", mMaxPerFileSize=" + this.mMaxPerFileSize + ", mFramesCountForOneWrite=" + this.mFramesCountForOneWrite + ", mFramesCountForOneFile=" + this.mFramesCountForOneFile + ", mFramesJumpForInsertForSRActive=" + this.mFramesJumpForInsertForSRActive + ", mFramesJumpForInsertForSRUnActive=" + this.mFramesJumpForInsertForSRUnActive + '}';
    }
}
