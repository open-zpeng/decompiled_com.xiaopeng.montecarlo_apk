package com.xiaopeng.montecarlo.root.util;

import android.util.SparseArray;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class CollectionUtils {
    private static final L.Tag TAG = new L.Tag("CollectionUtils");

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static <E> boolean isEmpty(E[] eArr) {
        return eArr == null || eArr.length <= 0;
    }

    public static boolean isEmpty(int[] iArr) {
        return iArr == null || iArr.length <= 0;
    }

    public static boolean isEmpty(SparseArray sparseArray) {
        return sparseArray == null || sparseArray.size() == 0;
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static <E> boolean isNotEmpty(E[] eArr) {
        return !isEmpty(eArr);
    }

    public static <E> void listAdd(List<E> list, E e) {
        if (e == null || list.contains(e)) {
            return;
        }
        list.add(e);
    }

    public static boolean isIndexLegal(int i, Collection collection) {
        if (!isNotEmpty(collection) || i < 0 || i >= collection.size()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "isIndexLegal index:" + i + ",coll:" + collection);
            }
            return false;
        }
        return true;
    }

    public static <T> T[] toArray(List<T> list, Class<T> cls) {
        if (isNotEmpty(list)) {
            return (T[]) list.toArray((Object[]) Array.newInstance((Class<?>) cls, list.size()));
        }
        return null;
    }

    public static String intArrayToString(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (iArr != null) {
            for (int i : iArr) {
                sb.append(i);
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
