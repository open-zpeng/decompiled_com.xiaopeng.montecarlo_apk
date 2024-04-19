package xpilot.sr.proto;

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
/* loaded from: classes4.dex */
public final class Nmeadata {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_NmeadataInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_NmeadataInfo_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_NmeadateData_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_NmeadateData_fieldAccessorTable;

    /* loaded from: classes4.dex */
    public interface NmeadataInfoOrBuilder extends MessageOrBuilder {
        NmeadateData getData();

        NmeadateDataOrBuilder getDataOrBuilder();

        long getTimeStamp();

        boolean hasData();
    }

    /* loaded from: classes4.dex */
    public interface NmeadateDataOrBuilder extends MessageOrBuilder {
        String getMessage();

        ByteString getMessageBytes();

        long getTimeStamp();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Nmeadata() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes4.dex */
    public static final class NmeadateData extends GeneratedMessageV3 implements NmeadateDataOrBuilder {
        public static final int MESSAGE_FIELD_NUMBER = 1;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private long timeStamp_;
        private static final NmeadateData DEFAULT_INSTANCE = new NmeadateData();
        private static final Parser<NmeadateData> PARSER = new AbstractParser<NmeadateData>() { // from class: xpilot.sr.proto.Nmeadata.NmeadateData.1
            @Override // com.google.protobuf.Parser
            public NmeadateData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new NmeadateData(codedInputStream, extensionRegistryLite);
            }
        };

