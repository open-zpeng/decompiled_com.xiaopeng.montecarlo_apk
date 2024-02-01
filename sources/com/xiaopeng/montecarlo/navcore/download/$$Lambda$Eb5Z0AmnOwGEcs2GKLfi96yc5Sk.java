package com.xiaopeng.montecarlo.navcore.download;

import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import java.util.function.Function;
/* compiled from: lambda */
/* renamed from: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk  reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk implements Function {
    public static final /* synthetic */ $$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk INSTANCE = new $$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk();

    private /* synthetic */ $$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Integer.valueOf(((CityDataBean) obj).getAdcode());
    }
}
