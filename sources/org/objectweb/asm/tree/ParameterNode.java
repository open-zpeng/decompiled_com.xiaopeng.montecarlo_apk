package org.objectweb.asm.tree;

import org.objectweb.asm.MethodVisitor;
/* loaded from: xp_Montecarlo-benchEdward.apk:org/objectweb/asm/tree/ParameterNode.SCL.lombok */
public class ParameterNode {
    public String name;
    public int access;

    public ParameterNode(String name, int access) {
        this.name = name;
        this.access = access;
    }

    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitParameter(this.name, this.access);
    }
}
