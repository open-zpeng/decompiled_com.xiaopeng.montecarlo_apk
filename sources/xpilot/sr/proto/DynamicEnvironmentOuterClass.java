package xpilot.sr.proto;

import com.autonavi.gbl.data.model.RegionCode;
import com.autonavi.gbl.pos.model.LocTrafficSignType;
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
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.search.SearchResultCode;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;
import xpilot.sr.proto.Primitives;
/* loaded from: classes4.dex */
public final class DynamicEnvironmentOuterClass {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_BPoutput_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_BPoutput_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_DynamicEnvironment_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_DynamicEnvironment_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_PredictIntention_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_PredictIntention_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_PredictPoint_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_PredictPoint_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_SfObject_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_SfObject_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_SfbpDynamicObject_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_SfbpDynamicObject_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_SfbpStaticObject_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_SfbpStaticObject_fieldAccessorTable;

    /* loaded from: classes4.dex */
    public interface BPoutputOrBuilder extends MessageOrBuilder {
        int getBpStatus();

        int getBpToSm1();

        int getBpToSm10();

        int getBpToSm11();

        int getBpToSm12();

        int getBpToSm13();

        int getBpToSm14();

        int getBpToSm15();

        int getBpToSm16();

        int getBpToSm17();

        int getBpToSm18();

        int getBpToSm19();

        int getBpToSm2();

        int getBpToSm20();

        int getBpToSm21();

        int getBpToSm22();

        int getBpToSm23();

        int getBpToSm24();

        int getBpToSm25();

        float getBpToSm26();

        float getBpToSm27();

        float getBpToSm28();

        float getBpToSm29();

        int getBpToSm3();

        float getBpToSm30();

        int getBpToSm4();

        int getBpToSm5();

        int getBpToSm6();

        int getBpToSm7();

        int getBpToSm8();

        int getBpToSm9();

        float getEgoRlFrontDistance();

        int getEmergency();

        int getGapSearchMode();

        int getHasTollStationAhead();

        int getHasTunnelAhead();

        int getHmiReminderType();

        int getLaneChangeCancelReason();

        int getLaneChangeStatus();

        float getLaneCurvature();

        int getLaneIndexFromRightToLeft();

        float getLaneWidth();

        int getNgpNotReadyReason();

        int getRiskLevel();

        int getSevereEmergency();

        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();

        float getSpeedLimit();

        int getStateRDALCCtrl();

        int getStaticObstacleAhead();

        boolean getTargetaccos();

        float getVehicleToLane();
    }

    /* loaded from: classes4.dex */
    public interface DynamicEnvironmentBufferOrBuilder extends MessageOrBuilder {
        DynamicEnvironment getDynamicEnvMsgs(int i);

        int getDynamicEnvMsgsCount();

        List<DynamicEnvironment> getDynamicEnvMsgsList();

        DynamicEnvironmentOrBuilder getDynamicEnvMsgsOrBuilder(int i);

        List<? extends DynamicEnvironmentOrBuilder> getDynamicEnvMsgsOrBuilderList();

        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();
    }

    /* loaded from: classes4.dex */
    public interface DynamicEnvironmentOrBuilder extends MessageOrBuilder {
        Primitives.EgoMotion getEgoMotion();

        Primitives.EgoMotionOrBuilder getEgoMotionOrBuilder();

        boolean getIsSplit();

        SfbpDynamicObject getSfbpObject(int i);

        int getSfbpObjectCount();

        List<SfbpDynamicObject> getSfbpObjectList();

        SfbpDynamicObjectOrBuilder getSfbpObjectOrBuilder(int i);

        List<? extends SfbpDynamicObjectOrBuilder> getSfbpObjectOrBuilderList();

        SfbpStaticObject getSfbpStaObject(int i);

        int getSfbpStaObjectCount();

        List<SfbpStaticObject> getSfbpStaObjectList();

        SfbpStaticObjectOrBuilder getSfbpStaObjectOrBuilder(int i);

        List<? extends SfbpStaticObjectOrBuilder> getSfbpStaObjectOrBuilderList();

        Primitives.Time getTimestamp();

        Primitives.TimeOrBuilder getTimestampOrBuilder();

        boolean hasEgoMotion();

        boolean hasTimestamp();
    }

    /* loaded from: classes4.dex */
    public interface PredictIntentionOrBuilder extends MessageOrBuilder {
        float getProbability();

        PredictPoint getTrajectory(int i);

        int getTrajectoryCount();

        List<PredictPoint> getTrajectoryList();

        PredictPointOrBuilder getTrajectoryOrBuilder(int i);

        List<? extends PredictPointOrBuilder> getTrajectoryOrBuilderList();
    }

    /* loaded from: classes4.dex */
    public interface PredictPointOrBuilder extends MessageOrBuilder {
        float getPredictedPose(int i);

        int getPredictedPoseCount();

        List<Float> getPredictedPoseList();

        Primitives.Time getTimestamp();

        Primitives.TimeOrBuilder getTimestampOrBuilder();

        float getUncertationRadius();

        boolean hasTimestamp();
    }

    /* loaded from: classes4.dex */
    public interface SfObjectOrBuilder extends MessageOrBuilder {
        Primitives.BrakeLight getBrakeLight();

        int getBrakeLightValue();

        int getId();

        int getIsp();

        float getLocalAcceleration(int i);

        int getLocalAccelerationCount();

        List<Float> getLocalAccelerationList();

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

        Primitives.SignalLight getSignalLight();

        int getSignalLightValue();

        Primitives.Size3D getSize();

        Primitives.Size3DOrBuilder getSizeOrBuilder();

        Primitives.ObjectType getType();

        int getTypeValue();

        int getXPUCDUVeh1StatusD();

        boolean hasSize();
    }

    /* loaded from: classes4.dex */
    public interface SfbpDynamicObjectOrBuilder extends MessageOrBuilder {
        PredictIntention getBpIntention(int i);

        int getBpIntentionCount();

        List<PredictIntention> getBpIntentionList();

        PredictIntentionOrBuilder getBpIntentionOrBuilder(int i);

        List<? extends PredictIntentionOrBuilder> getBpIntentionOrBuilderList();

        SfObject getSfSnapshot();

        SfObjectOrBuilder getSfSnapshotOrBuilder();

        boolean hasSfSnapshot();
    }

    /* loaded from: classes4.dex */
    public interface SfbpStaticObjectOrBuilder extends MessageOrBuilder {
        int getId();

        float getLocalPose(int i);

        int getLocalPoseCount();

        List<Float> getLocalPoseList();

        Primitives.Size3D getSize();

        Primitives.Size3DOrBuilder getSizeOrBuilder();

        Primitives.StaticObjectType getType();

        int getTypeValue();

        boolean hasSize();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private DynamicEnvironmentOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes4.dex */
    public static final class SfObject extends GeneratedMessageV3 implements SfObjectOrBuilder {
        public static final int BRAKE_LIGHT_FIELD_NUMBER = 5;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int ISP_FIELD_NUMBER = 12;
        public static final int LOCAL_ACCELERATION_FIELD_NUMBER = 8;
        public static final int LOCAL_POSE_FIELD_NUMBER = 6;
        public static final int LOCAL_POSE_SIGMA_FIELD_NUMBER = 9;
        public static final int LOCAL_VELOCITY_FIELD_NUMBER = 7;
        public static final int LOCAL_VELOCITY_SIGMA_FIELD_NUMBER = 10;
        public static final int SIGNAL_LIGHT_FIELD_NUMBER = 4;
        public static final int SIZE_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 3;
        public static final int XPU_CDU_VEH1_STATUSD_FIELD_NUMBER = 11;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int brakeLight_;
        private int id_;
        private int isp_;
        private int localAccelerationMemoizedSerializedSize;
        private List<Float> localAcceleration_;
        private int localPoseMemoizedSerializedSize;
        private int localPoseSigmaMemoizedSerializedSize;
        private List<Float> localPoseSigma_;
        private List<Float> localPose_;
        private int localVelocityMemoizedSerializedSize;
        private int localVelocitySigmaMemoizedSerializedSize;
        private List<Float> localVelocitySigma_;
        private List<Float> localVelocity_;
        private byte memoizedIsInitialized;
        private int signalLight_;
        private Primitives.Size3D size_;
        private int type_;
        private int xPUCDUVeh1StatusD_;
        private static final SfObject DEFAULT_INSTANCE = new SfObject();
        private static final Parser<SfObject> PARSER = new AbstractParser<SfObject>() { // from class: xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObject.1
            @Override // com.google.protobuf.Parser
            public SfObject parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SfObject(codedInputStream, extensionRegistryLite);
            }
        };

