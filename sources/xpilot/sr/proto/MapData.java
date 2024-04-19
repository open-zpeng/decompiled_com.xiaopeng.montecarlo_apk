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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class MapData {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_ApMapFile_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_ApMapFile_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_MapFile_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_MapFile_fieldAccessorTable;

    /* loaded from: classes4.dex */
    public interface ApMapFileOrBuilder extends MessageOrBuilder {
        MapFile getFile();

        MapFileOrBuilder getFileOrBuilder();

        ApMapFile.EnumMapType getType();

        int getTypeValue();

        boolean hasFile();
    }

    /* loaded from: classes4.dex */
    public interface MapFileOrBuilder extends MessageOrBuilder {
        ByteString getFbuf();

        String getFname();

        ByteString getFnameBytes();

        long getFsize();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private MapData() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes4.dex */
    public static final class MapFile extends GeneratedMessageV3 implements MapFileOrBuilder {
        public static final int FBUF_FIELD_NUMBER = 3;
        public static final int FNAME_FIELD_NUMBER = 1;
        public static final int FSIZE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private ByteString fbuf_;
        private volatile Object fname_;
        private long fsize_;
        private byte memoizedIsInitialized;
        private static final MapFile DEFAULT_INSTANCE = new MapFile();
        private static final Parser<MapFile> PARSER = new AbstractParser<MapFile>() { // from class: xpilot.sr.proto.MapData.MapFile.1
            @Override // com.google.protobuf.Parser
            public MapFile parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MapFile(codedInputStream, extensionRegistryLite);
            }
        };

        private MapFile(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private MapFile() {
            this.memoizedIsInitialized = (byte) -1;
            this.fname_ = "";
            this.fsize_ = 0L;
            this.fbuf_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MapFile(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.fname_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.fsize_ = codedInputStream.readUInt64();
                            } else if (readTag == 26) {
                                this.fbuf_ = codedInputStream.readBytes();
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
            return MapData.internal_static_xpilot_sr_proto_MapFile_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapData.internal_static_xpilot_sr_proto_MapFile_fieldAccessorTable.ensureFieldAccessorsInitialized(MapFile.class, Builder.class);
        }

        @Override // xpilot.sr.proto.MapData.MapFileOrBuilder
        public String getFname() {
            Object obj = this.fname_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fname_ = stringUtf8;
            return stringUtf8;
        }

        @Override // xpilot.sr.proto.MapData.MapFileOrBuilder
        public ByteString getFnameBytes() {
            Object obj = this.fname_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fname_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // xpilot.sr.proto.MapData.MapFileOrBuilder
        public long getFsize() {
            return this.fsize_;
        }

        @Override // xpilot.sr.proto.MapData.MapFileOrBuilder
        public ByteString getFbuf() {
            return this.fbuf_;
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
            if (!getFnameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.fname_);
            }
            long j = this.fsize_;
            if (j != 0) {
                codedOutputStream.writeUInt64(2, j);
            }
            if (!this.fbuf_.isEmpty()) {
                codedOutputStream.writeBytes(3, this.fbuf_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = getFnameBytes().isEmpty() ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.fname_);
            long j = this.fsize_;
            if (j != 0) {
                computeStringSize += CodedOutputStream.computeUInt64Size(2, j);
            }
            if (!this.fbuf_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeBytesSize(3, this.fbuf_);
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
            if (!(obj instanceof MapFile)) {
                return super.equals(obj);
            }
            MapFile mapFile = (MapFile) obj;
            return (((getFname().equals(mapFile.getFname())) && (getFsize() > mapFile.getFsize() ? 1 : (getFsize() == mapFile.getFsize() ? 0 : -1)) == 0) && getFbuf().equals(mapFile.getFbuf())) && this.unknownFields.equals(mapFile.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + getFname().hashCode()) * 37) + 2) * 53) + Internal.hashLong(getFsize())) * 37) + 3) * 53) + getFbuf().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static MapFile parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static MapFile parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MapFile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MapFile parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MapFile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MapFile parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MapFile parseFrom(InputStream inputStream) throws IOException {
            return (MapFile) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MapFile parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapFile) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MapFile parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MapFile) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MapFile parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapFile) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MapFile parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MapFile) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MapFile parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapFile) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MapFile mapFile) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(mapFile);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MapFileOrBuilder {
            private ByteString fbuf_;
            private Object fname_;
            private long fsize_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MapData.internal_static_xpilot_sr_proto_MapFile_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapData.internal_static_xpilot_sr_proto_MapFile_fieldAccessorTable.ensureFieldAccessorsInitialized(MapFile.class, Builder.class);
            }

            private Builder() {
                this.fname_ = "";
                this.fbuf_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.fname_ = "";
                this.fbuf_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MapFile.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.fname_ = "";
                this.fsize_ = 0L;
                this.fbuf_ = ByteString.EMPTY;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MapData.internal_static_xpilot_sr_proto_MapFile_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MapFile getDefaultInstanceForType() {
                return MapFile.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MapFile build() {
                MapFile buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MapFile buildPartial() {
                MapFile mapFile = new MapFile(this);
                mapFile.fname_ = this.fname_;
                mapFile.fsize_ = this.fsize_;
                mapFile.fbuf_ = this.fbuf_;
                onBuilt();
                return mapFile;
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
                if (message instanceof MapFile) {
                    return mergeFrom((MapFile) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(MapFile mapFile) {
                if (mapFile == MapFile.getDefaultInstance()) {
                    return this;
                }
                if (!mapFile.getFname().isEmpty()) {
                    this.fname_ = mapFile.fname_;
                    onChanged();
                }
                if (mapFile.getFsize() != 0) {
                    setFsize(mapFile.getFsize());
                }
                if (mapFile.getFbuf() != ByteString.EMPTY) {
                    setFbuf(mapFile.getFbuf());
                }
                mergeUnknownFields(mapFile.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.MapData.MapFile.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.MapData.MapFile.access$1000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.MapData$MapFile r3 = (xpilot.sr.proto.MapData.MapFile) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.MapData$MapFile r4 = (xpilot.sr.proto.MapData.MapFile) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.MapData.MapFile.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.MapData$MapFile$Builder");
            }

            @Override // xpilot.sr.proto.MapData.MapFileOrBuilder
            public String getFname() {
                Object obj = this.fname_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.fname_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // xpilot.sr.proto.MapData.MapFileOrBuilder
            public ByteString getFnameBytes() {
                Object obj = this.fname_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.fname_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setFname(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.fname_ = str;
                onChanged();
                return this;
            }

            public Builder clearFname() {
                this.fname_ = MapFile.getDefaultInstance().getFname();
                onChanged();
                return this;
            }

            public Builder setFnameBytes(ByteString byteString) {
                if (byteString != null) {
                    MapFile.checkByteStringIsUtf8(byteString);
                    this.fname_ = byteString;
                    onChanged();
                    return this;
                }
                throw new NullPointerException();
            }

            @Override // xpilot.sr.proto.MapData.MapFileOrBuilder
            public long getFsize() {
                return this.fsize_;
            }

            public Builder setFsize(long j) {
                this.fsize_ = j;
                onChanged();
                return this;
            }

            public Builder clearFsize() {
                this.fsize_ = 0L;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.MapData.MapFileOrBuilder
            public ByteString getFbuf() {
                return this.fbuf_;
            }

            public Builder setFbuf(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.fbuf_ = byteString;
                onChanged();
                return this;
            }

            public Builder clearFbuf() {
                this.fbuf_ = MapFile.getDefaultInstance().getFbuf();
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

        public static MapFile getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MapFile> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MapFile> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MapFile getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class ApMapFile extends GeneratedMessageV3 implements ApMapFileOrBuilder {
        public static final int FILE_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private MapFile file_;
        private byte memoizedIsInitialized;
        private int type_;
        private static final ApMapFile DEFAULT_INSTANCE = new ApMapFile();
        private static final Parser<ApMapFile> PARSER = new AbstractParser<ApMapFile>() { // from class: xpilot.sr.proto.MapData.ApMapFile.1
            @Override // com.google.protobuf.Parser
            public ApMapFile parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ApMapFile(codedInputStream, extensionRegistryLite);
            }
        };

        private ApMapFile(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private ApMapFile() {
            this.memoizedIsInitialized = (byte) -1;
            this.type_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ApMapFile(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.type_ = codedInputStream.readEnum();
                                } else if (readTag == 18) {
                                    MapFile.Builder builder = this.file_ != null ? this.file_.toBuilder() : null;
                                    this.file_ = (MapFile) codedInputStream.readMessage(MapFile.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.file_);
                                        this.file_ = builder.buildPartial();
                                    }
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
            return MapData.internal_static_xpilot_sr_proto_ApMapFile_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapData.internal_static_xpilot_sr_proto_ApMapFile_fieldAccessorTable.ensureFieldAccessorsInitialized(ApMapFile.class, Builder.class);
        }

        /* loaded from: classes4.dex */
        public enum EnumMapType implements ProtocolMessageEnum {
            EnumMapType_PKMAP(0),
            EnumMapType_TRAINMAP(1),
            UNRECOGNIZED(-1);
            
            public static final int EnumMapType_PKMAP_VALUE = 0;
            public static final int EnumMapType_TRAINMAP_VALUE = 1;
            private final int value;
            private static final Internal.EnumLiteMap<EnumMapType> internalValueMap = new Internal.EnumLiteMap<EnumMapType>() { // from class: xpilot.sr.proto.MapData.ApMapFile.EnumMapType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public EnumMapType findValueByNumber(int i) {
                    return EnumMapType.forNumber(i);
                }
            };
            private static final EnumMapType[] VALUES = values();

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                }
                return this.value;
            }

            @Deprecated
            public static EnumMapType valueOf(int i) {
                return forNumber(i);
            }

            public static EnumMapType forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        return null;
                    }
                    return EnumMapType_TRAINMAP;
                }
                return EnumMapType_PKMAP;
            }

            public static Internal.EnumLiteMap<EnumMapType> internalGetValueMap() {
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
                return ApMapFile.getDescriptor().getEnumTypes().get(0);
            }

            public static EnumMapType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }

            EnumMapType(int i) {
                this.value = i;
            }
        }

        @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
        public EnumMapType getType() {
            EnumMapType valueOf = EnumMapType.valueOf(this.type_);
            return valueOf == null ? EnumMapType.UNRECOGNIZED : valueOf;
        }

        @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
        public boolean hasFile() {
            return this.file_ != null;
        }

        @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
        public MapFile getFile() {
            MapFile mapFile = this.file_;
            return mapFile == null ? MapFile.getDefaultInstance() : mapFile;
        }

        @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
        public MapFileOrBuilder getFileOrBuilder() {
            return getFile();
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
            if (this.type_ != EnumMapType.EnumMapType_PKMAP.getNumber()) {
                codedOutputStream.writeEnum(1, this.type_);
            }
            if (this.file_ != null) {
                codedOutputStream.writeMessage(2, getFile());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.type_ != EnumMapType.EnumMapType_PKMAP.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.type_) : 0;
            if (this.file_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, getFile());
            }
            int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ApMapFile)) {
                return super.equals(obj);
            }
            ApMapFile apMapFile = (ApMapFile) obj;
            boolean z = (this.type_ == apMapFile.type_) && hasFile() == apMapFile.hasFile();
            if (hasFile()) {
                z = z && getFile().equals(apMapFile.getFile());
            }
            return z && this.unknownFields.equals(apMapFile.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + this.type_;
            if (hasFile()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getFile().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static ApMapFile parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ApMapFile parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ApMapFile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ApMapFile parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ApMapFile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ApMapFile parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ApMapFile parseFrom(InputStream inputStream) throws IOException {
            return (ApMapFile) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ApMapFile parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ApMapFile) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ApMapFile parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ApMapFile) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ApMapFile parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ApMapFile) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ApMapFile parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ApMapFile) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ApMapFile parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ApMapFile) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ApMapFile apMapFile) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(apMapFile);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApMapFileOrBuilder {
            private SingleFieldBuilderV3<MapFile, MapFile.Builder, MapFileOrBuilder> fileBuilder_;
            private MapFile file_;
            private int type_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MapData.internal_static_xpilot_sr_proto_ApMapFile_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapData.internal_static_xpilot_sr_proto_ApMapFile_fieldAccessorTable.ensureFieldAccessorsInitialized(ApMapFile.class, Builder.class);
            }

            private Builder() {
                this.type_ = 0;
                this.file_ = null;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                this.file_ = null;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ApMapFile.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.type_ = 0;
                if (this.fileBuilder_ == null) {
                    this.file_ = null;
                } else {
                    this.file_ = null;
                    this.fileBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MapData.internal_static_xpilot_sr_proto_ApMapFile_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ApMapFile getDefaultInstanceForType() {
                return ApMapFile.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ApMapFile build() {
                ApMapFile buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ApMapFile buildPartial() {
                ApMapFile apMapFile = new ApMapFile(this);
                apMapFile.type_ = this.type_;
                SingleFieldBuilderV3<MapFile, MapFile.Builder, MapFileOrBuilder> singleFieldBuilderV3 = this.fileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    apMapFile.file_ = this.file_;
                } else {
                    apMapFile.file_ = singleFieldBuilderV3.build();
                }
                onBuilt();
                return apMapFile;
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
                if (message instanceof ApMapFile) {
                    return mergeFrom((ApMapFile) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ApMapFile apMapFile) {
                if (apMapFile == ApMapFile.getDefaultInstance()) {
                    return this;
                }
                if (apMapFile.type_ != 0) {
                    setTypeValue(apMapFile.getTypeValue());
                }
                if (apMapFile.hasFile()) {
                    mergeFile(apMapFile.getFile());
                }
                mergeUnknownFields(apMapFile.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.MapData.ApMapFile.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.MapData.ApMapFile.access$2200()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.MapData$ApMapFile r3 = (xpilot.sr.proto.MapData.ApMapFile) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.MapData$ApMapFile r4 = (xpilot.sr.proto.MapData.ApMapFile) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.MapData.ApMapFile.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.MapData$ApMapFile$Builder");
            }

            @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
            public EnumMapType getType() {
                EnumMapType valueOf = EnumMapType.valueOf(this.type_);
                return valueOf == null ? EnumMapType.UNRECOGNIZED : valueOf;
            }

            public Builder setType(EnumMapType enumMapType) {
                if (enumMapType == null) {
                    throw new NullPointerException();
                }
                this.type_ = enumMapType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
            public boolean hasFile() {
                return (this.fileBuilder_ == null && this.file_ == null) ? false : true;
            }

            @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
            public MapFile getFile() {
                SingleFieldBuilderV3<MapFile, MapFile.Builder, MapFileOrBuilder> singleFieldBuilderV3 = this.fileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MapFile mapFile = this.file_;
                    return mapFile == null ? MapFile.getDefaultInstance() : mapFile;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setFile(MapFile mapFile) {
                SingleFieldBuilderV3<MapFile, MapFile.Builder, MapFileOrBuilder> singleFieldBuilderV3 = this.fileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(mapFile);
                } else if (mapFile == null) {
                    throw new NullPointerException();
                } else {
                    this.file_ = mapFile;
                    onChanged();
                }
                return this;
            }

            public Builder setFile(MapFile.Builder builder) {
                SingleFieldBuilderV3<MapFile, MapFile.Builder, MapFileOrBuilder> singleFieldBuilderV3 = this.fileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.file_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder mergeFile(MapFile mapFile) {
                SingleFieldBuilderV3<MapFile, MapFile.Builder, MapFileOrBuilder> singleFieldBuilderV3 = this.fileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MapFile mapFile2 = this.file_;
                    if (mapFile2 != null) {
                        this.file_ = MapFile.newBuilder(mapFile2).mergeFrom(mapFile).buildPartial();
                    } else {
                        this.file_ = mapFile;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(mapFile);
                }
                return this;
            }

            public Builder clearFile() {
                if (this.fileBuilder_ == null) {
                    this.file_ = null;
                    onChanged();
                } else {
                    this.file_ = null;
                    this.fileBuilder_ = null;
                }
                return this;
            }

            public MapFile.Builder getFileBuilder() {
                onChanged();
                return getFileFieldBuilder().getBuilder();
            }

            @Override // xpilot.sr.proto.MapData.ApMapFileOrBuilder
            public MapFileOrBuilder getFileOrBuilder() {
                SingleFieldBuilderV3<MapFile, MapFile.Builder, MapFileOrBuilder> singleFieldBuilderV3 = this.fileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MapFile mapFile = this.file_;
                return mapFile == null ? MapFile.getDefaultInstance() : mapFile;
            }

            private SingleFieldBuilderV3<MapFile, MapFile.Builder, MapFileOrBuilder> getFileFieldBuilder() {
                if (this.fileBuilder_ == null) {
                    this.fileBuilder_ = new SingleFieldBuilderV3<>(getFile(), getParentForChildren(), isClean());
                    this.file_ = null;
                }
                return this.fileBuilder_;
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

        public static ApMapFile getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ApMapFile> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ApMapFile> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ApMapFile getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000emap_data.proto\u0012\u000fxpilot.sr.proto\"5\n\u0007MapFile\u0012\r\n\u0005fname\u0018\u0001 \u0001(\t\u0012\r\n\u0005fsize\u0018\u0002 \u0001(\u0004\u0012\f\n\u0004fbuf\u0018\u0003 \u0001(\f\"©\u0001\n\tApMapFile\u00124\n\u0004type\u0018\u0001 \u0001(\u000e2&.xpilot.sr.proto.ApMapFile.EnumMapType\u0012&\n\u0004file\u0018\u0002 \u0001(\u000b2\u0018.xpilot.sr.proto.MapFile\">\n\u000bEnumMapType\u0012\u0015\n\u0011EnumMapType_PKMAP\u0010\u0000\u0012\u0018\n\u0014EnumMapType_TRAINMAP\u0010\u0001b\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.MapData.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = MapData.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_MapFile_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_MapFile_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_MapFile_descriptor, new String[]{"Fname", "Fsize", "Fbuf"});
        internal_static_xpilot_sr_proto_ApMapFile_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_xpilot_sr_proto_ApMapFile_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_ApMapFile_descriptor, new String[]{"Type", "File"});
    }
}
