package org.objectweb.asm;
/* loaded from: xp_Montecarlo-benchEdward.apk:org/objectweb/asm/FieldVisitor.SCL.lombok */
public abstract class FieldVisitor {
    protected final int api;
    protected FieldVisitor fv;

    public FieldVisitor(int api) {
        this(api, null);
    }

    public FieldVisitor(int api, FieldVisitor fieldVisitor) {
        if (api != 589824 && api != 524288 && api != 458752 && api != 393216 && api != 327680 && api != 262144 && api != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + api);
        }
        if (api == 17432576) {
            Constants.checkAsmExperimental(this);
        }
        this.api = api;
        this.fv = fieldVisitor;
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (this.fv != null) {
            return this.fv.visitAnnotation(descriptor, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException("This feature requires ASM5");
        }
        if (this.fv != null) {
            return this.fv.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        if (this.fv != null) {
            this.fv.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        if (this.fv != null) {
            this.fv.visitEnd();
        }
    }
}
