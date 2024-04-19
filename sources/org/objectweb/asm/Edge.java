package org.objectweb.asm;
/* loaded from: xp_Montecarlo-benchDavid55.apk:org/objectweb/asm/Edge.SCL.lombok */
final class Edge {
    static final int JUMP = 0;
    static final int EXCEPTION = Integer.MAX_VALUE;
    final int info;
    final Label successor;
    Edge nextEdge;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Edge(int info, Label successor, Edge nextEdge) {
        this.info = info;
        this.successor = successor;
        this.nextEdge = nextEdge;
    }
}
