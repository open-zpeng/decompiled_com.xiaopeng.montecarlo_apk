package com.autonavi.auto.intfauto;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public class TypeUtil {
    public static Class getInterpretType(String str, boolean z) {
        if (str.lastIndexOf("[]") == str.length() - 2) {
            return Array.newInstance(getInterpretType(str.substring(0, str.length() - 2), z), 0).getClass();
        }
        Class realClass = getRealClass(str);
        return (z && isIntfAutoType(realClass)) ? getIntfAutoTarget(realClass) : realClass;
    }

    public static String getSubTypeName(String str) {
        if (str.lastIndexOf("[]") == str.length() - 2) {
            return str.substring(0, str.length() - 2);
        }
        int indexOf = str.indexOf(60);
        return indexOf >= 0 ? str.substring(indexOf + 1, str.length() - 1) : "";
    }

    public static String getRealTypeName(String str) {
        if (str.lastIndexOf("[]") == str.length() - 2) {
            return "[Ljava.lang.Object;";
        }
        int indexOf = str.indexOf(60);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    private static Class getClassByName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            DebugTool.e("TypeUtil.getClassByName(%s) message=%s", str, e.getMessage());
            DebugTool.printStackTrace(e);
            return null;
        }
    }

    public static Class getRealClass(String str) {
        return getClassByName(getRealTypeName(str));
    }

    public static String getSubmostTypeName(String str) {
        String str2 = str;
        while (!str.equals("")) {
            str2 = str;
            str = getSubTypeName(str);
        }
        return str2;
    }

    public static Class getSuperIntfAutoClass(Class cls) {
        Class superclass = cls.getSuperclass();
        if (superclass == null || !isIntfAutoType(superclass)) {
            return null;
        }
        return superclass;
    }

    public static Class getHeadSuperIntfAutoClass(Class cls) {
        Class superIntfAutoClass = getSuperIntfAutoClass(cls);
        while (true) {
            Class cls2 = superIntfAutoClass;
            Class cls3 = cls;
            cls = cls2;
            if (cls == null) {
                return cls3;
            }
            superIntfAutoClass = getSuperIntfAutoClass(cls);
        }
    }

    public static boolean isIntfAutoType(Class cls) {
        return cls.isAnnotationPresent(IntfAuto.class);
    }

    public static IntfAuto getIntfAuto(Class cls) {
        return (IntfAuto) cls.getAnnotation(IntfAuto.class);
    }

    public static Class getIntfAutoTarget(Class cls) {
        return getIntfAuto(cls).target();
    }

    public static BuildType getIntfAutoType(Class cls) {
        return getIntfAuto(cls).type();
    }

    public static boolean enableIntfAutoCRfx(Class cls) {
        return getIntfAuto(cls).enableCRfx();
    }

    public static Class getIntfAutoCRfxProtoCls(Class cls) {
        return getIntfAuto(cls).protoOfCRfx();
    }

    public static boolean isJIntfType(Class cls) {
        return isJIntfType(getIntfAutoType(cls));
    }

    public static boolean isJIntfType(BuildType buildType) {
        return buildType == BuildType.JINTF;
    }

    public static boolean isCProxyType(Class cls) {
        return isCProxyType(getIntfAutoType(cls));
    }

    public static boolean isCProxyType(BuildType buildType) {
        return buildType == BuildType.CPROXY || buildType == BuildType.JROUTER;
    }

    public static BindTable getBindTable(Class cls) {
        try {
            return (BindTable) ReflexTool.getDeclField(cls, "BIND_TABLE");
        } catch (Exception e) {
            DebugTool.e("TypeUtil.getBindTable(%s) message=%s", ReflexTool.PN(cls), e.getMessage());
            DebugTool.printStackTrace(e);
            return null;
        }
    }

    public static Object operateArray(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        int length = Array.getLength(obj);
        Class<?> componentType = obj.getClass().getComponentType();
        if (componentType.isPrimitive() || componentType == String.class) {
            return returnPrimitive(obj, length);
        }
        int i = 0;
        if (componentType.isArray()) {
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), Array.getLength(obj));
            int length2 = Array.getLength(obj);
            while (i < length2) {
                Array.set(newInstance, i, operateArray(Array.get(obj, i)));
                i++;
            }
            return newInstance;
        }
        Object newInstance2 = Array.newInstance(componentType, length);
        while (i < length) {
            Object obj2 = Array.get(obj, i);
            Object newInstance3 = obj2.getClass().newInstance();
            deepcopy(obj2, newInstance3);
            Array.set(newInstance2, i, newInstance3);
            i++;
        }
        return newInstance2;
    }

    public static Object returnPrimitive(Object obj, int i) {
        Class<?> componentType = obj.getClass().getComponentType();
        if (componentType == Integer.TYPE) {
            return Arrays.copyOf((int[]) obj, i);
        }
        if (componentType == Double.TYPE) {
            return Arrays.copyOf((double[]) obj, i);
        }
        if (componentType == Float.TYPE) {
            return Arrays.copyOf((float[]) obj, i);
        }
        if (componentType == Long.TYPE) {
            return Arrays.copyOf((int[]) obj, i);
        }
        if (componentType == Boolean.TYPE) {
            return Arrays.copyOf((boolean[]) obj, i);
        }
        if (componentType == Byte.TYPE) {
            return Arrays.copyOf((byte[]) obj, i);
        }
        if (componentType == Short.TYPE) {
            return Arrays.copyOf((short[]) obj, i);
        }
        if (componentType == Character.TYPE) {
            return Arrays.copyOf((char[]) obj, i);
        }
        if (componentType == String.class) {
            return Arrays.copyOf((String[]) obj, i);
        }
        return null;
    }

    public static void deepcopy(Object obj, Object obj2) throws Exception {
        Field[] declaredFields;
        Class<?> cls = obj.getClass();
        if (cls == ArrayList.class) {
            ArrayList arrayList = (ArrayList) obj;
            ArrayList arrayList2 = (ArrayList) obj2;
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(arrayList.get(i));
            }
            return;
        }
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    Object obj3 = field.get(obj);
                    if (field.getType().isPrimitive()) {
                        field.set(obj2, obj3);
                    } else if (field.getType().isArray()) {
                        field.set(obj2, operateArray(obj3));
                    } else if (obj3 instanceof Object) {
                        Object newInstance = obj3.getClass().newInstance();
                        deepcopy(obj3, newInstance);
                        field.set(obj2, newInstance);
                    }
                    field.setAccessible(false);
                }
            }
            cls = cls.getSuperclass();
        }
    }
}
