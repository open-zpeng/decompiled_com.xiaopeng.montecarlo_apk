package org.objectweb.asm;

import org.objectweb.asm.Attribute;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xp_Montecarlo-benchDavid55.apk:org/objectweb/asm/RecordComponentWriter.SCL.lombok */
public final class RecordComponentWriter extends RecordComponentVisitor {
    private final SymbolTable symbolTable;
    private final int nameIndex;
    private final int descriptorIndex;
    private int signatureIndex;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private Attribute firstAttribute;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecordComponentWriter(SymbolTable symbolTable, String name, String descriptor, String signature) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable;
        this.nameIndex = symbolTable.addConstantUtf8(name);
        this.descriptorIndex = symbolTable.addConstantUtf8(descriptor);
        if (signature != null) {
            this.signatureIndex = symbolTable.addConstantUtf8(signature);
        }
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (visible) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, descriptor, this.lastRuntimeVisibleAnnotation);
            this.lastRuntimeVisibleAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, descriptor, this.lastRuntimeInvisibleAnnotation);
        this.lastRuntimeInvisibleAnnotation = create2;
        return create2;
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (visible) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, typeRef, typePath, descriptor, this.lastRuntimeVisibleTypeAnnotation);
            this.lastRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, typeRef, typePath, descriptor, this.lastRuntimeInvisibleTypeAnnotation);
        this.lastRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public void visitAttribute(Attribute attribute) {
        attribute.nextAttribute = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public void visitEnd() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int computeRecordComponentInfoSize() {
        int size = 6 + Attribute.computeAttributesSize(this.symbolTable, 0, this.signatureIndex) + AnnotationWriter.computeAnnotationsSize(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
        if (this.firstAttribute != null) {
            size += this.firstAttribute.computeAttributesSize(this.symbolTable);
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putRecordComponentInfo(ByteVector output) {
        output.putShort(this.nameIndex).putShort(this.descriptorIndex);
        int attributesCount = 0;
        if (this.signatureIndex != 0) {
            attributesCount = 0 + 1;
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            attributesCount++;
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            attributesCount++;
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            attributesCount++;
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            attributesCount++;
        }
        if (this.firstAttribute != null) {
            attributesCount += this.firstAttribute.getAttributeCount();
        }
        output.putShort(attributesCount);
        Attribute.putAttributes(this.symbolTable, 0, this.signatureIndex, output);
        AnnotationWriter.putAnnotations(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, output);
        if (this.firstAttribute != null) {
            this.firstAttribute.putAttributes(this.symbolTable, output);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void collectAttributePrototypes(Attribute.Set attributePrototypes) {
        attributePrototypes.addAttributes(this.firstAttribute);
    }
}
