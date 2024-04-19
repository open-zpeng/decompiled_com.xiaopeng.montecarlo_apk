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
import xpilot.sr.proto.Primitives;
/* loaded from: classes4.dex */
public final class LocalPose {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_LocalPoseInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_LocalPoseInfo_fieldAccessorTable;

    /* loaded from: classes4.dex */
    public interface LocalPoseInfoBufferOrBuilder extends MessageOrBuilder {
        LocalPoseInfo getLocalPoseMsgs(int i);

        int getLocalPoseMsgsCount();

        List<LocalPoseInfo> getLocalPoseMsgsList();

        LocalPoseInfoOrBuilder getLocalPoseMsgsOrBuilder(int i);

        List<? extends LocalPoseInfoOrBuilder> getLocalPoseMsgsOrBuilderList();
    }

    /* loaded from: classes4.dex */
    public interface LocalPoseInfoOrBuilder extends MessageOrBuilder {
        LocalFrameStatus getLocFrameStatus();

        int getLocFrameStatusValue();

        Primitives.Time getLocFrameTime();

        Primitives.TimeOrBuilder getLocFrameTimeOrBuilder();

        Primitives.Pose6DOF getLocFrameTransfoem();

        Primitives.Pose6DOFOrBuilder getLocFrameTransfoemOrBuilder();

        Primitives.Pose6DOF getLocalPose();

        Primitives.Pose6DOFOrBuilder getLocalPoseOrBuilder();

        Primitives.Vector3D getLocalPoseStd();

        Primitives.Vector3DOrBuilder getLocalPoseStdOrBuilder();

        Primitives.Vector3D getLocalVelocity();

        Primitives.Vector3DOrBuilder getLocalVelocityOrBuilder();

        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();

        Primitives.Time getTimestamp();

        Primitives.TimeOrBuilder getTimestampOrBuilder();

        float getVehAccelStd();

        float getVehAcceleration();

        float getVehSpeed();

        float getVehSpeedStd();

        int getXPUSRView();

        boolean hasLocFrameTime();

        boolean hasLocFrameTransfoem();

        boolean hasLocalPose();

        boolean hasLocalPoseStd();

        boolean hasLocalVelocity();

        boolean hasTimestamp();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private LocalPose() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes4.dex */
    public enum LocalFrameStatus implements ProtocolMessageEnum {
        SAME_AS_LAST_PUBLISHED(0),
        DIFF_FROM_LAST_PUBLISHED(1),
        UNRECOGNIZED(-1);
        
        public static final int DIFF_FROM_LAST_PUBLISHED_VALUE = 1;
        public static final int SAME_AS_LAST_PUBLISHED_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<LocalFrameStatus> internalValueMap = new Internal.EnumLiteMap<LocalFrameStatus>() { // from class: xpilot.sr.proto.LocalPose.LocalFrameStatus.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LocalFrameStatus findValueByNumber(int i) {
                return LocalFrameStatus.forNumber(i);
            }
        };
        private static final LocalFrameStatus[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static LocalFrameStatus valueOf(int i) {
            return forNumber(i);
        }

        public static LocalFrameStatus forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return DIFF_FROM_LAST_PUBLISHED;
            }
            return SAME_AS_LAST_PUBLISHED;
        }

        public static Internal.EnumLiteMap<LocalFrameStatus> internalGetValueMap() {
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
            return LocalPose.getDescriptor().getEnumTypes().get(0);
        }

