package org.objectweb.asm.tree;

import org.objectweb.asm.ModuleVisitor;
/* loaded from: xp_Montecarlo-benchDavid55.apk:org/objectweb/asm/tree/ModuleRequireNode.SCL.lombok */
public class ModuleRequireNode {
    public String module;
    public int access;
    public String version;

    public ModuleRequireNode(String module, int access, String version) {
        this.module = module;
        this.access = access;
        this.version = version;
    }

    public void accept(ModuleVisitor moduleVisitor) {
        moduleVisitor.visitRequire(this.module, this.access, this.version);
    }
}
