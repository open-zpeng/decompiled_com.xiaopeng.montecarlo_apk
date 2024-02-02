package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.Valid;
/* loaded from: classes2.dex */
public class NaviClearDataRequest {
    @SerializedName("data_types_map")
    @Valid
    private Map<Integer, List<Integer>> mDataTypesMap;
    @SerializedName("deleted_types")
    private Set<Integer> mDeletedTypes;
    @SerializedName("deleted_version")
    private Long mDeletedVersion;
    @SerializedName("local_version")
    private Long mLocalVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviClearDataRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviClearDataRequest) {
            NaviClearDataRequest naviClearDataRequest = (NaviClearDataRequest) obj;
            if (naviClearDataRequest.canEqual(this)) {
                Long localVersion = getLocalVersion();
                Long localVersion2 = naviClearDataRequest.getLocalVersion();
                if (localVersion != null ? localVersion.equals(localVersion2) : localVersion2 == null) {
                    Long deletedVersion = getDeletedVersion();
                    Long deletedVersion2 = naviClearDataRequest.getDeletedVersion();
                    if (deletedVersion != null ? deletedVersion.equals(deletedVersion2) : deletedVersion2 == null) {
                        Set<Integer> deletedTypes = getDeletedTypes();
                        Set<Integer> deletedTypes2 = naviClearDataRequest.getDeletedTypes();
                        if (deletedTypes != null ? deletedTypes.equals(deletedTypes2) : deletedTypes2 == null) {
                            Map<Integer, List<Integer>> dataTypesMap = getDataTypesMap();
                            Map<Integer, List<Integer>> dataTypesMap2 = naviClearDataRequest.getDataTypesMap();
                            return dataTypesMap != null ? dataTypesMap.equals(dataTypesMap2) : dataTypesMap2 == null;
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
        Long localVersion = getLocalVersion();
        int hashCode = localVersion == null ? 43 : localVersion.hashCode();
        Long deletedVersion = getDeletedVersion();
        int hashCode2 = ((hashCode + 59) * 59) + (deletedVersion == null ? 43 : deletedVersion.hashCode());
        Set<Integer> deletedTypes = getDeletedTypes();
        int hashCode3 = (hashCode2 * 59) + (deletedTypes == null ? 43 : deletedTypes.hashCode());
        Map<Integer, List<Integer>> dataTypesMap = getDataTypesMap();
        return (hashCode3 * 59) + (dataTypesMap != null ? dataTypesMap.hashCode() : 43);
    }

    public NaviClearDataRequest setDataTypesMap(Map<Integer, List<Integer>> map) {
        this.mDataTypesMap = map;
        return this;
    }

    public NaviClearDataRequest setDeletedTypes(Set<Integer> set) {
        this.mDeletedTypes = set;
        return this;
    }

    public NaviClearDataRequest setDeletedVersion(Long l) {
        this.mDeletedVersion = l;
        return this;
    }

    public NaviClearDataRequest setLocalVersion(Long l) {
        this.mLocalVersion = l;
        return this;
    }

    public String toString() {
        return "NaviClearDataRequest(mLocalVersion=" + getLocalVersion() + ", mDeletedVersion=" + getDeletedVersion() + ", mDeletedTypes=" + getDeletedTypes() + ", mDataTypesMap=" + getDataTypesMap() + ")";
    }

    public Long getLocalVersion() {
        return this.mLocalVersion;
    }

    public Long getDeletedVersion() {
        return this.mDeletedVersion;
    }

    public Set<Integer> getDeletedTypes() {
        return this.mDeletedTypes;
    }

    public Map<Integer, List<Integer>> getDataTypesMap() {
        return this.mDataTypesMap;
    }
}
