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
import com.google.protobuf.UnknownFieldSet;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class Imudata {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_xpilot_sr_proto_ImuInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_xpilot_sr_proto_ImuInfo_fieldAccessorTable;

    /* loaded from: classes4.dex */
    public interface ImuInfoOrBuilder extends MessageOrBuilder {
        float getImusysst(int i);

        int getImusysstCount();

        List<Float> getImusysstList();

        long getTime();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Imudata() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    /* loaded from: classes4.dex */
    public static final class ImuInfo extends GeneratedMessageV3 implements ImuInfoOrBuilder {
        public static final int IMUSYSST_FIELD_NUMBER = 2;
        public static final int TIME_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int imusysstMemoizedSerializedSize;
        private List<Float> imusysst_;
        private byte memoizedIsInitialized;
        private long time_;
        private static final ImuInfo DEFAULT_INSTANCE = new ImuInfo();
        private static final Parser<ImuInfo> PARSER = new AbstractParser<ImuInfo>() { // from class: xpilot.sr.proto.Imudata.ImuInfo.1
            @Override // com.google.protobuf.Parser
            public ImuInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ImuInfo(codedInputStream, extensionRegistryLite);
            }
        };

        private ImuInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.imusysstMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private ImuInfo() {
            this.imusysstMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.time_ = 0L;
            this.imusysst_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ImuInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.time_ = codedInputStream.readUInt64();
                            } else if (readTag == 18) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.imusysst_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.imusysst_.add(Float.valueOf(codedInputStream.readFloat()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 21) {
                                if (!(z2 & true)) {
                                    this.imusysst_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.imusysst_.add(Float.valueOf(codedInputStream.readFloat()));
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
                        this.imusysst_ = Collections.unmodifiableList(this.imusysst_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Imudata.internal_static_xpilot_sr_proto_ImuInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Imudata.internal_static_xpilot_sr_proto_ImuInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ImuInfo.class, Builder.class);
        }

        @Override // xpilot.sr.proto.Imudata.ImuInfoOrBuilder
        public long getTime() {
            return this.time_;
        }

        @Override // xpilot.sr.proto.Imudata.ImuInfoOrBuilder
        public List<Float> getImusysstList() {
            return this.imusysst_;
        }

        @Override // xpilot.sr.proto.Imudata.ImuInfoOrBuilder
        public int getImusysstCount() {
            return this.imusysst_.size();
        }

        @Override // xpilot.sr.proto.Imudata.ImuInfoOrBuilder
        public float getImusysst(int i) {
            return this.imusysst_.get(i).floatValue();
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
            long j = this.time_;
            if (j != 0) {
                codedOutputStream.writeUInt64(1, j);
            }
            if (getImusysstList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(18);
                codedOutputStream.writeUInt32NoTag(this.imusysstMemoizedSerializedSize);
            }
            for (int i = 0; i < this.imusysst_.size(); i++) {
                codedOutputStream.writeFloatNoTag(this.imusysst_.get(i).floatValue());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.time_;
            int computeUInt64Size = j != 0 ? 0 + CodedOutputStream.computeUInt64Size(1, j) : 0;
            int size = getImusysstList().size() * 4;
            int i2 = computeUInt64Size + size;
            if (!getImusysstList().isEmpty()) {
                i2 = i2 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.imusysstMemoizedSerializedSize = size;
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ImuInfo)) {
                return super.equals(obj);
            }
            ImuInfo imuInfo = (ImuInfo) obj;
            return (((getTime() > imuInfo.getTime() ? 1 : (getTime() == imuInfo.getTime() ? 0 : -1)) == 0) && getImusysstList().equals(imuInfo.getImusysstList())) && this.unknownFields.equals(imuInfo.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((BLParams.RouteOverlayRangeOnMap + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getTime());
            if (getImusysstCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getImusysstList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static ImuInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ImuInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ImuInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ImuInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ImuInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ImuInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ImuInfo parseFrom(InputStream inputStream) throws IOException {
            return (ImuInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ImuInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImuInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ImuInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ImuInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ImuInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImuInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ImuInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ImuInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ImuInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImuInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ImuInfo imuInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(imuInfo);
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
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ImuInfoOrBuilder {
            private int bitField0_;
            private List<Float> imusysst_;
            private long time_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Imudata.internal_static_xpilot_sr_proto_ImuInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Imudata.internal_static_xpilot_sr_proto_ImuInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ImuInfo.class, Builder.class);
            }

            private Builder() {
                this.imusysst_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.imusysst_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ImuInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.time_ = 0L;
                this.imusysst_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Imudata.internal_static_xpilot_sr_proto_ImuInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ImuInfo getDefaultInstanceForType() {
                return ImuInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ImuInfo build() {
                ImuInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ImuInfo buildPartial() {
                ImuInfo imuInfo = new ImuInfo(this);
                int i = this.bitField0_;
                imuInfo.time_ = this.time_;
                if ((this.bitField0_ & 2) == 2) {
                    this.imusysst_ = Collections.unmodifiableList(this.imusysst_);
                    this.bitField0_ &= -3;
                }
                imuInfo.imusysst_ = this.imusysst_;
                imuInfo.bitField0_ = 0;
                onBuilt();
                return imuInfo;
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
                if (message instanceof ImuInfo) {
                    return mergeFrom((ImuInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ImuInfo imuInfo) {
                if (imuInfo == ImuInfo.getDefaultInstance()) {
                    return this;
                }
                if (imuInfo.getTime() != 0) {
                    setTime(imuInfo.getTime());
                }
                if (!imuInfo.imusysst_.isEmpty()) {
                    if (this.imusysst_.isEmpty()) {
                        this.imusysst_ = imuInfo.imusysst_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureImusysstIsMutable();
                        this.imusysst_.addAll(imuInfo.imusysst_);
                    }
                    onChanged();
                }
                mergeUnknownFields(imuInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public xpilot.sr.proto.Imudata.ImuInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = xpilot.sr.proto.Imudata.ImuInfo.access$1000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    xpilot.sr.proto.Imudata$ImuInfo r3 = (xpilot.sr.proto.Imudata.ImuInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    xpilot.sr.proto.Imudata$ImuInfo r4 = (xpilot.sr.proto.Imudata.ImuInfo) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: xpilot.sr.proto.Imudata.ImuInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):xpilot.sr.proto.Imudata$ImuInfo$Builder");
            }

            @Override // xpilot.sr.proto.Imudata.ImuInfoOrBuilder
            public long getTime() {
                return this.time_;
            }

            public Builder setTime(long j) {
                this.time_ = j;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0L;
                onChanged();
                return this;
            }

            private void ensureImusysstIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.imusysst_ = new ArrayList(this.imusysst_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // xpilot.sr.proto.Imudata.ImuInfoOrBuilder
            public List<Float> getImusysstList() {
                return Collections.unmodifiableList(this.imusysst_);
            }

            @Override // xpilot.sr.proto.Imudata.ImuInfoOrBuilder
            public int getImusysstCount() {
                return this.imusysst_.size();
            }

            @Override // xpilot.sr.proto.Imudata.ImuInfoOrBuilder
            public float getImusysst(int i) {
                return this.imusysst_.get(i).floatValue();
            }

            public Builder setImusysst(int i, float f) {
                ensureImusysstIsMutable();
                this.imusysst_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addImusysst(float f) {
                ensureImusysstIsMutable();
                this.imusysst_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public Builder addAllImusysst(Iterable<? extends Float> iterable) {
                ensureImusysstIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.imusysst_);
                onChanged();
                return this;
            }

            public Builder clearImusysst() {
                this.imusysst_ = Collections.emptyList();
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

        public static ImuInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ImuInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ImuInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ImuInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rimudata.proto\u0012\u000fxpilot.sr.proto\")\n\u0007ImuInfo\u0012\f\n\u0004time\u0018\u0001 \u0001(\u0004\u0012\u0010\n\bimusysst\u0018\u0002 \u0003(\u0002b\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: xpilot.sr.proto.Imudata.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Imudata.descriptor = fileDescriptor;
                return null;
            }
        });
        internal_static_xpilot_sr_proto_ImuInfo_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_xpilot_sr_proto_ImuInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_xpilot_sr_proto_ImuInfo_descriptor, new String[]{"Time", "Imusysst"});
    }
}