        private NmeadateData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private NmeadateData() {
            this.memoizedIsInitialized = (byte) -1;
            this.message_ = "";
            this.timeStamp_ = 0L;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private NmeadateData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 10) {
                                    this.message_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 16) {
                                    this.timeStamp_ = codedInputStream.readUInt64();
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
            return Nmeadata.internal_static_xpilot_sr_proto_NmeadateData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Nmeadata.internal_static_xpilot_sr_proto_NmeadateData_fieldAccessorTable.ensureFieldAccessorsInitialized(NmeadateData.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Nmeadata.NmeadateDataOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // xpilot.sr.proto.Nmeadata.NmeadateDataOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // xpilot.sr.proto.Nmeadata.NmeadateDataOrBuilder
        public long getTimeStamp() {
            return this.timeStamp_;
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
            if (!getMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.message_);
            }
            long j = this.timeStamp_;
            if (j != 0) {
                codedOutputStream.writeUInt64(2, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = getMessageBytes().isEmpty() ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.message_);
            long j = this.timeStamp_;
            if (j != 0) {
                computeStringSize += CodedOutputStream.computeUInt64Size(2, j);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof NmeadateData)) {
                return super.equals(obj);
            }
            NmeadateData nmeadateData = (NmeadateData) obj;
            return ((getMessage().equals(nmeadateData.getMessage())) && (getTimeStamp() > nmeadateData.getTimeStamp() ? 1 : (getTimeStamp() == nmeadateData.getTimeStamp() ? 0 : -1)) == 0) && this.unknownFields.equals(nmeadateData.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getMessage().hashCode()) * 37) + 2) * 53) + Internal.hashLong(getTimeStamp())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static NmeadateData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static NmeadateData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static NmeadateData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static NmeadateData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static NmeadateData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static NmeadateData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static NmeadateData parseFrom(InputStream inputStream) throws IOException {
            return (NmeadateData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static NmeadateData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (NmeadateData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static NmeadateData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (NmeadateData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static NmeadateData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (NmeadateData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static NmeadateData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (NmeadateData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static NmeadateData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (NmeadateData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(NmeadateData nmeadateData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(nmeadateData);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NmeadateDataOrBuilder {
            private Object message_;
            private long timeStamp_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Nmeadata.internal_static_xpilot_sr_proto_NmeadateData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Nmeadata.internal_static_xpilot_sr_proto_NmeadateData_fieldAccessorTable.ensureFieldAccessorsInitialized(NmeadateData.class, Builder.class);
            }

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = NmeadateData.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.message_ = "";
                this.timeStamp_ = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Nmeadata.internal_static_xpilot_sr_proto_NmeadateData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NmeadateData getDefaultInstanceForType() {
                return NmeadateData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NmeadateData build() {
                NmeadateData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NmeadateData buildPartial() {
                NmeadateData nmeadateData = new NmeadateData(this);
                nmeadateData.message_ = this.message_;
                nmeadateData.timeStamp_ = this.timeStamp_;
                onBuilt();
                return nmeadateData;
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
                if (message instanceof NmeadateData) {
                    return mergeFrom((NmeadateData) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(NmeadateData nmeadateData) {
                if (nmeadateData == NmeadateData.getDefaultInstance()) {
                    return this;
                }
                if (!nmeadateData.getMessage().isEmpty()) {
                    this.message_ = nmeadateData.message_;
                    onChanged();
                }
                if (nmeadateData.getTimeStamp() != 0) {
                    setTimeStamp(nmeadateData.getTimeStamp());
                }
                mergeUnknownFields(nmeadateData.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Nmeadata.NmeadateData.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Nmeadata.NmeadateData.access$900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Nmeadata$NmeadateData r3 = (xpilot.sr.proto.Nmeadata.NmeadateData) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Nmeadata$NmeadateData r4 = (xpilot.sr.proto.Nmeadata.NmeadateData) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Nmeadata.NmeadateData.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Nmeadata$NmeadateData$Builder");
            }

            @Override // xpilot.sr.proto.Nmeadata.NmeadateDataOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.message_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // xpilot.sr.proto.Nmeadata.NmeadateDataOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.message_ = str;
                onChanged();
                return this;
            }

            public Builder clearMessage() {
                this.message_ = NmeadateData.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) {
                if (byteString != null) {
                    NmeadateData.checkByteStringIsUtf8(byteString);
                    this.message_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            @Override // xpilot.sr.proto.Nmeadata.NmeadateDataOrBuilder
            public long getTimeStamp() {
                return this.timeStamp_;
            }

            public Builder setTimeStamp(long j) {
                this.timeStamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearTimeStamp() {
                this.timeStamp_ = 0L;
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

        public static NmeadateData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NmeadateData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<NmeadateData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NmeadateData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class NmeadataInfo extends GeneratedMessageV3 implements NmeadataInfoOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final NmeadataInfo DEFAULT_INSTANCE = new NmeadataInfo();
        private static final Parser<NmeadataInfo> PARSER = new AbstractParser<NmeadataInfo>() { // from class: xpilot.sr.proto.Nmeadata.NmeadataInfo.1
            @Override // com.google.protobuf.Parser
            public NmeadataInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new NmeadataInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private NmeadateData data_;
        private byte memoizedIsInitialized;
        private long timeStamp_;

        private NmeadataInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private NmeadataInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.timeStamp_ = 0L;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private NmeadataInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 10) {
                                    NmeadateData.Builder builder = this.data_ != null ? this.data_.toBuilder() : null;
                                    this.data_ = (NmeadateData) codedInputStream.readMessage(NmeadateData.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.data_);
                                        this.data_ = builder.buildPartial();
                                    }
                                } else if (readTag == 16) {
                                    this.timeStamp_ = codedInputStream.readUInt64();
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
            return Nmeadata.internal_static_xpilot_sr_proto_NmeadataInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Nmeadata.internal_static_xpilot_sr_proto_NmeadataInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(NmeadataInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Nmeadata.NmeadataInfoOrBuilder
        public boolean hasData() {
            return this.data_ != null;
        }

        @Override // xpilot.sr.proto.Nmeadata.NmeadataInfoOrBuilder
        public NmeadateData getData() {
            NmeadateData nmeadateData = this.data_;
            return nmeadateData == null ? NmeadateData.getDefaultInstance() : nmeadateData;
        }

        @Override // xpilot.sr.proto.Nmeadata.NmeadataInfoOrBuilder
        public NmeadateDataOrBuilder getDataOrBuilder() {
            return getData();
        }

        @Override // xpilot.sr.proto.Nmeadata.NmeadataInfoOrBuilder
        public long getTimeStamp() {
            return this.timeStamp_;
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
            if (this.data_ != null) {
                codedOutputStream.writeMessage(1, getData());
            }
            long j = this.timeStamp_;
            if (j != 0) {
                codedOutputStream.writeUInt64(2, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.data_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getData()) : 0;
            long j = this.timeStamp_;
            if (j != 0) {
                computeMessageSize += CodedOutputStream.computeUInt64Size(2, j);
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
            if (!(obj instanceof NmeadataInfo)) {
                return super.equals(obj);
            }
            NmeadataInfo nmeadataInfo = (NmeadataInfo) obj;
            boolean z = hasData() == nmeadataInfo.hasData();
            if (hasData()) {
                z = z && getData().equals(nmeadataInfo.getData());
            }
            return (z && (getTimeStamp() > nmeadataInfo.getTimeStamp() ? 1 : (getTimeStamp() == nmeadataInfo.getTimeStamp() ? 0 : -1)) == 0) && this.unknownFields.equals(nmeadataInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode();
            if (hasData()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getData().hashCode();
            }
            int hashLong = (((((hashCode * 37) + 2) * 53) + Internal.hashLong(getTimeStamp())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashLong;
            return hashLong;
        }

        public static NmeadataInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static NmeadataInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static NmeadataInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static NmeadataInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static NmeadataInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static NmeadataInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static NmeadataInfo parseFrom(InputStream inputStream) throws IOException {
            return (NmeadataInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static NmeadataInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (NmeadataInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static NmeadataInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (NmeadataInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static NmeadataInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (NmeadataInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static NmeadataInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (NmeadataInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static NmeadataInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (NmeadataInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(NmeadataInfo nmeadataInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(nmeadataInfo);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NmeadataInfoOrBuilder {
            private SingleFieldBuilderV3<NmeadateData, NmeadateData.Builder, NmeadateDataOrBuilder> dataBuilder_;
            private NmeadateData data_;
            private long timeStamp_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Nmeadata.internal_static_xpilot_sr_proto_NmeadataInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Nmeadata.internal_static_xpilot_sr_proto_NmeadataInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(NmeadataInfo.class, Builder.class);
            }

            private Builder() {
                this.data_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.data_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = NmeadataInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.dataBuilder_ == null) {
                    this.data_ = null;
                } else {
                    this.data_ = null;
                    this.dataBuilder_ = null;
                }
                this.timeStamp_ = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Nmeadata.internal_static_xpilot_sr_proto_NmeadataInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NmeadataInfo getDefaultInstanceForType() {
                return NmeadataInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NmeadataInfo build() {
                NmeadataInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NmeadataInfo buildPartial() {
                NmeadataInfo nmeadataInfo = new NmeadataInfo(this);
                SingleFieldBuilderV3<NmeadateData, NmeadateData.Builder, NmeadateDataOrBuilder> singleFieldBuilderV3 = this.dataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    nmeadataInfo.data_ = this.data_;
                } else {
                    nmeadataInfo.data_ = singleFieldBuilderV3.build();
                }
                nmeadataInfo.timeStamp_ = this.timeStamp_;
                onBuilt();
                return nmeadataInfo;
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
                if (message instanceof NmeadataInfo) {
                    return mergeFrom((NmeadataInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(NmeadataInfo nmeadataInfo) {
                if (nmeadataInfo == NmeadataInfo.getDefaultInstance()) {
                    return this;
                }
                if (nmeadataInfo.hasData()) {
                    mergeData(nmeadataInfo.getData());
                }
                if (nmeadataInfo.getTimeStamp() != 0) {
                    setTimeStamp(nmeadataInfo.getTimeStamp());
                }
                mergeUnknownFields(nmeadataInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Nmeadata.NmeadataInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Nmeadata.NmeadataInfo.access$2100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Nmeadata$NmeadataInfo r3 = (xpilot.sr.proto.Nmeadata.NmeadataInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Nmeadata$NmeadataInfo r4 = (xpilot.sr.proto.Nmeadata.NmeadataInfo) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Nmeadata.NmeadataInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Nmeadata$NmeadataInfo$Builder");
            }

            @Override // xpilot.sr.proto.Nmeadata.NmeadataInfoOrBuilder
            public boolean hasData() {
                return (this.dataBuilder_ == null && this.data_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.Nmeadata.NmeadataInfoOrBuilder
            public NmeadateData getData() {
                SingleFieldBuilderV3<NmeadateData, NmeadateData.Builder, NmeadateDataOrBuilder> singleFieldBuilderV3 = this.dataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    NmeadateData nmeadateData = this.data_;
                    return nmeadateData == null ? NmeadateData.getDefaultInstance() : nmeadateData;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setData(NmeadateData nmeadateData) {
                SingleFieldBuilderV3<NmeadateData, NmeadateData.Builder, NmeadateDataOrBuilder> singleFieldBuilderV3 = this.dataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(nmeadateData);
                } else if (nmeadateData == null) {
                    throw new NullPointerException();
                } else {
                    this.data_ = nmeadateData;
                    onChanged();
                }
                return this;
            }

            public Builder setData(NmeadateData.Builder builder) {
                SingleFieldBuilderV3<NmeadateData, NmeadateData.Builder, NmeadateDataOrBuilder> singleFieldBuilderV3 = this.dataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.data_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeData(NmeadateData nmeadateData) {
                SingleFieldBuilderV3<NmeadateData, NmeadateData.Builder, NmeadateDataOrBuilder> singleFieldBuilderV3 = this.dataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    NmeadateData nmeadateData2 = this.data_;
                    if (nmeadateData2 != null) {
                        this.data_ = NmeadateData.newBuilder(nmeadateData2).mergeFrom(nmeadateData).buildPartial();
                    } else {
                        this.data_ = nmeadateData;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(nmeadateData);
                }
                return this;
            }

            public Builder clearData() {
                if (this.dataBuilder_ == null) {
                    this.data_ = null;
                    onChanged();
                } else {
                    this.data_ = null;
                    this.dataBuilder_ = null;
                }
                return this;
            }

            public NmeadateData.Builder getDataBuilder() {
                onChanged();
                return getDataFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.Nmeadata.NmeadataInfoOrBuilder
            public NmeadateDataOrBuilder getDataOrBuilder() {
                SingleFieldBuilderV3<NmeadateData, NmeadateData.Builder, NmeadateDataOrBuilder> singleFieldBuilderV3 = this.dataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                NmeadateData nmeadateData = this.data_;
                return nmeadateData == null ? NmeadateData.getDefaultInstance() : nmeadateData;
            }

            private SingleFieldBuilderV3<NmeadateData, NmeadateData.Builder, NmeadateDataOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    this.dataBuilder_ = new SingleFieldBuilderV3<>(getData(), getParentForChildren(), isClean());
                    this.data_ = null;
                }
                return this.dataBuilder_;
            }

            @Override // xpilot.sr.proto.Nmeadata.NmeadataInfoOrBuilder
            public long getTimeStamp() {
                return this.timeStamp_;
            }

            public Builder setTimeStamp(long j) {
                this.timeStamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearTimeStamp() {
                this.timeStamp_ = 0L;
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

        public static NmeadataInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NmeadataInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<NmeadataInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NmeadataInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000enmeadata.proto\u0012\u000fxpilot.sr.proto\"2\n\fNmeadateData\u0012\u000f\n\u0007message\u0018\u0001 \u0001(\t\u0012\u0011\n\ttimeStamp\u0018\u0002 \u0001(\u0004\"N\n\fNmeadataInfo\u0012+\n\u0004data\u0018\u0001 \u0001(\u000b2\u001d.xpilot.sr.proto.NmeadateData\u0012\u0011\n\ttimeStamp\u0018\u0002 \u0001(\u0004b\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.Nmeadata.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Nmeadata.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_NmeadateData_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_NmeadateData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_NmeadateData_descriptor, new String[]{"Message", "TimeStamp"});
        internal_static_xpilot_sr_proto_NmeadataInfo_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_xpilot_sr_proto_NmeadataInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_NmeadataInfo_descriptor, new String[]{"Data", "TimeStamp"});
    }
}
