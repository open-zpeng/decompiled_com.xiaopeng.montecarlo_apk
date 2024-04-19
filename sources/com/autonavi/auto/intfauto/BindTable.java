package com.autonavi.auto.intfauto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public class BindTable implements Comparable<BindTable> {
    private Class intfCls;
    private Class ownerCls;
    private BuildType ownerType;
    private Class proxyCls;
    private Class routerCls;
    private Class superCls;
    private BindTable superTable;
    private Class typeCls;
    private ReentrantReadWriteLock tableLock = new ReentrantReadWriteLock();
    private TreeMap<JType, BindInfo> jTypeTable = new TreeMap<>();
    private HashMap<Object, BindInfo> cProxyTable = new HashMap<>();
    private HashMap<String, Set<BindInfo>> targetTable = new HashMap<>();
    private ReentrantReadWriteLock subClsArrLock = new ReentrantReadWriteLock();
    private ArrayList<Class> subClsArr = new ArrayList<>();

    public BindTable getSuperTable() {
        return this.superTable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class getOwnerCls() {
        return this.ownerCls;
    }

    protected Class getProxyCls() {
        return this.proxyCls;
    }

    private void wlockSubClsArr() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.subClsArrLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().lock();
        }
    }

    private void wunlockSubClsArr() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.subClsArrLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    private void rlockSubClsArr() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.subClsArrLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().lock();
        }
    }

    private void runlockSubClsArr() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.subClsArrLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    private void addSubCls(Class cls) {
        if (this.subClsArr == null || cls == null) {
            return;
        }
        wlockSubClsArr();
        this.subClsArr.add(cls);
        wunlockSubClsArr();
        if (this.superTable != null) {
            wlock();
            this.superTable.addSubCls(cls);
            wunlock();
        }
    }

    public ArrayList<Class> getSubClsArr() {
        rlockSubClsArr();
        ArrayList<Class> arrayList = new ArrayList<>(this.subClsArr);
        runlockSubClsArr();
        return arrayList;
    }

    private void init() {
        this.ownerType = BuildType.NONE;
        this.superCls = null;
        this.superTable = null;
        this.routerCls = null;
        this.proxyCls = null;
        this.typeCls = null;
        this.intfCls = null;
        Class cls = this.ownerCls;
        if (cls != null) {
            this.ownerType = TypeUtil.getIntfAutoType(cls);
            this.superCls = TypeUtil.getSuperIntfAutoClass(this.ownerCls);
            Class cls2 = this.superCls;
            if (cls2 != null) {
                this.superTable = TypeUtil.getBindTable(cls2);
            }
            addSubCls(this.ownerCls);
            this.typeCls = TypeUtil.getIntfAutoTarget(this.ownerCls);
            if (this.ownerType == BuildType.CPROXY) {
                this.proxyCls = this.ownerCls;
                this.routerCls = TypeUtil.getIntfAutoTarget(this.typeCls);
                if (this.routerCls == this.proxyCls) {
                    this.routerCls = null;
                }
            } else {
                this.routerCls = this.ownerCls;
                this.proxyCls = this.superCls;
            }
            if (this.routerCls != null) {
                BuildType intfAutoType = TypeUtil.getIntfAutoType(this.typeCls);
                if (intfAutoType == BuildType.JINTF) {
                    this.intfCls = this.typeCls;
                } else if (intfAutoType == BuildType.JOBIMPL) {
                    this.intfCls = this.typeCls.getInterfaces()[0];
                }
            }
        }
    }

    public BindTable(Class cls) {
        this.ownerCls = cls;
        init();
    }

    @Override // java.lang.Comparable
    public int compareTo(BindTable bindTable) {
        return hashCode() - bindTable.hashCode();
    }

    public int hashCode() {
        Class cls = this.ownerCls;
        if (cls != null) {
            return cls.hashCode();
        }
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof BindTable)) {
            return this.ownerCls.equals(((BindTable) obj).ownerCls);
        }
        return super.equals(obj);
    }

    private void wlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.tableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().lock();
        }
    }

    private void wunlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.tableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    private void rlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.tableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().lock();
        }
    }

    private void runlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.tableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    private BindInfo getByTypeUnLock(Object obj) {
        if (obj != null) {
            JType jType = new JType(null, obj, true);
            rlock();
            TreeMap<JType, BindInfo> treeMap = this.jTypeTable;
            r0 = treeMap != null ? treeMap.get(jType) : null;
            runlock();
        }
        return r0;
    }

    public BindInfo getByType(Object obj) {
        return getByTypeUnLock(obj);
    }

    private BindInfo getByProxyUnLock(Object obj) {
        if (obj != null) {
            rlock();
            HashMap<Object, BindInfo> hashMap = this.cProxyTable;
            r0 = hashMap != null ? hashMap.get(obj) : null;
            runlock();
        }
        return r0;
    }

    public BindInfo getByProxy(Object obj) {
        return getByProxyUnLock(obj);
    }

    private Set<BindInfo> getByTargetUnLock(String str) {
        if (str != null) {
            rlock();
            HashMap<String, Set<BindInfo>> hashMap = this.targetTable;
            Set<BindInfo> set = hashMap != null ? hashMap.get(str) : null;
            runlock();
            if (set != null) {
                return new TreeSet(set);
            }
        }
        return new TreeSet();
    }

    public Set<BindInfo> getByTarget(String str) {
        return getByTargetUnLock(str);
    }

    private boolean addTypeUnLock(BindInfo bindInfo) {
        if (bindInfo != null) {
            JType jType = bindInfo.getJType();
            wlock();
            TreeMap<JType, BindInfo> treeMap = this.jTypeTable;
            if (treeMap != null) {
                treeMap.put(jType, bindInfo);
            }
            wunlock();
            return true;
        }
        return false;
    }

    private boolean addProxyUnLock(BindInfo bindInfo) {
        if (bindInfo != null) {
            Object cProxy = bindInfo.getCProxy();
            wlock();
            HashMap<Object, BindInfo> hashMap = this.cProxyTable;
            if (hashMap != null) {
                hashMap.put(cProxy, bindInfo);
            }
            wunlock();
            return true;
        }
        return false;
    }

    private boolean addTargetUnLock(String str, BindInfo bindInfo) {
        if (str == null || bindInfo == null || this.targetTable == null) {
            return false;
        }
        rlock();
        Set<BindInfo> set = this.targetTable.get(str);
        runlock();
        if (set == null) {
            wlock();
            set = this.targetTable.get(str);
            if (set == null) {
                set = new TreeSet<>();
                this.targetTable.put(str, set);
            }
            wunlock();
        }
        if (set != null) {
            wlock();
            boolean add = set.add(bindInfo);
            wunlock();
            return add;
        }
        return false;
    }

    private BindInfo removeTypeUnLock(JType jType) {
        if (jType != null) {
            wlock();
            TreeMap<JType, BindInfo> treeMap = this.jTypeTable;
            r0 = treeMap != null ? treeMap.remove(jType) : null;
            wunlock();
        }
        return r0;
    }

    private BindInfo removeProxyUnLock(Object obj) {
        if (obj != null) {
            wlock();
            HashMap<Object, BindInfo> hashMap = this.cProxyTable;
            r0 = hashMap != null ? hashMap.remove(obj) : null;
            wunlock();
        }
        return r0;
    }

    private boolean removeTargetUnLock(String str, BindInfo bindInfo, boolean z, boolean z2) {
        boolean z3 = false;
        if (str != null && bindInfo != null) {
            rlock();
            HashMap<String, Set<BindInfo>> hashMap = this.targetTable;
            Set<BindInfo> set = hashMap != null ? hashMap.get(str) : null;
            runlock();
            if (z) {
                wlock();
            }
            if (set != null) {
                z3 = set.remove(bindInfo);
                if (set.size() == 0) {
                    this.targetTable.remove(str);
                }
            }
            if (z2) {
                wunlock();
            }
        }
        return z3;
    }

    private void updateTables(String str, BindInfo bindInfo, boolean z, boolean z2, boolean z3) {
        if (bindInfo == null) {
            return;
        }
        if (z && bindInfo != null) {
            addTypeUnLock(bindInfo);
            addProxyUnLock(bindInfo);
        }
        boolean addTargetUnLock = addTargetUnLock(str, bindInfo);
        if (z2) {
            wlock();
        }
        if (this.superTable != null && (z || addTargetUnLock)) {
            this.superTable.updateTables(str, bindInfo, z, true, true);
        }
        if (z3) {
            wunlock();
        }
    }

    private void removeTables(Set<String> set, BindInfo bindInfo, boolean z, boolean z2, boolean z3) {
        if (bindInfo == null || set == null) {
            return;
        }
        if (z && bindInfo != null) {
            removeTypeUnLock(bindInfo.getJType());
            removeProxyUnLock(bindInfo.getCProxy());
        }
        boolean z4 = false;
        for (String str : set) {
            if (removeTargetUnLock(str, bindInfo, z2, z3)) {
                z4 = true;
            }
        }
        if (z2) {
            wlock();
        }
        if (this.superTable != null && (z || z4)) {
            this.superTable.removeTables(set, bindInfo, z, true, true);
        }
        if (z3) {
            wunlock();
        }
    }

    private void removeTables(String str, Map<BindInfo, Boolean> map, boolean z, boolean z2) {
        if (map == null || map.size() == 0) {
            return;
        }
        boolean z3 = false;
        boolean z4 = false;
        for (Map.Entry<BindInfo, Boolean> entry : map.entrySet()) {
            if (entry != null) {
                BindInfo key = entry.getKey();
                boolean booleanValue = entry.getValue().booleanValue();
                if (key != null) {
                    if (booleanValue) {
                        removeTypeUnLock(key.getJType());
                        removeProxyUnLock(key.getCProxy());
                        z3 = true;
                    }
                    if (removeTargetUnLock(str, key, z, z2)) {
                        z4 = true;
                    }
                }
            }
        }
        if (z) {
            wlock();
        }
        if (this.superTable != null && (z3 || z4)) {
            this.superTable.removeTables(str, map, true, true);
        }
        if (z2) {
            wunlock();
        }
    }

    private static void unbindImpl(BindInfo bindInfo, boolean z, boolean z2) {
        BindTable ownerTable;
        if (bindInfo == null || (ownerTable = bindInfo.getOwnerTable()) == null) {
            return;
        }
        if (z) {
            bindInfo.wlock();
        }
        if (!bindInfo.isRecycled()) {
            Set<String> unbind = bindInfo.unbind(false, false);
            if (z2) {
                bindInfo.wunlock();
            }
            ownerTable.removeTables(unbind, bindInfo, true, true, true);
            if (z) {
                bindInfo.wlock();
            }
            bindInfo.delete(false, false);
        }
        if (z2) {
            bindInfo.wunlock();
        }
    }

    private static void unbindImpl(String str, BindInfo bindInfo, boolean z, boolean z2) {
        BindTable ownerTable;
        if (str == null || bindInfo == null || (ownerTable = bindInfo.getOwnerTable()) == null) {
            return;
        }
        if (z) {
            bindInfo.wlock();
        }
        if (!bindInfo.isRecycled() && bindInfo.unbind(str, false, false)) {
            int countTargetUnlock = bindInfo.countTargetUnlock();
            TreeSet treeSet = new TreeSet();
            treeSet.add(str);
            if (z2) {
                bindInfo.wunlock();
            }
            ownerTable.removeTables(treeSet, bindInfo, countTargetUnlock == 0, true, true);
            if (z) {
                bindInfo.wlock();
            }
            if (countTargetUnlock == 0) {
                bindInfo.delete(false, false);
            }
        }
        if (z2) {
            bindInfo.wunlock();
        }
    }

    private static void unbindImpl(String str, Set<BindInfo> set, boolean z, boolean z2) {
        BindTable ownerTable;
        if (str == null || set == null || set.size() <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        Iterator<BindInfo> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BindInfo next = it.next();
            if (next != null && (ownerTable = next.getOwnerTable()) != null) {
                if (z) {
                    next.wlock();
                }
                boolean unbind = !next.isRecycled() ? next.unbind(str, false, false) : false;
                if (z2) {
                    next.wunlock();
                }
                if (unbind) {
                    Map map = (Map) treeMap.get(ownerTable);
                    if (map == null) {
                        map = new TreeMap();
                        treeMap.put(ownerTable, map);
                    }
                    map.put(next, Boolean.valueOf(next.countTargetUnlock() == 0));
                }
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            BindTable bindTable = (BindTable) entry.getKey();
            Map<BindInfo, Boolean> map2 = (Map) entry.getValue();
            if (bindTable != null && map2 != null) {
                bindTable.removeTables(str, map2, true, true);
                for (Map.Entry<BindInfo, Boolean> entry2 : map2.entrySet()) {
                    if (entry2 != null) {
                        BindInfo key = entry2.getKey();
                        boolean booleanValue = entry2.getValue().booleanValue();
                        if (key != null) {
                            if (z) {
                                key.wlock();
                            }
                            if (booleanValue) {
                                key.delete(false, false);
                            }
                            if (z2) {
                                key.wunlock();
                            }
                        }
                    }
                }
            }
        }
    }

    public BindInfo unbindByType(Object obj) {
        BindInfo byType = getByType(obj);
        unbindImpl(byType, true, true);
        return byType;
    }

    public BindInfo unbindByProxy(Object obj) {
        BindInfo byProxy = getByProxy(obj);
        unbindImpl(byProxy, true, true);
        return byProxy;
    }

    public BindInfo unbindByTypeWithTarget(String str, Object obj) {
        BindInfo byType = getByType(obj);
        unbindImpl(str, byType, true, true);
        return byType;
    }

    public BindInfo unbindByProxyWithTarget(String str, Object obj) {
        BindInfo byProxy = getByProxy(obj);
        unbindImpl(str, byProxy, true, true);
        return byProxy;
    }

    public Set<BindInfo> unbindByTypeWithTarget(String str, Set set) {
        TreeSet treeSet = new TreeSet();
        for (Object obj : set) {
            treeSet.add(getByTypeUnLock(obj));
        }
        unbindImpl(str, (Set<BindInfo>) treeSet, true, true);
        return treeSet;
    }

    public Set<BindInfo> unbindByProxyWithTarget(String str, Set set) {
        TreeSet treeSet = new TreeSet();
        for (Object obj : set) {
            treeSet.add(getByProxyUnLock(obj));
        }
        unbindImpl(str, (Set<BindInfo>) treeSet, true, true);
        return treeSet;
    }

    public Set<BindInfo> unbindByTarget(String str) {
        Set<BindInfo> byTarget = getByTarget(str);
        unbindImpl(str, byTarget, true, true);
        return byTarget;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.autonavi.auto.intfauto.BindInfo bindTables(java.lang.String r10, java.lang.Object r11, java.lang.Object r12, boolean r13) {
        /*
            r9 = this;
            r2 = 1
            r3 = 0
            if (r13 == 0) goto L21
            com.autonavi.auto.intfauto.BindInfo r4 = r9.getByProxyUnLock(r12)
            if (r4 == 0) goto Lc
            r5 = r2
            goto Ld
        Lc:
            r5 = r3
        Ld:
            if (r5 != 0) goto L47
            java.lang.Class r0 = r9.typeCls
            java.lang.Class[] r6 = new java.lang.Class[r2]
            java.lang.Class r7 = r9.proxyCls
            r6[r3] = r7
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r12
            java.lang.Object r0 = com.autonavi.auto.intfauto.ReflexTool.invokeDeclConstructorSafe(r0, r6, r2)
            r3 = r0
            goto L48
        L21:
            com.autonavi.auto.intfauto.BindInfo r4 = r9.getByTypeUnLock(r11)
            if (r4 == 0) goto L29
            r5 = r2
            goto L2a
        L29:
            r5 = r3
        L2a:
            if (r5 != 0) goto L47
            java.lang.Class r1 = r9.routerCls
            r6 = 2
            java.lang.Class[] r7 = new java.lang.Class[r6]
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r3] = r8
            java.lang.Class r8 = r9.intfCls
            r7[r2] = r8
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r3] = r10
            r6[r2] = r11
            java.lang.Object r1 = com.autonavi.auto.intfauto.ReflexTool.invokeDeclConstructorSafe(r1, r7, r6)
            r3 = r11
            r0 = r4
            r4 = r1
            goto L4a
        L47:
            r3 = r11
        L48:
            r0 = r4
            r4 = r12
        L4a:
            if (r5 != 0) goto L57
            java.lang.Class r2 = r9.typeCls
            r6 = 0
            r7 = 0
            r0 = r9
            r1 = r10
            r5 = r13
            com.autonavi.auto.intfauto.BindInfo r0 = r0.bindTables(r1, r2, r3, r4, r5, r6, r7)
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.auto.intfauto.BindTable.bindTables(java.lang.String, java.lang.Object, java.lang.Object, boolean):com.autonavi.auto.intfauto.BindInfo");
    }

    private static void updateBindInfo(String str, BindInfo bindInfo, boolean z, boolean z2, boolean z3) {
        BindTable ownerTable;
        if (str == null || bindInfo == null) {
            return;
        }
        bindInfo.wlock();
        if (!bindInfo.isRecycled() && (ownerTable = bindInfo.getOwnerTable()) != null && bindInfo.addTargetUnlock(str)) {
            bindInfo.wunlock();
            ownerTable.updateTables(str, bindInfo, z, z2, z3);
            bindInfo.wlock();
        }
        bindInfo.wunlock();
    }

    private BindInfo bindTables(String str, Class cls, Object obj, Object obj2, boolean z, boolean z2, boolean z3) {
        BindInfo bindInfo = new BindInfo(this, cls, obj, obj2, z);
        updateBindInfo(str, bindInfo, true, z2, z3);
        return bindInfo;
    }

    public BindInfo bindTables(String str, Class cls, Object obj, Object obj2, boolean z) {
        return bindTables(str, this.typeCls, obj, obj2, z, true, true);
    }

    public Object toJType(String str, Object obj, BuildType buildType, Class cls) {
        Object obj2;
        BindTable bindTable;
        BindInfo byProxy = getByProxy(obj);
        if (byProxy == null) {
            if (cls != null) {
                Object[] downcastingImpl = CRfxManager.downcastingImpl(cls, this.ownerCls, obj);
                Class cls2 = (Class) downcastingImpl[0];
                obj2 = downcastingImpl[1];
                if (obj2 != obj) {
                    bindTable = TypeUtil.getBindTable(cls2);
                    byProxy = bindTable.bindTables(str, null, obj2, true);
                }
            }
            obj2 = obj;
            bindTable = this;
            byProxy = bindTable.bindTables(str, null, obj2, true);
        } else {
            updateBindInfo(str, byProxy, false, true, true);
        }
        if (byProxy != null) {
            byProxy.rlock();
            r0 = byProxy.isRecycled() ? null : byProxy.getJTypeInst();
            byProxy.runlock();
        }
        return r0;
    }

    public Object toCProxy(String str, Object obj, BuildType buildType) {
        BindInfo byType = getByType(obj);
        if (byType == null) {
            byType = bindTables(str, obj, null, false);
        } else {
            updateBindInfo(str, byType, false, true, true);
        }
        if (byType != null) {
            byType.rlock();
            r0 = byType.isRecycled() ? null : byType.getCProxy();
            byType.runlock();
        }
        return r0;
    }
}
