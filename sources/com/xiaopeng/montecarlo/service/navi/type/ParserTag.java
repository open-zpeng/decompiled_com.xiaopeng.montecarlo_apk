package com.xiaopeng.montecarlo.service.navi.type;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class ParserTag {
    public ArrayList<Integer> mBackType = new ArrayList<>();
    public Class<?> mClass;
    public int mWhat;

    public ParserTag(int i, Class<?> cls, int[] iArr) {
        this.mWhat = 0;
        this.mWhat = i;
        this.mClass = cls;
        for (int i2 : iArr) {
            this.mBackType.add(Integer.valueOf(i2));
        }
    }
}
