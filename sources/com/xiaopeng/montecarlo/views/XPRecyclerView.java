package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.views.observable.ObservableRecyclerView;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.List;
/* loaded from: classes3.dex */
public class XPRecyclerView<T> extends ObservableRecyclerView implements VuiView {
    private static final L.Tag TAG = new L.Tag("XPRecyclerView");
    private boolean mAutoPaging;
    private CreateViewCallback mCreateFooterCallback;
    private CreateViewCallback mCreateHeaderCallback;
    private boolean mHideLoadMore;
    private boolean mHideNoMore;
    private boolean mIsLock;
    private LoadMoreCallback mLoadMoreCallback;
    private int mMaxCount;
    private OnPageCallback mOnPageCallback;
    private RecyclerView.OnScrollListener mOnXpScrollListener;
    private int mPageNum;
    private PageRecyclerAdapter mPageRecyclerAdapter;
    private int mPageSize;
    private PageValuesCallback mPageValuesCallback;
    private boolean mShowFooter;
    private boolean mShowHeader;
    private RecyclerView.OnScrollListener mXpScrollListener;

    /* loaded from: classes3.dex */
    public interface CreateViewCallback {
        View onCreateView();
    }

    /* loaded from: classes3.dex */
    public interface DataFusionCallback<T> {
        void fetch(List<T> list);
    }

    /* loaded from: classes3.dex */
    public static class LoadMode {
        public static final int LOAD_MODE_HAS_NO_MORE = 3;
        public static final int LOAD_MODE_LOADING = 2;
        public static final int LOAD_MODE_NONE = 1;
    }

    /* loaded from: classes3.dex */
    public interface LoadMoreCallback {
        void onLoadMore();
    }

    /* loaded from: classes3.dex */
    public interface OnPageCallback<T> {
        void onPageSuccess(List<T> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface PageValuesCallback<T> {
        void autoIncrementPageNum();

        View getFooter();

        View getHeader();

        int getMaxCount();

        int getPageNum();

        int getPageSize();

        boolean hideLoadMore();

        boolean hideNoMore();

        void onLoadMore();

        void onPageSuccess(List<T> list);

        void resetPageState();

        void setPageNum(int i);

        boolean showFooter();

        boolean showHeader();
    }

    @Override // com.xiaopeng.xui.vui.VuiView, com.xiaopeng.vui.commons.IVuiElement
    public String getVuiBizId() {
        return null;
    }

    @Override // com.xiaopeng.xui.vui.VuiView, com.xiaopeng.vui.commons.IVuiElement
    public void setVuiBizId(String str) {
    }

    /* loaded from: classes3.dex */
    public class LoadMoreViewHolder_ViewBinding implements Unbinder {
        private LoadMoreViewHolder target;

        @UiThread
        public LoadMoreViewHolder_ViewBinding(LoadMoreViewHolder loadMoreViewHolder, View view) {
            this.target = loadMoreViewHolder;
            loadMoreViewHolder.mLoadContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.search_result_load_container, "field 'mLoadContainer'", XRelativeLayout.class);
            loadMoreViewHolder.mLoadMoreText = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_load_more, "field 'mLoadMoreText'", XTextView.class);
            loadMoreViewHolder.mNoMoreResultText = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_no_more_result, "field 'mNoMoreResultText'", XTextView.class);
            loadMoreViewHolder.mLoadingText = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_loading_text, "field 'mLoadingText'", XTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            LoadMoreViewHolder loadMoreViewHolder = this.target;
            if (loadMoreViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            loadMoreViewHolder.mLoadContainer = null;
            loadMoreViewHolder.mLoadMoreText = null;
            loadMoreViewHolder.mNoMoreResultText = null;
            loadMoreViewHolder.mLoadingText = null;
        }
    }

    public XPRecyclerView(Context context) {
        this(context, null);
    }

