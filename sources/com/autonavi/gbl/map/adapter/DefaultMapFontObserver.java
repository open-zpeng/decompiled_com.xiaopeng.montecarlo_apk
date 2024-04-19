package com.autonavi.gbl.map.adapter;

import com.autonavi.gbl.map.model.FontMetrics;
import com.autonavi.gbl.map.model.FontMetricsRequestParam;
import com.autonavi.gbl.map.model.GlyphMetrics;
import com.autonavi.gbl.map.model.GlyphRaster;
import com.autonavi.gbl.map.model.GlyphRequestParam;
import com.autonavi.gbl.map.observer.MapFontObserver;
/* loaded from: classes2.dex */
public class DefaultMapFontObserver extends MapFontObserver {
    public static String TAG = "DefaultMapFontObserver";

    @Override // com.autonavi.gbl.map.observer.MapFontObserver, com.autonavi.gbl.map.observer.IMapFontObserver
    public GlyphMetrics getGlyphMetrics(GlyphRequestParam glyphRequestParam) {
        return MapUtils.getGlyphMetrics(glyphRequestParam);
    }

    @Override // com.autonavi.gbl.map.observer.MapFontObserver, com.autonavi.gbl.map.observer.IMapFontObserver
    public GlyphRaster getGlyphRaster(GlyphRequestParam glyphRequestParam) {
        return MapUtils.getGlyphRaster(glyphRequestParam);
    }

    @Override // com.autonavi.gbl.map.observer.MapFontObserver, com.autonavi.gbl.map.observer.IMapFontObserver
    public FontMetrics getFontMetrics(FontMetricsRequestParam fontMetricsRequestParam) {
        return MapUtils.getFontMetrics(fontMetricsRequestParam);
    }
}
