package xpilot.sr.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import xpilot.sr.proto.LocalPose;
import xpilot.sr.proto.Primitives;
/* loaded from: classes3.dex */
public final class StaticEnvironmentOuterClass {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_BoundaryInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_BoundaryInfo_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_LaneInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_LaneInfo_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_LaneLineInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_LaneLineInfo_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_LaneTypeInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_LaneTypeInfo_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_NeighborInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_NeighborInfo_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_PathPoint_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_PathPoint_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_SpeedLimitInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_SpeedLimitInfo_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_SplitMergeInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_SplitMergeInfo_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_StaticEnvironment_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_StaticEnvironment_fieldAccessorTable;

    /* loaded from: classes3.dex */
    public interface BoundaryInfoOrBuilder extends MessageOrBuilder {
        LineMarking getLineMarking();

        LineMarkingColour getLineMarkingColour();

        int getLineMarkingColourValue();

        int getLineMarkingValue();

        float getSBegin();

        float getSEnd();
    }

    /* loaded from: classes3.dex */
    public interface LaneInfoOrBuilder extends MessageOrBuilder {
        boolean getDirection();

        boolean getIsDrivable();

        boolean getIsValid();

        Primitives.LaneID getLaneId();

        int getLaneIdValue();

        Primitives.LaneType getLaneType();

        int getLaneTypeValue();

        int getLeftTrackId();

        int getRightTrackId();

        float getSpeedLimit();

        Primitives.LaneTurnSignType getTurnSign();

        int getTurnSignValue();
    }

    /* loaded from: classes3.dex */
    public interface LaneLineInfoOrBuilder extends MessageOrBuilder {
        float getConfidence();

        int getLanePriority();

        LaneTypeInfo getLaneType(int i);

        int getLaneTypeCount();

        List<LaneTypeInfo> getLaneTypeList();

        LaneTypeInfoOrBuilder getLaneTypeOrBuilder(int i);

        List<? extends LaneTypeInfoOrBuilder> getLaneTypeOrBuilderList();

        BoundaryInfo getLeftBoundaryType(int i);

        int getLeftBoundaryTypeCount();

        List<BoundaryInfo> getLeftBoundaryTypeList();

        BoundaryInfoOrBuilder getLeftBoundaryTypeOrBuilder(int i);

        List<? extends BoundaryInfoOrBuilder> getLeftBoundaryTypeOrBuilderList();

        NeighborInfo getLeftNeighbor(int i);

        int getLeftNeighborCount();

        List<NeighborInfo> getLeftNeighborList();

        NeighborInfoOrBuilder getLeftNeighborOrBuilder(int i);

        List<? extends NeighborInfoOrBuilder> getLeftNeighborOrBuilderList();

        SplitMergeInfo getMergeInfo();

        SplitMergeInfoOrBuilder getMergeInfoOrBuilder();

        PathPoint getPathPoints(int i);

        int getPathPointsCount();

        List<PathPoint> getPathPointsList();

        PathPointOrBuilder getPathPointsOrBuilder(int i);

        List<? extends PathPointOrBuilder> getPathPointsOrBuilderList();

        Primitives.LaneType_P getPositionLaneType();

        int getPositionLaneTypeValue();

        BoundaryInfo getRightBoundaryType(int i);

        int getRightBoundaryTypeCount();

        List<BoundaryInfo> getRightBoundaryTypeList();

        BoundaryInfoOrBuilder getRightBoundaryTypeOrBuilder(int i);

        List<? extends BoundaryInfoOrBuilder> getRightBoundaryTypeOrBuilderList();

        NeighborInfo getRightNeighbor(int i);

        int getRightNeighborCount();

        List<NeighborInfo> getRightNeighborList();

        NeighborInfoOrBuilder getRightNeighborOrBuilder(int i);

        List<? extends NeighborInfoOrBuilder> getRightNeighborOrBuilderList();

        SpeedLimitInfo getSpeedLimit(int i);

        int getSpeedLimitCount();

        List<SpeedLimitInfo> getSpeedLimitList();

        SpeedLimitInfoOrBuilder getSpeedLimitOrBuilder(int i);

        List<? extends SpeedLimitInfoOrBuilder> getSpeedLimitOrBuilderList();

        SplitMergeInfo getSplitInfo();

        SplitMergeInfoOrBuilder getSplitInfoOrBuilder();

        int getTrackId();

        int getXpuCduLaneColor();

        boolean hasMergeInfo();

        boolean hasSplitInfo();
    }

    /* loaded from: classes3.dex */
    public interface LaneTypeInfoOrBuilder extends MessageOrBuilder {
        Primitives.LaneType getLaneType();

        int getLaneTypeValue();

        float getSBegin();

        float getSEnd();
    }

    /* loaded from: classes3.dex */
    public interface NeighborInfoOrBuilder extends MessageOrBuilder {
        int getId();

        float getSBegin();

        float getSEnd();
    }

    /* loaded from: classes3.dex */
    public interface PathPointOrBuilder extends MessageOrBuilder {
        Primitives.Vector3D getBasePoint();

        Primitives.Vector3DOrBuilder getBasePointOrBuilder();

        float getConfidence();

        float getDdkappa();

        float getDkappa();

        float getKappa();

        float getLeftWidth();

        float getRightWidth();

        float getS();

        float getTheta();

        boolean hasBasePoint();
    }

    /* loaded from: classes3.dex */
    public interface SpeedLimitInfoOrBuilder extends MessageOrBuilder {
        float getSBegin();

        float getSEnd();

        float getSpeedLimit();
    }

    /* loaded from: classes3.dex */
    public interface SplitMergeInfoOrBuilder extends MessageOrBuilder {
        int getId();

        float getOverlapSRange();

        float getSOffset();
    }

    /* loaded from: classes3.dex */
    public interface StaticEnvironmentBufferOrBuilder extends MessageOrBuilder {
        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();

        StaticEnvironment getStaticEnvMsgs(int i);

        int getStaticEnvMsgsCount();

        List<StaticEnvironment> getStaticEnvMsgsList();

        StaticEnvironmentOrBuilder getStaticEnvMsgsOrBuilder(int i);

        List<? extends StaticEnvironmentOrBuilder> getStaticEnvMsgsOrBuilderList();
    }

    /* loaded from: classes3.dex */
    public interface StaticEnvironmentOrBuilder extends MessageOrBuilder {
        LocalPose.LocalPoseInfo getCurPose();

        LocalPose.LocalPoseInfoOrBuilder getCurPoseOrBuilder();

        boolean getIsDisplay();

        boolean getIsHdmapMode();

        LaneLineInfo getLaneLine(int i);

        int getLaneLineCount();

        List<LaneLineInfo> getLaneLineList();

        LaneLineInfoOrBuilder getLaneLineOrBuilder(int i);

        List<? extends LaneLineInfoOrBuilder> getLaneLineOrBuilderList();

        Primitives.Time getTimestamp();

        Primitives.TimeOrBuilder getTimestampOrBuilder();

        boolean hasCurPose();

        boolean hasTimestamp();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private StaticEnvironmentOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes3.dex */
    public enum LineMarking implements ProtocolMessageEnum {
        LineMarking_Unknown(0),
        LineMarking_SolidLine(1),
        LineMarking_DashedLine(2),
        LineMarking_ShortDashedLine(3),
        LineMarking_DoubleSolidLine(4),
        LineMarking_DoubleDashedLine(5),
        LineMarking_LeftSolidRightDashed(6),
        LineMarking_RightSolidLeftDashed(7),
        LineMarking_ShadedArea(8),
        LineMarking_LaneVirtualMarking(9),
        LineMarking_IntersectionVirualMarking(10),
        LineMarking_CurbVirtualMarking(11),
        LineMarking_UnclosedRoad(12),
        LineMarking_Other(99),
        UNRECOGNIZED(-1);
        