    public XPRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnXpScrollListener = null;
        this.mPageRecyclerAdapter = null;
        this.mLoadMoreCallback = null;
        this.mOnPageCallback = null;
        this.mAutoPaging = false;
        this.mHideNoMore = false;
        this.mHideLoadMore = false;
        this.mCreateHeaderCallback = null;
        this.mCreateFooterCallback = null;
        this.mMaxCount = Integer.MAX_VALUE;
        this.mPageNum = 1;
        this.mPageSize = 10;
        this.mIsLock = false;
        this.mXpScrollListener = new RecyclerView.OnScrollListener() { // from class: com.xiaopeng.montecarlo.views.XPRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (!XPRecyclerView.this.canScrollVertically(1) && XPRecyclerView.this.mPageRecyclerAdapter != null) {
                    if (!XPRecyclerView.this.mPageRecyclerAdapter.isDataDirty()) {
                        XPRecyclerView.this.mPageRecyclerAdapter.loadMore();
                    } else {
                        int updateStartPosition = XPRecyclerView.this.mPageRecyclerAdapter.getUpdateStartPosition();
                        int updateEndPosition = XPRecyclerView.this.mPageRecyclerAdapter.getUpdateEndPosition();
                        if (updateStartPosition == -1 && updateEndPosition == -1) {
                            XPRecyclerView.this.mPageRecyclerAdapter.notifyDataSetChanged();
                        } else if (updateStartPosition == updateEndPosition) {
                            XPRecyclerView.this.mPageRecyclerAdapter.notifyItemChanged(updateStartPosition);
                        } else {
                            XPRecyclerView.this.mPageRecyclerAdapter.removeItemWithData(updateStartPosition);
                        }
                        XPRecyclerView.this.mPageRecyclerAdapter.resetDataDirty();
                    }
                }
                if (XPRecyclerView.this.mOnXpScrollListener != null) {
                    XPRecyclerView.this.mOnXpScrollListener.onScrollStateChanged(recyclerView, i2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                if (XPRecyclerView.this.mOnXpScrollListener != null) {
                    XPRecyclerView.this.mOnXpScrollListener.onScrolled(recyclerView, i2, i3);
                }
            }
        };
        this.mPageValuesCallback = new PageValuesCallback() { // from class: com.xiaopeng.montecarlo.views.XPRecyclerView.2
            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public int getPageNum() {
                return XPRecyclerView.this.mPageNum;
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public void setPageNum(int i2) {
                XPRecyclerView.this.mPageNum = i2;
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public void autoIncrementPageNum() {
                XPRecyclerView.this.autoIncrementPageNum();
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public int getPageSize() {
                return XPRecyclerView.this.mPageSize;
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public int getMaxCount() {
                return XPRecyclerView.this.mMaxCount;
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public boolean showHeader() {
                return XPRecyclerView.this.mShowHeader && XPRecyclerView.this.mCreateHeaderCallback != null;
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public boolean showFooter() {
                return XPRecyclerView.this.mShowFooter && XPRecyclerView.this.mCreateFooterCallback != null;
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public View getHeader() {
                if (XPRecyclerView.this.mCreateHeaderCallback != null) {
                    return XPRecyclerView.this.mCreateHeaderCallback.onCreateView();
                }
                return null;
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public View getFooter() {
                if (XPRecyclerView.this.mCreateFooterCallback != null) {
                    return XPRecyclerView.this.mCreateFooterCallback.onCreateView();
                }
                return null;
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public void onPageSuccess(List list) {
                if (XPRecyclerView.this.mOnPageCallback != null) {
                    XPRecyclerView.this.mOnPageCallback.onPageSuccess(list);
                }
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public void onLoadMore() {
                if (XPRecyclerView.this.mLoadMoreCallback != null) {
                    XPRecyclerView.this.mLoadMoreCallback.onLoadMore();
                }
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public void resetPageState() {
                XPRecyclerView.this.resetPageState();
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public boolean hideNoMore() {
                return XPRecyclerView.this.mHideNoMore;
            }

            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.PageValuesCallback
            public boolean hideLoadMore() {
                return XPRecyclerView.this.mHideLoadMore;
            }
        };
        initVui(this, attributeSet);
        setVuiLayoutLoadable(true);
        super.addOnScrollListener(this.mXpScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.vui.VuiRecyclerView
    public void finalize() throws Throwable {
        super.finalize();
        releaseVui();
    }

    @Override // com.xiaopeng.xui.vui.VuiRecyclerView, androidx.recyclerview.widget.RecyclerView
    public final void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
    }

    public void setAdapter(PageRecyclerAdapter pageRecyclerAdapter) {
        this.mPageRecyclerAdapter = pageRecyclerAdapter;
        if (this.mAutoPaging) {
            this.mLoadMoreCallback = new LocalLoadMoreCallback();
        }
        setPageAdapterCallback();
        setAdapter((RecyclerView.Adapter) this.mPageRecyclerAdapter);
    }

    public void updateAdapterAndRefreshCache() {
        if (getAdapter() == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int i = 0;
            View childAt = linearLayoutManager.getChildAt(0);
            if (findFirstVisibleItemPosition >= 0 && childAt != null) {
                i = childAt.getTop();
            }
            setAdapter(getAdapter());
            if (findFirstVisibleItemPosition < 0 || getAdapter().getItemCount() <= 0) {
                return;
            }
            linearLayoutManager.scrollToPositionWithOffset(findFirstVisibleItemPosition, i);
            return;
        }
        setAdapter(getAdapter());
    }

    public int getPageNum() {
        return this.mPageNum;
    }

    public boolean isAutoPaging() {
        return this.mAutoPaging;
    }

    public void setAutoPaging(boolean z) {
        this.mAutoPaging = z;
        if (this.mAutoPaging) {
            this.mLoadMoreCallback = new LocalLoadMoreCallback();
        }
        setPageAdapterCallback();
    }

    public int getMaxCount() {
        return this.mMaxCount;
    }

    public void setMaxCount(int i) {
        this.mMaxCount = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        this.mPageSize = i;
    }

    public void setCreateHeaderCallback(CreateViewCallback createViewCallback) {
        this.mCreateHeaderCallback = createViewCallback;
    }

    public void setCreateFooterCallback(CreateViewCallback createViewCallback) {
        this.mCreateFooterCallback = createViewCallback;
    }

    public void setShowHeader(boolean z) {
        this.mShowHeader = z;
    }

    public void setShowFooter(boolean z) {
        this.mShowFooter = z;
    }

    private void setPageAdapterCallback() {
        PageValuesCallback pageValuesCallback;
        PageRecyclerAdapter pageRecyclerAdapter = this.mPageRecyclerAdapter;
        if (pageRecyclerAdapter == null || (pageValuesCallback = this.mPageValuesCallback) == null) {
            return;
        }
        pageRecyclerAdapter.setPageValuesCallback(pageValuesCallback);
    }

    public void setLoadMoreCallback(LoadMoreCallback loadMoreCallback) {
        if (this.mAutoPaging) {
            return;
        }
        this.mLoadMoreCallback = loadMoreCallback;
        setPageAdapterCallback();
    }

    public void setOnPageCallback(OnPageCallback onPageCallback) {
        this.mOnPageCallback = onPageCallback;
    }

    public void setOnXpScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.mOnXpScrollListener = onScrollListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoIncrementPageNum() {
        this.mPageNum++;
    }

    public boolean isPaging() {
        return this.mPageNum > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPageState() {
        this.mPageNum = 1;
    }

    public void resetPage() {
        resetPageState();
    }

    public void setHideNoMore(boolean z) {
        this.mHideNoMore = z;
    }

    public void setHideLoadMore(boolean z) {
        this.mHideLoadMore = z;
    }

    public int getLoadMode() {
        PageRecyclerAdapter pageRecyclerAdapter = this.mPageRecyclerAdapter;
        if (pageRecyclerAdapter == null) {
            return 1;
        }
        return pageRecyclerAdapter.getLoadMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class LoadMoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Runnable mCallback;
        @BindView(R.id.search_result_load_container)
        XRelativeLayout mLoadContainer;
        @BindView(R.id.search_result_load_more)
        XTextView mLoadMoreText;
        @BindView(R.id.search_result_loading_text)
        XTextView mLoadingText;
        @BindView(R.id.search_result_no_more_result)
        XTextView mNoMoreResultText;

        public LoadMoreViewHolder(View view, Runnable runnable) {
            super(view);
            this.mCallback = null;
            this.mCallback = runnable;
            ButterKnife.bind(this, view);
            this.mLoadContainer.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Runnable runnable;
            if (view.getId() == R.id.search_result_load_container && (runnable = this.mCallback) != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View view) {
            super(view);
        }
    }

    /* loaded from: classes3.dex */
    private class LocalLoadMoreCallback implements LoadMoreCallback {
        private Handler mHandler;
        private Runnable mRunnable;

        private LocalLoadMoreCallback() {
            this.mHandler = new Handler();
            this.mRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.views.XPRecyclerView.LocalLoadMoreCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    if (XPRecyclerView.this.mPageRecyclerAdapter != null) {
                        XPRecyclerView.this.mPageRecyclerAdapter.addNextPageList();
                    }
                }
            };
        }

        @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.LoadMoreCallback
        public void onLoadMore() {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.postDelayed(this.mRunnable, 500L);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.observable.ObservableRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsLock) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setLock(boolean z) {
        this.mIsLock = z;
    }
}
