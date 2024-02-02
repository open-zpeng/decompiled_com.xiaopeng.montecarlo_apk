package org.objectweb.asm.commons;

import org.objectweb.asm.Label;
/* loaded from: xp_Montecarlo-benchEdward.apk:org/objectweb/asm/commons/TableSwitchGenerator.SCL.lombok */
public interface TableSwitchGenerator {
    void generateCase(int i, Label label);

    void generateDefault();
}
