package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.option.LinkInfo;
import com.autonavi.gbl.common.path.option.SegmentInfo;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class XPBaseSegmentAccessor {
    private static final L.Tag TAG = new L.Tag("XPBaseSegmentAccessor");
    private final SegmentInfo mImpl;
    private long mIndex;
    private boolean mRecycled = false;
    XPBaseLinkAccessor mXpLinkAccessor;

    public XPBaseSegmentAccessor(long j, @NonNull SegmentInfo segmentInfo) {
        this.mIndex = j;
        this.mImpl = segmentInfo;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "Seq index:" + this.mIndex + " create");
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

    public long getLinkCount() {
        return this.mImpl.getLinkCount();
    }

    public XPBaseLinkAccessor getLinkAccessor(long j) {
        XPBaseLinkAccessor xPBaseLinkAccessor = this.mXpLinkAccessor;
        if (xPBaseLinkAccessor != null) {
            if (!xPBaseLinkAccessor.isRecycled() && this.mXpLinkAccessor.getIndex() == j) {
                return this.mXpLinkAccessor;
            }
            if (!this.mXpLinkAccessor.isRecycled()) {
                this.mXpLinkAccessor.recycle();
            }
            this.mXpLinkAccessor = null;
        }
        LinkInfo linkInfo = this.mImpl.getLinkInfo(j);
        if (linkInfo == null) {
            return null;
        }
        this.mXpLinkAccessor = new XPBaseLinkAccessor(j, linkInfo);
        return this.mXpLinkAccessor;
    }

    public long getLength() {
        return this.mImpl.getLength();
    }

    public long getTravelTime() {
        return this.mImpl.getTravelTime();
    }

    public ArrayList<Coord2DDouble> getPoints() {
        return NavCoreUtil.translationInt32ToDouble(this.mImpl.getPoints());
    }

    public int getTollCost() {
        return this.mImpl.getTollCost();
    }

    public void recycle() {
        if (this.mRecycled) {
            return;
        }
        XPBaseLinkAccessor xPBaseLinkAccessor = this.mXpLinkAccessor;
        if (xPBaseLinkAccessor != null && !xPBaseLinkAccessor.isRecycled()) {
            this.mXpLinkAccessor.recycle();
        }
        this.mImpl.delete();
        this.mRecycled = true;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "Seq index:" + this.mIndex + " recycle");
        }
    }
}
