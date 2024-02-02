package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class PageRecyclerAdapter<T> extends RecyclerView.Adapter {
    private Context mContext;
    private XPRecyclerView<T> mXPRecyclerView;
    private final List<T> mData = new ArrayList();
    private final List<T> mAllDataList = new ArrayList();
    private int mLoadMode = 1;
    private XPRecyclerView.PageValuesCallback mPageValuesCallback = null;
    private XPRecyclerView.DataFusionCallback<T> mDataFusionCallback = null;
    private boolean mIsDataDirty = false;
    private int mUpdateStartPosition = -1;
    private int mUpdateEndPosition = -1;
    private Runnable mLoadMoreRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.views.PageRecyclerAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            PageRecyclerAdapter.this.loadMore();
        }
    };

    private void bindFooterViewHolder(XPRecyclerView.FooterViewHolder footerViewHolder) {
    }

    private void bindHeaderViewHolder(XPRecyclerView.HeaderViewHolder headerViewHolder) {
    }

    public int getXpItemViewType(int i) {
        return -2147483645;
    }

    public abstract void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i);

    public abstract void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list);

    public abstract RecyclerView.ViewHolder onCreateXpViewHolder(ViewGroup viewGroup, int i);

    public PageRecyclerAdapter(Context context, XPRecyclerView<T> xPRecyclerView) {
        this.mXPRecyclerView = null;
        this.mContext = context;
        if (xPRecyclerView == null) {
            throw new IllegalArgumentException(" XPRecyclerView should not be null");
        }
        this.mXPRecyclerView = xPRecyclerView;
    }

    public void setDataFusionCallback(XPRecyclerView.DataFusionCallback<T> dataFusionCallback) {
        this.mDataFusionCallback = dataFusionCallback;
    }

    public void removeItem(int i) {
        if (i < 0 || i >= this.mData.size()) {
            return;
        }
        postDispatchSwipe(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void removeItemWithData(int i) {
        if (i >= 0 && i < this.mAllDataList.size()) {
            this.mAllDataList.remove(i);
        }
        if (i < 0 || i >= this.mData.size()) {
            return;
        }
        this.mData.remove(i);
        if (showHeader()) {
            i++;
        }
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, getItemCount() - i);
    }

    private void postDispatchSwipe(int i) {
        if (this.mXPRecyclerView.getScrollState() != 0 || this.mXPRecyclerView.isComputingLayout()) {
            if (this.mIsDataDirty && this.mUpdateEndPosition == -1 && this.mUpdateStartPosition == -1) {
                return;
            }
            this.mUpdateStartPosition = i;
            this.mUpdateEndPosition = getItemCount() - 1;
            this.mIsDataDirty = true;
            return;
        }
        removeItemWithData(i);
    }

    private void notifyXPDataSetChanged() {
        if (this.mXPRecyclerView.getScrollState() != 0 || this.mXPRecyclerView.isComputingLayout()) {
            this.mUpdateStartPosition = -1;
            this.mUpdateEndPosition = -1;
            this.mIsDataDirty = true;
            return;
        }
        notifyDataSetChanged();
        this.mIsDataDirty = false;
    }

    public void removeAllItem() {
        this.mAllDataList.clear();
        this.mData.clear();
        notifyXPDataSetChanged();
    }

    private void setFirstPageData(List<T> list) {
        this.mData.clear();
        if (CollectionUtils.isNotEmpty(list)) {
            this.mData.addAll(list);
        }
        int pageSize = this.mPageValuesCallback.getPageSize();
        if (pageSize >= 0 && this.mData.size() < pageSize) {
            this.mLoadMode = 3;
        }
        notifyXPDataSetChanged();
    }

    public final void addData(List<T> list, boolean z) {
        List<T> list2;
        int size;
        if (CollectionUtils.isNotEmpty(list)) {
            int maxCount = this.mPageValuesCallback.getMaxCount();
            int pageSize = this.mPageValuesCallback.getPageSize();
            int size2 = this.mData.size();
            if (list.size() + size2 >= maxCount) {
                this.mLoadMode = 3;
                size = maxCount - size2;
            } else {
                if (list.size() < pageSize) {
                    this.mLoadMode = 3;
                } else {
                    this.mLoadMode = 1;
                }
                size = list.size();
            }
            list2 = list.subList(0, size);
            if (CollectionUtils.isNotEmpty(list2)) {
                this.mData.addAll(list2);
            }
            if (z) {
                notifyXPDataSetChanged();
            } else {
                this.mLoadMode = 1;
                notifyItemInserted(this.mData.size());
                notifyItemChanged(this.mData.size());
                notifyItemRangeChanged(this.mData.size(), 1);
            }
            this.mPageValuesCallback.autoIncrementPageNum();
        } else {
            this.mLoadMode = 3;
            if (z) {
                if (showMore()) {
                    notifyLoadMoreItem();
                } else {
                    notifyXPDataSetChanged();
                }
            }
            list2 = null;
        }
        this.mPageValuesCallback.onPageSuccess(list2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addNextPageList() {
        List<T> nextPageList = getNextPageList();
        XPRecyclerView.DataFusionCallback<T> dataFusionCallback = this.mDataFusionCallback;
        if (dataFusionCallback != null) {
            dataFusionCallback.fetch(nextPageList);
        } else {
            addData(nextPageList, true);
        }
    }

    public List<T> getData() {
        return this.mData;
    }

    public final void setData(List<T> list) {
        this.mAllDataList.clear();
        if (CollectionUtils.isNotEmpty(list)) {
            this.mAllDataList.addAll(list);
        }
        XPRecyclerView.PageValuesCallback pageValuesCallback = this.mPageValuesCallback;
        if (pageValuesCallback != null) {
            pageValuesCallback.resetPageState();
        }
        resetLoadMode();
        setFirstPageData(getFirstPageList());
        XPRecyclerView.PageValuesCallback pageValuesCallback2 = this.mPageValuesCallback;
        if (pageValuesCallback2 != null) {
            pageValuesCallback2.autoIncrementPageNum();
        }
    }

    private List<T> getFirstPageList() {
        if (CollectionUtils.isEmpty(this.mAllDataList)) {
            return new ArrayList();
        }
        int size = this.mAllDataList.size();
        int pageSize = this.mPageValuesCallback.getPageSize();
        if (size > pageSize) {
            return new ArrayList(this.mAllDataList.subList(0, pageSize));
        }
        return new ArrayList(this.mAllDataList);
    }

    private List<T> getNextPageList() {
        if (CollectionUtils.isEmpty(this.mAllDataList)) {
            return new ArrayList();
        }
        int pageNum = this.mPageValuesCallback.getPageNum();
        int pageSize = this.mPageValuesCallback.getPageSize();
        int ceil = ((int) Math.ceil((this.mAllDataList.size() * 1.0d) / pageSize)) + 1;
        if (ceil != pageNum) {
            this.mPageValuesCallback.setPageNum(ceil);
        }
        int size = this.mData.size();
        int i = pageSize + size;
        int size2 = this.mAllDataList.size();
        if (i > size2) {
            i = size2;
        }
        return this.mAllDataList.subList(size, i);
    }

    public int getLoadMode() {
        return this.mLoadMode;
    }

    public void setLoadMode(int i) {
        this.mLoadMode = i;
    }

    public boolean isDataDirty() {
        return this.mIsDataDirty;
    }

    public int getUpdateStartPosition() {
        return this.mUpdateStartPosition;
    }

    public int getUpdateEndPosition() {
        return this.mUpdateEndPosition;
    }

    public void resetDataDirty() {
        this.mUpdateStartPosition = -1;
        this.mUpdateEndPosition = -1;
        this.mIsDataDirty = false;
    }

    public void loadMore() {
        if (this.mLoadMode == 1) {
            this.mLoadMode = 2;
            if (this.mPageValuesCallback != null) {
                notifyLoadMoreItem();
                this.mPageValuesCallback.onLoadMore();
            }
        }
    }

    private void resetLoadMode() {
        this.mLoadMode = 1;
    }

    private void notifyLoadMoreItem() {
        int itemCount = getItemCount();
        int i = showFooter() ? itemCount - 2 : itemCount - 1;
        if (i < 0 || this.mPageValuesCallback == null) {
            return;
        }
        notifyItemForChanged(i, true);
    }

    public void notifyItemForChanged(int i) {
        notifyItemForChanged(i, false);
    }

    private void notifyItemForChanged(int i, boolean z) {
        if (this.mXPRecyclerView.getScrollState() != 0 || this.mXPRecyclerView.isComputingLayout()) {
            if (this.mIsDataDirty && this.mUpdateEndPosition == -1 && this.mUpdateStartPosition == -1) {
                return;
            }
            if (this.mUpdateStartPosition == -1 && this.mUpdateEndPosition == -1) {
                this.mUpdateStartPosition = i;
                this.mUpdateEndPosition = i;
            } else if (!z) {
                if (i < this.mUpdateStartPosition) {
                    this.mUpdateStartPosition = i;
                }
                if (i > this.mUpdateEndPosition) {
                    this.mUpdateEndPosition = i;
                }
            } else {
                this.mUpdateEndPosition = getItemCount() - 1;
            }
            this.mIsDataDirty = true;
            return;
        }
        notifyItemChanged(i);
    }

    public boolean showMore() {
        return (CollectionUtils.isEmpty(this.mData) || isHideNoMore() || isHideLoadMore()) ? false : true;
    }

    private boolean isHideNoMore() {
        XPRecyclerView.PageValuesCallback pageValuesCallback = this.mPageValuesCallback;
        return pageValuesCallback != null && pageValuesCallback.hideNoMore() && this.mLoadMode == 3;
    }

    private boolean isHideLoadMore() {
        XPRecyclerView.PageValuesCallback pageValuesCallback = this.mPageValuesCallback;
        return pageValuesCallback != null && pageValuesCallback.hideLoadMore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        if (i == 0 && showHeader()) {
            return -2147483647;
        }
        int itemCount = getItemCount();
        boolean showFooter = showFooter();
        boolean showMore = showMore();
        if (!showFooter) {
            if (i == itemCount - 1 && showMore) {
                return Integer.MIN_VALUE;
            }
            return getXpItemViewType(i);
        } else if (i == itemCount - 1) {
            return -2147483646;
        } else {
            if (i == itemCount - 2 && showMore) {
                return Integer.MIN_VALUE;
            }
            return getXpItemViewType(i);
        }
    }

    private boolean showFooter() {
        XPRecyclerView.PageValuesCallback pageValuesCallback = this.mPageValuesCallback;
        return pageValuesCallback != null && pageValuesCallback.showFooter();
    }

    private boolean showHeader() {
        XPRecyclerView.PageValuesCallback pageValuesCallback = this.mPageValuesCallback;
        return pageValuesCallback != null && pageValuesCallback.showHeader();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (CollectionUtils.isEmpty(this.mData)) {
            return 0;
        }
        int xpItemCount = getXpItemCount();
        if (showHeader()) {
            xpItemCount++;
        }
        if (showMore()) {
            xpItemCount++;
        }
        return showFooter() ? xpItemCount + 1 : xpItemCount;
    }

    public int getXpItemCount() {
        return this.mData.size();
    }

    public int getActualPosition(int i) {
        if (showHeader()) {
            i--;
        }
        if (i < 0) {
            return 0;
        }
        int size = this.mData.size() - 1;
        return i <= size ? i : size;
    }

    public T getActualItem(int i) {
        if (showHeader()) {
            i--;
        }
        int size = this.mData.size() - 1;
        if (i > size) {
            i = size;
        }
        return this.mData.get(i);
    }

    public void setPageValuesCallback(XPRecyclerView.PageValuesCallback pageValuesCallback) {
        this.mPageValuesCallback = pageValuesCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == -2147483647) {
            return new XPRecyclerView.HeaderViewHolder(this.mPageValuesCallback.getHeader());
        }
        if (i == Integer.MIN_VALUE) {
            return new XPRecyclerView.LoadMoreViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_search_result_more_item, viewGroup, false), this.mLoadMoreRunnable);
        }
        if (i == -2147483646) {
            return new XPRecyclerView.FooterViewHolder(this.mPageValuesCallback.getFooter());
        }
        return onCreateXpViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder(viewHolder, i, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        if (viewHolder instanceof XPRecyclerView.LoadMoreViewHolder) {
            bindLoadMoreViewHolder((XPRecyclerView.LoadMoreViewHolder) viewHolder);
        } else if (viewHolder instanceof XPRecyclerView.HeaderViewHolder) {
            bindHeaderViewHolder((XPRecyclerView.HeaderViewHolder) viewHolder);
        } else if (viewHolder instanceof XPRecyclerView.FooterViewHolder) {
            bindFooterViewHolder((XPRecyclerView.FooterViewHolder) viewHolder);
        } else if (CollectionUtils.isEmpty(list)) {
            onBindXpViewHolder(viewHolder, i);
        } else {
            onBindXpViewHolder(viewHolder, i, list);
        }
    }

    private void bindLoadMoreViewHolder(XPRecyclerView.LoadMoreViewHolder loadMoreViewHolder) {
        loadMoreViewHolder.mLoadContainer.setVisibility(0);
        int i = this.mLoadMode;
        if (i == 2) {
            loadMoreViewHolder.mLoadMoreText.setVisibility(8);
            loadMoreViewHolder.mNoMoreResultText.setVisibility(8);
            loadMoreViewHolder.mLoadingText.setVisibility(0);
        } else if (i == 3) {
            loadMoreViewHolder.mLoadMoreText.setVisibility(8);
            loadMoreViewHolder.mNoMoreResultText.setVisibility(0);
            loadMoreViewHolder.mLoadingText.setVisibility(8);
        } else {
            loadMoreViewHolder.mLoadMoreText.setVisibility(0);
            loadMoreViewHolder.mNoMoreResultText.setVisibility(8);
            loadMoreViewHolder.mLoadingText.setVisibility(8);
        }
        loadMoreViewHolder.mLoadMoreText.setTextColor(ThemeWatcherUtil.getColor(R.color.search_load_more_color));
        loadMoreViewHolder.mLoadMoreText.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.selector_search_load_more));
        loadMoreViewHolder.mNoMoreResultText.setTextColor(ThemeWatcherUtil.getColor(R.color.colour_palette_orange));
    }

    /* loaded from: classes3.dex */
    private class ViewType {
        static final int VIEW_TYPE_FOOTER = -2147483646;
        static final int VIEW_TYPE_HEADER = -2147483647;
        static final int VIEW_TYPE_LOAD_MORE = Integer.MIN_VALUE;
        static final int VIEW_TYPE_NORMAL = -2147483645;

        private ViewType() {
        }
    }
}
