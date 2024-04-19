package com.autonavi.gbl.map.adapter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.autonavi.gbl.map.model.GlyphMetrics;
import com.autonavi.gbl.map.model.GlyphRaster;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class GlyphLoader {
    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long j);

    public static GlyphMetrics loadGlyphMetrics(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2, boolean z2, boolean z3) {
        GlyphMetrics glyphMetrics = new GlyphMetrics();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphMetrics;
        }
        try {
            if (!z2) {
                TextPaint newTextPaint = newTextPaint(fontStyle, f, str2, z, f2);
                Rect rect = new Rect();
                newTextPaint.getTextBounds(str, 0, str.length(), rect);
                if (rect.width() == 0 && rect.height() == 0) {
                    float measureText = newTextPaint.measureText(" ", 0, 1);
                    rect.top = 0;
                    rect.left = 0;
                    rect.right = (int) measureText;
                    rect.bottom = (int) (Math.abs(newTextPaint.getFontMetrics().ascent) + Math.abs(newTextPaint.getFontMetrics().descent));
                }
                if (z && f2 > 0.0f) {
                    float f3 = f2 / 2.0f;
                    rect.top = (int) (rect.top - f3);
                    rect.left = (int) (rect.left - f3);
                    rect.right = (int) (rect.right + f3);
                    rect.bottom = (int) (rect.bottom + f3);
                }
                glyphMetrics.fLeft = rect.left;
                glyphMetrics.fTop = Math.abs(newTextPaint.getFontMetrics().ascent) - Math.abs(rect.top);
                glyphMetrics.nWidth = rect.width();
                glyphMetrics.nHeight = rect.height();
                glyphMetrics.fAdvance = newTextPaint.measureText(str);
            } else {
                glyphMetrics.fLeft = 0.0f;
                glyphMetrics.fTop = 0.0f;
                int i = (int) f;
                glyphMetrics.nWidth = i;
                glyphMetrics.nHeight = i;
                glyphMetrics.fAdvance = f;
            }
        } catch (Exception unused) {
        }
        return glyphMetrics;
    }

    public static GlyphRaster loadGlyphRaster(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2, boolean z2, boolean z3) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            TextPaint newTextPaint = newTextPaint(fontStyle, f, str2, z, f2);
            Rect rect = new Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            int i = 1;
            if (rect.width() == 0 && rect.height() == 0) {
                rect.right = (int) newTextPaint.measureText(" ", 0, 1);
                rect.bottom = (int) (Math.abs(newTextPaint.getFontMetrics().ascent) + Math.abs(newTextPaint.getFontMetrics().descent));
                rect.left = 0;
                rect.top = 0;
            }
            if (z && f2 > 0.0f) {
                float f3 = f2 / 2.0f;
                rect.top = (int) (rect.top - f3);
                rect.left = (int) (rect.left - f3);
                rect.right = (int) (rect.right + f3);
                rect.bottom = (int) (rect.bottom + f3);
            }
            if (!rect.isEmpty()) {
                Bitmap.Config config = Bitmap.Config.ALPHA_8;
                if (z2) {
                    config = Bitmap.Config.ARGB_8888;
                    i = 4;
                }
                int i2 = z3 ? 3 : 0;
                int i3 = i2 * 2;
                Bitmap createBitmap = Bitmap.createBitmap(rect.width() + i3, rect.height() + i3, config);
                new Canvas(createBitmap).drawText(str, (0 - rect.left) + i2, (0 - rect.top) + i2, newTextPaint);
                byte[] bArr = new byte[((rect.width() + i3) * (rect.height() + i3) * i) + 100];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                glyphRaster.bitmapWidth = rect.width() + i3;
                glyphRaster.bitmapHeight = rect.height() + i3;
                if (z2) {
                    glyphRaster.bitmapPixelMode = 2;
                } else {
                    glyphRaster.bitmapPixelMode = 0;
                }
                glyphRaster.bitmapSize = bArr.length;
                createBitmap.copyPixelsToBuffer(wrap);
                createBitmap.recycle();
                glyphRaster.bitmapBuffer = bArr;
            }
        } catch (Exception unused) {
        }
        return glyphRaster;
    }

    public static GlyphRaster loadPathRaster(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            TextPaint newTextPaint = newTextPaint(fontStyle, f, str2, false, 0.0f);
            Rect rect = new Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            new Canvas(Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ALPHA_8)).drawText(str, 0 - rect.left, 0 - rect.top, newTextPaint);
            TextPaint newTextPaint2 = newTextPaint(fontStyle, f, str2, z, f2);
            Rect rect2 = new Rect();
            newTextPaint2.getTextBounds(str, 0, str.length(), rect2);
            if (z && f2 > 0.0f) {
                float f3 = f2 * 0.5f;
                rect2.top = (int) (rect2.top - f3);
                rect2.left = (int) (rect2.left - f3);
                rect2.right = (int) (rect2.right + f3);
                rect2.bottom = (int) (rect2.bottom + f3);
            }
            if (!rect2.isEmpty()) {
                Bitmap createBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ALPHA_8);
                Canvas canvas = new Canvas(createBitmap);
                float f4 = 0 - rect2.left;
                float f5 = 0 - rect2.top;
                Path path = new Path();
                newTextPaint.getTextPath(str, 0, str.length(), f4, f5, path);
                canvas.drawPath(path, newTextPaint2);
                byte[] bArr = new byte[rect2.width() * rect2.height()];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                glyphRaster.bitmapWidth = rect2.width();
                glyphRaster.bitmapHeight = rect2.height();
                glyphRaster.bitmapPixelMode = 0;
                glyphRaster.bitmapSize = bArr.length;
                createBitmap.copyPixelsToBuffer(wrap);
                createBitmap.recycle();
                glyphRaster.bitmapBuffer = bArr;
            }
        } catch (Exception unused) {
        }
        return glyphRaster;
    }

    private static String decodeUnicode(short s) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char) s);
        return stringBuffer.toString();
    }

    private static String decodeUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r3 != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.text.TextPaint newTextPaint(com.autonavi.gbl.map.adapter.FontStyle r2, float r3, java.lang.String r4, boolean r5, float r6) {
        /*
            android.text.TextPaint r0 = new android.text.TextPaint
            r0.<init>()
            if (r2 != 0) goto L8
            return r0
        L8:
            r1 = -1
            r0.setColor(r1)
            r1 = 1
            r0.setAntiAlias(r1)
            r0.setFilterBitmap(r1)
            r0.setTextSize(r3)
            android.graphics.Paint$Align r3 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r3)
            if (r5 == 0) goto L26
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r3)
            r0.setStrokeWidth(r6)
            goto L2b
        L26:
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL
            r0.setStyle(r3)
        L2b:
            int r3 = r2.getSlant()
            r5 = 2
            r6 = 0
            if (r3 == 0) goto L37
            if (r3 == r1) goto L39
            if (r3 == r5) goto L39
        L37:
            r3 = r6
            goto L3a
        L39:
            r3 = r1
        L3a:
            int r2 = r2.getWeight()
            switch(r2) {
                case 0: goto L41;
                case 100: goto L41;
                case 200: goto L41;
                case 300: goto L41;
                case 400: goto L41;
                case 500: goto L43;
                case 600: goto L43;
                case 700: goto L43;
                case 800: goto L43;
                case 900: goto L43;
                case 1000: goto L43;
                default: goto L41;
            }
        L41:
            r2 = r6
            goto L44
        L43:
            r2 = r1
        L44:
            if (r2 == 0) goto L4c
            if (r3 == 0) goto L4c
            r0.setFakeBoldText(r1)
            goto L55
        L4c:
            if (r2 == 0) goto L52
            r0.setFakeBoldText(r1)
            goto L55
        L52:
            if (r3 == 0) goto L55
            goto L56
        L55:
            r5 = r6
        L56:
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L63
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r5)
            goto L67
        L63:
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r4, r5)
        L67:
            r0.setTypeface(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.gbl.map.adapter.GlyphLoader.newTextPaint(com.autonavi.gbl.map.adapter.FontStyle, float, java.lang.String, boolean, float):android.text.TextPaint");
    }

    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    public static void destroyGlyphLoader(long j) {
        nativeDestroyGlyphLoader(j);
    }
}
