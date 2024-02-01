package org.objectweb.asm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:org/objectweb/asm/Context.SCL.lombok */
public final class Context {
    Attribute[] attributePrototypes;
    int parsingOptions;
    char[] charBuffer;
    int currentMethodAccessFlags;
    String currentMethodName;
    String currentMethodDescriptor;
    Label[] currentMethodLabels;
    int currentTypeAnnotationTarget;
    TypePath currentTypeAnnotationTargetPath;
    Label[] currentLocalVariableAnnotationRangeStarts;
    Label[] currentLocalVariableAnnotationRangeEnds;
    int[] currentLocalVariableAnnotationRangeIndices;
    int currentFrameOffset;
    int currentFrameType;
    int currentFrameLocalCount;
    int currentFrameLocalCountDelta;
    Object[] currentFrameLocalTypes;
    int currentFrameStackCount;
    Object[] currentFrameStackTypes;
}
