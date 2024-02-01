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
import xpilot.sr.proto.DynamicEnvironmentOuterClass;
import xpilot.sr.proto.LocalPose;
import xpilot.sr.proto.Posrtkimu;
import xpilot.sr.proto.Primitives;
import xpilot.sr.proto.StaticEnvironmentOuterClass;
/* loaded from: classes4.dex */
public final class Overall {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_overall_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_overall_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_total_overall_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_total_overall_fieldAccessorTable;

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
    public interface total_overallOrBuilder extends MessageOrBuilder {
        overall getOverall(int i);

        int getOverallCount();

        List<overall> getOverallList();

        overallOrBuilder getOverallOrBuilder(int i);

        List<? extends overallOrBuilder> getOverallOrBuilderList();
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
        public static final int XP_POS_INFO_FIELD_NUMBER = 14;
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
                            case 114:
                                this.xpPosInfo_ = codedInputStream.readBytes();
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
                codedOutputStream.writeBytes(14, this.xpPosInfo_);
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
                computeMessageSize += CodedOutputStream.computeBytesSize(14, this.xpPosInfo_);
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
            return (((((z9 && getSrDisplaySt() == overallVar.getSrDisplaySt()) && getSaveProtoSignal() == overallVar.getSaveProtoSignal()) && getUseLastMp() == overallVar.getUseLastMp()) && getUseLastSfbp() == overallVar.getUseLastSfbp()) && getXpPosInfo().equals(overallVar.getXpPosInfo())) && this.unknownFields.equals(overallVar.unknownFields);
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
            int srDisplaySt = (((((((((((((((((((((hashCode * 37) + 10) * 53) + getSrDisplaySt()) * 37) + 11) * 53) + getSaveProtoSignal()) * 37) + 12) * 53) + getUseLastMp()) * 37) + 13) * 53) + getUseLastSfbp()) * 37) + 14) * 53) + getXpPosInfo().hashCode()) * 29) + this.unknownFields.hashCode();
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
                onBuilt();
                return overallVar;
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
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.overall.access$2100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Overall.total_overall.access$3200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\roverall.proto\u0012\u000fxpilot.sr.proto\u001a\u0010primitives.proto\u001a\u0010local_pose.proto\u001a\u0018static_environment.proto\u001a\u0019dynamic_environment.proto\u001a\u000fposrtkimu.proto\"Õ\u0004\n\u0007overall\u00122\n\nlocal_pose\u0018\u0001 \u0001(\u000b2\u001e.xpilot.sr.proto.LocalPoseInfo\u00129\n\fdynamic_info\u0018\u0002 \u0001(\u000b2#.xpilot.sr.proto.DynamicEnvironment\u00127\n\u000bstatic_info\u0018\u0003 \u0001(\u000b2\".xpilot.sr.proto.StaticEnvironment\u00120\n\u0007mp_info\u0018\u0004 \u0001(\u000b2\u001f.xpilot.sr.proto.MotionPlanning\u00120\n\u0007gp_info\u0018\u0005 \u0001(\u000b2\u001f.xpilot.sr.proto.GlobalPoseInfo\u00121\n\u0007sm_info\u0018\u0006 \u0001(\u000b2 .xpilot.sr.proto.StateManagement\u0012;\n\fmf_lane_info\u0018\u0007 \u0001(\u000b2%.xpilot.sr.proto.MapFusionLanesForScu\u0012/\n\ngaode_info\u0018\b \u0001(\u000b2\u001b.xpilot.sr.proto.Gaode_Info\u0012*\n\u0007bp_info\u0018\t \u0001(\u000b2\u0019.xpilot.sr.proto.BPoutput\u0012\u0015\n\rsr_display_st\u0018\n \u0001(\u0005\u0012\u0019\n\u0011save_proto_signal\u0018\u000b \u0001(\u0005\u0012\u0013\n\u000buse_last_mp\u0018\f \u0001(\u0005\u0012\u0015\n\ruse_last_sfbp\u0018\r \u0001(\u0005\u0012\u0013\n\u000bxp_pos_info\u0018\u000e \u0001(\f\":\n\rtotal_overall\u0012)\n\u0007overall\u0018\u0001 \u0003(\u000b2\u0018.xpilot.sr.proto.overallb\u0006proto3"}, new Descriptors.FileDescriptor[]{Primitives.getDescriptor(), LocalPose.getDescriptor(), StaticEnvironmentOuterClass.getDescriptor(), DynamicEnvironmentOuterClass.getDescriptor(), Posrtkimu.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.Overall.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Overall.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_overall_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_overall_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_overall_descriptor, new String[]{"LocalPose", "DynamicInfo", "StaticInfo", "MpInfo", "GpInfo", "SmInfo", "MfLaneInfo", "GaodeInfo", "BpInfo", "SrDisplaySt", "SaveProtoSignal", "UseLastMp", "UseLastSfbp", "XpPosInfo"});
        internal_static_xpilot_sr_proto_total_overall_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_xpilot_sr_proto_total_overall_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_total_overall_descriptor, new String[]{"Overall"});
        Primitives.getDescriptor();
        LocalPose.getDescriptor();
        StaticEnvironmentOuterClass.getDescriptor();
        DynamicEnvironmentOuterClass.getDescriptor();
        Posrtkimu.getDescriptor();
    }
}
