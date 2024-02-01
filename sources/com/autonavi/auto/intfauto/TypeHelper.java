package com.autonavi.auto.intfauto;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public class TypeHelper {
    private String targetId;
    private HashSet<Class> transferTypeSet;
    private ReentrantReadWriteLock transferTypeSetLock;
    private static HashMap<Class, ArrayList<Class>> nearestUpcastTypeTable = new HashMap<>();
    private static ReentrantReadWriteLock nearestUpcastTypeTableLock = new ReentrantReadWriteLock();
    private static HashMap<Class, Class> headSuperClassTable = new HashMap<>();
    private static ReentrantReadWriteLock headSuperClassTableLock = new ReentrantReadWriteLock();

    public TypeHelper(Class cls) {
        this(ReflexTool.PN(cls));
    }

    public TypeHelper(String str) {
        this.transferTypeSet = new HashSet<>();
        this.transferTypeSetLock = new ReentrantReadWriteLock();
        this.targetId = str;
    }

    private void wlockTransferTypeSet() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.transferTypeSetLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().lock();
        }
    }

    private void wunlockTransferTypeSet() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.transferTypeSetLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    private void rlockTransferTypeSet() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.transferTypeSetLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().lock();
        }
    }

    private void runlockTransferTypeSet() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.transferTypeSetLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    private void setTransferType(Class cls) {
        if (this.transferTypeSet != null) {
            wlockTransferTypeSet();
            this.transferTypeSet.add(cls);
            wunlockTransferTypeSet();
        }
    }

    private static void wlockHeadSuperClassTable() {
        ReentrantReadWriteLock reentrantReadWriteLock = headSuperClassTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().lock();
        }
    }

    private static void wunlockHeadSuperClassTable() {
        ReentrantReadWriteLock reentrantReadWriteLock = headSuperClassTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    private static void rlockHeadSuperClassTable() {
        ReentrantReadWriteLock reentrantReadWriteLock = headSuperClassTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().lock();
        }
    }

    private static void runlockHeadSuperClassTable() {
        ReentrantReadWriteLock reentrantReadWriteLock = headSuperClassTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    private static Class getHeadSuperIntfAutoClass(Class cls) {
        rlockHeadSuperClassTable();
        HashMap<Class, Class> hashMap = headSuperClassTable;
        Class cls2 = hashMap != null ? hashMap.get(cls) : null;
        runlockHeadSuperClassTable();
        if (cls2 == null) {
            Class headSuperIntfAutoClass = TypeUtil.getHeadSuperIntfAutoClass(cls);
            setHeadSuperClass(cls, headSuperIntfAutoClass);
            return headSuperIntfAutoClass;
        }
        return cls2;
    }

    private static void setHeadSuperClass(Class cls, Class cls2) {
        wlockHeadSuperClassTable();
        HashMap<Class, Class> hashMap = headSuperClassTable;
        if (hashMap != null) {
            hashMap.put(cls, cls2);
        }
        wunlockHeadSuperClassTable();
    }

    private static void wlockNearestUpcastTypeTable() {
        ReentrantReadWriteLock reentrantReadWriteLock = nearestUpcastTypeTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().lock();
        }
    }

    private static void wunlockNearestUpcastTypeTable() {
        ReentrantReadWriteLock reentrantReadWriteLock = nearestUpcastTypeTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    private static void rlockNearestUpcastTypeTable() {
        ReentrantReadWriteLock reentrantReadWriteLock = nearestUpcastTypeTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().lock();
        }
    }

    private static void runlockNearestUpcastTypeTable() {
        ReentrantReadWriteLock reentrantReadWriteLock = nearestUpcastTypeTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    private static ArrayList<Class> getNearestUpcastTypeList(Class cls) {
        rlockNearestUpcastTypeTable();
        HashMap<Class, ArrayList<Class>> hashMap = nearestUpcastTypeTable;
        ArrayList<Class> arrayList = hashMap != null ? hashMap.get(cls) : null;
        runlockNearestUpcastTypeTable();
        return arrayList;
    }

    private static void setNearestUpcastTypeList(Class cls, ArrayList<Class> arrayList) {
        wlockNearestUpcastTypeTable();
        HashMap<Class, ArrayList<Class>> hashMap = nearestUpcastTypeTable;
        if (hashMap != null) {
            hashMap.put(cls, arrayList);
        }
        wunlockNearestUpcastTypeTable();
    }

    private static HashMap<Class, Integer> countUpcastTypeInDegree(Class cls) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        HashMap<Class, Integer> hashMap = new HashMap<>();
        do {
            boolean isIntfAutoType = TypeUtil.isIntfAutoType(cls);
            ArrayList<Class> arrayList = new ArrayList(Arrays.asList(cls.getInterfaces()));
            Class superclass = cls.getSuperclass();
            if (superclass != null) {
                arrayList.add(superclass);
            }
            for (Class cls2 : arrayList) {
                boolean isIntfAutoType2 = TypeUtil.isIntfAutoType(cls2);
                Integer num = null;
                if (hashSet.add(cls2)) {
                    linkedList.offer(cls2);
                    if (isIntfAutoType2) {
                        num = new Integer(0);
                    }
                }
                if (isIntfAutoType2) {
                    if (num == null) {
                        num = hashMap.get(cls2);
                    }
                    hashMap.put(cls2, Integer.valueOf(num.intValue() + (isIntfAutoType ? 1 : 0)));
                }
            }
            cls = (Class) linkedList.poll();
        } while (cls != null);
        return hashMap;
    }

    private static ArrayList<Class> calcNearestUpcastType(Class cls) {
        ArrayList<Class> nearestUpcastTypeList = getNearestUpcastTypeList(cls);
        if (nearestUpcastTypeList == null) {
            HashMap<Class, Integer> countUpcastTypeInDegree = countUpcastTypeInDegree(cls);
            ArrayList<Class> arrayList = new ArrayList<>();
            for (Map.Entry<Class, Integer> entry : countUpcastTypeInDegree.entrySet()) {
                Class key = entry.getKey();
                if (entry.getValue().intValue() == 0) {
                    if (key.isInterface()) {
                        arrayList.add(key);
                    } else {
                        arrayList.add(0, key);
                    }
                }
            }
            setNearestUpcastTypeList(cls, arrayList);
            return arrayList;
        }
        return nearestUpcastTypeList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Class getUpcastType(Class cls, Object obj, boolean z) {
        Class<?> cls2 = obj.getClass();
        if (TypeUtil.isIntfAutoType(cls2)) {
            return cls2;
        }
        ArrayList<Class> calcNearestUpcastType = calcNearestUpcastType(cls2);
        if (z) {
            cls = TypeUtil.getIntfAutoTarget(cls);
        }
        Iterator<Class> it = calcNearestUpcastType.iterator();
        while (it.hasNext()) {
            Class next = it.next();
            if (cls.isAssignableFrom(next)) {
                return next;
            }
        }
        return null;
    }

    private static BindTable getBindTable(Class cls) {
        if (cls != null) {
            if (!TypeUtil.isCProxyType(cls)) {
                cls = TypeUtil.getIntfAutoTarget(cls);
            }
            return TypeUtil.getBindTable(cls);
        }
        return null;
    }

    private static Object invokeMethod(Object obj, String str, Class[] clsArr, Object[] objArr) {
        if (obj == null) {
            obj = TypeHelper.class;
        }
        try {
            return ReflexTool.invokeMethod(obj, str, clsArr, objArr);
        } catch (Exception e) {
            DebugTool.e("TypeHelper.invokeMethod(%s) message=%s", str, e.getMessage());
            DebugTool.printStackTrace(e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r6 != 5) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object transfer(java.lang.Class r6, java.lang.Object r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L4c
            com.autonavi.auto.intfauto.IntfAuto r1 = com.autonavi.auto.intfauto.TypeUtil.getIntfAuto(r6)
            com.autonavi.auto.intfauto.BuildType r2 = r1.type()
            com.autonavi.auto.intfauto.BindTable r3 = getBindTable(r6)
            if (r3 == 0) goto L4c
            java.lang.Class r6 = getHeadSuperIntfAutoClass(r6)
            r5.setTransferType(r6)
            int[] r6 = com.autonavi.auto.intfauto.TypeHelper.AnonymousClass1.$SwitchMap$com$autonavi$auto$intfauto$BuildType
            int r4 = r2.ordinal()
            r6 = r6[r4]
            r4 = 1
            if (r6 == r4) goto L3b
            r1 = 2
            if (r6 == r1) goto L45
            r1 = 3
            if (r6 == r1) goto L30
            r1 = 4
            if (r6 == r1) goto L34
            r1 = 5
            if (r6 == r1) goto L34
            goto L4c
        L30:
            com.autonavi.auto.intfauto.BindTable r3 = r3.getSuperTable()
        L34:
            java.lang.String r6 = r5.targetId
            java.lang.Object r6 = r3.toCProxy(r6, r7, r2)
            return r6
        L3b:
            boolean r6 = r1.enableCRfx()
            if (r6 == 0) goto L45
            java.lang.Class r0 = r1.protoOfCRfx()
        L45:
            java.lang.String r6 = r5.targetId
            java.lang.Object r6 = r3.toJType(r6, r7, r2, r0)
            return r6
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.auto.intfauto.TypeHelper.transfer(java.lang.Class, java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.autonavi.auto.intfauto.TypeHelper$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$autonavi$auto$intfauto$BuildType = new int[BuildType.values().length];

        static {
            try {
                $SwitchMap$com$autonavi$auto$intfauto$BuildType[BuildType.CPROXY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$autonavi$auto$intfauto$BuildType[BuildType.JROUTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$autonavi$auto$intfauto$BuildType[BuildType.JOBIMPL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$autonavi$auto$intfauto$BuildType[BuildType.JINTF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$autonavi$auto$intfauto$BuildType[BuildType.JCTRL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public Object transfer(Method method, int i, Object obj, boolean z) {
        return transfer(ReflexTool.TN(method, i), obj, z);
    }

    public Object transfer(Constructor constructor, int i, Object obj, boolean z) {
        return transfer(ReflexTool.TN(constructor, i), obj, z);
    }

    public Object transfer(String str, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        Class realClass = TypeUtil.getRealClass(str);
        if (!TypeUtil.isIntfAutoType(realClass)) {
            return invokeMethod(this, "transfer", new Class[]{String.class, realClass, Boolean.TYPE}, new Object[]{str, obj, Boolean.valueOf(z)});
        }
        return transfer(getUpcastType(realClass, obj, z), obj);
    }

    public Object transfer(Method method, int i, Object obj) {
        return transfer(ReflexTool.TN(method, i), obj, false);
    }

    public Object transfer(Constructor constructor, int i, Object obj) {
        return transfer(ReflexTool.TN(constructor, i), obj, false);
    }

    public Object transfer(String str, Object obj) {
        return transfer(str, obj, false);
    }

    public Object transfer(Method method, int i, ArrayList arrayList, boolean z) {
        return transfer(ReflexTool.TN(method, i), arrayList, z);
    }

    public Object transfer(Constructor constructor, int i, ArrayList arrayList, boolean z) {
        return transfer(ReflexTool.TN(constructor, i), arrayList, z);
    }

    public ArrayList transfer(String str, ArrayList arrayList, boolean z) {
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        String subTypeName = TypeUtil.getSubTypeName(str);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            arrayList2.add(next != null ? transfer(subTypeName, next, z) : null);
        }
        return arrayList2;
    }

    public Object transfer(Method method, int i, ArrayList arrayList) {
        return transfer(ReflexTool.TN(method, i), arrayList, false);
    }

    public Object transfer(Constructor constructor, int i, ArrayList arrayList) {
        return transfer(ReflexTool.TN(constructor, i), arrayList, false);
    }

    public ArrayList transfer(String str, ArrayList arrayList) {
        return transfer(str, arrayList, false);
    }

    public Object transfer(Method method, int i, Object[] objArr, boolean z) {
        return transfer(ReflexTool.TN(method, i), objArr, z);
    }

    public Object transfer(Constructor constructor, int i, Object[] objArr, boolean z) {
        return transfer(ReflexTool.TN(constructor, i), objArr, z);
    }

    public Object[] transfer(String str, Object[] objArr, boolean z) {
        if (objArr == null) {
            return null;
        }
        String subTypeName = TypeUtil.getSubTypeName(str);
        Object[] objArr2 = (Object[]) Array.newInstance(TypeUtil.getInterpretType(subTypeName, !z), objArr.length);
        if (objArr2 != null) {
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                objArr2[i] = obj != null ? transfer(subTypeName, obj, z) : null;
            }
        }
        return objArr2;
    }

    public Object transfer(Method method, int i, Object[] objArr) {
        return transfer(ReflexTool.TN(method, i), objArr, false);
    }

    public Object transfer(Constructor constructor, int i, Object[] objArr) {
        return transfer(ReflexTool.TN(constructor, i), objArr, false);
    }

    public Object[] transfer(String str, Object[] objArr) {
        return transfer(str, objArr, false);
    }

    public BindInfo bind(Class cls, Object obj, Object obj2) {
        BindTable bindTable = getBindTable(cls);
        if (bindTable != null) {
            return bindTable.bindTables(this.targetId, cls, obj, obj2, false);
        }
        return null;
    }

    public void unbind(Method method, int i, Object obj, boolean z) {
        unbind(ReflexTool.TN(method, i), obj, z);
    }

    public void unbind(Constructor constructor, int i, Object obj, boolean z) {
        unbind(ReflexTool.TN(constructor, i), obj, z);
    }

    public void unbind(String str, Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        Class realClass = TypeUtil.getRealClass(str);
        if (!TypeUtil.isIntfAutoType(realClass)) {
            invokeMethod(this, "unbind", new Class[]{String.class, realClass, Boolean.TYPE}, new Object[]{str, obj, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            realClass = TypeUtil.getIntfAutoTarget(realClass);
        }
        BindTable bindTable = getBindTable(realClass);
        if (bindTable != null) {
            if (TypeUtil.isCProxyType(realClass)) {
                bindTable.unbindByProxyWithTarget(this.targetId, obj);
            } else {
                bindTable.unbindByTypeWithTarget(this.targetId, obj);
            }
        }
    }

    public void unbind(Method method, int i, Object obj) {
        unbind(ReflexTool.TN(method, i), obj, false);
    }

    public void unbind(Constructor constructor, int i, Object obj) {
        unbind(ReflexTool.TN(constructor, i), obj, false);
    }

    public void unbind(String str, Object obj) {
        unbind(str, obj, false);
    }

    public void unbind(Method method, int i, ArrayList arrayList, boolean z) {
        unbind(ReflexTool.TN(method, i), arrayList, z);
    }

    public void unbind(Constructor constructor, int i, ArrayList arrayList, boolean z) {
        unbind(ReflexTool.TN(constructor, i), arrayList, z);
    }

    public void unbind(String str, ArrayList arrayList, boolean z) {
        if (arrayList == null) {
            return;
        }
        String subTypeName = TypeUtil.getSubTypeName(str);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                unbind(subTypeName, next, z);
            }
        }
    }

    public void unbind(Method method, int i, ArrayList arrayList) {
        unbind(ReflexTool.TN(method, i), arrayList, false);
    }

    public void unbind(Constructor constructor, int i, ArrayList arrayList) {
        unbind(ReflexTool.TN(constructor, i), arrayList, false);
    }

    public void unbind(String str, ArrayList arrayList) {
        unbind(str, arrayList, false);
    }

    public void unbind(Method method, int i, Object[] objArr, boolean z) {
        unbind(ReflexTool.TN(method, i), objArr, z);
    }

    public void unbind(Constructor constructor, int i, Object[] objArr, boolean z) {
        unbind(ReflexTool.TN(constructor, i), objArr, z);
    }

    public void unbind(String str, Object[] objArr, boolean z) {
        if (objArr == null) {
            return;
        }
        String subTypeName = TypeUtil.getSubTypeName(str);
        for (Object obj : objArr) {
            if (obj != null) {
                unbind(subTypeName, obj, z);
            }
        }
    }

    public void unbind(Method method, int i, Object[] objArr) {
        unbind(ReflexTool.TN(method, i), objArr, false);
    }

    public void unbind(Constructor constructor, int i, Object[] objArr) {
        unbind(ReflexTool.TN(constructor, i), objArr, false);
    }

    public void unbind(String str, Object[] objArr) {
        unbind(str, objArr, false);
    }

    public void unbind(String str) {
        BindTable bindTable;
        Class realClass = TypeUtil.getRealClass(TypeUtil.getSubmostTypeName(str));
        if (!TypeUtil.isIntfAutoType(realClass) || (bindTable = getBindTable(realClass)) == null) {
            return;
        }
        bindTable.unbindByTarget(this.targetId);
    }

    public static void unbindAllTarget(Method method, int i, Object obj, boolean z) {
        unbindAllTarget(ReflexTool.TN(method, i), obj, z);
    }

    public static void unbindAllTarget(Constructor constructor, int i, Object obj, boolean z) {
        unbindAllTarget(ReflexTool.TN(constructor, i), obj, z);
    }

    public static void unbindAllTarget(String str, Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        Class realClass = TypeUtil.getRealClass(str);
        if (!TypeUtil.isIntfAutoType(realClass)) {
            invokeMethod(null, "unbindAllTarget", new Class[]{String.class, realClass, Boolean.TYPE}, new Object[]{str, obj, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            realClass = TypeUtil.getIntfAutoTarget(realClass);
        }
        BindTable bindTable = getBindTable(realClass);
        if (bindTable != null) {
            if (TypeUtil.isCProxyType(realClass)) {
                bindTable.unbindByProxy(obj);
            } else {
                bindTable.unbindByType(obj);
            }
        }
    }

    public static void unbindAllTarget(Method method, int i, Object obj) {
        unbindAllTarget(ReflexTool.TN(method, i), obj, false);
    }

    public static void unbindAllTarget(Constructor constructor, int i, Object obj) {
        unbindAllTarget(ReflexTool.TN(constructor, i), obj, false);
    }

    public static void unbindAllTarget(String str, Object obj) {
        unbindAllTarget(str, obj, false);
    }

    public static void unbindAllTarget(Method method, int i, ArrayList arrayList, boolean z) {
        unbindAllTarget(ReflexTool.TN(method, i), arrayList, z);
    }

    public static void unbindAllTarget(Constructor constructor, int i, ArrayList arrayList, boolean z) {
        unbindAllTarget(ReflexTool.TN(constructor, i), arrayList, z);
    }

    public static void unbindAllTarget(String str, ArrayList arrayList, boolean z) {
        if (arrayList == null) {
            return;
        }
        String subTypeName = TypeUtil.getSubTypeName(str);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                unbindAllTarget(subTypeName, next, z);
            }
        }
    }

    public static void unbindAllTarget(Method method, int i, ArrayList arrayList) {
        unbindAllTarget(ReflexTool.TN(method, i), arrayList, false);
    }

    public static void unbindAllTarget(Constructor constructor, int i, ArrayList arrayList) {
        unbindAllTarget(ReflexTool.TN(constructor, i), arrayList, false);
    }

    public static void unbindAllTarget(String str, ArrayList arrayList) {
        unbindAllTarget(str, arrayList, false);
    }

    public static void unbindAllTarget(Method method, int i, Object[] objArr, boolean z) {
        unbindAllTarget(ReflexTool.TN(method, i), objArr, z);
    }

    public static void unbindAllTarget(Constructor constructor, int i, Object[] objArr, boolean z) {
        unbindAllTarget(ReflexTool.TN(constructor, i), objArr, z);
    }

    public static void unbindAllTarget(String str, Object[] objArr, boolean z) {
        if (objArr == null) {
            return;
        }
        String subTypeName = TypeUtil.getSubTypeName(str);
        for (Object obj : objArr) {
            if (obj != null) {
                unbindAllTarget(subTypeName, obj, z);
            }
        }
    }

    public static void unbindAllTarget(Method method, int i, Object[] objArr) {
        unbindAllTarget(ReflexTool.TN(method, i), objArr, false);
    }

    public static void unbindAllTarget(Constructor constructor, int i, Object[] objArr) {
        unbindAllTarget(ReflexTool.TN(constructor, i), objArr, false);
    }

    public static void unbindAllTarget(String str, Object[] objArr) {
        unbindAllTarget(str, objArr, false);
    }

    public Set getBindSet(Method method, int i, boolean z) {
        return getBindSet(ReflexTool.TN(method, i), z);
    }

    public Set getBindSet(Constructor constructor, int i, boolean z) {
        return getBindSet(ReflexTool.TN(constructor, i), z);
    }

    public Set getBindSet(String str, boolean z) {
        BindTable bindTable;
        HashSet hashSet = new HashSet();
        Class realClass = TypeUtil.getRealClass(TypeUtil.getSubmostTypeName(str));
        if (TypeUtil.isIntfAutoType(realClass) && (bindTable = getBindTable(realClass)) != null) {
            Set<BindInfo> byTarget = bindTable.getByTarget(this.targetId);
            boolean z2 = TypeUtil.isCProxyType(realClass) != z;
            for (BindInfo bindInfo : byTarget) {
                if (bindInfo != null) {
                    bindInfo.rlock();
                    if (!bindInfo.isRecycled()) {
                        if (z2) {
                            hashSet.add(bindInfo.getCProxy());
                        } else {
                            hashSet.add(bindInfo.getJType().getInst());
                        }
                    }
                    bindInfo.runlock();
                }
            }
        }
        return hashSet;
    }

    public Set getBindSet(Method method, int i) {
        return getBindSet(ReflexTool.TN(method, i), false);
    }

    public Set getBindSet(Constructor constructor, int i) {
        return getBindSet(ReflexTool.TN(constructor, i), false);
    }

    public Set getBindSet(String str) {
        return getBindSet(str, false);
    }

    public void unbindSet(Method method, int i, Set set, boolean z) {
        unbindSet(ReflexTool.TN(method, i), set, z);
    }

    public void unbindSet(Constructor constructor, int i, Set set, boolean z) {
        unbindSet(ReflexTool.TN(constructor, i), set, z);
    }

    public void unbindSet(String str, Set set, boolean z) {
        if (set == null) {
            return;
        }
        Class realClass = TypeUtil.getRealClass(TypeUtil.getSubmostTypeName(str));
        if (TypeUtil.isIntfAutoType(realClass)) {
            BindTable bindTable = getBindTable(realClass);
            boolean z2 = TypeUtil.isCProxyType(realClass) != z;
            if (bindTable != null) {
                if (z2) {
                    bindTable.unbindByProxyWithTarget(this.targetId, set);
                } else {
                    bindTable.unbindByTypeWithTarget(this.targetId, set);
                }
            }
        }
    }

    public void unbindSet(Method method, int i, Set set) {
        unbindSet(ReflexTool.TN(method, i), set, false);
    }

    public void unbindSet(Constructor constructor, int i, Set set) {
        unbindSet(ReflexTool.TN(constructor, i), set, false);
    }

    public void unbindSet(String str, Set set) {
        unbindSet(str, set, false);
    }

    public void delete() {
        rlockTransferTypeSet();
        Iterator<Class> it = this.transferTypeSet.iterator();
        while (it.hasNext()) {
            BindTable bindTable = getBindTable(it.next());
            if (bindTable != null) {
                bindTable.unbindByTarget(this.targetId);
            }
        }
        runlockTransferTypeSet();
    }
}
