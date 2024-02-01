package org.tukaani.xz.rangecoder;

import com.alibaba.android.ark.AIMGroupService;
import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.CorruptedInputException;
/* loaded from: classes4.dex */
public final class RangeDecoderFromBuffer extends RangeDecoder {
    private static final int INIT_SIZE = 5;
    private final byte[] buf;
    private int pos = 0;
    private int end = 0;

    public RangeDecoderFromBuffer(int i) {
        this.buf = new byte[i - 5];
    }

    public boolean isFinished() {
        return this.pos == this.end && this.code == 0;
    }

    public boolean isInBufferOK() {
        return this.pos <= this.end;
    }

    @Override // org.tukaani.xz.rangecoder.RangeDecoder
    public void normalize() throws IOException {
        if ((this.range & (-16777216)) == 0) {
            try {
                byte[] bArr = this.buf;
                int i = this.pos;
                this.pos = i + 1;
                this.code = (this.code << 8) | (bArr[i] & AIMGroupService.AIM_MAX_GROUP_MEMBER_CURSOR);
                this.range <<= 8;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new CorruptedInputException();
            }
        }
    }

    public void prepareInputBuffer(DataInputStream dataInputStream, int i) throws IOException {
        if (i < 5) {
            throw new CorruptedInputException();
        }
        if (dataInputStream.readUnsignedByte() != 0) {
            throw new CorruptedInputException();
        }
        this.code = dataInputStream.readInt();
        this.range = -1;
        this.pos = 0;
        this.end = i - 5;
        dataInputStream.readFully(this.buf, 0, this.end);
    }
}
