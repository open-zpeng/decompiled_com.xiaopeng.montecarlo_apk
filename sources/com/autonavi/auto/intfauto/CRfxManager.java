package com.autonavi.auto.intfauto;

import com.autonavi.gbl.util.ObjLifeStateDispatcher;
import com.autonavi.gbl.util.model.ObjLifeState;
import com.autonavi.gbl.util.observer.IObjLifeStateObserver;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public class CRfxManager {
    private static HashMap<String, Class> realTypeTable = new HashMap<>();
    private static ReentrantReadWriteLock realTypeTableLock = new ReentrantReadWriteLock();
    private static CRfxLifeStateTracker lifeStateTracker = new CRfxLifeStateTracker();

    static {
        ObjLifeStateDispatcher.getInstance().addObserver(lifeStateTracker);
    }

    /* loaded from: classes.dex */
    private static class CRfxLifeStateTracker implements IObjLifeStateObserver {
        private CRfxLifeStateTracker() {
        }

        public static Object reflectCProxyInst(Class cls, long j) {
            if (cls != null) {
                return ReflexTool.invokeDeclConstructorSafe(cls, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), false});
            }
            return null;
        }

        public static void syncDestructAction(String str, long j) {
            Object reflectCProxyInst;
            BindTable bindTable;
            BindInfo byProxy;
            int indexOf;
            int i;
            int length;
            Class realType = CRfxManager.getRealType(str);
            if (realType == null && (indexOf = str.indexOf("SwigDirector_")) >= 0 && (i = indexOf + 13) < str.length() - 4) {
                String substring = str.substring(i, length);
                realType = CRfxManager.getRealType("N2bl" + substring.length() + substring + ICarService.CAR_STAGE_E);
            }
            if (realType == null || (reflectCProxyInst = reflectCProxyInst(realType, j)) == null || (bindTable = TypeUtil.getBindTable(realType)) == null || (byProxy = bindTable.getByProxy(reflectCProxyInst)) == null) {
                return;
            }
            DebugTool.i("CRfxLifeStateTracker.syncDestructAction(%s, %d) invoke del", str, Long.valueOf(j));
            byProxy.destructJTypeInst(true, true);
        }

        @Override // com.autonavi.gbl.util.observer.IObjLifeStateObserver
        public void inProgress(@ObjLifeState.ObjLifeState1 int i, long j, String str) {
            if (i == 0 || i == 1 || i != 2) {
                return;
            }
            syncDestructAction(str, j);
        }
    }

    private static void wlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = realTypeTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().lock();
        }
    }

    private static void wunlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = realTypeTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    private static void rlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = realTypeTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().lock();
        }
    }

    private static void runlock() {
        ReentrantReadWriteLock reentrantReadWriteLock = realTypeTableLock;
        if (reentrantReadWriteLock != null) {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    private static Class getRealTypeUnlock(String str) {
        HashMap<String, Class> hashMap = realTypeTable;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class getRealType(String str) {
        rlock();
        Class realTypeUnlock = getRealTypeUnlock(str);
        runlock();
        return realTypeUnlock;
    }

    private static void setRealTypeUnlock(String str, Class cls) {
        HashMap<String, Class> hashMap = realTypeTable;
        if (hashMap != null) {
            hashMap.put(str, cls);
        }
    }

    private static void setRealType(String str, Class cls) {
        wlock();
        setRealTypeUnlock(str, cls);
        wunlock();
    }

    private static void updateRealTypeUnlock(Class cls, ICRfxProto iCRfxProto) {
        if (iCRfxProto == null || realTypeTable == null) {
            return;
        }
        Class[] relatedClassList = iCRfxProto.getRelatedClassList();
        if (relatedClassList != null) {
            for (Class cls2 : relatedClassList) {
                realTypeTable.put(iCRfxProto.getClassTypeId(cls2), cls2);
            }
        }
        if (cls != null) {
            realTypeTable.put(ReflexTool.PN(cls), cls);
        }
    }

    private static void updateRealType(Class cls, ICRfxProto iCRfxProto) {
        wlock();
        updateRealTypeUnlock(cls, iCRfxProto);
        wunlock();
    }

    private static boolean hashUpdateRealTypeUnlock(Class cls) {
        return (cls == null || realTypeTable == null || getRealTypeUnlock(ReflexTool.PN(cls)) == null) ? false : true;
    }

    private static boolean hashUpdateRealType(Class cls) {
        rlock();
        boolean hashUpdateRealTypeUnlock = hashUpdateRealTypeUnlock(cls);
        runlock();
        return hashUpdateRealTypeUnlock;
    }

    private static Class getRealType(Class cls, Object obj) {
        ICRfxProto iCRfxProto = (ICRfxProto) ReflexTool.invokeDeclConstructorSafe(cls, null, null);
        if (iCRfxProto == null) {
            DebugTool.e("CRfxManager.getRealType(inst package = %s) protoInst == null", ReflexTool.PN(obj.getClass()));
            return null;
        }
        String objectTypeId = iCRfxProto.getObjectTypeId(obj);
        Class realType = getRealType(objectTypeId);
        if (realType == null) {
            wlock();
            if (!hashUpdateRealTypeUnlock(cls)) {
                updateRealTypeUnlock(cls, iCRfxProto);
            }
            realType = getRealTypeUnlock(objectTypeId);
            wunlock();
        }
        if (realType == null) {
            DebugTool.e("CRfxManager.getRealType(inst id = %s) realCls == null", objectTypeId);
            setRealType(objectTypeId, obj.getClass());
        }
        return realType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object[] downcastingImpl(java.lang.Class r7, java.lang.Class r8, java.lang.Object r9) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            if (r7 == 0) goto L44
            java.lang.Class r7 = getRealType(r7, r9)
            if (r8 == 0) goto L45
            if (r7 == 0) goto L45
            boolean r3 = r7.isInstance(r9)
            if (r3 != 0) goto L45
            java.lang.Class[] r3 = new java.lang.Class[r1]
            r3[r2] = r8
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r2] = r9
            java.lang.String r5 = "getCPtr"
            java.lang.Object r3 = com.autonavi.auto.intfauto.ReflexTool.invokeDeclMethodSafe(r8, r5, r3, r4)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            java.lang.Class[] r5 = new java.lang.Class[r0]
            java.lang.Class r6 = java.lang.Long.TYPE
            r5[r2] = r6
            java.lang.Class r6 = java.lang.Boolean.TYPE
            r5[r1] = r6
            java.lang.Object[] r6 = new java.lang.Object[r0]
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r6[r2] = r3
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r6[r1] = r3
            java.lang.Object r3 = com.autonavi.auto.intfauto.ReflexTool.invokeDeclConstructorSafe(r7, r5, r6)
            goto L46
        L44:
            r7 = 0
        L45:
            r3 = r9
        L46:
            if (r7 != 0) goto L69
            if (r8 != 0) goto L52
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.String r9 = "CRfxManager.downcastingImpl targetCls == null"
            com.autonavi.auto.intfauto.DebugTool.e(r9, r8)
            goto L69
        L52:
            java.lang.Object[] r4 = new java.lang.Object[r0]
            java.lang.String r8 = com.autonavi.auto.intfauto.ReflexTool.PN(r8)
            r4[r2] = r8
            java.lang.Class r8 = r9.getClass()
            java.lang.String r8 = com.autonavi.auto.intfauto.ReflexTool.PN(r8)
            r4[r1] = r8
            java.lang.String r8 = "CRfxManager.downcastingImpl(%s, %s) realCls == null"
            com.autonavi.auto.intfauto.DebugTool.e(r8, r4)
        L69:
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r8[r2] = r7
            r8[r1] = r3
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.auto.intfauto.CRfxManager.downcastingImpl(java.lang.Class, java.lang.Class, java.lang.Object):java.lang.Object[]");
    }

    public static Object downcasting(String str, Object obj) {
        if (obj == null) {
            return null;
        }
        Class realClass = TypeUtil.getRealClass(str);
        if (!TypeUtil.isIntfAutoType(realClass)) {
            return ReflexTool.invokeMethodSafe(CRfxManager.class, "downcasting", new Class[]{String.class, realClass}, new Object[]{str, obj});
        }
        Class upcastType = TypeHelper.getUpcastType(realClass, obj, false);
        IntfAuto intfAuto = TypeUtil.getIntfAuto(upcastType);
        return intfAuto.enableCRfx() ? downcastingImpl(intfAuto.protoOfCRfx(), upcastType, obj)[1] : obj;
    }

    public static Object downcasting(Method method, int i, Object obj) {
        return downcasting(ReflexTool.TN(method, i), obj);
    }

    public static Object downcasting(Constructor constructor, int i, Object obj) {
        return downcasting(ReflexTool.TN(constructor, i), obj);
    }

    public static ArrayList downcasting(String str, ArrayList arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        String subTypeName = TypeUtil.getSubTypeName(str);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            arrayList2.add(next != null ? downcasting(subTypeName, next) : null);
        }
        return arrayList2;
    }

    public static Object downcasting(Method method, int i, ArrayList arrayList) {
        return downcasting(ReflexTool.TN(method, i), arrayList);
    }

    public static Object downcasting(Constructor constructor, int i, ArrayList arrayList) {
        return downcasting(ReflexTool.TN(constructor, i), arrayList);
    }

    public static Object[] downcasting(String str, Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        String subTypeName = TypeUtil.getSubTypeName(str);
        Object[] objArr2 = (Object[]) Array.newInstance(TypeUtil.getInterpretType(subTypeName, true), objArr.length);
        if (objArr2 != null) {
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                objArr2[i] = obj != null ? downcasting(subTypeName, obj) : null;
            }
        }
        return objArr2;
    }

    public static Object downcasting(Method method, int i, Object[] objArr) {
        return downcasting(ReflexTool.TN(method, i), objArr);
    }

    public static Object downcasting(Constructor constructor, int i, Object[] objArr) {
        return downcasting(ReflexTool.TN(constructor, i), objArr);
    }
}
