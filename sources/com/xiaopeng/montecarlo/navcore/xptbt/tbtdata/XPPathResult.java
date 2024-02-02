package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.autonavi.gbl.common.path.option.PathInfo;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
/* loaded from: classes2.dex */
public class XPPathResult implements IPathResult {
    private static final L.Tag TAG = new L.Tag("XPPathResult");
    private List<IVariantPath> mVariantPaths;
    private List<IVariantPath> mVariantPathsTemp;
    private boolean mIsRecycle = false;
    private volatile int mRefCount = 0;
    private ArrayList<PathInfo> mPathResult = new ArrayList<>();

    public XPPathResult(ArrayList<PathInfo> arrayList) {
        Iterator<PathInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            this.mPathResult.add(new PathInfo(it.next()));
        }
        long pathCount = getPathCount();
        this.mVariantPaths = new ArrayList();
        this.mVariantPathsTemp = new ArrayList();
        for (int i = 0; i < pathCount; i++) {
            this.mVariantPaths.add(new XPVariantPath(this.mPathResult.get(i), this));
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult
    public synchronized long getPathCount() {
        if (this.mPathResult == null) {
            return 0L;
        }
        return this.mPathResult.size();
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult
    public synchronized IVariantPath getPath(int i) {
        if (this.mVariantPaths != null && i >= 0 && i < this.mVariantPaths.size()) {
            return this.mVariantPaths.get(i);
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult
    public synchronized IVariantPath getPath(long j) {
        if (this.mVariantPaths != null) {
            for (IVariantPath iVariantPath : this.mVariantPaths) {
                if (iVariantPath.getPathId() == j) {
                    return iVariantPath;
                }
            }
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult
    public synchronized boolean recycle() {
        L.Tag tag = TAG;
        L.i(tag, ">>> recycle mRefCount = " + this.mRefCount);
        if (!this.mIsRecycle) {
            if (this.mRefCount > 0) {
                return false;
            }
            clearVariantPaths();
            if (this.mPathResult != null) {
                this.mPathResult.clear();
                this.mPathResult = null;
            }
            this.mIsRecycle = true;
        }
        return true;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult
    public synchronized boolean addPath(IVariantPath iVariantPath) {
        PathInfo variantPath;
        if (this.mPathResult == null || iVariantPath == null || (variantPath = ((XPVariantPath) iVariantPath).getVariantPath()) == null) {
            return false;
        }
        boolean add = this.mPathResult.add(new PathInfo(variantPath));
        if (add) {
            this.mVariantPaths.add(new XPVariantPath(this.mPathResult.get(this.mPathResult.size() - 1), this));
        }
        return add;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult
    public synchronized boolean removePath(IVariantPath iVariantPath) {
        PathInfo variantPath;
        if (this.mPathResult == null || iVariantPath == null || (variantPath = ((XPVariantPath) iVariantPath).getVariantPath()) == null) {
            return false;
        }
        boolean remove = this.mPathResult.remove(variantPath);
        if (remove) {
            removeVariantPath(iVariantPath.getPathId());
        }
        return remove;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult
    public synchronized int getPathIndex(long j) {
        if (this.mVariantPaths != null) {
            int size = this.mVariantPaths.size();
            for (int i = 0; i < size; i++) {
                IVariantPath iVariantPath = this.mVariantPaths.get(i);
                if (iVariantPath != null && j == iVariantPath.getPathId()) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult
    public synchronized boolean addRef() {
        if (L.ENABLE) {
            L.d(TAG, ">>> addRef mRefCount = " + this.mRefCount + "  mIsRecycle = " + this.mIsRecycle + ", this = " + this);
        }
        if (this.mIsRecycle) {
            return false;
        }
        this.mRefCount++;
        return true;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult
    public synchronized void delRef() {
        if (L.ENABLE) {
            L.d(TAG, ">>> delRef mRefCount = " + this.mRefCount + "  mIsRecycle = " + this.mIsRecycle + ", this = " + this);
        }
        if (!this.mIsRecycle) {
            this.mRefCount--;
        }
    }

    private void removeVariantPath(long j) {
        List<IVariantPath> list = this.mVariantPaths;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            IVariantPath iVariantPath = this.mVariantPaths.get(i);
            if (iVariantPath != null && j == iVariantPath.getPathId()) {
                this.mVariantPaths.remove(i);
                if (this.mRefCount > 0) {
                    this.mVariantPathsTemp.add(iVariantPath);
                    return;
                }
                PathInfo variantPath = ((XPVariantPath) iVariantPath).getVariantPath();
                if (variantPath != null) {
                    variantPath.delete();
                    return;
                }
                return;
            }
        }
    }

    private void clearVariantPaths() {
        List<IVariantPath> list = this.mVariantPaths;
        if (list != null) {
            list.forEach(new Consumer() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.-$$Lambda$XPPathResult$TXaSI5qSTAD8pd_umLf8dDkUZ5c
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    XPPathResult.lambda$clearVariantPaths$0((IVariantPath) obj);
                }
            });
            this.mVariantPaths.clear();
            this.mVariantPaths = null;
        }
        List<IVariantPath> list2 = this.mVariantPathsTemp;
        if (list2 != null) {
            list2.forEach(new Consumer() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.-$$Lambda$XPPathResult$T4vUsIOvcQsm5nJ2OVbJQM5uniI
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    XPPathResult.lambda$clearVariantPaths$1((IVariantPath) obj);
                }
            });
            this.mVariantPathsTemp.clear();
            this.mVariantPathsTemp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$clearVariantPaths$0(IVariantPath iVariantPath) {
        try {
            PathInfo variantPath = ((XPVariantPath) iVariantPath).getVariantPath();
            if (variantPath != null) {
                variantPath.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
            L.Tag tag = TAG;
            L.w(tag, "clearVariantPaths error:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$clearVariantPaths$1(IVariantPath iVariantPath) {
        try {
            PathInfo variantPath = ((XPVariantPath) iVariantPath).getVariantPath();
            if (variantPath != null) {
                variantPath.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
            L.Tag tag = TAG;
            L.w(tag, "clearVariantPaths error:" + e.getMessage());
        }
    }

    public synchronized ArrayList<PathInfo> getPathResult() {
        return this.mPathResult;
    }
}
