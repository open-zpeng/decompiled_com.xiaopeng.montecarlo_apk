package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.FontMetrics;
import com.autonavi.gbl.map.model.FontMetricsRequestParam;
import com.autonavi.gbl.map.model.GlyphMetrics;
import com.autonavi.gbl.map.model.GlyphRaster;
import com.autonavi.gbl.map.model.GlyphRequestParam;
import com.autonavi.gbl.map.router.MapFontObserverRouter;
@IntfAuto(target = MapFontObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMapFontObserver {
    FontMetrics getFontMetrics(FontMetricsRequestParam fontMetricsRequestParam);

    GlyphMetrics getGlyphMetrics(GlyphRequestParam glyphRequestParam);

    GlyphRaster getGlyphRaster(GlyphRequestParam glyphRequestParam);
}
