package com.autonavi.auto.intfauto;
/* loaded from: classes.dex */
public class JType implements Comparable<JType> {
    private BuildType buildType;
    private boolean ignoreType;
    private Object inst;
    private Class type;

    private int getTypeHashCode() {
        Class cls = this.type;
        if (cls != null) {
            return cls.hashCode();
        }
        return 0;
    }

    private int getInstHashCode() {
        Object obj = this.inst;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    private void updateBuildtype() {
        Class cls = this.type;
        if (cls == null) {
            this.buildType = BuildType.NONE;
        } else {
            this.buildType = TypeUtil.getIntfAutoType(cls);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(JType jType) {
        int typeHashCode;
        int typeHashCode2;
        if (this.inst != jType.inst) {
            typeHashCode = getInstHashCode();
            typeHashCode2 = jType.getInstHashCode();
        } else if (this.ignoreType || jType.ignoreType) {
            return 0;
        } else {
            if (this.type == null) {
                return 1;
            }
            if (jType.type == null) {
                return -1;
            }
            BuildType buildType = getBuildType();
            if (TypeUtil.isJIntfType(buildType) != TypeUtil.isJIntfType(jType.getBuildType())) {
                return TypeUtil.isJIntfType(buildType) ? 1 : -1;
            }
            typeHashCode = getTypeHashCode();
            typeHashCode2 = jType.getTypeHashCode();
        }
        return typeHashCode - typeHashCode2;
    }

    public int hashCode() {
        return getInstHashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof JType)) {
            return false;
        }
        JType jType = (JType) obj;
        return this.type == jType.type && this.inst == jType.inst;
    }

    public JType(Class cls, Object obj, boolean z) {
        this.type = cls;
        this.inst = obj;
        this.ignoreType = z;
        updateBuildtype();
    }

    public JType(Class cls, Object obj) {
        this(cls, obj, false);
    }

    public Class getType() {
        return this.type;
    }

    public BuildType getBuildType() {
        return this.buildType;
    }

    public Object getInst() {
        return this.inst;
    }
}
