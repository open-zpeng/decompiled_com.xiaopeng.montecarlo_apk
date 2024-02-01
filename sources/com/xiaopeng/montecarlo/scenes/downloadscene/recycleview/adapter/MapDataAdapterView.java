package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.root.IWorkCallback;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.downloadscene.IMapDownloadContract;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.CityItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.EmptyItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.ProvinceItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.AbstractCityViewHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseCityViewHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.CurrentCityViewHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.EmptyViewHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.NormalCityViewHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.ProvinceViewHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IOnRecyclerViewListener;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IScrollListener;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class MapDataAdapterView extends RecyclerView.Adapter {
    private static final L.Tag TAG = new L.Tag("MapDataAdapterLandView");
    private static final int VIEW_TYPE_BASE_CITY = 2;
    private static final int VIEW_TYPE_CURRENT_CITY = 1;
    private static final int VIEW_TYPE_EMPTY = 5;
    private static final int VIEW_TYPE_NORMAL_CITY = 4;
    private static final int VIEW_TYPE_PROVINCE = 3;
    private MapDataAdapterProvider mAdapterProvider = new MapDataAdapterProvider();
    private LayoutInflater mInflater;
    private IOnRecyclerViewListener.OnItemClickListener mItemClickListener;
    private IScrollListener mScrollListener;
    private IMapDownloadContract.LogicView mView;

    private boolean canExpandAll() {
        return false;
    }

    public MapDataAdapterView(Context context, IMapDownloadContract.LogicView logicView) {
        this.mInflater = LayoutInflater.from(context);
        this.mView = logicView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        BaseItem baseItemWithPosition = getBaseItemWithPosition(i);
        if (i == 0) {
            return 1;
        }
        if (baseItemWithPosition instanceof ProvinceItem) {
            return 3;
        }
        return baseItemWithPosition instanceof CityItem ? ((CityItem) baseItemWithPosition).getAdcode() == 0 ? 2 : 4 : baseItemWithPosition instanceof EmptyItem ? 5 : 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return new EmptyViewHolder(this.mInflater.inflate(R.layout.layout_download_empty_space, viewGroup, false));
                    }
                    return new NormalCityViewHolder(this.mInflater.inflate(R.layout.item_city_layout, viewGroup, false));
                }
                return new ProvinceViewHolder(this.mInflater.inflate(R.layout.item_province_layout, viewGroup, false));
            }
            return new BaseCityViewHolder(this.mInflater.inflate(R.layout.layout_download_base_city, viewGroup, false));
        }
        return new CurrentCityViewHolder(this.mInflater.inflate(R.layout.layout_download_current_city, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int i) {
        View clickableView;
        if (viewHolder == null) {
            L.w(TAG, "onBindViewHolder, holder is null");
            return;
        }
        final BaseItem baseItemWithPosition = getBaseItemWithPosition(i);
        boolean z = viewHolder instanceof ProvinceViewHolder;
        if (z) {
            if (!(baseItemWithPosition instanceof ProvinceItem)) {
                return;
            }
        } else if ((viewHolder instanceof AbstractCityViewHolder) && !(baseItemWithPosition instanceof CityItem)) {
            return;
        }
        if (viewHolder instanceof BaseHolder) {
            ((BaseHolder) viewHolder).onBindHolder(baseItemWithPosition, this.mItemClickListener);
        }
        if ((baseItemWithPosition instanceof ProvinceItem) && z && (clickableView = ((ProvinceViewHolder) viewHolder).getClickableView()) != null) {
            clickableView.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.adapter.-$$Lambda$MapDataAdapterView$h-K2SgRKG7jcMygW00oqpH-2AI4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapDataAdapterView.this.lambda$onBindViewHolder$0$MapDataAdapterView(baseItemWithPosition, viewHolder, i, view);
                }
            });
        }
        if (viewHolder instanceof AbstractCityViewHolder) {
            ((AbstractCityViewHolder) viewHolder).setShowDivideLine(viewHolder.getAdapterPosition() != getRecyclerViewDataSize() - 1);
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$MapDataAdapterView(BaseItem baseItem, RecyclerView.ViewHolder viewHolder, int i, View view) {
        IOnRecyclerViewListener.OnItemClickListener onItemClickListener = this.mItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onGroupItemClick((ProvinceItem) baseItem, (ProvinceViewHolder) viewHolder, i);
        }
        IScrollListener iScrollListener = this.mScrollListener;
        if (iScrollListener == null || !iScrollListener.isScrollEnd()) {
            return;
        }
        if (((ProvinceItem) baseItem).isExpand()) {
            collapseGroup(i);
            return;
        }
        expandGroup(i);
        this.mScrollListener.scrollToPosition(baseItem.getGroupPosition(), this.mAdapterProvider.getRecyclerViewDataSize());
    }

    public void setOnItemClickListener(IOnRecyclerViewListener.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setScrollListener(IScrollListener iScrollListener) {
        this.mScrollListener = iScrollListener;
    }

    public void notifyDataSetChangedWhenIdle() {
        IScrollListener iScrollListener = this.mScrollListener;
        if (iScrollListener == null || !iScrollListener.isScrollEnd()) {
            return;
        }
        super.notifyDataSetChanged();
        L.i(TAG, "notifyDataSetChangedWhenIdle");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getRecyclerViewDataSize();
    }

    public boolean isRecycleViewDataReady() {
        MapDataAdapterProvider mapDataAdapterProvider = this.mAdapterProvider;
        return mapDataAdapterProvider != null && mapDataAdapterProvider.isRecycleViewDataReady();
    }

    public void expandGroup(int i) {
        int collapseGroup;
        BaseItem baseItem = i < this.mAdapterProvider.getRecyclerViewData().size() ? this.mAdapterProvider.getRecyclerViewData().get(i) : null;
        if (baseItem != null && (baseItem instanceof ProvinceItem)) {
            ProvinceItem provinceItem = (ProvinceItem) baseItem;
            if (provinceItem.isExpand()) {
                return;
            }
            if (!canExpandAll()) {
                int i2 = i;
                for (int i3 = 0; i3 < this.mAdapterProvider.getRecyclerViewData().size(); i3++) {
                    if (i3 != i2 && (collapseGroup = collapseGroup(i3)) != -1) {
                        i2 = collapseGroup;
                    }
                }
                i = i2;
            }
            if (provinceItem.hasChilds()) {
                ArrayList<CityItem> cityItemList = provinceItem.getCityItemList();
                provinceItem.onExpand();
                if (cityItemList != null) {
                    for (int i4 = 0; i4 < cityItemList.size(); i4++) {
                        CityItem cityItem = cityItemList.get(i4);
                        if (cityItem != null) {
                            if (i4 == cityItemList.size() - 1) {
                                cityItem.setLastItem(true);
                            } else {
                                cityItem.setLastItem(false);
                            }
                        }
                    }
                    if (canExpandAll()) {
                        this.mAdapterProvider.getRecyclerViewData().addAll(i + 1, cityItemList);
                    } else {
                        this.mAdapterProvider.getRecyclerViewData().addAll(this.mAdapterProvider.getRecyclerViewData().indexOf(baseItem) + 1, cityItemList);
                    }
                } else {
                    L.w(TAG, "expandGroup, tempChilds is null");
                }
                notifyDataSetChangedWhenIdle();
            }
        }
    }

    public int collapseGroup(int i) {
        BaseItem baseItem = i < this.mAdapterProvider.getRecyclerViewData().size() ? this.mAdapterProvider.getRecyclerViewData().get(i) : null;
        if (baseItem != null && (baseItem instanceof ProvinceItem)) {
            ProvinceItem provinceItem = (ProvinceItem) baseItem;
            if (provinceItem.isExpand()) {
                this.mAdapterProvider.getRecyclerViewData().size();
                if (provinceItem.hasChilds()) {
                    ArrayList<CityItem> cityItemList = provinceItem.getCityItemList();
                    provinceItem.onExpand();
                    if (cityItemList != null) {
                        int i2 = 0;
                        Iterator<BaseItem> it = this.mAdapterProvider.getRecyclerViewData().iterator();
                        while (it.hasNext()) {
                            BaseItem next = it.next();
                            if (i2 == 0) {
                                i2++;
                            } else if (cityItemList.contains(next)) {
                                it.remove();
                            }
                        }
                    } else {
                        L.Tag tag = TAG;
                        L.w(tag, "collapseGroup, tempChilds is null, pos = " + i);
                    }
                    notifyDataSetChangedWhenIdle();
                    return i;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public BaseItem getBaseItemWithPosition(int i) {
        if (i < this.mAdapterProvider.getRecyclerViewData().size()) {
            return this.mAdapterProvider.getRecyclerViewData().get(i);
        }
        return null;
    }

    public int getRecyclerViewDataSize() {
        MapDataAdapterProvider mapDataAdapterProvider = this.mAdapterProvider;
        if (mapDataAdapterProvider == null) {
            return 0;
        }
        return mapDataAdapterProvider.getRecyclerViewDataSize();
    }

    public void recreateRecycleViewData(IWorkCallback iWorkCallback) {
        L.i(TAG, "recreateRecycleViewData");
        this.mAdapterProvider.generateRecycleViewData(iWorkCallback);
    }

    public void onDownLoadStatus(Integer num, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
        this.mAdapterProvider.onDownLoadStatus(num, taskStatusCodeEnum, operationErrCodeEnum);
    }

    public void onOperated(OperationTypeEnum operationTypeEnum, Integer num) {
        this.mAdapterProvider.onOperated(operationTypeEnum, num);
    }

    public void onPercent(Integer num, Integer num2, Float f) {
        this.mAdapterProvider.onPercent(num, num2, f);
    }
}
