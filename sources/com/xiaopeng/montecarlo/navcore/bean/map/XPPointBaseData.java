package com.xiaopeng.montecarlo.navcore.bean.map;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.text.DecimalFormat;
import java.util.Objects;
/* loaded from: classes3.dex */
public class XPPointBaseData {
    private static final String PATTERN = "#.0000";
    private static final DecimalFormat mFormat = new DecimalFormat(PATTERN);
    public String id;
    public Coord3DDouble position = new Coord3DDouble();
    public int priority;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XPPointBaseData xPPointBaseData = (XPPointBaseData) obj;
        return this.priority == xPPointBaseData.priority && Objects.equals(this.id, xPPointBaseData.id) && Objects.equals(mFormat.format(this.position.lat), mFormat.format(xPPointBaseData.position.lat)) && Objects.equals(mFormat.format(this.position.lon), mFormat.format(xPPointBaseData.position.lon)) && Objects.equals(mFormat.format(this.position.z), mFormat.format(xPPointBaseData.position.z));
    }

    public int hashCode() {
        return Objects.hash(this.id, mFormat.format(this.position.lat), mFormat.format(this.position.lon), mFormat.format(this.position.z), Integer.valueOf(this.priority));
    }

    public String toString() {
        return "{\"id\":\"" + this.id + "\",\"position.lat\":" + this.position.lat + ",\"position.lon\":" + this.position.lon + ",\"position.z\":" + this.position.z + ",\"priority\":" + this.priority + '}';
    }
}
