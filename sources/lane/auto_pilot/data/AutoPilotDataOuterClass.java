package lane.auto_pilot.data;

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
/* loaded from: classes3.dex */
public final class AutoPilotDataOuterClass {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_lane_auto_pilot_data_AutoPilotData_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_lane_auto_pilot_data_AutoPilotData_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_lane_auto_pilot_data_LidarPointCloud_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_lane_auto_pilot_data_LidarPointCloud_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_lane_auto_pilot_data_LidarPointClouds_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_lane_auto_pilot_data_LidarPointClouds_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_lane_auto_pilot_data_LidarPointParam_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_lane_auto_pilot_data_LidarPointParam_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_lane_auto_pilot_data_LidarPoint_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_lane_auto_pilot_data_LidarPoint_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_lane_auto_pilot_data_SingleTrafficLight_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_lane_auto_pilot_data_SingleTrafficLight_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_lane_auto_pilot_data_TrafficLightGroup_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_lane_auto_pilot_data_TrafficLightGroup_fieldAccessorTable;

    /* loaded from: classes3.dex */
    public interface AutoPilotDataOrBuilder extends MessageOrBuilder {
        AutoPilotData.DataCase getDataCase();

        TrafficLightGroup getLightGroup();

        TrafficLightGroupOrBuilder getLightGroupOrBuilder();

        LidarPointClouds getPointClouds();

        LidarPointCloudsOrBuilder getPointCloudsOrBuilder();

        boolean hasLightGroup();

        boolean hasPointClouds();
    }

    /* loaded from: classes3.dex */
    public interface LidarPointCloudOrBuilder extends MessageOrBuilder {
        int getId();

        LidarPointParam getParam();

        LidarPointParamOrBuilder getParamOrBuilder();

        int getPointCount();

        LidarPoint getPoints(int i);

        int getPointsCount();

        List<LidarPoint> getPointsList();

        LidarPointOrBuilder getPointsOrBuilder(int i);

        List<? extends LidarPointOrBuilder> getPointsOrBuilderList();

        boolean hasParam();
    }

    /* loaded from: classes3.dex */
    public interface LidarPointCloudsOrBuilder extends MessageOrBuilder {
        LidarPointCloud getPointCloud(int i);

        int getPointCloudCount();

        List<LidarPointCloud> getPointCloudList();

        LidarPointCloudOrBuilder getPointCloudOrBuilder(int i);

        List<? extends LidarPointCloudOrBuilder> getPointCloudOrBuilderList();
    }

    /* loaded from: classes3.dex */
    public interface LidarPointOrBuilder extends MessageOrBuilder {
        double getReflectivity();

        double getX();

        double getY();

        double getZ();
    }

    /* loaded from: classes3.dex */
    public interface LidarPointParamOrBuilder extends MessageOrBuilder {
        int getLineCount();
    }

    /* loaded from: classes3.dex */
    public interface SingleTrafficLightOrBuilder extends MessageOrBuilder {
        long getIdInMap();

        int getKeepTime();

        int getRemainTime();

        TrafficLightStatus getStatus();

        int getStatusValue();
    }

    /* loaded from: classes3.dex */
    public interface TrafficLightGroupOrBuilder extends MessageOrBuilder {
        SingleTrafficLight getLights(int i);

        int getLightsCount();

        List<SingleTrafficLight> getLightsList();

        SingleTrafficLightOrBuilder getLightsOrBuilder(int i);

        List<? extends SingleTrafficLightOrBuilder> getLightsOrBuilderList();

        long getTimestamp();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private AutoPilotDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes3.dex */
    public enum TrafficLightStatus implements ProtocolMessageEnum {
        TRAFFIC_LIGHT_STATUS_UNKNOWN(0),
        TRAFFIC_LIGHT_STATUS_RED(1),
        TRAFFIC_LIGHT_STATUS_YELLOW(2),
        TRAFFIC_LIGHT_STATUS_GREEN(3),
        TRAFFIC_LIGHT_STATUS_FLASHING_RED(4),
        TRAFFIC_LIGHT_STATUS_FLASHING_YELLOW(5),
        TRAFFIC_LIGHT_STATUS_FLASHING_GREEN(6),
        TRAFFIC_LIGHT_STATUS_BLACK(7),
        UNRECOGNIZED(-1);
        
