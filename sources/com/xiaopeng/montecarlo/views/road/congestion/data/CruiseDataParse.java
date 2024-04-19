package com.xiaopeng.montecarlo.views.road.congestion.data;

import android.text.Html;
import android.text.Spanned;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseCongestionInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ResUtil;
import com.xiaopeng.montecarlo.views.font.XpFontTagHandler;
/* loaded from: classes3.dex */
public class CruiseDataParse implements IDataParse<XPCruiseCongestionInfo> {
    private XPCruiseCongestionInfo mXPCruiseCongestionInfo;
    private XpFontTagHandler mXpFontTagHandler = new XpFontTagHandler(ContextUtils.getContext().getResources().getDisplayMetrics());

    @Override // com.xiaopeng.montecarlo.views.road.congestion.data.IDataParse
    public CruiseDataParse parseCongestionData(XPCruiseCongestionInfo xPCruiseCongestionInfo) {
        this.mXPCruiseCongestionInfo = xPCruiseCongestionInfo;
        return this;
    }

    private Spanned getTimeString(String str, double d) {
        double d2 = d < 0.0d ? 0.0d : d;
        long j = (long) (d2 / 3600.0d);
        long j2 = (long) ((d2 % 3600.0d) / 60.0d);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            sb.append(ContextUtils.getString(R.string.traffic_congestion_status_hour, Long.valueOf(j)));
        }
        if (d2 >= 0.0d && j2 == 0 && i == 0) {
            j2 = 1;
        }
        if (j2 > 0) {
            sb.append(ContextUtils.getString(R.string.traffic_congestion_status_minute, Long.valueOf(j2)));
        }
        return Html.fromHtml(sb.toString(), null, this.mXpFontTagHandler);
    }

    @Override // com.xiaopeng.montecarlo.views.road.congestion.data.IDataParse
    public int parseCongestionColor() {
        XPCruiseCongestionInfo xPCruiseCongestionInfo = this.mXPCruiseCongestionInfo;
        if (xPCruiseCongestionInfo == null) {
            return 0;
        }
        return ResUtil.getTrafficCongestionColor(xPCruiseCongestionInfo.mCongestionStatus);
    }

    @Override // com.xiaopeng.montecarlo.views.road.congestion.data.IDataParse
    public CharSequence parseCongestionStr() {
        XPCruiseCongestionInfo xPCruiseCongestionInfo = this.mXPCruiseCongestionInfo;
        if (xPCruiseCongestionInfo == null || xPCruiseCongestionInfo.mCongestionStatus < 1 || this.mXPCruiseCongestionInfo.mLength <= 0) {
            return null;
        }
        if (this.mXPCruiseCongestionInfo.mCongestionStatus == 1) {
            return ContextUtils.getString(R.string.jam_normal);
        }
        return getTimeString(ContextUtils.getString(R.string.traffic_congestion_status, this.mXPCruiseCongestionInfo.mRoadName, ResUtil.getCongestionStatusString(this.mXPCruiseCongestionInfo.mCongestionStatus), Integer.valueOf(this.mXPCruiseCongestionInfo.mLength)), this.mXPCruiseCongestionInfo.mEtaTime);
    }
}
