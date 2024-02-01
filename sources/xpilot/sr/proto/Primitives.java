package xpilot.sr.proto;

import com.autonavi.gbl.data.model.RegionCode;
import com.autonavi.gbl.pos.model.LocTrafficSignType;
import com.autonavi.gbl.route.model.RouteControlKey;
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
import com.xiaopeng.montecarlo.navcore.search.SearchResultCode;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;
/* loaded from: classes4.dex */
public final class Primitives {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_EgoMotion_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_EgoMotion_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_GlobalPoseInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_GlobalPoseInfo_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_MapFusionLanesForScu_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_MapFusionLanesForScu_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_MotionPlanning_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_MotionPlanning_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Polygon3D_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Polygon3D_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Pose6DOF_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Pose6DOF_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Quaternion_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Quaternion_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Size2D_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Size2D_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Size3D_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Size3D_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_StateManagement_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_StateManagement_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Time_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Time_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Trajectory_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Trajectory_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Vector2D_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Vector2D_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Vector3D_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Vector3D_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_WayPoint_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_WayPoint_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Wgs_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Wgs_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_laneinfo_list_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_laneinfo_list_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_fieldAccessorTable;

    /* loaded from: classes4.dex */
    public interface EgoMotionOrBuilder extends MessageOrBuilder {
        float getEgoYaw();

        float getEgoYawRate();

        float getEgoYawRateStd();

        float getEgoYawStd();

        float getLocalPose(int i);

        int getLocalPoseCount();

        List<Float> getLocalPoseList();

        float getLocalPoseSigma(int i);

        int getLocalPoseSigmaCount();

        List<Float> getLocalPoseSigmaList();

        float getLocalVelocity(int i);

        int getLocalVelocityCount();

        List<Float> getLocalVelocityList();

        float getLocalVelocitySigma(int i);

        int getLocalVelocitySigmaCount();

        List<Float> getLocalVelocitySigmaList();
    }

    /* loaded from: classes4.dex */
    public interface GlobalPoseInfoOrBuilder extends MessageOrBuilder {
        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();

        Time getTimestamp();

        TimeOrBuilder getTimestampOrBuilder();

        Wgs getWorldPose();

        WgsOrBuilder getWorldPoseOrBuilder();

        boolean hasTimestamp();

        boolean hasWorldPose();
    }

    /* loaded from: classes4.dex */
    public interface MapFusionLanesForScuOrBuilder extends MessageOrBuilder {
        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();

        Time getTimestamp();

        TimeOrBuilder getTimestampOrBuilder();

        laneinfo_list getXpuLaneinfo();

        laneinfo_listOrBuilder getXpuLaneinfoOrBuilder();

        boolean hasTimestamp();

        boolean hasXpuLaneinfo();
    }

    /* loaded from: classes4.dex */
    public interface MotionPlanningOrBuilder extends MessageOrBuilder {
        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();

        Trajectory getTraject(int i);

        int getTrajectCount();

        List<Trajectory> getTrajectList();

        TrajectoryOrBuilder getTrajectOrBuilder(int i);

        List<? extends TrajectoryOrBuilder> getTrajectOrBuilderList();
    }

    /* loaded from: classes4.dex */
    public interface Polygon3DOrBuilder extends MessageOrBuilder {
        Vector3D getPoint(int i);

        int getPointCount();

        List<Vector3D> getPointList();

        Vector3DOrBuilder getPointOrBuilder(int i);

        List<? extends Vector3DOrBuilder> getPointOrBuilderList();
    }

    /* loaded from: classes4.dex */
    public interface Pose6DOFOrBuilder extends MessageOrBuilder {
        Vector3D getP();

        Vector3DOrBuilder getPOrBuilder();

        Quaternion getQ();

        QuaternionOrBuilder getQOrBuilder();

        boolean hasP();

        boolean hasQ();
    }

    /* loaded from: classes4.dex */
    public interface QuaternionOrBuilder extends MessageOrBuilder {
        double getQw();

        double getQx();

        double getQy();

        double getQz();
    }

    /* loaded from: classes4.dex */
    public interface Size2DOrBuilder extends MessageOrBuilder {
        float getLength();

        float getWidth();
    }

    /* loaded from: classes4.dex */
    public interface Size3DOrBuilder extends MessageOrBuilder {
        float getHeight();

        float getLength();

        float getWidth();
    }

    /* loaded from: classes4.dex */
    public interface StateManagementOrBuilder extends MessageOrBuilder {
        int getRdmodulecom10State();

        int getRdmodulecom11State();

        int getRdmodulecom12State();

        int getRdmodulecom13State();

        int getRdmodulecom14State();

        int getRdmodulecom15State();

        int getRdmodulecom16State();

        int getRdmodulecom17State();

        int getRdmodulecom18State();

        int getRdmodulecom19State();

        int getRdmodulecom20State();

        int getRdmodulecom9State();

        int getRdmodulecomACCMode1();

        int getRdmodulecomAccHold();

        int getRdmodulecomAccctrl();

        int getRdmodulecomAccmode();

        int getRdmodulecomAlcmode();

        int getRdmodulecomAlcstate();

        int getRdmodulecomBehaviorplanning();

        int getRdmodulecomCruiseLeverTHW();

        int getRdmodulecomCruiseVehSpd();

        float getRdmodulecomCruisevehSpdSt();

        int getRdmodulecomFunctionMode();

        int getRdmodulecomLKAMODE();

        int getRdmodulecomLateralctrl();

        int getRdmodulecomLccmode();

        int getRdmodulecomLkactrl();

        int getRdmodulecomLocalization();

        int getRdmodulecomLongctrl();

        int getRdmodulecomMotionplanning();

        int getRdmodulecomNgpflag();

        int getRdmodulecomNgpmode();

        int getRdmodulecomReferenceline();

        int getRdmodulecomSensorfusion();

        int getRdmodulecomSteeringctrl();

        int getRdmodulecomTurnstate();

        int getRdmodulecomUlcNeedtocomfirm();

        int getRdmodulecomUlcTurnstate();

        int getRdmodulecomUlcstate();

        int getRdmodulecomVlc();

        int getRdmodulecomWos();

        int getRfLineColor();

        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();

        int getSrDisplaySt();

        int getXPUSRLCView();

        int getXPUSRNGPView();
    }

    /* loaded from: classes4.dex */
    public interface TimeOrBuilder extends MessageOrBuilder {
        long getNsecs();
    }

    /* loaded from: classes4.dex */
    public interface TrajectoryOrBuilder extends MessageOrBuilder {
        float getX();

        float getY();

        float getZ();
    }

    /* loaded from: classes4.dex */
    public interface Vector2DOrBuilder extends MessageOrBuilder {
        double getX();

        double getY();
    }

    /* loaded from: classes4.dex */
    public interface Vector3DOrBuilder extends MessageOrBuilder {
        double getX();

        double getY();

        double getZ();
    }

    /* loaded from: classes4.dex */
    public interface WayPointOrBuilder extends MessageOrBuilder {
        float getLocalWaypoint(int i);

        int getLocalWaypointCount();

        List<Float> getLocalWaypointList();
    }

    /* loaded from: classes4.dex */
    public interface WgsOrBuilder extends MessageOrBuilder {
        double getElev();

        double getLat();

        double getLng();
    }

    /* loaded from: classes4.dex */
    public interface XPU_AssistSysSt_msgOrBuilder extends MessageOrBuilder {
        int getXpuAccst();

        int getXpuAlcctrlremind();

        int getXpuAlcdirection();

        int getXpuAlcst();

        int getXpuAlcstPg();

        float getXpuAlctarlaneendcenterpointx();

        float getXpuAlctarlaneendcenterpointy();

        int getXpuAssistsysstMsgsender();

        int getXpuAtcst();

        int getXpuCduUlcconfirmreq();

        int getXpuCduUlcstate();

        int getXpuCduUlcwarning();

        int getXpuCipWarningst();

        int getXpuCipst();

        boolean getXpuCruiseobjst();

        float getXpuCruisespdsetdisp();

        int getXpuDsmst();

        int getXpuHwpst();

        int getXpuIslcst();

        int getXpuLatctrlremind();

        int getXpuLatctrlremind2();

        int getXpuLateralendctrlreason();

        int getXpuLccst();

        int getXpuLongctrlremind();

        int getXpuLongendctrlreason();

        int getXpuNgpst();

        int getXpuTimegapsetdisp();

        int getXpuTsrsign1();

        int getXpuTsrsign2();

        int getXpuTsrsign3();

        int getXpuTsrst();

        int getXpuXpilotst();
    }

    /* loaded from: classes4.dex */
    public interface laneinfo_listOrBuilder extends MessageOrBuilder {
        boolean getIsStraddle();

        float getLaneShapeLocatTheta();

        float getLaneShapeLocatX();

        float getLaneShapeLocatY();

        boolean getLaneinfovd1();

        boolean getLaneinfovd2();

        boolean getLaneinfovd3();

        lanelineinfo_xpu2scu getLe1();

        lanelineinfo_xpu2scuOrBuilder getLe1OrBuilder();

        lanelineinfo_xpu2scu getLe2();

        lanelineinfo_xpu2scuOrBuilder getLe2OrBuilder();

        lanelineinfo_xpu2scu getLe3();

        lanelineinfo_xpu2scuOrBuilder getLe3OrBuilder();

        lanelineinfo_xpu2scu getRi1();

        lanelineinfo_xpu2scuOrBuilder getRi1OrBuilder();

        lanelineinfo_xpu2scu getRi2();

        lanelineinfo_xpu2scuOrBuilder getRi2OrBuilder();

        lanelineinfo_xpu2scu getRi3();

        lanelineinfo_xpu2scuOrBuilder getRi3OrBuilder();

        boolean hasLe1();

        boolean hasLe2();

        boolean hasLe3();

        boolean hasRi1();

        boolean hasRi2();

        boolean hasRi3();
    }

    /* loaded from: classes4.dex */
    public interface lanelineinfo_xpu2scuOrBuilder extends MessageOrBuilder {
        EnumC0056lanelinecolor getLanecolor();

        int getLanecolorValue();

        float getLanecurveC2();

        float getLanecurvechangeC3();

        float getLanedistyC0();

        float getLaneenddx();

        float getLaneenddxstd();

        int getLaneexistprob();

        int getLaneid();

        float getLanestartdx();

        float getLanestartdxstd();

        int getLanetype();

        int getLanetypeprob();

        float getLanewidth();

        float getLaneyawangleC1();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Primitives() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes4.dex */
    public enum LaneLineType implements ProtocolMessageEnum {
        LINE_TYPE_UNKNOWN(0),
        LINE_TYPE_SINGLE_SOLID(1),
        LINE_TYPE_SINGLE_DASHED(2),
        LINE_TYPE_DOUBLE_SOLID(3),
        LINE_TYPE_DOUBLE_DASHED(4),
        LINE_TYPE_LEFT_SOLID_RIGHT_DASHED(5),
        LINE_TYPE_RIGHT_SOLID_LEFT_DASHED(6),
        LINE_TYPE_SHADED_AREA(7),
        LINE_TYPE_VIRTUAL(8),
        LINE_TYPE_CURB(9),
        LINE_TYPE_BOLT(10),
        LINE_TYPE_DASHED_SLOW(11),
        LINE_TYPE_SOLID_SLOW(12),
        LINE_TYPE_OBSTACLE(13),
        LINE_TYPE_OTHERS(14),
        UNRECOGNIZED(-1);
        
        public static final int LINE_TYPE_BOLT_VALUE = 10;
        public static final int LINE_TYPE_CURB_VALUE = 9;
        public static final int LINE_TYPE_DASHED_SLOW_VALUE = 11;
        public static final int LINE_TYPE_DOUBLE_DASHED_VALUE = 4;
        public static final int LINE_TYPE_DOUBLE_SOLID_VALUE = 3;
        public static final int LINE_TYPE_LEFT_SOLID_RIGHT_DASHED_VALUE = 5;
        public static final int LINE_TYPE_OBSTACLE_VALUE = 13;
        public static final int LINE_TYPE_OTHERS_VALUE = 14;
        public static final int LINE_TYPE_RIGHT_SOLID_LEFT_DASHED_VALUE = 6;
        public static final int LINE_TYPE_SHADED_AREA_VALUE = 7;
        public static final int LINE_TYPE_SINGLE_DASHED_VALUE = 2;
        public static final int LINE_TYPE_SINGLE_SOLID_VALUE = 1;
        public static final int LINE_TYPE_SOLID_SLOW_VALUE = 12;
        public static final int LINE_TYPE_UNKNOWN_VALUE = 0;
        public static final int LINE_TYPE_VIRTUAL_VALUE = 8;
        private final int value;
        private static final Internal.EnumLiteMap<LaneLineType> internalValueMap = new Internal.EnumLiteMap<LaneLineType>() { // from class: xpilot.sr.proto.Primitives.LaneLineType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LaneLineType findValueByNumber(int i) {
                return LaneLineType.forNumber(i);
            }
        };
        private static final LaneLineType[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LaneLineType valueOf(int i) {
            return forNumber(i);
        }

        public static LaneLineType forNumber(int i) {
            switch (i) {
                case 0:
                    return LINE_TYPE_UNKNOWN;
                case 1:
                    return LINE_TYPE_SINGLE_SOLID;
                case 2:
                    return LINE_TYPE_SINGLE_DASHED;
                case 3:
                    return LINE_TYPE_DOUBLE_SOLID;
                case 4:
                    return LINE_TYPE_DOUBLE_DASHED;
                case 5:
                    return LINE_TYPE_LEFT_SOLID_RIGHT_DASHED;
                case 6:
                    return LINE_TYPE_RIGHT_SOLID_LEFT_DASHED;
                case 7:
                    return LINE_TYPE_SHADED_AREA;
                case 8:
                    return LINE_TYPE_VIRTUAL;
                case 9:
                    return LINE_TYPE_CURB;
                case 10:
                    return LINE_TYPE_BOLT;
                case 11:
                    return LINE_TYPE_DASHED_SLOW;
                case 12:
                    return LINE_TYPE_SOLID_SLOW;
                case 13:
                    return LINE_TYPE_OBSTACLE;
                case 14:
                    return LINE_TYPE_OTHERS;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<LaneLineType> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(0);
        }

        public static LaneLineType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LaneLineType(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum LaneType implements ProtocolMessageEnum {
        LaneType_Unknown(0),
        LaneType_NormalDriveable(1),
        LaneType_Shoulder(2),
        LaneType_OnRamp(3),
        LaneType_Deceleration(4),
        LaneType_Emergency(8),
        UNRECOGNIZED(-1);
        
        public static final int LaneType_Deceleration_VALUE = 4;
        public static final int LaneType_Emergency_VALUE = 8;
        public static final int LaneType_NormalDriveable_VALUE = 1;
        public static final int LaneType_OnRamp_VALUE = 3;
        public static final int LaneType_Shoulder_VALUE = 2;
        public static final int LaneType_Unknown_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<LaneType> internalValueMap = new Internal.EnumLiteMap<LaneType>() { // from class: xpilot.sr.proto.Primitives.LaneType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LaneType findValueByNumber(int i) {
                return LaneType.forNumber(i);
            }
        };
        private static final LaneType[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LaneType valueOf(int i) {
            return forNumber(i);
        }

        public static LaneType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 8) {
                                    return null;
                                }
                                return LaneType_Emergency;
                            }
                            return LaneType_Deceleration;
                        }
                        return LaneType_OnRamp;
                    }
                    return LaneType_Shoulder;
                }
                return LaneType_NormalDriveable;
            }
            return LaneType_Unknown;
        }

        public static Internal.EnumLiteMap<LaneType> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(1);
        }

        public static LaneType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LaneType(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum LaneType_P implements ProtocolMessageEnum {
        EGO_LANE(0),
        LEFT_LANE(1),
        RIGHT_LANE(2),
        EGO_ASSIST_LANE_LEFT(3),
        EGO_ASSIST_LANE_RIGHT(4),
        EGO_FORK_LANE_1(5),
        EGO_FORK_LANE_2(6),
        EGO_FORK_LANE_3(7),
        EGO_WIDE_LANE(8),
        EGO_WIDE_LANE_LEFT(9),
        EGO_WIDE_LANE_RIGHT(10),
        ADJACENT(11),
        ADJACENT_ADJACENT(12),
        ADJACENT_FORK_LEFT(13),
        ADJACENT_FORK_RIGHT(14),
        MAX_NUM(15),
        UNRECOGNIZED(-1);
        
        public static final int ADJACENT_ADJACENT_VALUE = 12;
        public static final int ADJACENT_FORK_LEFT_VALUE = 13;
        public static final int ADJACENT_FORK_RIGHT_VALUE = 14;
        public static final int ADJACENT_VALUE = 11;
        public static final int EGO_ASSIST_LANE_LEFT_VALUE = 3;
        public static final int EGO_ASSIST_LANE_RIGHT_VALUE = 4;
        public static final int EGO_FORK_LANE_1_VALUE = 5;
        public static final int EGO_FORK_LANE_2_VALUE = 6;
        public static final int EGO_FORK_LANE_3_VALUE = 7;
        public static final int EGO_LANE_VALUE = 0;
        public static final int EGO_WIDE_LANE_LEFT_VALUE = 9;
        public static final int EGO_WIDE_LANE_RIGHT_VALUE = 10;
        public static final int EGO_WIDE_LANE_VALUE = 8;
        public static final int LEFT_LANE_VALUE = 1;
        public static final int MAX_NUM_VALUE = 15;
        public static final int RIGHT_LANE_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<LaneType_P> internalValueMap = new Internal.EnumLiteMap<LaneType_P>() { // from class: xpilot.sr.proto.Primitives.LaneType_P.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LaneType_P findValueByNumber(int i) {
                return LaneType_P.forNumber(i);
            }
        };
        private static final LaneType_P[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LaneType_P valueOf(int i) {
            return forNumber(i);
        }

        public static LaneType_P forNumber(int i) {
            switch (i) {
                case 0:
                    return EGO_LANE;
                case 1:
                    return LEFT_LANE;
                case 2:
                    return RIGHT_LANE;
                case 3:
                    return EGO_ASSIST_LANE_LEFT;
                case 4:
                    return EGO_ASSIST_LANE_RIGHT;
                case 5:
                    return EGO_FORK_LANE_1;
                case 6:
                    return EGO_FORK_LANE_2;
                case 7:
                    return EGO_FORK_LANE_3;
                case 8:
                    return EGO_WIDE_LANE;
                case 9:
                    return EGO_WIDE_LANE_LEFT;
                case 10:
                    return EGO_WIDE_LANE_RIGHT;
                case 11:
                    return ADJACENT;
                case 12:
                    return ADJACENT_ADJACENT;
                case 13:
                    return ADJACENT_FORK_LEFT;
                case 14:
                    return ADJACENT_FORK_RIGHT;
                case 15:
                    return MAX_NUM;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<LaneType_P> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(2);
        }

        public static LaneType_P valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LaneType_P(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum LaneTurnSignType implements ProtocolMessageEnum {
        TURN_SING_UNKNOWN(0),
        TURN_SING_GO_STARIGHT(1),
        TURN_SING_LEFT(2),
        TURN_SING_RIGHT(3),
        TURN_SING_U(4),
        TURN_SING_STRAIGHT_LEFT(5),
        TURN_SING_STRAIGHT_RIGHT(6),
        TURN_SING_STRAIGHT_LEFT_RIGHT(7),
        TURN_SING_LEFT_U(8),
        TURN_SING_LEFT_RIGHT(9),
        TURN_SING_STRAIGHT_U(10),
        TURN_SING_SLOW_DOWN(11),
        UNRECOGNIZED(-1);
        
        public static final int TURN_SING_GO_STARIGHT_VALUE = 1;
        public static final int TURN_SING_LEFT_RIGHT_VALUE = 9;
        public static final int TURN_SING_LEFT_U_VALUE = 8;
        public static final int TURN_SING_LEFT_VALUE = 2;
        public static final int TURN_SING_RIGHT_VALUE = 3;
        public static final int TURN_SING_SLOW_DOWN_VALUE = 11;
        public static final int TURN_SING_STRAIGHT_LEFT_RIGHT_VALUE = 7;
        public static final int TURN_SING_STRAIGHT_LEFT_VALUE = 5;
        public static final int TURN_SING_STRAIGHT_RIGHT_VALUE = 6;
        public static final int TURN_SING_STRAIGHT_U_VALUE = 10;
        public static final int TURN_SING_UNKNOWN_VALUE = 0;
        public static final int TURN_SING_U_VALUE = 4;
        private final int value;
        private static final Internal.EnumLiteMap<LaneTurnSignType> internalValueMap = new Internal.EnumLiteMap<LaneTurnSignType>() { // from class: xpilot.sr.proto.Primitives.LaneTurnSignType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LaneTurnSignType findValueByNumber(int i) {
                return LaneTurnSignType.forNumber(i);
            }
        };
        private static final LaneTurnSignType[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LaneTurnSignType valueOf(int i) {
            return forNumber(i);
        }

        public static LaneTurnSignType forNumber(int i) {
            switch (i) {
                case 0:
                    return TURN_SING_UNKNOWN;
                case 1:
                    return TURN_SING_GO_STARIGHT;
                case 2:
                    return TURN_SING_LEFT;
                case 3:
                    return TURN_SING_RIGHT;
                case 4:
                    return TURN_SING_U;
                case 5:
                    return TURN_SING_STRAIGHT_LEFT;
                case 6:
                    return TURN_SING_STRAIGHT_RIGHT;
                case 7:
                    return TURN_SING_STRAIGHT_LEFT_RIGHT;
                case 8:
                    return TURN_SING_LEFT_U;
                case 9:
                    return TURN_SING_LEFT_RIGHT;
                case 10:
                    return TURN_SING_STRAIGHT_U;
                case 11:
                    return TURN_SING_SLOW_DOWN;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<LaneTurnSignType> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(3);
        }

        public static LaneTurnSignType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LaneTurnSignType(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum LaneLineColor implements ProtocolMessageEnum {
        LINE_COLOR_UNKNOWN(0),
        LINE_COLOR_WHITE(1),
        LINE_COLOR_YELLOW(2),
        LINE_COLOR_ORANGE(3),
        LINE_COLOR_BLUE(4),
        LINE_COLOR_GREEN(5),
        LINE_COLOR_GRAY(6),
        LINE_COLOR_LEFT_GRAY_RIGHT_YELLOW(7),
        LINE_COLOR_LEFT_YELLOW_RIGHT_WHITE(8),
        LINE_COLOR_BLACK(9),
        LINE_COLOR_OTHERS(10),
        UNRECOGNIZED(-1);
        
        public static final int LINE_COLOR_BLACK_VALUE = 9;
        public static final int LINE_COLOR_BLUE_VALUE = 4;
        public static final int LINE_COLOR_GRAY_VALUE = 6;
        public static final int LINE_COLOR_GREEN_VALUE = 5;
        public static final int LINE_COLOR_LEFT_GRAY_RIGHT_YELLOW_VALUE = 7;
        public static final int LINE_COLOR_LEFT_YELLOW_RIGHT_WHITE_VALUE = 8;
        public static final int LINE_COLOR_ORANGE_VALUE = 3;
        public static final int LINE_COLOR_OTHERS_VALUE = 10;
        public static final int LINE_COLOR_UNKNOWN_VALUE = 0;
        public static final int LINE_COLOR_WHITE_VALUE = 1;
        public static final int LINE_COLOR_YELLOW_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<LaneLineColor> internalValueMap = new Internal.EnumLiteMap<LaneLineColor>() { // from class: xpilot.sr.proto.Primitives.LaneLineColor.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LaneLineColor findValueByNumber(int i) {
                return LaneLineColor.forNumber(i);
            }
        };
        private static final LaneLineColor[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LaneLineColor valueOf(int i) {
            return forNumber(i);
        }

        public static LaneLineColor forNumber(int i) {
            switch (i) {
                case 0:
                    return LINE_COLOR_UNKNOWN;
                case 1:
                    return LINE_COLOR_WHITE;
                case 2:
                    return LINE_COLOR_YELLOW;
                case 3:
                    return LINE_COLOR_ORANGE;
                case 4:
                    return LINE_COLOR_BLUE;
                case 5:
                    return LINE_COLOR_GREEN;
                case 6:
                    return LINE_COLOR_GRAY;
                case 7:
                    return LINE_COLOR_LEFT_GRAY_RIGHT_YELLOW;
                case 8:
                    return LINE_COLOR_LEFT_YELLOW_RIGHT_WHITE;
                case 9:
                    return LINE_COLOR_BLACK;
                case 10:
                    return LINE_COLOR_OTHERS;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<LaneLineColor> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(4);
        }

        public static LaneLineColor valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LaneLineColor(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum ObjectType implements ProtocolMessageEnum {
        OBJ_TYPE_UNKNOWN(0),
        OBJ_TYPE_PERSON(1),
        OBJ_TYPE_ANIMAL(2),
        OBJ_TYPE_SEDAN(3),
        OBJ_TYPE_SUV(4),
        OBJ_TYPE_VAN(5),
        OBJ_TYPE_BICYCLE(6),
        OBJ_TYPE_TRICYCLE(7),
        OBJ_TYPE_MOTORCYCLE(8),
        OBJ_TYPE_TRUCK(9),
        OBJ_TYPE_BUS(10),
        OBJ_TYPE_PICKUP(11),
        UNRECOGNIZED(-1);
        
        public static final int OBJ_TYPE_ANIMAL_VALUE = 2;
        public static final int OBJ_TYPE_BICYCLE_VALUE = 6;
        public static final int OBJ_TYPE_BUS_VALUE = 10;
        public static final int OBJ_TYPE_MOTORCYCLE_VALUE = 8;
        public static final int OBJ_TYPE_PERSON_VALUE = 1;
        public static final int OBJ_TYPE_PICKUP_VALUE = 11;
        public static final int OBJ_TYPE_SEDAN_VALUE = 3;
        public static final int OBJ_TYPE_SUV_VALUE = 4;
        public static final int OBJ_TYPE_TRICYCLE_VALUE = 7;
        public static final int OBJ_TYPE_TRUCK_VALUE = 9;
        public static final int OBJ_TYPE_UNKNOWN_VALUE = 0;
        public static final int OBJ_TYPE_VAN_VALUE = 5;
        private final int value;
        private static final Internal.EnumLiteMap<ObjectType> internalValueMap = new Internal.EnumLiteMap<ObjectType>() { // from class: xpilot.sr.proto.Primitives.ObjectType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ObjectType findValueByNumber(int i) {
                return ObjectType.forNumber(i);
            }
        };
        private static final ObjectType[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static ObjectType valueOf(int i) {
            return forNumber(i);
        }

        public static ObjectType forNumber(int i) {
            switch (i) {
                case 0:
                    return OBJ_TYPE_UNKNOWN;
                case 1:
                    return OBJ_TYPE_PERSON;
                case 2:
                    return OBJ_TYPE_ANIMAL;
                case 3:
                    return OBJ_TYPE_SEDAN;
                case 4:
                    return OBJ_TYPE_SUV;
                case 5:
                    return OBJ_TYPE_VAN;
                case 6:
                    return OBJ_TYPE_BICYCLE;
                case 7:
                    return OBJ_TYPE_TRICYCLE;
                case 8:
                    return OBJ_TYPE_MOTORCYCLE;
                case 9:
                    return OBJ_TYPE_TRUCK;
                case 10:
                    return OBJ_TYPE_BUS;
                case 11:
                    return OBJ_TYPE_PICKUP;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ObjectType> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(5);
        }

        public static ObjectType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        ObjectType(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum BrakeLight implements ProtocolMessageEnum {
        BRAKE_LIGHT_UNKNOWN(0),
        BRAKE_LIGHT_ON(1),
        BRAKE_LIGHT_OFF(2),
        UNRECOGNIZED(-1);
        
        public static final int BRAKE_LIGHT_OFF_VALUE = 2;
        public static final int BRAKE_LIGHT_ON_VALUE = 1;
        public static final int BRAKE_LIGHT_UNKNOWN_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<BrakeLight> internalValueMap = new Internal.EnumLiteMap<BrakeLight>() { // from class: xpilot.sr.proto.Primitives.BrakeLight.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public BrakeLight findValueByNumber(int i) {
                return BrakeLight.forNumber(i);
            }
        };
        private static final BrakeLight[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static BrakeLight valueOf(int i) {
            return forNumber(i);
        }

        public static BrakeLight forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return BRAKE_LIGHT_OFF;
                }
                return BRAKE_LIGHT_ON;
            }
            return BRAKE_LIGHT_UNKNOWN;
        }

        public static Internal.EnumLiteMap<BrakeLight> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(6);
        }

        public static BrakeLight valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        BrakeLight(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum SignalLight implements ProtocolMessageEnum {
        SIGNAL_LIGHT_UNKNOWN(0),
        SIGNAL_LIGHT_LEFT(1),
        SIGNAL_LIGHT_RIGHT(2),
        SIGNAL_LIGHT_EMERGENCY(3),
        SIGNAL_LIGHT_OFF(4),
        UNRECOGNIZED(-1);
        
        public static final int SIGNAL_LIGHT_EMERGENCY_VALUE = 3;
        public static final int SIGNAL_LIGHT_LEFT_VALUE = 1;
        public static final int SIGNAL_LIGHT_OFF_VALUE = 4;
        public static final int SIGNAL_LIGHT_RIGHT_VALUE = 2;
        public static final int SIGNAL_LIGHT_UNKNOWN_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<SignalLight> internalValueMap = new Internal.EnumLiteMap<SignalLight>() { // from class: xpilot.sr.proto.Primitives.SignalLight.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SignalLight findValueByNumber(int i) {
                return SignalLight.forNumber(i);
            }
        };
        private static final SignalLight[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static SignalLight valueOf(int i) {
            return forNumber(i);
        }

        public static SignalLight forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return SIGNAL_LIGHT_OFF;
                        }
                        return SIGNAL_LIGHT_EMERGENCY;
                    }
                    return SIGNAL_LIGHT_RIGHT;
                }
                return SIGNAL_LIGHT_LEFT;
            }
            return SIGNAL_LIGHT_UNKNOWN;
        }

        public static Internal.EnumLiteMap<SignalLight> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(7);
        }

        public static SignalLight valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        SignalLight(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum RelativePosition implements ProtocolMessageEnum {
        RELATIVE_POS_UNKNOWN(0),
        RELATIVE_POS_CENTER(1),
        RELATIVE_POS_LEFT(2),
        RELATIVE_POS_FAR_LEFT(3),
        RELATIVE_POS_RIGHT(4),
        RELATIVE_POS_FAR_RIGHT(5),
        UNRECOGNIZED(-1);
        
        public static final int RELATIVE_POS_CENTER_VALUE = 1;
        public static final int RELATIVE_POS_FAR_LEFT_VALUE = 3;
        public static final int RELATIVE_POS_FAR_RIGHT_VALUE = 5;
        public static final int RELATIVE_POS_LEFT_VALUE = 2;
        public static final int RELATIVE_POS_RIGHT_VALUE = 4;
        public static final int RELATIVE_POS_UNKNOWN_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<RelativePosition> internalValueMap = new Internal.EnumLiteMap<RelativePosition>() { // from class: xpilot.sr.proto.Primitives.RelativePosition.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public RelativePosition findValueByNumber(int i) {
                return RelativePosition.forNumber(i);
            }
        };
        private static final RelativePosition[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static RelativePosition valueOf(int i) {
            return forNumber(i);
        }

        public static RelativePosition forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return RELATIVE_POS_FAR_RIGHT;
                            }
                            return RELATIVE_POS_RIGHT;
                        }
                        return RELATIVE_POS_FAR_LEFT;
                    }
                    return RELATIVE_POS_LEFT;
                }
                return RELATIVE_POS_CENTER;
            }
            return RELATIVE_POS_UNKNOWN;
        }

        public static Internal.EnumLiteMap<RelativePosition> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(8);
        }

        public static RelativePosition valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        RelativePosition(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum LaneID implements ProtocolMessageEnum {
        LANT_ID_EGO(0),
        LANT_ID_LEFT(1),
        LANT_ID_RIGHT(2),
        LANT_ID_LEFT_LEFT(3),
        LANT_ID_RIGHT_RIGHT(4),
        UNRECOGNIZED(-1);
        
        public static final int LANT_ID_EGO_VALUE = 0;
        public static final int LANT_ID_LEFT_LEFT_VALUE = 3;
        public static final int LANT_ID_LEFT_VALUE = 1;
        public static final int LANT_ID_RIGHT_RIGHT_VALUE = 4;
        public static final int LANT_ID_RIGHT_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<LaneID> internalValueMap = new Internal.EnumLiteMap<LaneID>() { // from class: xpilot.sr.proto.Primitives.LaneID.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LaneID findValueByNumber(int i) {
                return LaneID.forNumber(i);
            }
        };
        private static final LaneID[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LaneID valueOf(int i) {
            return forNumber(i);
        }

        public static LaneID forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return LANT_ID_RIGHT_RIGHT;
                        }
                        return LANT_ID_LEFT_LEFT;
                    }
                    return LANT_ID_RIGHT;
                }
                return LANT_ID_LEFT;
            }
            return LANT_ID_EGO;
        }

        public static Internal.EnumLiteMap<LaneID> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(9);
        }

        public static LaneID valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LaneID(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum LaneLineID implements ProtocolMessageEnum {
        LINE_ID_LEFT(0),
        LINE_ID_RIGHT(1),
        LINE_ID_LEFT_LEFT(2),
        LINE_ID_RIGHT_RIGHT(3),
        LINE_ID_LEFT_LEFT_LEFT(4),
        LINE_ID_RIGHT_RIGHT_RIGHT(5),
        UNRECOGNIZED(-1);
        
        public static final int LINE_ID_LEFT_LEFT_LEFT_VALUE = 4;
        public static final int LINE_ID_LEFT_LEFT_VALUE = 2;
        public static final int LINE_ID_LEFT_VALUE = 0;
        public static final int LINE_ID_RIGHT_RIGHT_RIGHT_VALUE = 5;
        public static final int LINE_ID_RIGHT_RIGHT_VALUE = 3;
        public static final int LINE_ID_RIGHT_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<LaneLineID> internalValueMap = new Internal.EnumLiteMap<LaneLineID>() { // from class: xpilot.sr.proto.Primitives.LaneLineID.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LaneLineID findValueByNumber(int i) {
                return LaneLineID.forNumber(i);
            }
        };
        private static final LaneLineID[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LaneLineID valueOf(int i) {
            return forNumber(i);
        }

        public static LaneLineID forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return LINE_ID_RIGHT_RIGHT_RIGHT;
                            }
                            return LINE_ID_LEFT_LEFT_LEFT;
                        }
                        return LINE_ID_RIGHT_RIGHT;
                    }
                    return LINE_ID_LEFT_LEFT;
                }
                return LINE_ID_RIGHT;
            }
            return LINE_ID_LEFT;
        }

        public static Internal.EnumLiteMap<LaneLineID> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(10);
        }

        public static LaneLineID valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LaneLineID(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum StaticObjectType implements ProtocolMessageEnum {
        UNKNOWN(0),
        CONE(1),
        BARREL(2),
        BARRIER(3),
        UNRECOGNIZED(-1);
        
        public static final int BARREL_VALUE = 2;
        public static final int BARRIER_VALUE = 3;
        public static final int CONE_VALUE = 1;
        public static final int UNKNOWN_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<StaticObjectType> internalValueMap = new Internal.EnumLiteMap<StaticObjectType>() { // from class: xpilot.sr.proto.Primitives.StaticObjectType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public StaticObjectType findValueByNumber(int i) {
                return StaticObjectType.forNumber(i);
            }
        };
        private static final StaticObjectType[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static StaticObjectType valueOf(int i) {
            return forNumber(i);
        }

        public static StaticObjectType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return BARRIER;
                    }
                    return BARREL;
                }
                return CONE;
            }
            return UNKNOWN;
        }

        public static Internal.EnumLiteMap<StaticObjectType> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(11);
        }

        public static StaticObjectType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        StaticObjectType(int i) {
            this.value = i;
        }
    }

    /* renamed from: xpilot.sr.proto.Primitives$lanelinecolor  reason: case insensitive filesystem */
    /* loaded from: classes4.dex */
    public enum EnumC0056lanelinecolor implements ProtocolMessageEnum {
        unknown(0),
        WHITE(1),
        YELLOW(2),
        RED(3),
        BLUE(4),
        UNRECOGNIZED(-1);
        
        public static final int BLUE_VALUE = 4;
        public static final int RED_VALUE = 3;
        public static final int WHITE_VALUE = 1;
        public static final int YELLOW_VALUE = 2;
        public static final int unknown_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<EnumC0056lanelinecolor> internalValueMap = new Internal.EnumLiteMap<EnumC0056lanelinecolor>() { // from class: xpilot.sr.proto.Primitives.lanelinecolor.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public EnumC0056lanelinecolor findValueByNumber(int i) {
                return EnumC0056lanelinecolor.forNumber(i);
            }
        };
        private static final EnumC0056lanelinecolor[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static EnumC0056lanelinecolor valueOf(int i) {
            return forNumber(i);
        }

        public static EnumC0056lanelinecolor forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return BLUE;
                        }
                        return RED;
                    }
                    return YELLOW;
                }
                return WHITE;
            }
            return unknown;
        }

        public static Internal.EnumLiteMap<EnumC0056lanelinecolor> internalGetValueMap() {
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
            return Primitives.getDescriptor().getEnumTypes().get(12);
        }

        public static EnumC0056lanelinecolor valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        EnumC0056lanelinecolor(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Vector2D extends GeneratedMessageV3 implements Vector2DOrBuilder {
        private static final Vector2D DEFAULT_INSTANCE = new Vector2D();
        private static final Parser<Vector2D> PARSER = new AbstractParser<Vector2D>() { // from class: xpilot.sr.proto.Primitives.Vector2D.1
            @Override // com.google.protobuf.Parser
            public Vector2D parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Vector2D(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private double x_;
        private double y_;

        private Vector2D(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Vector2D() {
            this.memoizedIsInitialized = (byte) -1;
            this.x_ = 0.0d;
            this.y_ = 0.0d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Vector2D(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 9) {
                                    this.x_ = codedInputStream.readDouble();
                                } else if (readTag == 17) {
                                    this.y_ = codedInputStream.readDouble();
                                } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Primitives.internal_static_xpilot_sr_proto_Vector2D_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Vector2D_fieldAccessorTable.ensureFieldAccessorsInitialized(Vector2D.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.Vector2DOrBuilder
        public double getX() {
            return this.x_;
        }

        @Override // xpilot.sr.proto.Primitives.Vector2DOrBuilder
        public double getY() {
            return this.y_;
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
            double d = this.x_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(1, d);
            }
            double d2 = this.y_;
            if (d2 != 0.0d) {
                codedOutputStream.writeDouble(2, d2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            double d = this.x_;
            int computeDoubleSize = d != 0.0d ? 0 + CodedOutputStream.computeDoubleSize(1, d) : 0;
            double d2 = this.y_;
            if (d2 != 0.0d) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(2, d2);
            }
            int serializedSize = computeDoubleSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Vector2D)) {
                return super.equals(obj);
            }
            Vector2D vector2D = (Vector2D) obj;
            return (((Double.doubleToLongBits(getX()) > Double.doubleToLongBits(vector2D.getX()) ? 1 : (Double.doubleToLongBits(getX()) == Double.doubleToLongBits(vector2D.getX()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getY()) > Double.doubleToLongBits(vector2D.getY()) ? 1 : (Double.doubleToLongBits(getY()) == Double.doubleToLongBits(vector2D.getY()) ? 0 : -1)) == 0) && this.unknownFields.equals(vector2D.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(Double.doubleToLongBits(getX()))) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getY()))) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static Vector2D parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Vector2D parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Vector2D parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Vector2D parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Vector2D parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Vector2D parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Vector2D parseFrom(InputStream inputStream) throws IOException {
            return (Vector2D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Vector2D parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Vector2D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Vector2D parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Vector2D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Vector2D parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Vector2D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Vector2D parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Vector2D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Vector2D parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Vector2D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Vector2D vector2D) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(vector2D);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Vector2DOrBuilder {
            private double x_;
            private double y_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Vector2D_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Vector2D_fieldAccessorTable.ensureFieldAccessorsInitialized(Vector2D.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Vector2D.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.x_ = 0.0d;
                this.y_ = 0.0d;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Vector2D_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Vector2D getDefaultInstanceForType() {
                return Vector2D.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Vector2D build() {
                Vector2D buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Vector2D buildPartial() {
                Vector2D vector2D = new Vector2D(this);
                vector2D.x_ = this.x_;
                vector2D.y_ = this.y_;
                onBuilt();
                return vector2D;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Vector2D) {
                    return mergeFrom((Vector2D) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Vector2D vector2D) {
                if (vector2D == Vector2D.getDefaultInstance()) {
                    return this;
                }
                if (vector2D.getX() != 0.0d) {
                    setX(vector2D.getX());
                }
                if (vector2D.getY() != 0.0d) {
                    setY(vector2D.getY());
                }
                mergeUnknownFields(vector2D.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Vector2D.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Vector2D.access$900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Vector2D r3 = (xpilot.sr.proto.Primitives.Vector2D) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Vector2D r4 = (xpilot.sr.proto.Primitives.Vector2D) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Vector2D.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Vector2D$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.Vector2DOrBuilder
            public double getX() {
                return this.x_;
            }

            public Builder setX(double d) {
                this.x_ = d;
                onChanged();
                return this;
            }

            public Builder clearX() {
                this.x_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.Vector2DOrBuilder
            public double getY() {
                return this.y_;
            }

            public Builder setY(double d) {
                this.y_ = d;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.y_ = 0.0d;
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

        public static Vector2D getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Vector2D> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Vector2D> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Vector2D getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Vector3D extends GeneratedMessageV3 implements Vector3DOrBuilder {
        private static final Vector3D DEFAULT_INSTANCE = new Vector3D();
        private static final Parser<Vector3D> PARSER = new AbstractParser<Vector3D>() { // from class: xpilot.sr.proto.Primitives.Vector3D.1
            @Override // com.google.protobuf.Parser
            public Vector3D parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Vector3D(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        public static final int Z_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private double x_;
        private double y_;
        private double z_;

        private Vector3D(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Vector3D() {
            this.memoizedIsInitialized = (byte) -1;
            this.x_ = 0.0d;
            this.y_ = 0.0d;
            this.z_ = 0.0d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Vector3D(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 9) {
                                this.x_ = codedInputStream.readDouble();
                            } else if (readTag == 17) {
                                this.y_ = codedInputStream.readDouble();
                            } else if (readTag == 25) {
                                this.z_ = codedInputStream.readDouble();
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
            return Primitives.internal_static_xpilot_sr_proto_Vector3D_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Vector3D_fieldAccessorTable.ensureFieldAccessorsInitialized(Vector3D.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.Vector3DOrBuilder
        public double getX() {
            return this.x_;
        }

        @Override // xpilot.sr.proto.Primitives.Vector3DOrBuilder
        public double getY() {
            return this.y_;
        }

        @Override // xpilot.sr.proto.Primitives.Vector3DOrBuilder
        public double getZ() {
            return this.z_;
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
            double d = this.x_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(1, d);
            }
            double d2 = this.y_;
            if (d2 != 0.0d) {
                codedOutputStream.writeDouble(2, d2);
            }
            double d3 = this.z_;
            if (d3 != 0.0d) {
                codedOutputStream.writeDouble(3, d3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            double d = this.x_;
            int computeDoubleSize = d != 0.0d ? 0 + CodedOutputStream.computeDoubleSize(1, d) : 0;
            double d2 = this.y_;
            if (d2 != 0.0d) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(2, d2);
            }
            double d3 = this.z_;
            if (d3 != 0.0d) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(3, d3);
            }
            int serializedSize = computeDoubleSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Vector3D)) {
                return super.equals(obj);
            }
            Vector3D vector3D = (Vector3D) obj;
            return ((((Double.doubleToLongBits(getX()) > Double.doubleToLongBits(vector3D.getX()) ? 1 : (Double.doubleToLongBits(getX()) == Double.doubleToLongBits(vector3D.getX()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getY()) > Double.doubleToLongBits(vector3D.getY()) ? 1 : (Double.doubleToLongBits(getY()) == Double.doubleToLongBits(vector3D.getY()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getZ()) > Double.doubleToLongBits(vector3D.getZ()) ? 1 : (Double.doubleToLongBits(getZ()) == Double.doubleToLongBits(vector3D.getZ()) ? 0 : -1)) == 0) && this.unknownFields.equals(vector3D.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(Double.doubleToLongBits(getX()))) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getY()))) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getZ()))) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static Vector3D parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Vector3D parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Vector3D parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Vector3D parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Vector3D parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Vector3D parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Vector3D parseFrom(InputStream inputStream) throws IOException {
            return (Vector3D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Vector3D parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Vector3D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Vector3D parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Vector3D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Vector3D parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Vector3D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Vector3D parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Vector3D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Vector3D parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Vector3D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Vector3D vector3D) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(vector3D);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Vector3DOrBuilder {
            private double x_;
            private double y_;
            private double z_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Vector3D_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Vector3D_fieldAccessorTable.ensureFieldAccessorsInitialized(Vector3D.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Vector3D.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.x_ = 0.0d;
                this.y_ = 0.0d;
                this.z_ = 0.0d;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Vector3D_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Vector3D getDefaultInstanceForType() {
                return Vector3D.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Vector3D build() {
                Vector3D buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Vector3D buildPartial() {
                Vector3D vector3D = new Vector3D(this);
                vector3D.x_ = this.x_;
                vector3D.y_ = this.y_;
                vector3D.z_ = this.z_;
                onBuilt();
                return vector3D;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Vector3D) {
                    return mergeFrom((Vector3D) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Vector3D vector3D) {
                if (vector3D == Vector3D.getDefaultInstance()) {
                    return this;
                }
                if (vector3D.getX() != 0.0d) {
                    setX(vector3D.getX());
                }
                if (vector3D.getY() != 0.0d) {
                    setY(vector3D.getY());
                }
                if (vector3D.getZ() != 0.0d) {
                    setZ(vector3D.getZ());
                }
                mergeUnknownFields(vector3D.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Vector3D.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Vector3D.access$2100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Vector3D r3 = (xpilot.sr.proto.Primitives.Vector3D) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Vector3D r4 = (xpilot.sr.proto.Primitives.Vector3D) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Vector3D.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Vector3D$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.Vector3DOrBuilder
            public double getX() {
                return this.x_;
            }

            public Builder setX(double d) {
                this.x_ = d;
                onChanged();
                return this;
            }

            public Builder clearX() {
                this.x_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.Vector3DOrBuilder
            public double getY() {
                return this.y_;
            }

            public Builder setY(double d) {
                this.y_ = d;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.y_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.Vector3DOrBuilder
            public double getZ() {
                return this.z_;
            }

            public Builder setZ(double d) {
                this.z_ = d;
                onChanged();
                return this;
            }

            public Builder clearZ() {
                this.z_ = 0.0d;
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

        public static Vector3D getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Vector3D> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Vector3D> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Vector3D getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Size2D extends GeneratedMessageV3 implements Size2DOrBuilder {
        public static final int LENGTH_FIELD_NUMBER = 1;
        public static final int WIDTH_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private float length_;
        private byte memoizedIsInitialized;
        private float width_;
        private static final Size2D DEFAULT_INSTANCE = new Size2D();
        private static final Parser<Size2D> PARSER = new AbstractParser<Size2D>() { // from class: xpilot.sr.proto.Primitives.Size2D.1
            @Override // com.google.protobuf.Parser
            public Size2D parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Size2D(codedInputStream, extensionRegistryLite);
            }
        };

        private Size2D(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Size2D() {
            this.memoizedIsInitialized = (byte) -1;
            this.length_ = 0.0f;
            this.width_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Size2D(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.length_ = codedInputStream.readFloat();
                                } else if (readTag == 21) {
                                    this.width_ = codedInputStream.readFloat();
                                } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Primitives.internal_static_xpilot_sr_proto_Size2D_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Size2D_fieldAccessorTable.ensureFieldAccessorsInitialized(Size2D.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.Size2DOrBuilder
        public float getLength() {
            return this.length_;
        }

        @Override // xpilot.sr.proto.Primitives.Size2DOrBuilder
        public float getWidth() {
            return this.width_;
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
            float f = this.length_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.width_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(2, f2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            float f = this.length_;
            int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
            float f2 = this.width_;
            if (f2 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(2, f2);
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
            if (!(obj instanceof Size2D)) {
                return super.equals(obj);
            }
            Size2D size2D = (Size2D) obj;
            return ((Float.floatToIntBits(getLength()) == Float.floatToIntBits(size2D.getLength())) && Float.floatToIntBits(getWidth()) == Float.floatToIntBits(size2D.getWidth())) && this.unknownFields.equals(size2D.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getLength())) * 37) + 2) * 53) + Float.floatToIntBits(getWidth())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static Size2D parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Size2D parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Size2D parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Size2D parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Size2D parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Size2D parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Size2D parseFrom(InputStream inputStream) throws IOException {
            return (Size2D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Size2D parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Size2D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Size2D parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Size2D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Size2D parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Size2D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Size2D parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Size2D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Size2D parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Size2D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Size2D size2D) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(size2D);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Size2DOrBuilder {
            private float length_;
            private float width_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Size2D_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Size2D_fieldAccessorTable.ensureFieldAccessorsInitialized(Size2D.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Size2D.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.length_ = 0.0f;
                this.width_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Size2D_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Size2D getDefaultInstanceForType() {
                return Size2D.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Size2D build() {
                Size2D buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Size2D buildPartial() {
                Size2D size2D = new Size2D(this);
                size2D.length_ = this.length_;
                size2D.width_ = this.width_;
                onBuilt();
                return size2D;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Size2D) {
                    return mergeFrom((Size2D) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Size2D size2D) {
                if (size2D == Size2D.getDefaultInstance()) {
                    return this;
                }
                if (size2D.getLength() != 0.0f) {
                    setLength(size2D.getLength());
                }
                if (size2D.getWidth() != 0.0f) {
                    setWidth(size2D.getWidth());
                }
                mergeUnknownFields(size2D.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Size2D.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Size2D.access$3200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Size2D r3 = (xpilot.sr.proto.Primitives.Size2D) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Size2D r4 = (xpilot.sr.proto.Primitives.Size2D) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Size2D.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Size2D$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.Size2DOrBuilder
            public float getLength() {
                return this.length_;
            }

            public Builder setLength(float f) {
                this.length_ = f;
                onChanged();
                return this;
            }

            public Builder clearLength() {
                this.length_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.Size2DOrBuilder
            public float getWidth() {
                return this.width_;
            }

            public Builder setWidth(float f) {
                this.width_ = f;
                onChanged();
                return this;
            }

            public Builder clearWidth() {
                this.width_ = 0.0f;
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

        public static Size2D getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Size2D> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Size2D> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Size2D getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Size3D extends GeneratedMessageV3 implements Size3DOrBuilder {
        public static final int HEIGHT_FIELD_NUMBER = 3;
        public static final int LENGTH_FIELD_NUMBER = 1;
        public static final int WIDTH_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private float height_;
        private float length_;
        private byte memoizedIsInitialized;
        private float width_;
        private static final Size3D DEFAULT_INSTANCE = new Size3D();
        private static final Parser<Size3D> PARSER = new AbstractParser<Size3D>() { // from class: xpilot.sr.proto.Primitives.Size3D.1
            @Override // com.google.protobuf.Parser
            public Size3D parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Size3D(codedInputStream, extensionRegistryLite);
            }
        };

        private Size3D(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Size3D() {
            this.memoizedIsInitialized = (byte) -1;
            this.length_ = 0.0f;
            this.width_ = 0.0f;
            this.height_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Size3D(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.length_ = codedInputStream.readFloat();
                            } else if (readTag == 21) {
                                this.width_ = codedInputStream.readFloat();
                            } else if (readTag == 29) {
                                this.height_ = codedInputStream.readFloat();
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
            return Primitives.internal_static_xpilot_sr_proto_Size3D_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Size3D_fieldAccessorTable.ensureFieldAccessorsInitialized(Size3D.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.Size3DOrBuilder
        public float getLength() {
            return this.length_;
        }

        @Override // xpilot.sr.proto.Primitives.Size3DOrBuilder
        public float getWidth() {
            return this.width_;
        }

        @Override // xpilot.sr.proto.Primitives.Size3DOrBuilder
        public float getHeight() {
            return this.height_;
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
            float f = this.length_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.width_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(2, f2);
            }
            float f3 = this.height_;
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
            float f = this.length_;
            int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
            float f2 = this.width_;
            if (f2 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(2, f2);
            }
            float f3 = this.height_;
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
            if (!(obj instanceof Size3D)) {
                return super.equals(obj);
            }
            Size3D size3D = (Size3D) obj;
            return (((Float.floatToIntBits(getLength()) == Float.floatToIntBits(size3D.getLength())) && Float.floatToIntBits(getWidth()) == Float.floatToIntBits(size3D.getWidth())) && Float.floatToIntBits(getHeight()) == Float.floatToIntBits(size3D.getHeight())) && this.unknownFields.equals(size3D.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getLength())) * 37) + 2) * 53) + Float.floatToIntBits(getWidth())) * 37) + 3) * 53) + Float.floatToIntBits(getHeight())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static Size3D parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Size3D parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Size3D parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Size3D parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Size3D parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Size3D parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Size3D parseFrom(InputStream inputStream) throws IOException {
            return (Size3D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Size3D parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Size3D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Size3D parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Size3D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Size3D parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Size3D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Size3D parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Size3D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Size3D parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Size3D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Size3D size3D) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(size3D);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Size3DOrBuilder {
            private float height_;
            private float length_;
            private float width_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Size3D_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Size3D_fieldAccessorTable.ensureFieldAccessorsInitialized(Size3D.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Size3D.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.length_ = 0.0f;
                this.width_ = 0.0f;
                this.height_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Size3D_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Size3D getDefaultInstanceForType() {
                return Size3D.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Size3D build() {
                Size3D buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Size3D buildPartial() {
                Size3D size3D = new Size3D(this);
                size3D.length_ = this.length_;
                size3D.width_ = this.width_;
                size3D.height_ = this.height_;
                onBuilt();
                return size3D;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Size3D) {
                    return mergeFrom((Size3D) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Size3D size3D) {
                if (size3D == Size3D.getDefaultInstance()) {
                    return this;
                }
                if (size3D.getLength() != 0.0f) {
                    setLength(size3D.getLength());
                }
                if (size3D.getWidth() != 0.0f) {
                    setWidth(size3D.getWidth());
                }
                if (size3D.getHeight() != 0.0f) {
                    setHeight(size3D.getHeight());
                }
                mergeUnknownFields(size3D.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Size3D.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Size3D.access$4400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Size3D r3 = (xpilot.sr.proto.Primitives.Size3D) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Size3D r4 = (xpilot.sr.proto.Primitives.Size3D) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Size3D.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Size3D$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.Size3DOrBuilder
            public float getLength() {
                return this.length_;
            }

            public Builder setLength(float f) {
                this.length_ = f;
                onChanged();
                return this;
            }

            public Builder clearLength() {
                this.length_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.Size3DOrBuilder
            public float getWidth() {
                return this.width_;
            }

            public Builder setWidth(float f) {
                this.width_ = f;
                onChanged();
                return this;
            }

            public Builder clearWidth() {
                this.width_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.Size3DOrBuilder
            public float getHeight() {
                return this.height_;
            }

            public Builder setHeight(float f) {
                this.height_ = f;
                onChanged();
                return this;
            }

            public Builder clearHeight() {
                this.height_ = 0.0f;
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

        public static Size3D getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Size3D> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Size3D> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Size3D getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Quaternion extends GeneratedMessageV3 implements QuaternionOrBuilder {
        private static final Quaternion DEFAULT_INSTANCE = new Quaternion();
        private static final Parser<Quaternion> PARSER = new AbstractParser<Quaternion>() { // from class: xpilot.sr.proto.Primitives.Quaternion.1
            @Override // com.google.protobuf.Parser
            public Quaternion parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Quaternion(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int QW_FIELD_NUMBER = 4;
        public static final int QX_FIELD_NUMBER = 1;
        public static final int QY_FIELD_NUMBER = 2;
        public static final int QZ_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private double qw_;
        private double qx_;
        private double qy_;
        private double qz_;

        private Quaternion(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Quaternion() {
            this.memoizedIsInitialized = (byte) -1;
            this.qx_ = 0.0d;
            this.qy_ = 0.0d;
            this.qz_ = 0.0d;
            this.qw_ = 0.0d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Quaternion(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 9) {
                                this.qx_ = codedInputStream.readDouble();
                            } else if (readTag == 17) {
                                this.qy_ = codedInputStream.readDouble();
                            } else if (readTag == 25) {
                                this.qz_ = codedInputStream.readDouble();
                            } else if (readTag == 33) {
                                this.qw_ = codedInputStream.readDouble();
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
            return Primitives.internal_static_xpilot_sr_proto_Quaternion_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Quaternion_fieldAccessorTable.ensureFieldAccessorsInitialized(Quaternion.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.QuaternionOrBuilder
        public double getQx() {
            return this.qx_;
        }

        @Override // xpilot.sr.proto.Primitives.QuaternionOrBuilder
        public double getQy() {
            return this.qy_;
        }

        @Override // xpilot.sr.proto.Primitives.QuaternionOrBuilder
        public double getQz() {
            return this.qz_;
        }

        @Override // xpilot.sr.proto.Primitives.QuaternionOrBuilder
        public double getQw() {
            return this.qw_;
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
            double d = this.qx_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(1, d);
            }
            double d2 = this.qy_;
            if (d2 != 0.0d) {
                codedOutputStream.writeDouble(2, d2);
            }
            double d3 = this.qz_;
            if (d3 != 0.0d) {
                codedOutputStream.writeDouble(3, d3);
            }
            double d4 = this.qw_;
            if (d4 != 0.0d) {
                codedOutputStream.writeDouble(4, d4);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            double d = this.qx_;
            int computeDoubleSize = d != 0.0d ? 0 + CodedOutputStream.computeDoubleSize(1, d) : 0;
            double d2 = this.qy_;
            if (d2 != 0.0d) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(2, d2);
            }
            double d3 = this.qz_;
            if (d3 != 0.0d) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(3, d3);
            }
            double d4 = this.qw_;
            if (d4 != 0.0d) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(4, d4);
            }
            int serializedSize = computeDoubleSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Quaternion)) {
                return super.equals(obj);
            }
            Quaternion quaternion = (Quaternion) obj;
            return (((((Double.doubleToLongBits(getQx()) > Double.doubleToLongBits(quaternion.getQx()) ? 1 : (Double.doubleToLongBits(getQx()) == Double.doubleToLongBits(quaternion.getQx()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getQy()) > Double.doubleToLongBits(quaternion.getQy()) ? 1 : (Double.doubleToLongBits(getQy()) == Double.doubleToLongBits(quaternion.getQy()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getQz()) > Double.doubleToLongBits(quaternion.getQz()) ? 1 : (Double.doubleToLongBits(getQz()) == Double.doubleToLongBits(quaternion.getQz()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getQw()) > Double.doubleToLongBits(quaternion.getQw()) ? 1 : (Double.doubleToLongBits(getQw()) == Double.doubleToLongBits(quaternion.getQw()) ? 0 : -1)) == 0) && this.unknownFields.equals(quaternion.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(Double.doubleToLongBits(getQx()))) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getQy()))) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getQz()))) * 37) + 4) * 53) + Internal.hashLong(Double.doubleToLongBits(getQw()))) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static Quaternion parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Quaternion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Quaternion parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Quaternion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Quaternion parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Quaternion parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Quaternion parseFrom(InputStream inputStream) throws IOException {
            return (Quaternion) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Quaternion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Quaternion) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Quaternion parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Quaternion) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Quaternion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Quaternion) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Quaternion parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Quaternion) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Quaternion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Quaternion) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Quaternion quaternion) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(quaternion);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuaternionOrBuilder {
            private double qw_;
            private double qx_;
            private double qy_;
            private double qz_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Quaternion_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Quaternion_fieldAccessorTable.ensureFieldAccessorsInitialized(Quaternion.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Quaternion.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.qx_ = 0.0d;
                this.qy_ = 0.0d;
                this.qz_ = 0.0d;
                this.qw_ = 0.0d;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Quaternion_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Quaternion getDefaultInstanceForType() {
                return Quaternion.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Quaternion build() {
                Quaternion buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Quaternion buildPartial() {
                Quaternion quaternion = new Quaternion(this);
                quaternion.qx_ = this.qx_;
                quaternion.qy_ = this.qy_;
                quaternion.qz_ = this.qz_;
                quaternion.qw_ = this.qw_;
                onBuilt();
                return quaternion;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Quaternion) {
                    return mergeFrom((Quaternion) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Quaternion quaternion) {
                if (quaternion == Quaternion.getDefaultInstance()) {
                    return this;
                }
                if (quaternion.getQx() != 0.0d) {
                    setQx(quaternion.getQx());
                }
                if (quaternion.getQy() != 0.0d) {
                    setQy(quaternion.getQy());
                }
                if (quaternion.getQz() != 0.0d) {
                    setQz(quaternion.getQz());
                }
                if (quaternion.getQw() != 0.0d) {
                    setQw(quaternion.getQw());
                }
                mergeUnknownFields(quaternion.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Quaternion.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Quaternion.access$5700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Quaternion r3 = (xpilot.sr.proto.Primitives.Quaternion) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Quaternion r4 = (xpilot.sr.proto.Primitives.Quaternion) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Quaternion.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Quaternion$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.QuaternionOrBuilder
            public double getQx() {
                return this.qx_;
            }

            public Builder setQx(double d) {
                this.qx_ = d;
                onChanged();
                return this;
            }

            public Builder clearQx() {
                this.qx_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.QuaternionOrBuilder
            public double getQy() {
                return this.qy_;
            }

            public Builder setQy(double d) {
                this.qy_ = d;
                onChanged();
                return this;
            }

            public Builder clearQy() {
                this.qy_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.QuaternionOrBuilder
            public double getQz() {
                return this.qz_;
            }

            public Builder setQz(double d) {
                this.qz_ = d;
                onChanged();
                return this;
            }

            public Builder clearQz() {
                this.qz_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.QuaternionOrBuilder
            public double getQw() {
                return this.qw_;
            }

            public Builder setQw(double d) {
                this.qw_ = d;
                onChanged();
                return this;
            }

            public Builder clearQw() {
                this.qw_ = 0.0d;
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

        public static Quaternion getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Quaternion> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Quaternion> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Quaternion getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class WayPoint extends GeneratedMessageV3 implements WayPointOrBuilder {
        public static final int LOCAL_WAYPOINT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int localWaypointMemoizedSerializedSize;
        private List<Float> localWaypoint_;
        private byte memoizedIsInitialized;
        private static final WayPoint DEFAULT_INSTANCE = new WayPoint();
        private static final Parser<WayPoint> PARSER = new AbstractParser<WayPoint>() { // from class: xpilot.sr.proto.Primitives.WayPoint.1
            @Override // com.google.protobuf.Parser
            public WayPoint parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WayPoint(codedInputStream, extensionRegistryLite);
            }
        };

        private WayPoint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.localWaypointMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private WayPoint() {
            this.localWaypointMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.localWaypoint_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WayPoint(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.localWaypoint_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.localWaypoint_.add(Float.valueOf(codedInputStream.readFloat()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag == 13) {
                                    if (!(z2 & true)) {
                                        this.localWaypoint_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.localWaypoint_.add(Float.valueOf(codedInputStream.readFloat()));
                                } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.localWaypoint_ = Collections.unmodifiableList(this.localWaypoint_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Primitives.internal_static_xpilot_sr_proto_WayPoint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_WayPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(WayPoint.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.WayPointOrBuilder
        public List<Float> getLocalWaypointList() {
            return this.localWaypoint_;
        }

        @Override // xpilot.sr.proto.Primitives.WayPointOrBuilder
        public int getLocalWaypointCount() {
            return this.localWaypoint_.size();
        }

        @Override // xpilot.sr.proto.Primitives.WayPointOrBuilder
        public float getLocalWaypoint(int i) {
            return this.localWaypoint_.get(i).floatValue();
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
            if (getLocalWaypointList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(10);
                codedOutputStream.writeUInt32NoTag(this.localWaypointMemoizedSerializedSize);
            }
            for (int i = 0; i < this.localWaypoint_.size(); i++) {
                codedOutputStream.writeFloatNoTag(this.localWaypoint_.get(i).floatValue());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int size = getLocalWaypointList().size() * 4;
            int i2 = size + 0;
            if (!getLocalWaypointList().isEmpty()) {
                i2 = i2 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.localWaypointMemoizedSerializedSize = size;
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WayPoint)) {
                return super.equals(obj);
            }
            WayPoint wayPoint = (WayPoint) obj;
            return (getLocalWaypointList().equals(wayPoint.getLocalWaypointList())) && this.unknownFields.equals(wayPoint.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getLocalWaypointCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getLocalWaypointList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static WayPoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static WayPoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static WayPoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static WayPoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static WayPoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static WayPoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WayPoint parseFrom(InputStream inputStream) throws IOException {
            return (WayPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WayPoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WayPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WayPoint parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WayPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WayPoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WayPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WayPoint parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WayPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WayPoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WayPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WayPoint wayPoint) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wayPoint);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WayPointOrBuilder {
            private int bitField0_;
            private List<Float> localWaypoint_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_WayPoint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_WayPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(WayPoint.class, Builder.class);
            }

            private Builder() {
                this.localWaypoint_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.localWaypoint_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = WayPoint.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.localWaypoint_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_WayPoint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WayPoint getDefaultInstanceForType() {
                return WayPoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WayPoint build() {
                WayPoint buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WayPoint buildPartial() {
                WayPoint wayPoint = new WayPoint(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.localWaypoint_ = Collections.unmodifiableList(this.localWaypoint_);
                    this.bitField0_ &= -2;
                }
                wayPoint.localWaypoint_ = this.localWaypoint_;
                onBuilt();
                return wayPoint;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof WayPoint) {
                    return mergeFrom((WayPoint) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(WayPoint wayPoint) {
                if (wayPoint == WayPoint.getDefaultInstance()) {
                    return this;
                }
                if (!wayPoint.localWaypoint_.isEmpty()) {
                    if (this.localWaypoint_.isEmpty()) {
                        this.localWaypoint_ = wayPoint.localWaypoint_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLocalWaypointIsMutable();
                        this.localWaypoint_.addAll(wayPoint.localWaypoint_);
                    }
                    onChanged();
                }
                mergeUnknownFields(wayPoint.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.WayPoint.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.WayPoint.access$6700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$WayPoint r3 = (xpilot.sr.proto.Primitives.WayPoint) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$WayPoint r4 = (xpilot.sr.proto.Primitives.WayPoint) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.WayPoint.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$WayPoint$Builder");
            }

            private void ensureLocalWaypointIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.localWaypoint_ = new ArrayList(this.localWaypoint_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.Primitives.WayPointOrBuilder
            public List<Float> getLocalWaypointList() {
                return Collections.unmodifiableList(this.localWaypoint_);
            }

            @Override // xpilot.sr.proto.Primitives.WayPointOrBuilder
            public int getLocalWaypointCount() {
                return this.localWaypoint_.size();
            }

            @Override // xpilot.sr.proto.Primitives.WayPointOrBuilder
            public float getLocalWaypoint(int i) {
                return this.localWaypoint_.get(i).floatValue();
            }

            public Builder setLocalWaypoint(int i, float f) {
                ensureLocalWaypointIsMutable();
                this.localWaypoint_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addLocalWaypoint(float f) {
                ensureLocalWaypointIsMutable();
                this.localWaypoint_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addAllLocalWaypoint(Iterable<? extends Float> iterable) {
                ensureLocalWaypointIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.localWaypoint_);
                onChanged();
                return this;
            }

            public Builder clearLocalWaypoint() {
                this.localWaypoint_ = Collections.emptyList();
                this.bitField0_ &= -2;
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

        public static WayPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WayPoint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WayPoint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WayPoint getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Polygon3D extends GeneratedMessageV3 implements Polygon3DOrBuilder {
        private static final Polygon3D DEFAULT_INSTANCE = new Polygon3D();
        private static final Parser<Polygon3D> PARSER = new AbstractParser<Polygon3D>() { // from class: xpilot.sr.proto.Primitives.Polygon3D.1
            @Override // com.google.protobuf.Parser
            public Polygon3D parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Polygon3D(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int POINT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<Vector3D> point_;

        private Polygon3D(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Polygon3D() {
            this.memoizedIsInitialized = (byte) -1;
            this.point_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Polygon3D(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    if (!(z2 & true)) {
                                        this.point_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.point_.add(codedInputStream.readMessage(Vector3D.parser(), extensionRegistryLite));
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
                    if (z2 & true) {
                        this.point_ = Collections.unmodifiableList(this.point_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Primitives.internal_static_xpilot_sr_proto_Polygon3D_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Polygon3D_fieldAccessorTable.ensureFieldAccessorsInitialized(Polygon3D.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
        public List<Vector3D> getPointList() {
            return this.point_;
        }

        @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
        public List<? extends Vector3DOrBuilder> getPointOrBuilderList() {
            return this.point_;
        }

        @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
        public int getPointCount() {
            return this.point_.size();
        }

        @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
        public Vector3D getPoint(int i) {
            return this.point_.get(i);
        }

        @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
        public Vector3DOrBuilder getPointOrBuilder(int i) {
            return this.point_.get(i);
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
            for (int i = 0; i < this.point_.size(); i++) {
                codedOutputStream.writeMessage(1, this.point_.get(i));
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
            for (int i3 = 0; i3 < this.point_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.point_.get(i3));
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Polygon3D)) {
                return super.equals(obj);
            }
            Polygon3D polygon3D = (Polygon3D) obj;
            return (getPointList().equals(polygon3D.getPointList())) && this.unknownFields.equals(polygon3D.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getPointCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getPointList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Polygon3D parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Polygon3D parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Polygon3D parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Polygon3D parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Polygon3D parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Polygon3D parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Polygon3D parseFrom(InputStream inputStream) throws IOException {
            return (Polygon3D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Polygon3D parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Polygon3D) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Polygon3D parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Polygon3D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Polygon3D parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Polygon3D) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Polygon3D parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Polygon3D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Polygon3D parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Polygon3D) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Polygon3D polygon3D) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(polygon3D);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Polygon3DOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> pointBuilder_;
            private List<Vector3D> point_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Polygon3D_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Polygon3D_fieldAccessorTable.ensureFieldAccessorsInitialized(Polygon3D.class, Builder.class);
            }

            private Builder() {
                this.point_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.point_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Polygon3D.alwaysUseFieldBuilders) {
                    getPointFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.point_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Polygon3D_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Polygon3D getDefaultInstanceForType() {
                return Polygon3D.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Polygon3D build() {
                Polygon3D buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Polygon3D buildPartial() {
                Polygon3D polygon3D = new Polygon3D(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.point_ = Collections.unmodifiableList(this.point_);
                        this.bitField0_ &= -2;
                    }
                    polygon3D.point_ = this.point_;
                } else {
                    polygon3D.point_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return polygon3D;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Polygon3D) {
                    return mergeFrom((Polygon3D) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Polygon3D polygon3D) {
                if (polygon3D == Polygon3D.getDefaultInstance()) {
                    return this;
                }
                if (this.pointBuilder_ == null) {
                    if (!polygon3D.point_.isEmpty()) {
                        if (this.point_.isEmpty()) {
                            this.point_ = polygon3D.point_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePointIsMutable();
                            this.point_.addAll(polygon3D.point_);
                        }
                        onChanged();
                    }
                } else if (!polygon3D.point_.isEmpty()) {
                    if (!this.pointBuilder_.isEmpty()) {
                        this.pointBuilder_.addAllMessages(polygon3D.point_);
                    } else {
                        this.pointBuilder_.dispose();
                        this.pointBuilder_ = null;
                        this.point_ = polygon3D.point_;
                        this.bitField0_ &= -2;
                        this.pointBuilder_ = Polygon3D.alwaysUseFieldBuilders ? getPointFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(polygon3D.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Polygon3D.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Polygon3D.access$7800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Polygon3D r3 = (xpilot.sr.proto.Primitives.Polygon3D) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Polygon3D r4 = (xpilot.sr.proto.Primitives.Polygon3D) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Polygon3D.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Polygon3D$Builder");
            }

            private void ensurePointIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.point_ = new ArrayList(this.point_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
            public List<Vector3D> getPointList() {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.point_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
            public int getPointCount() {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.point_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
            public Vector3D getPoint(int i) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.point_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setPoint(int i, Vector3D vector3D) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointIsMutable();
                    this.point_.set(i, vector3D);
                    onChanged();
                }
                return this;
            }

            public Builder setPoint(int i, Vector3D.Builder builder) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointIsMutable();
                    this.point_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addPoint(Vector3D vector3D) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointIsMutable();
                    this.point_.add(vector3D);
                    onChanged();
                }
                return this;
            }

            public Builder addPoint(int i, Vector3D vector3D) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointIsMutable();
                    this.point_.add(i, vector3D);
                    onChanged();
                }
                return this;
            }

            public Builder addPoint(Vector3D.Builder builder) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointIsMutable();
                    this.point_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addPoint(int i, Vector3D.Builder builder) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointIsMutable();
                    this.point_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllPoint(Iterable<? extends Vector3D> iterable) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.point_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearPoint() {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.point_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removePoint(int i) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointIsMutable();
                    this.point_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Vector3D.Builder getPointBuilder(int i) {
                return getPointFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
            public Vector3DOrBuilder getPointOrBuilder(int i) {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.point_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.Primitives.Polygon3DOrBuilder
            public List<? extends Vector3DOrBuilder> getPointOrBuilderList() {
                RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> repeatedFieldBuilderV3 = this.pointBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.point_);
            }

            public Vector3D.Builder addPointBuilder() {
                return getPointFieldBuilder().addBuilder(Vector3D.getDefaultInstance());
            }

            public Vector3D.Builder addPointBuilder(int i) {
                return getPointFieldBuilder().addBuilder(i, Vector3D.getDefaultInstance());
            }

            public List<Vector3D.Builder> getPointBuilderList() {
                return getPointFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> getPointFieldBuilder() {
                if (this.pointBuilder_ == null) {
                    this.pointBuilder_ = new RepeatedFieldBuilderV3<>(this.point_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.point_ = null;
                }
                return this.pointBuilder_;
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

        public static Polygon3D getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Polygon3D> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Polygon3D> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Polygon3D getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Time extends GeneratedMessageV3 implements TimeOrBuilder {
        public static final int NSECS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private long nsecs_;
        private static final Time DEFAULT_INSTANCE = new Time();
        private static final Parser<Time> PARSER = new AbstractParser<Time>() { // from class: xpilot.sr.proto.Primitives.Time.1
            @Override // com.google.protobuf.Parser
            public Time parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Time(codedInputStream, extensionRegistryLite);
            }
        };

        private Time(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Time() {
            this.memoizedIsInitialized = (byte) -1;
            this.nsecs_ = 0L;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Time(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.nsecs_ = codedInputStream.readUInt64();
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
            return Primitives.internal_static_xpilot_sr_proto_Time_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Time_fieldAccessorTable.ensureFieldAccessorsInitialized(Time.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.TimeOrBuilder
        public long getNsecs() {
            return this.nsecs_;
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
            long j = this.nsecs_;
            if (j != 0) {
                codedOutputStream.writeUInt64(1, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.nsecs_;
            int computeUInt64Size = (j != 0 ? 0 + CodedOutputStream.computeUInt64Size(1, j) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = computeUInt64Size;
            return computeUInt64Size;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Time)) {
                return super.equals(obj);
            }
            Time time = (Time) obj;
            return ((getNsecs() > time.getNsecs() ? 1 : (getNsecs() == time.getNsecs() ? 0 : -1)) == 0) && this.unknownFields.equals(time.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getNsecs())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static Time parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Time parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Time parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Time parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Time parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Time parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Time parseFrom(InputStream inputStream) throws IOException {
            return (Time) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Time parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Time) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Time parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Time) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Time parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Time) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Time parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Time) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Time parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Time) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Time time) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(time);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TimeOrBuilder {
            private long nsecs_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Time_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Time_fieldAccessorTable.ensureFieldAccessorsInitialized(Time.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Time.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.nsecs_ = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Time_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Time getDefaultInstanceForType() {
                return Time.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Time build() {
                Time buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Time buildPartial() {
                Time time = new Time(this);
                time.nsecs_ = this.nsecs_;
                onBuilt();
                return time;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Time) {
                    return mergeFrom((Time) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Time time) {
                if (time == Time.getDefaultInstance()) {
                    return this;
                }
                if (time.getNsecs() != 0) {
                    setNsecs(time.getNsecs());
                }
                mergeUnknownFields(time.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Time.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Time.access$8800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Time r3 = (xpilot.sr.proto.Primitives.Time) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Time r4 = (xpilot.sr.proto.Primitives.Time) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Time.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Time$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.TimeOrBuilder
            public long getNsecs() {
                return this.nsecs_;
            }

            public Builder setNsecs(long j) {
                this.nsecs_ = j;
                onChanged();
                return this;
            }

            public Builder clearNsecs() {
                this.nsecs_ = 0L;
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

        public static Time getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Time> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Time> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Time getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Pose6DOF extends GeneratedMessageV3 implements Pose6DOFOrBuilder {
        private static final Pose6DOF DEFAULT_INSTANCE = new Pose6DOF();
        private static final Parser<Pose6DOF> PARSER = new AbstractParser<Pose6DOF>() { // from class: xpilot.sr.proto.Primitives.Pose6DOF.1
            @Override // com.google.protobuf.Parser
            public Pose6DOF parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Pose6DOF(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int P_FIELD_NUMBER = 1;
        public static final int Q_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private Vector3D p_;
        private Quaternion q_;

        private Pose6DOF(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Pose6DOF() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Pose6DOF(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                Vector3D.Builder builder = this.p_ != null ? this.p_.toBuilder() : null;
                                this.p_ = (Vector3D) codedInputStream.readMessage(Vector3D.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.p_);
                                    this.p_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                Quaternion.Builder builder2 = this.q_ != null ? this.q_.toBuilder() : null;
                                this.q_ = (Quaternion) codedInputStream.readMessage(Quaternion.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.q_);
                                    this.q_ = builder2.buildPartial();
                                }
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
            return Primitives.internal_static_xpilot_sr_proto_Pose6DOF_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Pose6DOF_fieldAccessorTable.ensureFieldAccessorsInitialized(Pose6DOF.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
        public boolean hasP() {
            return this.p_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
        public Vector3D getP() {
            Vector3D vector3D = this.p_;
            return vector3D == null ? Vector3D.getDefaultInstance() : vector3D;
        }

        @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
        public Vector3DOrBuilder getPOrBuilder() {
            return getP();
        }

        @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
        public boolean hasQ() {
            return this.q_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
        public Quaternion getQ() {
            Quaternion quaternion = this.q_;
            return quaternion == null ? Quaternion.getDefaultInstance() : quaternion;
        }

        @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
        public QuaternionOrBuilder getQOrBuilder() {
            return getQ();
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
            if (this.p_ != null) {
                codedOutputStream.writeMessage(1, getP());
            }
            if (this.q_ != null) {
                codedOutputStream.writeMessage(2, getQ());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.p_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getP()) : 0;
            if (this.q_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getQ());
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
            if (!(obj instanceof Pose6DOF)) {
                return super.equals(obj);
            }
            Pose6DOF pose6DOF = (Pose6DOF) obj;
            boolean z = hasP() == pose6DOF.hasP();
            if (hasP()) {
                z = z && getP().equals(pose6DOF.getP());
            }
            boolean z2 = z && hasQ() == pose6DOF.hasQ();
            if (hasQ()) {
                z2 = z2 && getQ().equals(pose6DOF.getQ());
            }
            return z2 && this.unknownFields.equals(pose6DOF.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasP()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getP().hashCode();
            }
            if (hasQ()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getQ().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Pose6DOF parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Pose6DOF parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Pose6DOF parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Pose6DOF parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Pose6DOF parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Pose6DOF parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Pose6DOF parseFrom(InputStream inputStream) throws IOException {
            return (Pose6DOF) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Pose6DOF parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Pose6DOF) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Pose6DOF parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Pose6DOF) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Pose6DOF parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Pose6DOF) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Pose6DOF parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Pose6DOF) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Pose6DOF parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Pose6DOF) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Pose6DOF pose6DOF) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(pose6DOF);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Pose6DOFOrBuilder {
            private SingleFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> pBuilder_;
            private Vector3D p_;
            private SingleFieldBuilderV3<Quaternion, Quaternion.Builder, QuaternionOrBuilder> qBuilder_;
            private Quaternion q_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Pose6DOF_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Pose6DOF_fieldAccessorTable.ensureFieldAccessorsInitialized(Pose6DOF.class, Builder.class);
            }

            private Builder() {
                this.p_ = null;
                this.q_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.p_ = null;
                this.q_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Pose6DOF.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.pBuilder_ == null) {
                    this.p_ = null;
                } else {
                    this.p_ = null;
                    this.pBuilder_ = null;
                }
                if (this.qBuilder_ == null) {
                    this.q_ = null;
                } else {
                    this.q_ = null;
                    this.qBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Pose6DOF_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Pose6DOF getDefaultInstanceForType() {
                return Pose6DOF.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Pose6DOF build() {
                Pose6DOF buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Pose6DOF buildPartial() {
                Pose6DOF pose6DOF = new Pose6DOF(this);
                SingleFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> singleFieldBuilderV3 = this.pBuilder_;
                if (singleFieldBuilderV3 == null) {
                    pose6DOF.p_ = this.p_;
                } else {
                    pose6DOF.p_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Quaternion, Quaternion.Builder, QuaternionOrBuilder> singleFieldBuilderV32 = this.qBuilder_;
                if (singleFieldBuilderV32 == null) {
                    pose6DOF.q_ = this.q_;
                } else {
                    pose6DOF.q_ = singleFieldBuilderV32.build();
                }
                onBuilt();
                return pose6DOF;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Pose6DOF) {
                    return mergeFrom((Pose6DOF) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Pose6DOF pose6DOF) {
                if (pose6DOF == Pose6DOF.getDefaultInstance()) {
                    return this;
                }
                if (pose6DOF.hasP()) {
                    mergeP(pose6DOF.getP());
                }
                if (pose6DOF.hasQ()) {
                    mergeQ(pose6DOF.getQ());
                }
                mergeUnknownFields(pose6DOF.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Pose6DOF.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Pose6DOF.access$9900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Pose6DOF r3 = (xpilot.sr.proto.Primitives.Pose6DOF) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Pose6DOF r4 = (xpilot.sr.proto.Primitives.Pose6DOF) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Pose6DOF.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Pose6DOF$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
            public boolean hasP() {
                return (this.pBuilder_ == null && this.p_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
            public Vector3D getP() {
                SingleFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> singleFieldBuilderV3 = this.pBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Vector3D vector3D = this.p_;
                    return vector3D == null ? Vector3D.getDefaultInstance() : vector3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setP(Vector3D vector3D) {
                SingleFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> singleFieldBuilderV3 = this.pBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    this.p_ = vector3D;
                    onChanged();
                }
                return this;
            }

            public Builder setP(Vector3D.Builder builder) {
                SingleFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> singleFieldBuilderV3 = this.pBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.p_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeP(Vector3D vector3D) {
                SingleFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> singleFieldBuilderV3 = this.pBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Vector3D vector3D2 = this.p_;
                    if (vector3D2 != null) {
                        this.p_ = Vector3D.newBuilder(vector3D2).mergeFrom(vector3D).buildPartial();
                    } else {
                        this.p_ = vector3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(vector3D);
                }
                return this;
            }

            public Builder clearP() {
                if (this.pBuilder_ == null) {
                    this.p_ = null;
                    onChanged();
                } else {
                    this.p_ = null;
                    this.pBuilder_ = null;
                }
                return this;
            }

            public Vector3D.Builder getPBuilder() {
                onChanged();
                return getPFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
            public Vector3DOrBuilder getPOrBuilder() {
                SingleFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> singleFieldBuilderV3 = this.pBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Vector3D vector3D = this.p_;
                return vector3D == null ? Vector3D.getDefaultInstance() : vector3D;
            }

            private SingleFieldBuilderV3<Vector3D, Vector3D.Builder, Vector3DOrBuilder> getPFieldBuilder() {
                if (this.pBuilder_ == null) {
                    this.pBuilder_ = new SingleFieldBuilderV3<>(getP(), getParentForChildren(), isClean());
                    this.p_ = null;
                }
                return this.pBuilder_;
            }

            @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
            public boolean hasQ() {
                return (this.qBuilder_ == null && this.q_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
            public Quaternion getQ() {
                SingleFieldBuilderV3<Quaternion, Quaternion.Builder, QuaternionOrBuilder> singleFieldBuilderV3 = this.qBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Quaternion quaternion = this.q_;
                    return quaternion == null ? Quaternion.getDefaultInstance() : quaternion;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setQ(Quaternion quaternion) {
                SingleFieldBuilderV3<Quaternion, Quaternion.Builder, QuaternionOrBuilder> singleFieldBuilderV3 = this.qBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(quaternion);
                } else if (quaternion == null) {
                    throw new NullPointerException();
                } else {
                    this.q_ = quaternion;
                    onChanged();
                }
                return this;
            }

            public Builder setQ(Quaternion.Builder builder) {
                SingleFieldBuilderV3<Quaternion, Quaternion.Builder, QuaternionOrBuilder> singleFieldBuilderV3 = this.qBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.q_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeQ(Quaternion quaternion) {
                SingleFieldBuilderV3<Quaternion, Quaternion.Builder, QuaternionOrBuilder> singleFieldBuilderV3 = this.qBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Quaternion quaternion2 = this.q_;
                    if (quaternion2 != null) {
                        this.q_ = Quaternion.newBuilder(quaternion2).mergeFrom(quaternion).buildPartial();
                    } else {
                        this.q_ = quaternion;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(quaternion);
                }
                return this;
            }

            public Builder clearQ() {
                if (this.qBuilder_ == null) {
                    this.q_ = null;
                    onChanged();
                } else {
                    this.q_ = null;
                    this.qBuilder_ = null;
                }
                return this;
            }

            public Quaternion.Builder getQBuilder() {
                onChanged();
                return getQFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.Pose6DOFOrBuilder
            public QuaternionOrBuilder getQOrBuilder() {
                SingleFieldBuilderV3<Quaternion, Quaternion.Builder, QuaternionOrBuilder> singleFieldBuilderV3 = this.qBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Quaternion quaternion = this.q_;
                return quaternion == null ? Quaternion.getDefaultInstance() : quaternion;
            }

            private SingleFieldBuilderV3<Quaternion, Quaternion.Builder, QuaternionOrBuilder> getQFieldBuilder() {
                if (this.qBuilder_ == null) {
                    this.qBuilder_ = new SingleFieldBuilderV3<>(getQ(), getParentForChildren(), isClean());
                    this.q_ = null;
                }
                return this.qBuilder_;
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

        public static Pose6DOF getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Pose6DOF> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Pose6DOF> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Pose6DOF getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class EgoMotion extends GeneratedMessageV3 implements EgoMotionOrBuilder {
        public static final int EGO_YAW_FIELD_NUMBER = 5;
        public static final int EGO_YAW_RATE_FIELD_NUMBER = 7;
        public static final int EGO_YAW_RATE_STD_FIELD_NUMBER = 8;
        public static final int EGO_YAW_STD_FIELD_NUMBER = 6;
        public static final int LOCAL_POSE_FIELD_NUMBER = 1;
        public static final int LOCAL_POSE_SIGMA_FIELD_NUMBER = 3;
        public static final int LOCAL_VELOCITY_FIELD_NUMBER = 2;
        public static final int LOCAL_VELOCITY_SIGMA_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private float egoYawRateStd_;
        private float egoYawRate_;
        private float egoYawStd_;
        private float egoYaw_;
        private int localPoseMemoizedSerializedSize;
        private int localPoseSigmaMemoizedSerializedSize;
        private List<Float> localPoseSigma_;
        private List<Float> localPose_;
        private int localVelocityMemoizedSerializedSize;
        private int localVelocitySigmaMemoizedSerializedSize;
        private List<Float> localVelocitySigma_;
        private List<Float> localVelocity_;
        private byte memoizedIsInitialized;
        private static final EgoMotion DEFAULT_INSTANCE = new EgoMotion();
        private static final Parser<EgoMotion> PARSER = new AbstractParser<EgoMotion>() { // from class: xpilot.sr.proto.Primitives.EgoMotion.1
            @Override // com.google.protobuf.Parser
            public EgoMotion parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EgoMotion(codedInputStream, extensionRegistryLite);
            }
        };

        private EgoMotion(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.localPoseMemoizedSerializedSize = -1;
            this.localVelocityMemoizedSerializedSize = -1;
            this.localPoseSigmaMemoizedSerializedSize = -1;
            this.localVelocitySigmaMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private EgoMotion() {
            this.localPoseMemoizedSerializedSize = -1;
            this.localVelocityMemoizedSerializedSize = -1;
            this.localPoseSigmaMemoizedSerializedSize = -1;
            this.localVelocitySigmaMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.localPose_ = Collections.emptyList();
            this.localVelocity_ = Collections.emptyList();
            this.localPoseSigma_ = Collections.emptyList();
            this.localVelocitySigma_ = Collections.emptyList();
            this.egoYaw_ = 0.0f;
            this.egoYawStd_ = 0.0f;
            this.egoYawRate_ = 0.0f;
            this.egoYawRateStd_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
        private EgoMotion(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r3 = 8;
                if (z) {
                    return;
                }
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localPose_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localPose_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit);
                                continue;
                                break;
                            case 13:
                                if (!(z2 & true)) {
                                    this.localPose_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localPose_.add(Float.valueOf(codedInputStream.readFloat()));
                                continue;
                            case 18:
                                int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localVelocity_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localVelocity_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit2);
                                continue;
                                break;
                            case 21:
                                if (!(z2 & true)) {
                                    this.localVelocity_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localVelocity_.add(Float.valueOf(codedInputStream.readFloat()));
                                continue;
                            case 26:
                                int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localPoseSigma_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localPoseSigma_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit3);
                                continue;
                                break;
                            case 29:
                                if (!(z2 & true)) {
                                    this.localPoseSigma_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localPoseSigma_.add(Float.valueOf(codedInputStream.readFloat()));
                                continue;
                            case 34:
                                int pushLimit4 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localVelocitySigma_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localVelocitySigma_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit4);
                                continue;
                                break;
                            case 37:
                                if (!(z2 & true)) {
                                    this.localVelocitySigma_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localVelocitySigma_.add(Float.valueOf(codedInputStream.readFloat()));
                                continue;
                            case 45:
                                this.egoYaw_ = codedInputStream.readFloat();
                                continue;
                            case 53:
                                this.egoYawStd_ = codedInputStream.readFloat();
                                continue;
                            case 61:
                                this.egoYawRate_ = codedInputStream.readFloat();
                                continue;
                            case 69:
                                this.egoYawRateStd_ = codedInputStream.readFloat();
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
                        this.localPose_ = Collections.unmodifiableList(this.localPose_);
                    }
                    if (z2 & true) {
                        this.localVelocity_ = Collections.unmodifiableList(this.localVelocity_);
                    }
                    if (z2 & true) {
                        this.localPoseSigma_ = Collections.unmodifiableList(this.localPoseSigma_);
                    }
                    if ((z2 & true) == r3) {
                        this.localVelocitySigma_ = Collections.unmodifiableList(this.localVelocitySigma_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Primitives.internal_static_xpilot_sr_proto_EgoMotion_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_EgoMotion_fieldAccessorTable.ensureFieldAccessorsInitialized(EgoMotion.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public List<Float> getLocalPoseList() {
            return this.localPose_;
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public int getLocalPoseCount() {
            return this.localPose_.size();
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public float getLocalPose(int i) {
            return this.localPose_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public List<Float> getLocalVelocityList() {
            return this.localVelocity_;
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public int getLocalVelocityCount() {
            return this.localVelocity_.size();
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public float getLocalVelocity(int i) {
            return this.localVelocity_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public List<Float> getLocalPoseSigmaList() {
            return this.localPoseSigma_;
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public int getLocalPoseSigmaCount() {
            return this.localPoseSigma_.size();
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public float getLocalPoseSigma(int i) {
            return this.localPoseSigma_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public List<Float> getLocalVelocitySigmaList() {
            return this.localVelocitySigma_;
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public int getLocalVelocitySigmaCount() {
            return this.localVelocitySigma_.size();
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public float getLocalVelocitySigma(int i) {
            return this.localVelocitySigma_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public float getEgoYaw() {
            return this.egoYaw_;
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public float getEgoYawStd() {
            return this.egoYawStd_;
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public float getEgoYawRate() {
            return this.egoYawRate_;
        }

        @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
        public float getEgoYawRateStd() {
            return this.egoYawRateStd_;
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
            if (getLocalPoseList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(10);
                codedOutputStream.writeUInt32NoTag(this.localPoseMemoizedSerializedSize);
            }
            for (int i = 0; i < this.localPose_.size(); i++) {
                codedOutputStream.writeFloatNoTag(this.localPose_.get(i).floatValue());
            }
            if (getLocalVelocityList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(18);
                codedOutputStream.writeUInt32NoTag(this.localVelocityMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.localVelocity_.size(); i2++) {
                codedOutputStream.writeFloatNoTag(this.localVelocity_.get(i2).floatValue());
            }
            if (getLocalPoseSigmaList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(26);
                codedOutputStream.writeUInt32NoTag(this.localPoseSigmaMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.localPoseSigma_.size(); i3++) {
                codedOutputStream.writeFloatNoTag(this.localPoseSigma_.get(i3).floatValue());
            }
            if (getLocalVelocitySigmaList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(34);
                codedOutputStream.writeUInt32NoTag(this.localVelocitySigmaMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.localVelocitySigma_.size(); i4++) {
                codedOutputStream.writeFloatNoTag(this.localVelocitySigma_.get(i4).floatValue());
            }
            float f = this.egoYaw_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(5, f);
            }
            float f2 = this.egoYawStd_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(6, f2);
            }
            float f3 = this.egoYawRate_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(7, f3);
            }
            float f4 = this.egoYawRateStd_;
            if (f4 != 0.0f) {
                codedOutputStream.writeFloat(8, f4);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int size = getLocalPoseList().size() * 4;
            int i2 = size + 0;
            if (!getLocalPoseList().isEmpty()) {
                i2 = i2 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.localPoseMemoizedSerializedSize = size;
            int size2 = getLocalVelocityList().size() * 4;
            int i3 = i2 + size2;
            if (!getLocalVelocityList().isEmpty()) {
                i3 = i3 + 1 + CodedOutputStream.computeInt32SizeNoTag(size2);
            }
            this.localVelocityMemoizedSerializedSize = size2;
            int size3 = getLocalPoseSigmaList().size() * 4;
            int i4 = i3 + size3;
            if (!getLocalPoseSigmaList().isEmpty()) {
                i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(size3);
            }
            this.localPoseSigmaMemoizedSerializedSize = size3;
            int size4 = getLocalVelocitySigmaList().size() * 4;
            int i5 = i4 + size4;
            if (!getLocalVelocitySigmaList().isEmpty()) {
                i5 = i5 + 1 + CodedOutputStream.computeInt32SizeNoTag(size4);
            }
            this.localVelocitySigmaMemoizedSerializedSize = size4;
            float f = this.egoYaw_;
            if (f != 0.0f) {
                i5 += CodedOutputStream.computeFloatSize(5, f);
            }
            float f2 = this.egoYawStd_;
            if (f2 != 0.0f) {
                i5 += CodedOutputStream.computeFloatSize(6, f2);
            }
            float f3 = this.egoYawRate_;
            if (f3 != 0.0f) {
                i5 += CodedOutputStream.computeFloatSize(7, f3);
            }
            float f4 = this.egoYawRateStd_;
            if (f4 != 0.0f) {
                i5 += CodedOutputStream.computeFloatSize(8, f4);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EgoMotion)) {
                return super.equals(obj);
            }
            EgoMotion egoMotion = (EgoMotion) obj;
            return ((((((((getLocalPoseList().equals(egoMotion.getLocalPoseList())) && getLocalVelocityList().equals(egoMotion.getLocalVelocityList())) && getLocalPoseSigmaList().equals(egoMotion.getLocalPoseSigmaList())) && getLocalVelocitySigmaList().equals(egoMotion.getLocalVelocitySigmaList())) && Float.floatToIntBits(getEgoYaw()) == Float.floatToIntBits(egoMotion.getEgoYaw())) && Float.floatToIntBits(getEgoYawStd()) == Float.floatToIntBits(egoMotion.getEgoYawStd())) && Float.floatToIntBits(getEgoYawRate()) == Float.floatToIntBits(egoMotion.getEgoYawRate())) && Float.floatToIntBits(getEgoYawRateStd()) == Float.floatToIntBits(egoMotion.getEgoYawRateStd())) && this.unknownFields.equals(egoMotion.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getLocalPoseCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getLocalPoseList().hashCode();
            }
            if (getLocalVelocityCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getLocalVelocityList().hashCode();
            }
            if (getLocalPoseSigmaCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getLocalPoseSigmaList().hashCode();
            }
            if (getLocalVelocitySigmaCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getLocalVelocitySigmaList().hashCode();
            }
            int floatToIntBits = (((((((((((((((((hashCode * 37) + 5) * 53) + Float.floatToIntBits(getEgoYaw())) * 37) + 6) * 53) + Float.floatToIntBits(getEgoYawStd())) * 37) + 7) * 53) + Float.floatToIntBits(getEgoYawRate())) * 37) + 8) * 53) + Float.floatToIntBits(getEgoYawRateStd())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = floatToIntBits;
            return floatToIntBits;
        }

        public static EgoMotion parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static EgoMotion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static EgoMotion parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static EgoMotion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static EgoMotion parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static EgoMotion parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static EgoMotion parseFrom(InputStream inputStream) throws IOException {
            return (EgoMotion) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static EgoMotion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EgoMotion) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static EgoMotion parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EgoMotion) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EgoMotion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EgoMotion) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static EgoMotion parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EgoMotion) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static EgoMotion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EgoMotion) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EgoMotion egoMotion) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(egoMotion);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EgoMotionOrBuilder {
            private int bitField0_;
            private float egoYawRateStd_;
            private float egoYawRate_;
            private float egoYawStd_;
            private float egoYaw_;
            private List<Float> localPoseSigma_;
            private List<Float> localPose_;
            private List<Float> localVelocitySigma_;
            private List<Float> localVelocity_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_EgoMotion_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_EgoMotion_fieldAccessorTable.ensureFieldAccessorsInitialized(EgoMotion.class, Builder.class);
            }

            private Builder() {
                this.localPose_ = Collections.emptyList();
                this.localVelocity_ = Collections.emptyList();
                this.localPoseSigma_ = Collections.emptyList();
                this.localVelocitySigma_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.localPose_ = Collections.emptyList();
                this.localVelocity_ = Collections.emptyList();
                this.localPoseSigma_ = Collections.emptyList();
                this.localVelocitySigma_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = EgoMotion.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.localPose_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.localVelocity_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.localPoseSigma_ = Collections.emptyList();
                this.bitField0_ &= -5;
                this.localVelocitySigma_ = Collections.emptyList();
                this.bitField0_ &= -9;
                this.egoYaw_ = 0.0f;
                this.egoYawStd_ = 0.0f;
                this.egoYawRate_ = 0.0f;
                this.egoYawRateStd_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_EgoMotion_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EgoMotion getDefaultInstanceForType() {
                return EgoMotion.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EgoMotion build() {
                EgoMotion buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EgoMotion buildPartial() {
                EgoMotion egoMotion = new EgoMotion(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.localPose_ = Collections.unmodifiableList(this.localPose_);
                    this.bitField0_ &= -2;
                }
                egoMotion.localPose_ = this.localPose_;
                if ((this.bitField0_ & 2) == 2) {
                    this.localVelocity_ = Collections.unmodifiableList(this.localVelocity_);
                    this.bitField0_ &= -3;
                }
                egoMotion.localVelocity_ = this.localVelocity_;
                if ((this.bitField0_ & 4) == 4) {
                    this.localPoseSigma_ = Collections.unmodifiableList(this.localPoseSigma_);
                    this.bitField0_ &= -5;
                }
                egoMotion.localPoseSigma_ = this.localPoseSigma_;
                if ((this.bitField0_ & 8) == 8) {
                    this.localVelocitySigma_ = Collections.unmodifiableList(this.localVelocitySigma_);
                    this.bitField0_ &= -9;
                }
                egoMotion.localVelocitySigma_ = this.localVelocitySigma_;
                egoMotion.egoYaw_ = this.egoYaw_;
                egoMotion.egoYawStd_ = this.egoYawStd_;
                egoMotion.egoYawRate_ = this.egoYawRate_;
                egoMotion.egoYawRateStd_ = this.egoYawRateStd_;
                egoMotion.bitField0_ = 0;
                onBuilt();
                return egoMotion;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof EgoMotion) {
                    return mergeFrom((EgoMotion) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(EgoMotion egoMotion) {
                if (egoMotion == EgoMotion.getDefaultInstance()) {
                    return this;
                }
                if (!egoMotion.localPose_.isEmpty()) {
                    if (this.localPose_.isEmpty()) {
                        this.localPose_ = egoMotion.localPose_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLocalPoseIsMutable();
                        this.localPose_.addAll(egoMotion.localPose_);
                    }
                    onChanged();
                }
                if (!egoMotion.localVelocity_.isEmpty()) {
                    if (this.localVelocity_.isEmpty()) {
                        this.localVelocity_ = egoMotion.localVelocity_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureLocalVelocityIsMutable();
                        this.localVelocity_.addAll(egoMotion.localVelocity_);
                    }
                    onChanged();
                }
                if (!egoMotion.localPoseSigma_.isEmpty()) {
                    if (this.localPoseSigma_.isEmpty()) {
                        this.localPoseSigma_ = egoMotion.localPoseSigma_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureLocalPoseSigmaIsMutable();
                        this.localPoseSigma_.addAll(egoMotion.localPoseSigma_);
                    }
                    onChanged();
                }
                if (!egoMotion.localVelocitySigma_.isEmpty()) {
                    if (this.localVelocitySigma_.isEmpty()) {
                        this.localVelocitySigma_ = egoMotion.localVelocitySigma_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureLocalVelocitySigmaIsMutable();
                        this.localVelocitySigma_.addAll(egoMotion.localVelocitySigma_);
                    }
                    onChanged();
                }
                if (egoMotion.getEgoYaw() != 0.0f) {
                    setEgoYaw(egoMotion.getEgoYaw());
                }
                if (egoMotion.getEgoYawStd() != 0.0f) {
                    setEgoYawStd(egoMotion.getEgoYawStd());
                }
                if (egoMotion.getEgoYawRate() != 0.0f) {
                    setEgoYawRate(egoMotion.getEgoYawRate());
                }
                if (egoMotion.getEgoYawRateStd() != 0.0f) {
                    setEgoYawRateStd(egoMotion.getEgoYawRateStd());
                }
                mergeUnknownFields(egoMotion.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.EgoMotion.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.EgoMotion.access$11700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$EgoMotion r3 = (xpilot.sr.proto.Primitives.EgoMotion) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$EgoMotion r4 = (xpilot.sr.proto.Primitives.EgoMotion) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.EgoMotion.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$EgoMotion$Builder");
            }

            private void ensureLocalPoseIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.localPose_ = new ArrayList(this.localPose_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public List<Float> getLocalPoseList() {
                return Collections.unmodifiableList(this.localPose_);
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public int getLocalPoseCount() {
                return this.localPose_.size();
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public float getLocalPose(int i) {
                return this.localPose_.get(i).floatValue();
            }

            public Builder setLocalPose(int i, float f) {
                ensureLocalPoseIsMutable();
                this.localPose_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addLocalPose(float f) {
                ensureLocalPoseIsMutable();
                this.localPose_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addAllLocalPose(Iterable<? extends Float> iterable) {
                ensureLocalPoseIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.localPose_);
                onChanged();
                return this;
            }

            public Builder clearLocalPose() {
                this.localPose_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureLocalVelocityIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.localVelocity_ = new ArrayList(this.localVelocity_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public List<Float> getLocalVelocityList() {
                return Collections.unmodifiableList(this.localVelocity_);
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public int getLocalVelocityCount() {
                return this.localVelocity_.size();
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public float getLocalVelocity(int i) {
                return this.localVelocity_.get(i).floatValue();
            }

            public Builder setLocalVelocity(int i, float f) {
                ensureLocalVelocityIsMutable();
                this.localVelocity_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addLocalVelocity(float f) {
                ensureLocalVelocityIsMutable();
                this.localVelocity_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addAllLocalVelocity(Iterable<? extends Float> iterable) {
                ensureLocalVelocityIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.localVelocity_);
                onChanged();
                return this;
            }

            public Builder clearLocalVelocity() {
                this.localVelocity_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureLocalPoseSigmaIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.localPoseSigma_ = new ArrayList(this.localPoseSigma_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public List<Float> getLocalPoseSigmaList() {
                return Collections.unmodifiableList(this.localPoseSigma_);
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public int getLocalPoseSigmaCount() {
                return this.localPoseSigma_.size();
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public float getLocalPoseSigma(int i) {
                return this.localPoseSigma_.get(i).floatValue();
            }

            public Builder setLocalPoseSigma(int i, float f) {
                ensureLocalPoseSigmaIsMutable();
                this.localPoseSigma_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addLocalPoseSigma(float f) {
                ensureLocalPoseSigmaIsMutable();
                this.localPoseSigma_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addAllLocalPoseSigma(Iterable<? extends Float> iterable) {
                ensureLocalPoseSigmaIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.localPoseSigma_);
                onChanged();
                return this;
            }

            public Builder clearLocalPoseSigma() {
                this.localPoseSigma_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureLocalVelocitySigmaIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.localVelocitySigma_ = new ArrayList(this.localVelocitySigma_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public List<Float> getLocalVelocitySigmaList() {
                return Collections.unmodifiableList(this.localVelocitySigma_);
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public int getLocalVelocitySigmaCount() {
                return this.localVelocitySigma_.size();
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public float getLocalVelocitySigma(int i) {
                return this.localVelocitySigma_.get(i).floatValue();
            }

            public Builder setLocalVelocitySigma(int i, float f) {
                ensureLocalVelocitySigmaIsMutable();
                this.localVelocitySigma_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addLocalVelocitySigma(float f) {
                ensureLocalVelocitySigmaIsMutable();
                this.localVelocitySigma_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addAllLocalVelocitySigma(Iterable<? extends Float> iterable) {
                ensureLocalVelocitySigmaIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.localVelocitySigma_);
                onChanged();
                return this;
            }

            public Builder clearLocalVelocitySigma() {
                this.localVelocitySigma_ = Collections.emptyList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public float getEgoYaw() {
                return this.egoYaw_;
            }

            public Builder setEgoYaw(float f) {
                this.egoYaw_ = f;
                onChanged();
                return this;
            }

            public Builder clearEgoYaw() {
                this.egoYaw_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public float getEgoYawStd() {
                return this.egoYawStd_;
            }

            public Builder setEgoYawStd(float f) {
                this.egoYawStd_ = f;
                onChanged();
                return this;
            }

            public Builder clearEgoYawStd() {
                this.egoYawStd_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public float getEgoYawRate() {
                return this.egoYawRate_;
            }

            public Builder setEgoYawRate(float f) {
                this.egoYawRate_ = f;
                onChanged();
                return this;
            }

            public Builder clearEgoYawRate() {
                this.egoYawRate_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.EgoMotionOrBuilder
            public float getEgoYawRateStd() {
                return this.egoYawRateStd_;
            }

            public Builder setEgoYawRateStd(float f) {
                this.egoYawRateStd_ = f;
                onChanged();
                return this;
            }

            public Builder clearEgoYawRateStd() {
                this.egoYawRateStd_ = 0.0f;
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

        public static EgoMotion getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EgoMotion> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EgoMotion> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EgoMotion getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Trajectory extends GeneratedMessageV3 implements TrajectoryOrBuilder {
        private static final Trajectory DEFAULT_INSTANCE = new Trajectory();
        private static final Parser<Trajectory> PARSER = new AbstractParser<Trajectory>() { // from class: xpilot.sr.proto.Primitives.Trajectory.1
            @Override // com.google.protobuf.Parser
            public Trajectory parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Trajectory(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        public static final int Z_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private float x_;
        private float y_;
        private float z_;

        private Trajectory(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Trajectory() {
            this.memoizedIsInitialized = (byte) -1;
            this.x_ = 0.0f;
            this.y_ = 0.0f;
            this.z_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Trajectory(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.x_ = codedInputStream.readFloat();
                            } else if (readTag == 21) {
                                this.y_ = codedInputStream.readFloat();
                            } else if (readTag == 29) {
                                this.z_ = codedInputStream.readFloat();
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
            return Primitives.internal_static_xpilot_sr_proto_Trajectory_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Trajectory_fieldAccessorTable.ensureFieldAccessorsInitialized(Trajectory.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.TrajectoryOrBuilder
        public float getX() {
            return this.x_;
        }

        @Override // xpilot.sr.proto.Primitives.TrajectoryOrBuilder
        public float getY() {
            return this.y_;
        }

        @Override // xpilot.sr.proto.Primitives.TrajectoryOrBuilder
        public float getZ() {
            return this.z_;
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
            float f = this.x_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.y_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(2, f2);
            }
            float f3 = this.z_;
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
            float f = this.x_;
            int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
            float f2 = this.y_;
            if (f2 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(2, f2);
            }
            float f3 = this.z_;
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
            if (!(obj instanceof Trajectory)) {
                return super.equals(obj);
            }
            Trajectory trajectory = (Trajectory) obj;
            return (((Float.floatToIntBits(getX()) == Float.floatToIntBits(trajectory.getX())) && Float.floatToIntBits(getY()) == Float.floatToIntBits(trajectory.getY())) && Float.floatToIntBits(getZ()) == Float.floatToIntBits(trajectory.getZ())) && this.unknownFields.equals(trajectory.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getX())) * 37) + 2) * 53) + Float.floatToIntBits(getY())) * 37) + 3) * 53) + Float.floatToIntBits(getZ())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static Trajectory parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Trajectory parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Trajectory parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Trajectory parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Trajectory parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Trajectory parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Trajectory parseFrom(InputStream inputStream) throws IOException {
            return (Trajectory) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Trajectory parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Trajectory) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Trajectory parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Trajectory) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Trajectory parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Trajectory) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Trajectory parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Trajectory) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Trajectory parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Trajectory) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Trajectory trajectory) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(trajectory);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TrajectoryOrBuilder {
            private float x_;
            private float y_;
            private float z_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Trajectory_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Trajectory_fieldAccessorTable.ensureFieldAccessorsInitialized(Trajectory.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Trajectory.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.x_ = 0.0f;
                this.y_ = 0.0f;
                this.z_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Trajectory_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Trajectory getDefaultInstanceForType() {
                return Trajectory.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Trajectory build() {
                Trajectory buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Trajectory buildPartial() {
                Trajectory trajectory = new Trajectory(this);
                trajectory.x_ = this.x_;
                trajectory.y_ = this.y_;
                trajectory.z_ = this.z_;
                onBuilt();
                return trajectory;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Trajectory) {
                    return mergeFrom((Trajectory) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Trajectory trajectory) {
                if (trajectory == Trajectory.getDefaultInstance()) {
                    return this;
                }
                if (trajectory.getX() != 0.0f) {
                    setX(trajectory.getX());
                }
                if (trajectory.getY() != 0.0f) {
                    setY(trajectory.getY());
                }
                if (trajectory.getZ() != 0.0f) {
                    setZ(trajectory.getZ());
                }
                mergeUnknownFields(trajectory.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Trajectory.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Trajectory.access$12900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Trajectory r3 = (xpilot.sr.proto.Primitives.Trajectory) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Trajectory r4 = (xpilot.sr.proto.Primitives.Trajectory) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Trajectory.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Trajectory$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.TrajectoryOrBuilder
            public float getX() {
                return this.x_;
            }

            public Builder setX(float f) {
                this.x_ = f;
                onChanged();
                return this;
            }

            public Builder clearX() {
                this.x_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.TrajectoryOrBuilder
            public float getY() {
                return this.y_;
            }

            public Builder setY(float f) {
                this.y_ = f;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.y_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.TrajectoryOrBuilder
            public float getZ() {
                return this.z_;
            }

            public Builder setZ(float f) {
                this.z_ = f;
                onChanged();
                return this;
            }

            public Builder clearZ() {
                this.z_ = 0.0f;
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

        public static Trajectory getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Trajectory> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Trajectory> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Trajectory getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class MotionPlanning extends GeneratedMessageV3 implements MotionPlanningOrBuilder {
        private static final MotionPlanning DEFAULT_INSTANCE = new MotionPlanning();
        private static final Parser<MotionPlanning> PARSER = new AbstractParser<MotionPlanning>() { // from class: xpilot.sr.proto.Primitives.MotionPlanning.1
            @Override // com.google.protobuf.Parser
            public MotionPlanning parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MotionPlanning(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SPARE_FIELD_NUMBER = 2;
        public static final int TRAJECT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private List<Trajectory> traject_;

        private MotionPlanning(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private MotionPlanning() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.traject_ = Collections.emptyList();
            this.spare_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private MotionPlanning(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.traject_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.traject_.add(codedInputStream.readMessage(Trajectory.parser(), extensionRegistryLite));
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
                        this.traject_ = Collections.unmodifiableList(this.traject_);
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
            return Primitives.internal_static_xpilot_sr_proto_MotionPlanning_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_MotionPlanning_fieldAccessorTable.ensureFieldAccessorsInitialized(MotionPlanning.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
        public List<Trajectory> getTrajectList() {
            return this.traject_;
        }

        @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
        public List<? extends TrajectoryOrBuilder> getTrajectOrBuilderList() {
            return this.traject_;
        }

        @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
        public int getTrajectCount() {
            return this.traject_.size();
        }

        @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
        public Trajectory getTraject(int i) {
            return this.traject_.get(i);
        }

        @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
        public TrajectoryOrBuilder getTrajectOrBuilder(int i) {
            return this.traject_.get(i);
        }

        @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
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
            for (int i = 0; i < this.traject_.size(); i++) {
                codedOutputStream.writeMessage(1, this.traject_.get(i));
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
            for (int i3 = 0; i3 < this.traject_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.traject_.get(i3));
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
            if (!(obj instanceof MotionPlanning)) {
                return super.equals(obj);
            }
            MotionPlanning motionPlanning = (MotionPlanning) obj;
            return ((getTrajectList().equals(motionPlanning.getTrajectList())) && getSpareList().equals(motionPlanning.getSpareList())) && this.unknownFields.equals(motionPlanning.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getTrajectCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getTrajectList().hashCode();
            }
            if (getSpareCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getSpareList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static MotionPlanning parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static MotionPlanning parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MotionPlanning parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MotionPlanning parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MotionPlanning parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MotionPlanning parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MotionPlanning parseFrom(InputStream inputStream) throws IOException {
            return (MotionPlanning) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MotionPlanning parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MotionPlanning) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MotionPlanning parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MotionPlanning) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MotionPlanning parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MotionPlanning) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MotionPlanning parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MotionPlanning) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MotionPlanning parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MotionPlanning) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MotionPlanning motionPlanning) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(motionPlanning);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MotionPlanningOrBuilder {
            private int bitField0_;
            private List<Float> spare_;
            private RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> trajectBuilder_;
            private List<Trajectory> traject_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_MotionPlanning_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_MotionPlanning_fieldAccessorTable.ensureFieldAccessorsInitialized(MotionPlanning.class, Builder.class);
            }

            private Builder() {
                this.traject_ = Collections.emptyList();
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.traject_ = Collections.emptyList();
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MotionPlanning.alwaysUseFieldBuilders) {
                    getTrajectFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.traject_ = Collections.emptyList();
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
                return Primitives.internal_static_xpilot_sr_proto_MotionPlanning_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MotionPlanning getDefaultInstanceForType() {
                return MotionPlanning.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MotionPlanning build() {
                MotionPlanning buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MotionPlanning buildPartial() {
                MotionPlanning motionPlanning = new MotionPlanning(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.traject_ = Collections.unmodifiableList(this.traject_);
                        this.bitField0_ &= -2;
                    }
                    motionPlanning.traject_ = this.traject_;
                } else {
                    motionPlanning.traject_ = repeatedFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 2) == 2) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField0_ &= -3;
                }
                motionPlanning.spare_ = this.spare_;
                onBuilt();
                return motionPlanning;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof MotionPlanning) {
                    return mergeFrom((MotionPlanning) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(MotionPlanning motionPlanning) {
                if (motionPlanning == MotionPlanning.getDefaultInstance()) {
                    return this;
                }
                if (this.trajectBuilder_ == null) {
                    if (!motionPlanning.traject_.isEmpty()) {
                        if (this.traject_.isEmpty()) {
                            this.traject_ = motionPlanning.traject_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTrajectIsMutable();
                            this.traject_.addAll(motionPlanning.traject_);
                        }
                        onChanged();
                    }
                } else if (!motionPlanning.traject_.isEmpty()) {
                    if (!this.trajectBuilder_.isEmpty()) {
                        this.trajectBuilder_.addAllMessages(motionPlanning.traject_);
                    } else {
                        this.trajectBuilder_.dispose();
                        this.trajectBuilder_ = null;
                        this.traject_ = motionPlanning.traject_;
                        this.bitField0_ &= -2;
                        this.trajectBuilder_ = MotionPlanning.alwaysUseFieldBuilders ? getTrajectFieldBuilder() : null;
                    }
                }
                if (!motionPlanning.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = motionPlanning.spare_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(motionPlanning.spare_);
                    }
                    onChanged();
                }
                mergeUnknownFields(motionPlanning.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.MotionPlanning.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.MotionPlanning.access$14100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$MotionPlanning r3 = (xpilot.sr.proto.Primitives.MotionPlanning) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$MotionPlanning r4 = (xpilot.sr.proto.Primitives.MotionPlanning) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.MotionPlanning.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$MotionPlanning$Builder");
            }

            private void ensureTrajectIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.traject_ = new ArrayList(this.traject_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
            public List<Trajectory> getTrajectList() {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.traject_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
            public int getTrajectCount() {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.traject_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
            public Trajectory getTraject(int i) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.traject_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setTraject(int i, Trajectory trajectory) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, trajectory);
                } else if (trajectory == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrajectIsMutable();
                    this.traject_.set(i, trajectory);
                    onChanged();
                }
                return this;
            }

            public Builder setTraject(int i, Trajectory.Builder builder) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectIsMutable();
                    this.traject_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addTraject(Trajectory trajectory) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(trajectory);
                } else if (trajectory == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrajectIsMutable();
                    this.traject_.add(trajectory);
                    onChanged();
                }
                return this;
            }

            public Builder addTraject(int i, Trajectory trajectory) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, trajectory);
                } else if (trajectory == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrajectIsMutable();
                    this.traject_.add(i, trajectory);
                    onChanged();
                }
                return this;
            }

            public Builder addTraject(Trajectory.Builder builder) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectIsMutable();
                    this.traject_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addTraject(int i, Trajectory.Builder builder) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectIsMutable();
                    this.traject_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllTraject(Iterable<? extends Trajectory> iterable) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.traject_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearTraject() {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.traject_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeTraject(int i) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectIsMutable();
                    this.traject_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Trajectory.Builder getTrajectBuilder(int i) {
                return getTrajectFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
            public TrajectoryOrBuilder getTrajectOrBuilder(int i) {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.traject_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
            public List<? extends TrajectoryOrBuilder> getTrajectOrBuilderList() {
                RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> repeatedFieldBuilderV3 = this.trajectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.traject_);
            }

            public Trajectory.Builder addTrajectBuilder() {
                return getTrajectFieldBuilder().addBuilder(Trajectory.getDefaultInstance());
            }

            public Trajectory.Builder addTrajectBuilder(int i) {
                return getTrajectFieldBuilder().addBuilder(i, Trajectory.getDefaultInstance());
            }

            public List<Trajectory.Builder> getTrajectBuilderList() {
                return getTrajectFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Trajectory, Trajectory.Builder, TrajectoryOrBuilder> getTrajectFieldBuilder() {
                if (this.trajectBuilder_ == null) {
                    this.trajectBuilder_ = new RepeatedFieldBuilderV3<>(this.traject_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.traject_ = null;
                }
                return this.trajectBuilder_;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.Primitives.MotionPlanningOrBuilder
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

        public static MotionPlanning getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MotionPlanning> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MotionPlanning> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MotionPlanning getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class XPU_AssistSysSt_msg extends GeneratedMessageV3 implements XPU_AssistSysSt_msgOrBuilder {
        private static final XPU_AssistSysSt_msg DEFAULT_INSTANCE = new XPU_AssistSysSt_msg();
        private static final Parser<XPU_AssistSysSt_msg> PARSER = new AbstractParser<XPU_AssistSysSt_msg>() { // from class: xpilot.sr.proto.Primitives.XPU_AssistSysSt_msg.1
            @Override // com.google.protobuf.Parser
            public XPU_AssistSysSt_msg parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new XPU_AssistSysSt_msg(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int XPU_ACCST_FIELD_NUMBER = 8;
        public static final int XPU_ALCCTRLREMIND_FIELD_NUMBER = 30;
        public static final int XPU_ALCDIRECTION_FIELD_NUMBER = 27;
        public static final int XPU_ALCST_FIELD_NUMBER = 26;
        public static final int XPU_ALCST_PG_FIELD_NUMBER = 31;
        public static final int XPU_ALCTARLANEENDCENTERPOINTX_FIELD_NUMBER = 29;
        public static final int XPU_ALCTARLANEENDCENTERPOINTY_FIELD_NUMBER = 28;
        public static final int XPU_ASSISTSYSST_MSGSENDER_FIELD_NUMBER = 32;
        public static final int XPU_ATCST_FIELD_NUMBER = 15;
        public static final int XPU_CDU_ULCCONFIRMREQ_FIELD_NUMBER = 24;
        public static final int XPU_CDU_ULCSTATE_FIELD_NUMBER = 23;
        public static final int XPU_CDU_ULCWARNING_FIELD_NUMBER = 25;
        public static final int XPU_CIPST_FIELD_NUMBER = 10;
        public static final int XPU_CIP_WARNINGST_FIELD_NUMBER = 11;
        public static final int XPU_CRUISEOBJST_FIELD_NUMBER = 17;
        public static final int XPU_CRUISESPDSETDISP_FIELD_NUMBER = 14;
        public static final int XPU_DSMST_FIELD_NUMBER = 12;
        public static final int XPU_HWPST_FIELD_NUMBER = 7;
        public static final int XPU_ISLCST_FIELD_NUMBER = 18;
        public static final int XPU_LATCTRLREMIND2_FIELD_NUMBER = 4;
        public static final int XPU_LATCTRLREMIND_FIELD_NUMBER = 2;
        public static final int XPU_LATERALENDCTRLREASON_FIELD_NUMBER = 6;
        public static final int XPU_LCCST_FIELD_NUMBER = 13;
        public static final int XPU_LONGCTRLREMIND_FIELD_NUMBER = 3;
        public static final int XPU_LONGENDCTRLREASON_FIELD_NUMBER = 5;
        public static final int XPU_NGPST_FIELD_NUMBER = 9;
        public static final int XPU_TIMEGAPSETDISP_FIELD_NUMBER = 16;
        public static final int XPU_TSRSIGN1_FIELD_NUMBER = 20;
        public static final int XPU_TSRSIGN2_FIELD_NUMBER = 21;
        public static final int XPU_TSRSIGN3_FIELD_NUMBER = 22;
        public static final int XPU_TSRST_FIELD_NUMBER = 19;
        public static final int XPU_XPILOTST_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int xpuAccst_;
        private int xpuAlcctrlremind_;
        private int xpuAlcdirection_;
        private int xpuAlcstPg_;
        private int xpuAlcst_;
        private float xpuAlctarlaneendcenterpointx_;
        private float xpuAlctarlaneendcenterpointy_;
        private int xpuAssistsysstMsgsender_;
        private int xpuAtcst_;
        private int xpuCduUlcconfirmreq_;
        private int xpuCduUlcstate_;
        private int xpuCduUlcwarning_;
        private int xpuCipWarningst_;
        private int xpuCipst_;
        private boolean xpuCruiseobjst_;
        private float xpuCruisespdsetdisp_;
        private int xpuDsmst_;
        private int xpuHwpst_;
        private int xpuIslcst_;
        private int xpuLatctrlremind2_;
        private int xpuLatctrlremind_;
        private int xpuLateralendctrlreason_;
        private int xpuLccst_;
        private int xpuLongctrlremind_;
        private int xpuLongendctrlreason_;
        private int xpuNgpst_;
        private int xpuTimegapsetdisp_;
        private int xpuTsrsign1_;
        private int xpuTsrsign2_;
        private int xpuTsrsign3_;
        private int xpuTsrst_;
        private int xpuXpilotst_;

        private XPU_AssistSysSt_msg(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private XPU_AssistSysSt_msg() {
            this.memoizedIsInitialized = (byte) -1;
            this.xpuXpilotst_ = 0;
            this.xpuLatctrlremind_ = 0;
            this.xpuLongctrlremind_ = 0;
            this.xpuLatctrlremind2_ = 0;
            this.xpuLongendctrlreason_ = 0;
            this.xpuLateralendctrlreason_ = 0;
            this.xpuHwpst_ = 0;
            this.xpuAccst_ = 0;
            this.xpuNgpst_ = 0;
            this.xpuCipst_ = 0;
            this.xpuCipWarningst_ = 0;
            this.xpuDsmst_ = 0;
            this.xpuLccst_ = 0;
            this.xpuCruisespdsetdisp_ = 0.0f;
            this.xpuAtcst_ = 0;
            this.xpuTimegapsetdisp_ = 0;
            this.xpuCruiseobjst_ = false;
            this.xpuIslcst_ = 0;
            this.xpuTsrst_ = 0;
            this.xpuTsrsign1_ = 0;
            this.xpuTsrsign2_ = 0;
            this.xpuTsrsign3_ = 0;
            this.xpuCduUlcstate_ = 0;
            this.xpuCduUlcconfirmreq_ = 0;
            this.xpuCduUlcwarning_ = 0;
            this.xpuAlcst_ = 0;
            this.xpuAlcdirection_ = 0;
            this.xpuAlctarlaneendcenterpointy_ = 0.0f;
            this.xpuAlctarlaneendcenterpointx_ = 0.0f;
            this.xpuAlcctrlremind_ = 0;
            this.xpuAlcstPg_ = 0;
            this.xpuAssistsysstMsgsender_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private XPU_AssistSysSt_msg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.xpuXpilotst_ = codedInputStream.readInt32();
                                    continue;
                                case 16:
                                    this.xpuLatctrlremind_ = codedInputStream.readInt32();
                                    continue;
                                case 24:
                                    this.xpuLongctrlremind_ = codedInputStream.readInt32();
                                    continue;
                                case 32:
                                    this.xpuLatctrlremind2_ = codedInputStream.readInt32();
                                    continue;
                                case 40:
                                    this.xpuLongendctrlreason_ = codedInputStream.readInt32();
                                    continue;
                                case 48:
                                    this.xpuLateralendctrlreason_ = codedInputStream.readInt32();
                                    continue;
                                case 56:
                                    this.xpuHwpst_ = codedInputStream.readInt32();
                                    continue;
                                case 64:
                                    this.xpuAccst_ = codedInputStream.readInt32();
                                    continue;
                                case 72:
                                    this.xpuNgpst_ = codedInputStream.readInt32();
                                    continue;
                                case 80:
                                    this.xpuCipst_ = codedInputStream.readInt32();
                                    continue;
                                case 88:
                                    this.xpuCipWarningst_ = codedInputStream.readInt32();
                                    continue;
                                case 96:
                                    this.xpuDsmst_ = codedInputStream.readInt32();
                                    continue;
                                case 104:
                                    this.xpuLccst_ = codedInputStream.readInt32();
                                    continue;
                                case 117:
                                    this.xpuCruisespdsetdisp_ = codedInputStream.readFloat();
                                    continue;
                                case 120:
                                    this.xpuAtcst_ = codedInputStream.readInt32();
                                    continue;
                                case 128:
                                    this.xpuTimegapsetdisp_ = codedInputStream.readInt32();
                                    continue;
                                case 136:
                                    this.xpuCruiseobjst_ = codedInputStream.readBool();
                                    continue;
                                case 144:
                                    this.xpuIslcst_ = codedInputStream.readInt32();
                                    continue;
                                case 152:
                                    this.xpuTsrst_ = codedInputStream.readInt32();
                                    continue;
                                case 160:
                                    this.xpuTsrsign1_ = codedInputStream.readInt32();
                                    continue;
                                case 168:
                                    this.xpuTsrsign2_ = codedInputStream.readInt32();
                                    continue;
                                case Opcodes.ARETURN /* 176 */:
                                    this.xpuTsrsign3_ = codedInputStream.readInt32();
                                    continue;
                                case Opcodes.INVOKESTATIC /* 184 */:
                                    this.xpuCduUlcstate_ = codedInputStream.readInt32();
                                    continue;
                                case 192:
                                    this.xpuCduUlcconfirmreq_ = codedInputStream.readInt32();
                                    continue;
                                case 200:
                                    this.xpuCduUlcwarning_ = codedInputStream.readInt32();
                                    continue;
                                case 208:
                                    this.xpuAlcst_ = codedInputStream.readInt32();
                                    continue;
                                case 216:
                                    this.xpuAlcdirection_ = codedInputStream.readInt32();
                                    continue;
                                case LocTrafficSignType.LOC_TRAFFIC_SIGN_STOP_AND_CHECK /* 229 */:
                                    this.xpuAlctarlaneendcenterpointy_ = codedInputStream.readFloat();
                                    continue;
                                case LocTrafficSignType.LOC_TRAFFIC_SIGN_MIN_SPEED_LIMIT /* 237 */:
                                    this.xpuAlctarlaneendcenterpointx_ = codedInputStream.readFloat();
                                    continue;
                                case RouteChargeDecorator.TYPE_SELECTED_KEEPER /* 240 */:
                                    this.xpuAlcctrlremind_ = codedInputStream.readInt32();
                                    continue;
                                case 248:
                                    this.xpuAlcstPg_ = codedInputStream.readInt32();
                                    continue;
                                case 256:
                                    this.xpuAssistsysstMsgsender_ = codedInputStream.readInt32();
                                    continue;
                                default:
                                    if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
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
            return Primitives.internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_fieldAccessorTable.ensureFieldAccessorsInitialized(XPU_AssistSysSt_msg.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuXpilotst() {
            return this.xpuXpilotst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuLatctrlremind() {
            return this.xpuLatctrlremind_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuLongctrlremind() {
            return this.xpuLongctrlremind_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuLatctrlremind2() {
            return this.xpuLatctrlremind2_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuLongendctrlreason() {
            return this.xpuLongendctrlreason_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuLateralendctrlreason() {
            return this.xpuLateralendctrlreason_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuHwpst() {
            return this.xpuHwpst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuAccst() {
            return this.xpuAccst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuNgpst() {
            return this.xpuNgpst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuCipst() {
            return this.xpuCipst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuCipWarningst() {
            return this.xpuCipWarningst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuDsmst() {
            return this.xpuDsmst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuLccst() {
            return this.xpuLccst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public float getXpuCruisespdsetdisp() {
            return this.xpuCruisespdsetdisp_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuAtcst() {
            return this.xpuAtcst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuTimegapsetdisp() {
            return this.xpuTimegapsetdisp_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public boolean getXpuCruiseobjst() {
            return this.xpuCruiseobjst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuIslcst() {
            return this.xpuIslcst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuTsrst() {
            return this.xpuTsrst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuTsrsign1() {
            return this.xpuTsrsign1_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuTsrsign2() {
            return this.xpuTsrsign2_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuTsrsign3() {
            return this.xpuTsrsign3_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuCduUlcstate() {
            return this.xpuCduUlcstate_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuCduUlcconfirmreq() {
            return this.xpuCduUlcconfirmreq_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuCduUlcwarning() {
            return this.xpuCduUlcwarning_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuAlcst() {
            return this.xpuAlcst_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuAlcdirection() {
            return this.xpuAlcdirection_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public float getXpuAlctarlaneendcenterpointy() {
            return this.xpuAlctarlaneendcenterpointy_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public float getXpuAlctarlaneendcenterpointx() {
            return this.xpuAlctarlaneendcenterpointx_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuAlcctrlremind() {
            return this.xpuAlcctrlremind_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuAlcstPg() {
            return this.xpuAlcstPg_;
        }

        @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
        public int getXpuAssistsysstMsgsender() {
            return this.xpuAssistsysstMsgsender_;
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
            int i = this.xpuXpilotst_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            int i2 = this.xpuLatctrlremind_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            int i3 = this.xpuLongctrlremind_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
            int i4 = this.xpuLatctrlremind2_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(4, i4);
            }
            int i5 = this.xpuLongendctrlreason_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(5, i5);
            }
            int i6 = this.xpuLateralendctrlreason_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(6, i6);
            }
            int i7 = this.xpuHwpst_;
            if (i7 != 0) {
                codedOutputStream.writeInt32(7, i7);
            }
            int i8 = this.xpuAccst_;
            if (i8 != 0) {
                codedOutputStream.writeInt32(8, i8);
            }
            int i9 = this.xpuNgpst_;
            if (i9 != 0) {
                codedOutputStream.writeInt32(9, i9);
            }
            int i10 = this.xpuCipst_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(10, i10);
            }
            int i11 = this.xpuCipWarningst_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(11, i11);
            }
            int i12 = this.xpuDsmst_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(12, i12);
            }
            int i13 = this.xpuLccst_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(13, i13);
            }
            float f = this.xpuCruisespdsetdisp_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(14, f);
            }
            int i14 = this.xpuAtcst_;
            if (i14 != 0) {
                codedOutputStream.writeInt32(15, i14);
            }
            int i15 = this.xpuTimegapsetdisp_;
            if (i15 != 0) {
                codedOutputStream.writeInt32(16, i15);
            }
            boolean z = this.xpuCruiseobjst_;
            if (z) {
                codedOutputStream.writeBool(17, z);
            }
            int i16 = this.xpuIslcst_;
            if (i16 != 0) {
                codedOutputStream.writeInt32(18, i16);
            }
            int i17 = this.xpuTsrst_;
            if (i17 != 0) {
                codedOutputStream.writeInt32(19, i17);
            }
            int i18 = this.xpuTsrsign1_;
            if (i18 != 0) {
                codedOutputStream.writeInt32(20, i18);
            }
            int i19 = this.xpuTsrsign2_;
            if (i19 != 0) {
                codedOutputStream.writeInt32(21, i19);
            }
            int i20 = this.xpuTsrsign3_;
            if (i20 != 0) {
                codedOutputStream.writeInt32(22, i20);
            }
            int i21 = this.xpuCduUlcstate_;
            if (i21 != 0) {
                codedOutputStream.writeInt32(23, i21);
            }
            int i22 = this.xpuCduUlcconfirmreq_;
            if (i22 != 0) {
                codedOutputStream.writeInt32(24, i22);
            }
            int i23 = this.xpuCduUlcwarning_;
            if (i23 != 0) {
                codedOutputStream.writeInt32(25, i23);
            }
            int i24 = this.xpuAlcst_;
            if (i24 != 0) {
                codedOutputStream.writeInt32(26, i24);
            }
            int i25 = this.xpuAlcdirection_;
            if (i25 != 0) {
                codedOutputStream.writeInt32(27, i25);
            }
            float f2 = this.xpuAlctarlaneendcenterpointy_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(28, f2);
            }
            float f3 = this.xpuAlctarlaneendcenterpointx_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(29, f3);
            }
            int i26 = this.xpuAlcctrlremind_;
            if (i26 != 0) {
                codedOutputStream.writeInt32(30, i26);
            }
            int i27 = this.xpuAlcstPg_;
            if (i27 != 0) {
                codedOutputStream.writeInt32(31, i27);
            }
            int i28 = this.xpuAssistsysstMsgsender_;
            if (i28 != 0) {
                codedOutputStream.writeInt32(32, i28);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.xpuXpilotst_;
            int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.xpuLatctrlremind_;
            if (i3 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.xpuLongctrlremind_;
            if (i4 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
            }
            int i5 = this.xpuLatctrlremind2_;
            if (i5 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, i5);
            }
            int i6 = this.xpuLongendctrlreason_;
            if (i6 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, i6);
            }
            int i7 = this.xpuLateralendctrlreason_;
            if (i7 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, i7);
            }
            int i8 = this.xpuHwpst_;
            if (i8 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, i8);
            }
            int i9 = this.xpuAccst_;
            if (i9 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, i9);
            }
            int i10 = this.xpuNgpst_;
            if (i10 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, i10);
            }
            int i11 = this.xpuCipst_;
            if (i11 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(10, i11);
            }
            int i12 = this.xpuCipWarningst_;
            if (i12 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, i12);
            }
            int i13 = this.xpuDsmst_;
            if (i13 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(12, i13);
            }
            int i14 = this.xpuLccst_;
            if (i14 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(13, i14);
            }
            float f = this.xpuCruisespdsetdisp_;
            if (f != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(14, f);
            }
            int i15 = this.xpuAtcst_;
            if (i15 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(15, i15);
            }
            int i16 = this.xpuTimegapsetdisp_;
            if (i16 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(16, i16);
            }
            boolean z = this.xpuCruiseobjst_;
            if (z) {
                computeInt32Size += CodedOutputStream.computeBoolSize(17, z);
            }
            int i17 = this.xpuIslcst_;
            if (i17 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(18, i17);
            }
            int i18 = this.xpuTsrst_;
            if (i18 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(19, i18);
            }
            int i19 = this.xpuTsrsign1_;
            if (i19 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(20, i19);
            }
            int i20 = this.xpuTsrsign2_;
            if (i20 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(21, i20);
            }
            int i21 = this.xpuTsrsign3_;
            if (i21 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(22, i21);
            }
            int i22 = this.xpuCduUlcstate_;
            if (i22 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(23, i22);
            }
            int i23 = this.xpuCduUlcconfirmreq_;
            if (i23 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(24, i23);
            }
            int i24 = this.xpuCduUlcwarning_;
            if (i24 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(25, i24);
            }
            int i25 = this.xpuAlcst_;
            if (i25 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(26, i25);
            }
            int i26 = this.xpuAlcdirection_;
            if (i26 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(27, i26);
            }
            float f2 = this.xpuAlctarlaneendcenterpointy_;
            if (f2 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(28, f2);
            }
            float f3 = this.xpuAlctarlaneendcenterpointx_;
            if (f3 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(29, f3);
            }
            int i27 = this.xpuAlcctrlremind_;
            if (i27 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(30, i27);
            }
            int i28 = this.xpuAlcstPg_;
            if (i28 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(31, i28);
            }
            int i29 = this.xpuAssistsysstMsgsender_;
            if (i29 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(32, i29);
            }
            int serializedSize = computeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof XPU_AssistSysSt_msg)) {
                return super.equals(obj);
            }
            XPU_AssistSysSt_msg xPU_AssistSysSt_msg = (XPU_AssistSysSt_msg) obj;
            return ((((((((((((((((((((((((((((((((getXpuXpilotst() == xPU_AssistSysSt_msg.getXpuXpilotst()) && getXpuLatctrlremind() == xPU_AssistSysSt_msg.getXpuLatctrlremind()) && getXpuLongctrlremind() == xPU_AssistSysSt_msg.getXpuLongctrlremind()) && getXpuLatctrlremind2() == xPU_AssistSysSt_msg.getXpuLatctrlremind2()) && getXpuLongendctrlreason() == xPU_AssistSysSt_msg.getXpuLongendctrlreason()) && getXpuLateralendctrlreason() == xPU_AssistSysSt_msg.getXpuLateralendctrlreason()) && getXpuHwpst() == xPU_AssistSysSt_msg.getXpuHwpst()) && getXpuAccst() == xPU_AssistSysSt_msg.getXpuAccst()) && getXpuNgpst() == xPU_AssistSysSt_msg.getXpuNgpst()) && getXpuCipst() == xPU_AssistSysSt_msg.getXpuCipst()) && getXpuCipWarningst() == xPU_AssistSysSt_msg.getXpuCipWarningst()) && getXpuDsmst() == xPU_AssistSysSt_msg.getXpuDsmst()) && getXpuLccst() == xPU_AssistSysSt_msg.getXpuLccst()) && Float.floatToIntBits(getXpuCruisespdsetdisp()) == Float.floatToIntBits(xPU_AssistSysSt_msg.getXpuCruisespdsetdisp())) && getXpuAtcst() == xPU_AssistSysSt_msg.getXpuAtcst()) && getXpuTimegapsetdisp() == xPU_AssistSysSt_msg.getXpuTimegapsetdisp()) && getXpuCruiseobjst() == xPU_AssistSysSt_msg.getXpuCruiseobjst()) && getXpuIslcst() == xPU_AssistSysSt_msg.getXpuIslcst()) && getXpuTsrst() == xPU_AssistSysSt_msg.getXpuTsrst()) && getXpuTsrsign1() == xPU_AssistSysSt_msg.getXpuTsrsign1()) && getXpuTsrsign2() == xPU_AssistSysSt_msg.getXpuTsrsign2()) && getXpuTsrsign3() == xPU_AssistSysSt_msg.getXpuTsrsign3()) && getXpuCduUlcstate() == xPU_AssistSysSt_msg.getXpuCduUlcstate()) && getXpuCduUlcconfirmreq() == xPU_AssistSysSt_msg.getXpuCduUlcconfirmreq()) && getXpuCduUlcwarning() == xPU_AssistSysSt_msg.getXpuCduUlcwarning()) && getXpuAlcst() == xPU_AssistSysSt_msg.getXpuAlcst()) && getXpuAlcdirection() == xPU_AssistSysSt_msg.getXpuAlcdirection()) && Float.floatToIntBits(getXpuAlctarlaneendcenterpointy()) == Float.floatToIntBits(xPU_AssistSysSt_msg.getXpuAlctarlaneendcenterpointy())) && Float.floatToIntBits(getXpuAlctarlaneendcenterpointx()) == Float.floatToIntBits(xPU_AssistSysSt_msg.getXpuAlctarlaneendcenterpointx())) && getXpuAlcctrlremind() == xPU_AssistSysSt_msg.getXpuAlcctrlremind()) && getXpuAlcstPg() == xPU_AssistSysSt_msg.getXpuAlcstPg()) && getXpuAssistsysstMsgsender() == xPU_AssistSysSt_msg.getXpuAssistsysstMsgsender()) && this.unknownFields.equals(xPU_AssistSysSt_msg.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getXpuXpilotst()) * 37) + 2) * 53) + getXpuLatctrlremind()) * 37) + 3) * 53) + getXpuLongctrlremind()) * 37) + 4) * 53) + getXpuLatctrlremind2()) * 37) + 5) * 53) + getXpuLongendctrlreason()) * 37) + 6) * 53) + getXpuLateralendctrlreason()) * 37) + 7) * 53) + getXpuHwpst()) * 37) + 8) * 53) + getXpuAccst()) * 37) + 9) * 53) + getXpuNgpst()) * 37) + 10) * 53) + getXpuCipst()) * 37) + 11) * 53) + getXpuCipWarningst()) * 37) + 12) * 53) + getXpuDsmst()) * 37) + 13) * 53) + getXpuLccst()) * 37) + 14) * 53) + Float.floatToIntBits(getXpuCruisespdsetdisp())) * 37) + 15) * 53) + getXpuAtcst()) * 37) + 16) * 53) + getXpuTimegapsetdisp()) * 37) + 17) * 53) + Internal.hashBoolean(getXpuCruiseobjst())) * 37) + 18) * 53) + getXpuIslcst()) * 37) + 19) * 53) + getXpuTsrst()) * 37) + 20) * 53) + getXpuTsrsign1()) * 37) + 21) * 53) + getXpuTsrsign2()) * 37) + 22) * 53) + getXpuTsrsign3()) * 37) + 23) * 53) + getXpuCduUlcstate()) * 37) + 24) * 53) + getXpuCduUlcconfirmreq()) * 37) + 25) * 53) + getXpuCduUlcwarning()) * 37) + 26) * 53) + getXpuAlcst()) * 37) + 27) * 53) + getXpuAlcdirection()) * 37) + 28) * 53) + Float.floatToIntBits(getXpuAlctarlaneendcenterpointy())) * 37) + 29) * 53) + Float.floatToIntBits(getXpuAlctarlaneendcenterpointx())) * 37) + 30) * 53) + getXpuAlcctrlremind()) * 37) + 31) * 53) + getXpuAlcstPg()) * 37) + 32) * 53) + getXpuAssistsysstMsgsender()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static XPU_AssistSysSt_msg parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static XPU_AssistSysSt_msg parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static XPU_AssistSysSt_msg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static XPU_AssistSysSt_msg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static XPU_AssistSysSt_msg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static XPU_AssistSysSt_msg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static XPU_AssistSysSt_msg parseFrom(InputStream inputStream) throws IOException {
            return (XPU_AssistSysSt_msg) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static XPU_AssistSysSt_msg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (XPU_AssistSysSt_msg) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static XPU_AssistSysSt_msg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (XPU_AssistSysSt_msg) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static XPU_AssistSysSt_msg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (XPU_AssistSysSt_msg) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static XPU_AssistSysSt_msg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (XPU_AssistSysSt_msg) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static XPU_AssistSysSt_msg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (XPU_AssistSysSt_msg) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(XPU_AssistSysSt_msg xPU_AssistSysSt_msg) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(xPU_AssistSysSt_msg);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements XPU_AssistSysSt_msgOrBuilder {
            private int xpuAccst_;
            private int xpuAlcctrlremind_;
            private int xpuAlcdirection_;
            private int xpuAlcstPg_;
            private int xpuAlcst_;
            private float xpuAlctarlaneendcenterpointx_;
            private float xpuAlctarlaneendcenterpointy_;
            private int xpuAssistsysstMsgsender_;
            private int xpuAtcst_;
            private int xpuCduUlcconfirmreq_;
            private int xpuCduUlcstate_;
            private int xpuCduUlcwarning_;
            private int xpuCipWarningst_;
            private int xpuCipst_;
            private boolean xpuCruiseobjst_;
            private float xpuCruisespdsetdisp_;
            private int xpuDsmst_;
            private int xpuHwpst_;
            private int xpuIslcst_;
            private int xpuLatctrlremind2_;
            private int xpuLatctrlremind_;
            private int xpuLateralendctrlreason_;
            private int xpuLccst_;
            private int xpuLongctrlremind_;
            private int xpuLongendctrlreason_;
            private int xpuNgpst_;
            private int xpuTimegapsetdisp_;
            private int xpuTsrsign1_;
            private int xpuTsrsign2_;
            private int xpuTsrsign3_;
            private int xpuTsrst_;
            private int xpuXpilotst_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_fieldAccessorTable.ensureFieldAccessorsInitialized(XPU_AssistSysSt_msg.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = XPU_AssistSysSt_msg.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.xpuXpilotst_ = 0;
                this.xpuLatctrlremind_ = 0;
                this.xpuLongctrlremind_ = 0;
                this.xpuLatctrlremind2_ = 0;
                this.xpuLongendctrlreason_ = 0;
                this.xpuLateralendctrlreason_ = 0;
                this.xpuHwpst_ = 0;
                this.xpuAccst_ = 0;
                this.xpuNgpst_ = 0;
                this.xpuCipst_ = 0;
                this.xpuCipWarningst_ = 0;
                this.xpuDsmst_ = 0;
                this.xpuLccst_ = 0;
                this.xpuCruisespdsetdisp_ = 0.0f;
                this.xpuAtcst_ = 0;
                this.xpuTimegapsetdisp_ = 0;
                this.xpuCruiseobjst_ = false;
                this.xpuIslcst_ = 0;
                this.xpuTsrst_ = 0;
                this.xpuTsrsign1_ = 0;
                this.xpuTsrsign2_ = 0;
                this.xpuTsrsign3_ = 0;
                this.xpuCduUlcstate_ = 0;
                this.xpuCduUlcconfirmreq_ = 0;
                this.xpuCduUlcwarning_ = 0;
                this.xpuAlcst_ = 0;
                this.xpuAlcdirection_ = 0;
                this.xpuAlctarlaneendcenterpointy_ = 0.0f;
                this.xpuAlctarlaneendcenterpointx_ = 0.0f;
                this.xpuAlcctrlremind_ = 0;
                this.xpuAlcstPg_ = 0;
                this.xpuAssistsysstMsgsender_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public XPU_AssistSysSt_msg getDefaultInstanceForType() {
                return XPU_AssistSysSt_msg.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public XPU_AssistSysSt_msg build() {
                XPU_AssistSysSt_msg buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public XPU_AssistSysSt_msg buildPartial() {
                XPU_AssistSysSt_msg xPU_AssistSysSt_msg = new XPU_AssistSysSt_msg(this);
                xPU_AssistSysSt_msg.xpuXpilotst_ = this.xpuXpilotst_;
                xPU_AssistSysSt_msg.xpuLatctrlremind_ = this.xpuLatctrlremind_;
                xPU_AssistSysSt_msg.xpuLongctrlremind_ = this.xpuLongctrlremind_;
                xPU_AssistSysSt_msg.xpuLatctrlremind2_ = this.xpuLatctrlremind2_;
                xPU_AssistSysSt_msg.xpuLongendctrlreason_ = this.xpuLongendctrlreason_;
                xPU_AssistSysSt_msg.xpuLateralendctrlreason_ = this.xpuLateralendctrlreason_;
                xPU_AssistSysSt_msg.xpuHwpst_ = this.xpuHwpst_;
                xPU_AssistSysSt_msg.xpuAccst_ = this.xpuAccst_;
                xPU_AssistSysSt_msg.xpuNgpst_ = this.xpuNgpst_;
                xPU_AssistSysSt_msg.xpuCipst_ = this.xpuCipst_;
                xPU_AssistSysSt_msg.xpuCipWarningst_ = this.xpuCipWarningst_;
                xPU_AssistSysSt_msg.xpuDsmst_ = this.xpuDsmst_;
                xPU_AssistSysSt_msg.xpuLccst_ = this.xpuLccst_;
                xPU_AssistSysSt_msg.xpuCruisespdsetdisp_ = this.xpuCruisespdsetdisp_;
                xPU_AssistSysSt_msg.xpuAtcst_ = this.xpuAtcst_;
                xPU_AssistSysSt_msg.xpuTimegapsetdisp_ = this.xpuTimegapsetdisp_;
                xPU_AssistSysSt_msg.xpuCruiseobjst_ = this.xpuCruiseobjst_;
                xPU_AssistSysSt_msg.xpuIslcst_ = this.xpuIslcst_;
                xPU_AssistSysSt_msg.xpuTsrst_ = this.xpuTsrst_;
                xPU_AssistSysSt_msg.xpuTsrsign1_ = this.xpuTsrsign1_;
                xPU_AssistSysSt_msg.xpuTsrsign2_ = this.xpuTsrsign2_;
                xPU_AssistSysSt_msg.xpuTsrsign3_ = this.xpuTsrsign3_;
                xPU_AssistSysSt_msg.xpuCduUlcstate_ = this.xpuCduUlcstate_;
                xPU_AssistSysSt_msg.xpuCduUlcconfirmreq_ = this.xpuCduUlcconfirmreq_;
                xPU_AssistSysSt_msg.xpuCduUlcwarning_ = this.xpuCduUlcwarning_;
                xPU_AssistSysSt_msg.xpuAlcst_ = this.xpuAlcst_;
                xPU_AssistSysSt_msg.xpuAlcdirection_ = this.xpuAlcdirection_;
                xPU_AssistSysSt_msg.xpuAlctarlaneendcenterpointy_ = this.xpuAlctarlaneendcenterpointy_;
                xPU_AssistSysSt_msg.xpuAlctarlaneendcenterpointx_ = this.xpuAlctarlaneendcenterpointx_;
                xPU_AssistSysSt_msg.xpuAlcctrlremind_ = this.xpuAlcctrlremind_;
                xPU_AssistSysSt_msg.xpuAlcstPg_ = this.xpuAlcstPg_;
                xPU_AssistSysSt_msg.xpuAssistsysstMsgsender_ = this.xpuAssistsysstMsgsender_;
                onBuilt();
                return xPU_AssistSysSt_msg;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof XPU_AssistSysSt_msg) {
                    return mergeFrom((XPU_AssistSysSt_msg) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(XPU_AssistSysSt_msg xPU_AssistSysSt_msg) {
                if (xPU_AssistSysSt_msg == XPU_AssistSysSt_msg.getDefaultInstance()) {
                    return this;
                }
                if (xPU_AssistSysSt_msg.getXpuXpilotst() != 0) {
                    setXpuXpilotst(xPU_AssistSysSt_msg.getXpuXpilotst());
                }
                if (xPU_AssistSysSt_msg.getXpuLatctrlremind() != 0) {
                    setXpuLatctrlremind(xPU_AssistSysSt_msg.getXpuLatctrlremind());
                }
                if (xPU_AssistSysSt_msg.getXpuLongctrlremind() != 0) {
                    setXpuLongctrlremind(xPU_AssistSysSt_msg.getXpuLongctrlremind());
                }
                if (xPU_AssistSysSt_msg.getXpuLatctrlremind2() != 0) {
                    setXpuLatctrlremind2(xPU_AssistSysSt_msg.getXpuLatctrlremind2());
                }
                if (xPU_AssistSysSt_msg.getXpuLongendctrlreason() != 0) {
                    setXpuLongendctrlreason(xPU_AssistSysSt_msg.getXpuLongendctrlreason());
                }
                if (xPU_AssistSysSt_msg.getXpuLateralendctrlreason() != 0) {
                    setXpuLateralendctrlreason(xPU_AssistSysSt_msg.getXpuLateralendctrlreason());
                }
                if (xPU_AssistSysSt_msg.getXpuHwpst() != 0) {
                    setXpuHwpst(xPU_AssistSysSt_msg.getXpuHwpst());
                }
                if (xPU_AssistSysSt_msg.getXpuAccst() != 0) {
                    setXpuAccst(xPU_AssistSysSt_msg.getXpuAccst());
                }
                if (xPU_AssistSysSt_msg.getXpuNgpst() != 0) {
                    setXpuNgpst(xPU_AssistSysSt_msg.getXpuNgpst());
                }
                if (xPU_AssistSysSt_msg.getXpuCipst() != 0) {
                    setXpuCipst(xPU_AssistSysSt_msg.getXpuCipst());
                }
                if (xPU_AssistSysSt_msg.getXpuCipWarningst() != 0) {
                    setXpuCipWarningst(xPU_AssistSysSt_msg.getXpuCipWarningst());
                }
                if (xPU_AssistSysSt_msg.getXpuDsmst() != 0) {
                    setXpuDsmst(xPU_AssistSysSt_msg.getXpuDsmst());
                }
                if (xPU_AssistSysSt_msg.getXpuLccst() != 0) {
                    setXpuLccst(xPU_AssistSysSt_msg.getXpuLccst());
                }
                if (xPU_AssistSysSt_msg.getXpuCruisespdsetdisp() != 0.0f) {
                    setXpuCruisespdsetdisp(xPU_AssistSysSt_msg.getXpuCruisespdsetdisp());
                }
                if (xPU_AssistSysSt_msg.getXpuAtcst() != 0) {
                    setXpuAtcst(xPU_AssistSysSt_msg.getXpuAtcst());
                }
                if (xPU_AssistSysSt_msg.getXpuTimegapsetdisp() != 0) {
                    setXpuTimegapsetdisp(xPU_AssistSysSt_msg.getXpuTimegapsetdisp());
                }
                if (xPU_AssistSysSt_msg.getXpuCruiseobjst()) {
                    setXpuCruiseobjst(xPU_AssistSysSt_msg.getXpuCruiseobjst());
                }
                if (xPU_AssistSysSt_msg.getXpuIslcst() != 0) {
                    setXpuIslcst(xPU_AssistSysSt_msg.getXpuIslcst());
                }
                if (xPU_AssistSysSt_msg.getXpuTsrst() != 0) {
                    setXpuTsrst(xPU_AssistSysSt_msg.getXpuTsrst());
                }
                if (xPU_AssistSysSt_msg.getXpuTsrsign1() != 0) {
                    setXpuTsrsign1(xPU_AssistSysSt_msg.getXpuTsrsign1());
                }
                if (xPU_AssistSysSt_msg.getXpuTsrsign2() != 0) {
                    setXpuTsrsign2(xPU_AssistSysSt_msg.getXpuTsrsign2());
                }
                if (xPU_AssistSysSt_msg.getXpuTsrsign3() != 0) {
                    setXpuTsrsign3(xPU_AssistSysSt_msg.getXpuTsrsign3());
                }
                if (xPU_AssistSysSt_msg.getXpuCduUlcstate() != 0) {
                    setXpuCduUlcstate(xPU_AssistSysSt_msg.getXpuCduUlcstate());
                }
                if (xPU_AssistSysSt_msg.getXpuCduUlcconfirmreq() != 0) {
                    setXpuCduUlcconfirmreq(xPU_AssistSysSt_msg.getXpuCduUlcconfirmreq());
                }
                if (xPU_AssistSysSt_msg.getXpuCduUlcwarning() != 0) {
                    setXpuCduUlcwarning(xPU_AssistSysSt_msg.getXpuCduUlcwarning());
                }
                if (xPU_AssistSysSt_msg.getXpuAlcst() != 0) {
                    setXpuAlcst(xPU_AssistSysSt_msg.getXpuAlcst());
                }
                if (xPU_AssistSysSt_msg.getXpuAlcdirection() != 0) {
                    setXpuAlcdirection(xPU_AssistSysSt_msg.getXpuAlcdirection());
                }
                if (xPU_AssistSysSt_msg.getXpuAlctarlaneendcenterpointy() != 0.0f) {
                    setXpuAlctarlaneendcenterpointy(xPU_AssistSysSt_msg.getXpuAlctarlaneendcenterpointy());
                }
                if (xPU_AssistSysSt_msg.getXpuAlctarlaneendcenterpointx() != 0.0f) {
                    setXpuAlctarlaneendcenterpointx(xPU_AssistSysSt_msg.getXpuAlctarlaneendcenterpointx());
                }
                if (xPU_AssistSysSt_msg.getXpuAlcctrlremind() != 0) {
                    setXpuAlcctrlremind(xPU_AssistSysSt_msg.getXpuAlcctrlremind());
                }
                if (xPU_AssistSysSt_msg.getXpuAlcstPg() != 0) {
                    setXpuAlcstPg(xPU_AssistSysSt_msg.getXpuAlcstPg());
                }
                if (xPU_AssistSysSt_msg.getXpuAssistsysstMsgsender() != 0) {
                    setXpuAssistsysstMsgsender(xPU_AssistSysSt_msg.getXpuAssistsysstMsgsender());
                }
                mergeUnknownFields(xPU_AssistSysSt_msg.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.XPU_AssistSysSt_msg.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.XPU_AssistSysSt_msg.access$18200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$XPU_AssistSysSt_msg r3 = (xpilot.sr.proto.Primitives.XPU_AssistSysSt_msg) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$XPU_AssistSysSt_msg r4 = (xpilot.sr.proto.Primitives.XPU_AssistSysSt_msg) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.XPU_AssistSysSt_msg.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$XPU_AssistSysSt_msg$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuXpilotst() {
                return this.xpuXpilotst_;
            }

            public Builder setXpuXpilotst(int i) {
                this.xpuXpilotst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuXpilotst() {
                this.xpuXpilotst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuLatctrlremind() {
                return this.xpuLatctrlremind_;
            }

            public Builder setXpuLatctrlremind(int i) {
                this.xpuLatctrlremind_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuLatctrlremind() {
                this.xpuLatctrlremind_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuLongctrlremind() {
                return this.xpuLongctrlremind_;
            }

            public Builder setXpuLongctrlremind(int i) {
                this.xpuLongctrlremind_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuLongctrlremind() {
                this.xpuLongctrlremind_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuLatctrlremind2() {
                return this.xpuLatctrlremind2_;
            }

            public Builder setXpuLatctrlremind2(int i) {
                this.xpuLatctrlremind2_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuLatctrlremind2() {
                this.xpuLatctrlremind2_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuLongendctrlreason() {
                return this.xpuLongendctrlreason_;
            }

            public Builder setXpuLongendctrlreason(int i) {
                this.xpuLongendctrlreason_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuLongendctrlreason() {
                this.xpuLongendctrlreason_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuLateralendctrlreason() {
                return this.xpuLateralendctrlreason_;
            }

            public Builder setXpuLateralendctrlreason(int i) {
                this.xpuLateralendctrlreason_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuLateralendctrlreason() {
                this.xpuLateralendctrlreason_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuHwpst() {
                return this.xpuHwpst_;
            }

            public Builder setXpuHwpst(int i) {
                this.xpuHwpst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuHwpst() {
                this.xpuHwpst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuAccst() {
                return this.xpuAccst_;
            }

            public Builder setXpuAccst(int i) {
                this.xpuAccst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuAccst() {
                this.xpuAccst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuNgpst() {
                return this.xpuNgpst_;
            }

            public Builder setXpuNgpst(int i) {
                this.xpuNgpst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuNgpst() {
                this.xpuNgpst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuCipst() {
                return this.xpuCipst_;
            }

            public Builder setXpuCipst(int i) {
                this.xpuCipst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuCipst() {
                this.xpuCipst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuCipWarningst() {
                return this.xpuCipWarningst_;
            }

            public Builder setXpuCipWarningst(int i) {
                this.xpuCipWarningst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuCipWarningst() {
                this.xpuCipWarningst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuDsmst() {
                return this.xpuDsmst_;
            }

            public Builder setXpuDsmst(int i) {
                this.xpuDsmst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuDsmst() {
                this.xpuDsmst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuLccst() {
                return this.xpuLccst_;
            }

            public Builder setXpuLccst(int i) {
                this.xpuLccst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuLccst() {
                this.xpuLccst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public float getXpuCruisespdsetdisp() {
                return this.xpuCruisespdsetdisp_;
            }

            public Builder setXpuCruisespdsetdisp(float f) {
                this.xpuCruisespdsetdisp_ = f;
                onChanged();
                return this;
            }

            public Builder clearXpuCruisespdsetdisp() {
                this.xpuCruisespdsetdisp_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuAtcst() {
                return this.xpuAtcst_;
            }

            public Builder setXpuAtcst(int i) {
                this.xpuAtcst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuAtcst() {
                this.xpuAtcst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuTimegapsetdisp() {
                return this.xpuTimegapsetdisp_;
            }

            public Builder setXpuTimegapsetdisp(int i) {
                this.xpuTimegapsetdisp_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuTimegapsetdisp() {
                this.xpuTimegapsetdisp_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public boolean getXpuCruiseobjst() {
                return this.xpuCruiseobjst_;
            }

            public Builder setXpuCruiseobjst(boolean z) {
                this.xpuCruiseobjst_ = z;
                onChanged();
                return this;
            }

            public Builder clearXpuCruiseobjst() {
                this.xpuCruiseobjst_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuIslcst() {
                return this.xpuIslcst_;
            }

            public Builder setXpuIslcst(int i) {
                this.xpuIslcst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuIslcst() {
                this.xpuIslcst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuTsrst() {
                return this.xpuTsrst_;
            }

            public Builder setXpuTsrst(int i) {
                this.xpuTsrst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuTsrst() {
                this.xpuTsrst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuTsrsign1() {
                return this.xpuTsrsign1_;
            }

            public Builder setXpuTsrsign1(int i) {
                this.xpuTsrsign1_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuTsrsign1() {
                this.xpuTsrsign1_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuTsrsign2() {
                return this.xpuTsrsign2_;
            }

            public Builder setXpuTsrsign2(int i) {
                this.xpuTsrsign2_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuTsrsign2() {
                this.xpuTsrsign2_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuTsrsign3() {
                return this.xpuTsrsign3_;
            }

            public Builder setXpuTsrsign3(int i) {
                this.xpuTsrsign3_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuTsrsign3() {
                this.xpuTsrsign3_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuCduUlcstate() {
                return this.xpuCduUlcstate_;
            }

            public Builder setXpuCduUlcstate(int i) {
                this.xpuCduUlcstate_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuCduUlcstate() {
                this.xpuCduUlcstate_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuCduUlcconfirmreq() {
                return this.xpuCduUlcconfirmreq_;
            }

            public Builder setXpuCduUlcconfirmreq(int i) {
                this.xpuCduUlcconfirmreq_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuCduUlcconfirmreq() {
                this.xpuCduUlcconfirmreq_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuCduUlcwarning() {
                return this.xpuCduUlcwarning_;
            }

            public Builder setXpuCduUlcwarning(int i) {
                this.xpuCduUlcwarning_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuCduUlcwarning() {
                this.xpuCduUlcwarning_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuAlcst() {
                return this.xpuAlcst_;
            }

            public Builder setXpuAlcst(int i) {
                this.xpuAlcst_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuAlcst() {
                this.xpuAlcst_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuAlcdirection() {
                return this.xpuAlcdirection_;
            }

            public Builder setXpuAlcdirection(int i) {
                this.xpuAlcdirection_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuAlcdirection() {
                this.xpuAlcdirection_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public float getXpuAlctarlaneendcenterpointy() {
                return this.xpuAlctarlaneendcenterpointy_;
            }

            public Builder setXpuAlctarlaneendcenterpointy(float f) {
                this.xpuAlctarlaneendcenterpointy_ = f;
                onChanged();
                return this;
            }

            public Builder clearXpuAlctarlaneendcenterpointy() {
                this.xpuAlctarlaneendcenterpointy_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public float getXpuAlctarlaneendcenterpointx() {
                return this.xpuAlctarlaneendcenterpointx_;
            }

            public Builder setXpuAlctarlaneendcenterpointx(float f) {
                this.xpuAlctarlaneendcenterpointx_ = f;
                onChanged();
                return this;
            }

            public Builder clearXpuAlctarlaneendcenterpointx() {
                this.xpuAlctarlaneendcenterpointx_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuAlcctrlremind() {
                return this.xpuAlcctrlremind_;
            }

            public Builder setXpuAlcctrlremind(int i) {
                this.xpuAlcctrlremind_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuAlcctrlremind() {
                this.xpuAlcctrlremind_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuAlcstPg() {
                return this.xpuAlcstPg_;
            }

            public Builder setXpuAlcstPg(int i) {
                this.xpuAlcstPg_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuAlcstPg() {
                this.xpuAlcstPg_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.XPU_AssistSysSt_msgOrBuilder
            public int getXpuAssistsysstMsgsender() {
                return this.xpuAssistsysstMsgsender_;
            }

            public Builder setXpuAssistsysstMsgsender(int i) {
                this.xpuAssistsysstMsgsender_ = i;
                onChanged();
                return this;
            }

            public Builder clearXpuAssistsysstMsgsender() {
                this.xpuAssistsysstMsgsender_ = 0;
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

        public static XPU_AssistSysSt_msg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<XPU_AssistSysSt_msg> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<XPU_AssistSysSt_msg> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public XPU_AssistSysSt_msg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wgs extends GeneratedMessageV3 implements WgsOrBuilder {
        public static final int ELEV_FIELD_NUMBER = 3;
        public static final int LAT_FIELD_NUMBER = 1;
        public static final int LNG_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private double elev_;
        private double lat_;
        private double lng_;
        private byte memoizedIsInitialized;
        private static final Wgs DEFAULT_INSTANCE = new Wgs();
        private static final Parser<Wgs> PARSER = new AbstractParser<Wgs>() { // from class: xpilot.sr.proto.Primitives.Wgs.1
            @Override // com.google.protobuf.Parser
            public Wgs parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Wgs(codedInputStream, extensionRegistryLite);
            }
        };

        private Wgs(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Wgs() {
            this.memoizedIsInitialized = (byte) -1;
            this.lat_ = 0.0d;
            this.lng_ = 0.0d;
            this.elev_ = 0.0d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Wgs(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 9) {
                                this.lat_ = codedInputStream.readDouble();
                            } else if (readTag == 17) {
                                this.lng_ = codedInputStream.readDouble();
                            } else if (readTag == 25) {
                                this.elev_ = codedInputStream.readDouble();
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
            return Primitives.internal_static_xpilot_sr_proto_Wgs_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_Wgs_fieldAccessorTable.ensureFieldAccessorsInitialized(Wgs.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.WgsOrBuilder
        public double getLat() {
            return this.lat_;
        }

        @Override // xpilot.sr.proto.Primitives.WgsOrBuilder
        public double getLng() {
            return this.lng_;
        }

        @Override // xpilot.sr.proto.Primitives.WgsOrBuilder
        public double getElev() {
            return this.elev_;
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
            double d = this.lat_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(1, d);
            }
            double d2 = this.lng_;
            if (d2 != 0.0d) {
                codedOutputStream.writeDouble(2, d2);
            }
            double d3 = this.elev_;
            if (d3 != 0.0d) {
                codedOutputStream.writeDouble(3, d3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            double d = this.lat_;
            int computeDoubleSize = d != 0.0d ? 0 + CodedOutputStream.computeDoubleSize(1, d) : 0;
            double d2 = this.lng_;
            if (d2 != 0.0d) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(2, d2);
            }
            double d3 = this.elev_;
            if (d3 != 0.0d) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(3, d3);
            }
            int serializedSize = computeDoubleSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wgs)) {
                return super.equals(obj);
            }
            Wgs wgs = (Wgs) obj;
            return ((((Double.doubleToLongBits(getLat()) > Double.doubleToLongBits(wgs.getLat()) ? 1 : (Double.doubleToLongBits(getLat()) == Double.doubleToLongBits(wgs.getLat()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getLng()) > Double.doubleToLongBits(wgs.getLng()) ? 1 : (Double.doubleToLongBits(getLng()) == Double.doubleToLongBits(wgs.getLng()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getElev()) > Double.doubleToLongBits(wgs.getElev()) ? 1 : (Double.doubleToLongBits(getElev()) == Double.doubleToLongBits(wgs.getElev()) ? 0 : -1)) == 0) && this.unknownFields.equals(wgs.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(Double.doubleToLongBits(getLat()))) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getLng()))) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getElev()))) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static Wgs parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Wgs parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Wgs parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Wgs parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Wgs parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Wgs parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Wgs parseFrom(InputStream inputStream) throws IOException {
            return (Wgs) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Wgs parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Wgs) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Wgs parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Wgs) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Wgs parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Wgs) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Wgs parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Wgs) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Wgs parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Wgs) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Wgs wgs) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wgs);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WgsOrBuilder {
            private double elev_;
            private double lat_;
            private double lng_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_Wgs_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_Wgs_fieldAccessorTable.ensureFieldAccessorsInitialized(Wgs.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Wgs.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.lat_ = 0.0d;
                this.lng_ = 0.0d;
                this.elev_ = 0.0d;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_Wgs_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Wgs getDefaultInstanceForType() {
                return Wgs.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Wgs build() {
                Wgs buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Wgs buildPartial() {
                Wgs wgs = new Wgs(this);
                wgs.lat_ = this.lat_;
                wgs.lng_ = this.lng_;
                wgs.elev_ = this.elev_;
                onBuilt();
                return wgs;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof Wgs) {
                    return mergeFrom((Wgs) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Wgs wgs) {
                if (wgs == Wgs.getDefaultInstance()) {
                    return this;
                }
                if (wgs.getLat() != 0.0d) {
                    setLat(wgs.getLat());
                }
                if (wgs.getLng() != 0.0d) {
                    setLng(wgs.getLng());
                }
                if (wgs.getElev() != 0.0d) {
                    setElev(wgs.getElev());
                }
                mergeUnknownFields(wgs.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.Wgs.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.Wgs.access$19400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$Wgs r3 = (xpilot.sr.proto.Primitives.Wgs) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$Wgs r4 = (xpilot.sr.proto.Primitives.Wgs) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.Wgs.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$Wgs$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.WgsOrBuilder
            public double getLat() {
                return this.lat_;
            }

            public Builder setLat(double d) {
                this.lat_ = d;
                onChanged();
                return this;
            }

            public Builder clearLat() {
                this.lat_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.WgsOrBuilder
            public double getLng() {
                return this.lng_;
            }

            public Builder setLng(double d) {
                this.lng_ = d;
                onChanged();
                return this;
            }

            public Builder clearLng() {
                this.lng_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.WgsOrBuilder
            public double getElev() {
                return this.elev_;
            }

            public Builder setElev(double d) {
                this.elev_ = d;
                onChanged();
                return this;
            }

            public Builder clearElev() {
                this.elev_ = 0.0d;
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

        public static Wgs getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Wgs> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Wgs> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Wgs getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class GlobalPoseInfo extends GeneratedMessageV3 implements GlobalPoseInfoOrBuilder {
        private static final GlobalPoseInfo DEFAULT_INSTANCE = new GlobalPoseInfo();
        private static final Parser<GlobalPoseInfo> PARSER = new AbstractParser<GlobalPoseInfo>() { // from class: xpilot.sr.proto.Primitives.GlobalPoseInfo.1
            @Override // com.google.protobuf.Parser
            public GlobalPoseInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new GlobalPoseInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SPARE_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final int WORLD_POSE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private Time timestamp_;
        private Wgs worldPose_;

        private GlobalPoseInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private GlobalPoseInfo() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.spare_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GlobalPoseInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                Wgs.Builder builder = this.worldPose_ != null ? this.worldPose_.toBuilder() : null;
                                this.worldPose_ = (Wgs) codedInputStream.readMessage(Wgs.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.worldPose_);
                                    this.worldPose_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                Time.Builder builder2 = this.timestamp_ != null ? this.timestamp_.toBuilder() : null;
                                this.timestamp_ = (Time) codedInputStream.readMessage(Time.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.timestamp_);
                                    this.timestamp_ = builder2.buildPartial();
                                }
                            } else if (readTag == 26) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                boolean z3 = (z2 ? 1 : 0) & true;
                                z2 = z2;
                                if (!z3) {
                                    z2 = z2;
                                    if (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.spare_ = new ArrayList();
                                        z2 = (z2 ? 1 : 0) | true;
                                    }
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.spare_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 29) {
                                boolean z4 = (z2 ? 1 : 0) & true;
                                z2 = z2;
                                if (!z4) {
                                    this.spare_ = new ArrayList();
                                    z2 = (z2 ? 1 : 0) | true;
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
                    if ((z2 ? 1 : 0) & true) {
                        this.spare_ = Collections.unmodifiableList(this.spare_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Primitives.internal_static_xpilot_sr_proto_GlobalPoseInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_GlobalPoseInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GlobalPoseInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
        public boolean hasWorldPose() {
            return this.worldPose_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
        public Wgs getWorldPose() {
            Wgs wgs = this.worldPose_;
            return wgs == null ? Wgs.getDefaultInstance() : wgs;
        }

        @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
        public WgsOrBuilder getWorldPoseOrBuilder() {
            return getWorldPose();
        }

        @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
        public boolean hasTimestamp() {
            return this.timestamp_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
        public Time getTimestamp() {
            Time time = this.timestamp_;
            return time == null ? Time.getDefaultInstance() : time;
        }

        @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
        public TimeOrBuilder getTimestampOrBuilder() {
            return getTimestamp();
        }

        @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
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
            if (this.worldPose_ != null) {
                codedOutputStream.writeMessage(1, getWorldPose());
            }
            if (this.timestamp_ != null) {
                codedOutputStream.writeMessage(2, getTimestamp());
            }
            if (getSpareList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(26);
                codedOutputStream.writeUInt32NoTag(this.spareMemoizedSerializedSize);
            }
            for (int i = 0; i < this.spare_.size(); i++) {
                codedOutputStream.writeFloatNoTag(this.spare_.get(i).floatValue());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.worldPose_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getWorldPose()) : 0;
            if (this.timestamp_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getTimestamp());
            }
            int size = getSpareList().size() * 4;
            int i2 = computeMessageSize + size;
            if (!getSpareList().isEmpty()) {
                i2 = i2 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.spareMemoizedSerializedSize = size;
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GlobalPoseInfo)) {
                return super.equals(obj);
            }
            GlobalPoseInfo globalPoseInfo = (GlobalPoseInfo) obj;
            boolean z = hasWorldPose() == globalPoseInfo.hasWorldPose();
            if (hasWorldPose()) {
                z = z && getWorldPose().equals(globalPoseInfo.getWorldPose());
            }
            boolean z2 = z && hasTimestamp() == globalPoseInfo.hasTimestamp();
            if (hasTimestamp()) {
                z2 = z2 && getTimestamp().equals(globalPoseInfo.getTimestamp());
            }
            return (z2 && getSpareList().equals(globalPoseInfo.getSpareList())) && this.unknownFields.equals(globalPoseInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasWorldPose()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getWorldPose().hashCode();
            }
            if (hasTimestamp()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getTimestamp().hashCode();
            }
            if (getSpareCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getSpareList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static GlobalPoseInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static GlobalPoseInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static GlobalPoseInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static GlobalPoseInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static GlobalPoseInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static GlobalPoseInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static GlobalPoseInfo parseFrom(InputStream inputStream) throws IOException {
            return (GlobalPoseInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static GlobalPoseInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GlobalPoseInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static GlobalPoseInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GlobalPoseInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static GlobalPoseInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GlobalPoseInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static GlobalPoseInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GlobalPoseInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static GlobalPoseInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GlobalPoseInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GlobalPoseInfo globalPoseInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(globalPoseInfo);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GlobalPoseInfoOrBuilder {
            private int bitField0_;
            private List<Float> spare_;
            private SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> timestampBuilder_;
            private Time timestamp_;
            private SingleFieldBuilderV3<Wgs, Wgs.Builder, WgsOrBuilder> worldPoseBuilder_;
            private Wgs worldPose_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_GlobalPoseInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_GlobalPoseInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GlobalPoseInfo.class, Builder.class);
            }

            private Builder() {
                this.worldPose_ = null;
                this.timestamp_ = null;
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.worldPose_ = null;
                this.timestamp_ = null;
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GlobalPoseInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.worldPoseBuilder_ == null) {
                    this.worldPose_ = null;
                } else {
                    this.worldPose_ = null;
                    this.worldPoseBuilder_ = null;
                }
                if (this.timestampBuilder_ == null) {
                    this.timestamp_ = null;
                } else {
                    this.timestamp_ = null;
                    this.timestampBuilder_ = null;
                }
                this.spare_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_GlobalPoseInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GlobalPoseInfo getDefaultInstanceForType() {
                return GlobalPoseInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GlobalPoseInfo build() {
                GlobalPoseInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GlobalPoseInfo buildPartial() {
                GlobalPoseInfo globalPoseInfo = new GlobalPoseInfo(this);
                int i = this.bitField0_;
                SingleFieldBuilderV3<Wgs, Wgs.Builder, WgsOrBuilder> singleFieldBuilderV3 = this.worldPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    globalPoseInfo.worldPose_ = this.worldPose_;
                } else {
                    globalPoseInfo.worldPose_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV32 = this.timestampBuilder_;
                if (singleFieldBuilderV32 == null) {
                    globalPoseInfo.timestamp_ = this.timestamp_;
                } else {
                    globalPoseInfo.timestamp_ = singleFieldBuilderV32.build();
                }
                if ((this.bitField0_ & 4) == 4) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField0_ &= -5;
                }
                globalPoseInfo.spare_ = this.spare_;
                globalPoseInfo.bitField0_ = 0;
                onBuilt();
                return globalPoseInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof GlobalPoseInfo) {
                    return mergeFrom((GlobalPoseInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(GlobalPoseInfo globalPoseInfo) {
                if (globalPoseInfo == GlobalPoseInfo.getDefaultInstance()) {
                    return this;
                }
                if (globalPoseInfo.hasWorldPose()) {
                    mergeWorldPose(globalPoseInfo.getWorldPose());
                }
                if (globalPoseInfo.hasTimestamp()) {
                    mergeTimestamp(globalPoseInfo.getTimestamp());
                }
                if (!globalPoseInfo.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = globalPoseInfo.spare_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(globalPoseInfo.spare_);
                    }
                    onChanged();
                }
                mergeUnknownFields(globalPoseInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.GlobalPoseInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.GlobalPoseInfo.access$20700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$GlobalPoseInfo r3 = (xpilot.sr.proto.Primitives.GlobalPoseInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$GlobalPoseInfo r4 = (xpilot.sr.proto.Primitives.GlobalPoseInfo) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.GlobalPoseInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$GlobalPoseInfo$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
            public boolean hasWorldPose() {
                return (this.worldPoseBuilder_ == null && this.worldPose_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
            public Wgs getWorldPose() {
                SingleFieldBuilderV3<Wgs, Wgs.Builder, WgsOrBuilder> singleFieldBuilderV3 = this.worldPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Wgs wgs = this.worldPose_;
                    return wgs == null ? Wgs.getDefaultInstance() : wgs;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setWorldPose(Wgs wgs) {
                SingleFieldBuilderV3<Wgs, Wgs.Builder, WgsOrBuilder> singleFieldBuilderV3 = this.worldPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(wgs);
                } else if (wgs == null) {
                    throw new NullPointerException();
                } else {
                    this.worldPose_ = wgs;
                    onChanged();
                }
                return this;
            }

            public Builder setWorldPose(Wgs.Builder builder) {
                SingleFieldBuilderV3<Wgs, Wgs.Builder, WgsOrBuilder> singleFieldBuilderV3 = this.worldPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.worldPose_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeWorldPose(Wgs wgs) {
                SingleFieldBuilderV3<Wgs, Wgs.Builder, WgsOrBuilder> singleFieldBuilderV3 = this.worldPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Wgs wgs2 = this.worldPose_;
                    if (wgs2 != null) {
                        this.worldPose_ = Wgs.newBuilder(wgs2).mergeFrom(wgs).buildPartial();
                    } else {
                        this.worldPose_ = wgs;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(wgs);
                }
                return this;
            }

            public Builder clearWorldPose() {
                if (this.worldPoseBuilder_ == null) {
                    this.worldPose_ = null;
                    onChanged();
                } else {
                    this.worldPose_ = null;
                    this.worldPoseBuilder_ = null;
                }
                return this;
            }

            public Wgs.Builder getWorldPoseBuilder() {
                onChanged();
                return getWorldPoseFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
            public WgsOrBuilder getWorldPoseOrBuilder() {
                SingleFieldBuilderV3<Wgs, Wgs.Builder, WgsOrBuilder> singleFieldBuilderV3 = this.worldPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Wgs wgs = this.worldPose_;
                return wgs == null ? Wgs.getDefaultInstance() : wgs;
            }

            private SingleFieldBuilderV3<Wgs, Wgs.Builder, WgsOrBuilder> getWorldPoseFieldBuilder() {
                if (this.worldPoseBuilder_ == null) {
                    this.worldPoseBuilder_ = new SingleFieldBuilderV3<>(getWorldPose(), getParentForChildren(), isClean());
                    this.worldPose_ = null;
                }
                return this.worldPoseBuilder_;
            }

            @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
            public boolean hasTimestamp() {
                return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
            public Time getTimestamp() {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Time time = this.timestamp_;
                    return time == null ? Time.getDefaultInstance() : time;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setTimestamp(Time time) {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
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

            public Builder setTimestamp(Time.Builder builder) {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.timestamp_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeTimestamp(Time time) {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Time time2 = this.timestamp_;
                    if (time2 != null) {
                        this.timestamp_ = Time.newBuilder(time2).mergeFrom(time).buildPartial();
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

            public Time.Builder getTimestampBuilder() {
                onChanged();
                return getTimestampFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
            public TimeOrBuilder getTimestampOrBuilder() {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Time time = this.timestamp_;
                return time == null ? Time.getDefaultInstance() : time;
            }

            private SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> getTimestampFieldBuilder() {
                if (this.timestampBuilder_ == null) {
                    this.timestampBuilder_ = new SingleFieldBuilderV3<>(getTimestamp(), getParentForChildren(), isClean());
                    this.timestamp_ = null;
                }
                return this.timestampBuilder_;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.Primitives.GlobalPoseInfoOrBuilder
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
                this.bitField0_ &= -5;
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

        public static GlobalPoseInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GlobalPoseInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GlobalPoseInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GlobalPoseInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class StateManagement extends GeneratedMessageV3 implements StateManagementOrBuilder {
        private static final StateManagement DEFAULT_INSTANCE = new StateManagement();
        private static final Parser<StateManagement> PARSER = new AbstractParser<StateManagement>() { // from class: xpilot.sr.proto.Primitives.StateManagement.1
            @Override // com.google.protobuf.Parser
            public StateManagement parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StateManagement(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RDMODULECOM_10_STATE_FIELD_NUMBER = 32;
        public static final int RDMODULECOM_11_STATE_FIELD_NUMBER = 33;
        public static final int RDMODULECOM_12_STATE_FIELD_NUMBER = 34;
        public static final int RDMODULECOM_13_STATE_FIELD_NUMBER = 35;
        public static final int RDMODULECOM_14_STATE_FIELD_NUMBER = 36;
        public static final int RDMODULECOM_15_STATE_FIELD_NUMBER = 37;
        public static final int RDMODULECOM_16_STATE_FIELD_NUMBER = 38;
        public static final int RDMODULECOM_17_STATE_FIELD_NUMBER = 39;
        public static final int RDMODULECOM_18_STATE_FIELD_NUMBER = 40;
        public static final int RDMODULECOM_19_STATE_FIELD_NUMBER = 41;
        public static final int RDMODULECOM_20_STATE_FIELD_NUMBER = 42;
        public static final int RDMODULECOM_9_STATE_FIELD_NUMBER = 31;
        public static final int RDMODULECOM_ACCCTRL_FIELD_NUMBER = 7;
        public static final int RDMODULECOM_ACCHOLD_FIELD_NUMBER = 11;
        public static final int RDMODULECOM_ACCMODE_FIELD_NUMBER = 23;
        public static final int RDMODULECOM_ACC_MODE_1_FIELD_NUMBER = 12;
        public static final int RDMODULECOM_ALCMODE_FIELD_NUMBER = 21;
        public static final int RDMODULECOM_ALCSTATE_FIELD_NUMBER = 19;
        public static final int RDMODULECOM_BEHAVIORPLANNING_FIELD_NUMBER = 5;
        public static final int RDMODULECOM_CRUISELEVERTHW_FIELD_NUMBER = 9;
        public static final int RDMODULECOM_CRUISEVEHSPD_FIELD_NUMBER = 10;
        public static final int RDMODULECOM_CRUISEVEHSPD_ST_FIELD_NUMBER = 26;
        public static final int RDMODULECOM_FUNCTION_MODE_FIELD_NUMBER = 25;
        public static final int RDMODULECOM_LATERALCTRL_FIELD_NUMBER = 15;
        public static final int RDMODULECOM_LCCMODE_FIELD_NUMBER = 22;
        public static final int RDMODULECOM_LKACTRL_FIELD_NUMBER = 8;
        public static final int RDMODULECOM_LKA_MODE_FIELD_NUMBER = 13;
        public static final int RDMODULECOM_LOCALIZATION_FIELD_NUMBER = 1;
        public static final int RDMODULECOM_LONGCTRL_FIELD_NUMBER = 14;
        public static final int RDMODULECOM_MOTIONPLANNING_FIELD_NUMBER = 4;
        public static final int RDMODULECOM_NGPFLAG_FIELD_NUMBER = 24;
        public static final int RDMODULECOM_NGPMODE_FIELD_NUMBER = 20;
        public static final int RDMODULECOM_REFERENCELINE_FIELD_NUMBER = 3;
        public static final int RDMODULECOM_SENSORFUSION_FIELD_NUMBER = 2;
        public static final int RDMODULECOM_STEERINGCTRL_FIELD_NUMBER = 16;
        public static final int RDMODULECOM_TURNSTATE_FIELD_NUMBER = 18;
        public static final int RDMODULECOM_ULCSTATE_FIELD_NUMBER = 29;
        public static final int RDMODULECOM_ULC_NEEDTOCOMFIRM_FIELD_NUMBER = 30;
        public static final int RDMODULECOM_ULC_TURNSTATE_FIELD_NUMBER = 28;
        public static final int RDMODULECOM_VLC_FIELD_NUMBER = 6;
        public static final int RDMODULECOM_WOS_FIELD_NUMBER = 17;
        public static final int RF_LINE_COLOR_FIELD_NUMBER = 44;
        public static final int SPARE_FIELD_NUMBER = 46;
        public static final int SR_DISPLAY_ST_FIELD_NUMBER = 43;
        public static final int XPU_SR_LCVIEW_FIELD_NUMBER = 45;
        public static final int XPU_SR_NGP_VIEW_FIELD_NUMBER = 27;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int bitField1_;
        private byte memoizedIsInitialized;
        private int rdmodulecom10State_;
        private int rdmodulecom11State_;
        private int rdmodulecom12State_;
        private int rdmodulecom13State_;
        private int rdmodulecom14State_;
        private int rdmodulecom15State_;
        private int rdmodulecom16State_;
        private int rdmodulecom17State_;
        private int rdmodulecom18State_;
        private int rdmodulecom19State_;
        private int rdmodulecom20State_;
        private int rdmodulecom9State_;
        private int rdmodulecomACCMode1_;
        private int rdmodulecomAccHold_;
        private int rdmodulecomAccctrl_;
        private int rdmodulecomAccmode_;
        private int rdmodulecomAlcmode_;
        private int rdmodulecomAlcstate_;
        private int rdmodulecomBehaviorplanning_;
        private int rdmodulecomCruiseLeverTHW_;
        private int rdmodulecomCruiseVehSpd_;
        private float rdmodulecomCruisevehSpdSt_;
        private int rdmodulecomFunctionMode_;
        private int rdmodulecomLKAMODE_;
        private int rdmodulecomLateralctrl_;
        private int rdmodulecomLccmode_;
        private int rdmodulecomLkactrl_;
        private int rdmodulecomLocalization_;
        private int rdmodulecomLongctrl_;
        private int rdmodulecomMotionplanning_;
        private int rdmodulecomNgpflag_;
        private int rdmodulecomNgpmode_;
        private int rdmodulecomReferenceline_;
        private int rdmodulecomSensorfusion_;
        private int rdmodulecomSteeringctrl_;
        private int rdmodulecomTurnstate_;
        private int rdmodulecomUlcNeedtocomfirm_;
        private int rdmodulecomUlcTurnstate_;
        private int rdmodulecomUlcstate_;
        private int rdmodulecomVlc_;
        private int rdmodulecomWos_;
        private int rfLineColor_;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private int srDisplaySt_;
        private int xPUSRLCView_;
        private int xPUSRNGPView_;

        private StateManagement(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private StateManagement() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.rdmodulecomLocalization_ = 0;
            this.rdmodulecomSensorfusion_ = 0;
            this.rdmodulecomReferenceline_ = 0;
            this.rdmodulecomMotionplanning_ = 0;
            this.rdmodulecomBehaviorplanning_ = 0;
            this.rdmodulecomVlc_ = 0;
            this.rdmodulecomAccctrl_ = 0;
            this.rdmodulecomLkactrl_ = 0;
            this.rdmodulecomCruiseLeverTHW_ = 0;
            this.rdmodulecomCruiseVehSpd_ = 0;
            this.rdmodulecomAccHold_ = 0;
            this.rdmodulecomACCMode1_ = 0;
            this.rdmodulecomLKAMODE_ = 0;
            this.rdmodulecomLongctrl_ = 0;
            this.rdmodulecomLateralctrl_ = 0;
            this.rdmodulecomSteeringctrl_ = 0;
            this.rdmodulecomWos_ = 0;
            this.rdmodulecomTurnstate_ = 0;
            this.rdmodulecomAlcstate_ = 0;
            this.rdmodulecomNgpmode_ = 0;
            this.rdmodulecomAlcmode_ = 0;
            this.rdmodulecomLccmode_ = 0;
            this.rdmodulecomAccmode_ = 0;
            this.rdmodulecomNgpflag_ = 0;
            this.rdmodulecomFunctionMode_ = 0;
            this.rdmodulecomCruisevehSpdSt_ = 0.0f;
            this.xPUSRNGPView_ = 0;
            this.rdmodulecomUlcTurnstate_ = 0;
            this.rdmodulecomUlcstate_ = 0;
            this.rdmodulecomUlcNeedtocomfirm_ = 0;
            this.rdmodulecom9State_ = 0;
            this.rdmodulecom10State_ = 0;
            this.rdmodulecom11State_ = 0;
            this.rdmodulecom12State_ = 0;
            this.rdmodulecom13State_ = 0;
            this.rdmodulecom14State_ = 0;
            this.rdmodulecom15State_ = 0;
            this.rdmodulecom16State_ = 0;
            this.rdmodulecom17State_ = 0;
            this.rdmodulecom18State_ = 0;
            this.rdmodulecom19State_ = 0;
            this.rdmodulecom20State_ = 0;
            this.srDisplaySt_ = 0;
            this.rfLineColor_ = 0;
            this.xPUSRLCView_ = 0;
            this.spare_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
        private StateManagement(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r3 = 8192;
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
                                this.rdmodulecomLocalization_ = codedInputStream.readInt32();
                                continue;
                            case 16:
                                this.rdmodulecomSensorfusion_ = codedInputStream.readInt32();
                                continue;
                            case 24:
                                this.rdmodulecomReferenceline_ = codedInputStream.readInt32();
                                continue;
                            case 32:
                                this.rdmodulecomMotionplanning_ = codedInputStream.readInt32();
                                continue;
                            case 40:
                                this.rdmodulecomBehaviorplanning_ = codedInputStream.readInt32();
                                continue;
                            case 48:
                                this.rdmodulecomVlc_ = codedInputStream.readInt32();
                                continue;
                            case 56:
                                this.rdmodulecomAccctrl_ = codedInputStream.readInt32();
                                continue;
                            case 64:
                                this.rdmodulecomLkactrl_ = codedInputStream.readInt32();
                                continue;
                            case 72:
                                this.rdmodulecomCruiseLeverTHW_ = codedInputStream.readInt32();
                                continue;
                            case 80:
                                this.rdmodulecomCruiseVehSpd_ = codedInputStream.readInt32();
                                continue;
                            case 88:
                                this.rdmodulecomAccHold_ = codedInputStream.readInt32();
                                continue;
                            case 96:
                                this.rdmodulecomACCMode1_ = codedInputStream.readInt32();
                                continue;
                            case 104:
                                this.rdmodulecomLKAMODE_ = codedInputStream.readInt32();
                                continue;
                            case 112:
                                this.rdmodulecomLongctrl_ = codedInputStream.readInt32();
                                continue;
                            case 120:
                                this.rdmodulecomLateralctrl_ = codedInputStream.readInt32();
                                continue;
                            case 128:
                                this.rdmodulecomSteeringctrl_ = codedInputStream.readInt32();
                                continue;
                            case 136:
                                this.rdmodulecomWos_ = codedInputStream.readInt32();
                                continue;
                            case 144:
                                this.rdmodulecomTurnstate_ = codedInputStream.readInt32();
                                continue;
                            case 152:
                                this.rdmodulecomAlcstate_ = codedInputStream.readInt32();
                                continue;
                            case 160:
                                this.rdmodulecomNgpmode_ = codedInputStream.readInt32();
                                continue;
                            case 168:
                                this.rdmodulecomAlcmode_ = codedInputStream.readInt32();
                                continue;
                            case Opcodes.ARETURN /* 176 */:
                                this.rdmodulecomLccmode_ = codedInputStream.readInt32();
                                continue;
                            case Opcodes.INVOKESTATIC /* 184 */:
                                this.rdmodulecomAccmode_ = codedInputStream.readInt32();
                                continue;
                            case 192:
                                this.rdmodulecomNgpflag_ = codedInputStream.readInt32();
                                continue;
                            case 200:
                                this.rdmodulecomFunctionMode_ = codedInputStream.readInt32();
                                continue;
                            case 213:
                                this.rdmodulecomCruisevehSpdSt_ = codedInputStream.readFloat();
                                continue;
                            case 216:
                                this.xPUSRNGPView_ = codedInputStream.readInt32();
                                continue;
                            case LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_HONKING /* 224 */:
                                this.rdmodulecomUlcTurnstate_ = codedInputStream.readInt32();
                                continue;
                            case LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING_AREA /* 232 */:
                                this.rdmodulecomUlcstate_ = codedInputStream.readInt32();
                                continue;
                            case RouteChargeDecorator.TYPE_SELECTED_KEEPER /* 240 */:
                                this.rdmodulecomUlcNeedtocomfirm_ = codedInputStream.readInt32();
                                continue;
                            case 248:
                                this.rdmodulecom9State_ = codedInputStream.readInt32();
                                continue;
                            case 256:
                                this.rdmodulecom10State_ = codedInputStream.readInt32();
                                continue;
                            case SearchResultCode.G_ERR_HMI_NULL /* 264 */:
                                this.rdmodulecom11State_ = codedInputStream.readInt32();
                                continue;
                            case 272:
                                this.rdmodulecom12State_ = codedInputStream.readInt32();
                                continue;
                            case 280:
                                this.rdmodulecom13State_ = codedInputStream.readInt32();
                                continue;
                            case MarkUtils.MARKER_ID_RECOMMEND_PARK_2 /* 288 */:
                                this.rdmodulecom14State_ = codedInputStream.readInt32();
                                continue;
                            case MarkUtils.MARKER_ID_TIE_1 /* 296 */:
                                this.rdmodulecom15State_ = codedInputStream.readInt32();
                                continue;
                            case 304:
                                this.rdmodulecom16State_ = codedInputStream.readInt32();
                                continue;
                            case 312:
                                this.rdmodulecom17State_ = codedInputStream.readInt32();
                                continue;
                            case 320:
                                this.rdmodulecom18State_ = codedInputStream.readInt32();
                                continue;
                            case LocTrafficSignType.LOC_TRAFFIC_SIGN_BUS_LANE /* 328 */:
                                this.rdmodulecom19State_ = codedInputStream.readInt32();
                                continue;
                            case LocTrafficSignType.LOC_TRAFFIC_SIGN_CARRIAGEWAY /* 336 */:
                                this.rdmodulecom20State_ = codedInputStream.readInt32();
                                continue;
                            case RegionCode.REGION_CODE_HKG /* 344 */:
                                this.srDisplaySt_ = codedInputStream.readInt32();
                                continue;
                            case 352:
                                this.rfLineColor_ = codedInputStream.readInt32();
                                continue;
                            case MarkUtils.MARKER_ID_BUBBLE_VIA_CHARGE /* 360 */:
                                this.xPUSRLCView_ = codedInputStream.readInt32();
                                continue;
                            case 370:
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.spare_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.spare_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit);
                                continue;
                                break;
                            case RouteControlKey.RouteControlKeySetTotalTime /* 373 */:
                                if (!(z2 & true)) {
                                    this.spare_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.spare_.add(Float.valueOf(codedInputStream.readFloat()));
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
                    if ((z2 & true) == r3) {
                        this.spare_ = Collections.unmodifiableList(this.spare_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Primitives.internal_static_xpilot_sr_proto_StateManagement_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_StateManagement_fieldAccessorTable.ensureFieldAccessorsInitialized(StateManagement.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomLocalization() {
            return this.rdmodulecomLocalization_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomSensorfusion() {
            return this.rdmodulecomSensorfusion_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomReferenceline() {
            return this.rdmodulecomReferenceline_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomMotionplanning() {
            return this.rdmodulecomMotionplanning_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomBehaviorplanning() {
            return this.rdmodulecomBehaviorplanning_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomVlc() {
            return this.rdmodulecomVlc_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomAccctrl() {
            return this.rdmodulecomAccctrl_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomLkactrl() {
            return this.rdmodulecomLkactrl_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomCruiseLeverTHW() {
            return this.rdmodulecomCruiseLeverTHW_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomCruiseVehSpd() {
            return this.rdmodulecomCruiseVehSpd_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomAccHold() {
            return this.rdmodulecomAccHold_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomACCMode1() {
            return this.rdmodulecomACCMode1_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomLKAMODE() {
            return this.rdmodulecomLKAMODE_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomLongctrl() {
            return this.rdmodulecomLongctrl_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomLateralctrl() {
            return this.rdmodulecomLateralctrl_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomSteeringctrl() {
            return this.rdmodulecomSteeringctrl_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomWos() {
            return this.rdmodulecomWos_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomTurnstate() {
            return this.rdmodulecomTurnstate_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomAlcstate() {
            return this.rdmodulecomAlcstate_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomNgpmode() {
            return this.rdmodulecomNgpmode_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomAlcmode() {
            return this.rdmodulecomAlcmode_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomLccmode() {
            return this.rdmodulecomLccmode_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomAccmode() {
            return this.rdmodulecomAccmode_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomNgpflag() {
            return this.rdmodulecomNgpflag_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomFunctionMode() {
            return this.rdmodulecomFunctionMode_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public float getRdmodulecomCruisevehSpdSt() {
            return this.rdmodulecomCruisevehSpdSt_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getXPUSRNGPView() {
            return this.xPUSRNGPView_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomUlcTurnstate() {
            return this.rdmodulecomUlcTurnstate_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomUlcstate() {
            return this.rdmodulecomUlcstate_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecomUlcNeedtocomfirm() {
            return this.rdmodulecomUlcNeedtocomfirm_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom9State() {
            return this.rdmodulecom9State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom10State() {
            return this.rdmodulecom10State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom11State() {
            return this.rdmodulecom11State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom12State() {
            return this.rdmodulecom12State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom13State() {
            return this.rdmodulecom13State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom14State() {
            return this.rdmodulecom14State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom15State() {
            return this.rdmodulecom15State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom16State() {
            return this.rdmodulecom16State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom17State() {
            return this.rdmodulecom17State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom18State() {
            return this.rdmodulecom18State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom19State() {
            return this.rdmodulecom19State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRdmodulecom20State() {
            return this.rdmodulecom20State_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getSrDisplaySt() {
            return this.srDisplaySt_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getRfLineColor() {
            return this.rfLineColor_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getXPUSRLCView() {
            return this.xPUSRLCView_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
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
            int i = this.rdmodulecomLocalization_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            int i2 = this.rdmodulecomSensorfusion_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            int i3 = this.rdmodulecomReferenceline_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
            int i4 = this.rdmodulecomMotionplanning_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(4, i4);
            }
            int i5 = this.rdmodulecomBehaviorplanning_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(5, i5);
            }
            int i6 = this.rdmodulecomVlc_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(6, i6);
            }
            int i7 = this.rdmodulecomAccctrl_;
            if (i7 != 0) {
                codedOutputStream.writeInt32(7, i7);
            }
            int i8 = this.rdmodulecomLkactrl_;
            if (i8 != 0) {
                codedOutputStream.writeInt32(8, i8);
            }
            int i9 = this.rdmodulecomCruiseLeverTHW_;
            if (i9 != 0) {
                codedOutputStream.writeInt32(9, i9);
            }
            int i10 = this.rdmodulecomCruiseVehSpd_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(10, i10);
            }
            int i11 = this.rdmodulecomAccHold_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(11, i11);
            }
            int i12 = this.rdmodulecomACCMode1_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(12, i12);
            }
            int i13 = this.rdmodulecomLKAMODE_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(13, i13);
            }
            int i14 = this.rdmodulecomLongctrl_;
            if (i14 != 0) {
                codedOutputStream.writeInt32(14, i14);
            }
            int i15 = this.rdmodulecomLateralctrl_;
            if (i15 != 0) {
                codedOutputStream.writeInt32(15, i15);
            }
            int i16 = this.rdmodulecomSteeringctrl_;
            if (i16 != 0) {
                codedOutputStream.writeInt32(16, i16);
            }
            int i17 = this.rdmodulecomWos_;
            if (i17 != 0) {
                codedOutputStream.writeInt32(17, i17);
            }
            int i18 = this.rdmodulecomTurnstate_;
            if (i18 != 0) {
                codedOutputStream.writeInt32(18, i18);
            }
            int i19 = this.rdmodulecomAlcstate_;
            if (i19 != 0) {
                codedOutputStream.writeInt32(19, i19);
            }
            int i20 = this.rdmodulecomNgpmode_;
            if (i20 != 0) {
                codedOutputStream.writeInt32(20, i20);
            }
            int i21 = this.rdmodulecomAlcmode_;
            if (i21 != 0) {
                codedOutputStream.writeInt32(21, i21);
            }
            int i22 = this.rdmodulecomLccmode_;
            if (i22 != 0) {
                codedOutputStream.writeInt32(22, i22);
            }
            int i23 = this.rdmodulecomAccmode_;
            if (i23 != 0) {
                codedOutputStream.writeInt32(23, i23);
            }
            int i24 = this.rdmodulecomNgpflag_;
            if (i24 != 0) {
                codedOutputStream.writeInt32(24, i24);
            }
            int i25 = this.rdmodulecomFunctionMode_;
            if (i25 != 0) {
                codedOutputStream.writeInt32(25, i25);
            }
            float f = this.rdmodulecomCruisevehSpdSt_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(26, f);
            }
            int i26 = this.xPUSRNGPView_;
            if (i26 != 0) {
                codedOutputStream.writeInt32(27, i26);
            }
            int i27 = this.rdmodulecomUlcTurnstate_;
            if (i27 != 0) {
                codedOutputStream.writeInt32(28, i27);
            }
            int i28 = this.rdmodulecomUlcstate_;
            if (i28 != 0) {
                codedOutputStream.writeInt32(29, i28);
            }
            int i29 = this.rdmodulecomUlcNeedtocomfirm_;
            if (i29 != 0) {
                codedOutputStream.writeInt32(30, i29);
            }
            int i30 = this.rdmodulecom9State_;
            if (i30 != 0) {
                codedOutputStream.writeInt32(31, i30);
            }
            int i31 = this.rdmodulecom10State_;
            if (i31 != 0) {
                codedOutputStream.writeInt32(32, i31);
            }
            int i32 = this.rdmodulecom11State_;
            if (i32 != 0) {
                codedOutputStream.writeInt32(33, i32);
            }
            int i33 = this.rdmodulecom12State_;
            if (i33 != 0) {
                codedOutputStream.writeInt32(34, i33);
            }
            int i34 = this.rdmodulecom13State_;
            if (i34 != 0) {
                codedOutputStream.writeInt32(35, i34);
            }
            int i35 = this.rdmodulecom14State_;
            if (i35 != 0) {
                codedOutputStream.writeInt32(36, i35);
            }
            int i36 = this.rdmodulecom15State_;
            if (i36 != 0) {
                codedOutputStream.writeInt32(37, i36);
            }
            int i37 = this.rdmodulecom16State_;
            if (i37 != 0) {
                codedOutputStream.writeInt32(38, i37);
            }
            int i38 = this.rdmodulecom17State_;
            if (i38 != 0) {
                codedOutputStream.writeInt32(39, i38);
            }
            int i39 = this.rdmodulecom18State_;
            if (i39 != 0) {
                codedOutputStream.writeInt32(40, i39);
            }
            int i40 = this.rdmodulecom19State_;
            if (i40 != 0) {
                codedOutputStream.writeInt32(41, i40);
            }
            int i41 = this.rdmodulecom20State_;
            if (i41 != 0) {
                codedOutputStream.writeInt32(42, i41);
            }
            int i42 = this.srDisplaySt_;
            if (i42 != 0) {
                codedOutputStream.writeInt32(43, i42);
            }
            int i43 = this.rfLineColor_;
            if (i43 != 0) {
                codedOutputStream.writeInt32(44, i43);
            }
            int i44 = this.xPUSRLCView_;
            if (i44 != 0) {
                codedOutputStream.writeInt32(45, i44);
            }
            if (getSpareList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(370);
                codedOutputStream.writeUInt32NoTag(this.spareMemoizedSerializedSize);
            }
            for (int i45 = 0; i45 < this.spare_.size(); i45++) {
                codedOutputStream.writeFloatNoTag(this.spare_.get(i45).floatValue());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.rdmodulecomLocalization_;
            int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.rdmodulecomSensorfusion_;
            if (i3 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.rdmodulecomReferenceline_;
            if (i4 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
            }
            int i5 = this.rdmodulecomMotionplanning_;
            if (i5 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, i5);
            }
            int i6 = this.rdmodulecomBehaviorplanning_;
            if (i6 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, i6);
            }
            int i7 = this.rdmodulecomVlc_;
            if (i7 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, i7);
            }
            int i8 = this.rdmodulecomAccctrl_;
            if (i8 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, i8);
            }
            int i9 = this.rdmodulecomLkactrl_;
            if (i9 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, i9);
            }
            int i10 = this.rdmodulecomCruiseLeverTHW_;
            if (i10 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, i10);
            }
            int i11 = this.rdmodulecomCruiseVehSpd_;
            if (i11 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(10, i11);
            }
            int i12 = this.rdmodulecomAccHold_;
            if (i12 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, i12);
            }
            int i13 = this.rdmodulecomACCMode1_;
            if (i13 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(12, i13);
            }
            int i14 = this.rdmodulecomLKAMODE_;
            if (i14 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(13, i14);
            }
            int i15 = this.rdmodulecomLongctrl_;
            if (i15 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(14, i15);
            }
            int i16 = this.rdmodulecomLateralctrl_;
            if (i16 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(15, i16);
            }
            int i17 = this.rdmodulecomSteeringctrl_;
            if (i17 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(16, i17);
            }
            int i18 = this.rdmodulecomWos_;
            if (i18 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(17, i18);
            }
            int i19 = this.rdmodulecomTurnstate_;
            if (i19 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(18, i19);
            }
            int i20 = this.rdmodulecomAlcstate_;
            if (i20 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(19, i20);
            }
            int i21 = this.rdmodulecomNgpmode_;
            if (i21 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(20, i21);
            }
            int i22 = this.rdmodulecomAlcmode_;
            if (i22 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(21, i22);
            }
            int i23 = this.rdmodulecomLccmode_;
            if (i23 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(22, i23);
            }
            int i24 = this.rdmodulecomAccmode_;
            if (i24 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(23, i24);
            }
            int i25 = this.rdmodulecomNgpflag_;
            if (i25 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(24, i25);
            }
            int i26 = this.rdmodulecomFunctionMode_;
            if (i26 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(25, i26);
            }
            float f = this.rdmodulecomCruisevehSpdSt_;
            if (f != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(26, f);
            }
            int i27 = this.xPUSRNGPView_;
            if (i27 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(27, i27);
            }
            int i28 = this.rdmodulecomUlcTurnstate_;
            if (i28 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(28, i28);
            }
            int i29 = this.rdmodulecomUlcstate_;
            if (i29 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(29, i29);
            }
            int i30 = this.rdmodulecomUlcNeedtocomfirm_;
            if (i30 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(30, i30);
            }
            int i31 = this.rdmodulecom9State_;
            if (i31 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(31, i31);
            }
            int i32 = this.rdmodulecom10State_;
            if (i32 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(32, i32);
            }
            int i33 = this.rdmodulecom11State_;
            if (i33 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(33, i33);
            }
            int i34 = this.rdmodulecom12State_;
            if (i34 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(34, i34);
            }
            int i35 = this.rdmodulecom13State_;
            if (i35 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(35, i35);
            }
            int i36 = this.rdmodulecom14State_;
            if (i36 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(36, i36);
            }
            int i37 = this.rdmodulecom15State_;
            if (i37 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(37, i37);
            }
            int i38 = this.rdmodulecom16State_;
            if (i38 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(38, i38);
            }
            int i39 = this.rdmodulecom17State_;
            if (i39 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(39, i39);
            }
            int i40 = this.rdmodulecom18State_;
            if (i40 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(40, i40);
            }
            int i41 = this.rdmodulecom19State_;
            if (i41 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(41, i41);
            }
            int i42 = this.rdmodulecom20State_;
            if (i42 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(42, i42);
            }
            int i43 = this.srDisplaySt_;
            if (i43 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(43, i43);
            }
            int i44 = this.rfLineColor_;
            if (i44 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(44, i44);
            }
            int i45 = this.xPUSRLCView_;
            if (i45 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(45, i45);
            }
            int size = getSpareList().size() * 4;
            int i46 = computeInt32Size + size;
            if (!getSpareList().isEmpty()) {
                i46 = i46 + 2 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.spareMemoizedSerializedSize = size;
            int serializedSize = i46 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof StateManagement)) {
                return super.equals(obj);
            }
            StateManagement stateManagement = (StateManagement) obj;
            return ((((((((((((((((((((((((((((((((((((((((((((((getRdmodulecomLocalization() == stateManagement.getRdmodulecomLocalization()) && getRdmodulecomSensorfusion() == stateManagement.getRdmodulecomSensorfusion()) && getRdmodulecomReferenceline() == stateManagement.getRdmodulecomReferenceline()) && getRdmodulecomMotionplanning() == stateManagement.getRdmodulecomMotionplanning()) && getRdmodulecomBehaviorplanning() == stateManagement.getRdmodulecomBehaviorplanning()) && getRdmodulecomVlc() == stateManagement.getRdmodulecomVlc()) && getRdmodulecomAccctrl() == stateManagement.getRdmodulecomAccctrl()) && getRdmodulecomLkactrl() == stateManagement.getRdmodulecomLkactrl()) && getRdmodulecomCruiseLeverTHW() == stateManagement.getRdmodulecomCruiseLeverTHW()) && getRdmodulecomCruiseVehSpd() == stateManagement.getRdmodulecomCruiseVehSpd()) && getRdmodulecomAccHold() == stateManagement.getRdmodulecomAccHold()) && getRdmodulecomACCMode1() == stateManagement.getRdmodulecomACCMode1()) && getRdmodulecomLKAMODE() == stateManagement.getRdmodulecomLKAMODE()) && getRdmodulecomLongctrl() == stateManagement.getRdmodulecomLongctrl()) && getRdmodulecomLateralctrl() == stateManagement.getRdmodulecomLateralctrl()) && getRdmodulecomSteeringctrl() == stateManagement.getRdmodulecomSteeringctrl()) && getRdmodulecomWos() == stateManagement.getRdmodulecomWos()) && getRdmodulecomTurnstate() == stateManagement.getRdmodulecomTurnstate()) && getRdmodulecomAlcstate() == stateManagement.getRdmodulecomAlcstate()) && getRdmodulecomNgpmode() == stateManagement.getRdmodulecomNgpmode()) && getRdmodulecomAlcmode() == stateManagement.getRdmodulecomAlcmode()) && getRdmodulecomLccmode() == stateManagement.getRdmodulecomLccmode()) && getRdmodulecomAccmode() == stateManagement.getRdmodulecomAccmode()) && getRdmodulecomNgpflag() == stateManagement.getRdmodulecomNgpflag()) && getRdmodulecomFunctionMode() == stateManagement.getRdmodulecomFunctionMode()) && Float.floatToIntBits(getRdmodulecomCruisevehSpdSt()) == Float.floatToIntBits(stateManagement.getRdmodulecomCruisevehSpdSt())) && getXPUSRNGPView() == stateManagement.getXPUSRNGPView()) && getRdmodulecomUlcTurnstate() == stateManagement.getRdmodulecomUlcTurnstate()) && getRdmodulecomUlcstate() == stateManagement.getRdmodulecomUlcstate()) && getRdmodulecomUlcNeedtocomfirm() == stateManagement.getRdmodulecomUlcNeedtocomfirm()) && getRdmodulecom9State() == stateManagement.getRdmodulecom9State()) && getRdmodulecom10State() == stateManagement.getRdmodulecom10State()) && getRdmodulecom11State() == stateManagement.getRdmodulecom11State()) && getRdmodulecom12State() == stateManagement.getRdmodulecom12State()) && getRdmodulecom13State() == stateManagement.getRdmodulecom13State()) && getRdmodulecom14State() == stateManagement.getRdmodulecom14State()) && getRdmodulecom15State() == stateManagement.getRdmodulecom15State()) && getRdmodulecom16State() == stateManagement.getRdmodulecom16State()) && getRdmodulecom17State() == stateManagement.getRdmodulecom17State()) && getRdmodulecom18State() == stateManagement.getRdmodulecom18State()) && getRdmodulecom19State() == stateManagement.getRdmodulecom19State()) && getRdmodulecom20State() == stateManagement.getRdmodulecom20State()) && getSrDisplaySt() == stateManagement.getSrDisplaySt()) && getRfLineColor() == stateManagement.getRfLineColor()) && getXPUSRLCView() == stateManagement.getXPUSRLCView()) && getSpareList().equals(stateManagement.getSpareList())) && this.unknownFields.equals(stateManagement.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getRdmodulecomLocalization()) * 37) + 2) * 53) + getRdmodulecomSensorfusion()) * 37) + 3) * 53) + getRdmodulecomReferenceline()) * 37) + 4) * 53) + getRdmodulecomMotionplanning()) * 37) + 5) * 53) + getRdmodulecomBehaviorplanning()) * 37) + 6) * 53) + getRdmodulecomVlc()) * 37) + 7) * 53) + getRdmodulecomAccctrl()) * 37) + 8) * 53) + getRdmodulecomLkactrl()) * 37) + 9) * 53) + getRdmodulecomCruiseLeverTHW()) * 37) + 10) * 53) + getRdmodulecomCruiseVehSpd()) * 37) + 11) * 53) + getRdmodulecomAccHold()) * 37) + 12) * 53) + getRdmodulecomACCMode1()) * 37) + 13) * 53) + getRdmodulecomLKAMODE()) * 37) + 14) * 53) + getRdmodulecomLongctrl()) * 37) + 15) * 53) + getRdmodulecomLateralctrl()) * 37) + 16) * 53) + getRdmodulecomSteeringctrl()) * 37) + 17) * 53) + getRdmodulecomWos()) * 37) + 18) * 53) + getRdmodulecomTurnstate()) * 37) + 19) * 53) + getRdmodulecomAlcstate()) * 37) + 20) * 53) + getRdmodulecomNgpmode()) * 37) + 21) * 53) + getRdmodulecomAlcmode()) * 37) + 22) * 53) + getRdmodulecomLccmode()) * 37) + 23) * 53) + getRdmodulecomAccmode()) * 37) + 24) * 53) + getRdmodulecomNgpflag()) * 37) + 25) * 53) + getRdmodulecomFunctionMode()) * 37) + 26) * 53) + Float.floatToIntBits(getRdmodulecomCruisevehSpdSt())) * 37) + 27) * 53) + getXPUSRNGPView()) * 37) + 28) * 53) + getRdmodulecomUlcTurnstate()) * 37) + 29) * 53) + getRdmodulecomUlcstate()) * 37) + 30) * 53) + getRdmodulecomUlcNeedtocomfirm()) * 37) + 31) * 53) + getRdmodulecom9State()) * 37) + 32) * 53) + getRdmodulecom10State()) * 37) + 33) * 53) + getRdmodulecom11State()) * 37) + 34) * 53) + getRdmodulecom12State()) * 37) + 35) * 53) + getRdmodulecom13State()) * 37) + 36) * 53) + getRdmodulecom14State()) * 37) + 37) * 53) + getRdmodulecom15State()) * 37) + 38) * 53) + getRdmodulecom16State()) * 37) + 39) * 53) + getRdmodulecom17State()) * 37) + 40) * 53) + getRdmodulecom18State()) * 37) + 41) * 53) + getRdmodulecom19State()) * 37) + 42) * 53) + getRdmodulecom20State()) * 37) + 43) * 53) + getSrDisplaySt()) * 37) + 44) * 53) + getRfLineColor()) * 37) + 45) * 53) + getXPUSRLCView();
            if (getSpareCount() > 0) {
                hashCode = (((hashCode * 37) + 46) * 53) + getSpareList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static StateManagement parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static StateManagement parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static StateManagement parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static StateManagement parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static StateManagement parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static StateManagement parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static StateManagement parseFrom(InputStream inputStream) throws IOException {
            return (StateManagement) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static StateManagement parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StateManagement) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StateManagement parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StateManagement) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static StateManagement parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StateManagement) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static StateManagement parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StateManagement) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static StateManagement parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StateManagement) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StateManagement stateManagement) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(stateManagement);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StateManagementOrBuilder {
            private int bitField0_;
            private int bitField1_;
            private int rdmodulecom10State_;
            private int rdmodulecom11State_;
            private int rdmodulecom12State_;
            private int rdmodulecom13State_;
            private int rdmodulecom14State_;
            private int rdmodulecom15State_;
            private int rdmodulecom16State_;
            private int rdmodulecom17State_;
            private int rdmodulecom18State_;
            private int rdmodulecom19State_;
            private int rdmodulecom20State_;
            private int rdmodulecom9State_;
            private int rdmodulecomACCMode1_;
            private int rdmodulecomAccHold_;
            private int rdmodulecomAccctrl_;
            private int rdmodulecomAccmode_;
            private int rdmodulecomAlcmode_;
            private int rdmodulecomAlcstate_;
            private int rdmodulecomBehaviorplanning_;
            private int rdmodulecomCruiseLeverTHW_;
            private int rdmodulecomCruiseVehSpd_;
            private float rdmodulecomCruisevehSpdSt_;
            private int rdmodulecomFunctionMode_;
            private int rdmodulecomLKAMODE_;
            private int rdmodulecomLateralctrl_;
            private int rdmodulecomLccmode_;
            private int rdmodulecomLkactrl_;
            private int rdmodulecomLocalization_;
            private int rdmodulecomLongctrl_;
            private int rdmodulecomMotionplanning_;
            private int rdmodulecomNgpflag_;
            private int rdmodulecomNgpmode_;
            private int rdmodulecomReferenceline_;
            private int rdmodulecomSensorfusion_;
            private int rdmodulecomSteeringctrl_;
            private int rdmodulecomTurnstate_;
            private int rdmodulecomUlcNeedtocomfirm_;
            private int rdmodulecomUlcTurnstate_;
            private int rdmodulecomUlcstate_;
            private int rdmodulecomVlc_;
            private int rdmodulecomWos_;
            private int rfLineColor_;
            private List<Float> spare_;
            private int srDisplaySt_;
            private int xPUSRLCView_;
            private int xPUSRNGPView_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_StateManagement_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_StateManagement_fieldAccessorTable.ensureFieldAccessorsInitialized(StateManagement.class, Builder.class);
            }

            private Builder() {
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = StateManagement.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.rdmodulecomLocalization_ = 0;
                this.rdmodulecomSensorfusion_ = 0;
                this.rdmodulecomReferenceline_ = 0;
                this.rdmodulecomMotionplanning_ = 0;
                this.rdmodulecomBehaviorplanning_ = 0;
                this.rdmodulecomVlc_ = 0;
                this.rdmodulecomAccctrl_ = 0;
                this.rdmodulecomLkactrl_ = 0;
                this.rdmodulecomCruiseLeverTHW_ = 0;
                this.rdmodulecomCruiseVehSpd_ = 0;
                this.rdmodulecomAccHold_ = 0;
                this.rdmodulecomACCMode1_ = 0;
                this.rdmodulecomLKAMODE_ = 0;
                this.rdmodulecomLongctrl_ = 0;
                this.rdmodulecomLateralctrl_ = 0;
                this.rdmodulecomSteeringctrl_ = 0;
                this.rdmodulecomWos_ = 0;
                this.rdmodulecomTurnstate_ = 0;
                this.rdmodulecomAlcstate_ = 0;
                this.rdmodulecomNgpmode_ = 0;
                this.rdmodulecomAlcmode_ = 0;
                this.rdmodulecomLccmode_ = 0;
                this.rdmodulecomAccmode_ = 0;
                this.rdmodulecomNgpflag_ = 0;
                this.rdmodulecomFunctionMode_ = 0;
                this.rdmodulecomCruisevehSpdSt_ = 0.0f;
                this.xPUSRNGPView_ = 0;
                this.rdmodulecomUlcTurnstate_ = 0;
                this.rdmodulecomUlcstate_ = 0;
                this.rdmodulecomUlcNeedtocomfirm_ = 0;
                this.rdmodulecom9State_ = 0;
                this.rdmodulecom10State_ = 0;
                this.rdmodulecom11State_ = 0;
                this.rdmodulecom12State_ = 0;
                this.rdmodulecom13State_ = 0;
                this.rdmodulecom14State_ = 0;
                this.rdmodulecom15State_ = 0;
                this.rdmodulecom16State_ = 0;
                this.rdmodulecom17State_ = 0;
                this.rdmodulecom18State_ = 0;
                this.rdmodulecom19State_ = 0;
                this.rdmodulecom20State_ = 0;
                this.srDisplaySt_ = 0;
                this.rfLineColor_ = 0;
                this.xPUSRLCView_ = 0;
                this.spare_ = Collections.emptyList();
                this.bitField1_ &= -8193;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_StateManagement_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StateManagement getDefaultInstanceForType() {
                return StateManagement.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StateManagement build() {
                StateManagement buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StateManagement buildPartial() {
                StateManagement stateManagement = new StateManagement(this);
                int i = this.bitField0_;
                int i2 = this.bitField1_;
                stateManagement.rdmodulecomLocalization_ = this.rdmodulecomLocalization_;
                stateManagement.rdmodulecomSensorfusion_ = this.rdmodulecomSensorfusion_;
                stateManagement.rdmodulecomReferenceline_ = this.rdmodulecomReferenceline_;
                stateManagement.rdmodulecomMotionplanning_ = this.rdmodulecomMotionplanning_;
                stateManagement.rdmodulecomBehaviorplanning_ = this.rdmodulecomBehaviorplanning_;
                stateManagement.rdmodulecomVlc_ = this.rdmodulecomVlc_;
                stateManagement.rdmodulecomAccctrl_ = this.rdmodulecomAccctrl_;
                stateManagement.rdmodulecomLkactrl_ = this.rdmodulecomLkactrl_;
                stateManagement.rdmodulecomCruiseLeverTHW_ = this.rdmodulecomCruiseLeverTHW_;
                stateManagement.rdmodulecomCruiseVehSpd_ = this.rdmodulecomCruiseVehSpd_;
                stateManagement.rdmodulecomAccHold_ = this.rdmodulecomAccHold_;
                stateManagement.rdmodulecomACCMode1_ = this.rdmodulecomACCMode1_;
                stateManagement.rdmodulecomLKAMODE_ = this.rdmodulecomLKAMODE_;
                stateManagement.rdmodulecomLongctrl_ = this.rdmodulecomLongctrl_;
                stateManagement.rdmodulecomLateralctrl_ = this.rdmodulecomLateralctrl_;
                stateManagement.rdmodulecomSteeringctrl_ = this.rdmodulecomSteeringctrl_;
                stateManagement.rdmodulecomWos_ = this.rdmodulecomWos_;
                stateManagement.rdmodulecomTurnstate_ = this.rdmodulecomTurnstate_;
                stateManagement.rdmodulecomAlcstate_ = this.rdmodulecomAlcstate_;
                stateManagement.rdmodulecomNgpmode_ = this.rdmodulecomNgpmode_;
                stateManagement.rdmodulecomAlcmode_ = this.rdmodulecomAlcmode_;
                stateManagement.rdmodulecomLccmode_ = this.rdmodulecomLccmode_;
                stateManagement.rdmodulecomAccmode_ = this.rdmodulecomAccmode_;
                stateManagement.rdmodulecomNgpflag_ = this.rdmodulecomNgpflag_;
                stateManagement.rdmodulecomFunctionMode_ = this.rdmodulecomFunctionMode_;
                stateManagement.rdmodulecomCruisevehSpdSt_ = this.rdmodulecomCruisevehSpdSt_;
                stateManagement.xPUSRNGPView_ = this.xPUSRNGPView_;
                stateManagement.rdmodulecomUlcTurnstate_ = this.rdmodulecomUlcTurnstate_;
                stateManagement.rdmodulecomUlcstate_ = this.rdmodulecomUlcstate_;
                stateManagement.rdmodulecomUlcNeedtocomfirm_ = this.rdmodulecomUlcNeedtocomfirm_;
                stateManagement.rdmodulecom9State_ = this.rdmodulecom9State_;
                stateManagement.rdmodulecom10State_ = this.rdmodulecom10State_;
                stateManagement.rdmodulecom11State_ = this.rdmodulecom11State_;
                stateManagement.rdmodulecom12State_ = this.rdmodulecom12State_;
                stateManagement.rdmodulecom13State_ = this.rdmodulecom13State_;
                stateManagement.rdmodulecom14State_ = this.rdmodulecom14State_;
                stateManagement.rdmodulecom15State_ = this.rdmodulecom15State_;
                stateManagement.rdmodulecom16State_ = this.rdmodulecom16State_;
                stateManagement.rdmodulecom17State_ = this.rdmodulecom17State_;
                stateManagement.rdmodulecom18State_ = this.rdmodulecom18State_;
                stateManagement.rdmodulecom19State_ = this.rdmodulecom19State_;
                stateManagement.rdmodulecom20State_ = this.rdmodulecom20State_;
                stateManagement.srDisplaySt_ = this.srDisplaySt_;
                stateManagement.rfLineColor_ = this.rfLineColor_;
                stateManagement.xPUSRLCView_ = this.xPUSRLCView_;
                if ((this.bitField1_ & 8192) == 8192) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField1_ &= -8193;
                }
                stateManagement.spare_ = this.spare_;
                stateManagement.bitField0_ = 0;
                stateManagement.bitField1_ = 0;
                onBuilt();
                return stateManagement;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof StateManagement) {
                    return mergeFrom((StateManagement) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(StateManagement stateManagement) {
                if (stateManagement == StateManagement.getDefaultInstance()) {
                    return this;
                }
                if (stateManagement.getRdmodulecomLocalization() != 0) {
                    setRdmodulecomLocalization(stateManagement.getRdmodulecomLocalization());
                }
                if (stateManagement.getRdmodulecomSensorfusion() != 0) {
                    setRdmodulecomSensorfusion(stateManagement.getRdmodulecomSensorfusion());
                }
                if (stateManagement.getRdmodulecomReferenceline() != 0) {
                    setRdmodulecomReferenceline(stateManagement.getRdmodulecomReferenceline());
                }
                if (stateManagement.getRdmodulecomMotionplanning() != 0) {
                    setRdmodulecomMotionplanning(stateManagement.getRdmodulecomMotionplanning());
                }
                if (stateManagement.getRdmodulecomBehaviorplanning() != 0) {
                    setRdmodulecomBehaviorplanning(stateManagement.getRdmodulecomBehaviorplanning());
                }
                if (stateManagement.getRdmodulecomVlc() != 0) {
                    setRdmodulecomVlc(stateManagement.getRdmodulecomVlc());
                }
                if (stateManagement.getRdmodulecomAccctrl() != 0) {
                    setRdmodulecomAccctrl(stateManagement.getRdmodulecomAccctrl());
                }
                if (stateManagement.getRdmodulecomLkactrl() != 0) {
                    setRdmodulecomLkactrl(stateManagement.getRdmodulecomLkactrl());
                }
                if (stateManagement.getRdmodulecomCruiseLeverTHW() != 0) {
                    setRdmodulecomCruiseLeverTHW(stateManagement.getRdmodulecomCruiseLeverTHW());
                }
                if (stateManagement.getRdmodulecomCruiseVehSpd() != 0) {
                    setRdmodulecomCruiseVehSpd(stateManagement.getRdmodulecomCruiseVehSpd());
                }
                if (stateManagement.getRdmodulecomAccHold() != 0) {
                    setRdmodulecomAccHold(stateManagement.getRdmodulecomAccHold());
                }
                if (stateManagement.getRdmodulecomACCMode1() != 0) {
                    setRdmodulecomACCMode1(stateManagement.getRdmodulecomACCMode1());
                }
                if (stateManagement.getRdmodulecomLKAMODE() != 0) {
                    setRdmodulecomLKAMODE(stateManagement.getRdmodulecomLKAMODE());
                }
                if (stateManagement.getRdmodulecomLongctrl() != 0) {
                    setRdmodulecomLongctrl(stateManagement.getRdmodulecomLongctrl());
                }
                if (stateManagement.getRdmodulecomLateralctrl() != 0) {
                    setRdmodulecomLateralctrl(stateManagement.getRdmodulecomLateralctrl());
                }
                if (stateManagement.getRdmodulecomSteeringctrl() != 0) {
                    setRdmodulecomSteeringctrl(stateManagement.getRdmodulecomSteeringctrl());
                }
                if (stateManagement.getRdmodulecomWos() != 0) {
                    setRdmodulecomWos(stateManagement.getRdmodulecomWos());
                }
                if (stateManagement.getRdmodulecomTurnstate() != 0) {
                    setRdmodulecomTurnstate(stateManagement.getRdmodulecomTurnstate());
                }
                if (stateManagement.getRdmodulecomAlcstate() != 0) {
                    setRdmodulecomAlcstate(stateManagement.getRdmodulecomAlcstate());
                }
                if (stateManagement.getRdmodulecomNgpmode() != 0) {
                    setRdmodulecomNgpmode(stateManagement.getRdmodulecomNgpmode());
                }
                if (stateManagement.getRdmodulecomAlcmode() != 0) {
                    setRdmodulecomAlcmode(stateManagement.getRdmodulecomAlcmode());
                }
                if (stateManagement.getRdmodulecomLccmode() != 0) {
                    setRdmodulecomLccmode(stateManagement.getRdmodulecomLccmode());
                }
                if (stateManagement.getRdmodulecomAccmode() != 0) {
                    setRdmodulecomAccmode(stateManagement.getRdmodulecomAccmode());
                }
                if (stateManagement.getRdmodulecomNgpflag() != 0) {
                    setRdmodulecomNgpflag(stateManagement.getRdmodulecomNgpflag());
                }
                if (stateManagement.getRdmodulecomFunctionMode() != 0) {
                    setRdmodulecomFunctionMode(stateManagement.getRdmodulecomFunctionMode());
                }
                if (stateManagement.getRdmodulecomCruisevehSpdSt() != 0.0f) {
                    setRdmodulecomCruisevehSpdSt(stateManagement.getRdmodulecomCruisevehSpdSt());
                }
                if (stateManagement.getXPUSRNGPView() != 0) {
                    setXPUSRNGPView(stateManagement.getXPUSRNGPView());
                }
                if (stateManagement.getRdmodulecomUlcTurnstate() != 0) {
                    setRdmodulecomUlcTurnstate(stateManagement.getRdmodulecomUlcTurnstate());
                }
                if (stateManagement.getRdmodulecomUlcstate() != 0) {
                    setRdmodulecomUlcstate(stateManagement.getRdmodulecomUlcstate());
                }
                if (stateManagement.getRdmodulecomUlcNeedtocomfirm() != 0) {
                    setRdmodulecomUlcNeedtocomfirm(stateManagement.getRdmodulecomUlcNeedtocomfirm());
                }
                if (stateManagement.getRdmodulecom9State() != 0) {
                    setRdmodulecom9State(stateManagement.getRdmodulecom9State());
                }
                if (stateManagement.getRdmodulecom10State() != 0) {
                    setRdmodulecom10State(stateManagement.getRdmodulecom10State());
                }
                if (stateManagement.getRdmodulecom11State() != 0) {
                    setRdmodulecom11State(stateManagement.getRdmodulecom11State());
                }
                if (stateManagement.getRdmodulecom12State() != 0) {
                    setRdmodulecom12State(stateManagement.getRdmodulecom12State());
                }
                if (stateManagement.getRdmodulecom13State() != 0) {
                    setRdmodulecom13State(stateManagement.getRdmodulecom13State());
                }
                if (stateManagement.getRdmodulecom14State() != 0) {
                    setRdmodulecom14State(stateManagement.getRdmodulecom14State());
                }
                if (stateManagement.getRdmodulecom15State() != 0) {
                    setRdmodulecom15State(stateManagement.getRdmodulecom15State());
                }
                if (stateManagement.getRdmodulecom16State() != 0) {
                    setRdmodulecom16State(stateManagement.getRdmodulecom16State());
                }
                if (stateManagement.getRdmodulecom17State() != 0) {
                    setRdmodulecom17State(stateManagement.getRdmodulecom17State());
                }
                if (stateManagement.getRdmodulecom18State() != 0) {
                    setRdmodulecom18State(stateManagement.getRdmodulecom18State());
                }
                if (stateManagement.getRdmodulecom19State() != 0) {
                    setRdmodulecom19State(stateManagement.getRdmodulecom19State());
                }
                if (stateManagement.getRdmodulecom20State() != 0) {
                    setRdmodulecom20State(stateManagement.getRdmodulecom20State());
                }
                if (stateManagement.getSrDisplaySt() != 0) {
                    setSrDisplaySt(stateManagement.getSrDisplaySt());
                }
                if (stateManagement.getRfLineColor() != 0) {
                    setRfLineColor(stateManagement.getRfLineColor());
                }
                if (stateManagement.getXPUSRLCView() != 0) {
                    setXPUSRLCView(stateManagement.getXPUSRLCView());
                }
                if (!stateManagement.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = stateManagement.spare_;
                        this.bitField1_ &= -8193;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(stateManagement.spare_);
                    }
                    onChanged();
                }
                mergeUnknownFields(stateManagement.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.StateManagement.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.StateManagement.access$26400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$StateManagement r3 = (xpilot.sr.proto.Primitives.StateManagement) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$StateManagement r4 = (xpilot.sr.proto.Primitives.StateManagement) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.StateManagement.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$StateManagement$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomLocalization() {
                return this.rdmodulecomLocalization_;
            }

            public Builder setRdmodulecomLocalization(int i) {
                this.rdmodulecomLocalization_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomLocalization() {
                this.rdmodulecomLocalization_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomSensorfusion() {
                return this.rdmodulecomSensorfusion_;
            }

            public Builder setRdmodulecomSensorfusion(int i) {
                this.rdmodulecomSensorfusion_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomSensorfusion() {
                this.rdmodulecomSensorfusion_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomReferenceline() {
                return this.rdmodulecomReferenceline_;
            }

            public Builder setRdmodulecomReferenceline(int i) {
                this.rdmodulecomReferenceline_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomReferenceline() {
                this.rdmodulecomReferenceline_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomMotionplanning() {
                return this.rdmodulecomMotionplanning_;
            }

            public Builder setRdmodulecomMotionplanning(int i) {
                this.rdmodulecomMotionplanning_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomMotionplanning() {
                this.rdmodulecomMotionplanning_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomBehaviorplanning() {
                return this.rdmodulecomBehaviorplanning_;
            }

            public Builder setRdmodulecomBehaviorplanning(int i) {
                this.rdmodulecomBehaviorplanning_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomBehaviorplanning() {
                this.rdmodulecomBehaviorplanning_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomVlc() {
                return this.rdmodulecomVlc_;
            }

            public Builder setRdmodulecomVlc(int i) {
                this.rdmodulecomVlc_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomVlc() {
                this.rdmodulecomVlc_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomAccctrl() {
                return this.rdmodulecomAccctrl_;
            }

            public Builder setRdmodulecomAccctrl(int i) {
                this.rdmodulecomAccctrl_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomAccctrl() {
                this.rdmodulecomAccctrl_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomLkactrl() {
                return this.rdmodulecomLkactrl_;
            }

            public Builder setRdmodulecomLkactrl(int i) {
                this.rdmodulecomLkactrl_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomLkactrl() {
                this.rdmodulecomLkactrl_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomCruiseLeverTHW() {
                return this.rdmodulecomCruiseLeverTHW_;
            }

            public Builder setRdmodulecomCruiseLeverTHW(int i) {
                this.rdmodulecomCruiseLeverTHW_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomCruiseLeverTHW() {
                this.rdmodulecomCruiseLeverTHW_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomCruiseVehSpd() {
                return this.rdmodulecomCruiseVehSpd_;
            }

            public Builder setRdmodulecomCruiseVehSpd(int i) {
                this.rdmodulecomCruiseVehSpd_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomCruiseVehSpd() {
                this.rdmodulecomCruiseVehSpd_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomAccHold() {
                return this.rdmodulecomAccHold_;
            }

            public Builder setRdmodulecomAccHold(int i) {
                this.rdmodulecomAccHold_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomAccHold() {
                this.rdmodulecomAccHold_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomACCMode1() {
                return this.rdmodulecomACCMode1_;
            }

            public Builder setRdmodulecomACCMode1(int i) {
                this.rdmodulecomACCMode1_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomACCMode1() {
                this.rdmodulecomACCMode1_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomLKAMODE() {
                return this.rdmodulecomLKAMODE_;
            }

            public Builder setRdmodulecomLKAMODE(int i) {
                this.rdmodulecomLKAMODE_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomLKAMODE() {
                this.rdmodulecomLKAMODE_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomLongctrl() {
                return this.rdmodulecomLongctrl_;
            }

            public Builder setRdmodulecomLongctrl(int i) {
                this.rdmodulecomLongctrl_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomLongctrl() {
                this.rdmodulecomLongctrl_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomLateralctrl() {
                return this.rdmodulecomLateralctrl_;
            }

            public Builder setRdmodulecomLateralctrl(int i) {
                this.rdmodulecomLateralctrl_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomLateralctrl() {
                this.rdmodulecomLateralctrl_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomSteeringctrl() {
                return this.rdmodulecomSteeringctrl_;
            }

            public Builder setRdmodulecomSteeringctrl(int i) {
                this.rdmodulecomSteeringctrl_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomSteeringctrl() {
                this.rdmodulecomSteeringctrl_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomWos() {
                return this.rdmodulecomWos_;
            }

            public Builder setRdmodulecomWos(int i) {
                this.rdmodulecomWos_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomWos() {
                this.rdmodulecomWos_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomTurnstate() {
                return this.rdmodulecomTurnstate_;
            }

            public Builder setRdmodulecomTurnstate(int i) {
                this.rdmodulecomTurnstate_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomTurnstate() {
                this.rdmodulecomTurnstate_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomAlcstate() {
                return this.rdmodulecomAlcstate_;
            }

            public Builder setRdmodulecomAlcstate(int i) {
                this.rdmodulecomAlcstate_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomAlcstate() {
                this.rdmodulecomAlcstate_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomNgpmode() {
                return this.rdmodulecomNgpmode_;
            }

            public Builder setRdmodulecomNgpmode(int i) {
                this.rdmodulecomNgpmode_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomNgpmode() {
                this.rdmodulecomNgpmode_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomAlcmode() {
                return this.rdmodulecomAlcmode_;
            }

            public Builder setRdmodulecomAlcmode(int i) {
                this.rdmodulecomAlcmode_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomAlcmode() {
                this.rdmodulecomAlcmode_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomLccmode() {
                return this.rdmodulecomLccmode_;
            }

            public Builder setRdmodulecomLccmode(int i) {
                this.rdmodulecomLccmode_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomLccmode() {
                this.rdmodulecomLccmode_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomAccmode() {
                return this.rdmodulecomAccmode_;
            }

            public Builder setRdmodulecomAccmode(int i) {
                this.rdmodulecomAccmode_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomAccmode() {
                this.rdmodulecomAccmode_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomNgpflag() {
                return this.rdmodulecomNgpflag_;
            }

            public Builder setRdmodulecomNgpflag(int i) {
                this.rdmodulecomNgpflag_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomNgpflag() {
                this.rdmodulecomNgpflag_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomFunctionMode() {
                return this.rdmodulecomFunctionMode_;
            }

            public Builder setRdmodulecomFunctionMode(int i) {
                this.rdmodulecomFunctionMode_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomFunctionMode() {
                this.rdmodulecomFunctionMode_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public float getRdmodulecomCruisevehSpdSt() {
                return this.rdmodulecomCruisevehSpdSt_;
            }

            public Builder setRdmodulecomCruisevehSpdSt(float f) {
                this.rdmodulecomCruisevehSpdSt_ = f;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomCruisevehSpdSt() {
                this.rdmodulecomCruisevehSpdSt_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getXPUSRNGPView() {
                return this.xPUSRNGPView_;
            }

            public Builder setXPUSRNGPView(int i) {
                this.xPUSRNGPView_ = i;
                onChanged();
                return this;
            }

            public Builder clearXPUSRNGPView() {
                this.xPUSRNGPView_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomUlcTurnstate() {
                return this.rdmodulecomUlcTurnstate_;
            }

            public Builder setRdmodulecomUlcTurnstate(int i) {
                this.rdmodulecomUlcTurnstate_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomUlcTurnstate() {
                this.rdmodulecomUlcTurnstate_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomUlcstate() {
                return this.rdmodulecomUlcstate_;
            }

            public Builder setRdmodulecomUlcstate(int i) {
                this.rdmodulecomUlcstate_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomUlcstate() {
                this.rdmodulecomUlcstate_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecomUlcNeedtocomfirm() {
                return this.rdmodulecomUlcNeedtocomfirm_;
            }

            public Builder setRdmodulecomUlcNeedtocomfirm(int i) {
                this.rdmodulecomUlcNeedtocomfirm_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecomUlcNeedtocomfirm() {
                this.rdmodulecomUlcNeedtocomfirm_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom9State() {
                return this.rdmodulecom9State_;
            }

            public Builder setRdmodulecom9State(int i) {
                this.rdmodulecom9State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom9State() {
                this.rdmodulecom9State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom10State() {
                return this.rdmodulecom10State_;
            }

            public Builder setRdmodulecom10State(int i) {
                this.rdmodulecom10State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom10State() {
                this.rdmodulecom10State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom11State() {
                return this.rdmodulecom11State_;
            }

            public Builder setRdmodulecom11State(int i) {
                this.rdmodulecom11State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom11State() {
                this.rdmodulecom11State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom12State() {
                return this.rdmodulecom12State_;
            }

            public Builder setRdmodulecom12State(int i) {
                this.rdmodulecom12State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom12State() {
                this.rdmodulecom12State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom13State() {
                return this.rdmodulecom13State_;
            }

            public Builder setRdmodulecom13State(int i) {
                this.rdmodulecom13State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom13State() {
                this.rdmodulecom13State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom14State() {
                return this.rdmodulecom14State_;
            }

            public Builder setRdmodulecom14State(int i) {
                this.rdmodulecom14State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom14State() {
                this.rdmodulecom14State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom15State() {
                return this.rdmodulecom15State_;
            }

            public Builder setRdmodulecom15State(int i) {
                this.rdmodulecom15State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom15State() {
                this.rdmodulecom15State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom16State() {
                return this.rdmodulecom16State_;
            }

            public Builder setRdmodulecom16State(int i) {
                this.rdmodulecom16State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom16State() {
                this.rdmodulecom16State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom17State() {
                return this.rdmodulecom17State_;
            }

            public Builder setRdmodulecom17State(int i) {
                this.rdmodulecom17State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom17State() {
                this.rdmodulecom17State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom18State() {
                return this.rdmodulecom18State_;
            }

            public Builder setRdmodulecom18State(int i) {
                this.rdmodulecom18State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom18State() {
                this.rdmodulecom18State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom19State() {
                return this.rdmodulecom19State_;
            }

            public Builder setRdmodulecom19State(int i) {
                this.rdmodulecom19State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom19State() {
                this.rdmodulecom19State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRdmodulecom20State() {
                return this.rdmodulecom20State_;
            }

            public Builder setRdmodulecom20State(int i) {
                this.rdmodulecom20State_ = i;
                onChanged();
                return this;
            }

            public Builder clearRdmodulecom20State() {
                this.rdmodulecom20State_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getSrDisplaySt() {
                return this.srDisplaySt_;
            }

            public Builder setSrDisplaySt(int i) {
                this.srDisplaySt_ = i;
                onChanged();
                return this;
            }

            public Builder clearSrDisplaySt() {
                this.srDisplaySt_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getRfLineColor() {
                return this.rfLineColor_;
            }

            public Builder setRfLineColor(int i) {
                this.rfLineColor_ = i;
                onChanged();
                return this;
            }

            public Builder clearRfLineColor() {
                this.rfLineColor_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getXPUSRLCView() {
                return this.xPUSRLCView_;
            }

            public Builder setXPUSRLCView(int i) {
                this.xPUSRLCView_ = i;
                onChanged();
                return this;
            }

            public Builder clearXPUSRLCView() {
                this.xPUSRLCView_ = 0;
                onChanged();
                return this;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField1_ & 8192) != 8192) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField1_ |= 8192;
                }
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.Primitives.StateManagementOrBuilder
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
                this.bitField1_ &= -8193;
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

        public static StateManagement getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StateManagement> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StateManagement> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StateManagement getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class lanelineinfo_xpu2scu extends GeneratedMessageV3 implements lanelineinfo_xpu2scuOrBuilder {
        public static final int LANECOLOR_FIELD_NUMBER = 9;
        public static final int LANECURVECHANGE_C3_FIELD_NUMBER = 13;
        public static final int LANECURVE_C2_FIELD_NUMBER = 12;
        public static final int LANEDISTY_C0_FIELD_NUMBER = 10;
        public static final int LANEENDDXSTD_FIELD_NUMBER = 5;
        public static final int LANEENDDX_FIELD_NUMBER = 4;
        public static final int LANEEXISTPROB_FIELD_NUMBER = 6;
        public static final int LANEID_FIELD_NUMBER = 1;
        public static final int LANESTARTDXSTD_FIELD_NUMBER = 3;
        public static final int LANESTARTDX_FIELD_NUMBER = 2;
        public static final int LANETYPEPROB_FIELD_NUMBER = 8;
        public static final int LANETYPE_FIELD_NUMBER = 7;
        public static final int LANEWIDTH_FIELD_NUMBER = 14;
        public static final int LANEYAWANGLE_C1_FIELD_NUMBER = 11;
        private static final long serialVersionUID = 0;
        private int lanecolor_;
        private float lanecurveC2_;
        private float lanecurvechangeC3_;
        private float lanedistyC0_;
        private float laneenddx_;
        private float laneenddxstd_;
        private int laneexistprob_;
        private int laneid_;
        private float lanestartdx_;
        private float lanestartdxstd_;
        private int lanetype_;
        private int lanetypeprob_;
        private float lanewidth_;
        private float laneyawangleC1_;
        private byte memoizedIsInitialized;
        private static final lanelineinfo_xpu2scu DEFAULT_INSTANCE = new lanelineinfo_xpu2scu();
        private static final Parser<lanelineinfo_xpu2scu> PARSER = new AbstractParser<lanelineinfo_xpu2scu>() { // from class: xpilot.sr.proto.Primitives.lanelineinfo_xpu2scu.1
            @Override // com.google.protobuf.Parser
            public lanelineinfo_xpu2scu parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new lanelineinfo_xpu2scu(codedInputStream, extensionRegistryLite);
            }
        };

        private lanelineinfo_xpu2scu(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private lanelineinfo_xpu2scu() {
            this.memoizedIsInitialized = (byte) -1;
            this.laneid_ = 0;
            this.lanestartdx_ = 0.0f;
            this.lanestartdxstd_ = 0.0f;
            this.laneenddx_ = 0.0f;
            this.laneenddxstd_ = 0.0f;
            this.laneexistprob_ = 0;
            this.lanetype_ = 0;
            this.lanetypeprob_ = 0;
            this.lanecolor_ = 0;
            this.lanedistyC0_ = 0.0f;
            this.laneyawangleC1_ = 0.0f;
            this.lanecurveC2_ = 0.0f;
            this.lanecurvechangeC3_ = 0.0f;
            this.lanewidth_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private lanelineinfo_xpu2scu(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.laneid_ = codedInputStream.readInt32();
                                    continue;
                                case 21:
                                    this.lanestartdx_ = codedInputStream.readFloat();
                                    continue;
                                case 29:
                                    this.lanestartdxstd_ = codedInputStream.readFloat();
                                    continue;
                                case 37:
                                    this.laneenddx_ = codedInputStream.readFloat();
                                    continue;
                                case 45:
                                    this.laneenddxstd_ = codedInputStream.readFloat();
                                    continue;
                                case 48:
                                    this.laneexistprob_ = codedInputStream.readInt32();
                                    continue;
                                case 56:
                                    this.lanetype_ = codedInputStream.readInt32();
                                    continue;
                                case 64:
                                    this.lanetypeprob_ = codedInputStream.readInt32();
                                    continue;
                                case 72:
                                    this.lanecolor_ = codedInputStream.readEnum();
                                    continue;
                                case 85:
                                    this.lanedistyC0_ = codedInputStream.readFloat();
                                    continue;
                                case 93:
                                    this.laneyawangleC1_ = codedInputStream.readFloat();
                                    continue;
                                case 101:
                                    this.lanecurveC2_ = codedInputStream.readFloat();
                                    continue;
                                case 109:
                                    this.lanecurvechangeC3_ = codedInputStream.readFloat();
                                    continue;
                                case 117:
                                    this.lanewidth_ = codedInputStream.readFloat();
                                    continue;
                                default:
                                    if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Primitives.internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_fieldAccessorTable.ensureFieldAccessorsInitialized(lanelineinfo_xpu2scu.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public int getLaneid() {
            return this.laneid_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public float getLanestartdx() {
            return this.lanestartdx_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public float getLanestartdxstd() {
            return this.lanestartdxstd_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public float getLaneenddx() {
            return this.laneenddx_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public float getLaneenddxstd() {
            return this.laneenddxstd_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public int getLaneexistprob() {
            return this.laneexistprob_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public int getLanetype() {
            return this.lanetype_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public int getLanetypeprob() {
            return this.lanetypeprob_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public int getLanecolorValue() {
            return this.lanecolor_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public EnumC0056lanelinecolor getLanecolor() {
            EnumC0056lanelinecolor valueOf = EnumC0056lanelinecolor.valueOf(this.lanecolor_);
            return valueOf == null ? EnumC0056lanelinecolor.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public float getLanedistyC0() {
            return this.lanedistyC0_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public float getLaneyawangleC1() {
            return this.laneyawangleC1_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public float getLanecurveC2() {
            return this.lanecurveC2_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public float getLanecurvechangeC3() {
            return this.lanecurvechangeC3_;
        }

        @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
        public float getLanewidth() {
            return this.lanewidth_;
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
            int i = this.laneid_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            float f = this.lanestartdx_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(2, f);
            }
            float f2 = this.lanestartdxstd_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(3, f2);
            }
            float f3 = this.laneenddx_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(4, f3);
            }
            float f4 = this.laneenddxstd_;
            if (f4 != 0.0f) {
                codedOutputStream.writeFloat(5, f4);
            }
            int i2 = this.laneexistprob_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(6, i2);
            }
            int i3 = this.lanetype_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(7, i3);
            }
            int i4 = this.lanetypeprob_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(8, i4);
            }
            if (this.lanecolor_ != EnumC0056lanelinecolor.unknown.getNumber()) {
                codedOutputStream.writeEnum(9, this.lanecolor_);
            }
            float f5 = this.lanedistyC0_;
            if (f5 != 0.0f) {
                codedOutputStream.writeFloat(10, f5);
            }
            float f6 = this.laneyawangleC1_;
            if (f6 != 0.0f) {
                codedOutputStream.writeFloat(11, f6);
            }
            float f7 = this.lanecurveC2_;
            if (f7 != 0.0f) {
                codedOutputStream.writeFloat(12, f7);
            }
            float f8 = this.lanecurvechangeC3_;
            if (f8 != 0.0f) {
                codedOutputStream.writeFloat(13, f8);
            }
            float f9 = this.lanewidth_;
            if (f9 != 0.0f) {
                codedOutputStream.writeFloat(14, f9);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.laneid_;
            int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            float f = this.lanestartdx_;
            if (f != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(2, f);
            }
            float f2 = this.lanestartdxstd_;
            if (f2 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(3, f2);
            }
            float f3 = this.laneenddx_;
            if (f3 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(4, f3);
            }
            float f4 = this.laneenddxstd_;
            if (f4 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(5, f4);
            }
            int i3 = this.laneexistprob_;
            if (i3 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, i3);
            }
            int i4 = this.lanetype_;
            if (i4 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, i4);
            }
            int i5 = this.lanetypeprob_;
            if (i5 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, i5);
            }
            if (this.lanecolor_ != EnumC0056lanelinecolor.unknown.getNumber()) {
                computeInt32Size += CodedOutputStream.computeEnumSize(9, this.lanecolor_);
            }
            float f5 = this.lanedistyC0_;
            if (f5 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(10, f5);
            }
            float f6 = this.laneyawangleC1_;
            if (f6 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(11, f6);
            }
            float f7 = this.lanecurveC2_;
            if (f7 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(12, f7);
            }
            float f8 = this.lanecurvechangeC3_;
            if (f8 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(13, f8);
            }
            float f9 = this.lanewidth_;
            if (f9 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(14, f9);
            }
            int serializedSize = computeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof lanelineinfo_xpu2scu)) {
                return super.equals(obj);
            }
            lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = (lanelineinfo_xpu2scu) obj;
            return ((((((((((((((getLaneid() == lanelineinfo_xpu2scuVar.getLaneid()) && Float.floatToIntBits(getLanestartdx()) == Float.floatToIntBits(lanelineinfo_xpu2scuVar.getLanestartdx())) && Float.floatToIntBits(getLanestartdxstd()) == Float.floatToIntBits(lanelineinfo_xpu2scuVar.getLanestartdxstd())) && Float.floatToIntBits(getLaneenddx()) == Float.floatToIntBits(lanelineinfo_xpu2scuVar.getLaneenddx())) && Float.floatToIntBits(getLaneenddxstd()) == Float.floatToIntBits(lanelineinfo_xpu2scuVar.getLaneenddxstd())) && getLaneexistprob() == lanelineinfo_xpu2scuVar.getLaneexistprob()) && getLanetype() == lanelineinfo_xpu2scuVar.getLanetype()) && getLanetypeprob() == lanelineinfo_xpu2scuVar.getLanetypeprob()) && this.lanecolor_ == lanelineinfo_xpu2scuVar.lanecolor_) && Float.floatToIntBits(getLanedistyC0()) == Float.floatToIntBits(lanelineinfo_xpu2scuVar.getLanedistyC0())) && Float.floatToIntBits(getLaneyawangleC1()) == Float.floatToIntBits(lanelineinfo_xpu2scuVar.getLaneyawangleC1())) && Float.floatToIntBits(getLanecurveC2()) == Float.floatToIntBits(lanelineinfo_xpu2scuVar.getLanecurveC2())) && Float.floatToIntBits(getLanecurvechangeC3()) == Float.floatToIntBits(lanelineinfo_xpu2scuVar.getLanecurvechangeC3())) && Float.floatToIntBits(getLanewidth()) == Float.floatToIntBits(lanelineinfo_xpu2scuVar.getLanewidth())) && this.unknownFields.equals(lanelineinfo_xpu2scuVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getLaneid()) * 37) + 2) * 53) + Float.floatToIntBits(getLanestartdx())) * 37) + 3) * 53) + Float.floatToIntBits(getLanestartdxstd())) * 37) + 4) * 53) + Float.floatToIntBits(getLaneenddx())) * 37) + 5) * 53) + Float.floatToIntBits(getLaneenddxstd())) * 37) + 6) * 53) + getLaneexistprob()) * 37) + 7) * 53) + getLanetype()) * 37) + 8) * 53) + getLanetypeprob()) * 37) + 9) * 53) + this.lanecolor_) * 37) + 10) * 53) + Float.floatToIntBits(getLanedistyC0())) * 37) + 11) * 53) + Float.floatToIntBits(getLaneyawangleC1())) * 37) + 12) * 53) + Float.floatToIntBits(getLanecurveC2())) * 37) + 13) * 53) + Float.floatToIntBits(getLanecurvechangeC3())) * 37) + 14) * 53) + Float.floatToIntBits(getLanewidth())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static lanelineinfo_xpu2scu parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static lanelineinfo_xpu2scu parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static lanelineinfo_xpu2scu parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static lanelineinfo_xpu2scu parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static lanelineinfo_xpu2scu parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static lanelineinfo_xpu2scu parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static lanelineinfo_xpu2scu parseFrom(InputStream inputStream) throws IOException {
            return (lanelineinfo_xpu2scu) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static lanelineinfo_xpu2scu parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (lanelineinfo_xpu2scu) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static lanelineinfo_xpu2scu parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (lanelineinfo_xpu2scu) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static lanelineinfo_xpu2scu parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (lanelineinfo_xpu2scu) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static lanelineinfo_xpu2scu parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (lanelineinfo_xpu2scu) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static lanelineinfo_xpu2scu parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (lanelineinfo_xpu2scu) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(lanelineinfo_xpu2scuVar);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements lanelineinfo_xpu2scuOrBuilder {
            private int lanecolor_;
            private float lanecurveC2_;
            private float lanecurvechangeC3_;
            private float lanedistyC0_;
            private float laneenddx_;
            private float laneenddxstd_;
            private int laneexistprob_;
            private int laneid_;
            private float lanestartdx_;
            private float lanestartdxstd_;
            private int lanetype_;
            private int lanetypeprob_;
            private float lanewidth_;
            private float laneyawangleC1_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_fieldAccessorTable.ensureFieldAccessorsInitialized(lanelineinfo_xpu2scu.class, Builder.class);
            }

            private Builder() {
                this.lanecolor_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.lanecolor_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = lanelineinfo_xpu2scu.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.laneid_ = 0;
                this.lanestartdx_ = 0.0f;
                this.lanestartdxstd_ = 0.0f;
                this.laneenddx_ = 0.0f;
                this.laneenddxstd_ = 0.0f;
                this.laneexistprob_ = 0;
                this.lanetype_ = 0;
                this.lanetypeprob_ = 0;
                this.lanecolor_ = 0;
                this.lanedistyC0_ = 0.0f;
                this.laneyawangleC1_ = 0.0f;
                this.lanecurveC2_ = 0.0f;
                this.lanecurvechangeC3_ = 0.0f;
                this.lanewidth_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public lanelineinfo_xpu2scu getDefaultInstanceForType() {
                return lanelineinfo_xpu2scu.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public lanelineinfo_xpu2scu build() {
                lanelineinfo_xpu2scu buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public lanelineinfo_xpu2scu buildPartial() {
                lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = new lanelineinfo_xpu2scu(this);
                lanelineinfo_xpu2scuVar.laneid_ = this.laneid_;
                lanelineinfo_xpu2scuVar.lanestartdx_ = this.lanestartdx_;
                lanelineinfo_xpu2scuVar.lanestartdxstd_ = this.lanestartdxstd_;
                lanelineinfo_xpu2scuVar.laneenddx_ = this.laneenddx_;
                lanelineinfo_xpu2scuVar.laneenddxstd_ = this.laneenddxstd_;
                lanelineinfo_xpu2scuVar.laneexistprob_ = this.laneexistprob_;
                lanelineinfo_xpu2scuVar.lanetype_ = this.lanetype_;
                lanelineinfo_xpu2scuVar.lanetypeprob_ = this.lanetypeprob_;
                lanelineinfo_xpu2scuVar.lanecolor_ = this.lanecolor_;
                lanelineinfo_xpu2scuVar.lanedistyC0_ = this.lanedistyC0_;
                lanelineinfo_xpu2scuVar.laneyawangleC1_ = this.laneyawangleC1_;
                lanelineinfo_xpu2scuVar.lanecurveC2_ = this.lanecurveC2_;
                lanelineinfo_xpu2scuVar.lanecurvechangeC3_ = this.lanecurvechangeC3_;
                lanelineinfo_xpu2scuVar.lanewidth_ = this.lanewidth_;
                onBuilt();
                return lanelineinfo_xpu2scuVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof lanelineinfo_xpu2scu) {
                    return mergeFrom((lanelineinfo_xpu2scu) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                if (lanelineinfo_xpu2scuVar == lanelineinfo_xpu2scu.getDefaultInstance()) {
                    return this;
                }
                if (lanelineinfo_xpu2scuVar.getLaneid() != 0) {
                    setLaneid(lanelineinfo_xpu2scuVar.getLaneid());
                }
                if (lanelineinfo_xpu2scuVar.getLanestartdx() != 0.0f) {
                    setLanestartdx(lanelineinfo_xpu2scuVar.getLanestartdx());
                }
                if (lanelineinfo_xpu2scuVar.getLanestartdxstd() != 0.0f) {
                    setLanestartdxstd(lanelineinfo_xpu2scuVar.getLanestartdxstd());
                }
                if (lanelineinfo_xpu2scuVar.getLaneenddx() != 0.0f) {
                    setLaneenddx(lanelineinfo_xpu2scuVar.getLaneenddx());
                }
                if (lanelineinfo_xpu2scuVar.getLaneenddxstd() != 0.0f) {
                    setLaneenddxstd(lanelineinfo_xpu2scuVar.getLaneenddxstd());
                }
                if (lanelineinfo_xpu2scuVar.getLaneexistprob() != 0) {
                    setLaneexistprob(lanelineinfo_xpu2scuVar.getLaneexistprob());
                }
                if (lanelineinfo_xpu2scuVar.getLanetype() != 0) {
                    setLanetype(lanelineinfo_xpu2scuVar.getLanetype());
                }
                if (lanelineinfo_xpu2scuVar.getLanetypeprob() != 0) {
                    setLanetypeprob(lanelineinfo_xpu2scuVar.getLanetypeprob());
                }
                if (lanelineinfo_xpu2scuVar.lanecolor_ != 0) {
                    setLanecolorValue(lanelineinfo_xpu2scuVar.getLanecolorValue());
                }
                if (lanelineinfo_xpu2scuVar.getLanedistyC0() != 0.0f) {
                    setLanedistyC0(lanelineinfo_xpu2scuVar.getLanedistyC0());
                }
                if (lanelineinfo_xpu2scuVar.getLaneyawangleC1() != 0.0f) {
                    setLaneyawangleC1(lanelineinfo_xpu2scuVar.getLaneyawangleC1());
                }
                if (lanelineinfo_xpu2scuVar.getLanecurveC2() != 0.0f) {
                    setLanecurveC2(lanelineinfo_xpu2scuVar.getLanecurveC2());
                }
                if (lanelineinfo_xpu2scuVar.getLanecurvechangeC3() != 0.0f) {
                    setLanecurvechangeC3(lanelineinfo_xpu2scuVar.getLanecurvechangeC3());
                }
                if (lanelineinfo_xpu2scuVar.getLanewidth() != 0.0f) {
                    setLanewidth(lanelineinfo_xpu2scuVar.getLanewidth());
                }
                mergeUnknownFields(lanelineinfo_xpu2scuVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.lanelineinfo_xpu2scu.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.lanelineinfo_xpu2scu.access$28700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$lanelineinfo_xpu2scu r3 = (xpilot.sr.proto.Primitives.lanelineinfo_xpu2scu) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$lanelineinfo_xpu2scu r4 = (xpilot.sr.proto.Primitives.lanelineinfo_xpu2scu) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.lanelineinfo_xpu2scu.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$lanelineinfo_xpu2scu$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public int getLaneid() {
                return this.laneid_;
            }

            public Builder setLaneid(int i) {
                this.laneid_ = i;
                onChanged();
                return this;
            }

            public Builder clearLaneid() {
                this.laneid_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public float getLanestartdx() {
                return this.lanestartdx_;
            }

            public Builder setLanestartdx(float f) {
                this.lanestartdx_ = f;
                onChanged();
                return this;
            }

            public Builder clearLanestartdx() {
                this.lanestartdx_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public float getLanestartdxstd() {
                return this.lanestartdxstd_;
            }

            public Builder setLanestartdxstd(float f) {
                this.lanestartdxstd_ = f;
                onChanged();
                return this;
            }

            public Builder clearLanestartdxstd() {
                this.lanestartdxstd_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public float getLaneenddx() {
                return this.laneenddx_;
            }

            public Builder setLaneenddx(float f) {
                this.laneenddx_ = f;
                onChanged();
                return this;
            }

            public Builder clearLaneenddx() {
                this.laneenddx_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public float getLaneenddxstd() {
                return this.laneenddxstd_;
            }

            public Builder setLaneenddxstd(float f) {
                this.laneenddxstd_ = f;
                onChanged();
                return this;
            }

            public Builder clearLaneenddxstd() {
                this.laneenddxstd_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public int getLaneexistprob() {
                return this.laneexistprob_;
            }

            public Builder setLaneexistprob(int i) {
                this.laneexistprob_ = i;
                onChanged();
                return this;
            }

            public Builder clearLaneexistprob() {
                this.laneexistprob_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public int getLanetype() {
                return this.lanetype_;
            }

            public Builder setLanetype(int i) {
                this.lanetype_ = i;
                onChanged();
                return this;
            }

            public Builder clearLanetype() {
                this.lanetype_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public int getLanetypeprob() {
                return this.lanetypeprob_;
            }

            public Builder setLanetypeprob(int i) {
                this.lanetypeprob_ = i;
                onChanged();
                return this;
            }

            public Builder clearLanetypeprob() {
                this.lanetypeprob_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public int getLanecolorValue() {
                return this.lanecolor_;
            }

            public Builder setLanecolorValue(int i) {
                this.lanecolor_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public EnumC0056lanelinecolor getLanecolor() {
                EnumC0056lanelinecolor valueOf = EnumC0056lanelinecolor.valueOf(this.lanecolor_);
                return valueOf == null ? EnumC0056lanelinecolor.UNRECOGNIZED : valueOf;
            }

            public Builder setLanecolor(EnumC0056lanelinecolor enumC0056lanelinecolor) {
                if (enumC0056lanelinecolor == null) {
                    throw new NullPointerException();
                }
                this.lanecolor_ = enumC0056lanelinecolor.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLanecolor() {
                this.lanecolor_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public float getLanedistyC0() {
                return this.lanedistyC0_;
            }

            public Builder setLanedistyC0(float f) {
                this.lanedistyC0_ = f;
                onChanged();
                return this;
            }

            public Builder clearLanedistyC0() {
                this.lanedistyC0_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public float getLaneyawangleC1() {
                return this.laneyawangleC1_;
            }

            public Builder setLaneyawangleC1(float f) {
                this.laneyawangleC1_ = f;
                onChanged();
                return this;
            }

            public Builder clearLaneyawangleC1() {
                this.laneyawangleC1_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public float getLanecurveC2() {
                return this.lanecurveC2_;
            }

            public Builder setLanecurveC2(float f) {
                this.lanecurveC2_ = f;
                onChanged();
                return this;
            }

            public Builder clearLanecurveC2() {
                this.lanecurveC2_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public float getLanecurvechangeC3() {
                return this.lanecurvechangeC3_;
            }

            public Builder setLanecurvechangeC3(float f) {
                this.lanecurvechangeC3_ = f;
                onChanged();
                return this;
            }

            public Builder clearLanecurvechangeC3() {
                this.lanecurvechangeC3_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.lanelineinfo_xpu2scuOrBuilder
            public float getLanewidth() {
                return this.lanewidth_;
            }

            public Builder setLanewidth(float f) {
                this.lanewidth_ = f;
                onChanged();
                return this;
            }

            public Builder clearLanewidth() {
                this.lanewidth_ = 0.0f;
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

        public static lanelineinfo_xpu2scu getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<lanelineinfo_xpu2scu> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<lanelineinfo_xpu2scu> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public lanelineinfo_xpu2scu getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class laneinfo_list extends GeneratedMessageV3 implements laneinfo_listOrBuilder {
        public static final int IS_STRADDLE_FIELD_NUMBER = 1;
        public static final int LANEINFOVD1_FIELD_NUMBER = 2;
        public static final int LANEINFOVD2_FIELD_NUMBER = 3;
        public static final int LANEINFOVD3_FIELD_NUMBER = 4;
        public static final int LANESHAPE_LOCAT_THETA_FIELD_NUMBER = 7;
        public static final int LANESHAPE_LOCAT_X_FIELD_NUMBER = 5;
        public static final int LANESHAPE_LOCAT_Y_FIELD_NUMBER = 6;
        public static final int LE1_FIELD_NUMBER = 8;
        public static final int LE2_FIELD_NUMBER = 10;
        public static final int LE3_FIELD_NUMBER = 12;
        public static final int RI1_FIELD_NUMBER = 9;
        public static final int RI2_FIELD_NUMBER = 11;
        public static final int RI3_FIELD_NUMBER = 13;
        private static final long serialVersionUID = 0;
        private boolean isStraddle_;
        private float laneShapeLocatTheta_;
        private float laneShapeLocatX_;
        private float laneShapeLocatY_;
        private boolean laneinfovd1_;
        private boolean laneinfovd2_;
        private boolean laneinfovd3_;
        private lanelineinfo_xpu2scu le1_;
        private lanelineinfo_xpu2scu le2_;
        private lanelineinfo_xpu2scu le3_;
        private byte memoizedIsInitialized;
        private lanelineinfo_xpu2scu ri1_;
        private lanelineinfo_xpu2scu ri2_;
        private lanelineinfo_xpu2scu ri3_;
        private static final laneinfo_list DEFAULT_INSTANCE = new laneinfo_list();
        private static final Parser<laneinfo_list> PARSER = new AbstractParser<laneinfo_list>() { // from class: xpilot.sr.proto.Primitives.laneinfo_list.1
            @Override // com.google.protobuf.Parser
            public laneinfo_list parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new laneinfo_list(codedInputStream, extensionRegistryLite);
            }
        };

        private laneinfo_list(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private laneinfo_list() {
            this.memoizedIsInitialized = (byte) -1;
            this.isStraddle_ = false;
            this.laneinfovd1_ = false;
            this.laneinfovd2_ = false;
            this.laneinfovd3_ = false;
            this.laneShapeLocatX_ = 0.0f;
            this.laneShapeLocatY_ = 0.0f;
            this.laneShapeLocatTheta_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private laneinfo_list(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            lanelineinfo_xpu2scu.Builder builder;
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
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.isStraddle_ = codedInputStream.readBool();
                                    continue;
                                case 16:
                                    this.laneinfovd1_ = codedInputStream.readBool();
                                    continue;
                                case 24:
                                    this.laneinfovd2_ = codedInputStream.readBool();
                                    continue;
                                case 32:
                                    this.laneinfovd3_ = codedInputStream.readBool();
                                    continue;
                                case 45:
                                    this.laneShapeLocatX_ = codedInputStream.readFloat();
                                    continue;
                                case 53:
                                    this.laneShapeLocatY_ = codedInputStream.readFloat();
                                    continue;
                                case 61:
                                    this.laneShapeLocatTheta_ = codedInputStream.readFloat();
                                    continue;
                                case 66:
                                    builder = this.le1_ != null ? this.le1_.toBuilder() : null;
                                    this.le1_ = (lanelineinfo_xpu2scu) codedInputStream.readMessage(lanelineinfo_xpu2scu.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.le1_);
                                        this.le1_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 74:
                                    builder = this.ri1_ != null ? this.ri1_.toBuilder() : null;
                                    this.ri1_ = (lanelineinfo_xpu2scu) codedInputStream.readMessage(lanelineinfo_xpu2scu.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.ri1_);
                                        this.ri1_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 82:
                                    builder = this.le2_ != null ? this.le2_.toBuilder() : null;
                                    this.le2_ = (lanelineinfo_xpu2scu) codedInputStream.readMessage(lanelineinfo_xpu2scu.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.le2_);
                                        this.le2_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 90:
                                    builder = this.ri2_ != null ? this.ri2_.toBuilder() : null;
                                    this.ri2_ = (lanelineinfo_xpu2scu) codedInputStream.readMessage(lanelineinfo_xpu2scu.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.ri2_);
                                        this.ri2_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 98:
                                    builder = this.le3_ != null ? this.le3_.toBuilder() : null;
                                    this.le3_ = (lanelineinfo_xpu2scu) codedInputStream.readMessage(lanelineinfo_xpu2scu.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.le3_);
                                        this.le3_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 106:
                                    builder = this.ri3_ != null ? this.ri3_.toBuilder() : null;
                                    this.ri3_ = (lanelineinfo_xpu2scu) codedInputStream.readMessage(lanelineinfo_xpu2scu.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.ri3_);
                                        this.ri3_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                default:
                                    if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
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
            return Primitives.internal_static_xpilot_sr_proto_laneinfo_list_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_laneinfo_list_fieldAccessorTable.ensureFieldAccessorsInitialized(laneinfo_list.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean getIsStraddle() {
            return this.isStraddle_;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean getLaneinfovd1() {
            return this.laneinfovd1_;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean getLaneinfovd2() {
            return this.laneinfovd2_;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean getLaneinfovd3() {
            return this.laneinfovd3_;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public float getLaneShapeLocatX() {
            return this.laneShapeLocatX_;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public float getLaneShapeLocatY() {
            return this.laneShapeLocatY_;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public float getLaneShapeLocatTheta() {
            return this.laneShapeLocatTheta_;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean hasLe1() {
            return this.le1_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scu getLe1() {
            lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.le1_;
            return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scuOrBuilder getLe1OrBuilder() {
            return getLe1();
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean hasRi1() {
            return this.ri1_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scu getRi1() {
            lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.ri1_;
            return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scuOrBuilder getRi1OrBuilder() {
            return getRi1();
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean hasLe2() {
            return this.le2_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scu getLe2() {
            lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.le2_;
            return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scuOrBuilder getLe2OrBuilder() {
            return getLe2();
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean hasRi2() {
            return this.ri2_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scu getRi2() {
            lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.ri2_;
            return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scuOrBuilder getRi2OrBuilder() {
            return getRi2();
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean hasLe3() {
            return this.le3_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scu getLe3() {
            lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.le3_;
            return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scuOrBuilder getLe3OrBuilder() {
            return getLe3();
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public boolean hasRi3() {
            return this.ri3_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scu getRi3() {
            lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.ri3_;
            return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
        }

        @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
        public lanelineinfo_xpu2scuOrBuilder getRi3OrBuilder() {
            return getRi3();
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
            boolean z = this.isStraddle_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            boolean z2 = this.laneinfovd1_;
            if (z2) {
                codedOutputStream.writeBool(2, z2);
            }
            boolean z3 = this.laneinfovd2_;
            if (z3) {
                codedOutputStream.writeBool(3, z3);
            }
            boolean z4 = this.laneinfovd3_;
            if (z4) {
                codedOutputStream.writeBool(4, z4);
            }
            float f = this.laneShapeLocatX_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(5, f);
            }
            float f2 = this.laneShapeLocatY_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(6, f2);
            }
            float f3 = this.laneShapeLocatTheta_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(7, f3);
            }
            if (this.le1_ != null) {
                codedOutputStream.writeMessage(8, getLe1());
            }
            if (this.ri1_ != null) {
                codedOutputStream.writeMessage(9, getRi1());
            }
            if (this.le2_ != null) {
                codedOutputStream.writeMessage(10, getLe2());
            }
            if (this.ri2_ != null) {
                codedOutputStream.writeMessage(11, getRi2());
            }
            if (this.le3_ != null) {
                codedOutputStream.writeMessage(12, getLe3());
            }
            if (this.ri3_ != null) {
                codedOutputStream.writeMessage(13, getRi3());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            boolean z = this.isStraddle_;
            int computeBoolSize = z ? 0 + CodedOutputStream.computeBoolSize(1, z) : 0;
            boolean z2 = this.laneinfovd1_;
            if (z2) {
                computeBoolSize += CodedOutputStream.computeBoolSize(2, z2);
            }
            boolean z3 = this.laneinfovd2_;
            if (z3) {
                computeBoolSize += CodedOutputStream.computeBoolSize(3, z3);
            }
            boolean z4 = this.laneinfovd3_;
            if (z4) {
                computeBoolSize += CodedOutputStream.computeBoolSize(4, z4);
            }
            float f = this.laneShapeLocatX_;
            if (f != 0.0f) {
                computeBoolSize += CodedOutputStream.computeFloatSize(5, f);
            }
            float f2 = this.laneShapeLocatY_;
            if (f2 != 0.0f) {
                computeBoolSize += CodedOutputStream.computeFloatSize(6, f2);
            }
            float f3 = this.laneShapeLocatTheta_;
            if (f3 != 0.0f) {
                computeBoolSize += CodedOutputStream.computeFloatSize(7, f3);
            }
            if (this.le1_ != null) {
                computeBoolSize += CodedOutputStream.computeMessageSize(8, getLe1());
            }
            if (this.ri1_ != null) {
                computeBoolSize += CodedOutputStream.computeMessageSize(9, getRi1());
            }
            if (this.le2_ != null) {
                computeBoolSize += CodedOutputStream.computeMessageSize(10, getLe2());
            }
            if (this.ri2_ != null) {
                computeBoolSize += CodedOutputStream.computeMessageSize(11, getRi2());
            }
            if (this.le3_ != null) {
                computeBoolSize += CodedOutputStream.computeMessageSize(12, getLe3());
            }
            if (this.ri3_ != null) {
                computeBoolSize += CodedOutputStream.computeMessageSize(13, getRi3());
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
            if (!(obj instanceof laneinfo_list)) {
                return super.equals(obj);
            }
            laneinfo_list laneinfo_listVar = (laneinfo_list) obj;
            boolean z = (((((((getIsStraddle() == laneinfo_listVar.getIsStraddle()) && getLaneinfovd1() == laneinfo_listVar.getLaneinfovd1()) && getLaneinfovd2() == laneinfo_listVar.getLaneinfovd2()) && getLaneinfovd3() == laneinfo_listVar.getLaneinfovd3()) && Float.floatToIntBits(getLaneShapeLocatX()) == Float.floatToIntBits(laneinfo_listVar.getLaneShapeLocatX())) && Float.floatToIntBits(getLaneShapeLocatY()) == Float.floatToIntBits(laneinfo_listVar.getLaneShapeLocatY())) && Float.floatToIntBits(getLaneShapeLocatTheta()) == Float.floatToIntBits(laneinfo_listVar.getLaneShapeLocatTheta())) && hasLe1() == laneinfo_listVar.hasLe1();
            if (hasLe1()) {
                z = z && getLe1().equals(laneinfo_listVar.getLe1());
            }
            boolean z2 = z && hasRi1() == laneinfo_listVar.hasRi1();
            if (hasRi1()) {
                z2 = z2 && getRi1().equals(laneinfo_listVar.getRi1());
            }
            boolean z3 = z2 && hasLe2() == laneinfo_listVar.hasLe2();
            if (hasLe2()) {
                z3 = z3 && getLe2().equals(laneinfo_listVar.getLe2());
            }
            boolean z4 = z3 && hasRi2() == laneinfo_listVar.hasRi2();
            if (hasRi2()) {
                z4 = z4 && getRi2().equals(laneinfo_listVar.getRi2());
            }
            boolean z5 = z4 && hasLe3() == laneinfo_listVar.hasLe3();
            if (hasLe3()) {
                z5 = z5 && getLe3().equals(laneinfo_listVar.getLe3());
            }
            boolean z6 = z5 && hasRi3() == laneinfo_listVar.hasRi3();
            if (hasRi3()) {
                z6 = z6 && getRi3().equals(laneinfo_listVar.getRi3());
            }
            return z6 && this.unknownFields.equals(laneinfo_listVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashBoolean(getIsStraddle())) * 37) + 2) * 53) + Internal.hashBoolean(getLaneinfovd1())) * 37) + 3) * 53) + Internal.hashBoolean(getLaneinfovd2())) * 37) + 4) * 53) + Internal.hashBoolean(getLaneinfovd3())) * 37) + 5) * 53) + Float.floatToIntBits(getLaneShapeLocatX())) * 37) + 6) * 53) + Float.floatToIntBits(getLaneShapeLocatY())) * 37) + 7) * 53) + Float.floatToIntBits(getLaneShapeLocatTheta());
            if (hasLe1()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getLe1().hashCode();
            }
            if (hasRi1()) {
                hashCode = (((hashCode * 37) + 9) * 53) + getRi1().hashCode();
            }
            if (hasLe2()) {
                hashCode = (((hashCode * 37) + 10) * 53) + getLe2().hashCode();
            }
            if (hasRi2()) {
                hashCode = (((hashCode * 37) + 11) * 53) + getRi2().hashCode();
            }
            if (hasLe3()) {
                hashCode = (((hashCode * 37) + 12) * 53) + getLe3().hashCode();
            }
            if (hasRi3()) {
                hashCode = (((hashCode * 37) + 13) * 53) + getRi3().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static laneinfo_list parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static laneinfo_list parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static laneinfo_list parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static laneinfo_list parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static laneinfo_list parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static laneinfo_list parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static laneinfo_list parseFrom(InputStream inputStream) throws IOException {
            return (laneinfo_list) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static laneinfo_list parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (laneinfo_list) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static laneinfo_list parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (laneinfo_list) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static laneinfo_list parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (laneinfo_list) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static laneinfo_list parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (laneinfo_list) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static laneinfo_list parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (laneinfo_list) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(laneinfo_list laneinfo_listVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(laneinfo_listVar);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements laneinfo_listOrBuilder {
            private boolean isStraddle_;
            private float laneShapeLocatTheta_;
            private float laneShapeLocatX_;
            private float laneShapeLocatY_;
            private boolean laneinfovd1_;
            private boolean laneinfovd2_;
            private boolean laneinfovd3_;
            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> le1Builder_;
            private lanelineinfo_xpu2scu le1_;
            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> le2Builder_;
            private lanelineinfo_xpu2scu le2_;
            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> le3Builder_;
            private lanelineinfo_xpu2scu le3_;
            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> ri1Builder_;
            private lanelineinfo_xpu2scu ri1_;
            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> ri2Builder_;
            private lanelineinfo_xpu2scu ri2_;
            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> ri3Builder_;
            private lanelineinfo_xpu2scu ri3_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_laneinfo_list_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_laneinfo_list_fieldAccessorTable.ensureFieldAccessorsInitialized(laneinfo_list.class, Builder.class);
            }

            private Builder() {
                this.le1_ = null;
                this.ri1_ = null;
                this.le2_ = null;
                this.ri2_ = null;
                this.le3_ = null;
                this.ri3_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.le1_ = null;
                this.ri1_ = null;
                this.le2_ = null;
                this.ri2_ = null;
                this.le3_ = null;
                this.ri3_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = laneinfo_list.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.isStraddle_ = false;
                this.laneinfovd1_ = false;
                this.laneinfovd2_ = false;
                this.laneinfovd3_ = false;
                this.laneShapeLocatX_ = 0.0f;
                this.laneShapeLocatY_ = 0.0f;
                this.laneShapeLocatTheta_ = 0.0f;
                if (this.le1Builder_ == null) {
                    this.le1_ = null;
                } else {
                    this.le1_ = null;
                    this.le1Builder_ = null;
                }
                if (this.ri1Builder_ == null) {
                    this.ri1_ = null;
                } else {
                    this.ri1_ = null;
                    this.ri1Builder_ = null;
                }
                if (this.le2Builder_ == null) {
                    this.le2_ = null;
                } else {
                    this.le2_ = null;
                    this.le2Builder_ = null;
                }
                if (this.ri2Builder_ == null) {
                    this.ri2_ = null;
                } else {
                    this.ri2_ = null;
                    this.ri2Builder_ = null;
                }
                if (this.le3Builder_ == null) {
                    this.le3_ = null;
                } else {
                    this.le3_ = null;
                    this.le3Builder_ = null;
                }
                if (this.ri3Builder_ == null) {
                    this.ri3_ = null;
                } else {
                    this.ri3_ = null;
                    this.ri3Builder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_laneinfo_list_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public laneinfo_list getDefaultInstanceForType() {
                return laneinfo_list.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public laneinfo_list build() {
                laneinfo_list buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public laneinfo_list buildPartial() {
                laneinfo_list laneinfo_listVar = new laneinfo_list(this);
                laneinfo_listVar.isStraddle_ = this.isStraddle_;
                laneinfo_listVar.laneinfovd1_ = this.laneinfovd1_;
                laneinfo_listVar.laneinfovd2_ = this.laneinfovd2_;
                laneinfo_listVar.laneinfovd3_ = this.laneinfovd3_;
                laneinfo_listVar.laneShapeLocatX_ = this.laneShapeLocatX_;
                laneinfo_listVar.laneShapeLocatY_ = this.laneShapeLocatY_;
                laneinfo_listVar.laneShapeLocatTheta_ = this.laneShapeLocatTheta_;
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le1Builder_;
                if (singleFieldBuilderV3 == null) {
                    laneinfo_listVar.le1_ = this.le1_;
                } else {
                    laneinfo_listVar.le1_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV32 = this.ri1Builder_;
                if (singleFieldBuilderV32 == null) {
                    laneinfo_listVar.ri1_ = this.ri1_;
                } else {
                    laneinfo_listVar.ri1_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV33 = this.le2Builder_;
                if (singleFieldBuilderV33 == null) {
                    laneinfo_listVar.le2_ = this.le2_;
                } else {
                    laneinfo_listVar.le2_ = singleFieldBuilderV33.build();
                }
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV34 = this.ri2Builder_;
                if (singleFieldBuilderV34 == null) {
                    laneinfo_listVar.ri2_ = this.ri2_;
                } else {
                    laneinfo_listVar.ri2_ = singleFieldBuilderV34.build();
                }
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV35 = this.le3Builder_;
                if (singleFieldBuilderV35 == null) {
                    laneinfo_listVar.le3_ = this.le3_;
                } else {
                    laneinfo_listVar.le3_ = singleFieldBuilderV35.build();
                }
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV36 = this.ri3Builder_;
                if (singleFieldBuilderV36 == null) {
                    laneinfo_listVar.ri3_ = this.ri3_;
                } else {
                    laneinfo_listVar.ri3_ = singleFieldBuilderV36.build();
                }
                onBuilt();
                return laneinfo_listVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof laneinfo_list) {
                    return mergeFrom((laneinfo_list) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(laneinfo_list laneinfo_listVar) {
                if (laneinfo_listVar == laneinfo_list.getDefaultInstance()) {
                    return this;
                }
                if (laneinfo_listVar.getIsStraddle()) {
                    setIsStraddle(laneinfo_listVar.getIsStraddle());
                }
                if (laneinfo_listVar.getLaneinfovd1()) {
                    setLaneinfovd1(laneinfo_listVar.getLaneinfovd1());
                }
                if (laneinfo_listVar.getLaneinfovd2()) {
                    setLaneinfovd2(laneinfo_listVar.getLaneinfovd2());
                }
                if (laneinfo_listVar.getLaneinfovd3()) {
                    setLaneinfovd3(laneinfo_listVar.getLaneinfovd3());
                }
                if (laneinfo_listVar.getLaneShapeLocatX() != 0.0f) {
                    setLaneShapeLocatX(laneinfo_listVar.getLaneShapeLocatX());
                }
                if (laneinfo_listVar.getLaneShapeLocatY() != 0.0f) {
                    setLaneShapeLocatY(laneinfo_listVar.getLaneShapeLocatY());
                }
                if (laneinfo_listVar.getLaneShapeLocatTheta() != 0.0f) {
                    setLaneShapeLocatTheta(laneinfo_listVar.getLaneShapeLocatTheta());
                }
                if (laneinfo_listVar.hasLe1()) {
                    mergeLe1(laneinfo_listVar.getLe1());
                }
                if (laneinfo_listVar.hasRi1()) {
                    mergeRi1(laneinfo_listVar.getRi1());
                }
                if (laneinfo_listVar.hasLe2()) {
                    mergeLe2(laneinfo_listVar.getLe2());
                }
                if (laneinfo_listVar.hasRi2()) {
                    mergeRi2(laneinfo_listVar.getRi2());
                }
                if (laneinfo_listVar.hasLe3()) {
                    mergeLe3(laneinfo_listVar.getLe3());
                }
                if (laneinfo_listVar.hasRi3()) {
                    mergeRi3(laneinfo_listVar.getRi3());
                }
                mergeUnknownFields(laneinfo_listVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.laneinfo_list.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.laneinfo_list.access$30900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$laneinfo_list r3 = (xpilot.sr.proto.Primitives.laneinfo_list) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$laneinfo_list r4 = (xpilot.sr.proto.Primitives.laneinfo_list) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.laneinfo_list.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$laneinfo_list$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean getIsStraddle() {
                return this.isStraddle_;
            }

            public Builder setIsStraddle(boolean z) {
                this.isStraddle_ = z;
                onChanged();
                return this;
            }

            public Builder clearIsStraddle() {
                this.isStraddle_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean getLaneinfovd1() {
                return this.laneinfovd1_;
            }

            public Builder setLaneinfovd1(boolean z) {
                this.laneinfovd1_ = z;
                onChanged();
                return this;
            }

            public Builder clearLaneinfovd1() {
                this.laneinfovd1_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean getLaneinfovd2() {
                return this.laneinfovd2_;
            }

            public Builder setLaneinfovd2(boolean z) {
                this.laneinfovd2_ = z;
                onChanged();
                return this;
            }

            public Builder clearLaneinfovd2() {
                this.laneinfovd2_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean getLaneinfovd3() {
                return this.laneinfovd3_;
            }

            public Builder setLaneinfovd3(boolean z) {
                this.laneinfovd3_ = z;
                onChanged();
                return this;
            }

            public Builder clearLaneinfovd3() {
                this.laneinfovd3_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public float getLaneShapeLocatX() {
                return this.laneShapeLocatX_;
            }

            public Builder setLaneShapeLocatX(float f) {
                this.laneShapeLocatX_ = f;
                onChanged();
                return this;
            }

            public Builder clearLaneShapeLocatX() {
                this.laneShapeLocatX_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public float getLaneShapeLocatY() {
                return this.laneShapeLocatY_;
            }

            public Builder setLaneShapeLocatY(float f) {
                this.laneShapeLocatY_ = f;
                onChanged();
                return this;
            }

            public Builder clearLaneShapeLocatY() {
                this.laneShapeLocatY_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public float getLaneShapeLocatTheta() {
                return this.laneShapeLocatTheta_;
            }

            public Builder setLaneShapeLocatTheta(float f) {
                this.laneShapeLocatTheta_ = f;
                onChanged();
                return this;
            }

            public Builder clearLaneShapeLocatTheta() {
                this.laneShapeLocatTheta_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean hasLe1() {
                return (this.le1Builder_ == null && this.le1_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scu getLe1() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le1Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.le1_;
                    return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLe1(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le1Builder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(lanelineinfo_xpu2scuVar);
                } else if (lanelineinfo_xpu2scuVar == null) {
                    throw new NullPointerException();
                } else {
                    this.le1_ = lanelineinfo_xpu2scuVar;
                    onChanged();
                }
                return this;
            }

            public Builder setLe1(lanelineinfo_xpu2scu.Builder builder) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le1Builder_;
                if (singleFieldBuilderV3 == null) {
                    this.le1_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLe1(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le1Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar2 = this.le1_;
                    if (lanelineinfo_xpu2scuVar2 != null) {
                        this.le1_ = lanelineinfo_xpu2scu.newBuilder(lanelineinfo_xpu2scuVar2).mergeFrom(lanelineinfo_xpu2scuVar).buildPartial();
                    } else {
                        this.le1_ = lanelineinfo_xpu2scuVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(lanelineinfo_xpu2scuVar);
                }
                return this;
            }

            public Builder clearLe1() {
                if (this.le1Builder_ == null) {
                    this.le1_ = null;
                    onChanged();
                } else {
                    this.le1_ = null;
                    this.le1Builder_ = null;
                }
                return this;
            }

            public lanelineinfo_xpu2scu.Builder getLe1Builder() {
                onChanged();
                return getLe1FieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scuOrBuilder getLe1OrBuilder() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le1Builder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.le1_;
                return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
            }

            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> getLe1FieldBuilder() {
                if (this.le1Builder_ == null) {
                    this.le1Builder_ = new SingleFieldBuilderV3<>(getLe1(), getParentForChildren(), isClean());
                    this.le1_ = null;
                }
                return this.le1Builder_;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean hasRi1() {
                return (this.ri1Builder_ == null && this.ri1_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scu getRi1() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri1Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.ri1_;
                    return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setRi1(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri1Builder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(lanelineinfo_xpu2scuVar);
                } else if (lanelineinfo_xpu2scuVar == null) {
                    throw new NullPointerException();
                } else {
                    this.ri1_ = lanelineinfo_xpu2scuVar;
                    onChanged();
                }
                return this;
            }

            public Builder setRi1(lanelineinfo_xpu2scu.Builder builder) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri1Builder_;
                if (singleFieldBuilderV3 == null) {
                    this.ri1_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeRi1(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri1Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar2 = this.ri1_;
                    if (lanelineinfo_xpu2scuVar2 != null) {
                        this.ri1_ = lanelineinfo_xpu2scu.newBuilder(lanelineinfo_xpu2scuVar2).mergeFrom(lanelineinfo_xpu2scuVar).buildPartial();
                    } else {
                        this.ri1_ = lanelineinfo_xpu2scuVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(lanelineinfo_xpu2scuVar);
                }
                return this;
            }

            public Builder clearRi1() {
                if (this.ri1Builder_ == null) {
                    this.ri1_ = null;
                    onChanged();
                } else {
                    this.ri1_ = null;
                    this.ri1Builder_ = null;
                }
                return this;
            }

            public lanelineinfo_xpu2scu.Builder getRi1Builder() {
                onChanged();
                return getRi1FieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scuOrBuilder getRi1OrBuilder() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri1Builder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.ri1_;
                return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
            }

            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> getRi1FieldBuilder() {
                if (this.ri1Builder_ == null) {
                    this.ri1Builder_ = new SingleFieldBuilderV3<>(getRi1(), getParentForChildren(), isClean());
                    this.ri1_ = null;
                }
                return this.ri1Builder_;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean hasLe2() {
                return (this.le2Builder_ == null && this.le2_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scu getLe2() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le2Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.le2_;
                    return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLe2(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le2Builder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(lanelineinfo_xpu2scuVar);
                } else if (lanelineinfo_xpu2scuVar == null) {
                    throw new NullPointerException();
                } else {
                    this.le2_ = lanelineinfo_xpu2scuVar;
                    onChanged();
                }
                return this;
            }

            public Builder setLe2(lanelineinfo_xpu2scu.Builder builder) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le2Builder_;
                if (singleFieldBuilderV3 == null) {
                    this.le2_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLe2(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le2Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar2 = this.le2_;
                    if (lanelineinfo_xpu2scuVar2 != null) {
                        this.le2_ = lanelineinfo_xpu2scu.newBuilder(lanelineinfo_xpu2scuVar2).mergeFrom(lanelineinfo_xpu2scuVar).buildPartial();
                    } else {
                        this.le2_ = lanelineinfo_xpu2scuVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(lanelineinfo_xpu2scuVar);
                }
                return this;
            }

            public Builder clearLe2() {
                if (this.le2Builder_ == null) {
                    this.le2_ = null;
                    onChanged();
                } else {
                    this.le2_ = null;
                    this.le2Builder_ = null;
                }
                return this;
            }

            public lanelineinfo_xpu2scu.Builder getLe2Builder() {
                onChanged();
                return getLe2FieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scuOrBuilder getLe2OrBuilder() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le2Builder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.le2_;
                return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
            }

            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> getLe2FieldBuilder() {
                if (this.le2Builder_ == null) {
                    this.le2Builder_ = new SingleFieldBuilderV3<>(getLe2(), getParentForChildren(), isClean());
                    this.le2_ = null;
                }
                return this.le2Builder_;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean hasRi2() {
                return (this.ri2Builder_ == null && this.ri2_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scu getRi2() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri2Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.ri2_;
                    return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setRi2(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri2Builder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(lanelineinfo_xpu2scuVar);
                } else if (lanelineinfo_xpu2scuVar == null) {
                    throw new NullPointerException();
                } else {
                    this.ri2_ = lanelineinfo_xpu2scuVar;
                    onChanged();
                }
                return this;
            }

            public Builder setRi2(lanelineinfo_xpu2scu.Builder builder) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri2Builder_;
                if (singleFieldBuilderV3 == null) {
                    this.ri2_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeRi2(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri2Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar2 = this.ri2_;
                    if (lanelineinfo_xpu2scuVar2 != null) {
                        this.ri2_ = lanelineinfo_xpu2scu.newBuilder(lanelineinfo_xpu2scuVar2).mergeFrom(lanelineinfo_xpu2scuVar).buildPartial();
                    } else {
                        this.ri2_ = lanelineinfo_xpu2scuVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(lanelineinfo_xpu2scuVar);
                }
                return this;
            }

            public Builder clearRi2() {
                if (this.ri2Builder_ == null) {
                    this.ri2_ = null;
                    onChanged();
                } else {
                    this.ri2_ = null;
                    this.ri2Builder_ = null;
                }
                return this;
            }

            public lanelineinfo_xpu2scu.Builder getRi2Builder() {
                onChanged();
                return getRi2FieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scuOrBuilder getRi2OrBuilder() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri2Builder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.ri2_;
                return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
            }

            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> getRi2FieldBuilder() {
                if (this.ri2Builder_ == null) {
                    this.ri2Builder_ = new SingleFieldBuilderV3<>(getRi2(), getParentForChildren(), isClean());
                    this.ri2_ = null;
                }
                return this.ri2Builder_;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean hasLe3() {
                return (this.le3Builder_ == null && this.le3_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scu getLe3() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le3Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.le3_;
                    return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLe3(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le3Builder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(lanelineinfo_xpu2scuVar);
                } else if (lanelineinfo_xpu2scuVar == null) {
                    throw new NullPointerException();
                } else {
                    this.le3_ = lanelineinfo_xpu2scuVar;
                    onChanged();
                }
                return this;
            }

            public Builder setLe3(lanelineinfo_xpu2scu.Builder builder) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le3Builder_;
                if (singleFieldBuilderV3 == null) {
                    this.le3_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLe3(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le3Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar2 = this.le3_;
                    if (lanelineinfo_xpu2scuVar2 != null) {
                        this.le3_ = lanelineinfo_xpu2scu.newBuilder(lanelineinfo_xpu2scuVar2).mergeFrom(lanelineinfo_xpu2scuVar).buildPartial();
                    } else {
                        this.le3_ = lanelineinfo_xpu2scuVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(lanelineinfo_xpu2scuVar);
                }
                return this;
            }

            public Builder clearLe3() {
                if (this.le3Builder_ == null) {
                    this.le3_ = null;
                    onChanged();
                } else {
                    this.le3_ = null;
                    this.le3Builder_ = null;
                }
                return this;
            }

            public lanelineinfo_xpu2scu.Builder getLe3Builder() {
                onChanged();
                return getLe3FieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scuOrBuilder getLe3OrBuilder() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.le3Builder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.le3_;
                return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
            }

            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> getLe3FieldBuilder() {
                if (this.le3Builder_ == null) {
                    this.le3Builder_ = new SingleFieldBuilderV3<>(getLe3(), getParentForChildren(), isClean());
                    this.le3_ = null;
                }
                return this.le3Builder_;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public boolean hasRi3() {
                return (this.ri3Builder_ == null && this.ri3_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scu getRi3() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri3Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.ri3_;
                    return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setRi3(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri3Builder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(lanelineinfo_xpu2scuVar);
                } else if (lanelineinfo_xpu2scuVar == null) {
                    throw new NullPointerException();
                } else {
                    this.ri3_ = lanelineinfo_xpu2scuVar;
                    onChanged();
                }
                return this;
            }

            public Builder setRi3(lanelineinfo_xpu2scu.Builder builder) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri3Builder_;
                if (singleFieldBuilderV3 == null) {
                    this.ri3_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeRi3(lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri3Builder_;
                if (singleFieldBuilderV3 == null) {
                    lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar2 = this.ri3_;
                    if (lanelineinfo_xpu2scuVar2 != null) {
                        this.ri3_ = lanelineinfo_xpu2scu.newBuilder(lanelineinfo_xpu2scuVar2).mergeFrom(lanelineinfo_xpu2scuVar).buildPartial();
                    } else {
                        this.ri3_ = lanelineinfo_xpu2scuVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(lanelineinfo_xpu2scuVar);
                }
                return this;
            }

            public Builder clearRi3() {
                if (this.ri3Builder_ == null) {
                    this.ri3_ = null;
                    onChanged();
                } else {
                    this.ri3_ = null;
                    this.ri3Builder_ = null;
                }
                return this;
            }

            public lanelineinfo_xpu2scu.Builder getRi3Builder() {
                onChanged();
                return getRi3FieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.laneinfo_listOrBuilder
            public lanelineinfo_xpu2scuOrBuilder getRi3OrBuilder() {
                SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> singleFieldBuilderV3 = this.ri3Builder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar = this.ri3_;
                return lanelineinfo_xpu2scuVar == null ? lanelineinfo_xpu2scu.getDefaultInstance() : lanelineinfo_xpu2scuVar;
            }

            private SingleFieldBuilderV3<lanelineinfo_xpu2scu, lanelineinfo_xpu2scu.Builder, lanelineinfo_xpu2scuOrBuilder> getRi3FieldBuilder() {
                if (this.ri3Builder_ == null) {
                    this.ri3Builder_ = new SingleFieldBuilderV3<>(getRi3(), getParentForChildren(), isClean());
                    this.ri3_ = null;
                }
                return this.ri3Builder_;
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

        public static laneinfo_list getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<laneinfo_list> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<laneinfo_list> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public laneinfo_list getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class MapFusionLanesForScu extends GeneratedMessageV3 implements MapFusionLanesForScuOrBuilder {
        private static final MapFusionLanesForScu DEFAULT_INSTANCE = new MapFusionLanesForScu();
        private static final Parser<MapFusionLanesForScu> PARSER = new AbstractParser<MapFusionLanesForScu>() { // from class: xpilot.sr.proto.Primitives.MapFusionLanesForScu.1
            @Override // com.google.protobuf.Parser
            public MapFusionLanesForScu parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MapFusionLanesForScu(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SPARE_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final int XPU_LANEINFO_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private Time timestamp_;
        private laneinfo_list xpuLaneinfo_;

        private MapFusionLanesForScu(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private MapFusionLanesForScu() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.spare_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MapFusionLanesForScu(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                laneinfo_list.Builder builder = this.xpuLaneinfo_ != null ? this.xpuLaneinfo_.toBuilder() : null;
                                this.xpuLaneinfo_ = (laneinfo_list) codedInputStream.readMessage(laneinfo_list.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.xpuLaneinfo_);
                                    this.xpuLaneinfo_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                Time.Builder builder2 = this.timestamp_ != null ? this.timestamp_.toBuilder() : null;
                                this.timestamp_ = (Time) codedInputStream.readMessage(Time.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.timestamp_);
                                    this.timestamp_ = builder2.buildPartial();
                                }
                            } else if (readTag == 26) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                boolean z3 = (z2 ? 1 : 0) & true;
                                z2 = z2;
                                if (!z3) {
                                    z2 = z2;
                                    if (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.spare_ = new ArrayList();
                                        z2 = (z2 ? 1 : 0) | true;
                                    }
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.spare_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 29) {
                                boolean z4 = (z2 ? 1 : 0) & true;
                                z2 = z2;
                                if (!z4) {
                                    this.spare_ = new ArrayList();
                                    z2 = (z2 ? 1 : 0) | true;
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
                    if ((z2 ? 1 : 0) & true) {
                        this.spare_ = Collections.unmodifiableList(this.spare_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Primitives.internal_static_xpilot_sr_proto_MapFusionLanesForScu_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Primitives.internal_static_xpilot_sr_proto_MapFusionLanesForScu_fieldAccessorTable.ensureFieldAccessorsInitialized(MapFusionLanesForScu.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
        public boolean hasXpuLaneinfo() {
            return this.xpuLaneinfo_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
        public laneinfo_list getXpuLaneinfo() {
            laneinfo_list laneinfo_listVar = this.xpuLaneinfo_;
            return laneinfo_listVar == null ? laneinfo_list.getDefaultInstance() : laneinfo_listVar;
        }

        @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
        public laneinfo_listOrBuilder getXpuLaneinfoOrBuilder() {
            return getXpuLaneinfo();
        }

        @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
        public boolean hasTimestamp() {
            return this.timestamp_ != null;
        }

        @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
        public Time getTimestamp() {
            Time time = this.timestamp_;
            return time == null ? Time.getDefaultInstance() : time;
        }

        @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
        public TimeOrBuilder getTimestampOrBuilder() {
            return getTimestamp();
        }

        @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
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
            if (this.xpuLaneinfo_ != null) {
                codedOutputStream.writeMessage(1, getXpuLaneinfo());
            }
            if (this.timestamp_ != null) {
                codedOutputStream.writeMessage(2, getTimestamp());
            }
            if (getSpareList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(26);
                codedOutputStream.writeUInt32NoTag(this.spareMemoizedSerializedSize);
            }
            for (int i = 0; i < this.spare_.size(); i++) {
                codedOutputStream.writeFloatNoTag(this.spare_.get(i).floatValue());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.xpuLaneinfo_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getXpuLaneinfo()) : 0;
            if (this.timestamp_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getTimestamp());
            }
            int size = getSpareList().size() * 4;
            int i2 = computeMessageSize + size;
            if (!getSpareList().isEmpty()) {
                i2 = i2 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.spareMemoizedSerializedSize = size;
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MapFusionLanesForScu)) {
                return super.equals(obj);
            }
            MapFusionLanesForScu mapFusionLanesForScu = (MapFusionLanesForScu) obj;
            boolean z = hasXpuLaneinfo() == mapFusionLanesForScu.hasXpuLaneinfo();
            if (hasXpuLaneinfo()) {
                z = z && getXpuLaneinfo().equals(mapFusionLanesForScu.getXpuLaneinfo());
            }
            boolean z2 = z && hasTimestamp() == mapFusionLanesForScu.hasTimestamp();
            if (hasTimestamp()) {
                z2 = z2 && getTimestamp().equals(mapFusionLanesForScu.getTimestamp());
            }
            return (z2 && getSpareList().equals(mapFusionLanesForScu.getSpareList())) && this.unknownFields.equals(mapFusionLanesForScu.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasXpuLaneinfo()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getXpuLaneinfo().hashCode();
            }
            if (hasTimestamp()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getTimestamp().hashCode();
            }
            if (getSpareCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getSpareList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static MapFusionLanesForScu parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static MapFusionLanesForScu parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MapFusionLanesForScu parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MapFusionLanesForScu parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MapFusionLanesForScu parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MapFusionLanesForScu parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MapFusionLanesForScu parseFrom(InputStream inputStream) throws IOException {
            return (MapFusionLanesForScu) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MapFusionLanesForScu parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapFusionLanesForScu) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MapFusionLanesForScu parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MapFusionLanesForScu) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MapFusionLanesForScu parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapFusionLanesForScu) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MapFusionLanesForScu parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MapFusionLanesForScu) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MapFusionLanesForScu parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapFusionLanesForScu) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MapFusionLanesForScu mapFusionLanesForScu) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(mapFusionLanesForScu);
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

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MapFusionLanesForScuOrBuilder {
            private int bitField0_;
            private List<Float> spare_;
            private SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> timestampBuilder_;
            private Time timestamp_;
            private SingleFieldBuilderV3<laneinfo_list, laneinfo_list.Builder, laneinfo_listOrBuilder> xpuLaneinfoBuilder_;
            private laneinfo_list xpuLaneinfo_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Primitives.internal_static_xpilot_sr_proto_MapFusionLanesForScu_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Primitives.internal_static_xpilot_sr_proto_MapFusionLanesForScu_fieldAccessorTable.ensureFieldAccessorsInitialized(MapFusionLanesForScu.class, Builder.class);
            }

            private Builder() {
                this.xpuLaneinfo_ = null;
                this.timestamp_ = null;
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.xpuLaneinfo_ = null;
                this.timestamp_ = null;
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MapFusionLanesForScu.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.xpuLaneinfoBuilder_ == null) {
                    this.xpuLaneinfo_ = null;
                } else {
                    this.xpuLaneinfo_ = null;
                    this.xpuLaneinfoBuilder_ = null;
                }
                if (this.timestampBuilder_ == null) {
                    this.timestamp_ = null;
                } else {
                    this.timestamp_ = null;
                    this.timestampBuilder_ = null;
                }
                this.spare_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Primitives.internal_static_xpilot_sr_proto_MapFusionLanesForScu_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MapFusionLanesForScu getDefaultInstanceForType() {
                return MapFusionLanesForScu.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MapFusionLanesForScu build() {
                MapFusionLanesForScu buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MapFusionLanesForScu buildPartial() {
                MapFusionLanesForScu mapFusionLanesForScu = new MapFusionLanesForScu(this);
                int i = this.bitField0_;
                SingleFieldBuilderV3<laneinfo_list, laneinfo_list.Builder, laneinfo_listOrBuilder> singleFieldBuilderV3 = this.xpuLaneinfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    mapFusionLanesForScu.xpuLaneinfo_ = this.xpuLaneinfo_;
                } else {
                    mapFusionLanesForScu.xpuLaneinfo_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV32 = this.timestampBuilder_;
                if (singleFieldBuilderV32 == null) {
                    mapFusionLanesForScu.timestamp_ = this.timestamp_;
                } else {
                    mapFusionLanesForScu.timestamp_ = singleFieldBuilderV32.build();
                }
                if ((this.bitField0_ & 4) == 4) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField0_ &= -5;
                }
                mapFusionLanesForScu.spare_ = this.spare_;
                mapFusionLanesForScu.bitField0_ = 0;
                onBuilt();
                return mapFusionLanesForScu;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo86clone() {
                return (Builder) super.mo86clone();
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
                if (message instanceof MapFusionLanesForScu) {
                    return mergeFrom((MapFusionLanesForScu) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(MapFusionLanesForScu mapFusionLanesForScu) {
                if (mapFusionLanesForScu == MapFusionLanesForScu.getDefaultInstance()) {
                    return this;
                }
                if (mapFusionLanesForScu.hasXpuLaneinfo()) {
                    mergeXpuLaneinfo(mapFusionLanesForScu.getXpuLaneinfo());
                }
                if (mapFusionLanesForScu.hasTimestamp()) {
                    mergeTimestamp(mapFusionLanesForScu.getTimestamp());
                }
                if (!mapFusionLanesForScu.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = mapFusionLanesForScu.spare_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(mapFusionLanesForScu.spare_);
                    }
                    onChanged();
                }
                mergeUnknownFields(mapFusionLanesForScu.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Primitives.MapFusionLanesForScu.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Primitives.MapFusionLanesForScu.access$32200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Primitives$MapFusionLanesForScu r3 = (xpilot.sr.proto.Primitives.MapFusionLanesForScu) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Primitives$MapFusionLanesForScu r4 = (xpilot.sr.proto.Primitives.MapFusionLanesForScu) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Primitives.MapFusionLanesForScu.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Primitives$MapFusionLanesForScu$Builder");
            }

            @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
            public boolean hasXpuLaneinfo() {
                return (this.xpuLaneinfoBuilder_ == null && this.xpuLaneinfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
            public laneinfo_list getXpuLaneinfo() {
                SingleFieldBuilderV3<laneinfo_list, laneinfo_list.Builder, laneinfo_listOrBuilder> singleFieldBuilderV3 = this.xpuLaneinfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    laneinfo_list laneinfo_listVar = this.xpuLaneinfo_;
                    return laneinfo_listVar == null ? laneinfo_list.getDefaultInstance() : laneinfo_listVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setXpuLaneinfo(laneinfo_list laneinfo_listVar) {
                SingleFieldBuilderV3<laneinfo_list, laneinfo_list.Builder, laneinfo_listOrBuilder> singleFieldBuilderV3 = this.xpuLaneinfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(laneinfo_listVar);
                } else if (laneinfo_listVar == null) {
                    throw new NullPointerException();
                } else {
                    this.xpuLaneinfo_ = laneinfo_listVar;
                    onChanged();
                }
                return this;
            }

            public Builder setXpuLaneinfo(laneinfo_list.Builder builder) {
                SingleFieldBuilderV3<laneinfo_list, laneinfo_list.Builder, laneinfo_listOrBuilder> singleFieldBuilderV3 = this.xpuLaneinfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.xpuLaneinfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeXpuLaneinfo(laneinfo_list laneinfo_listVar) {
                SingleFieldBuilderV3<laneinfo_list, laneinfo_list.Builder, laneinfo_listOrBuilder> singleFieldBuilderV3 = this.xpuLaneinfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    laneinfo_list laneinfo_listVar2 = this.xpuLaneinfo_;
                    if (laneinfo_listVar2 != null) {
                        this.xpuLaneinfo_ = laneinfo_list.newBuilder(laneinfo_listVar2).mergeFrom(laneinfo_listVar).buildPartial();
                    } else {
                        this.xpuLaneinfo_ = laneinfo_listVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(laneinfo_listVar);
                }
                return this;
            }

            public Builder clearXpuLaneinfo() {
                if (this.xpuLaneinfoBuilder_ == null) {
                    this.xpuLaneinfo_ = null;
                    onChanged();
                } else {
                    this.xpuLaneinfo_ = null;
                    this.xpuLaneinfoBuilder_ = null;
                }
                return this;
            }

            public laneinfo_list.Builder getXpuLaneinfoBuilder() {
                onChanged();
                return getXpuLaneinfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
            public laneinfo_listOrBuilder getXpuLaneinfoOrBuilder() {
                SingleFieldBuilderV3<laneinfo_list, laneinfo_list.Builder, laneinfo_listOrBuilder> singleFieldBuilderV3 = this.xpuLaneinfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                laneinfo_list laneinfo_listVar = this.xpuLaneinfo_;
                return laneinfo_listVar == null ? laneinfo_list.getDefaultInstance() : laneinfo_listVar;
            }

            private SingleFieldBuilderV3<laneinfo_list, laneinfo_list.Builder, laneinfo_listOrBuilder> getXpuLaneinfoFieldBuilder() {
                if (this.xpuLaneinfoBuilder_ == null) {
                    this.xpuLaneinfoBuilder_ = new SingleFieldBuilderV3<>(getXpuLaneinfo(), getParentForChildren(), isClean());
                    this.xpuLaneinfo_ = null;
                }
                return this.xpuLaneinfoBuilder_;
            }

            @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
            public boolean hasTimestamp() {
                return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
            public Time getTimestamp() {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Time time = this.timestamp_;
                    return time == null ? Time.getDefaultInstance() : time;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setTimestamp(Time time) {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
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

            public Builder setTimestamp(Time.Builder builder) {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.timestamp_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeTimestamp(Time time) {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Time time2 = this.timestamp_;
                    if (time2 != null) {
                        this.timestamp_ = Time.newBuilder(time2).mergeFrom(time).buildPartial();
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

            public Time.Builder getTimestampBuilder() {
                onChanged();
                return getTimestampFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
            public TimeOrBuilder getTimestampOrBuilder() {
                SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Time time = this.timestamp_;
                return time == null ? Time.getDefaultInstance() : time;
            }

            private SingleFieldBuilderV3<Time, Time.Builder, TimeOrBuilder> getTimestampFieldBuilder() {
                if (this.timestampBuilder_ == null) {
                    this.timestampBuilder_ = new SingleFieldBuilderV3<>(getTimestamp(), getParentForChildren(), isClean());
                    this.timestamp_ = null;
                }
                return this.timestampBuilder_;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.Primitives.MapFusionLanesForScuOrBuilder
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
                this.bitField0_ &= -5;
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

        public static MapFusionLanesForScu getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MapFusionLanesForScu> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MapFusionLanesForScu> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MapFusionLanesForScu getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010primitives.proto\u0012\u000fxpilot.sr.proto\" \n\bVector2D\u0012\t\n\u0001x\u0018\u0001 \u0001(\u0001\u0012\t\n\u0001y\u0018\u0002 \u0001(\u0001\"+\n\bVector3D\u0012\t\n\u0001x\u0018\u0001 \u0001(\u0001\u0012\t\n\u0001y\u0018\u0002 \u0001(\u0001\u0012\t\n\u0001z\u0018\u0003 \u0001(\u0001\"'\n\u0006Size2D\u0012\u000e\n\u0006length\u0018\u0001 \u0001(\u0002\u0012\r\n\u0005width\u0018\u0002 \u0001(\u0002\"7\n\u0006Size3D\u0012\u000e\n\u0006length\u0018\u0001 \u0001(\u0002\u0012\r\n\u0005width\u0018\u0002 \u0001(\u0002\u0012\u000e\n\u0006height\u0018\u0003 \u0001(\u0002\"<\n\nQuaternion\u0012\n\n\u0002qx\u0018\u0001 \u0001(\u0001\u0012\n\n\u0002qy\u0018\u0002 \u0001(\u0001\u0012\n\n\u0002qz\u0018\u0003 \u0001(\u0001\u0012\n\n\u0002qw\u0018\u0004 \u0001(\u0001\"\"\n\bWayPoint\u0012\u0016\n\u000elocal_waypoint\u0018\u0001 \u0003(\u0002\"5\n\tPolygon3D\u0012(\n\u0005point\u0018\u0001 \u0003(\u000b2\u0019.xpilot.sr.proto.Vector3D\"\u0015\n\u0004Time\u0012\r\n\u0005nsecs\u0018\u0001 \u0001(\u0004\"X\n\bPose6DOF\u0012$\n\u0001p\u0018\u0001 \u0001(\u000b2\u0019.xpilot.sr.proto.Vector3D\u0012&\n\u0001q\u0018\u0002 \u0001(\u000b2\u001b.xpilot.sr.proto.Quaternion\"Å\u0001\n\tEgoMotion\u0012\u0012\n\nlocal_pose\u0018\u0001 \u0003(\u0002\u0012\u0016\n\u000elocal_velocity\u0018\u0002 \u0003(\u0002\u0012\u0018\n\u0010local_pose_sigma\u0018\u0003 \u0003(\u0002\u0012\u001c\n\u0014local_velocity_sigma\u0018\u0004 \u0003(\u0002\u0012\u000f\n\u0007ego_yaw\u0018\u0005 \u0001(\u0002\u0012\u0013\n\u000bego_yaw_std\u0018\u0006 \u0001(\u0002\u0012\u0014\n\fego_yaw_rate\u0018\u0007 \u0001(\u0002\u0012\u0018\n\u0010ego_yaw_rate_std\u0018\b \u0001(\u0002\"-\n\nTrajectory\u0012\t\n\u0001x\u0018\u0001 \u0001(\u0002\u0012\t\n\u0001y\u0018\u0002 \u0001(\u0002\u0012\t\n\u0001z\u0018\u0003 \u0001(\u0002\"M\n\u000eMotionPlanning\u0012,\n\u0007traject\u0018\u0001 \u0003(\u000b2\u001b.xpilot.sr.proto.Trajectory\u0012\r\n\u0005spare\u0018\u0002 \u0003(\u0002\"¿\u0006\n\u0013XPU_AssistSysSt_msg\u0012\u0014\n\fxpu_xpilotst\u0018\u0001 \u0001(\u0005\u0012\u0019\n\u0011xpu_latctrlremind\u0018\u0002 \u0001(\u0005\u0012\u001a\n\u0012xpu_longctrlremind\u0018\u0003 \u0001(\u0005\u0012\u001a\n\u0012xpu_latctrlremind2\u0018\u0004 \u0001(\u0005\u0012\u001d\n\u0015xpu_longendctrlreason\u0018\u0005 \u0001(\u0005\u0012 \n\u0018xpu_lateralendctrlreason\u0018\u0006 \u0001(\u0005\u0012\u0011\n\txpu_hwpst\u0018\u0007 \u0001(\u0005\u0012\u0011\n\txpu_accst\u0018\b \u0001(\u0005\u0012\u0011\n\txpu_ngpst\u0018\t \u0001(\u0005\u0012\u0011\n\txpu_cipst\u0018\n \u0001(\u0005\u0012\u0019\n\u0011xpu_cip_warningst\u0018\u000b \u0001(\u0005\u0012\u0011\n\txpu_dsmst\u0018\f \u0001(\u0005\u0012\u0011\n\txpu_lccst\u0018\r \u0001(\u0005\u0012\u001c\n\u0014xpu_cruisespdsetdisp\u0018\u000e \u0001(\u0002\u0012\u0011\n\txpu_atcst\u0018\u000f \u0001(\u0005\u0012\u001a\n\u0012xpu_timegapsetdisp\u0018\u0010 \u0001(\u0005\u0012\u0017\n\u000fxpu_cruiseobjst\u0018\u0011 \u0001(\b\u0012\u0012\n\nxpu_islcst\u0018\u0012 \u0001(\u0005\u0012\u0011\n\txpu_tsrst\u0018\u0013 \u0001(\u0005\u0012\u0014\n\fxpu_tsrsign1\u0018\u0014 \u0001(\u0005\u0012\u0014\n\fxpu_tsrsign2\u0018\u0015 \u0001(\u0005\u0012\u0014\n\fxpu_tsrsign3\u0018\u0016 \u0001(\u0005\u0012\u0018\n\u0010xpu_cdu_ulcstate\u0018\u0017 \u0001(\u0005\u0012\u001d\n\u0015xpu_cdu_ulcconfirmreq\u0018\u0018 \u0001(\u0005\u0012\u001a\n\u0012xpu_cdu_ulcwarning\u0018\u0019 \u0001(\u0005\u0012\u0011\n\txpu_alcst\u0018\u001a \u0001(\u0005\u0012\u0018\n\u0010xpu_alcdirection\u0018\u001b \u0001(\u0005\u0012%\n\u001dxpu_alctarlaneendcenterpointy\u0018\u001c \u0001(\u0002\u0012%\n\u001dxpu_alctarlaneendcenterpointx\u0018\u001d \u0001(\u0002\u0012\u0019\n\u0011xpu_alcctrlremind\u0018\u001e \u0001(\u0005\u0012\u0014\n\fxpu_alcst_pg\u0018\u001f \u0001(\u0005\u0012!\n\u0019xpu_assistsysst_msgsender\u0018  \u0001(\u0005\"-\n\u0003Wgs\u0012\u000b\n\u0003lat\u0018\u0001 \u0001(\u0001\u0012\u000b\n\u0003lng\u0018\u0002 \u0001(\u0001\u0012\f\n\u0004elev\u0018\u0003 \u0001(\u0001\"s\n\u000eGlobalPoseInfo\u0012(\n\nworld_pose\u0018\u0001 \u0001(\u000b2\u0014.xpilot.sr.proto.Wgs\u0012(\n\ttimestamp\u0018\u0002 \u0001(\u000b2\u0015.xpilot.sr.proto.Time\u0012\r\n\u0005spare\u0018\u0003 \u0003(\u0002\"\u0082\u000b\n\u000fStateManagement\u0012 \n\u0018rdmodulecom_localization\u0018\u0001 \u0001(\u0005\u0012 \n\u0018rdmodulecom_sensorfusion\u0018\u0002 \u0001(\u0005\u0012!\n\u0019rdmodulecom_referenceline\u0018\u0003 \u0001(\u0005\u0012\"\n\u001ardmodulecom_motionplanning\u0018\u0004 \u0001(\u0005\u0012$\n\u001crdmodulecom_behaviorplanning\u0018\u0005 \u0001(\u0005\u0012\u0017\n\u000frdmodulecom_vlc\u0018\u0006 \u0001(\u0005\u0012\u001b\n\u0013rdmodulecom_accctrl\u0018\u0007 \u0001(\u0005\u0012\u001b\n\u0013rdmodulecom_lkactrl\u0018\b \u0001(\u0005\u0012\"\n\u001ardmodulecom_CruiseLeverTHW\u0018\t \u0001(\u0005\u0012 \n\u0018rdmodulecom_CruiseVehSpd\u0018\n \u0001(\u0005\u0012\u001b\n\u0013rdmodulecom_AccHold\u0018\u000b \u0001(\u0005\u0012\u001e\n\u0016rdmodulecom_ACC_Mode_1\u0018\f \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_LKA_MODE\u0018\r \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_longctrl\u0018\u000e \u0001(\u0005\u0012\u001f\n\u0017rdmodulecom_lateralctrl\u0018\u000f \u0001(\u0005\u0012 \n\u0018rdmodulecom_steeringctrl\u0018\u0010 \u0001(\u0005\u0012\u0017\n\u000frdmodulecom_wos\u0018\u0011 \u0001(\u0005\u0012\u001d\n\u0015rdmodulecom_turnstate\u0018\u0012 \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_alcstate\u0018\u0013 \u0001(\u0005\u0012\u001b\n\u0013rdmodulecom_ngpmode\u0018\u0014 \u0001(\u0005\u0012\u001b\n\u0013rdmodulecom_alcmode\u0018\u0015 \u0001(\u0005\u0012\u001b\n\u0013rdmodulecom_lccmode\u0018\u0016 \u0001(\u0005\u0012\u001b\n\u0013rdmodulecom_accmode\u0018\u0017 \u0001(\u0005\u0012\u001b\n\u0013rdmodulecom_ngpflag\u0018\u0018 \u0001(\u0005\u0012!\n\u0019rdmodulecom_function_mode\u0018\u0019 \u0001(\u0005\u0012#\n\u001brdmodulecom_cruisevehSpd_st\u0018\u001a \u0001(\u0002\u0012\u0017\n\u000fXPU_SR_NGP_View\u0018\u001b \u0001(\u0005\u0012!\n\u0019rdmodulecom_ulc_turnstate\u0018\u001c \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_ulcstate\u0018\u001d \u0001(\u0005\u0012%\n\u001drdmodulecom_ulc_needtocomfirm\u0018\u001e \u0001(\u0005\u0012\u001b\n\u0013rdmodulecom_9_state\u0018\u001f \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_10_state\u0018  \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_11_state\u0018! \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_12_state\u0018\" \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_13_state\u0018# \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_14_state\u0018$ \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_15_state\u0018% \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_16_state\u0018& \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_17_state\u0018' \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_18_state\u0018( \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_19_state\u0018) \u0001(\u0005\u0012\u001c\n\u0014rdmodulecom_20_state\u0018* \u0001(\u0005\u0012\u0015\n\rsr_display_st\u0018+ \u0001(\u0005\u0012\u0015\n\rrf_line_color\u0018, \u0001(\u0005\u0012\u0015\n\rXPU_SR_LCView\u0018- \u0001(\u0005\u0012\r\n\u0005spare\u0018. \u0003(\u0002\"â\u0002\n\u0014lanelineinfo_xpu2scu\u0012\u000e\n\u0006laneid\u0018\u0001 \u0001(\u0005\u0012\u0013\n\u000blanestartdx\u0018\u0002 \u0001(\u0002\u0012\u0016\n\u000elanestartdxstd\u0018\u0003 \u0001(\u0002\u0012\u0011\n\tlaneenddx\u0018\u0004 \u0001(\u0002\u0012\u0014\n\flaneenddxstd\u0018\u0005 \u0001(\u0002\u0012\u0015\n\rlaneexistprob\u0018\u0006 \u0001(\u0005\u0012\u0010\n\blanetype\u0018\u0007 \u0001(\u0005\u0012\u0014\n\flanetypeprob\u0018\b \u0001(\u0005\u00121\n\tlanecolor\u0018\t \u0001(\u000e2\u001e.xpilot.sr.proto.lanelinecolor\u0012\u0014\n\flanedisty_c0\u0018\n \u0001(\u0002\u0012\u0017\n\u000flaneyawangle_c1\u0018\u000b \u0001(\u0002\u0012\u0014\n\flanecurve_c2\u0018\f \u0001(\u0002\u0012\u001a\n\u0012lanecurvechange_c3\u0018\r \u0001(\u0002\u0012\u0011\n\tlanewidth\u0018\u000e \u0001(\u0002\"ð\u0003\n\rlaneinfo_list\u0012\u0013\n\u000bis_straddle\u0018\u0001 \u0001(\b\u0012\u0013\n\u000blaneinfovd1\u0018\u0002 \u0001(\b\u0012\u0013\n\u000blaneinfovd2\u0018\u0003 \u0001(\b\u0012\u0013\n\u000blaneinfovd3\u0018\u0004 \u0001(\b\u0012\u0019\n\u0011LaneShape_Locat_x\u0018\u0005 \u0001(\u0002\u0012\u0019\n\u0011LaneShape_Locat_y\u0018\u0006 \u0001(\u0002\u0012\u001d\n\u0015LaneShape_locat_theta\u0018\u0007 \u0001(\u0002\u00122\n\u0003le1\u0018\b \u0001(\u000b2%.xpilot.sr.proto.lanelineinfo_xpu2scu\u00122\n\u0003ri1\u0018\t \u0001(\u000b2%.xpilot.sr.proto.lanelineinfo_xpu2scu\u00122\n\u0003le2\u0018\n \u0001(\u000b2%.xpilot.sr.proto.lanelineinfo_xpu2scu\u00122\n\u0003ri2\u0018\u000b \u0001(\u000b2%.xpilot.sr.proto.lanelineinfo_xpu2scu\u00122\n\u0003le3\u0018\f \u0001(\u000b2%.xpilot.sr.proto.lanelineinfo_xpu2scu\u00122\n\u0003ri3\u0018\r \u0001(\u000b2%.xpilot.sr.proto.lanelineinfo_xpu2scu\"\u0085\u0001\n\u0014MapFusionLanesForScu\u00124\n\fxpu_laneinfo\u0018\u0001 \u0001(\u000b2\u001e.xpilot.sr.proto.laneinfo_list\u0012(\n\ttimestamp\u0018\u0002 \u0001(\u000b2\u0015.xpilot.sr.proto.Time\u0012\r\n\u0005spare\u0018\u0003 \u0003(\u0002*¢\u0003\n\fLaneLineType\u0012\u0015\n\u0011LINE_TYPE_UNKNOWN\u0010\u0000\u0012\u001a\n\u0016LINE_TYPE_SINGLE_SOLID\u0010\u0001\u0012\u001b\n\u0017LINE_TYPE_SINGLE_DASHED\u0010\u0002\u0012\u001a\n\u0016LINE_TYPE_DOUBLE_SOLID\u0010\u0003\u0012\u001b\n\u0017LINE_TYPE_DOUBLE_DASHED\u0010\u0004\u0012%\n!LINE_TYPE_LEFT_SOLID_RIGHT_DASHED\u0010\u0005\u0012%\n!LINE_TYPE_RIGHT_SOLID_LEFT_DASHED\u0010\u0006\u0012\u0019\n\u0015LINE_TYPE_SHADED_AREA\u0010\u0007\u0012\u0015\n\u0011LINE_TYPE_VIRTUAL\u0010\b\u0012\u0012\n\u000eLINE_TYPE_CURB\u0010\t\u0012\u0012\n\u000eLINE_TYPE_BOLT\u0010\n\u0012\u0019\n\u0015LINE_TYPE_DASHED_SLOW\u0010\u000b\u0012\u0018\n\u0014LINE_TYPE_SOLID_SLOW\u0010\f\u0012\u0016\n\u0012LINE_TYPE_OBSTACLE\u0010\r\u0012\u0014\n\u0010LINE_TYPE_OTHERS\u0010\u000e*\u009d\u0001\n\bLaneType\u0012\u0014\n\u0010LaneType_Unknown\u0010\u0000\u0012\u001c\n\u0018LaneType_NormalDriveable\u0010\u0001\u0012\u0015\n\u0011LaneType_Shoulder\u0010\u0002\u0012\u0013\n\u000fLaneType_OnRamp\u0010\u0003\u0012\u0019\n\u0015LaneType_Deceleration\u0010\u0004\u0012\u0016\n\u0012LaneType_Emergency\u0010\b*Ô\u0002\n\nLaneType_P\u0012\f\n\bEGO_LANE\u0010\u0000\u0012\r\n\tLEFT_LANE\u0010\u0001\u0012\u000e\n\nRIGHT_LANE\u0010\u0002\u0012\u0018\n\u0014EGO_ASSIST_LANE_LEFT\u0010\u0003\u0012\u0019\n\u0015EGO_ASSIST_LANE_RIGHT\u0010\u0004\u0012\u0013\n\u000fEGO_FORK_LANE_1\u0010\u0005\u0012\u0013\n\u000fEGO_FORK_LANE_2\u0010\u0006\u0012\u0013\n\u000fEGO_FORK_LANE_3\u0010\u0007\u0012\u0011\n\rEGO_WIDE_LANE\u0010\b\u0012\u0016\n\u0012EGO_WIDE_LANE_LEFT\u0010\t\u0012\u0017\n\u0013EGO_WIDE_LANE_RIGHT\u0010\n\u0012\f\n\bADJACENT\u0010\u000b\u0012\u0015\n\u0011ADJACENT_ADJACENT\u0010\f\u0012\u0016\n\u0012ADJACENT_FORK_LEFT\u0010\r\u0012\u0017\n\u0013ADJACENT_FORK_RIGHT\u0010\u000e\u0012\u000b\n\u0007MAX_NUM\u0010\u000f*¿\u0002\n\u0010LaneTurnSignType\u0012\u0015\n\u0011TURN_SING_UNKNOWN\u0010\u0000\u0012\u0019\n\u0015TURN_SING_GO_STARIGHT\u0010\u0001\u0012\u0012\n\u000eTURN_SING_LEFT\u0010\u0002\u0012\u0013\n\u000fTURN_SING_RIGHT\u0010\u0003\u0012\u000f\n\u000bTURN_SING_U\u0010\u0004\u0012\u001b\n\u0017TURN_SING_STRAIGHT_LEFT\u0010\u0005\u0012\u001c\n\u0018TURN_SING_STRAIGHT_RIGHT\u0010\u0006\u0012!\n\u001dTURN_SING_STRAIGHT_LEFT_RIGHT\u0010\u0007\u0012\u0014\n\u0010TURN_SING_LEFT_U\u0010\b\u0012\u0018\n\u0014TURN_SING_LEFT_RIGHT\u0010\t\u0012\u0018\n\u0014TURN_SING_STRAIGHT_U\u0010\n\u0012\u0017\n\u0013TURN_SING_SLOW_DOWN\u0010\u000b*§\u0002\n\rLaneLineColor\u0012\u0016\n\u0012LINE_COLOR_UNKNOWN\u0010\u0000\u0012\u0014\n\u0010LINE_COLOR_WHITE\u0010\u0001\u0012\u0015\n\u0011LINE_COLOR_YELLOW\u0010\u0002\u0012\u0015\n\u0011LINE_COLOR_ORANGE\u0010\u0003\u0012\u0013\n\u000fLINE_COLOR_BLUE\u0010\u0004\u0012\u0014\n\u0010LINE_COLOR_GREEN\u0010\u0005\u0012\u0013\n\u000fLINE_COLOR_GRAY\u0010\u0006\u0012%\n!LINE_COLOR_LEFT_GRAY_RIGHT_YELLOW\u0010\u0007\u0012&\n\"LINE_COLOR_LEFT_YELLOW_RIGHT_WHITE\u0010\b\u0012\u0014\n\u0010LINE_COLOR_BLACK\u0010\t\u0012\u0015\n\u0011LINE_COLOR_OTHERS\u0010\n*\u0085\u0002\n\nObjectType\u0012\u0014\n\u0010OBJ_TYPE_UNKNOWN\u0010\u0000\u0012\u0013\n\u000fOBJ_TYPE_PERSON\u0010\u0001\u0012\u0013\n\u000fOBJ_TYPE_ANIMAL\u0010\u0002\u0012\u0012\n\u000eOBJ_TYPE_SEDAN\u0010\u0003\u0012\u0010\n\fOBJ_TYPE_SUV\u0010\u0004\u0012\u0010\n\fOBJ_TYPE_VAN\u0010\u0005\u0012\u0014\n\u0010OBJ_TYPE_BICYCLE\u0010\u0006\u0012\u0015\n\u0011OBJ_TYPE_TRICYCLE\u0010\u0007\u0012\u0017\n\u0013OBJ_TYPE_MOTORCYCLE\u0010\b\u0012\u0012\n\u000eOBJ_TYPE_TRUCK\u0010\t\u0012\u0010\n\fOBJ_TYPE_BUS\u0010\n\u0012\u0013\n\u000fOBJ_TYPE_PICKUP\u0010\u000b*N\n\nBrakeLight\u0012\u0017\n\u0013BRAKE_LIGHT_UNKNOWN\u0010\u0000\u0012\u0012\n\u000eBRAKE_LIGHT_ON\u0010\u0001\u0012\u0013\n\u000fBRAKE_LIGHT_OFF\u0010\u0002*\u0088\u0001\n\u000bSignalLight\u0012\u0018\n\u0014SIGNAL_LIGHT_UNKNOWN\u0010\u0000\u0012\u0015\n\u0011SIGNAL_LIGHT_LEFT\u0010\u0001\u0012\u0016\n\u0012SIGNAL_LIGHT_RIGHT\u0010\u0002\u0012\u001a\n\u0016SIGNAL_LIGHT_EMERGENCY\u0010\u0003\u0012\u0014\n\u0010SIGNAL_LIGHT_OFF\u0010\u0004*«\u0001\n\u0010RelativePosition\u0012\u0018\n\u0014RELATIVE_POS_UNKNOWN\u0010\u0000\u0012\u0017\n\u0013RELATIVE_POS_CENTER\u0010\u0001\u0012\u0015\n\u0011RELATIVE_POS_LEFT\u0010\u0002\u0012\u0019\n\u0015RELATIVE_POS_FAR_LEFT\u0010\u0003\u0012\u0016\n\u0012RELATIVE_POS_RIGHT\u0010\u0004\u0012\u001a\n\u0016RELATIVE_POS_FAR_RIGHT\u0010\u0005*n\n\u0006LaneID\u0012\u000f\n\u000bLANT_ID_EGO\u0010\u0000\u0012\u0010\n\fLANT_ID_LEFT\u0010\u0001\u0012\u0011\n\rLANT_ID_RIGHT\u0010\u0002\u0012\u0015\n\u0011LANT_ID_LEFT_LEFT\u0010\u0003\u0012\u0017\n\u0013LANT_ID_RIGHT_RIGHT\u0010\u0004*\u009c\u0001\n\nLaneLineID\u0012\u0010\n\fLINE_ID_LEFT\u0010\u0000\u0012\u0011\n\rLINE_ID_RIGHT\u0010\u0001\u0012\u0015\n\u0011LINE_ID_LEFT_LEFT\u0010\u0002\u0012\u0017\n\u0013LINE_ID_RIGHT_RIGHT\u0010\u0003\u0012\u001a\n\u0016LINE_ID_LEFT_LEFT_LEFT\u0010\u0004\u0012\u001d\n\u0019LINE_ID_RIGHT_RIGHT_RIGHT\u0010\u0005*B\n\u0010StaticObjectType\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\b\n\u0004CONE\u0010\u0001\u0012\n\n\u0006BARREL\u0010\u0002\u0012\u000b\n\u0007BARRIER\u0010\u0003*F\n\rlanelinecolor\u0012\u000b\n\u0007unknown\u0010\u0000\u0012\t\n\u0005WHITE\u0010\u0001\u0012\n\n\u0006YELLOW\u0010\u0002\u0012\u0007\n\u0003RED\u0010\u0003\u0012\b\n\u0004BLUE\u0010\u0004b\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.Primitives.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Primitives.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_Vector2D_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_Vector2D_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Vector2D_descriptor, new String[]{"X", "Y"});
        internal_static_xpilot_sr_proto_Vector3D_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_xpilot_sr_proto_Vector3D_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Vector3D_descriptor, new String[]{"X", "Y", "Z"});
        internal_static_xpilot_sr_proto_Size2D_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_xpilot_sr_proto_Size2D_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Size2D_descriptor, new String[]{"Length", "Width"});
        internal_static_xpilot_sr_proto_Size3D_descriptor = getDescriptor().getMessageTypes().get(3);
        internal_static_xpilot_sr_proto_Size3D_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Size3D_descriptor, new String[]{"Length", "Width", "Height"});
        internal_static_xpilot_sr_proto_Quaternion_descriptor = getDescriptor().getMessageTypes().get(4);
        internal_static_xpilot_sr_proto_Quaternion_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Quaternion_descriptor, new String[]{"Qx", "Qy", "Qz", "Qw"});
        internal_static_xpilot_sr_proto_WayPoint_descriptor = getDescriptor().getMessageTypes().get(5);
        internal_static_xpilot_sr_proto_WayPoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_WayPoint_descriptor, new String[]{"LocalWaypoint"});
        internal_static_xpilot_sr_proto_Polygon3D_descriptor = getDescriptor().getMessageTypes().get(6);
        internal_static_xpilot_sr_proto_Polygon3D_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Polygon3D_descriptor, new String[]{"Point"});
        internal_static_xpilot_sr_proto_Time_descriptor = getDescriptor().getMessageTypes().get(7);
        internal_static_xpilot_sr_proto_Time_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Time_descriptor, new String[]{"Nsecs"});
        internal_static_xpilot_sr_proto_Pose6DOF_descriptor = getDescriptor().getMessageTypes().get(8);
        internal_static_xpilot_sr_proto_Pose6DOF_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Pose6DOF_descriptor, new String[]{"P", "Q"});
        internal_static_xpilot_sr_proto_EgoMotion_descriptor = getDescriptor().getMessageTypes().get(9);
        internal_static_xpilot_sr_proto_EgoMotion_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_EgoMotion_descriptor, new String[]{"LocalPose", "LocalVelocity", "LocalPoseSigma", "LocalVelocitySigma", "EgoYaw", "EgoYawStd", "EgoYawRate", "EgoYawRateStd"});
        internal_static_xpilot_sr_proto_Trajectory_descriptor = getDescriptor().getMessageTypes().get(10);
        internal_static_xpilot_sr_proto_Trajectory_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Trajectory_descriptor, new String[]{"X", "Y", "Z"});
        internal_static_xpilot_sr_proto_MotionPlanning_descriptor = getDescriptor().getMessageTypes().get(11);
        internal_static_xpilot_sr_proto_MotionPlanning_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_MotionPlanning_descriptor, new String[]{"Traject", "Spare"});
        internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_descriptor = getDescriptor().getMessageTypes().get(12);
        internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_XPU_AssistSysSt_msg_descriptor, new String[]{"XpuXpilotst", "XpuLatctrlremind", "XpuLongctrlremind", "XpuLatctrlremind2", "XpuLongendctrlreason", "XpuLateralendctrlreason", "XpuHwpst", "XpuAccst", "XpuNgpst", "XpuCipst", "XpuCipWarningst", "XpuDsmst", "XpuLccst", "XpuCruisespdsetdisp", "XpuAtcst", "XpuTimegapsetdisp", "XpuCruiseobjst", "XpuIslcst", "XpuTsrst", "XpuTsrsign1", "XpuTsrsign2", "XpuTsrsign3", "XpuCduUlcstate", "XpuCduUlcconfirmreq", "XpuCduUlcwarning", "XpuAlcst", "XpuAlcdirection", "XpuAlctarlaneendcenterpointy", "XpuAlctarlaneendcenterpointx", "XpuAlcctrlremind", "XpuAlcstPg", "XpuAssistsysstMsgsender"});
        internal_static_xpilot_sr_proto_Wgs_descriptor = getDescriptor().getMessageTypes().get(13);
        internal_static_xpilot_sr_proto_Wgs_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Wgs_descriptor, new String[]{"Lat", "Lng", "Elev"});
        internal_static_xpilot_sr_proto_GlobalPoseInfo_descriptor = getDescriptor().getMessageTypes().get(14);
        internal_static_xpilot_sr_proto_GlobalPoseInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_GlobalPoseInfo_descriptor, new String[]{"WorldPose", "Timestamp", "Spare"});
        internal_static_xpilot_sr_proto_StateManagement_descriptor = getDescriptor().getMessageTypes().get(15);
        internal_static_xpilot_sr_proto_StateManagement_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_StateManagement_descriptor, new String[]{"RdmodulecomLocalization", "RdmodulecomSensorfusion", "RdmodulecomReferenceline", "RdmodulecomMotionplanning", "RdmodulecomBehaviorplanning", "RdmodulecomVlc", "RdmodulecomAccctrl", "RdmodulecomLkactrl", "RdmodulecomCruiseLeverTHW", "RdmodulecomCruiseVehSpd", "RdmodulecomAccHold", "RdmodulecomACCMode1", "RdmodulecomLKAMODE", "RdmodulecomLongctrl", "RdmodulecomLateralctrl", "RdmodulecomSteeringctrl", "RdmodulecomWos", "RdmodulecomTurnstate", "RdmodulecomAlcstate", "RdmodulecomNgpmode", "RdmodulecomAlcmode", "RdmodulecomLccmode", "RdmodulecomAccmode", "RdmodulecomNgpflag", "RdmodulecomFunctionMode", "RdmodulecomCruisevehSpdSt", "XPUSRNGPView", "RdmodulecomUlcTurnstate", "RdmodulecomUlcstate", "RdmodulecomUlcNeedtocomfirm", "Rdmodulecom9State", "Rdmodulecom10State", "Rdmodulecom11State", "Rdmodulecom12State", "Rdmodulecom13State", "Rdmodulecom14State", "Rdmodulecom15State", "Rdmodulecom16State", "Rdmodulecom17State", "Rdmodulecom18State", "Rdmodulecom19State", "Rdmodulecom20State", "SrDisplaySt", "RfLineColor", "XPUSRLCView", "Spare"});
        internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_descriptor = getDescriptor().getMessageTypes().get(16);
        internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_lanelineinfo_xpu2scu_descriptor, new String[]{"Laneid", "Lanestartdx", "Lanestartdxstd", "Laneenddx", "Laneenddxstd", "Laneexistprob", "Lanetype", "Lanetypeprob", "Lanecolor", "LanedistyC0", "LaneyawangleC1", "LanecurveC2", "LanecurvechangeC3", "Lanewidth"});
        internal_static_xpilot_sr_proto_laneinfo_list_descriptor = getDescriptor().getMessageTypes().get(17);
        internal_static_xpilot_sr_proto_laneinfo_list_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_laneinfo_list_descriptor, new String[]{"IsStraddle", "Laneinfovd1", "Laneinfovd2", "Laneinfovd3", "LaneShapeLocatX", "LaneShapeLocatY", "LaneShapeLocatTheta", "Le1", "Ri1", "Le2", "Ri2", "Le3", "Ri3"});
        internal_static_xpilot_sr_proto_MapFusionLanesForScu_descriptor = getDescriptor().getMessageTypes().get(18);
        internal_static_xpilot_sr_proto_MapFusionLanesForScu_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_MapFusionLanesForScu_descriptor, new String[]{"XpuLaneinfo", "Timestamp", "Spare"});
    }
}
