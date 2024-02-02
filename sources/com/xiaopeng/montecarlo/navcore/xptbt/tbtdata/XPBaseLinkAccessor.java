package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.option.LinkInfo;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class XPBaseLinkAccessor {
    private static final L.Tag TAG = new L.Tag("XPBaseLinkAccessor");
    private final LinkInfo mImpl;
    private long mIndex;
    private boolean mRecycled = false;

    public XPBaseLinkAccessor(long j, @NonNull LinkInfo linkInfo) {
        this.mIndex = j;
        this.mImpl = linkInfo;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "Link index:" + this.mIndex + " create");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getIndex() {
        return this.mIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRecycled() {
        return this.mRecycled;
    }

    public int getLength() {
        return this.mImpl.getLength();
    }

    public long getTravelTime() {
        return this.mImpl.getTravelTime();
    }

    public ArrayList<Coord2DDouble> getPoints() {
        return NavCoreUtil.translationInt32ToDouble(this.mImpl.getPoints());
    }

    public int getRoadClass() {
        return this.mImpl.getRoadClass();
    }

    public int getLinkType() {
        return this.mImpl.getLinkType();
    }

    public int getFormway() {
        return this.mImpl.getFormway();
    }

    public long getTPID() {
        return this.mImpl.getTPID();
    }

    public long getTileID() {
        return this.mImpl.getTileID();
    }

    public int getURID() {
        return this.mImpl.getURID();
    }

    public boolean isToll() {
        return this.mImpl.isToll();
    }

    public void recycle() {
        if (this.mRecycled) {
            return;
        }
        this.mRecycled = true;
        this.mImpl.delete();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "Link index:" + this.mIndex + " recycle");
        }
    }
}
