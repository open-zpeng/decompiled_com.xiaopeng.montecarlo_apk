package org.objectweb.asm.tree;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;
/* loaded from: xp_Montecarlo-benchDavid55.apk:org/objectweb/asm/tree/TypeAnnotationNode.SCL.lombok */
public class TypeAnnotationNode extends AnnotationNode {
    public int typeRef;
    public TypePath typePath;

    public TypeAnnotationNode(int typeRef, TypePath typePath, String descriptor) {
        this(Opcodes.ASM9, typeRef, typePath, descriptor);
        if (getClass() != TypeAnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public TypeAnnotationNode(int api, int typeRef, TypePath typePath, String descriptor) {
        super(api, descriptor);
        this.typeRef = typeRef;
        this.typePath = typePath;
    }
}
