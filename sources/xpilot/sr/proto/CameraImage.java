package xpilot.sr.proto;

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
import com.google.protobuf.UnknownFieldSet;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class CameraImage {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_cameraimage_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_cameraimage_fieldAccessorTable;

    /* loaded from: classes4.dex */
    public interface cameraimageOrBuilder extends MessageOrBuilder {
        int getCameraId();

        int getHeight();

        ByteString getImagedata();

        int getSize();

        int getWidth();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private CameraImage() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes4.dex */
    public static final class cameraimage extends GeneratedMessageV3 implements cameraimageOrBuilder {
        public static final int CAMERA_ID_FIELD_NUMBER = 3;
        public static final int HEIGHT_FIELD_NUMBER = 2;
        public static final int IMAGEDATA_FIELD_NUMBER = 5;
        public static final int SIZE_FIELD_NUMBER = 4;
        public static final int WIDTH_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int cameraId_;
        private int height_;
        private ByteString imagedata_;
        private byte memoizedIsInitialized;
        private int size_;
        private int width_;
        private static final cameraimage DEFAULT_INSTANCE = new cameraimage();
        private static final Parser<cameraimage> PARSER = new AbstractParser<cameraimage>() { // from class: xpilot.sr.proto.CameraImage.cameraimage.1
            @Override // com.google.protobuf.Parser
            public cameraimage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new cameraimage(codedInputStream, extensionRegistryLite);
            }
        };

        private cameraimage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private cameraimage() {
            this.memoizedIsInitialized = (byte) -1;
            this.width_ = 0;
            this.height_ = 0;
            this.cameraId_ = 0;
            this.size_ = 0;
            this.imagedata_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private cameraimage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 8) {
                                    this.width_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.height_ = codedInputStream.readInt32();
                                } else if (readTag == 24) {
                                    this.cameraId_ = codedInputStream.readInt32();
                                } else if (readTag == 32) {
                                    this.size_ = codedInputStream.readInt32();
                                } else if (readTag == 42) {
                                    this.imagedata_ = codedInputStream.readBytes();
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
            return CameraImage.internal_static_xpilot_sr_proto_cameraimage_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CameraImage.internal_static_xpilot_sr_proto_cameraimage_fieldAccessorTable.ensureFieldAccessorsInitialized(cameraimage.class, Builder.class);
        }

        @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
        public int getHeight() {
            return this.height_;
        }

        @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
        public int getCameraId() {
            return this.cameraId_;
        }

        @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
        public int getSize() {
            return this.size_;
        }

        @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
        public ByteString getImagedata() {
            return this.imagedata_;
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
            int i = this.width_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            int i2 = this.height_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            int i3 = this.cameraId_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
            int i4 = this.size_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(4, i4);
            }
            if (!this.imagedata_.isEmpty()) {
                codedOutputStream.writeBytes(5, this.imagedata_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.width_;
            int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.height_;
            if (i3 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.cameraId_;
            if (i4 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
            }
            int i5 = this.size_;
            if (i5 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, i5);
            }
            if (!this.imagedata_.isEmpty()) {
                computeInt32Size += CodedOutputStream.computeBytesSize(5, this.imagedata_);
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
            if (!(obj instanceof cameraimage)) {
                return super.equals(obj);
            }
            cameraimage cameraimageVar = (cameraimage) obj;
            return (((((getWidth() == cameraimageVar.getWidth()) && getHeight() == cameraimageVar.getHeight()) && getCameraId() == cameraimageVar.getCameraId()) && getSize() == cameraimageVar.getSize()) && getImagedata().equals(cameraimageVar.getImagedata())) && this.unknownFields.equals(cameraimageVar.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getWidth()) * 37) + 2) * 53) + getHeight()) * 37) + 3) * 53) + getCameraId()) * 37) + 4) * 53) + getSize()) * 37) + 5) * 53) + getImagedata().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static cameraimage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static cameraimage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static cameraimage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static cameraimage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static cameraimage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static cameraimage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static cameraimage parseFrom(InputStream inputStream) throws IOException {
            return (cameraimage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static cameraimage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (cameraimage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static cameraimage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (cameraimage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static cameraimage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (cameraimage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static cameraimage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (cameraimage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static cameraimage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (cameraimage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(cameraimage cameraimageVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(cameraimageVar);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements cameraimageOrBuilder {
            private int cameraId_;
            private int height_;
            private ByteString imagedata_;
            private int size_;
            private int width_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CameraImage.internal_static_xpilot_sr_proto_cameraimage_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CameraImage.internal_static_xpilot_sr_proto_cameraimage_fieldAccessorTable.ensureFieldAccessorsInitialized(cameraimage.class, Builder.class);
            }

            private Builder() {
                this.imagedata_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.imagedata_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = cameraimage.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.width_ = 0;
                this.height_ = 0;
                this.cameraId_ = 0;
                this.size_ = 0;
                this.imagedata_ = ByteString.EMPTY;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CameraImage.internal_static_xpilot_sr_proto_cameraimage_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public cameraimage getDefaultInstanceForType() {
                return cameraimage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public cameraimage build() {
                cameraimage buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public cameraimage buildPartial() {
                cameraimage cameraimageVar = new cameraimage(this);
                cameraimageVar.width_ = this.width_;
                cameraimageVar.height_ = this.height_;
                cameraimageVar.cameraId_ = this.cameraId_;
                cameraimageVar.size_ = this.size_;
                cameraimageVar.imagedata_ = this.imagedata_;
                onBuilt();
                return cameraimageVar;
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
                if (message instanceof cameraimage) {
                    return mergeFrom((cameraimage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(cameraimage cameraimageVar) {
                if (cameraimageVar == cameraimage.getDefaultInstance()) {
                    return this;
                }
                if (cameraimageVar.getWidth() != 0) {
                    setWidth(cameraimageVar.getWidth());
                }
                if (cameraimageVar.getHeight() != 0) {
                    setHeight(cameraimageVar.getHeight());
                }
                if (cameraimageVar.getCameraId() != 0) {
                    setCameraId(cameraimageVar.getCameraId());
                }
                if (cameraimageVar.getSize() != 0) {
                    setSize(cameraimageVar.getSize());
                }
                if (cameraimageVar.getImagedata() != ByteString.EMPTY) {
                    setImagedata(cameraimageVar.getImagedata());
                }
                mergeUnknownFields(cameraimageVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.CameraImage.cameraimage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.CameraImage.cameraimage.access$1200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.CameraImage$cameraimage r3 = (xpilot.sr.proto.CameraImage.cameraimage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.CameraImage$cameraimage r4 = (xpilot.sr.proto.CameraImage.cameraimage) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.CameraImage.cameraimage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.CameraImage$cameraimage$Builder");
            }

            @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
            public int getWidth() {
                return this.width_;
            }

            public Builder setWidth(int i) {
                this.width_ = i;
                onChanged();
                return this;
            }

            public Builder clearWidth() {
                this.width_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
            public int getHeight() {
                return this.height_;
            }

            public Builder setHeight(int i) {
                this.height_ = i;
                onChanged();
                return this;
            }

            public Builder clearHeight() {
                this.height_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
            public int getCameraId() {
                return this.cameraId_;
            }

            public Builder setCameraId(int i) {
                this.cameraId_ = i;
                onChanged();
                return this;
            }

            public Builder clearCameraId() {
                this.cameraId_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
            public int getSize() {
                return this.size_;
            }

            public Builder setSize(int i) {
                this.size_ = i;
                onChanged();
                return this;
            }

            public Builder clearSize() {
                this.size_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.CameraImage.cameraimageOrBuilder
            public ByteString getImagedata() {
                return this.imagedata_;
            }

            public Builder setImagedata(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.imagedata_ = byteString;
                onChanged();
                return this;
            }

            public Builder clearImagedata() {
                this.imagedata_ = cameraimage.getDefaultInstance().getImagedata();
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

        public static cameraimage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<cameraimage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<cameraimage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public cameraimage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012camera_image.proto\u0012\u000fxpilot.sr.proto\"`\n\u000bcameraimage\u0012\r\n\u0005width\u0018\u0001 \u0001(\u0005\u0012\u000e\n\u0006height\u0018\u0002 \u0001(\u0005\u0012\u0011\n\tcamera_id\u0018\u0003 \u0001(\u0005\u0012\f\n\u0004size\u0018\u0004 \u0001(\u0005\u0012\u0011\n\timagedata\u0018\u0005 \u0001(\fb\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.CameraImage.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = CameraImage.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_cameraimage_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_cameraimage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_cameraimage_descriptor, new String[]{"Width", "Height", "CameraId", "Size", "Imagedata"});
    }
}