        public static LocalFrameStatus valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        LocalFrameStatus(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public static final class LocalPoseInfo extends GeneratedMessageV3 implements LocalPoseInfoOrBuilder {
        public static final int LOCAL_POSE_FIELD_NUMBER = 2;
        public static final int LOCAL_POSE_STD_FIELD_NUMBER = 4;
        public static final int LOCAL_VELOCITY_FIELD_NUMBER = 3;
        public static final int LOC_FRAME_STATUS_FIELD_NUMBER = 9;
        public static final int LOC_FRAME_TIME_FIELD_NUMBER = 11;
        public static final int LOC_FRAME_TRANSFOEM_FIELD_NUMBER = 10;
        public static final int SPARE_FIELD_NUMBER = 13;
        public static final int TIMESTAMP_FIELD_NUMBER = 1;
        public static final int VEH_ACCELERATION_FIELD_NUMBER = 6;
        public static final int VEH_ACCEL_STD_FIELD_NUMBER = 8;
        public static final int VEH_SPEED_FIELD_NUMBER = 5;
        public static final int VEH_SPEED_STD_FIELD_NUMBER = 7;
        public static final int XPU_SR_VIEW_FIELD_NUMBER = 12;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int locFrameStatus_;
        private Primitives.Time locFrameTime_;
        private Primitives.Pose6DOF locFrameTransfoem_;
        private Primitives.Vector3D localPoseStd_;
        private Primitives.Pose6DOF localPose_;
        private Primitives.Vector3D localVelocity_;
        private byte memoizedIsInitialized;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private Primitives.Time timestamp_;
        private float vehAccelStd_;
        private float vehAcceleration_;
        private float vehSpeedStd_;
        private float vehSpeed_;
        private int xPUSRView_;
        private static final LocalPoseInfo DEFAULT_INSTANCE = new LocalPoseInfo();
        private static final Parser<LocalPoseInfo> PARSER = new AbstractParser<LocalPoseInfo>() { // from class: xpilot.sr.proto.LocalPose.LocalPoseInfo.1
            @Override // com.google.protobuf.Parser
            public LocalPoseInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LocalPoseInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private LocalPoseInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private LocalPoseInfo() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.vehSpeed_ = 0.0f;
            this.vehAcceleration_ = 0.0f;
            this.vehSpeedStd_ = 0.0f;
            this.vehAccelStd_ = 0.0f;
            this.locFrameStatus_ = 0;
            this.xPUSRView_ = 0;
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
        private LocalPoseInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r3 = 4096;
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
                                Primitives.Time.Builder builder = this.timestamp_ != null ? this.timestamp_.toBuilder() : null;
                                this.timestamp_ = (Primitives.Time) codedInputStream.readMessage(Primitives.Time.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.timestamp_);
                                    this.timestamp_ = builder.buildPartial();
                                } else {
                                    continue;
                                }
                            case 18:
                                Primitives.Pose6DOF.Builder builder2 = this.localPose_ != null ? this.localPose_.toBuilder() : null;
                                this.localPose_ = (Primitives.Pose6DOF) codedInputStream.readMessage(Primitives.Pose6DOF.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.localPose_);
                                    this.localPose_ = builder2.buildPartial();
                                } else {
                                    continue;
                                }
                            case 26:
                                Primitives.Vector3D.Builder builder3 = this.localVelocity_ != null ? this.localVelocity_.toBuilder() : null;
                                this.localVelocity_ = (Primitives.Vector3D) codedInputStream.readMessage(Primitives.Vector3D.parser(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.localVelocity_);
                                    this.localVelocity_ = builder3.buildPartial();
                                } else {
                                    continue;
                                }
                            case 34:
                                Primitives.Vector3D.Builder builder4 = this.localPoseStd_ != null ? this.localPoseStd_.toBuilder() : null;
                                this.localPoseStd_ = (Primitives.Vector3D) codedInputStream.readMessage(Primitives.Vector3D.parser(), extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom(this.localPoseStd_);
                                    this.localPoseStd_ = builder4.buildPartial();
                                } else {
                                    continue;
                                }
                            case 45:
                                this.vehSpeed_ = codedInputStream.readFloat();
                                continue;
                            case 53:
                                this.vehAcceleration_ = codedInputStream.readFloat();
                                continue;
                            case 61:
                                this.vehSpeedStd_ = codedInputStream.readFloat();
                                continue;
                            case 69:
                                this.vehAccelStd_ = codedInputStream.readFloat();
                                continue;
                            case 72:
                                this.locFrameStatus_ = codedInputStream.readEnum();
                                continue;
                            case 82:
                                Primitives.Pose6DOF.Builder builder5 = this.locFrameTransfoem_ != null ? this.locFrameTransfoem_.toBuilder() : null;
                                this.locFrameTransfoem_ = (Primitives.Pose6DOF) codedInputStream.readMessage(Primitives.Pose6DOF.parser(), extensionRegistryLite);
                                if (builder5 != null) {
                                    builder5.mergeFrom(this.locFrameTransfoem_);
                                    this.locFrameTransfoem_ = builder5.buildPartial();
                                } else {
                                    continue;
                                }
                            case 90:
                                Primitives.Time.Builder builder6 = this.locFrameTime_ != null ? this.locFrameTime_.toBuilder() : null;
                                this.locFrameTime_ = (Primitives.Time) codedInputStream.readMessage(Primitives.Time.parser(), extensionRegistryLite);
                                if (builder6 != null) {
                                    builder6.mergeFrom(this.locFrameTime_);
                                    this.locFrameTime_ = builder6.buildPartial();
                                } else {
                                    continue;
                                }
                            case 96:
                                this.xPUSRView_ = codedInputStream.readInt32();
                                continue;
                            case 106:
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
                                continue;
                            case 109:
                                boolean z4 = (z2 ? 1 : 0) & true;
                                z2 = z2;
                                if (!z4) {
                                    this.spare_ = new ArrayList();
                                    z2 = (z2 ? 1 : 0) | true;
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
                    if (((z2 ? 1 : 0) & true) == r3) {
                        this.spare_ = Collections.unmodifiableList(this.spare_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LocalPoseInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public boolean hasTimestamp() {
            return this.timestamp_ != null;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Time getTimestamp() {
            Primitives.Time time = this.timestamp_;
            return time == null ? Primitives.Time.getDefaultInstance() : time;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.TimeOrBuilder getTimestampOrBuilder() {
            return getTimestamp();
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public boolean hasLocalPose() {
            return this.localPose_ != null;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Pose6DOF getLocalPose() {
            Primitives.Pose6DOF pose6DOF = this.localPose_;
            return pose6DOF == null ? Primitives.Pose6DOF.getDefaultInstance() : pose6DOF;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Pose6DOFOrBuilder getLocalPoseOrBuilder() {
            return getLocalPose();
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public boolean hasLocalVelocity() {
            return this.localVelocity_ != null;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Vector3D getLocalVelocity() {
            Primitives.Vector3D vector3D = this.localVelocity_;
            return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Vector3DOrBuilder getLocalVelocityOrBuilder() {
            return getLocalVelocity();
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public boolean hasLocalPoseStd() {
            return this.localPoseStd_ != null;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Vector3D getLocalPoseStd() {
            Primitives.Vector3D vector3D = this.localPoseStd_;
            return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Vector3DOrBuilder getLocalPoseStdOrBuilder() {
            return getLocalPoseStd();
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public float getVehSpeed() {
            return this.vehSpeed_;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public float getVehAcceleration() {
            return this.vehAcceleration_;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public float getVehSpeedStd() {
            return this.vehSpeedStd_;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public float getVehAccelStd() {
            return this.vehAccelStd_;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public int getLocFrameStatusValue() {
            return this.locFrameStatus_;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public LocalFrameStatus getLocFrameStatus() {
            LocalFrameStatus valueOf = LocalFrameStatus.valueOf(this.locFrameStatus_);
            return valueOf == null ? LocalFrameStatus.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public boolean hasLocFrameTransfoem() {
            return this.locFrameTransfoem_ != null;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Pose6DOF getLocFrameTransfoem() {
            Primitives.Pose6DOF pose6DOF = this.locFrameTransfoem_;
            return pose6DOF == null ? Primitives.Pose6DOF.getDefaultInstance() : pose6DOF;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Pose6DOFOrBuilder getLocFrameTransfoemOrBuilder() {
            return getLocFrameTransfoem();
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public boolean hasLocFrameTime() {
            return this.locFrameTime_ != null;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.Time getLocFrameTime() {
            Primitives.Time time = this.locFrameTime_;
            return time == null ? Primitives.Time.getDefaultInstance() : time;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public Primitives.TimeOrBuilder getLocFrameTimeOrBuilder() {
            return getLocFrameTime();
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public int getXPUSRView() {
            return this.xPUSRView_;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
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
            if (this.timestamp_ != null) {
                codedOutputStream.writeMessage(1, getTimestamp());
            }
            if (this.localPose_ != null) {
                codedOutputStream.writeMessage(2, getLocalPose());
            }
            if (this.localVelocity_ != null) {
                codedOutputStream.writeMessage(3, getLocalVelocity());
            }
            if (this.localPoseStd_ != null) {
                codedOutputStream.writeMessage(4, getLocalPoseStd());
            }
            float f = this.vehSpeed_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(5, f);
            }
            float f2 = this.vehAcceleration_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(6, f2);
            }
            float f3 = this.vehSpeedStd_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(7, f3);
            }
            float f4 = this.vehAccelStd_;
            if (f4 != 0.0f) {
                codedOutputStream.writeFloat(8, f4);
            }
            if (this.locFrameStatus_ != LocalFrameStatus.SAME_AS_LAST_PUBLISHED.getNumber()) {
                codedOutputStream.writeEnum(9, this.locFrameStatus_);
            }
            if (this.locFrameTransfoem_ != null) {
                codedOutputStream.writeMessage(10, getLocFrameTransfoem());
            }
            if (this.locFrameTime_ != null) {
                codedOutputStream.writeMessage(11, getLocFrameTime());
            }
            int i = this.xPUSRView_;
            if (i != 0) {
                codedOutputStream.writeInt32(12, i);
            }
            if (getSpareList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(106);
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
            int computeMessageSize = this.timestamp_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getTimestamp()) : 0;
            if (this.localPose_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getLocalPose());
            }
            if (this.localVelocity_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, getLocalVelocity());
            }
            if (this.localPoseStd_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, getLocalPoseStd());
            }
            float f = this.vehSpeed_;
            if (f != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(5, f);
            }
            float f2 = this.vehAcceleration_;
            if (f2 != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(6, f2);
            }
            float f3 = this.vehSpeedStd_;
            if (f3 != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(7, f3);
            }
            float f4 = this.vehAccelStd_;
            if (f4 != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(8, f4);
            }
            if (this.locFrameStatus_ != LocalFrameStatus.SAME_AS_LAST_PUBLISHED.getNumber()) {
                computeMessageSize += CodedOutputStream.computeEnumSize(9, this.locFrameStatus_);
            }
            if (this.locFrameTransfoem_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(10, getLocFrameTransfoem());
            }
            if (this.locFrameTime_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(11, getLocFrameTime());
            }
            int i2 = this.xPUSRView_;
            if (i2 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(12, i2);
            }
            int size = getSpareList().size() * 4;
            int i3 = computeMessageSize + size;
            if (!getSpareList().isEmpty()) {
                i3 = i3 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.spareMemoizedSerializedSize = size;
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LocalPoseInfo)) {
                return super.equals(obj);
            }
            LocalPoseInfo localPoseInfo = (LocalPoseInfo) obj;
            boolean z = hasTimestamp() == localPoseInfo.hasTimestamp();
            if (hasTimestamp()) {
                z = z && getTimestamp().equals(localPoseInfo.getTimestamp());
            }
            boolean z2 = z && hasLocalPose() == localPoseInfo.hasLocalPose();
            if (hasLocalPose()) {
                z2 = z2 && getLocalPose().equals(localPoseInfo.getLocalPose());
            }
            boolean z3 = z2 && hasLocalVelocity() == localPoseInfo.hasLocalVelocity();
            if (hasLocalVelocity()) {
                z3 = z3 && getLocalVelocity().equals(localPoseInfo.getLocalVelocity());
            }
            boolean z4 = z3 && hasLocalPoseStd() == localPoseInfo.hasLocalPoseStd();
            if (hasLocalPoseStd()) {
                z4 = z4 && getLocalPoseStd().equals(localPoseInfo.getLocalPoseStd());
            }
            boolean z5 = (((((z4 && Float.floatToIntBits(getVehSpeed()) == Float.floatToIntBits(localPoseInfo.getVehSpeed())) && Float.floatToIntBits(getVehAcceleration()) == Float.floatToIntBits(localPoseInfo.getVehAcceleration())) && Float.floatToIntBits(getVehSpeedStd()) == Float.floatToIntBits(localPoseInfo.getVehSpeedStd())) && Float.floatToIntBits(getVehAccelStd()) == Float.floatToIntBits(localPoseInfo.getVehAccelStd())) && this.locFrameStatus_ == localPoseInfo.locFrameStatus_) && hasLocFrameTransfoem() == localPoseInfo.hasLocFrameTransfoem();
            if (hasLocFrameTransfoem()) {
                z5 = z5 && getLocFrameTransfoem().equals(localPoseInfo.getLocFrameTransfoem());
            }
            boolean z6 = z5 && hasLocFrameTime() == localPoseInfo.hasLocFrameTime();
            if (hasLocFrameTime()) {
                z6 = z6 && getLocFrameTime().equals(localPoseInfo.getLocFrameTime());
            }
            return ((z6 && getXPUSRView() == localPoseInfo.getXPUSRView()) && getSpareList().equals(localPoseInfo.getSpareList())) && this.unknownFields.equals(localPoseInfo.unknownFields);
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
            if (hasLocalPose()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getLocalPose().hashCode();
            }
            if (hasLocalVelocity()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getLocalVelocity().hashCode();
            }
            if (hasLocalPoseStd()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getLocalPoseStd().hashCode();
            }
            int floatToIntBits = (((((((((((((((((((hashCode * 37) + 5) * 53) + Float.floatToIntBits(getVehSpeed())) * 37) + 6) * 53) + Float.floatToIntBits(getVehAcceleration())) * 37) + 7) * 53) + Float.floatToIntBits(getVehSpeedStd())) * 37) + 8) * 53) + Float.floatToIntBits(getVehAccelStd())) * 37) + 9) * 53) + this.locFrameStatus_;
            if (hasLocFrameTransfoem()) {
                floatToIntBits = (((floatToIntBits * 37) + 10) * 53) + getLocFrameTransfoem().hashCode();
            }
            if (hasLocFrameTime()) {
                floatToIntBits = (((floatToIntBits * 37) + 11) * 53) + getLocFrameTime().hashCode();
            }
            int xPUSRView = (((floatToIntBits * 37) + 12) * 53) + getXPUSRView();
            if (getSpareCount() > 0) {
                xPUSRView = (((xPUSRView * 37) + 13) * 53) + getSpareList().hashCode();
            }
            int hashCode2 = (xPUSRView * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static LocalPoseInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LocalPoseInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LocalPoseInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LocalPoseInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LocalPoseInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LocalPoseInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LocalPoseInfo parseFrom(InputStream inputStream) throws IOException {
            return (LocalPoseInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LocalPoseInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocalPoseInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LocalPoseInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LocalPoseInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LocalPoseInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocalPoseInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LocalPoseInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LocalPoseInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LocalPoseInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocalPoseInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LocalPoseInfo localPoseInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(localPoseInfo);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LocalPoseInfoOrBuilder {
            private int bitField0_;
            private int locFrameStatus_;
            private SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> locFrameTimeBuilder_;
            private Primitives.Time locFrameTime_;
            private SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> locFrameTransfoemBuilder_;
            private Primitives.Pose6DOF locFrameTransfoem_;
            private SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> localPoseBuilder_;
            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> localPoseStdBuilder_;
            private Primitives.Vector3D localPoseStd_;
            private Primitives.Pose6DOF localPose_;
            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> localVelocityBuilder_;
            private Primitives.Vector3D localVelocity_;
            private List<Float> spare_;
            private SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> timestampBuilder_;
            private Primitives.Time timestamp_;
            private float vehAccelStd_;
            private float vehAcceleration_;
            private float vehSpeedStd_;
            private float vehSpeed_;
            private int xPUSRView_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LocalPoseInfo.class, Builder.class);
            }

            private Builder() {
                this.timestamp_ = null;
                this.localPose_ = null;
                this.localVelocity_ = null;
                this.localPoseStd_ = null;
                this.locFrameStatus_ = 0;
                this.locFrameTransfoem_ = null;
                this.locFrameTime_ = null;
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.timestamp_ = null;
                this.localPose_ = null;
                this.localVelocity_ = null;
                this.localPoseStd_ = null;
                this.locFrameStatus_ = 0;
                this.locFrameTransfoem_ = null;
                this.locFrameTime_ = null;
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LocalPoseInfo.alwaysUseFieldBuilders;
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
                if (this.localPoseBuilder_ == null) {
                    this.localPose_ = null;
                } else {
                    this.localPose_ = null;
                    this.localPoseBuilder_ = null;
                }
                if (this.localVelocityBuilder_ == null) {
                    this.localVelocity_ = null;
                } else {
                    this.localVelocity_ = null;
                    this.localVelocityBuilder_ = null;
                }
                if (this.localPoseStdBuilder_ == null) {
                    this.localPoseStd_ = null;
                } else {
                    this.localPoseStd_ = null;
                    this.localPoseStdBuilder_ = null;
                }
                this.vehSpeed_ = 0.0f;
                this.vehAcceleration_ = 0.0f;
                this.vehSpeedStd_ = 0.0f;
                this.vehAccelStd_ = 0.0f;
                this.locFrameStatus_ = 0;
                if (this.locFrameTransfoemBuilder_ == null) {
                    this.locFrameTransfoem_ = null;
                } else {
                    this.locFrameTransfoem_ = null;
                    this.locFrameTransfoemBuilder_ = null;
                }
                if (this.locFrameTimeBuilder_ == null) {
                    this.locFrameTime_ = null;
                } else {
                    this.locFrameTime_ = null;
                    this.locFrameTimeBuilder_ = null;
                }
                this.xPUSRView_ = 0;
                this.spare_ = Collections.emptyList();
                this.bitField0_ &= -4097;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LocalPoseInfo getDefaultInstanceForType() {
                return LocalPoseInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LocalPoseInfo build() {
                LocalPoseInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LocalPoseInfo buildPartial() {
                LocalPoseInfo localPoseInfo = new LocalPoseInfo(this);
                int i = this.bitField0_;
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    localPoseInfo.timestamp_ = this.timestamp_;
                } else {
                    localPoseInfo.timestamp_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV32 = this.localPoseBuilder_;
                if (singleFieldBuilderV32 == null) {
                    localPoseInfo.localPose_ = this.localPose_;
                } else {
                    localPoseInfo.localPose_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV33 = this.localVelocityBuilder_;
                if (singleFieldBuilderV33 == null) {
                    localPoseInfo.localVelocity_ = this.localVelocity_;
                } else {
                    localPoseInfo.localVelocity_ = singleFieldBuilderV33.build();
                }
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV34 = this.localPoseStdBuilder_;
                if (singleFieldBuilderV34 == null) {
                    localPoseInfo.localPoseStd_ = this.localPoseStd_;
                } else {
                    localPoseInfo.localPoseStd_ = singleFieldBuilderV34.build();
                }
                localPoseInfo.vehSpeed_ = this.vehSpeed_;
                localPoseInfo.vehAcceleration_ = this.vehAcceleration_;
                localPoseInfo.vehSpeedStd_ = this.vehSpeedStd_;
                localPoseInfo.vehAccelStd_ = this.vehAccelStd_;
                localPoseInfo.locFrameStatus_ = this.locFrameStatus_;
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV35 = this.locFrameTransfoemBuilder_;
                if (singleFieldBuilderV35 == null) {
                    localPoseInfo.locFrameTransfoem_ = this.locFrameTransfoem_;
                } else {
                    localPoseInfo.locFrameTransfoem_ = singleFieldBuilderV35.build();
                }
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV36 = this.locFrameTimeBuilder_;
                if (singleFieldBuilderV36 == null) {
                    localPoseInfo.locFrameTime_ = this.locFrameTime_;
                } else {
                    localPoseInfo.locFrameTime_ = singleFieldBuilderV36.build();
                }
                localPoseInfo.xPUSRView_ = this.xPUSRView_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField0_ &= -4097;
                }
                localPoseInfo.spare_ = this.spare_;
                localPoseInfo.bitField0_ = 0;
                onBuilt();
                return localPoseInfo;
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
                if (message instanceof LocalPoseInfo) {
                    return mergeFrom((LocalPoseInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LocalPoseInfo localPoseInfo) {
                if (localPoseInfo == LocalPoseInfo.getDefaultInstance()) {
                    return this;
                }
                if (localPoseInfo.hasTimestamp()) {
                    mergeTimestamp(localPoseInfo.getTimestamp());
                }
                if (localPoseInfo.hasLocalPose()) {
                    mergeLocalPose(localPoseInfo.getLocalPose());
                }
                if (localPoseInfo.hasLocalVelocity()) {
                    mergeLocalVelocity(localPoseInfo.getLocalVelocity());
                }
                if (localPoseInfo.hasLocalPoseStd()) {
                    mergeLocalPoseStd(localPoseInfo.getLocalPoseStd());
                }
                if (localPoseInfo.getVehSpeed() != 0.0f) {
                    setVehSpeed(localPoseInfo.getVehSpeed());
                }
                if (localPoseInfo.getVehAcceleration() != 0.0f) {
                    setVehAcceleration(localPoseInfo.getVehAcceleration());
                }
                if (localPoseInfo.getVehSpeedStd() != 0.0f) {
                    setVehSpeedStd(localPoseInfo.getVehSpeedStd());
                }
                if (localPoseInfo.getVehAccelStd() != 0.0f) {
                    setVehAccelStd(localPoseInfo.getVehAccelStd());
                }
                if (localPoseInfo.locFrameStatus_ != 0) {
                    setLocFrameStatusValue(localPoseInfo.getLocFrameStatusValue());
                }
                if (localPoseInfo.hasLocFrameTransfoem()) {
                    mergeLocFrameTransfoem(localPoseInfo.getLocFrameTransfoem());
                }
                if (localPoseInfo.hasLocFrameTime()) {
                    mergeLocFrameTime(localPoseInfo.getLocFrameTime());
                }
                if (localPoseInfo.getXPUSRView() != 0) {
                    setXPUSRView(localPoseInfo.getXPUSRView());
                }
                if (!localPoseInfo.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = localPoseInfo.spare_;
                        this.bitField0_ &= -4097;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(localPoseInfo.spare_);
                    }
                    onChanged();
                }
                mergeUnknownFields(localPoseInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.LocalPose.LocalPoseInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.LocalPose.LocalPoseInfo.access$2100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.LocalPose$LocalPoseInfo r3 = (xpilot.sr.proto.LocalPose.LocalPoseInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.LocalPose$LocalPoseInfo r4 = (xpilot.sr.proto.LocalPose.LocalPoseInfo) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.LocalPose.LocalPoseInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.LocalPose$LocalPoseInfo$Builder");
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public boolean hasTimestamp() {
                return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
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

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
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

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public boolean hasLocalPose() {
                return (this.localPoseBuilder_ == null && this.localPose_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.Pose6DOF getLocalPose() {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Pose6DOF pose6DOF = this.localPose_;
                    return pose6DOF == null ? Primitives.Pose6DOF.getDefaultInstance() : pose6DOF;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLocalPose(Primitives.Pose6DOF pose6DOF) {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(pose6DOF);
                } else if (pose6DOF == null) {
                    throw new NullPointerException();
                } else {
                    this.localPose_ = pose6DOF;
                    onChanged();
                }
                return this;
            }

            public Builder setLocalPose(Primitives.Pose6DOF.Builder builder) {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.localPose_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLocalPose(Primitives.Pose6DOF pose6DOF) {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Pose6DOF pose6DOF2 = this.localPose_;
                    if (pose6DOF2 != null) {
                        this.localPose_ = Primitives.Pose6DOF.newBuilder(pose6DOF2).mergeFrom(pose6DOF).buildPartial();
                    } else {
                        this.localPose_ = pose6DOF;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(pose6DOF);
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

            public Primitives.Pose6DOF.Builder getLocalPoseBuilder() {
                onChanged();
                return getLocalPoseFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.Pose6DOFOrBuilder getLocalPoseOrBuilder() {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Pose6DOF pose6DOF = this.localPose_;
                return pose6DOF == null ? Primitives.Pose6DOF.getDefaultInstance() : pose6DOF;
            }

            private SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> getLocalPoseFieldBuilder() {
                if (this.localPoseBuilder_ == null) {
                    this.localPoseBuilder_ = new SingleFieldBuilderV3<>(getLocalPose(), getParentForChildren(), isClean());
                    this.localPose_ = null;
                }
                return this.localPoseBuilder_;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public boolean hasLocalVelocity() {
                return (this.localVelocityBuilder_ == null && this.localVelocity_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.Vector3D getLocalVelocity() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localVelocityBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D = this.localVelocity_;
                    return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLocalVelocity(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localVelocityBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    this.localVelocity_ = vector3D;
                    onChanged();
                }
                return this;
            }

            public Builder setLocalVelocity(Primitives.Vector3D.Builder builder) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localVelocityBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.localVelocity_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLocalVelocity(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localVelocityBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D2 = this.localVelocity_;
                    if (vector3D2 != null) {
                        this.localVelocity_ = Primitives.Vector3D.newBuilder(vector3D2).mergeFrom(vector3D).buildPartial();
                    } else {
                        this.localVelocity_ = vector3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(vector3D);
                }
                return this;
            }

            public Builder clearLocalVelocity() {
                if (this.localVelocityBuilder_ == null) {
                    this.localVelocity_ = null;
                    onChanged();
                } else {
                    this.localVelocity_ = null;
                    this.localVelocityBuilder_ = null;
                }
                return this;
            }

            public Primitives.Vector3D.Builder getLocalVelocityBuilder() {
                onChanged();
                return getLocalVelocityFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.Vector3DOrBuilder getLocalVelocityOrBuilder() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localVelocityBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Vector3D vector3D = this.localVelocity_;
                return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
            }

            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> getLocalVelocityFieldBuilder() {
                if (this.localVelocityBuilder_ == null) {
                    this.localVelocityBuilder_ = new SingleFieldBuilderV3<>(getLocalVelocity(), getParentForChildren(), isClean());
                    this.localVelocity_ = null;
                }
                return this.localVelocityBuilder_;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public boolean hasLocalPoseStd() {
                return (this.localPoseStdBuilder_ == null && this.localPoseStd_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.Vector3D getLocalPoseStd() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseStdBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D = this.localPoseStd_;
                    return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLocalPoseStd(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseStdBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    this.localPoseStd_ = vector3D;
                    onChanged();
                }
                return this;
            }

            public Builder setLocalPoseStd(Primitives.Vector3D.Builder builder) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseStdBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.localPoseStd_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLocalPoseStd(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseStdBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D2 = this.localPoseStd_;
                    if (vector3D2 != null) {
                        this.localPoseStd_ = Primitives.Vector3D.newBuilder(vector3D2).mergeFrom(vector3D).buildPartial();
                    } else {
                        this.localPoseStd_ = vector3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(vector3D);
                }
                return this;
            }

            public Builder clearLocalPoseStd() {
                if (this.localPoseStdBuilder_ == null) {
                    this.localPoseStd_ = null;
                    onChanged();
                } else {
                    this.localPoseStd_ = null;
                    this.localPoseStdBuilder_ = null;
                }
                return this;
            }

            public Primitives.Vector3D.Builder getLocalPoseStdBuilder() {
                onChanged();
                return getLocalPoseStdFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.Vector3DOrBuilder getLocalPoseStdOrBuilder() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseStdBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Vector3D vector3D = this.localPoseStd_;
                return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
            }

            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> getLocalPoseStdFieldBuilder() {
                if (this.localPoseStdBuilder_ == null) {
                    this.localPoseStdBuilder_ = new SingleFieldBuilderV3<>(getLocalPoseStd(), getParentForChildren(), isClean());
                    this.localPoseStd_ = null;
                }
                return this.localPoseStdBuilder_;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public float getVehSpeed() {
                return this.vehSpeed_;
            }

            public Builder setVehSpeed(float f) {
                this.vehSpeed_ = f;
                onChanged();
                return this;
            }

            public Builder clearVehSpeed() {
                this.vehSpeed_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public float getVehAcceleration() {
                return this.vehAcceleration_;
            }

            public Builder setVehAcceleration(float f) {
                this.vehAcceleration_ = f;
                onChanged();
                return this;
            }

            public Builder clearVehAcceleration() {
                this.vehAcceleration_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public float getVehSpeedStd() {
                return this.vehSpeedStd_;
            }

            public Builder setVehSpeedStd(float f) {
                this.vehSpeedStd_ = f;
                onChanged();
                return this;
            }

            public Builder clearVehSpeedStd() {
                this.vehSpeedStd_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public float getVehAccelStd() {
                return this.vehAccelStd_;
            }

            public Builder setVehAccelStd(float f) {
                this.vehAccelStd_ = f;
                onChanged();
                return this;
            }

            public Builder clearVehAccelStd() {
                this.vehAccelStd_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public int getLocFrameStatusValue() {
                return this.locFrameStatus_;
            }

            public Builder setLocFrameStatusValue(int i) {
                this.locFrameStatus_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public LocalFrameStatus getLocFrameStatus() {
                LocalFrameStatus valueOf = LocalFrameStatus.valueOf(this.locFrameStatus_);
                return valueOf == null ? LocalFrameStatus.UNRECOGNIZED : valueOf;
            }

            public Builder setLocFrameStatus(LocalFrameStatus localFrameStatus) {
                if (localFrameStatus == null) {
                    throw new NullPointerException();
                }
                this.locFrameStatus_ = localFrameStatus.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLocFrameStatus() {
                this.locFrameStatus_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public boolean hasLocFrameTransfoem() {
                return (this.locFrameTransfoemBuilder_ == null && this.locFrameTransfoem_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.Pose6DOF getLocFrameTransfoem() {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.locFrameTransfoemBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Pose6DOF pose6DOF = this.locFrameTransfoem_;
                    return pose6DOF == null ? Primitives.Pose6DOF.getDefaultInstance() : pose6DOF;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLocFrameTransfoem(Primitives.Pose6DOF pose6DOF) {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.locFrameTransfoemBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(pose6DOF);
                } else if (pose6DOF == null) {
                    throw new NullPointerException();
                } else {
                    this.locFrameTransfoem_ = pose6DOF;
                    onChanged();
                }
                return this;
            }

            public Builder setLocFrameTransfoem(Primitives.Pose6DOF.Builder builder) {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.locFrameTransfoemBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.locFrameTransfoem_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLocFrameTransfoem(Primitives.Pose6DOF pose6DOF) {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.locFrameTransfoemBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Pose6DOF pose6DOF2 = this.locFrameTransfoem_;
                    if (pose6DOF2 != null) {
                        this.locFrameTransfoem_ = Primitives.Pose6DOF.newBuilder(pose6DOF2).mergeFrom(pose6DOF).buildPartial();
                    } else {
                        this.locFrameTransfoem_ = pose6DOF;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(pose6DOF);
                }
                return this;
            }

            public Builder clearLocFrameTransfoem() {
                if (this.locFrameTransfoemBuilder_ == null) {
                    this.locFrameTransfoem_ = null;
                    onChanged();
                } else {
                    this.locFrameTransfoem_ = null;
                    this.locFrameTransfoemBuilder_ = null;
                }
                return this;
            }

            public Primitives.Pose6DOF.Builder getLocFrameTransfoemBuilder() {
                onChanged();
                return getLocFrameTransfoemFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.Pose6DOFOrBuilder getLocFrameTransfoemOrBuilder() {
                SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> singleFieldBuilderV3 = this.locFrameTransfoemBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Pose6DOF pose6DOF = this.locFrameTransfoem_;
                return pose6DOF == null ? Primitives.Pose6DOF.getDefaultInstance() : pose6DOF;
            }

            private SingleFieldBuilderV3<Primitives.Pose6DOF, Primitives.Pose6DOF.Builder, Primitives.Pose6DOFOrBuilder> getLocFrameTransfoemFieldBuilder() {
                if (this.locFrameTransfoemBuilder_ == null) {
                    this.locFrameTransfoemBuilder_ = new SingleFieldBuilderV3<>(getLocFrameTransfoem(), getParentForChildren(), isClean());
                    this.locFrameTransfoem_ = null;
                }
                return this.locFrameTransfoemBuilder_;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public boolean hasLocFrameTime() {
                return (this.locFrameTimeBuilder_ == null && this.locFrameTime_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.Time getLocFrameTime() {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.locFrameTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Time time = this.locFrameTime_;
                    return time == null ? Primitives.Time.getDefaultInstance() : time;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLocFrameTime(Primitives.Time time) {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.locFrameTimeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(time);
                } else if (time == null) {
                    throw new NullPointerException();
                } else {
                    this.locFrameTime_ = time;
                    onChanged();
                }
                return this;
            }

            public Builder setLocFrameTime(Primitives.Time.Builder builder) {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.locFrameTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.locFrameTime_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLocFrameTime(Primitives.Time time) {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.locFrameTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Time time2 = this.locFrameTime_;
                    if (time2 != null) {
                        this.locFrameTime_ = Primitives.Time.newBuilder(time2).mergeFrom(time).buildPartial();
                    } else {
                        this.locFrameTime_ = time;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(time);
                }
                return this;
            }

            public Builder clearLocFrameTime() {
                if (this.locFrameTimeBuilder_ == null) {
                    this.locFrameTime_ = null;
                    onChanged();
                } else {
                    this.locFrameTime_ = null;
                    this.locFrameTimeBuilder_ = null;
                }
                return this;
            }

            public Primitives.Time.Builder getLocFrameTimeBuilder() {
                onChanged();
                return getLocFrameTimeFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public Primitives.TimeOrBuilder getLocFrameTimeOrBuilder() {
                SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> singleFieldBuilderV3 = this.locFrameTimeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Time time = this.locFrameTime_;
                return time == null ? Primitives.Time.getDefaultInstance() : time;
            }

            private SingleFieldBuilderV3<Primitives.Time, Primitives.Time.Builder, Primitives.TimeOrBuilder> getLocFrameTimeFieldBuilder() {
                if (this.locFrameTimeBuilder_ == null) {
                    this.locFrameTimeBuilder_ = new SingleFieldBuilderV3<>(getLocFrameTime(), getParentForChildren(), isClean());
                    this.locFrameTime_ = null;
                }
                return this.locFrameTimeBuilder_;
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public int getXPUSRView() {
                return this.xPUSRView_;
            }

            public Builder setXPUSRView(int i) {
                this.xPUSRView_ = i;
                onChanged();
                return this;
            }

            public Builder clearXPUSRView() {
                this.xPUSRView_ = 0;
                onChanged();
                return this;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField0_ |= 4096;
                }
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoOrBuilder
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
                this.bitField0_ &= -4097;
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

        public static LocalPoseInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LocalPoseInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LocalPoseInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LocalPoseInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class LocalPoseInfoBuffer extends GeneratedMessageV3 implements LocalPoseInfoBufferOrBuilder {
        public static final int LOCAL_POSE_MSGS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<LocalPoseInfo> localPoseMsgs_;
        private byte memoizedIsInitialized;
        private static final LocalPoseInfoBuffer DEFAULT_INSTANCE = new LocalPoseInfoBuffer();
        private static final Parser<LocalPoseInfoBuffer> PARSER = new AbstractParser<LocalPoseInfoBuffer>() { // from class: xpilot.sr.proto.LocalPose.LocalPoseInfoBuffer.1
            @Override // com.google.protobuf.Parser
            public LocalPoseInfoBuffer parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LocalPoseInfoBuffer(codedInputStream, extensionRegistryLite);
            }
        };

        private LocalPoseInfoBuffer(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private LocalPoseInfoBuffer() {
            this.memoizedIsInitialized = (byte) -1;
            this.localPoseMsgs_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private LocalPoseInfoBuffer(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                        this.localPoseMsgs_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.localPoseMsgs_.add(codedInputStream.readMessage(LocalPoseInfo.parser(), extensionRegistryLite));
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
                        this.localPoseMsgs_ = Collections.unmodifiableList(this.localPoseMsgs_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_fieldAccessorTable.ensureFieldAccessorsInitialized(LocalPoseInfoBuffer.class, Builder.class);
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
        public List<LocalPoseInfo> getLocalPoseMsgsList() {
            return this.localPoseMsgs_;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
        public List<? extends LocalPoseInfoOrBuilder> getLocalPoseMsgsOrBuilderList() {
            return this.localPoseMsgs_;
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
        public int getLocalPoseMsgsCount() {
            return this.localPoseMsgs_.size();
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
        public LocalPoseInfo getLocalPoseMsgs(int i) {
            return this.localPoseMsgs_.get(i);
        }

        @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
        public LocalPoseInfoOrBuilder getLocalPoseMsgsOrBuilder(int i) {
            return this.localPoseMsgs_.get(i);
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
            for (int i = 0; i < this.localPoseMsgs_.size(); i++) {
                codedOutputStream.writeMessage(1, this.localPoseMsgs_.get(i));
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
            for (int i3 = 0; i3 < this.localPoseMsgs_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.localPoseMsgs_.get(i3));
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
            if (!(obj instanceof LocalPoseInfoBuffer)) {
                return super.equals(obj);
            }
            LocalPoseInfoBuffer localPoseInfoBuffer = (LocalPoseInfoBuffer) obj;
            return (getLocalPoseMsgsList().equals(localPoseInfoBuffer.getLocalPoseMsgsList())) && this.unknownFields.equals(localPoseInfoBuffer.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getLocalPoseMsgsCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getLocalPoseMsgsList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static LocalPoseInfoBuffer parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LocalPoseInfoBuffer parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LocalPoseInfoBuffer parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LocalPoseInfoBuffer parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LocalPoseInfoBuffer parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LocalPoseInfoBuffer parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LocalPoseInfoBuffer parseFrom(InputStream inputStream) throws IOException {
            return (LocalPoseInfoBuffer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LocalPoseInfoBuffer parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocalPoseInfoBuffer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LocalPoseInfoBuffer parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LocalPoseInfoBuffer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LocalPoseInfoBuffer parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocalPoseInfoBuffer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LocalPoseInfoBuffer parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LocalPoseInfoBuffer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LocalPoseInfoBuffer parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LocalPoseInfoBuffer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LocalPoseInfoBuffer localPoseInfoBuffer) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(localPoseInfoBuffer);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LocalPoseInfoBufferOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> localPoseMsgsBuilder_;
            private List<LocalPoseInfo> localPoseMsgs_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_fieldAccessorTable.ensureFieldAccessorsInitialized(LocalPoseInfoBuffer.class, Builder.class);
            }

            private Builder() {
                this.localPoseMsgs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.localPoseMsgs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LocalPoseInfoBuffer.alwaysUseFieldBuilders) {
                    getLocalPoseMsgsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.localPoseMsgs_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LocalPose.internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LocalPoseInfoBuffer getDefaultInstanceForType() {
                return LocalPoseInfoBuffer.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LocalPoseInfoBuffer build() {
                LocalPoseInfoBuffer buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LocalPoseInfoBuffer buildPartial() {
                LocalPoseInfoBuffer localPoseInfoBuffer = new LocalPoseInfoBuffer(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.localPoseMsgs_ = Collections.unmodifiableList(this.localPoseMsgs_);
                        this.bitField0_ &= -2;
                    }
                    localPoseInfoBuffer.localPoseMsgs_ = this.localPoseMsgs_;
                } else {
                    localPoseInfoBuffer.localPoseMsgs_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return localPoseInfoBuffer;
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
                if (message instanceof LocalPoseInfoBuffer) {
                    return mergeFrom((LocalPoseInfoBuffer) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LocalPoseInfoBuffer localPoseInfoBuffer) {
                if (localPoseInfoBuffer == LocalPoseInfoBuffer.getDefaultInstance()) {
                    return this;
                }
                if (this.localPoseMsgsBuilder_ == null) {
                    if (!localPoseInfoBuffer.localPoseMsgs_.isEmpty()) {
                        if (this.localPoseMsgs_.isEmpty()) {
                            this.localPoseMsgs_ = localPoseInfoBuffer.localPoseMsgs_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureLocalPoseMsgsIsMutable();
                            this.localPoseMsgs_.addAll(localPoseInfoBuffer.localPoseMsgs_);
                        }
                        onChanged();
                    }
                } else if (!localPoseInfoBuffer.localPoseMsgs_.isEmpty()) {
                    if (!this.localPoseMsgsBuilder_.isEmpty()) {
                        this.localPoseMsgsBuilder_.addAllMessages(localPoseInfoBuffer.localPoseMsgs_);
                    } else {
                        this.localPoseMsgsBuilder_.dispose();
                        this.localPoseMsgsBuilder_ = null;
                        this.localPoseMsgs_ = localPoseInfoBuffer.localPoseMsgs_;
                        this.bitField0_ &= -2;
                        this.localPoseMsgsBuilder_ = LocalPoseInfoBuffer.alwaysUseFieldBuilders ? getLocalPoseMsgsFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(localPoseInfoBuffer.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.LocalPose.LocalPoseInfoBuffer.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.LocalPose.LocalPoseInfoBuffer.access$3200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.LocalPose$LocalPoseInfoBuffer r3 = (xpilot.sr.proto.LocalPose.LocalPoseInfoBuffer) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.LocalPose$LocalPoseInfoBuffer r4 = (xpilot.sr.proto.LocalPose.LocalPoseInfoBuffer) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.LocalPose.LocalPoseInfoBuffer.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.LocalPose$LocalPoseInfoBuffer$Builder");
            }

            private void ensureLocalPoseMsgsIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.localPoseMsgs_ = new ArrayList(this.localPoseMsgs_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
            public List<LocalPoseInfo> getLocalPoseMsgsList() {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.localPoseMsgs_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
            public int getLocalPoseMsgsCount() {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.localPoseMsgs_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
            public LocalPoseInfo getLocalPoseMsgs(int i) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.localPoseMsgs_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setLocalPoseMsgs(int i, LocalPoseInfo localPoseInfo) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, localPoseInfo);
                } else if (localPoseInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLocalPoseMsgsIsMutable();
                    this.localPoseMsgs_.set(i, localPoseInfo);
                    onChanged();
                }
                return this;
            }

            public Builder setLocalPoseMsgs(int i, LocalPoseInfo.Builder builder) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLocalPoseMsgsIsMutable();
                    this.localPoseMsgs_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addLocalPoseMsgs(LocalPoseInfo localPoseInfo) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(localPoseInfo);
                } else if (localPoseInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLocalPoseMsgsIsMutable();
                    this.localPoseMsgs_.add(localPoseInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLocalPoseMsgs(int i, LocalPoseInfo localPoseInfo) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, localPoseInfo);
                } else if (localPoseInfo == null) {
                    throw new NullPointerException();
                } else {
                    ensureLocalPoseMsgsIsMutable();
                    this.localPoseMsgs_.add(i, localPoseInfo);
                    onChanged();
                }
                return this;
            }

            public Builder addLocalPoseMsgs(LocalPoseInfo.Builder builder) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLocalPoseMsgsIsMutable();
                    this.localPoseMsgs_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addLocalPoseMsgs(int i, LocalPoseInfo.Builder builder) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLocalPoseMsgsIsMutable();
                    this.localPoseMsgs_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllLocalPoseMsgs(Iterable<? extends LocalPoseInfo> iterable) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLocalPoseMsgsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.localPoseMsgs_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearLocalPoseMsgs() {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.localPoseMsgs_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeLocalPoseMsgs(int i) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLocalPoseMsgsIsMutable();
                    this.localPoseMsgs_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public LocalPoseInfo.Builder getLocalPoseMsgsBuilder(int i) {
                return getLocalPoseMsgsFieldBuilder().getBuilder(i);
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
            public LocalPoseInfoOrBuilder getLocalPoseMsgsOrBuilder(int i) {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.localPoseMsgs_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // xpilot.sr.proto.LocalPose.LocalPoseInfoBufferOrBuilder
            public List<? extends LocalPoseInfoOrBuilder> getLocalPoseMsgsOrBuilderList() {
                RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> repeatedFieldBuilderV3 = this.localPoseMsgsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.localPoseMsgs_);
            }

            public LocalPoseInfo.Builder addLocalPoseMsgsBuilder() {
                return getLocalPoseMsgsFieldBuilder().addBuilder(LocalPoseInfo.getDefaultInstance());
            }

            public LocalPoseInfo.Builder addLocalPoseMsgsBuilder(int i) {
                return getLocalPoseMsgsFieldBuilder().addBuilder(i, LocalPoseInfo.getDefaultInstance());
            }

            public List<LocalPoseInfo.Builder> getLocalPoseMsgsBuilderList() {
                return getLocalPoseMsgsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LocalPoseInfo, LocalPoseInfo.Builder, LocalPoseInfoOrBuilder> getLocalPoseMsgsFieldBuilder() {
                if (this.localPoseMsgsBuilder_ == null) {
                    this.localPoseMsgsBuilder_ = new RepeatedFieldBuilderV3<>(this.localPoseMsgs_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.localPoseMsgs_ = null;
                }
                return this.localPoseMsgsBuilder_;
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

        public static LocalPoseInfoBuffer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LocalPoseInfoBuffer> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LocalPoseInfoBuffer> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LocalPoseInfoBuffer getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010local_pose.proto\u0012\u000fxpilot.sr.proto\u001a\u0010primitives.proto\"ñ\u0003\n\rLocalPoseInfo\u0012(\n\ttimestamp\u0018\u0001 \u0001(\u000b2\u0015.xpilot.sr.proto.Time\u0012-\n\nlocal_pose\u0018\u0002 \u0001(\u000b2\u0019.xpilot.sr.proto.Pose6DOF\u00121\n\u000elocal_velocity\u0018\u0003 \u0001(\u000b2\u0019.xpilot.sr.proto.Vector3D\u00121\n\u000elocal_pose_std\u0018\u0004 \u0001(\u000b2\u0019.xpilot.sr.proto.Vector3D\u0012\u0011\n\tveh_speed\u0018\u0005 \u0001(\u0002\u0012\u0018\n\u0010veh_acceleration\u0018\u0006 \u0001(\u0002\u0012\u0015\n\rveh_speed_std\u0018\u0007 \u0001(\u0002\u0012\u0015\n\rveh_accel_std\u0018\b \u0001(\u0002\u0012;\n\u0010loc_frame_status\u0018\t \u0001(\u000e2!.xpilot.sr.proto.LocalFrameStatus\u00126\n\u0013loc_frame_transfoem\u0018\n \u0001(\u000b2\u0019.xpilot.sr.proto.Pose6DOF\u0012-\n\u000eloc_frame_time\u0018\u000b \u0001(\u000b2\u0015.xpilot.sr.proto.Time\u0012\u0013\n\u000bXPU_SR_View\u0018\f \u0001(\u0005\u0012\r\n\u0005spare\u0018\r \u0003(\u0002\"N\n\u0013LocalPoseInfoBuffer\u00127\n\u000flocal_pose_msgs\u0018\u0001 \u0003(\u000b2\u001e.xpilot.sr.proto.LocalPoseInfo*L\n\u0010LocalFrameStatus\u0012\u001a\n\u0016SAME_AS_LAST_PUBLISHED\u0010\u0000\u0012\u001c\n\u0018DIFF_FROM_LAST_PUBLISHED\u0010\u0001b\u0006proto3"}, new Descriptors.FileDescriptor[]{Primitives.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.LocalPose.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = LocalPose.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_LocalPoseInfo_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_LocalPoseInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_LocalPoseInfo_descriptor, new String[]{"Timestamp", "LocalPose", "LocalVelocity", "LocalPoseStd", "VehSpeed", "VehAcceleration", "VehSpeedStd", "VehAccelStd", "LocFrameStatus", "LocFrameTransfoem", "LocFrameTime", "XPUSRView", "Spare"});
        internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_LocalPoseInfoBuffer_descriptor, new String[]{"LocalPoseMsgs"});
        Primitives.getDescriptor();
    }
}
