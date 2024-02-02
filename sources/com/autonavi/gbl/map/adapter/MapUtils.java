package com.autonavi.gbl.map.adapter;

import android.graphics.Paint;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.FontMetrics;
import com.autonavi.gbl.map.model.FontMetricsRequestParam;
import com.autonavi.gbl.map.model.GlyphMetrics;
import com.autonavi.gbl.map.model.GlyphRaster;
import com.autonavi.gbl.map.model.GlyphRequestParam;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class MapUtils {
    public static final int PIXEL_MODE_A8 = 0;
    public static final int PIXEL_MODE_ARGB = 1;
    public static final int PIXEL_MODE_RGB = 3;
    public static final int PIXEL_MODE_RGBA = 2;

    public static Integer shortToInteger(Short sh) {
        if (sh.shortValue() < 0) {
            return Integer.valueOf(sh.shortValue() + 65536);
        }
        return Integer.valueOf(new BigDecimal((int) sh.shortValue()).intValue());
    }

    public static String getAusContent32(short[] sArr) {
        String str = "";
        if (sArr.length > 0) {
            for (int i = 0; i < sArr.length && sArr[i] != 0; i++) {
                String hexString = Integer.toHexString(shortToInteger(Short.valueOf(sArr[i])).intValue());
                String str2 = "\\u" + hexString.trim();
                str = str + decodeUnicode(str2).trim();
            }
        }
        return str;
    }

    public static String decodeUnicode(String str) {
        String substring;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i > -1) {
            int i2 = i + 2;
            int indexOf = str.indexOf("\\u", i2);
            if (indexOf == -1) {
                substring = str.substring(i2, str.length());
            } else {
                substring = str.substring(i2, indexOf);
            }
            stringBuffer.append(new Character((char) Integer.parseInt(substring, 16)).toString());
            i = indexOf;
        }
        return stringBuffer.toString();
    }

    public static GlyphMetrics getGlyphMetrics(GlyphRequestParam glyphRequestParam) {
        return GlyphLoader.loadGlyphMetrics(getAusContent32(glyphRequestParam.u16Str), new FontStyle(glyphRequestParam.font.nFontStyleCode), glyphRequestParam.font.nFontSize, glyphRequestParam.languageArr, glyphRequestParam.drawingMode != 0, glyphRequestParam.strokeWidth, glyphRequestParam.isEmoji > 0, glyphRequestParam.isSDF > 0);
    }

    public static GlyphRaster getGlyphRaster(GlyphRequestParam glyphRequestParam) {
        FontStyle fontStyle = new FontStyle(glyphRequestParam.font.nFontStyleCode);
        boolean z = glyphRequestParam.drawingMode != 0;
        String ausContent32 = getAusContent32(glyphRequestParam.u16Str);
        LogUtils.d(String.format("xzc %s", ausContent32));
        if (glyphRequestParam.drawingMode == 3) {
            LogUtils.i("xzc, loadPathRaster");
            return GlyphLoader.loadPathRaster(ausContent32, fontStyle, glyphRequestParam.font.nFontSize, glyphRequestParam.languageArr, z, 2.0f * glyphRequestParam.strokeWidth);
        }
        LogUtils.i("xzc, loadGlyphRaster");
        return GlyphLoader.loadGlyphRaster(ausContent32, fontStyle, glyphRequestParam.font.nFontSize, glyphRequestParam.languageArr, z, glyphRequestParam.strokeWidth, glyphRequestParam.isEmoji > 0, glyphRequestParam.isSDF > 0);
    }

    public static FontMetrics getFontMetrics(FontMetricsRequestParam fontMetricsRequestParam) {
        Paint.FontMetrics fontMetrics = GlyphLoader.newTextPaint(new FontStyle(fontMetricsRequestParam.nFontStyleCode), fontMetricsRequestParam.fFontSize, fontMetricsRequestParam.languageArr, false, 0.0f).getFontMetrics();
        FontMetrics fontMetrics2 = new FontMetrics();
        fontMetrics2.fAscent = Math.abs(fontMetrics.ascent);
        fontMetrics2.fDescent = Math.abs(fontMetrics.descent);
        fontMetrics2.fLeading = Math.abs(fontMetrics.leading);
        fontMetrics2.fHeight = Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent);
        return fontMetrics2;
    }
}
