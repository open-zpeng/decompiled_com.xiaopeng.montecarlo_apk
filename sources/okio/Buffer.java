package okio;

import com.autonavi.gbl.pos.model.LocTrafficSignType;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.compress.archivers.tar.TarConstants;
/* loaded from: classes3.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    Segment head;
    long size;

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public long size() {
        return this.size;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.writeByte((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.write(bArr, i, i2);
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }
        };
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.2
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.read(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    public Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    public Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        int i;
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (j >= segment.limit - segment.pos) {
            j -= segment.limit - segment.pos;
            segment = segment.next;
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.limit - i, j2);
            outputStream.write(segment.data, (int) (segment.pos + j), min);
            j2 -= min;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    public Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.size += j2;
        Segment segment = this.head;
        while (j >= segment.limit - segment.pos) {
            j -= segment.limit - segment.pos;
            segment = segment.next;
        }
        while (j2 > 0) {
            Segment sharedCopy = segment.sharedCopy();
            sharedCopy.pos = (int) (sharedCopy.pos + j);
            sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j2), sharedCopy.limit);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer.head = sharedCopy;
            } else {
                segment2.prev.push(sharedCopy);
            }
            j2 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    public Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0L, j);
        Segment segment = this.head;
        while (j > 0) {
            int min = (int) Math.min(j, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j2 = min;
            this.size -= j2;
            j -= j2;
            if (segment.pos == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    public Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        readFrom(inputStream, j, false);
        return this;
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment writableSegment = writableSegment(1);
            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, 8192 - writableSegment.limit));
            if (read == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment.limit += read;
            long j2 = read;
            this.size += j2;
            j -= j2;
        }
    }

    public long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        return (segment.limit >= 8192 || !segment.owner) ? j : j - (segment.limit - segment.pos);
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        this.size--;
        if (i3 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b;
    }

    public byte getByte(long j) {
        Util.checkOffsetAndCount(this.size, j, 1L);
        long j2 = this.size;
        if (j2 - j > j) {
            Segment segment = this.head;
            while (true) {
                long j3 = segment.limit - segment.pos;
                if (j >= j3) {
                    j -= j3;
                    segment = segment.next;
                } else {
                    return segment.data[segment.pos + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                j4 += segment2.limit - segment2.pos;
            } while (j4 < 0);
            return segment2.data[segment2.pos + ((int) j4)];
        }
    }

    @Override // okio.BufferedSource
    public short readShort() {
        if (this.size < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.size -= 2;
        if (i4 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) i5;
    }

    @Override // okio.BufferedSource
    public int readInt() {
        if (this.size < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.size -= 4;
        if (i8 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i8;
        }
        return i9;
    }

    @Override // okio.BufferedSource
    public long readLong() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.size < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int i8 = segment.pos;
        int i9 = segment.limit;
        if (i9 - i8 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.data;
        int i10 = i8 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        long j = (bArr[i7] & 255) | ((bArr[i8] & 255) << 56) | ((bArr[i] & 255) << 48) | ((bArr[i2] & 255) << 40) | ((bArr[i3] & 255) << 32) | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8);
        this.size -= 8;
        if (i10 == i9) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i10;
        }
        return j;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ab A[EDGE_INSN: B:45:0x00ab->B:38:0x00ab ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto Lb6
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = r7
            r6 = r5
        L10:
            okio.Segment r10 = r0.head
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L18:
            if (r12 >= r13) goto L97
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L69
            r1 = 57
            if (r15 > r1) goto L69
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3c
            if (r16 != 0) goto L36
            long r1 = (long) r14
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 >= 0) goto L36
            goto L3c
        L36:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L73
        L3c:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong(r3)
            okio.Buffer r1 = r1.writeByte(r15)
            if (r5 != 0) goto L4e
            r1.readByte()
        L4e:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L69:
            r1 = 45
            if (r15 != r1) goto L78
            if (r7 != 0) goto L78
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L73:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L18
        L78:
            if (r7 == 0) goto L7c
            r6 = 1
            goto L97
        L7c:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L97:
            if (r12 != r13) goto La3
            okio.Segment r1 = r10.pop()
            r0.head = r1
            okio.SegmentPool.recycle(r10)
            goto La5
        La3:
            r10.pos = r12
        La5:
            if (r6 != 0) goto Lab
            okio.Segment r1 = r0.head
            if (r1 != 0) goto L10
        Lab:
            long r1 = r0.size
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.size = r1
            if (r5 == 0) goto Lb4
            goto Lb5
        Lb4:
            long r3 = -r3
        Lb5:
            return r3
        Lb6:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5 A[EDGE_INSN: B:42:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r14 = this;
            long r0 = r14.size
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lac
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            okio.Segment r6 = r14.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L13
        L4a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r1 == 0) goto L76
            r0 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            okio.Segment r7 = r6.pop()
            r14.head = r7
            okio.SegmentPool.recycle(r6)
            goto L9f
        L9d:
            r6.pos = r8
        L9f:
            if (r0 != 0) goto La5
            okio.Segment r6 = r14.head
            if (r6 != 0) goto Lb
        La5:
            long r2 = r14.size
            long r0 = (long) r1
            long r2 = r2 - r0
            r14.size = r2
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        Segment segment = this.head;
        if (segment == null) {
            return options.indexOf(ByteString.EMPTY);
        }
        ByteString[] byteStringArr = options.byteStrings;
        int length = byteStringArr.length;
        for (int i = 0; i < length; i++) {
            ByteString byteString = byteStringArr[i];
            if (this.size >= byteString.size() && rangeEquals(segment, segment.pos, byteString, 0, byteString.size())) {
                try {
                    skip(byteString.size());
                    return i;
                } catch (EOFException e) {
                    throw new AssertionError(e);
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int selectPrefix(Options options) {
        Segment segment = this.head;
        ByteString[] byteStringArr = options.byteStrings;
        int length = byteStringArr.length;
        for (int i = 0; i < length; i++) {
            ByteString byteString = byteStringArr[i];
            int min = (int) Math.min(this.size, byteString.size());
            if (min == 0 || rangeEquals(segment, segment.pos, byteString, 0, min)) {
                return i;
            }
        }
        return -1;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 < j) {
            buffer.write(this, j2);
            throw new EOFException();
        } else {
            buffer.write(this, j);
        }
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, Util.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                Segment segment = this.head;
                if (segment.pos + j > segment.limit) {
                    return new String(readByteArray(j), charset);
                }
                String str = new String(segment.data, segment.pos, (int) j, charset);
                segment.pos = (int) (segment.pos + j);
                this.size -= j;
                if (segment.pos == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            long j = this.size;
            if (j != 0) {
                return readUtf8(j);
            }
            return null;
        }
        return readUtf8Line(indexOf);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long indexOf = indexOf((byte) 10, 0L, j2);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return readUtf8Line(j2);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String readUtf8Line(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String readUtf8 = readUtf8(j2);
                skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j);
        skip(1L);
        return readUtf82;
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.size == 0) {
            throw new EOFException();
        }
        byte b = getByte(0L);
        if ((b & 128) == 0) {
            i = b & Byte.MAX_VALUE;
            i3 = 0;
            i2 = 1;
        } else if ((b & 224) == 192) {
            i = b & 31;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & 15;
            i2 = 3;
            i3 = 2048;
        } else if ((b & 248) != 240) {
            skip(1L);
            return REPLACEMENT_CHARACTER;
        } else {
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.size < j) {
            throw new EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = getByte(j2);
            if ((b2 & 192) != 128) {
                skip(j2);
                return REPLACEMENT_CHARACTER;
            }
            i = (i << 6) | (b2 & 63);
        }
        skip(j);
        return i > 1114111 ? REPLACEMENT_CHARACTER : ((i < 55296 || i > 57343) && i >= i3) ? i : REPLACEMENT_CHARACTER;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        Util.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i, min);
        segment.pos += min;
        this.size -= min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        segment.pos += min;
        this.size -= min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        Segment segment;
        while (j > 0) {
            if (this.head == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, segment.limit - this.head.pos);
            long j2 = min;
            this.size -= j2;
            j -= j2;
            this.head.pos += min;
            if (this.head.pos == this.head.limit) {
                Segment segment2 = this.head;
                this.head = segment2.pop();
                SegmentPool.recycle(segment2);
            }
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        Segment writableSegment = writableSegment(1);
                        byte[] bArr = writableSegment.data;
                        int i3 = writableSegment.limit - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                        while (i4 < min) {
                            char charAt2 = str.charAt(i4);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i4 + i3] = (byte) charAt2;
                            i4++;
                        }
                        int i5 = (i3 + i4) - writableSegment.limit;
                        writableSegment.limit += i5;
                        this.size += i5;
                        i = i4;
                    } else {
                        if (charAt < 2048) {
                            writeByte((charAt >> 6) | 192);
                            writeByte((charAt & '?') | 128);
                        } else if (charAt < 55296 || charAt > 57343) {
                            writeByte((charAt >> '\f') | LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_HONKING);
                            writeByte(((charAt >> 6) & 63) | 128);
                            writeByte((charAt & '?') | 128);
                        } else {
                            int i6 = i + 1;
                            char charAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                            if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                writeByte(63);
                                i = i6;
                            } else {
                                int i7 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i7 >> 18) | RouteChargeDecorator.TYPE_SELECTED_KEEPER);
                                writeByte(((i7 >> 12) & 63) | 128);
                                writeByte(((i7 >> 6) & 63) | 128);
                                writeByte((i7 & 63) | 128);
                                i += 2;
                            }
                        }
                        i++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                writeByte(63);
            } else {
                writeByte((i >> 12) | LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_HONKING);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | RouteChargeDecorator.TYPE_SELECTED_KEEPER);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 <= str.length()) {
                if (charset == null) {
                    throw new IllegalArgumentException("charset == null");
                }
                if (charset.equals(Util.UTF_8)) {
                    return writeUtf8(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return write(bytes, 0, bytes.length);
            } else {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return write(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment = writableSegment(1);
            int min = Math.min(i3 - i, 8192 - writableSegment.limit);
            System.arraycopy(bArr, i, writableSegment.data, writableSegment.limit, min);
            i += min;
            writableSegment.limit += min;
        }
        this.size += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            Segment writableSegment = writableSegment(1);
            int min = Math.min(i, 8192 - writableSegment.limit);
            byteBuffer.get(writableSegment.data, writableSegment.limit, min);
            i -= min;
            writableSegment.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        writableSegment.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment.limit = i3 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytesShort((short) i));
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment.limit = i5 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        writableSegment.limit = i8 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= NavRestoreManager.WAKELOCK_TIMEOUT_10SEC) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment = writableSegment(i2);
        byte[] bArr = writableSegment.data;
        int i3 = writableSegment.limit + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        writableSegment.limit += i2;
        this.size += i2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        for (int i2 = (writableSegment.limit + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += numberOfTrailingZeros;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment writableSegment(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment == null) {
            this.head = SegmentPool.take();
            Segment segment2 = this.head;
            segment2.prev = segment2;
            segment2.next = segment2;
            return segment2;
        }
        Segment segment3 = segment.prev;
        return (segment3.limit + i > 8192 || !segment3.owner) ? segment3.push(SegmentPool.take()) : segment3;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            if (j < buffer.head.limit - buffer.head.pos) {
                Segment segment = this.head;
                Segment segment2 = segment != null ? segment.prev : null;
                if (segment2 != null && segment2.owner) {
                    if ((segment2.limit + j) - (segment2.shared ? 0 : segment2.pos) <= 8192) {
                        buffer.head.writeTo(segment2, (int) j);
                        buffer.size -= j;
                        this.size += j;
                        return;
                    }
                }
                buffer.head = buffer.head.split((int) j);
            }
            Segment segment3 = buffer.head;
            long j2 = segment3.limit - segment3.pos;
            buffer.head = segment3.pop();
            Segment segment4 = this.head;
            if (segment4 == null) {
                this.head = segment3;
                Segment segment5 = this.head;
                segment5.prev = segment5;
                segment5.next = segment5;
            } else {
                segment4.prev.push(segment3).compact();
            }
            buffer.size -= j2;
            this.size += j2;
            j -= j2;
        }
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2 = this.size;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.size;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (segment = this.head) == null) {
            return -1L;
        }
        long j5 = this.size;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = (segment.limit - segment.pos) + j5;
                if (j3 >= j) {
                    break;
                }
                segment = segment.next;
            }
        } else {
            while (j5 > j) {
                segment = segment.prev;
                j5 -= segment.limit - segment.pos;
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = segment.data;
            int min = (int) Math.min(segment.limit, (segment.pos + j4) - j5);
            for (int i = (int) ((segment.pos + j6) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - segment.pos) + j5;
                }
            }
            j6 = (segment.limit - segment.pos) + j5;
            segment = segment.next;
            j5 = j6;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        byte[] bArr;
        Segment segment;
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j < 0) {
                throw new IllegalArgumentException("fromIndex < 0");
            }
            Segment segment2 = this.head;
            long j3 = -1;
            if (segment2 == null) {
                return -1L;
            }
            long j4 = this.size;
            if (j4 - j >= j) {
                while (true) {
                    j4 = j2;
                    j2 = (segment2.limit - segment2.pos) + j4;
                    if (j2 >= j) {
                        break;
                    }
                    segment2 = segment2.next;
                }
            } else {
                while (j4 > j) {
                    segment2 = segment2.prev;
                    j4 -= segment2.limit - segment2.pos;
                }
            }
            byte b = byteString.getByte(0);
            int size = byteString.size();
            long j5 = 1 + (this.size - size);
            long j6 = j;
            Segment segment3 = segment2;
            long j7 = j4;
            while (j7 < j5) {
                byte[] bArr2 = segment3.data;
                int min = (int) Math.min(segment3.limit, (segment3.pos + j5) - j7);
                int i = (int) ((segment3.pos + j6) - j7);
                while (i < min) {
                    if (bArr2[i] == b) {
                        bArr = bArr2;
                        segment = segment3;
                        if (rangeEquals(segment3, i + 1, byteString, 1, size)) {
                            return (i - segment.pos) + j7;
                        }
                    } else {
                        bArr = bArr2;
                        segment = segment3;
                    }
                    i++;
                    segment3 = segment;
                    bArr2 = bArr;
                }
                Segment segment4 = segment3;
                j6 = (segment4.limit - segment4.pos) + j7;
                segment3 = segment4.next;
                j3 = -1;
                j7 = j6;
            }
            return j3;
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.size;
        if (j3 - j >= j) {
            while (true) {
                j3 = j2;
                j2 = (segment.limit - segment.pos) + j3;
                if (j2 >= j) {
                    break;
                }
                segment = segment.next;
            }
        } else {
            while (j3 > j) {
                segment = segment.prev;
                j3 -= segment.limit - segment.pos;
            }
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j3 < this.size) {
                byte[] bArr = segment.data;
                i = (int) ((segment.pos + j) - j3);
                int i3 = segment.limit;
                while (i < i3) {
                    byte b3 = bArr[i];
                    if (b3 == b || b3 == b2) {
                        i2 = segment.pos;
                        return (i - i2) + j3;
                    }
                    i++;
                }
                j = (segment.limit - segment.pos) + j3;
                segment = segment.next;
                j3 = j;
            }
            return -1L;
        }
        byte[] internalArray = byteString.internalArray();
        while (j3 < this.size) {
            byte[] bArr2 = segment.data;
            i = (int) ((segment.pos + j) - j3);
            int i4 = segment.limit;
            while (i < i4) {
                byte b4 = bArr2[i];
                for (byte b5 : internalArray) {
                    if (b4 == b5) {
                        i2 = segment.pos;
                        return (i - i2) + j3;
                    }
                }
                i++;
            }
            j = (segment.limit - segment.pos) + j3;
            segment = segment.next;
            j3 = j;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean rangeEquals(Segment segment, int i, ByteString byteString, int i2, int i3) {
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        }
    }

    public ByteString md5() {
        return digest("MD5");
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public ByteString sha512() {
        return digest("SHA-512");
    }

    private ByteString digest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (this.head != null) {
                messageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                Segment segment = this.head;
                while (true) {
                    segment = segment.next;
                    if (segment == this.head) {
                        break;
                    }
                    messageDigest.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            if (this.head != null) {
                mac.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                Segment segment = this.head;
                while (true) {
                    segment = segment.next;
                    if (segment == this.head) {
                        break;
                    }
                    mac.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j = this.size;
            if (j != buffer.size) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            Segment segment = this.head;
            Segment segment2 = buffer.head;
            int i = segment.pos;
            int i2 = segment2.pos;
            while (j2 < this.size) {
                long min = Math.min(segment.limit - i, segment2.limit - i2);
                int i3 = i2;
                int i4 = i;
                int i5 = 0;
                while (i5 < min) {
                    int i6 = i4 + 1;
                    int i7 = i3 + 1;
                    if (segment.data[i4] != segment2.data[i3]) {
                        return false;
                    }
                    i5++;
                    i4 = i6;
                    i3 = i7;
                }
                if (i4 == segment.limit) {
                    segment = segment.next;
                    i = segment.pos;
                } else {
                    i = i4;
                }
                if (i3 == segment2.limit) {
                    segment2 = segment2.next;
                    i2 = segment2.pos;
                } else {
                    i2 = i3;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i;
    }

    public String toString() {
        return snapshot().toString();
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        buffer.head = this.head.sharedCopy();
        Segment segment = buffer.head;
        segment.prev = segment;
        segment.next = segment;
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 != this.head) {
                buffer.head.prev.push(segment2.sharedCopy());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public ByteString snapshot() {
        long j = this.size;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
        }
        return snapshot((int) j);
    }

    public ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i);
    }

    public UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    public UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    /* loaded from: classes3.dex */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        public int next() {
            if (this.offset == this.buffer.size) {
                throw new IllegalStateException();
            }
            long j = this.offset;
            return j == -1 ? seek(0L) : seek(j + (this.end - this.start));
        }

        public int seek(long j) {
            int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if (i < 0 || j > this.buffer.size) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.buffer.size)));
            }
            if (i == 0 || j == this.buffer.size) {
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long j2 = 0;
            long j3 = this.buffer.size;
            Segment segment = this.buffer.head;
            Segment segment2 = this.buffer.head;
            Segment segment3 = this.segment;
            if (segment3 != null) {
                long j4 = this.offset - (this.start - segment3.pos);
                if (j4 > j) {
                    segment2 = this.segment;
                    j3 = j4;
                } else {
                    segment = this.segment;
                    j2 = j4;
                }
            }
            if (j3 - j > j - j2) {
                while (j >= (segment.limit - segment.pos) + j2) {
                    j2 += segment.limit - segment.pos;
                    segment = segment.next;
                }
            } else {
                j2 = j3;
                segment = segment2;
                while (j2 > j) {
                    segment = segment.prev;
                    j2 -= segment.limit - segment.pos;
                }
            }
            if (this.readWrite && segment.shared) {
                Segment unsharedCopy = segment.unsharedCopy();
                if (this.buffer.head == segment) {
                    this.buffer.head = unsharedCopy;
                }
                segment = segment.push(unsharedCopy);
                segment.prev.pop();
            }
            this.segment = segment;
            this.offset = j;
            this.data = segment.data;
            this.start = segment.pos + ((int) (j - j2));
            this.end = segment.limit;
            return this.end - this.start;
        }

        public long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.size;
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i <= 0) {
                if (j < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j);
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 <= 0) {
                        break;
                    }
                    Segment segment = this.buffer.head.prev;
                    long j4 = segment.limit - segment.pos;
                    if (j4 <= j3) {
                        this.buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                        j3 -= j4;
                    } else {
                        segment.limit = (int) (segment.limit - j3);
                        break;
                    }
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (i > 0) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    Segment writableSegment = this.buffer.writableSegment(1);
                    int min = (int) Math.min(j5, 8192 - writableSegment.limit);
                    writableSegment.limit += min;
                    j5 -= min;
                    if (z) {
                        this.segment = writableSegment;
                        this.offset = j2;
                        this.data = writableSegment.data;
                        this.start = writableSegment.limit - min;
                        this.end = writableSegment.limit;
                        z = false;
                    }
                }
            }
            this.buffer.size = j;
            return j2;
        }

        public long expandBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i);
            } else if (i > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            } else {
                Buffer buffer = this.buffer;
                if (buffer == null) {
                    throw new IllegalStateException("not attached to a buffer");
                }
                if (!this.readWrite) {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
                long j = buffer.size;
                Segment writableSegment = this.buffer.writableSegment(i);
                int i2 = 8192 - writableSegment.limit;
                writableSegment.limit = 8192;
                long j2 = i2;
                this.buffer.size = j + j2;
                this.segment = writableSegment;
                this.offset = j;
                this.data = writableSegment.data;
                this.start = 8192 - i2;
                this.end = 8192;
                return j2;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }
    }
}
