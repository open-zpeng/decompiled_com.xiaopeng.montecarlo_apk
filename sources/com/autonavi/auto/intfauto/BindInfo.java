package com.autonavi.auto.intfauto;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public class BindInfo implements Comparable<BindInfo> {
    private Object cProxyInst;
    private boolean holdByC;
    private JType jTypeInfo;
    private BindTable ownerTable;
    private HashSet<String> targetSet = new HashSet<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /* JADX INFO: Access modifiers changed from: protected */
    public void wlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.rwLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().lock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wunlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.rwLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.rwLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().lock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.rwLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean addTargetUnlock(String str) {
        HashSet<String> hashSet = this.targetSet;
        if (hashSet == null) {
            return false;
        }
        return hashSet.add(str);
    }

    protected boolean removeTargetUnlock(String str) {
        HashSet<String> hashSet = this.targetSet;
        if (hashSet == null) {
            return false;
        }
        return hashSet.remove(str);
    }

    protected Set<String> getTargetSetUnlock() {
        HashSet<String> hashSet = this.targetSet;
        if (hashSet == null) {
            return new HashSet();
        }
        return new HashSet(hashSet);
    }

    protected void clearTargetUnlock() {
        HashSet<String> hashSet = this.targetSet;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int countTargetUnlock() {
        HashSet<String> hashSet = this.targetSet;
        if (hashSet == null) {
            return 0;
        }
        return hashSet.size();
    }

    @Override // java.lang.Comparable
    public int compareTo(BindInfo bindInfo) {
        return hashCode() - bindInfo.hashCode();
    }

    public int hashCode() {
        int hashCode;
        rlock();
        Object obj = this.cProxyInst;
        if (obj != null) {
            hashCode = obj.hashCode();
        } else {
            hashCode = super.hashCode();
        }
        runlock();
        return hashCode;
    }

    public boolean equals(Object obj) {
        boolean equals;
        Object obj2;
        if (obj != null && (obj instanceof BindInfo)) {
            BindInfo bindInfo = (BindInfo) obj;
            rlock();
            bindInfo.rlock();
            Object obj3 = this.cProxyInst;
            if (obj3 != null && (obj2 = bindInfo.cProxyInst) != null) {
                equals = obj3.equals(obj2);
            } else {
                equals = super.equals(obj);
            }
            runlock();
            bindInfo.runlock();
            return equals;
        }
        return super.equals(obj);
    }

    public BindInfo(BindTable bindTable, Class cls, Object obj, Object obj2, boolean z) {
        this.ownerTable = bindTable;
        this.jTypeInfo = new JType(cls, obj);
        this.cProxyInst = obj2;
        this.holdByC = z;
    }

    public JType getJType() {
        return this.jTypeInfo;
    }

    public Object getJTypeInst() {
        JType jType = this.jTypeInfo;
        if (jType != null) {
            return jType.getInst();
        }
        DebugTool.e("BindInfo.getJTypeInst = null, isRecycled = %b, ownerPackage = %s", Boolean.valueOf(isRecycled()), ReflexTool.PN(getOwnerTable().getOwnerCls()));
        return null;
    }

    public Object getCProxy() {
        return this.cProxyInst;
    }

    public BindTable getOwnerTable() {
        return this.ownerTable;
    }

    public boolean addTarget(String str) {
        wlock();
        boolean addTargetUnlock = addTargetUnlock(str);
        wunlock();
        return addTargetUnlock;
    }

    public boolean removeTarget(String str) {
        wlock();
        boolean removeTargetUnlock = removeTargetUnlock(str);
        wunlock();
        return removeTargetUnlock;
    }

    public Set<String> getTargetSet() {
        rlock();
        Set<String> targetSetUnlock = getTargetSetUnlock();
        runlock();
        return targetSetUnlock;
    }

    public void clearTarget() {
        wlock();
        clearTargetUnlock();
        wunlock();
    }

    public int countTarget() {
        rlock();
        int countTargetUnlock = countTargetUnlock();
        runlock();
        return countTargetUnlock;
    }

    public void delete(boolean z, boolean z2) {
        Object obj = this.cProxyInst;
        if (!isRecycled()) {
            DebugTool.e("BindInfo.delete isRecycled = false, ownerPackage = %s", ReflexTool.PN(getOwnerTable().getOwnerCls()));
        }
        if (z) {
            wlock();
        }
        JType jType = this.jTypeInfo;
        if (jType != null && this.cProxyInst != null) {
            if (jType.getBuildType() == BuildType.JINTF) {
                ReflexTool.invokeDeclMethodSafe(this.cProxyInst, RequestParameters.SUBRESOURCE_DELETE, null, null);
            }
            this.cProxyInst = null;
            this.jTypeInfo = null;
        } else {
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(this.jTypeInfo == null);
            objArr[1] = Boolean.valueOf(this.cProxyInst == null);
            objArr[2] = Boolean.valueOf(isRecycled());
            objArr[3] = ReflexTool.PN(getOwnerTable().getOwnerCls());
            DebugTool.e("BindInfo.delete jTypeInfo is null = %b, cProxyInst is null = %b, isRecycled = %b, ownerPackage = %s", objArr);
        }
        if (z2) {
            wunlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void destructJTypeInst(boolean r5, boolean r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L5
            r4.wlock()
        L5:
            com.autonavi.auto.intfauto.JType r5 = r4.jTypeInfo
            r0 = 0
            if (r5 == 0) goto L21
            java.lang.Object r1 = r4.cProxyInst
            if (r1 == 0) goto L21
            com.autonavi.auto.intfauto.BuildType r5 = r5.getBuildType()
            com.autonavi.auto.intfauto.BuildType r1 = com.autonavi.auto.intfauto.BuildType.JCTRL
            if (r5 == r1) goto L1a
            com.autonavi.auto.intfauto.BuildType r1 = com.autonavi.auto.intfauto.BuildType.JOBIMPL
            if (r5 != r1) goto L5d
        L1a:
            com.autonavi.auto.intfauto.JType r5 = r4.jTypeInfo
            java.lang.Object r5 = r5.getInst()
            goto L5e
        L21:
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.autonavi.auto.intfauto.JType r1 = r4.jTypeInfo
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L2c
            r1 = r2
            goto L2d
        L2c:
            r1 = r3
        L2d:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r5[r3] = r1
            java.lang.Object r1 = r4.cProxyInst
            if (r1 != 0) goto L38
            r3 = r2
        L38:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
            r5[r2] = r1
            r1 = 2
            boolean r2 = r4.isRecycled()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r5[r1] = r2
            r1 = 3
            com.autonavi.auto.intfauto.BindTable r2 = r4.getOwnerTable()
            java.lang.Class r2 = r2.getOwnerCls()
            java.lang.String r2 = com.autonavi.auto.intfauto.ReflexTool.PN(r2)
            r5[r1] = r2
            java.lang.String r1 = "BindInfo.destructJTypeInst jTypeInfo is null = %b, cProxyInst is null = %b, isRecycled = %b, ownerPackage = %s"
            com.autonavi.auto.intfauto.DebugTool.e(r1, r5)
        L5d:
            r5 = r0
        L5e:
            if (r6 == 0) goto L63
            r4.wunlock()
        L63:
            if (r5 == 0) goto L6a
            java.lang.String r6 = "delete"
            com.autonavi.auto.intfauto.ReflexTool.invokeMethodSafe(r5, r6, r0, r0)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.auto.intfauto.BindInfo.destructJTypeInst(boolean, boolean):void");
    }

    public boolean isRecycled() {
        return this.targetSet == null;
    }

    public Set<String> unbind(boolean z, boolean z2) {
        if (z) {
            wlock();
        }
        Set<String> targetSetUnlock = getTargetSetUnlock();
        this.targetSet = null;
        if (z2) {
            wunlock();
        }
        return targetSetUnlock;
    }

    public boolean unbind(String str, boolean z, boolean z2) {
        if (z) {
            wlock();
        }
        boolean removeTargetUnlock = removeTargetUnlock(str);
        if (countTargetUnlock() == 0) {
            this.targetSet = null;
        }
        if (z2) {
            wunlock();
        }
        return removeTargetUnlock;
    }
}
