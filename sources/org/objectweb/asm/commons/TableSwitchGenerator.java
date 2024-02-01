package org.objectweb.asm.commons;

import org.objectweb.asm.Label;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:org/objectweb/asm/commons/TableSwitchGenerator.SCL.lombok */
public interface TableSwitchGenerator {
    void generateCase(int i, Label label);

    void generateDefault();
}
