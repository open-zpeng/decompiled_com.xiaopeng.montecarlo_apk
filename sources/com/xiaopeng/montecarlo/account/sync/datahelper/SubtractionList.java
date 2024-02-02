package com.xiaopeng.montecarlo.account.sync.datahelper;

import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class SubtractionList<T> {
    private List<T> mList;
    private List<T> mSubList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface SubtractionListCallback<T> {
        boolean equal(T t, T t2);
    }

    public SubtractionList(List<T> list, List<T> list2) {
        this.mList = null;
        this.mSubList = null;
        this.mList = list;
        this.mSubList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<T> getSubtraction(SubtractionListCallback subtractionListCallback) {
        if (subtractionListCallback == null || CollectionUtils.isEmpty(this.mList)) {
            return new ArrayList();
        }
        List<T> list = this.mSubList;
        if (list == null || list.size() == 0) {
            return new ArrayList(this.mList);
        }
        ArrayList arrayList = new ArrayList(this.mList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (contains(it.next(), this.mSubList, subtractionListCallback)) {
                it.remove();
            }
        }
        return arrayList;
    }

    private boolean contains(T t, List<T> list, SubtractionListCallback subtractionListCallback) {
        Iterator<T> it = list.iterator();
        if (t != null) {
            while (it.hasNext()) {
                if (subtractionListCallback.equal(t, it.next())) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (it.next() == null) {
                return true;
            }
        }
        return false;
    }
}
