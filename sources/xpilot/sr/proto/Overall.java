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
import lane.auto_pilot.data.AutoPilotDataOuterClass;
import xpilot.sr.proto.DynamicEnvironmentOuterClass;
import xpilot.sr.proto.Imudata;
import xpilot.sr.proto.LocalPose;
import xpilot.sr.proto.Nmeadata;
import xpilot.sr.proto.Posrtkimu;
import xpilot.sr.proto.Primitives;
import xpilot.sr.proto.StaticEnvironmentOuterClass;
/* loaded from: classes4.dex */
public final class Overall {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_gnss_cdutime_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_gnss_cdutime_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_imu_cdutime_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_imu_cdutime_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_imu_nmea_forSrservice_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_imu_nmea_forSrservice_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_overall_cdutime_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_overall_cdutime_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_overall_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_overall_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_overall_gaode_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_overall_gaode_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_overall_imu_nmea_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_overall_imu_nmea_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_save_sr_overall_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_save_sr_overall_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_total_overall_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_total_overall_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_total_xpu_overall_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_total_xpu_overall_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_xpu_data_to_app_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_xpu_data_to_app_fieldAccessorTable;

    /* loaded from: classes4.dex */
    public interface gnss_cdutimeOrBuilder extends MessageOrBuilder {
        long getCduTime(int i);

        int getCduTimeCount();

        List<Long> getCduTimeList();

        Nmeadata.NmeadataInfo getNmeadataInfo(int i);

        int getNmeadataInfoCount();

        List<Nmeadata.NmeadataInfo> getNmeadataInfoList();

        Nmeadata.NmeadataInfoOrBuilder getNmeadataInfoOrBuilder(int i);

        List<? extends Nmeadata.NmeadataInfoOrBuilder> getNmeadataInfoOrBuilderList();
    }

    /* loaded from: classes4.dex */
    public interface imu_cdutimeOrBuilder extends MessageOrBuilder {
        long getCduTime(int i);

        int getCduTimeCount();

        List<Long> getCduTimeList();

        Imudata.ImuInfo getImuInfo(int i);

        int getImuInfoCount();

        List<Imudata.ImuInfo> getImuInfoList();

        Imudata.ImuInfoOrBuilder getImuInfoOrBuilder(int i);

        List<? extends Imudata.ImuInfoOrBuilder> getImuInfoOrBuilderList();
    }

    /* loaded from: classes4.dex */
    public interface imu_nmea_forSrserviceOrBuilder extends MessageOrBuilder {
        imu_cdutime getImuInfoOverall();

        imu_cdutimeOrBuilder getImuInfoOverallOrBuilder();

        gnss_cdutime getNmeadataInfoOverall();

        gnss_cdutimeOrBuilder getNmeadataInfoOverallOrBuilder();

        boolean hasImuInfoOverall();

        boolean hasNmeadataInfoOverall();
    }

    /* loaded from: classes4.dex */
    public interface overallOrBuilder extends MessageOrBuilder {
        DynamicEnvironmentOuterClass.BPoutput getBpInfo();

        DynamicEnvironmentOuterClass.BPoutputOrBuilder getBpInfoOrBuilder();

        DynamicEnvironmentOuterClass.DynamicEnvironment getDynamicInfo();

        DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder getDynamicInfoOrBuilder();

        Posrtkimu.Gaode_Info getGaodeInfo();

        Posrtkimu.Gaode_InfoOrBuilder getGaodeInfoOrBuilder();

        Primitives.GlobalPoseInfo getGpInfo();

        Primitives.GlobalPoseInfoOrBuilder getGpInfoOrBuilder();

        LocalPose.LocalPoseInfo getLocalPose();

        LocalPose.LocalPoseInfoOrBuilder getLocalPoseOrBuilder();

        Primitives.MapFusionLanesForScu getMfLaneInfo();

        Primitives.MapFusionLanesForScuOrBuilder getMfLaneInfoOrBuilder();

        Primitives.MotionPlanning getMpInfo();

        Primitives.MotionPlanningOrBuilder getMpInfoOrBuilder();

        int getSaveProtoSignal();

        Primitives.StateManagement getSmInfo();

        Primitives.StateManagementOrBuilder getSmInfoOrBuilder();

        int getSrDisplaySt();

        StaticEnvironmentOuterClass.StaticEnvironment getStaticInfo();

        StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder getStaticInfoOrBuilder();

        int getUseLastMp();

        int getUseLastSfbp();

        ByteString getXpEhpVersion();

        ByteString getXpPosInfo();

        boolean hasBpInfo();

        boolean hasDynamicInfo();

        boolean hasGaodeInfo();

        boolean hasGpInfo();

        boolean hasLocalPose();

        boolean hasMfLaneInfo();

        boolean hasMpInfo();

        boolean hasSmInfo();

        boolean hasStaticInfo();
    }

    /* loaded from: classes4.dex */
    public interface overall_cdutimeOrBuilder extends MessageOrBuilder {
        long getCduTime(int i);

        int getCduTimeCount();

        List<Long> getCduTimeList();

        overall_gaode getOverallGaode(int i);

        int getOverallGaodeCount();

        List<overall_gaode> getOverallGaodeList();

        overall_gaodeOrBuilder getOverallGaodeOrBuilder(int i);

        List<? extends overall_gaodeOrBuilder> getOverallGaodeOrBuilderList();
    }

    /* loaded from: classes4.dex */
    public interface overall_gaodeOrBuilder extends MessageOrBuilder {
        AutoPilotDataOuterClass.AutoPilotData getAutoPilotData();

        AutoPilotDataOuterClass.AutoPilotDataOrBuilder getAutoPilotDataOrBuilder();

        overall getOverall();

        overallOrBuilder getOverallOrBuilder();

        boolean hasAutoPilotData();

        boolean hasOverall();
    }

    /* loaded from: classes4.dex */
    public interface overall_imu_nmeaOrBuilder extends MessageOrBuilder {
        Imudata.ImuInfo getImuInfo();

        Imudata.ImuInfoOrBuilder getImuInfoOrBuilder();

        Nmeadata.NmeadataInfo getNmeadataInfo(int i);

        int getNmeadataInfoCount();

        List<Nmeadata.NmeadataInfo> getNmeadataInfoList();

        Nmeadata.NmeadataInfoOrBuilder getNmeadataInfoOrBuilder(int i);

        List<? extends Nmeadata.NmeadataInfoOrBuilder> getNmeadataInfoOrBuilderList();

        overall_gaode getOverallGaode();

        overall_gaodeOrBuilder getOverallGaodeOrBuilder();

        boolean hasImuInfo();

        boolean hasOverallGaode();
    }

    /* loaded from: classes4.dex */
    public interface save_sr_overallOrBuilder extends MessageOrBuilder {
        gnss_cdutime getGnssData();

        gnss_cdutimeOrBuilder getGnssDataOrBuilder();

        imu_cdutime getImuData();

        imu_cdutimeOrBuilder getImuDataOrBuilder();

        overall_cdutime getOverallData();

        overall_cdutimeOrBuilder getOverallDataOrBuilder();

        boolean hasGnssData();

        boolean hasImuData();

        boolean hasOverallData();
    }

    /* loaded from: classes4.dex */
    public interface total_overallOrBuilder extends MessageOrBuilder {
        overall getOverall(int i);

        int getOverallCount();

        List<overall> getOverallList();

        overallOrBuilder getOverallOrBuilder(int i);

        List<? extends overallOrBuilder> getOverallOrBuilderList();
    }

    /* loaded from: classes4.dex */
    public interface total_xpu_overallOrBuilder extends MessageOrBuilder {
        xpu_data_to_app getXpuOverall(int i);

        int getXpuOverallCount();

        List<xpu_data_to_app> getXpuOverallList();

        xpu_data_to_appOrBuilder getXpuOverallOrBuilder(int i);

        List<? extends xpu_data_to_appOrBuilder> getXpuOverallOrBuilderList();
    }

    /* loaded from: classes4.dex */
    public interface xpu_data_to_appOrBuilder extends MessageOrBuilder {
        AutoPilotDataOuterClass.AutoPilotData getAutoPilotData();

        AutoPilotDataOuterClass.AutoPilotDataOrBuilder getAutoPilotDataOrBuilder();

        long getCduTime();

        Imudata.ImuInfo getImuInfo();

        Imudata.ImuInfoOrBuilder getImuInfoOrBuilder();

        Nmeadata.NmeadataInfo getNmeadataInfo();

        Nmeadata.NmeadataInfoOrBuilder getNmeadataInfoOrBuilder();

        overall getOverall();

        overallOrBuilder getOverallOrBuilder();

        boolean hasAutoPilotData();

        boolean hasImuInfo();

        boolean hasNmeadataInfo();

        boolean hasOverall();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Overall() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes4.dex */
    public static final class overall extends GeneratedMessageV3 implements overallOrBuilder {
        public static final int BP_INFO_FIELD_NUMBER = 9;
        public static final int DYNAMIC_INFO_FIELD_NUMBER = 2;
        public static final int GAODE_INFO_FIELD_NUMBER = 8;
        public static final int GP_INFO_FIELD_NUMBER = 5;
        public static final int LOCAL_POSE_FIELD_NUMBER = 1;
        public static final int MF_LANE_INFO_FIELD_NUMBER = 7;
        public static final int MP_INFO_FIELD_NUMBER = 4;
        public static final int SAVE_PROTO_SIGNAL_FIELD_NUMBER = 11;
        public static final int SM_INFO_FIELD_NUMBER = 6;
        public static final int SR_DISPLAY_ST_FIELD_NUMBER = 10;
        public static final int STATIC_INFO_FIELD_NUMBER = 3;
        public static final int USE_LAST_MP_FIELD_NUMBER = 12;
        public static final int USE_LAST_SFBP_FIELD_NUMBER = 13;
        public static final int XP_EHP_VERSION_FIELD_NUMBER = 31;
        public static final int XP_POS_INFO_FIELD_NUMBER = 30;
        private static final long serialVersionUID = 0;
        private DynamicEnvironmentOuterClass.BPoutput bpInfo_;
        private DynamicEnvironmentOuterClass.DynamicEnvironment dynamicInfo_;
        private Posrtkimu.Gaode_Info gaodeInfo_;
        private Primitives.GlobalPoseInfo gpInfo_;
        private LocalPose.LocalPoseInfo localPose_;
        private byte memoizedIsInitialized;
        private Primitives.MapFusionLanesForScu mfLaneInfo_;
        private Primitives.MotionPlanning mpInfo_;
        private int saveProtoSignal_;
        private Primitives.StateManagement smInfo_;
        private int srDisplaySt_;
        private StaticEnvironmentOuterClass.StaticEnvironment staticInfo_;
        private int useLastMp_;
        private int useLastSfbp_;
        private ByteString xpEhpVersion_;
        private ByteString xpPosInfo_;
        private static final overall DEFAULT_INSTANCE = new overall();
        private static final Parser<overall> PARSER = new AbstractParser<overall>() { // from class: xpilot.sr.proto.Overall.overall.1
            @Override // com.google.protobuf.Parser
            public overall parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new overall(codedInputStream, extensionRegistryLite);
            }
        };

