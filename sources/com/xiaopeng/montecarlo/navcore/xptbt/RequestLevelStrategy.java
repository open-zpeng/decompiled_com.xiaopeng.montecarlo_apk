package com.xiaopeng.montecarlo.navcore.xptbt;
/* loaded from: classes3.dex */
public class RequestLevelStrategy implements IRequestLevelStrategy {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r7 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
        if (r7 != false) goto L15;
     */
    @Override // com.xiaopeng.montecarlo.navcore.xptbt.IRequestLevelStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getRequestPriority(@androidx.annotation.NonNull java.util.Map<java.lang.Long, com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel> r4, long r5, int r7, long r8) {
        /*
            r3 = this;
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            java.lang.Object r5 = r4.get(r5)
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel r5 = (com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel) r5
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            java.lang.Object r4 = r4.get(r6)
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel r4 = (com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel) r4
            r6 = 0
            r8 = 3
            if (r5 == 0) goto L49
            if (r4 == 0) goto L49
            r9 = 1
            r0 = 2
            if (r0 != r7) goto L20
            r7 = r9
            goto L21
        L20:
            r7 = r6
        L21:
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams r5 = r5.mRouteParams
            com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams r4 = r4.mRouteParams
            if (r5 == 0) goto L49
            if (r4 == 0) goto L49
            int r1 = r4.mRoutePriority
            int r2 = r5.mRoutePriority
            if (r1 >= r2) goto L37
            boolean r4 = r4.mIsCanCancel
            if (r4 != 0) goto L4a
            if (r7 == 0) goto L49
        L35:
            r6 = r0
            goto L4a
        L37:
            int r4 = r4.mRoutePriority
            int r6 = r5.mRoutePriority
            if (r4 <= r6) goto L49
            boolean r4 = r5.mIsCanCancel
            if (r4 == 0) goto L46
            if (r7 == 0) goto L44
            goto L35
        L44:
            r6 = r9
            goto L4a
        L46:
            if (r7 == 0) goto L49
            goto L35
        L49:
            r6 = r8
        L4a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.xptbt.RequestLevelStrategy.getRequestPriority(java.util.Map, long, int, long):int");
    }
}
