package com.alibaba.sdk.android.httpdns.b;

import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes.dex */
public class g {
    public long h;
    public long id;
    public String k;
    public String l;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("[IpRecord] ");
        sb.append("id:");
        sb.append(this.id);
        sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        sb.append("host_id:");
        sb.append(this.h);
        sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        sb.append("ip:");
        sb.append(this.k);
        sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        sb.append("ttl:");
        sb.append(this.l);
        sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        return sb.toString();
    }
}