        public static final int LineMarking_CurbVirtualMarking_VALUE = 11;
        public static final int LineMarking_DashedLine_VALUE = 2;
        public static final int LineMarking_DoubleDashedLine_VALUE = 5;
        public static final int LineMarking_DoubleSolidLine_VALUE = 4;
        public static final int LineMarking_IntersectionVirualMarking_VALUE = 10;
        public static final int LineMarking_LaneVirtualMarking_VALUE = 9;
        public static final int LineMarking_LeftSolidRightDashed_VALUE = 6;
        public static final int LineMarking_Other_VALUE = 99;
        public static final int LineMarking_RightSolidLeftDashed_VALUE = 7;
        public static final int LineMarking_ShadedArea_VALUE = 8;
        public static final int LineMarking_ShortDashedLine_VALUE = 3;
        public static final int LineMarking_SolidLine_VALUE = 1;
        public static final int LineMarking_UnclosedRoad_VALUE = 12;
        public static final int LineMarking_Unknown_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<LineMarking> internalValueMap = new Internal.EnumLiteMap<LineMarking>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.LineMarking.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LineMarking findValueByNumber(int i) {
                return LineMarking.forNumber(i);
            }
        };
        private static final LineMarking[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LineMarking valueOf(int i) {
            return forNumber(i);
        }

        public static LineMarking forNumber(int i) {
            if (i != 99) {
                switch (i) {
                    case 0:
                        return LineMarking_Unknown;
                    case 1:
                        return LineMarking_SolidLine;
                    case 2:
                        return LineMarking_DashedLine;
                    case 3:
                        return LineMarking_ShortDashedLine;
                    case 4:
                        return LineMarking_DoubleSolidLine;
                    case 5:
                        return LineMarking_DoubleDashedLine;
                    case 6:
                        return LineMarking_LeftSolidRightDashed;
                    case 7:
                        return LineMarking_RightSolidLeftDashed;
                    case 8:
                        return LineMarking_ShadedArea;
                    case 9:
                        return LineMarking_LaneVirtualMarking;
                    case 10:
                        return LineMarking_IntersectionVirualMarking;
                    case 11:
                        return LineMarking_CurbVirtualMarking;
                    case 12:
                        return LineMarking_UnclosedRoad;
                    default:
                        return null;
                }
            }
            return LineMarking_Other;
        }

        public static Internal.EnumLiteMap<LineMarking> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return StaticEnvironmentOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static LineMarking valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LineMarking(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes3.dex */
    public enum LineMarkingColour implements ProtocolMessageEnum {
        LineMarkingColour_None(0),
        LineMarkingColour_White(1),
        LineMarkingColour_Yellow(2),
        LineMarkingColour_Orange(3),
        LineMarkingColour_Blue(4),
        LineMarkingColour_Green(5),
        LineMarkingColour_Gray(6),
        LineMarkingColour_LeftGrayRightYellow(7),
        LineMarkingColour_LeftYellowRightWhite(8),
        LineMarkingColour_Other(99),
        UNRECOGNIZED(-1);
        
        public static final int LineMarkingColour_Blue_VALUE = 4;
        public static final int LineMarkingColour_Gray_VALUE = 6;
        public static final int LineMarkingColour_Green_VALUE = 5;
        public static final int LineMarkingColour_LeftGrayRightYellow_VALUE = 7;
        public static final int LineMarkingColour_LeftYellowRightWhite_VALUE = 8;
        public static final int LineMarkingColour_None_VALUE = 0;
        public static final int LineMarkingColour_Orange_VALUE = 3;
        public static final int LineMarkingColour_Other_VALUE = 99;
        public static final int LineMarkingColour_White_VALUE = 1;
        public static final int LineMarkingColour_Yellow_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<LineMarkingColour> internalValueMap = new Internal.EnumLiteMap<LineMarkingColour>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.LineMarkingColour.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LineMarkingColour findValueByNumber(int i) {
                return LineMarkingColour.forNumber(i);
            }
        };
        private static final LineMarkingColour[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LineMarkingColour valueOf(int i) {
            return forNumber(i);
        }

        public static LineMarkingColour forNumber(int i) {
            if (i != 99) {
                switch (i) {
                    case 0:
                        return LineMarkingColour_None;
                    case 1:
                        return LineMarkingColour_White;
                    case 2:
                        return LineMarkingColour_Yellow;
                    case 3:
                        return LineMarkingColour_Orange;
                    case 4:
                        return LineMarkingColour_Blue;
                    case 5:
                        return LineMarkingColour_Green;
                    case 6:
                        return LineMarkingColour_Gray;
                    case 7:
                        return LineMarkingColour_LeftGrayRightYellow;
                    case 8:
                        return LineMarkingColour_LeftYellowRightWhite;
                    default:
                        return null;
                }
            }
            return LineMarkingColour_Other;
        }

        public static Internal.EnumLiteMap<LineMarkingColour> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return StaticEnvironmentOuterClass.getDescriptor().getEnumTypes().get(1);
        }

        public static LineMarkingColour valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LineMarkingColour(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes3.dex */
    public static final class PathPoint extends GeneratedMessageV3 implements PathPointOrBuilder {
        public static final int BASE_POINT_FIELD_NUMBER = 2;
        public static final int CONFIDENCE_FIELD_NUMBER = 1;
        public static final int DDKAPPA_FIELD_NUMBER = 9;
        public static final int DKAPPA_FIELD_NUMBER = 8;
        public static final int KAPPA_FIELD_NUMBER = 4;
        public static final int LEFT_WIDTH_FIELD_NUMBER = 6;
        public static final int RIGHT_WIDTH_FIELD_NUMBER = 7;
        public static final int S_FIELD_NUMBER = 5;
        public static final int THETA_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private Primitives.Vector3D basePoint_;
        private float confidence_;
        private float ddkappa_;
        private float dkappa_;
        private float kappa_;
        private float leftWidth_;
        private byte memoizedIsInitialized;
        private float rightWidth_;
        private float s_;
        private float theta_;
        private static final PathPoint DEFAULT_INSTANCE = new PathPoint();
        private static final Parser<PathPoint> PARSER = new AbstractParser<PathPoint>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.PathPoint.1
            @Override // com.google.protobuf.Parser
            public PathPoint parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PathPoint(codedInputStream, extensionRegistryLite);
            }
        };

        private PathPoint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private PathPoint() {
            this.memoizedIsInitialized = (byte) -1;
            this.confidence_ = 0.0f;
            this.theta_ = 0.0f;
            this.kappa_ = 0.0f;
            this.s_ = 0.0f;
            this.leftWidth_ = 0.0f;
            this.rightWidth_ = 0.0f;
            this.dkappa_ = 0.0f;
            this.ddkappa_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PathPoint(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 13) {
                                    this.confidence_ = codedInputStream.readFloat();
                                } else if (readTag == 18) {
                                    Primitives.Vector3D.Builder builder = this.basePoint_ != null ? this.basePoint_.toBuilder() : null;
                                    this.basePoint_ = (Primitives.Vector3D) codedInputStream.readMessage(Primitives.Vector3D.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.basePoint_);
                                        this.basePoint_ = builder.buildPartial();
                                    }
                                } else if (readTag == 29) {
                                    this.theta_ = codedInputStream.readFloat();
                                } else if (readTag == 37) {
                                    this.kappa_ = codedInputStream.readFloat();
                                } else if (readTag == 45) {
                                    this.s_ = codedInputStream.readFloat();
                                } else if (readTag == 53) {
                                    this.leftWidth_ = codedInputStream.readFloat();
                                } else if (readTag == 61) {
                                    this.rightWidth_ = codedInputStream.readFloat();
                                } else if (readTag == 69) {
                                    this.dkappa_ = codedInputStream.readFloat();
                                } else if (readTag == 77) {
                                    this.ddkappa_ = codedInputStream.readFloat();
                                } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_PathPoint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_PathPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(PathPoint.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public float getConfidence() {
            return this.confidence_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public boolean hasBasePoint() {
            return this.basePoint_ != null;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public Primitives.Vector3D getBasePoint() {
            Primitives.Vector3D vector3D = this.basePoint_;
            return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public Primitives.Vector3DOrBuilder getBasePointOrBuilder() {
            return getBasePoint();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public float getTheta() {
            return this.theta_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public float getKappa() {
            return this.kappa_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public float getS() {
            return this.s_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public float getLeftWidth() {
            return this.leftWidth_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public float getRightWidth() {
            return this.rightWidth_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public float getDkappa() {
            return this.dkappa_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
        public float getDdkappa() {
            return this.ddkappa_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            float f = this.confidence_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            if (this.basePoint_ != null) {
                codedOutputStream.writeMessage(2, getBasePoint());
            }
            float f2 = this.theta_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(3, f2);
            }
            float f3 = this.kappa_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(4, f3);
            }
            float f4 = this.s_;
            if (f4 != 0.0f) {
                codedOutputStream.writeFloat(5, f4);
            }
            float f5 = this.leftWidth_;
            if (f5 != 0.0f) {
                codedOutputStream.writeFloat(6, f5);
            }
            float f6 = this.rightWidth_;
            if (f6 != 0.0f) {
                codedOutputStream.writeFloat(7, f6);
            }
            float f7 = this.dkappa_;
            if (f7 != 0.0f) {
                codedOutputStream.writeFloat(8, f7);
            }
            float f8 = this.ddkappa_;
            if (f8 != 0.0f) {
                codedOutputStream.writeFloat(9, f8);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            float f = this.confidence_;
            int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
            if (this.basePoint_ != null) {
                computeFloatSize += CodedOutputStream.computeMessageSize(2, getBasePoint());
            }
            float f2 = this.theta_;
            if (f2 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(3, f2);
            }
            float f3 = this.kappa_;
            if (f3 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(4, f3);
            }
            float f4 = this.s_;
            if (f4 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(5, f4);
            }
            float f5 = this.leftWidth_;
            if (f5 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(6, f5);
            }
            float f6 = this.rightWidth_;
            if (f6 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(7, f6);
            }
            float f7 = this.dkappa_;
            if (f7 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(8, f7);
            }
            float f8 = this.ddkappa_;
            if (f8 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(9, f8);
            }
            int serializedSize = computeFloatSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PathPoint)) {
                return super.equals(obj);
            }
            PathPoint pathPoint = (PathPoint) obj;
            boolean z = (Float.floatToIntBits(getConfidence()) == Float.floatToIntBits(pathPoint.getConfidence())) && hasBasePoint() == pathPoint.hasBasePoint();
            if (hasBasePoint()) {
                z = z && getBasePoint().equals(pathPoint.getBasePoint());
            }
            return (((((((z && Float.floatToIntBits(getTheta()) == Float.floatToIntBits(pathPoint.getTheta())) && Float.floatToIntBits(getKappa()) == Float.floatToIntBits(pathPoint.getKappa())) && Float.floatToIntBits(getS()) == Float.floatToIntBits(pathPoint.getS())) && Float.floatToIntBits(getLeftWidth()) == Float.floatToIntBits(pathPoint.getLeftWidth())) && Float.floatToIntBits(getRightWidth()) == Float.floatToIntBits(pathPoint.getRightWidth())) && Float.floatToIntBits(getDkappa()) == Float.floatToIntBits(pathPoint.getDkappa())) && Float.floatToIntBits(getDdkappa()) == Float.floatToIntBits(pathPoint.getDdkappa())) && this.unknownFields.equals(pathPoint.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getConfidence());
            if (hasBasePoint()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getBasePoint().hashCode();
            }
            int floatToIntBits = (((((((((((((((((((((((((((((hashCode * 37) + 3) * 53) + Float.floatToIntBits(getTheta())) * 37) + 4) * 53) + Float.floatToIntBits(getKappa())) * 37) + 5) * 53) + Float.floatToIntBits(getS())) * 37) + 6) * 53) + Float.floatToIntBits(getLeftWidth())) * 37) + 7) * 53) + Float.floatToIntBits(getRightWidth())) * 37) + 8) * 53) + Float.floatToIntBits(getDkappa())) * 37) + 9) * 53) + Float.floatToIntBits(getDdkappa())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = floatToIntBits;
            return floatToIntBits;
        }

        public static PathPoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static PathPoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PathPoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PathPoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PathPoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PathPoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PathPoint parseFrom(InputStream inputStream) throws IOException {
            return (PathPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PathPoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PathPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PathPoint parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PathPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PathPoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PathPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PathPoint parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PathPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PathPoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PathPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PathPoint pathPoint) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(pathPoint);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PathPointOrBuilder {
            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> basePointBuilder_;
            private Primitives.Vector3D basePoint_;
            private float confidence_;
            private float ddkappa_;
            private float dkappa_;
            private float kappa_;
            private float leftWidth_;
            private float rightWidth_;
            private float s_;
            private float theta_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_PathPoint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_PathPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(PathPoint.class, Builder.class);
            }

            private Builder() {
                this.basePoint_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.basePoint_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = PathPoint.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.confidence_ = 0.0f;
                if (this.basePointBuilder_ == null) {
                    this.basePoint_ = null;
                } else {
                    this.basePoint_ = null;
                    this.basePointBuilder_ = null;
                }
                this.theta_ = 0.0f;
                this.kappa_ = 0.0f;
                this.s_ = 0.0f;
                this.leftWidth_ = 0.0f;
                this.rightWidth_ = 0.0f;
                this.dkappa_ = 0.0f;
                this.ddkappa_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_PathPoint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PathPoint getDefaultInstanceForType() {
                return PathPoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PathPoint build() {
                PathPoint buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PathPoint buildPartial() {
                PathPoint pathPoint = new PathPoint(this);
                pathPoint.confidence_ = this.confidence_;
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.basePointBuilder_;
                if (singleFieldBuilderV3 == null) {
                    pathPoint.basePoint_ = this.basePoint_;
                } else {
                    pathPoint.basePoint_ = singleFieldBuilderV3.build();
                }
                pathPoint.theta_ = this.theta_;
                pathPoint.kappa_ = this.kappa_;
                pathPoint.s_ = this.s_;
                pathPoint.leftWidth_ = this.leftWidth_;
                pathPoint.rightWidth_ = this.rightWidth_;
                pathPoint.dkappa_ = this.dkappa_;
                pathPoint.ddkappa_ = this.ddkappa_;
                onBuilt();
                return pathPoint;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof PathPoint) {
                    return mergeFrom((PathPoint) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(PathPoint pathPoint) {
                if (pathPoint == PathPoint.getDefaultInstance()) {
                    return this;
                }
                if (pathPoint.getConfidence() != 0.0f) {
                    setConfidence(pathPoint.getConfidence());
                }
                if (pathPoint.hasBasePoint()) {
                    mergeBasePoint(pathPoint.getBasePoint());
                }
                if (pathPoint.getTheta() != 0.0f) {
                    setTheta(pathPoint.getTheta());
                }
                if (pathPoint.getKappa() != 0.0f) {
                    setKappa(pathPoint.getKappa());
                }
                if (pathPoint.getS() != 0.0f) {
                    setS(pathPoint.getS());
                }
                if (pathPoint.getLeftWidth() != 0.0f) {
                    setLeftWidth(pathPoint.getLeftWidth());
                }
                if (pathPoint.getRightWidth() != 0.0f) {
                    setRightWidth(pathPoint.getRightWidth());
                }
                if (pathPoint.getDkappa() != 0.0f) {
                    setDkappa(pathPoint.getDkappa());
                }
                if (pathPoint.getDdkappa() != 0.0f) {
                    setDdkappa(pathPoint.getDdkappa());
                }
                mergeUnknownFields(pathPoint.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.PathPoint.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.PathPoint.access$1600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$PathPoint r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.PathPoint) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$PathPoint r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.PathPoint) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.PathPoint.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$PathPoint$Builder");
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public float getConfidence() {
                return this.confidence_;
            }

            public Builder setConfidence(float f) {
                this.confidence_ = f;
                onChanged();
                return this;
            }

            public Builder clearConfidence() {
                this.confidence_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public boolean hasBasePoint() {
                return (this.basePointBuilder_ == null && this.basePoint_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public Primitives.Vector3D getBasePoint() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.basePointBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D = this.basePoint_;
                    return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setBasePoint(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.basePointBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    this.basePoint_ = vector3D;
                    onChanged();
                }
                return this;
            }

            public Builder setBasePoint(Primitives.Vector3D.Builder builder) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.basePointBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.basePoint_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeBasePoint(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.basePointBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D2 = this.basePoint_;
                    if (vector3D2 != null) {
                        this.basePoint_ = Primitives.Vector3D.newBuilder(vector3D2).mergeFrom(vector3D).buildPartial();
                    } else {
                        this.basePoint_ = vector3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(vector3D);
                }
                return this;
            }

            public Builder clearBasePoint() {
                if (this.basePointBuilder_ == null) {
                    this.basePoint_ = null;
                    onChanged();
                } else {
                    this.basePoint_ = null;
                    this.basePointBuilder_ = null;
                }
                return this;
            }

            public Primitives.Vector3D.Builder getBasePointBuilder() {
                onChanged();
                return getBasePointFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public Primitives.Vector3DOrBuilder getBasePointOrBuilder() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.basePointBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Vector3D vector3D = this.basePoint_;
                return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
            }

            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> getBasePointFieldBuilder() {
                if (this.basePointBuilder_ == null) {
                    this.basePointBuilder_ = new SingleFieldBuilderV3<>(getBasePoint(), getParentForChildren(), isClean());
                    this.basePoint_ = null;
                }
                return this.basePointBuilder_;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public float getTheta() {
                return this.theta_;
            }

            public Builder setTheta(float f) {
                this.theta_ = f;
                onChanged();
                return this;
            }

            public Builder clearTheta() {
                this.theta_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public float getKappa() {
                return this.kappa_;
            }

            public Builder setKappa(float f) {
                this.kappa_ = f;
                onChanged();
                return this;
            }

            public Builder clearKappa() {
                this.kappa_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public float getS() {
                return this.s_;
            }

            public Builder setS(float f) {
                this.s_ = f;
                onChanged();
                return this;
            }

            public Builder clearS() {
                this.s_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public float getLeftWidth() {
                return this.leftWidth_;
            }

            public Builder setLeftWidth(float f) {
                this.leftWidth_ = f;
                onChanged();
                return this;
            }

            public Builder clearLeftWidth() {
                this.leftWidth_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public float getRightWidth() {
                return this.rightWidth_;
            }

            public Builder setRightWidth(float f) {
                this.rightWidth_ = f;
                onChanged();
                return this;
            }

            public Builder clearRightWidth() {
                this.rightWidth_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public float getDkappa() {
                return this.dkappa_;
            }

            public Builder setDkappa(float f) {
                this.dkappa_ = f;
                onChanged();
                return this;
            }

            public Builder clearDkappa() {
                this.dkappa_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.PathPointOrBuilder
            public float getDdkappa() {
                return this.ddkappa_;
            }

            public Builder setDdkappa(float f) {
                this.ddkappa_ = f;
                onChanged();
                return this;
            }

            public Builder clearDdkappa() {
                this.ddkappa_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static PathPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PathPoint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PathPoint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PathPoint getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class NeighborInfo extends GeneratedMessageV3 implements NeighborInfoOrBuilder {
        public static final int ID_FIELD_NUMBER = 3;
        public static final int S_BEGIN_FIELD_NUMBER = 1;
        public static final int S_END_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int id_;
        private byte memoizedIsInitialized;
        private float sBegin_;
        private float sEnd_;
        private static final NeighborInfo DEFAULT_INSTANCE = new NeighborInfo();
        private static final Parser<NeighborInfo> PARSER = new AbstractParser<NeighborInfo>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfo.1
            @Override // com.google.protobuf.Parser
            public NeighborInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new NeighborInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private NeighborInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private NeighborInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.sBegin_ = 0.0f;
            this.sEnd_ = 0.0f;
            this.id_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private NeighborInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 13) {
                                this.sBegin_ = codedInputStream.readFloat();
                            } else if (readTag == 21) {
                                this.sEnd_ = codedInputStream.readFloat();
                            } else if (readTag == 24) {
                                this.id_ = codedInputStream.readUInt32();
                            } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_NeighborInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_NeighborInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(NeighborInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfoOrBuilder
        public float getSBegin() {
            return this.sBegin_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfoOrBuilder
        public float getSEnd() {
            return this.sEnd_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfoOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            float f = this.sBegin_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.sEnd_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(2, f2);
            }
            int i = this.id_;
            if (i != 0) {
                codedOutputStream.writeUInt32(3, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            float f = this.sBegin_;
            int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
            float f2 = this.sEnd_;
            if (f2 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(2, f2);
            }
            int i2 = this.id_;
            if (i2 != 0) {
                computeFloatSize += CodedOutputStream.computeUInt32Size(3, i2);
            }
            int serializedSize = computeFloatSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof NeighborInfo)) {
                return super.equals(obj);
            }
            NeighborInfo neighborInfo = (NeighborInfo) obj;
            return (((Float.floatToIntBits(getSBegin()) == Float.floatToIntBits(neighborInfo.getSBegin())) && Float.floatToIntBits(getSEnd()) == Float.floatToIntBits(neighborInfo.getSEnd())) && getId() == neighborInfo.getId()) && this.unknownFields.equals(neighborInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getSBegin())) * 37) + 2) * 53) + Float.floatToIntBits(getSEnd())) * 37) + 3) * 53) + getId()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static NeighborInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static NeighborInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static NeighborInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static NeighborInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static NeighborInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static NeighborInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static NeighborInfo parseFrom(InputStream inputStream) throws IOException {
            return (NeighborInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static NeighborInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (NeighborInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static NeighborInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (NeighborInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static NeighborInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (NeighborInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static NeighborInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (NeighborInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static NeighborInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (NeighborInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(NeighborInfo neighborInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(neighborInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NeighborInfoOrBuilder {
            private int id_;
            private float sBegin_;
            private float sEnd_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_NeighborInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_NeighborInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(NeighborInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = NeighborInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.sBegin_ = 0.0f;
                this.sEnd_ = 0.0f;
                this.id_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_NeighborInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NeighborInfo getDefaultInstanceForType() {
                return NeighborInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NeighborInfo build() {
                NeighborInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NeighborInfo buildPartial() {
                NeighborInfo neighborInfo = new NeighborInfo(this);
                neighborInfo.sBegin_ = this.sBegin_;
                neighborInfo.sEnd_ = this.sEnd_;
                neighborInfo.id_ = this.id_;
                onBuilt();
                return neighborInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof NeighborInfo) {
                    return mergeFrom((NeighborInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(NeighborInfo neighborInfo) {
                if (neighborInfo == NeighborInfo.getDefaultInstance()) {
                    return this;
                }
                if (neighborInfo.getSBegin() != 0.0f) {
                    setSBegin(neighborInfo.getSBegin());
                }
                if (neighborInfo.getSEnd() != 0.0f) {
                    setSEnd(neighborInfo.getSEnd());
                }
                if (neighborInfo.getId() != 0) {
                    setId(neighborInfo.getId());
                }
                mergeUnknownFields(neighborInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfo.access$2800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$NeighborInfo r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$NeighborInfo r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfo) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$NeighborInfo$Builder");
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfoOrBuilder
            public float getSBegin() {
                return this.sBegin_;
            }

            public Builder setSBegin(float f) {
                this.sBegin_ = f;
                onChanged();
                return this;
            }

            public Builder clearSBegin() {
                this.sBegin_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfoOrBuilder
            public float getSEnd() {
                return this.sEnd_;
            }

            public Builder setSEnd(float f) {
                this.sEnd_ = f;
                onChanged();
                return this;
            }

            public Builder clearSEnd() {
                this.sEnd_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.NeighborInfoOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int i) {
                this.id_ = i;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static NeighborInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NeighborInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<NeighborInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NeighborInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class SpeedLimitInfo extends GeneratedMessageV3 implements SpeedLimitInfoOrBuilder {
        private static final SpeedLimitInfo DEFAULT_INSTANCE = new SpeedLimitInfo();
        private static final Parser<SpeedLimitInfo> PARSER = new AbstractParser<SpeedLimitInfo>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfo.1
            @Override // com.google.protobuf.Parser
            public SpeedLimitInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SpeedLimitInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SPEED_LIMIT_FIELD_NUMBER = 3;
        public static final int S_BEGIN_FIELD_NUMBER = 1;
        public static final int S_END_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private float sBegin_;
        private float sEnd_;
        private float speedLimit_;

        private SpeedLimitInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private SpeedLimitInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.sBegin_ = 0.0f;
            this.sEnd_ = 0.0f;
            this.speedLimit_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SpeedLimitInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 13) {
                                this.sBegin_ = codedInputStream.readFloat();
                            } else if (readTag == 21) {
                                this.sEnd_ = codedInputStream.readFloat();
                            } else if (readTag == 29) {
                                this.speedLimit_ = codedInputStream.readFloat();
                            } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SpeedLimitInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SpeedLimitInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SpeedLimitInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfoOrBuilder
        public float getSBegin() {
            return this.sBegin_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfoOrBuilder
        public float getSEnd() {
            return this.sEnd_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfoOrBuilder
        public float getSpeedLimit() {
            return this.speedLimit_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            float f = this.sBegin_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.sEnd_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(2, f2);
            }
            float f3 = this.speedLimit_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(3, f3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            float f = this.sBegin_;
            int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
            float f2 = this.sEnd_;
            if (f2 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(2, f2);
            }
            float f3 = this.speedLimit_;
            if (f3 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(3, f3);
            }
            int serializedSize = computeFloatSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SpeedLimitInfo)) {
                return super.equals(obj);
            }
            SpeedLimitInfo speedLimitInfo = (SpeedLimitInfo) obj;
            return (((Float.floatToIntBits(getSBegin()) == Float.floatToIntBits(speedLimitInfo.getSBegin())) && Float.floatToIntBits(getSEnd()) == Float.floatToIntBits(speedLimitInfo.getSEnd())) && Float.floatToIntBits(getSpeedLimit()) == Float.floatToIntBits(speedLimitInfo.getSpeedLimit())) && this.unknownFields.equals(speedLimitInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getSBegin())) * 37) + 2) * 53) + Float.floatToIntBits(getSEnd())) * 37) + 3) * 53) + Float.floatToIntBits(getSpeedLimit())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static SpeedLimitInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SpeedLimitInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SpeedLimitInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SpeedLimitInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SpeedLimitInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SpeedLimitInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SpeedLimitInfo parseFrom(InputStream inputStream) throws IOException {
            return (SpeedLimitInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SpeedLimitInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SpeedLimitInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SpeedLimitInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SpeedLimitInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SpeedLimitInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SpeedLimitInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SpeedLimitInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SpeedLimitInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SpeedLimitInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SpeedLimitInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SpeedLimitInfo speedLimitInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(speedLimitInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SpeedLimitInfoOrBuilder {
            private float sBegin_;
            private float sEnd_;
            private float speedLimit_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SpeedLimitInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SpeedLimitInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SpeedLimitInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SpeedLimitInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.sBegin_ = 0.0f;
                this.sEnd_ = 0.0f;
                this.speedLimit_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SpeedLimitInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SpeedLimitInfo getDefaultInstanceForType() {
                return SpeedLimitInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SpeedLimitInfo build() {
                SpeedLimitInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SpeedLimitInfo buildPartial() {
                SpeedLimitInfo speedLimitInfo = new SpeedLimitInfo(this);
                speedLimitInfo.sBegin_ = this.sBegin_;
                speedLimitInfo.sEnd_ = this.sEnd_;
                speedLimitInfo.speedLimit_ = this.speedLimit_;
                onBuilt();
                return speedLimitInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SpeedLimitInfo) {
                    return mergeFrom((SpeedLimitInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SpeedLimitInfo speedLimitInfo) {
                if (speedLimitInfo == SpeedLimitInfo.getDefaultInstance()) {
                    return this;
                }
                if (speedLimitInfo.getSBegin() != 0.0f) {
                    setSBegin(speedLimitInfo.getSBegin());
                }
                if (speedLimitInfo.getSEnd() != 0.0f) {
                    setSEnd(speedLimitInfo.getSEnd());
                }
                if (speedLimitInfo.getSpeedLimit() != 0.0f) {
                    setSpeedLimit(speedLimitInfo.getSpeedLimit());
                }
                mergeUnknownFields(speedLimitInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfo.access$4000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$SpeedLimitInfo r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$SpeedLimitInfo r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfo) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$SpeedLimitInfo$Builder");
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfoOrBuilder
            public float getSBegin() {
                return this.sBegin_;
            }

            public Builder setSBegin(float f) {
                this.sBegin_ = f;
                onChanged();
                return this;
            }

            public Builder clearSBegin() {
                this.sBegin_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfoOrBuilder
            public float getSEnd() {
                return this.sEnd_;
            }

            public Builder setSEnd(float f) {
                this.sEnd_ = f;
                onChanged();
                return this;
            }

            public Builder clearSEnd() {
                this.sEnd_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SpeedLimitInfoOrBuilder
            public float getSpeedLimit() {
                return this.speedLimit_;
            }

            public Builder setSpeedLimit(float f) {
                this.speedLimit_ = f;
                onChanged();
                return this;
            }

            public Builder clearSpeedLimit() {
                this.speedLimit_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static SpeedLimitInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SpeedLimitInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SpeedLimitInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SpeedLimitInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class LaneTypeInfo extends GeneratedMessageV3 implements LaneTypeInfoOrBuilder {
        public static final int LANE_TYPE_FIELD_NUMBER = 3;
        public static final int S_BEGIN_FIELD_NUMBER = 1;
        public static final int S_END_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int laneType_;
        private byte memoizedIsInitialized;
        private float sBegin_;
        private float sEnd_;
        private static final LaneTypeInfo DEFAULT_INSTANCE = new LaneTypeInfo();
        private static final Parser<LaneTypeInfo> PARSER = new AbstractParser<LaneTypeInfo>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfo.1
            @Override // com.google.protobuf.Parser
            public LaneTypeInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LaneTypeInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private LaneTypeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private LaneTypeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.sBegin_ = 0.0f;
            this.sEnd_ = 0.0f;
            this.laneType_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LaneTypeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 13) {
                                this.sBegin_ = codedInputStream.readFloat();
                            } else if (readTag == 21) {
                                this.sEnd_ = codedInputStream.readFloat();
                            } else if (readTag == 24) {
                                this.laneType_ = codedInputStream.readEnum();
                            } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneTypeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneTypeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LaneTypeInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfoOrBuilder
        public float getSBegin() {
            return this.sBegin_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfoOrBuilder
        public float getSEnd() {
            return this.sEnd_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfoOrBuilder
        public int getLaneTypeValue() {
            return this.laneType_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfoOrBuilder
        public Primitives.LaneType getLaneType() {
            Primitives.LaneType valueOf = Primitives.LaneType.valueOf(this.laneType_);
            return valueOf == null ? Primitives.LaneType.UNRECOGNIZED : valueOf;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            float f = this.sBegin_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.sEnd_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(2, f2);
            }
            if (this.laneType_ != Primitives.LaneType.LaneType_Unknown.getNumber()) {
                codedOutputStream.writeEnum(3, this.laneType_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            float f = this.sBegin_;
            int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
            float f2 = this.sEnd_;
            if (f2 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(2, f2);
            }
            if (this.laneType_ != Primitives.LaneType.LaneType_Unknown.getNumber()) {
                computeFloatSize += CodedOutputStream.computeEnumSize(3, this.laneType_);
            }
            int serializedSize = computeFloatSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LaneTypeInfo)) {
                return super.equals(obj);
            }
            LaneTypeInfo laneTypeInfo = (LaneTypeInfo) obj;
            return (((Float.floatToIntBits(getSBegin()) == Float.floatToIntBits(laneTypeInfo.getSBegin())) && Float.floatToIntBits(getSEnd()) == Float.floatToIntBits(laneTypeInfo.getSEnd())) && this.laneType_ == laneTypeInfo.laneType_) && this.unknownFields.equals(laneTypeInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getSBegin())) * 37) + 2) * 53) + Float.floatToIntBits(getSEnd())) * 37) + 3) * 53) + this.laneType_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static LaneTypeInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LaneTypeInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LaneTypeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LaneTypeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LaneTypeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LaneTypeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LaneTypeInfo parseFrom(InputStream inputStream) throws IOException {
            return (LaneTypeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LaneTypeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LaneTypeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LaneTypeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LaneTypeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LaneTypeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LaneTypeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LaneTypeInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LaneTypeInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LaneTypeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LaneTypeInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LaneTypeInfo laneTypeInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(laneTypeInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LaneTypeInfoOrBuilder {
            private int laneType_;
            private float sBegin_;
            private float sEnd_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneTypeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneTypeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LaneTypeInfo.class, Builder.class);
            }

            private Builder() {
                this.laneType_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.laneType_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LaneTypeInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.sBegin_ = 0.0f;
                this.sEnd_ = 0.0f;
                this.laneType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneTypeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LaneTypeInfo getDefaultInstanceForType() {
                return LaneTypeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LaneTypeInfo build() {
                LaneTypeInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LaneTypeInfo buildPartial() {
                LaneTypeInfo laneTypeInfo = new LaneTypeInfo(this);
                laneTypeInfo.sBegin_ = this.sBegin_;
                laneTypeInfo.sEnd_ = this.sEnd_;
                laneTypeInfo.laneType_ = this.laneType_;
                onBuilt();
                return laneTypeInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LaneTypeInfo) {
                    return mergeFrom((LaneTypeInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LaneTypeInfo laneTypeInfo) {
                if (laneTypeInfo == LaneTypeInfo.getDefaultInstance()) {
                    return this;
                }
                if (laneTypeInfo.getSBegin() != 0.0f) {
                    setSBegin(laneTypeInfo.getSBegin());
                }
                if (laneTypeInfo.getSEnd() != 0.0f) {
                    setSEnd(laneTypeInfo.getSEnd());
                }
                if (laneTypeInfo.laneType_ != 0) {
                    setLaneTypeValue(laneTypeInfo.getLaneTypeValue());
                }
                mergeUnknownFields(laneTypeInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfo.access$5200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$LaneTypeInfo r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$LaneTypeInfo r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfo) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$LaneTypeInfo$Builder");
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfoOrBuilder
            public float getSBegin() {
                return this.sBegin_;
            }

            public Builder setSBegin(float f) {
                this.sBegin_ = f;
                onChanged();
                return this;
            }

            public Builder clearSBegin() {
                this.sBegin_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfoOrBuilder
            public float getSEnd() {
                return this.sEnd_;
            }

            public Builder setSEnd(float f) {
                this.sEnd_ = f;
                onChanged();
                return this;
            }

            public Builder clearSEnd() {
                this.sEnd_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfoOrBuilder
            public int getLaneTypeValue() {
                return this.laneType_;
            }

            public Builder setLaneTypeValue(int i) {
                this.laneType_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneTypeInfoOrBuilder
            public Primitives.LaneType getLaneType() {
                Primitives.LaneType valueOf = Primitives.LaneType.valueOf(this.laneType_);
                return valueOf == null ? Primitives.LaneType.UNRECOGNIZED : valueOf;
            }

            public Builder setLaneType(Primitives.LaneType laneType) {
                if (laneType == null) {
                    throw new NullPointerException();
                }
                this.laneType_ = laneType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLaneType() {
                this.laneType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static LaneTypeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LaneTypeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LaneTypeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LaneTypeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class BoundaryInfo extends GeneratedMessageV3 implements BoundaryInfoOrBuilder {
        public static final int LINE_MARKING_COLOUR_FIELD_NUMBER = 4;
        public static final int LINE_MARKING_FIELD_NUMBER = 3;
        public static final int S_BEGIN_FIELD_NUMBER = 1;
        public static final int S_END_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int lineMarkingColour_;
        private int lineMarking_;
        private byte memoizedIsInitialized;
        private float sBegin_;
        private float sEnd_;
        private static final BoundaryInfo DEFAULT_INSTANCE = new BoundaryInfo();
        private static final Parser<BoundaryInfo> PARSER = new AbstractParser<BoundaryInfo>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfo.1
            @Override // com.google.protobuf.Parser
            public BoundaryInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new BoundaryInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private BoundaryInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private BoundaryInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.sBegin_ = 0.0f;
            this.sEnd_ = 0.0f;
            this.lineMarking_ = 0;
            this.lineMarkingColour_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BoundaryInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 13) {
                                this.sBegin_ = codedInputStream.readFloat();
                            } else if (readTag == 21) {
                                this.sEnd_ = codedInputStream.readFloat();
                            } else if (readTag == 24) {
                                this.lineMarking_ = codedInputStream.readEnum();
                            } else if (readTag == 32) {
                                this.lineMarkingColour_ = codedInputStream.readEnum();
                            } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_BoundaryInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_BoundaryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BoundaryInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
        public float getSBegin() {
            return this.sBegin_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
        public float getSEnd() {
            return this.sEnd_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
        public int getLineMarkingValue() {
            return this.lineMarking_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
        public LineMarking getLineMarking() {
            LineMarking valueOf = LineMarking.valueOf(this.lineMarking_);
            return valueOf == null ? LineMarking.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
        public int getLineMarkingColourValue() {
            return this.lineMarkingColour_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
        public LineMarkingColour getLineMarkingColour() {
            LineMarkingColour valueOf = LineMarkingColour.valueOf(this.lineMarkingColour_);
            return valueOf == null ? LineMarkingColour.UNRECOGNIZED : valueOf;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            float f = this.sBegin_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.sEnd_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(2, f2);
            }
            if (this.lineMarking_ != LineMarking.LineMarking_Unknown.getNumber()) {
                codedOutputStream.writeEnum(3, this.lineMarking_);
            }
            if (this.lineMarkingColour_ != LineMarkingColour.LineMarkingColour_None.getNumber()) {
                codedOutputStream.writeEnum(4, this.lineMarkingColour_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            float f = this.sBegin_;
            int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
            float f2 = this.sEnd_;
            if (f2 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(2, f2);
            }
            if (this.lineMarking_ != LineMarking.LineMarking_Unknown.getNumber()) {
                computeFloatSize += CodedOutputStream.computeEnumSize(3, this.lineMarking_);
            }
            if (this.lineMarkingColour_ != LineMarkingColour.LineMarkingColour_None.getNumber()) {
                computeFloatSize += CodedOutputStream.computeEnumSize(4, this.lineMarkingColour_);
            }
            int serializedSize = computeFloatSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BoundaryInfo)) {
                return super.equals(obj);
            }
            BoundaryInfo boundaryInfo = (BoundaryInfo) obj;
            return ((((Float.floatToIntBits(getSBegin()) == Float.floatToIntBits(boundaryInfo.getSBegin())) && Float.floatToIntBits(getSEnd()) == Float.floatToIntBits(boundaryInfo.getSEnd())) && this.lineMarking_ == boundaryInfo.lineMarking_) && this.lineMarkingColour_ == boundaryInfo.lineMarkingColour_) && this.unknownFields.equals(boundaryInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getSBegin())) * 37) + 2) * 53) + Float.floatToIntBits(getSEnd())) * 37) + 3) * 53) + this.lineMarking_) * 37) + 4) * 53) + this.lineMarkingColour_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static BoundaryInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static BoundaryInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static BoundaryInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static BoundaryInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static BoundaryInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static BoundaryInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static BoundaryInfo parseFrom(InputStream inputStream) throws IOException {
            return (BoundaryInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static BoundaryInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BoundaryInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BoundaryInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BoundaryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BoundaryInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BoundaryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BoundaryInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BoundaryInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static BoundaryInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BoundaryInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BoundaryInfo boundaryInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(boundaryInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BoundaryInfoOrBuilder {
            private int lineMarkingColour_;
            private int lineMarking_;
            private float sBegin_;
            private float sEnd_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_BoundaryInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_BoundaryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BoundaryInfo.class, Builder.class);
            }

            private Builder() {
                this.lineMarking_ = 0;
                this.lineMarkingColour_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.lineMarking_ = 0;
                this.lineMarkingColour_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = BoundaryInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.sBegin_ = 0.0f;
                this.sEnd_ = 0.0f;
                this.lineMarking_ = 0;
                this.lineMarkingColour_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_BoundaryInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BoundaryInfo getDefaultInstanceForType() {
                return BoundaryInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BoundaryInfo build() {
                BoundaryInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BoundaryInfo buildPartial() {
                BoundaryInfo boundaryInfo = new BoundaryInfo(this);
                boundaryInfo.sBegin_ = this.sBegin_;
                boundaryInfo.sEnd_ = this.sEnd_;
                boundaryInfo.lineMarking_ = this.lineMarking_;
                boundaryInfo.lineMarkingColour_ = this.lineMarkingColour_;
                onBuilt();
                return boundaryInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof BoundaryInfo) {
                    return mergeFrom((BoundaryInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(BoundaryInfo boundaryInfo) {
                if (boundaryInfo == BoundaryInfo.getDefaultInstance()) {
                    return this;
                }
                if (boundaryInfo.getSBegin() != 0.0f) {
                    setSBegin(boundaryInfo.getSBegin());
                }
                if (boundaryInfo.getSEnd() != 0.0f) {
                    setSEnd(boundaryInfo.getSEnd());
                }
                if (boundaryInfo.lineMarking_ != 0) {
                    setLineMarkingValue(boundaryInfo.getLineMarkingValue());
                }
                if (boundaryInfo.lineMarkingColour_ != 0) {
                    setLineMarkingColourValue(boundaryInfo.getLineMarkingColourValue());
                }
                mergeUnknownFields(boundaryInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfo.access$6500()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$BoundaryInfo r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$BoundaryInfo r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfo) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$BoundaryInfo$Builder");
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
            public float getSBegin() {
                return this.sBegin_;
            }

            public Builder setSBegin(float f) {
                this.sBegin_ = f;
                onChanged();
                return this;
            }

            public Builder clearSBegin() {
                this.sBegin_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
            public float getSEnd() {
                return this.sEnd_;
            }

            public Builder setSEnd(float f) {
                this.sEnd_ = f;
                onChanged();
                return this;
            }

            public Builder clearSEnd() {
                this.sEnd_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
            public int getLineMarkingValue() {
                return this.lineMarking_;
            }

            public Builder setLineMarkingValue(int i) {
                this.lineMarking_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
            public LineMarking getLineMarking() {
                LineMarking valueOf = LineMarking.valueOf(this.lineMarking_);
                return valueOf == null ? LineMarking.UNRECOGNIZED : valueOf;
            }

            public Builder setLineMarking(LineMarking lineMarking) {
                if (lineMarking == null) {
                    throw new NullPointerException();
                }
                this.lineMarking_ = lineMarking.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLineMarking() {
                this.lineMarking_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
            public int getLineMarkingColourValue() {
                return this.lineMarkingColour_;
            }

            public Builder setLineMarkingColourValue(int i) {
                this.lineMarkingColour_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.BoundaryInfoOrBuilder
            public LineMarkingColour getLineMarkingColour() {
                LineMarkingColour valueOf = LineMarkingColour.valueOf(this.lineMarkingColour_);
                return valueOf == null ? LineMarkingColour.UNRECOGNIZED : valueOf;
            }

            public Builder setLineMarkingColour(LineMarkingColour lineMarkingColour) {
                if (lineMarkingColour == null) {
                    throw new NullPointerException();
                }
                this.lineMarkingColour_ = lineMarkingColour.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLineMarkingColour() {
                this.lineMarkingColour_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static BoundaryInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BoundaryInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BoundaryInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BoundaryInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class SplitMergeInfo extends GeneratedMessageV3 implements SplitMergeInfoOrBuilder {
        public static final int ID_FIELD_NUMBER = 1;
        public static final int OVERLAP_S_RANGE_FIELD_NUMBER = 3;
        public static final int S_OFFSET_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int id_;
        private byte memoizedIsInitialized;
        private float overlapSRange_;
        private float sOffset_;
        private static final SplitMergeInfo DEFAULT_INSTANCE = new SplitMergeInfo();
        private static final Parser<SplitMergeInfo> PARSER = new AbstractParser<SplitMergeInfo>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfo.1
            @Override // com.google.protobuf.Parser
            public SplitMergeInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SplitMergeInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private SplitMergeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private SplitMergeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.id_ = 0;
            this.sOffset_ = 0.0f;
            this.overlapSRange_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SplitMergeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.id_ = codedInputStream.readUInt32();
                            } else if (readTag == 21) {
                                this.sOffset_ = codedInputStream.readFloat();
                            } else if (readTag == 29) {
                                this.overlapSRange_ = codedInputStream.readFloat();
                            } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SplitMergeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SplitMergeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SplitMergeInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfoOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfoOrBuilder
        public float getSOffset() {
            return this.sOffset_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfoOrBuilder
        public float getOverlapSRange() {
            return this.overlapSRange_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.id_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            float f = this.sOffset_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(2, f);
            }
            float f2 = this.overlapSRange_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(3, f2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.id_;
            int computeUInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeUInt32Size(1, i2) : 0;
            float f = this.sOffset_;
            if (f != 0.0f) {
                computeUInt32Size += CodedOutputStream.computeFloatSize(2, f);
            }
            float f2 = this.overlapSRange_;
            if (f2 != 0.0f) {
                computeUInt32Size += CodedOutputStream.computeFloatSize(3, f2);
            }
            int serializedSize = computeUInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SplitMergeInfo)) {
                return super.equals(obj);
            }
            SplitMergeInfo splitMergeInfo = (SplitMergeInfo) obj;
            return (((getId() == splitMergeInfo.getId()) && Float.floatToIntBits(getSOffset()) == Float.floatToIntBits(splitMergeInfo.getSOffset())) && Float.floatToIntBits(getOverlapSRange()) == Float.floatToIntBits(splitMergeInfo.getOverlapSRange())) && this.unknownFields.equals(splitMergeInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getId()) * 37) + 2) * 53) + Float.floatToIntBits(getSOffset())) * 37) + 3) * 53) + Float.floatToIntBits(getOverlapSRange())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static SplitMergeInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SplitMergeInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SplitMergeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SplitMergeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SplitMergeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SplitMergeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SplitMergeInfo parseFrom(InputStream inputStream) throws IOException {
            return (SplitMergeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SplitMergeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SplitMergeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SplitMergeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SplitMergeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SplitMergeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SplitMergeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SplitMergeInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SplitMergeInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SplitMergeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SplitMergeInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SplitMergeInfo splitMergeInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(splitMergeInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SplitMergeInfoOrBuilder {
            private int id_;
            private float overlapSRange_;
            private float sOffset_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SplitMergeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SplitMergeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SplitMergeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SplitMergeInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.sOffset_ = 0.0f;
                this.overlapSRange_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_SplitMergeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SplitMergeInfo getDefaultInstanceForType() {
                return SplitMergeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SplitMergeInfo build() {
                SplitMergeInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SplitMergeInfo buildPartial() {
                SplitMergeInfo splitMergeInfo = new SplitMergeInfo(this);
                splitMergeInfo.id_ = this.id_;
                splitMergeInfo.sOffset_ = this.sOffset_;
                splitMergeInfo.overlapSRange_ = this.overlapSRange_;
                onBuilt();
                return splitMergeInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SplitMergeInfo) {
                    return mergeFrom((SplitMergeInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SplitMergeInfo splitMergeInfo) {
                if (splitMergeInfo == SplitMergeInfo.getDefaultInstance()) {
                    return this;
                }
                if (splitMergeInfo.getId() != 0) {
                    setId(splitMergeInfo.getId());
                }
                if (splitMergeInfo.getSOffset() != 0.0f) {
                    setSOffset(splitMergeInfo.getSOffset());
                }
                if (splitMergeInfo.getOverlapSRange() != 0.0f) {
                    setOverlapSRange(splitMergeInfo.getOverlapSRange());
                }
                mergeUnknownFields(splitMergeInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfo.access$7700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$SplitMergeInfo r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$SplitMergeInfo r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfo) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$SplitMergeInfo$Builder");
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfoOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int i) {
                this.id_ = i;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfoOrBuilder
            public float getSOffset() {
                return this.sOffset_;
            }

            public Builder setSOffset(float f) {
                this.sOffset_ = f;
                onChanged();
                return this;
            }

            public Builder clearSOffset() {
                this.sOffset_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.SplitMergeInfoOrBuilder
            public float getOverlapSRange() {
                return this.overlapSRange_;
            }

            public Builder setOverlapSRange(float f) {
                this.overlapSRange_ = f;
                onChanged();
                return this;
            }

            public Builder clearOverlapSRange() {
                this.overlapSRange_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static SplitMergeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SplitMergeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SplitMergeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SplitMergeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class LaneLineInfo extends GeneratedMessageV3 implements LaneLineInfoOrBuilder {
        public static final int CONFIDENCE_FIELD_NUMBER = 12;
        public static final int LANE_PRIORITY_FIELD_NUMBER = 11;
        public static final int LANE_TYPE_FIELD_NUMBER = 6;
        public static final int LEFT_BOUNDARY_TYPE_FIELD_NUMBER = 7;
        public static final int LEFT_NEIGHBOR_FIELD_NUMBER = 3;
        public static final int MERGE_INFO_FIELD_NUMBER = 10;
        public static final int PATH_POINTS_FIELD_NUMBER = 2;
        public static final int POSITION_LANE_TYPE_FIELD_NUMBER = 13;
        public static final int RIGHT_BOUNDARY_TYPE_FIELD_NUMBER = 8;
        public static final int RIGHT_NEIGHBOR_FIELD_NUMBER = 4;
        public static final int SPEED_LIMIT_FIELD_NUMBER = 5;
        public static final int SPLIT_INFO_FIELD_NUMBER = 9;
        public static final int TRACK_ID_FIELD_NUMBER = 1;
        public static final int XPU_CDU_LANE_COLOR_FIELD_NUMBER = 14;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private float confidence_;
        private int lanePriority_;
        private List<LaneTypeInfo> laneType_;
        private List<BoundaryInfo> leftBoundaryType_;
        private List<NeighborInfo> leftNeighbor_;
        private byte memoizedIsInitialized;
        private SplitMergeInfo mergeInfo_;
        private List<PathPoint> pathPoints_;
        private int positionLaneType_;
        private List<BoundaryInfo> rightBoundaryType_;
        private List<NeighborInfo> rightNeighbor_;
        private List<SpeedLimitInfo> speedLimit_;
        private SplitMergeInfo splitInfo_;
        private int trackId_;
        private int xpuCduLaneColor_;
        private static final LaneLineInfo DEFAULT_INSTANCE = new LaneLineInfo();
        private static final Parser<LaneLineInfo> PARSER = new AbstractParser<LaneLineInfo>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfo.1
            @Override // com.google.protobuf.Parser
            public LaneLineInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LaneLineInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private LaneLineInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private LaneLineInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.trackId_ = 0;
            this.pathPoints_ = Collections.emptyList();
            this.leftNeighbor_ = Collections.emptyList();
            this.rightNeighbor_ = Collections.emptyList();
            this.speedLimit_ = Collections.emptyList();
            this.laneType_ = Collections.emptyList();
            this.leftBoundaryType_ = Collections.emptyList();
            this.rightBoundaryType_ = Collections.emptyList();
            this.lanePriority_ = 0;
            this.confidence_ = 0.0f;
            this.positionLaneType_ = 0;
            this.xpuCduLaneColor_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
        private LaneLineInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            SplitMergeInfo.Builder builder;
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r3 = 128;
                if (z) {
                    return;
                }
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.trackId_ = codedInputStream.readUInt32();
                                continue;
                            case 18:
                                if (!(z2 & true)) {
                                    this.pathPoints_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.pathPoints_.add(codedInputStream.readMessage(PathPoint.parser(), extensionRegistryLite));
                                continue;
                            case 26:
                                if (!(z2 & true)) {
                                    this.leftNeighbor_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.leftNeighbor_.add(codedInputStream.readMessage(NeighborInfo.parser(), extensionRegistryLite));
                                continue;
                            case 34:
                                if (!(z2 & true)) {
                                    this.rightNeighbor_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.rightNeighbor_.add(codedInputStream.readMessage(NeighborInfo.parser(), extensionRegistryLite));
                                continue;
                            case 42:
                                if (!(z2 & true)) {
                                    this.speedLimit_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.speedLimit_.add(codedInputStream.readMessage(SpeedLimitInfo.parser(), extensionRegistryLite));
                                continue;
                            case 50:
                                if (!(z2 & true)) {
                                    this.laneType_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.laneType_.add(codedInputStream.readMessage(LaneTypeInfo.parser(), extensionRegistryLite));
                                continue;
                            case 58:
                                if (!(z2 & true)) {
                                    this.leftBoundaryType_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.leftBoundaryType_.add(codedInputStream.readMessage(BoundaryInfo.parser(), extensionRegistryLite));
                                continue;
                            case 66:
                                if (!(z2 & true)) {
                                    this.rightBoundaryType_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.rightBoundaryType_.add(codedInputStream.readMessage(BoundaryInfo.parser(), extensionRegistryLite));
                                continue;
                            case 74:
                                builder = this.splitInfo_ != null ? this.splitInfo_.toBuilder() : null;
                                this.splitInfo_ = (SplitMergeInfo) codedInputStream.readMessage(SplitMergeInfo.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.splitInfo_);
                                    this.splitInfo_ = builder.buildPartial();
                                } else {
                                    continue;
                                }
                            case 82:
                                builder = this.mergeInfo_ != null ? this.mergeInfo_.toBuilder() : null;
                                this.mergeInfo_ = (SplitMergeInfo) codedInputStream.readMessage(SplitMergeInfo.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.mergeInfo_);
                                    this.mergeInfo_ = builder.buildPartial();
                                } else {
                                    continue;
                                }
                            case 88:
                                this.lanePriority_ = codedInputStream.readUInt32();
                                continue;
                            case 101:
                                this.confidence_ = codedInputStream.readFloat();
                                continue;
                            case 104:
                                this.positionLaneType_ = codedInputStream.readEnum();
                                continue;
                            case 112:
                                this.xpuCduLaneColor_ = codedInputStream.readUInt32();
                                continue;
                            default:
                                r3 = parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag);
                                if (r3 == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.pathPoints_ = Collections.unmodifiableList(this.pathPoints_);
                    }
                    if (z2 & true) {
                        this.leftNeighbor_ = Collections.unmodifiableList(this.leftNeighbor_);
                    }
                    if (z2 & true) {
                        this.rightNeighbor_ = Collections.unmodifiableList(this.rightNeighbor_);
                    }
                    if (z2 & true) {
                        this.speedLimit_ = Collections.unmodifiableList(this.speedLimit_);
                    }
                    if (z2 & true) {
                        this.laneType_ = Collections.unmodifiableList(this.laneType_);
                    }
                    if (z2 & true) {
                        this.leftBoundaryType_ = Collections.unmodifiableList(this.leftBoundaryType_);
                    }
                    if ((z2 & true) == r3) {
                        this.rightBoundaryType_ = Collections.unmodifiableList(this.rightBoundaryType_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneLineInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneLineInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LaneLineInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getTrackId() {
            return this.trackId_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<PathPoint> getPathPointsList() {
            return this.pathPoints_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<? extends PathPointOrBuilder> getPathPointsOrBuilderList() {
            return this.pathPoints_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getPathPointsCount() {
            return this.pathPoints_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public PathPoint getPathPoints(int i) {
            return this.pathPoints_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public PathPointOrBuilder getPathPointsOrBuilder(int i) {
            return this.pathPoints_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<NeighborInfo> getLeftNeighborList() {
            return this.leftNeighbor_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<? extends NeighborInfoOrBuilder> getLeftNeighborOrBuilderList() {
            return this.leftNeighbor_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getLeftNeighborCount() {
            return this.leftNeighbor_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public NeighborInfo getLeftNeighbor(int i) {
            return this.leftNeighbor_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public NeighborInfoOrBuilder getLeftNeighborOrBuilder(int i) {
            return this.leftNeighbor_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<NeighborInfo> getRightNeighborList() {
            return this.rightNeighbor_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<? extends NeighborInfoOrBuilder> getRightNeighborOrBuilderList() {
            return this.rightNeighbor_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getRightNeighborCount() {
            return this.rightNeighbor_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public NeighborInfo getRightNeighbor(int i) {
            return this.rightNeighbor_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public NeighborInfoOrBuilder getRightNeighborOrBuilder(int i) {
            return this.rightNeighbor_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<SpeedLimitInfo> getSpeedLimitList() {
            return this.speedLimit_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<? extends SpeedLimitInfoOrBuilder> getSpeedLimitOrBuilderList() {
            return this.speedLimit_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getSpeedLimitCount() {
            return this.speedLimit_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public SpeedLimitInfo getSpeedLimit(int i) {
            return this.speedLimit_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public SpeedLimitInfoOrBuilder getSpeedLimitOrBuilder(int i) {
            return this.speedLimit_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<LaneTypeInfo> getLaneTypeList() {
            return this.laneType_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<? extends LaneTypeInfoOrBuilder> getLaneTypeOrBuilderList() {
            return this.laneType_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getLaneTypeCount() {
            return this.laneType_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public LaneTypeInfo getLaneType(int i) {
            return this.laneType_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public LaneTypeInfoOrBuilder getLaneTypeOrBuilder(int i) {
            return this.laneType_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<BoundaryInfo> getLeftBoundaryTypeList() {
            return this.leftBoundaryType_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<? extends BoundaryInfoOrBuilder> getLeftBoundaryTypeOrBuilderList() {
            return this.leftBoundaryType_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getLeftBoundaryTypeCount() {
            return this.leftBoundaryType_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public BoundaryInfo getLeftBoundaryType(int i) {
            return this.leftBoundaryType_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public BoundaryInfoOrBuilder getLeftBoundaryTypeOrBuilder(int i) {
            return this.leftBoundaryType_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<BoundaryInfo> getRightBoundaryTypeList() {
            return this.rightBoundaryType_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public List<? extends BoundaryInfoOrBuilder> getRightBoundaryTypeOrBuilderList() {
            return this.rightBoundaryType_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getRightBoundaryTypeCount() {
            return this.rightBoundaryType_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public BoundaryInfo getRightBoundaryType(int i) {
            return this.rightBoundaryType_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public BoundaryInfoOrBuilder getRightBoundaryTypeOrBuilder(int i) {
            return this.rightBoundaryType_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public boolean hasSplitInfo() {
            return this.splitInfo_ != null;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public SplitMergeInfo getSplitInfo() {
            SplitMergeInfo splitMergeInfo = this.splitInfo_;
            return splitMergeInfo == null ? SplitMergeInfo.getDefaultInstance() : splitMergeInfo;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public SplitMergeInfoOrBuilder getSplitInfoOrBuilder() {
            return getSplitInfo();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public boolean hasMergeInfo() {
            return this.mergeInfo_ != null;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public SplitMergeInfo getMergeInfo() {
            SplitMergeInfo splitMergeInfo = this.mergeInfo_;
            return splitMergeInfo == null ? SplitMergeInfo.getDefaultInstance() : splitMergeInfo;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public SplitMergeInfoOrBuilder getMergeInfoOrBuilder() {
            return getMergeInfo();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getLanePriority() {
            return this.lanePriority_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public float getConfidence() {
            return this.confidence_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getPositionLaneTypeValue() {
            return this.positionLaneType_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public Primitives.LaneType_P getPositionLaneType() {
            Primitives.LaneType_P valueOf = Primitives.LaneType_P.valueOf(this.positionLaneType_);
            return valueOf == null ? Primitives.LaneType_P.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
        public int getXpuCduLaneColor() {
            return this.xpuCduLaneColor_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.trackId_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            for (int i2 = 0; i2 < this.pathPoints_.size(); i2++) {
                codedOutputStream.writeMessage(2, this.pathPoints_.get(i2));
            }
            for (int i3 = 0; i3 < this.leftNeighbor_.size(); i3++) {
                codedOutputStream.writeMessage(3, this.leftNeighbor_.get(i3));
            }
            for (int i4 = 0; i4 < this.rightNeighbor_.size(); i4++) {
                codedOutputStream.writeMessage(4, this.rightNeighbor_.get(i4));
            }
            for (int i5 = 0; i5 < this.speedLimit_.size(); i5++) {
                codedOutputStream.writeMessage(5, this.speedLimit_.get(i5));
            }
            for (int i6 = 0; i6 < this.laneType_.size(); i6++) {
                codedOutputStream.writeMessage(6, this.laneType_.get(i6));
            }
            for (int i7 = 0; i7 < this.leftBoundaryType_.size(); i7++) {
                codedOutputStream.writeMessage(7, this.leftBoundaryType_.get(i7));
            }
            for (int i8 = 0; i8 < this.rightBoundaryType_.size(); i8++) {
                codedOutputStream.writeMessage(8, this.rightBoundaryType_.get(i8));
            }
            if (this.splitInfo_ != null) {
                codedOutputStream.writeMessage(9, getSplitInfo());
            }
            if (this.mergeInfo_ != null) {
                codedOutputStream.writeMessage(10, getMergeInfo());
            }
            int i9 = this.lanePriority_;
            if (i9 != 0) {
                codedOutputStream.writeUInt32(11, i9);
            }
            float f = this.confidence_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(12, f);
            }
            if (this.positionLaneType_ != Primitives.LaneType_P.EGO_LANE.getNumber()) {
                codedOutputStream.writeEnum(13, this.positionLaneType_);
            }
            int i10 = this.xpuCduLaneColor_;
            if (i10 != 0) {
                codedOutputStream.writeUInt32(14, i10);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.trackId_;
            int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
            for (int i3 = 0; i3 < this.pathPoints_.size(); i3++) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(2, this.pathPoints_.get(i3));
            }
            for (int i4 = 0; i4 < this.leftNeighbor_.size(); i4++) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(3, this.leftNeighbor_.get(i4));
            }
            for (int i5 = 0; i5 < this.rightNeighbor_.size(); i5++) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(4, this.rightNeighbor_.get(i5));
            }
            for (int i6 = 0; i6 < this.speedLimit_.size(); i6++) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(5, this.speedLimit_.get(i6));
            }
            for (int i7 = 0; i7 < this.laneType_.size(); i7++) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(6, this.laneType_.get(i7));
            }
            for (int i8 = 0; i8 < this.leftBoundaryType_.size(); i8++) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(7, this.leftBoundaryType_.get(i8));
            }
            for (int i9 = 0; i9 < this.rightBoundaryType_.size(); i9++) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(8, this.rightBoundaryType_.get(i9));
            }
            if (this.splitInfo_ != null) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(9, getSplitInfo());
            }
            if (this.mergeInfo_ != null) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(10, getMergeInfo());
            }
            int i10 = this.lanePriority_;
            if (i10 != 0) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(11, i10);
            }
            float f = this.confidence_;
            if (f != 0.0f) {
                computeUInt32Size += CodedOutputStream.computeFloatSize(12, f);
            }
            if (this.positionLaneType_ != Primitives.LaneType_P.EGO_LANE.getNumber()) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(13, this.positionLaneType_);
            }
            int i11 = this.xpuCduLaneColor_;
            if (i11 != 0) {
                computeUInt32Size += CodedOutputStream.computeUInt32Size(14, i11);
            }
            int serializedSize = computeUInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LaneLineInfo)) {
                return super.equals(obj);
            }
            LaneLineInfo laneLineInfo = (LaneLineInfo) obj;
            boolean z = ((((((((getTrackId() == laneLineInfo.getTrackId()) && getPathPointsList().equals(laneLineInfo.getPathPointsList())) && getLeftNeighborList().equals(laneLineInfo.getLeftNeighborList())) && getRightNeighborList().equals(laneLineInfo.getRightNeighborList())) && getSpeedLimitList().equals(laneLineInfo.getSpeedLimitList())) && getLaneTypeList().equals(laneLineInfo.getLaneTypeList())) && getLeftBoundaryTypeList().equals(laneLineInfo.getLeftBoundaryTypeList())) && getRightBoundaryTypeList().equals(laneLineInfo.getRightBoundaryTypeList())) && hasSplitInfo() == laneLineInfo.hasSplitInfo();
            if (hasSplitInfo()) {
                z = z && getSplitInfo().equals(laneLineInfo.getSplitInfo());
            }
            boolean z2 = z && hasMergeInfo() == laneLineInfo.hasMergeInfo();
            if (hasMergeInfo()) {
                z2 = z2 && getMergeInfo().equals(laneLineInfo.getMergeInfo());
            }
            return ((((z2 && getLanePriority() == laneLineInfo.getLanePriority()) && Float.floatToIntBits(getConfidence()) == Float.floatToIntBits(laneLineInfo.getConfidence())) && this.positionLaneType_ == laneLineInfo.positionLaneType_) && getXpuCduLaneColor() == laneLineInfo.getXpuCduLaneColor()) && this.unknownFields.equals(laneLineInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getTrackId();
            if (getPathPointsCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getPathPointsList().hashCode();
            }
            if (getLeftNeighborCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getLeftNeighborList().hashCode();
            }
            if (getRightNeighborCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getRightNeighborList().hashCode();
            }
            if (getSpeedLimitCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getSpeedLimitList().hashCode();
            }
            if (getLaneTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getLaneTypeList().hashCode();
            }
            if (getLeftBoundaryTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 7) * 53) + getLeftBoundaryTypeList().hashCode();
            }
            if (getRightBoundaryTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 8) * 53) + getRightBoundaryTypeList().hashCode();
            }
            if (hasSplitInfo()) {
                hashCode = (((hashCode * 37) + 9) * 53) + getSplitInfo().hashCode();
            }
            if (hasMergeInfo()) {
                hashCode = (((hashCode * 37) + 10) * 53) + getMergeInfo().hashCode();
            }
            int lanePriority = (((((((((((((((((hashCode * 37) + 11) * 53) + getLanePriority()) * 37) + 12) * 53) + Float.floatToIntBits(getConfidence())) * 37) + 13) * 53) + this.positionLaneType_) * 37) + 14) * 53) + getXpuCduLaneColor()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = lanePriority;
            return lanePriority;
        }

        public static LaneLineInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LaneLineInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LaneLineInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LaneLineInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LaneLineInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LaneLineInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LaneLineInfo parseFrom(InputStream inputStream) throws IOException {
            return (LaneLineInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LaneLineInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LaneLineInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LaneLineInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LaneLineInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LaneLineInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LaneLineInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LaneLineInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LaneLineInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LaneLineInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LaneLineInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LaneLineInfo laneLineInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(laneLineInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LaneLineInfoOrBuilder {
            private int bitField0_;
            private float confidence_;
            private int lanePriority_;
            private RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> laneTypeBuilder_;
            private List<LaneTypeInfo> laneType_;
            private RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> leftBoundaryTypeBuilder_;
            private List<BoundaryInfo> leftBoundaryType_;
            private RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> leftNeighborBuilder_;
            private List<NeighborInfo> leftNeighbor_;
            private SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> mergeInfoBuilder_;
            private SplitMergeInfo mergeInfo_;
            private RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> pathPointsBuilder_;
            private List<PathPoint> pathPoints_;
            private int positionLaneType_;
            private RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> rightBoundaryTypeBuilder_;
            private List<BoundaryInfo> rightBoundaryType_;
            private RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> rightNeighborBuilder_;
            private List<NeighborInfo> rightNeighbor_;
            private RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> speedLimitBuilder_;
            private List<SpeedLimitInfo> speedLimit_;
            private SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> splitInfoBuilder_;
            private SplitMergeInfo splitInfo_;
            private int trackId_;
            private int xpuCduLaneColor_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneLineInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneLineInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LaneLineInfo.class, Builder.class);
            }

            private Builder() {
                this.pathPoints_ = Collections.emptyList();
                this.leftNeighbor_ = Collections.emptyList();
                this.rightNeighbor_ = Collections.emptyList();
                this.speedLimit_ = Collections.emptyList();
                this.laneType_ = Collections.emptyList();
                this.leftBoundaryType_ = Collections.emptyList();
                this.rightBoundaryType_ = Collections.emptyList();
                this.splitInfo_ = null;
                this.mergeInfo_ = null;
                this.positionLaneType_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.pathPoints_ = Collections.emptyList();
                this.leftNeighbor_ = Collections.emptyList();
                this.rightNeighbor_ = Collections.emptyList();
                this.speedLimit_ = Collections.emptyList();
                this.laneType_ = Collections.emptyList();
                this.leftBoundaryType_ = Collections.emptyList();
                this.rightBoundaryType_ = Collections.emptyList();
                this.splitInfo_ = null;
                this.mergeInfo_ = null;
                this.positionLaneType_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LaneLineInfo.alwaysUseFieldBuilders) {
                    getPathPointsFieldBuilder();
                    getLeftNeighborFieldBuilder();
                    getRightNeighborFieldBuilder();
                    getSpeedLimitFieldBuilder();
                    getLaneTypeFieldBuilder();
                    getLeftBoundaryTypeFieldBuilder();
                    getRightBoundaryTypeFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.trackId_ = 0;
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.pathPoints_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV32 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV32 == null) {
                    this.leftNeighbor_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    repeatedFieldBuilderV32.clear();
                }
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV33 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV33 == null) {
                    this.rightNeighbor_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    repeatedFieldBuilderV33.clear();
                }
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV34 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV34 == null) {
                    this.speedLimit_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    repeatedFieldBuilderV34.clear();
                }
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV35 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV35 == null) {
                    this.laneType_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    repeatedFieldBuilderV35.clear();
                }
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV36 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV36 == null) {
                    this.leftBoundaryType_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    repeatedFieldBuilderV36.clear();
                }
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV37 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV37 == null) {
                    this.rightBoundaryType_ = Collections.emptyList();
                    this.bitField0_ &= -129;
                } else {
                    repeatedFieldBuilderV37.clear();
                }
                if (this.splitInfoBuilder_ == null) {
                    this.splitInfo_ = null;
                } else {
                    this.splitInfo_ = null;
                    this.splitInfoBuilder_ = null;
                }
                if (this.mergeInfoBuilder_ == null) {
                    this.mergeInfo_ = null;
                } else {
                    this.mergeInfo_ = null;
                    this.mergeInfoBuilder_ = null;
                }
                this.lanePriority_ = 0;
                this.confidence_ = 0.0f;
                this.positionLaneType_ = 0;
                this.xpuCduLaneColor_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneLineInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LaneLineInfo getDefaultInstanceForType() {
                return LaneLineInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LaneLineInfo build() {
                LaneLineInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LaneLineInfo buildPartial() {
                LaneLineInfo laneLineInfo = new LaneLineInfo(this);
                int i = this.bitField0_;
                laneLineInfo.trackId_ = this.trackId_;
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    laneLineInfo.pathPoints_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 2) == 2) {
                        this.pathPoints_ = Collections.unmodifiableList(this.pathPoints_);
                        this.bitField0_ &= -3;
                    }
                    laneLineInfo.pathPoints_ = this.pathPoints_;
                }
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV32 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV32 != null) {
                    laneLineInfo.leftNeighbor_ = repeatedFieldBuilderV32.build();
                } else {
                    if ((this.bitField0_ & 4) == 4) {
                        this.leftNeighbor_ = Collections.unmodifiableList(this.leftNeighbor_);
                        this.bitField0_ &= -5;
                    }
                    laneLineInfo.leftNeighbor_ = this.leftNeighbor_;
                }
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV33 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV33 != null) {
                    laneLineInfo.rightNeighbor_ = repeatedFieldBuilderV33.build();
                } else {
                    if ((this.bitField0_ & 8) == 8) {
                        this.rightNeighbor_ = Collections.unmodifiableList(this.rightNeighbor_);
                        this.bitField0_ &= -9;
                    }
                    laneLineInfo.rightNeighbor_ = this.rightNeighbor_;
                }
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV34 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV34 != null) {
                    laneLineInfo.speedLimit_ = repeatedFieldBuilderV34.build();
                } else {
                    if ((this.bitField0_ & 16) == 16) {
                        this.speedLimit_ = Collections.unmodifiableList(this.speedLimit_);
                        this.bitField0_ &= -17;
                    }
                    laneLineInfo.speedLimit_ = this.speedLimit_;
                }
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV35 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV35 != null) {
                    laneLineInfo.laneType_ = repeatedFieldBuilderV35.build();
                } else {
                    if ((this.bitField0_ & 32) == 32) {
                        this.laneType_ = Collections.unmodifiableList(this.laneType_);
                        this.bitField0_ &= -33;
                    }
                    laneLineInfo.laneType_ = this.laneType_;
                }
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV36 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV36 != null) {
                    laneLineInfo.leftBoundaryType_ = repeatedFieldBuilderV36.build();
                } else {
                    if ((this.bitField0_ & 64) == 64) {
                        this.leftBoundaryType_ = Collections.unmodifiableList(this.leftBoundaryType_);
                        this.bitField0_ &= -65;
                    }
                    laneLineInfo.leftBoundaryType_ = this.leftBoundaryType_;
                }
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV37 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV37 != null) {
                    laneLineInfo.rightBoundaryType_ = repeatedFieldBuilderV37.build();
                } else {
                    if ((this.bitField0_ & 128) == 128) {
                        this.rightBoundaryType_ = Collections.unmodifiableList(this.rightBoundaryType_);
                        this.bitField0_ &= -129;
                    }
                    laneLineInfo.rightBoundaryType_ = this.rightBoundaryType_;
                }
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.splitInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    laneLineInfo.splitInfo_ = this.splitInfo_;
                } else {
                    laneLineInfo.splitInfo_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV32 = this.mergeInfoBuilder_;
                if (singleFieldBuilderV32 == null) {
                    laneLineInfo.mergeInfo_ = this.mergeInfo_;
                } else {
                    laneLineInfo.mergeInfo_ = singleFieldBuilderV32.build();
                }
                laneLineInfo.lanePriority_ = this.lanePriority_;
                laneLineInfo.confidence_ = this.confidence_;
                laneLineInfo.positionLaneType_ = this.positionLaneType_;
                laneLineInfo.xpuCduLaneColor_ = this.xpuCduLaneColor_;
                laneLineInfo.bitField0_ = 0;
                onBuilt();
                return laneLineInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LaneLineInfo) {
                    return mergeFrom((LaneLineInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LaneLineInfo laneLineInfo) {
                if (laneLineInfo == LaneLineInfo.getDefaultInstance()) {
                    return this;
                }
                if (laneLineInfo.getTrackId() != 0) {
                    setTrackId(laneLineInfo.getTrackId());
                }
                if (this.pathPointsBuilder_ == null) {
                    if (!laneLineInfo.pathPoints_.isEmpty()) {
                        if (this.pathPoints_.isEmpty()) {
                            this.pathPoints_ = laneLineInfo.pathPoints_;
                            this.bitField0_ &= -3;
                        } else {
                            ensurePathPointsIsMutable();
                            this.pathPoints_.addAll(laneLineInfo.pathPoints_);
                        }
                        onChanged();
                    }
                } else if (!laneLineInfo.pathPoints_.isEmpty()) {
                    if (!this.pathPointsBuilder_.isEmpty()) {
                        this.pathPointsBuilder_.addAllMessages(laneLineInfo.pathPoints_);
                    } else {
                        this.pathPointsBuilder_.dispose();
                        this.pathPointsBuilder_ = null;
                        this.pathPoints_ = laneLineInfo.pathPoints_;
                        this.bitField0_ &= -3;
                        this.pathPointsBuilder_ = LaneLineInfo.alwaysUseFieldBuilders ? getPathPointsFieldBuilder() : null;
                    }
                }
                if (this.leftNeighborBuilder_ == null) {
                    if (!laneLineInfo.leftNeighbor_.isEmpty()) {
                        if (this.leftNeighbor_.isEmpty()) {
                            this.leftNeighbor_ = laneLineInfo.leftNeighbor_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureLeftNeighborIsMutable();
                            this.leftNeighbor_.addAll(laneLineInfo.leftNeighbor_);
                        }
                        onChanged();
                    }
                } else if (!laneLineInfo.leftNeighbor_.isEmpty()) {
                    if (!this.leftNeighborBuilder_.isEmpty()) {
                        this.leftNeighborBuilder_.addAllMessages(laneLineInfo.leftNeighbor_);
                    } else {
                        this.leftNeighborBuilder_.dispose();
                        this.leftNeighborBuilder_ = null;
                        this.leftNeighbor_ = laneLineInfo.leftNeighbor_;
                        this.bitField0_ &= -5;
                        this.leftNeighborBuilder_ = LaneLineInfo.alwaysUseFieldBuilders ? getLeftNeighborFieldBuilder() : null;
                    }
                }
                if (this.rightNeighborBuilder_ == null) {
                    if (!laneLineInfo.rightNeighbor_.isEmpty()) {
                        if (this.rightNeighbor_.isEmpty()) {
                            this.rightNeighbor_ = laneLineInfo.rightNeighbor_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureRightNeighborIsMutable();
                            this.rightNeighbor_.addAll(laneLineInfo.rightNeighbor_);
                        }
                        onChanged();
                    }
                } else if (!laneLineInfo.rightNeighbor_.isEmpty()) {
                    if (!this.rightNeighborBuilder_.isEmpty()) {
                        this.rightNeighborBuilder_.addAllMessages(laneLineInfo.rightNeighbor_);
                    } else {
                        this.rightNeighborBuilder_.dispose();
                        this.rightNeighborBuilder_ = null;
                        this.rightNeighbor_ = laneLineInfo.rightNeighbor_;
                        this.bitField0_ &= -9;
                        this.rightNeighborBuilder_ = LaneLineInfo.alwaysUseFieldBuilders ? getRightNeighborFieldBuilder() : null;
                    }
                }
                if (this.speedLimitBuilder_ == null) {
                    if (!laneLineInfo.speedLimit_.isEmpty()) {
                        if (this.speedLimit_.isEmpty()) {
                            this.speedLimit_ = laneLineInfo.speedLimit_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureSpeedLimitIsMutable();
                            this.speedLimit_.addAll(laneLineInfo.speedLimit_);
                        }
                        onChanged();
                    }
                } else if (!laneLineInfo.speedLimit_.isEmpty()) {
                    if (!this.speedLimitBuilder_.isEmpty()) {
                        this.speedLimitBuilder_.addAllMessages(laneLineInfo.speedLimit_);
                    } else {
                        this.speedLimitBuilder_.dispose();
                        this.speedLimitBuilder_ = null;
                        this.speedLimit_ = laneLineInfo.speedLimit_;
                        this.bitField0_ &= -17;
                        this.speedLimitBuilder_ = LaneLineInfo.alwaysUseFieldBuilders ? getSpeedLimitFieldBuilder() : null;
                    }
                }
                if (this.laneTypeBuilder_ == null) {
                    if (!laneLineInfo.laneType_.isEmpty()) {
                        if (this.laneType_.isEmpty()) {
                            this.laneType_ = laneLineInfo.laneType_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureLaneTypeIsMutable();
                            this.laneType_.addAll(laneLineInfo.laneType_);
                        }
                        onChanged();
                    }
                } else if (!laneLineInfo.laneType_.isEmpty()) {
                    if (!this.laneTypeBuilder_.isEmpty()) {
                        this.laneTypeBuilder_.addAllMessages(laneLineInfo.laneType_);
                    } else {
                        this.laneTypeBuilder_.dispose();
                        this.laneTypeBuilder_ = null;
                        this.laneType_ = laneLineInfo.laneType_;
                        this.bitField0_ &= -33;
                        this.laneTypeBuilder_ = LaneLineInfo.alwaysUseFieldBuilders ? getLaneTypeFieldBuilder() : null;
                    }
                }
                if (this.leftBoundaryTypeBuilder_ == null) {
                    if (!laneLineInfo.leftBoundaryType_.isEmpty()) {
                        if (this.leftBoundaryType_.isEmpty()) {
                            this.leftBoundaryType_ = laneLineInfo.leftBoundaryType_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureLeftBoundaryTypeIsMutable();
                            this.leftBoundaryType_.addAll(laneLineInfo.leftBoundaryType_);
                        }
                        onChanged();
                    }
                } else if (!laneLineInfo.leftBoundaryType_.isEmpty()) {
                    if (!this.leftBoundaryTypeBuilder_.isEmpty()) {
                        this.leftBoundaryTypeBuilder_.addAllMessages(laneLineInfo.leftBoundaryType_);
                    } else {
                        this.leftBoundaryTypeBuilder_.dispose();
                        this.leftBoundaryTypeBuilder_ = null;
                        this.leftBoundaryType_ = laneLineInfo.leftBoundaryType_;
                        this.bitField0_ &= -65;
                        this.leftBoundaryTypeBuilder_ = LaneLineInfo.alwaysUseFieldBuilders ? getLeftBoundaryTypeFieldBuilder() : null;
                    }
                }
                if (this.rightBoundaryTypeBuilder_ == null) {
                    if (!laneLineInfo.rightBoundaryType_.isEmpty()) {
                        if (this.rightBoundaryType_.isEmpty()) {
                            this.rightBoundaryType_ = laneLineInfo.rightBoundaryType_;
                            this.bitField0_ &= -129;
                        } else {
                            ensureRightBoundaryTypeIsMutable();
                            this.rightBoundaryType_.addAll(laneLineInfo.rightBoundaryType_);
                        }
                        onChanged();
                    }
                } else if (!laneLineInfo.rightBoundaryType_.isEmpty()) {
                    if (!this.rightBoundaryTypeBuilder_.isEmpty()) {
                        this.rightBoundaryTypeBuilder_.addAllMessages(laneLineInfo.rightBoundaryType_);
                    } else {
                        this.rightBoundaryTypeBuilder_.dispose();
                        this.rightBoundaryTypeBuilder_ = null;
                        this.rightBoundaryType_ = laneLineInfo.rightBoundaryType_;
                        this.bitField0_ &= -129;
                        this.rightBoundaryTypeBuilder_ = LaneLineInfo.alwaysUseFieldBuilders ? getRightBoundaryTypeFieldBuilder() : null;
                    }
                }
                if (laneLineInfo.hasSplitInfo()) {
                    mergeSplitInfo(laneLineInfo.getSplitInfo());
                }
                if (laneLineInfo.hasMergeInfo()) {
                    mergeMergeInfo(laneLineInfo.getMergeInfo());
                }
                if (laneLineInfo.getLanePriority() != 0) {
                    setLanePriority(laneLineInfo.getLanePriority());
                }
                if (laneLineInfo.getConfidence() != 0.0f) {
                    setConfidence(laneLineInfo.getConfidence());
                }
                if (laneLineInfo.positionLaneType_ != 0) {
                    setPositionLaneTypeValue(laneLineInfo.getPositionLaneTypeValue());
                }
                if (laneLineInfo.getXpuCduLaneColor() != 0) {
                    setXpuCduLaneColor(laneLineInfo.getXpuCduLaneColor());
                }
                mergeUnknownFields(laneLineInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfo.access$10800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$LaneLineInfo r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$LaneLineInfo r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfo) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$LaneLineInfo$Builder");
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getTrackId() {
                return this.trackId_;
            }

            public Builder setTrackId(int i) {
                this.trackId_ = i;
                onChanged();
                return this;
            }

            public Builder clearTrackId() {
                this.trackId_ = 0;
                onChanged();
                return this;
            }

            private void ensurePathPointsIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.pathPoints_ = new ArrayList(this.pathPoints_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<PathPoint> getPathPointsList() {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.pathPoints_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getPathPointsCount() {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.pathPoints_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public PathPoint getPathPoints(int i) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.pathPoints_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setPathPoints(int i, PathPoint pathPoint) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, pathPoint);
                } else if (pathPoint == null) {
                    throw new NullPointerException();
                } else {
                    ensurePathPointsIsMutable();
                    this.pathPoints_.set(i, pathPoint);
                    onChanged();
                }
                return this;
            }

            public Builder setPathPoints(int i, PathPoint.Builder builder) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePathPointsIsMutable();
                    this.pathPoints_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addPathPoints(PathPoint pathPoint) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(pathPoint);
                } else if (pathPoint == null) {
                    throw new NullPointerException();
                } else {
                    ensurePathPointsIsMutable();
                    this.pathPoints_.add(pathPoint);
                    onChanged();
                }
                return this;
            }

            public Builder addPathPoints(int i, PathPoint pathPoint) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, pathPoint);
                } else if (pathPoint == null) {
                    throw new NullPointerException();
                } else {
                    ensurePathPointsIsMutable();
                    this.pathPoints_.add(i, pathPoint);
                    onChanged();
                }
                return this;
            }

            public Builder addPathPoints(PathPoint.Builder builder) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePathPointsIsMutable();
                    this.pathPoints_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addPathPoints(int i, PathPoint.Builder builder) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePathPointsIsMutable();
                    this.pathPoints_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllPathPoints(Iterable<? extends PathPoint> iterable) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePathPointsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.pathPoints_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearPathPoints() {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.pathPoints_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removePathPoints(int i) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePathPointsIsMutable();
                    this.pathPoints_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public PathPoint.Builder getPathPointsBuilder(int i) {
                return getPathPointsFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public PathPointOrBuilder getPathPointsOrBuilder(int i) {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.pathPoints_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<? extends PathPointOrBuilder> getPathPointsOrBuilderList() {
                RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> repeatedFieldBuilderV3 = this.pathPointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.pathPoints_);
            }

            public PathPoint.Builder addPathPointsBuilder() {
                return getPathPointsFieldBuilder().addBuilder(PathPoint.getDefaultInstance());
            }

            public PathPoint.Builder addPathPointsBuilder(int i) {
                return getPathPointsFieldBuilder().addBuilder(i, PathPoint.getDefaultInstance());
            }

            public List<PathPoint.Builder> getPathPointsBuilderList() {
                return getPathPointsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PathPoint, PathPoint.Builder, PathPointOrBuilder> getPathPointsFieldBuilder() {
                if (this.pathPointsBuilder_ == null) {
                    this.pathPointsBuilder_ = new RepeatedFieldBuilderV3<>(this.pathPoints_, (this.bitField0_ & 2) == 2, getParentForChildren(), isClean());
                    this.pathPoints_ = null;
                }
                return this.pathPointsBuilder_;
            }

            private void ensureLeftNeighborIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.leftNeighbor_ = new ArrayList(this.leftNeighbor_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<NeighborInfo> getLeftNeighborList() {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.leftNeighbor_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getLeftNeighborCount() {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.leftNeighbor_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public NeighborInfo getLeftNeighbor(int i) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.leftNeighbor_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setLeftNeighbor(int i, NeighborInfo neighborInfo) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, neighborInfo);
                } else if (neighborInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLeftNeighborIsMutable();
                    this.leftNeighbor_.set(i, neighborInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setLeftNeighbor(int i, NeighborInfo.Builder builder) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftNeighborIsMutable();
                    this.leftNeighbor_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addLeftNeighbor(NeighborInfo neighborInfo) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(neighborInfo);
                } else if (neighborInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLeftNeighborIsMutable();
                    this.leftNeighbor_.add(neighborInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLeftNeighbor(int i, NeighborInfo neighborInfo) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, neighborInfo);
                } else if (neighborInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLeftNeighborIsMutable();
                    this.leftNeighbor_.add(i, neighborInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLeftNeighbor(NeighborInfo.Builder builder) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftNeighborIsMutable();
                    this.leftNeighbor_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addLeftNeighbor(int i, NeighborInfo.Builder builder) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftNeighborIsMutable();
                    this.leftNeighbor_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllLeftNeighbor(Iterable<? extends NeighborInfo> iterable) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftNeighborIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.leftNeighbor_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearLeftNeighbor() {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.leftNeighbor_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeLeftNeighbor(int i) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftNeighborIsMutable();
                    this.leftNeighbor_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public NeighborInfo.Builder getLeftNeighborBuilder(int i) {
                return getLeftNeighborFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public NeighborInfoOrBuilder getLeftNeighborOrBuilder(int i) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.leftNeighbor_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<? extends NeighborInfoOrBuilder> getLeftNeighborOrBuilderList() {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.leftNeighborBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.leftNeighbor_);
            }

            public NeighborInfo.Builder addLeftNeighborBuilder() {
                return getLeftNeighborFieldBuilder().addBuilder(NeighborInfo.getDefaultInstance());
            }

            public NeighborInfo.Builder addLeftNeighborBuilder(int i) {
                return getLeftNeighborFieldBuilder().addBuilder(i, NeighborInfo.getDefaultInstance());
            }

            public List<NeighborInfo.Builder> getLeftNeighborBuilderList() {
                return getLeftNeighborFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> getLeftNeighborFieldBuilder() {
                if (this.leftNeighborBuilder_ == null) {
                    this.leftNeighborBuilder_ = new RepeatedFieldBuilderV3<>(this.leftNeighbor_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.leftNeighbor_ = null;
                }
                return this.leftNeighborBuilder_;
            }

            private void ensureRightNeighborIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.rightNeighbor_ = new ArrayList(this.rightNeighbor_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<NeighborInfo> getRightNeighborList() {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.rightNeighbor_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getRightNeighborCount() {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.rightNeighbor_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public NeighborInfo getRightNeighbor(int i) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.rightNeighbor_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setRightNeighbor(int i, NeighborInfo neighborInfo) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, neighborInfo);
                } else if (neighborInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureRightNeighborIsMutable();
                    this.rightNeighbor_.set(i, neighborInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setRightNeighbor(int i, NeighborInfo.Builder builder) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightNeighborIsMutable();
                    this.rightNeighbor_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addRightNeighbor(NeighborInfo neighborInfo) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(neighborInfo);
                } else if (neighborInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureRightNeighborIsMutable();
                    this.rightNeighbor_.add(neighborInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addRightNeighbor(int i, NeighborInfo neighborInfo) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, neighborInfo);
                } else if (neighborInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureRightNeighborIsMutable();
                    this.rightNeighbor_.add(i, neighborInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addRightNeighbor(NeighborInfo.Builder builder) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightNeighborIsMutable();
                    this.rightNeighbor_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addRightNeighbor(int i, NeighborInfo.Builder builder) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightNeighborIsMutable();
                    this.rightNeighbor_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllRightNeighbor(Iterable<? extends NeighborInfo> iterable) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightNeighborIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.rightNeighbor_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearRightNeighbor() {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.rightNeighbor_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeRightNeighbor(int i) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightNeighborIsMutable();
                    this.rightNeighbor_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public NeighborInfo.Builder getRightNeighborBuilder(int i) {
                return getRightNeighborFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public NeighborInfoOrBuilder getRightNeighborOrBuilder(int i) {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.rightNeighbor_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<? extends NeighborInfoOrBuilder> getRightNeighborOrBuilderList() {
                RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> repeatedFieldBuilderV3 = this.rightNeighborBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.rightNeighbor_);
            }

            public NeighborInfo.Builder addRightNeighborBuilder() {
                return getRightNeighborFieldBuilder().addBuilder(NeighborInfo.getDefaultInstance());
            }

            public NeighborInfo.Builder addRightNeighborBuilder(int i) {
                return getRightNeighborFieldBuilder().addBuilder(i, NeighborInfo.getDefaultInstance());
            }

            public List<NeighborInfo.Builder> getRightNeighborBuilderList() {
                return getRightNeighborFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<NeighborInfo, NeighborInfo.Builder, NeighborInfoOrBuilder> getRightNeighborFieldBuilder() {
                if (this.rightNeighborBuilder_ == null) {
                    this.rightNeighborBuilder_ = new RepeatedFieldBuilderV3<>(this.rightNeighbor_, (this.bitField0_ & 8) == 8, getParentForChildren(), isClean());
                    this.rightNeighbor_ = null;
                }
                return this.rightNeighborBuilder_;
            }

            private void ensureSpeedLimitIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.speedLimit_ = new ArrayList(this.speedLimit_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<SpeedLimitInfo> getSpeedLimitList() {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.speedLimit_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getSpeedLimitCount() {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.speedLimit_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public SpeedLimitInfo getSpeedLimit(int i) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.speedLimit_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setSpeedLimit(int i, SpeedLimitInfo speedLimitInfo) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, speedLimitInfo);
                } else if (speedLimitInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpeedLimitIsMutable();
                    this.speedLimit_.set(i, speedLimitInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setSpeedLimit(int i, SpeedLimitInfo.Builder builder) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSpeedLimitIsMutable();
                    this.speedLimit_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addSpeedLimit(SpeedLimitInfo speedLimitInfo) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(speedLimitInfo);
                } else if (speedLimitInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpeedLimitIsMutable();
                    this.speedLimit_.add(speedLimitInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addSpeedLimit(int i, SpeedLimitInfo speedLimitInfo) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, speedLimitInfo);
                } else if (speedLimitInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpeedLimitIsMutable();
                    this.speedLimit_.add(i, speedLimitInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addSpeedLimit(SpeedLimitInfo.Builder builder) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSpeedLimitIsMutable();
                    this.speedLimit_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addSpeedLimit(int i, SpeedLimitInfo.Builder builder) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSpeedLimitIsMutable();
                    this.speedLimit_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllSpeedLimit(Iterable<? extends SpeedLimitInfo> iterable) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSpeedLimitIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.speedLimit_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearSpeedLimit() {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.speedLimit_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeSpeedLimit(int i) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSpeedLimitIsMutable();
                    this.speedLimit_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public SpeedLimitInfo.Builder getSpeedLimitBuilder(int i) {
                return getSpeedLimitFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public SpeedLimitInfoOrBuilder getSpeedLimitOrBuilder(int i) {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.speedLimit_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<? extends SpeedLimitInfoOrBuilder> getSpeedLimitOrBuilderList() {
                RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> repeatedFieldBuilderV3 = this.speedLimitBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.speedLimit_);
            }

            public SpeedLimitInfo.Builder addSpeedLimitBuilder() {
                return getSpeedLimitFieldBuilder().addBuilder(SpeedLimitInfo.getDefaultInstance());
            }

            public SpeedLimitInfo.Builder addSpeedLimitBuilder(int i) {
                return getSpeedLimitFieldBuilder().addBuilder(i, SpeedLimitInfo.getDefaultInstance());
            }

            public List<SpeedLimitInfo.Builder> getSpeedLimitBuilderList() {
                return getSpeedLimitFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SpeedLimitInfo, SpeedLimitInfo.Builder, SpeedLimitInfoOrBuilder> getSpeedLimitFieldBuilder() {
                if (this.speedLimitBuilder_ == null) {
                    this.speedLimitBuilder_ = new RepeatedFieldBuilderV3<>(this.speedLimit_, (this.bitField0_ & 16) == 16, getParentForChildren(), isClean());
                    this.speedLimit_ = null;
                }
                return this.speedLimitBuilder_;
            }

            private void ensureLaneTypeIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.laneType_ = new ArrayList(this.laneType_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<LaneTypeInfo> getLaneTypeList() {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.laneType_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getLaneTypeCount() {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.laneType_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public LaneTypeInfo getLaneType(int i) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.laneType_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setLaneType(int i, LaneTypeInfo laneTypeInfo) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, laneTypeInfo);
                } else if (laneTypeInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLaneTypeIsMutable();
                    this.laneType_.set(i, laneTypeInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setLaneType(int i, LaneTypeInfo.Builder builder) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneTypeIsMutable();
                    this.laneType_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addLaneType(LaneTypeInfo laneTypeInfo) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(laneTypeInfo);
                } else if (laneTypeInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLaneTypeIsMutable();
                    this.laneType_.add(laneTypeInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLaneType(int i, LaneTypeInfo laneTypeInfo) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, laneTypeInfo);
                } else if (laneTypeInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLaneTypeIsMutable();
                    this.laneType_.add(i, laneTypeInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLaneType(LaneTypeInfo.Builder builder) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneTypeIsMutable();
                    this.laneType_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addLaneType(int i, LaneTypeInfo.Builder builder) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneTypeIsMutable();
                    this.laneType_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllLaneType(Iterable<? extends LaneTypeInfo> iterable) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneTypeIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.laneType_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearLaneType() {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.laneType_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeLaneType(int i) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneTypeIsMutable();
                    this.laneType_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public LaneTypeInfo.Builder getLaneTypeBuilder(int i) {
                return getLaneTypeFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public LaneTypeInfoOrBuilder getLaneTypeOrBuilder(int i) {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.laneType_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<? extends LaneTypeInfoOrBuilder> getLaneTypeOrBuilderList() {
                RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> repeatedFieldBuilderV3 = this.laneTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.laneType_);
            }

            public LaneTypeInfo.Builder addLaneTypeBuilder() {
                return getLaneTypeFieldBuilder().addBuilder(LaneTypeInfo.getDefaultInstance());
            }

            public LaneTypeInfo.Builder addLaneTypeBuilder(int i) {
                return getLaneTypeFieldBuilder().addBuilder(i, LaneTypeInfo.getDefaultInstance());
            }

            public List<LaneTypeInfo.Builder> getLaneTypeBuilderList() {
                return getLaneTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LaneTypeInfo, LaneTypeInfo.Builder, LaneTypeInfoOrBuilder> getLaneTypeFieldBuilder() {
                if (this.laneTypeBuilder_ == null) {
                    this.laneTypeBuilder_ = new RepeatedFieldBuilderV3<>(this.laneType_, (this.bitField0_ & 32) == 32, getParentForChildren(), isClean());
                    this.laneType_ = null;
                }
                return this.laneTypeBuilder_;
            }

            private void ensureLeftBoundaryTypeIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.leftBoundaryType_ = new ArrayList(this.leftBoundaryType_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<BoundaryInfo> getLeftBoundaryTypeList() {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.leftBoundaryType_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getLeftBoundaryTypeCount() {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.leftBoundaryType_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public BoundaryInfo getLeftBoundaryType(int i) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.leftBoundaryType_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setLeftBoundaryType(int i, BoundaryInfo boundaryInfo) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, boundaryInfo);
                } else if (boundaryInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLeftBoundaryTypeIsMutable();
                    this.leftBoundaryType_.set(i, boundaryInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setLeftBoundaryType(int i, BoundaryInfo.Builder builder) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftBoundaryTypeIsMutable();
                    this.leftBoundaryType_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addLeftBoundaryType(BoundaryInfo boundaryInfo) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(boundaryInfo);
                } else if (boundaryInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLeftBoundaryTypeIsMutable();
                    this.leftBoundaryType_.add(boundaryInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLeftBoundaryType(int i, BoundaryInfo boundaryInfo) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, boundaryInfo);
                } else if (boundaryInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLeftBoundaryTypeIsMutable();
                    this.leftBoundaryType_.add(i, boundaryInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLeftBoundaryType(BoundaryInfo.Builder builder) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftBoundaryTypeIsMutable();
                    this.leftBoundaryType_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addLeftBoundaryType(int i, BoundaryInfo.Builder builder) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftBoundaryTypeIsMutable();
                    this.leftBoundaryType_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllLeftBoundaryType(Iterable<? extends BoundaryInfo> iterable) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftBoundaryTypeIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.leftBoundaryType_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearLeftBoundaryType() {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.leftBoundaryType_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeLeftBoundaryType(int i) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLeftBoundaryTypeIsMutable();
                    this.leftBoundaryType_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public BoundaryInfo.Builder getLeftBoundaryTypeBuilder(int i) {
                return getLeftBoundaryTypeFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public BoundaryInfoOrBuilder getLeftBoundaryTypeOrBuilder(int i) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.leftBoundaryType_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<? extends BoundaryInfoOrBuilder> getLeftBoundaryTypeOrBuilderList() {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.leftBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.leftBoundaryType_);
            }

            public BoundaryInfo.Builder addLeftBoundaryTypeBuilder() {
                return getLeftBoundaryTypeFieldBuilder().addBuilder(BoundaryInfo.getDefaultInstance());
            }

            public BoundaryInfo.Builder addLeftBoundaryTypeBuilder(int i) {
                return getLeftBoundaryTypeFieldBuilder().addBuilder(i, BoundaryInfo.getDefaultInstance());
            }

            public List<BoundaryInfo.Builder> getLeftBoundaryTypeBuilderList() {
                return getLeftBoundaryTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> getLeftBoundaryTypeFieldBuilder() {
                if (this.leftBoundaryTypeBuilder_ == null) {
                    this.leftBoundaryTypeBuilder_ = new RepeatedFieldBuilderV3<>(this.leftBoundaryType_, (this.bitField0_ & 64) == 64, getParentForChildren(), isClean());
                    this.leftBoundaryType_ = null;
                }
                return this.leftBoundaryTypeBuilder_;
            }

            private void ensureRightBoundaryTypeIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.rightBoundaryType_ = new ArrayList(this.rightBoundaryType_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<BoundaryInfo> getRightBoundaryTypeList() {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.rightBoundaryType_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getRightBoundaryTypeCount() {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.rightBoundaryType_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public BoundaryInfo getRightBoundaryType(int i) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.rightBoundaryType_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setRightBoundaryType(int i, BoundaryInfo boundaryInfo) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, boundaryInfo);
                } else if (boundaryInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureRightBoundaryTypeIsMutable();
                    this.rightBoundaryType_.set(i, boundaryInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setRightBoundaryType(int i, BoundaryInfo.Builder builder) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightBoundaryTypeIsMutable();
                    this.rightBoundaryType_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addRightBoundaryType(BoundaryInfo boundaryInfo) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(boundaryInfo);
                } else if (boundaryInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureRightBoundaryTypeIsMutable();
                    this.rightBoundaryType_.add(boundaryInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addRightBoundaryType(int i, BoundaryInfo boundaryInfo) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, boundaryInfo);
                } else if (boundaryInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureRightBoundaryTypeIsMutable();
                    this.rightBoundaryType_.add(i, boundaryInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addRightBoundaryType(BoundaryInfo.Builder builder) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightBoundaryTypeIsMutable();
                    this.rightBoundaryType_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addRightBoundaryType(int i, BoundaryInfo.Builder builder) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightBoundaryTypeIsMutable();
                    this.rightBoundaryType_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllRightBoundaryType(Iterable<? extends BoundaryInfo> iterable) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightBoundaryTypeIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.rightBoundaryType_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearRightBoundaryType() {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.rightBoundaryType_ = Collections.emptyList();
                    this.bitField0_ &= -129;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeRightBoundaryType(int i) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRightBoundaryTypeIsMutable();
                    this.rightBoundaryType_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public BoundaryInfo.Builder getRightBoundaryTypeBuilder(int i) {
                return getRightBoundaryTypeFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public BoundaryInfoOrBuilder getRightBoundaryTypeOrBuilder(int i) {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.rightBoundaryType_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public List<? extends BoundaryInfoOrBuilder> getRightBoundaryTypeOrBuilderList() {
                RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> repeatedFieldBuilderV3 = this.rightBoundaryTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.rightBoundaryType_);
            }

            public BoundaryInfo.Builder addRightBoundaryTypeBuilder() {
                return getRightBoundaryTypeFieldBuilder().addBuilder(BoundaryInfo.getDefaultInstance());
            }

            public BoundaryInfo.Builder addRightBoundaryTypeBuilder(int i) {
                return getRightBoundaryTypeFieldBuilder().addBuilder(i, BoundaryInfo.getDefaultInstance());
            }

            public List<BoundaryInfo.Builder> getRightBoundaryTypeBuilderList() {
                return getRightBoundaryTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BoundaryInfo, BoundaryInfo.Builder, BoundaryInfoOrBuilder> getRightBoundaryTypeFieldBuilder() {
                if (this.rightBoundaryTypeBuilder_ == null) {
                    this.rightBoundaryTypeBuilder_ = new RepeatedFieldBuilderV3<>(this.rightBoundaryType_, (this.bitField0_ & 128) == 128, getParentForChildren(), isClean());
                    this.rightBoundaryType_ = null;
                }
                return this.rightBoundaryTypeBuilder_;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public boolean hasSplitInfo() {
                return (this.splitInfoBuilder_ == null && this.splitInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public SplitMergeInfo getSplitInfo() {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.splitInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    SplitMergeInfo splitMergeInfo = this.splitInfo_;
                    return splitMergeInfo == null ? SplitMergeInfo.getDefaultInstance() : splitMergeInfo;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setSplitInfo(SplitMergeInfo splitMergeInfo) {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.splitInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(splitMergeInfo);
                } else if (splitMergeInfo == null) {
                    throw new NullPointerException();
                } else {
                    this.splitInfo_ = splitMergeInfo;
                    onChanged();
                }
                return this;
            }

            public Builder setSplitInfo(SplitMergeInfo.Builder builder) {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.splitInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.splitInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeSplitInfo(SplitMergeInfo splitMergeInfo) {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.splitInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    SplitMergeInfo splitMergeInfo2 = this.splitInfo_;
                    if (splitMergeInfo2 != null) {
                        this.splitInfo_ = SplitMergeInfo.newBuilder(splitMergeInfo2).mergeFrom(splitMergeInfo).buildPartial();
                    } else {
                        this.splitInfo_ = splitMergeInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(splitMergeInfo);
                }
                return this;
            }

            public Builder clearSplitInfo() {
                if (this.splitInfoBuilder_ == null) {
                    this.splitInfo_ = null;
                    onChanged();
                } else {
                    this.splitInfo_ = null;
                    this.splitInfoBuilder_ = null;
                }
                return this;
            }

            public SplitMergeInfo.Builder getSplitInfoBuilder() {
                onChanged();
                return getSplitInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public SplitMergeInfoOrBuilder getSplitInfoOrBuilder() {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.splitInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                SplitMergeInfo splitMergeInfo = this.splitInfo_;
                return splitMergeInfo == null ? SplitMergeInfo.getDefaultInstance() : splitMergeInfo;
            }

            private SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> getSplitInfoFieldBuilder() {
                if (this.splitInfoBuilder_ == null) {
                    this.splitInfoBuilder_ = new SingleFieldBuilderV3<>(getSplitInfo(), getParentForChildren(), isClean());
                    this.splitInfo_ = null;
                }
                return this.splitInfoBuilder_;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public boolean hasMergeInfo() {
                return (this.mergeInfoBuilder_ == null && this.mergeInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public SplitMergeInfo getMergeInfo() {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.mergeInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    SplitMergeInfo splitMergeInfo = this.mergeInfo_;
                    return splitMergeInfo == null ? SplitMergeInfo.getDefaultInstance() : splitMergeInfo;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setMergeInfo(SplitMergeInfo splitMergeInfo) {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.mergeInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(splitMergeInfo);
                } else if (splitMergeInfo == null) {
                    throw new NullPointerException();
                } else {
                    this.mergeInfo_ = splitMergeInfo;
                    onChanged();
                }
                return this;
            }

            public Builder setMergeInfo(SplitMergeInfo.Builder builder) {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.mergeInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.mergeInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeMergeInfo(SplitMergeInfo splitMergeInfo) {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.mergeInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    SplitMergeInfo splitMergeInfo2 = this.mergeInfo_;
                    if (splitMergeInfo2 != null) {
                        this.mergeInfo_ = SplitMergeInfo.newBuilder(splitMergeInfo2).mergeFrom(splitMergeInfo).buildPartial();
                    } else {
                        this.mergeInfo_ = splitMergeInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(splitMergeInfo);
                }
                return this;
            }

            public Builder clearMergeInfo() {
                if (this.mergeInfoBuilder_ == null) {
                    this.mergeInfo_ = null;
                    onChanged();
                } else {
                    this.mergeInfo_ = null;
                    this.mergeInfoBuilder_ = null;
                }
                return this;
            }

            public SplitMergeInfo.Builder getMergeInfoBuilder() {
                onChanged();
                return getMergeInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public SplitMergeInfoOrBuilder getMergeInfoOrBuilder() {
                SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> singleFieldBuilderV3 = this.mergeInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                SplitMergeInfo splitMergeInfo = this.mergeInfo_;
                return splitMergeInfo == null ? SplitMergeInfo.getDefaultInstance() : splitMergeInfo;
            }

            private SingleFieldBuilderV3<SplitMergeInfo, SplitMergeInfo.Builder, SplitMergeInfoOrBuilder> getMergeInfoFieldBuilder() {
                if (this.mergeInfoBuilder_ == null) {
                    this.mergeInfoBuilder_ = new SingleFieldBuilderV3<>(getMergeInfo(), getParentForChildren(), isClean());
                    this.mergeInfo_ = null;
                }
                return this.mergeInfoBuilder_;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getLanePriority() {
                return this.lanePriority_;
            }

            public Builder setLanePriority(int i) {
                this.lanePriority_ = i;
                onChanged();
                return this;
            }

            public Builder clearLanePriority() {
                this.lanePriority_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public float getConfidence() {
                return this.confidence_;
            }

            public Builder setConfidence(float f) {
                this.confidence_ = f;
                onChanged();
                return this;
            }

            public Builder clearConfidence() {
                this.confidence_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getPositionLaneTypeValue() {
                return this.positionLaneType_;
            }

            public Builder setPositionLaneTypeValue(int i) {
                this.positionLaneType_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public Primitives.LaneType_P getPositionLaneType() {
                Primitives.LaneType_P valueOf = Primitives.LaneType_P.valueOf(this.positionLaneType_);
                return valueOf == null ? Primitives.LaneType_P.UNRECOGNIZED : valueOf;
            }

            public Builder setPositionLaneType(Primitives.LaneType_P laneType_P) {
                if (laneType_P == null) {
                    throw new NullPointerException();
                }
                this.positionLaneType_ = laneType_P.getNumber();
                onChanged();
                return this;
            }

            public Builder clearPositionLaneType() {
                this.positionLaneType_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneLineInfoOrBuilder
            public int getXpuCduLaneColor() {
                return this.xpuCduLaneColor_;
            }

            public Builder setXpuCduLaneColor(int i) {
                this.xpuCduLaneColor_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuCduLaneColor() {
                this.xpuCduLaneColor_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static LaneLineInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LaneLineInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LaneLineInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LaneLineInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class LaneInfo extends GeneratedMessageV3 implements LaneInfoOrBuilder {
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int IS_DRIVABLE_FIELD_NUMBER = 3;
        public static final int IS_VALID_FIELD_NUMBER = 1;
        public static final int LANE_ID_FIELD_NUMBER = 8;
        public static final int LANE_TYPE_FIELD_NUMBER = 7;
        public static final int LEFT_TRACK_ID_FIELD_NUMBER = 5;
        public static final int RIGHT_TRACK_ID_FIELD_NUMBER = 6;
        public static final int SPEED_LIMIT_FIELD_NUMBER = 4;
        public static final int TURN_SIGN_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private boolean direction_;
        private boolean isDrivable_;
        private boolean isValid_;
        private int laneId_;
        private int laneType_;
        private int leftTrackId_;
        private byte memoizedIsInitialized;
        private int rightTrackId_;
        private float speedLimit_;
        private int turnSign_;
        private static final LaneInfo DEFAULT_INSTANCE = new LaneInfo();
        private static final Parser<LaneInfo> PARSER = new AbstractParser<LaneInfo>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfo.1
            @Override // com.google.protobuf.Parser
            public LaneInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LaneInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private LaneInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private LaneInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.isValid_ = false;
            this.direction_ = false;
            this.isDrivable_ = false;
            this.speedLimit_ = 0.0f;
            this.leftTrackId_ = 0;
            this.rightTrackId_ = 0;
            this.laneType_ = 0;
            this.laneId_ = 0;
            this.turnSign_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LaneInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.isValid_ = codedInputStream.readBool();
                            } else if (readTag == 16) {
                                this.direction_ = codedInputStream.readBool();
                            } else if (readTag == 24) {
                                this.isDrivable_ = codedInputStream.readBool();
                            } else if (readTag == 37) {
                                this.speedLimit_ = codedInputStream.readFloat();
                            } else if (readTag == 40) {
                                this.leftTrackId_ = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.rightTrackId_ = codedInputStream.readUInt32();
                            } else if (readTag == 56) {
                                this.laneType_ = codedInputStream.readEnum();
                            } else if (readTag == 64) {
                                this.laneId_ = codedInputStream.readEnum();
                            } else if (readTag == 72) {
                                this.turnSign_ = codedInputStream.readEnum();
                            } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LaneInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public boolean getIsValid() {
            return this.isValid_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public boolean getDirection() {
            return this.direction_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public boolean getIsDrivable() {
            return this.isDrivable_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public float getSpeedLimit() {
            return this.speedLimit_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public int getLeftTrackId() {
            return this.leftTrackId_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public int getRightTrackId() {
            return this.rightTrackId_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public int getLaneTypeValue() {
            return this.laneType_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public Primitives.LaneType getLaneType() {
            Primitives.LaneType valueOf = Primitives.LaneType.valueOf(this.laneType_);
            return valueOf == null ? Primitives.LaneType.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public int getLaneIdValue() {
            return this.laneId_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public Primitives.LaneID getLaneId() {
            Primitives.LaneID valueOf = Primitives.LaneID.valueOf(this.laneId_);
            return valueOf == null ? Primitives.LaneID.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public int getTurnSignValue() {
            return this.turnSign_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
        public Primitives.LaneTurnSignType getTurnSign() {
            Primitives.LaneTurnSignType valueOf = Primitives.LaneTurnSignType.valueOf(this.turnSign_);
            return valueOf == null ? Primitives.LaneTurnSignType.UNRECOGNIZED : valueOf;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z = this.isValid_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            boolean z2 = this.direction_;
            if (z2) {
                codedOutputStream.writeBool(2, z2);
            }
            boolean z3 = this.isDrivable_;
            if (z3) {
                codedOutputStream.writeBool(3, z3);
            }
            float f = this.speedLimit_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(4, f);
            }
            int i = this.leftTrackId_;
            if (i != 0) {
                codedOutputStream.writeUInt32(5, i);
            }
            int i2 = this.rightTrackId_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(6, i2);
            }
            if (this.laneType_ != Primitives.LaneType.LaneType_Unknown.getNumber()) {
                codedOutputStream.writeEnum(7, this.laneType_);
            }
            if (this.laneId_ != Primitives.LaneID.LANT_ID_EGO.getNumber()) {
                codedOutputStream.writeEnum(8, this.laneId_);
            }
            if (this.turnSign_ != Primitives.LaneTurnSignType.TURN_SING_UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(9, this.turnSign_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            boolean z = this.isValid_;
            int computeBoolSize = z ? 0 + CodedOutputStream.computeBoolSize(1, z) : 0;
            boolean z2 = this.direction_;
            if (z2) {
                computeBoolSize += CodedOutputStream.computeBoolSize(2, z2);
            }
            boolean z3 = this.isDrivable_;
            if (z3) {
                computeBoolSize += CodedOutputStream.computeBoolSize(3, z3);
            }
            float f = this.speedLimit_;
            if (f != 0.0f) {
                computeBoolSize += CodedOutputStream.computeFloatSize(4, f);
            }
            int i2 = this.leftTrackId_;
            if (i2 != 0) {
                computeBoolSize += CodedOutputStream.computeUInt32Size(5, i2);
            }
            int i3 = this.rightTrackId_;
            if (i3 != 0) {
                computeBoolSize += CodedOutputStream.computeUInt32Size(6, i3);
            }
            if (this.laneType_ != Primitives.LaneType.LaneType_Unknown.getNumber()) {
                computeBoolSize += CodedOutputStream.computeEnumSize(7, this.laneType_);
            }
            if (this.laneId_ != Primitives.LaneID.LANT_ID_EGO.getNumber()) {
                computeBoolSize += CodedOutputStream.computeEnumSize(8, this.laneId_);
            }
            if (this.turnSign_ != Primitives.LaneTurnSignType.TURN_SING_UNKNOWN.getNumber()) {
                computeBoolSize += CodedOutputStream.computeEnumSize(9, this.turnSign_);
            }
            int serializedSize = computeBoolSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LaneInfo)) {
                return super.equals(obj);
            }
            LaneInfo laneInfo = (LaneInfo) obj;
            return (((((((((getIsValid() == laneInfo.getIsValid()) && getDirection() == laneInfo.getDirection()) && getIsDrivable() == laneInfo.getIsDrivable()) && Float.floatToIntBits(getSpeedLimit()) == Float.floatToIntBits(laneInfo.getSpeedLimit())) && getLeftTrackId() == laneInfo.getLeftTrackId()) && getRightTrackId() == laneInfo.getRightTrackId()) && this.laneType_ == laneInfo.laneType_) && this.laneId_ == laneInfo.laneId_) && this.turnSign_ == laneInfo.turnSign_) && this.unknownFields.equals(laneInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashBoolean(getIsValid())) * 37) + 2) * 53) + Internal.hashBoolean(getDirection())) * 37) + 3) * 53) + Internal.hashBoolean(getIsDrivable())) * 37) + 4) * 53) + Float.floatToIntBits(getSpeedLimit())) * 37) + 5) * 53) + getLeftTrackId()) * 37) + 6) * 53) + getRightTrackId()) * 37) + 7) * 53) + this.laneType_) * 37) + 8) * 53) + this.laneId_) * 37) + 9) * 53) + this.turnSign_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static LaneInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LaneInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LaneInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LaneInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LaneInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LaneInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LaneInfo parseFrom(InputStream inputStream) throws IOException {
            return (LaneInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LaneInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LaneInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LaneInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LaneInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LaneInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LaneInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LaneInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LaneInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LaneInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LaneInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LaneInfo laneInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(laneInfo);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LaneInfoOrBuilder {
            private boolean direction_;
            private boolean isDrivable_;
            private boolean isValid_;
            private int laneId_;
            private int laneType_;
            private int leftTrackId_;
            private int rightTrackId_;
            private float speedLimit_;
            private int turnSign_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LaneInfo.class, Builder.class);
            }

            private Builder() {
                this.laneType_ = 0;
                this.laneId_ = 0;
                this.turnSign_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.laneType_ = 0;
                this.laneId_ = 0;
                this.turnSign_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LaneInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.isValid_ = false;
                this.direction_ = false;
                this.isDrivable_ = false;
                this.speedLimit_ = 0.0f;
                this.leftTrackId_ = 0;
                this.rightTrackId_ = 0;
                this.laneType_ = 0;
                this.laneId_ = 0;
                this.turnSign_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_LaneInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LaneInfo getDefaultInstanceForType() {
                return LaneInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LaneInfo build() {
                LaneInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LaneInfo buildPartial() {
                LaneInfo laneInfo = new LaneInfo(this);
                laneInfo.isValid_ = this.isValid_;
                laneInfo.direction_ = this.direction_;
                laneInfo.isDrivable_ = this.isDrivable_;
                laneInfo.speedLimit_ = this.speedLimit_;
                laneInfo.leftTrackId_ = this.leftTrackId_;
                laneInfo.rightTrackId_ = this.rightTrackId_;
                laneInfo.laneType_ = this.laneType_;
                laneInfo.laneId_ = this.laneId_;
                laneInfo.turnSign_ = this.turnSign_;
                onBuilt();
                return laneInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LaneInfo) {
                    return mergeFrom((LaneInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LaneInfo laneInfo) {
                if (laneInfo == LaneInfo.getDefaultInstance()) {
                    return this;
                }
                if (laneInfo.getIsValid()) {
                    setIsValid(laneInfo.getIsValid());
                }
                if (laneInfo.getDirection()) {
                    setDirection(laneInfo.getDirection());
                }
                if (laneInfo.getIsDrivable()) {
                    setIsDrivable(laneInfo.getIsDrivable());
                }
                if (laneInfo.getSpeedLimit() != 0.0f) {
                    setSpeedLimit(laneInfo.getSpeedLimit());
                }
                if (laneInfo.getLeftTrackId() != 0) {
                    setLeftTrackId(laneInfo.getLeftTrackId());
                }
                if (laneInfo.getRightTrackId() != 0) {
                    setRightTrackId(laneInfo.getRightTrackId());
                }
                if (laneInfo.laneType_ != 0) {
                    setLaneTypeValue(laneInfo.getLaneTypeValue());
                }
                if (laneInfo.laneId_ != 0) {
                    setLaneIdValue(laneInfo.getLaneIdValue());
                }
                if (laneInfo.turnSign_ != 0) {
                    setTurnSignValue(laneInfo.getTurnSignValue());
                }
                mergeUnknownFields(laneInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfo.access$12600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$LaneInfo r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$LaneInfo r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfo) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$LaneInfo$Builder");
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public boolean getIsValid() {
                return this.isValid_;
            }

            public Builder setIsValid(boolean z) {
                this.isValid_ = z;
                onChanged();
                return this;
            }

            public Builder clearIsValid() {
                this.isValid_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public boolean getDirection() {
                return this.direction_;
            }

            public Builder setDirection(boolean z) {
                this.direction_ = z;
                onChanged();
                return this;
            }

            public Builder clearDirection() {
                this.direction_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public boolean getIsDrivable() {
                return this.isDrivable_;
            }

            public Builder setIsDrivable(boolean z) {
                this.isDrivable_ = z;
                onChanged();
                return this;
            }

            public Builder clearIsDrivable() {
                this.isDrivable_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public float getSpeedLimit() {
                return this.speedLimit_;
            }

            public Builder setSpeedLimit(float f) {
                this.speedLimit_ = f;
                onChanged();
                return this;
            }

            public Builder clearSpeedLimit() {
                this.speedLimit_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public int getLeftTrackId() {
                return this.leftTrackId_;
            }

            public Builder setLeftTrackId(int i) {
                this.leftTrackId_ = i;
                onChanged();
                return this;
            }

            public Builder clearLeftTrackId() {
                this.leftTrackId_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public int getRightTrackId() {
                return this.rightTrackId_;
            }

            public Builder setRightTrackId(int i) {
                this.rightTrackId_ = i;
                onChanged();
                return this;
            }

            public Builder clearRightTrackId() {
                this.rightTrackId_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public int getLaneTypeValue() {
                return this.laneType_;
            }

            public Builder setLaneTypeValue(int i) {
                this.laneType_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public Primitives.LaneType getLaneType() {
                Primitives.LaneType valueOf = Primitives.LaneType.valueOf(this.laneType_);
                return valueOf == null ? Primitives.LaneType.UNRECOGNIZED : valueOf;
            }

            public Builder setLaneType(Primitives.LaneType laneType) {
                if (laneType == null) {
                    throw new NullPointerException();
                }
                this.laneType_ = laneType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLaneType() {
                this.laneType_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public int getLaneIdValue() {
                return this.laneId_;
            }

            public Builder setLaneIdValue(int i) {
                this.laneId_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public Primitives.LaneID getLaneId() {
                Primitives.LaneID valueOf = Primitives.LaneID.valueOf(this.laneId_);
                return valueOf == null ? Primitives.LaneID.UNRECOGNIZED : valueOf;
            }

            public Builder setLaneId(Primitives.LaneID laneID) {
                if (laneID == null) {
                    throw new NullPointerException();
                }
                this.laneId_ = laneID.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLaneId() {
                this.laneId_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public int getTurnSignValue() {
                return this.turnSign_;
            }

            public Builder setTurnSignValue(int i) {
                this.turnSign_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.LaneInfoOrBuilder
            public Primitives.LaneTurnSignType getTurnSign() {
                Primitives.LaneTurnSignType valueOf = Primitives.LaneTurnSignType.valueOf(this.turnSign_);
                return valueOf == null ? Primitives.LaneTurnSignType.UNRECOGNIZED : valueOf;
            }

            public Builder setTurnSign(Primitives.LaneTurnSignType laneTurnSignType) {
                if (laneTurnSignType == null) {
                    throw new NullPointerException();
                }
                this.turnSign_ = laneTurnSignType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearTurnSign() {
                this.turnSign_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static LaneInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LaneInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LaneInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LaneInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StaticEnvironment extends GeneratedMessageV3 implements StaticEnvironmentOrBuilder {
        public static final int CUR_POSE_FIELD_NUMBER = 2;
        public static final int IS_DISPLAY_FIELD_NUMBER = 5;
        public static final int IS_HDMAP_MODE_FIELD_NUMBER = 4;
        public static final int LANE_LINE_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private LocalPose.LocalPoseInfo curPose_;
        private boolean isDisplay_;
        private boolean isHdmapMode_;
        private List<LaneLineInfo> laneLine_;
        private byte memoizedIsInitialized;
        private Primitives.Time timestamp_;
        private static final StaticEnvironment DEFAULT_INSTANCE = new StaticEnvironment();
        private static final Parser<StaticEnvironment> PARSER = new AbstractParser<StaticEnvironment>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironment.1
            @Override // com.google.protobuf.Parser
            public StaticEnvironment parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StaticEnvironment(codedInputStream, extensionRegistryLite);
            }
        };

        private StaticEnvironment(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private StaticEnvironment() {
            this.memoizedIsInitialized = (byte) -1;
            this.laneLine_ = Collections.emptyList();
            this.isHdmapMode_ = false;
            this.isDisplay_ = false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private StaticEnvironment(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                if (z) {
                    break;
                }
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                Primitives.Time.Builder builder = this.timestamp_ != null ? this.timestamp_.toBuilder() : null;
                                this.timestamp_ = (Primitives.Time) codedInputStream.readMessage(Primitives.Time.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.timestamp_);
                                    this.timestamp_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                LocalPose.LocalPoseInfo.Builder builder2 = this.curPose_ != null ? this.curPose_.toBuilder() : null;
                                this.curPose_ = (LocalPose.LocalPoseInfo) codedInputStream.readMessage(LocalPose.LocalPoseInfo.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.curPose_);
                                    this.curPose_ = builder2.buildPartial();
                                }
                            } else if (readTag == 26) {
                                boolean z3 = (z2 ? 1 : 0) & true;
                                z2 = z2;
                                if (!z3) {
                                    this.laneLine_ = new ArrayList();
                                    z2 = (z2 ? 1 : 0) | true;
                                }
                                this.laneLine_.add(codedInputStream.readMessage(LaneLineInfo.parser(), extensionRegistryLite));
                            } else if (readTag == 32) {
                                this.isHdmapMode_ = codedInputStream.readBool();
                            } else if (readTag == 40) {
                                this.isDisplay_ = codedInputStream.readBool();
                            } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((z2 ? 1 : 0) & true) {
                        this.laneLine_ = Collections.unmodifiableList(this.laneLine_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironment_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironment_fieldAccessorTable.ensureFieldAccessorsInitialized(StaticEnvironment.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public boolean hasTimestamp() {
            return this.timestamp_ != null;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public Primitives.Time getTimestamp() {
            Primitives.Time time = this.timestamp_;
            return time == null ? Primitives.Time.getDefaultInstance() : time;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public Primitives.TimeOrBuilder getTimestampOrBuilder() {
            return getTimestamp();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public boolean hasCurPose() {
            return this.curPose_ != null;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public LocalPose.LocalPoseInfo getCurPose() {
            LocalPose.LocalPoseInfo localPoseInfo = this.curPose_;
            return localPoseInfo == null ? LocalPose.LocalPoseInfo.getDefaultInstance() : localPoseInfo;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public LocalPose.LocalPoseInfoOrBuilder getCurPoseOrBuilder() {
            return getCurPose();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public List<LaneLineInfo> getLaneLineList() {
            return this.laneLine_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public List<? extends LaneLineInfoOrBuilder> getLaneLineOrBuilderList() {
            return this.laneLine_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public int getLaneLineCount() {
            return this.laneLine_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public LaneLineInfo getLaneLine(int i) {
            return this.laneLine_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public LaneLineInfoOrBuilder getLaneLineOrBuilder(int i) {
            return this.laneLine_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public boolean getIsHdmapMode() {
            return this.isHdmapMode_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
        public boolean getIsDisplay() {
            return this.isDisplay_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.timestamp_ != null) {
                codedOutputStream.writeMessage(1, getTimestamp());
            }
            if (this.curPose_ != null) {
                codedOutputStream.writeMessage(2, getCurPose());
            }
            for (int i = 0; i < this.laneLine_.size(); i++) {
                codedOutputStream.writeMessage(3, this.laneLine_.get(i));
            }
            boolean z = this.isHdmapMode_;
            if (z) {
                codedOutputStream.writeBool(4, z);
            }
            boolean z2 = this.isDisplay_;
            if (z2) {
                codedOutputStream.writeBool(5, z2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.timestamp_ != null ? CodedOutputStream.computeMessageSize(1, getTimestamp()) + 0 : 0;
            if (this.curPose_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getCurPose());
            }
            for (int i2 = 0; i2 < this.laneLine_.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, this.laneLine_.get(i2));
            }
            boolean z = this.isHdmapMode_;
            if (z) {
                computeMessageSize += CodedOutputStream.computeBoolSize(4, z);
            }
            boolean z2 = this.isDisplay_;
            if (z2) {
                computeMessageSize += CodedOutputStream.computeBoolSize(5, z2);
            }
            int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof StaticEnvironment)) {
                return super.equals(obj);
            }
            StaticEnvironment staticEnvironment = (StaticEnvironment) obj;
            boolean z = hasTimestamp() == staticEnvironment.hasTimestamp();
            if (hasTimestamp()) {
                z = z && getTimestamp().equals(staticEnvironment.getTimestamp());
            }
            boolean z2 = z && hasCurPose() == staticEnvironment.hasCurPose();
            if (hasCurPose()) {
                z2 = z2 && getCurPose().equals(staticEnvironment.getCurPose());
            }
            return (((z2 && getLaneLineList().equals(staticEnvironment.getLaneLineList())) && getIsHdmapMode() == staticEnvironment.getIsHdmapMode()) && getIsDisplay() == staticEnvironment.getIsDisplay()) && this.unknownFields.equals(staticEnvironment.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasTimestamp()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getTimestamp().hashCode();
            }
            if (hasCurPose()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getCurPose().hashCode();
            }
            if (getLaneLineCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getLaneLineList().hashCode();
            }
            int hashBoolean = (((((((((hashCode * 37) + 4) * 53) + Internal.hashBoolean(getIsHdmapMode())) * 37) + 5) * 53) + Internal.hashBoolean(getIsDisplay())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashBoolean;
            return hashBoolean;
        }

        public static StaticEnvironment parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static StaticEnvironment parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static StaticEnvironment parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static StaticEnvironment parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static StaticEnvironment parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static StaticEnvironment parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static StaticEnvironment parseFrom(InputStream inputStream) throws IOException {
            return (StaticEnvironment) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static StaticEnvironment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StaticEnvironment) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StaticEnvironment parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StaticEnvironment) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static StaticEnvironment parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StaticEnvironment) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StaticEnvironment parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StaticEnvironment) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static StaticEnvironment parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StaticEnvironment) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StaticEnvironment staticEnvironment) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(staticEnvironment);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StaticEnvironmentOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> curPoseBuilder_;
            private LocalPose.LocalPoseInfo curPose_;
            private boolean isDisplay_;
            private boolean isHdmapMode_;
            private RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> laneLineBuilder_;
            private List<LaneLineInfo> laneLine_;
            private SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> timestampBuilder_;
            private Primitives.Time timestamp_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironment_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironment_fieldAccessorTable.ensureFieldAccessorsInitialized(StaticEnvironment.class, Builder.class);
            }

            private Builder() {
                this.timestamp_ = null;
                this.curPose_ = null;
                this.laneLine_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.timestamp_ = null;
                this.curPose_ = null;
                this.laneLine_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (StaticEnvironment.alwaysUseFieldBuilders) {
                    getLaneLineFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.timestampBuilder_ == null) {
                    this.timestamp_ = null;
                } else {
                    this.timestamp_ = null;
                    this.timestampBuilder_ = null;
                }
                if (this.curPoseBuilder_ == null) {
                    this.curPose_ = null;
                } else {
                    this.curPose_ = null;
                    this.curPoseBuilder_ = null;
                }
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.laneLine_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.isHdmapMode_ = false;
                this.isDisplay_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironment_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StaticEnvironment getDefaultInstanceForType() {
                return StaticEnvironment.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StaticEnvironment build() {
                StaticEnvironment buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StaticEnvironment buildPartial() {
                StaticEnvironment staticEnvironment = new StaticEnvironment(this);
                int i = this.bitField0_;
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    staticEnvironment.timestamp_ = this.timestamp_;
                } else {
                    staticEnvironment.timestamp_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV32 = this.curPoseBuilder_;
                if (singleFieldBuilderV32 == null) {
                    staticEnvironment.curPose_ = this.curPose_;
                } else {
                    staticEnvironment.curPose_ = singleFieldBuilderV32.build();
                }
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    staticEnvironment.laneLine_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 4) == 4) {
                        this.laneLine_ = Collections.unmodifiableList(this.laneLine_);
                        this.bitField0_ &= -5;
                    }
                    staticEnvironment.laneLine_ = this.laneLine_;
                }
                staticEnvironment.isHdmapMode_ = this.isHdmapMode_;
                staticEnvironment.isDisplay_ = this.isDisplay_;
                staticEnvironment.bitField0_ = 0;
                onBuilt();
                return staticEnvironment;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof StaticEnvironment) {
                    return mergeFrom((StaticEnvironment) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(StaticEnvironment staticEnvironment) {
                if (staticEnvironment == StaticEnvironment.getDefaultInstance()) {
                    return this;
                }
                if (staticEnvironment.hasTimestamp()) {
                    mergeTimestamp(staticEnvironment.getTimestamp());
                }
                if (staticEnvironment.hasCurPose()) {
                    mergeCurPose(staticEnvironment.getCurPose());
                }
                if (this.laneLineBuilder_ == null) {
                    if (!staticEnvironment.laneLine_.isEmpty()) {
                        if (this.laneLine_.isEmpty()) {
                            this.laneLine_ = staticEnvironment.laneLine_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureLaneLineIsMutable();
                            this.laneLine_.addAll(staticEnvironment.laneLine_);
                        }
                        onChanged();
                    }
                } else if (!staticEnvironment.laneLine_.isEmpty()) {
                    if (!this.laneLineBuilder_.isEmpty()) {
                        this.laneLineBuilder_.addAllMessages(staticEnvironment.laneLine_);
                    } else {
                        this.laneLineBuilder_.dispose();
                        this.laneLineBuilder_ = null;
                        this.laneLine_ = staticEnvironment.laneLine_;
                        this.bitField0_ &= -5;
                        this.laneLineBuilder_ = StaticEnvironment.alwaysUseFieldBuilders ? getLaneLineFieldBuilder() : null;
                    }
                }
                if (staticEnvironment.getIsHdmapMode()) {
                    setIsHdmapMode(staticEnvironment.getIsHdmapMode());
                }
                if (staticEnvironment.getIsDisplay()) {
                    setIsDisplay(staticEnvironment.getIsDisplay());
                }
                mergeUnknownFields(staticEnvironment.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironment.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironment.access$14200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$StaticEnvironment r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironment) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$StaticEnvironment r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironment) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironment.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$StaticEnvironment$Builder");
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public boolean hasTimestamp() {
                return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public Primitives.Time getTimestamp() {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Time time = this.timestamp_;
                    return time == null ? Primitives.Time.getDefaultInstance() : time;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setTimestamp(Primitives.Time time) {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(time);
                } else if (time == null) {
                    throw new NullPointerException();
                } else {
                    this.timestamp_ = time;
                    onChanged();
                }
                return this;
            }

            public Builder setTimestamp(Primitives.Time.Builder builder) {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.timestamp_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeTimestamp(Primitives.Time time) {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Time time2 = this.timestamp_;
                    if (time2 != null) {
                        this.timestamp_ = Primitives.Time.newBuilder(time2).mergeFrom(time).buildPartial();
                    } else {
                        this.timestamp_ = time;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(time);
                }
                return this;
            }

            public Builder clearTimestamp() {
                if (this.timestampBuilder_ == null) {
                    this.timestamp_ = null;
                    onChanged();
                } else {
                    this.timestamp_ = null;
                    this.timestampBuilder_ = null;
                }
                return this;
            }

            public Primitives.Time.Builder getTimestampBuilder() {
                onChanged();
                return getTimestampFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public Primitives.TimeOrBuilder getTimestampOrBuilder() {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Time time = this.timestamp_;
                return time == null ? Primitives.Time.getDefaultInstance() : time;
            }

            private SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> getTimestampFieldBuilder() {
                if (this.timestampBuilder_ == null) {
                    this.timestampBuilder_ = new SingleFieldBuilderV3<>(getTimestamp(), getParentForChildren(), isClean());
                    this.timestamp_ = null;
                }
                return this.timestampBuilder_;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public boolean hasCurPose() {
                return (this.curPoseBuilder_ == null && this.curPose_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public LocalPose.LocalPoseInfo getCurPose() {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.curPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    LocalPose.LocalPoseInfo localPoseInfo = this.curPose_;
                    return localPoseInfo == null ? LocalPose.LocalPoseInfo.getDefaultInstance() : localPoseInfo;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setCurPose(LocalPose.LocalPoseInfo localPoseInfo) {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.curPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(localPoseInfo);
                } else if (localPoseInfo == null) {
                    throw new NullPointerException();
                } else {
                    this.curPose_ = localPoseInfo;
                    onChanged();
                }
                return this;
            }

            public Builder setCurPose(LocalPose.LocalPoseInfo.Builder builder) {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.curPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.curPose_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeCurPose(LocalPose.LocalPoseInfo localPoseInfo) {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.curPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    LocalPose.LocalPoseInfo localPoseInfo2 = this.curPose_;
                    if (localPoseInfo2 != null) {
                        this.curPose_ = LocalPose.LocalPoseInfo.newBuilder(localPoseInfo2).mergeFrom(localPoseInfo).buildPartial();
                    } else {
                        this.curPose_ = localPoseInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(localPoseInfo);
                }
                return this;
            }

            public Builder clearCurPose() {
                if (this.curPoseBuilder_ == null) {
                    this.curPose_ = null;
                    onChanged();
                } else {
                    this.curPose_ = null;
                    this.curPoseBuilder_ = null;
                }
                return this;
            }

            public LocalPose.LocalPoseInfo.Builder getCurPoseBuilder() {
                onChanged();
                return getCurPoseFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public LocalPose.LocalPoseInfoOrBuilder getCurPoseOrBuilder() {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.curPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                LocalPose.LocalPoseInfo localPoseInfo = this.curPose_;
                return localPoseInfo == null ? LocalPose.LocalPoseInfo.getDefaultInstance() : localPoseInfo;
            }

            private SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> getCurPoseFieldBuilder() {
                if (this.curPoseBuilder_ == null) {
                    this.curPoseBuilder_ = new SingleFieldBuilderV3<>(getCurPose(), getParentForChildren(), isClean());
                    this.curPose_ = null;
                }
                return this.curPoseBuilder_;
            }

            private void ensureLaneLineIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.laneLine_ = new ArrayList(this.laneLine_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public List<LaneLineInfo> getLaneLineList() {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.laneLine_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public int getLaneLineCount() {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.laneLine_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public LaneLineInfo getLaneLine(int i) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.laneLine_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setLaneLine(int i, LaneLineInfo laneLineInfo) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, laneLineInfo);
                } else if (laneLineInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLaneLineIsMutable();
                    this.laneLine_.set(i, laneLineInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setLaneLine(int i, LaneLineInfo.Builder builder) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneLineIsMutable();
                    this.laneLine_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addLaneLine(LaneLineInfo laneLineInfo) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(laneLineInfo);
                } else if (laneLineInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLaneLineIsMutable();
                    this.laneLine_.add(laneLineInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLaneLine(int i, LaneLineInfo laneLineInfo) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, laneLineInfo);
                } else if (laneLineInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLaneLineIsMutable();
                    this.laneLine_.add(i, laneLineInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLaneLine(LaneLineInfo.Builder builder) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneLineIsMutable();
                    this.laneLine_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addLaneLine(int i, LaneLineInfo.Builder builder) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneLineIsMutable();
                    this.laneLine_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllLaneLine(Iterable<? extends LaneLineInfo> iterable) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneLineIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.laneLine_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearLaneLine() {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.laneLine_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeLaneLine(int i) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLaneLineIsMutable();
                    this.laneLine_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public LaneLineInfo.Builder getLaneLineBuilder(int i) {
                return getLaneLineFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public LaneLineInfoOrBuilder getLaneLineOrBuilder(int i) {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.laneLine_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public List<? extends LaneLineInfoOrBuilder> getLaneLineOrBuilderList() {
                RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> repeatedFieldBuilderV3 = this.laneLineBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.laneLine_);
            }

            public LaneLineInfo.Builder addLaneLineBuilder() {
                return getLaneLineFieldBuilder().addBuilder(LaneLineInfo.getDefaultInstance());
            }

            public LaneLineInfo.Builder addLaneLineBuilder(int i) {
                return getLaneLineFieldBuilder().addBuilder(i, LaneLineInfo.getDefaultInstance());
            }

            public List<LaneLineInfo.Builder> getLaneLineBuilderList() {
                return getLaneLineFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LaneLineInfo, LaneLineInfo.Builder, LaneLineInfoOrBuilder> getLaneLineFieldBuilder() {
                if (this.laneLineBuilder_ == null) {
                    this.laneLineBuilder_ = new RepeatedFieldBuilderV3<>(this.laneLine_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.laneLine_ = null;
                }
                return this.laneLineBuilder_;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public boolean getIsHdmapMode() {
                return this.isHdmapMode_;
            }

            public Builder setIsHdmapMode(boolean z) {
                this.isHdmapMode_ = z;
                onChanged();
                return this;
            }

            public Builder clearIsHdmapMode() {
                this.isHdmapMode_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder
            public boolean getIsDisplay() {
                return this.isDisplay_;
            }

            public Builder setIsDisplay(boolean z) {
                this.isDisplay_ = z;
                onChanged();
                return this;
            }

            public Builder clearIsDisplay() {
                this.isDisplay_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static StaticEnvironment getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StaticEnvironment> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StaticEnvironment> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StaticEnvironment getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StaticEnvironmentBuffer extends GeneratedMessageV3 implements StaticEnvironmentBufferOrBuilder {
        private static final StaticEnvironmentBuffer DEFAULT_INSTANCE = new StaticEnvironmentBuffer();
        private static final Parser<StaticEnvironmentBuffer> PARSER = new AbstractParser<StaticEnvironmentBuffer>() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBuffer.1
            @Override // com.google.protobuf.Parser
            public StaticEnvironmentBuffer parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StaticEnvironmentBuffer(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SPARE_FIELD_NUMBER = 2;
        public static final int STATIC_ENV_MSGS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private List<StaticEnvironment> staticEnvMsgs_;

        private StaticEnvironmentBuffer(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private StaticEnvironmentBuffer() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.staticEnvMsgs_ = Collections.emptyList();
            this.spare_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private StaticEnvironmentBuffer(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                if (z) {
                    break;
                }
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                if (!(z2 & true)) {
                                    this.staticEnvMsgs_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.staticEnvMsgs_.add(codedInputStream.readMessage(StaticEnvironment.parser(), extensionRegistryLite));
                            } else if (readTag == 18) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.spare_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.spare_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 21) {
                                if (!(z2 & true)) {
                                    this.spare_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.spare_.add(Float.valueOf(codedInputStream.readFloat()));
                            } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.staticEnvMsgs_ = Collections.unmodifiableList(this.staticEnvMsgs_);
                    }
                    if (z2 & true) {
                        this.spare_ = Collections.unmodifiableList(this.spare_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_fieldAccessorTable.ensureFieldAccessorsInitialized(StaticEnvironmentBuffer.class, Builder.class);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
        public List<StaticEnvironment> getStaticEnvMsgsList() {
            return this.staticEnvMsgs_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
        public List<? extends StaticEnvironmentOrBuilder> getStaticEnvMsgsOrBuilderList() {
            return this.staticEnvMsgs_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
        public int getStaticEnvMsgsCount() {
            return this.staticEnvMsgs_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
        public StaticEnvironment getStaticEnvMsgs(int i) {
            return this.staticEnvMsgs_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
        public StaticEnvironmentOrBuilder getStaticEnvMsgsOrBuilder(int i) {
            return this.staticEnvMsgs_.get(i);
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
        public float getSpare(int i) {
            return this.spare_.get(i).floatValue();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.staticEnvMsgs_.size(); i++) {
                codedOutputStream.writeMessage(1, this.staticEnvMsgs_.get(i));
            }
            if (getSpareList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(18);
                codedOutputStream.writeUInt32NoTag(this.spareMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.spare_.size(); i2++) {
                codedOutputStream.writeFloatNoTag(this.spare_.get(i2).floatValue());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.staticEnvMsgs_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.staticEnvMsgs_.get(i3));
            }
            int size = getSpareList().size() * 4;
            int i4 = i2 + size;
            if (!getSpareList().isEmpty()) {
                i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.spareMemoizedSerializedSize = size;
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof StaticEnvironmentBuffer)) {
                return super.equals(obj);
            }
            StaticEnvironmentBuffer staticEnvironmentBuffer = (StaticEnvironmentBuffer) obj;
            return ((getStaticEnvMsgsList().equals(staticEnvironmentBuffer.getStaticEnvMsgsList())) && getSpareList().equals(staticEnvironmentBuffer.getSpareList())) && this.unknownFields.equals(staticEnvironmentBuffer.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getStaticEnvMsgsCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getStaticEnvMsgsList().hashCode();
            }
            if (getSpareCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getSpareList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static StaticEnvironmentBuffer parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static StaticEnvironmentBuffer parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static StaticEnvironmentBuffer parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static StaticEnvironmentBuffer parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static StaticEnvironmentBuffer parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static StaticEnvironmentBuffer parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static StaticEnvironmentBuffer parseFrom(InputStream inputStream) throws IOException {
            return (StaticEnvironmentBuffer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static StaticEnvironmentBuffer parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StaticEnvironmentBuffer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StaticEnvironmentBuffer parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StaticEnvironmentBuffer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static StaticEnvironmentBuffer parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StaticEnvironmentBuffer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StaticEnvironmentBuffer parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StaticEnvironmentBuffer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static StaticEnvironmentBuffer parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StaticEnvironmentBuffer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StaticEnvironmentBuffer staticEnvironmentBuffer) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(staticEnvironmentBuffer);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StaticEnvironmentBufferOrBuilder {
            private int bitField0_;
            private List<Float> spare_;
            private RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> staticEnvMsgsBuilder_;
            private List<StaticEnvironment> staticEnvMsgs_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_fieldAccessorTable.ensureFieldAccessorsInitialized(StaticEnvironmentBuffer.class, Builder.class);
            }

            private Builder() {
                this.staticEnvMsgs_ = Collections.emptyList();
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.staticEnvMsgs_ = Collections.emptyList();
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (StaticEnvironmentBuffer.alwaysUseFieldBuilders) {
                    getStaticEnvMsgsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.staticEnvMsgs_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.spare_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StaticEnvironmentOuterClass.internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StaticEnvironmentBuffer getDefaultInstanceForType() {
                return StaticEnvironmentBuffer.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StaticEnvironmentBuffer build() {
                StaticEnvironmentBuffer buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StaticEnvironmentBuffer buildPartial() {
                StaticEnvironmentBuffer staticEnvironmentBuffer = new StaticEnvironmentBuffer(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.staticEnvMsgs_ = Collections.unmodifiableList(this.staticEnvMsgs_);
                        this.bitField0_ &= -2;
                    }
                    staticEnvironmentBuffer.staticEnvMsgs_ = this.staticEnvMsgs_;
                } else {
                    staticEnvironmentBuffer.staticEnvMsgs_ = repeatedFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 2) == 2) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField0_ &= -3;
                }
                staticEnvironmentBuffer.spare_ = this.spare_;
                onBuilt();
                return staticEnvironmentBuffer;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo66clone() {
                return (Builder) super.mo66clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof StaticEnvironmentBuffer) {
                    return mergeFrom((StaticEnvironmentBuffer) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(StaticEnvironmentBuffer staticEnvironmentBuffer) {
                if (staticEnvironmentBuffer == StaticEnvironmentBuffer.getDefaultInstance()) {
                    return this;
                }
                if (this.staticEnvMsgsBuilder_ == null) {
                    if (!staticEnvironmentBuffer.staticEnvMsgs_.isEmpty()) {
                        if (this.staticEnvMsgs_.isEmpty()) {
                            this.staticEnvMsgs_ = staticEnvironmentBuffer.staticEnvMsgs_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureStaticEnvMsgsIsMutable();
                            this.staticEnvMsgs_.addAll(staticEnvironmentBuffer.staticEnvMsgs_);
                        }
                        onChanged();
                    }
                } else if (!staticEnvironmentBuffer.staticEnvMsgs_.isEmpty()) {
                    if (!this.staticEnvMsgsBuilder_.isEmpty()) {
                        this.staticEnvMsgsBuilder_.addAllMessages(staticEnvironmentBuffer.staticEnvMsgs_);
                    } else {
                        this.staticEnvMsgsBuilder_.dispose();
                        this.staticEnvMsgsBuilder_ = null;
                        this.staticEnvMsgs_ = staticEnvironmentBuffer.staticEnvMsgs_;
                        this.bitField0_ &= -2;
                        this.staticEnvMsgsBuilder_ = StaticEnvironmentBuffer.alwaysUseFieldBuilders ? getStaticEnvMsgsFieldBuilder() : null;
                    }
                }
                if (!staticEnvironmentBuffer.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = staticEnvironmentBuffer.spare_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(staticEnvironmentBuffer.spare_);
                    }
                    onChanged();
                }
                mergeUnknownFields(staticEnvironmentBuffer.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBuffer.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBuffer.access$15400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.StaticEnvironmentOuterClass$StaticEnvironmentBuffer r3 = (xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBuffer) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    xpilot.sr.proto.StaticEnvironmentOuterClass$StaticEnvironmentBuffer r4 = (xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBuffer) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBuffer.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.StaticEnvironmentOuterClass$StaticEnvironmentBuffer$Builder");
            }

            private void ensureStaticEnvMsgsIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.staticEnvMsgs_ = new ArrayList(this.staticEnvMsgs_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
            public List<StaticEnvironment> getStaticEnvMsgsList() {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.staticEnvMsgs_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
            public int getStaticEnvMsgsCount() {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.staticEnvMsgs_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
            public StaticEnvironment getStaticEnvMsgs(int i) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.staticEnvMsgs_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setStaticEnvMsgs(int i, StaticEnvironment staticEnvironment) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, staticEnvironment);
                } else if (staticEnvironment == null) {
                    throw new NullPointerException();
                } else {
                    ensureStaticEnvMsgsIsMutable();
                    this.staticEnvMsgs_.set(i, staticEnvironment);
                    onChanged();
                }
                return this;
            }

            public Builder setStaticEnvMsgs(int i, StaticEnvironment.Builder builder) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureStaticEnvMsgsIsMutable();
                    this.staticEnvMsgs_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addStaticEnvMsgs(StaticEnvironment staticEnvironment) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(staticEnvironment);
                } else if (staticEnvironment == null) {
                    throw new NullPointerException();
                } else {
                    ensureStaticEnvMsgsIsMutable();
                    this.staticEnvMsgs_.add(staticEnvironment);
                    onChanged();
                }
                return this;
            }

            public Builder addStaticEnvMsgs(int i, StaticEnvironment staticEnvironment) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, staticEnvironment);
                } else if (staticEnvironment == null) {
                    throw new NullPointerException();
                } else {
                    ensureStaticEnvMsgsIsMutable();
                    this.staticEnvMsgs_.add(i, staticEnvironment);
                    onChanged();
                }
                return this;
            }

            public Builder addStaticEnvMsgs(StaticEnvironment.Builder builder) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureStaticEnvMsgsIsMutable();
                    this.staticEnvMsgs_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addStaticEnvMsgs(int i, StaticEnvironment.Builder builder) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureStaticEnvMsgsIsMutable();
                    this.staticEnvMsgs_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllStaticEnvMsgs(Iterable<? extends StaticEnvironment> iterable) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureStaticEnvMsgsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.staticEnvMsgs_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearStaticEnvMsgs() {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.staticEnvMsgs_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeStaticEnvMsgs(int i) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureStaticEnvMsgsIsMutable();
                    this.staticEnvMsgs_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public StaticEnvironment.Builder getStaticEnvMsgsBuilder(int i) {
                return getStaticEnvMsgsFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
            public StaticEnvironmentOrBuilder getStaticEnvMsgsOrBuilder(int i) {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.staticEnvMsgs_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
            public List<? extends StaticEnvironmentOrBuilder> getStaticEnvMsgsOrBuilderList() {
                RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.staticEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.staticEnvMsgs_);
            }

            public StaticEnvironment.Builder addStaticEnvMsgsBuilder() {
                return getStaticEnvMsgsFieldBuilder().addBuilder(StaticEnvironment.getDefaultInstance());
            }

            public StaticEnvironment.Builder addStaticEnvMsgsBuilder(int i) {
                return getStaticEnvMsgsFieldBuilder().addBuilder(i, StaticEnvironment.getDefaultInstance());
            }

            public List<StaticEnvironment.Builder> getStaticEnvMsgsBuilderList() {
                return getStaticEnvMsgsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<StaticEnvironment, StaticEnvironment.Builder, StaticEnvironmentOrBuilder> getStaticEnvMsgsFieldBuilder() {
                if (this.staticEnvMsgsBuilder_ == null) {
                    this.staticEnvMsgsBuilder_ = new RepeatedFieldBuilderV3<>(this.staticEnvMsgs_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.staticEnvMsgs_ = null;
                }
                return this.staticEnvMsgsBuilder_;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.StaticEnvironmentOuterClass.StaticEnvironmentBufferOrBuilder
            public float getSpare(int i) {
                return this.spare_.get(i).floatValue();
            }

            public Builder setSpare(int i, float f) {
                ensureSpareIsMutable();
                this.spare_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addSpare(float f) {
                ensureSpareIsMutable();
                this.spare_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addAllSpare(Iterable<? extends Float> iterable) {
                ensureSpareIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.spare_);
                onChanged();
                return this;
            }

            public Builder clearSpare() {
                this.spare_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static StaticEnvironmentBuffer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StaticEnvironmentBuffer> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StaticEnvironmentBuffer> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StaticEnvironmentBuffer getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018static_environment.proto\u0012\u000fxpilot.sr.proto\u001a\u0010primitives.proto\u001a\u0010local_pose.proto\"Á\u0001\n\tPathPoint\u0012\u0012\n\nconfidence\u0018\u0001 \u0001(\u0002\u0012-\n\nbase_point\u0018\u0002 \u0001(\u000b2\u0019.xpilot.sr.proto.Vector3D\u0012\r\n\u0005theta\u0018\u0003 \u0001(\u0002\u0012\r\n\u0005kappa\u0018\u0004 \u0001(\u0002\u0012\t\n\u0001s\u0018\u0005 \u0001(\u0002\u0012\u0012\n\nleft_width\u0018\u0006 \u0001(\u0002\u0012\u0013\n\u000bright_width\u0018\u0007 \u0001(\u0002\u0012\u000e\n\u0006dkappa\u0018\b \u0001(\u0002\u0012\u000f\n\u0007ddkappa\u0018\t \u0001(\u0002\":\n\fNeighborInfo\u0012\u000f\n\u0007s_begin\u0018\u0001 \u0001(\u0002\u0012\r\n\u0005s_end\u0018\u0002 \u0001(\u0002\u0012\n\n\u0002id\u0018\u0003 \u0001(\r\"E\n\u000eSpeedLimitInfo\u0012\u000f\n\u0007s_begin\u0018\u0001 \u0001(\u0002\u0012\r\n\u0005s_end\u0018\u0002 \u0001(\u0002\u0012\u0013\n\u000bspeed_limit\u0018\u0003 \u0001(\u0002\"\\\n\fLaneTypeInfo\u0012\u000f\n\u0007s_begin\u0018\u0001 \u0001(\u0002\u0012\r\n\u0005s_end\u0018\u0002 \u0001(\u0002\u0012,\n\tlane_type\u0018\u0003 \u0001(\u000e2\u0019.xpilot.sr.proto.LaneType\"£\u0001\n\fBoundaryInfo\u0012\u000f\n\u0007s_begin\u0018\u0001 \u0001(\u0002\u0012\r\n\u0005s_end\u0018\u0002 \u0001(\u0002\u00122\n\fline_marking\u0018\u0003 \u0001(\u000e2\u001c.xpilot.sr.proto.LineMarking\u0012?\n\u0013line_marking_colour\u0018\u0004 \u0001(\u000e2\".xpilot.sr.proto.LineMarkingColour\"G\n\u000eSplitMergeInfo\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\u0010\n\bs_offset\u0018\u0002 \u0001(\u0002\u0012\u0017\n\u000foverlap_s_range\u0018\u0003 \u0001(\u0002\"\u0087\u0005\n\fLaneLineInfo\u0012\u0010\n\btrack_id\u0018\u0001 \u0001(\r\u0012/\n\u000bpath_points\u0018\u0002 \u0003(\u000b2\u001a.xpilot.sr.proto.PathPoint\u00124\n\rleft_neighbor\u0018\u0003 \u0003(\u000b2\u001d.xpilot.sr.proto.NeighborInfo\u00125\n\u000eright_neighbor\u0018\u0004 \u0003(\u000b2\u001d.xpilot.sr.proto.NeighborInfo\u00124\n\u000bspeed_limit\u0018\u0005 \u0003(\u000b2\u001f.xpilot.sr.proto.SpeedLimitInfo\u00120\n\tlane_type\u0018\u0006 \u0003(\u000b2\u001d.xpilot.sr.proto.LaneTypeInfo\u00129\n\u0012left_boundary_type\u0018\u0007 \u0003(\u000b2\u001d.xpilot.sr.proto.BoundaryInfo\u0012:\n\u0013right_boundary_type\u0018\b \u0003(\u000b2\u001d.xpilot.sr.proto.BoundaryInfo\u00123\n\nsplit_info\u0018\t \u0001(\u000b2\u001f.xpilot.sr.proto.SplitMergeInfo\u00123\n\nmerge_info\u0018\n \u0001(\u000b2\u001f.xpilot.sr.proto.SplitMergeInfo\u0012\u0015\n\rlane_priority\u0018\u000b \u0001(\r\u0012\u0012\n\nconfidence\u0018\f \u0001(\u0002\u00127\n\u0012position_lane_type\u0018\r \u0001(\u000e2\u001b.xpilot.sr.proto.LaneType_P\u0012\u001a\n\u0012xpu_cdu_lane_color\u0018\u000e \u0001(\r\"\u0096\u0002\n\bLaneInfo\u0012\u0010\n\bis_valid\u0018\u0001 \u0001(\b\u0012\u0011\n\tdirection\u0018\u0002 \u0001(\b\u0012\u0013\n\u000bis_drivable\u0018\u0003 \u0001(\b\u0012\u0013\n\u000bspeed_limit\u0018\u0004 \u0001(\u0002\u0012\u0015\n\rleft_track_id\u0018\u0005 \u0001(\r\u0012\u0016\n\u000eright_track_id\u0018\u0006 \u0001(\r\u0012,\n\tlane_type\u0018\u0007 \u0001(\u000e2\u0019.xpilot.sr.proto.LaneType\u0012(\n\u0007lane_id\u0018\b \u0001(\u000e2\u0017.xpilot.sr.proto.LaneID\u00124\n\tturn_sign\u0018\t \u0001(\u000e2!.xpilot.sr.proto.LaneTurnSignType\"Ì\u0001\n\u0011StaticEnvironment\u0012(\n\ttimestamp\u0018\u0001 \u0001(\u000b2\u0015.xpilot.sr.proto.Time\u00120\n\bcur_pose\u0018\u0002 \u0001(\u000b2\u001e.xpilot.sr.proto.LocalPoseInfo\u00120\n\tlane_line\u0018\u0003 \u0003(\u000b2\u001d.xpilot.sr.proto.LaneLineInfo\u0012\u0015\n\ris_hdmap_mode\u0018\u0004 \u0001(\b\u0012\u0012\n\nis_display\u0018\u0005 \u0001(\b\"e\n\u0017StaticEnvironmentBuffer\u0012;\n\u000fstatic_env_msgs\u0018\u0001 \u0003(\u000b2\".xpilot.sr.proto.StaticEnvironment\u0012\r\n\u0005spare\u0018\u0002 \u0003(\u0002*Ñ\u0003\n\u000bLineMarking\u0012\u0017\n\u0013LineMarking_Unknown\u0010\u0000\u0012\u0019\n\u0015LineMarking_SolidLine\u0010\u0001\u0012\u001a\n\u0016LineMarking_DashedLine\u0010\u0002\u0012\u001f\n\u001bLineMarking_ShortDashedLine\u0010\u0003\u0012\u001f\n\u001bLineMarking_DoubleSolidLine\u0010\u0004\u0012 \n\u001cLineMarking_DoubleDashedLine\u0010\u0005\u0012$\n LineMarking_LeftSolidRightDashed\u0010\u0006\u0012$\n LineMarking_RightSolidLeftDashed\u0010\u0007\u0012\u001a\n\u0016LineMarking_ShadedArea\u0010\b\u0012\"\n\u001eLineMarking_LaneVirtualMarking\u0010\t\u0012)\n%LineMarking_IntersectionVirualMarking\u0010\n\u0012\"\n\u001eLineMarking_CurbVirtualMarking\u0010\u000b\u0012\u001c\n\u0018LineMarking_UnclosedRoad\u0010\f\u0012\u0015\n\u0011LineMarking_Other\u0010c*Ñ\u0002\n\u0011LineMarkingColour\u0012\u001a\n\u0016LineMarkingColour_None\u0010\u0000\u0012\u001b\n\u0017LineMarkingColour_White\u0010\u0001\u0012\u001c\n\u0018LineMarkingColour_Yellow\u0010\u0002\u0012\u001c\n\u0018LineMarkingColour_Orange\u0010\u0003\u0012\u001a\n\u0016LineMarkingColour_Blue\u0010\u0004\u0012\u001b\n\u0017LineMarkingColour_Green\u0010\u0005\u0012\u001a\n\u0016LineMarkingColour_Gray\u0010\u0006\u0012)\n%LineMarkingColour_LeftGrayRightYellow\u0010\u0007\u0012*\n&LineMarkingColour_LeftYellowRightWhite\u0010\b\u0012\u001b\n\u0017LineMarkingColour_Other\u0010cb\u0006proto3"}, new Descriptors.FileDescriptor[]{Primitives.getDescriptor(), LocalPose.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.StaticEnvironmentOuterClass.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = StaticEnvironmentOuterClass.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_PathPoint_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_PathPoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_PathPoint_descriptor, new String[]{"Confidence", "BasePoint", "Theta", "Kappa", "S", "LeftWidth", "RightWidth", "Dkappa", "Ddkappa"});
        internal_static_xpilot_sr_proto_NeighborInfo_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_xpilot_sr_proto_NeighborInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_NeighborInfo_descriptor, new String[]{"SBegin", "SEnd", "Id"});
        internal_static_xpilot_sr_proto_SpeedLimitInfo_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_xpilot_sr_proto_SpeedLimitInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_SpeedLimitInfo_descriptor, new String[]{"SBegin", "SEnd", "SpeedLimit"});
        internal_static_xpilot_sr_proto_LaneTypeInfo_descriptor = getDescriptor().getMessageTypes().get(3);
        internal_static_xpilot_sr_proto_LaneTypeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_LaneTypeInfo_descriptor, new String[]{"SBegin", "SEnd", "LaneType"});
        internal_static_xpilot_sr_proto_BoundaryInfo_descriptor = getDescriptor().getMessageTypes().get(4);
        internal_static_xpilot_sr_proto_BoundaryInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_BoundaryInfo_descriptor, new String[]{"SBegin", "SEnd", "LineMarking", "LineMarkingColour"});
        internal_static_xpilot_sr_proto_SplitMergeInfo_descriptor = getDescriptor().getMessageTypes().get(5);
        internal_static_xpilot_sr_proto_SplitMergeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_SplitMergeInfo_descriptor, new String[]{"Id", "SOffset", "OverlapSRange"});
        internal_static_xpilot_sr_proto_LaneLineInfo_descriptor = getDescriptor().getMessageTypes().get(6);
        internal_static_xpilot_sr_proto_LaneLineInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_LaneLineInfo_descriptor, new String[]{"TrackId", "PathPoints", "LeftNeighbor", "RightNeighbor", "SpeedLimit", "LaneType", "LeftBoundaryType", "RightBoundaryType", "SplitInfo", "MergeInfo", "LanePriority", "Confidence", "PositionLaneType", "XpuCduLaneColor"});
        internal_static_xpilot_sr_proto_LaneInfo_descriptor = getDescriptor().getMessageTypes().get(7);
        internal_static_xpilot_sr_proto_LaneInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_LaneInfo_descriptor, new String[]{"IsValid", "Direction", "IsDrivable", "SpeedLimit", "LeftTrackId", "RightTrackId", "LaneType", "LaneId", "TurnSign"});
        internal_static_xpilot_sr_proto_StaticEnvironment_descriptor = getDescriptor().getMessageTypes().get(8);
        internal_static_xpilot_sr_proto_StaticEnvironment_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_StaticEnvironment_descriptor, new String[]{"Timestamp", "CurPose", "LaneLine", "IsHdmapMode", "IsDisplay"});
        internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_descriptor = getDescriptor().getMessageTypes().get(9);
        internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_StaticEnvironmentBuffer_descriptor, new String[]{"StaticEnvMsgs", "Spare"});
        Primitives.getDescriptor();
        LocalPose.getDescriptor();
    }
}
