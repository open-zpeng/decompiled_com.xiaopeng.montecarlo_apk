package org.objectweb.asm.tree;

import java.util.List;
import org.objectweb.asm.ModuleVisitor;
/* loaded from: xp_Montecarlo-benchDavid55.apk:org/objectweb/asm/tree/ModuleExportNode.SCL.lombok */
public class ModuleExportNode {
    public String packaze;
    public int access;
    public List<String> modules;

    public ModuleExportNode(String packaze, int access, List<String> modules) {
        this.packaze = packaze;
        this.access = access;
        this.modules = modules;
    }

    public void accept(ModuleVisitor moduleVisitor) {
        moduleVisitor.visitExport(this.packaze, this.access, this.modules == null ? null : (String[]) this.modules.toArray(new String[0]));
    }
}
