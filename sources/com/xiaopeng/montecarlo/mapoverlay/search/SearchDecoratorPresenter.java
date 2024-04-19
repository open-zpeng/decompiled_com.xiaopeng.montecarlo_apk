package com.xiaopeng.montecarlo.mapoverlay.search;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
/* loaded from: classes2.dex */
public class SearchDecoratorPresenter extends BaseDecoratorPresenter {
    private static final L.Tag TAG = new L.Tag("SearchDecoratorPresenter");
    private int mFirstVisibleIndex;
    private boolean mIsPortraitVoiceFusion;
    private int mLastVisibleIndex;
    protected int mSearchType;

    public SearchDecoratorPresenter(BaseDecoratorCallback baseDecoratorCallback) {
        super(baseDecoratorCallback);
        this.mIsPortraitVoiceFusion = false;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public void update(Bundle bundle) {
        this.mSearchType = bundle.getInt(SearchDecorator.KEY_SEARCH_TYPE, 100);
        this.mFirstVisibleIndex = bundle.getInt(SearchDecorator.KEY_FIRST_VISIBLE_ITEM_POSITION, 0);
        this.mLastVisibleIndex = bundle.getInt(SearchDecorator.KEY_LAST_VISIBLE_ITEM_POSITION, 0);
        this.mIsPortraitVoiceFusion = bundle.getBoolean(SearchDecorator.KEY_IS_PORTRAIT_VOICE_FUSION, false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "POP=> update : " + this.mFirstVisibleIndex + " - " + this.mLastVisibleIndex);
        }
        super.update(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    @NonNull
    public XPPointBaseData generateBizPoint(int i, int i2, @NonNull XPPoiInfo xPPoiInfo) {
        XPPointBaseData generateBizPoint = super.generateBizPoint(i, i2, xPPoiInfo);
        if (i == 1 && i2 == 0 && !this.mIsPortraitVoiceFusion) {
            generateBizPoint.id = SearchDecorator.SEARCH_SINGLE_ID + ((int) generateBizPoint.position.lat) + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + ((int) generateBizPoint.position.lon) + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + ((int) generateBizPoint.position.z) + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + generateBizPoint.priority;
        } else if (i2 < i) {
            generateBizPoint.id = "" + (i2 + 1);
            generateBizPoint.priority = isMarkPoint(i2) ? i - i2 : (i * 2) - i2;
            if (this.mSearchType == 101 && i2 == i - 1) {
                generateBizPoint.id = SearchDecorator.SEARCH_CENTER_ID + ((int) generateBizPoint.position.lat) + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + ((int) generateBizPoint.position.lon) + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + ((int) generateBizPoint.position.z) + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + generateBizPoint.priority;
            }
        }
        return generateBizPoint;
    }

    private boolean isMarkPoint(int i) {
        return i < this.mFirstVisibleIndex || i > this.mLastVisibleIndex;
    }
}