        private overall(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private overall() {
            this.memoizedIsInitialized = (byte) -1;
            this.srDisplaySt_ = 0;
            this.saveProtoSignal_ = 0;
            this.useLastMp_ = 0;
            this.useLastSfbp_ = 0;
            this.xpPosInfo_ = ByteString.EMPTY;
            this.xpEhpVersion_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private overall(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                LocalPose.LocalPoseInfo.Builder builder = this.localPose_ != null ? this.localPose_.toBuilder() : null;
                                this.localPose_ = (LocalPose.LocalPoseInfo) codedInputStream.readMessage(LocalPose.LocalPoseInfo.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.localPose_);
                                    this.localPose_ = builder.buildPartial();
                                } else {
                                    continue;
                                }
                            case 18:
                                DynamicEnvironmentOuterClass.DynamicEnvironment.Builder builder2 = this.dynamicInfo_ != null ? this.dynamicInfo_.toBuilder() : null;
                                this.dynamicInfo_ = (DynamicEnvironmentOuterClass.DynamicEnvironment) codedInputStream.readMessage(DynamicEnvironmentOuterClass.DynamicEnvironment.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.dynamicInfo_);
                                    this.dynamicInfo_ = builder2.buildPartial();
                                } else {
                                    continue;
                                }
                            case 26:
                                StaticEnvironmentOuterClass.StaticEnvironment.Builder builder3 = this.staticInfo_ != null ? this.staticInfo_.toBuilder() : null;
                                this.staticInfo_ = (StaticEnvironmentOuterClass.StaticEnvironment) codedInputStream.readMessage(StaticEnvironmentOuterClass.StaticEnvironment.parser(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.staticInfo_);
                                    this.staticInfo_ = builder3.buildPartial();
                                } else {
                                    continue;
                                }
                            case 34:
                                Primitives.MotionPlanning.Builder builder4 = this.mpInfo_ != null ? this.mpInfo_.toBuilder() : null;
                                this.mpInfo_ = (Primitives.MotionPlanning) codedInputStream.readMessage(Primitives.MotionPlanning.parser(), extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom(this.mpInfo_);
                                    this.mpInfo_ = builder4.buildPartial();
                                } else {
                                    continue;
                                }
                            case 42:
                                Primitives.GlobalPoseInfo.Builder builder5 = this.gpInfo_ != null ? this.gpInfo_.toBuilder() : null;
                                this.gpInfo_ = (Primitives.GlobalPoseInfo) codedInputStream.readMessage(Primitives.GlobalPoseInfo.parser(), extensionRegistryLite);
                                if (builder5 != null) {
                                    builder5.mergeFrom(this.gpInfo_);
                                    this.gpInfo_ = builder5.buildPartial();
                                } else {
                                    continue;
                                }
                            case 50:
                                Primitives.StateManagement.Builder builder6 = this.smInfo_ != null ? this.smInfo_.toBuilder() : null;
                                this.smInfo_ = (Primitives.StateManagement) codedInputStream.readMessage(Primitives.StateManagement.parser(), extensionRegistryLite);
                                if (builder6 != null) {
                                    builder6.mergeFrom(this.smInfo_);
                                    this.smInfo_ = builder6.buildPartial();
                                } else {
                                    continue;
                                }
                            case 58:
                                Primitives.MapFusionLanesForScu.Builder builder7 = this.mfLaneInfo_ != null ? this.mfLaneInfo_.toBuilder() : null;
                                this.mfLaneInfo_ = (Primitives.MapFusionLanesForScu) codedInputStream.readMessage(Primitives.MapFusionLanesForScu.parser(), extensionRegistryLite);
                                if (builder7 != null) {
                                    builder7.mergeFrom(this.mfLaneInfo_);
                                    this.mfLaneInfo_ = builder7.buildPartial();
                                } else {
                                    continue;
                                }
                            case 66:
                                Posrtkimu.Gaode_Info.Builder builder8 = this.gaodeInfo_ != null ? this.gaodeInfo_.toBuilder() : null;
                                this.gaodeInfo_ = (Posrtkimu.Gaode_Info) codedInputStream.readMessage(Posrtkimu.Gaode_Info.parser(), extensionRegistryLite);
                                if (builder8 != null) {
                                    builder8.mergeFrom(this.gaodeInfo_);
                                    this.gaodeInfo_ = builder8.buildPartial();
                                } else {
                                    continue;
                                }
                            case 74:
                                DynamicEnvironmentOuterClass.BPoutput.Builder builder9 = this.bpInfo_ != null ? this.bpInfo_.toBuilder() : null;
                                this.bpInfo_ = (DynamicEnvironmentOuterClass.BPoutput) codedInputStream.readMessage(DynamicEnvironmentOuterClass.BPoutput.parser(), extensionRegistryLite);
                                if (builder9 != null) {
                                    builder9.mergeFrom(this.bpInfo_);
                                    this.bpInfo_ = builder9.buildPartial();
                                } else {
                                    continue;
                                }
                            case 80:
                                this.srDisplaySt_ = codedInputStream.readInt32();
                                continue;
                            case 88:
                                this.saveProtoSignal_ = codedInputStream.readInt32();
                                continue;
                            case 96:
                                this.useLastMp_ = codedInputStream.readInt32();
                                continue;
                            case 104:
                                this.useLastSfbp_ = codedInputStream.readInt32();
                                continue;
                            case 242:
                                this.xpPosInfo_ = codedInputStream.readBytes();
                                continue;
                            case 250:
                                this.xpEhpVersion_ = codedInputStream.readBytes();
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
            return Overall.internal_static_xpilot_sr_proto_overall_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_overall_fieldAccessorTable.ensureFieldAccessorsInitialized(overall.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public boolean hasLocalPose() {
            return this.localPose_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public LocalPose.LocalPoseInfo getLocalPose() {
            LocalPose.LocalPoseInfo localPoseInfo = this.localPose_;
            return localPoseInfo == null ? LocalPose.LocalPoseInfo.getDefaultInstance() : localPoseInfo;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public LocalPose.LocalPoseInfoOrBuilder getLocalPoseOrBuilder() {
            return getLocalPose();
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public boolean hasDynamicInfo() {
            return this.dynamicInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public DynamicEnvironmentOuterClass.DynamicEnvironment getDynamicInfo() {
            DynamicEnvironmentOuterClass.DynamicEnvironment dynamicEnvironment = this.dynamicInfo_;
            return dynamicEnvironment == null ? DynamicEnvironmentOuterClass.DynamicEnvironment.getDefaultInstance() : dynamicEnvironment;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder getDynamicInfoOrBuilder() {
            return getDynamicInfo();
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public boolean hasStaticInfo() {
            return this.staticInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public StaticEnvironmentOuterClass.StaticEnvironment getStaticInfo() {
            StaticEnvironmentOuterClass.StaticEnvironment staticEnvironment = this.staticInfo_;
            return staticEnvironment == null ? StaticEnvironmentOuterClass.StaticEnvironment.getDefaultInstance() : staticEnvironment;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder getStaticInfoOrBuilder() {
            return getStaticInfo();
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public boolean hasMpInfo() {
            return this.mpInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Primitives.MotionPlanning getMpInfo() {
            Primitives.MotionPlanning motionPlanning = this.mpInfo_;
            return motionPlanning == null ? Primitives.MotionPlanning.getDefaultInstance() : motionPlanning;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Primitives.MotionPlanningOrBuilder getMpInfoOrBuilder() {
            return getMpInfo();
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public boolean hasGpInfo() {
            return this.gpInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Primitives.GlobalPoseInfo getGpInfo() {
            Primitives.GlobalPoseInfo globalPoseInfo = this.gpInfo_;
            return globalPoseInfo == null ? Primitives.GlobalPoseInfo.getDefaultInstance() : globalPoseInfo;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Primitives.GlobalPoseInfoOrBuilder getGpInfoOrBuilder() {
            return getGpInfo();
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public boolean hasSmInfo() {
            return this.smInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Primitives.StateManagement getSmInfo() {
            Primitives.StateManagement stateManagement = this.smInfo_;
            return stateManagement == null ? Primitives.StateManagement.getDefaultInstance() : stateManagement;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Primitives.StateManagementOrBuilder getSmInfoOrBuilder() {
            return getSmInfo();
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public boolean hasMfLaneInfo() {
            return this.mfLaneInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Primitives.MapFusionLanesForScu getMfLaneInfo() {
            Primitives.MapFusionLanesForScu mapFusionLanesForScu = this.mfLaneInfo_;
            return mapFusionLanesForScu == null ? Primitives.MapFusionLanesForScu.getDefaultInstance() : mapFusionLanesForScu;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Primitives.MapFusionLanesForScuOrBuilder getMfLaneInfoOrBuilder() {
            return getMfLaneInfo();
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public boolean hasGaodeInfo() {
            return this.gaodeInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Posrtkimu.Gaode_Info getGaodeInfo() {
            Posrtkimu.Gaode_Info gaode_Info = this.gaodeInfo_;
            return gaode_Info == null ? Posrtkimu.Gaode_Info.getDefaultInstance() : gaode_Info;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public Posrtkimu.Gaode_InfoOrBuilder getGaodeInfoOrBuilder() {
            return getGaodeInfo();
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public boolean hasBpInfo() {
            return this.bpInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public DynamicEnvironmentOuterClass.BPoutput getBpInfo() {
            DynamicEnvironmentOuterClass.BPoutput bPoutput = this.bpInfo_;
            return bPoutput == null ? DynamicEnvironmentOuterClass.BPoutput.getDefaultInstance() : bPoutput;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public DynamicEnvironmentOuterClass.BPoutputOrBuilder getBpInfoOrBuilder() {
            return getBpInfo();
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public int getSrDisplaySt() {
            return this.srDisplaySt_;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public int getSaveProtoSignal() {
            return this.saveProtoSignal_;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public int getUseLastMp() {
            return this.useLastMp_;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public int getUseLastSfbp() {
            return this.useLastSfbp_;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public ByteString getXpPosInfo() {
            return this.xpPosInfo_;
        }

        @Override // xpilot.sr.proto.Overall.overallOrBuilder
        public ByteString getXpEhpVersion() {
            return this.xpEhpVersion_;
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
            if (this.localPose_ != null) {
                codedOutputStream.writeMessage(1, getLocalPose());
            }
            if (this.dynamicInfo_ != null) {
                codedOutputStream.writeMessage(2, getDynamicInfo());
            }
            if (this.staticInfo_ != null) {
                codedOutputStream.writeMessage(3, getStaticInfo());
            }
            if (this.mpInfo_ != null) {
                codedOutputStream.writeMessage(4, getMpInfo());
            }
            if (this.gpInfo_ != null) {
                codedOutputStream.writeMessage(5, getGpInfo());
            }
            if (this.smInfo_ != null) {
                codedOutputStream.writeMessage(6, getSmInfo());
            }
            if (this.mfLaneInfo_ != null) {
                codedOutputStream.writeMessage(7, getMfLaneInfo());
            }
            if (this.gaodeInfo_ != null) {
                codedOutputStream.writeMessage(8, getGaodeInfo());
            }
            if (this.bpInfo_ != null) {
                codedOutputStream.writeMessage(9, getBpInfo());
            }
            int i = this.srDisplaySt_;
            if (i != 0) {
                codedOutputStream.writeInt32(10, i);
            }
            int i2 = this.saveProtoSignal_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(11, i2);
            }
            int i3 = this.useLastMp_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(12, i3);
            }
            int i4 = this.useLastSfbp_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(13, i4);
            }
            if (!this.xpPosInfo_.isEmpty()) {
                codedOutputStream.writeBytes(30, this.xpPosInfo_);
            }
            if (!this.xpEhpVersion_.isEmpty()) {
                codedOutputStream.writeBytes(31, this.xpEhpVersion_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.localPose_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getLocalPose()) : 0;
            if (this.dynamicInfo_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getDynamicInfo());
            }
            if (this.staticInfo_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, getStaticInfo());
            }
            if (this.mpInfo_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, getMpInfo());
            }
            if (this.gpInfo_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(5, getGpInfo());
            }
            if (this.smInfo_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(6, getSmInfo());
            }
            if (this.mfLaneInfo_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(7, getMfLaneInfo());
            }
            if (this.gaodeInfo_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(8, getGaodeInfo());
            }
            if (this.bpInfo_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(9, getBpInfo());
            }
            int i2 = this.srDisplaySt_;
            if (i2 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(10, i2);
            }
            int i3 = this.saveProtoSignal_;
            if (i3 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(11, i3);
            }
            int i4 = this.useLastMp_;
            if (i4 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(12, i4);
            }
            int i5 = this.useLastSfbp_;
            if (i5 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(13, i5);
            }
            if (!this.xpPosInfo_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeBytesSize(30, this.xpPosInfo_);
            }
            if (!this.xpEhpVersion_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeBytesSize(31, this.xpEhpVersion_);
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
            if (!(obj instanceof overall)) {
                return super.equals(obj);
            }
            overall overallVar = (overall) obj;
            boolean z = hasLocalPose() == overallVar.hasLocalPose();
            if (hasLocalPose()) {
                z = z && getLocalPose().equals(overallVar.getLocalPose());
            }
            boolean z2 = z && hasDynamicInfo() == overallVar.hasDynamicInfo();
            if (hasDynamicInfo()) {
                z2 = z2 && getDynamicInfo().equals(overallVar.getDynamicInfo());
            }
            boolean z3 = z2 && hasStaticInfo() == overallVar.hasStaticInfo();
            if (hasStaticInfo()) {
                z3 = z3 && getStaticInfo().equals(overallVar.getStaticInfo());
            }
            boolean z4 = z3 && hasMpInfo() == overallVar.hasMpInfo();
            if (hasMpInfo()) {
                z4 = z4 && getMpInfo().equals(overallVar.getMpInfo());
            }
            boolean z5 = z4 && hasGpInfo() == overallVar.hasGpInfo();
            if (hasGpInfo()) {
                z5 = z5 && getGpInfo().equals(overallVar.getGpInfo());
            }
            boolean z6 = z5 && hasSmInfo() == overallVar.hasSmInfo();
            if (hasSmInfo()) {
                z6 = z6 && getSmInfo().equals(overallVar.getSmInfo());
            }
            boolean z7 = z6 && hasMfLaneInfo() == overallVar.hasMfLaneInfo();
            if (hasMfLaneInfo()) {
                z7 = z7 && getMfLaneInfo().equals(overallVar.getMfLaneInfo());
            }
            boolean z8 = z7 && hasGaodeInfo() == overallVar.hasGaodeInfo();
            if (hasGaodeInfo()) {
                z8 = z8 && getGaodeInfo().equals(overallVar.getGaodeInfo());
            }
            boolean z9 = z8 && hasBpInfo() == overallVar.hasBpInfo();
            if (hasBpInfo()) {
                z9 = z9 && getBpInfo().equals(overallVar.getBpInfo());
            }
            return ((((((z9 && getSrDisplaySt() == overallVar.getSrDisplaySt()) && getSaveProtoSignal() == overallVar.getSaveProtoSignal()) && getUseLastMp() == overallVar.getUseLastMp()) && getUseLastSfbp() == overallVar.getUseLastSfbp()) && getXpPosInfo().equals(overallVar.getXpPosInfo())) && getXpEhpVersion().equals(overallVar.getXpEhpVersion())) && this.unknownFields.equals(overallVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasLocalPose()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getLocalPose().hashCode();
            }
            if (hasDynamicInfo()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getDynamicInfo().hashCode();
            }
            if (hasStaticInfo()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getStaticInfo().hashCode();
            }
            if (hasMpInfo()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getMpInfo().hashCode();
            }
            if (hasGpInfo()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getGpInfo().hashCode();
            }
            if (hasSmInfo()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getSmInfo().hashCode();
            }
            if (hasMfLaneInfo()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getMfLaneInfo().hashCode();
            }
            if (hasGaodeInfo()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getGaodeInfo().hashCode();
            }
            if (hasBpInfo()) {
                hashCode = (((hashCode * 37) + 9) * 53) + getBpInfo().hashCode();
            }
            int srDisplaySt = (((((((((((((((((((((((((hashCode * 37) + 10) * 53) + getSrDisplaySt()) * 37) + 11) * 53) + getSaveProtoSignal()) * 37) + 12) * 53) + getUseLastMp()) * 37) + 13) * 53) + getUseLastSfbp()) * 37) + 30) * 53) + getXpPosInfo().hashCode()) * 37) + 31) * 53) + getXpEhpVersion().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = srDisplaySt;
            return srDisplaySt;
        }

        public static overall parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static overall parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static overall parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static overall parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static overall parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static overall parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static overall parseFrom(InputStream inputStream) throws IOException {
            return (overall) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static overall parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static overall parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (overall) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static overall parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static overall parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (overall) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static overall parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(overall overallVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(overallVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements overallOrBuilder {
            private SingleFieldBuilderV3<DynamicEnvironmentOuterClass.BPoutput, DynamicEnvironmentOuterClass.BPoutput.Builder, DynamicEnvironmentOuterClass.BPoutputOrBuilder> bpInfoBuilder_;
            private DynamicEnvironmentOuterClass.BPoutput bpInfo_;
            private SingleFieldBuilderV3<DynamicEnvironmentOuterClass.DynamicEnvironment, DynamicEnvironmentOuterClass.DynamicEnvironment.Builder, DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder> dynamicInfoBuilder_;
            private DynamicEnvironmentOuterClass.DynamicEnvironment dynamicInfo_;
            private SingleFieldBuilderV3<Posrtkimu.Gaode_Info, Posrtkimu.Gaode_Info.Builder, Posrtkimu.Gaode_InfoOrBuilder> gaodeInfoBuilder_;
            private Posrtkimu.Gaode_Info gaodeInfo_;
            private SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> gpInfoBuilder_;
            private Primitives.GlobalPoseInfo gpInfo_;
            private SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> localPoseBuilder_;
            private LocalPose.LocalPoseInfo localPose_;
            private SingleFieldBuilderV3<Primitives.MapFusionLanesForScu, Primitives.MapFusionLanesForScu.Builder, Primitives.MapFusionLanesForScuOrBuilder> mfLaneInfoBuilder_;
            private Primitives.MapFusionLanesForScu mfLaneInfo_;
            private SingleFieldBuilderV3<Primitives.MotionPlanning, Primitives.MotionPlanning.Builder, Primitives.MotionPlanningOrBuilder> mpInfoBuilder_;
            private Primitives.MotionPlanning mpInfo_;
            private int saveProtoSignal_;
            private SingleFieldBuilderV3<Primitives.StateManagement, Primitives.StateManagement.Builder, Primitives.StateManagementOrBuilder> smInfoBuilder_;
            private Primitives.StateManagement smInfo_;
            private int srDisplaySt_;
            private SingleFieldBuilderV3<StaticEnvironmentOuterClass.StaticEnvironment, StaticEnvironmentOuterClass.StaticEnvironment.Builder, StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder> staticInfoBuilder_;
            private StaticEnvironmentOuterClass.StaticEnvironment staticInfo_;
            private int useLastMp_;
            private int useLastSfbp_;
            private ByteString xpEhpVersion_;
            private ByteString xpPosInfo_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_overall_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_overall_fieldAccessorTable.ensureFieldAccessorsInitialized(overall.class, Builder.class);
            }

            private Builder() {
                this.localPose_ = null;
                this.dynamicInfo_ = null;
                this.staticInfo_ = null;
                this.mpInfo_ = null;
                this.gpInfo_ = null;
                this.smInfo_ = null;
                this.mfLaneInfo_ = null;
                this.gaodeInfo_ = null;
                this.bpInfo_ = null;
                this.xpPosInfo_ = ByteString.EMPTY;
                this.xpEhpVersion_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.localPose_ = null;
                this.dynamicInfo_ = null;
                this.staticInfo_ = null;
                this.mpInfo_ = null;
                this.gpInfo_ = null;
                this.smInfo_ = null;
                this.mfLaneInfo_ = null;
                this.gaodeInfo_ = null;
                this.bpInfo_ = null;
                this.xpPosInfo_ = ByteString.EMPTY;
                this.xpEhpVersion_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = overall.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.localPoseBuilder_ == null) {
                    this.localPose_ = null;
                } else {
                    this.localPose_ = null;
                    this.localPoseBuilder_ = null;
                }
                if (this.dynamicInfoBuilder_ == null) {
                    this.dynamicInfo_ = null;
                } else {
                    this.dynamicInfo_ = null;
                    this.dynamicInfoBuilder_ = null;
                }
                if (this.staticInfoBuilder_ == null) {
                    this.staticInfo_ = null;
                } else {
                    this.staticInfo_ = null;
                    this.staticInfoBuilder_ = null;
                }
                if (this.mpInfoBuilder_ == null) {
                    this.mpInfo_ = null;
                } else {
                    this.mpInfo_ = null;
                    this.mpInfoBuilder_ = null;
                }
                if (this.gpInfoBuilder_ == null) {
                    this.gpInfo_ = null;
                } else {
                    this.gpInfo_ = null;
                    this.gpInfoBuilder_ = null;
                }
                if (this.smInfoBuilder_ == null) {
                    this.smInfo_ = null;
                } else {
                    this.smInfo_ = null;
                    this.smInfoBuilder_ = null;
                }
                if (this.mfLaneInfoBuilder_ == null) {
                    this.mfLaneInfo_ = null;
                } else {
                    this.mfLaneInfo_ = null;
                    this.mfLaneInfoBuilder_ = null;
                }
                if (this.gaodeInfoBuilder_ == null) {
                    this.gaodeInfo_ = null;
                } else {
                    this.gaodeInfo_ = null;
                    this.gaodeInfoBuilder_ = null;
                }
                if (this.bpInfoBuilder_ == null) {
                    this.bpInfo_ = null;
                } else {
                    this.bpInfo_ = null;
                    this.bpInfoBuilder_ = null;
                }
                this.srDisplaySt_ = 0;
                this.saveProtoSignal_ = 0;
                this.useLastMp_ = 0;
                this.useLastSfbp_ = 0;
                this.xpPosInfo_ = ByteString.EMPTY;
                this.xpEhpVersion_ = ByteString.EMPTY;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_overall_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public overall getDefaultInstanceForType() {
                return overall.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public overall build() {
                overall buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public overall buildPartial() {
                overall overallVar = new overall(this);
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overallVar.localPose_ = this.localPose_;
                } else {
                    overallVar.localPose_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.DynamicEnvironment, DynamicEnvironmentOuterClass.DynamicEnvironment.Builder, DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder> singleFieldBuilderV32 = this.dynamicInfoBuilder_;
                if (singleFieldBuilderV32 == null) {
                    overallVar.dynamicInfo_ = this.dynamicInfo_;
                } else {
                    overallVar.dynamicInfo_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<StaticEnvironmentOuterClass.StaticEnvironment, StaticEnvironmentOuterClass.StaticEnvironment.Builder, StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder> singleFieldBuilderV33 = this.staticInfoBuilder_;
                if (singleFieldBuilderV33 == null) {
                    overallVar.staticInfo_ = this.staticInfo_;
                } else {
                    overallVar.staticInfo_ = singleFieldBuilderV33.build();
                }
                SingleFieldBuilderV3<Primitives.MotionPlanning, Primitives.MotionPlanning.Builder, Primitives.MotionPlanningOrBuilder> singleFieldBuilderV34 = this.mpInfoBuilder_;
                if (singleFieldBuilderV34 == null) {
                    overallVar.mpInfo_ = this.mpInfo_;
                } else {
                    overallVar.mpInfo_ = singleFieldBuilderV34.build();
                }
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV35 = this.gpInfoBuilder_;
                if (singleFieldBuilderV35 == null) {
                    overallVar.gpInfo_ = this.gpInfo_;
                } else {
                    overallVar.gpInfo_ = singleFieldBuilderV35.build();
                }
                SingleFieldBuilderV3<Primitives.StateManagement, Primitives.StateManagement.Builder, Primitives.StateManagementOrBuilder> singleFieldBuilderV36 = this.smInfoBuilder_;
                if (singleFieldBuilderV36 == null) {
                    overallVar.smInfo_ = this.smInfo_;
                } else {
                    overallVar.smInfo_ = singleFieldBuilderV36.build();
                }
                SingleFieldBuilderV3<Primitives.MapFusionLanesForScu, Primitives.MapFusionLanesForScu.Builder, Primitives.MapFusionLanesForScuOrBuilder> singleFieldBuilderV37 = this.mfLaneInfoBuilder_;
                if (singleFieldBuilderV37 == null) {
                    overallVar.mfLaneInfo_ = this.mfLaneInfo_;
                } else {
                    overallVar.mfLaneInfo_ = singleFieldBuilderV37.build();
                }
                SingleFieldBuilderV3<Posrtkimu.Gaode_Info, Posrtkimu.Gaode_Info.Builder, Posrtkimu.Gaode_InfoOrBuilder> singleFieldBuilderV38 = this.gaodeInfoBuilder_;
                if (singleFieldBuilderV38 == null) {
                    overallVar.gaodeInfo_ = this.gaodeInfo_;
                } else {
                    overallVar.gaodeInfo_ = singleFieldBuilderV38.build();
                }
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.BPoutput, DynamicEnvironmentOuterClass.BPoutput.Builder, DynamicEnvironmentOuterClass.BPoutputOrBuilder> singleFieldBuilderV39 = this.bpInfoBuilder_;
                if (singleFieldBuilderV39 == null) {
                    overallVar.bpInfo_ = this.bpInfo_;
                } else {
                    overallVar.bpInfo_ = singleFieldBuilderV39.build();
                }
                overallVar.srDisplaySt_ = this.srDisplaySt_;
                overallVar.saveProtoSignal_ = this.saveProtoSignal_;
                overallVar.useLastMp_ = this.useLastMp_;
                overallVar.useLastSfbp_ = this.useLastSfbp_;
                overallVar.xpPosInfo_ = this.xpPosInfo_;
                overallVar.xpEhpVersion_ = this.xpEhpVersion_;
                onBuilt();
                return overallVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof overall) {
                    return mergeFrom((overall) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(overall overallVar) {
                if (overallVar == overall.getDefaultInstance()) {
                    return this;
                }
                if (overallVar.hasLocalPose()) {
                    mergeLocalPose(overallVar.getLocalPose());
                }
                if (overallVar.hasDynamicInfo()) {
                    mergeDynamicInfo(overallVar.getDynamicInfo());
                }
                if (overallVar.hasStaticInfo()) {
                    mergeStaticInfo(overallVar.getStaticInfo());
                }
                if (overallVar.hasMpInfo()) {
                    mergeMpInfo(overallVar.getMpInfo());
                }
                if (overallVar.hasGpInfo()) {
                    mergeGpInfo(overallVar.getGpInfo());
                }
                if (overallVar.hasSmInfo()) {
                    mergeSmInfo(overallVar.getSmInfo());
                }
                if (overallVar.hasMfLaneInfo()) {
                    mergeMfLaneInfo(overallVar.getMfLaneInfo());
                }
                if (overallVar.hasGaodeInfo()) {
                    mergeGaodeInfo(overallVar.getGaodeInfo());
                }
                if (overallVar.hasBpInfo()) {
                    mergeBpInfo(overallVar.getBpInfo());
                }
                if (overallVar.getSrDisplaySt() != 0) {
                    setSrDisplaySt(overallVar.getSrDisplaySt());
                }
                if (overallVar.getSaveProtoSignal() != 0) {
                    setSaveProtoSignal(overallVar.getSaveProtoSignal());
                }
                if (overallVar.getUseLastMp() != 0) {
                    setUseLastMp(overallVar.getUseLastMp());
                }
                if (overallVar.getUseLastSfbp() != 0) {
                    setUseLastSfbp(overallVar.getUseLastSfbp());
                }
                if (overallVar.getXpPosInfo() != ByteString.EMPTY) {
                    setXpPosInfo(overallVar.getXpPosInfo());
                }
                if (overallVar.getXpEhpVersion() != ByteString.EMPTY) {
                    setXpEhpVersion(overallVar.getXpEhpVersion());
                }
                mergeUnknownFields(overallVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.overall.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.overall.access$2200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$overall r3 = (xpilot.sr.proto.Overall.overall) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$overall r4 = (xpilot.sr.proto.Overall.overall) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.overall.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$overall$Builder");
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public boolean hasLocalPose() {
                return (this.localPoseBuilder_ == null && this.localPose_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public LocalPose.LocalPoseInfo getLocalPose() {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    LocalPose.LocalPoseInfo localPoseInfo = this.localPose_;
                    return localPoseInfo == null ? LocalPose.LocalPoseInfo.getDefaultInstance() : localPoseInfo;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLocalPose(LocalPose.LocalPoseInfo localPoseInfo) {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(localPoseInfo);
                } else if (localPoseInfo == null) {
                    throw new NullPointerException();
                } else {
                    this.localPose_ = localPoseInfo;
                    onChanged();
                }
                return this;
            }

            public Builder setLocalPose(LocalPose.LocalPoseInfo.Builder builder) {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.localPose_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLocalPose(LocalPose.LocalPoseInfo localPoseInfo) {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    LocalPose.LocalPoseInfo localPoseInfo2 = this.localPose_;
                    if (localPoseInfo2 != null) {
                        this.localPose_ = LocalPose.LocalPoseInfo.newBuilder(localPoseInfo2).mergeFrom(localPoseInfo).buildPartial();
                    } else {
                        this.localPose_ = localPoseInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(localPoseInfo);
                }
                return this;
            }

            public Builder clearLocalPose() {
                if (this.localPoseBuilder_ == null) {
                    this.localPose_ = null;
                    onChanged();
                } else {
                    this.localPose_ = null;
                    this.localPoseBuilder_ = null;
                }
                return this;
            }

            public LocalPose.LocalPoseInfo.Builder getLocalPoseBuilder() {
                onChanged();
                return getLocalPoseFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public LocalPose.LocalPoseInfoOrBuilder getLocalPoseOrBuilder() {
                SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                LocalPose.LocalPoseInfo localPoseInfo = this.localPose_;
                return localPoseInfo == null ? LocalPose.LocalPoseInfo.getDefaultInstance() : localPoseInfo;
            }

            private SingleFieldBuilderV3<LocalPose.LocalPoseInfo, LocalPose.LocalPoseInfo.Builder, LocalPose.LocalPoseInfoOrBuilder> getLocalPoseFieldBuilder() {
                if (this.localPoseBuilder_ == null) {
                    this.localPoseBuilder_ = new SingleFieldBuilderV3<>(getLocalPose(), getParentForChildren(), isClean());
                    this.localPose_ = null;
                }
                return this.localPoseBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public boolean hasDynamicInfo() {
                return (this.dynamicInfoBuilder_ == null && this.dynamicInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public DynamicEnvironmentOuterClass.DynamicEnvironment getDynamicInfo() {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.DynamicEnvironment, DynamicEnvironmentOuterClass.DynamicEnvironment.Builder, DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder> singleFieldBuilderV3 = this.dynamicInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    DynamicEnvironmentOuterClass.DynamicEnvironment dynamicEnvironment = this.dynamicInfo_;
                    return dynamicEnvironment == null ? DynamicEnvironmentOuterClass.DynamicEnvironment.getDefaultInstance() : dynamicEnvironment;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setDynamicInfo(DynamicEnvironmentOuterClass.DynamicEnvironment dynamicEnvironment) {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.DynamicEnvironment, DynamicEnvironmentOuterClass.DynamicEnvironment.Builder, DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder> singleFieldBuilderV3 = this.dynamicInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(dynamicEnvironment);
                } else if (dynamicEnvironment == null) {
                    throw new NullPointerException();
                } else {
                    this.dynamicInfo_ = dynamicEnvironment;
                    onChanged();
                }
                return this;
            }

            public Builder setDynamicInfo(DynamicEnvironmentOuterClass.DynamicEnvironment.Builder builder) {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.DynamicEnvironment, DynamicEnvironmentOuterClass.DynamicEnvironment.Builder, DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder> singleFieldBuilderV3 = this.dynamicInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.dynamicInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeDynamicInfo(DynamicEnvironmentOuterClass.DynamicEnvironment dynamicEnvironment) {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.DynamicEnvironment, DynamicEnvironmentOuterClass.DynamicEnvironment.Builder, DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder> singleFieldBuilderV3 = this.dynamicInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    DynamicEnvironmentOuterClass.DynamicEnvironment dynamicEnvironment2 = this.dynamicInfo_;
                    if (dynamicEnvironment2 != null) {
                        this.dynamicInfo_ = DynamicEnvironmentOuterClass.DynamicEnvironment.newBuilder(dynamicEnvironment2).mergeFrom(dynamicEnvironment).buildPartial();
                    } else {
                        this.dynamicInfo_ = dynamicEnvironment;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(dynamicEnvironment);
                }
                return this;
            }

            public Builder clearDynamicInfo() {
                if (this.dynamicInfoBuilder_ == null) {
                    this.dynamicInfo_ = null;
                    onChanged();
                } else {
                    this.dynamicInfo_ = null;
                    this.dynamicInfoBuilder_ = null;
                }
                return this;
            }

            public DynamicEnvironmentOuterClass.DynamicEnvironment.Builder getDynamicInfoBuilder() {
                onChanged();
                return getDynamicInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder getDynamicInfoOrBuilder() {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.DynamicEnvironment, DynamicEnvironmentOuterClass.DynamicEnvironment.Builder, DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder> singleFieldBuilderV3 = this.dynamicInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                DynamicEnvironmentOuterClass.DynamicEnvironment dynamicEnvironment = this.dynamicInfo_;
                return dynamicEnvironment == null ? DynamicEnvironmentOuterClass.DynamicEnvironment.getDefaultInstance() : dynamicEnvironment;
            }

            private SingleFieldBuilderV3<DynamicEnvironmentOuterClass.DynamicEnvironment, DynamicEnvironmentOuterClass.DynamicEnvironment.Builder, DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder> getDynamicInfoFieldBuilder() {
                if (this.dynamicInfoBuilder_ == null) {
                    this.dynamicInfoBuilder_ = new SingleFieldBuilderV3<>(getDynamicInfo(), getParentForChildren(), isClean());
                    this.dynamicInfo_ = null;
                }
                return this.dynamicInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public boolean hasStaticInfo() {
                return (this.staticInfoBuilder_ == null && this.staticInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public StaticEnvironmentOuterClass.StaticEnvironment getStaticInfo() {
                SingleFieldBuilderV3<StaticEnvironmentOuterClass.StaticEnvironment, StaticEnvironmentOuterClass.StaticEnvironment.Builder, StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder> singleFieldBuilderV3 = this.staticInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StaticEnvironmentOuterClass.StaticEnvironment staticEnvironment = this.staticInfo_;
                    return staticEnvironment == null ? StaticEnvironmentOuterClass.StaticEnvironment.getDefaultInstance() : staticEnvironment;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setStaticInfo(StaticEnvironmentOuterClass.StaticEnvironment staticEnvironment) {
                SingleFieldBuilderV3<StaticEnvironmentOuterClass.StaticEnvironment, StaticEnvironmentOuterClass.StaticEnvironment.Builder, StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder> singleFieldBuilderV3 = this.staticInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(staticEnvironment);
                } else if (staticEnvironment == null) {
                    throw new NullPointerException();
                } else {
                    this.staticInfo_ = staticEnvironment;
                    onChanged();
                }
                return this;
            }

            public Builder setStaticInfo(StaticEnvironmentOuterClass.StaticEnvironment.Builder builder) {
                SingleFieldBuilderV3<StaticEnvironmentOuterClass.StaticEnvironment, StaticEnvironmentOuterClass.StaticEnvironment.Builder, StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder> singleFieldBuilderV3 = this.staticInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.staticInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeStaticInfo(StaticEnvironmentOuterClass.StaticEnvironment staticEnvironment) {
                SingleFieldBuilderV3<StaticEnvironmentOuterClass.StaticEnvironment, StaticEnvironmentOuterClass.StaticEnvironment.Builder, StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder> singleFieldBuilderV3 = this.staticInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StaticEnvironmentOuterClass.StaticEnvironment staticEnvironment2 = this.staticInfo_;
                    if (staticEnvironment2 != null) {
                        this.staticInfo_ = StaticEnvironmentOuterClass.StaticEnvironment.newBuilder(staticEnvironment2).mergeFrom(staticEnvironment).buildPartial();
                    } else {
                        this.staticInfo_ = staticEnvironment;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(staticEnvironment);
                }
                return this;
            }

            public Builder clearStaticInfo() {
                if (this.staticInfoBuilder_ == null) {
                    this.staticInfo_ = null;
                    onChanged();
                } else {
                    this.staticInfo_ = null;
                    this.staticInfoBuilder_ = null;
                }
                return this;
            }

            public StaticEnvironmentOuterClass.StaticEnvironment.Builder getStaticInfoBuilder() {
                onChanged();
                return getStaticInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder getStaticInfoOrBuilder() {
                SingleFieldBuilderV3<StaticEnvironmentOuterClass.StaticEnvironment, StaticEnvironmentOuterClass.StaticEnvironment.Builder, StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder> singleFieldBuilderV3 = this.staticInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                StaticEnvironmentOuterClass.StaticEnvironment staticEnvironment = this.staticInfo_;
                return staticEnvironment == null ? StaticEnvironmentOuterClass.StaticEnvironment.getDefaultInstance() : staticEnvironment;
            }

            private SingleFieldBuilderV3<StaticEnvironmentOuterClass.StaticEnvironment, StaticEnvironmentOuterClass.StaticEnvironment.Builder, StaticEnvironmentOuterClass.StaticEnvironmentOrBuilder> getStaticInfoFieldBuilder() {
                if (this.staticInfoBuilder_ == null) {
                    this.staticInfoBuilder_ = new SingleFieldBuilderV3<>(getStaticInfo(), getParentForChildren(), isClean());
                    this.staticInfo_ = null;
                }
                return this.staticInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public boolean hasMpInfo() {
                return (this.mpInfoBuilder_ == null && this.mpInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Primitives.MotionPlanning getMpInfo() {
                SingleFieldBuilderV3<Primitives.MotionPlanning, Primitives.MotionPlanning.Builder, Primitives.MotionPlanningOrBuilder> singleFieldBuilderV3 = this.mpInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.MotionPlanning motionPlanning = this.mpInfo_;
                    return motionPlanning == null ? Primitives.MotionPlanning.getDefaultInstance() : motionPlanning;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setMpInfo(Primitives.MotionPlanning motionPlanning) {
                SingleFieldBuilderV3<Primitives.MotionPlanning, Primitives.MotionPlanning.Builder, Primitives.MotionPlanningOrBuilder> singleFieldBuilderV3 = this.mpInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(motionPlanning);
                } else if (motionPlanning == null) {
                    throw new NullPointerException();
                } else {
                    this.mpInfo_ = motionPlanning;
                    onChanged();
                }
                return this;
            }

            public Builder setMpInfo(Primitives.MotionPlanning.Builder builder) {
                SingleFieldBuilderV3<Primitives.MotionPlanning, Primitives.MotionPlanning.Builder, Primitives.MotionPlanningOrBuilder> singleFieldBuilderV3 = this.mpInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.mpInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeMpInfo(Primitives.MotionPlanning motionPlanning) {
                SingleFieldBuilderV3<Primitives.MotionPlanning, Primitives.MotionPlanning.Builder, Primitives.MotionPlanningOrBuilder> singleFieldBuilderV3 = this.mpInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.MotionPlanning motionPlanning2 = this.mpInfo_;
                    if (motionPlanning2 != null) {
                        this.mpInfo_ = Primitives.MotionPlanning.newBuilder(motionPlanning2).mergeFrom(motionPlanning).buildPartial();
                    } else {
                        this.mpInfo_ = motionPlanning;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(motionPlanning);
                }
                return this;
            }

            public Builder clearMpInfo() {
                if (this.mpInfoBuilder_ == null) {
                    this.mpInfo_ = null;
                    onChanged();
                } else {
                    this.mpInfo_ = null;
                    this.mpInfoBuilder_ = null;
                }
                return this;
            }

            public Primitives.MotionPlanning.Builder getMpInfoBuilder() {
                onChanged();
                return getMpInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Primitives.MotionPlanningOrBuilder getMpInfoOrBuilder() {
                SingleFieldBuilderV3<Primitives.MotionPlanning, Primitives.MotionPlanning.Builder, Primitives.MotionPlanningOrBuilder> singleFieldBuilderV3 = this.mpInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.MotionPlanning motionPlanning = this.mpInfo_;
                return motionPlanning == null ? Primitives.MotionPlanning.getDefaultInstance() : motionPlanning;
            }

            private SingleFieldBuilderV3<Primitives.MotionPlanning, Primitives.MotionPlanning.Builder, Primitives.MotionPlanningOrBuilder> getMpInfoFieldBuilder() {
                if (this.mpInfoBuilder_ == null) {
                    this.mpInfoBuilder_ = new SingleFieldBuilderV3<>(getMpInfo(), getParentForChildren(), isClean());
                    this.mpInfo_ = null;
                }
                return this.mpInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public boolean hasGpInfo() {
                return (this.gpInfoBuilder_ == null && this.gpInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Primitives.GlobalPoseInfo getGpInfo() {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.gpInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.GlobalPoseInfo globalPoseInfo = this.gpInfo_;
                    return globalPoseInfo == null ? Primitives.GlobalPoseInfo.getDefaultInstance() : globalPoseInfo;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setGpInfo(Primitives.GlobalPoseInfo globalPoseInfo) {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.gpInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(globalPoseInfo);
                } else if (globalPoseInfo == null) {
                    throw new NullPointerException();
                } else {
                    this.gpInfo_ = globalPoseInfo;
                    onChanged();
                }
                return this;
            }

            public Builder setGpInfo(Primitives.GlobalPoseInfo.Builder builder) {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.gpInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.gpInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeGpInfo(Primitives.GlobalPoseInfo globalPoseInfo) {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.gpInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.GlobalPoseInfo globalPoseInfo2 = this.gpInfo_;
                    if (globalPoseInfo2 != null) {
                        this.gpInfo_ = Primitives.GlobalPoseInfo.newBuilder(globalPoseInfo2).mergeFrom(globalPoseInfo).buildPartial();
                    } else {
                        this.gpInfo_ = globalPoseInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(globalPoseInfo);
                }
                return this;
            }

            public Builder clearGpInfo() {
                if (this.gpInfoBuilder_ == null) {
                    this.gpInfo_ = null;
                    onChanged();
                } else {
                    this.gpInfo_ = null;
                    this.gpInfoBuilder_ = null;
                }
                return this;
            }

            public Primitives.GlobalPoseInfo.Builder getGpInfoBuilder() {
                onChanged();
                return getGpInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Primitives.GlobalPoseInfoOrBuilder getGpInfoOrBuilder() {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.gpInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.GlobalPoseInfo globalPoseInfo = this.gpInfo_;
                return globalPoseInfo == null ? Primitives.GlobalPoseInfo.getDefaultInstance() : globalPoseInfo;
            }

            private SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> getGpInfoFieldBuilder() {
                if (this.gpInfoBuilder_ == null) {
                    this.gpInfoBuilder_ = new SingleFieldBuilderV3<>(getGpInfo(), getParentForChildren(), isClean());
                    this.gpInfo_ = null;
                }
                return this.gpInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public boolean hasSmInfo() {
                return (this.smInfoBuilder_ == null && this.smInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Primitives.StateManagement getSmInfo() {
                SingleFieldBuilderV3<Primitives.StateManagement, Primitives.StateManagement.Builder, Primitives.StateManagementOrBuilder> singleFieldBuilderV3 = this.smInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.StateManagement stateManagement = this.smInfo_;
                    return stateManagement == null ? Primitives.StateManagement.getDefaultInstance() : stateManagement;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setSmInfo(Primitives.StateManagement stateManagement) {
                SingleFieldBuilderV3<Primitives.StateManagement, Primitives.StateManagement.Builder, Primitives.StateManagementOrBuilder> singleFieldBuilderV3 = this.smInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(stateManagement);
                } else if (stateManagement == null) {
                    throw new NullPointerException();
                } else {
                    this.smInfo_ = stateManagement;
                    onChanged();
                }
                return this;
            }

            public Builder setSmInfo(Primitives.StateManagement.Builder builder) {
                SingleFieldBuilderV3<Primitives.StateManagement, Primitives.StateManagement.Builder, Primitives.StateManagementOrBuilder> singleFieldBuilderV3 = this.smInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.smInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeSmInfo(Primitives.StateManagement stateManagement) {
                SingleFieldBuilderV3<Primitives.StateManagement, Primitives.StateManagement.Builder, Primitives.StateManagementOrBuilder> singleFieldBuilderV3 = this.smInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.StateManagement stateManagement2 = this.smInfo_;
                    if (stateManagement2 != null) {
                        this.smInfo_ = Primitives.StateManagement.newBuilder(stateManagement2).mergeFrom(stateManagement).buildPartial();
                    } else {
                        this.smInfo_ = stateManagement;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(stateManagement);
                }
                return this;
            }

            public Builder clearSmInfo() {
                if (this.smInfoBuilder_ == null) {
                    this.smInfo_ = null;
                    onChanged();
                } else {
                    this.smInfo_ = null;
                    this.smInfoBuilder_ = null;
                }
                return this;
            }

            public Primitives.StateManagement.Builder getSmInfoBuilder() {
                onChanged();
                return getSmInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Primitives.StateManagementOrBuilder getSmInfoOrBuilder() {
                SingleFieldBuilderV3<Primitives.StateManagement, Primitives.StateManagement.Builder, Primitives.StateManagementOrBuilder> singleFieldBuilderV3 = this.smInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.StateManagement stateManagement = this.smInfo_;
                return stateManagement == null ? Primitives.StateManagement.getDefaultInstance() : stateManagement;
            }

            private SingleFieldBuilderV3<Primitives.StateManagement, Primitives.StateManagement.Builder, Primitives.StateManagementOrBuilder> getSmInfoFieldBuilder() {
                if (this.smInfoBuilder_ == null) {
                    this.smInfoBuilder_ = new SingleFieldBuilderV3<>(getSmInfo(), getParentForChildren(), isClean());
                    this.smInfo_ = null;
                }
                return this.smInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public boolean hasMfLaneInfo() {
                return (this.mfLaneInfoBuilder_ == null && this.mfLaneInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Primitives.MapFusionLanesForScu getMfLaneInfo() {
                SingleFieldBuilderV3<Primitives.MapFusionLanesForScu, Primitives.MapFusionLanesForScu.Builder, Primitives.MapFusionLanesForScuOrBuilder> singleFieldBuilderV3 = this.mfLaneInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.MapFusionLanesForScu mapFusionLanesForScu = this.mfLaneInfo_;
                    return mapFusionLanesForScu == null ? Primitives.MapFusionLanesForScu.getDefaultInstance() : mapFusionLanesForScu;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setMfLaneInfo(Primitives.MapFusionLanesForScu mapFusionLanesForScu) {
                SingleFieldBuilderV3<Primitives.MapFusionLanesForScu, Primitives.MapFusionLanesForScu.Builder, Primitives.MapFusionLanesForScuOrBuilder> singleFieldBuilderV3 = this.mfLaneInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(mapFusionLanesForScu);
                } else if (mapFusionLanesForScu == null) {
                    throw new NullPointerException();
                } else {
                    this.mfLaneInfo_ = mapFusionLanesForScu;
                    onChanged();
                }
                return this;
            }

            public Builder setMfLaneInfo(Primitives.MapFusionLanesForScu.Builder builder) {
                SingleFieldBuilderV3<Primitives.MapFusionLanesForScu, Primitives.MapFusionLanesForScu.Builder, Primitives.MapFusionLanesForScuOrBuilder> singleFieldBuilderV3 = this.mfLaneInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.mfLaneInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeMfLaneInfo(Primitives.MapFusionLanesForScu mapFusionLanesForScu) {
                SingleFieldBuilderV3<Primitives.MapFusionLanesForScu, Primitives.MapFusionLanesForScu.Builder, Primitives.MapFusionLanesForScuOrBuilder> singleFieldBuilderV3 = this.mfLaneInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.MapFusionLanesForScu mapFusionLanesForScu2 = this.mfLaneInfo_;
                    if (mapFusionLanesForScu2 != null) {
                        this.mfLaneInfo_ = Primitives.MapFusionLanesForScu.newBuilder(mapFusionLanesForScu2).mergeFrom(mapFusionLanesForScu).buildPartial();
                    } else {
                        this.mfLaneInfo_ = mapFusionLanesForScu;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(mapFusionLanesForScu);
                }
                return this;
            }

            public Builder clearMfLaneInfo() {
                if (this.mfLaneInfoBuilder_ == null) {
                    this.mfLaneInfo_ = null;
                    onChanged();
                } else {
                    this.mfLaneInfo_ = null;
                    this.mfLaneInfoBuilder_ = null;
                }
                return this;
            }

            public Primitives.MapFusionLanesForScu.Builder getMfLaneInfoBuilder() {
                onChanged();
                return getMfLaneInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Primitives.MapFusionLanesForScuOrBuilder getMfLaneInfoOrBuilder() {
                SingleFieldBuilderV3<Primitives.MapFusionLanesForScu, Primitives.MapFusionLanesForScu.Builder, Primitives.MapFusionLanesForScuOrBuilder> singleFieldBuilderV3 = this.mfLaneInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.MapFusionLanesForScu mapFusionLanesForScu = this.mfLaneInfo_;
                return mapFusionLanesForScu == null ? Primitives.MapFusionLanesForScu.getDefaultInstance() : mapFusionLanesForScu;
            }

            private SingleFieldBuilderV3<Primitives.MapFusionLanesForScu, Primitives.MapFusionLanesForScu.Builder, Primitives.MapFusionLanesForScuOrBuilder> getMfLaneInfoFieldBuilder() {
                if (this.mfLaneInfoBuilder_ == null) {
                    this.mfLaneInfoBuilder_ = new SingleFieldBuilderV3<>(getMfLaneInfo(), getParentForChildren(), isClean());
                    this.mfLaneInfo_ = null;
                }
                return this.mfLaneInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public boolean hasGaodeInfo() {
                return (this.gaodeInfoBuilder_ == null && this.gaodeInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Posrtkimu.Gaode_Info getGaodeInfo() {
                SingleFieldBuilderV3<Posrtkimu.Gaode_Info, Posrtkimu.Gaode_Info.Builder, Posrtkimu.Gaode_InfoOrBuilder> singleFieldBuilderV3 = this.gaodeInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Posrtkimu.Gaode_Info gaode_Info = this.gaodeInfo_;
                    return gaode_Info == null ? Posrtkimu.Gaode_Info.getDefaultInstance() : gaode_Info;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setGaodeInfo(Posrtkimu.Gaode_Info gaode_Info) {
                SingleFieldBuilderV3<Posrtkimu.Gaode_Info, Posrtkimu.Gaode_Info.Builder, Posrtkimu.Gaode_InfoOrBuilder> singleFieldBuilderV3 = this.gaodeInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(gaode_Info);
                } else if (gaode_Info == null) {
                    throw new NullPointerException();
                } else {
                    this.gaodeInfo_ = gaode_Info;
                    onChanged();
                }
                return this;
            }

            public Builder setGaodeInfo(Posrtkimu.Gaode_Info.Builder builder) {
                SingleFieldBuilderV3<Posrtkimu.Gaode_Info, Posrtkimu.Gaode_Info.Builder, Posrtkimu.Gaode_InfoOrBuilder> singleFieldBuilderV3 = this.gaodeInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.gaodeInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeGaodeInfo(Posrtkimu.Gaode_Info gaode_Info) {
                SingleFieldBuilderV3<Posrtkimu.Gaode_Info, Posrtkimu.Gaode_Info.Builder, Posrtkimu.Gaode_InfoOrBuilder> singleFieldBuilderV3 = this.gaodeInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Posrtkimu.Gaode_Info gaode_Info2 = this.gaodeInfo_;
                    if (gaode_Info2 != null) {
                        this.gaodeInfo_ = Posrtkimu.Gaode_Info.newBuilder(gaode_Info2).mergeFrom(gaode_Info).buildPartial();
                    } else {
                        this.gaodeInfo_ = gaode_Info;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(gaode_Info);
                }
                return this;
            }

            public Builder clearGaodeInfo() {
                if (this.gaodeInfoBuilder_ == null) {
                    this.gaodeInfo_ = null;
                    onChanged();
                } else {
                    this.gaodeInfo_ = null;
                    this.gaodeInfoBuilder_ = null;
                }
                return this;
            }

            public Posrtkimu.Gaode_Info.Builder getGaodeInfoBuilder() {
                onChanged();
                return getGaodeInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public Posrtkimu.Gaode_InfoOrBuilder getGaodeInfoOrBuilder() {
                SingleFieldBuilderV3<Posrtkimu.Gaode_Info, Posrtkimu.Gaode_Info.Builder, Posrtkimu.Gaode_InfoOrBuilder> singleFieldBuilderV3 = this.gaodeInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Posrtkimu.Gaode_Info gaode_Info = this.gaodeInfo_;
                return gaode_Info == null ? Posrtkimu.Gaode_Info.getDefaultInstance() : gaode_Info;
            }

            private SingleFieldBuilderV3<Posrtkimu.Gaode_Info, Posrtkimu.Gaode_Info.Builder, Posrtkimu.Gaode_InfoOrBuilder> getGaodeInfoFieldBuilder() {
                if (this.gaodeInfoBuilder_ == null) {
                    this.gaodeInfoBuilder_ = new SingleFieldBuilderV3<>(getGaodeInfo(), getParentForChildren(), isClean());
                    this.gaodeInfo_ = null;
                }
                return this.gaodeInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public boolean hasBpInfo() {
                return (this.bpInfoBuilder_ == null && this.bpInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public DynamicEnvironmentOuterClass.BPoutput getBpInfo() {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.BPoutput, DynamicEnvironmentOuterClass.BPoutput.Builder, DynamicEnvironmentOuterClass.BPoutputOrBuilder> singleFieldBuilderV3 = this.bpInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    DynamicEnvironmentOuterClass.BPoutput bPoutput = this.bpInfo_;
                    return bPoutput == null ? DynamicEnvironmentOuterClass.BPoutput.getDefaultInstance() : bPoutput;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setBpInfo(DynamicEnvironmentOuterClass.BPoutput bPoutput) {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.BPoutput, DynamicEnvironmentOuterClass.BPoutput.Builder, DynamicEnvironmentOuterClass.BPoutputOrBuilder> singleFieldBuilderV3 = this.bpInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(bPoutput);
                } else if (bPoutput == null) {
                    throw new NullPointerException();
                } else {
                    this.bpInfo_ = bPoutput;
                    onChanged();
                }
                return this;
            }

            public Builder setBpInfo(DynamicEnvironmentOuterClass.BPoutput.Builder builder) {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.BPoutput, DynamicEnvironmentOuterClass.BPoutput.Builder, DynamicEnvironmentOuterClass.BPoutputOrBuilder> singleFieldBuilderV3 = this.bpInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.bpInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeBpInfo(DynamicEnvironmentOuterClass.BPoutput bPoutput) {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.BPoutput, DynamicEnvironmentOuterClass.BPoutput.Builder, DynamicEnvironmentOuterClass.BPoutputOrBuilder> singleFieldBuilderV3 = this.bpInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    DynamicEnvironmentOuterClass.BPoutput bPoutput2 = this.bpInfo_;
                    if (bPoutput2 != null) {
                        this.bpInfo_ = DynamicEnvironmentOuterClass.BPoutput.newBuilder(bPoutput2).mergeFrom(bPoutput).buildPartial();
                    } else {
                        this.bpInfo_ = bPoutput;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(bPoutput);
                }
                return this;
            }

            public Builder clearBpInfo() {
                if (this.bpInfoBuilder_ == null) {
                    this.bpInfo_ = null;
                    onChanged();
                } else {
                    this.bpInfo_ = null;
                    this.bpInfoBuilder_ = null;
                }
                return this;
            }

            public DynamicEnvironmentOuterClass.BPoutput.Builder getBpInfoBuilder() {
                onChanged();
                return getBpInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public DynamicEnvironmentOuterClass.BPoutputOrBuilder getBpInfoOrBuilder() {
                SingleFieldBuilderV3<DynamicEnvironmentOuterClass.BPoutput, DynamicEnvironmentOuterClass.BPoutput.Builder, DynamicEnvironmentOuterClass.BPoutputOrBuilder> singleFieldBuilderV3 = this.bpInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                DynamicEnvironmentOuterClass.BPoutput bPoutput = this.bpInfo_;
                return bPoutput == null ? DynamicEnvironmentOuterClass.BPoutput.getDefaultInstance() : bPoutput;
            }

            private SingleFieldBuilderV3<DynamicEnvironmentOuterClass.BPoutput, DynamicEnvironmentOuterClass.BPoutput.Builder, DynamicEnvironmentOuterClass.BPoutputOrBuilder> getBpInfoFieldBuilder() {
                if (this.bpInfoBuilder_ == null) {
                    this.bpInfoBuilder_ = new SingleFieldBuilderV3<>(getBpInfo(), getParentForChildren(), isClean());
                    this.bpInfo_ = null;
                }
                return this.bpInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
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

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public int getSaveProtoSignal() {
                return this.saveProtoSignal_;
            }

            public Builder setSaveProtoSignal(int i) {
                this.saveProtoSignal_ = i;
                onChanged();
                return this;
            }

            public Builder clearSaveProtoSignal() {
                this.saveProtoSignal_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public int getUseLastMp() {
                return this.useLastMp_;
            }

            public Builder setUseLastMp(int i) {
                this.useLastMp_ = i;
                onChanged();
                return this;
            }

            public Builder clearUseLastMp() {
                this.useLastMp_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public int getUseLastSfbp() {
                return this.useLastSfbp_;
            }

            public Builder setUseLastSfbp(int i) {
                this.useLastSfbp_ = i;
                onChanged();
                return this;
            }

            public Builder clearUseLastSfbp() {
                this.useLastSfbp_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public ByteString getXpPosInfo() {
                return this.xpPosInfo_;
            }

            public Builder setXpPosInfo(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.xpPosInfo_ = byteString;
                onChanged();
                return this;
            }

            public Builder clearXpPosInfo() {
                this.xpPosInfo_ = overall.getDefaultInstance().getXpPosInfo();
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Overall.overallOrBuilder
            public ByteString getXpEhpVersion() {
                return this.xpEhpVersion_;
            }

            public Builder setXpEhpVersion(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.xpEhpVersion_ = byteString;
                onChanged();
                return this;
            }

            public Builder clearXpEhpVersion() {
                this.xpEhpVersion_ = overall.getDefaultInstance().getXpEhpVersion();
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

        public static overall getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<overall> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<overall> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public overall getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class total_overall extends GeneratedMessageV3 implements total_overallOrBuilder {
        public static final int OVERALL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<overall> overall_;
        private static final total_overall DEFAULT_INSTANCE = new total_overall();
        private static final Parser<total_overall> PARSER = new AbstractParser<total_overall>() { // from class: xpilot.sr.proto.Overall.total_overall.1
            @Override // com.google.protobuf.Parser
            public total_overall parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new total_overall(codedInputStream, extensionRegistryLite);
            }
        };

        private total_overall(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private total_overall() {
            this.memoizedIsInitialized = (byte) -1;
            this.overall_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private total_overall(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                        this.overall_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.overall_.add(codedInputStream.readMessage(overall.parser(), extensionRegistryLite));
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
                        this.overall_ = Collections.unmodifiableList(this.overall_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Overall.internal_static_xpilot_sr_proto_total_overall_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_total_overall_fieldAccessorTable.ensureFieldAccessorsInitialized(total_overall.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
        public List<overall> getOverallList() {
            return this.overall_;
        }

        @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
        public List<? extends overallOrBuilder> getOverallOrBuilderList() {
            return this.overall_;
        }

        @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
        public int getOverallCount() {
            return this.overall_.size();
        }

        @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
        public overall getOverall(int i) {
            return this.overall_.get(i);
        }

        @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
        public overallOrBuilder getOverallOrBuilder(int i) {
            return this.overall_.get(i);
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
            for (int i = 0; i < this.overall_.size(); i++) {
                codedOutputStream.writeMessage(1, this.overall_.get(i));
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
            for (int i3 = 0; i3 < this.overall_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.overall_.get(i3));
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
            if (!(obj instanceof total_overall)) {
                return super.equals(obj);
            }
            total_overall total_overallVar = (total_overall) obj;
            return (getOverallList().equals(total_overallVar.getOverallList())) && this.unknownFields.equals(total_overallVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getOverallCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getOverallList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static total_overall parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static total_overall parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static total_overall parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static total_overall parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static total_overall parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static total_overall parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static total_overall parseFrom(InputStream inputStream) throws IOException {
            return (total_overall) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static total_overall parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (total_overall) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static total_overall parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (total_overall) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static total_overall parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (total_overall) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static total_overall parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (total_overall) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static total_overall parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (total_overall) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(total_overall total_overallVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(total_overallVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements total_overallOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> overallBuilder_;
            private List<overall> overall_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_total_overall_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_total_overall_fieldAccessorTable.ensureFieldAccessorsInitialized(total_overall.class, Builder.class);
            }

            private Builder() {
                this.overall_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.overall_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (total_overall.alwaysUseFieldBuilders) {
                    getOverallFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.overall_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_total_overall_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public total_overall getDefaultInstanceForType() {
                return total_overall.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public total_overall build() {
                total_overall buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public total_overall buildPartial() {
                total_overall total_overallVar = new total_overall(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.overall_ = Collections.unmodifiableList(this.overall_);
                        this.bitField0_ &= -2;
                    }
                    total_overallVar.overall_ = this.overall_;
                } else {
                    total_overallVar.overall_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return total_overallVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof total_overall) {
                    return mergeFrom((total_overall) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(total_overall total_overallVar) {
                if (total_overallVar == total_overall.getDefaultInstance()) {
                    return this;
                }
                if (this.overallBuilder_ == null) {
                    if (!total_overallVar.overall_.isEmpty()) {
                        if (this.overall_.isEmpty()) {
                            this.overall_ = total_overallVar.overall_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureOverallIsMutable();
                            this.overall_.addAll(total_overallVar.overall_);
                        }
                        onChanged();
                    }
                } else if (!total_overallVar.overall_.isEmpty()) {
                    if (!this.overallBuilder_.isEmpty()) {
                        this.overallBuilder_.addAllMessages(total_overallVar.overall_);
                    } else {
                        this.overallBuilder_.dispose();
                        this.overallBuilder_ = null;
                        this.overall_ = total_overallVar.overall_;
                        this.bitField0_ &= -2;
                        this.overallBuilder_ = total_overall.alwaysUseFieldBuilders ? getOverallFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(total_overallVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.total_overall.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.total_overall.access$3300()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$total_overall r3 = (xpilot.sr.proto.Overall.total_overall) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$total_overall r4 = (xpilot.sr.proto.Overall.total_overall) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.total_overall.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$total_overall$Builder");
            }

            private void ensureOverallIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.overall_ = new ArrayList(this.overall_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
            public List<overall> getOverallList() {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.overall_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
            public int getOverallCount() {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.overall_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
            public overall getOverall(int i) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.overall_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setOverall(int i, overall overallVar) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, overallVar);
                } else if (overallVar == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverallIsMutable();
                    this.overall_.set(i, overallVar);
                    onChanged();
                }
                return this;
            }

            public Builder setOverall(int i, overall.Builder builder) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallIsMutable();
                    this.overall_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addOverall(overall overallVar) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(overallVar);
                } else if (overallVar == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverallIsMutable();
                    this.overall_.add(overallVar);
                    onChanged();
                }
                return this;
            }

            public Builder addOverall(int i, overall overallVar) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, overallVar);
                } else if (overallVar == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverallIsMutable();
                    this.overall_.add(i, overallVar);
                    onChanged();
                }
                return this;
            }

            public Builder addOverall(overall.Builder builder) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallIsMutable();
                    this.overall_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addOverall(int i, overall.Builder builder) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallIsMutable();
                    this.overall_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllOverall(Iterable<? extends overall> iterable) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.overall_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearOverall() {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.overall_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeOverall(int i) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallIsMutable();
                    this.overall_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public overall.Builder getOverallBuilder(int i) {
                return getOverallFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
            public overallOrBuilder getOverallOrBuilder(int i) {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.overall_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.total_overallOrBuilder
            public List<? extends overallOrBuilder> getOverallOrBuilderList() {
                RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> repeatedFieldBuilderV3 = this.overallBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.overall_);
            }

            public overall.Builder addOverallBuilder() {
                return getOverallFieldBuilder().addBuilder(overall.getDefaultInstance());
            }

            public overall.Builder addOverallBuilder(int i) {
                return getOverallFieldBuilder().addBuilder(i, overall.getDefaultInstance());
            }

            public List<overall.Builder> getOverallBuilderList() {
                return getOverallFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<overall, overall.Builder, overallOrBuilder> getOverallFieldBuilder() {
                if (this.overallBuilder_ == null) {
                    this.overallBuilder_ = new RepeatedFieldBuilderV3<>(this.overall_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.overall_ = null;
                }
                return this.overallBuilder_;
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

        public static total_overall getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<total_overall> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<total_overall> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public total_overall getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class overall_imu_nmea extends GeneratedMessageV3 implements overall_imu_nmeaOrBuilder {
        public static final int IMUINFO_FIELD_NUMBER = 2;
        public static final int NMEADATAINFO_FIELD_NUMBER = 3;
        public static final int OVERALL_GAODE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Imudata.ImuInfo imuInfo_;
        private byte memoizedIsInitialized;
        private List<Nmeadata.NmeadataInfo> nmeadataInfo_;
        private overall_gaode overallGaode_;
        private static final overall_imu_nmea DEFAULT_INSTANCE = new overall_imu_nmea();
        private static final Parser<overall_imu_nmea> PARSER = new AbstractParser<overall_imu_nmea>() { // from class: xpilot.sr.proto.Overall.overall_imu_nmea.1
            @Override // com.google.protobuf.Parser
            public overall_imu_nmea parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new overall_imu_nmea(codedInputStream, extensionRegistryLite);
            }
        };

        private overall_imu_nmea(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private overall_imu_nmea() {
            this.memoizedIsInitialized = (byte) -1;
            this.nmeadataInfo_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private overall_imu_nmea(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    overall_gaode.Builder builder = this.overallGaode_ != null ? this.overallGaode_.toBuilder() : null;
                                    this.overallGaode_ = (overall_gaode) codedInputStream.readMessage(overall_gaode.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.overallGaode_);
                                        this.overallGaode_ = builder.buildPartial();
                                    }
                                } else if (readTag == 18) {
                                    Imudata.ImuInfo.Builder builder2 = this.imuInfo_ != null ? this.imuInfo_.toBuilder() : null;
                                    this.imuInfo_ = (Imudata.ImuInfo) codedInputStream.readMessage(Imudata.ImuInfo.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom(this.imuInfo_);
                                        this.imuInfo_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 26) {
                                    boolean z3 = (z2 ? 1 : 0) & true;
                                    z2 = z2;
                                    if (!z3) {
                                        this.nmeadataInfo_ = new ArrayList();
                                        z2 = (z2 ? 1 : 0) | true;
                                    }
                                    this.nmeadataInfo_.add(codedInputStream.readMessage(Nmeadata.NmeadataInfo.parser(), extensionRegistryLite));
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
                    if ((z2 ? 1 : 0) & true) {
                        this.nmeadataInfo_ = Collections.unmodifiableList(this.nmeadataInfo_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Overall.internal_static_xpilot_sr_proto_overall_imu_nmea_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_overall_imu_nmea_fieldAccessorTable.ensureFieldAccessorsInitialized(overall_imu_nmea.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public boolean hasOverallGaode() {
            return this.overallGaode_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public overall_gaode getOverallGaode() {
            overall_gaode overall_gaodeVar = this.overallGaode_;
            return overall_gaodeVar == null ? overall_gaode.getDefaultInstance() : overall_gaodeVar;
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public overall_gaodeOrBuilder getOverallGaodeOrBuilder() {
            return getOverallGaode();
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public boolean hasImuInfo() {
            return this.imuInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public Imudata.ImuInfo getImuInfo() {
            Imudata.ImuInfo imuInfo = this.imuInfo_;
            return imuInfo == null ? Imudata.ImuInfo.getDefaultInstance() : imuInfo;
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public Imudata.ImuInfoOrBuilder getImuInfoOrBuilder() {
            return getImuInfo();
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public List<Nmeadata.NmeadataInfo> getNmeadataInfoList() {
            return this.nmeadataInfo_;
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public List<? extends Nmeadata.NmeadataInfoOrBuilder> getNmeadataInfoOrBuilderList() {
            return this.nmeadataInfo_;
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public int getNmeadataInfoCount() {
            return this.nmeadataInfo_.size();
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public Nmeadata.NmeadataInfo getNmeadataInfo(int i) {
            return this.nmeadataInfo_.get(i);
        }

        @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
        public Nmeadata.NmeadataInfoOrBuilder getNmeadataInfoOrBuilder(int i) {
            return this.nmeadataInfo_.get(i);
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
            if (this.overallGaode_ != null) {
                codedOutputStream.writeMessage(1, getOverallGaode());
            }
            if (this.imuInfo_ != null) {
                codedOutputStream.writeMessage(2, getImuInfo());
            }
            for (int i = 0; i < this.nmeadataInfo_.size(); i++) {
                codedOutputStream.writeMessage(3, this.nmeadataInfo_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.overallGaode_ != null ? CodedOutputStream.computeMessageSize(1, getOverallGaode()) + 0 : 0;
            if (this.imuInfo_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getImuInfo());
            }
            for (int i2 = 0; i2 < this.nmeadataInfo_.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, this.nmeadataInfo_.get(i2));
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
            if (!(obj instanceof overall_imu_nmea)) {
                return super.equals(obj);
            }
            overall_imu_nmea overall_imu_nmeaVar = (overall_imu_nmea) obj;
            boolean z = hasOverallGaode() == overall_imu_nmeaVar.hasOverallGaode();
            if (hasOverallGaode()) {
                z = z && getOverallGaode().equals(overall_imu_nmeaVar.getOverallGaode());
            }
            boolean z2 = z && hasImuInfo() == overall_imu_nmeaVar.hasImuInfo();
            if (hasImuInfo()) {
                z2 = z2 && getImuInfo().equals(overall_imu_nmeaVar.getImuInfo());
            }
            return (z2 && getNmeadataInfoList().equals(overall_imu_nmeaVar.getNmeadataInfoList())) && this.unknownFields.equals(overall_imu_nmeaVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasOverallGaode()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getOverallGaode().hashCode();
            }
            if (hasImuInfo()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getImuInfo().hashCode();
            }
            if (getNmeadataInfoCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getNmeadataInfoList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static overall_imu_nmea parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static overall_imu_nmea parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static overall_imu_nmea parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static overall_imu_nmea parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static overall_imu_nmea parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static overall_imu_nmea parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static overall_imu_nmea parseFrom(InputStream inputStream) throws IOException {
            return (overall_imu_nmea) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static overall_imu_nmea parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall_imu_nmea) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static overall_imu_nmea parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (overall_imu_nmea) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static overall_imu_nmea parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall_imu_nmea) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static overall_imu_nmea parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (overall_imu_nmea) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static overall_imu_nmea parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall_imu_nmea) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(overall_imu_nmea overall_imu_nmeaVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(overall_imu_nmeaVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements overall_imu_nmeaOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> imuInfoBuilder_;
            private Imudata.ImuInfo imuInfo_;
            private RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> nmeadataInfoBuilder_;
            private List<Nmeadata.NmeadataInfo> nmeadataInfo_;
            private SingleFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> overallGaodeBuilder_;
            private overall_gaode overallGaode_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_overall_imu_nmea_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_overall_imu_nmea_fieldAccessorTable.ensureFieldAccessorsInitialized(overall_imu_nmea.class, Builder.class);
            }

            private Builder() {
                this.overallGaode_ = null;
                this.imuInfo_ = null;
                this.nmeadataInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.overallGaode_ = null;
                this.imuInfo_ = null;
                this.nmeadataInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (overall_imu_nmea.alwaysUseFieldBuilders) {
                    getNmeadataInfoFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.overallGaodeBuilder_ == null) {
                    this.overallGaode_ = null;
                } else {
                    this.overallGaode_ = null;
                    this.overallGaodeBuilder_ = null;
                }
                if (this.imuInfoBuilder_ == null) {
                    this.imuInfo_ = null;
                } else {
                    this.imuInfo_ = null;
                    this.imuInfoBuilder_ = null;
                }
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.nmeadataInfo_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_overall_imu_nmea_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public overall_imu_nmea getDefaultInstanceForType() {
                return overall_imu_nmea.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public overall_imu_nmea build() {
                overall_imu_nmea buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public overall_imu_nmea buildPartial() {
                overall_imu_nmea overall_imu_nmeaVar = new overall_imu_nmea(this);
                int i = this.bitField0_;
                SingleFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> singleFieldBuilderV3 = this.overallGaodeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall_imu_nmeaVar.overallGaode_ = this.overallGaode_;
                } else {
                    overall_imu_nmeaVar.overallGaode_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV32 = this.imuInfoBuilder_;
                if (singleFieldBuilderV32 == null) {
                    overall_imu_nmeaVar.imuInfo_ = this.imuInfo_;
                } else {
                    overall_imu_nmeaVar.imuInfo_ = singleFieldBuilderV32.build();
                }
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    overall_imu_nmeaVar.nmeadataInfo_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 4) == 4) {
                        this.nmeadataInfo_ = Collections.unmodifiableList(this.nmeadataInfo_);
                        this.bitField0_ &= -5;
                    }
                    overall_imu_nmeaVar.nmeadataInfo_ = this.nmeadataInfo_;
                }
                overall_imu_nmeaVar.bitField0_ = 0;
                onBuilt();
                return overall_imu_nmeaVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof overall_imu_nmea) {
                    return mergeFrom((overall_imu_nmea) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(overall_imu_nmea overall_imu_nmeaVar) {
                if (overall_imu_nmeaVar == overall_imu_nmea.getDefaultInstance()) {
                    return this;
                }
                if (overall_imu_nmeaVar.hasOverallGaode()) {
                    mergeOverallGaode(overall_imu_nmeaVar.getOverallGaode());
                }
                if (overall_imu_nmeaVar.hasImuInfo()) {
                    mergeImuInfo(overall_imu_nmeaVar.getImuInfo());
                }
                if (this.nmeadataInfoBuilder_ == null) {
                    if (!overall_imu_nmeaVar.nmeadataInfo_.isEmpty()) {
                        if (this.nmeadataInfo_.isEmpty()) {
                            this.nmeadataInfo_ = overall_imu_nmeaVar.nmeadataInfo_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureNmeadataInfoIsMutable();
                            this.nmeadataInfo_.addAll(overall_imu_nmeaVar.nmeadataInfo_);
                        }
                        onChanged();
                    }
                } else if (!overall_imu_nmeaVar.nmeadataInfo_.isEmpty()) {
                    if (!this.nmeadataInfoBuilder_.isEmpty()) {
                        this.nmeadataInfoBuilder_.addAllMessages(overall_imu_nmeaVar.nmeadataInfo_);
                    } else {
                        this.nmeadataInfoBuilder_.dispose();
                        this.nmeadataInfoBuilder_ = null;
                        this.nmeadataInfo_ = overall_imu_nmeaVar.nmeadataInfo_;
                        this.bitField0_ &= -5;
                        this.nmeadataInfoBuilder_ = overall_imu_nmea.alwaysUseFieldBuilders ? getNmeadataInfoFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(overall_imu_nmeaVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.overall_imu_nmea.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.overall_imu_nmea.access$4700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$overall_imu_nmea r3 = (xpilot.sr.proto.Overall.overall_imu_nmea) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$overall_imu_nmea r4 = (xpilot.sr.proto.Overall.overall_imu_nmea) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.overall_imu_nmea.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$overall_imu_nmea$Builder");
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public boolean hasOverallGaode() {
                return (this.overallGaodeBuilder_ == null && this.overallGaode_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public overall_gaode getOverallGaode() {
                SingleFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> singleFieldBuilderV3 = this.overallGaodeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall_gaode overall_gaodeVar = this.overallGaode_;
                    return overall_gaodeVar == null ? overall_gaode.getDefaultInstance() : overall_gaodeVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setOverallGaode(overall_gaode overall_gaodeVar) {
                SingleFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> singleFieldBuilderV3 = this.overallGaodeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(overall_gaodeVar);
                } else if (overall_gaodeVar == null) {
                    throw new NullPointerException();
                } else {
                    this.overallGaode_ = overall_gaodeVar;
                    onChanged();
                }
                return this;
            }

            public Builder setOverallGaode(overall_gaode.Builder builder) {
                SingleFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> singleFieldBuilderV3 = this.overallGaodeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.overallGaode_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeOverallGaode(overall_gaode overall_gaodeVar) {
                SingleFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> singleFieldBuilderV3 = this.overallGaodeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall_gaode overall_gaodeVar2 = this.overallGaode_;
                    if (overall_gaodeVar2 != null) {
                        this.overallGaode_ = overall_gaode.newBuilder(overall_gaodeVar2).mergeFrom(overall_gaodeVar).buildPartial();
                    } else {
                        this.overallGaode_ = overall_gaodeVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(overall_gaodeVar);
                }
                return this;
            }

            public Builder clearOverallGaode() {
                if (this.overallGaodeBuilder_ == null) {
                    this.overallGaode_ = null;
                    onChanged();
                } else {
                    this.overallGaode_ = null;
                    this.overallGaodeBuilder_ = null;
                }
                return this;
            }

            public overall_gaode.Builder getOverallGaodeBuilder() {
                onChanged();
                return getOverallGaodeFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public overall_gaodeOrBuilder getOverallGaodeOrBuilder() {
                SingleFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> singleFieldBuilderV3 = this.overallGaodeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                overall_gaode overall_gaodeVar = this.overallGaode_;
                return overall_gaodeVar == null ? overall_gaode.getDefaultInstance() : overall_gaodeVar;
            }

            private SingleFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> getOverallGaodeFieldBuilder() {
                if (this.overallGaodeBuilder_ == null) {
                    this.overallGaodeBuilder_ = new SingleFieldBuilderV3<>(getOverallGaode(), getParentForChildren(), isClean());
                    this.overallGaode_ = null;
                }
                return this.overallGaodeBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public boolean hasImuInfo() {
                return (this.imuInfoBuilder_ == null && this.imuInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public Imudata.ImuInfo getImuInfo() {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Imudata.ImuInfo imuInfo = this.imuInfo_;
                    return imuInfo == null ? Imudata.ImuInfo.getDefaultInstance() : imuInfo;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setImuInfo(Imudata.ImuInfo imuInfo) {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(imuInfo);
                } else if (imuInfo == null) {
                    throw new NullPointerException();
                } else {
                    this.imuInfo_ = imuInfo;
                    onChanged();
                }
                return this;
            }

            public Builder setImuInfo(Imudata.ImuInfo.Builder builder) {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.imuInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeImuInfo(Imudata.ImuInfo imuInfo) {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Imudata.ImuInfo imuInfo2 = this.imuInfo_;
                    if (imuInfo2 != null) {
                        this.imuInfo_ = Imudata.ImuInfo.newBuilder(imuInfo2).mergeFrom(imuInfo).buildPartial();
                    } else {
                        this.imuInfo_ = imuInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(imuInfo);
                }
                return this;
            }

            public Builder clearImuInfo() {
                if (this.imuInfoBuilder_ == null) {
                    this.imuInfo_ = null;
                    onChanged();
                } else {
                    this.imuInfo_ = null;
                    this.imuInfoBuilder_ = null;
                }
                return this;
            }

            public Imudata.ImuInfo.Builder getImuInfoBuilder() {
                onChanged();
                return getImuInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public Imudata.ImuInfoOrBuilder getImuInfoOrBuilder() {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Imudata.ImuInfo imuInfo = this.imuInfo_;
                return imuInfo == null ? Imudata.ImuInfo.getDefaultInstance() : imuInfo;
            }

            private SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> getImuInfoFieldBuilder() {
                if (this.imuInfoBuilder_ == null) {
                    this.imuInfoBuilder_ = new SingleFieldBuilderV3<>(getImuInfo(), getParentForChildren(), isClean());
                    this.imuInfo_ = null;
                }
                return this.imuInfoBuilder_;
            }

            private void ensureNmeadataInfoIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.nmeadataInfo_ = new ArrayList(this.nmeadataInfo_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public List<Nmeadata.NmeadataInfo> getNmeadataInfoList() {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.nmeadataInfo_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public int getNmeadataInfoCount() {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.nmeadataInfo_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public Nmeadata.NmeadataInfo getNmeadataInfo(int i) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.nmeadataInfo_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setNmeadataInfo(int i, Nmeadata.NmeadataInfo nmeadataInfo) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, nmeadataInfo);
                } else if (nmeadataInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.set(i, nmeadataInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setNmeadataInfo(int i, Nmeadata.NmeadataInfo.Builder builder) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addNmeadataInfo(Nmeadata.NmeadataInfo nmeadataInfo) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(nmeadataInfo);
                } else if (nmeadataInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.add(nmeadataInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addNmeadataInfo(int i, Nmeadata.NmeadataInfo nmeadataInfo) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, nmeadataInfo);
                } else if (nmeadataInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.add(i, nmeadataInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addNmeadataInfo(Nmeadata.NmeadataInfo.Builder builder) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addNmeadataInfo(int i, Nmeadata.NmeadataInfo.Builder builder) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllNmeadataInfo(Iterable<? extends Nmeadata.NmeadataInfo> iterable) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.nmeadataInfo_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearNmeadataInfo() {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.nmeadataInfo_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeNmeadataInfo(int i) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Nmeadata.NmeadataInfo.Builder getNmeadataInfoBuilder(int i) {
                return getNmeadataInfoFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public Nmeadata.NmeadataInfoOrBuilder getNmeadataInfoOrBuilder(int i) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.nmeadataInfo_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.overall_imu_nmeaOrBuilder
            public List<? extends Nmeadata.NmeadataInfoOrBuilder> getNmeadataInfoOrBuilderList() {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.nmeadataInfo_);
            }

            public Nmeadata.NmeadataInfo.Builder addNmeadataInfoBuilder() {
                return getNmeadataInfoFieldBuilder().addBuilder(Nmeadata.NmeadataInfo.getDefaultInstance());
            }

            public Nmeadata.NmeadataInfo.Builder addNmeadataInfoBuilder(int i) {
                return getNmeadataInfoFieldBuilder().addBuilder(i, Nmeadata.NmeadataInfo.getDefaultInstance());
            }

            public List<Nmeadata.NmeadataInfo.Builder> getNmeadataInfoBuilderList() {
                return getNmeadataInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> getNmeadataInfoFieldBuilder() {
                if (this.nmeadataInfoBuilder_ == null) {
                    this.nmeadataInfoBuilder_ = new RepeatedFieldBuilderV3<>(this.nmeadataInfo_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.nmeadataInfo_ = null;
                }
                return this.nmeadataInfoBuilder_;
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

        public static overall_imu_nmea getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<overall_imu_nmea> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<overall_imu_nmea> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public overall_imu_nmea getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class overall_gaode extends GeneratedMessageV3 implements overall_gaodeOrBuilder {
        public static final int AUTOPILOTDATA_FIELD_NUMBER = 2;
        public static final int OVERALL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private AutoPilotDataOuterClass.AutoPilotData autoPilotData_;
        private byte memoizedIsInitialized;
        private overall overall_;
        private static final overall_gaode DEFAULT_INSTANCE = new overall_gaode();
        private static final Parser<overall_gaode> PARSER = new AbstractParser<overall_gaode>() { // from class: xpilot.sr.proto.Overall.overall_gaode.1
            @Override // com.google.protobuf.Parser
            public overall_gaode parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new overall_gaode(codedInputStream, extensionRegistryLite);
            }
        };

        private overall_gaode(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private overall_gaode() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private overall_gaode(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                overall.Builder builder = this.overall_ != null ? this.overall_.toBuilder() : null;
                                this.overall_ = (overall) codedInputStream.readMessage(overall.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.overall_);
                                    this.overall_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                AutoPilotDataOuterClass.AutoPilotData.Builder builder2 = this.autoPilotData_ != null ? this.autoPilotData_.toBuilder() : null;
                                this.autoPilotData_ = (AutoPilotDataOuterClass.AutoPilotData) codedInputStream.readMessage(AutoPilotDataOuterClass.AutoPilotData.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.autoPilotData_);
                                    this.autoPilotData_ = builder2.buildPartial();
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
            return Overall.internal_static_xpilot_sr_proto_overall_gaode_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_overall_gaode_fieldAccessorTable.ensureFieldAccessorsInitialized(overall_gaode.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
        public boolean hasOverall() {
            return this.overall_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
        public overall getOverall() {
            overall overallVar = this.overall_;
            return overallVar == null ? overall.getDefaultInstance() : overallVar;
        }

        @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
        public overallOrBuilder getOverallOrBuilder() {
            return getOverall();
        }

        @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
        public boolean hasAutoPilotData() {
            return this.autoPilotData_ != null;
        }

        @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
        public AutoPilotDataOuterClass.AutoPilotData getAutoPilotData() {
            AutoPilotDataOuterClass.AutoPilotData autoPilotData = this.autoPilotData_;
            return autoPilotData == null ? AutoPilotDataOuterClass.AutoPilotData.getDefaultInstance() : autoPilotData;
        }

        @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
        public AutoPilotDataOuterClass.AutoPilotDataOrBuilder getAutoPilotDataOrBuilder() {
            return getAutoPilotData();
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
            if (this.overall_ != null) {
                codedOutputStream.writeMessage(1, getOverall());
            }
            if (this.autoPilotData_ != null) {
                codedOutputStream.writeMessage(2, getAutoPilotData());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.overall_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getOverall()) : 0;
            if (this.autoPilotData_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getAutoPilotData());
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
            if (!(obj instanceof overall_gaode)) {
                return super.equals(obj);
            }
            overall_gaode overall_gaodeVar = (overall_gaode) obj;
            boolean z = hasOverall() == overall_gaodeVar.hasOverall();
            if (hasOverall()) {
                z = z && getOverall().equals(overall_gaodeVar.getOverall());
            }
            boolean z2 = z && hasAutoPilotData() == overall_gaodeVar.hasAutoPilotData();
            if (hasAutoPilotData()) {
                z2 = z2 && getAutoPilotData().equals(overall_gaodeVar.getAutoPilotData());
            }
            return z2 && this.unknownFields.equals(overall_gaodeVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasOverall()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getOverall().hashCode();
            }
            if (hasAutoPilotData()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getAutoPilotData().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static overall_gaode parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static overall_gaode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static overall_gaode parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static overall_gaode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static overall_gaode parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static overall_gaode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static overall_gaode parseFrom(InputStream inputStream) throws IOException {
            return (overall_gaode) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static overall_gaode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall_gaode) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static overall_gaode parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (overall_gaode) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static overall_gaode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall_gaode) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static overall_gaode parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (overall_gaode) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static overall_gaode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall_gaode) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(overall_gaode overall_gaodeVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(overall_gaodeVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements overall_gaodeOrBuilder {
            private SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> autoPilotDataBuilder_;
            private AutoPilotDataOuterClass.AutoPilotData autoPilotData_;
            private SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> overallBuilder_;
            private overall overall_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_overall_gaode_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_overall_gaode_fieldAccessorTable.ensureFieldAccessorsInitialized(overall_gaode.class, Builder.class);
            }

            private Builder() {
                this.overall_ = null;
                this.autoPilotData_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.overall_ = null;
                this.autoPilotData_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = overall_gaode.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.overallBuilder_ == null) {
                    this.overall_ = null;
                } else {
                    this.overall_ = null;
                    this.overallBuilder_ = null;
                }
                if (this.autoPilotDataBuilder_ == null) {
                    this.autoPilotData_ = null;
                } else {
                    this.autoPilotData_ = null;
                    this.autoPilotDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_overall_gaode_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public overall_gaode getDefaultInstanceForType() {
                return overall_gaode.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public overall_gaode build() {
                overall_gaode buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public overall_gaode buildPartial() {
                overall_gaode overall_gaodeVar = new overall_gaode(this);
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall_gaodeVar.overall_ = this.overall_;
                } else {
                    overall_gaodeVar.overall_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV32 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV32 == null) {
                    overall_gaodeVar.autoPilotData_ = this.autoPilotData_;
                } else {
                    overall_gaodeVar.autoPilotData_ = singleFieldBuilderV32.build();
                }
                onBuilt();
                return overall_gaodeVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof overall_gaode) {
                    return mergeFrom((overall_gaode) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(overall_gaode overall_gaodeVar) {
                if (overall_gaodeVar == overall_gaode.getDefaultInstance()) {
                    return this;
                }
                if (overall_gaodeVar.hasOverall()) {
                    mergeOverall(overall_gaodeVar.getOverall());
                }
                if (overall_gaodeVar.hasAutoPilotData()) {
                    mergeAutoPilotData(overall_gaodeVar.getAutoPilotData());
                }
                mergeUnknownFields(overall_gaodeVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.overall_gaode.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.overall_gaode.access$5800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$overall_gaode r3 = (xpilot.sr.proto.Overall.overall_gaode) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$overall_gaode r4 = (xpilot.sr.proto.Overall.overall_gaode) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.overall_gaode.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$overall_gaode$Builder");
            }

            @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
            public boolean hasOverall() {
                return (this.overallBuilder_ == null && this.overall_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
            public overall getOverall() {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall overallVar = this.overall_;
                    return overallVar == null ? overall.getDefaultInstance() : overallVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setOverall(overall overallVar) {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(overallVar);
                } else if (overallVar == null) {
                    throw new NullPointerException();
                } else {
                    this.overall_ = overallVar;
                    onChanged();
                }
                return this;
            }

            public Builder setOverall(overall.Builder builder) {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.overall_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeOverall(overall overallVar) {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall overallVar2 = this.overall_;
                    if (overallVar2 != null) {
                        this.overall_ = overall.newBuilder(overallVar2).mergeFrom(overallVar).buildPartial();
                    } else {
                        this.overall_ = overallVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(overallVar);
                }
                return this;
            }

            public Builder clearOverall() {
                if (this.overallBuilder_ == null) {
                    this.overall_ = null;
                    onChanged();
                } else {
                    this.overall_ = null;
                    this.overallBuilder_ = null;
                }
                return this;
            }

            public overall.Builder getOverallBuilder() {
                onChanged();
                return getOverallFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
            public overallOrBuilder getOverallOrBuilder() {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                overall overallVar = this.overall_;
                return overallVar == null ? overall.getDefaultInstance() : overallVar;
            }

            private SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> getOverallFieldBuilder() {
                if (this.overallBuilder_ == null) {
                    this.overallBuilder_ = new SingleFieldBuilderV3<>(getOverall(), getParentForChildren(), isClean());
                    this.overall_ = null;
                }
                return this.overallBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
            public boolean hasAutoPilotData() {
                return (this.autoPilotDataBuilder_ == null && this.autoPilotData_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
            public AutoPilotDataOuterClass.AutoPilotData getAutoPilotData() {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AutoPilotDataOuterClass.AutoPilotData autoPilotData = this.autoPilotData_;
                    return autoPilotData == null ? AutoPilotDataOuterClass.AutoPilotData.getDefaultInstance() : autoPilotData;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setAutoPilotData(AutoPilotDataOuterClass.AutoPilotData autoPilotData) {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(autoPilotData);
                } else if (autoPilotData == null) {
                    throw new NullPointerException();
                } else {
                    this.autoPilotData_ = autoPilotData;
                    onChanged();
                }
                return this;
            }

            public Builder setAutoPilotData(AutoPilotDataOuterClass.AutoPilotData.Builder builder) {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.autoPilotData_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeAutoPilotData(AutoPilotDataOuterClass.AutoPilotData autoPilotData) {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AutoPilotDataOuterClass.AutoPilotData autoPilotData2 = this.autoPilotData_;
                    if (autoPilotData2 != null) {
                        this.autoPilotData_ = AutoPilotDataOuterClass.AutoPilotData.newBuilder(autoPilotData2).mergeFrom(autoPilotData).buildPartial();
                    } else {
                        this.autoPilotData_ = autoPilotData;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(autoPilotData);
                }
                return this;
            }

            public Builder clearAutoPilotData() {
                if (this.autoPilotDataBuilder_ == null) {
                    this.autoPilotData_ = null;
                    onChanged();
                } else {
                    this.autoPilotData_ = null;
                    this.autoPilotDataBuilder_ = null;
                }
                return this;
            }

            public AutoPilotDataOuterClass.AutoPilotData.Builder getAutoPilotDataBuilder() {
                onChanged();
                return getAutoPilotDataFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.overall_gaodeOrBuilder
            public AutoPilotDataOuterClass.AutoPilotDataOrBuilder getAutoPilotDataOrBuilder() {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                AutoPilotDataOuterClass.AutoPilotData autoPilotData = this.autoPilotData_;
                return autoPilotData == null ? AutoPilotDataOuterClass.AutoPilotData.getDefaultInstance() : autoPilotData;
            }

            private SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> getAutoPilotDataFieldBuilder() {
                if (this.autoPilotDataBuilder_ == null) {
                    this.autoPilotDataBuilder_ = new SingleFieldBuilderV3<>(getAutoPilotData(), getParentForChildren(), isClean());
                    this.autoPilotData_ = null;
                }
                return this.autoPilotDataBuilder_;
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

        public static overall_gaode getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<overall_gaode> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<overall_gaode> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public overall_gaode getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class overall_cdutime extends GeneratedMessageV3 implements overall_cdutimeOrBuilder {
        public static final int CDU_TIME_FIELD_NUMBER = 2;
        public static final int OVERALL_GAODE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int cduTimeMemoizedSerializedSize;
        private List<Long> cduTime_;
        private byte memoizedIsInitialized;
        private List<overall_gaode> overallGaode_;
        private static final overall_cdutime DEFAULT_INSTANCE = new overall_cdutime();
        private static final Parser<overall_cdutime> PARSER = new AbstractParser<overall_cdutime>() { // from class: xpilot.sr.proto.Overall.overall_cdutime.1
            @Override // com.google.protobuf.Parser
            public overall_cdutime parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new overall_cdutime(codedInputStream, extensionRegistryLite);
            }
        };

        private overall_cdutime(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.cduTimeMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private overall_cdutime() {
            this.cduTimeMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.overallGaode_ = Collections.emptyList();
            this.cduTime_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private overall_cdutime(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.overallGaode_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.overallGaode_.add(codedInputStream.readMessage(overall_gaode.parser(), extensionRegistryLite));
                            } else if (readTag == 16) {
                                if (!(z2 & true)) {
                                    this.cduTime_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.cduTime_.add(Long.valueOf(codedInputStream.readUInt64()));
                            } else if (readTag == 18) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.cduTime_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.cduTime_.add(Long.valueOf(codedInputStream.readUInt64()));
                                }
                                codedInputStream.popLimit(pushLimit);
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
                        this.overallGaode_ = Collections.unmodifiableList(this.overallGaode_);
                    }
                    if (z2 & true) {
                        this.cduTime_ = Collections.unmodifiableList(this.cduTime_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Overall.internal_static_xpilot_sr_proto_overall_cdutime_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_overall_cdutime_fieldAccessorTable.ensureFieldAccessorsInitialized(overall_cdutime.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
        public List<overall_gaode> getOverallGaodeList() {
            return this.overallGaode_;
        }

        @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
        public List<? extends overall_gaodeOrBuilder> getOverallGaodeOrBuilderList() {
            return this.overallGaode_;
        }

        @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
        public int getOverallGaodeCount() {
            return this.overallGaode_.size();
        }

        @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
        public overall_gaode getOverallGaode(int i) {
            return this.overallGaode_.get(i);
        }

        @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
        public overall_gaodeOrBuilder getOverallGaodeOrBuilder(int i) {
            return this.overallGaode_.get(i);
        }

        @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
        public List<Long> getCduTimeList() {
            return this.cduTime_;
        }

        @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
        public int getCduTimeCount() {
            return this.cduTime_.size();
        }

        @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
        public long getCduTime(int i) {
            return this.cduTime_.get(i).longValue();
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
            for (int i = 0; i < this.overallGaode_.size(); i++) {
                codedOutputStream.writeMessage(1, this.overallGaode_.get(i));
            }
            if (getCduTimeList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(18);
                codedOutputStream.writeUInt32NoTag(this.cduTimeMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.cduTime_.size(); i2++) {
                codedOutputStream.writeUInt64NoTag(this.cduTime_.get(i2).longValue());
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
            for (int i3 = 0; i3 < this.overallGaode_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.overallGaode_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.cduTime_.size(); i5++) {
                i4 += CodedOutputStream.computeUInt64SizeNoTag(this.cduTime_.get(i5).longValue());
            }
            int i6 = i2 + i4;
            if (!getCduTimeList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.cduTimeMemoizedSerializedSize = i4;
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof overall_cdutime)) {
                return super.equals(obj);
            }
            overall_cdutime overall_cdutimeVar = (overall_cdutime) obj;
            return ((getOverallGaodeList().equals(overall_cdutimeVar.getOverallGaodeList())) && getCduTimeList().equals(overall_cdutimeVar.getCduTimeList())) && this.unknownFields.equals(overall_cdutimeVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getOverallGaodeCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getOverallGaodeList().hashCode();
            }
            if (getCduTimeCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getCduTimeList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static overall_cdutime parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static overall_cdutime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static overall_cdutime parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static overall_cdutime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static overall_cdutime parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static overall_cdutime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static overall_cdutime parseFrom(InputStream inputStream) throws IOException {
            return (overall_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static overall_cdutime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static overall_cdutime parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (overall_cdutime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static overall_cdutime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall_cdutime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static overall_cdutime parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (overall_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static overall_cdutime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (overall_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(overall_cdutime overall_cdutimeVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(overall_cdutimeVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements overall_cdutimeOrBuilder {
            private int bitField0_;
            private List<Long> cduTime_;
            private RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> overallGaodeBuilder_;
            private List<overall_gaode> overallGaode_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_overall_cdutime_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_overall_cdutime_fieldAccessorTable.ensureFieldAccessorsInitialized(overall_cdutime.class, Builder.class);
            }

            private Builder() {
                this.overallGaode_ = Collections.emptyList();
                this.cduTime_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.overallGaode_ = Collections.emptyList();
                this.cduTime_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (overall_cdutime.alwaysUseFieldBuilders) {
                    getOverallGaodeFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.overallGaode_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.cduTime_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_overall_cdutime_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public overall_cdutime getDefaultInstanceForType() {
                return overall_cdutime.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public overall_cdutime build() {
                overall_cdutime buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public overall_cdutime buildPartial() {
                overall_cdutime overall_cdutimeVar = new overall_cdutime(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.overallGaode_ = Collections.unmodifiableList(this.overallGaode_);
                        this.bitField0_ &= -2;
                    }
                    overall_cdutimeVar.overallGaode_ = this.overallGaode_;
                } else {
                    overall_cdutimeVar.overallGaode_ = repeatedFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 2) == 2) {
                    this.cduTime_ = Collections.unmodifiableList(this.cduTime_);
                    this.bitField0_ &= -3;
                }
                overall_cdutimeVar.cduTime_ = this.cduTime_;
                onBuilt();
                return overall_cdutimeVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof overall_cdutime) {
                    return mergeFrom((overall_cdutime) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(overall_cdutime overall_cdutimeVar) {
                if (overall_cdutimeVar == overall_cdutime.getDefaultInstance()) {
                    return this;
                }
                if (this.overallGaodeBuilder_ == null) {
                    if (!overall_cdutimeVar.overallGaode_.isEmpty()) {
                        if (this.overallGaode_.isEmpty()) {
                            this.overallGaode_ = overall_cdutimeVar.overallGaode_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureOverallGaodeIsMutable();
                            this.overallGaode_.addAll(overall_cdutimeVar.overallGaode_);
                        }
                        onChanged();
                    }
                } else if (!overall_cdutimeVar.overallGaode_.isEmpty()) {
                    if (!this.overallGaodeBuilder_.isEmpty()) {
                        this.overallGaodeBuilder_.addAllMessages(overall_cdutimeVar.overallGaode_);
                    } else {
                        this.overallGaodeBuilder_.dispose();
                        this.overallGaodeBuilder_ = null;
                        this.overallGaode_ = overall_cdutimeVar.overallGaode_;
                        this.bitField0_ &= -2;
                        this.overallGaodeBuilder_ = overall_cdutime.alwaysUseFieldBuilders ? getOverallGaodeFieldBuilder() : null;
                    }
                }
                if (!overall_cdutimeVar.cduTime_.isEmpty()) {
                    if (this.cduTime_.isEmpty()) {
                        this.cduTime_ = overall_cdutimeVar.cduTime_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureCduTimeIsMutable();
                        this.cduTime_.addAll(overall_cdutimeVar.cduTime_);
                    }
                    onChanged();
                }
                mergeUnknownFields(overall_cdutimeVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.overall_cdutime.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.overall_cdutime.access$7000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$overall_cdutime r3 = (xpilot.sr.proto.Overall.overall_cdutime) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$overall_cdutime r4 = (xpilot.sr.proto.Overall.overall_cdutime) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.overall_cdutime.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$overall_cdutime$Builder");
            }

            private void ensureOverallGaodeIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.overallGaode_ = new ArrayList(this.overallGaode_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
            public List<overall_gaode> getOverallGaodeList() {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.overallGaode_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
            public int getOverallGaodeCount() {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.overallGaode_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
            public overall_gaode getOverallGaode(int i) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.overallGaode_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setOverallGaode(int i, overall_gaode overall_gaodeVar) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, overall_gaodeVar);
                } else if (overall_gaodeVar == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverallGaodeIsMutable();
                    this.overallGaode_.set(i, overall_gaodeVar);
                    onChanged();
                }
                return this;
            }

            public Builder setOverallGaode(int i, overall_gaode.Builder builder) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallGaodeIsMutable();
                    this.overallGaode_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addOverallGaode(overall_gaode overall_gaodeVar) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(overall_gaodeVar);
                } else if (overall_gaodeVar == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverallGaodeIsMutable();
                    this.overallGaode_.add(overall_gaodeVar);
                    onChanged();
                }
                return this;
            }

            public Builder addOverallGaode(int i, overall_gaode overall_gaodeVar) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, overall_gaodeVar);
                } else if (overall_gaodeVar == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverallGaodeIsMutable();
                    this.overallGaode_.add(i, overall_gaodeVar);
                    onChanged();
                }
                return this;
            }

            public Builder addOverallGaode(overall_gaode.Builder builder) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallGaodeIsMutable();
                    this.overallGaode_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addOverallGaode(int i, overall_gaode.Builder builder) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallGaodeIsMutable();
                    this.overallGaode_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllOverallGaode(Iterable<? extends overall_gaode> iterable) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallGaodeIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.overallGaode_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearOverallGaode() {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.overallGaode_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeOverallGaode(int i) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureOverallGaodeIsMutable();
                    this.overallGaode_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public overall_gaode.Builder getOverallGaodeBuilder(int i) {
                return getOverallGaodeFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
            public overall_gaodeOrBuilder getOverallGaodeOrBuilder(int i) {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.overallGaode_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
            public List<? extends overall_gaodeOrBuilder> getOverallGaodeOrBuilderList() {
                RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> repeatedFieldBuilderV3 = this.overallGaodeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.overallGaode_);
            }

            public overall_gaode.Builder addOverallGaodeBuilder() {
                return getOverallGaodeFieldBuilder().addBuilder(overall_gaode.getDefaultInstance());
            }

            public overall_gaode.Builder addOverallGaodeBuilder(int i) {
                return getOverallGaodeFieldBuilder().addBuilder(i, overall_gaode.getDefaultInstance());
            }

            public List<overall_gaode.Builder> getOverallGaodeBuilderList() {
                return getOverallGaodeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<overall_gaode, overall_gaode.Builder, overall_gaodeOrBuilder> getOverallGaodeFieldBuilder() {
                if (this.overallGaodeBuilder_ == null) {
                    this.overallGaodeBuilder_ = new RepeatedFieldBuilderV3<>(this.overallGaode_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.overallGaode_ = null;
                }
                return this.overallGaodeBuilder_;
            }

            private void ensureCduTimeIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.cduTime_ = new ArrayList(this.cduTime_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
            public List<Long> getCduTimeList() {
                return Collections.unmodifiableList(this.cduTime_);
            }

            @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
            public int getCduTimeCount() {
                return this.cduTime_.size();
            }

            @Override // xpilot.sr.proto.Overall.overall_cdutimeOrBuilder
            public long getCduTime(int i) {
                return this.cduTime_.get(i).longValue();
            }

            public Builder setCduTime(int i, long j) {
                ensureCduTimeIsMutable();
                this.cduTime_.set(i, Long.valueOf(j));
                onChanged();
                return this;
            }

            public Builder addCduTime(long j) {
                ensureCduTimeIsMutable();
                this.cduTime_.add(Long.valueOf(j));
                onChanged();
                return this;
            }

            public Builder addAllCduTime(Iterable<? extends Long> iterable) {
                ensureCduTimeIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.cduTime_);
                onChanged();
                return this;
            }

            public Builder clearCduTime() {
                this.cduTime_ = Collections.emptyList();
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

        public static overall_cdutime getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<overall_cdutime> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<overall_cdutime> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public overall_cdutime getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class imu_cdutime extends GeneratedMessageV3 implements imu_cdutimeOrBuilder {
        public static final int CDU_TIME_FIELD_NUMBER = 2;
        public static final int IMUINFO_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int cduTimeMemoizedSerializedSize;
        private List<Long> cduTime_;
        private List<Imudata.ImuInfo> imuInfo_;
        private byte memoizedIsInitialized;
        private static final imu_cdutime DEFAULT_INSTANCE = new imu_cdutime();
        private static final Parser<imu_cdutime> PARSER = new AbstractParser<imu_cdutime>() { // from class: xpilot.sr.proto.Overall.imu_cdutime.1
            @Override // com.google.protobuf.Parser
            public imu_cdutime parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new imu_cdutime(codedInputStream, extensionRegistryLite);
            }
        };

        private imu_cdutime(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.cduTimeMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private imu_cdutime() {
            this.cduTimeMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.imuInfo_ = Collections.emptyList();
            this.cduTime_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private imu_cdutime(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.imuInfo_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.imuInfo_.add(codedInputStream.readMessage(Imudata.ImuInfo.parser(), extensionRegistryLite));
                            } else if (readTag == 16) {
                                if (!(z2 & true)) {
                                    this.cduTime_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.cduTime_.add(Long.valueOf(codedInputStream.readUInt64()));
                            } else if (readTag == 18) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.cduTime_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.cduTime_.add(Long.valueOf(codedInputStream.readUInt64()));
                                }
                                codedInputStream.popLimit(pushLimit);
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
                        this.imuInfo_ = Collections.unmodifiableList(this.imuInfo_);
                    }
                    if (z2 & true) {
                        this.cduTime_ = Collections.unmodifiableList(this.cduTime_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Overall.internal_static_xpilot_sr_proto_imu_cdutime_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_imu_cdutime_fieldAccessorTable.ensureFieldAccessorsInitialized(imu_cdutime.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
        public List<Imudata.ImuInfo> getImuInfoList() {
            return this.imuInfo_;
        }

        @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
        public List<? extends Imudata.ImuInfoOrBuilder> getImuInfoOrBuilderList() {
            return this.imuInfo_;
        }

        @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
        public int getImuInfoCount() {
            return this.imuInfo_.size();
        }

        @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
        public Imudata.ImuInfo getImuInfo(int i) {
            return this.imuInfo_.get(i);
        }

        @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
        public Imudata.ImuInfoOrBuilder getImuInfoOrBuilder(int i) {
            return this.imuInfo_.get(i);
        }

        @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
        public List<Long> getCduTimeList() {
            return this.cduTime_;
        }

        @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
        public int getCduTimeCount() {
            return this.cduTime_.size();
        }

        @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
        public long getCduTime(int i) {
            return this.cduTime_.get(i).longValue();
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
            for (int i = 0; i < this.imuInfo_.size(); i++) {
                codedOutputStream.writeMessage(1, this.imuInfo_.get(i));
            }
            if (getCduTimeList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(18);
                codedOutputStream.writeUInt32NoTag(this.cduTimeMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.cduTime_.size(); i2++) {
                codedOutputStream.writeUInt64NoTag(this.cduTime_.get(i2).longValue());
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
            for (int i3 = 0; i3 < this.imuInfo_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.imuInfo_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.cduTime_.size(); i5++) {
                i4 += CodedOutputStream.computeUInt64SizeNoTag(this.cduTime_.get(i5).longValue());
            }
            int i6 = i2 + i4;
            if (!getCduTimeList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.cduTimeMemoizedSerializedSize = i4;
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof imu_cdutime)) {
                return super.equals(obj);
            }
            imu_cdutime imu_cdutimeVar = (imu_cdutime) obj;
            return ((getImuInfoList().equals(imu_cdutimeVar.getImuInfoList())) && getCduTimeList().equals(imu_cdutimeVar.getCduTimeList())) && this.unknownFields.equals(imu_cdutimeVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getImuInfoCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getImuInfoList().hashCode();
            }
            if (getCduTimeCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getCduTimeList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static imu_cdutime parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static imu_cdutime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static imu_cdutime parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static imu_cdutime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static imu_cdutime parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static imu_cdutime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static imu_cdutime parseFrom(InputStream inputStream) throws IOException {
            return (imu_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static imu_cdutime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (imu_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static imu_cdutime parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (imu_cdutime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static imu_cdutime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (imu_cdutime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static imu_cdutime parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (imu_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static imu_cdutime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (imu_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(imu_cdutime imu_cdutimeVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(imu_cdutimeVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements imu_cdutimeOrBuilder {
            private int bitField0_;
            private List<Long> cduTime_;
            private RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> imuInfoBuilder_;
            private List<Imudata.ImuInfo> imuInfo_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_imu_cdutime_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_imu_cdutime_fieldAccessorTable.ensureFieldAccessorsInitialized(imu_cdutime.class, Builder.class);
            }

            private Builder() {
                this.imuInfo_ = Collections.emptyList();
                this.cduTime_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.imuInfo_ = Collections.emptyList();
                this.cduTime_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (imu_cdutime.alwaysUseFieldBuilders) {
                    getImuInfoFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.imuInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.cduTime_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_imu_cdutime_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public imu_cdutime getDefaultInstanceForType() {
                return imu_cdutime.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public imu_cdutime build() {
                imu_cdutime buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public imu_cdutime buildPartial() {
                imu_cdutime imu_cdutimeVar = new imu_cdutime(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.imuInfo_ = Collections.unmodifiableList(this.imuInfo_);
                        this.bitField0_ &= -2;
                    }
                    imu_cdutimeVar.imuInfo_ = this.imuInfo_;
                } else {
                    imu_cdutimeVar.imuInfo_ = repeatedFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 2) == 2) {
                    this.cduTime_ = Collections.unmodifiableList(this.cduTime_);
                    this.bitField0_ &= -3;
                }
                imu_cdutimeVar.cduTime_ = this.cduTime_;
                onBuilt();
                return imu_cdutimeVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof imu_cdutime) {
                    return mergeFrom((imu_cdutime) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(imu_cdutime imu_cdutimeVar) {
                if (imu_cdutimeVar == imu_cdutime.getDefaultInstance()) {
                    return this;
                }
                if (this.imuInfoBuilder_ == null) {
                    if (!imu_cdutimeVar.imuInfo_.isEmpty()) {
                        if (this.imuInfo_.isEmpty()) {
                            this.imuInfo_ = imu_cdutimeVar.imuInfo_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureImuInfoIsMutable();
                            this.imuInfo_.addAll(imu_cdutimeVar.imuInfo_);
                        }
                        onChanged();
                    }
                } else if (!imu_cdutimeVar.imuInfo_.isEmpty()) {
                    if (!this.imuInfoBuilder_.isEmpty()) {
                        this.imuInfoBuilder_.addAllMessages(imu_cdutimeVar.imuInfo_);
                    } else {
                        this.imuInfoBuilder_.dispose();
                        this.imuInfoBuilder_ = null;
                        this.imuInfo_ = imu_cdutimeVar.imuInfo_;
                        this.bitField0_ &= -2;
                        this.imuInfoBuilder_ = imu_cdutime.alwaysUseFieldBuilders ? getImuInfoFieldBuilder() : null;
                    }
                }
                if (!imu_cdutimeVar.cduTime_.isEmpty()) {
                    if (this.cduTime_.isEmpty()) {
                        this.cduTime_ = imu_cdutimeVar.cduTime_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureCduTimeIsMutable();
                        this.cduTime_.addAll(imu_cdutimeVar.cduTime_);
                    }
                    onChanged();
                }
                mergeUnknownFields(imu_cdutimeVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.imu_cdutime.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.imu_cdutime.access$8200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$imu_cdutime r3 = (xpilot.sr.proto.Overall.imu_cdutime) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$imu_cdutime r4 = (xpilot.sr.proto.Overall.imu_cdutime) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.imu_cdutime.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$imu_cdutime$Builder");
            }

            private void ensureImuInfoIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.imuInfo_ = new ArrayList(this.imuInfo_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
            public List<Imudata.ImuInfo> getImuInfoList() {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.imuInfo_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
            public int getImuInfoCount() {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.imuInfo_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
            public Imudata.ImuInfo getImuInfo(int i) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.imuInfo_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setImuInfo(int i, Imudata.ImuInfo imuInfo) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, imuInfo);
                } else if (imuInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureImuInfoIsMutable();
                    this.imuInfo_.set(i, imuInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setImuInfo(int i, Imudata.ImuInfo.Builder builder) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImuInfoIsMutable();
                    this.imuInfo_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addImuInfo(Imudata.ImuInfo imuInfo) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(imuInfo);
                } else if (imuInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureImuInfoIsMutable();
                    this.imuInfo_.add(imuInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addImuInfo(int i, Imudata.ImuInfo imuInfo) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, imuInfo);
                } else if (imuInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureImuInfoIsMutable();
                    this.imuInfo_.add(i, imuInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addImuInfo(Imudata.ImuInfo.Builder builder) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImuInfoIsMutable();
                    this.imuInfo_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addImuInfo(int i, Imudata.ImuInfo.Builder builder) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImuInfoIsMutable();
                    this.imuInfo_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllImuInfo(Iterable<? extends Imudata.ImuInfo> iterable) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImuInfoIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.imuInfo_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearImuInfo() {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.imuInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeImuInfo(int i) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImuInfoIsMutable();
                    this.imuInfo_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Imudata.ImuInfo.Builder getImuInfoBuilder(int i) {
                return getImuInfoFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
            public Imudata.ImuInfoOrBuilder getImuInfoOrBuilder(int i) {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.imuInfo_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
            public List<? extends Imudata.ImuInfoOrBuilder> getImuInfoOrBuilderList() {
                RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> repeatedFieldBuilderV3 = this.imuInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.imuInfo_);
            }

            public Imudata.ImuInfo.Builder addImuInfoBuilder() {
                return getImuInfoFieldBuilder().addBuilder(Imudata.ImuInfo.getDefaultInstance());
            }

            public Imudata.ImuInfo.Builder addImuInfoBuilder(int i) {
                return getImuInfoFieldBuilder().addBuilder(i, Imudata.ImuInfo.getDefaultInstance());
            }

            public List<Imudata.ImuInfo.Builder> getImuInfoBuilderList() {
                return getImuInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> getImuInfoFieldBuilder() {
                if (this.imuInfoBuilder_ == null) {
                    this.imuInfoBuilder_ = new RepeatedFieldBuilderV3<>(this.imuInfo_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.imuInfo_ = null;
                }
                return this.imuInfoBuilder_;
            }

            private void ensureCduTimeIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.cduTime_ = new ArrayList(this.cduTime_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
            public List<Long> getCduTimeList() {
                return Collections.unmodifiableList(this.cduTime_);
            }

            @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
            public int getCduTimeCount() {
                return this.cduTime_.size();
            }

            @Override // xpilot.sr.proto.Overall.imu_cdutimeOrBuilder
            public long getCduTime(int i) {
                return this.cduTime_.get(i).longValue();
            }

            public Builder setCduTime(int i, long j) {
                ensureCduTimeIsMutable();
                this.cduTime_.set(i, Long.valueOf(j));
                onChanged();
                return this;
            }

            public Builder addCduTime(long j) {
                ensureCduTimeIsMutable();
                this.cduTime_.add(Long.valueOf(j));
                onChanged();
                return this;
            }

            public Builder addAllCduTime(Iterable<? extends Long> iterable) {
                ensureCduTimeIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.cduTime_);
                onChanged();
                return this;
            }

            public Builder clearCduTime() {
                this.cduTime_ = Collections.emptyList();
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

        public static imu_cdutime getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<imu_cdutime> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<imu_cdutime> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public imu_cdutime getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class gnss_cdutime extends GeneratedMessageV3 implements gnss_cdutimeOrBuilder {
        public static final int CDU_TIME_FIELD_NUMBER = 2;
        public static final int NMEADATAINFO_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int cduTimeMemoizedSerializedSize;
        private List<Long> cduTime_;
        private byte memoizedIsInitialized;
        private List<Nmeadata.NmeadataInfo> nmeadataInfo_;
        private static final gnss_cdutime DEFAULT_INSTANCE = new gnss_cdutime();
        private static final Parser<gnss_cdutime> PARSER = new AbstractParser<gnss_cdutime>() { // from class: xpilot.sr.proto.Overall.gnss_cdutime.1
            @Override // com.google.protobuf.Parser
            public gnss_cdutime parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new gnss_cdutime(codedInputStream, extensionRegistryLite);
            }
        };

        private gnss_cdutime(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.cduTimeMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private gnss_cdutime() {
            this.cduTimeMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.nmeadataInfo_ = Collections.emptyList();
            this.cduTime_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private gnss_cdutime(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.nmeadataInfo_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.nmeadataInfo_.add(codedInputStream.readMessage(Nmeadata.NmeadataInfo.parser(), extensionRegistryLite));
                            } else if (readTag == 16) {
                                if (!(z2 & true)) {
                                    this.cduTime_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.cduTime_.add(Long.valueOf(codedInputStream.readUInt64()));
                            } else if (readTag == 18) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.cduTime_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.cduTime_.add(Long.valueOf(codedInputStream.readUInt64()));
                                }
                                codedInputStream.popLimit(pushLimit);
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
                        this.nmeadataInfo_ = Collections.unmodifiableList(this.nmeadataInfo_);
                    }
                    if (z2 & true) {
                        this.cduTime_ = Collections.unmodifiableList(this.cduTime_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Overall.internal_static_xpilot_sr_proto_gnss_cdutime_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_gnss_cdutime_fieldAccessorTable.ensureFieldAccessorsInitialized(gnss_cdutime.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
        public List<Nmeadata.NmeadataInfo> getNmeadataInfoList() {
            return this.nmeadataInfo_;
        }

        @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
        public List<? extends Nmeadata.NmeadataInfoOrBuilder> getNmeadataInfoOrBuilderList() {
            return this.nmeadataInfo_;
        }

        @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
        public int getNmeadataInfoCount() {
            return this.nmeadataInfo_.size();
        }

        @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
        public Nmeadata.NmeadataInfo getNmeadataInfo(int i) {
            return this.nmeadataInfo_.get(i);
        }

        @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
        public Nmeadata.NmeadataInfoOrBuilder getNmeadataInfoOrBuilder(int i) {
            return this.nmeadataInfo_.get(i);
        }

        @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
        public List<Long> getCduTimeList() {
            return this.cduTime_;
        }

        @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
        public int getCduTimeCount() {
            return this.cduTime_.size();
        }

        @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
        public long getCduTime(int i) {
            return this.cduTime_.get(i).longValue();
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
            for (int i = 0; i < this.nmeadataInfo_.size(); i++) {
                codedOutputStream.writeMessage(1, this.nmeadataInfo_.get(i));
            }
            if (getCduTimeList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(18);
                codedOutputStream.writeUInt32NoTag(this.cduTimeMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.cduTime_.size(); i2++) {
                codedOutputStream.writeUInt64NoTag(this.cduTime_.get(i2).longValue());
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
            for (int i3 = 0; i3 < this.nmeadataInfo_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.nmeadataInfo_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.cduTime_.size(); i5++) {
                i4 += CodedOutputStream.computeUInt64SizeNoTag(this.cduTime_.get(i5).longValue());
            }
            int i6 = i2 + i4;
            if (!getCduTimeList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.cduTimeMemoizedSerializedSize = i4;
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof gnss_cdutime)) {
                return super.equals(obj);
            }
            gnss_cdutime gnss_cdutimeVar = (gnss_cdutime) obj;
            return ((getNmeadataInfoList().equals(gnss_cdutimeVar.getNmeadataInfoList())) && getCduTimeList().equals(gnss_cdutimeVar.getCduTimeList())) && this.unknownFields.equals(gnss_cdutimeVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getNmeadataInfoCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getNmeadataInfoList().hashCode();
            }
            if (getCduTimeCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getCduTimeList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static gnss_cdutime parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static gnss_cdutime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static gnss_cdutime parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static gnss_cdutime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static gnss_cdutime parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static gnss_cdutime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static gnss_cdutime parseFrom(InputStream inputStream) throws IOException {
            return (gnss_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static gnss_cdutime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (gnss_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static gnss_cdutime parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (gnss_cdutime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static gnss_cdutime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (gnss_cdutime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static gnss_cdutime parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (gnss_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static gnss_cdutime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (gnss_cdutime) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(gnss_cdutime gnss_cdutimeVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(gnss_cdutimeVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements gnss_cdutimeOrBuilder {
            private int bitField0_;
            private List<Long> cduTime_;
            private RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> nmeadataInfoBuilder_;
            private List<Nmeadata.NmeadataInfo> nmeadataInfo_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_gnss_cdutime_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_gnss_cdutime_fieldAccessorTable.ensureFieldAccessorsInitialized(gnss_cdutime.class, Builder.class);
            }

            private Builder() {
                this.nmeadataInfo_ = Collections.emptyList();
                this.cduTime_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.nmeadataInfo_ = Collections.emptyList();
                this.cduTime_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (gnss_cdutime.alwaysUseFieldBuilders) {
                    getNmeadataInfoFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.nmeadataInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.cduTime_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_gnss_cdutime_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public gnss_cdutime getDefaultInstanceForType() {
                return gnss_cdutime.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public gnss_cdutime build() {
                gnss_cdutime buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public gnss_cdutime buildPartial() {
                gnss_cdutime gnss_cdutimeVar = new gnss_cdutime(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.nmeadataInfo_ = Collections.unmodifiableList(this.nmeadataInfo_);
                        this.bitField0_ &= -2;
                    }
                    gnss_cdutimeVar.nmeadataInfo_ = this.nmeadataInfo_;
                } else {
                    gnss_cdutimeVar.nmeadataInfo_ = repeatedFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 2) == 2) {
                    this.cduTime_ = Collections.unmodifiableList(this.cduTime_);
                    this.bitField0_ &= -3;
                }
                gnss_cdutimeVar.cduTime_ = this.cduTime_;
                onBuilt();
                return gnss_cdutimeVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof gnss_cdutime) {
                    return mergeFrom((gnss_cdutime) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(gnss_cdutime gnss_cdutimeVar) {
                if (gnss_cdutimeVar == gnss_cdutime.getDefaultInstance()) {
                    return this;
                }
                if (this.nmeadataInfoBuilder_ == null) {
                    if (!gnss_cdutimeVar.nmeadataInfo_.isEmpty()) {
                        if (this.nmeadataInfo_.isEmpty()) {
                            this.nmeadataInfo_ = gnss_cdutimeVar.nmeadataInfo_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureNmeadataInfoIsMutable();
                            this.nmeadataInfo_.addAll(gnss_cdutimeVar.nmeadataInfo_);
                        }
                        onChanged();
                    }
                } else if (!gnss_cdutimeVar.nmeadataInfo_.isEmpty()) {
                    if (!this.nmeadataInfoBuilder_.isEmpty()) {
                        this.nmeadataInfoBuilder_.addAllMessages(gnss_cdutimeVar.nmeadataInfo_);
                    } else {
                        this.nmeadataInfoBuilder_.dispose();
                        this.nmeadataInfoBuilder_ = null;
                        this.nmeadataInfo_ = gnss_cdutimeVar.nmeadataInfo_;
                        this.bitField0_ &= -2;
                        this.nmeadataInfoBuilder_ = gnss_cdutime.alwaysUseFieldBuilders ? getNmeadataInfoFieldBuilder() : null;
                    }
                }
                if (!gnss_cdutimeVar.cduTime_.isEmpty()) {
                    if (this.cduTime_.isEmpty()) {
                        this.cduTime_ = gnss_cdutimeVar.cduTime_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureCduTimeIsMutable();
                        this.cduTime_.addAll(gnss_cdutimeVar.cduTime_);
                    }
                    onChanged();
                }
                mergeUnknownFields(gnss_cdutimeVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.gnss_cdutime.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.gnss_cdutime.access$9400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$gnss_cdutime r3 = (xpilot.sr.proto.Overall.gnss_cdutime) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$gnss_cdutime r4 = (xpilot.sr.proto.Overall.gnss_cdutime) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.gnss_cdutime.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$gnss_cdutime$Builder");
            }

            private void ensureNmeadataInfoIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.nmeadataInfo_ = new ArrayList(this.nmeadataInfo_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
            public List<Nmeadata.NmeadataInfo> getNmeadataInfoList() {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.nmeadataInfo_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
            public int getNmeadataInfoCount() {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.nmeadataInfo_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
            public Nmeadata.NmeadataInfo getNmeadataInfo(int i) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.nmeadataInfo_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setNmeadataInfo(int i, Nmeadata.NmeadataInfo nmeadataInfo) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, nmeadataInfo);
                } else if (nmeadataInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.set(i, nmeadataInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setNmeadataInfo(int i, Nmeadata.NmeadataInfo.Builder builder) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addNmeadataInfo(Nmeadata.NmeadataInfo nmeadataInfo) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(nmeadataInfo);
                } else if (nmeadataInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.add(nmeadataInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addNmeadataInfo(int i, Nmeadata.NmeadataInfo nmeadataInfo) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, nmeadataInfo);
                } else if (nmeadataInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.add(i, nmeadataInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addNmeadataInfo(Nmeadata.NmeadataInfo.Builder builder) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addNmeadataInfo(int i, Nmeadata.NmeadataInfo.Builder builder) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllNmeadataInfo(Iterable<? extends Nmeadata.NmeadataInfo> iterable) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.nmeadataInfo_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearNmeadataInfo() {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.nmeadataInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeNmeadataInfo(int i) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureNmeadataInfoIsMutable();
                    this.nmeadataInfo_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public Nmeadata.NmeadataInfo.Builder getNmeadataInfoBuilder(int i) {
                return getNmeadataInfoFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
            public Nmeadata.NmeadataInfoOrBuilder getNmeadataInfoOrBuilder(int i) {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.nmeadataInfo_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
            public List<? extends Nmeadata.NmeadataInfoOrBuilder> getNmeadataInfoOrBuilderList() {
                RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> repeatedFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.nmeadataInfo_);
            }

            public Nmeadata.NmeadataInfo.Builder addNmeadataInfoBuilder() {
                return getNmeadataInfoFieldBuilder().addBuilder(Nmeadata.NmeadataInfo.getDefaultInstance());
            }

            public Nmeadata.NmeadataInfo.Builder addNmeadataInfoBuilder(int i) {
                return getNmeadataInfoFieldBuilder().addBuilder(i, Nmeadata.NmeadataInfo.getDefaultInstance());
            }

            public List<Nmeadata.NmeadataInfo.Builder> getNmeadataInfoBuilderList() {
                return getNmeadataInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> getNmeadataInfoFieldBuilder() {
                if (this.nmeadataInfoBuilder_ == null) {
                    this.nmeadataInfoBuilder_ = new RepeatedFieldBuilderV3<>(this.nmeadataInfo_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.nmeadataInfo_ = null;
                }
                return this.nmeadataInfoBuilder_;
            }

            private void ensureCduTimeIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.cduTime_ = new ArrayList(this.cduTime_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
            public List<Long> getCduTimeList() {
                return Collections.unmodifiableList(this.cduTime_);
            }

            @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
            public int getCduTimeCount() {
                return this.cduTime_.size();
            }

            @Override // xpilot.sr.proto.Overall.gnss_cdutimeOrBuilder
            public long getCduTime(int i) {
                return this.cduTime_.get(i).longValue();
            }

            public Builder setCduTime(int i, long j) {
                ensureCduTimeIsMutable();
                this.cduTime_.set(i, Long.valueOf(j));
                onChanged();
                return this;
            }

            public Builder addCduTime(long j) {
                ensureCduTimeIsMutable();
                this.cduTime_.add(Long.valueOf(j));
                onChanged();
                return this;
            }

            public Builder addAllCduTime(Iterable<? extends Long> iterable) {
                ensureCduTimeIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.cduTime_);
                onChanged();
                return this;
            }

            public Builder clearCduTime() {
                this.cduTime_ = Collections.emptyList();
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

        public static gnss_cdutime getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<gnss_cdutime> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<gnss_cdutime> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public gnss_cdutime getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class save_sr_overall extends GeneratedMessageV3 implements save_sr_overallOrBuilder {
        public static final int GNSS_DATA_FIELD_NUMBER = 3;
        public static final int IMU_DATA_FIELD_NUMBER = 2;
        public static final int OVERALL_DATA_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private gnss_cdutime gnssData_;
        private imu_cdutime imuData_;
        private byte memoizedIsInitialized;
        private overall_cdutime overallData_;
        private static final save_sr_overall DEFAULT_INSTANCE = new save_sr_overall();
        private static final Parser<save_sr_overall> PARSER = new AbstractParser<save_sr_overall>() { // from class: xpilot.sr.proto.Overall.save_sr_overall.1
            @Override // com.google.protobuf.Parser
            public save_sr_overall parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new save_sr_overall(codedInputStream, extensionRegistryLite);
            }
        };

        private save_sr_overall(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private save_sr_overall() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private save_sr_overall(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                overall_cdutime.Builder builder = this.overallData_ != null ? this.overallData_.toBuilder() : null;
                                this.overallData_ = (overall_cdutime) codedInputStream.readMessage(overall_cdutime.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.overallData_);
                                    this.overallData_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                imu_cdutime.Builder builder2 = this.imuData_ != null ? this.imuData_.toBuilder() : null;
                                this.imuData_ = (imu_cdutime) codedInputStream.readMessage(imu_cdutime.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.imuData_);
                                    this.imuData_ = builder2.buildPartial();
                                }
                            } else if (readTag == 26) {
                                gnss_cdutime.Builder builder3 = this.gnssData_ != null ? this.gnssData_.toBuilder() : null;
                                this.gnssData_ = (gnss_cdutime) codedInputStream.readMessage(gnss_cdutime.parser(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.gnssData_);
                                    this.gnssData_ = builder3.buildPartial();
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
            return Overall.internal_static_xpilot_sr_proto_save_sr_overall_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_save_sr_overall_fieldAccessorTable.ensureFieldAccessorsInitialized(save_sr_overall.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
        public boolean hasOverallData() {
            return this.overallData_ != null;
        }

        @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
        public overall_cdutime getOverallData() {
            overall_cdutime overall_cdutimeVar = this.overallData_;
            return overall_cdutimeVar == null ? overall_cdutime.getDefaultInstance() : overall_cdutimeVar;
        }

        @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
        public overall_cdutimeOrBuilder getOverallDataOrBuilder() {
            return getOverallData();
        }

        @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
        public boolean hasImuData() {
            return this.imuData_ != null;
        }

        @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
        public imu_cdutime getImuData() {
            imu_cdutime imu_cdutimeVar = this.imuData_;
            return imu_cdutimeVar == null ? imu_cdutime.getDefaultInstance() : imu_cdutimeVar;
        }

        @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
        public imu_cdutimeOrBuilder getImuDataOrBuilder() {
            return getImuData();
        }

        @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
        public boolean hasGnssData() {
            return this.gnssData_ != null;
        }

        @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
        public gnss_cdutime getGnssData() {
            gnss_cdutime gnss_cdutimeVar = this.gnssData_;
            return gnss_cdutimeVar == null ? gnss_cdutime.getDefaultInstance() : gnss_cdutimeVar;
        }

        @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
        public gnss_cdutimeOrBuilder getGnssDataOrBuilder() {
            return getGnssData();
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
            if (this.overallData_ != null) {
                codedOutputStream.writeMessage(1, getOverallData());
            }
            if (this.imuData_ != null) {
                codedOutputStream.writeMessage(2, getImuData());
            }
            if (this.gnssData_ != null) {
                codedOutputStream.writeMessage(3, getGnssData());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.overallData_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getOverallData()) : 0;
            if (this.imuData_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getImuData());
            }
            if (this.gnssData_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, getGnssData());
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
            if (!(obj instanceof save_sr_overall)) {
                return super.equals(obj);
            }
            save_sr_overall save_sr_overallVar = (save_sr_overall) obj;
            boolean z = hasOverallData() == save_sr_overallVar.hasOverallData();
            if (hasOverallData()) {
                z = z && getOverallData().equals(save_sr_overallVar.getOverallData());
            }
            boolean z2 = z && hasImuData() == save_sr_overallVar.hasImuData();
            if (hasImuData()) {
                z2 = z2 && getImuData().equals(save_sr_overallVar.getImuData());
            }
            boolean z3 = z2 && hasGnssData() == save_sr_overallVar.hasGnssData();
            if (hasGnssData()) {
                z3 = z3 && getGnssData().equals(save_sr_overallVar.getGnssData());
            }
            return z3 && this.unknownFields.equals(save_sr_overallVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasOverallData()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getOverallData().hashCode();
            }
            if (hasImuData()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getImuData().hashCode();
            }
            if (hasGnssData()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getGnssData().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static save_sr_overall parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static save_sr_overall parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static save_sr_overall parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static save_sr_overall parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static save_sr_overall parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static save_sr_overall parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static save_sr_overall parseFrom(InputStream inputStream) throws IOException {
            return (save_sr_overall) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static save_sr_overall parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (save_sr_overall) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static save_sr_overall parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (save_sr_overall) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static save_sr_overall parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (save_sr_overall) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static save_sr_overall parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (save_sr_overall) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static save_sr_overall parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (save_sr_overall) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(save_sr_overall save_sr_overallVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(save_sr_overallVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements save_sr_overallOrBuilder {
            private SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> gnssDataBuilder_;
            private gnss_cdutime gnssData_;
            private SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> imuDataBuilder_;
            private imu_cdutime imuData_;
            private SingleFieldBuilderV3<overall_cdutime, overall_cdutime.Builder, overall_cdutimeOrBuilder> overallDataBuilder_;
            private overall_cdutime overallData_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_save_sr_overall_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_save_sr_overall_fieldAccessorTable.ensureFieldAccessorsInitialized(save_sr_overall.class, Builder.class);
            }

            private Builder() {
                this.overallData_ = null;
                this.imuData_ = null;
                this.gnssData_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.overallData_ = null;
                this.imuData_ = null;
                this.gnssData_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = save_sr_overall.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.overallDataBuilder_ == null) {
                    this.overallData_ = null;
                } else {
                    this.overallData_ = null;
                    this.overallDataBuilder_ = null;
                }
                if (this.imuDataBuilder_ == null) {
                    this.imuData_ = null;
                } else {
                    this.imuData_ = null;
                    this.imuDataBuilder_ = null;
                }
                if (this.gnssDataBuilder_ == null) {
                    this.gnssData_ = null;
                } else {
                    this.gnssData_ = null;
                    this.gnssDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_save_sr_overall_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public save_sr_overall getDefaultInstanceForType() {
                return save_sr_overall.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public save_sr_overall build() {
                save_sr_overall buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public save_sr_overall buildPartial() {
                save_sr_overall save_sr_overallVar = new save_sr_overall(this);
                SingleFieldBuilderV3<overall_cdutime, overall_cdutime.Builder, overall_cdutimeOrBuilder> singleFieldBuilderV3 = this.overallDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    save_sr_overallVar.overallData_ = this.overallData_;
                } else {
                    save_sr_overallVar.overallData_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV32 = this.imuDataBuilder_;
                if (singleFieldBuilderV32 == null) {
                    save_sr_overallVar.imuData_ = this.imuData_;
                } else {
                    save_sr_overallVar.imuData_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV33 = this.gnssDataBuilder_;
                if (singleFieldBuilderV33 == null) {
                    save_sr_overallVar.gnssData_ = this.gnssData_;
                } else {
                    save_sr_overallVar.gnssData_ = singleFieldBuilderV33.build();
                }
                onBuilt();
                return save_sr_overallVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof save_sr_overall) {
                    return mergeFrom((save_sr_overall) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(save_sr_overall save_sr_overallVar) {
                if (save_sr_overallVar == save_sr_overall.getDefaultInstance()) {
                    return this;
                }
                if (save_sr_overallVar.hasOverallData()) {
                    mergeOverallData(save_sr_overallVar.getOverallData());
                }
                if (save_sr_overallVar.hasImuData()) {
                    mergeImuData(save_sr_overallVar.getImuData());
                }
                if (save_sr_overallVar.hasGnssData()) {
                    mergeGnssData(save_sr_overallVar.getGnssData());
                }
                mergeUnknownFields(save_sr_overallVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.save_sr_overall.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.save_sr_overall.access$10600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$save_sr_overall r3 = (xpilot.sr.proto.Overall.save_sr_overall) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$save_sr_overall r4 = (xpilot.sr.proto.Overall.save_sr_overall) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.save_sr_overall.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$save_sr_overall$Builder");
            }

            @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
            public boolean hasOverallData() {
                return (this.overallDataBuilder_ == null && this.overallData_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
            public overall_cdutime getOverallData() {
                SingleFieldBuilderV3<overall_cdutime, overall_cdutime.Builder, overall_cdutimeOrBuilder> singleFieldBuilderV3 = this.overallDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall_cdutime overall_cdutimeVar = this.overallData_;
                    return overall_cdutimeVar == null ? overall_cdutime.getDefaultInstance() : overall_cdutimeVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setOverallData(overall_cdutime overall_cdutimeVar) {
                SingleFieldBuilderV3<overall_cdutime, overall_cdutime.Builder, overall_cdutimeOrBuilder> singleFieldBuilderV3 = this.overallDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(overall_cdutimeVar);
                } else if (overall_cdutimeVar == null) {
                    throw new NullPointerException();
                } else {
                    this.overallData_ = overall_cdutimeVar;
                    onChanged();
                }
                return this;
            }

            public Builder setOverallData(overall_cdutime.Builder builder) {
                SingleFieldBuilderV3<overall_cdutime, overall_cdutime.Builder, overall_cdutimeOrBuilder> singleFieldBuilderV3 = this.overallDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.overallData_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeOverallData(overall_cdutime overall_cdutimeVar) {
                SingleFieldBuilderV3<overall_cdutime, overall_cdutime.Builder, overall_cdutimeOrBuilder> singleFieldBuilderV3 = this.overallDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall_cdutime overall_cdutimeVar2 = this.overallData_;
                    if (overall_cdutimeVar2 != null) {
                        this.overallData_ = overall_cdutime.newBuilder(overall_cdutimeVar2).mergeFrom(overall_cdutimeVar).buildPartial();
                    } else {
                        this.overallData_ = overall_cdutimeVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(overall_cdutimeVar);
                }
                return this;
            }

            public Builder clearOverallData() {
                if (this.overallDataBuilder_ == null) {
                    this.overallData_ = null;
                    onChanged();
                } else {
                    this.overallData_ = null;
                    this.overallDataBuilder_ = null;
                }
                return this;
            }

            public overall_cdutime.Builder getOverallDataBuilder() {
                onChanged();
                return getOverallDataFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
            public overall_cdutimeOrBuilder getOverallDataOrBuilder() {
                SingleFieldBuilderV3<overall_cdutime, overall_cdutime.Builder, overall_cdutimeOrBuilder> singleFieldBuilderV3 = this.overallDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                overall_cdutime overall_cdutimeVar = this.overallData_;
                return overall_cdutimeVar == null ? overall_cdutime.getDefaultInstance() : overall_cdutimeVar;
            }

            private SingleFieldBuilderV3<overall_cdutime, overall_cdutime.Builder, overall_cdutimeOrBuilder> getOverallDataFieldBuilder() {
                if (this.overallDataBuilder_ == null) {
                    this.overallDataBuilder_ = new SingleFieldBuilderV3<>(getOverallData(), getParentForChildren(), isClean());
                    this.overallData_ = null;
                }
                return this.overallDataBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
            public boolean hasImuData() {
                return (this.imuDataBuilder_ == null && this.imuData_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
            public imu_cdutime getImuData() {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    imu_cdutime imu_cdutimeVar = this.imuData_;
                    return imu_cdutimeVar == null ? imu_cdutime.getDefaultInstance() : imu_cdutimeVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setImuData(imu_cdutime imu_cdutimeVar) {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(imu_cdutimeVar);
                } else if (imu_cdutimeVar == null) {
                    throw new NullPointerException();
                } else {
                    this.imuData_ = imu_cdutimeVar;
                    onChanged();
                }
                return this;
            }

            public Builder setImuData(imu_cdutime.Builder builder) {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.imuData_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeImuData(imu_cdutime imu_cdutimeVar) {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    imu_cdutime imu_cdutimeVar2 = this.imuData_;
                    if (imu_cdutimeVar2 != null) {
                        this.imuData_ = imu_cdutime.newBuilder(imu_cdutimeVar2).mergeFrom(imu_cdutimeVar).buildPartial();
                    } else {
                        this.imuData_ = imu_cdutimeVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(imu_cdutimeVar);
                }
                return this;
            }

            public Builder clearImuData() {
                if (this.imuDataBuilder_ == null) {
                    this.imuData_ = null;
                    onChanged();
                } else {
                    this.imuData_ = null;
                    this.imuDataBuilder_ = null;
                }
                return this;
            }

            public imu_cdutime.Builder getImuDataBuilder() {
                onChanged();
                return getImuDataFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
            public imu_cdutimeOrBuilder getImuDataOrBuilder() {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                imu_cdutime imu_cdutimeVar = this.imuData_;
                return imu_cdutimeVar == null ? imu_cdutime.getDefaultInstance() : imu_cdutimeVar;
            }

            private SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> getImuDataFieldBuilder() {
                if (this.imuDataBuilder_ == null) {
                    this.imuDataBuilder_ = new SingleFieldBuilderV3<>(getImuData(), getParentForChildren(), isClean());
                    this.imuData_ = null;
                }
                return this.imuDataBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
            public boolean hasGnssData() {
                return (this.gnssDataBuilder_ == null && this.gnssData_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
            public gnss_cdutime getGnssData() {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.gnssDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    gnss_cdutime gnss_cdutimeVar = this.gnssData_;
                    return gnss_cdutimeVar == null ? gnss_cdutime.getDefaultInstance() : gnss_cdutimeVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setGnssData(gnss_cdutime gnss_cdutimeVar) {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.gnssDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(gnss_cdutimeVar);
                } else if (gnss_cdutimeVar == null) {
                    throw new NullPointerException();
                } else {
                    this.gnssData_ = gnss_cdutimeVar;
                    onChanged();
                }
                return this;
            }

            public Builder setGnssData(gnss_cdutime.Builder builder) {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.gnssDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.gnssData_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeGnssData(gnss_cdutime gnss_cdutimeVar) {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.gnssDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    gnss_cdutime gnss_cdutimeVar2 = this.gnssData_;
                    if (gnss_cdutimeVar2 != null) {
                        this.gnssData_ = gnss_cdutime.newBuilder(gnss_cdutimeVar2).mergeFrom(gnss_cdutimeVar).buildPartial();
                    } else {
                        this.gnssData_ = gnss_cdutimeVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(gnss_cdutimeVar);
                }
                return this;
            }

            public Builder clearGnssData() {
                if (this.gnssDataBuilder_ == null) {
                    this.gnssData_ = null;
                    onChanged();
                } else {
                    this.gnssData_ = null;
                    this.gnssDataBuilder_ = null;
                }
                return this;
            }

            public gnss_cdutime.Builder getGnssDataBuilder() {
                onChanged();
                return getGnssDataFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.save_sr_overallOrBuilder
            public gnss_cdutimeOrBuilder getGnssDataOrBuilder() {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.gnssDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                gnss_cdutime gnss_cdutimeVar = this.gnssData_;
                return gnss_cdutimeVar == null ? gnss_cdutime.getDefaultInstance() : gnss_cdutimeVar;
            }

            private SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> getGnssDataFieldBuilder() {
                if (this.gnssDataBuilder_ == null) {
                    this.gnssDataBuilder_ = new SingleFieldBuilderV3<>(getGnssData(), getParentForChildren(), isClean());
                    this.gnssData_ = null;
                }
                return this.gnssDataBuilder_;
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

        public static save_sr_overall getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<save_sr_overall> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<save_sr_overall> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public save_sr_overall getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class total_xpu_overall extends GeneratedMessageV3 implements total_xpu_overallOrBuilder {
        private static final total_xpu_overall DEFAULT_INSTANCE = new total_xpu_overall();
        private static final Parser<total_xpu_overall> PARSER = new AbstractParser<total_xpu_overall>() { // from class: xpilot.sr.proto.Overall.total_xpu_overall.1
            @Override // com.google.protobuf.Parser
            public total_xpu_overall parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new total_xpu_overall(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int XPU_OVERALL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<xpu_data_to_app> xpuOverall_;

        private total_xpu_overall(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private total_xpu_overall() {
            this.memoizedIsInitialized = (byte) -1;
            this.xpuOverall_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private total_xpu_overall(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                        this.xpuOverall_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.xpuOverall_.add(codedInputStream.readMessage(xpu_data_to_app.parser(), extensionRegistryLite));
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
                        this.xpuOverall_ = Collections.unmodifiableList(this.xpuOverall_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Overall.internal_static_xpilot_sr_proto_total_xpu_overall_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_total_xpu_overall_fieldAccessorTable.ensureFieldAccessorsInitialized(total_xpu_overall.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
        public List<xpu_data_to_app> getXpuOverallList() {
            return this.xpuOverall_;
        }

        @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
        public List<? extends xpu_data_to_appOrBuilder> getXpuOverallOrBuilderList() {
            return this.xpuOverall_;
        }

        @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
        public int getXpuOverallCount() {
            return this.xpuOverall_.size();
        }

        @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
        public xpu_data_to_app getXpuOverall(int i) {
            return this.xpuOverall_.get(i);
        }

        @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
        public xpu_data_to_appOrBuilder getXpuOverallOrBuilder(int i) {
            return this.xpuOverall_.get(i);
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
            for (int i = 0; i < this.xpuOverall_.size(); i++) {
                codedOutputStream.writeMessage(1, this.xpuOverall_.get(i));
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
            for (int i3 = 0; i3 < this.xpuOverall_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.xpuOverall_.get(i3));
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
            if (!(obj instanceof total_xpu_overall)) {
                return super.equals(obj);
            }
            total_xpu_overall total_xpu_overallVar = (total_xpu_overall) obj;
            return (getXpuOverallList().equals(total_xpu_overallVar.getXpuOverallList())) && this.unknownFields.equals(total_xpu_overallVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getXpuOverallCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getXpuOverallList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static total_xpu_overall parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static total_xpu_overall parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static total_xpu_overall parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static total_xpu_overall parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static total_xpu_overall parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static total_xpu_overall parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static total_xpu_overall parseFrom(InputStream inputStream) throws IOException {
            return (total_xpu_overall) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static total_xpu_overall parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (total_xpu_overall) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static total_xpu_overall parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (total_xpu_overall) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static total_xpu_overall parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (total_xpu_overall) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static total_xpu_overall parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (total_xpu_overall) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static total_xpu_overall parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (total_xpu_overall) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(total_xpu_overall total_xpu_overallVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(total_xpu_overallVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements total_xpu_overallOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> xpuOverallBuilder_;
            private List<xpu_data_to_app> xpuOverall_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_total_xpu_overall_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_total_xpu_overall_fieldAccessorTable.ensureFieldAccessorsInitialized(total_xpu_overall.class, Builder.class);
            }

            private Builder() {
                this.xpuOverall_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.xpuOverall_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (total_xpu_overall.alwaysUseFieldBuilders) {
                    getXpuOverallFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.xpuOverall_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_total_xpu_overall_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public total_xpu_overall getDefaultInstanceForType() {
                return total_xpu_overall.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public total_xpu_overall build() {
                total_xpu_overall buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public total_xpu_overall buildPartial() {
                total_xpu_overall total_xpu_overallVar = new total_xpu_overall(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.xpuOverall_ = Collections.unmodifiableList(this.xpuOverall_);
                        this.bitField0_ &= -2;
                    }
                    total_xpu_overallVar.xpuOverall_ = this.xpuOverall_;
                } else {
                    total_xpu_overallVar.xpuOverall_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return total_xpu_overallVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof total_xpu_overall) {
                    return mergeFrom((total_xpu_overall) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(total_xpu_overall total_xpu_overallVar) {
                if (total_xpu_overallVar == total_xpu_overall.getDefaultInstance()) {
                    return this;
                }
                if (this.xpuOverallBuilder_ == null) {
                    if (!total_xpu_overallVar.xpuOverall_.isEmpty()) {
                        if (this.xpuOverall_.isEmpty()) {
                            this.xpuOverall_ = total_xpu_overallVar.xpuOverall_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureXpuOverallIsMutable();
                            this.xpuOverall_.addAll(total_xpu_overallVar.xpuOverall_);
                        }
                        onChanged();
                    }
                } else if (!total_xpu_overallVar.xpuOverall_.isEmpty()) {
                    if (!this.xpuOverallBuilder_.isEmpty()) {
                        this.xpuOverallBuilder_.addAllMessages(total_xpu_overallVar.xpuOverall_);
                    } else {
                        this.xpuOverallBuilder_.dispose();
                        this.xpuOverallBuilder_ = null;
                        this.xpuOverall_ = total_xpu_overallVar.xpuOverall_;
                        this.bitField0_ &= -2;
                        this.xpuOverallBuilder_ = total_xpu_overall.alwaysUseFieldBuilders ? getXpuOverallFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(total_xpu_overallVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.total_xpu_overall.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.total_xpu_overall.access$11700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$total_xpu_overall r3 = (xpilot.sr.proto.Overall.total_xpu_overall) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$total_xpu_overall r4 = (xpilot.sr.proto.Overall.total_xpu_overall) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.total_xpu_overall.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$total_xpu_overall$Builder");
            }

            private void ensureXpuOverallIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.xpuOverall_ = new ArrayList(this.xpuOverall_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
            public List<xpu_data_to_app> getXpuOverallList() {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.xpuOverall_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
            public int getXpuOverallCount() {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.xpuOverall_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
            public xpu_data_to_app getXpuOverall(int i) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.xpuOverall_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setXpuOverall(int i, xpu_data_to_app xpu_data_to_appVar) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, xpu_data_to_appVar);
                } else if (xpu_data_to_appVar == null) {
                    throw new NullPointerException();
                } else {
                    ensureXpuOverallIsMutable();
                    this.xpuOverall_.set(i, xpu_data_to_appVar);
                    onChanged();
                }
                return this;
            }

            public Builder setXpuOverall(int i, xpu_data_to_app.Builder builder) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureXpuOverallIsMutable();
                    this.xpuOverall_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addXpuOverall(xpu_data_to_app xpu_data_to_appVar) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(xpu_data_to_appVar);
                } else if (xpu_data_to_appVar == null) {
                    throw new NullPointerException();
                } else {
                    ensureXpuOverallIsMutable();
                    this.xpuOverall_.add(xpu_data_to_appVar);
                    onChanged();
                }
                return this;
            }

            public Builder addXpuOverall(int i, xpu_data_to_app xpu_data_to_appVar) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, xpu_data_to_appVar);
                } else if (xpu_data_to_appVar == null) {
                    throw new NullPointerException();
                } else {
                    ensureXpuOverallIsMutable();
                    this.xpuOverall_.add(i, xpu_data_to_appVar);
                    onChanged();
                }
                return this;
            }

            public Builder addXpuOverall(xpu_data_to_app.Builder builder) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureXpuOverallIsMutable();
                    this.xpuOverall_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addXpuOverall(int i, xpu_data_to_app.Builder builder) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureXpuOverallIsMutable();
                    this.xpuOverall_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllXpuOverall(Iterable<? extends xpu_data_to_app> iterable) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureXpuOverallIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.xpuOverall_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearXpuOverall() {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.xpuOverall_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeXpuOverall(int i) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureXpuOverallIsMutable();
                    this.xpuOverall_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public xpu_data_to_app.Builder getXpuOverallBuilder(int i) {
                return getXpuOverallFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
            public xpu_data_to_appOrBuilder getXpuOverallOrBuilder(int i) {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.xpuOverall_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.Overall.total_xpu_overallOrBuilder
            public List<? extends xpu_data_to_appOrBuilder> getXpuOverallOrBuilderList() {
                RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> repeatedFieldBuilderV3 = this.xpuOverallBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.xpuOverall_);
            }

            public xpu_data_to_app.Builder addXpuOverallBuilder() {
                return getXpuOverallFieldBuilder().addBuilder(xpu_data_to_app.getDefaultInstance());
            }

            public xpu_data_to_app.Builder addXpuOverallBuilder(int i) {
                return getXpuOverallFieldBuilder().addBuilder(i, xpu_data_to_app.getDefaultInstance());
            }

            public List<xpu_data_to_app.Builder> getXpuOverallBuilderList() {
                return getXpuOverallFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<xpu_data_to_app, xpu_data_to_app.Builder, xpu_data_to_appOrBuilder> getXpuOverallFieldBuilder() {
                if (this.xpuOverallBuilder_ == null) {
                    this.xpuOverallBuilder_ = new RepeatedFieldBuilderV3<>(this.xpuOverall_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.xpuOverall_ = null;
                }
                return this.xpuOverallBuilder_;
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

        public static total_xpu_overall getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<total_xpu_overall> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<total_xpu_overall> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public total_xpu_overall getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class xpu_data_to_app extends GeneratedMessageV3 implements xpu_data_to_appOrBuilder {
        public static final int AUTOPILOTDATA_FIELD_NUMBER = 5;
        public static final int CDU_TIME_FIELD_NUMBER = 1;
        public static final int IMUINFO_FIELD_NUMBER = 2;
        public static final int NMEADATAINFO_FIELD_NUMBER = 3;
        public static final int OVERALL_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private AutoPilotDataOuterClass.AutoPilotData autoPilotData_;
        private long cduTime_;
        private Imudata.ImuInfo imuInfo_;
        private byte memoizedIsInitialized;
        private Nmeadata.NmeadataInfo nmeadataInfo_;
        private overall overall_;
        private static final xpu_data_to_app DEFAULT_INSTANCE = new xpu_data_to_app();
        private static final Parser<xpu_data_to_app> PARSER = new AbstractParser<xpu_data_to_app>() { // from class: xpilot.sr.proto.Overall.xpu_data_to_app.1
            @Override // com.google.protobuf.Parser
            public xpu_data_to_app parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new xpu_data_to_app(codedInputStream, extensionRegistryLite);
            }
        };

        private xpu_data_to_app(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private xpu_data_to_app() {
            this.memoizedIsInitialized = (byte) -1;
            this.cduTime_ = 0L;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private xpu_data_to_app(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag != 8) {
                                if (readTag == 18) {
                                    Imudata.ImuInfo.Builder builder = this.imuInfo_ != null ? this.imuInfo_.toBuilder() : null;
                                    this.imuInfo_ = (Imudata.ImuInfo) codedInputStream.readMessage(Imudata.ImuInfo.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.imuInfo_);
                                        this.imuInfo_ = builder.buildPartial();
                                    }
                                } else if (readTag == 26) {
                                    Nmeadata.NmeadataInfo.Builder builder2 = this.nmeadataInfo_ != null ? this.nmeadataInfo_.toBuilder() : null;
                                    this.nmeadataInfo_ = (Nmeadata.NmeadataInfo) codedInputStream.readMessage(Nmeadata.NmeadataInfo.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom(this.nmeadataInfo_);
                                        this.nmeadataInfo_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 34) {
                                    overall.Builder builder3 = this.overall_ != null ? this.overall_.toBuilder() : null;
                                    this.overall_ = (overall) codedInputStream.readMessage(overall.parser(), extensionRegistryLite);
                                    if (builder3 != null) {
                                        builder3.mergeFrom(this.overall_);
                                        this.overall_ = builder3.buildPartial();
                                    }
                                } else if (readTag == 42) {
                                    AutoPilotDataOuterClass.AutoPilotData.Builder builder4 = this.autoPilotData_ != null ? this.autoPilotData_.toBuilder() : null;
                                    this.autoPilotData_ = (AutoPilotDataOuterClass.AutoPilotData) codedInputStream.readMessage(AutoPilotDataOuterClass.AutoPilotData.parser(), extensionRegistryLite);
                                    if (builder4 != null) {
                                        builder4.mergeFrom(this.autoPilotData_);
                                        this.autoPilotData_ = builder4.buildPartial();
                                    }
                                } else if (!parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.cduTime_ = codedInputStream.readUInt64();
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
            return Overall.internal_static_xpilot_sr_proto_xpu_data_to_app_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_xpu_data_to_app_fieldAccessorTable.ensureFieldAccessorsInitialized(xpu_data_to_app.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public long getCduTime() {
            return this.cduTime_;
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public boolean hasImuInfo() {
            return this.imuInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public Imudata.ImuInfo getImuInfo() {
            Imudata.ImuInfo imuInfo = this.imuInfo_;
            return imuInfo == null ? Imudata.ImuInfo.getDefaultInstance() : imuInfo;
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public Imudata.ImuInfoOrBuilder getImuInfoOrBuilder() {
            return getImuInfo();
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public boolean hasNmeadataInfo() {
            return this.nmeadataInfo_ != null;
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public Nmeadata.NmeadataInfo getNmeadataInfo() {
            Nmeadata.NmeadataInfo nmeadataInfo = this.nmeadataInfo_;
            return nmeadataInfo == null ? Nmeadata.NmeadataInfo.getDefaultInstance() : nmeadataInfo;
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public Nmeadata.NmeadataInfoOrBuilder getNmeadataInfoOrBuilder() {
            return getNmeadataInfo();
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public boolean hasOverall() {
            return this.overall_ != null;
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public overall getOverall() {
            overall overallVar = this.overall_;
            return overallVar == null ? overall.getDefaultInstance() : overallVar;
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public overallOrBuilder getOverallOrBuilder() {
            return getOverall();
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public boolean hasAutoPilotData() {
            return this.autoPilotData_ != null;
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public AutoPilotDataOuterClass.AutoPilotData getAutoPilotData() {
            AutoPilotDataOuterClass.AutoPilotData autoPilotData = this.autoPilotData_;
            return autoPilotData == null ? AutoPilotDataOuterClass.AutoPilotData.getDefaultInstance() : autoPilotData;
        }

        @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
        public AutoPilotDataOuterClass.AutoPilotDataOrBuilder getAutoPilotDataOrBuilder() {
            return getAutoPilotData();
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
            long j = this.cduTime_;
            if (j != 0) {
                codedOutputStream.writeUInt64(1, j);
            }
            if (this.imuInfo_ != null) {
                codedOutputStream.writeMessage(2, getImuInfo());
            }
            if (this.nmeadataInfo_ != null) {
                codedOutputStream.writeMessage(3, getNmeadataInfo());
            }
            if (this.overall_ != null) {
                codedOutputStream.writeMessage(4, getOverall());
            }
            if (this.autoPilotData_ != null) {
                codedOutputStream.writeMessage(5, getAutoPilotData());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.cduTime_;
            int computeUInt64Size = j != 0 ? 0 + CodedOutputStream.computeUInt64Size(1, j) : 0;
            if (this.imuInfo_ != null) {
                computeUInt64Size += CodedOutputStream.computeMessageSize(2, getImuInfo());
            }
            if (this.nmeadataInfo_ != null) {
                computeUInt64Size += CodedOutputStream.computeMessageSize(3, getNmeadataInfo());
            }
            if (this.overall_ != null) {
                computeUInt64Size += CodedOutputStream.computeMessageSize(4, getOverall());
            }
            if (this.autoPilotData_ != null) {
                computeUInt64Size += CodedOutputStream.computeMessageSize(5, getAutoPilotData());
            }
            int serializedSize = computeUInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof xpu_data_to_app)) {
                return super.equals(obj);
            }
            xpu_data_to_app xpu_data_to_appVar = (xpu_data_to_app) obj;
            boolean z = ((getCduTime() > xpu_data_to_appVar.getCduTime() ? 1 : (getCduTime() == xpu_data_to_appVar.getCduTime() ? 0 : -1)) == 0) && hasImuInfo() == xpu_data_to_appVar.hasImuInfo();
            if (hasImuInfo()) {
                z = z && getImuInfo().equals(xpu_data_to_appVar.getImuInfo());
            }
            boolean z2 = z && hasNmeadataInfo() == xpu_data_to_appVar.hasNmeadataInfo();
            if (hasNmeadataInfo()) {
                z2 = z2 && getNmeadataInfo().equals(xpu_data_to_appVar.getNmeadataInfo());
            }
            boolean z3 = z2 && hasOverall() == xpu_data_to_appVar.hasOverall();
            if (hasOverall()) {
                z3 = z3 && getOverall().equals(xpu_data_to_appVar.getOverall());
            }
            boolean z4 = z3 && hasAutoPilotData() == xpu_data_to_appVar.hasAutoPilotData();
            if (hasAutoPilotData()) {
                z4 = z4 && getAutoPilotData().equals(xpu_data_to_appVar.getAutoPilotData());
            }
            return z4 && this.unknownFields.equals(xpu_data_to_appVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getCduTime());
            if (hasImuInfo()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getImuInfo().hashCode();
            }
            if (hasNmeadataInfo()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getNmeadataInfo().hashCode();
            }
            if (hasOverall()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getOverall().hashCode();
            }
            if (hasAutoPilotData()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getAutoPilotData().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static xpu_data_to_app parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static xpu_data_to_app parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static xpu_data_to_app parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static xpu_data_to_app parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static xpu_data_to_app parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static xpu_data_to_app parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static xpu_data_to_app parseFrom(InputStream inputStream) throws IOException {
            return (xpu_data_to_app) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static xpu_data_to_app parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (xpu_data_to_app) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static xpu_data_to_app parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (xpu_data_to_app) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static xpu_data_to_app parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (xpu_data_to_app) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static xpu_data_to_app parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (xpu_data_to_app) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static xpu_data_to_app parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (xpu_data_to_app) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(xpu_data_to_app xpu_data_to_appVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(xpu_data_to_appVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements xpu_data_to_appOrBuilder {
            private SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> autoPilotDataBuilder_;
            private AutoPilotDataOuterClass.AutoPilotData autoPilotData_;
            private long cduTime_;
            private SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> imuInfoBuilder_;
            private Imudata.ImuInfo imuInfo_;
            private SingleFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> nmeadataInfoBuilder_;
            private Nmeadata.NmeadataInfo nmeadataInfo_;
            private SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> overallBuilder_;
            private overall overall_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_xpu_data_to_app_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_xpu_data_to_app_fieldAccessorTable.ensureFieldAccessorsInitialized(xpu_data_to_app.class, Builder.class);
            }

            private Builder() {
                this.imuInfo_ = null;
                this.nmeadataInfo_ = null;
                this.overall_ = null;
                this.autoPilotData_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.imuInfo_ = null;
                this.nmeadataInfo_ = null;
                this.overall_ = null;
                this.autoPilotData_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = xpu_data_to_app.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.cduTime_ = 0L;
                if (this.imuInfoBuilder_ == null) {
                    this.imuInfo_ = null;
                } else {
                    this.imuInfo_ = null;
                    this.imuInfoBuilder_ = null;
                }
                if (this.nmeadataInfoBuilder_ == null) {
                    this.nmeadataInfo_ = null;
                } else {
                    this.nmeadataInfo_ = null;
                    this.nmeadataInfoBuilder_ = null;
                }
                if (this.overallBuilder_ == null) {
                    this.overall_ = null;
                } else {
                    this.overall_ = null;
                    this.overallBuilder_ = null;
                }
                if (this.autoPilotDataBuilder_ == null) {
                    this.autoPilotData_ = null;
                } else {
                    this.autoPilotData_ = null;
                    this.autoPilotDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_xpu_data_to_app_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public xpu_data_to_app getDefaultInstanceForType() {
                return xpu_data_to_app.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public xpu_data_to_app build() {
                xpu_data_to_app buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public xpu_data_to_app buildPartial() {
                xpu_data_to_app xpu_data_to_appVar = new xpu_data_to_app(this);
                xpu_data_to_appVar.cduTime_ = this.cduTime_;
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    xpu_data_to_appVar.imuInfo_ = this.imuInfo_;
                } else {
                    xpu_data_to_appVar.imuInfo_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> singleFieldBuilderV32 = this.nmeadataInfoBuilder_;
                if (singleFieldBuilderV32 == null) {
                    xpu_data_to_appVar.nmeadataInfo_ = this.nmeadataInfo_;
                } else {
                    xpu_data_to_appVar.nmeadataInfo_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV33 = this.overallBuilder_;
                if (singleFieldBuilderV33 == null) {
                    xpu_data_to_appVar.overall_ = this.overall_;
                } else {
                    xpu_data_to_appVar.overall_ = singleFieldBuilderV33.build();
                }
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV34 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV34 == null) {
                    xpu_data_to_appVar.autoPilotData_ = this.autoPilotData_;
                } else {
                    xpu_data_to_appVar.autoPilotData_ = singleFieldBuilderV34.build();
                }
                onBuilt();
                return xpu_data_to_appVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof xpu_data_to_app) {
                    return mergeFrom((xpu_data_to_app) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(xpu_data_to_app xpu_data_to_appVar) {
                if (xpu_data_to_appVar == xpu_data_to_app.getDefaultInstance()) {
                    return this;
                }
                if (xpu_data_to_appVar.getCduTime() != 0) {
                    setCduTime(xpu_data_to_appVar.getCduTime());
                }
                if (xpu_data_to_appVar.hasImuInfo()) {
                    mergeImuInfo(xpu_data_to_appVar.getImuInfo());
                }
                if (xpu_data_to_appVar.hasNmeadataInfo()) {
                    mergeNmeadataInfo(xpu_data_to_appVar.getNmeadataInfo());
                }
                if (xpu_data_to_appVar.hasOverall()) {
                    mergeOverall(xpu_data_to_appVar.getOverall());
                }
                if (xpu_data_to_appVar.hasAutoPilotData()) {
                    mergeAutoPilotData(xpu_data_to_appVar.getAutoPilotData());
                }
                mergeUnknownFields(xpu_data_to_appVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.xpu_data_to_app.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.xpu_data_to_app.access$13100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$xpu_data_to_app r3 = (xpilot.sr.proto.Overall.xpu_data_to_app) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$xpu_data_to_app r4 = (xpilot.sr.proto.Overall.xpu_data_to_app) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.xpu_data_to_app.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$xpu_data_to_app$Builder");
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public long getCduTime() {
                return this.cduTime_;
            }

            public Builder setCduTime(long j) {
                this.cduTime_ = j;
                onChanged();
                return this;
            }

            public Builder clearCduTime() {
                this.cduTime_ = 0L;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public boolean hasImuInfo() {
                return (this.imuInfoBuilder_ == null && this.imuInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public Imudata.ImuInfo getImuInfo() {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Imudata.ImuInfo imuInfo = this.imuInfo_;
                    return imuInfo == null ? Imudata.ImuInfo.getDefaultInstance() : imuInfo;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setImuInfo(Imudata.ImuInfo imuInfo) {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(imuInfo);
                } else if (imuInfo == null) {
                    throw new NullPointerException();
                } else {
                    this.imuInfo_ = imuInfo;
                    onChanged();
                }
                return this;
            }

            public Builder setImuInfo(Imudata.ImuInfo.Builder builder) {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.imuInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeImuInfo(Imudata.ImuInfo imuInfo) {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Imudata.ImuInfo imuInfo2 = this.imuInfo_;
                    if (imuInfo2 != null) {
                        this.imuInfo_ = Imudata.ImuInfo.newBuilder(imuInfo2).mergeFrom(imuInfo).buildPartial();
                    } else {
                        this.imuInfo_ = imuInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(imuInfo);
                }
                return this;
            }

            public Builder clearImuInfo() {
                if (this.imuInfoBuilder_ == null) {
                    this.imuInfo_ = null;
                    onChanged();
                } else {
                    this.imuInfo_ = null;
                    this.imuInfoBuilder_ = null;
                }
                return this;
            }

            public Imudata.ImuInfo.Builder getImuInfoBuilder() {
                onChanged();
                return getImuInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public Imudata.ImuInfoOrBuilder getImuInfoOrBuilder() {
                SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> singleFieldBuilderV3 = this.imuInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Imudata.ImuInfo imuInfo = this.imuInfo_;
                return imuInfo == null ? Imudata.ImuInfo.getDefaultInstance() : imuInfo;
            }

            private SingleFieldBuilderV3<Imudata.ImuInfo, Imudata.ImuInfo.Builder, Imudata.ImuInfoOrBuilder> getImuInfoFieldBuilder() {
                if (this.imuInfoBuilder_ == null) {
                    this.imuInfoBuilder_ = new SingleFieldBuilderV3<>(getImuInfo(), getParentForChildren(), isClean());
                    this.imuInfo_ = null;
                }
                return this.imuInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public boolean hasNmeadataInfo() {
                return (this.nmeadataInfoBuilder_ == null && this.nmeadataInfo_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public Nmeadata.NmeadataInfo getNmeadataInfo() {
                SingleFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Nmeadata.NmeadataInfo nmeadataInfo = this.nmeadataInfo_;
                    return nmeadataInfo == null ? Nmeadata.NmeadataInfo.getDefaultInstance() : nmeadataInfo;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setNmeadataInfo(Nmeadata.NmeadataInfo nmeadataInfo) {
                SingleFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(nmeadataInfo);
                } else if (nmeadataInfo == null) {
                    throw new NullPointerException();
                } else {
                    this.nmeadataInfo_ = nmeadataInfo;
                    onChanged();
                }
                return this;
            }

            public Builder setNmeadataInfo(Nmeadata.NmeadataInfo.Builder builder) {
                SingleFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.nmeadataInfo_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeNmeadataInfo(Nmeadata.NmeadataInfo nmeadataInfo) {
                SingleFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Nmeadata.NmeadataInfo nmeadataInfo2 = this.nmeadataInfo_;
                    if (nmeadataInfo2 != null) {
                        this.nmeadataInfo_ = Nmeadata.NmeadataInfo.newBuilder(nmeadataInfo2).mergeFrom(nmeadataInfo).buildPartial();
                    } else {
                        this.nmeadataInfo_ = nmeadataInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(nmeadataInfo);
                }
                return this;
            }

            public Builder clearNmeadataInfo() {
                if (this.nmeadataInfoBuilder_ == null) {
                    this.nmeadataInfo_ = null;
                    onChanged();
                } else {
                    this.nmeadataInfo_ = null;
                    this.nmeadataInfoBuilder_ = null;
                }
                return this;
            }

            public Nmeadata.NmeadataInfo.Builder getNmeadataInfoBuilder() {
                onChanged();
                return getNmeadataInfoFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public Nmeadata.NmeadataInfoOrBuilder getNmeadataInfoOrBuilder() {
                SingleFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Nmeadata.NmeadataInfo nmeadataInfo = this.nmeadataInfo_;
                return nmeadataInfo == null ? Nmeadata.NmeadataInfo.getDefaultInstance() : nmeadataInfo;
            }

            private SingleFieldBuilderV3<Nmeadata.NmeadataInfo, Nmeadata.NmeadataInfo.Builder, Nmeadata.NmeadataInfoOrBuilder> getNmeadataInfoFieldBuilder() {
                if (this.nmeadataInfoBuilder_ == null) {
                    this.nmeadataInfoBuilder_ = new SingleFieldBuilderV3<>(getNmeadataInfo(), getParentForChildren(), isClean());
                    this.nmeadataInfo_ = null;
                }
                return this.nmeadataInfoBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public boolean hasOverall() {
                return (this.overallBuilder_ == null && this.overall_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public overall getOverall() {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall overallVar = this.overall_;
                    return overallVar == null ? overall.getDefaultInstance() : overallVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setOverall(overall overallVar) {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(overallVar);
                } else if (overallVar == null) {
                    throw new NullPointerException();
                } else {
                    this.overall_ = overallVar;
                    onChanged();
                }
                return this;
            }

            public Builder setOverall(overall.Builder builder) {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.overall_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeOverall(overall overallVar) {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    overall overallVar2 = this.overall_;
                    if (overallVar2 != null) {
                        this.overall_ = overall.newBuilder(overallVar2).mergeFrom(overallVar).buildPartial();
                    } else {
                        this.overall_ = overallVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(overallVar);
                }
                return this;
            }

            public Builder clearOverall() {
                if (this.overallBuilder_ == null) {
                    this.overall_ = null;
                    onChanged();
                } else {
                    this.overall_ = null;
                    this.overallBuilder_ = null;
                }
                return this;
            }

            public overall.Builder getOverallBuilder() {
                onChanged();
                return getOverallFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public overallOrBuilder getOverallOrBuilder() {
                SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> singleFieldBuilderV3 = this.overallBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                overall overallVar = this.overall_;
                return overallVar == null ? overall.getDefaultInstance() : overallVar;
            }

            private SingleFieldBuilderV3<overall, overall.Builder, overallOrBuilder> getOverallFieldBuilder() {
                if (this.overallBuilder_ == null) {
                    this.overallBuilder_ = new SingleFieldBuilderV3<>(getOverall(), getParentForChildren(), isClean());
                    this.overall_ = null;
                }
                return this.overallBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public boolean hasAutoPilotData() {
                return (this.autoPilotDataBuilder_ == null && this.autoPilotData_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public AutoPilotDataOuterClass.AutoPilotData getAutoPilotData() {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AutoPilotDataOuterClass.AutoPilotData autoPilotData = this.autoPilotData_;
                    return autoPilotData == null ? AutoPilotDataOuterClass.AutoPilotData.getDefaultInstance() : autoPilotData;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setAutoPilotData(AutoPilotDataOuterClass.AutoPilotData autoPilotData) {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(autoPilotData);
                } else if (autoPilotData == null) {
                    throw new NullPointerException();
                } else {
                    this.autoPilotData_ = autoPilotData;
                    onChanged();
                }
                return this;
            }

            public Builder setAutoPilotData(AutoPilotDataOuterClass.AutoPilotData.Builder builder) {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.autoPilotData_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeAutoPilotData(AutoPilotDataOuterClass.AutoPilotData autoPilotData) {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AutoPilotDataOuterClass.AutoPilotData autoPilotData2 = this.autoPilotData_;
                    if (autoPilotData2 != null) {
                        this.autoPilotData_ = AutoPilotDataOuterClass.AutoPilotData.newBuilder(autoPilotData2).mergeFrom(autoPilotData).buildPartial();
                    } else {
                        this.autoPilotData_ = autoPilotData;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(autoPilotData);
                }
                return this;
            }

            public Builder clearAutoPilotData() {
                if (this.autoPilotDataBuilder_ == null) {
                    this.autoPilotData_ = null;
                    onChanged();
                } else {
                    this.autoPilotData_ = null;
                    this.autoPilotDataBuilder_ = null;
                }
                return this;
            }

            public AutoPilotDataOuterClass.AutoPilotData.Builder getAutoPilotDataBuilder() {
                onChanged();
                return getAutoPilotDataFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.xpu_data_to_appOrBuilder
            public AutoPilotDataOuterClass.AutoPilotDataOrBuilder getAutoPilotDataOrBuilder() {
                SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> singleFieldBuilderV3 = this.autoPilotDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                AutoPilotDataOuterClass.AutoPilotData autoPilotData = this.autoPilotData_;
                return autoPilotData == null ? AutoPilotDataOuterClass.AutoPilotData.getDefaultInstance() : autoPilotData;
            }

            private SingleFieldBuilderV3<AutoPilotDataOuterClass.AutoPilotData, AutoPilotDataOuterClass.AutoPilotData.Builder, AutoPilotDataOuterClass.AutoPilotDataOrBuilder> getAutoPilotDataFieldBuilder() {
                if (this.autoPilotDataBuilder_ == null) {
                    this.autoPilotDataBuilder_ = new SingleFieldBuilderV3<>(getAutoPilotData(), getParentForChildren(), isClean());
                    this.autoPilotData_ = null;
                }
                return this.autoPilotDataBuilder_;
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

        public static xpu_data_to_app getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<xpu_data_to_app> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<xpu_data_to_app> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public xpu_data_to_app getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class imu_nmea_forSrservice extends GeneratedMessageV3 implements imu_nmea_forSrserviceOrBuilder {
        public static final int IMUINFO_OVERALL_FIELD_NUMBER = 1;
        public static final int NMEADATAINFO_OVERALL_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private imu_cdutime imuInfoOverall_;
        private byte memoizedIsInitialized;
        private gnss_cdutime nmeadataInfoOverall_;
        private static final imu_nmea_forSrservice DEFAULT_INSTANCE = new imu_nmea_forSrservice();
        private static final Parser<imu_nmea_forSrservice> PARSER = new AbstractParser<imu_nmea_forSrservice>() { // from class: xpilot.sr.proto.Overall.imu_nmea_forSrservice.1
            @Override // com.google.protobuf.Parser
            public imu_nmea_forSrservice parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new imu_nmea_forSrservice(codedInputStream, extensionRegistryLite);
            }
        };

        private imu_nmea_forSrservice(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private imu_nmea_forSrservice() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private imu_nmea_forSrservice(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                imu_cdutime.Builder builder = this.imuInfoOverall_ != null ? this.imuInfoOverall_.toBuilder() : null;
                                this.imuInfoOverall_ = (imu_cdutime) codedInputStream.readMessage(imu_cdutime.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.imuInfoOverall_);
                                    this.imuInfoOverall_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                gnss_cdutime.Builder builder2 = this.nmeadataInfoOverall_ != null ? this.nmeadataInfoOverall_.toBuilder() : null;
                                this.nmeadataInfoOverall_ = (gnss_cdutime) codedInputStream.readMessage(gnss_cdutime.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.nmeadataInfoOverall_);
                                    this.nmeadataInfoOverall_ = builder2.buildPartial();
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
            return Overall.internal_static_xpilot_sr_proto_imu_nmea_forSrservice_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Overall.internal_static_xpilot_sr_proto_imu_nmea_forSrservice_fieldAccessorTable.ensureFieldAccessorsInitialized(imu_nmea_forSrservice.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
        public boolean hasImuInfoOverall() {
            return this.imuInfoOverall_ != null;
        }

        @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
        public imu_cdutime getImuInfoOverall() {
            imu_cdutime imu_cdutimeVar = this.imuInfoOverall_;
            return imu_cdutimeVar == null ? imu_cdutime.getDefaultInstance() : imu_cdutimeVar;
        }

        @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
        public imu_cdutimeOrBuilder getImuInfoOverallOrBuilder() {
            return getImuInfoOverall();
        }

        @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
        public boolean hasNmeadataInfoOverall() {
            return this.nmeadataInfoOverall_ != null;
        }

        @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
        public gnss_cdutime getNmeadataInfoOverall() {
            gnss_cdutime gnss_cdutimeVar = this.nmeadataInfoOverall_;
            return gnss_cdutimeVar == null ? gnss_cdutime.getDefaultInstance() : gnss_cdutimeVar;
        }

        @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
        public gnss_cdutimeOrBuilder getNmeadataInfoOverallOrBuilder() {
            return getNmeadataInfoOverall();
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
            if (this.imuInfoOverall_ != null) {
                codedOutputStream.writeMessage(1, getImuInfoOverall());
            }
            if (this.nmeadataInfoOverall_ != null) {
                codedOutputStream.writeMessage(2, getNmeadataInfoOverall());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.imuInfoOverall_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getImuInfoOverall()) : 0;
            if (this.nmeadataInfoOverall_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getNmeadataInfoOverall());
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
            if (!(obj instanceof imu_nmea_forSrservice)) {
                return super.equals(obj);
            }
            imu_nmea_forSrservice imu_nmea_forsrservice = (imu_nmea_forSrservice) obj;
            boolean z = hasImuInfoOverall() == imu_nmea_forsrservice.hasImuInfoOverall();
            if (hasImuInfoOverall()) {
                z = z && getImuInfoOverall().equals(imu_nmea_forsrservice.getImuInfoOverall());
            }
            boolean z2 = z && hasNmeadataInfoOverall() == imu_nmea_forsrservice.hasNmeadataInfoOverall();
            if (hasNmeadataInfoOverall()) {
                z2 = z2 && getNmeadataInfoOverall().equals(imu_nmea_forsrservice.getNmeadataInfoOverall());
            }
            return z2 && this.unknownFields.equals(imu_nmea_forsrservice.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasImuInfoOverall()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getImuInfoOverall().hashCode();
            }
            if (hasNmeadataInfoOverall()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getNmeadataInfoOverall().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static imu_nmea_forSrservice parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static imu_nmea_forSrservice parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static imu_nmea_forSrservice parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static imu_nmea_forSrservice parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static imu_nmea_forSrservice parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static imu_nmea_forSrservice parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static imu_nmea_forSrservice parseFrom(InputStream inputStream) throws IOException {
            return (imu_nmea_forSrservice) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static imu_nmea_forSrservice parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (imu_nmea_forSrservice) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static imu_nmea_forSrservice parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (imu_nmea_forSrservice) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static imu_nmea_forSrservice parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (imu_nmea_forSrservice) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static imu_nmea_forSrservice parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (imu_nmea_forSrservice) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static imu_nmea_forSrservice parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (imu_nmea_forSrservice) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(imu_nmea_forSrservice imu_nmea_forsrservice) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(imu_nmea_forsrservice);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements imu_nmea_forSrserviceOrBuilder {
            private SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> imuInfoOverallBuilder_;
            private imu_cdutime imuInfoOverall_;
            private SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> nmeadataInfoOverallBuilder_;
            private gnss_cdutime nmeadataInfoOverall_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Overall.internal_static_xpilot_sr_proto_imu_nmea_forSrservice_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Overall.internal_static_xpilot_sr_proto_imu_nmea_forSrservice_fieldAccessorTable.ensureFieldAccessorsInitialized(imu_nmea_forSrservice.class, Builder.class);
            }

            private Builder() {
                this.imuInfoOverall_ = null;
                this.nmeadataInfoOverall_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.imuInfoOverall_ = null;
                this.nmeadataInfoOverall_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = imu_nmea_forSrservice.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.imuInfoOverallBuilder_ == null) {
                    this.imuInfoOverall_ = null;
                } else {
                    this.imuInfoOverall_ = null;
                    this.imuInfoOverallBuilder_ = null;
                }
                if (this.nmeadataInfoOverallBuilder_ == null) {
                    this.nmeadataInfoOverall_ = null;
                } else {
                    this.nmeadataInfoOverall_ = null;
                    this.nmeadataInfoOverallBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Overall.internal_static_xpilot_sr_proto_imu_nmea_forSrservice_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public imu_nmea_forSrservice getDefaultInstanceForType() {
                return imu_nmea_forSrservice.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public imu_nmea_forSrservice build() {
                imu_nmea_forSrservice buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public imu_nmea_forSrservice buildPartial() {
                imu_nmea_forSrservice imu_nmea_forsrservice = new imu_nmea_forSrservice(this);
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuInfoOverallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    imu_nmea_forsrservice.imuInfoOverall_ = this.imuInfoOverall_;
                } else {
                    imu_nmea_forsrservice.imuInfoOverall_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV32 = this.nmeadataInfoOverallBuilder_;
                if (singleFieldBuilderV32 == null) {
                    imu_nmea_forsrservice.nmeadataInfoOverall_ = this.nmeadataInfoOverall_;
                } else {
                    imu_nmea_forsrservice.nmeadataInfoOverall_ = singleFieldBuilderV32.build();
                }
                onBuilt();
                return imu_nmea_forsrservice;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo87clone() {
                return (Builder) super.mo87clone();
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
                if (message instanceof imu_nmea_forSrservice) {
                    return mergeFrom((imu_nmea_forSrservice) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(imu_nmea_forSrservice imu_nmea_forsrservice) {
                if (imu_nmea_forsrservice == imu_nmea_forSrservice.getDefaultInstance()) {
                    return this;
                }
                if (imu_nmea_forsrservice.hasImuInfoOverall()) {
                    mergeImuInfoOverall(imu_nmea_forsrservice.getImuInfoOverall());
                }
                if (imu_nmea_forsrservice.hasNmeadataInfoOverall()) {
                    mergeNmeadataInfoOverall(imu_nmea_forsrservice.getNmeadataInfoOverall());
                }
                mergeUnknownFields(imu_nmea_forsrservice.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Overall.imu_nmea_forSrservice.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.imu_nmea_forSrservice.access$14200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Overall$imu_nmea_forSrservice r3 = (xpilot.sr.proto.Overall.imu_nmea_forSrservice) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Overall$imu_nmea_forSrservice r4 = (xpilot.sr.proto.Overall.imu_nmea_forSrservice) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Overall.imu_nmea_forSrservice.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Overall$imu_nmea_forSrservice$Builder");
            }

            @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
            public boolean hasImuInfoOverall() {
                return (this.imuInfoOverallBuilder_ == null && this.imuInfoOverall_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
            public imu_cdutime getImuInfoOverall() {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuInfoOverallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    imu_cdutime imu_cdutimeVar = this.imuInfoOverall_;
                    return imu_cdutimeVar == null ? imu_cdutime.getDefaultInstance() : imu_cdutimeVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setImuInfoOverall(imu_cdutime imu_cdutimeVar) {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuInfoOverallBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(imu_cdutimeVar);
                } else if (imu_cdutimeVar == null) {
                    throw new NullPointerException();
                } else {
                    this.imuInfoOverall_ = imu_cdutimeVar;
                    onChanged();
                }
                return this;
            }

            public Builder setImuInfoOverall(imu_cdutime.Builder builder) {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuInfoOverallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.imuInfoOverall_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeImuInfoOverall(imu_cdutime imu_cdutimeVar) {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuInfoOverallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    imu_cdutime imu_cdutimeVar2 = this.imuInfoOverall_;
                    if (imu_cdutimeVar2 != null) {
                        this.imuInfoOverall_ = imu_cdutime.newBuilder(imu_cdutimeVar2).mergeFrom(imu_cdutimeVar).buildPartial();
                    } else {
                        this.imuInfoOverall_ = imu_cdutimeVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(imu_cdutimeVar);
                }
                return this;
            }

            public Builder clearImuInfoOverall() {
                if (this.imuInfoOverallBuilder_ == null) {
                    this.imuInfoOverall_ = null;
                    onChanged();
                } else {
                    this.imuInfoOverall_ = null;
                    this.imuInfoOverallBuilder_ = null;
                }
                return this;
            }

            public imu_cdutime.Builder getImuInfoOverallBuilder() {
                onChanged();
                return getImuInfoOverallFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
            public imu_cdutimeOrBuilder getImuInfoOverallOrBuilder() {
                SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> singleFieldBuilderV3 = this.imuInfoOverallBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                imu_cdutime imu_cdutimeVar = this.imuInfoOverall_;
                return imu_cdutimeVar == null ? imu_cdutime.getDefaultInstance() : imu_cdutimeVar;
            }

            private SingleFieldBuilderV3<imu_cdutime, imu_cdutime.Builder, imu_cdutimeOrBuilder> getImuInfoOverallFieldBuilder() {
                if (this.imuInfoOverallBuilder_ == null) {
                    this.imuInfoOverallBuilder_ = new SingleFieldBuilderV3<>(getImuInfoOverall(), getParentForChildren(), isClean());
                    this.imuInfoOverall_ = null;
                }
                return this.imuInfoOverallBuilder_;
            }

            @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
            public boolean hasNmeadataInfoOverall() {
                return (this.nmeadataInfoOverallBuilder_ == null && this.nmeadataInfoOverall_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
            public gnss_cdutime getNmeadataInfoOverall() {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoOverallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    gnss_cdutime gnss_cdutimeVar = this.nmeadataInfoOverall_;
                    return gnss_cdutimeVar == null ? gnss_cdutime.getDefaultInstance() : gnss_cdutimeVar;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setNmeadataInfoOverall(gnss_cdutime gnss_cdutimeVar) {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoOverallBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(gnss_cdutimeVar);
                } else if (gnss_cdutimeVar == null) {
                    throw new NullPointerException();
                } else {
                    this.nmeadataInfoOverall_ = gnss_cdutimeVar;
                    onChanged();
                }
                return this;
            }

            public Builder setNmeadataInfoOverall(gnss_cdutime.Builder builder) {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoOverallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.nmeadataInfoOverall_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeNmeadataInfoOverall(gnss_cdutime gnss_cdutimeVar) {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoOverallBuilder_;
                if (singleFieldBuilderV3 == null) {
                    gnss_cdutime gnss_cdutimeVar2 = this.nmeadataInfoOverall_;
                    if (gnss_cdutimeVar2 != null) {
                        this.nmeadataInfoOverall_ = gnss_cdutime.newBuilder(gnss_cdutimeVar2).mergeFrom(gnss_cdutimeVar).buildPartial();
                    } else {
                        this.nmeadataInfoOverall_ = gnss_cdutimeVar;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(gnss_cdutimeVar);
                }
                return this;
            }

            public Builder clearNmeadataInfoOverall() {
                if (this.nmeadataInfoOverallBuilder_ == null) {
                    this.nmeadataInfoOverall_ = null;
                    onChanged();
                } else {
                    this.nmeadataInfoOverall_ = null;
                    this.nmeadataInfoOverallBuilder_ = null;
                }
                return this;
            }

            public gnss_cdutime.Builder getNmeadataInfoOverallBuilder() {
                onChanged();
                return getNmeadataInfoOverallFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Overall.imu_nmea_forSrserviceOrBuilder
            public gnss_cdutimeOrBuilder getNmeadataInfoOverallOrBuilder() {
                SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> singleFieldBuilderV3 = this.nmeadataInfoOverallBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                gnss_cdutime gnss_cdutimeVar = this.nmeadataInfoOverall_;
                return gnss_cdutimeVar == null ? gnss_cdutime.getDefaultInstance() : gnss_cdutimeVar;
            }

            private SingleFieldBuilderV3<gnss_cdutime, gnss_cdutime.Builder, gnss_cdutimeOrBuilder> getNmeadataInfoOverallFieldBuilder() {
                if (this.nmeadataInfoOverallBuilder_ == null) {
                    this.nmeadataInfoOverallBuilder_ = new SingleFieldBuilderV3<>(getNmeadataInfoOverall(), getParentForChildren(), isClean());
                    this.nmeadataInfoOverall_ = null;
                }
                return this.nmeadataInfoOverallBuilder_;
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

        public static imu_nmea_forSrservice getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<imu_nmea_forSrservice> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<imu_nmea_forSrservice> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public imu_nmea_forSrservice getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\roverall.proto\u0012\u000fxpilot.sr.proto\u001a\u0010primitives.proto\u001a\u0010local_pose.proto\u001a\u0018static_environment.proto\u001a\u0019dynamic_environment.proto\u001a\u000fposrtkimu.proto\u001a\u000enmeadata.proto\u001a\rimudata.proto\u001a\u0015auto_pilot_data.proto\"í\u0004\n\u0007overall\u00122\n\nlocal_pose\u0018\u0001 \u0001(\u000b2\u001e.xpilot.sr.proto.LocalPoseInfo\u00129\n\fdynamic_info\u0018\u0002 \u0001(\u000b2#.xpilot.sr.proto.DynamicEnvironment\u00127\n\u000bstatic_info\u0018\u0003 \u0001(\u000b2\".xpilot.sr.proto.StaticEnvironment\u00120\n\u0007mp_info\u0018\u0004 \u0001(\u000b2\u001f.xpilot.sr.proto.MotionPlanning\u00120\n\u0007gp_info\u0018\u0005 \u0001(\u000b2\u001f.xpilot.sr.proto.GlobalPoseInfo\u00121\n\u0007sm_info\u0018\u0006 \u0001(\u000b2 .xpilot.sr.proto.StateManagement\u0012;\n\fmf_lane_info\u0018\u0007 \u0001(\u000b2%.xpilot.sr.proto.MapFusionLanesForScu\u0012/\n\ngaode_info\u0018\b \u0001(\u000b2\u001b.xpilot.sr.proto.Gaode_Info\u0012*\n\u0007bp_info\u0018\t \u0001(\u000b2\u0019.xpilot.sr.proto.BPoutput\u0012\u0015\n\rsr_display_st\u0018\n \u0001(\u0005\u0012\u0019\n\u0011save_proto_signal\u0018\u000b \u0001(\u0005\u0012\u0013\n\u000buse_last_mp\u0018\f \u0001(\u0005\u0012\u0015\n\ruse_last_sfbp\u0018\r \u0001(\u0005\u0012\u0013\n\u000bxp_pos_info\u0018\u001e \u0001(\f\u0012\u0016\n\u000exp_ehp_version\u0018\u001f \u0001(\f\":\n\rtotal_overall\u0012)\n\u0007overall\u0018\u0001 \u0003(\u000b2\u0018.xpilot.sr.proto.overall\"©\u0001\n\u0010overall_imu_nmea\u00125\n\roverall_gaode\u0018\u0001 \u0001(\u000b2\u001e.xpilot.sr.proto.overall_gaode\u0012)\n\u0007imuInfo\u0018\u0002 \u0001(\u000b2\u0018.xpilot.sr.proto.ImuInfo\u00123\n\fnmeadataInfo\u0018\u0003 \u0003(\u000b2\u001d.xpilot.sr.proto.NmeadataInfo\"v\n\roverall_gaode\u0012)\n\u0007overall\u0018\u0001 \u0001(\u000b2\u0018.xpilot.sr.proto.overall\u0012:\n\rautoPilotData\u0018\u0002 \u0001(\u000b2#.lane.auto_pilot.data.AutoPilotData\"Z\n\u000foverall_cdutime\u00125\n\roverall_gaode\u0018\u0001 \u0003(\u000b2\u001e.xpilot.sr.proto.overall_gaode\u0012\u0010\n\bcdu_time\u0018\u0002 \u0003(\u0004\"J\n\u000bimu_cdutime\u0012)\n\u0007imuInfo\u0018\u0001 \u0003(\u000b2\u0018.xpilot.sr.proto.ImuInfo\u0012\u0010\n\bcdu_time\u0018\u0002 \u0003(\u0004\"U\n\fgnss_cdutime\u00123\n\fnmeadataInfo\u0018\u0001 \u0003(\u000b2\u001d.xpilot.sr.proto.NmeadataInfo\u0012\u0010\n\bcdu_time\u0018\u0002 \u0003(\u0004\"«\u0001\n\u000fsave_sr_overall\u00126\n\foverall_data\u0018\u0001 \u0001(\u000b2 .xpilot.sr.proto.overall_cdutime\u0012.\n\bimu_data\u0018\u0002 \u0001(\u000b2\u001c.xpilot.sr.proto.imu_cdutime\u00120\n\tgnss_data\u0018\u0003 \u0001(\u000b2\u001d.xpilot.sr.proto.gnss_cdutime\"J\n\u0011total_xpu_overall\u00125\n\u000bxpu_overall\u0018\u0001 \u0003(\u000b2 .xpilot.sr.proto.xpu_data_to_app\"ê\u0001\n\u000fxpu_data_to_app\u0012\u0010\n\bcdu_time\u0018\u0001 \u0001(\u0004\u0012)\n\u0007imuInfo\u0018\u0002 \u0001(\u000b2\u0018.xpilot.sr.proto.ImuInfo\u00123\n\fnmeadataInfo\u0018\u0003 \u0001(\u000b2\u001d.xpilot.sr.proto.NmeadataInfo\u0012)\n\u0007overall\u0018\u0004 \u0001(\u000b2\u0018.xpilot.sr.proto.overall\u0012:\n\rautoPilotData\u0018\u0005 \u0001(\u000b2#.lane.auto_pilot.data.AutoPilotData\"\u008b\u0001\n\u0015imu_nmea_forSrservice\u00125\n\u000fimuInfo_overall\u0018\u0001 \u0001(\u000b2\u001c.xpilot.sr.proto.imu_cdutime\u0012;\n\u0014nmeadataInfo_overall\u0018\u0002 \u0001(\u000b2\u001d.xpilot.sr.proto.gnss_cdutimeb\u0006proto3"}, new Descriptors.FileDescriptor[]{Primitives.getDescriptor(), LocalPose.getDescriptor(), StaticEnvironmentOuterClass.getDescriptor(), DynamicEnvironmentOuterClass.getDescriptor(), Posrtkimu.getDescriptor(), Nmeadata.getDescriptor(), Imudata.getDescriptor(), AutoPilotDataOuterClass.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.Overall.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Overall.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_overall_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_overall_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_overall_descriptor, new String[]{"LocalPose", "DynamicInfo", "StaticInfo", "MpInfo", "GpInfo", "SmInfo", "MfLaneInfo", "GaodeInfo", "BpInfo", "SrDisplaySt", "SaveProtoSignal", "UseLastMp", "UseLastSfbp", "XpPosInfo", "XpEhpVersion"});
        internal_static_xpilot_sr_proto_total_overall_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_xpilot_sr_proto_total_overall_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_total_overall_descriptor, new String[]{"Overall"});
        internal_static_xpilot_sr_proto_overall_imu_nmea_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_xpilot_sr_proto_overall_imu_nmea_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_overall_imu_nmea_descriptor, new String[]{"OverallGaode", "ImuInfo", "NmeadataInfo"});
        internal_static_xpilot_sr_proto_overall_gaode_descriptor = getDescriptor().getMessageTypes().get(3);
        internal_static_xpilot_sr_proto_overall_gaode_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_overall_gaode_descriptor, new String[]{"Overall", "AutoPilotData"});
        internal_static_xpilot_sr_proto_overall_cdutime_descriptor = getDescriptor().getMessageTypes().get(4);
        internal_static_xpilot_sr_proto_overall_cdutime_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_overall_cdutime_descriptor, new String[]{"OverallGaode", "CduTime"});
        internal_static_xpilot_sr_proto_imu_cdutime_descriptor = getDescriptor().getMessageTypes().get(5);
        internal_static_xpilot_sr_proto_imu_cdutime_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_imu_cdutime_descriptor, new String[]{"ImuInfo", "CduTime"});
        internal_static_xpilot_sr_proto_gnss_cdutime_descriptor = getDescriptor().getMessageTypes().get(6);
        internal_static_xpilot_sr_proto_gnss_cdutime_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_gnss_cdutime_descriptor, new String[]{"NmeadataInfo", "CduTime"});
        internal_static_xpilot_sr_proto_save_sr_overall_descriptor = getDescriptor().getMessageTypes().get(7);
        internal_static_xpilot_sr_proto_save_sr_overall_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_save_sr_overall_descriptor, new String[]{"OverallData", "ImuData", "GnssData"});
        internal_static_xpilot_sr_proto_total_xpu_overall_descriptor = getDescriptor().getMessageTypes().get(8);
        internal_static_xpilot_sr_proto_total_xpu_overall_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_total_xpu_overall_descriptor, new String[]{"XpuOverall"});
        internal_static_xpilot_sr_proto_xpu_data_to_app_descriptor = getDescriptor().getMessageTypes().get(9);
        internal_static_xpilot_sr_proto_xpu_data_to_app_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_xpu_data_to_app_descriptor, new String[]{"CduTime", "ImuInfo", "NmeadataInfo", "Overall", "AutoPilotData"});
        internal_static_xpilot_sr_proto_imu_nmea_forSrservice_descriptor = getDescriptor().getMessageTypes().get(10);
        internal_static_xpilot_sr_proto_imu_nmea_forSrservice_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_imu_nmea_forSrservice_descriptor, new String[]{"ImuInfoOverall", "NmeadataInfoOverall"});
        Primitives.getDescriptor();
        LocalPose.getDescriptor();
        StaticEnvironmentOuterClass.getDescriptor();
        DynamicEnvironmentOuterClass.getDescriptor();
        Posrtkimu.getDescriptor();
        Nmeadata.getDescriptor();
        Imudata.getDescriptor();
        AutoPilotDataOuterClass.getDescriptor();
    }
}
