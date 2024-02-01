package com.xiaopeng.montecarlo.mapoverlay.search;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
/* loaded from: classes.dex */
public class SearchDecorator extends BaseMapDecorator {
    public static final String KEY_FIRST_VISIBLE_ITEM_POSITION = "first_visible_item_position";
    public static final String KEY_IS_PORTRAIT_VOICE_FUSION = "is_portrait_voice_fusion";
    public static final String KEY_LAST_VISIBLE_ITEM_POSITION = "last_visible_item_position";
    public static final String KEY_SEARCH_TYPE = "poi_search_type";
    public static final String SEARCH_CENTER_ID = "center_";
    public static final String SEARCH_SINGLE_ID = "single_";

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 20001;
    }

    public SearchDecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public BaseDecoratorPresenter createPresenter() {
        return new SearchDecoratorPresenter(this.mDecoratorCallback);
    }
}
