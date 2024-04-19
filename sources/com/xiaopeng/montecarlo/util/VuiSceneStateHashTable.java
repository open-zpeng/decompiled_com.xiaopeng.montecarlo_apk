package com.xiaopeng.montecarlo.util;

import java.util.Hashtable;
/* loaded from: classes3.dex */
public class VuiSceneStateHashTable<K, V> extends Hashtable {
    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Integer get(Object obj) {
        int i = 0;
        if (obj == null) {
            return 0;
        }
        Object obj2 = super.get(obj);
        if (obj2 != null) {
            i = ((Integer) obj2).intValue();
        }
        return Integer.valueOf(i);
    }
}
