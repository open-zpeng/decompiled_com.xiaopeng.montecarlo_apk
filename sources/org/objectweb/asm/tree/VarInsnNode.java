package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:org/objectweb/asm/tree/VarInsnNode.SCL.lombok */
public class VarInsnNode extends AbstractInsnNode {
    public int var;

    public VarInsnNode(int opcode, int var) {
        super(opcode);
        this.var = var;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 2;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(this.opcode, this.var);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new VarInsnNode(this.opcode, this.var).cloneAnnotations(this);
    }
}
