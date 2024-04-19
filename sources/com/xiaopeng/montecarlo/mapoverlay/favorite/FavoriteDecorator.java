package com.xiaopeng.montecarlo.mapoverlay.favorite;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.scenes.mapscene.MapTextureResourcesHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes2.dex */
public class FavoriteDecorator extends BaseMapDecorator {
    public static final String KEY_FAVORITE_TYPE_LIST = "favorite_type_list";
    private final XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 8004;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public boolean isGlobalDecorator() {
        return true;
    }

    public /* synthetic */ void lambda$new$0$FavoriteDecorator(int i) {
        if (this.mPresenter != null) {
            updateTheme();
        }
    }

    public FavoriteDecorator(@NonNull DecoratorType decoratorType, @NonNull MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.mapoverlay.favorite.-$$Lambda$FavoriteDecorator$lduJdmPjYfvsiD4kLHw4YKiIC7o
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public final void onThemeSwitch(int i) {
                FavoriteDecorator.this.lambda$new$0$FavoriteDecorator(i);
            }
        };
        updateTheme();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    private void updateTheme() {
        getMapView().cleanOverlayTexture(MarkUtils.MARKER_ID_FAVOURITE_FOCUS, true);
        MarkUtils.MapTextureResource createMapTextureByResId = MapTextureResourcesHelper.createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_small_collection_mapdisplay_pressed));
        MarkUtils.addOverlayTextureAsync(getMapView(), MarkUtils.MARKER_ID_FAVOURITE_FOCUS, createMapTextureByResId.getResId(), createMapTextureByResId.getAnchor(), createMapTextureByResId.getXRatio(), createMapTextureByResId.getYRatio(), createMapTextureByResId.isGenMimps(), createMapTextureByResId.isRepeat(), true, false);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public void onDecoratorRemove() {
        super.onDecoratorRemove();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public BaseDecoratorPresenter createPresenter() {
        return new FavDecoratorPresenter(this.mDecoratorCallback);
    }
}