        private SfObject(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.localPoseMemoizedSerializedSize = -1;
            this.localVelocityMemoizedSerializedSize = -1;
            this.localAccelerationMemoizedSerializedSize = -1;
            this.localPoseSigmaMemoizedSerializedSize = -1;
            this.localVelocitySigmaMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private SfObject() {
            this.localPoseMemoizedSerializedSize = -1;
            this.localVelocityMemoizedSerializedSize = -1;
            this.localAccelerationMemoizedSerializedSize = -1;
            this.localPoseSigmaMemoizedSerializedSize = -1;
            this.localVelocitySigmaMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.id_ = 0;
            this.type_ = 0;
            this.signalLight_ = 0;
            this.brakeLight_ = 0;
            this.localPose_ = Collections.emptyList();
            this.localVelocity_ = Collections.emptyList();
            this.localAcceleration_ = Collections.emptyList();
            this.localPoseSigma_ = Collections.emptyList();
            this.localVelocitySigma_ = Collections.emptyList();
            this.xPUCDUVeh1StatusD_ = 0;
            this.isp_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
        private SfObject(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r3 = 512;
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
                                this.id_ = codedInputStream.readUInt32();
                                continue;
                            case 18:
                                Primitives.Size3D.Builder builder = this.size_ != null ? this.size_.toBuilder() : null;
                                this.size_ = (Primitives.Size3D) codedInputStream.readMessage(Primitives.Size3D.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.size_);
                                    this.size_ = builder.buildPartial();
                                } else {
                                    continue;
                                }
                            case 24:
                                this.type_ = codedInputStream.readEnum();
                                continue;
                            case 32:
                                this.signalLight_ = codedInputStream.readEnum();
                                continue;
                            case 40:
                                this.brakeLight_ = codedInputStream.readEnum();
                                continue;
                            case 50:
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
                            case 53:
                                if (!(z2 & true)) {
                                    this.localPose_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localPose_.add(Float.valueOf(codedInputStream.readFloat()));
                                continue;
                            case 58:
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
                            case 61:
                                if (!(z2 & true)) {
                                    this.localVelocity_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localVelocity_.add(Float.valueOf(codedInputStream.readFloat()));
                                continue;
                            case 66:
                                int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localAcceleration_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localAcceleration_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit3);
                                continue;
                                break;
                            case 69:
                                if (!(z2 & true)) {
                                    this.localAcceleration_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localAcceleration_.add(Float.valueOf(codedInputStream.readFloat()));
                                continue;
                            case 74:
                                int pushLimit4 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localPoseSigma_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localPoseSigma_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit4);
                                continue;
                                break;
                            case 77:
                                if (!(z2 & true)) {
                                    this.localPoseSigma_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localPoseSigma_.add(Float.valueOf(codedInputStream.readFloat()));
                                continue;
                            case 82:
                                int pushLimit5 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localVelocitySigma_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localVelocitySigma_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit5);
                                continue;
                                break;
                            case 85:
                                if (!(z2 & true)) {
                                    this.localVelocitySigma_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localVelocitySigma_.add(Float.valueOf(codedInputStream.readFloat()));
                                continue;
                            case 88:
                                this.xPUCDUVeh1StatusD_ = codedInputStream.readInt32();
                                continue;
                            case 96:
                                this.isp_ = codedInputStream.readInt32();
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
                        this.localAcceleration_ = Collections.unmodifiableList(this.localAcceleration_);
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
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfObject_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfObject_fieldAccessorTable.ensureFieldAccessorsInitialized(SfObject.class, Builder.class);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public boolean hasSize() {
            return this.size_ != null;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public Primitives.Size3D getSize() {
            Primitives.Size3D size3D = this.size_;
            return size3D == null ? Primitives.Size3D.getDefaultInstance() : size3D;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public Primitives.Size3DOrBuilder getSizeOrBuilder() {
            return getSize();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public Primitives.ObjectType getType() {
            Primitives.ObjectType valueOf = Primitives.ObjectType.valueOf(this.type_);
            return valueOf == null ? Primitives.ObjectType.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getSignalLightValue() {
            return this.signalLight_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public Primitives.SignalLight getSignalLight() {
            Primitives.SignalLight valueOf = Primitives.SignalLight.valueOf(this.signalLight_);
            return valueOf == null ? Primitives.SignalLight.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getBrakeLightValue() {
            return this.brakeLight_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public Primitives.BrakeLight getBrakeLight() {
            Primitives.BrakeLight valueOf = Primitives.BrakeLight.valueOf(this.brakeLight_);
            return valueOf == null ? Primitives.BrakeLight.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public List<Float> getLocalPoseList() {
            return this.localPose_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getLocalPoseCount() {
            return this.localPose_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public float getLocalPose(int i) {
            return this.localPose_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public List<Float> getLocalVelocityList() {
            return this.localVelocity_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getLocalVelocityCount() {
            return this.localVelocity_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public float getLocalVelocity(int i) {
            return this.localVelocity_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public List<Float> getLocalAccelerationList() {
            return this.localAcceleration_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getLocalAccelerationCount() {
            return this.localAcceleration_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public float getLocalAcceleration(int i) {
            return this.localAcceleration_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public List<Float> getLocalPoseSigmaList() {
            return this.localPoseSigma_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getLocalPoseSigmaCount() {
            return this.localPoseSigma_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public float getLocalPoseSigma(int i) {
            return this.localPoseSigma_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public List<Float> getLocalVelocitySigmaList() {
            return this.localVelocitySigma_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getLocalVelocitySigmaCount() {
            return this.localVelocitySigma_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public float getLocalVelocitySigma(int i) {
            return this.localVelocitySigma_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getXPUCDUVeh1StatusD() {
            return this.xPUCDUVeh1StatusD_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
        public int getIsp() {
            return this.isp_;
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
            int i = this.id_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (this.size_ != null) {
                codedOutputStream.writeMessage(2, getSize());
            }
            if (this.type_ != Primitives.ObjectType.OBJ_TYPE_UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(3, this.type_);
            }
            if (this.signalLight_ != Primitives.SignalLight.SIGNAL_LIGHT_UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(4, this.signalLight_);
            }
            if (this.brakeLight_ != Primitives.BrakeLight.BRAKE_LIGHT_UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(5, this.brakeLight_);
            }
            if (getLocalPoseList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(50);
                codedOutputStream.writeUInt32NoTag(this.localPoseMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.localPose_.size(); i2++) {
                codedOutputStream.writeFloatNoTag(this.localPose_.get(i2).floatValue());
            }
            if (getLocalVelocityList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(58);
                codedOutputStream.writeUInt32NoTag(this.localVelocityMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.localVelocity_.size(); i3++) {
                codedOutputStream.writeFloatNoTag(this.localVelocity_.get(i3).floatValue());
            }
            if (getLocalAccelerationList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(66);
                codedOutputStream.writeUInt32NoTag(this.localAccelerationMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.localAcceleration_.size(); i4++) {
                codedOutputStream.writeFloatNoTag(this.localAcceleration_.get(i4).floatValue());
            }
            if (getLocalPoseSigmaList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(74);
                codedOutputStream.writeUInt32NoTag(this.localPoseSigmaMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.localPoseSigma_.size(); i5++) {
                codedOutputStream.writeFloatNoTag(this.localPoseSigma_.get(i5).floatValue());
            }
            if (getLocalVelocitySigmaList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(82);
                codedOutputStream.writeUInt32NoTag(this.localVelocitySigmaMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.localVelocitySigma_.size(); i6++) {
                codedOutputStream.writeFloatNoTag(this.localVelocitySigma_.get(i6).floatValue());
            }
            int i7 = this.xPUCDUVeh1StatusD_;
            if (i7 != 0) {
                codedOutputStream.writeInt32(11, i7);
            }
            int i8 = this.isp_;
            if (i8 != 0) {
                codedOutputStream.writeInt32(12, i8);
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
            if (this.size_ != null) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(2, getSize());
            }
            if (this.type_ != Primitives.ObjectType.OBJ_TYPE_UNKNOWN.getNumber()) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(3, this.type_);
            }
            if (this.signalLight_ != Primitives.SignalLight.SIGNAL_LIGHT_UNKNOWN.getNumber()) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(4, this.signalLight_);
            }
            if (this.brakeLight_ != Primitives.BrakeLight.BRAKE_LIGHT_UNKNOWN.getNumber()) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(5, this.brakeLight_);
            }
            int size = getLocalPoseList().size() * 4;
            int i3 = computeUInt32Size + size;
            if (!getLocalPoseList().isEmpty()) {
                i3 = i3 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.localPoseMemoizedSerializedSize = size;
            int size2 = getLocalVelocityList().size() * 4;
            int i4 = i3 + size2;
            if (!getLocalVelocityList().isEmpty()) {
                i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(size2);
            }
            this.localVelocityMemoizedSerializedSize = size2;
            int size3 = getLocalAccelerationList().size() * 4;
            int i5 = i4 + size3;
            if (!getLocalAccelerationList().isEmpty()) {
                i5 = i5 + 1 + CodedOutputStream.computeInt32SizeNoTag(size3);
            }
            this.localAccelerationMemoizedSerializedSize = size3;
            int size4 = getLocalPoseSigmaList().size() * 4;
            int i6 = i5 + size4;
            if (!getLocalPoseSigmaList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(size4);
            }
            this.localPoseSigmaMemoizedSerializedSize = size4;
            int size5 = getLocalVelocitySigmaList().size() * 4;
            int i7 = i6 + size5;
            if (!getLocalVelocitySigmaList().isEmpty()) {
                i7 = i7 + 1 + CodedOutputStream.computeInt32SizeNoTag(size5);
            }
            this.localVelocitySigmaMemoizedSerializedSize = size5;
            int i8 = this.xPUCDUVeh1StatusD_;
            if (i8 != 0) {
                i7 += CodedOutputStream.computeInt32Size(11, i8);
            }
            int i9 = this.isp_;
            if (i9 != 0) {
                i7 += CodedOutputStream.computeInt32Size(12, i9);
            }
            int serializedSize = i7 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SfObject)) {
                return super.equals(obj);
            }
            SfObject sfObject = (SfObject) obj;
            boolean z = (getId() == sfObject.getId()) && hasSize() == sfObject.hasSize();
            if (hasSize()) {
                z = z && getSize().equals(sfObject.getSize());
            }
            return ((((((((((z && this.type_ == sfObject.type_) && this.signalLight_ == sfObject.signalLight_) && this.brakeLight_ == sfObject.brakeLight_) && getLocalPoseList().equals(sfObject.getLocalPoseList())) && getLocalVelocityList().equals(sfObject.getLocalVelocityList())) && getLocalAccelerationList().equals(sfObject.getLocalAccelerationList())) && getLocalPoseSigmaList().equals(sfObject.getLocalPoseSigmaList())) && getLocalVelocitySigmaList().equals(sfObject.getLocalVelocitySigmaList())) && getXPUCDUVeh1StatusD() == sfObject.getXPUCDUVeh1StatusD()) && getIsp() == sfObject.getIsp()) && this.unknownFields.equals(sfObject.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getId();
            if (hasSize()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getSize().hashCode();
            }
            int i = (((((((((((hashCode * 37) + 3) * 53) + this.type_) * 37) + 4) * 53) + this.signalLight_) * 37) + 5) * 53) + this.brakeLight_;
            if (getLocalPoseCount() > 0) {
                i = (((i * 37) + 6) * 53) + getLocalPoseList().hashCode();
            }
            if (getLocalVelocityCount() > 0) {
                i = (((i * 37) + 7) * 53) + getLocalVelocityList().hashCode();
            }
            if (getLocalAccelerationCount() > 0) {
                i = (((i * 37) + 8) * 53) + getLocalAccelerationList().hashCode();
            }
            if (getLocalPoseSigmaCount() > 0) {
                i = (((i * 37) + 9) * 53) + getLocalPoseSigmaList().hashCode();
            }
            if (getLocalVelocitySigmaCount() > 0) {
                i = (((i * 37) + 10) * 53) + getLocalVelocitySigmaList().hashCode();
            }
            int xPUCDUVeh1StatusD = (((((((((i * 37) + 11) * 53) + getXPUCDUVeh1StatusD()) * 37) + 12) * 53) + getIsp()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = xPUCDUVeh1StatusD;
            return xPUCDUVeh1StatusD;
        }

        public static SfObject parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SfObject parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SfObject parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SfObject parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SfObject parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SfObject parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SfObject parseFrom(InputStream inputStream) throws IOException {
            return (SfObject) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SfObject parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SfObject) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SfObject parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SfObject) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SfObject parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SfObject) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SfObject parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SfObject) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SfObject parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SfObject) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SfObject sfObject) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sfObject);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SfObjectOrBuilder {
            private int bitField0_;
            private int brakeLight_;
            private int id_;
            private int isp_;
            private List<Float> localAcceleration_;
            private List<Float> localPoseSigma_;
            private List<Float> localPose_;
            private List<Float> localVelocitySigma_;
            private List<Float> localVelocity_;
            private int signalLight_;
            private SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> sizeBuilder_;
            private Primitives.Size3D size_;
            private int type_;
            private int xPUCDUVeh1StatusD_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfObject_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfObject_fieldAccessorTable.ensureFieldAccessorsInitialized(SfObject.class, Builder.class);
            }

            private Builder() {
                this.size_ = null;
                this.type_ = 0;
                this.signalLight_ = 0;
                this.brakeLight_ = 0;
                this.localPose_ = Collections.emptyList();
                this.localVelocity_ = Collections.emptyList();
                this.localAcceleration_ = Collections.emptyList();
                this.localPoseSigma_ = Collections.emptyList();
                this.localVelocitySigma_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.size_ = null;
                this.type_ = 0;
                this.signalLight_ = 0;
                this.brakeLight_ = 0;
                this.localPose_ = Collections.emptyList();
                this.localVelocity_ = Collections.emptyList();
                this.localAcceleration_ = Collections.emptyList();
                this.localPoseSigma_ = Collections.emptyList();
                this.localVelocitySigma_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SfObject.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.id_ = 0;
                if (this.sizeBuilder_ == null) {
                    this.size_ = null;
                } else {
                    this.size_ = null;
                    this.sizeBuilder_ = null;
                }
                this.type_ = 0;
                this.signalLight_ = 0;
                this.brakeLight_ = 0;
                this.localPose_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.localVelocity_ = Collections.emptyList();
                this.bitField0_ &= -65;
                this.localAcceleration_ = Collections.emptyList();
                this.bitField0_ &= -129;
                this.localPoseSigma_ = Collections.emptyList();
                this.bitField0_ &= -257;
                this.localVelocitySigma_ = Collections.emptyList();
                this.bitField0_ &= -513;
                this.xPUCDUVeh1StatusD_ = 0;
                this.isp_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfObject_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SfObject getDefaultInstanceForType() {
                return SfObject.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SfObject build() {
                SfObject buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SfObject buildPartial() {
                SfObject sfObject = new SfObject(this);
                int i = this.bitField0_;
                sfObject.id_ = this.id_;
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    sfObject.size_ = this.size_;
                } else {
                    sfObject.size_ = singleFieldBuilderV3.build();
                }
                sfObject.type_ = this.type_;
                sfObject.signalLight_ = this.signalLight_;
                sfObject.brakeLight_ = this.brakeLight_;
                if ((this.bitField0_ & 32) == 32) {
                    this.localPose_ = Collections.unmodifiableList(this.localPose_);
                    this.bitField0_ &= -33;
                }
                sfObject.localPose_ = this.localPose_;
                if ((this.bitField0_ & 64) == 64) {
                    this.localVelocity_ = Collections.unmodifiableList(this.localVelocity_);
                    this.bitField0_ &= -65;
                }
                sfObject.localVelocity_ = this.localVelocity_;
                if ((this.bitField0_ & 128) == 128) {
                    this.localAcceleration_ = Collections.unmodifiableList(this.localAcceleration_);
                    this.bitField0_ &= -129;
                }
                sfObject.localAcceleration_ = this.localAcceleration_;
                if ((this.bitField0_ & 256) == 256) {
                    this.localPoseSigma_ = Collections.unmodifiableList(this.localPoseSigma_);
                    this.bitField0_ &= -257;
                }
                sfObject.localPoseSigma_ = this.localPoseSigma_;
                if ((this.bitField0_ & 512) == 512) {
                    this.localVelocitySigma_ = Collections.unmodifiableList(this.localVelocitySigma_);
                    this.bitField0_ &= -513;
                }
                sfObject.localVelocitySigma_ = this.localVelocitySigma_;
                sfObject.xPUCDUVeh1StatusD_ = this.xPUCDUVeh1StatusD_;
                sfObject.isp_ = this.isp_;
                sfObject.bitField0_ = 0;
                onBuilt();
                return sfObject;
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
                if (message instanceof SfObject) {
                    return mergeFrom((SfObject) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SfObject sfObject) {
                if (sfObject == SfObject.getDefaultInstance()) {
                    return this;
                }
                if (sfObject.getId() != 0) {
                    setId(sfObject.getId());
                }
                if (sfObject.hasSize()) {
                    mergeSize(sfObject.getSize());
                }
                if (sfObject.type_ != 0) {
                    setTypeValue(sfObject.getTypeValue());
                }
                if (sfObject.signalLight_ != 0) {
                    setSignalLightValue(sfObject.getSignalLightValue());
                }
                if (sfObject.brakeLight_ != 0) {
                    setBrakeLightValue(sfObject.getBrakeLightValue());
                }
                if (!sfObject.localPose_.isEmpty()) {
                    if (this.localPose_.isEmpty()) {
                        this.localPose_ = sfObject.localPose_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureLocalPoseIsMutable();
                        this.localPose_.addAll(sfObject.localPose_);
                    }
                    onChanged();
                }
                if (!sfObject.localVelocity_.isEmpty()) {
                    if (this.localVelocity_.isEmpty()) {
                        this.localVelocity_ = sfObject.localVelocity_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureLocalVelocityIsMutable();
                        this.localVelocity_.addAll(sfObject.localVelocity_);
                    }
                    onChanged();
                }
                if (!sfObject.localAcceleration_.isEmpty()) {
                    if (this.localAcceleration_.isEmpty()) {
                        this.localAcceleration_ = sfObject.localAcceleration_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureLocalAccelerationIsMutable();
                        this.localAcceleration_.addAll(sfObject.localAcceleration_);
                    }
                    onChanged();
                }
                if (!sfObject.localPoseSigma_.isEmpty()) {
                    if (this.localPoseSigma_.isEmpty()) {
                        this.localPoseSigma_ = sfObject.localPoseSigma_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureLocalPoseSigmaIsMutable();
                        this.localPoseSigma_.addAll(sfObject.localPoseSigma_);
                    }
                    onChanged();
                }
                if (!sfObject.localVelocitySigma_.isEmpty()) {
                    if (this.localVelocitySigma_.isEmpty()) {
                        this.localVelocitySigma_ = sfObject.localVelocitySigma_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureLocalVelocitySigmaIsMutable();
                        this.localVelocitySigma_.addAll(sfObject.localVelocitySigma_);
                    }
                    onChanged();
                }
                if (sfObject.getXPUCDUVeh1StatusD() != 0) {
                    setXPUCDUVeh1StatusD(sfObject.getXPUCDUVeh1StatusD());
                }
                if (sfObject.getIsp() != 0) {
                    setIsp(sfObject.getIsp());
                }
                mergeUnknownFields(sfObject.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObject.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObject.access$2000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$SfObject r3 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObject) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$SfObject r4 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObject) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObject.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.DynamicEnvironmentOuterClass$SfObject$Builder");
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
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

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public boolean hasSize() {
                return (this.sizeBuilder_ == null && this.size_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public Primitives.Size3D getSize() {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Size3D size3D = this.size_;
                    return size3D == null ? Primitives.Size3D.getDefaultInstance() : size3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setSize(Primitives.Size3D size3D) {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(size3D);
                } else if (size3D == null) {
                    throw new NullPointerException();
                } else {
                    this.size_ = size3D;
                    onChanged();
                }
                return this;
            }

            public Builder setSize(Primitives.Size3D.Builder builder) {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.size_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeSize(Primitives.Size3D size3D) {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Size3D size3D2 = this.size_;
                    if (size3D2 != null) {
                        this.size_ = Primitives.Size3D.newBuilder(size3D2).mergeFrom(size3D).buildPartial();
                    } else {
                        this.size_ = size3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(size3D);
                }
                return this;
            }

            public Builder clearSize() {
                if (this.sizeBuilder_ == null) {
                    this.size_ = null;
                    onChanged();
                } else {
                    this.size_ = null;
                    this.sizeBuilder_ = null;
                }
                return this;
            }

            public Primitives.Size3D.Builder getSizeBuilder() {
                onChanged();
                return getSizeFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public Primitives.Size3DOrBuilder getSizeOrBuilder() {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Size3D size3D = this.size_;
                return size3D == null ? Primitives.Size3D.getDefaultInstance() : size3D;
            }

            private SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> getSizeFieldBuilder() {
                if (this.sizeBuilder_ == null) {
                    this.sizeBuilder_ = new SingleFieldBuilderV3<>(getSize(), getParentForChildren(), isClean());
                    this.size_ = null;
                }
                return this.sizeBuilder_;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public Primitives.ObjectType getType() {
                Primitives.ObjectType valueOf = Primitives.ObjectType.valueOf(this.type_);
                return valueOf == null ? Primitives.ObjectType.UNRECOGNIZED : valueOf;
            }

            public Builder setType(Primitives.ObjectType objectType) {
                if (objectType == null) {
                    throw new NullPointerException();
                }
                this.type_ = objectType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getSignalLightValue() {
                return this.signalLight_;
            }

            public Builder setSignalLightValue(int i) {
                this.signalLight_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public Primitives.SignalLight getSignalLight() {
                Primitives.SignalLight valueOf = Primitives.SignalLight.valueOf(this.signalLight_);
                return valueOf == null ? Primitives.SignalLight.UNRECOGNIZED : valueOf;
            }

            public Builder setSignalLight(Primitives.SignalLight signalLight) {
                if (signalLight == null) {
                    throw new NullPointerException();
                }
                this.signalLight_ = signalLight.getNumber();
                onChanged();
                return this;
            }

            public Builder clearSignalLight() {
                this.signalLight_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getBrakeLightValue() {
                return this.brakeLight_;
            }

            public Builder setBrakeLightValue(int i) {
                this.brakeLight_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public Primitives.BrakeLight getBrakeLight() {
                Primitives.BrakeLight valueOf = Primitives.BrakeLight.valueOf(this.brakeLight_);
                return valueOf == null ? Primitives.BrakeLight.UNRECOGNIZED : valueOf;
            }

            public Builder setBrakeLight(Primitives.BrakeLight brakeLight) {
                if (brakeLight == null) {
                    throw new NullPointerException();
                }
                this.brakeLight_ = brakeLight.getNumber();
                onChanged();
                return this;
            }

            public Builder clearBrakeLight() {
                this.brakeLight_ = 0;
                onChanged();
                return this;
            }

            private void ensureLocalPoseIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.localPose_ = new ArrayList(this.localPose_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public List<Float> getLocalPoseList() {
                return Collections.unmodifiableList(this.localPose_);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getLocalPoseCount() {
                return this.localPose_.size();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
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
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            private void ensureLocalVelocityIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.localVelocity_ = new ArrayList(this.localVelocity_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public List<Float> getLocalVelocityList() {
                return Collections.unmodifiableList(this.localVelocity_);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getLocalVelocityCount() {
                return this.localVelocity_.size();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
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
                this.bitField0_ &= -65;
                onChanged();
                return this;
            }

            private void ensureLocalAccelerationIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.localAcceleration_ = new ArrayList(this.localAcceleration_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public List<Float> getLocalAccelerationList() {
                return Collections.unmodifiableList(this.localAcceleration_);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getLocalAccelerationCount() {
                return this.localAcceleration_.size();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public float getLocalAcceleration(int i) {
                return this.localAcceleration_.get(i).floatValue();
            }

            public Builder setLocalAcceleration(int i, float f) {
                ensureLocalAccelerationIsMutable();
                this.localAcceleration_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addLocalAcceleration(float f) {
                ensureLocalAccelerationIsMutable();
                this.localAcceleration_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addAllLocalAcceleration(Iterable<? extends Float> iterable) {
                ensureLocalAccelerationIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.localAcceleration_);
                onChanged();
                return this;
            }

            public Builder clearLocalAcceleration() {
                this.localAcceleration_ = Collections.emptyList();
                this.bitField0_ &= -129;
                onChanged();
                return this;
            }

            private void ensureLocalPoseSigmaIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.localPoseSigma_ = new ArrayList(this.localPoseSigma_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public List<Float> getLocalPoseSigmaList() {
                return Collections.unmodifiableList(this.localPoseSigma_);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getLocalPoseSigmaCount() {
                return this.localPoseSigma_.size();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
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
                this.bitField0_ &= -257;
                onChanged();
                return this;
            }

            private void ensureLocalVelocitySigmaIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.localVelocitySigma_ = new ArrayList(this.localVelocitySigma_);
                    this.bitField0_ |= 512;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public List<Float> getLocalVelocitySigmaList() {
                return Collections.unmodifiableList(this.localVelocitySigma_);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getLocalVelocitySigmaCount() {
                return this.localVelocitySigma_.size();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
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
                this.bitField0_ &= -513;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getXPUCDUVeh1StatusD() {
                return this.xPUCDUVeh1StatusD_;
            }

            public Builder setXPUCDUVeh1StatusD(int i) {
                this.xPUCDUVeh1StatusD_ = i;
                onChanged();
                return this;
            }

            public Builder clearXPUCDUVeh1StatusD() {
                this.xPUCDUVeh1StatusD_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfObjectOrBuilder
            public int getIsp() {
                return this.isp_;
            }

            public Builder setIsp(int i) {
                this.isp_ = i;
                onChanged();
                return this;
            }

            public Builder clearIsp() {
                this.isp_ = 0;
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

        public static SfObject getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SfObject> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SfObject> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SfObject getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class PredictPoint extends GeneratedMessageV3 implements PredictPointOrBuilder {
        private static final PredictPoint DEFAULT_INSTANCE = new PredictPoint();
        private static final Parser<PredictPoint> PARSER = new AbstractParser<PredictPoint>() { // from class: xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPoint.1
            @Override // com.google.protobuf.Parser
            public PredictPoint parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PredictPoint(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PREDICTED_POSE_FIELD_NUMBER = 2;
        public static final int TIMESTAMP_FIELD_NUMBER = 1;
        public static final int UNCERTATION_RADIUS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int predictedPoseMemoizedSerializedSize;
        private List<Float> predictedPose_;
        private Primitives.Time timestamp_;
        private float uncertationRadius_;

        private PredictPoint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.predictedPoseMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private PredictPoint() {
            this.predictedPoseMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.predictedPose_ = Collections.emptyList();
            this.uncertationRadius_ = 0.0f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PredictPoint(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.predictedPose_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.predictedPose_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 21) {
                                if (!(z2 & true)) {
                                    this.predictedPose_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.predictedPose_.add(Float.valueOf(codedInputStream.readFloat()));
                            } else if (readTag == 29) {
                                this.uncertationRadius_ = codedInputStream.readFloat();
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
                        this.predictedPose_ = Collections.unmodifiableList(this.predictedPose_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictPoint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(PredictPoint.class, Builder.class);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
        public boolean hasTimestamp() {
            return this.timestamp_ != null;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
        public Primitives.Time getTimestamp() {
            Primitives.Time time = this.timestamp_;
            return time == null ? Primitives.Time.getDefaultInstance() : time;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
        public Primitives.TimeOrBuilder getTimestampOrBuilder() {
            return getTimestamp();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
        public List<Float> getPredictedPoseList() {
            return this.predictedPose_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
        public int getPredictedPoseCount() {
            return this.predictedPose_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
        public float getPredictedPose(int i) {
            return this.predictedPose_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
        public float getUncertationRadius() {
            return this.uncertationRadius_;
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
            if (this.timestamp_ != null) {
                codedOutputStream.writeMessage(1, getTimestamp());
            }
            if (getPredictedPoseList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(18);
                codedOutputStream.writeUInt32NoTag(this.predictedPoseMemoizedSerializedSize);
            }
            for (int i = 0; i < this.predictedPose_.size(); i++) {
                codedOutputStream.writeFloatNoTag(this.predictedPose_.get(i).floatValue());
            }
            float f = this.uncertationRadius_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(3, f);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.timestamp_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getTimestamp()) : 0;
            int size = getPredictedPoseList().size() * 4;
            int i2 = computeMessageSize + size;
            if (!getPredictedPoseList().isEmpty()) {
                i2 = i2 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.predictedPoseMemoizedSerializedSize = size;
            float f = this.uncertationRadius_;
            if (f != 0.0f) {
                i2 += CodedOutputStream.computeFloatSize(3, f);
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
            if (!(obj instanceof PredictPoint)) {
                return super.equals(obj);
            }
            PredictPoint predictPoint = (PredictPoint) obj;
            boolean z = hasTimestamp() == predictPoint.hasTimestamp();
            if (hasTimestamp()) {
                z = z && getTimestamp().equals(predictPoint.getTimestamp());
            }
            return ((z && getPredictedPoseList().equals(predictPoint.getPredictedPoseList())) && Float.floatToIntBits(getUncertationRadius()) == Float.floatToIntBits(predictPoint.getUncertationRadius())) && this.unknownFields.equals(predictPoint.unknownFields);
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
            if (getPredictedPoseCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getPredictedPoseList().hashCode();
            }
            int floatToIntBits = (((((hashCode * 37) + 3) * 53) + Float.floatToIntBits(getUncertationRadius())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = floatToIntBits;
            return floatToIntBits;
        }

        public static PredictPoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static PredictPoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PredictPoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PredictPoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PredictPoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PredictPoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PredictPoint parseFrom(InputStream inputStream) throws IOException {
            return (PredictPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PredictPoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PredictPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PredictPoint parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PredictPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PredictPoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PredictPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PredictPoint parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PredictPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PredictPoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PredictPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PredictPoint predictPoint) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(predictPoint);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PredictPointOrBuilder {
            private int bitField0_;
            private List<Float> predictedPose_;
            private SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> timestampBuilder_;
            private Primitives.Time timestamp_;
            private float uncertationRadius_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictPoint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(PredictPoint.class, Builder.class);
            }

            private Builder() {
                this.timestamp_ = null;
                this.predictedPose_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.timestamp_ = null;
                this.predictedPose_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = PredictPoint.alwaysUseFieldBuilders;
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
                this.predictedPose_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.uncertationRadius_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictPoint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PredictPoint getDefaultInstanceForType() {
                return PredictPoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PredictPoint build() {
                PredictPoint buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PredictPoint buildPartial() {
                PredictPoint predictPoint = new PredictPoint(this);
                int i = this.bitField0_;
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    predictPoint.timestamp_ = this.timestamp_;
                } else {
                    predictPoint.timestamp_ = singleFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 2) == 2) {
                    this.predictedPose_ = Collections.unmodifiableList(this.predictedPose_);
                    this.bitField0_ &= -3;
                }
                predictPoint.predictedPose_ = this.predictedPose_;
                predictPoint.uncertationRadius_ = this.uncertationRadius_;
                predictPoint.bitField0_ = 0;
                onBuilt();
                return predictPoint;
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
                if (message instanceof PredictPoint) {
                    return mergeFrom((PredictPoint) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(PredictPoint predictPoint) {
                if (predictPoint == PredictPoint.getDefaultInstance()) {
                    return this;
                }
                if (predictPoint.hasTimestamp()) {
                    mergeTimestamp(predictPoint.getTimestamp());
                }
                if (!predictPoint.predictedPose_.isEmpty()) {
                    if (this.predictedPose_.isEmpty()) {
                        this.predictedPose_ = predictPoint.predictedPose_;
                        this.bitField0_ &= -3;
                    } else {
                        ensurePredictedPoseIsMutable();
                        this.predictedPose_.addAll(predictPoint.predictedPose_);
                    }
                    onChanged();
                }
                if (predictPoint.getUncertationRadius() != 0.0f) {
                    setUncertationRadius(predictPoint.getUncertationRadius());
                }
                mergeUnknownFields(predictPoint.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPoint.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPoint.access$3300()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$PredictPoint r3 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPoint) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$PredictPoint r4 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPoint) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPoint.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.DynamicEnvironmentOuterClass$PredictPoint$Builder");
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
            public boolean hasTimestamp() {
                return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
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

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
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

            private void ensurePredictedPoseIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.predictedPose_ = new ArrayList(this.predictedPose_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
            public List<Float> getPredictedPoseList() {
                return Collections.unmodifiableList(this.predictedPose_);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
            public int getPredictedPoseCount() {
                return this.predictedPose_.size();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
            public float getPredictedPose(int i) {
                return this.predictedPose_.get(i).floatValue();
            }

            public Builder setPredictedPose(int i, float f) {
                ensurePredictedPoseIsMutable();
                this.predictedPose_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addPredictedPose(float f) {
                ensurePredictedPoseIsMutable();
                this.predictedPose_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addAllPredictedPose(Iterable<? extends Float> iterable) {
                ensurePredictedPoseIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.predictedPose_);
                onChanged();
                return this;
            }

            public Builder clearPredictedPose() {
                this.predictedPose_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictPointOrBuilder
            public float getUncertationRadius() {
                return this.uncertationRadius_;
            }

            public Builder setUncertationRadius(float f) {
                this.uncertationRadius_ = f;
                onChanged();
                return this;
            }

            public Builder clearUncertationRadius() {
                this.uncertationRadius_ = 0.0f;
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

        public static PredictPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PredictPoint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PredictPoint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PredictPoint getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class PredictIntention extends GeneratedMessageV3 implements PredictIntentionOrBuilder {
        private static final PredictIntention DEFAULT_INSTANCE = new PredictIntention();
        private static final Parser<PredictIntention> PARSER = new AbstractParser<PredictIntention>() { // from class: xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntention.1
            @Override // com.google.protobuf.Parser
            public PredictIntention parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PredictIntention(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PROBABILITY_FIELD_NUMBER = 1;
        public static final int TRAJECTORY_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private float probability_;
        private List<PredictPoint> trajectory_;

        private PredictIntention(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private PredictIntention() {
            this.memoizedIsInitialized = (byte) -1;
            this.probability_ = 0.0f;
            this.trajectory_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private PredictIntention(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 13) {
                                this.probability_ = codedInputStream.readFloat();
                            } else if (readTag == 18) {
                                if (!(z2 & true)) {
                                    this.trajectory_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.trajectory_.add(codedInputStream.readMessage(PredictPoint.parser(), extensionRegistryLite));
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
                        this.trajectory_ = Collections.unmodifiableList(this.trajectory_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictIntention_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictIntention_fieldAccessorTable.ensureFieldAccessorsInitialized(PredictIntention.class, Builder.class);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
        public float getProbability() {
            return this.probability_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
        public List<PredictPoint> getTrajectoryList() {
            return this.trajectory_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
        public List<? extends PredictPointOrBuilder> getTrajectoryOrBuilderList() {
            return this.trajectory_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
        public int getTrajectoryCount() {
            return this.trajectory_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
        public PredictPoint getTrajectory(int i) {
            return this.trajectory_.get(i);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
        public PredictPointOrBuilder getTrajectoryOrBuilder(int i) {
            return this.trajectory_.get(i);
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
            float f = this.probability_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            for (int i = 0; i < this.trajectory_.size(); i++) {
                codedOutputStream.writeMessage(2, this.trajectory_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            float f = this.probability_;
            int computeFloatSize = f != 0.0f ? CodedOutputStream.computeFloatSize(1, f) + 0 : 0;
            for (int i2 = 0; i2 < this.trajectory_.size(); i2++) {
                computeFloatSize += CodedOutputStream.computeMessageSize(2, this.trajectory_.get(i2));
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
            if (!(obj instanceof PredictIntention)) {
                return super.equals(obj);
            }
            PredictIntention predictIntention = (PredictIntention) obj;
            return ((Float.floatToIntBits(getProbability()) == Float.floatToIntBits(predictIntention.getProbability())) && getTrajectoryList().equals(predictIntention.getTrajectoryList())) && this.unknownFields.equals(predictIntention.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getProbability());
            if (getTrajectoryCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getTrajectoryList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static PredictIntention parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static PredictIntention parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PredictIntention parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PredictIntention parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PredictIntention parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PredictIntention parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PredictIntention parseFrom(InputStream inputStream) throws IOException {
            return (PredictIntention) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PredictIntention parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PredictIntention) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PredictIntention parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PredictIntention) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PredictIntention parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PredictIntention) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PredictIntention parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PredictIntention) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PredictIntention parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PredictIntention) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PredictIntention predictIntention) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(predictIntention);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PredictIntentionOrBuilder {
            private int bitField0_;
            private float probability_;
            private RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> trajectoryBuilder_;
            private List<PredictPoint> trajectory_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictIntention_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictIntention_fieldAccessorTable.ensureFieldAccessorsInitialized(PredictIntention.class, Builder.class);
            }

            private Builder() {
                this.trajectory_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.trajectory_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PredictIntention.alwaysUseFieldBuilders) {
                    getTrajectoryFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.probability_ = 0.0f;
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.trajectory_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_PredictIntention_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PredictIntention getDefaultInstanceForType() {
                return PredictIntention.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PredictIntention build() {
                PredictIntention buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PredictIntention buildPartial() {
                PredictIntention predictIntention = new PredictIntention(this);
                int i = this.bitField0_;
                predictIntention.probability_ = this.probability_;
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    predictIntention.trajectory_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 2) == 2) {
                        this.trajectory_ = Collections.unmodifiableList(this.trajectory_);
                        this.bitField0_ &= -3;
                    }
                    predictIntention.trajectory_ = this.trajectory_;
                }
                predictIntention.bitField0_ = 0;
                onBuilt();
                return predictIntention;
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
                if (message instanceof PredictIntention) {
                    return mergeFrom((PredictIntention) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(PredictIntention predictIntention) {
                if (predictIntention == PredictIntention.getDefaultInstance()) {
                    return this;
                }
                if (predictIntention.getProbability() != 0.0f) {
                    setProbability(predictIntention.getProbability());
                }
                if (this.trajectoryBuilder_ == null) {
                    if (!predictIntention.trajectory_.isEmpty()) {
                        if (this.trajectory_.isEmpty()) {
                            this.trajectory_ = predictIntention.trajectory_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureTrajectoryIsMutable();
                            this.trajectory_.addAll(predictIntention.trajectory_);
                        }
                        onChanged();
                    }
                } else if (!predictIntention.trajectory_.isEmpty()) {
                    if (!this.trajectoryBuilder_.isEmpty()) {
                        this.trajectoryBuilder_.addAllMessages(predictIntention.trajectory_);
                    } else {
                        this.trajectoryBuilder_.dispose();
                        this.trajectoryBuilder_ = null;
                        this.trajectory_ = predictIntention.trajectory_;
                        this.bitField0_ &= -3;
                        this.trajectoryBuilder_ = PredictIntention.alwaysUseFieldBuilders ? getTrajectoryFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(predictIntention.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntention.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntention.access$4600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$PredictIntention r3 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntention) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$PredictIntention r4 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntention) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntention.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.DynamicEnvironmentOuterClass$PredictIntention$Builder");
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
            public float getProbability() {
                return this.probability_;
            }

            public Builder setProbability(float f) {
                this.probability_ = f;
                onChanged();
                return this;
            }

            public Builder clearProbability() {
                this.probability_ = 0.0f;
                onChanged();
                return this;
            }

            private void ensureTrajectoryIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.trajectory_ = new ArrayList(this.trajectory_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
            public List<PredictPoint> getTrajectoryList() {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.trajectory_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
            public int getTrajectoryCount() {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.trajectory_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
            public PredictPoint getTrajectory(int i) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.trajectory_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setTrajectory(int i, PredictPoint predictPoint) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, predictPoint);
                } else if (predictPoint == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrajectoryIsMutable();
                    this.trajectory_.set(i, predictPoint);
                    onChanged();
                }
                return this;
            }

            public Builder setTrajectory(int i, PredictPoint.Builder builder) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectoryIsMutable();
                    this.trajectory_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addTrajectory(PredictPoint predictPoint) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(predictPoint);
                } else if (predictPoint == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrajectoryIsMutable();
                    this.trajectory_.add(predictPoint);
                    onChanged();
                }
                return this;
            }

            public Builder addTrajectory(int i, PredictPoint predictPoint) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, predictPoint);
                } else if (predictPoint == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrajectoryIsMutable();
                    this.trajectory_.add(i, predictPoint);
                    onChanged();
                }
                return this;
            }

            public Builder addTrajectory(PredictPoint.Builder builder) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectoryIsMutable();
                    this.trajectory_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addTrajectory(int i, PredictPoint.Builder builder) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectoryIsMutable();
                    this.trajectory_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllTrajectory(Iterable<? extends PredictPoint> iterable) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectoryIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.trajectory_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearTrajectory() {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.trajectory_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeTrajectory(int i) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTrajectoryIsMutable();
                    this.trajectory_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public PredictPoint.Builder getTrajectoryBuilder(int i) {
                return getTrajectoryFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
            public PredictPointOrBuilder getTrajectoryOrBuilder(int i) {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.trajectory_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.PredictIntentionOrBuilder
            public List<? extends PredictPointOrBuilder> getTrajectoryOrBuilderList() {
                RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> repeatedFieldBuilderV3 = this.trajectoryBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.trajectory_);
            }

            public PredictPoint.Builder addTrajectoryBuilder() {
                return getTrajectoryFieldBuilder().addBuilder(PredictPoint.getDefaultInstance());
            }

            public PredictPoint.Builder addTrajectoryBuilder(int i) {
                return getTrajectoryFieldBuilder().addBuilder(i, PredictPoint.getDefaultInstance());
            }

            public List<PredictPoint.Builder> getTrajectoryBuilderList() {
                return getTrajectoryFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PredictPoint, PredictPoint.Builder, PredictPointOrBuilder> getTrajectoryFieldBuilder() {
                if (this.trajectoryBuilder_ == null) {
                    this.trajectoryBuilder_ = new RepeatedFieldBuilderV3<>(this.trajectory_, (this.bitField0_ & 2) == 2, getParentForChildren(), isClean());
                    this.trajectory_ = null;
                }
                return this.trajectoryBuilder_;
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

        public static PredictIntention getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PredictIntention> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PredictIntention> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PredictIntention getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class SfbpDynamicObject extends GeneratedMessageV3 implements SfbpDynamicObjectOrBuilder {
        public static final int BP_INTENTION_FIELD_NUMBER = 2;
        private static final SfbpDynamicObject DEFAULT_INSTANCE = new SfbpDynamicObject();
        private static final Parser<SfbpDynamicObject> PARSER = new AbstractParser<SfbpDynamicObject>() { // from class: xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObject.1
            @Override // com.google.protobuf.Parser
            public SfbpDynamicObject parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SfbpDynamicObject(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SF_SNAPSHOT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<PredictIntention> bpIntention_;
        private byte memoizedIsInitialized;
        private SfObject sfSnapshot_;

        private SfbpDynamicObject(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private SfbpDynamicObject() {
            this.memoizedIsInitialized = (byte) -1;
            this.bpIntention_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SfbpDynamicObject(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                SfObject.Builder builder = this.sfSnapshot_ != null ? this.sfSnapshot_.toBuilder() : null;
                                this.sfSnapshot_ = (SfObject) codedInputStream.readMessage(SfObject.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.sfSnapshot_);
                                    this.sfSnapshot_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                if (!(z2 & true)) {
                                    this.bpIntention_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.bpIntention_.add(codedInputStream.readMessage(PredictIntention.parser(), extensionRegistryLite));
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
                        this.bpIntention_ = Collections.unmodifiableList(this.bpIntention_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpDynamicObject_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpDynamicObject_fieldAccessorTable.ensureFieldAccessorsInitialized(SfbpDynamicObject.class, Builder.class);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
        public boolean hasSfSnapshot() {
            return this.sfSnapshot_ != null;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
        public SfObject getSfSnapshot() {
            SfObject sfObject = this.sfSnapshot_;
            return sfObject == null ? SfObject.getDefaultInstance() : sfObject;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
        public SfObjectOrBuilder getSfSnapshotOrBuilder() {
            return getSfSnapshot();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
        public List<PredictIntention> getBpIntentionList() {
            return this.bpIntention_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
        public List<? extends PredictIntentionOrBuilder> getBpIntentionOrBuilderList() {
            return this.bpIntention_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
        public int getBpIntentionCount() {
            return this.bpIntention_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
        public PredictIntention getBpIntention(int i) {
            return this.bpIntention_.get(i);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
        public PredictIntentionOrBuilder getBpIntentionOrBuilder(int i) {
            return this.bpIntention_.get(i);
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
            if (this.sfSnapshot_ != null) {
                codedOutputStream.writeMessage(1, getSfSnapshot());
            }
            for (int i = 0; i < this.bpIntention_.size(); i++) {
                codedOutputStream.writeMessage(2, this.bpIntention_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.sfSnapshot_ != null ? CodedOutputStream.computeMessageSize(1, getSfSnapshot()) + 0 : 0;
            for (int i2 = 0; i2 < this.bpIntention_.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.bpIntention_.get(i2));
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
            if (!(obj instanceof SfbpDynamicObject)) {
                return super.equals(obj);
            }
            SfbpDynamicObject sfbpDynamicObject = (SfbpDynamicObject) obj;
            boolean z = hasSfSnapshot() == sfbpDynamicObject.hasSfSnapshot();
            if (hasSfSnapshot()) {
                z = z && getSfSnapshot().equals(sfbpDynamicObject.getSfSnapshot());
            }
            return (z && getBpIntentionList().equals(sfbpDynamicObject.getBpIntentionList())) && this.unknownFields.equals(sfbpDynamicObject.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasSfSnapshot()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getSfSnapshot().hashCode();
            }
            if (getBpIntentionCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getBpIntentionList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static SfbpDynamicObject parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SfbpDynamicObject parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SfbpDynamicObject parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SfbpDynamicObject parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SfbpDynamicObject parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SfbpDynamicObject parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SfbpDynamicObject parseFrom(InputStream inputStream) throws IOException {
            return (SfbpDynamicObject) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SfbpDynamicObject parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SfbpDynamicObject) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SfbpDynamicObject parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SfbpDynamicObject) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SfbpDynamicObject parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SfbpDynamicObject) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SfbpDynamicObject parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SfbpDynamicObject) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SfbpDynamicObject parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SfbpDynamicObject) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SfbpDynamicObject sfbpDynamicObject) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sfbpDynamicObject);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SfbpDynamicObjectOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> bpIntentionBuilder_;
            private List<PredictIntention> bpIntention_;
            private SingleFieldBuilderV3<SfObject, SfObject.Builder, SfObjectOrBuilder> sfSnapshotBuilder_;
            private SfObject sfSnapshot_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpDynamicObject_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpDynamicObject_fieldAccessorTable.ensureFieldAccessorsInitialized(SfbpDynamicObject.class, Builder.class);
            }

            private Builder() {
                this.sfSnapshot_ = null;
                this.bpIntention_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.sfSnapshot_ = null;
                this.bpIntention_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SfbpDynamicObject.alwaysUseFieldBuilders) {
                    getBpIntentionFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.sfSnapshotBuilder_ == null) {
                    this.sfSnapshot_ = null;
                } else {
                    this.sfSnapshot_ = null;
                    this.sfSnapshotBuilder_ = null;
                }
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.bpIntention_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpDynamicObject_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SfbpDynamicObject getDefaultInstanceForType() {
                return SfbpDynamicObject.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SfbpDynamicObject build() {
                SfbpDynamicObject buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SfbpDynamicObject buildPartial() {
                SfbpDynamicObject sfbpDynamicObject = new SfbpDynamicObject(this);
                int i = this.bitField0_;
                SingleFieldBuilderV3<SfObject, SfObject.Builder, SfObjectOrBuilder> singleFieldBuilderV3 = this.sfSnapshotBuilder_;
                if (singleFieldBuilderV3 == null) {
                    sfbpDynamicObject.sfSnapshot_ = this.sfSnapshot_;
                } else {
                    sfbpDynamicObject.sfSnapshot_ = singleFieldBuilderV3.build();
                }
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    sfbpDynamicObject.bpIntention_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 2) == 2) {
                        this.bpIntention_ = Collections.unmodifiableList(this.bpIntention_);
                        this.bitField0_ &= -3;
                    }
                    sfbpDynamicObject.bpIntention_ = this.bpIntention_;
                }
                sfbpDynamicObject.bitField0_ = 0;
                onBuilt();
                return sfbpDynamicObject;
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
                if (message instanceof SfbpDynamicObject) {
                    return mergeFrom((SfbpDynamicObject) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SfbpDynamicObject sfbpDynamicObject) {
                if (sfbpDynamicObject == SfbpDynamicObject.getDefaultInstance()) {
                    return this;
                }
                if (sfbpDynamicObject.hasSfSnapshot()) {
                    mergeSfSnapshot(sfbpDynamicObject.getSfSnapshot());
                }
                if (this.bpIntentionBuilder_ == null) {
                    if (!sfbpDynamicObject.bpIntention_.isEmpty()) {
                        if (this.bpIntention_.isEmpty()) {
                            this.bpIntention_ = sfbpDynamicObject.bpIntention_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureBpIntentionIsMutable();
                            this.bpIntention_.addAll(sfbpDynamicObject.bpIntention_);
                        }
                        onChanged();
                    }
                } else if (!sfbpDynamicObject.bpIntention_.isEmpty()) {
                    if (!this.bpIntentionBuilder_.isEmpty()) {
                        this.bpIntentionBuilder_.addAllMessages(sfbpDynamicObject.bpIntention_);
                    } else {
                        this.bpIntentionBuilder_.dispose();
                        this.bpIntentionBuilder_ = null;
                        this.bpIntention_ = sfbpDynamicObject.bpIntention_;
                        this.bitField0_ &= -3;
                        this.bpIntentionBuilder_ = SfbpDynamicObject.alwaysUseFieldBuilders ? getBpIntentionFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(sfbpDynamicObject.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObject.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObject.access$5900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$SfbpDynamicObject r3 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObject) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$SfbpDynamicObject r4 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObject) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObject.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.DynamicEnvironmentOuterClass$SfbpDynamicObject$Builder");
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
            public boolean hasSfSnapshot() {
                return (this.sfSnapshotBuilder_ == null && this.sfSnapshot_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
            public SfObject getSfSnapshot() {
                SingleFieldBuilderV3<SfObject, SfObject.Builder, SfObjectOrBuilder> singleFieldBuilderV3 = this.sfSnapshotBuilder_;
                if (singleFieldBuilderV3 == null) {
                    SfObject sfObject = this.sfSnapshot_;
                    return sfObject == null ? SfObject.getDefaultInstance() : sfObject;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setSfSnapshot(SfObject sfObject) {
                SingleFieldBuilderV3<SfObject, SfObject.Builder, SfObjectOrBuilder> singleFieldBuilderV3 = this.sfSnapshotBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(sfObject);
                } else if (sfObject == null) {
                    throw new NullPointerException();
                } else {
                    this.sfSnapshot_ = sfObject;
                    onChanged();
                }
                return this;
            }

            public Builder setSfSnapshot(SfObject.Builder builder) {
                SingleFieldBuilderV3<SfObject, SfObject.Builder, SfObjectOrBuilder> singleFieldBuilderV3 = this.sfSnapshotBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.sfSnapshot_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeSfSnapshot(SfObject sfObject) {
                SingleFieldBuilderV3<SfObject, SfObject.Builder, SfObjectOrBuilder> singleFieldBuilderV3 = this.sfSnapshotBuilder_;
                if (singleFieldBuilderV3 == null) {
                    SfObject sfObject2 = this.sfSnapshot_;
                    if (sfObject2 != null) {
                        this.sfSnapshot_ = SfObject.newBuilder(sfObject2).mergeFrom(sfObject).buildPartial();
                    } else {
                        this.sfSnapshot_ = sfObject;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(sfObject);
                }
                return this;
            }

            public Builder clearSfSnapshot() {
                if (this.sfSnapshotBuilder_ == null) {
                    this.sfSnapshot_ = null;
                    onChanged();
                } else {
                    this.sfSnapshot_ = null;
                    this.sfSnapshotBuilder_ = null;
                }
                return this;
            }

            public SfObject.Builder getSfSnapshotBuilder() {
                onChanged();
                return getSfSnapshotFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
            public SfObjectOrBuilder getSfSnapshotOrBuilder() {
                SingleFieldBuilderV3<SfObject, SfObject.Builder, SfObjectOrBuilder> singleFieldBuilderV3 = this.sfSnapshotBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                SfObject sfObject = this.sfSnapshot_;
                return sfObject == null ? SfObject.getDefaultInstance() : sfObject;
            }

            private SingleFieldBuilderV3<SfObject, SfObject.Builder, SfObjectOrBuilder> getSfSnapshotFieldBuilder() {
                if (this.sfSnapshotBuilder_ == null) {
                    this.sfSnapshotBuilder_ = new SingleFieldBuilderV3<>(getSfSnapshot(), getParentForChildren(), isClean());
                    this.sfSnapshot_ = null;
                }
                return this.sfSnapshotBuilder_;
            }

            private void ensureBpIntentionIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.bpIntention_ = new ArrayList(this.bpIntention_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
            public List<PredictIntention> getBpIntentionList() {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.bpIntention_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
            public int getBpIntentionCount() {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.bpIntention_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
            public PredictIntention getBpIntention(int i) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.bpIntention_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setBpIntention(int i, PredictIntention predictIntention) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, predictIntention);
                } else if (predictIntention == null) {
                    throw new NullPointerException();
                } else {
                    ensureBpIntentionIsMutable();
                    this.bpIntention_.set(i, predictIntention);
                    onChanged();
                }
                return this;
            }

            public Builder setBpIntention(int i, PredictIntention.Builder builder) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBpIntentionIsMutable();
                    this.bpIntention_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addBpIntention(PredictIntention predictIntention) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(predictIntention);
                } else if (predictIntention == null) {
                    throw new NullPointerException();
                } else {
                    ensureBpIntentionIsMutable();
                    this.bpIntention_.add(predictIntention);
                    onChanged();
                }
                return this;
            }

            public Builder addBpIntention(int i, PredictIntention predictIntention) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, predictIntention);
                } else if (predictIntention == null) {
                    throw new NullPointerException();
                } else {
                    ensureBpIntentionIsMutable();
                    this.bpIntention_.add(i, predictIntention);
                    onChanged();
                }
                return this;
            }

            public Builder addBpIntention(PredictIntention.Builder builder) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBpIntentionIsMutable();
                    this.bpIntention_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addBpIntention(int i, PredictIntention.Builder builder) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBpIntentionIsMutable();
                    this.bpIntention_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllBpIntention(Iterable<? extends PredictIntention> iterable) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBpIntentionIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.bpIntention_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearBpIntention() {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.bpIntention_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeBpIntention(int i) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureBpIntentionIsMutable();
                    this.bpIntention_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public PredictIntention.Builder getBpIntentionBuilder(int i) {
                return getBpIntentionFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
            public PredictIntentionOrBuilder getBpIntentionOrBuilder(int i) {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.bpIntention_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpDynamicObjectOrBuilder
            public List<? extends PredictIntentionOrBuilder> getBpIntentionOrBuilderList() {
                RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> repeatedFieldBuilderV3 = this.bpIntentionBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.bpIntention_);
            }

            public PredictIntention.Builder addBpIntentionBuilder() {
                return getBpIntentionFieldBuilder().addBuilder(PredictIntention.getDefaultInstance());
            }

            public PredictIntention.Builder addBpIntentionBuilder(int i) {
                return getBpIntentionFieldBuilder().addBuilder(i, PredictIntention.getDefaultInstance());
            }

            public List<PredictIntention.Builder> getBpIntentionBuilderList() {
                return getBpIntentionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PredictIntention, PredictIntention.Builder, PredictIntentionOrBuilder> getBpIntentionFieldBuilder() {
                if (this.bpIntentionBuilder_ == null) {
                    this.bpIntentionBuilder_ = new RepeatedFieldBuilderV3<>(this.bpIntention_, (this.bitField0_ & 2) == 2, getParentForChildren(), isClean());
                    this.bpIntention_ = null;
                }
                return this.bpIntentionBuilder_;
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

        public static SfbpDynamicObject getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SfbpDynamicObject> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SfbpDynamicObject> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SfbpDynamicObject getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class SfbpStaticObject extends GeneratedMessageV3 implements SfbpStaticObjectOrBuilder {
        public static final int ID_FIELD_NUMBER = 1;
        public static final int LOCAL_POSE_FIELD_NUMBER = 4;
        public static final int SIZE_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int id_;
        private int localPoseMemoizedSerializedSize;
        private List<Float> localPose_;
        private byte memoizedIsInitialized;
        private Primitives.Size3D size_;
        private int type_;
        private static final SfbpStaticObject DEFAULT_INSTANCE = new SfbpStaticObject();
        private static final Parser<SfbpStaticObject> PARSER = new AbstractParser<SfbpStaticObject>() { // from class: xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObject.1
            @Override // com.google.protobuf.Parser
            public SfbpStaticObject parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SfbpStaticObject(codedInputStream, extensionRegistryLite);
            }
        };

        private SfbpStaticObject(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.localPoseMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private SfbpStaticObject() {
            this.localPoseMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.id_ = 0;
            this.type_ = 0;
            this.localPose_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SfbpStaticObject(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 8) {
                                this.id_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.type_ = codedInputStream.readEnum();
                            } else if (readTag == 26) {
                                Primitives.Size3D.Builder builder = this.size_ != null ? this.size_.toBuilder() : null;
                                this.size_ = (Primitives.Size3D) codedInputStream.readMessage(Primitives.Size3D.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.size_);
                                    this.size_ = builder.buildPartial();
                                }
                            } else if (readTag == 34) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localPose_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localPose_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 37) {
                                if (!(z2 & true)) {
                                    this.localPose_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localPose_.add(Float.valueOf(codedInputStream.readFloat()));
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
                        this.localPose_ = Collections.unmodifiableList(this.localPose_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpStaticObject_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpStaticObject_fieldAccessorTable.ensureFieldAccessorsInitialized(SfbpStaticObject.class, Builder.class);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
        public Primitives.StaticObjectType getType() {
            Primitives.StaticObjectType valueOf = Primitives.StaticObjectType.valueOf(this.type_);
            return valueOf == null ? Primitives.StaticObjectType.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
        public boolean hasSize() {
            return this.size_ != null;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
        public Primitives.Size3D getSize() {
            Primitives.Size3D size3D = this.size_;
            return size3D == null ? Primitives.Size3D.getDefaultInstance() : size3D;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
        public Primitives.Size3DOrBuilder getSizeOrBuilder() {
            return getSize();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
        public List<Float> getLocalPoseList() {
            return this.localPose_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
        public int getLocalPoseCount() {
            return this.localPose_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
        public float getLocalPose(int i) {
            return this.localPose_.get(i).floatValue();
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
            int i = this.id_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (this.type_ != Primitives.StaticObjectType.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(2, this.type_);
            }
            if (this.size_ != null) {
                codedOutputStream.writeMessage(3, getSize());
            }
            if (getLocalPoseList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(34);
                codedOutputStream.writeUInt32NoTag(this.localPoseMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.localPose_.size(); i2++) {
                codedOutputStream.writeFloatNoTag(this.localPose_.get(i2).floatValue());
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
            if (this.type_ != Primitives.StaticObjectType.UNKNOWN.getNumber()) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(2, this.type_);
            }
            if (this.size_ != null) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(3, getSize());
            }
            int size = getLocalPoseList().size() * 4;
            int i3 = computeUInt32Size + size;
            if (!getLocalPoseList().isEmpty()) {
                i3 = i3 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.localPoseMemoizedSerializedSize = size;
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SfbpStaticObject)) {
                return super.equals(obj);
            }
            SfbpStaticObject sfbpStaticObject = (SfbpStaticObject) obj;
            boolean z = ((getId() == sfbpStaticObject.getId()) && this.type_ == sfbpStaticObject.type_) && hasSize() == sfbpStaticObject.hasSize();
            if (hasSize()) {
                z = z && getSize().equals(sfbpStaticObject.getSize());
            }
            return (z && getLocalPoseList().equals(sfbpStaticObject.getLocalPoseList())) && this.unknownFields.equals(sfbpStaticObject.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getId()) * 37) + 2) * 53) + this.type_;
            if (hasSize()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getSize().hashCode();
            }
            if (getLocalPoseCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getLocalPoseList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static SfbpStaticObject parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SfbpStaticObject parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SfbpStaticObject parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SfbpStaticObject parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SfbpStaticObject parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SfbpStaticObject parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SfbpStaticObject parseFrom(InputStream inputStream) throws IOException {
            return (SfbpStaticObject) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SfbpStaticObject parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SfbpStaticObject) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SfbpStaticObject parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SfbpStaticObject) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SfbpStaticObject parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SfbpStaticObject) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SfbpStaticObject parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SfbpStaticObject) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SfbpStaticObject parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SfbpStaticObject) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SfbpStaticObject sfbpStaticObject) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sfbpStaticObject);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SfbpStaticObjectOrBuilder {
            private int bitField0_;
            private int id_;
            private List<Float> localPose_;
            private SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> sizeBuilder_;
            private Primitives.Size3D size_;
            private int type_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpStaticObject_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpStaticObject_fieldAccessorTable.ensureFieldAccessorsInitialized(SfbpStaticObject.class, Builder.class);
            }

            private Builder() {
                this.type_ = 0;
                this.size_ = null;
                this.localPose_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                this.size_ = null;
                this.localPose_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SfbpStaticObject.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.type_ = 0;
                if (this.sizeBuilder_ == null) {
                    this.size_ = null;
                } else {
                    this.size_ = null;
                    this.sizeBuilder_ = null;
                }
                this.localPose_ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_SfbpStaticObject_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SfbpStaticObject getDefaultInstanceForType() {
                return SfbpStaticObject.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SfbpStaticObject build() {
                SfbpStaticObject buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SfbpStaticObject buildPartial() {
                SfbpStaticObject sfbpStaticObject = new SfbpStaticObject(this);
                int i = this.bitField0_;
                sfbpStaticObject.id_ = this.id_;
                sfbpStaticObject.type_ = this.type_;
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    sfbpStaticObject.size_ = this.size_;
                } else {
                    sfbpStaticObject.size_ = singleFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 8) == 8) {
                    this.localPose_ = Collections.unmodifiableList(this.localPose_);
                    this.bitField0_ &= -9;
                }
                sfbpStaticObject.localPose_ = this.localPose_;
                sfbpStaticObject.bitField0_ = 0;
                onBuilt();
                return sfbpStaticObject;
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
                if (message instanceof SfbpStaticObject) {
                    return mergeFrom((SfbpStaticObject) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SfbpStaticObject sfbpStaticObject) {
                if (sfbpStaticObject == SfbpStaticObject.getDefaultInstance()) {
                    return this;
                }
                if (sfbpStaticObject.getId() != 0) {
                    setId(sfbpStaticObject.getId());
                }
                if (sfbpStaticObject.type_ != 0) {
                    setTypeValue(sfbpStaticObject.getTypeValue());
                }
                if (sfbpStaticObject.hasSize()) {
                    mergeSize(sfbpStaticObject.getSize());
                }
                if (!sfbpStaticObject.localPose_.isEmpty()) {
                    if (this.localPose_.isEmpty()) {
                        this.localPose_ = sfbpStaticObject.localPose_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureLocalPoseIsMutable();
                        this.localPose_.addAll(sfbpStaticObject.localPose_);
                    }
                    onChanged();
                }
                mergeUnknownFields(sfbpStaticObject.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObject.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObject.access$7300()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$SfbpStaticObject r3 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObject) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$SfbpStaticObject r4 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObject) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObject.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.DynamicEnvironmentOuterClass$SfbpStaticObject$Builder");
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
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

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
            public Primitives.StaticObjectType getType() {
                Primitives.StaticObjectType valueOf = Primitives.StaticObjectType.valueOf(this.type_);
                return valueOf == null ? Primitives.StaticObjectType.UNRECOGNIZED : valueOf;
            }

            public Builder setType(Primitives.StaticObjectType staticObjectType) {
                if (staticObjectType == null) {
                    throw new NullPointerException();
                }
                this.type_ = staticObjectType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
            public boolean hasSize() {
                return (this.sizeBuilder_ == null && this.size_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
            public Primitives.Size3D getSize() {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Size3D size3D = this.size_;
                    return size3D == null ? Primitives.Size3D.getDefaultInstance() : size3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setSize(Primitives.Size3D size3D) {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(size3D);
                } else if (size3D == null) {
                    throw new NullPointerException();
                } else {
                    this.size_ = size3D;
                    onChanged();
                }
                return this;
            }

            public Builder setSize(Primitives.Size3D.Builder builder) {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.size_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeSize(Primitives.Size3D size3D) {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Size3D size3D2 = this.size_;
                    if (size3D2 != null) {
                        this.size_ = Primitives.Size3D.newBuilder(size3D2).mergeFrom(size3D).buildPartial();
                    } else {
                        this.size_ = size3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(size3D);
                }
                return this;
            }

            public Builder clearSize() {
                if (this.sizeBuilder_ == null) {
                    this.size_ = null;
                    onChanged();
                } else {
                    this.size_ = null;
                    this.sizeBuilder_ = null;
                }
                return this;
            }

            public Primitives.Size3D.Builder getSizeBuilder() {
                onChanged();
                return getSizeFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
            public Primitives.Size3DOrBuilder getSizeOrBuilder() {
                SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> singleFieldBuilderV3 = this.sizeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Size3D size3D = this.size_;
                return size3D == null ? Primitives.Size3D.getDefaultInstance() : size3D;
            }

            private SingleFieldBuilderV3<Primitives.Size3D, Primitives.Size3D.Builder, Primitives.Size3DOrBuilder> getSizeFieldBuilder() {
                if (this.sizeBuilder_ == null) {
                    this.sizeBuilder_ = new SingleFieldBuilderV3<>(getSize(), getParentForChildren(), isClean());
                    this.size_ = null;
                }
                return this.sizeBuilder_;
            }

            private void ensureLocalPoseIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.localPose_ = new ArrayList(this.localPose_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
            public List<Float> getLocalPoseList() {
                return Collections.unmodifiableList(this.localPose_);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
            public int getLocalPoseCount() {
                return this.localPose_.size();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.SfbpStaticObjectOrBuilder
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
                this.bitField0_ &= -9;
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

        public static SfbpStaticObject getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SfbpStaticObject> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SfbpStaticObject> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SfbpStaticObject getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class DynamicEnvironment extends GeneratedMessageV3 implements DynamicEnvironmentOrBuilder {
        public static final int EGO_MOTION_FIELD_NUMBER = 2;
        public static final int IS_SPLIT_FIELD_NUMBER = 3;
        public static final int SFBP_OBJECT_FIELD_NUMBER = 4;
        public static final int SFBP_STA_OBJECT_FIELD_NUMBER = 5;
        public static final int TIMESTAMP_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Primitives.EgoMotion egoMotion_;
        private boolean isSplit_;
        private byte memoizedIsInitialized;
        private List<SfbpDynamicObject> sfbpObject_;
        private List<SfbpStaticObject> sfbpStaObject_;
        private Primitives.Time timestamp_;
        private static final DynamicEnvironment DEFAULT_INSTANCE = new DynamicEnvironment();
        private static final Parser<DynamicEnvironment> PARSER = new AbstractParser<DynamicEnvironment>() { // from class: xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironment.1
            @Override // com.google.protobuf.Parser
            public DynamicEnvironment parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new DynamicEnvironment(codedInputStream, extensionRegistryLite);
            }
        };

        private DynamicEnvironment(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private DynamicEnvironment() {
            this.memoizedIsInitialized = (byte) -1;
            this.isSplit_ = false;
            this.sfbpObject_ = Collections.emptyList();
            this.sfbpStaObject_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private DynamicEnvironment(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                Primitives.EgoMotion.Builder builder2 = this.egoMotion_ != null ? this.egoMotion_.toBuilder() : null;
                                this.egoMotion_ = (Primitives.EgoMotion) codedInputStream.readMessage(Primitives.EgoMotion.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.egoMotion_);
                                    this.egoMotion_ = builder2.buildPartial();
                                }
                            } else if (readTag == 24) {
                                this.isSplit_ = codedInputStream.readBool();
                            } else if (readTag == 34) {
                                boolean z3 = (z2 ? 1 : 0) & true;
                                z2 = z2;
                                if (!z3) {
                                    this.sfbpObject_ = new ArrayList();
                                    z2 = (z2 ? 1 : 0) | true;
                                }
                                this.sfbpObject_.add(codedInputStream.readMessage(SfbpDynamicObject.parser(), extensionRegistryLite));
                            } else if (readTag == 42) {
                                boolean z4 = (z2 ? 1 : 0) & true;
                                z2 = z2;
                                if (!z4) {
                                    this.sfbpStaObject_ = new ArrayList();
                                    z2 = (z2 ? 1 : 0) | true;
                                }
                                this.sfbpStaObject_.add(codedInputStream.readMessage(SfbpStaticObject.parser(), extensionRegistryLite));
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
                        this.sfbpObject_ = Collections.unmodifiableList(this.sfbpObject_);
                    }
                    if ((z2 ? 1 : 0) & true) {
                        this.sfbpStaObject_ = Collections.unmodifiableList(this.sfbpStaObject_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironment_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironment_fieldAccessorTable.ensureFieldAccessorsInitialized(DynamicEnvironment.class, Builder.class);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public boolean hasTimestamp() {
            return this.timestamp_ != null;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public Primitives.Time getTimestamp() {
            Primitives.Time time = this.timestamp_;
            return time == null ? Primitives.Time.getDefaultInstance() : time;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public Primitives.TimeOrBuilder getTimestampOrBuilder() {
            return getTimestamp();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public boolean hasEgoMotion() {
            return this.egoMotion_ != null;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public Primitives.EgoMotion getEgoMotion() {
            Primitives.EgoMotion egoMotion = this.egoMotion_;
            return egoMotion == null ? Primitives.EgoMotion.getDefaultInstance() : egoMotion;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public Primitives.EgoMotionOrBuilder getEgoMotionOrBuilder() {
            return getEgoMotion();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public boolean getIsSplit() {
            return this.isSplit_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public List<SfbpDynamicObject> getSfbpObjectList() {
            return this.sfbpObject_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public List<? extends SfbpDynamicObjectOrBuilder> getSfbpObjectOrBuilderList() {
            return this.sfbpObject_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public int getSfbpObjectCount() {
            return this.sfbpObject_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public SfbpDynamicObject getSfbpObject(int i) {
            return this.sfbpObject_.get(i);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public SfbpDynamicObjectOrBuilder getSfbpObjectOrBuilder(int i) {
            return this.sfbpObject_.get(i);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public List<SfbpStaticObject> getSfbpStaObjectList() {
            return this.sfbpStaObject_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public List<? extends SfbpStaticObjectOrBuilder> getSfbpStaObjectOrBuilderList() {
            return this.sfbpStaObject_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public int getSfbpStaObjectCount() {
            return this.sfbpStaObject_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public SfbpStaticObject getSfbpStaObject(int i) {
            return this.sfbpStaObject_.get(i);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
        public SfbpStaticObjectOrBuilder getSfbpStaObjectOrBuilder(int i) {
            return this.sfbpStaObject_.get(i);
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
            if (this.egoMotion_ != null) {
                codedOutputStream.writeMessage(2, getEgoMotion());
            }
            boolean z = this.isSplit_;
            if (z) {
                codedOutputStream.writeBool(3, z);
            }
            for (int i = 0; i < this.sfbpObject_.size(); i++) {
                codedOutputStream.writeMessage(4, this.sfbpObject_.get(i));
            }
            for (int i2 = 0; i2 < this.sfbpStaObject_.size(); i2++) {
                codedOutputStream.writeMessage(5, this.sfbpStaObject_.get(i2));
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
            if (this.egoMotion_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getEgoMotion());
            }
            boolean z = this.isSplit_;
            if (z) {
                computeMessageSize += CodedOutputStream.computeBoolSize(3, z);
            }
            int i2 = computeMessageSize;
            for (int i3 = 0; i3 < this.sfbpObject_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(4, this.sfbpObject_.get(i3));
            }
            for (int i4 = 0; i4 < this.sfbpStaObject_.size(); i4++) {
                i2 += CodedOutputStream.computeMessageSize(5, this.sfbpStaObject_.get(i4));
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
            if (!(obj instanceof DynamicEnvironment)) {
                return super.equals(obj);
            }
            DynamicEnvironment dynamicEnvironment = (DynamicEnvironment) obj;
            boolean z = hasTimestamp() == dynamicEnvironment.hasTimestamp();
            if (hasTimestamp()) {
                z = z && getTimestamp().equals(dynamicEnvironment.getTimestamp());
            }
            boolean z2 = z && hasEgoMotion() == dynamicEnvironment.hasEgoMotion();
            if (hasEgoMotion()) {
                z2 = z2 && getEgoMotion().equals(dynamicEnvironment.getEgoMotion());
            }
            return (((z2 && getIsSplit() == dynamicEnvironment.getIsSplit()) && getSfbpObjectList().equals(dynamicEnvironment.getSfbpObjectList())) && getSfbpStaObjectList().equals(dynamicEnvironment.getSfbpStaObjectList())) && this.unknownFields.equals(dynamicEnvironment.unknownFields);
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
            if (hasEgoMotion()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getEgoMotion().hashCode();
            }
            int hashBoolean = (((hashCode * 37) + 3) * 53) + Internal.hashBoolean(getIsSplit());
            if (getSfbpObjectCount() > 0) {
                hashBoolean = (((hashBoolean * 37) + 4) * 53) + getSfbpObjectList().hashCode();
            }
            if (getSfbpStaObjectCount() > 0) {
                hashBoolean = (((hashBoolean * 37) + 5) * 53) + getSfbpStaObjectList().hashCode();
            }
            int hashCode2 = (hashBoolean * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static DynamicEnvironment parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static DynamicEnvironment parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static DynamicEnvironment parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static DynamicEnvironment parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DynamicEnvironment parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static DynamicEnvironment parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static DynamicEnvironment parseFrom(InputStream inputStream) throws IOException {
            return (DynamicEnvironment) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DynamicEnvironment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DynamicEnvironment) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DynamicEnvironment parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DynamicEnvironment) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DynamicEnvironment parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DynamicEnvironment) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DynamicEnvironment parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DynamicEnvironment) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static DynamicEnvironment parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DynamicEnvironment) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DynamicEnvironment dynamicEnvironment) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(dynamicEnvironment);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DynamicEnvironmentOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<Primitives.EgoMotion, Primitives.EgoMotion.Builder, Primitives.EgoMotionOrBuilder> egoMotionBuilder_;
            private Primitives.EgoMotion egoMotion_;
            private boolean isSplit_;
            private RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> sfbpObjectBuilder_;
            private List<SfbpDynamicObject> sfbpObject_;
            private RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> sfbpStaObjectBuilder_;
            private List<SfbpStaticObject> sfbpStaObject_;
            private SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> timestampBuilder_;
            private Primitives.Time timestamp_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironment_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironment_fieldAccessorTable.ensureFieldAccessorsInitialized(DynamicEnvironment.class, Builder.class);
            }

            private Builder() {
                this.timestamp_ = null;
                this.egoMotion_ = null;
                this.sfbpObject_ = Collections.emptyList();
                this.sfbpStaObject_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.timestamp_ = null;
                this.egoMotion_ = null;
                this.sfbpObject_ = Collections.emptyList();
                this.sfbpStaObject_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DynamicEnvironment.alwaysUseFieldBuilders) {
                    getSfbpObjectFieldBuilder();
                    getSfbpStaObjectFieldBuilder();
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
                if (this.egoMotionBuilder_ == null) {
                    this.egoMotion_ = null;
                } else {
                    this.egoMotion_ = null;
                    this.egoMotionBuilder_ = null;
                }
                this.isSplit_ = false;
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.sfbpObject_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV32 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV32 == null) {
                    this.sfbpStaObject_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    repeatedFieldBuilderV32.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironment_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DynamicEnvironment getDefaultInstanceForType() {
                return DynamicEnvironment.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DynamicEnvironment build() {
                DynamicEnvironment buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DynamicEnvironment buildPartial() {
                DynamicEnvironment dynamicEnvironment = new DynamicEnvironment(this);
                int i = this.bitField0_;
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    dynamicEnvironment.timestamp_ = this.timestamp_;
                } else {
                    dynamicEnvironment.timestamp_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Primitives.EgoMotion, Primitives.EgoMotion.Builder, Primitives.EgoMotionOrBuilder> singleFieldBuilderV32 = this.egoMotionBuilder_;
                if (singleFieldBuilderV32 == null) {
                    dynamicEnvironment.egoMotion_ = this.egoMotion_;
                } else {
                    dynamicEnvironment.egoMotion_ = singleFieldBuilderV32.build();
                }
                dynamicEnvironment.isSplit_ = this.isSplit_;
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    dynamicEnvironment.sfbpObject_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 8) == 8) {
                        this.sfbpObject_ = Collections.unmodifiableList(this.sfbpObject_);
                        this.bitField0_ &= -9;
                    }
                    dynamicEnvironment.sfbpObject_ = this.sfbpObject_;
                }
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV32 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV32 != null) {
                    dynamicEnvironment.sfbpStaObject_ = repeatedFieldBuilderV32.build();
                } else {
                    if ((this.bitField0_ & 16) == 16) {
                        this.sfbpStaObject_ = Collections.unmodifiableList(this.sfbpStaObject_);
                        this.bitField0_ &= -17;
                    }
                    dynamicEnvironment.sfbpStaObject_ = this.sfbpStaObject_;
                }
                dynamicEnvironment.bitField0_ = 0;
                onBuilt();
                return dynamicEnvironment;
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
                if (message instanceof DynamicEnvironment) {
                    return mergeFrom((DynamicEnvironment) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(DynamicEnvironment dynamicEnvironment) {
                if (dynamicEnvironment == DynamicEnvironment.getDefaultInstance()) {
                    return this;
                }
                if (dynamicEnvironment.hasTimestamp()) {
                    mergeTimestamp(dynamicEnvironment.getTimestamp());
                }
                if (dynamicEnvironment.hasEgoMotion()) {
                    mergeEgoMotion(dynamicEnvironment.getEgoMotion());
                }
                if (dynamicEnvironment.getIsSplit()) {
                    setIsSplit(dynamicEnvironment.getIsSplit());
                }
                if (this.sfbpObjectBuilder_ == null) {
                    if (!dynamicEnvironment.sfbpObject_.isEmpty()) {
                        if (this.sfbpObject_.isEmpty()) {
                            this.sfbpObject_ = dynamicEnvironment.sfbpObject_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureSfbpObjectIsMutable();
                            this.sfbpObject_.addAll(dynamicEnvironment.sfbpObject_);
                        }
                        onChanged();
                    }
                } else if (!dynamicEnvironment.sfbpObject_.isEmpty()) {
                    if (!this.sfbpObjectBuilder_.isEmpty()) {
                        this.sfbpObjectBuilder_.addAllMessages(dynamicEnvironment.sfbpObject_);
                    } else {
                        this.sfbpObjectBuilder_.dispose();
                        this.sfbpObjectBuilder_ = null;
                        this.sfbpObject_ = dynamicEnvironment.sfbpObject_;
                        this.bitField0_ &= -9;
                        this.sfbpObjectBuilder_ = DynamicEnvironment.alwaysUseFieldBuilders ? getSfbpObjectFieldBuilder() : null;
                    }
                }
                if (this.sfbpStaObjectBuilder_ == null) {
                    if (!dynamicEnvironment.sfbpStaObject_.isEmpty()) {
                        if (this.sfbpStaObject_.isEmpty()) {
                            this.sfbpStaObject_ = dynamicEnvironment.sfbpStaObject_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureSfbpStaObjectIsMutable();
                            this.sfbpStaObject_.addAll(dynamicEnvironment.sfbpStaObject_);
                        }
                        onChanged();
                    }
                } else if (!dynamicEnvironment.sfbpStaObject_.isEmpty()) {
                    if (!this.sfbpStaObjectBuilder_.isEmpty()) {
                        this.sfbpStaObjectBuilder_.addAllMessages(dynamicEnvironment.sfbpStaObject_);
                    } else {
                        this.sfbpStaObjectBuilder_.dispose();
                        this.sfbpStaObjectBuilder_ = null;
                        this.sfbpStaObject_ = dynamicEnvironment.sfbpStaObject_;
                        this.bitField0_ &= -17;
                        this.sfbpStaObjectBuilder_ = DynamicEnvironment.alwaysUseFieldBuilders ? getSfbpStaObjectFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(dynamicEnvironment.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironment.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironment.access$9000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$DynamicEnvironment r3 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironment) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$DynamicEnvironment r4 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironment) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironment.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.DynamicEnvironmentOuterClass$DynamicEnvironment$Builder");
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public boolean hasTimestamp() {
                return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
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

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
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

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public boolean hasEgoMotion() {
                return (this.egoMotionBuilder_ == null && this.egoMotion_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public Primitives.EgoMotion getEgoMotion() {
                SingleFieldBuilderV3<Primitives.EgoMotion, Primitives.EgoMotion.Builder, Primitives.EgoMotionOrBuilder> singleFieldBuilderV3 = this.egoMotionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.EgoMotion egoMotion = this.egoMotion_;
                    return egoMotion == null ? Primitives.EgoMotion.getDefaultInstance() : egoMotion;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setEgoMotion(Primitives.EgoMotion egoMotion) {
                SingleFieldBuilderV3<Primitives.EgoMotion, Primitives.EgoMotion.Builder, Primitives.EgoMotionOrBuilder> singleFieldBuilderV3 = this.egoMotionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(egoMotion);
                } else if (egoMotion == null) {
                    throw new NullPointerException();
                } else {
                    this.egoMotion_ = egoMotion;
                    onChanged();
                }
                return this;
            }

            public Builder setEgoMotion(Primitives.EgoMotion.Builder builder) {
                SingleFieldBuilderV3<Primitives.EgoMotion, Primitives.EgoMotion.Builder, Primitives.EgoMotionOrBuilder> singleFieldBuilderV3 = this.egoMotionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.egoMotion_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeEgoMotion(Primitives.EgoMotion egoMotion) {
                SingleFieldBuilderV3<Primitives.EgoMotion, Primitives.EgoMotion.Builder, Primitives.EgoMotionOrBuilder> singleFieldBuilderV3 = this.egoMotionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.EgoMotion egoMotion2 = this.egoMotion_;
                    if (egoMotion2 != null) {
                        this.egoMotion_ = Primitives.EgoMotion.newBuilder(egoMotion2).mergeFrom(egoMotion).buildPartial();
                    } else {
                        this.egoMotion_ = egoMotion;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(egoMotion);
                }
                return this;
            }

            public Builder clearEgoMotion() {
                if (this.egoMotionBuilder_ == null) {
                    this.egoMotion_ = null;
                    onChanged();
                } else {
                    this.egoMotion_ = null;
                    this.egoMotionBuilder_ = null;
                }
                return this;
            }

            public Primitives.EgoMotion.Builder getEgoMotionBuilder() {
                onChanged();
                return getEgoMotionFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public Primitives.EgoMotionOrBuilder getEgoMotionOrBuilder() {
                SingleFieldBuilderV3<Primitives.EgoMotion, Primitives.EgoMotion.Builder, Primitives.EgoMotionOrBuilder> singleFieldBuilderV3 = this.egoMotionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.EgoMotion egoMotion = this.egoMotion_;
                return egoMotion == null ? Primitives.EgoMotion.getDefaultInstance() : egoMotion;
            }

            private SingleFieldBuilderV3<Primitives.EgoMotion, Primitives.EgoMotion.Builder, Primitives.EgoMotionOrBuilder> getEgoMotionFieldBuilder() {
                if (this.egoMotionBuilder_ == null) {
                    this.egoMotionBuilder_ = new SingleFieldBuilderV3<>(getEgoMotion(), getParentForChildren(), isClean());
                    this.egoMotion_ = null;
                }
                return this.egoMotionBuilder_;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public boolean getIsSplit() {
                return this.isSplit_;
            }

            public Builder setIsSplit(boolean z) {
                this.isSplit_ = z;
                onChanged();
                return this;
            }

            public Builder clearIsSplit() {
                this.isSplit_ = false;
                onChanged();
                return this;
            }

            private void ensureSfbpObjectIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.sfbpObject_ = new ArrayList(this.sfbpObject_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public List<SfbpDynamicObject> getSfbpObjectList() {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.sfbpObject_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public int getSfbpObjectCount() {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.sfbpObject_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public SfbpDynamicObject getSfbpObject(int i) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.sfbpObject_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setSfbpObject(int i, SfbpDynamicObject sfbpDynamicObject) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, sfbpDynamicObject);
                } else if (sfbpDynamicObject == null) {
                    throw new NullPointerException();
                } else {
                    ensureSfbpObjectIsMutable();
                    this.sfbpObject_.set(i, sfbpDynamicObject);
                    onChanged();
                }
                return this;
            }

            public Builder setSfbpObject(int i, SfbpDynamicObject.Builder builder) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpObjectIsMutable();
                    this.sfbpObject_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addSfbpObject(SfbpDynamicObject sfbpDynamicObject) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(sfbpDynamicObject);
                } else if (sfbpDynamicObject == null) {
                    throw new NullPointerException();
                } else {
                    ensureSfbpObjectIsMutable();
                    this.sfbpObject_.add(sfbpDynamicObject);
                    onChanged();
                }
                return this;
            }

            public Builder addSfbpObject(int i, SfbpDynamicObject sfbpDynamicObject) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, sfbpDynamicObject);
                } else if (sfbpDynamicObject == null) {
                    throw new NullPointerException();
                } else {
                    ensureSfbpObjectIsMutable();
                    this.sfbpObject_.add(i, sfbpDynamicObject);
                    onChanged();
                }
                return this;
            }

            public Builder addSfbpObject(SfbpDynamicObject.Builder builder) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpObjectIsMutable();
                    this.sfbpObject_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addSfbpObject(int i, SfbpDynamicObject.Builder builder) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpObjectIsMutable();
                    this.sfbpObject_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllSfbpObject(Iterable<? extends SfbpDynamicObject> iterable) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpObjectIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.sfbpObject_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearSfbpObject() {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.sfbpObject_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeSfbpObject(int i) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpObjectIsMutable();
                    this.sfbpObject_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public SfbpDynamicObject.Builder getSfbpObjectBuilder(int i) {
                return getSfbpObjectFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public SfbpDynamicObjectOrBuilder getSfbpObjectOrBuilder(int i) {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.sfbpObject_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public List<? extends SfbpDynamicObjectOrBuilder> getSfbpObjectOrBuilderList() {
                RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpObjectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.sfbpObject_);
            }

            public SfbpDynamicObject.Builder addSfbpObjectBuilder() {
                return getSfbpObjectFieldBuilder().addBuilder(SfbpDynamicObject.getDefaultInstance());
            }

            public SfbpDynamicObject.Builder addSfbpObjectBuilder(int i) {
                return getSfbpObjectFieldBuilder().addBuilder(i, SfbpDynamicObject.getDefaultInstance());
            }

            public List<SfbpDynamicObject.Builder> getSfbpObjectBuilderList() {
                return getSfbpObjectFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SfbpDynamicObject, SfbpDynamicObject.Builder, SfbpDynamicObjectOrBuilder> getSfbpObjectFieldBuilder() {
                if (this.sfbpObjectBuilder_ == null) {
                    this.sfbpObjectBuilder_ = new RepeatedFieldBuilderV3<>(this.sfbpObject_, (this.bitField0_ & 8) == 8, getParentForChildren(), isClean());
                    this.sfbpObject_ = null;
                }
                return this.sfbpObjectBuilder_;
            }

            private void ensureSfbpStaObjectIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.sfbpStaObject_ = new ArrayList(this.sfbpStaObject_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public List<SfbpStaticObject> getSfbpStaObjectList() {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.sfbpStaObject_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public int getSfbpStaObjectCount() {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.sfbpStaObject_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public SfbpStaticObject getSfbpStaObject(int i) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.sfbpStaObject_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setSfbpStaObject(int i, SfbpStaticObject sfbpStaticObject) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, sfbpStaticObject);
                } else if (sfbpStaticObject == null) {
                    throw new NullPointerException();
                } else {
                    ensureSfbpStaObjectIsMutable();
                    this.sfbpStaObject_.set(i, sfbpStaticObject);
                    onChanged();
                }
                return this;
            }

            public Builder setSfbpStaObject(int i, SfbpStaticObject.Builder builder) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpStaObjectIsMutable();
                    this.sfbpStaObject_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addSfbpStaObject(SfbpStaticObject sfbpStaticObject) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(sfbpStaticObject);
                } else if (sfbpStaticObject == null) {
                    throw new NullPointerException();
                } else {
                    ensureSfbpStaObjectIsMutable();
                    this.sfbpStaObject_.add(sfbpStaticObject);
                    onChanged();
                }
                return this;
            }

            public Builder addSfbpStaObject(int i, SfbpStaticObject sfbpStaticObject) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, sfbpStaticObject);
                } else if (sfbpStaticObject == null) {
                    throw new NullPointerException();
                } else {
                    ensureSfbpStaObjectIsMutable();
                    this.sfbpStaObject_.add(i, sfbpStaticObject);
                    onChanged();
                }
                return this;
            }

            public Builder addSfbpStaObject(SfbpStaticObject.Builder builder) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpStaObjectIsMutable();
                    this.sfbpStaObject_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addSfbpStaObject(int i, SfbpStaticObject.Builder builder) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpStaObjectIsMutable();
                    this.sfbpStaObject_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllSfbpStaObject(Iterable<? extends SfbpStaticObject> iterable) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpStaObjectIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.sfbpStaObject_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearSfbpStaObject() {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.sfbpStaObject_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeSfbpStaObject(int i) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureSfbpStaObjectIsMutable();
                    this.sfbpStaObject_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public SfbpStaticObject.Builder getSfbpStaObjectBuilder(int i) {
                return getSfbpStaObjectFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public SfbpStaticObjectOrBuilder getSfbpStaObjectOrBuilder(int i) {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.sfbpStaObject_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentOrBuilder
            public List<? extends SfbpStaticObjectOrBuilder> getSfbpStaObjectOrBuilderList() {
                RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> repeatedFieldBuilderV3 = this.sfbpStaObjectBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.sfbpStaObject_);
            }

            public SfbpStaticObject.Builder addSfbpStaObjectBuilder() {
                return getSfbpStaObjectFieldBuilder().addBuilder(SfbpStaticObject.getDefaultInstance());
            }

            public SfbpStaticObject.Builder addSfbpStaObjectBuilder(int i) {
                return getSfbpStaObjectFieldBuilder().addBuilder(i, SfbpStaticObject.getDefaultInstance());
            }

            public List<SfbpStaticObject.Builder> getSfbpStaObjectBuilderList() {
                return getSfbpStaObjectFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SfbpStaticObject, SfbpStaticObject.Builder, SfbpStaticObjectOrBuilder> getSfbpStaObjectFieldBuilder() {
                if (this.sfbpStaObjectBuilder_ == null) {
                    this.sfbpStaObjectBuilder_ = new RepeatedFieldBuilderV3<>(this.sfbpStaObject_, (this.bitField0_ & 16) == 16, getParentForChildren(), isClean());
                    this.sfbpStaObject_ = null;
                }
                return this.sfbpStaObjectBuilder_;
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

        public static DynamicEnvironment getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DynamicEnvironment> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DynamicEnvironment> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DynamicEnvironment getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class DynamicEnvironmentBuffer extends GeneratedMessageV3 implements DynamicEnvironmentBufferOrBuilder {
        public static final int DYNAMIC_ENV_MSGS_FIELD_NUMBER = 1;
        public static final int SPARE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private List<DynamicEnvironment> dynamicEnvMsgs_;
        private byte memoizedIsInitialized;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private static final DynamicEnvironmentBuffer DEFAULT_INSTANCE = new DynamicEnvironmentBuffer();
        private static final Parser<DynamicEnvironmentBuffer> PARSER = new AbstractParser<DynamicEnvironmentBuffer>() { // from class: xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBuffer.1
            @Override // com.google.protobuf.Parser
            public DynamicEnvironmentBuffer parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new DynamicEnvironmentBuffer(codedInputStream, extensionRegistryLite);
            }
        };

        private DynamicEnvironmentBuffer(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private DynamicEnvironmentBuffer() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.dynamicEnvMsgs_ = Collections.emptyList();
            this.spare_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private DynamicEnvironmentBuffer(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.dynamicEnvMsgs_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.dynamicEnvMsgs_.add(codedInputStream.readMessage(DynamicEnvironment.parser(), extensionRegistryLite));
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
                        this.dynamicEnvMsgs_ = Collections.unmodifiableList(this.dynamicEnvMsgs_);
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
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_fieldAccessorTable.ensureFieldAccessorsInitialized(DynamicEnvironmentBuffer.class, Builder.class);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
        public List<DynamicEnvironment> getDynamicEnvMsgsList() {
            return this.dynamicEnvMsgs_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
        public List<? extends DynamicEnvironmentOrBuilder> getDynamicEnvMsgsOrBuilderList() {
            return this.dynamicEnvMsgs_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
        public int getDynamicEnvMsgsCount() {
            return this.dynamicEnvMsgs_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
        public DynamicEnvironment getDynamicEnvMsgs(int i) {
            return this.dynamicEnvMsgs_.get(i);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
        public DynamicEnvironmentOrBuilder getDynamicEnvMsgsOrBuilder(int i) {
            return this.dynamicEnvMsgs_.get(i);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
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
            for (int i = 0; i < this.dynamicEnvMsgs_.size(); i++) {
                codedOutputStream.writeMessage(1, this.dynamicEnvMsgs_.get(i));
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
            for (int i3 = 0; i3 < this.dynamicEnvMsgs_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.dynamicEnvMsgs_.get(i3));
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
            if (!(obj instanceof DynamicEnvironmentBuffer)) {
                return super.equals(obj);
            }
            DynamicEnvironmentBuffer dynamicEnvironmentBuffer = (DynamicEnvironmentBuffer) obj;
            return ((getDynamicEnvMsgsList().equals(dynamicEnvironmentBuffer.getDynamicEnvMsgsList())) && getSpareList().equals(dynamicEnvironmentBuffer.getSpareList())) && this.unknownFields.equals(dynamicEnvironmentBuffer.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getDynamicEnvMsgsCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getDynamicEnvMsgsList().hashCode();
            }
            if (getSpareCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getSpareList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static DynamicEnvironmentBuffer parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static DynamicEnvironmentBuffer parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static DynamicEnvironmentBuffer parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static DynamicEnvironmentBuffer parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DynamicEnvironmentBuffer parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static DynamicEnvironmentBuffer parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static DynamicEnvironmentBuffer parseFrom(InputStream inputStream) throws IOException {
            return (DynamicEnvironmentBuffer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DynamicEnvironmentBuffer parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DynamicEnvironmentBuffer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DynamicEnvironmentBuffer parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DynamicEnvironmentBuffer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DynamicEnvironmentBuffer parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DynamicEnvironmentBuffer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DynamicEnvironmentBuffer parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DynamicEnvironmentBuffer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static DynamicEnvironmentBuffer parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DynamicEnvironmentBuffer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DynamicEnvironmentBuffer dynamicEnvironmentBuffer) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(dynamicEnvironmentBuffer);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DynamicEnvironmentBufferOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> dynamicEnvMsgsBuilder_;
            private List<DynamicEnvironment> dynamicEnvMsgs_;
            private List<Float> spare_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_fieldAccessorTable.ensureFieldAccessorsInitialized(DynamicEnvironmentBuffer.class, Builder.class);
            }

            private Builder() {
                this.dynamicEnvMsgs_ = Collections.emptyList();
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.dynamicEnvMsgs_ = Collections.emptyList();
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DynamicEnvironmentBuffer.alwaysUseFieldBuilders) {
                    getDynamicEnvMsgsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.dynamicEnvMsgs_ = Collections.emptyList();
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
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DynamicEnvironmentBuffer getDefaultInstanceForType() {
                return DynamicEnvironmentBuffer.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DynamicEnvironmentBuffer build() {
                DynamicEnvironmentBuffer buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DynamicEnvironmentBuffer buildPartial() {
                DynamicEnvironmentBuffer dynamicEnvironmentBuffer = new DynamicEnvironmentBuffer(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.dynamicEnvMsgs_ = Collections.unmodifiableList(this.dynamicEnvMsgs_);
                        this.bitField0_ &= -2;
                    }
                    dynamicEnvironmentBuffer.dynamicEnvMsgs_ = this.dynamicEnvMsgs_;
                } else {
                    dynamicEnvironmentBuffer.dynamicEnvMsgs_ = repeatedFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 2) == 2) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField0_ &= -3;
                }
                dynamicEnvironmentBuffer.spare_ = this.spare_;
                onBuilt();
                return dynamicEnvironmentBuffer;
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
                if (message instanceof DynamicEnvironmentBuffer) {
                    return mergeFrom((DynamicEnvironmentBuffer) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(DynamicEnvironmentBuffer dynamicEnvironmentBuffer) {
                if (dynamicEnvironmentBuffer == DynamicEnvironmentBuffer.getDefaultInstance()) {
                    return this;
                }
                if (this.dynamicEnvMsgsBuilder_ == null) {
                    if (!dynamicEnvironmentBuffer.dynamicEnvMsgs_.isEmpty()) {
                        if (this.dynamicEnvMsgs_.isEmpty()) {
                            this.dynamicEnvMsgs_ = dynamicEnvironmentBuffer.dynamicEnvMsgs_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDynamicEnvMsgsIsMutable();
                            this.dynamicEnvMsgs_.addAll(dynamicEnvironmentBuffer.dynamicEnvMsgs_);
                        }
                        onChanged();
                    }
                } else if (!dynamicEnvironmentBuffer.dynamicEnvMsgs_.isEmpty()) {
                    if (!this.dynamicEnvMsgsBuilder_.isEmpty()) {
                        this.dynamicEnvMsgsBuilder_.addAllMessages(dynamicEnvironmentBuffer.dynamicEnvMsgs_);
                    } else {
                        this.dynamicEnvMsgsBuilder_.dispose();
                        this.dynamicEnvMsgsBuilder_ = null;
                        this.dynamicEnvMsgs_ = dynamicEnvironmentBuffer.dynamicEnvMsgs_;
                        this.bitField0_ &= -2;
                        this.dynamicEnvMsgsBuilder_ = DynamicEnvironmentBuffer.alwaysUseFieldBuilders ? getDynamicEnvMsgsFieldBuilder() : null;
                    }
                }
                if (!dynamicEnvironmentBuffer.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = dynamicEnvironmentBuffer.spare_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(dynamicEnvironmentBuffer.spare_);
                    }
                    onChanged();
                }
                mergeUnknownFields(dynamicEnvironmentBuffer.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBuffer.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBuffer.access$10200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$DynamicEnvironmentBuffer r3 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBuffer) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$DynamicEnvironmentBuffer r4 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBuffer) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBuffer.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.DynamicEnvironmentOuterClass$DynamicEnvironmentBuffer$Builder");
            }

            private void ensureDynamicEnvMsgsIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.dynamicEnvMsgs_ = new ArrayList(this.dynamicEnvMsgs_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
            public List<DynamicEnvironment> getDynamicEnvMsgsList() {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.dynamicEnvMsgs_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
            public int getDynamicEnvMsgsCount() {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.dynamicEnvMsgs_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
            public DynamicEnvironment getDynamicEnvMsgs(int i) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.dynamicEnvMsgs_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setDynamicEnvMsgs(int i, DynamicEnvironment dynamicEnvironment) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, dynamicEnvironment);
                } else if (dynamicEnvironment == null) {
                    throw new NullPointerException();
                } else {
                    ensureDynamicEnvMsgsIsMutable();
                    this.dynamicEnvMsgs_.set(i, dynamicEnvironment);
                    onChanged();
                }
                return this;
            }

            public Builder setDynamicEnvMsgs(int i, DynamicEnvironment.Builder builder) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDynamicEnvMsgsIsMutable();
                    this.dynamicEnvMsgs_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addDynamicEnvMsgs(DynamicEnvironment dynamicEnvironment) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(dynamicEnvironment);
                } else if (dynamicEnvironment == null) {
                    throw new NullPointerException();
                } else {
                    ensureDynamicEnvMsgsIsMutable();
                    this.dynamicEnvMsgs_.add(dynamicEnvironment);
                    onChanged();
                }
                return this;
            }

            public Builder addDynamicEnvMsgs(int i, DynamicEnvironment dynamicEnvironment) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, dynamicEnvironment);
                } else if (dynamicEnvironment == null) {
                    throw new NullPointerException();
                } else {
                    ensureDynamicEnvMsgsIsMutable();
                    this.dynamicEnvMsgs_.add(i, dynamicEnvironment);
                    onChanged();
                }
                return this;
            }

            public Builder addDynamicEnvMsgs(DynamicEnvironment.Builder builder) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDynamicEnvMsgsIsMutable();
                    this.dynamicEnvMsgs_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addDynamicEnvMsgs(int i, DynamicEnvironment.Builder builder) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDynamicEnvMsgsIsMutable();
                    this.dynamicEnvMsgs_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllDynamicEnvMsgs(Iterable<? extends DynamicEnvironment> iterable) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDynamicEnvMsgsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.dynamicEnvMsgs_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearDynamicEnvMsgs() {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.dynamicEnvMsgs_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeDynamicEnvMsgs(int i) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDynamicEnvMsgsIsMutable();
                    this.dynamicEnvMsgs_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public DynamicEnvironment.Builder getDynamicEnvMsgsBuilder(int i) {
                return getDynamicEnvMsgsFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
            public DynamicEnvironmentOrBuilder getDynamicEnvMsgsOrBuilder(int i) {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.dynamicEnvMsgs_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
            public List<? extends DynamicEnvironmentOrBuilder> getDynamicEnvMsgsOrBuilderList() {
                RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> repeatedFieldBuilderV3 = this.dynamicEnvMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dynamicEnvMsgs_);
            }

            public DynamicEnvironment.Builder addDynamicEnvMsgsBuilder() {
                return getDynamicEnvMsgsFieldBuilder().addBuilder(DynamicEnvironment.getDefaultInstance());
            }

            public DynamicEnvironment.Builder addDynamicEnvMsgsBuilder(int i) {
                return getDynamicEnvMsgsFieldBuilder().addBuilder(i, DynamicEnvironment.getDefaultInstance());
            }

            public List<DynamicEnvironment.Builder> getDynamicEnvMsgsBuilderList() {
                return getDynamicEnvMsgsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DynamicEnvironment, DynamicEnvironment.Builder, DynamicEnvironmentOrBuilder> getDynamicEnvMsgsFieldBuilder() {
                if (this.dynamicEnvMsgsBuilder_ == null) {
                    this.dynamicEnvMsgsBuilder_ = new RepeatedFieldBuilderV3<>(this.dynamicEnvMsgs_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.dynamicEnvMsgs_ = null;
                }
                return this.dynamicEnvMsgsBuilder_;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.DynamicEnvironmentBufferOrBuilder
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

        public static DynamicEnvironmentBuffer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DynamicEnvironmentBuffer> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DynamicEnvironmentBuffer> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DynamicEnvironmentBuffer getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class BPoutput extends GeneratedMessageV3 implements BPoutputOrBuilder {
        public static final int BP_STATUS_FIELD_NUMBER = 37;
        public static final int BP_TO_SM10_FIELD_NUMBER = 3;
        public static final int BP_TO_SM11_FIELD_NUMBER = 4;
        public static final int BP_TO_SM12_FIELD_NUMBER = 5;
        public static final int BP_TO_SM13_FIELD_NUMBER = 6;
        public static final int BP_TO_SM14_FIELD_NUMBER = 7;
        public static final int BP_TO_SM15_FIELD_NUMBER = 8;
        public static final int BP_TO_SM16_FIELD_NUMBER = 9;
        public static final int BP_TO_SM17_FIELD_NUMBER = 18;
        public static final int BP_TO_SM18_FIELD_NUMBER = 19;
        public static final int BP_TO_SM19_FIELD_NUMBER = 20;
        public static final int BP_TO_SM1_FIELD_NUMBER = 10;
        public static final int BP_TO_SM20_FIELD_NUMBER = 21;
        public static final int BP_TO_SM21_FIELD_NUMBER = 22;
        public static final int BP_TO_SM22_FIELD_NUMBER = 23;
        public static final int BP_TO_SM23_FIELD_NUMBER = 24;
        public static final int BP_TO_SM24_FIELD_NUMBER = 25;
        public static final int BP_TO_SM25_FIELD_NUMBER = 26;
        public static final int BP_TO_SM26_FIELD_NUMBER = 27;
        public static final int BP_TO_SM27_FIELD_NUMBER = 28;
        public static final int BP_TO_SM28_FIELD_NUMBER = 29;
        public static final int BP_TO_SM29_FIELD_NUMBER = 30;
        public static final int BP_TO_SM2_FIELD_NUMBER = 11;
        public static final int BP_TO_SM30_FIELD_NUMBER = 31;
        public static final int BP_TO_SM3_FIELD_NUMBER = 12;
        public static final int BP_TO_SM4_FIELD_NUMBER = 13;
        public static final int BP_TO_SM5_FIELD_NUMBER = 14;
        public static final int BP_TO_SM6_FIELD_NUMBER = 2;
        public static final int BP_TO_SM7_FIELD_NUMBER = 15;
        public static final int BP_TO_SM8_FIELD_NUMBER = 16;
        public static final int BP_TO_SM9_FIELD_NUMBER = 17;
        public static final int EGO_RL_FRONT_DISTANCE_FIELD_NUMBER = 49;
        public static final int EMERGENCY_FIELD_NUMBER = 1;
        public static final int GAP_SEARCH_MODE_FIELD_NUMBER = 44;
        public static final int HAS_TOLL_STATION_AHEAD_FIELD_NUMBER = 48;
        public static final int HAS_TUNNEL_AHEAD_FIELD_NUMBER = 47;
        public static final int HMI_REMINDER_TYPE_FIELD_NUMBER = 42;
        public static final int LANE_CHANGE_CANCEL_REASON_FIELD_NUMBER = 41;
        public static final int LANE_CHANGE_STATUS_FIELD_NUMBER = 35;
        public static final int LANE_CURVATURE_FIELD_NUMBER = 33;
        public static final int LANE_INDEX_FROM_RIGHT_TO_LEFT_FIELD_NUMBER = 46;
        public static final int LANE_WIDTH_FIELD_NUMBER = 32;
        public static final int NGP_NOT_READY_REASON_FIELD_NUMBER = 50;
        public static final int RISK_LEVEL_FIELD_NUMBER = 43;
        public static final int SEVERE_EMERGENCY_FIELD_NUMBER = 40;
        public static final int SPARE_FIELD_NUMBER = 51;
        public static final int SPEED_LIMIT_FIELD_NUMBER = 39;
        public static final int STATE_RD_ALCCTRL_FIELD_NUMBER = 36;
        public static final int STATIC_OBSTACLE_AHEAD_FIELD_NUMBER = 45;
        public static final int TARGETACCOS_FIELD_NUMBER = 38;
        public static final int VEHICLE_TO_LANE_FIELD_NUMBER = 34;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int bitField1_;
        private int bpStatus_;
        private int bpToSm10_;
        private int bpToSm11_;
        private int bpToSm12_;
        private int bpToSm13_;
        private int bpToSm14_;
        private int bpToSm15_;
        private int bpToSm16_;
        private int bpToSm17_;
        private int bpToSm18_;
        private int bpToSm19_;
        private int bpToSm1_;
        private int bpToSm20_;
        private int bpToSm21_;
        private int bpToSm22_;
        private int bpToSm23_;
        private int bpToSm24_;
        private int bpToSm25_;
        private float bpToSm26_;
        private float bpToSm27_;
        private float bpToSm28_;
        private float bpToSm29_;
        private int bpToSm2_;
        private float bpToSm30_;
        private int bpToSm3_;
        private int bpToSm4_;
        private int bpToSm5_;
        private int bpToSm6_;
        private int bpToSm7_;
        private int bpToSm8_;
        private int bpToSm9_;
        private float egoRlFrontDistance_;
        private int emergency_;
        private int gapSearchMode_;
        private int hasTollStationAhead_;
        private int hasTunnelAhead_;
        private int hmiReminderType_;
        private int laneChangeCancelReason_;
        private int laneChangeStatus_;
        private float laneCurvature_;
        private int laneIndexFromRightToLeft_;
        private float laneWidth_;
        private byte memoizedIsInitialized;
        private int ngpNotReadyReason_;
        private int riskLevel_;
        private int severeEmergency_;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private float speedLimit_;
        private int stateRDALCCtrl_;
        private int staticObstacleAhead_;
        private boolean targetaccos_;
        private float vehicleToLane_;
        private static final BPoutput DEFAULT_INSTANCE = new BPoutput();
        private static final Parser<BPoutput> PARSER = new AbstractParser<BPoutput>() { // from class: xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutput.1
            @Override // com.google.protobuf.Parser
            public BPoutput parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new BPoutput(codedInputStream, extensionRegistryLite);
            }
        };

        private BPoutput(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private BPoutput() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.emergency_ = 0;
            this.bpToSm6_ = 0;
            this.bpToSm10_ = 0;
            this.bpToSm11_ = 0;
            this.bpToSm12_ = 0;
            this.bpToSm13_ = 0;
            this.bpToSm14_ = 0;
            this.bpToSm15_ = 0;
            this.bpToSm16_ = 0;
            this.bpToSm1_ = 0;
            this.bpToSm2_ = 0;
            this.bpToSm3_ = 0;
            this.bpToSm4_ = 0;
            this.bpToSm5_ = 0;
            this.bpToSm7_ = 0;
            this.bpToSm8_ = 0;
            this.bpToSm9_ = 0;
            this.bpToSm17_ = 0;
            this.bpToSm18_ = 0;
            this.bpToSm19_ = 0;
            this.bpToSm20_ = 0;
            this.bpToSm21_ = 0;
            this.bpToSm22_ = 0;
            this.bpToSm23_ = 0;
            this.bpToSm24_ = 0;
            this.bpToSm25_ = 0;
            this.bpToSm26_ = 0.0f;
            this.bpToSm27_ = 0.0f;
            this.bpToSm28_ = 0.0f;
            this.bpToSm29_ = 0.0f;
            this.bpToSm30_ = 0.0f;
            this.laneWidth_ = 0.0f;
            this.laneCurvature_ = 0.0f;
            this.vehicleToLane_ = 0.0f;
            this.laneChangeStatus_ = 0;
            this.stateRDALCCtrl_ = 0;
            this.bpStatus_ = 0;
            this.targetaccos_ = false;
            this.speedLimit_ = 0.0f;
            this.severeEmergency_ = 0;
            this.laneChangeCancelReason_ = 0;
            this.hmiReminderType_ = 0;
            this.riskLevel_ = 0;
            this.gapSearchMode_ = 0;
            this.staticObstacleAhead_ = 0;
            this.laneIndexFromRightToLeft_ = 0;
            this.hasTunnelAhead_ = 0;
            this.hasTollStationAhead_ = 0;
            this.egoRlFrontDistance_ = 0.0f;
            this.ngpNotReadyReason_ = 0;
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
        private BPoutput(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            int i = 0;
            while (true) {
                ?? r3 = 262144;
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
                                this.emergency_ = codedInputStream.readInt32();
                                continue;
                            case 16:
                                this.bpToSm6_ = codedInputStream.readInt32();
                                continue;
                            case 24:
                                this.bpToSm10_ = codedInputStream.readInt32();
                                continue;
                            case 32:
                                this.bpToSm11_ = codedInputStream.readInt32();
                                continue;
                            case 40:
                                this.bpToSm12_ = codedInputStream.readInt32();
                                continue;
                            case 48:
                                this.bpToSm13_ = codedInputStream.readInt32();
                                continue;
                            case 56:
                                this.bpToSm14_ = codedInputStream.readInt32();
                                continue;
                            case 64:
                                this.bpToSm15_ = codedInputStream.readInt32();
                                continue;
                            case 72:
                                this.bpToSm16_ = codedInputStream.readInt32();
                                continue;
                            case 80:
                                this.bpToSm1_ = codedInputStream.readInt32();
                                continue;
                            case 88:
                                this.bpToSm2_ = codedInputStream.readInt32();
                                continue;
                            case 96:
                                this.bpToSm3_ = codedInputStream.readInt32();
                                continue;
                            case 104:
                                this.bpToSm4_ = codedInputStream.readInt32();
                                continue;
                            case 112:
                                this.bpToSm5_ = codedInputStream.readInt32();
                                continue;
                            case 120:
                                this.bpToSm7_ = codedInputStream.readInt32();
                                continue;
                            case 128:
                                this.bpToSm8_ = codedInputStream.readInt32();
                                continue;
                            case 136:
                                this.bpToSm9_ = codedInputStream.readInt32();
                                continue;
                            case 144:
                                this.bpToSm17_ = codedInputStream.readInt32();
                                continue;
                            case 152:
                                this.bpToSm18_ = codedInputStream.readInt32();
                                continue;
                            case 160:
                                this.bpToSm19_ = codedInputStream.readInt32();
                                continue;
                            case 168:
                                this.bpToSm20_ = codedInputStream.readInt32();
                                continue;
                            case Opcodes.ARETURN /* 176 */:
                                this.bpToSm21_ = codedInputStream.readInt32();
                                continue;
                            case Opcodes.INVOKESTATIC /* 184 */:
                                this.bpToSm22_ = codedInputStream.readInt32();
                                continue;
                            case 192:
                                this.bpToSm23_ = codedInputStream.readInt32();
                                continue;
                            case 200:
                                this.bpToSm24_ = codedInputStream.readInt32();
                                continue;
                            case 208:
                                this.bpToSm25_ = codedInputStream.readInt32();
                                continue;
                            case LocTrafficSignType.LOC_TRAFFIC_SIGN_END_OF_NO_OVERTAKING /* 221 */:
                                this.bpToSm26_ = codedInputStream.readFloat();
                                continue;
                            case LocTrafficSignType.LOC_TRAFFIC_SIGN_STOP_AND_CHECK /* 229 */:
                                this.bpToSm27_ = codedInputStream.readFloat();
                                continue;
                            case LocTrafficSignType.LOC_TRAFFIC_SIGN_MIN_SPEED_LIMIT /* 237 */:
                                this.bpToSm28_ = codedInputStream.readFloat();
                                continue;
                            case 245:
                                this.bpToSm29_ = codedInputStream.readFloat();
                                continue;
                            case 253:
                                this.bpToSm30_ = codedInputStream.readFloat();
                                continue;
                            case 261:
                                this.laneWidth_ = codedInputStream.readFloat();
                                continue;
                            case SearchResultCode.G_ERR_NOLOGIN /* 269 */:
                                this.laneCurvature_ = codedInputStream.readFloat();
                                continue;
                            case 277:
                                this.vehicleToLane_ = codedInputStream.readFloat();
                                continue;
                            case 280:
                                this.laneChangeStatus_ = codedInputStream.readInt32();
                                continue;
                            case MarkUtils.MARKER_ID_RECOMMEND_PARK_2 /* 288 */:
                                this.stateRDALCCtrl_ = codedInputStream.readInt32();
                                continue;
                            case MarkUtils.MARKER_ID_TIE_1 /* 296 */:
                                this.bpStatus_ = codedInputStream.readInt32();
                                continue;
                            case 304:
                                this.targetaccos_ = codedInputStream.readBool();
                                continue;
                            case 317:
                                this.speedLimit_ = codedInputStream.readFloat();
                                continue;
                            case 320:
                                this.severeEmergency_ = codedInputStream.readInt32();
                                continue;
                            case LocTrafficSignType.LOC_TRAFFIC_SIGN_BUS_LANE /* 328 */:
                                this.laneChangeCancelReason_ = codedInputStream.readInt32();
                                continue;
                            case LocTrafficSignType.LOC_TRAFFIC_SIGN_CARRIAGEWAY /* 336 */:
                                this.hmiReminderType_ = codedInputStream.readInt32();
                                continue;
                            case RegionCode.REGION_CODE_HKG /* 344 */:
                                this.riskLevel_ = codedInputStream.readInt32();
                                continue;
                            case 352:
                                this.gapSearchMode_ = codedInputStream.readInt32();
                                continue;
                            case MarkUtils.MARKER_ID_BUBBLE_VIA_CHARGE /* 360 */:
                                this.staticObstacleAhead_ = codedInputStream.readInt32();
                                continue;
                            case MarkUtils.MARKER_ID_FAVOURITE_FOCUS /* 368 */:
                                this.laneIndexFromRightToLeft_ = codedInputStream.readInt32();
                                continue;
                            case 376:
                                this.hasTunnelAhead_ = codedInputStream.readInt32();
                                continue;
                            case 384:
                                this.hasTollStationAhead_ = codedInputStream.readInt32();
                                continue;
                            case 397:
                                this.egoRlFrontDistance_ = codedInputStream.readFloat();
                                continue;
                            case 400:
                                this.ngpNotReadyReason_ = codedInputStream.readInt32();
                                continue;
                            case SpeechNaviEvent.SPEECH_SWITCH_MAP_MODE /* 410 */:
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i & 262144) != 262144 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.spare_ = new ArrayList();
                                    i |= 262144;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.spare_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit);
                                continue;
                                break;
                            case 413:
                                if ((i & 262144) != 262144) {
                                    this.spare_ = new ArrayList();
                                    i |= 262144;
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
                    if ((i & r3) == r3) {
                        this.spare_ = Collections.unmodifiableList(this.spare_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_BPoutput_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_BPoutput_fieldAccessorTable.ensureFieldAccessorsInitialized(BPoutput.class, Builder.class);
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getEmergency() {
            return this.emergency_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm6() {
            return this.bpToSm6_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm10() {
            return this.bpToSm10_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm11() {
            return this.bpToSm11_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm12() {
            return this.bpToSm12_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm13() {
            return this.bpToSm13_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm14() {
            return this.bpToSm14_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm15() {
            return this.bpToSm15_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm16() {
            return this.bpToSm16_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm1() {
            return this.bpToSm1_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm2() {
            return this.bpToSm2_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm3() {
            return this.bpToSm3_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm4() {
            return this.bpToSm4_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm5() {
            return this.bpToSm5_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm7() {
            return this.bpToSm7_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm8() {
            return this.bpToSm8_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm9() {
            return this.bpToSm9_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm17() {
            return this.bpToSm17_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm18() {
            return this.bpToSm18_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm19() {
            return this.bpToSm19_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm20() {
            return this.bpToSm20_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm21() {
            return this.bpToSm21_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm22() {
            return this.bpToSm22_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm23() {
            return this.bpToSm23_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm24() {
            return this.bpToSm24_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpToSm25() {
            return this.bpToSm25_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getBpToSm26() {
            return this.bpToSm26_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getBpToSm27() {
            return this.bpToSm27_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getBpToSm28() {
            return this.bpToSm28_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getBpToSm29() {
            return this.bpToSm29_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getBpToSm30() {
            return this.bpToSm30_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getLaneWidth() {
            return this.laneWidth_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getLaneCurvature() {
            return this.laneCurvature_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getVehicleToLane() {
            return this.vehicleToLane_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getLaneChangeStatus() {
            return this.laneChangeStatus_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getStateRDALCCtrl() {
            return this.stateRDALCCtrl_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getBpStatus() {
            return this.bpStatus_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public boolean getTargetaccos() {
            return this.targetaccos_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getSpeedLimit() {
            return this.speedLimit_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getSevereEmergency() {
            return this.severeEmergency_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getLaneChangeCancelReason() {
            return this.laneChangeCancelReason_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getHmiReminderType() {
            return this.hmiReminderType_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getRiskLevel() {
            return this.riskLevel_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getGapSearchMode() {
            return this.gapSearchMode_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getStaticObstacleAhead() {
            return this.staticObstacleAhead_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getLaneIndexFromRightToLeft() {
            return this.laneIndexFromRightToLeft_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getHasTunnelAhead() {
            return this.hasTunnelAhead_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getHasTollStationAhead() {
            return this.hasTollStationAhead_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public float getEgoRlFrontDistance() {
            return this.egoRlFrontDistance_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getNgpNotReadyReason() {
            return this.ngpNotReadyReason_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
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
            int i = this.emergency_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            int i2 = this.bpToSm6_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            int i3 = this.bpToSm10_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
            int i4 = this.bpToSm11_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(4, i4);
            }
            int i5 = this.bpToSm12_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(5, i5);
            }
            int i6 = this.bpToSm13_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(6, i6);
            }
            int i7 = this.bpToSm14_;
            if (i7 != 0) {
                codedOutputStream.writeInt32(7, i7);
            }
            int i8 = this.bpToSm15_;
            if (i8 != 0) {
                codedOutputStream.writeInt32(8, i8);
            }
            int i9 = this.bpToSm16_;
            if (i9 != 0) {
                codedOutputStream.writeInt32(9, i9);
            }
            int i10 = this.bpToSm1_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(10, i10);
            }
            int i11 = this.bpToSm2_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(11, i11);
            }
            int i12 = this.bpToSm3_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(12, i12);
            }
            int i13 = this.bpToSm4_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(13, i13);
            }
            int i14 = this.bpToSm5_;
            if (i14 != 0) {
                codedOutputStream.writeInt32(14, i14);
            }
            int i15 = this.bpToSm7_;
            if (i15 != 0) {
                codedOutputStream.writeInt32(15, i15);
            }
            int i16 = this.bpToSm8_;
            if (i16 != 0) {
                codedOutputStream.writeInt32(16, i16);
            }
            int i17 = this.bpToSm9_;
            if (i17 != 0) {
                codedOutputStream.writeInt32(17, i17);
            }
            int i18 = this.bpToSm17_;
            if (i18 != 0) {
                codedOutputStream.writeInt32(18, i18);
            }
            int i19 = this.bpToSm18_;
            if (i19 != 0) {
                codedOutputStream.writeInt32(19, i19);
            }
            int i20 = this.bpToSm19_;
            if (i20 != 0) {
                codedOutputStream.writeInt32(20, i20);
            }
            int i21 = this.bpToSm20_;
            if (i21 != 0) {
                codedOutputStream.writeInt32(21, i21);
            }
            int i22 = this.bpToSm21_;
            if (i22 != 0) {
                codedOutputStream.writeInt32(22, i22);
            }
            int i23 = this.bpToSm22_;
            if (i23 != 0) {
                codedOutputStream.writeInt32(23, i23);
            }
            int i24 = this.bpToSm23_;
            if (i24 != 0) {
                codedOutputStream.writeInt32(24, i24);
            }
            int i25 = this.bpToSm24_;
            if (i25 != 0) {
                codedOutputStream.writeInt32(25, i25);
            }
            int i26 = this.bpToSm25_;
            if (i26 != 0) {
                codedOutputStream.writeInt32(26, i26);
            }
            float f = this.bpToSm26_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(27, f);
            }
            float f2 = this.bpToSm27_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(28, f2);
            }
            float f3 = this.bpToSm28_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(29, f3);
            }
            float f4 = this.bpToSm29_;
            if (f4 != 0.0f) {
                codedOutputStream.writeFloat(30, f4);
            }
            float f5 = this.bpToSm30_;
            if (f5 != 0.0f) {
                codedOutputStream.writeFloat(31, f5);
            }
            float f6 = this.laneWidth_;
            if (f6 != 0.0f) {
                codedOutputStream.writeFloat(32, f6);
            }
            float f7 = this.laneCurvature_;
            if (f7 != 0.0f) {
                codedOutputStream.writeFloat(33, f7);
            }
            float f8 = this.vehicleToLane_;
            if (f8 != 0.0f) {
                codedOutputStream.writeFloat(34, f8);
            }
            int i27 = this.laneChangeStatus_;
            if (i27 != 0) {
                codedOutputStream.writeInt32(35, i27);
            }
            int i28 = this.stateRDALCCtrl_;
            if (i28 != 0) {
                codedOutputStream.writeInt32(36, i28);
            }
            int i29 = this.bpStatus_;
            if (i29 != 0) {
                codedOutputStream.writeInt32(37, i29);
            }
            boolean z = this.targetaccos_;
            if (z) {
                codedOutputStream.writeBool(38, z);
            }
            float f9 = this.speedLimit_;
            if (f9 != 0.0f) {
                codedOutputStream.writeFloat(39, f9);
            }
            int i30 = this.severeEmergency_;
            if (i30 != 0) {
                codedOutputStream.writeInt32(40, i30);
            }
            int i31 = this.laneChangeCancelReason_;
            if (i31 != 0) {
                codedOutputStream.writeInt32(41, i31);
            }
            int i32 = this.hmiReminderType_;
            if (i32 != 0) {
                codedOutputStream.writeInt32(42, i32);
            }
            int i33 = this.riskLevel_;
            if (i33 != 0) {
                codedOutputStream.writeInt32(43, i33);
            }
            int i34 = this.gapSearchMode_;
            if (i34 != 0) {
                codedOutputStream.writeInt32(44, i34);
            }
            int i35 = this.staticObstacleAhead_;
            if (i35 != 0) {
                codedOutputStream.writeInt32(45, i35);
            }
            int i36 = this.laneIndexFromRightToLeft_;
            if (i36 != 0) {
                codedOutputStream.writeInt32(46, i36);
            }
            int i37 = this.hasTunnelAhead_;
            if (i37 != 0) {
                codedOutputStream.writeInt32(47, i37);
            }
            int i38 = this.hasTollStationAhead_;
            if (i38 != 0) {
                codedOutputStream.writeInt32(48, i38);
            }
            float f10 = this.egoRlFrontDistance_;
            if (f10 != 0.0f) {
                codedOutputStream.writeFloat(49, f10);
            }
            int i39 = this.ngpNotReadyReason_;
            if (i39 != 0) {
                codedOutputStream.writeInt32(50, i39);
            }
            if (getSpareList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(SpeechNaviEvent.SPEECH_SWITCH_MAP_MODE);
                codedOutputStream.writeUInt32NoTag(this.spareMemoizedSerializedSize);
            }
            for (int i40 = 0; i40 < this.spare_.size(); i40++) {
                codedOutputStream.writeFloatNoTag(this.spare_.get(i40).floatValue());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.emergency_;
            int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.bpToSm6_;
            if (i3 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.bpToSm10_;
            if (i4 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
            }
            int i5 = this.bpToSm11_;
            if (i5 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, i5);
            }
            int i6 = this.bpToSm12_;
            if (i6 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, i6);
            }
            int i7 = this.bpToSm13_;
            if (i7 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, i7);
            }
            int i8 = this.bpToSm14_;
            if (i8 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, i8);
            }
            int i9 = this.bpToSm15_;
            if (i9 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, i9);
            }
            int i10 = this.bpToSm16_;
            if (i10 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, i10);
            }
            int i11 = this.bpToSm1_;
            if (i11 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(10, i11);
            }
            int i12 = this.bpToSm2_;
            if (i12 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, i12);
            }
            int i13 = this.bpToSm3_;
            if (i13 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(12, i13);
            }
            int i14 = this.bpToSm4_;
            if (i14 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(13, i14);
            }
            int i15 = this.bpToSm5_;
            if (i15 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(14, i15);
            }
            int i16 = this.bpToSm7_;
            if (i16 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(15, i16);
            }
            int i17 = this.bpToSm8_;
            if (i17 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(16, i17);
            }
            int i18 = this.bpToSm9_;
            if (i18 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(17, i18);
            }
            int i19 = this.bpToSm17_;
            if (i19 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(18, i19);
            }
            int i20 = this.bpToSm18_;
            if (i20 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(19, i20);
            }
            int i21 = this.bpToSm19_;
            if (i21 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(20, i21);
            }
            int i22 = this.bpToSm20_;
            if (i22 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(21, i22);
            }
            int i23 = this.bpToSm21_;
            if (i23 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(22, i23);
            }
            int i24 = this.bpToSm22_;
            if (i24 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(23, i24);
            }
            int i25 = this.bpToSm23_;
            if (i25 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(24, i25);
            }
            int i26 = this.bpToSm24_;
            if (i26 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(25, i26);
            }
            int i27 = this.bpToSm25_;
            if (i27 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(26, i27);
            }
            float f = this.bpToSm26_;
            if (f != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(27, f);
            }
            float f2 = this.bpToSm27_;
            if (f2 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(28, f2);
            }
            float f3 = this.bpToSm28_;
            if (f3 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(29, f3);
            }
            float f4 = this.bpToSm29_;
            if (f4 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(30, f4);
            }
            float f5 = this.bpToSm30_;
            if (f5 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(31, f5);
            }
            float f6 = this.laneWidth_;
            if (f6 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(32, f6);
            }
            float f7 = this.laneCurvature_;
            if (f7 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(33, f7);
            }
            float f8 = this.vehicleToLane_;
            if (f8 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(34, f8);
            }
            int i28 = this.laneChangeStatus_;
            if (i28 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(35, i28);
            }
            int i29 = this.stateRDALCCtrl_;
            if (i29 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(36, i29);
            }
            int i30 = this.bpStatus_;
            if (i30 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(37, i30);
            }
            boolean z = this.targetaccos_;
            if (z) {
                computeInt32Size += CodedOutputStream.computeBoolSize(38, z);
            }
            float f9 = this.speedLimit_;
            if (f9 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(39, f9);
            }
            int i31 = this.severeEmergency_;
            if (i31 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(40, i31);
            }
            int i32 = this.laneChangeCancelReason_;
            if (i32 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(41, i32);
            }
            int i33 = this.hmiReminderType_;
            if (i33 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(42, i33);
            }
            int i34 = this.riskLevel_;
            if (i34 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(43, i34);
            }
            int i35 = this.gapSearchMode_;
            if (i35 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(44, i35);
            }
            int i36 = this.staticObstacleAhead_;
            if (i36 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(45, i36);
            }
            int i37 = this.laneIndexFromRightToLeft_;
            if (i37 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(46, i37);
            }
            int i38 = this.hasTunnelAhead_;
            if (i38 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(47, i38);
            }
            int i39 = this.hasTollStationAhead_;
            if (i39 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(48, i39);
            }
            float f10 = this.egoRlFrontDistance_;
            if (f10 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(49, f10);
            }
            int i40 = this.ngpNotReadyReason_;
            if (i40 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(50, i40);
            }
            int size = getSpareList().size() * 4;
            int i41 = computeInt32Size + size;
            if (!getSpareList().isEmpty()) {
                i41 = i41 + 2 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.spareMemoizedSerializedSize = size;
            int serializedSize = i41 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BPoutput)) {
                return super.equals(obj);
            }
            BPoutput bPoutput = (BPoutput) obj;
            return (((((((((((((((((((((((((((((((((((((((((((((((((((getEmergency() == bPoutput.getEmergency()) && getBpToSm6() == bPoutput.getBpToSm6()) && getBpToSm10() == bPoutput.getBpToSm10()) && getBpToSm11() == bPoutput.getBpToSm11()) && getBpToSm12() == bPoutput.getBpToSm12()) && getBpToSm13() == bPoutput.getBpToSm13()) && getBpToSm14() == bPoutput.getBpToSm14()) && getBpToSm15() == bPoutput.getBpToSm15()) && getBpToSm16() == bPoutput.getBpToSm16()) && getBpToSm1() == bPoutput.getBpToSm1()) && getBpToSm2() == bPoutput.getBpToSm2()) && getBpToSm3() == bPoutput.getBpToSm3()) && getBpToSm4() == bPoutput.getBpToSm4()) && getBpToSm5() == bPoutput.getBpToSm5()) && getBpToSm7() == bPoutput.getBpToSm7()) && getBpToSm8() == bPoutput.getBpToSm8()) && getBpToSm9() == bPoutput.getBpToSm9()) && getBpToSm17() == bPoutput.getBpToSm17()) && getBpToSm18() == bPoutput.getBpToSm18()) && getBpToSm19() == bPoutput.getBpToSm19()) && getBpToSm20() == bPoutput.getBpToSm20()) && getBpToSm21() == bPoutput.getBpToSm21()) && getBpToSm22() == bPoutput.getBpToSm22()) && getBpToSm23() == bPoutput.getBpToSm23()) && getBpToSm24() == bPoutput.getBpToSm24()) && getBpToSm25() == bPoutput.getBpToSm25()) && Float.floatToIntBits(getBpToSm26()) == Float.floatToIntBits(bPoutput.getBpToSm26())) && Float.floatToIntBits(getBpToSm27()) == Float.floatToIntBits(bPoutput.getBpToSm27())) && Float.floatToIntBits(getBpToSm28()) == Float.floatToIntBits(bPoutput.getBpToSm28())) && Float.floatToIntBits(getBpToSm29()) == Float.floatToIntBits(bPoutput.getBpToSm29())) && Float.floatToIntBits(getBpToSm30()) == Float.floatToIntBits(bPoutput.getBpToSm30())) && Float.floatToIntBits(getLaneWidth()) == Float.floatToIntBits(bPoutput.getLaneWidth())) && Float.floatToIntBits(getLaneCurvature()) == Float.floatToIntBits(bPoutput.getLaneCurvature())) && Float.floatToIntBits(getVehicleToLane()) == Float.floatToIntBits(bPoutput.getVehicleToLane())) && getLaneChangeStatus() == bPoutput.getLaneChangeStatus()) && getStateRDALCCtrl() == bPoutput.getStateRDALCCtrl()) && getBpStatus() == bPoutput.getBpStatus()) && getTargetaccos() == bPoutput.getTargetaccos()) && Float.floatToIntBits(getSpeedLimit()) == Float.floatToIntBits(bPoutput.getSpeedLimit())) && getSevereEmergency() == bPoutput.getSevereEmergency()) && getLaneChangeCancelReason() == bPoutput.getLaneChangeCancelReason()) && getHmiReminderType() == bPoutput.getHmiReminderType()) && getRiskLevel() == bPoutput.getRiskLevel()) && getGapSearchMode() == bPoutput.getGapSearchMode()) && getStaticObstacleAhead() == bPoutput.getStaticObstacleAhead()) && getLaneIndexFromRightToLeft() == bPoutput.getLaneIndexFromRightToLeft()) && getHasTunnelAhead() == bPoutput.getHasTunnelAhead()) && getHasTollStationAhead() == bPoutput.getHasTollStationAhead()) && Float.floatToIntBits(getEgoRlFrontDistance()) == Float.floatToIntBits(bPoutput.getEgoRlFrontDistance())) && getNgpNotReadyReason() == bPoutput.getNgpNotReadyReason()) && getSpareList().equals(bPoutput.getSpareList())) && this.unknownFields.equals(bPoutput.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getEmergency()) * 37) + 2) * 53) + getBpToSm6()) * 37) + 3) * 53) + getBpToSm10()) * 37) + 4) * 53) + getBpToSm11()) * 37) + 5) * 53) + getBpToSm12()) * 37) + 6) * 53) + getBpToSm13()) * 37) + 7) * 53) + getBpToSm14()) * 37) + 8) * 53) + getBpToSm15()) * 37) + 9) * 53) + getBpToSm16()) * 37) + 10) * 53) + getBpToSm1()) * 37) + 11) * 53) + getBpToSm2()) * 37) + 12) * 53) + getBpToSm3()) * 37) + 13) * 53) + getBpToSm4()) * 37) + 14) * 53) + getBpToSm5()) * 37) + 15) * 53) + getBpToSm7()) * 37) + 16) * 53) + getBpToSm8()) * 37) + 17) * 53) + getBpToSm9()) * 37) + 18) * 53) + getBpToSm17()) * 37) + 19) * 53) + getBpToSm18()) * 37) + 20) * 53) + getBpToSm19()) * 37) + 21) * 53) + getBpToSm20()) * 37) + 22) * 53) + getBpToSm21()) * 37) + 23) * 53) + getBpToSm22()) * 37) + 24) * 53) + getBpToSm23()) * 37) + 25) * 53) + getBpToSm24()) * 37) + 26) * 53) + getBpToSm25()) * 37) + 27) * 53) + Float.floatToIntBits(getBpToSm26())) * 37) + 28) * 53) + Float.floatToIntBits(getBpToSm27())) * 37) + 29) * 53) + Float.floatToIntBits(getBpToSm28())) * 37) + 30) * 53) + Float.floatToIntBits(getBpToSm29())) * 37) + 31) * 53) + Float.floatToIntBits(getBpToSm30())) * 37) + 32) * 53) + Float.floatToIntBits(getLaneWidth())) * 37) + 33) * 53) + Float.floatToIntBits(getLaneCurvature())) * 37) + 34) * 53) + Float.floatToIntBits(getVehicleToLane())) * 37) + 35) * 53) + getLaneChangeStatus()) * 37) + 36) * 53) + getStateRDALCCtrl()) * 37) + 37) * 53) + getBpStatus()) * 37) + 38) * 53) + Internal.hashBoolean(getTargetaccos())) * 37) + 39) * 53) + Float.floatToIntBits(getSpeedLimit())) * 37) + 40) * 53) + getSevereEmergency()) * 37) + 41) * 53) + getLaneChangeCancelReason()) * 37) + 42) * 53) + getHmiReminderType()) * 37) + 43) * 53) + getRiskLevel()) * 37) + 44) * 53) + getGapSearchMode()) * 37) + 45) * 53) + getStaticObstacleAhead()) * 37) + 46) * 53) + getLaneIndexFromRightToLeft()) * 37) + 47) * 53) + getHasTunnelAhead()) * 37) + 48) * 53) + getHasTollStationAhead()) * 37) + 49) * 53) + Float.floatToIntBits(getEgoRlFrontDistance())) * 37) + 50) * 53) + getNgpNotReadyReason();
            if (getSpareCount() > 0) {
                hashCode = (((hashCode * 37) + 51) * 53) + getSpareList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static BPoutput parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static BPoutput parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static BPoutput parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static BPoutput parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static BPoutput parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static BPoutput parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static BPoutput parseFrom(InputStream inputStream) throws IOException {
            return (BPoutput) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static BPoutput parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BPoutput) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BPoutput parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BPoutput) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BPoutput parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BPoutput) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BPoutput parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BPoutput) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static BPoutput parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BPoutput) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BPoutput bPoutput) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(bPoutput);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BPoutputOrBuilder {
            private int bitField0_;
            private int bitField1_;
            private int bpStatus_;
            private int bpToSm10_;
            private int bpToSm11_;
            private int bpToSm12_;
            private int bpToSm13_;
            private int bpToSm14_;
            private int bpToSm15_;
            private int bpToSm16_;
            private int bpToSm17_;
            private int bpToSm18_;
            private int bpToSm19_;
            private int bpToSm1_;
            private int bpToSm20_;
            private int bpToSm21_;
            private int bpToSm22_;
            private int bpToSm23_;
            private int bpToSm24_;
            private int bpToSm25_;
            private float bpToSm26_;
            private float bpToSm27_;
            private float bpToSm28_;
            private float bpToSm29_;
            private int bpToSm2_;
            private float bpToSm30_;
            private int bpToSm3_;
            private int bpToSm4_;
            private int bpToSm5_;
            private int bpToSm6_;
            private int bpToSm7_;
            private int bpToSm8_;
            private int bpToSm9_;
            private float egoRlFrontDistance_;
            private int emergency_;
            private int gapSearchMode_;
            private int hasTollStationAhead_;
            private int hasTunnelAhead_;
            private int hmiReminderType_;
            private int laneChangeCancelReason_;
            private int laneChangeStatus_;
            private float laneCurvature_;
            private int laneIndexFromRightToLeft_;
            private float laneWidth_;
            private int ngpNotReadyReason_;
            private int riskLevel_;
            private int severeEmergency_;
            private List<Float> spare_;
            private float speedLimit_;
            private int stateRDALCCtrl_;
            private int staticObstacleAhead_;
            private boolean targetaccos_;
            private float vehicleToLane_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_BPoutput_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_BPoutput_fieldAccessorTable.ensureFieldAccessorsInitialized(BPoutput.class, Builder.class);
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
                boolean unused = BPoutput.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.emergency_ = 0;
                this.bpToSm6_ = 0;
                this.bpToSm10_ = 0;
                this.bpToSm11_ = 0;
                this.bpToSm12_ = 0;
                this.bpToSm13_ = 0;
                this.bpToSm14_ = 0;
                this.bpToSm15_ = 0;
                this.bpToSm16_ = 0;
                this.bpToSm1_ = 0;
                this.bpToSm2_ = 0;
                this.bpToSm3_ = 0;
                this.bpToSm4_ = 0;
                this.bpToSm5_ = 0;
                this.bpToSm7_ = 0;
                this.bpToSm8_ = 0;
                this.bpToSm9_ = 0;
                this.bpToSm17_ = 0;
                this.bpToSm18_ = 0;
                this.bpToSm19_ = 0;
                this.bpToSm20_ = 0;
                this.bpToSm21_ = 0;
                this.bpToSm22_ = 0;
                this.bpToSm23_ = 0;
                this.bpToSm24_ = 0;
                this.bpToSm25_ = 0;
                this.bpToSm26_ = 0.0f;
                this.bpToSm27_ = 0.0f;
                this.bpToSm28_ = 0.0f;
                this.bpToSm29_ = 0.0f;
                this.bpToSm30_ = 0.0f;
                this.laneWidth_ = 0.0f;
                this.laneCurvature_ = 0.0f;
                this.vehicleToLane_ = 0.0f;
                this.laneChangeStatus_ = 0;
                this.stateRDALCCtrl_ = 0;
                this.bpStatus_ = 0;
                this.targetaccos_ = false;
                this.speedLimit_ = 0.0f;
                this.severeEmergency_ = 0;
                this.laneChangeCancelReason_ = 0;
                this.hmiReminderType_ = 0;
                this.riskLevel_ = 0;
                this.gapSearchMode_ = 0;
                this.staticObstacleAhead_ = 0;
                this.laneIndexFromRightToLeft_ = 0;
                this.hasTunnelAhead_ = 0;
                this.hasTollStationAhead_ = 0;
                this.egoRlFrontDistance_ = 0.0f;
                this.ngpNotReadyReason_ = 0;
                this.spare_ = Collections.emptyList();
                this.bitField1_ &= -262145;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DynamicEnvironmentOuterClass.internal_static_xpilot_sr_proto_BPoutput_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BPoutput getDefaultInstanceForType() {
                return BPoutput.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BPoutput build() {
                BPoutput buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BPoutput buildPartial() {
                BPoutput bPoutput = new BPoutput(this);
                int i = this.bitField0_;
                int i2 = this.bitField1_;
                bPoutput.emergency_ = this.emergency_;
                bPoutput.bpToSm6_ = this.bpToSm6_;
                bPoutput.bpToSm10_ = this.bpToSm10_;
                bPoutput.bpToSm11_ = this.bpToSm11_;
                bPoutput.bpToSm12_ = this.bpToSm12_;
                bPoutput.bpToSm13_ = this.bpToSm13_;
                bPoutput.bpToSm14_ = this.bpToSm14_;
                bPoutput.bpToSm15_ = this.bpToSm15_;
                bPoutput.bpToSm16_ = this.bpToSm16_;
                bPoutput.bpToSm1_ = this.bpToSm1_;
                bPoutput.bpToSm2_ = this.bpToSm2_;
                bPoutput.bpToSm3_ = this.bpToSm3_;
                bPoutput.bpToSm4_ = this.bpToSm4_;
                bPoutput.bpToSm5_ = this.bpToSm5_;
                bPoutput.bpToSm7_ = this.bpToSm7_;
                bPoutput.bpToSm8_ = this.bpToSm8_;
                bPoutput.bpToSm9_ = this.bpToSm9_;
                bPoutput.bpToSm17_ = this.bpToSm17_;
                bPoutput.bpToSm18_ = this.bpToSm18_;
                bPoutput.bpToSm19_ = this.bpToSm19_;
                bPoutput.bpToSm20_ = this.bpToSm20_;
                bPoutput.bpToSm21_ = this.bpToSm21_;
                bPoutput.bpToSm22_ = this.bpToSm22_;
                bPoutput.bpToSm23_ = this.bpToSm23_;
                bPoutput.bpToSm24_ = this.bpToSm24_;
                bPoutput.bpToSm25_ = this.bpToSm25_;
                bPoutput.bpToSm26_ = this.bpToSm26_;
                bPoutput.bpToSm27_ = this.bpToSm27_;
                bPoutput.bpToSm28_ = this.bpToSm28_;
                bPoutput.bpToSm29_ = this.bpToSm29_;
                bPoutput.bpToSm30_ = this.bpToSm30_;
                bPoutput.laneWidth_ = this.laneWidth_;
                bPoutput.laneCurvature_ = this.laneCurvature_;
                bPoutput.vehicleToLane_ = this.vehicleToLane_;
                bPoutput.laneChangeStatus_ = this.laneChangeStatus_;
                bPoutput.stateRDALCCtrl_ = this.stateRDALCCtrl_;
                bPoutput.bpStatus_ = this.bpStatus_;
                bPoutput.targetaccos_ = this.targetaccos_;
                bPoutput.speedLimit_ = this.speedLimit_;
                bPoutput.severeEmergency_ = this.severeEmergency_;
                bPoutput.laneChangeCancelReason_ = this.laneChangeCancelReason_;
                bPoutput.hmiReminderType_ = this.hmiReminderType_;
                bPoutput.riskLevel_ = this.riskLevel_;
                bPoutput.gapSearchMode_ = this.gapSearchMode_;
                bPoutput.staticObstacleAhead_ = this.staticObstacleAhead_;
                bPoutput.laneIndexFromRightToLeft_ = this.laneIndexFromRightToLeft_;
                bPoutput.hasTunnelAhead_ = this.hasTunnelAhead_;
                bPoutput.hasTollStationAhead_ = this.hasTollStationAhead_;
                bPoutput.egoRlFrontDistance_ = this.egoRlFrontDistance_;
                bPoutput.ngpNotReadyReason_ = this.ngpNotReadyReason_;
                if ((this.bitField1_ & 262144) == 262144) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField1_ &= -262145;
                }
                bPoutput.spare_ = this.spare_;
                bPoutput.bitField0_ = 0;
                bPoutput.bitField1_ = 0;
                onBuilt();
                return bPoutput;
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
                if (message instanceof BPoutput) {
                    return mergeFrom((BPoutput) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(BPoutput bPoutput) {
                if (bPoutput == BPoutput.getDefaultInstance()) {
                    return this;
                }
                if (bPoutput.getEmergency() != 0) {
                    setEmergency(bPoutput.getEmergency());
                }
                if (bPoutput.getBpToSm6() != 0) {
                    setBpToSm6(bPoutput.getBpToSm6());
                }
                if (bPoutput.getBpToSm10() != 0) {
                    setBpToSm10(bPoutput.getBpToSm10());
                }
                if (bPoutput.getBpToSm11() != 0) {
                    setBpToSm11(bPoutput.getBpToSm11());
                }
                if (bPoutput.getBpToSm12() != 0) {
                    setBpToSm12(bPoutput.getBpToSm12());
                }
                if (bPoutput.getBpToSm13() != 0) {
                    setBpToSm13(bPoutput.getBpToSm13());
                }
                if (bPoutput.getBpToSm14() != 0) {
                    setBpToSm14(bPoutput.getBpToSm14());
                }
                if (bPoutput.getBpToSm15() != 0) {
                    setBpToSm15(bPoutput.getBpToSm15());
                }
                if (bPoutput.getBpToSm16() != 0) {
                    setBpToSm16(bPoutput.getBpToSm16());
                }
                if (bPoutput.getBpToSm1() != 0) {
                    setBpToSm1(bPoutput.getBpToSm1());
                }
                if (bPoutput.getBpToSm2() != 0) {
                    setBpToSm2(bPoutput.getBpToSm2());
                }
                if (bPoutput.getBpToSm3() != 0) {
                    setBpToSm3(bPoutput.getBpToSm3());
                }
                if (bPoutput.getBpToSm4() != 0) {
                    setBpToSm4(bPoutput.getBpToSm4());
                }
                if (bPoutput.getBpToSm5() != 0) {
                    setBpToSm5(bPoutput.getBpToSm5());
                }
                if (bPoutput.getBpToSm7() != 0) {
                    setBpToSm7(bPoutput.getBpToSm7());
                }
                if (bPoutput.getBpToSm8() != 0) {
                    setBpToSm8(bPoutput.getBpToSm8());
                }
                if (bPoutput.getBpToSm9() != 0) {
                    setBpToSm9(bPoutput.getBpToSm9());
                }
                if (bPoutput.getBpToSm17() != 0) {
                    setBpToSm17(bPoutput.getBpToSm17());
                }
                if (bPoutput.getBpToSm18() != 0) {
                    setBpToSm18(bPoutput.getBpToSm18());
                }
                if (bPoutput.getBpToSm19() != 0) {
                    setBpToSm19(bPoutput.getBpToSm19());
                }
                if (bPoutput.getBpToSm20() != 0) {
                    setBpToSm20(bPoutput.getBpToSm20());
                }
                if (bPoutput.getBpToSm21() != 0) {
                    setBpToSm21(bPoutput.getBpToSm21());
                }
                if (bPoutput.getBpToSm22() != 0) {
                    setBpToSm22(bPoutput.getBpToSm22());
                }
                if (bPoutput.getBpToSm23() != 0) {
                    setBpToSm23(bPoutput.getBpToSm23());
                }
                if (bPoutput.getBpToSm24() != 0) {
                    setBpToSm24(bPoutput.getBpToSm24());
                }
                if (bPoutput.getBpToSm25() != 0) {
                    setBpToSm25(bPoutput.getBpToSm25());
                }
                if (bPoutput.getBpToSm26() != 0.0f) {
                    setBpToSm26(bPoutput.getBpToSm26());
                }
                if (bPoutput.getBpToSm27() != 0.0f) {
                    setBpToSm27(bPoutput.getBpToSm27());
                }
                if (bPoutput.getBpToSm28() != 0.0f) {
                    setBpToSm28(bPoutput.getBpToSm28());
                }
                if (bPoutput.getBpToSm29() != 0.0f) {
                    setBpToSm29(bPoutput.getBpToSm29());
                }
                if (bPoutput.getBpToSm30() != 0.0f) {
                    setBpToSm30(bPoutput.getBpToSm30());
                }
                if (bPoutput.getLaneWidth() != 0.0f) {
                    setLaneWidth(bPoutput.getLaneWidth());
                }
                if (bPoutput.getLaneCurvature() != 0.0f) {
                    setLaneCurvature(bPoutput.getLaneCurvature());
                }
                if (bPoutput.getVehicleToLane() != 0.0f) {
                    setVehicleToLane(bPoutput.getVehicleToLane());
                }
                if (bPoutput.getLaneChangeStatus() != 0) {
                    setLaneChangeStatus(bPoutput.getLaneChangeStatus());
                }
                if (bPoutput.getStateRDALCCtrl() != 0) {
                    setStateRDALCCtrl(bPoutput.getStateRDALCCtrl());
                }
                if (bPoutput.getBpStatus() != 0) {
                    setBpStatus(bPoutput.getBpStatus());
                }
                if (bPoutput.getTargetaccos()) {
                    setTargetaccos(bPoutput.getTargetaccos());
                }
                if (bPoutput.getSpeedLimit() != 0.0f) {
                    setSpeedLimit(bPoutput.getSpeedLimit());
                }
                if (bPoutput.getSevereEmergency() != 0) {
                    setSevereEmergency(bPoutput.getSevereEmergency());
                }
                if (bPoutput.getLaneChangeCancelReason() != 0) {
                    setLaneChangeCancelReason(bPoutput.getLaneChangeCancelReason());
                }
                if (bPoutput.getHmiReminderType() != 0) {
                    setHmiReminderType(bPoutput.getHmiReminderType());
                }
                if (bPoutput.getRiskLevel() != 0) {
                    setRiskLevel(bPoutput.getRiskLevel());
                }
                if (bPoutput.getGapSearchMode() != 0) {
                    setGapSearchMode(bPoutput.getGapSearchMode());
                }
                if (bPoutput.getStaticObstacleAhead() != 0) {
                    setStaticObstacleAhead(bPoutput.getStaticObstacleAhead());
                }
                if (bPoutput.getLaneIndexFromRightToLeft() != 0) {
                    setLaneIndexFromRightToLeft(bPoutput.getLaneIndexFromRightToLeft());
                }
                if (bPoutput.getHasTunnelAhead() != 0) {
                    setHasTunnelAhead(bPoutput.getHasTunnelAhead());
                }
                if (bPoutput.getHasTollStationAhead() != 0) {
                    setHasTollStationAhead(bPoutput.getHasTollStationAhead());
                }
                if (bPoutput.getEgoRlFrontDistance() != 0.0f) {
                    setEgoRlFrontDistance(bPoutput.getEgoRlFrontDistance());
                }
                if (bPoutput.getNgpNotReadyReason() != 0) {
                    setNgpNotReadyReason(bPoutput.getNgpNotReadyReason());
                }
                if (!bPoutput.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = bPoutput.spare_;
                        this.bitField1_ &= -262145;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(bPoutput.spare_);
                    }
                    onChanged();
                }
                mergeUnknownFields(bPoutput.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutput.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutput.access$16400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$BPoutput r3 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutput) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.DynamicEnvironmentOuterClass$BPoutput r4 = (xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutput) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutput.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.DynamicEnvironmentOuterClass$BPoutput$Builder");
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getEmergency() {
                return this.emergency_;
            }

            public Builder setEmergency(int i) {
                this.emergency_ = i;
                onChanged();
                return this;
            }

            public Builder clearEmergency() {
                this.emergency_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm6() {
                return this.bpToSm6_;
            }

            public Builder setBpToSm6(int i) {
                this.bpToSm6_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm6() {
                this.bpToSm6_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm10() {
                return this.bpToSm10_;
            }

            public Builder setBpToSm10(int i) {
                this.bpToSm10_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm10() {
                this.bpToSm10_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm11() {
                return this.bpToSm11_;
            }

            public Builder setBpToSm11(int i) {
                this.bpToSm11_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm11() {
                this.bpToSm11_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm12() {
                return this.bpToSm12_;
            }

            public Builder setBpToSm12(int i) {
                this.bpToSm12_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm12() {
                this.bpToSm12_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm13() {
                return this.bpToSm13_;
            }

            public Builder setBpToSm13(int i) {
                this.bpToSm13_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm13() {
                this.bpToSm13_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm14() {
                return this.bpToSm14_;
            }

            public Builder setBpToSm14(int i) {
                this.bpToSm14_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm14() {
                this.bpToSm14_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm15() {
                return this.bpToSm15_;
            }

            public Builder setBpToSm15(int i) {
                this.bpToSm15_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm15() {
                this.bpToSm15_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm16() {
                return this.bpToSm16_;
            }

            public Builder setBpToSm16(int i) {
                this.bpToSm16_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm16() {
                this.bpToSm16_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm1() {
                return this.bpToSm1_;
            }

            public Builder setBpToSm1(int i) {
                this.bpToSm1_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm1() {
                this.bpToSm1_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm2() {
                return this.bpToSm2_;
            }

            public Builder setBpToSm2(int i) {
                this.bpToSm2_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm2() {
                this.bpToSm2_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm3() {
                return this.bpToSm3_;
            }

            public Builder setBpToSm3(int i) {
                this.bpToSm3_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm3() {
                this.bpToSm3_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm4() {
                return this.bpToSm4_;
            }

            public Builder setBpToSm4(int i) {
                this.bpToSm4_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm4() {
                this.bpToSm4_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm5() {
                return this.bpToSm5_;
            }

            public Builder setBpToSm5(int i) {
                this.bpToSm5_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm5() {
                this.bpToSm5_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm7() {
                return this.bpToSm7_;
            }

            public Builder setBpToSm7(int i) {
                this.bpToSm7_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm7() {
                this.bpToSm7_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm8() {
                return this.bpToSm8_;
            }

            public Builder setBpToSm8(int i) {
                this.bpToSm8_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm8() {
                this.bpToSm8_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm9() {
                return this.bpToSm9_;
            }

            public Builder setBpToSm9(int i) {
                this.bpToSm9_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm9() {
                this.bpToSm9_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm17() {
                return this.bpToSm17_;
            }

            public Builder setBpToSm17(int i) {
                this.bpToSm17_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm17() {
                this.bpToSm17_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm18() {
                return this.bpToSm18_;
            }

            public Builder setBpToSm18(int i) {
                this.bpToSm18_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm18() {
                this.bpToSm18_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm19() {
                return this.bpToSm19_;
            }

            public Builder setBpToSm19(int i) {
                this.bpToSm19_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm19() {
                this.bpToSm19_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm20() {
                return this.bpToSm20_;
            }

            public Builder setBpToSm20(int i) {
                this.bpToSm20_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm20() {
                this.bpToSm20_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm21() {
                return this.bpToSm21_;
            }

            public Builder setBpToSm21(int i) {
                this.bpToSm21_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm21() {
                this.bpToSm21_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm22() {
                return this.bpToSm22_;
            }

            public Builder setBpToSm22(int i) {
                this.bpToSm22_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm22() {
                this.bpToSm22_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm23() {
                return this.bpToSm23_;
            }

            public Builder setBpToSm23(int i) {
                this.bpToSm23_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm23() {
                this.bpToSm23_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm24() {
                return this.bpToSm24_;
            }

            public Builder setBpToSm24(int i) {
                this.bpToSm24_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm24() {
                this.bpToSm24_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpToSm25() {
                return this.bpToSm25_;
            }

            public Builder setBpToSm25(int i) {
                this.bpToSm25_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpToSm25() {
                this.bpToSm25_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public float getBpToSm26() {
                return this.bpToSm26_;
            }

            public Builder setBpToSm26(float f) {
                this.bpToSm26_ = f;
                onChanged();
                return this;
            }

            public Builder clearBpToSm26() {
                this.bpToSm26_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public float getBpToSm27() {
                return this.bpToSm27_;
            }

            public Builder setBpToSm27(float f) {
                this.bpToSm27_ = f;
                onChanged();
                return this;
            }

            public Builder clearBpToSm27() {
                this.bpToSm27_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public float getBpToSm28() {
                return this.bpToSm28_;
            }

            public Builder setBpToSm28(float f) {
                this.bpToSm28_ = f;
                onChanged();
                return this;
            }

            public Builder clearBpToSm28() {
                this.bpToSm28_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public float getBpToSm29() {
                return this.bpToSm29_;
            }

            public Builder setBpToSm29(float f) {
                this.bpToSm29_ = f;
                onChanged();
                return this;
            }

            public Builder clearBpToSm29() {
                this.bpToSm29_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public float getBpToSm30() {
                return this.bpToSm30_;
            }

            public Builder setBpToSm30(float f) {
                this.bpToSm30_ = f;
                onChanged();
                return this;
            }

            public Builder clearBpToSm30() {
                this.bpToSm30_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public float getLaneWidth() {
                return this.laneWidth_;
            }

            public Builder setLaneWidth(float f) {
                this.laneWidth_ = f;
                onChanged();
                return this;
            }

            public Builder clearLaneWidth() {
                this.laneWidth_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public float getLaneCurvature() {
                return this.laneCurvature_;
            }

            public Builder setLaneCurvature(float f) {
                this.laneCurvature_ = f;
                onChanged();
                return this;
            }

            public Builder clearLaneCurvature() {
                this.laneCurvature_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public float getVehicleToLane() {
                return this.vehicleToLane_;
            }

            public Builder setVehicleToLane(float f) {
                this.vehicleToLane_ = f;
                onChanged();
                return this;
            }

            public Builder clearVehicleToLane() {
                this.vehicleToLane_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getLaneChangeStatus() {
                return this.laneChangeStatus_;
            }

            public Builder setLaneChangeStatus(int i) {
                this.laneChangeStatus_ = i;
                onChanged();
                return this;
            }

            public Builder clearLaneChangeStatus() {
                this.laneChangeStatus_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getStateRDALCCtrl() {
                return this.stateRDALCCtrl_;
            }

            public Builder setStateRDALCCtrl(int i) {
                this.stateRDALCCtrl_ = i;
                onChanged();
                return this;
            }

            public Builder clearStateRDALCCtrl() {
                this.stateRDALCCtrl_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getBpStatus() {
                return this.bpStatus_;
            }

            public Builder setBpStatus(int i) {
                this.bpStatus_ = i;
                onChanged();
                return this;
            }

            public Builder clearBpStatus() {
                this.bpStatus_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public boolean getTargetaccos() {
                return this.targetaccos_;
            }

            public Builder setTargetaccos(boolean z) {
                this.targetaccos_ = z;
                onChanged();
                return this;
            }

            public Builder clearTargetaccos() {
                this.targetaccos_ = false;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
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

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getSevereEmergency() {
                return this.severeEmergency_;
            }

            public Builder setSevereEmergency(int i) {
                this.severeEmergency_ = i;
                onChanged();
                return this;
            }

            public Builder clearSevereEmergency() {
                this.severeEmergency_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getLaneChangeCancelReason() {
                return this.laneChangeCancelReason_;
            }

            public Builder setLaneChangeCancelReason(int i) {
                this.laneChangeCancelReason_ = i;
                onChanged();
                return this;
            }

            public Builder clearLaneChangeCancelReason() {
                this.laneChangeCancelReason_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getHmiReminderType() {
                return this.hmiReminderType_;
            }

            public Builder setHmiReminderType(int i) {
                this.hmiReminderType_ = i;
                onChanged();
                return this;
            }

            public Builder clearHmiReminderType() {
                this.hmiReminderType_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getRiskLevel() {
                return this.riskLevel_;
            }

            public Builder setRiskLevel(int i) {
                this.riskLevel_ = i;
                onChanged();
                return this;
            }

            public Builder clearRiskLevel() {
                this.riskLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getGapSearchMode() {
                return this.gapSearchMode_;
            }

            public Builder setGapSearchMode(int i) {
                this.gapSearchMode_ = i;
                onChanged();
                return this;
            }

            public Builder clearGapSearchMode() {
                this.gapSearchMode_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getStaticObstacleAhead() {
                return this.staticObstacleAhead_;
            }

            public Builder setStaticObstacleAhead(int i) {
                this.staticObstacleAhead_ = i;
                onChanged();
                return this;
            }

            public Builder clearStaticObstacleAhead() {
                this.staticObstacleAhead_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getLaneIndexFromRightToLeft() {
                return this.laneIndexFromRightToLeft_;
            }

            public Builder setLaneIndexFromRightToLeft(int i) {
                this.laneIndexFromRightToLeft_ = i;
                onChanged();
                return this;
            }

            public Builder clearLaneIndexFromRightToLeft() {
                this.laneIndexFromRightToLeft_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getHasTunnelAhead() {
                return this.hasTunnelAhead_;
            }

            public Builder setHasTunnelAhead(int i) {
                this.hasTunnelAhead_ = i;
                onChanged();
                return this;
            }

            public Builder clearHasTunnelAhead() {
                this.hasTunnelAhead_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getHasTollStationAhead() {
                return this.hasTollStationAhead_;
            }

            public Builder setHasTollStationAhead(int i) {
                this.hasTollStationAhead_ = i;
                onChanged();
                return this;
            }

            public Builder clearHasTollStationAhead() {
                this.hasTollStationAhead_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public float getEgoRlFrontDistance() {
                return this.egoRlFrontDistance_;
            }

            public Builder setEgoRlFrontDistance(float f) {
                this.egoRlFrontDistance_ = f;
                onChanged();
                return this;
            }

            public Builder clearEgoRlFrontDistance() {
                this.egoRlFrontDistance_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getNgpNotReadyReason() {
                return this.ngpNotReadyReason_;
            }

            public Builder setNgpNotReadyReason(int i) {
                this.ngpNotReadyReason_ = i;
                onChanged();
                return this;
            }

            public Builder clearNgpNotReadyReason() {
                this.ngpNotReadyReason_ = 0;
                onChanged();
                return this;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField1_ & 262144) != 262144) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField1_ |= 262144;
                }
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.DynamicEnvironmentOuterClass.BPoutputOrBuilder
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
                this.bitField1_ &= -262145;
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

        public static BPoutput getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BPoutput> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BPoutput> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BPoutput getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019dynamic_environment.proto\u0012\u000fxpilot.sr.proto\u001a\u0010primitives.proto\"ù\u0002\n\bSfObject\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012%\n\u0004size\u0018\u0002 \u0001(\u000b2\u0017.xpilot.sr.proto.Size3D\u0012)\n\u0004type\u0018\u0003 \u0001(\u000e2\u001b.xpilot.sr.proto.ObjectType\u00122\n\fsignal_light\u0018\u0004 \u0001(\u000e2\u001c.xpilot.sr.proto.SignalLight\u00120\n\u000bbrake_light\u0018\u0005 \u0001(\u000e2\u001b.xpilot.sr.proto.BrakeLight\u0012\u0012\n\nlocal_pose\u0018\u0006 \u0003(\u0002\u0012\u0016\n\u000elocal_velocity\u0018\u0007 \u0003(\u0002\u0012\u001a\n\u0012local_acceleration\u0018\b \u0003(\u0002\u0012\u0018\n\u0010local_pose_sigma\u0018\t \u0003(\u0002\u0012\u001c\n\u0014local_velocity_sigma\u0018\n \u0003(\u0002\u0012\u001c\n\u0014XPU_CDU_Veh1_StatusD\u0018\u000b \u0001(\u0005\u0012\u000b\n\u0003isp\u0018\f \u0001(\u0005\"l\n\fPredictPoint\u0012(\n\ttimestamp\u0018\u0001 \u0001(\u000b2\u0015.xpilot.sr.proto.Time\u0012\u0016\n\u000epredicted_pose\u0018\u0002 \u0003(\u0002\u0012\u001a\n\u0012uncertation_radius\u0018\u0003 \u0001(\u0002\"Z\n\u0010PredictIntention\u0012\u0013\n\u000bprobability\u0018\u0001 \u0001(\u0002\u00121\n\ntrajectory\u0018\u0002 \u0003(\u000b2\u001d.xpilot.sr.proto.PredictPoint\"|\n\u0011SfbpDynamicObject\u0012.\n\u000bsf_snapshot\u0018\u0001 \u0001(\u000b2\u0019.xpilot.sr.proto.SfObject\u00127\n\fbp_intention\u0018\u0002 \u0003(\u000b2!.xpilot.sr.proto.PredictIntention\"\u008a\u0001\n\u0010SfbpStaticObject\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012/\n\u0004type\u0018\u0002 \u0001(\u000e2!.xpilot.sr.proto.StaticObjectType\u0012%\n\u0004size\u0018\u0003 \u0001(\u000b2\u0017.xpilot.sr.proto.Size3D\u0012\u0012\n\nlocal_pose\u0018\u0004 \u0003(\u0002\"õ\u0001\n\u0012DynamicEnvironment\u0012(\n\ttimestamp\u0018\u0001 \u0001(\u000b2\u0015.xpilot.sr.proto.Time\u0012.\n\nego_motion\u0018\u0002 \u0001(\u000b2\u001a.xpilot.sr.proto.EgoMotion\u0012\u0010\n\bis_split\u0018\u0003 \u0001(\b\u00127\n\u000bsfbp_object\u0018\u0004 \u0003(\u000b2\".xpilot.sr.proto.SfbpDynamicObject\u0012:\n\u000fsfbp_sta_object\u0018\u0005 \u0003(\u000b2!.xpilot.sr.proto.SfbpStaticObject\"h\n\u0018DynamicEnvironmentBuffer\u0012=\n\u0010dynamic_env_msgs\u0018\u0001 \u0003(\u000b2#.xpilot.sr.proto.DynamicEnvironment\u0012\r\n\u0005spare\u0018\u0002 \u0003(\u0002\"õ\b\n\bBPoutput\u0012\u0011\n\temergency\u0018\u0001 \u0001(\u0005\u0012\u0011\n\tbp_to_sm6\u0018\u0002 \u0001(\u0005\u0012\u0012\n\nbp_to_sm10\u0018\u0003 \u0001(\u0005\u0012\u0012\n\nbp_to_sm11\u0018\u0004 \u0001(\u0005\u0012\u0012\n\nbp_to_sm12\u0018\u0005 \u0001(\u0005\u0012\u0012\n\nbp_to_sm13\u0018\u0006 \u0001(\u0005\u0012\u0012\n\nbp_to_sm14\u0018\u0007 \u0001(\u0005\u0012\u0012\n\nbp_to_sm15\u0018\b \u0001(\u0005\u0012\u0012\n\nbp_to_sm16\u0018\t \u0001(\u0005\u0012\u0011\n\tbp_to_sm1\u0018\n \u0001(\u0005\u0012\u0011\n\tbp_to_sm2\u0018\u000b \u0001(\u0005\u0012\u0011\n\tbp_to_sm3\u0018\f \u0001(\u0005\u0012\u0011\n\tbp_to_sm4\u0018\r \u0001(\u0005\u0012\u0011\n\tbp_to_sm5\u0018\u000e \u0001(\u0005\u0012\u0011\n\tbp_to_sm7\u0018\u000f \u0001(\u0005\u0012\u0011\n\tbp_to_sm8\u0018\u0010 \u0001(\u0005\u0012\u0011\n\tbp_to_sm9\u0018\u0011 \u0001(\u0005\u0012\u0012\n\nbp_to_sm17\u0018\u0012 \u0001(\u0005\u0012\u0012\n\nbp_to_sm18\u0018\u0013 \u0001(\u0005\u0012\u0012\n\nbp_to_sm19\u0018\u0014 \u0001(\u0005\u0012\u0012\n\nbp_to_sm20\u0018\u0015 \u0001(\u0005\u0012\u0012\n\nbp_to_sm21\u0018\u0016 \u0001(\u0005\u0012\u0012\n\nbp_to_sm22\u0018\u0017 \u0001(\u0005\u0012\u0012\n\nbp_to_sm23\u0018\u0018 \u0001(\u0005\u0012\u0012\n\nbp_to_sm24\u0018\u0019 \u0001(\u0005\u0012\u0012\n\nbp_to_sm25\u0018\u001a \u0001(\u0005\u0012\u0012\n\nbp_to_sm26\u0018\u001b \u0001(\u0002\u0012\u0012\n\nbp_to_sm27\u0018\u001c \u0001(\u0002\u0012\u0012\n\nbp_to_sm28\u0018\u001d \u0001(\u0002\u0012\u0012\n\nbp_to_sm29\u0018\u001e \u0001(\u0002\u0012\u0012\n\nbp_to_sm30\u0018\u001f \u0001(\u0002\u0012\u0012\n\nlane_width\u0018  \u0001(\u0002\u0012\u0016\n\u000elane_curvature\u0018! \u0001(\u0002\u0012\u0017\n\u000fvehicle_to_lane\u0018\" \u0001(\u0002\u0012\u001a\n\u0012lane_change_status\u0018# \u0001(\u0005\u0012\u0018\n\u0010State_RD_ALCCtrl\u0018$ \u0001(\u0005\u0012\u0011\n\tbp_status\u0018% \u0001(\u0005\u0012\u0013\n\u000btargetaccos\u0018& \u0001(\b\u0012\u0013\n\u000bspeed_limit\u0018' \u0001(\u0002\u0012\u0018\n\u0010severe_emergency\u0018( \u0001(\u0005\u0012!\n\u0019lane_change_cancel_reason\u0018) \u0001(\u0005\u0012\u0019\n\u0011hmi_reminder_type\u0018* \u0001(\u0005\u0012\u0012\n\nrisk_level\u0018+ \u0001(\u0005\u0012\u0017\n\u000fgap_search_mode\u0018, \u0001(\u0005\u0012\u001d\n\u0015static_obstacle_ahead\u0018- \u0001(\u0005\u0012%\n\u001dlane_index_from_right_to_left\u0018. \u0001(\u0005\u0012\u0018\n\u0010has_tunnel_ahead\u0018/ \u0001(\u0005\u0012\u001e\n\u0016has_toll_station_ahead\u00180 \u0001(\u0005\u0012\u001d\n\u0015ego_rl_front_distance\u00181 \u0001(\u0002\u0012\u001c\n\u0014ngp_not_ready_reason\u00182 \u0001(\u0005\u0012\r\n\u0005spare\u00183 \u0003(\u0002b\u0006proto3"}, new Descriptors.FileDescriptor[]{Primitives.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.DynamicEnvironmentOuterClass.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = DynamicEnvironmentOuterClass.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_SfObject_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_SfObject_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_SfObject_descriptor, new String[]{"Id", "Size", "Type", "SignalLight", "BrakeLight", "LocalPose", "LocalVelocity", "LocalAcceleration", "LocalPoseSigma", "LocalVelocitySigma", "XPUCDUVeh1StatusD", "Isp"});
        internal_static_xpilot_sr_proto_PredictPoint_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_xpilot_sr_proto_PredictPoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_PredictPoint_descriptor, new String[]{"Timestamp", "PredictedPose", "UncertationRadius"});
        internal_static_xpilot_sr_proto_PredictIntention_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_xpilot_sr_proto_PredictIntention_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_PredictIntention_descriptor, new String[]{"Probability", "Trajectory"});
        internal_static_xpilot_sr_proto_SfbpDynamicObject_descriptor = getDescriptor().getMessageTypes().get(3);
        internal_static_xpilot_sr_proto_SfbpDynamicObject_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_SfbpDynamicObject_descriptor, new String[]{"SfSnapshot", "BpIntention"});
        internal_static_xpilot_sr_proto_SfbpStaticObject_descriptor = getDescriptor().getMessageTypes().get(4);
        internal_static_xpilot_sr_proto_SfbpStaticObject_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_SfbpStaticObject_descriptor, new String[]{"Id", "Type", "Size", "LocalPose"});
        internal_static_xpilot_sr_proto_DynamicEnvironment_descriptor = getDescriptor().getMessageTypes().get(5);
        internal_static_xpilot_sr_proto_DynamicEnvironment_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_DynamicEnvironment_descriptor, new String[]{"Timestamp", "EgoMotion", "IsSplit", "SfbpObject", "SfbpStaObject"});
        internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_descriptor = getDescriptor().getMessageTypes().get(6);
        internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_DynamicEnvironmentBuffer_descriptor, new String[]{"DynamicEnvMsgs", "Spare"});
        internal_static_xpilot_sr_proto_BPoutput_descriptor = getDescriptor().getMessageTypes().get(7);
        internal_static_xpilot_sr_proto_BPoutput_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_BPoutput_descriptor, new String[]{"Emergency", "BpToSm6", "BpToSm10", "BpToSm11", "BpToSm12", "BpToSm13", "BpToSm14", "BpToSm15", "BpToSm16", "BpToSm1", "BpToSm2", "BpToSm3", "BpToSm4", "BpToSm5", "BpToSm7", "BpToSm8", "BpToSm9", "BpToSm17", "BpToSm18", "BpToSm19", "BpToSm20", "BpToSm21", "BpToSm22", "BpToSm23", "BpToSm24", "BpToSm25", "BpToSm26", "BpToSm27", "BpToSm28", "BpToSm29", "BpToSm30", "LaneWidth", "LaneCurvature", "VehicleToLane", "LaneChangeStatus", "StateRDALCCtrl", "BpStatus", "Targetaccos", "SpeedLimit", "SevereEmergency", "LaneChangeCancelReason", "HmiReminderType", "RiskLevel", "GapSearchMode", "StaticObstacleAhead", "LaneIndexFromRightToLeft", "HasTunnelAhead", "HasTollStationAhead", "EgoRlFrontDistance", "NgpNotReadyReason", "Spare"});
        Primitives.getDescriptor();
    }
}
