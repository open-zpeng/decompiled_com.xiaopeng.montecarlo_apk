package com.autonavi.gbl.map.adapter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE = -1;
    private int TEXT_FONTSIZE_TRUE = -1;
    private float base_line = 0.0f;
    private float start_x = 0.0f;
    private Paint text_paint = null;

    public static int GetNearstSize2N(int i) {
        int i2 = 1;
        while (i > i2) {
            i2 *= 2;
        }
        return i2;
    }

    public TextTextureGenerator() {
        createTextParam();
    }

    private void createTextParam() {
        this.TEXT_FONTSIZE_TRUE = this.TEXT_FONTSIZE - 2;
        this.text_paint = newPaint(null, this.TEXT_FONTSIZE_TRUE, 49);
        float f = (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE) / 2.0f;
        this.start_x = f;
        float f2 = 7.3242188f;
        float f3 = -27.832031f;
        try {
            Paint.FontMetrics fontMetrics = this.text_paint.getFontMetrics();
            f2 = fontMetrics.descent;
            f3 = fontMetrics.ascent;
            float f4 = fontMetrics.top;
            float f5 = fontMetrics.bottom;
            float f6 = fontMetrics.leading;
        } catch (Exception unused) {
        }
        this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f2 + f3)) / 2.0f) + f + 0.5f;
    }

    public byte[] getTextPixelBuffer(int i, int i2) {
        if (this.TEXT_FONTSIZE != i2) {
            this.TEXT_FONTSIZE = i2;
            createTextParam();
        }
        try {
            char c = (char) i;
            char[] cArr = {c};
            float f = this.base_line;
            Bitmap createBitmap = Bitmap.createBitmap(this.TEXT_FONTSIZE, this.TEXT_FONTSIZE, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            byte[] bArr = new byte[this.TEXT_FONTSIZE * this.TEXT_FONTSIZE];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.text_paint.measureText(String.valueOf(c));
            if (cArr[0] > 0 && cArr[0] < 256) {
                f -= 1.5f;
            }
            float f2 = f;
            Paint.Align textAlign = this.text_paint.getTextAlign();
            float textSize = this.text_paint.getTextSize();
            float f3 = measureText - this.TEXT_FONTSIZE_TRUE;
            if (textAlign != Paint.Align.CENTER && f3 >= 4.0f) {
                this.text_paint.setTextAlign(Paint.Align.CENTER);
                this.text_paint.setTextSize(this.TEXT_FONTSIZE_TRUE - f3);
                canvas.drawText(cArr, 0, 1, (this.TEXT_FONTSIZE_TRUE - f3) / 2.0f, f2, this.text_paint);
                this.text_paint.setTextAlign(textAlign);
                this.text_paint.setTextSize(textSize);
            } else {
                canvas.drawText(cArr, 0, 1, this.start_x, f2, this.text_paint);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            createBitmap.recycle();
            return bArr;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public byte[] getCharsWidths(int[] iArr, int i) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        byte[] bArr = new byte[length];
        float[] fArr = new float[1];
        if (this.TEXT_FONTSIZE != i) {
            this.TEXT_FONTSIZE = i;
            createTextParam();
        }
        for (int i2 = 0; i2 < length; i2++) {
            fArr[0] = this.text_paint.measureText(((char) iArr[i2]) + "");
            bArr[i2] = (byte) ((int) (fArr[0] + ((float) (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE))));
        }
        return bArr;
    }

    public byte[] getCharsWidths(short[] sArr, int i) {
        if (sArr == null) {
            return null;
        }
        int length = sArr.length;
        byte[] bArr = new byte[length];
        float[] fArr = new float[1];
        if (this.TEXT_FONTSIZE != i) {
            this.TEXT_FONTSIZE = i;
            createTextParam();
        }
        for (int i2 = 0; i2 < length; i2++) {
            fArr[0] = this.text_paint.measureText(((char) sArr[i2]) + "");
            bArr[i2] = (byte) ((int) (fArr[0] + ((float) (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE))));
        }
        return bArr;
    }

    private static Paint newPaint(String str, int i, int i2) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(i);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        switch (i2) {
            case 49:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
            case 50:
                textPaint.setTextAlign(Paint.Align.RIGHT);
                break;
            case 51:
                textPaint.setTextAlign(Paint.Align.CENTER);
                break;
            default:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
        }
        return textPaint;
    }

    public static float getFontlength(Paint paint, String str) {
        if (paint == null) {
            return 0.0f;
        }
        return paint.measureText(str);
    }

    public static float getFontHeight(Paint paint) {
        if (paint == null) {
            return 0.0f;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public String getFontVersion() {
        byte[] textPixelBuffer = getTextPixelBuffer(104, this.TEXT_FONTSIZE);
        if (textPixelBuffer == null) {
            return null;
        }
        return GLMD5Util.getByteArrayCRC32(textPixelBuffer);
    }
}
