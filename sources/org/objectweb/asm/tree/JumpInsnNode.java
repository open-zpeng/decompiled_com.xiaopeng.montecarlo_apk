package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:org/objectweb/asm/tree/JumpInsnNode.SCL.lombok */
public class JumpInsnNode extends AbstractInsnNode {
    public LabelNode label;

    public JumpInsnNode(int opcode, LabelNode label) {
        super(opcode);
        this.label = label;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 7;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitJumpInsn(this.opcode, this.label.getLabel());
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new JumpInsnNode(this.opcode, clone(this.label, clonedLabels)).cloneAnnotations(this);
    }
}