        public static final int TRAFFIC_LIGHT_STATUS_BLACK_VALUE = 7;
        public static final int TRAFFIC_LIGHT_STATUS_FLASHING_GREEN_VALUE = 6;
        public static final int TRAFFIC_LIGHT_STATUS_FLASHING_RED_VALUE = 4;
        public static final int TRAFFIC_LIGHT_STATUS_FLASHING_YELLOW_VALUE = 5;
        public static final int TRAFFIC_LIGHT_STATUS_GREEN_VALUE = 3;
        public static final int TRAFFIC_LIGHT_STATUS_RED_VALUE = 1;
        public static final int TRAFFIC_LIGHT_STATUS_UNKNOWN_VALUE = 0;
        public static final int TRAFFIC_LIGHT_STATUS_YELLOW_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<TrafficLightStatus> internalValueMap = new Internal.EnumLiteMap<TrafficLightStatus>() { // from class: lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightStatus.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public TrafficLightStatus findValueByNumber(int i) {
                return TrafficLightStatus.forNumber(i);
            }
        };
        private static final TrafficLightStatus[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static TrafficLightStatus valueOf(int i) {
            return forNumber(i);
        }

        public static TrafficLightStatus forNumber(int i) {
            switch (i) {
                case 0:
                    return TRAFFIC_LIGHT_STATUS_UNKNOWN;
                case 1:
                    return TRAFFIC_LIGHT_STATUS_RED;
                case 2:
                    return TRAFFIC_LIGHT_STATUS_YELLOW;
                case 3:
                    return TRAFFIC_LIGHT_STATUS_GREEN;
                case 4:
                    return TRAFFIC_LIGHT_STATUS_FLASHING_RED;
                case 5:
                    return TRAFFIC_LIGHT_STATUS_FLASHING_YELLOW;
                case 6:
                    return TRAFFIC_LIGHT_STATUS_FLASHING_GREEN;
                case 7:
                    return TRAFFIC_LIGHT_STATUS_BLACK;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<TrafficLightStatus> internalGetValueMap() {
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
            return AutoPilotDataOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static TrafficLightStatus valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        TrafficLightStatus(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes3.dex */
    public static final class LidarPoint extends GeneratedMessageV3 implements LidarPointOrBuilder {
        private static final LidarPoint DEFAULT_INSTANCE = new LidarPoint();
        private static final Parser<LidarPoint> PARSER = new AbstractParser<LidarPoint>() { // from class: lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPoint.1
            @Override // com.google.protobuf.Parser
            public LidarPoint parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LidarPoint(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REFLECTIVITY_FIELD_NUMBER = 4;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        public static final int Z_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private double reflectivity_;
        private double x_;
        private double y_;
        private double z_;

        private LidarPoint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private LidarPoint() {
            this.memoizedIsInitialized = (byte) -1;
            this.x_ = 0.0d;
            this.y_ = 0.0d;
            this.z_ = 0.0d;
            this.reflectivity_ = 0.0d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LidarPoint(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            } else if (readTag == 33) {
                                this.reflectivity_ = codedInputStream.readDouble();
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
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPoint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(LidarPoint.class, Builder.class);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointOrBuilder
        public double getX() {
            return this.x_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointOrBuilder
        public double getY() {
            return this.y_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointOrBuilder
        public double getZ() {
            return this.z_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointOrBuilder
        public double getReflectivity() {
            return this.reflectivity_;
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
            double d4 = this.reflectivity_;
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
            double d4 = this.reflectivity_;
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
            if (!(obj instanceof LidarPoint)) {
                return super.equals(obj);
            }
            LidarPoint lidarPoint = (LidarPoint) obj;
            return (((((Double.doubleToLongBits(getX()) > Double.doubleToLongBits(lidarPoint.getX()) ? 1 : (Double.doubleToLongBits(getX()) == Double.doubleToLongBits(lidarPoint.getX()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getY()) > Double.doubleToLongBits(lidarPoint.getY()) ? 1 : (Double.doubleToLongBits(getY()) == Double.doubleToLongBits(lidarPoint.getY()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getZ()) > Double.doubleToLongBits(lidarPoint.getZ()) ? 1 : (Double.doubleToLongBits(getZ()) == Double.doubleToLongBits(lidarPoint.getZ()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getReflectivity()) > Double.doubleToLongBits(lidarPoint.getReflectivity()) ? 1 : (Double.doubleToLongBits(getReflectivity()) == Double.doubleToLongBits(lidarPoint.getReflectivity()) ? 0 : -1)) == 0) && this.unknownFields.equals(lidarPoint.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(Double.doubleToLongBits(getX()))) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getY()))) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getZ()))) * 37) + 4) * 53) + Internal.hashLong(Double.doubleToLongBits(getReflectivity()))) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static LidarPoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LidarPoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LidarPoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LidarPoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LidarPoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LidarPoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LidarPoint parseFrom(InputStream inputStream) throws IOException {
            return (LidarPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LidarPoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LidarPoint parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LidarPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LidarPoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LidarPoint parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LidarPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LidarPoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LidarPoint lidarPoint) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(lidarPoint);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LidarPointOrBuilder {
            private double reflectivity_;
            private double x_;
            private double y_;
            private double z_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPoint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(LidarPoint.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LidarPoint.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.x_ = 0.0d;
                this.y_ = 0.0d;
                this.z_ = 0.0d;
                this.reflectivity_ = 0.0d;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPoint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LidarPoint getDefaultInstanceForType() {
                return LidarPoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LidarPoint build() {
                LidarPoint buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LidarPoint buildPartial() {
                LidarPoint lidarPoint = new LidarPoint(this);
                lidarPoint.x_ = this.x_;
                lidarPoint.y_ = this.y_;
                lidarPoint.z_ = this.z_;
                lidarPoint.reflectivity_ = this.reflectivity_;
                onBuilt();
                return lidarPoint;
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
                if (message instanceof LidarPoint) {
                    return mergeFrom((LidarPoint) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LidarPoint lidarPoint) {
                if (lidarPoint == LidarPoint.getDefaultInstance()) {
                    return this;
                }
                if (lidarPoint.getX() != 0.0d) {
                    setX(lidarPoint.getX());
                }
                if (lidarPoint.getY() != 0.0d) {
                    setY(lidarPoint.getY());
                }
                if (lidarPoint.getZ() != 0.0d) {
                    setZ(lidarPoint.getZ());
                }
                if (lidarPoint.getReflectivity() != 0.0d) {
                    setReflectivity(lidarPoint.getReflectivity());
                }
                mergeUnknownFields(lidarPoint.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPoint.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPoint.access$1100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPoint r3 = (lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPoint) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPoint r4 = (lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPoint) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPoint.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPoint$Builder");
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointOrBuilder
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

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointOrBuilder
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

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointOrBuilder
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

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointOrBuilder
            public double getReflectivity() {
                return this.reflectivity_;
            }

            public Builder setReflectivity(double d) {
                this.reflectivity_ = d;
                onChanged();
                return this;
            }

            public Builder clearReflectivity() {
                this.reflectivity_ = 0.0d;
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

        public static LidarPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LidarPoint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LidarPoint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LidarPoint getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class LidarPointParam extends GeneratedMessageV3 implements LidarPointParamOrBuilder {
        public static final int LINECOUNT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int lineCount_;
        private byte memoizedIsInitialized;
        private static final LidarPointParam DEFAULT_INSTANCE = new LidarPointParam();
        private static final Parser<LidarPointParam> PARSER = new AbstractParser<LidarPointParam>() { // from class: lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointParam.1
            @Override // com.google.protobuf.Parser
            public LidarPointParam parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LidarPointParam(codedInputStream, extensionRegistryLite);
            }
        };

        private LidarPointParam(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private LidarPointParam() {
            this.memoizedIsInitialized = (byte) -1;
            this.lineCount_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LidarPointParam(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.lineCount_ = codedInputStream.readInt32();
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
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointParam_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointParam_fieldAccessorTable.ensureFieldAccessorsInitialized(LidarPointParam.class, Builder.class);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointParamOrBuilder
        public int getLineCount() {
            return this.lineCount_;
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
            int i = this.lineCount_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.lineCount_;
            int computeInt32Size = (i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = computeInt32Size;
            return computeInt32Size;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LidarPointParam)) {
                return super.equals(obj);
            }
            LidarPointParam lidarPointParam = (LidarPointParam) obj;
            return (getLineCount() == lidarPointParam.getLineCount()) && this.unknownFields.equals(lidarPointParam.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getLineCount()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static LidarPointParam parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LidarPointParam parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LidarPointParam parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LidarPointParam parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LidarPointParam parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LidarPointParam parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LidarPointParam parseFrom(InputStream inputStream) throws IOException {
            return (LidarPointParam) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LidarPointParam parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPointParam) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LidarPointParam parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LidarPointParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LidarPointParam parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPointParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LidarPointParam parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LidarPointParam) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LidarPointParam parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPointParam) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LidarPointParam lidarPointParam) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(lidarPointParam);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LidarPointParamOrBuilder {
            private int lineCount_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointParam_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointParam_fieldAccessorTable.ensureFieldAccessorsInitialized(LidarPointParam.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LidarPointParam.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.lineCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointParam_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LidarPointParam getDefaultInstanceForType() {
                return LidarPointParam.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LidarPointParam build() {
                LidarPointParam buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LidarPointParam buildPartial() {
                LidarPointParam lidarPointParam = new LidarPointParam(this);
                lidarPointParam.lineCount_ = this.lineCount_;
                onBuilt();
                return lidarPointParam;
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
                if (message instanceof LidarPointParam) {
                    return mergeFrom((LidarPointParam) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LidarPointParam lidarPointParam) {
                if (lidarPointParam == LidarPointParam.getDefaultInstance()) {
                    return this;
                }
                if (lidarPointParam.getLineCount() != 0) {
                    setLineCount(lidarPointParam.getLineCount());
                }
                mergeUnknownFields(lidarPointParam.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointParam.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointParam.access$2100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointParam r3 = (lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointParam) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointParam r4 = (lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointParam) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointParam.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointParam$Builder");
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointParamOrBuilder
            public int getLineCount() {
                return this.lineCount_;
            }

            public Builder setLineCount(int i) {
                this.lineCount_ = i;
                onChanged();
                return this;
            }

            public Builder clearLineCount() {
                this.lineCount_ = 0;
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

        public static LidarPointParam getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LidarPointParam> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LidarPointParam> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LidarPointParam getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class LidarPointCloud extends GeneratedMessageV3 implements LidarPointCloudOrBuilder {
        public static final int ID_FIELD_NUMBER = 1;
        public static final int PARAM_FIELD_NUMBER = 2;
        public static final int POINTCOUNT_FIELD_NUMBER = 3;
        public static final int POINTS_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private LidarPointParam param_;
        private int pointCount_;
        private List<LidarPoint> points_;
        private static final LidarPointCloud DEFAULT_INSTANCE = new LidarPointCloud();
        private static final Parser<LidarPointCloud> PARSER = new AbstractParser<LidarPointCloud>() { // from class: lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloud.1
            @Override // com.google.protobuf.Parser
            public LidarPointCloud parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LidarPointCloud(codedInputStream, extensionRegistryLite);
            }
        };

        private LidarPointCloud(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private LidarPointCloud() {
            this.memoizedIsInitialized = (byte) -1;
            this.id_ = 0;
            this.pointCount_ = 0;
            this.points_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private LidarPointCloud(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.id_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                LidarPointParam.Builder builder = this.param_ != null ? this.param_.toBuilder() : null;
                                this.param_ = (LidarPointParam) codedInputStream.readMessage(LidarPointParam.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.param_);
                                    this.param_ = builder.buildPartial();
                                }
                            } else if (readTag == 24) {
                                this.pointCount_ = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                if (!(z2 & true)) {
                                    this.points_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.points_.add(codedInputStream.readMessage(LidarPoint.parser(), extensionRegistryLite));
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
                        this.points_ = Collections.unmodifiableList(this.points_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointCloud_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointCloud_fieldAccessorTable.ensureFieldAccessorsInitialized(LidarPointCloud.class, Builder.class);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public boolean hasParam() {
            return this.param_ != null;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public LidarPointParam getParam() {
            LidarPointParam lidarPointParam = this.param_;
            return lidarPointParam == null ? LidarPointParam.getDefaultInstance() : lidarPointParam;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public LidarPointParamOrBuilder getParamOrBuilder() {
            return getParam();
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public int getPointCount() {
            return this.pointCount_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public List<LidarPoint> getPointsList() {
            return this.points_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public List<? extends LidarPointOrBuilder> getPointsOrBuilderList() {
            return this.points_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public int getPointsCount() {
            return this.points_.size();
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public LidarPoint getPoints(int i) {
            return this.points_.get(i);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
        public LidarPointOrBuilder getPointsOrBuilder(int i) {
            return this.points_.get(i);
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
                codedOutputStream.writeInt32(1, i);
            }
            if (this.param_ != null) {
                codedOutputStream.writeMessage(2, getParam());
            }
            int i2 = this.pointCount_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
            for (int i3 = 0; i3 < this.points_.size(); i3++) {
                codedOutputStream.writeMessage(4, this.points_.get(i3));
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
            int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
            if (this.param_ != null) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, getParam());
            }
            int i3 = this.pointCount_;
            if (i3 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(3, i3);
            }
            for (int i4 = 0; i4 < this.points_.size(); i4++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.points_.get(i4));
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
            if (!(obj instanceof LidarPointCloud)) {
                return super.equals(obj);
            }
            LidarPointCloud lidarPointCloud = (LidarPointCloud) obj;
            boolean z = (getId() == lidarPointCloud.getId()) && hasParam() == lidarPointCloud.hasParam();
            if (hasParam()) {
                z = z && getParam().equals(lidarPointCloud.getParam());
            }
            return ((z && getPointCount() == lidarPointCloud.getPointCount()) && getPointsList().equals(lidarPointCloud.getPointsList())) && this.unknownFields.equals(lidarPointCloud.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getId();
            if (hasParam()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getParam().hashCode();
            }
            int pointCount = (((hashCode * 37) + 3) * 53) + getPointCount();
            if (getPointsCount() > 0) {
                pointCount = (((pointCount * 37) + 4) * 53) + getPointsList().hashCode();
            }
            int hashCode2 = (pointCount * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static LidarPointCloud parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LidarPointCloud parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LidarPointCloud parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LidarPointCloud parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LidarPointCloud parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LidarPointCloud parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LidarPointCloud parseFrom(InputStream inputStream) throws IOException {
            return (LidarPointCloud) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LidarPointCloud parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPointCloud) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LidarPointCloud parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LidarPointCloud) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LidarPointCloud parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPointCloud) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LidarPointCloud parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LidarPointCloud) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LidarPointCloud parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPointCloud) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LidarPointCloud lidarPointCloud) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(lidarPointCloud);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LidarPointCloudOrBuilder {
            private int bitField0_;
            private int id_;
            private SingleFieldBuilderV3<LidarPointParam, LidarPointParam.Builder, LidarPointParamOrBuilder> paramBuilder_;
            private LidarPointParam param_;
            private int pointCount_;
            private RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> pointsBuilder_;
            private List<LidarPoint> points_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointCloud_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointCloud_fieldAccessorTable.ensureFieldAccessorsInitialized(LidarPointCloud.class, Builder.class);
            }

            private Builder() {
                this.param_ = null;
                this.points_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.param_ = null;
                this.points_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LidarPointCloud.alwaysUseFieldBuilders) {
                    getPointsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.id_ = 0;
                if (this.paramBuilder_ == null) {
                    this.param_ = null;
                } else {
                    this.param_ = null;
                    this.paramBuilder_ = null;
                }
                this.pointCount_ = 0;
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.points_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointCloud_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LidarPointCloud getDefaultInstanceForType() {
                return LidarPointCloud.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LidarPointCloud build() {
                LidarPointCloud buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LidarPointCloud buildPartial() {
                LidarPointCloud lidarPointCloud = new LidarPointCloud(this);
                int i = this.bitField0_;
                lidarPointCloud.id_ = this.id_;
                SingleFieldBuilderV3<LidarPointParam, LidarPointParam.Builder, LidarPointParamOrBuilder> singleFieldBuilderV3 = this.paramBuilder_;
                if (singleFieldBuilderV3 == null) {
                    lidarPointCloud.param_ = this.param_;
                } else {
                    lidarPointCloud.param_ = singleFieldBuilderV3.build();
                }
                lidarPointCloud.pointCount_ = this.pointCount_;
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    lidarPointCloud.points_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 8) == 8) {
                        this.points_ = Collections.unmodifiableList(this.points_);
                        this.bitField0_ &= -9;
                    }
                    lidarPointCloud.points_ = this.points_;
                }
                lidarPointCloud.bitField0_ = 0;
                onBuilt();
                return lidarPointCloud;
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
                if (message instanceof LidarPointCloud) {
                    return mergeFrom((LidarPointCloud) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LidarPointCloud lidarPointCloud) {
                if (lidarPointCloud == LidarPointCloud.getDefaultInstance()) {
                    return this;
                }
                if (lidarPointCloud.getId() != 0) {
                    setId(lidarPointCloud.getId());
                }
                if (lidarPointCloud.hasParam()) {
                    mergeParam(lidarPointCloud.getParam());
                }
                if (lidarPointCloud.getPointCount() != 0) {
                    setPointCount(lidarPointCloud.getPointCount());
                }
                if (this.pointsBuilder_ == null) {
                    if (!lidarPointCloud.points_.isEmpty()) {
                        if (this.points_.isEmpty()) {
                            this.points_ = lidarPointCloud.points_;
                            this.bitField0_ &= -9;
                        } else {
                            ensurePointsIsMutable();
                            this.points_.addAll(lidarPointCloud.points_);
                        }
                        onChanged();
                    }
                } else if (!lidarPointCloud.points_.isEmpty()) {
                    if (!this.pointsBuilder_.isEmpty()) {
                        this.pointsBuilder_.addAllMessages(lidarPointCloud.points_);
                    } else {
                        this.pointsBuilder_.dispose();
                        this.pointsBuilder_ = null;
                        this.points_ = lidarPointCloud.points_;
                        this.bitField0_ &= -9;
                        this.pointsBuilder_ = LidarPointCloud.alwaysUseFieldBuilders ? getPointsFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(lidarPointCloud.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloud.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloud.access$3600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointCloud r3 = (lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloud) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointCloud r4 = (lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloud) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloud.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointCloud$Builder");
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
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

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
            public boolean hasParam() {
                return (this.paramBuilder_ == null && this.param_ == null) ? false : true;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
            public LidarPointParam getParam() {
                SingleFieldBuilderV3<LidarPointParam, LidarPointParam.Builder, LidarPointParamOrBuilder> singleFieldBuilderV3 = this.paramBuilder_;
                if (singleFieldBuilderV3 == null) {
                    LidarPointParam lidarPointParam = this.param_;
                    return lidarPointParam == null ? LidarPointParam.getDefaultInstance() : lidarPointParam;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setParam(LidarPointParam lidarPointParam) {
                SingleFieldBuilderV3<LidarPointParam, LidarPointParam.Builder, LidarPointParamOrBuilder> singleFieldBuilderV3 = this.paramBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(lidarPointParam);
                } else if (lidarPointParam == null) {
                    throw new NullPointerException();
                } else {
                    this.param_ = lidarPointParam;
                    onChanged();
                }
                return this;
            }

            public Builder setParam(LidarPointParam.Builder builder) {
                SingleFieldBuilderV3<LidarPointParam, LidarPointParam.Builder, LidarPointParamOrBuilder> singleFieldBuilderV3 = this.paramBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.param_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeParam(LidarPointParam lidarPointParam) {
                SingleFieldBuilderV3<LidarPointParam, LidarPointParam.Builder, LidarPointParamOrBuilder> singleFieldBuilderV3 = this.paramBuilder_;
                if (singleFieldBuilderV3 == null) {
                    LidarPointParam lidarPointParam2 = this.param_;
                    if (lidarPointParam2 != null) {
                        this.param_ = LidarPointParam.newBuilder(lidarPointParam2).mergeFrom(lidarPointParam).buildPartial();
                    } else {
                        this.param_ = lidarPointParam;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(lidarPointParam);
                }
                return this;
            }

            public Builder clearParam() {
                if (this.paramBuilder_ == null) {
                    this.param_ = null;
                    onChanged();
                } else {
                    this.param_ = null;
                    this.paramBuilder_ = null;
                }
                return this;
            }

            public LidarPointParam.Builder getParamBuilder() {
                onChanged();
                return getParamFieldBuilder().getBuilder();
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
            public LidarPointParamOrBuilder getParamOrBuilder() {
                SingleFieldBuilderV3<LidarPointParam, LidarPointParam.Builder, LidarPointParamOrBuilder> singleFieldBuilderV3 = this.paramBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                LidarPointParam lidarPointParam = this.param_;
                return lidarPointParam == null ? LidarPointParam.getDefaultInstance() : lidarPointParam;
            }

            private SingleFieldBuilderV3<LidarPointParam, LidarPointParam.Builder, LidarPointParamOrBuilder> getParamFieldBuilder() {
                if (this.paramBuilder_ == null) {
                    this.paramBuilder_ = new SingleFieldBuilderV3<>(getParam(), getParentForChildren(), isClean());
                    this.param_ = null;
                }
                return this.paramBuilder_;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
            public int getPointCount() {
                return this.pointCount_;
            }

            public Builder setPointCount(int i) {
                this.pointCount_ = i;
                onChanged();
                return this;
            }

            public Builder clearPointCount() {
                this.pointCount_ = 0;
                onChanged();
                return this;
            }

            private void ensurePointsIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.points_ = new ArrayList(this.points_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
            public List<LidarPoint> getPointsList() {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.points_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
            public int getPointsCount() {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.points_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
            public LidarPoint getPoints(int i) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.points_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setPoints(int i, LidarPoint lidarPoint) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, lidarPoint);
                } else if (lidarPoint == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointsIsMutable();
                    this.points_.set(i, lidarPoint);
                    onChanged();
                }
                return this;
            }

            public Builder setPoints(int i, LidarPoint.Builder builder) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointsIsMutable();
                    this.points_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addPoints(LidarPoint lidarPoint) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(lidarPoint);
                } else if (lidarPoint == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointsIsMutable();
                    this.points_.add(lidarPoint);
                    onChanged();
                }
                return this;
            }

            public Builder addPoints(int i, LidarPoint lidarPoint) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, lidarPoint);
                } else if (lidarPoint == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointsIsMutable();
                    this.points_.add(i, lidarPoint);
                    onChanged();
                }
                return this;
            }

            public Builder addPoints(LidarPoint.Builder builder) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointsIsMutable();
                    this.points_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addPoints(int i, LidarPoint.Builder builder) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointsIsMutable();
                    this.points_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllPoints(Iterable<? extends LidarPoint> iterable) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.points_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearPoints() {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.points_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removePoints(int i) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointsIsMutable();
                    this.points_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public LidarPoint.Builder getPointsBuilder(int i) {
                return getPointsFieldBuilder().getBuilder(i);
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
            public LidarPointOrBuilder getPointsOrBuilder(int i) {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.points_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudOrBuilder
            public List<? extends LidarPointOrBuilder> getPointsOrBuilderList() {
                RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> repeatedFieldBuilderV3 = this.pointsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.points_);
            }

            public LidarPoint.Builder addPointsBuilder() {
                return getPointsFieldBuilder().addBuilder(LidarPoint.getDefaultInstance());
            }

            public LidarPoint.Builder addPointsBuilder(int i) {
                return getPointsFieldBuilder().addBuilder(i, LidarPoint.getDefaultInstance());
            }

            public List<LidarPoint.Builder> getPointsBuilderList() {
                return getPointsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LidarPoint, LidarPoint.Builder, LidarPointOrBuilder> getPointsFieldBuilder() {
                if (this.pointsBuilder_ == null) {
                    this.pointsBuilder_ = new RepeatedFieldBuilderV3<>(this.points_, (this.bitField0_ & 8) == 8, getParentForChildren(), isClean());
                    this.points_ = null;
                }
                return this.pointsBuilder_;
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

        public static LidarPointCloud getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LidarPointCloud> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LidarPointCloud> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LidarPointCloud getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class LidarPointClouds extends GeneratedMessageV3 implements LidarPointCloudsOrBuilder {
        private static final LidarPointClouds DEFAULT_INSTANCE = new LidarPointClouds();
        private static final Parser<LidarPointClouds> PARSER = new AbstractParser<LidarPointClouds>() { // from class: lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointClouds.1
            @Override // com.google.protobuf.Parser
            public LidarPointClouds parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LidarPointClouds(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int POINTCLOUD_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<LidarPointCloud> pointCloud_;

        private LidarPointClouds(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private LidarPointClouds() {
            this.memoizedIsInitialized = (byte) -1;
            this.pointCloud_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private LidarPointClouds(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                        this.pointCloud_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.pointCloud_.add(codedInputStream.readMessage(LidarPointCloud.parser(), extensionRegistryLite));
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
                        this.pointCloud_ = Collections.unmodifiableList(this.pointCloud_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointClouds_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointClouds_fieldAccessorTable.ensureFieldAccessorsInitialized(LidarPointClouds.class, Builder.class);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
        public List<LidarPointCloud> getPointCloudList() {
            return this.pointCloud_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
        public List<? extends LidarPointCloudOrBuilder> getPointCloudOrBuilderList() {
            return this.pointCloud_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
        public int getPointCloudCount() {
            return this.pointCloud_.size();
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
        public LidarPointCloud getPointCloud(int i) {
            return this.pointCloud_.get(i);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
        public LidarPointCloudOrBuilder getPointCloudOrBuilder(int i) {
            return this.pointCloud_.get(i);
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
            for (int i = 0; i < this.pointCloud_.size(); i++) {
                codedOutputStream.writeMessage(1, this.pointCloud_.get(i));
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
            for (int i3 = 0; i3 < this.pointCloud_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.pointCloud_.get(i3));
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
            if (!(obj instanceof LidarPointClouds)) {
                return super.equals(obj);
            }
            LidarPointClouds lidarPointClouds = (LidarPointClouds) obj;
            return (getPointCloudList().equals(lidarPointClouds.getPointCloudList())) && this.unknownFields.equals(lidarPointClouds.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getPointCloudCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getPointCloudList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static LidarPointClouds parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LidarPointClouds parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LidarPointClouds parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LidarPointClouds parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LidarPointClouds parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LidarPointClouds parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LidarPointClouds parseFrom(InputStream inputStream) throws IOException {
            return (LidarPointClouds) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LidarPointClouds parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPointClouds) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LidarPointClouds parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LidarPointClouds) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LidarPointClouds parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPointClouds) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LidarPointClouds parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LidarPointClouds) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LidarPointClouds parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LidarPointClouds) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LidarPointClouds lidarPointClouds) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(lidarPointClouds);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LidarPointCloudsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> pointCloudBuilder_;
            private List<LidarPointCloud> pointCloud_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointClouds_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointClouds_fieldAccessorTable.ensureFieldAccessorsInitialized(LidarPointClouds.class, Builder.class);
            }

            private Builder() {
                this.pointCloud_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.pointCloud_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LidarPointClouds.alwaysUseFieldBuilders) {
                    getPointCloudFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.pointCloud_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_LidarPointClouds_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LidarPointClouds getDefaultInstanceForType() {
                return LidarPointClouds.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LidarPointClouds build() {
                LidarPointClouds buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LidarPointClouds buildPartial() {
                LidarPointClouds lidarPointClouds = new LidarPointClouds(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.pointCloud_ = Collections.unmodifiableList(this.pointCloud_);
                        this.bitField0_ &= -2;
                    }
                    lidarPointClouds.pointCloud_ = this.pointCloud_;
                } else {
                    lidarPointClouds.pointCloud_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return lidarPointClouds;
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
                if (message instanceof LidarPointClouds) {
                    return mergeFrom((LidarPointClouds) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LidarPointClouds lidarPointClouds) {
                if (lidarPointClouds == LidarPointClouds.getDefaultInstance()) {
                    return this;
                }
                if (this.pointCloudBuilder_ == null) {
                    if (!lidarPointClouds.pointCloud_.isEmpty()) {
                        if (this.pointCloud_.isEmpty()) {
                            this.pointCloud_ = lidarPointClouds.pointCloud_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePointCloudIsMutable();
                            this.pointCloud_.addAll(lidarPointClouds.pointCloud_);
                        }
                        onChanged();
                    }
                } else if (!lidarPointClouds.pointCloud_.isEmpty()) {
                    if (!this.pointCloudBuilder_.isEmpty()) {
                        this.pointCloudBuilder_.addAllMessages(lidarPointClouds.pointCloud_);
                    } else {
                        this.pointCloudBuilder_.dispose();
                        this.pointCloudBuilder_ = null;
                        this.pointCloud_ = lidarPointClouds.pointCloud_;
                        this.bitField0_ &= -2;
                        this.pointCloudBuilder_ = LidarPointClouds.alwaysUseFieldBuilders ? getPointCloudFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(lidarPointClouds.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointClouds.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointClouds.access$4700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointClouds r3 = (lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointClouds) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointClouds r4 = (lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointClouds) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointClouds.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointClouds$Builder");
            }

            private void ensurePointCloudIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.pointCloud_ = new ArrayList(this.pointCloud_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
            public List<LidarPointCloud> getPointCloudList() {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.pointCloud_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
            public int getPointCloudCount() {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.pointCloud_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
            public LidarPointCloud getPointCloud(int i) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.pointCloud_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setPointCloud(int i, LidarPointCloud lidarPointCloud) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, lidarPointCloud);
                } else if (lidarPointCloud == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointCloudIsMutable();
                    this.pointCloud_.set(i, lidarPointCloud);
                    onChanged();
                }
                return this;
            }

            public Builder setPointCloud(int i, LidarPointCloud.Builder builder) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointCloudIsMutable();
                    this.pointCloud_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addPointCloud(LidarPointCloud lidarPointCloud) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(lidarPointCloud);
                } else if (lidarPointCloud == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointCloudIsMutable();
                    this.pointCloud_.add(lidarPointCloud);
                    onChanged();
                }
                return this;
            }

            public Builder addPointCloud(int i, LidarPointCloud lidarPointCloud) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, lidarPointCloud);
                } else if (lidarPointCloud == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointCloudIsMutable();
                    this.pointCloud_.add(i, lidarPointCloud);
                    onChanged();
                }
                return this;
            }

            public Builder addPointCloud(LidarPointCloud.Builder builder) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointCloudIsMutable();
                    this.pointCloud_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addPointCloud(int i, LidarPointCloud.Builder builder) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointCloudIsMutable();
                    this.pointCloud_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllPointCloud(Iterable<? extends LidarPointCloud> iterable) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointCloudIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.pointCloud_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearPointCloud() {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.pointCloud_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removePointCloud(int i) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensurePointCloudIsMutable();
                    this.pointCloud_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public LidarPointCloud.Builder getPointCloudBuilder(int i) {
                return getPointCloudFieldBuilder().getBuilder(i);
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
            public LidarPointCloudOrBuilder getPointCloudOrBuilder(int i) {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.pointCloud_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.LidarPointCloudsOrBuilder
            public List<? extends LidarPointCloudOrBuilder> getPointCloudOrBuilderList() {
                RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> repeatedFieldBuilderV3 = this.pointCloudBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.pointCloud_);
            }

            public LidarPointCloud.Builder addPointCloudBuilder() {
                return getPointCloudFieldBuilder().addBuilder(LidarPointCloud.getDefaultInstance());
            }

            public LidarPointCloud.Builder addPointCloudBuilder(int i) {
                return getPointCloudFieldBuilder().addBuilder(i, LidarPointCloud.getDefaultInstance());
            }

            public List<LidarPointCloud.Builder> getPointCloudBuilderList() {
                return getPointCloudFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LidarPointCloud, LidarPointCloud.Builder, LidarPointCloudOrBuilder> getPointCloudFieldBuilder() {
                if (this.pointCloudBuilder_ == null) {
                    this.pointCloudBuilder_ = new RepeatedFieldBuilderV3<>(this.pointCloud_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.pointCloud_ = null;
                }
                return this.pointCloudBuilder_;
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

        public static LidarPointClouds getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LidarPointClouds> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LidarPointClouds> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LidarPointClouds getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class AutoPilotData extends GeneratedMessageV3 implements AutoPilotDataOrBuilder {
        public static final int LIGHTGROUP_FIELD_NUMBER = 2;
        public static final int POINTCLOUDS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int dataCase_;
        private Object data_;
        private byte memoizedIsInitialized;
        private static final AutoPilotData DEFAULT_INSTANCE = new AutoPilotData();
        private static final Parser<AutoPilotData> PARSER = new AbstractParser<AutoPilotData>() { // from class: lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotData.1
            @Override // com.google.protobuf.Parser
            public AutoPilotData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AutoPilotData(codedInputStream, extensionRegistryLite);
            }
        };

        private AutoPilotData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.dataCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private AutoPilotData() {
            this.dataCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AutoPilotData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                LidarPointClouds.Builder builder = this.dataCase_ == 1 ? ((LidarPointClouds) this.data_).toBuilder() : null;
                                this.data_ = codedInputStream.readMessage(LidarPointClouds.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((LidarPointClouds) this.data_);
                                    this.data_ = builder.buildPartial();
                                }
                                this.dataCase_ = 1;
                            } else if (readTag == 18) {
                                TrafficLightGroup.Builder builder2 = this.dataCase_ == 2 ? ((TrafficLightGroup) this.data_).toBuilder() : null;
                                this.data_ = codedInputStream.readMessage(TrafficLightGroup.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((TrafficLightGroup) this.data_);
                                    this.data_ = builder2.buildPartial();
                                }
                                this.dataCase_ = 2;
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
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_AutoPilotData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_AutoPilotData_fieldAccessorTable.ensureFieldAccessorsInitialized(AutoPilotData.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public enum DataCase implements Internal.EnumLite {
            POINTCLOUDS(1),
            LIGHTGROUP(2),
            DATA_NOT_SET(0);
            
            private final int value;

            DataCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static DataCase valueOf(int i) {
                return forNumber(i);
            }

            public static DataCase forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return LIGHTGROUP;
                    }
                    return POINTCLOUDS;
                }
                return DATA_NOT_SET;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
        public DataCase getDataCase() {
            return DataCase.forNumber(this.dataCase_);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
        public boolean hasPointClouds() {
            return this.dataCase_ == 1;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
        public LidarPointClouds getPointClouds() {
            if (this.dataCase_ == 1) {
                return (LidarPointClouds) this.data_;
            }
            return LidarPointClouds.getDefaultInstance();
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
        public LidarPointCloudsOrBuilder getPointCloudsOrBuilder() {
            if (this.dataCase_ == 1) {
                return (LidarPointClouds) this.data_;
            }
            return LidarPointClouds.getDefaultInstance();
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
        public boolean hasLightGroup() {
            return this.dataCase_ == 2;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
        public TrafficLightGroup getLightGroup() {
            if (this.dataCase_ == 2) {
                return (TrafficLightGroup) this.data_;
            }
            return TrafficLightGroup.getDefaultInstance();
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
        public TrafficLightGroupOrBuilder getLightGroupOrBuilder() {
            if (this.dataCase_ == 2) {
                return (TrafficLightGroup) this.data_;
            }
            return TrafficLightGroup.getDefaultInstance();
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
            if (this.dataCase_ == 1) {
                codedOutputStream.writeMessage(1, (LidarPointClouds) this.data_);
            }
            if (this.dataCase_ == 2) {
                codedOutputStream.writeMessage(2, (TrafficLightGroup) this.data_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.dataCase_ == 1 ? 0 + CodedOutputStream.computeMessageSize(1, (LidarPointClouds) this.data_) : 0;
            if (this.dataCase_ == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, (TrafficLightGroup) this.data_);
            }
            int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
            if (getLightGroup().equals(r6.getLightGroup()) != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
            r1 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
            if (getPointClouds().equals(r6.getPointClouds()) != false) goto L21;
         */
        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r0 = 1
                if (r6 != r5) goto L4
                return r0
            L4:
                boolean r1 = r6 instanceof lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotData
                if (r1 != 0) goto Ld
                boolean r6 = super.equals(r6)
                return r6
            Ld:
                lane.auto_pilot.data.AutoPilotDataOuterClass$AutoPilotData r6 = (lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotData) r6
                lane.auto_pilot.data.AutoPilotDataOuterClass$AutoPilotData$DataCase r1 = r5.getDataCase()
                lane.auto_pilot.data.AutoPilotDataOuterClass$AutoPilotData$DataCase r2 = r6.getDataCase()
                boolean r1 = r1.equals(r2)
                r2 = 0
                if (r1 == 0) goto L20
                r1 = r0
                goto L21
            L20:
                r1 = r2
            L21:
                if (r1 != 0) goto L24
                return r2
            L24:
                int r3 = r5.dataCase_
                if (r3 == r0) goto L40
                r4 = 2
                if (r3 == r4) goto L2c
                goto L51
            L2c:
                if (r1 == 0) goto L3e
                lane.auto_pilot.data.AutoPilotDataOuterClass$TrafficLightGroup r1 = r5.getLightGroup()
                lane.auto_pilot.data.AutoPilotDataOuterClass$TrafficLightGroup r3 = r6.getLightGroup()
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L3e
            L3c:
                r1 = r0
                goto L51
            L3e:
                r1 = r2
                goto L51
            L40:
                if (r1 == 0) goto L3e
                lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointClouds r1 = r5.getPointClouds()
                lane.auto_pilot.data.AutoPilotDataOuterClass$LidarPointClouds r3 = r6.getPointClouds()
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L3e
                goto L3c
            L51:
                if (r1 == 0) goto L5e
                com.google.protobuf.UnknownFieldSet r1 = r5.unknownFields
                com.google.protobuf.UnknownFieldSet r6 = r6.unknownFields
                boolean r6 = r1.equals(r6)
                if (r6 == 0) goto L5e
                goto L5f
            L5e:
                r0 = r2
            L5f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotData.equals(java.lang.Object):boolean");
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i;
            int hashCode;
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode2 = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            int i2 = this.dataCase_;
            if (i2 == 1) {
                i = ((hashCode2 * 37) + 1) * 53;
                hashCode = getPointClouds().hashCode();
            } else {
                if (i2 == 2) {
                    i = ((hashCode2 * 37) + 2) * 53;
                    hashCode = getLightGroup().hashCode();
                }
                int hashCode3 = (hashCode2 * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode3;
                return hashCode3;
            }
            hashCode2 = i + hashCode;
            int hashCode32 = (hashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode32;
            return hashCode32;
        }

        public static AutoPilotData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AutoPilotData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AutoPilotData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AutoPilotData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AutoPilotData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AutoPilotData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AutoPilotData parseFrom(InputStream inputStream) throws IOException {
            return (AutoPilotData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AutoPilotData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AutoPilotData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AutoPilotData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AutoPilotData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AutoPilotData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AutoPilotData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AutoPilotData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AutoPilotData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AutoPilotData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AutoPilotData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AutoPilotData autoPilotData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(autoPilotData);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AutoPilotDataOrBuilder {
            private int dataCase_;
            private Object data_;
            private SingleFieldBuilderV3<TrafficLightGroup, TrafficLightGroup.Builder, TrafficLightGroupOrBuilder> lightGroupBuilder_;
            private SingleFieldBuilderV3<LidarPointClouds, LidarPointClouds.Builder, LidarPointCloudsOrBuilder> pointCloudsBuilder_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_AutoPilotData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_AutoPilotData_fieldAccessorTable.ensureFieldAccessorsInitialized(AutoPilotData.class, Builder.class);
            }

            private Builder() {
                this.dataCase_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.dataCase_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AutoPilotData.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.dataCase_ = 0;
                this.data_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_AutoPilotData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AutoPilotData getDefaultInstanceForType() {
                return AutoPilotData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AutoPilotData build() {
                AutoPilotData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AutoPilotData buildPartial() {
                AutoPilotData autoPilotData = new AutoPilotData(this);
                if (this.dataCase_ == 1) {
                    SingleFieldBuilderV3<LidarPointClouds, LidarPointClouds.Builder, LidarPointCloudsOrBuilder> singleFieldBuilderV3 = this.pointCloudsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        autoPilotData.data_ = this.data_;
                    } else {
                        autoPilotData.data_ = singleFieldBuilderV3.build();
                    }
                }
                if (this.dataCase_ == 2) {
                    SingleFieldBuilderV3<TrafficLightGroup, TrafficLightGroup.Builder, TrafficLightGroupOrBuilder> singleFieldBuilderV32 = this.lightGroupBuilder_;
                    if (singleFieldBuilderV32 == null) {
                        autoPilotData.data_ = this.data_;
                    } else {
                        autoPilotData.data_ = singleFieldBuilderV32.build();
                    }
                }
                autoPilotData.dataCase_ = this.dataCase_;
                onBuilt();
                return autoPilotData;
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
                if (message instanceof AutoPilotData) {
                    return mergeFrom((AutoPilotData) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AutoPilotData autoPilotData) {
                if (autoPilotData == AutoPilotData.getDefaultInstance()) {
                    return this;
                }
                int i = AnonymousClass2.$SwitchMap$lane$auto_pilot$data$AutoPilotDataOuterClass$AutoPilotData$DataCase[autoPilotData.getDataCase().ordinal()];
                if (i == 1) {
                    mergePointClouds(autoPilotData.getPointClouds());
                } else if (i == 2) {
                    mergeLightGroup(autoPilotData.getLightGroup());
                }
                mergeUnknownFields(autoPilotData.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotData.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotData.access$5800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    lane.auto_pilot.data.AutoPilotDataOuterClass$AutoPilotData r3 = (lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotData) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    lane.auto_pilot.data.AutoPilotDataOuterClass$AutoPilotData r4 = (lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotData) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotData.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):lane.auto_pilot.data.AutoPilotDataOuterClass$AutoPilotData$Builder");
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
            public DataCase getDataCase() {
                return DataCase.forNumber(this.dataCase_);
            }

            public Builder clearData() {
                this.dataCase_ = 0;
                this.data_ = null;
                onChanged();
                return this;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
            public boolean hasPointClouds() {
                return this.dataCase_ == 1;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
            public LidarPointClouds getPointClouds() {
                SingleFieldBuilderV3<LidarPointClouds, LidarPointClouds.Builder, LidarPointCloudsOrBuilder> singleFieldBuilderV3 = this.pointCloudsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.dataCase_ == 1) {
                        return (LidarPointClouds) this.data_;
                    }
                    return LidarPointClouds.getDefaultInstance();
                } else if (this.dataCase_ == 1) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return LidarPointClouds.getDefaultInstance();
                }
            }

            public Builder setPointClouds(LidarPointClouds lidarPointClouds) {
                SingleFieldBuilderV3<LidarPointClouds, LidarPointClouds.Builder, LidarPointCloudsOrBuilder> singleFieldBuilderV3 = this.pointCloudsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(lidarPointClouds);
                } else if (lidarPointClouds == null) {
                    throw new NullPointerException();
                } else {
                    this.data_ = lidarPointClouds;
                    onChanged();
                }
                this.dataCase_ = 1;
                return this;
            }

            public Builder setPointClouds(LidarPointClouds.Builder builder) {
                SingleFieldBuilderV3<LidarPointClouds, LidarPointClouds.Builder, LidarPointCloudsOrBuilder> singleFieldBuilderV3 = this.pointCloudsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.data_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.dataCase_ = 1;
                return this;
            }

            public Builder mergePointClouds(LidarPointClouds lidarPointClouds) {
                SingleFieldBuilderV3<LidarPointClouds, LidarPointClouds.Builder, LidarPointCloudsOrBuilder> singleFieldBuilderV3 = this.pointCloudsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.dataCase_ == 1 && this.data_ != LidarPointClouds.getDefaultInstance()) {
                        this.data_ = LidarPointClouds.newBuilder((LidarPointClouds) this.data_).mergeFrom(lidarPointClouds).buildPartial();
                    } else {
                        this.data_ = lidarPointClouds;
                    }
                    onChanged();
                } else {
                    if (this.dataCase_ == 1) {
                        singleFieldBuilderV3.mergeFrom(lidarPointClouds);
                    }
                    this.pointCloudsBuilder_.setMessage(lidarPointClouds);
                }
                this.dataCase_ = 1;
                return this;
            }

            public Builder clearPointClouds() {
                if (this.pointCloudsBuilder_ == null) {
                    if (this.dataCase_ == 1) {
                        this.dataCase_ = 0;
                        this.data_ = null;
                        onChanged();
                    }
                } else {
                    if (this.dataCase_ == 1) {
                        this.dataCase_ = 0;
                        this.data_ = null;
                    }
                    this.pointCloudsBuilder_.clear();
                }
                return this;
            }

            public LidarPointClouds.Builder getPointCloudsBuilder() {
                return getPointCloudsFieldBuilder().getBuilder();
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
            public LidarPointCloudsOrBuilder getPointCloudsOrBuilder() {
                SingleFieldBuilderV3<LidarPointClouds, LidarPointClouds.Builder, LidarPointCloudsOrBuilder> singleFieldBuilderV3;
                if (this.dataCase_ == 1 && (singleFieldBuilderV3 = this.pointCloudsBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.dataCase_ == 1) {
                    return (LidarPointClouds) this.data_;
                }
                return LidarPointClouds.getDefaultInstance();
            }

            private SingleFieldBuilderV3<LidarPointClouds, LidarPointClouds.Builder, LidarPointCloudsOrBuilder> getPointCloudsFieldBuilder() {
                if (this.pointCloudsBuilder_ == null) {
                    if (this.dataCase_ != 1) {
                        this.data_ = LidarPointClouds.getDefaultInstance();
                    }
                    this.pointCloudsBuilder_ = new SingleFieldBuilderV3<>((LidarPointClouds) this.data_, getParentForChildren(), isClean());
                    this.data_ = null;
                }
                this.dataCase_ = 1;
                onChanged();
                return this.pointCloudsBuilder_;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
            public boolean hasLightGroup() {
                return this.dataCase_ == 2;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
            public TrafficLightGroup getLightGroup() {
                SingleFieldBuilderV3<TrafficLightGroup, TrafficLightGroup.Builder, TrafficLightGroupOrBuilder> singleFieldBuilderV3 = this.lightGroupBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.dataCase_ == 2) {
                        return (TrafficLightGroup) this.data_;
                    }
                    return TrafficLightGroup.getDefaultInstance();
                } else if (this.dataCase_ == 2) {
                    return singleFieldBuilderV3.getMessage();
                } else {
                    return TrafficLightGroup.getDefaultInstance();
                }
            }

            public Builder setLightGroup(TrafficLightGroup trafficLightGroup) {
                SingleFieldBuilderV3<TrafficLightGroup, TrafficLightGroup.Builder, TrafficLightGroupOrBuilder> singleFieldBuilderV3 = this.lightGroupBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(trafficLightGroup);
                } else if (trafficLightGroup == null) {
                    throw new NullPointerException();
                } else {
                    this.data_ = trafficLightGroup;
                    onChanged();
                }
                this.dataCase_ = 2;
                return this;
            }

            public Builder setLightGroup(TrafficLightGroup.Builder builder) {
                SingleFieldBuilderV3<TrafficLightGroup, TrafficLightGroup.Builder, TrafficLightGroupOrBuilder> singleFieldBuilderV3 = this.lightGroupBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.data_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.dataCase_ = 2;
                return this;
            }

            public Builder mergeLightGroup(TrafficLightGroup trafficLightGroup) {
                SingleFieldBuilderV3<TrafficLightGroup, TrafficLightGroup.Builder, TrafficLightGroupOrBuilder> singleFieldBuilderV3 = this.lightGroupBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.dataCase_ == 2 && this.data_ != TrafficLightGroup.getDefaultInstance()) {
                        this.data_ = TrafficLightGroup.newBuilder((TrafficLightGroup) this.data_).mergeFrom(trafficLightGroup).buildPartial();
                    } else {
                        this.data_ = trafficLightGroup;
                    }
                    onChanged();
                } else {
                    if (this.dataCase_ == 2) {
                        singleFieldBuilderV3.mergeFrom(trafficLightGroup);
                    }
                    this.lightGroupBuilder_.setMessage(trafficLightGroup);
                }
                this.dataCase_ = 2;
                return this;
            }

            public Builder clearLightGroup() {
                if (this.lightGroupBuilder_ == null) {
                    if (this.dataCase_ == 2) {
                        this.dataCase_ = 0;
                        this.data_ = null;
                        onChanged();
                    }
                } else {
                    if (this.dataCase_ == 2) {
                        this.dataCase_ = 0;
                        this.data_ = null;
                    }
                    this.lightGroupBuilder_.clear();
                }
                return this;
            }

            public TrafficLightGroup.Builder getLightGroupBuilder() {
                return getLightGroupFieldBuilder().getBuilder();
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.AutoPilotDataOrBuilder
            public TrafficLightGroupOrBuilder getLightGroupOrBuilder() {
                SingleFieldBuilderV3<TrafficLightGroup, TrafficLightGroup.Builder, TrafficLightGroupOrBuilder> singleFieldBuilderV3;
                if (this.dataCase_ == 2 && (singleFieldBuilderV3 = this.lightGroupBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (this.dataCase_ == 2) {
                    return (TrafficLightGroup) this.data_;
                }
                return TrafficLightGroup.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TrafficLightGroup, TrafficLightGroup.Builder, TrafficLightGroupOrBuilder> getLightGroupFieldBuilder() {
                if (this.lightGroupBuilder_ == null) {
                    if (this.dataCase_ != 2) {
                        this.data_ = TrafficLightGroup.getDefaultInstance();
                    }
                    this.lightGroupBuilder_ = new SingleFieldBuilderV3<>((TrafficLightGroup) this.data_, getParentForChildren(), isClean());
                    this.data_ = null;
                }
                this.dataCase_ = 2;
                onChanged();
                return this.lightGroupBuilder_;
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

        public static AutoPilotData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AutoPilotData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AutoPilotData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AutoPilotData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lane.auto_pilot.data.AutoPilotDataOuterClass$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$lane$auto_pilot$data$AutoPilotDataOuterClass$AutoPilotData$DataCase = new int[AutoPilotData.DataCase.values().length];

        static {
            try {
                $SwitchMap$lane$auto_pilot$data$AutoPilotDataOuterClass$AutoPilotData$DataCase[AutoPilotData.DataCase.POINTCLOUDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$lane$auto_pilot$data$AutoPilotDataOuterClass$AutoPilotData$DataCase[AutoPilotData.DataCase.LIGHTGROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$lane$auto_pilot$data$AutoPilotDataOuterClass$AutoPilotData$DataCase[AutoPilotData.DataCase.DATA_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class SingleTrafficLight extends GeneratedMessageV3 implements SingleTrafficLightOrBuilder {
        public static final int IDINMAP_FIELD_NUMBER = 1;
        public static final int KEEPTIME_FIELD_NUMBER = 3;
        public static final int REMAINTIME_FIELD_NUMBER = 4;
        public static final int STATUS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private long idInMap_;
        private int keepTime_;
        private byte memoizedIsInitialized;
        private int remainTime_;
        private int status_;
        private static final SingleTrafficLight DEFAULT_INSTANCE = new SingleTrafficLight();
        private static final Parser<SingleTrafficLight> PARSER = new AbstractParser<SingleTrafficLight>() { // from class: lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLight.1
            @Override // com.google.protobuf.Parser
            public SingleTrafficLight parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SingleTrafficLight(codedInputStream, extensionRegistryLite);
            }
        };

        private SingleTrafficLight(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private SingleTrafficLight() {
            this.memoizedIsInitialized = (byte) -1;
            this.idInMap_ = 0L;
            this.status_ = 0;
            this.keepTime_ = 0;
            this.remainTime_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SingleTrafficLight(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.idInMap_ = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.status_ = codedInputStream.readEnum();
                            } else if (readTag == 24) {
                                this.keepTime_ = codedInputStream.readInt32();
                            } else if (readTag == 32) {
                                this.remainTime_ = codedInputStream.readInt32();
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
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_SingleTrafficLight_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_SingleTrafficLight_fieldAccessorTable.ensureFieldAccessorsInitialized(SingleTrafficLight.class, Builder.class);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
        public long getIdInMap() {
            return this.idInMap_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
        public int getStatusValue() {
            return this.status_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
        public TrafficLightStatus getStatus() {
            TrafficLightStatus valueOf = TrafficLightStatus.valueOf(this.status_);
            return valueOf == null ? TrafficLightStatus.UNRECOGNIZED : valueOf;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
        public int getKeepTime() {
            return this.keepTime_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
        public int getRemainTime() {
            return this.remainTime_;
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
            long j = this.idInMap_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            if (this.status_ != TrafficLightStatus.TRAFFIC_LIGHT_STATUS_UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(2, this.status_);
            }
            int i = this.keepTime_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            int i2 = this.remainTime_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(4, i2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.idInMap_;
            int computeInt64Size = j != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j) : 0;
            if (this.status_ != TrafficLightStatus.TRAFFIC_LIGHT_STATUS_UNKNOWN.getNumber()) {
                computeInt64Size += CodedOutputStream.computeEnumSize(2, this.status_);
            }
            int i2 = this.keepTime_;
            if (i2 != 0) {
                computeInt64Size += CodedOutputStream.computeInt32Size(3, i2);
            }
            int i3 = this.remainTime_;
            if (i3 != 0) {
                computeInt64Size += CodedOutputStream.computeInt32Size(4, i3);
            }
            int serializedSize = computeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SingleTrafficLight)) {
                return super.equals(obj);
            }
            SingleTrafficLight singleTrafficLight = (SingleTrafficLight) obj;
            return (((((getIdInMap() > singleTrafficLight.getIdInMap() ? 1 : (getIdInMap() == singleTrafficLight.getIdInMap() ? 0 : -1)) == 0) && this.status_ == singleTrafficLight.status_) && getKeepTime() == singleTrafficLight.getKeepTime()) && getRemainTime() == singleTrafficLight.getRemainTime()) && this.unknownFields.equals(singleTrafficLight.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getIdInMap())) * 37) + 2) * 53) + this.status_) * 37) + 3) * 53) + getKeepTime()) * 37) + 4) * 53) + getRemainTime()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static SingleTrafficLight parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SingleTrafficLight parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SingleTrafficLight parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SingleTrafficLight parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SingleTrafficLight parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SingleTrafficLight parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SingleTrafficLight parseFrom(InputStream inputStream) throws IOException {
            return (SingleTrafficLight) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SingleTrafficLight parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SingleTrafficLight) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SingleTrafficLight parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SingleTrafficLight) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SingleTrafficLight parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SingleTrafficLight) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SingleTrafficLight parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SingleTrafficLight) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SingleTrafficLight parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SingleTrafficLight) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SingleTrafficLight singleTrafficLight) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(singleTrafficLight);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SingleTrafficLightOrBuilder {
            private long idInMap_;
            private int keepTime_;
            private int remainTime_;
            private int status_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_SingleTrafficLight_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_SingleTrafficLight_fieldAccessorTable.ensureFieldAccessorsInitialized(SingleTrafficLight.class, Builder.class);
            }

            private Builder() {
                this.status_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.status_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SingleTrafficLight.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.idInMap_ = 0L;
                this.status_ = 0;
                this.keepTime_ = 0;
                this.remainTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_SingleTrafficLight_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SingleTrafficLight getDefaultInstanceForType() {
                return SingleTrafficLight.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SingleTrafficLight build() {
                SingleTrafficLight buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SingleTrafficLight buildPartial() {
                SingleTrafficLight singleTrafficLight = new SingleTrafficLight(this);
                singleTrafficLight.idInMap_ = this.idInMap_;
                singleTrafficLight.status_ = this.status_;
                singleTrafficLight.keepTime_ = this.keepTime_;
                singleTrafficLight.remainTime_ = this.remainTime_;
                onBuilt();
                return singleTrafficLight;
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
                if (message instanceof SingleTrafficLight) {
                    return mergeFrom((SingleTrafficLight) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SingleTrafficLight singleTrafficLight) {
                if (singleTrafficLight == SingleTrafficLight.getDefaultInstance()) {
                    return this;
                }
                if (singleTrafficLight.getIdInMap() != 0) {
                    setIdInMap(singleTrafficLight.getIdInMap());
                }
                if (singleTrafficLight.status_ != 0) {
                    setStatusValue(singleTrafficLight.getStatusValue());
                }
                if (singleTrafficLight.getKeepTime() != 0) {
                    setKeepTime(singleTrafficLight.getKeepTime());
                }
                if (singleTrafficLight.getRemainTime() != 0) {
                    setRemainTime(singleTrafficLight.getRemainTime());
                }
                mergeUnknownFields(singleTrafficLight.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLight.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLight.access$7100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    lane.auto_pilot.data.AutoPilotDataOuterClass$SingleTrafficLight r3 = (lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLight) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    lane.auto_pilot.data.AutoPilotDataOuterClass$SingleTrafficLight r4 = (lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLight) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLight.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):lane.auto_pilot.data.AutoPilotDataOuterClass$SingleTrafficLight$Builder");
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
            public long getIdInMap() {
                return this.idInMap_;
            }

            public Builder setIdInMap(long j) {
                this.idInMap_ = j;
                onChanged();
                return this;
            }

            public Builder clearIdInMap() {
                this.idInMap_ = 0L;
                onChanged();
                return this;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
            public int getStatusValue() {
                return this.status_;
            }

            public Builder setStatusValue(int i) {
                this.status_ = i;
                onChanged();
                return this;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
            public TrafficLightStatus getStatus() {
                TrafficLightStatus valueOf = TrafficLightStatus.valueOf(this.status_);
                return valueOf == null ? TrafficLightStatus.UNRECOGNIZED : valueOf;
            }

            public Builder setStatus(TrafficLightStatus trafficLightStatus) {
                if (trafficLightStatus == null) {
                    throw new NullPointerException();
                }
                this.status_ = trafficLightStatus.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = 0;
                onChanged();
                return this;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
            public int getKeepTime() {
                return this.keepTime_;
            }

            public Builder setKeepTime(int i) {
                this.keepTime_ = i;
                onChanged();
                return this;
            }

            public Builder clearKeepTime() {
                this.keepTime_ = 0;
                onChanged();
                return this;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.SingleTrafficLightOrBuilder
            public int getRemainTime() {
                return this.remainTime_;
            }

            public Builder setRemainTime(int i) {
                this.remainTime_ = i;
                onChanged();
                return this;
            }

            public Builder clearRemainTime() {
                this.remainTime_ = 0;
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

        public static SingleTrafficLight getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SingleTrafficLight> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SingleTrafficLight> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SingleTrafficLight getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class TrafficLightGroup extends GeneratedMessageV3 implements TrafficLightGroupOrBuilder {
        public static final int LIGHTS_FIELD_NUMBER = 1;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<SingleTrafficLight> lights_;
        private byte memoizedIsInitialized;
        private long timestamp_;
        private static final TrafficLightGroup DEFAULT_INSTANCE = new TrafficLightGroup();
        private static final Parser<TrafficLightGroup> PARSER = new AbstractParser<TrafficLightGroup>() { // from class: lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroup.1
            @Override // com.google.protobuf.Parser
            public TrafficLightGroup parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TrafficLightGroup(codedInputStream, extensionRegistryLite);
            }
        };

        private TrafficLightGroup(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private TrafficLightGroup() {
            this.memoizedIsInitialized = (byte) -1;
            this.lights_ = Collections.emptyList();
            this.timestamp_ = 0L;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private TrafficLightGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.lights_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.lights_.add(codedInputStream.readMessage(SingleTrafficLight.parser(), extensionRegistryLite));
                            } else if (readTag == 16) {
                                this.timestamp_ = codedInputStream.readInt64();
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
                        this.lights_ = Collections.unmodifiableList(this.lights_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_TrafficLightGroup_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_TrafficLightGroup_fieldAccessorTable.ensureFieldAccessorsInitialized(TrafficLightGroup.class, Builder.class);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
        public List<SingleTrafficLight> getLightsList() {
            return this.lights_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
        public List<? extends SingleTrafficLightOrBuilder> getLightsOrBuilderList() {
            return this.lights_;
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
        public int getLightsCount() {
            return this.lights_.size();
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
        public SingleTrafficLight getLights(int i) {
            return this.lights_.get(i);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
        public SingleTrafficLightOrBuilder getLightsOrBuilder(int i) {
            return this.lights_.get(i);
        }

        @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
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
            for (int i = 0; i < this.lights_.size(); i++) {
                codedOutputStream.writeMessage(1, this.lights_.get(i));
            }
            long j = this.timestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(2, j);
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
            for (int i3 = 0; i3 < this.lights_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.lights_.get(i3));
            }
            long j = this.timestamp_;
            if (j != 0) {
                i2 += CodedOutputStream.computeInt64Size(2, j);
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
            if (!(obj instanceof TrafficLightGroup)) {
                return super.equals(obj);
            }
            TrafficLightGroup trafficLightGroup = (TrafficLightGroup) obj;
            return ((getLightsList().equals(trafficLightGroup.getLightsList())) && (getTimestamp() > trafficLightGroup.getTimestamp() ? 1 : (getTimestamp() == trafficLightGroup.getTimestamp() ? 0 : -1)) == 0) && this.unknownFields.equals(trafficLightGroup.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (getLightsCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getLightsList().hashCode();
            }
            int hashLong = (((((hashCode * 37) + 2) * 53) + Internal.hashLong(getTimestamp())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashLong;
            return hashLong;
        }

        public static TrafficLightGroup parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static TrafficLightGroup parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static TrafficLightGroup parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static TrafficLightGroup parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static TrafficLightGroup parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static TrafficLightGroup parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static TrafficLightGroup parseFrom(InputStream inputStream) throws IOException {
            return (TrafficLightGroup) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static TrafficLightGroup parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TrafficLightGroup) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static TrafficLightGroup parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TrafficLightGroup) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TrafficLightGroup parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TrafficLightGroup) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static TrafficLightGroup parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TrafficLightGroup) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static TrafficLightGroup parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TrafficLightGroup) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TrafficLightGroup trafficLightGroup) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(trafficLightGroup);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TrafficLightGroupOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> lightsBuilder_;
            private List<SingleTrafficLight> lights_;
            private long timestamp_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_TrafficLightGroup_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_TrafficLightGroup_fieldAccessorTable.ensureFieldAccessorsInitialized(TrafficLightGroup.class, Builder.class);
            }

            private Builder() {
                this.lights_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.lights_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TrafficLightGroup.alwaysUseFieldBuilders) {
                    getLightsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.lights_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.timestamp_ = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AutoPilotDataOuterClass.internal_static_lane_auto_pilot_data_TrafficLightGroup_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TrafficLightGroup getDefaultInstanceForType() {
                return TrafficLightGroup.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrafficLightGroup build() {
                TrafficLightGroup buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrafficLightGroup buildPartial() {
                TrafficLightGroup trafficLightGroup = new TrafficLightGroup(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) == 1) {
                        this.lights_ = Collections.unmodifiableList(this.lights_);
                        this.bitField0_ &= -2;
                    }
                    trafficLightGroup.lights_ = this.lights_;
                } else {
                    trafficLightGroup.lights_ = repeatedFieldBuilderV3.build();
                }
                trafficLightGroup.timestamp_ = this.timestamp_;
                trafficLightGroup.bitField0_ = 0;
                onBuilt();
                return trafficLightGroup;
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
                if (message instanceof TrafficLightGroup) {
                    return mergeFrom((TrafficLightGroup) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(TrafficLightGroup trafficLightGroup) {
                if (trafficLightGroup == TrafficLightGroup.getDefaultInstance()) {
                    return this;
                }
                if (this.lightsBuilder_ == null) {
                    if (!trafficLightGroup.lights_.isEmpty()) {
                        if (this.lights_.isEmpty()) {
                            this.lights_ = trafficLightGroup.lights_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureLightsIsMutable();
                            this.lights_.addAll(trafficLightGroup.lights_);
                        }
                        onChanged();
                    }
                } else if (!trafficLightGroup.lights_.isEmpty()) {
                    if (!this.lightsBuilder_.isEmpty()) {
                        this.lightsBuilder_.addAllMessages(trafficLightGroup.lights_);
                    } else {
                        this.lightsBuilder_.dispose();
                        this.lightsBuilder_ = null;
                        this.lights_ = trafficLightGroup.lights_;
                        this.bitField0_ &= -2;
                        this.lightsBuilder_ = TrafficLightGroup.alwaysUseFieldBuilders ? getLightsFieldBuilder() : null;
                    }
                }
                if (trafficLightGroup.getTimestamp() != 0) {
                    setTimestamp(trafficLightGroup.getTimestamp());
                }
                mergeUnknownFields(trafficLightGroup.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroup.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroup.access$8400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    lane.auto_pilot.data.AutoPilotDataOuterClass$TrafficLightGroup r3 = (lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroup) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    lane.auto_pilot.data.AutoPilotDataOuterClass$TrafficLightGroup r4 = (lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroup) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroup.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):lane.auto_pilot.data.AutoPilotDataOuterClass$TrafficLightGroup$Builder");
            }

            private void ensureLightsIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.lights_ = new ArrayList(this.lights_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
            public List<SingleTrafficLight> getLightsList() {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.lights_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
            public int getLightsCount() {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.lights_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
            public SingleTrafficLight getLights(int i) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.lights_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setLights(int i, SingleTrafficLight singleTrafficLight) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, singleTrafficLight);
                } else if (singleTrafficLight == null) {
                    throw new NullPointerException();
                } else {
                    ensureLightsIsMutable();
                    this.lights_.set(i, singleTrafficLight);
                    onChanged();
                }
                return this;
            }

            public Builder setLights(int i, SingleTrafficLight.Builder builder) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLightsIsMutable();
                    this.lights_.set(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                }
                return this;
            }

            public Builder addLights(SingleTrafficLight singleTrafficLight) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(singleTrafficLight);
                } else if (singleTrafficLight == null) {
                    throw new NullPointerException();
                } else {
                    ensureLightsIsMutable();
                    this.lights_.add(singleTrafficLight);
                    onChanged();
                }
                return this;
            }

            public Builder addLights(int i, SingleTrafficLight singleTrafficLight) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, singleTrafficLight);
                } else if (singleTrafficLight == null) {
                    throw new NullPointerException();
                } else {
                    ensureLightsIsMutable();
                    this.lights_.add(i, singleTrafficLight);
                    onChanged();
                }
                return this;
            }

            public Builder addLights(SingleTrafficLight.Builder builder) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLightsIsMutable();
                    this.lights_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addLights(int i, SingleTrafficLight.Builder builder) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLightsIsMutable();
                    this.lights_.add(i, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                }
                return this;
            }

            public Builder addAllLights(Iterable<? extends SingleTrafficLight> iterable) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLightsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.lights_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder clearLights() {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.lights_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeLights(int i) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureLightsIsMutable();
                    this.lights_.remove(i);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i);
                }
                return this;
            }

            public SingleTrafficLight.Builder getLightsBuilder(int i) {
                return getLightsFieldBuilder().getBuilder(i);
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
            public SingleTrafficLightOrBuilder getLightsOrBuilder(int i) {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.lights_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
            public List<? extends SingleTrafficLightOrBuilder> getLightsOrBuilderList() {
                RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> repeatedFieldBuilderV3 = this.lightsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.lights_);
            }

            public SingleTrafficLight.Builder addLightsBuilder() {
                return getLightsFieldBuilder().addBuilder(SingleTrafficLight.getDefaultInstance());
            }

            public SingleTrafficLight.Builder addLightsBuilder(int i) {
                return getLightsFieldBuilder().addBuilder(i, SingleTrafficLight.getDefaultInstance());
            }

            public List<SingleTrafficLight.Builder> getLightsBuilderList() {
                return getLightsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SingleTrafficLight, SingleTrafficLight.Builder, SingleTrafficLightOrBuilder> getLightsFieldBuilder() {
                if (this.lightsBuilder_ == null) {
                    this.lightsBuilder_ = new RepeatedFieldBuilderV3<>(this.lights_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.lights_ = null;
                }
                return this.lightsBuilder_;
            }

            @Override // lane.auto_pilot.data.AutoPilotDataOuterClass.TrafficLightGroupOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            public Builder setTimestamp(long j) {
                this.timestamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0L;
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

        public static TrafficLightGroup getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TrafficLightGroup> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TrafficLightGroup> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TrafficLightGroup getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015auto_pilot_data.proto\u0012\u0014lane.auto_pilot.data\"C\n\nLidarPoint\u0012\t\n\u0001x\u0018\u0001 \u0001(\u0001\u0012\t\n\u0001y\u0018\u0002 \u0001(\u0001\u0012\t\n\u0001z\u0018\u0003 \u0001(\u0001\u0012\u0014\n\freflectivity\u0018\u0004 \u0001(\u0001\"$\n\u000fLidarPointParam\u0012\u0011\n\tlineCount\u0018\u0001 \u0001(\u0005\"\u0099\u0001\n\u000fLidarPointCloud\u0012\n\n\u0002id\u0018\u0001 \u0001(\u0005\u00124\n\u0005param\u0018\u0002 \u0001(\u000b2%.lane.auto_pilot.data.LidarPointParam\u0012\u0012\n\npointCount\u0018\u0003 \u0001(\u0005\u00120\n\u0006points\u0018\u0004 \u0003(\u000b2 .lane.auto_pilot.data.LidarPoint\"M\n\u0010LidarPointClouds\u00129\n\npointCloud\u0018\u0001 \u0003(\u000b2%.lane.auto_pilot.data.LidarPointCloud\"\u0095\u0001\n\rAutoPilotData\u0012=\n\u000bpointClouds\u0018\u0001 \u0001(\u000b2&.lane.auto_pilot.data.LidarPointCloudsH\u0000\u0012=\n\nlightGroup\u0018\u0002 \u0001(\u000b2'.lane.auto_pilot.data.TrafficLightGroupH\u0000B\u0006\n\u0004data\"\u0085\u0001\n\u0012SingleTrafficLight\u0012\u000f\n\u0007idInMap\u0018\u0001 \u0001(\u0003\u00128\n\u0006status\u0018\u0002 \u0001(\u000e2(.lane.auto_pilot.data.TrafficLightStatus\u0012\u0010\n\bkeepTime\u0018\u0003 \u0001(\u0005\u0012\u0012\n\nremainTime\u0018\u0004 \u0001(\u0005\"`\n\u0011TrafficLightGroup\u00128\n\u0006lights\u0018\u0001 \u0003(\u000b2(.lane.auto_pilot.data.SingleTrafficLight\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003*¯\u0002\n\u0012TrafficLightStatus\u0012 \n\u001cTRAFFIC_LIGHT_STATUS_UNKNOWN\u0010\u0000\u0012\u001c\n\u0018TRAFFIC_LIGHT_STATUS_RED\u0010\u0001\u0012\u001f\n\u001bTRAFFIC_LIGHT_STATUS_YELLOW\u0010\u0002\u0012\u001e\n\u001aTRAFFIC_LIGHT_STATUS_GREEN\u0010\u0003\u0012%\n!TRAFFIC_LIGHT_STATUS_FLASHING_RED\u0010\u0004\u0012(\n$TRAFFIC_LIGHT_STATUS_FLASHING_YELLOW\u0010\u0005\u0012'\n#TRAFFIC_LIGHT_STATUS_FLASHING_GREEN\u0010\u0006\u0012\u001e\n\u001aTRAFFIC_LIGHT_STATUS_BLACK\u0010\u0007b\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: lane.auto_pilot.data.AutoPilotDataOuterClass.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = AutoPilotDataOuterClass.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_lane_auto_pilot_data_LidarPoint_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_lane_auto_pilot_data_LidarPoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_lane_auto_pilot_data_LidarPoint_descriptor, new String[]{"X", "Y", "Z", "Reflectivity"});
        internal_static_lane_auto_pilot_data_LidarPointParam_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_lane_auto_pilot_data_LidarPointParam_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_lane_auto_pilot_data_LidarPointParam_descriptor, new String[]{"LineCount"});
        internal_static_lane_auto_pilot_data_LidarPointCloud_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_lane_auto_pilot_data_LidarPointCloud_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_lane_auto_pilot_data_LidarPointCloud_descriptor, new String[]{"Id", "Param", "PointCount", "Points"});
        internal_static_lane_auto_pilot_data_LidarPointClouds_descriptor = getDescriptor().getMessageTypes().get(3);
        internal_static_lane_auto_pilot_data_LidarPointClouds_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_lane_auto_pilot_data_LidarPointClouds_descriptor, new String[]{"PointCloud"});
        internal_static_lane_auto_pilot_data_AutoPilotData_descriptor = getDescriptor().getMessageTypes().get(4);
        internal_static_lane_auto_pilot_data_AutoPilotData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_lane_auto_pilot_data_AutoPilotData_descriptor, new String[]{"PointClouds", "LightGroup", "Data"});
        internal_static_lane_auto_pilot_data_SingleTrafficLight_descriptor = getDescriptor().getMessageTypes().get(5);
        internal_static_lane_auto_pilot_data_SingleTrafficLight_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_lane_auto_pilot_data_SingleTrafficLight_descriptor, new String[]{"IdInMap", "Status", "KeepTime", "RemainTime"});
        internal_static_lane_auto_pilot_data_TrafficLightGroup_descriptor = getDescriptor().getMessageTypes().get(6);
        internal_static_lane_auto_pilot_data_TrafficLightGroup_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_lane_auto_pilot_data_TrafficLightGroup_descriptor, new String[]{"Lights", "Timestamp"});
    }
}
