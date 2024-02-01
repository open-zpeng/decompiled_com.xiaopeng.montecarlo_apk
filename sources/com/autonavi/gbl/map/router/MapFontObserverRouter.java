package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.map.model.FontMetrics;
import com.autonavi.gbl.map.model.FontMetricsRequestParam;
import com.autonavi.gbl.map.model.GlyphMetrics;
import com.autonavi.gbl.map.model.GlyphRaster;
import com.autonavi.gbl.map.model.GlyphRequestParam;
import com.autonavi.gbl.map.observer.IMapFontObserver;
import com.autonavi.gbl.map.observer.MapFontObserver;
import com.autonavi.gbl.map.observer.impl.IMapFontObserverImpl;
@IntfAuto(target = MapFontObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapFontObserverRouter extends IMapFontObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MapFontObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapFontObserverRouter.class);
    private TypeHelper mHelper;
    private IMapFontObserver mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IMapFontObserver iMapFontObserver) {
        if (iMapFontObserver != null) {
            this.mObserver = iMapFontObserver;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(MapFontObserver.class, iMapFontObserver, this);
            }
        }
    }

    private void $constructor(String str, IMapFontObserver iMapFontObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapFontObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iMapFontObserver);
    }

    public MapFontObserverRouter(String str, IMapFontObserver iMapFontObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapFontObserver);
    }

    public MapFontObserverRouter(String str, IMapFontObserver iMapFontObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapFontObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IMapFontObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapFontObserverImpl
    public boolean getGlyphMetrics(GlyphRequestParam glyphRequestParam, GlyphMetrics glyphMetrics) {
        return $wrapper_getGlyphMetrics(glyphRequestParam, glyphMetrics);
    }

    private boolean $wrapper_getGlyphMetrics(GlyphRequestParam glyphRequestParam, GlyphMetrics glyphMetrics) {
        IMapFontObserver iMapFontObserver = this.mObserver;
        if (iMapFontObserver != null) {
            try {
                TypeUtil.deepcopy(iMapFontObserver.getGlyphMetrics(glyphRequestParam), glyphMetrics);
                return true;
            } catch (Exception unused) {
                DebugTool.e("getGlyphMetrics copy failed", new Object[0]);
                return true;
            }
        }
        return true;
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapFontObserverImpl
    public boolean getGlyphRaster(GlyphRequestParam glyphRequestParam, GlyphRaster glyphRaster) {
        return $wrapper_getGlyphRaster(glyphRequestParam, glyphRaster);
    }

    private boolean $wrapper_getGlyphRaster(GlyphRequestParam glyphRequestParam, GlyphRaster glyphRaster) {
        IMapFontObserver iMapFontObserver = this.mObserver;
        if (iMapFontObserver != null) {
            try {
                TypeUtil.deepcopy(iMapFontObserver.getGlyphRaster(glyphRequestParam), glyphRaster);
                return true;
            } catch (Exception unused) {
                DebugTool.e("getGlyphRaster copy failed", new Object[0]);
                return true;
            }
        }
        return true;
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapFontObserverImpl
    public boolean getFontMetrics(FontMetricsRequestParam fontMetricsRequestParam, FontMetrics fontMetrics) {
        return $wrapper_getFontMetrics(fontMetricsRequestParam, fontMetrics);
    }

    private boolean $wrapper_getFontMetrics(FontMetricsRequestParam fontMetricsRequestParam, FontMetrics fontMetrics) {
        IMapFontObserver iMapFontObserver = this.mObserver;
        if (iMapFontObserver != null) {
            try {
                TypeUtil.deepcopy(iMapFontObserver.getFontMetrics(fontMetricsRequestParam), fontMetrics);
                return true;
            } catch (Exception unused) {
                DebugTool.e("getFontMetrics copy failed", new Object[0]);
                return true;
            }
        }
        return true;
    }
}
