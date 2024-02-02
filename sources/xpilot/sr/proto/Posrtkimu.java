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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;
import xpilot.sr.proto.Primitives;
/* loaded from: classes3.dex */
public final class Posrtkimu {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_Gaode_Info_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_Gaode_Info_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_PosFusionResultExternal_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_PosFusionResultExternal_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_PosRTKImuResultExternal_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_PosRTKImuResultExternal_fieldAccessorTable;

    /* loaded from: classes3.dex */
    public interface Gaode_InfoOrBuilder extends MessageOrBuilder {
        PosRTKImuResultExternal getBrief8();

        PosRTKImuResultExternalOrBuilder getBrief8OrBuilder();

        PosFusionResultExternal getBrief9();

        PosFusionResultExternalOrBuilder getBrief9OrBuilder();

        boolean hasBrief8();

        boolean hasBrief9();
    }

    /* loaded from: classes3.dex */
    public interface PosFusionResultExternalOrBuilder extends MessageOrBuilder {
        float getAlt();

        float getAltAcc();

        float getCourse();

        float getCourseAcc();

        long getDatetime();

        int getEw();

        int getFusiontype();

        int getNs();

        float getPosAcc();

        Primitives.Vector3D getPosEnu();

        Primitives.Vector3DOrBuilder getPosEnuOrBuilder();

        Primitives.Vector3D getRefPosEcef();

        Primitives.Vector3DOrBuilder getRefPosEcefOrBuilder();

        Primitives.Quaternion getRefPosEcefq();

        Primitives.QuaternionOrBuilder getRefPosEcefqOrBuilder();

        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();

        float getSpeed();

        float getSpeedAcc();

        int getStatus();

        long getTicktime();

        Primitives.Vector3D getWorldecefp();

        Primitives.Vector3DOrBuilder getWorldecefpOrBuilder();

        Primitives.Quaternion getWorldecefq();

        Primitives.QuaternionOrBuilder getWorldecefqOrBuilder();

        boolean hasPosEnu();

        boolean hasRefPosEcef();

        boolean hasRefPosEcefq();

        boolean hasWorldecefp();

        boolean hasWorldecefq();
    }

    /* loaded from: classes3.dex */
    public interface PosRTKImuResultExternalOrBuilder extends MessageOrBuilder {
        float getAlt();

        float getAltacc();

        float getCourse();

        float getCourseacc();

        long getDatetime();

        int getEw();

        int getFusiontype();

        float getHdop();

        Primitives.Vector3D getLocalPose();

        Primitives.Vector3DOrBuilder getLocalPoseOrBuilder();

        int getNs();

        float getPdop();

        Primitives.GlobalPoseInfo getPos();

        Primitives.GlobalPoseInfoOrBuilder getPosOrBuilder();

        float getPosacc();

        float getSatnum();

        float getSpare(int i);

        int getSpareCount();

        List<Float> getSpareList();

        float getSpeed();

        float getSpeedacc();

        int getStatus();

        long getTicktime();

        float getVdop();

        boolean hasLocalPose();

