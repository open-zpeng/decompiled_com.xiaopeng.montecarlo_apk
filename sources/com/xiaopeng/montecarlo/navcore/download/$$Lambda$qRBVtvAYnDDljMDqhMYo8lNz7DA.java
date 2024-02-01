package com.xiaopeng.montecarlo.navcore.download;

import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import java.util.Objects;
import java.util.function.Predicate;
/* compiled from: lambda */
/* renamed from: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA  reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA implements Predicate {
    public static final /* synthetic */ $$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA INSTANCE = new $$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA();

    private /* synthetic */ $$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Objects.nonNull((CityDataBean) obj);
    }
}
