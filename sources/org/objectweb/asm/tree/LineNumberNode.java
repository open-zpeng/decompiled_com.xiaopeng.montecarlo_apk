package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:org/objectweb/asm/tree/LineNumberNode.SCL.lombok */
public class LineNumberNode extends AbstractInsnNode {
    public int line;
    public LabelNode start;

    public LineNumberNode(int line, LabelNode start) {
        super(-1);
        this.line = line;
        this.start = start;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 15;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitLineNumber(this.line, this.start.getLabel());
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new LineNumberNode(this.line, clone(this.start, clonedLabels));
    }
}