        boolean hasPos();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Posrtkimu() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes3.dex */
    public static final class Gaode_Info extends GeneratedMessageV3 implements Gaode_InfoOrBuilder {
        public static final int BRIEF8_FIELD_NUMBER = 1;
        public static final int BRIEF9_FIELD_NUMBER = 2;
        private static final Gaode_Info DEFAULT_INSTANCE = new Gaode_Info();
        private static final Parser<Gaode_Info> PARSER = new AbstractParser<Gaode_Info>() { // from class: xpilot.sr.proto.Posrtkimu.Gaode_Info.1
            @Override // com.google.protobuf.Parser
            public Gaode_Info parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Gaode_Info(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private PosRTKImuResultExternal brief8_;
        private PosFusionResultExternal brief9_;
        private byte memoizedIsInitialized;

        private Gaode_Info(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Gaode_Info() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Gaode_Info(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                PosRTKImuResultExternal.Builder builder = this.brief8_ != null ? this.brief8_.toBuilder() : null;
                                this.brief8_ = (PosRTKImuResultExternal) codedInputStream.readMessage(PosRTKImuResultExternal.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.brief8_);
                                    this.brief8_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                PosFusionResultExternal.Builder builder2 = this.brief9_ != null ? this.brief9_.toBuilder() : null;
                                this.brief9_ = (PosFusionResultExternal) codedInputStream.readMessage(PosFusionResultExternal.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.brief9_);
                                    this.brief9_ = builder2.buildPartial();
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
            return Posrtkimu.internal_static_xpilot_sr_proto_Gaode_Info_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Posrtkimu.internal_static_xpilot_sr_proto_Gaode_Info_fieldAccessorTable.ensureFieldAccessorsInitialized(Gaode_Info.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
        public boolean hasBrief8() {
            return this.brief8_ != null;
        }

        @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
        public PosRTKImuResultExternal getBrief8() {
            PosRTKImuResultExternal posRTKImuResultExternal = this.brief8_;
            return posRTKImuResultExternal == null ? PosRTKImuResultExternal.getDefaultInstance() : posRTKImuResultExternal;
        }

        @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
        public PosRTKImuResultExternalOrBuilder getBrief8OrBuilder() {
            return getBrief8();
        }

        @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
        public boolean hasBrief9() {
            return this.brief9_ != null;
        }

        @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
        public PosFusionResultExternal getBrief9() {
            PosFusionResultExternal posFusionResultExternal = this.brief9_;
            return posFusionResultExternal == null ? PosFusionResultExternal.getDefaultInstance() : posFusionResultExternal;
        }

        @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
        public PosFusionResultExternalOrBuilder getBrief9OrBuilder() {
            return getBrief9();
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
            if (this.brief8_ != null) {
                codedOutputStream.writeMessage(1, getBrief8());
            }
            if (this.brief9_ != null) {
                codedOutputStream.writeMessage(2, getBrief9());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.brief8_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getBrief8()) : 0;
            if (this.brief9_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getBrief9());
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
            if (!(obj instanceof Gaode_Info)) {
                return super.equals(obj);
            }
            Gaode_Info gaode_Info = (Gaode_Info) obj;
            boolean z = hasBrief8() == gaode_Info.hasBrief8();
            if (hasBrief8()) {
                z = z && getBrief8().equals(gaode_Info.getBrief8());
            }
            boolean z2 = z && hasBrief9() == gaode_Info.hasBrief9();
            if (hasBrief9()) {
                z2 = z2 && getBrief9().equals(gaode_Info.getBrief9());
            }
            return z2 && this.unknownFields.equals(gaode_Info.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasBrief8()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getBrief8().hashCode();
            }
            if (hasBrief9()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getBrief9().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Gaode_Info parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Gaode_Info parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Gaode_Info parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Gaode_Info parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Gaode_Info parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Gaode_Info parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Gaode_Info parseFrom(InputStream inputStream) throws IOException {
            return (Gaode_Info) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Gaode_Info parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Gaode_Info) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Gaode_Info parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Gaode_Info) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Gaode_Info parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Gaode_Info) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Gaode_Info parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Gaode_Info) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Gaode_Info parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Gaode_Info) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Gaode_Info gaode_Info) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(gaode_Info);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Gaode_InfoOrBuilder {
            private SingleFieldBuilderV3<PosRTKImuResultExternal, PosRTKImuResultExternal.Builder, PosRTKImuResultExternalOrBuilder> brief8Builder_;
            private PosRTKImuResultExternal brief8_;
            private SingleFieldBuilderV3<PosFusionResultExternal, PosFusionResultExternal.Builder, PosFusionResultExternalOrBuilder> brief9Builder_;
            private PosFusionResultExternal brief9_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Posrtkimu.internal_static_xpilot_sr_proto_Gaode_Info_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Posrtkimu.internal_static_xpilot_sr_proto_Gaode_Info_fieldAccessorTable.ensureFieldAccessorsInitialized(Gaode_Info.class, Builder.class);
            }

            private Builder() {
                this.brief8_ = null;
                this.brief9_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.brief8_ = null;
                this.brief9_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Gaode_Info.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.brief8Builder_ == null) {
                    this.brief8_ = null;
                } else {
                    this.brief8_ = null;
                    this.brief8Builder_ = null;
                }
                if (this.brief9Builder_ == null) {
                    this.brief9_ = null;
                } else {
                    this.brief9_ = null;
                    this.brief9Builder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Posrtkimu.internal_static_xpilot_sr_proto_Gaode_Info_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Gaode_Info getDefaultInstanceForType() {
                return Gaode_Info.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Gaode_Info build() {
                Gaode_Info buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Gaode_Info buildPartial() {
                Gaode_Info gaode_Info = new Gaode_Info(this);
                SingleFieldBuilderV3<PosRTKImuResultExternal, PosRTKImuResultExternal.Builder, PosRTKImuResultExternalOrBuilder> singleFieldBuilderV3 = this.brief8Builder_;
                if (singleFieldBuilderV3 == null) {
                    gaode_Info.brief8_ = this.brief8_;
                } else {
                    gaode_Info.brief8_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<PosFusionResultExternal, PosFusionResultExternal.Builder, PosFusionResultExternalOrBuilder> singleFieldBuilderV32 = this.brief9Builder_;
                if (singleFieldBuilderV32 == null) {
                    gaode_Info.brief9_ = this.brief9_;
                } else {
                    gaode_Info.brief9_ = singleFieldBuilderV32.build();
                }
                onBuilt();
                return gaode_Info;
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
                if (message instanceof Gaode_Info) {
                    return mergeFrom((Gaode_Info) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Gaode_Info gaode_Info) {
                if (gaode_Info == Gaode_Info.getDefaultInstance()) {
                    return this;
                }
                if (gaode_Info.hasBrief8()) {
                    mergeBrief8(gaode_Info.getBrief8());
                }
                if (gaode_Info.hasBrief9()) {
                    mergeBrief9(gaode_Info.getBrief9());
                }
                mergeUnknownFields(gaode_Info.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Posrtkimu.Gaode_Info.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Posrtkimu.Gaode_Info.access$900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Posrtkimu$Gaode_Info r3 = (xpilot.sr.proto.Posrtkimu.Gaode_Info) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Posrtkimu$Gaode_Info r4 = (xpilot.sr.proto.Posrtkimu.Gaode_Info) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Posrtkimu.Gaode_Info.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Posrtkimu$Gaode_Info$Builder");
            }

            @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
            public boolean hasBrief8() {
                return (this.brief8Builder_ == null && this.brief8_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
            public PosRTKImuResultExternal getBrief8() {
                SingleFieldBuilderV3<PosRTKImuResultExternal, PosRTKImuResultExternal.Builder, PosRTKImuResultExternalOrBuilder> singleFieldBuilderV3 = this.brief8Builder_;
                if (singleFieldBuilderV3 == null) {
                    PosRTKImuResultExternal posRTKImuResultExternal = this.brief8_;
                    return posRTKImuResultExternal == null ? PosRTKImuResultExternal.getDefaultInstance() : posRTKImuResultExternal;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setBrief8(PosRTKImuResultExternal posRTKImuResultExternal) {
                SingleFieldBuilderV3<PosRTKImuResultExternal, PosRTKImuResultExternal.Builder, PosRTKImuResultExternalOrBuilder> singleFieldBuilderV3 = this.brief8Builder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(posRTKImuResultExternal);
                } else if (posRTKImuResultExternal == null) {
                    throw new NullPointerException();
                } else {
                    this.brief8_ = posRTKImuResultExternal;
                    onChanged();
                }
                return this;
            }

            public Builder setBrief8(PosRTKImuResultExternal.Builder builder) {
                SingleFieldBuilderV3<PosRTKImuResultExternal, PosRTKImuResultExternal.Builder, PosRTKImuResultExternalOrBuilder> singleFieldBuilderV3 = this.brief8Builder_;
                if (singleFieldBuilderV3 == null) {
                    this.brief8_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeBrief8(PosRTKImuResultExternal posRTKImuResultExternal) {
                SingleFieldBuilderV3<PosRTKImuResultExternal, PosRTKImuResultExternal.Builder, PosRTKImuResultExternalOrBuilder> singleFieldBuilderV3 = this.brief8Builder_;
                if (singleFieldBuilderV3 == null) {
                    PosRTKImuResultExternal posRTKImuResultExternal2 = this.brief8_;
                    if (posRTKImuResultExternal2 != null) {
                        this.brief8_ = PosRTKImuResultExternal.newBuilder(posRTKImuResultExternal2).mergeFrom(posRTKImuResultExternal).buildPartial();
                    } else {
                        this.brief8_ = posRTKImuResultExternal;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(posRTKImuResultExternal);
                }
                return this;
            }

            public Builder clearBrief8() {
                if (this.brief8Builder_ == null) {
                    this.brief8_ = null;
                    onChanged();
                } else {
                    this.brief8_ = null;
                    this.brief8Builder_ = null;
                }
                return this;
            }

            public PosRTKImuResultExternal.Builder getBrief8Builder() {
                onChanged();
                return getBrief8FieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
            public PosRTKImuResultExternalOrBuilder getBrief8OrBuilder() {
                SingleFieldBuilderV3<PosRTKImuResultExternal, PosRTKImuResultExternal.Builder, PosRTKImuResultExternalOrBuilder> singleFieldBuilderV3 = this.brief8Builder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                PosRTKImuResultExternal posRTKImuResultExternal = this.brief8_;
                return posRTKImuResultExternal == null ? PosRTKImuResultExternal.getDefaultInstance() : posRTKImuResultExternal;
            }

            private SingleFieldBuilderV3<PosRTKImuResultExternal, PosRTKImuResultExternal.Builder, PosRTKImuResultExternalOrBuilder> getBrief8FieldBuilder() {
                if (this.brief8Builder_ == null) {
                    this.brief8Builder_ = new SingleFieldBuilderV3<>(getBrief8(), getParentForChildren(), isClean());
                    this.brief8_ = null;
                }
                return this.brief8Builder_;
            }

            @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
            public boolean hasBrief9() {
                return (this.brief9Builder_ == null && this.brief9_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
            public PosFusionResultExternal getBrief9() {
                SingleFieldBuilderV3<PosFusionResultExternal, PosFusionResultExternal.Builder, PosFusionResultExternalOrBuilder> singleFieldBuilderV3 = this.brief9Builder_;
                if (singleFieldBuilderV3 == null) {
                    PosFusionResultExternal posFusionResultExternal = this.brief9_;
                    return posFusionResultExternal == null ? PosFusionResultExternal.getDefaultInstance() : posFusionResultExternal;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setBrief9(PosFusionResultExternal posFusionResultExternal) {
                SingleFieldBuilderV3<PosFusionResultExternal, PosFusionResultExternal.Builder, PosFusionResultExternalOrBuilder> singleFieldBuilderV3 = this.brief9Builder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(posFusionResultExternal);
                } else if (posFusionResultExternal == null) {
                    throw new NullPointerException();
                } else {
                    this.brief9_ = posFusionResultExternal;
                    onChanged();
                }
                return this;
            }

            public Builder setBrief9(PosFusionResultExternal.Builder builder) {
                SingleFieldBuilderV3<PosFusionResultExternal, PosFusionResultExternal.Builder, PosFusionResultExternalOrBuilder> singleFieldBuilderV3 = this.brief9Builder_;
                if (singleFieldBuilderV3 == null) {
                    this.brief9_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeBrief9(PosFusionResultExternal posFusionResultExternal) {
                SingleFieldBuilderV3<PosFusionResultExternal, PosFusionResultExternal.Builder, PosFusionResultExternalOrBuilder> singleFieldBuilderV3 = this.brief9Builder_;
                if (singleFieldBuilderV3 == null) {
                    PosFusionResultExternal posFusionResultExternal2 = this.brief9_;
                    if (posFusionResultExternal2 != null) {
                        this.brief9_ = PosFusionResultExternal.newBuilder(posFusionResultExternal2).mergeFrom(posFusionResultExternal).buildPartial();
                    } else {
                        this.brief9_ = posFusionResultExternal;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(posFusionResultExternal);
                }
                return this;
            }

            public Builder clearBrief9() {
                if (this.brief9Builder_ == null) {
                    this.brief9_ = null;
                    onChanged();
                } else {
                    this.brief9_ = null;
                    this.brief9Builder_ = null;
                }
                return this;
            }

            public PosFusionResultExternal.Builder getBrief9Builder() {
                onChanged();
                return getBrief9FieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Posrtkimu.Gaode_InfoOrBuilder
            public PosFusionResultExternalOrBuilder getBrief9OrBuilder() {
                SingleFieldBuilderV3<PosFusionResultExternal, PosFusionResultExternal.Builder, PosFusionResultExternalOrBuilder> singleFieldBuilderV3 = this.brief9Builder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                PosFusionResultExternal posFusionResultExternal = this.brief9_;
                return posFusionResultExternal == null ? PosFusionResultExternal.getDefaultInstance() : posFusionResultExternal;
            }

            private SingleFieldBuilderV3<PosFusionResultExternal, PosFusionResultExternal.Builder, PosFusionResultExternalOrBuilder> getBrief9FieldBuilder() {
                if (this.brief9Builder_ == null) {
                    this.brief9Builder_ = new SingleFieldBuilderV3<>(getBrief9(), getParentForChildren(), isClean());
                    this.brief9_ = null;
                }
                return this.brief9Builder_;
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

        public static Gaode_Info getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Gaode_Info> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Gaode_Info> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Gaode_Info getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class PosRTKImuResultExternal extends GeneratedMessageV3 implements PosRTKImuResultExternalOrBuilder {
        public static final int ALTACC_FIELD_NUMBER = 11;
        public static final int ALT_FIELD_NUMBER = 8;
        public static final int COURSEACC_FIELD_NUMBER = 10;
        public static final int COURSE_FIELD_NUMBER = 7;
        public static final int DATETIME_FIELD_NUMBER = 17;
        public static final int EW_FIELD_NUMBER = 4;
        public static final int FUSIONTYPE_FIELD_NUMBER = 18;
        public static final int HDOP_FIELD_NUMBER = 14;
        public static final int LOCAL_POSE_FIELD_NUMBER = 19;
        public static final int NS_FIELD_NUMBER = 3;
        public static final int PDOP_FIELD_NUMBER = 16;
        public static final int POSACC_FIELD_NUMBER = 9;
        public static final int POS_FIELD_NUMBER = 5;
        public static final int SATNUM_FIELD_NUMBER = 13;
        public static final int SPARE_FIELD_NUMBER = 20;
        public static final int SPEEDACC_FIELD_NUMBER = 12;
        public static final int SPEED_FIELD_NUMBER = 6;
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TICKTIME_FIELD_NUMBER = 1;
        public static final int VDOP_FIELD_NUMBER = 15;
        private static final long serialVersionUID = 0;
        private float alt_;
        private float altacc_;
        private int bitField0_;
        private float course_;
        private float courseacc_;
        private long datetime_;
        private int ew_;
        private int fusiontype_;
        private float hdop_;
        private Primitives.Vector3D localPose_;
        private byte memoizedIsInitialized;
        private int ns_;
        private float pdop_;
        private Primitives.GlobalPoseInfo pos_;
        private float posacc_;
        private float satnum_;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private float speed_;
        private float speedacc_;
        private int status_;
        private long ticktime_;
        private float vdop_;
        private static final PosRTKImuResultExternal DEFAULT_INSTANCE = new PosRTKImuResultExternal();
        private static final Parser<PosRTKImuResultExternal> PARSER = new AbstractParser<PosRTKImuResultExternal>() { // from class: xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternal.1
            @Override // com.google.protobuf.Parser
            public PosRTKImuResultExternal parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PosRTKImuResultExternal(codedInputStream, extensionRegistryLite);
            }
        };

        private PosRTKImuResultExternal(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private PosRTKImuResultExternal() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.ticktime_ = 0L;
            this.status_ = 0;
            this.ns_ = 0;
            this.ew_ = 0;
            this.speed_ = 0.0f;
            this.course_ = 0.0f;
            this.alt_ = 0.0f;
            this.posacc_ = 0.0f;
            this.courseacc_ = 0.0f;
            this.altacc_ = 0.0f;
            this.speedacc_ = 0.0f;
            this.satnum_ = 0.0f;
            this.hdop_ = 0.0f;
            this.vdop_ = 0.0f;
            this.pdop_ = 0.0f;
            this.datetime_ = 0L;
            this.fusiontype_ = 0;
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
        private PosRTKImuResultExternal(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r3 = 524288;
                if (z) {
                    return;
                }
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.ticktime_ = codedInputStream.readUInt64();
                                    continue;
                                case 16:
                                    this.status_ = codedInputStream.readInt32();
                                    continue;
                                case 24:
                                    this.ns_ = codedInputStream.readInt32();
                                    continue;
                                case 32:
                                    this.ew_ = codedInputStream.readInt32();
                                    continue;
                                case 42:
                                    Primitives.GlobalPoseInfo.Builder builder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                    this.pos_ = (Primitives.GlobalPoseInfo) codedInputStream.readMessage(Primitives.GlobalPoseInfo.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.pos_);
                                        this.pos_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 53:
                                    this.speed_ = codedInputStream.readFloat();
                                    continue;
                                case 61:
                                    this.course_ = codedInputStream.readFloat();
                                    continue;
                                case 69:
                                    this.alt_ = codedInputStream.readFloat();
                                    continue;
                                case 77:
                                    this.posacc_ = codedInputStream.readFloat();
                                    continue;
                                case 85:
                                    this.courseacc_ = codedInputStream.readFloat();
                                    continue;
                                case 93:
                                    this.altacc_ = codedInputStream.readFloat();
                                    continue;
                                case 101:
                                    this.speedacc_ = codedInputStream.readFloat();
                                    continue;
                                case 109:
                                    this.satnum_ = codedInputStream.readFloat();
                                    continue;
                                case 117:
                                    this.hdop_ = codedInputStream.readFloat();
                                    continue;
                                case 125:
                                    this.vdop_ = codedInputStream.readFloat();
                                    continue;
                                case 133:
                                    this.pdop_ = codedInputStream.readFloat();
                                    continue;
                                case 136:
                                    this.datetime_ = codedInputStream.readUInt64();
                                    continue;
                                case 144:
                                    this.fusiontype_ = codedInputStream.readInt32();
                                    continue;
                                case 154:
                                    Primitives.Vector3D.Builder builder2 = this.localPose_ != null ? this.localPose_.toBuilder() : null;
                                    this.localPose_ = (Primitives.Vector3D) codedInputStream.readMessage(Primitives.Vector3D.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom(this.localPose_);
                                        this.localPose_ = builder2.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 162:
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
                                case Opcodes.IF_ACMPEQ /* 165 */:
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    if (((z2 ? 1 : 0) & r3) == r3) {
                        this.spare_ = Collections.unmodifiableList(this.spare_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Posrtkimu.internal_static_xpilot_sr_proto_PosRTKImuResultExternal_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Posrtkimu.internal_static_xpilot_sr_proto_PosRTKImuResultExternal_fieldAccessorTable.ensureFieldAccessorsInitialized(PosRTKImuResultExternal.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public long getTicktime() {
            return this.ticktime_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public int getNs() {
            return this.ns_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public int getEw() {
            return this.ew_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public Primitives.GlobalPoseInfo getPos() {
            Primitives.GlobalPoseInfo globalPoseInfo = this.pos_;
            return globalPoseInfo == null ? Primitives.GlobalPoseInfo.getDefaultInstance() : globalPoseInfo;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public Primitives.GlobalPoseInfoOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getSpeed() {
            return this.speed_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getCourse() {
            return this.course_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getAlt() {
            return this.alt_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getPosacc() {
            return this.posacc_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getCourseacc() {
            return this.courseacc_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getAltacc() {
            return this.altacc_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getSpeedacc() {
            return this.speedacc_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getSatnum() {
            return this.satnum_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getHdop() {
            return this.hdop_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getVdop() {
            return this.vdop_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public float getPdop() {
            return this.pdop_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public long getDatetime() {
            return this.datetime_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public int getFusiontype() {
            return this.fusiontype_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public boolean hasLocalPose() {
            return this.localPose_ != null;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public Primitives.Vector3D getLocalPose() {
            Primitives.Vector3D vector3D = this.localPose_;
            return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public Primitives.Vector3DOrBuilder getLocalPoseOrBuilder() {
            return getLocalPose();
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
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
            long j = this.ticktime_;
            if (j != 0) {
                codedOutputStream.writeUInt64(1, j);
            }
            int i = this.status_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            int i2 = this.ns_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
            int i3 = this.ew_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(4, i3);
            }
            if (this.pos_ != null) {
                codedOutputStream.writeMessage(5, getPos());
            }
            float f = this.speed_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(6, f);
            }
            float f2 = this.course_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(7, f2);
            }
            float f3 = this.alt_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(8, f3);
            }
            float f4 = this.posacc_;
            if (f4 != 0.0f) {
                codedOutputStream.writeFloat(9, f4);
            }
            float f5 = this.courseacc_;
            if (f5 != 0.0f) {
                codedOutputStream.writeFloat(10, f5);
            }
            float f6 = this.altacc_;
            if (f6 != 0.0f) {
                codedOutputStream.writeFloat(11, f6);
            }
            float f7 = this.speedacc_;
            if (f7 != 0.0f) {
                codedOutputStream.writeFloat(12, f7);
            }
            float f8 = this.satnum_;
            if (f8 != 0.0f) {
                codedOutputStream.writeFloat(13, f8);
            }
            float f9 = this.hdop_;
            if (f9 != 0.0f) {
                codedOutputStream.writeFloat(14, f9);
            }
            float f10 = this.vdop_;
            if (f10 != 0.0f) {
                codedOutputStream.writeFloat(15, f10);
            }
            float f11 = this.pdop_;
            if (f11 != 0.0f) {
                codedOutputStream.writeFloat(16, f11);
            }
            long j2 = this.datetime_;
            if (j2 != 0) {
                codedOutputStream.writeUInt64(17, j2);
            }
            int i4 = this.fusiontype_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(18, i4);
            }
            if (this.localPose_ != null) {
                codedOutputStream.writeMessage(19, getLocalPose());
            }
            if (getSpareList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(162);
                codedOutputStream.writeUInt32NoTag(this.spareMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.spare_.size(); i5++) {
                codedOutputStream.writeFloatNoTag(this.spare_.get(i5).floatValue());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.ticktime_;
            int computeUInt64Size = j != 0 ? 0 + CodedOutputStream.computeUInt64Size(1, j) : 0;
            int i2 = this.status_;
            if (i2 != 0) {
                computeUInt64Size += CodedOutputStream.computeInt32Size(2, i2);
            }
            int i3 = this.ns_;
            if (i3 != 0) {
                computeUInt64Size += CodedOutputStream.computeInt32Size(3, i3);
            }
            int i4 = this.ew_;
            if (i4 != 0) {
                computeUInt64Size += CodedOutputStream.computeInt32Size(4, i4);
            }
            if (this.pos_ != null) {
                computeUInt64Size += CodedOutputStream.computeMessageSize(5, getPos());
            }
            float f = this.speed_;
            if (f != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(6, f);
            }
            float f2 = this.course_;
            if (f2 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(7, f2);
            }
            float f3 = this.alt_;
            if (f3 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(8, f3);
            }
            float f4 = this.posacc_;
            if (f4 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(9, f4);
            }
            float f5 = this.courseacc_;
            if (f5 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(10, f5);
            }
            float f6 = this.altacc_;
            if (f6 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(11, f6);
            }
            float f7 = this.speedacc_;
            if (f7 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(12, f7);
            }
            float f8 = this.satnum_;
            if (f8 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(13, f8);
            }
            float f9 = this.hdop_;
            if (f9 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(14, f9);
            }
            float f10 = this.vdop_;
            if (f10 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(15, f10);
            }
            float f11 = this.pdop_;
            if (f11 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(16, f11);
            }
            long j2 = this.datetime_;
            if (j2 != 0) {
                computeUInt64Size += CodedOutputStream.computeUInt64Size(17, j2);
            }
            int i5 = this.fusiontype_;
            if (i5 != 0) {
                computeUInt64Size += CodedOutputStream.computeInt32Size(18, i5);
            }
            if (this.localPose_ != null) {
                computeUInt64Size += CodedOutputStream.computeMessageSize(19, getLocalPose());
            }
            int size = getSpareList().size() * 4;
            int i6 = computeUInt64Size + size;
            if (!getSpareList().isEmpty()) {
                i6 = i6 + 2 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.spareMemoizedSerializedSize = size;
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PosRTKImuResultExternal)) {
                return super.equals(obj);
            }
            PosRTKImuResultExternal posRTKImuResultExternal = (PosRTKImuResultExternal) obj;
            boolean z = (((((getTicktime() > posRTKImuResultExternal.getTicktime() ? 1 : (getTicktime() == posRTKImuResultExternal.getTicktime() ? 0 : -1)) == 0) && getStatus() == posRTKImuResultExternal.getStatus()) && getNs() == posRTKImuResultExternal.getNs()) && getEw() == posRTKImuResultExternal.getEw()) && hasPos() == posRTKImuResultExternal.hasPos();
            if (hasPos()) {
                z = z && getPos().equals(posRTKImuResultExternal.getPos());
            }
            boolean z2 = (((((((((((((z && Float.floatToIntBits(getSpeed()) == Float.floatToIntBits(posRTKImuResultExternal.getSpeed())) && Float.floatToIntBits(getCourse()) == Float.floatToIntBits(posRTKImuResultExternal.getCourse())) && Float.floatToIntBits(getAlt()) == Float.floatToIntBits(posRTKImuResultExternal.getAlt())) && Float.floatToIntBits(getPosacc()) == Float.floatToIntBits(posRTKImuResultExternal.getPosacc())) && Float.floatToIntBits(getCourseacc()) == Float.floatToIntBits(posRTKImuResultExternal.getCourseacc())) && Float.floatToIntBits(getAltacc()) == Float.floatToIntBits(posRTKImuResultExternal.getAltacc())) && Float.floatToIntBits(getSpeedacc()) == Float.floatToIntBits(posRTKImuResultExternal.getSpeedacc())) && Float.floatToIntBits(getSatnum()) == Float.floatToIntBits(posRTKImuResultExternal.getSatnum())) && Float.floatToIntBits(getHdop()) == Float.floatToIntBits(posRTKImuResultExternal.getHdop())) && Float.floatToIntBits(getVdop()) == Float.floatToIntBits(posRTKImuResultExternal.getVdop())) && Float.floatToIntBits(getPdop()) == Float.floatToIntBits(posRTKImuResultExternal.getPdop())) && (getDatetime() > posRTKImuResultExternal.getDatetime() ? 1 : (getDatetime() == posRTKImuResultExternal.getDatetime() ? 0 : -1)) == 0) && getFusiontype() == posRTKImuResultExternal.getFusiontype()) && hasLocalPose() == posRTKImuResultExternal.hasLocalPose();
            if (hasLocalPose()) {
                z2 = z2 && getLocalPose().equals(posRTKImuResultExternal.getLocalPose());
            }
            return (z2 && getSpareList().equals(posRTKImuResultExternal.getSpareList())) && this.unknownFields.equals(posRTKImuResultExternal.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getTicktime())) * 37) + 2) * 53) + getStatus()) * 37) + 3) * 53) + getNs()) * 37) + 4) * 53) + getEw();
            if (hasPos()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getPos().hashCode();
            }
            int floatToIntBits = (((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 37) + 6) * 53) + Float.floatToIntBits(getSpeed())) * 37) + 7) * 53) + Float.floatToIntBits(getCourse())) * 37) + 8) * 53) + Float.floatToIntBits(getAlt())) * 37) + 9) * 53) + Float.floatToIntBits(getPosacc())) * 37) + 10) * 53) + Float.floatToIntBits(getCourseacc())) * 37) + 11) * 53) + Float.floatToIntBits(getAltacc())) * 37) + 12) * 53) + Float.floatToIntBits(getSpeedacc())) * 37) + 13) * 53) + Float.floatToIntBits(getSatnum())) * 37) + 14) * 53) + Float.floatToIntBits(getHdop())) * 37) + 15) * 53) + Float.floatToIntBits(getVdop())) * 37) + 16) * 53) + Float.floatToIntBits(getPdop())) * 37) + 17) * 53) + Internal.hashLong(getDatetime())) * 37) + 18) * 53) + getFusiontype();
            if (hasLocalPose()) {
                floatToIntBits = (((floatToIntBits * 37) + 19) * 53) + getLocalPose().hashCode();
            }
            if (getSpareCount() > 0) {
                floatToIntBits = (((floatToIntBits * 37) + 20) * 53) + getSpareList().hashCode();
            }
            int hashCode2 = (floatToIntBits * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static PosRTKImuResultExternal parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static PosRTKImuResultExternal parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PosRTKImuResultExternal parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PosRTKImuResultExternal parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PosRTKImuResultExternal parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PosRTKImuResultExternal parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PosRTKImuResultExternal parseFrom(InputStream inputStream) throws IOException {
            return (PosRTKImuResultExternal) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PosRTKImuResultExternal parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PosRTKImuResultExternal) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PosRTKImuResultExternal parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PosRTKImuResultExternal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PosRTKImuResultExternal parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PosRTKImuResultExternal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PosRTKImuResultExternal parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PosRTKImuResultExternal) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PosRTKImuResultExternal parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PosRTKImuResultExternal) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PosRTKImuResultExternal posRTKImuResultExternal) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(posRTKImuResultExternal);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PosRTKImuResultExternalOrBuilder {
            private float alt_;
            private float altacc_;
            private int bitField0_;
            private float course_;
            private float courseacc_;
            private long datetime_;
            private int ew_;
            private int fusiontype_;
            private float hdop_;
            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> localPoseBuilder_;
            private Primitives.Vector3D localPose_;
            private int ns_;
            private float pdop_;
            private SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> posBuilder_;
            private Primitives.GlobalPoseInfo pos_;
            private float posacc_;
            private float satnum_;
            private List<Float> spare_;
            private float speed_;
            private float speedacc_;
            private int status_;
            private long ticktime_;
            private float vdop_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Posrtkimu.internal_static_xpilot_sr_proto_PosRTKImuResultExternal_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Posrtkimu.internal_static_xpilot_sr_proto_PosRTKImuResultExternal_fieldAccessorTable.ensureFieldAccessorsInitialized(PosRTKImuResultExternal.class, Builder.class);
            }

            private Builder() {
                this.pos_ = null;
                this.localPose_ = null;
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.pos_ = null;
                this.localPose_ = null;
                this.spare_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = PosRTKImuResultExternal.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.ticktime_ = 0L;
                this.status_ = 0;
                this.ns_ = 0;
                this.ew_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.speed_ = 0.0f;
                this.course_ = 0.0f;
                this.alt_ = 0.0f;
                this.posacc_ = 0.0f;
                this.courseacc_ = 0.0f;
                this.altacc_ = 0.0f;
                this.speedacc_ = 0.0f;
                this.satnum_ = 0.0f;
                this.hdop_ = 0.0f;
                this.vdop_ = 0.0f;
                this.pdop_ = 0.0f;
                this.datetime_ = 0L;
                this.fusiontype_ = 0;
                if (this.localPoseBuilder_ == null) {
                    this.localPose_ = null;
                } else {
                    this.localPose_ = null;
                    this.localPoseBuilder_ = null;
                }
                this.spare_ = Collections.emptyList();
                this.bitField0_ &= -524289;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Posrtkimu.internal_static_xpilot_sr_proto_PosRTKImuResultExternal_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PosRTKImuResultExternal getDefaultInstanceForType() {
                return PosRTKImuResultExternal.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PosRTKImuResultExternal build() {
                PosRTKImuResultExternal buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PosRTKImuResultExternal buildPartial() {
                PosRTKImuResultExternal posRTKImuResultExternal = new PosRTKImuResultExternal(this);
                int i = this.bitField0_;
                posRTKImuResultExternal.ticktime_ = this.ticktime_;
                posRTKImuResultExternal.status_ = this.status_;
                posRTKImuResultExternal.ns_ = this.ns_;
                posRTKImuResultExternal.ew_ = this.ew_;
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.posBuilder_;
                if (singleFieldBuilderV3 == null) {
                    posRTKImuResultExternal.pos_ = this.pos_;
                } else {
                    posRTKImuResultExternal.pos_ = singleFieldBuilderV3.build();
                }
                posRTKImuResultExternal.speed_ = this.speed_;
                posRTKImuResultExternal.course_ = this.course_;
                posRTKImuResultExternal.alt_ = this.alt_;
                posRTKImuResultExternal.posacc_ = this.posacc_;
                posRTKImuResultExternal.courseacc_ = this.courseacc_;
                posRTKImuResultExternal.altacc_ = this.altacc_;
                posRTKImuResultExternal.speedacc_ = this.speedacc_;
                posRTKImuResultExternal.satnum_ = this.satnum_;
                posRTKImuResultExternal.hdop_ = this.hdop_;
                posRTKImuResultExternal.vdop_ = this.vdop_;
                posRTKImuResultExternal.pdop_ = this.pdop_;
                posRTKImuResultExternal.datetime_ = this.datetime_;
                posRTKImuResultExternal.fusiontype_ = this.fusiontype_;
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV32 = this.localPoseBuilder_;
                if (singleFieldBuilderV32 == null) {
                    posRTKImuResultExternal.localPose_ = this.localPose_;
                } else {
                    posRTKImuResultExternal.localPose_ = singleFieldBuilderV32.build();
                }
                if ((this.bitField0_ & 524288) == 524288) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField0_ &= -524289;
                }
                posRTKImuResultExternal.spare_ = this.spare_;
                posRTKImuResultExternal.bitField0_ = 0;
                onBuilt();
                return posRTKImuResultExternal;
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
                if (message instanceof PosRTKImuResultExternal) {
                    return mergeFrom((PosRTKImuResultExternal) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(PosRTKImuResultExternal posRTKImuResultExternal) {
                if (posRTKImuResultExternal == PosRTKImuResultExternal.getDefaultInstance()) {
                    return this;
                }
                if (posRTKImuResultExternal.getTicktime() != 0) {
                    setTicktime(posRTKImuResultExternal.getTicktime());
                }
                if (posRTKImuResultExternal.getStatus() != 0) {
                    setStatus(posRTKImuResultExternal.getStatus());
                }
                if (posRTKImuResultExternal.getNs() != 0) {
                    setNs(posRTKImuResultExternal.getNs());
                }
                if (posRTKImuResultExternal.getEw() != 0) {
                    setEw(posRTKImuResultExternal.getEw());
                }
                if (posRTKImuResultExternal.hasPos()) {
                    mergePos(posRTKImuResultExternal.getPos());
                }
                if (posRTKImuResultExternal.getSpeed() != 0.0f) {
                    setSpeed(posRTKImuResultExternal.getSpeed());
                }
                if (posRTKImuResultExternal.getCourse() != 0.0f) {
                    setCourse(posRTKImuResultExternal.getCourse());
                }
                if (posRTKImuResultExternal.getAlt() != 0.0f) {
                    setAlt(posRTKImuResultExternal.getAlt());
                }
                if (posRTKImuResultExternal.getPosacc() != 0.0f) {
                    setPosacc(posRTKImuResultExternal.getPosacc());
                }
                if (posRTKImuResultExternal.getCourseacc() != 0.0f) {
                    setCourseacc(posRTKImuResultExternal.getCourseacc());
                }
                if (posRTKImuResultExternal.getAltacc() != 0.0f) {
                    setAltacc(posRTKImuResultExternal.getAltacc());
                }
                if (posRTKImuResultExternal.getSpeedacc() != 0.0f) {
                    setSpeedacc(posRTKImuResultExternal.getSpeedacc());
                }
                if (posRTKImuResultExternal.getSatnum() != 0.0f) {
                    setSatnum(posRTKImuResultExternal.getSatnum());
                }
                if (posRTKImuResultExternal.getHdop() != 0.0f) {
                    setHdop(posRTKImuResultExternal.getHdop());
                }
                if (posRTKImuResultExternal.getVdop() != 0.0f) {
                    setVdop(posRTKImuResultExternal.getVdop());
                }
                if (posRTKImuResultExternal.getPdop() != 0.0f) {
                    setPdop(posRTKImuResultExternal.getPdop());
                }
                if (posRTKImuResultExternal.getDatetime() != 0) {
                    setDatetime(posRTKImuResultExternal.getDatetime());
                }
                if (posRTKImuResultExternal.getFusiontype() != 0) {
                    setFusiontype(posRTKImuResultExternal.getFusiontype());
                }
                if (posRTKImuResultExternal.hasLocalPose()) {
                    mergeLocalPose(posRTKImuResultExternal.getLocalPose());
                }
                if (!posRTKImuResultExternal.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = posRTKImuResultExternal.spare_;
                        this.bitField0_ &= -524289;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(posRTKImuResultExternal.spare_);
                    }
                    onChanged();
                }
                mergeUnknownFields(posRTKImuResultExternal.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternal.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternal.access$3900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Posrtkimu$PosRTKImuResultExternal r3 = (xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternal) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Posrtkimu$PosRTKImuResultExternal r4 = (xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternal) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternal.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Posrtkimu$PosRTKImuResultExternal$Builder");
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public long getTicktime() {
                return this.ticktime_;
            }

            public Builder setTicktime(long j) {
                this.ticktime_ = j;
                onChanged();
                return this;
            }

            public Builder clearTicktime() {
                this.ticktime_ = 0L;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public int getStatus() {
                return this.status_;
            }

            public Builder setStatus(int i) {
                this.status_ = i;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public int getNs() {
                return this.ns_;
            }

            public Builder setNs(int i) {
                this.ns_ = i;
                onChanged();
                return this;
            }

            public Builder clearNs() {
                this.ns_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public int getEw() {
                return this.ew_;
            }

            public Builder setEw(int i) {
                this.ew_ = i;
                onChanged();
                return this;
            }

            public Builder clearEw() {
                this.ew_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public Primitives.GlobalPoseInfo getPos() {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.posBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.GlobalPoseInfo globalPoseInfo = this.pos_;
                    return globalPoseInfo == null ? Primitives.GlobalPoseInfo.getDefaultInstance() : globalPoseInfo;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setPos(Primitives.GlobalPoseInfo globalPoseInfo) {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.posBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(globalPoseInfo);
                } else if (globalPoseInfo == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = globalPoseInfo;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(Primitives.GlobalPoseInfo.Builder builder) {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.posBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.pos_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergePos(Primitives.GlobalPoseInfo globalPoseInfo) {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.posBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.GlobalPoseInfo globalPoseInfo2 = this.pos_;
                    if (globalPoseInfo2 != null) {
                        this.pos_ = Primitives.GlobalPoseInfo.newBuilder(globalPoseInfo2).mergeFrom(globalPoseInfo).buildPartial();
                    } else {
                        this.pos_ = globalPoseInfo;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(globalPoseInfo);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public Primitives.GlobalPoseInfo.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public Primitives.GlobalPoseInfoOrBuilder getPosOrBuilder() {
                SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> singleFieldBuilderV3 = this.posBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.GlobalPoseInfo globalPoseInfo = this.pos_;
                return globalPoseInfo == null ? Primitives.GlobalPoseInfo.getDefaultInstance() : globalPoseInfo;
            }

            private SingleFieldBuilderV3<Primitives.GlobalPoseInfo, Primitives.GlobalPoseInfo.Builder, Primitives.GlobalPoseInfoOrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getSpeed() {
                return this.speed_;
            }

            public Builder setSpeed(float f) {
                this.speed_ = f;
                onChanged();
                return this;
            }

            public Builder clearSpeed() {
                this.speed_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getCourse() {
                return this.course_;
            }

            public Builder setCourse(float f) {
                this.course_ = f;
                onChanged();
                return this;
            }

            public Builder clearCourse() {
                this.course_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getAlt() {
                return this.alt_;
            }

            public Builder setAlt(float f) {
                this.alt_ = f;
                onChanged();
                return this;
            }

            public Builder clearAlt() {
                this.alt_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getPosacc() {
                return this.posacc_;
            }

            public Builder setPosacc(float f) {
                this.posacc_ = f;
                onChanged();
                return this;
            }

            public Builder clearPosacc() {
                this.posacc_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getCourseacc() {
                return this.courseacc_;
            }

            public Builder setCourseacc(float f) {
                this.courseacc_ = f;
                onChanged();
                return this;
            }

            public Builder clearCourseacc() {
                this.courseacc_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getAltacc() {
                return this.altacc_;
            }

            public Builder setAltacc(float f) {
                this.altacc_ = f;
                onChanged();
                return this;
            }

            public Builder clearAltacc() {
                this.altacc_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getSpeedacc() {
                return this.speedacc_;
            }

            public Builder setSpeedacc(float f) {
                this.speedacc_ = f;
                onChanged();
                return this;
            }

            public Builder clearSpeedacc() {
                this.speedacc_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getSatnum() {
                return this.satnum_;
            }

            public Builder setSatnum(float f) {
                this.satnum_ = f;
                onChanged();
                return this;
            }

            public Builder clearSatnum() {
                this.satnum_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getHdop() {
                return this.hdop_;
            }

            public Builder setHdop(float f) {
                this.hdop_ = f;
                onChanged();
                return this;
            }

            public Builder clearHdop() {
                this.hdop_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getVdop() {
                return this.vdop_;
            }

            public Builder setVdop(float f) {
                this.vdop_ = f;
                onChanged();
                return this;
            }

            public Builder clearVdop() {
                this.vdop_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public float getPdop() {
                return this.pdop_;
            }

            public Builder setPdop(float f) {
                this.pdop_ = f;
                onChanged();
                return this;
            }

            public Builder clearPdop() {
                this.pdop_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public long getDatetime() {
                return this.datetime_;
            }

            public Builder setDatetime(long j) {
                this.datetime_ = j;
                onChanged();
                return this;
            }

            public Builder clearDatetime() {
                this.datetime_ = 0L;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public int getFusiontype() {
                return this.fusiontype_;
            }

            public Builder setFusiontype(int i) {
                this.fusiontype_ = i;
                onChanged();
                return this;
            }

            public Builder clearFusiontype() {
                this.fusiontype_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public boolean hasLocalPose() {
                return (this.localPoseBuilder_ == null && this.localPose_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public Primitives.Vector3D getLocalPose() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D = this.localPose_;
                    return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setLocalPose(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    this.localPose_ = vector3D;
                    onChanged();
                }
                return this;
            }

            public Builder setLocalPose(Primitives.Vector3D.Builder builder) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.localPose_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeLocalPose(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D2 = this.localPose_;
                    if (vector3D2 != null) {
                        this.localPose_ = Primitives.Vector3D.newBuilder(vector3D2).mergeFrom(vector3D).buildPartial();
                    } else {
                        this.localPose_ = vector3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(vector3D);
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

            public Primitives.Vector3D.Builder getLocalPoseBuilder() {
                onChanged();
                return getLocalPoseFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public Primitives.Vector3DOrBuilder getLocalPoseOrBuilder() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.localPoseBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Vector3D vector3D = this.localPose_;
                return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
            }

            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> getLocalPoseFieldBuilder() {
                if (this.localPoseBuilder_ == null) {
                    this.localPoseBuilder_ = new SingleFieldBuilderV3<>(getLocalPose(), getParentForChildren(), isClean());
                    this.localPose_ = null;
                }
                return this.localPoseBuilder_;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField0_ & 524288) != 524288) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField0_ |= 524288;
                }
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosRTKImuResultExternalOrBuilder
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
                this.bitField0_ &= -524289;
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

        public static PosRTKImuResultExternal getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PosRTKImuResultExternal> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PosRTKImuResultExternal> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PosRTKImuResultExternal getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class PosFusionResultExternal extends GeneratedMessageV3 implements PosFusionResultExternalOrBuilder {
        public static final int ALTACC_FIELD_NUMBER = 12;
        public static final int ALT_FIELD_NUMBER = 9;
        public static final int COURSEACC_FIELD_NUMBER = 11;
        public static final int COURSE_FIELD_NUMBER = 8;
        public static final int DATETIME_FIELD_NUMBER = 14;
        public static final int EW_FIELD_NUMBER = 4;
        public static final int FUSIONTYPE_FIELD_NUMBER = 15;
        public static final int NS_FIELD_NUMBER = 3;
        public static final int POSACC_FIELD_NUMBER = 10;
        public static final int POSENU_FIELD_NUMBER = 5;
        public static final int REFPOSECEFQ_FIELD_NUMBER = 19;
        public static final int REFPOSECEF_FIELD_NUMBER = 6;
        public static final int SPARE_FIELD_NUMBER = 16;
        public static final int SPEEDACC_FIELD_NUMBER = 13;
        public static final int SPEED_FIELD_NUMBER = 7;
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TICKTIME_FIELD_NUMBER = 1;
        public static final int WORLDECEFP_FIELD_NUMBER = 17;
        public static final int WORLDECEFQ_FIELD_NUMBER = 18;
        private static final long serialVersionUID = 0;
        private float altAcc_;
        private float alt_;
        private int bitField0_;
        private float courseAcc_;
        private float course_;
        private long datetime_;
        private int ew_;
        private int fusiontype_;
        private byte memoizedIsInitialized;
        private int ns_;
        private float posAcc_;
        private Primitives.Vector3D posEnu_;
        private Primitives.Vector3D refPosEcef_;
        private Primitives.Quaternion refPosEcefq_;
        private int spareMemoizedSerializedSize;
        private List<Float> spare_;
        private float speedAcc_;
        private float speed_;
        private int status_;
        private long ticktime_;
        private Primitives.Vector3D worldecefp_;
        private Primitives.Quaternion worldecefq_;
        private static final PosFusionResultExternal DEFAULT_INSTANCE = new PosFusionResultExternal();
        private static final Parser<PosFusionResultExternal> PARSER = new AbstractParser<PosFusionResultExternal>() { // from class: xpilot.sr.proto.Posrtkimu.PosFusionResultExternal.1
            @Override // com.google.protobuf.Parser
            public PosFusionResultExternal parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PosFusionResultExternal(codedInputStream, extensionRegistryLite);
            }
        };

        private PosFusionResultExternal(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private PosFusionResultExternal() {
            this.spareMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.ticktime_ = 0L;
            this.status_ = 0;
            this.ns_ = 0;
            this.ew_ = 0;
            this.speed_ = 0.0f;
            this.course_ = 0.0f;
            this.alt_ = 0.0f;
            this.posAcc_ = 0.0f;
            this.courseAcc_ = 0.0f;
            this.altAcc_ = 0.0f;
            this.speedAcc_ = 0.0f;
            this.datetime_ = 0L;
            this.fusiontype_ = 0;
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
        private PosFusionResultExternal(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r3 = 32768;
                if (z) {
                    return;
                }
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.ticktime_ = codedInputStream.readUInt64();
                                    continue;
                                case 16:
                                    this.status_ = codedInputStream.readInt32();
                                    continue;
                                case 24:
                                    this.ns_ = codedInputStream.readInt32();
                                    continue;
                                case 32:
                                    this.ew_ = codedInputStream.readInt32();
                                    continue;
                                case 42:
                                    Primitives.Vector3D.Builder builder = this.posEnu_ != null ? this.posEnu_.toBuilder() : null;
                                    this.posEnu_ = (Primitives.Vector3D) codedInputStream.readMessage(Primitives.Vector3D.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.posEnu_);
                                        this.posEnu_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 50:
                                    Primitives.Vector3D.Builder builder2 = this.refPosEcef_ != null ? this.refPosEcef_.toBuilder() : null;
                                    this.refPosEcef_ = (Primitives.Vector3D) codedInputStream.readMessage(Primitives.Vector3D.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom(this.refPosEcef_);
                                        this.refPosEcef_ = builder2.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 61:
                                    this.speed_ = codedInputStream.readFloat();
                                    continue;
                                case 69:
                                    this.course_ = codedInputStream.readFloat();
                                    continue;
                                case 77:
                                    this.alt_ = codedInputStream.readFloat();
                                    continue;
                                case 85:
                                    this.posAcc_ = codedInputStream.readFloat();
                                    continue;
                                case 93:
                                    this.courseAcc_ = codedInputStream.readFloat();
                                    continue;
                                case 101:
                                    this.altAcc_ = codedInputStream.readFloat();
                                    continue;
                                case 109:
                                    this.speedAcc_ = codedInputStream.readFloat();
                                    continue;
                                case 112:
                                    this.datetime_ = codedInputStream.readUInt64();
                                    continue;
                                case 120:
                                    this.fusiontype_ = codedInputStream.readInt32();
                                    continue;
                                case 130:
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
                                case 133:
                                    boolean z4 = (z2 ? 1 : 0) & true;
                                    z2 = z2;
                                    if (!z4) {
                                        this.spare_ = new ArrayList();
                                        z2 = (z2 ? 1 : 0) | true;
                                    }
                                    this.spare_.add(Float.valueOf(codedInputStream.readFloat()));
                                    continue;
                                case 138:
                                    Primitives.Vector3D.Builder builder3 = this.worldecefp_ != null ? this.worldecefp_.toBuilder() : null;
                                    this.worldecefp_ = (Primitives.Vector3D) codedInputStream.readMessage(Primitives.Vector3D.parser(), extensionRegistryLite);
                                    if (builder3 != null) {
                                        builder3.mergeFrom(this.worldecefp_);
                                        this.worldecefp_ = builder3.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 146:
                                    Primitives.Quaternion.Builder builder4 = this.worldecefq_ != null ? this.worldecefq_.toBuilder() : null;
                                    this.worldecefq_ = (Primitives.Quaternion) codedInputStream.readMessage(Primitives.Quaternion.parser(), extensionRegistryLite);
                                    if (builder4 != null) {
                                        builder4.mergeFrom(this.worldecefq_);
                                        this.worldecefq_ = builder4.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 154:
                                    Primitives.Quaternion.Builder builder5 = this.refPosEcefq_ != null ? this.refPosEcefq_.toBuilder() : null;
                                    this.refPosEcefq_ = (Primitives.Quaternion) codedInputStream.readMessage(Primitives.Quaternion.parser(), extensionRegistryLite);
                                    if (builder5 != null) {
                                        builder5.mergeFrom(this.refPosEcefq_);
                                        this.refPosEcefq_ = builder5.buildPartial();
                                    } else {
                                        continue;
                                    }
                                default:
                                    r3 = parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag);
                                    if (r3 == 0) {
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
                    if (((z2 ? 1 : 0) & r3) == r3) {
                        this.spare_ = Collections.unmodifiableList(this.spare_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Posrtkimu.internal_static_xpilot_sr_proto_PosFusionResultExternal_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Posrtkimu.internal_static_xpilot_sr_proto_PosFusionResultExternal_fieldAccessorTable.ensureFieldAccessorsInitialized(PosFusionResultExternal.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public long getTicktime() {
            return this.ticktime_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public int getNs() {
            return this.ns_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public int getEw() {
            return this.ew_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public boolean hasPosEnu() {
            return this.posEnu_ != null;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.Vector3D getPosEnu() {
            Primitives.Vector3D vector3D = this.posEnu_;
            return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.Vector3DOrBuilder getPosEnuOrBuilder() {
            return getPosEnu();
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public boolean hasRefPosEcef() {
            return this.refPosEcef_ != null;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.Vector3D getRefPosEcef() {
            Primitives.Vector3D vector3D = this.refPosEcef_;
            return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.Vector3DOrBuilder getRefPosEcefOrBuilder() {
            return getRefPosEcef();
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public float getSpeed() {
            return this.speed_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public float getCourse() {
            return this.course_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public float getAlt() {
            return this.alt_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public float getPosAcc() {
            return this.posAcc_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public float getCourseAcc() {
            return this.courseAcc_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public float getAltAcc() {
            return this.altAcc_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public float getSpeedAcc() {
            return this.speedAcc_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public long getDatetime() {
            return this.datetime_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public int getFusiontype() {
            return this.fusiontype_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public List<Float> getSpareList() {
            return this.spare_;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public int getSpareCount() {
            return this.spare_.size();
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public float getSpare(int i) {
            return this.spare_.get(i).floatValue();
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public boolean hasWorldecefp() {
            return this.worldecefp_ != null;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.Vector3D getWorldecefp() {
            Primitives.Vector3D vector3D = this.worldecefp_;
            return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.Vector3DOrBuilder getWorldecefpOrBuilder() {
            return getWorldecefp();
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public boolean hasWorldecefq() {
            return this.worldecefq_ != null;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.Quaternion getWorldecefq() {
            Primitives.Quaternion quaternion = this.worldecefq_;
            return quaternion == null ? Primitives.Quaternion.getDefaultInstance() : quaternion;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.QuaternionOrBuilder getWorldecefqOrBuilder() {
            return getWorldecefq();
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public boolean hasRefPosEcefq() {
            return this.refPosEcefq_ != null;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.Quaternion getRefPosEcefq() {
            Primitives.Quaternion quaternion = this.refPosEcefq_;
            return quaternion == null ? Primitives.Quaternion.getDefaultInstance() : quaternion;
        }

        @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
        public Primitives.QuaternionOrBuilder getRefPosEcefqOrBuilder() {
            return getRefPosEcefq();
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
            long j = this.ticktime_;
            if (j != 0) {
                codedOutputStream.writeUInt64(1, j);
            }
            int i = this.status_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            int i2 = this.ns_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
            int i3 = this.ew_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(4, i3);
            }
            if (this.posEnu_ != null) {
                codedOutputStream.writeMessage(5, getPosEnu());
            }
            if (this.refPosEcef_ != null) {
                codedOutputStream.writeMessage(6, getRefPosEcef());
            }
            float f = this.speed_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(7, f);
            }
            float f2 = this.course_;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(8, f2);
            }
            float f3 = this.alt_;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(9, f3);
            }
            float f4 = this.posAcc_;
            if (f4 != 0.0f) {
                codedOutputStream.writeFloat(10, f4);
            }
            float f5 = this.courseAcc_;
            if (f5 != 0.0f) {
                codedOutputStream.writeFloat(11, f5);
            }
            float f6 = this.altAcc_;
            if (f6 != 0.0f) {
                codedOutputStream.writeFloat(12, f6);
            }
            float f7 = this.speedAcc_;
            if (f7 != 0.0f) {
                codedOutputStream.writeFloat(13, f7);
            }
            long j2 = this.datetime_;
            if (j2 != 0) {
                codedOutputStream.writeUInt64(14, j2);
            }
            int i4 = this.fusiontype_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(15, i4);
            }
            if (getSpareList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(130);
                codedOutputStream.writeUInt32NoTag(this.spareMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.spare_.size(); i5++) {
                codedOutputStream.writeFloatNoTag(this.spare_.get(i5).floatValue());
            }
            if (this.worldecefp_ != null) {
                codedOutputStream.writeMessage(17, getWorldecefp());
            }
            if (this.worldecefq_ != null) {
                codedOutputStream.writeMessage(18, getWorldecefq());
            }
            if (this.refPosEcefq_ != null) {
                codedOutputStream.writeMessage(19, getRefPosEcefq());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.ticktime_;
            int computeUInt64Size = j != 0 ? 0 + CodedOutputStream.computeUInt64Size(1, j) : 0;
            int i2 = this.status_;
            if (i2 != 0) {
                computeUInt64Size += CodedOutputStream.computeInt32Size(2, i2);
            }
            int i3 = this.ns_;
            if (i3 != 0) {
                computeUInt64Size += CodedOutputStream.computeInt32Size(3, i3);
            }
            int i4 = this.ew_;
            if (i4 != 0) {
                computeUInt64Size += CodedOutputStream.computeInt32Size(4, i4);
            }
            if (this.posEnu_ != null) {
                computeUInt64Size += CodedOutputStream.computeMessageSize(5, getPosEnu());
            }
            if (this.refPosEcef_ != null) {
                computeUInt64Size += CodedOutputStream.computeMessageSize(6, getRefPosEcef());
            }
            float f = this.speed_;
            if (f != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(7, f);
            }
            float f2 = this.course_;
            if (f2 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(8, f2);
            }
            float f3 = this.alt_;
            if (f3 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(9, f3);
            }
            float f4 = this.posAcc_;
            if (f4 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(10, f4);
            }
            float f5 = this.courseAcc_;
            if (f5 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(11, f5);
            }
            float f6 = this.altAcc_;
            if (f6 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(12, f6);
            }
            float f7 = this.speedAcc_;
            if (f7 != 0.0f) {
                computeUInt64Size += CodedOutputStream.computeFloatSize(13, f7);
            }
            long j2 = this.datetime_;
            if (j2 != 0) {
                computeUInt64Size += CodedOutputStream.computeUInt64Size(14, j2);
            }
            int i5 = this.fusiontype_;
            if (i5 != 0) {
                computeUInt64Size += CodedOutputStream.computeInt32Size(15, i5);
            }
            int size = getSpareList().size() * 4;
            int i6 = computeUInt64Size + size;
            if (!getSpareList().isEmpty()) {
                i6 = i6 + 2 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.spareMemoizedSerializedSize = size;
            if (this.worldecefp_ != null) {
                i6 += CodedOutputStream.computeMessageSize(17, getWorldecefp());
            }
            if (this.worldecefq_ != null) {
                i6 += CodedOutputStream.computeMessageSize(18, getWorldecefq());
            }
            if (this.refPosEcefq_ != null) {
                i6 += CodedOutputStream.computeMessageSize(19, getRefPosEcefq());
            }
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PosFusionResultExternal)) {
                return super.equals(obj);
            }
            PosFusionResultExternal posFusionResultExternal = (PosFusionResultExternal) obj;
            boolean z = (((((getTicktime() > posFusionResultExternal.getTicktime() ? 1 : (getTicktime() == posFusionResultExternal.getTicktime() ? 0 : -1)) == 0) && getStatus() == posFusionResultExternal.getStatus()) && getNs() == posFusionResultExternal.getNs()) && getEw() == posFusionResultExternal.getEw()) && hasPosEnu() == posFusionResultExternal.hasPosEnu();
            if (hasPosEnu()) {
                z = z && getPosEnu().equals(posFusionResultExternal.getPosEnu());
            }
            boolean z2 = z && hasRefPosEcef() == posFusionResultExternal.hasRefPosEcef();
            if (hasRefPosEcef()) {
                z2 = z2 && getRefPosEcef().equals(posFusionResultExternal.getRefPosEcef());
            }
            boolean z3 = ((((((((((z2 && Float.floatToIntBits(getSpeed()) == Float.floatToIntBits(posFusionResultExternal.getSpeed())) && Float.floatToIntBits(getCourse()) == Float.floatToIntBits(posFusionResultExternal.getCourse())) && Float.floatToIntBits(getAlt()) == Float.floatToIntBits(posFusionResultExternal.getAlt())) && Float.floatToIntBits(getPosAcc()) == Float.floatToIntBits(posFusionResultExternal.getPosAcc())) && Float.floatToIntBits(getCourseAcc()) == Float.floatToIntBits(posFusionResultExternal.getCourseAcc())) && Float.floatToIntBits(getAltAcc()) == Float.floatToIntBits(posFusionResultExternal.getAltAcc())) && Float.floatToIntBits(getSpeedAcc()) == Float.floatToIntBits(posFusionResultExternal.getSpeedAcc())) && (getDatetime() > posFusionResultExternal.getDatetime() ? 1 : (getDatetime() == posFusionResultExternal.getDatetime() ? 0 : -1)) == 0) && getFusiontype() == posFusionResultExternal.getFusiontype()) && getSpareList().equals(posFusionResultExternal.getSpareList())) && hasWorldecefp() == posFusionResultExternal.hasWorldecefp();
            if (hasWorldecefp()) {
                z3 = z3 && getWorldecefp().equals(posFusionResultExternal.getWorldecefp());
            }
            boolean z4 = z3 && hasWorldecefq() == posFusionResultExternal.hasWorldecefq();
            if (hasWorldecefq()) {
                z4 = z4 && getWorldecefq().equals(posFusionResultExternal.getWorldecefq());
            }
            boolean z5 = z4 && hasRefPosEcefq() == posFusionResultExternal.hasRefPosEcefq();
            if (hasRefPosEcefq()) {
                z5 = z5 && getRefPosEcefq().equals(posFusionResultExternal.getRefPosEcefq());
            }
            return z5 && this.unknownFields.equals(posFusionResultExternal.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getTicktime())) * 37) + 2) * 53) + getStatus()) * 37) + 3) * 53) + getNs()) * 37) + 4) * 53) + getEw();
            if (hasPosEnu()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getPosEnu().hashCode();
            }
            if (hasRefPosEcef()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getRefPosEcef().hashCode();
            }
            int floatToIntBits = (((((((((((((((((((((((((((((((((((hashCode * 37) + 7) * 53) + Float.floatToIntBits(getSpeed())) * 37) + 8) * 53) + Float.floatToIntBits(getCourse())) * 37) + 9) * 53) + Float.floatToIntBits(getAlt())) * 37) + 10) * 53) + Float.floatToIntBits(getPosAcc())) * 37) + 11) * 53) + Float.floatToIntBits(getCourseAcc())) * 37) + 12) * 53) + Float.floatToIntBits(getAltAcc())) * 37) + 13) * 53) + Float.floatToIntBits(getSpeedAcc())) * 37) + 14) * 53) + Internal.hashLong(getDatetime())) * 37) + 15) * 53) + getFusiontype();
            if (getSpareCount() > 0) {
                floatToIntBits = (((floatToIntBits * 37) + 16) * 53) + getSpareList().hashCode();
            }
            if (hasWorldecefp()) {
                floatToIntBits = (((floatToIntBits * 37) + 17) * 53) + getWorldecefp().hashCode();
            }
            if (hasWorldecefq()) {
                floatToIntBits = (((floatToIntBits * 37) + 18) * 53) + getWorldecefq().hashCode();
            }
            if (hasRefPosEcefq()) {
                floatToIntBits = (((floatToIntBits * 37) + 19) * 53) + getRefPosEcefq().hashCode();
            }
            int hashCode2 = (floatToIntBits * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static PosFusionResultExternal parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static PosFusionResultExternal parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PosFusionResultExternal parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PosFusionResultExternal parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PosFusionResultExternal parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PosFusionResultExternal parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PosFusionResultExternal parseFrom(InputStream inputStream) throws IOException {
            return (PosFusionResultExternal) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PosFusionResultExternal parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PosFusionResultExternal) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PosFusionResultExternal parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PosFusionResultExternal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PosFusionResultExternal parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PosFusionResultExternal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PosFusionResultExternal parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PosFusionResultExternal) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PosFusionResultExternal parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PosFusionResultExternal) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PosFusionResultExternal posFusionResultExternal) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(posFusionResultExternal);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PosFusionResultExternalOrBuilder {
            private float altAcc_;
            private float alt_;
            private int bitField0_;
            private float courseAcc_;
            private float course_;
            private long datetime_;
            private int ew_;
            private int fusiontype_;
            private int ns_;
            private float posAcc_;
            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> posEnuBuilder_;
            private Primitives.Vector3D posEnu_;
            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> refPosEcefBuilder_;
            private Primitives.Vector3D refPosEcef_;
            private SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> refPosEcefqBuilder_;
            private Primitives.Quaternion refPosEcefq_;
            private List<Float> spare_;
            private float speedAcc_;
            private float speed_;
            private int status_;
            private long ticktime_;
            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> worldecefpBuilder_;
            private Primitives.Vector3D worldecefp_;
            private SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> worldecefqBuilder_;
            private Primitives.Quaternion worldecefq_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Posrtkimu.internal_static_xpilot_sr_proto_PosFusionResultExternal_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Posrtkimu.internal_static_xpilot_sr_proto_PosFusionResultExternal_fieldAccessorTable.ensureFieldAccessorsInitialized(PosFusionResultExternal.class, Builder.class);
            }

            private Builder() {
                this.posEnu_ = null;
                this.refPosEcef_ = null;
                this.spare_ = Collections.emptyList();
                this.worldecefp_ = null;
                this.worldecefq_ = null;
                this.refPosEcefq_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.posEnu_ = null;
                this.refPosEcef_ = null;
                this.spare_ = Collections.emptyList();
                this.worldecefp_ = null;
                this.worldecefq_ = null;
                this.refPosEcefq_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = PosFusionResultExternal.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.ticktime_ = 0L;
                this.status_ = 0;
                this.ns_ = 0;
                this.ew_ = 0;
                if (this.posEnuBuilder_ == null) {
                    this.posEnu_ = null;
                } else {
                    this.posEnu_ = null;
                    this.posEnuBuilder_ = null;
                }
                if (this.refPosEcefBuilder_ == null) {
                    this.refPosEcef_ = null;
                } else {
                    this.refPosEcef_ = null;
                    this.refPosEcefBuilder_ = null;
                }
                this.speed_ = 0.0f;
                this.course_ = 0.0f;
                this.alt_ = 0.0f;
                this.posAcc_ = 0.0f;
                this.courseAcc_ = 0.0f;
                this.altAcc_ = 0.0f;
                this.speedAcc_ = 0.0f;
                this.datetime_ = 0L;
                this.fusiontype_ = 0;
                this.spare_ = Collections.emptyList();
                this.bitField0_ &= -32769;
                if (this.worldecefpBuilder_ == null) {
                    this.worldecefp_ = null;
                } else {
                    this.worldecefp_ = null;
                    this.worldecefpBuilder_ = null;
                }
                if (this.worldecefqBuilder_ == null) {
                    this.worldecefq_ = null;
                } else {
                    this.worldecefq_ = null;
                    this.worldecefqBuilder_ = null;
                }
                if (this.refPosEcefqBuilder_ == null) {
                    this.refPosEcefq_ = null;
                } else {
                    this.refPosEcefq_ = null;
                    this.refPosEcefqBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Posrtkimu.internal_static_xpilot_sr_proto_PosFusionResultExternal_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PosFusionResultExternal getDefaultInstanceForType() {
                return PosFusionResultExternal.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PosFusionResultExternal build() {
                PosFusionResultExternal buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PosFusionResultExternal buildPartial() {
                PosFusionResultExternal posFusionResultExternal = new PosFusionResultExternal(this);
                int i = this.bitField0_;
                posFusionResultExternal.ticktime_ = this.ticktime_;
                posFusionResultExternal.status_ = this.status_;
                posFusionResultExternal.ns_ = this.ns_;
                posFusionResultExternal.ew_ = this.ew_;
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.posEnuBuilder_;
                if (singleFieldBuilderV3 == null) {
                    posFusionResultExternal.posEnu_ = this.posEnu_;
                } else {
                    posFusionResultExternal.posEnu_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV32 = this.refPosEcefBuilder_;
                if (singleFieldBuilderV32 == null) {
                    posFusionResultExternal.refPosEcef_ = this.refPosEcef_;
                } else {
                    posFusionResultExternal.refPosEcef_ = singleFieldBuilderV32.build();
                }
                posFusionResultExternal.speed_ = this.speed_;
                posFusionResultExternal.course_ = this.course_;
                posFusionResultExternal.alt_ = this.alt_;
                posFusionResultExternal.posAcc_ = this.posAcc_;
                posFusionResultExternal.courseAcc_ = this.courseAcc_;
                posFusionResultExternal.altAcc_ = this.altAcc_;
                posFusionResultExternal.speedAcc_ = this.speedAcc_;
                posFusionResultExternal.datetime_ = this.datetime_;
                posFusionResultExternal.fusiontype_ = this.fusiontype_;
                if ((this.bitField0_ & 32768) == 32768) {
                    this.spare_ = Collections.unmodifiableList(this.spare_);
                    this.bitField0_ &= -32769;
                }
                posFusionResultExternal.spare_ = this.spare_;
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV33 = this.worldecefpBuilder_;
                if (singleFieldBuilderV33 == null) {
                    posFusionResultExternal.worldecefp_ = this.worldecefp_;
                } else {
                    posFusionResultExternal.worldecefp_ = singleFieldBuilderV33.build();
                }
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV34 = this.worldecefqBuilder_;
                if (singleFieldBuilderV34 == null) {
                    posFusionResultExternal.worldecefq_ = this.worldecefq_;
                } else {
                    posFusionResultExternal.worldecefq_ = singleFieldBuilderV34.build();
                }
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV35 = this.refPosEcefqBuilder_;
                if (singleFieldBuilderV35 == null) {
                    posFusionResultExternal.refPosEcefq_ = this.refPosEcefq_;
                } else {
                    posFusionResultExternal.refPosEcefq_ = singleFieldBuilderV35.build();
                }
                posFusionResultExternal.bitField0_ = 0;
                onBuilt();
                return posFusionResultExternal;
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
                if (message instanceof PosFusionResultExternal) {
                    return mergeFrom((PosFusionResultExternal) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(PosFusionResultExternal posFusionResultExternal) {
                if (posFusionResultExternal == PosFusionResultExternal.getDefaultInstance()) {
                    return this;
                }
                if (posFusionResultExternal.getTicktime() != 0) {
                    setTicktime(posFusionResultExternal.getTicktime());
                }
                if (posFusionResultExternal.getStatus() != 0) {
                    setStatus(posFusionResultExternal.getStatus());
                }
                if (posFusionResultExternal.getNs() != 0) {
                    setNs(posFusionResultExternal.getNs());
                }
                if (posFusionResultExternal.getEw() != 0) {
                    setEw(posFusionResultExternal.getEw());
                }
                if (posFusionResultExternal.hasPosEnu()) {
                    mergePosEnu(posFusionResultExternal.getPosEnu());
                }
                if (posFusionResultExternal.hasRefPosEcef()) {
                    mergeRefPosEcef(posFusionResultExternal.getRefPosEcef());
                }
                if (posFusionResultExternal.getSpeed() != 0.0f) {
                    setSpeed(posFusionResultExternal.getSpeed());
                }
                if (posFusionResultExternal.getCourse() != 0.0f) {
                    setCourse(posFusionResultExternal.getCourse());
                }
                if (posFusionResultExternal.getAlt() != 0.0f) {
                    setAlt(posFusionResultExternal.getAlt());
                }
                if (posFusionResultExternal.getPosAcc() != 0.0f) {
                    setPosAcc(posFusionResultExternal.getPosAcc());
                }
                if (posFusionResultExternal.getCourseAcc() != 0.0f) {
                    setCourseAcc(posFusionResultExternal.getCourseAcc());
                }
                if (posFusionResultExternal.getAltAcc() != 0.0f) {
                    setAltAcc(posFusionResultExternal.getAltAcc());
                }
                if (posFusionResultExternal.getSpeedAcc() != 0.0f) {
                    setSpeedAcc(posFusionResultExternal.getSpeedAcc());
                }
                if (posFusionResultExternal.getDatetime() != 0) {
                    setDatetime(posFusionResultExternal.getDatetime());
                }
                if (posFusionResultExternal.getFusiontype() != 0) {
                    setFusiontype(posFusionResultExternal.getFusiontype());
                }
                if (!posFusionResultExternal.spare_.isEmpty()) {
                    if (this.spare_.isEmpty()) {
                        this.spare_ = posFusionResultExternal.spare_;
                        this.bitField0_ &= -32769;
                    } else {
                        ensureSpareIsMutable();
                        this.spare_.addAll(posFusionResultExternal.spare_);
                    }
                    onChanged();
                }
                if (posFusionResultExternal.hasWorldecefp()) {
                    mergeWorldecefp(posFusionResultExternal.getWorldecefp());
                }
                if (posFusionResultExternal.hasWorldecefq()) {
                    mergeWorldecefq(posFusionResultExternal.getWorldecefq());
                }
                if (posFusionResultExternal.hasRefPosEcefq()) {
                    mergeRefPosEcefq(posFusionResultExternal.getRefPosEcefq());
                }
                mergeUnknownFields(posFusionResultExternal.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Posrtkimu.PosFusionResultExternal.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Posrtkimu.PosFusionResultExternal.access$6800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Posrtkimu$PosFusionResultExternal r3 = (xpilot.sr.proto.Posrtkimu.PosFusionResultExternal) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Posrtkimu$PosFusionResultExternal r4 = (xpilot.sr.proto.Posrtkimu.PosFusionResultExternal) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Posrtkimu.PosFusionResultExternal.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Posrtkimu$PosFusionResultExternal$Builder");
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public long getTicktime() {
                return this.ticktime_;
            }

            public Builder setTicktime(long j) {
                this.ticktime_ = j;
                onChanged();
                return this;
            }

            public Builder clearTicktime() {
                this.ticktime_ = 0L;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public int getStatus() {
                return this.status_;
            }

            public Builder setStatus(int i) {
                this.status_ = i;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public int getNs() {
                return this.ns_;
            }

            public Builder setNs(int i) {
                this.ns_ = i;
                onChanged();
                return this;
            }

            public Builder clearNs() {
                this.ns_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public int getEw() {
                return this.ew_;
            }

            public Builder setEw(int i) {
                this.ew_ = i;
                onChanged();
                return this;
            }

            public Builder clearEw() {
                this.ew_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public boolean hasPosEnu() {
                return (this.posEnuBuilder_ == null && this.posEnu_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.Vector3D getPosEnu() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.posEnuBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D = this.posEnu_;
                    return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setPosEnu(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.posEnuBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    this.posEnu_ = vector3D;
                    onChanged();
                }
                return this;
            }

            public Builder setPosEnu(Primitives.Vector3D.Builder builder) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.posEnuBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.posEnu_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergePosEnu(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.posEnuBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D2 = this.posEnu_;
                    if (vector3D2 != null) {
                        this.posEnu_ = Primitives.Vector3D.newBuilder(vector3D2).mergeFrom(vector3D).buildPartial();
                    } else {
                        this.posEnu_ = vector3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(vector3D);
                }
                return this;
            }

            public Builder clearPosEnu() {
                if (this.posEnuBuilder_ == null) {
                    this.posEnu_ = null;
                    onChanged();
                } else {
                    this.posEnu_ = null;
                    this.posEnuBuilder_ = null;
                }
                return this;
            }

            public Primitives.Vector3D.Builder getPosEnuBuilder() {
                onChanged();
                return getPosEnuFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.Vector3DOrBuilder getPosEnuOrBuilder() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.posEnuBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Vector3D vector3D = this.posEnu_;
                return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
            }

            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> getPosEnuFieldBuilder() {
                if (this.posEnuBuilder_ == null) {
                    this.posEnuBuilder_ = new SingleFieldBuilderV3<>(getPosEnu(), getParentForChildren(), isClean());
                    this.posEnu_ = null;
                }
                return this.posEnuBuilder_;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public boolean hasRefPosEcef() {
                return (this.refPosEcefBuilder_ == null && this.refPosEcef_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.Vector3D getRefPosEcef() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.refPosEcefBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D = this.refPosEcef_;
                    return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setRefPosEcef(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.refPosEcefBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    this.refPosEcef_ = vector3D;
                    onChanged();
                }
                return this;
            }

            public Builder setRefPosEcef(Primitives.Vector3D.Builder builder) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.refPosEcefBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.refPosEcef_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeRefPosEcef(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.refPosEcefBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D2 = this.refPosEcef_;
                    if (vector3D2 != null) {
                        this.refPosEcef_ = Primitives.Vector3D.newBuilder(vector3D2).mergeFrom(vector3D).buildPartial();
                    } else {
                        this.refPosEcef_ = vector3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(vector3D);
                }
                return this;
            }

            public Builder clearRefPosEcef() {
                if (this.refPosEcefBuilder_ == null) {
                    this.refPosEcef_ = null;
                    onChanged();
                } else {
                    this.refPosEcef_ = null;
                    this.refPosEcefBuilder_ = null;
                }
                return this;
            }

            public Primitives.Vector3D.Builder getRefPosEcefBuilder() {
                onChanged();
                return getRefPosEcefFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.Vector3DOrBuilder getRefPosEcefOrBuilder() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.refPosEcefBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Vector3D vector3D = this.refPosEcef_;
                return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
            }

            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> getRefPosEcefFieldBuilder() {
                if (this.refPosEcefBuilder_ == null) {
                    this.refPosEcefBuilder_ = new SingleFieldBuilderV3<>(getRefPosEcef(), getParentForChildren(), isClean());
                    this.refPosEcef_ = null;
                }
                return this.refPosEcefBuilder_;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public float getSpeed() {
                return this.speed_;
            }

            public Builder setSpeed(float f) {
                this.speed_ = f;
                onChanged();
                return this;
            }

            public Builder clearSpeed() {
                this.speed_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public float getCourse() {
                return this.course_;
            }

            public Builder setCourse(float f) {
                this.course_ = f;
                onChanged();
                return this;
            }

            public Builder clearCourse() {
                this.course_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public float getAlt() {
                return this.alt_;
            }

            public Builder setAlt(float f) {
                this.alt_ = f;
                onChanged();
                return this;
            }

            public Builder clearAlt() {
                this.alt_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public float getPosAcc() {
                return this.posAcc_;
            }

            public Builder setPosAcc(float f) {
                this.posAcc_ = f;
                onChanged();
                return this;
            }

            public Builder clearPosAcc() {
                this.posAcc_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public float getCourseAcc() {
                return this.courseAcc_;
            }

            public Builder setCourseAcc(float f) {
                this.courseAcc_ = f;
                onChanged();
                return this;
            }

            public Builder clearCourseAcc() {
                this.courseAcc_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public float getAltAcc() {
                return this.altAcc_;
            }

            public Builder setAltAcc(float f) {
                this.altAcc_ = f;
                onChanged();
                return this;
            }

            public Builder clearAltAcc() {
                this.altAcc_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public float getSpeedAcc() {
                return this.speedAcc_;
            }

            public Builder setSpeedAcc(float f) {
                this.speedAcc_ = f;
                onChanged();
                return this;
            }

            public Builder clearSpeedAcc() {
                this.speedAcc_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public long getDatetime() {
                return this.datetime_;
            }

            public Builder setDatetime(long j) {
                this.datetime_ = j;
                onChanged();
                return this;
            }

            public Builder clearDatetime() {
                this.datetime_ = 0L;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public int getFusiontype() {
                return this.fusiontype_;
            }

            public Builder setFusiontype(int i) {
                this.fusiontype_ = i;
                onChanged();
                return this;
            }

            public Builder clearFusiontype() {
                this.fusiontype_ = 0;
                onChanged();
                return this;
            }

            private void ensureSpareIsMutable() {
                if ((this.bitField0_ & 32768) != 32768) {
                    this.spare_ = new ArrayList(this.spare_);
                    this.bitField0_ |= 32768;
                }
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public List<Float> getSpareList() {
                return Collections.unmodifiableList(this.spare_);
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public int getSpareCount() {
                return this.spare_.size();
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
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
                this.bitField0_ &= -32769;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public boolean hasWorldecefp() {
                return (this.worldecefpBuilder_ == null && this.worldecefp_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.Vector3D getWorldecefp() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.worldecefpBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D = this.worldecefp_;
                    return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setWorldecefp(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.worldecefpBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(vector3D);
                } else if (vector3D == null) {
                    throw new NullPointerException();
                } else {
                    this.worldecefp_ = vector3D;
                    onChanged();
                }
                return this;
            }

            public Builder setWorldecefp(Primitives.Vector3D.Builder builder) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.worldecefpBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.worldecefp_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeWorldecefp(Primitives.Vector3D vector3D) {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.worldecefpBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Vector3D vector3D2 = this.worldecefp_;
                    if (vector3D2 != null) {
                        this.worldecefp_ = Primitives.Vector3D.newBuilder(vector3D2).mergeFrom(vector3D).buildPartial();
                    } else {
                        this.worldecefp_ = vector3D;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(vector3D);
                }
                return this;
            }

            public Builder clearWorldecefp() {
                if (this.worldecefpBuilder_ == null) {
                    this.worldecefp_ = null;
                    onChanged();
                } else {
                    this.worldecefp_ = null;
                    this.worldecefpBuilder_ = null;
                }
                return this;
            }

            public Primitives.Vector3D.Builder getWorldecefpBuilder() {
                onChanged();
                return getWorldecefpFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.Vector3DOrBuilder getWorldecefpOrBuilder() {
                SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> singleFieldBuilderV3 = this.worldecefpBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Vector3D vector3D = this.worldecefp_;
                return vector3D == null ? Primitives.Vector3D.getDefaultInstance() : vector3D;
            }

            private SingleFieldBuilderV3<Primitives.Vector3D, Primitives.Vector3D.Builder, Primitives.Vector3DOrBuilder> getWorldecefpFieldBuilder() {
                if (this.worldecefpBuilder_ == null) {
                    this.worldecefpBuilder_ = new SingleFieldBuilderV3<>(getWorldecefp(), getParentForChildren(), isClean());
                    this.worldecefp_ = null;
                }
                return this.worldecefpBuilder_;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public boolean hasWorldecefq() {
                return (this.worldecefqBuilder_ == null && this.worldecefq_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.Quaternion getWorldecefq() {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.worldecefqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Quaternion quaternion = this.worldecefq_;
                    return quaternion == null ? Primitives.Quaternion.getDefaultInstance() : quaternion;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setWorldecefq(Primitives.Quaternion quaternion) {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.worldecefqBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(quaternion);
                } else if (quaternion == null) {
                    throw new NullPointerException();
                } else {
                    this.worldecefq_ = quaternion;
                    onChanged();
                }
                return this;
            }

            public Builder setWorldecefq(Primitives.Quaternion.Builder builder) {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.worldecefqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.worldecefq_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeWorldecefq(Primitives.Quaternion quaternion) {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.worldecefqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Quaternion quaternion2 = this.worldecefq_;
                    if (quaternion2 != null) {
                        this.worldecefq_ = Primitives.Quaternion.newBuilder(quaternion2).mergeFrom(quaternion).buildPartial();
                    } else {
                        this.worldecefq_ = quaternion;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(quaternion);
                }
                return this;
            }

            public Builder clearWorldecefq() {
                if (this.worldecefqBuilder_ == null) {
                    this.worldecefq_ = null;
                    onChanged();
                } else {
                    this.worldecefq_ = null;
                    this.worldecefqBuilder_ = null;
                }
                return this;
            }

            public Primitives.Quaternion.Builder getWorldecefqBuilder() {
                onChanged();
                return getWorldecefqFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.QuaternionOrBuilder getWorldecefqOrBuilder() {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.worldecefqBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Quaternion quaternion = this.worldecefq_;
                return quaternion == null ? Primitives.Quaternion.getDefaultInstance() : quaternion;
            }

            private SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> getWorldecefqFieldBuilder() {
                if (this.worldecefqBuilder_ == null) {
                    this.worldecefqBuilder_ = new SingleFieldBuilderV3<>(getWorldecefq(), getParentForChildren(), isClean());
                    this.worldecefq_ = null;
                }
                return this.worldecefqBuilder_;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public boolean hasRefPosEcefq() {
                return (this.refPosEcefqBuilder_ == null && this.refPosEcefq_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.Quaternion getRefPosEcefq() {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.refPosEcefqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Quaternion quaternion = this.refPosEcefq_;
                    return quaternion == null ? Primitives.Quaternion.getDefaultInstance() : quaternion;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setRefPosEcefq(Primitives.Quaternion quaternion) {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.refPosEcefqBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(quaternion);
                } else if (quaternion == null) {
                    throw new NullPointerException();
                } else {
                    this.refPosEcefq_ = quaternion;
                    onChanged();
                }
                return this;
            }

            public Builder setRefPosEcefq(Primitives.Quaternion.Builder builder) {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.refPosEcefqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.refPosEcefq_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeRefPosEcefq(Primitives.Quaternion quaternion) {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.refPosEcefqBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Primitives.Quaternion quaternion2 = this.refPosEcefq_;
                    if (quaternion2 != null) {
                        this.refPosEcefq_ = Primitives.Quaternion.newBuilder(quaternion2).mergeFrom(quaternion).buildPartial();
                    } else {
                        this.refPosEcefq_ = quaternion;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(quaternion);
                }
                return this;
            }

            public Builder clearRefPosEcefq() {
                if (this.refPosEcefqBuilder_ == null) {
                    this.refPosEcefq_ = null;
                    onChanged();
                } else {
                    this.refPosEcefq_ = null;
                    this.refPosEcefqBuilder_ = null;
                }
                return this;
            }

            public Primitives.Quaternion.Builder getRefPosEcefqBuilder() {
                onChanged();
                return getRefPosEcefqFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Posrtkimu.PosFusionResultExternalOrBuilder
            public Primitives.QuaternionOrBuilder getRefPosEcefqOrBuilder() {
                SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> singleFieldBuilderV3 = this.refPosEcefqBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Primitives.Quaternion quaternion = this.refPosEcefq_;
                return quaternion == null ? Primitives.Quaternion.getDefaultInstance() : quaternion;
            }

            private SingleFieldBuilderV3<Primitives.Quaternion, Primitives.Quaternion.Builder, Primitives.QuaternionOrBuilder> getRefPosEcefqFieldBuilder() {
                if (this.refPosEcefqBuilder_ == null) {
                    this.refPosEcefqBuilder_ = new SingleFieldBuilderV3<>(getRefPosEcefq(), getParentForChildren(), isClean());
                    this.refPosEcefq_ = null;
                }
                return this.refPosEcefqBuilder_;
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

        public static PosFusionResultExternal getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PosFusionResultExternal> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PosFusionResultExternal> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PosFusionResultExternal getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fposrtkimu.proto\u0012\u000fxpilot.sr.proto\u001a\u0010primitives.proto\u001a\u0010local_pose.proto\"\u0080\u0001\n\nGaode_Info\u00128\n\u0006brief8\u0018\u0001 \u0001(\u000b2(.xpilot.sr.proto.PosRTKImuResultExternal\u00128\n\u0006brief9\u0018\u0002 \u0001(\u000b2(.xpilot.sr.proto.PosFusionResultExternal\"\u0090\u0003\n\u0017PosRTKImuResultExternal\u0012\u0010\n\bticktime\u0018\u0001 \u0001(\u0004\u0012\u000e\n\u0006status\u0018\u0002 \u0001(\u0005\u0012\n\n\u0002ns\u0018\u0003 \u0001(\u0005\u0012\n\n\u0002ew\u0018\u0004 \u0001(\u0005\u0012,\n\u0003pos\u0018\u0005 \u0001(\u000b2\u001f.xpilot.sr.proto.GlobalPoseInfo\u0012\r\n\u0005speed\u0018\u0006 \u0001(\u0002\u0012\u000e\n\u0006course\u0018\u0007 \u0001(\u0002\u0012\u000b\n\u0003alt\u0018\b \u0001(\u0002\u0012\u000e\n\u0006posacc\u0018\t \u0001(\u0002\u0012\u0011\n\tcourseacc\u0018\n \u0001(\u0002\u0012\u000e\n\u0006altacc\u0018\u000b \u0001(\u0002\u0012\u0010\n\bspeedacc\u0018\f \u0001(\u0002\u0012\u000e\n\u0006satnum\u0018\r \u0001(\u0002\u0012\f\n\u0004hdop\u0018\u000e \u0001(\u0002\u0012\f\n\u0004vdop\u0018\u000f \u0001(\u0002\u0012\f\n\u0004pdop\u0018\u0010 \u0001(\u0002\u0012\u0010\n\bdatetime\u0018\u0011 \u0001(\u0004\u0012\u0012\n\nfusiontype\u0018\u0012 \u0001(\u0005\u0012-\n\nlocal_pose\u0018\u0013 \u0001(\u000b2\u0019.xpilot.sr.proto.Vector3D\u0012\r\n\u0005spare\u0018\u0014 \u0003(\u0002\"å\u0003\n\u0017PosFusionResultExternal\u0012\u0010\n\bticktime\u0018\u0001 \u0001(\u0004\u0012\u000e\n\u0006status\u0018\u0002 \u0001(\u0005\u0012\n\n\u0002ns\u0018\u0003 \u0001(\u0005\u0012\n\n\u0002ew\u0018\u0004 \u0001(\u0005\u0012)\n\u0006posEnu\u0018\u0005 \u0001(\u000b2\u0019.xpilot.sr.proto.Vector3D\u0012-\n\nrefPosEcef\u0018\u0006 \u0001(\u000b2\u0019.xpilot.sr.proto.Vector3D\u0012\r\n\u0005speed\u0018\u0007 \u0001(\u0002\u0012\u000e\n\u0006course\u0018\b \u0001(\u0002\u0012\u000b\n\u0003alt\u0018\t \u0001(\u0002\u0012\u000e\n\u0006posAcc\u0018\n \u0001(\u0002\u0012\u0011\n\tcourseAcc\u0018\u000b \u0001(\u0002\u0012\u000e\n\u0006altAcc\u0018\f \u0001(\u0002\u0012\u0010\n\bspeedAcc\u0018\r \u0001(\u0002\u0012\u0010\n\bdatetime\u0018\u000e \u0001(\u0004\u0012\u0012\n\nfusiontype\u0018\u000f \u0001(\u0005\u0012\r\n\u0005spare\u0018\u0010 \u0003(\u0002\u0012-\n\nworldecefp\u0018\u0011 \u0001(\u000b2\u0019.xpilot.sr.proto.Vector3D\u0012/\n\nworldecefq\u0018\u0012 \u0001(\u000b2\u001b.xpilot.sr.proto.Quaternion\u00120\n\u000brefPosEcefq\u0018\u0013 \u0001(\u000b2\u001b.xpilot.sr.proto.Quaternionb\u0006proto3"}, new Descriptors.FileDescriptor[]{Primitives.getDescriptor(), LocalPose.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.Posrtkimu.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Posrtkimu.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_Gaode_Info_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_Gaode_Info_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_Gaode_Info_descriptor, new String[]{"Brief8", "Brief9"});
        internal_static_xpilot_sr_proto_PosRTKImuResultExternal_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_xpilot_sr_proto_PosRTKImuResultExternal_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_PosRTKImuResultExternal_descriptor, new String[]{"Ticktime", "Status", "Ns", "Ew", "Pos", "Speed", "Course", "Alt", "Posacc", "Courseacc", "Altacc", "Speedacc", "Satnum", "Hdop", "Vdop", "Pdop", "Datetime", "Fusiontype", "LocalPose", "Spare"});
        internal_static_xpilot_sr_proto_PosFusionResultExternal_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_xpilot_sr_proto_PosFusionResultExternal_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_PosFusionResultExternal_descriptor, new String[]{"Ticktime", "Status", "Ns", "Ew", "PosEnu", "RefPosEcef", "Speed", "Course", "Alt", "PosAcc", "CourseAcc", "AltAcc", "SpeedAcc", "Datetime", "Fusiontype", "Spare", "Worldecefp", "Worldecefq", "RefPosEcefq"});
        Primitives.getDescriptor();
        LocalPose.getDescriptor();
    }
}
