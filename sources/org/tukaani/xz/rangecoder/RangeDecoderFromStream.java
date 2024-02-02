package org.tukaani.xz.rangecoder;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.CorruptedInputException;
/* loaded from: classes3.dex */
public final class RangeDecoderFromStream extends RangeDecoder {
    private final DataInputStream inData;

    public RangeDecoderFromStream(InputStream inputStream) throws IOException {
        this.inData = new DataInputStream(inputStream);
        if (this.inData.readUnsignedByte() != 0) {
            throw new CorruptedInputException();
        }
        this.code = this.inData.readInt();
        this.range = -1;
    }

    public boolean isFinished() {
        return this.code == 0;
    }

    @Override // org.tukaani.xz.rangecoder.RangeDecoder
    public void normalize() throws IOException {
        if ((this.range & (-16777216)) == 0) {
            this.code = (this.code << 8) | this.inData.readUnsignedByte();
            this.range <<= 8;
        }
    }
}
