package com.xiaopeng.montecarlo.navcore.download.autodownload.profile;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class VisitCityRecorder {
    @SerializedName("mDay")
    private Integer mDay;
    @NonNull
    @SerializedName("mVisitCityList")
    private Set<Integer> mVisitCityList = new HashSet();

    public Integer getDay() {
        return this.mDay;
    }

    @NonNull
    public Set<Integer> getVisitCityList() {
        return this.mVisitCityList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VisitCityRecorder(int i) {
        this.mDay = Integer.valueOf(i);
    }

    public void recordAdCode(int i) {
        this.mVisitCityList.add(Integer.valueOf(i));
    }

    public String toString() {
        return GsonUtil.toJson(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof VisitCityRecorder) {
            return ((VisitCityRecorder) obj).mDay.equals(this.mDay);
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return this.mDay.hashCode();
    }
}
