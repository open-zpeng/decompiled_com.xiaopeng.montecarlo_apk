package org.objectweb.asm.tree;

import org.objectweb.asm.MethodVisitor;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:org/objectweb/asm/tree/ParameterNode.SCL.lombok */
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
