package com.xiaopeng.montecarlo.mapoverlay.favorite;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorCallback;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FavDecoratorPresenter extends BaseDecoratorPresenter {
    private static final L.Tag TAG = new L.Tag("POP=>FavDecoratorPresenter");
    private ArrayList<Integer> mTypeList;

    public FavDecoratorPresenter(BaseDecoratorCallback baseDecoratorCallback) {
        super(baseDecoratorCallback);
        this.mTypeList = new ArrayList<>();
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    public void update(Bundle bundle) {
        if (bundle != null) {
            this.mTypeList = bundle.getIntegerArrayList(FavoriteDecorator.KEY_FAVORITE_TYPE_LIST);
        }
        super.update(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter
    @NonNull
    public XPPointBaseData generateBizPoint(int i, int i2, @NonNull XPPoiInfo xPPoiInfo) {
        XPPointBaseData generateBizPoint = super.generateBizPoint(i, i2, xPPoiInfo);
        ArrayList<Integer> arrayList = this.mTypeList;
        if (arrayList != null && i2 >= 0 && i2 < arrayList.size()) {
            generateBizPoint.id += "-" + this.mTypeList.get(i2);
        } else {
            L.e(TAG, "out of index, index = " + i2 + ", xpPoiInfo = " + xPPoiInfo + ", mTypeList = " + this.mTypeList);
        }
        return generateBizPoint;
    }
}
