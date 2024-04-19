package com.autonavi.auto.intfauto;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes.dex */
public class ReflexTool {
    public static String EMD(Object obj) {
        return "";
    }

    public static String PN(Class cls) {
        return getPackageName(cls);
    }

    public static Method EM(Object obj) {
        return getEnclosingMethod(obj);
    }

    public static Constructor EC(Object obj) {
        return getEnclosingConstructor(obj);
    }

    public static String ECD(Object obj) {
        return getConstructorDesc(getEnclosingConstructor(obj));
    }

    public static String TN(Method method, int i) {
        return getTypeName(method, i);
    }

    public static String TN(Constructor constructor, int i) {
        return getTypeName(constructor, i);
    }

    public static Object invokeConstructor(Class cls, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static Object invokeConstructorSafe(Class cls, Class[] clsArr, Object[] objArr) {
        try {
            return invokeConstructor(cls, clsArr, objArr);
        } catch (Exception e) {
            DebugTool.printStackTrace(e);
            return null;
        }
    }

    public static Object invokeDeclConstructor(Class cls, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(objArr);
    }

    public static Object invokeDeclConstructorSafe(Class cls, Class[] clsArr, Object[] objArr) {
        try {
            return invokeDeclConstructor(cls, clsArr, objArr);
        } catch (Exception e) {
            DebugTool.printStackTrace(e);
            return null;
        }
    }

    public static Object invokeMethod(Object obj, String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object obj2;
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
            obj2 = null;
        } else {
            obj2 = obj;
            cls = obj.getClass();
        }
        return cls.getMethod(str, clsArr).invoke(obj2, objArr);
    }

    public static Object invokeMethodSafe(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            return invokeMethod(obj, str, clsArr, objArr);
        } catch (Exception e) {
            DebugTool.printStackTrace(e);
            return null;
        }
    }

    public static Object invokeDeclMethod(Object obj, String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object obj2;
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
            obj2 = null;
        } else {
            obj2 = obj;
            cls = obj.getClass();
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj2, objArr);
    }

    public static Object invokeDeclMethodSafe(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            return invokeDeclMethod(obj, str, clsArr, objArr);
        } catch (Exception e) {
            DebugTool.printStackTrace(e);
            return null;
        }
    }

    public static Object getField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Object obj2;
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
            obj2 = null;
        } else {
            obj2 = obj;
            cls = obj.getClass();
        }
        return cls.getField(str).get(obj2);
    }

    public static Object getFieldSafe(Object obj, String str) {
        try {
            return getField(obj, str);
        } catch (Exception e) {
            DebugTool.printStackTrace(e);
            return null;
        }
    }

    public static Object getDeclField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Object obj2;
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
            obj2 = null;
        } else {
            obj2 = obj;
            cls = obj.getClass();
        }
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj2);
    }

    public static Object getDeclFieldSafe(Object obj, String str) {
        try {
            return getDeclField(obj, str);
        } catch (Exception e) {
            DebugTool.printStackTrace(e);
            return null;
        }
    }

    public static void setField(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        Object obj3;
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
            obj3 = null;
        } else {
            obj3 = obj;
            cls = obj.getClass();
        }
        cls.getField(str).set(obj3, obj2);
    }

    public static void setFieldSafe(Object obj, String str, Object obj2) {
        try {
            setField(obj, str, obj2);
        } catch (Exception e) {
            DebugTool.printStackTrace(e);
        }
    }

    public static void setDeclField(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        Object obj3;
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
            obj3 = null;
        } else {
            obj3 = obj;
            cls = obj.getClass();
        }
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj3, obj2);
    }

    public static void setDeclFieldSafe(Object obj, String str, Object obj2) {
        try {
            setDeclField(obj, str, obj2);
        } catch (Exception e) {
            DebugTool.printStackTrace(e);
        }
    }

    private static String getPackageName(Class cls) {
        return cls.getCanonicalName();
    }

    private static Method getEnclosingMethod(Object obj) {
        return obj.getClass().getEnclosingMethod();
    }

    private static Constructor getEnclosingConstructor(Object obj) {
        return obj.getClass().getEnclosingConstructor();
    }

    private static String getMethodDesc(Method method) {
        return method.toGenericString();
    }

    private static String getConstructorDesc(Constructor constructor) {
        return constructor.toGenericString();
    }

    private static void appendArrayGenericType(StringBuilder sb, Type[] typeArr) {
        if (typeArr.length > 0) {
            appendGenericType(sb, typeArr[0]);
            for (int i = 1; i < typeArr.length; i++) {
                sb.append(',');
                appendGenericType(sb, typeArr[i]);
            }
        }
    }

    private static void appendGenericType(StringBuilder sb, Type type) {
        if (type instanceof TypeVariable) {
            sb.append(((TypeVariable) type).getName());
        } else if (type instanceof ParameterizedType) {
            sb.append(type.toString());
        } else if (type instanceof GenericArrayType) {
            appendGenericType(sb, ((GenericArrayType) type).getGenericComponentType());
            sb.append("[]");
        } else if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                String[] split = cls.getName().split("\\[");
                int length = split.length - 1;
                if (split[length].length() > 1) {
                    sb.append(split[length].substring(1, split[length].length() - 1));
                } else {
                    char charAt = split[length].charAt(0);
                    if (charAt == 'I') {
                        sb.append("int");
                    } else if (charAt == 'B') {
                        sb.append("byte");
                    } else if (charAt == 'J') {
                        sb.append("long");
                    } else if (charAt == 'F') {
                        sb.append(TypedValues.Custom.S_FLOAT);
                    } else if (charAt == 'D') {
                        sb.append("double");
                    } else if (charAt == 'S') {
                        sb.append("short");
                    } else if (charAt == 'C') {
                        sb.append("char");
                    } else if (charAt == 'Z') {
                        sb.append(TypedValues.Custom.S_BOOLEAN);
                    } else if (charAt == 'V') {
                        sb.append("void");
                    }
                }
                for (int i = 0; i < length; i++) {
                    sb.append("[]");
                }
                return;
            }
            sb.append(cls.getName());
        }
    }

    private static String getTypeName(Method method, int i) {
        StringBuilder sb = new StringBuilder();
        if (i < 0) {
            appendGenericType(sb, method.getGenericReturnType());
            return sb.toString();
        }
        appendGenericType(sb, method.getGenericParameterTypes()[i]);
        return sb.toString();
    }

    private static String getTypeName(Constructor constructor, int i) {
        StringBuilder sb = new StringBuilder();
        appendGenericType(sb, constructor.getGenericParameterTypes()[i]);
        return sb.toString();
    }

    private static String getPackageNameArray(Class[] clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        if (clsArr != null) {
            for (Class cls : clsArr) {
                sb.append(", \"");
                sb.append(getPackageName(cls));
                sb.append("\"");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
