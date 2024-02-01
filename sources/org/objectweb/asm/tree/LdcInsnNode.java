package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:org/objectweb/asm/tree/LdcInsnNode.SCL.lombok */
public class LdcInsnNode extends AbstractInsnNode {
    public Object cst;

    public LdcInsnNode(Object value) {
        super(18);
        this.cst = value;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 9;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitLdcInsn(this.cst);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new LdcInsnNode(this.cst).cloneAnnotations(this);
    }
}
