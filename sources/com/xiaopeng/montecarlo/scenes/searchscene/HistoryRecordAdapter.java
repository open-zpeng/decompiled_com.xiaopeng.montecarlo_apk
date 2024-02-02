package com.xiaopeng.montecarlo.scenes.searchscene;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.views.ChildPoiGridView;
import com.xiaopeng.montecarlo.views.GotoPoiView;
import com.xiaopeng.montecarlo.views.HistoryRouteView;
import com.xiaopeng.montecarlo.views.PageRecyclerAdapter;
import com.xiaopeng.montecarlo.views.SetHomeOfficeView;
import com.xiaopeng.montecarlo.views.SetWayPointView;
import com.xiaopeng.montecarlo.views.SwipeMenuLayout;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.vui.commons.VuiMode;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HistoryRecordAdapter extends PageRecyclerAdapter<HistoryRecordInfo> {
    private static final int ITEM_DESTINATION = 2;
    private static final int ITEM_KEYWORD = 1;
    private static final int ITEM_PATH = 3;
    private static final L.Tag TAG = new L.Tag("HistoryRecordAdapter");
    private AdapterCallback mAdapterCallback;
    private Context mContext;
    private List<Integer> mExpandIndexs;
    private LayoutInflater mInflater;
    private int mSearchDest;
    private int mSearchMode;
    private int mSearchModeView;
    private int mSelectedIndex;
    private XPPoiInfo mSelectedSubInfo;
    private boolean mSwipeMenuEnable;

    /* loaded from: classes3.dex */
    public interface AdapterCallback {
        void onAddWay(HistoryRecordInfo historyRecordInfo, int i);

        void onChildPoiClick(int i, XPPoiInfo xPPoiInfo);

        void onDel(HistoryRecordInfo historyRecordInfo, int i);

        void onGotoDest(HistoryRecordInfo historyRecordInfo, int i);

        void onItemClick(HistoryRecordInfo historyRecordInfo, int i);

        void onNewNavi(HistoryRecordInfo historyRecordInfo, int i);

        void onRemoveWay(HistoryRecordInfo historyRecordInfo, int i);

        void onSetCompany(HistoryRecordInfo historyRecordInfo, int i);

        void onSetHome(HistoryRecordInfo historyRecordInfo, int i);
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
    }

    /* loaded from: classes3.dex */
    public class AddWayViewHolder_ViewBinding extends DestCommonViewHolder_ViewBinding {
        private AddWayViewHolder target;

        @UiThread
        public AddWayViewHolder_ViewBinding(AddWayViewHolder addWayViewHolder, View view) {
            super(addWayViewHolder, view);
            this.target = addWayViewHolder;
            addWayViewHolder.mSetWayPointView = (SetWayPointView) Utils.findRequiredViewAsType(view, R.id.container_set_waypoint, "field 'mSetWayPointView'", SetWayPointView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.DestCommonViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AddWayViewHolder addWayViewHolder = this.target;
            if (addWayViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            addWayViewHolder.mSetWayPointView = null;
            super.unbind();
        }
    }

    /* loaded from: classes3.dex */
    public class SetViewHolder_ViewBinding extends DestCommonViewHolder_ViewBinding {
        private SetViewHolder target;

        @UiThread
        public SetViewHolder_ViewBinding(SetViewHolder setViewHolder, View view) {
            super(setViewHolder, view);
            this.target = setViewHolder;
            setViewHolder.mSetHomeOfficeView = (SetHomeOfficeView) Utils.findRequiredViewAsType(view, R.id.container_set_home_office, "field 'mSetHomeOfficeView'", SetHomeOfficeView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.DestCommonViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            SetViewHolder setViewHolder = this.target;
            if (setViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            setViewHolder.mSetHomeOfficeView = null;
            super.unbind();
        }
    }

    /* loaded from: classes3.dex */
    public class GotoPoiViewHolder_ViewBinding extends DestCommonViewHolder_ViewBinding {
        private GotoPoiViewHolder target;

        @UiThread
        public GotoPoiViewHolder_ViewBinding(GotoPoiViewHolder gotoPoiViewHolder, View view) {
            super(gotoPoiViewHolder, view);
            this.target = gotoPoiViewHolder;
            gotoPoiViewHolder.mContainerGotoPoi = (GotoPoiView) Utils.findRequiredViewAsType(view, R.id.container_goto_poi_view, "field 'mContainerGotoPoi'", GotoPoiView.class);
            gotoPoiViewHolder.mIvLeftShadow = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_left_shadow, "field 'mIvLeftShadow'", XImageView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.DestCommonViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            GotoPoiViewHolder gotoPoiViewHolder = this.target;
            if (gotoPoiViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            gotoPoiViewHolder.mContainerGotoPoi = null;
            gotoPoiViewHolder.mIvLeftShadow = null;
            super.unbind();
        }
    }

    /* loaded from: classes3.dex */
    public class DestCommonViewHolder_ViewBinding implements Unbinder {
        private DestCommonViewHolder target;

        @UiThread
        public DestCommonViewHolder_ViewBinding(DestCommonViewHolder destCommonViewHolder, View view) {
            this.target = destCommonViewHolder;
            destCommonViewHolder.mSwipeMenuLayout = (SwipeMenuLayout) Utils.findRequiredViewAsType(view, R.id.search_item_swipe, "field 'mSwipeMenuLayout'", SwipeMenuLayout.class);
            destCommonViewHolder.mContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.destination_item_container, "field 'mContainer'", XRelativeLayout.class);
            destCommonViewHolder.mIvLocation = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_location, "field 'mIvLocation'", XImageView.class);
            destCommonViewHolder.mName = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_dest_item_name, "field 'mName'", XTextView.class);
            destCommonViewHolder.mDestDistance = (XTextView) Utils.findRequiredViewAsType(view, R.id.dest_item_distance, "field 'mDestDistance'", XTextView.class);
            destCommonViewHolder.mTvAddressType = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_dest_item_address_type, "field 'mTvAddressType'", XTextView.class);
            destCommonViewHolder.mAddressName = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_dest_item_address_name, "field 'mAddressName'", XTextView.class);
            destCommonViewHolder.mTvDestDelete = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_dest_delete, "field 'mTvDestDelete'", XTextView.class);
            destCommonViewHolder.mContainerChild = (ChildPoiGridView) Utils.findRequiredViewAsType(view, R.id.container_child, "field 'mContainerChild'", ChildPoiGridView.class);
            destCommonViewHolder.mBottomLine = Utils.findRequiredView(view, R.id.bottom_line, "field 'mBottomLine'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            DestCommonViewHolder destCommonViewHolder = this.target;
            if (destCommonViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            destCommonViewHolder.mSwipeMenuLayout = null;
            destCommonViewHolder.mContainer = null;
            destCommonViewHolder.mIvLocation = null;
            destCommonViewHolder.mName = null;
            destCommonViewHolder.mDestDistance = null;
            destCommonViewHolder.mTvAddressType = null;
            destCommonViewHolder.mAddressName = null;
            destCommonViewHolder.mTvDestDelete = null;
            destCommonViewHolder.mContainerChild = null;
            destCommonViewHolder.mBottomLine = null;
        }
    }

    /* loaded from: classes3.dex */
    public class HistoryRouteHolder_ViewBinding implements Unbinder {
        private HistoryRouteHolder target;

        @UiThread
        public HistoryRouteHolder_ViewBinding(HistoryRouteHolder historyRouteHolder, View view) {
            this.target = historyRouteHolder;
            historyRouteHolder.mSwipeMenuLayout = (SwipeMenuLayout) Utils.findRequiredViewAsType(view, R.id.search_item_swipe, "field 'mSwipeMenuLayout'", SwipeMenuLayout.class);
            historyRouteHolder.mContainerHistoryRoute = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.container_history_route, "field 'mContainerHistoryRoute'", XRelativeLayout.class);
            historyRouteHolder.mIvRoute = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_route, "field 'mIvRoute'", XImageView.class);
            historyRouteHolder.mHistoryRouteView = (HistoryRouteView) Utils.findRequiredViewAsType(view, R.id.view_history_route, "field 'mHistoryRouteView'", HistoryRouteView.class);
            historyRouteHolder.mDeleteText = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_kwd_delete, "field 'mDeleteText'", XTextView.class);
            historyRouteHolder.mIvLeftShadow = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_left_shadow, "field 'mIvLeftShadow'", XImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            HistoryRouteHolder historyRouteHolder = this.target;
            if (historyRouteHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            historyRouteHolder.mSwipeMenuLayout = null;
            historyRouteHolder.mContainerHistoryRoute = null;
            historyRouteHolder.mIvRoute = null;
            historyRouteHolder.mHistoryRouteView = null;
            historyRouteHolder.mDeleteText = null;
            historyRouteHolder.mIvLeftShadow = null;
        }
    }

    /* loaded from: classes3.dex */
    public class KeywordViewHolder_ViewBinding implements Unbinder {
        private KeywordViewHolder target;

        @UiThread
        public KeywordViewHolder_ViewBinding(KeywordViewHolder keywordViewHolder, View view) {
            this.target = keywordViewHolder;
            keywordViewHolder.mSwipeMenuLayout = (SwipeMenuLayout) Utils.findRequiredViewAsType(view, R.id.search_item_swipe, "field 'mSwipeMenuLayout'", SwipeMenuLayout.class);
            keywordViewHolder.mIvIcon = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_ic_check, "field 'mIvIcon'", XImageView.class);
            keywordViewHolder.mKeywordText = (XTextView) Utils.findRequiredViewAsType(view, R.id.keyword_item_text, "field 'mKeywordText'", XTextView.class);
            keywordViewHolder.mKeywordParent = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.keyword_item_parent, "field 'mKeywordParent'", XRelativeLayout.class);
            keywordViewHolder.mDeleteText = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_kwd_delete, "field 'mDeleteText'", XTextView.class);
            keywordViewHolder.mBottomLine = (XView) Utils.findRequiredViewAsType(view, R.id.bottom_line, "field 'mBottomLine'", XView.class);
            keywordViewHolder.mIvLeftShadow = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_left_shadow, "field 'mIvLeftShadow'", XImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            KeywordViewHolder keywordViewHolder = this.target;
            if (keywordViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            keywordViewHolder.mSwipeMenuLayout = null;
            keywordViewHolder.mIvIcon = null;
            keywordViewHolder.mKeywordText = null;
            keywordViewHolder.mKeywordParent = null;
            keywordViewHolder.mDeleteText = null;
            keywordViewHolder.mBottomLine = null;
            keywordViewHolder.mIvLeftShadow = null;
        }
    }

    public HistoryRecordAdapter(Context context, XPRecyclerView<HistoryRecordInfo> xPRecyclerView, int i, int i2, int i3) {
        super(context, xPRecyclerView);
        this.mSearchMode = 100;
        this.mSearchDest = 1000;
        this.mSearchModeView = 100;
        this.mSwipeMenuEnable = true;
        this.mSelectedIndex = -1;
        this.mSelectedSubInfo = null;
        this.mExpandIndexs = new ArrayList();
        this.mContext = context;
        this.mSearchMode = i;
        this.mSearchDest = i2;
        this.mSearchModeView = i3;
        this.mSwipeMenuEnable = com.xiaopeng.montecarlo.util.Utils.isSwipeMenuEnable(this.mSearchMode, this.mSearchDest);
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    public void setAdapterCallback(AdapterCallback adapterCallback) {
        this.mAdapterCallback = adapterCallback;
    }

    public void notifyChangeForDelete(int i) {
        removeItem(i);
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public RecyclerView.ViewHolder onCreateXpViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new KeywordViewHolder(this.mInflater.inflate(R.layout.layout_keyword_item, viewGroup, false));
        }
        if (i == 3) {
            return new HistoryRouteHolder(this.mInflater.inflate(R.layout.layout_route_item, viewGroup, false));
        }
        if (this.mSearchMode == 102 || this.mSearchModeView == 102) {
            return new AddWayViewHolder(this.mInflater.inflate(R.layout.layout_history_waypoint_item, viewGroup, false));
        }
        int i2 = this.mSearchDest;
        if (i2 == 1001 || i2 == 1002) {
            return new SetViewHolder(this.mInflater.inflate(R.layout.layout_history_set_item, viewGroup, false));
        }
        return new GotoPoiViewHolder(this.mInflater.inflate(R.layout.layout_history_gotopoi_item, viewGroup, false));
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int actualPosition = getActualPosition(viewHolder.getAdapterPosition());
        if (viewHolder instanceof DestCommonViewHolder) {
            HistoryRecordInfo actualItem = getActualItem(viewHolder.getAdapterPosition());
            bindDestCommonViewHolder((DestCommonViewHolder) viewHolder, actualItem, actualPosition);
            if (viewHolder instanceof SetViewHolder) {
                bindSetViewHolder((SetViewHolder) viewHolder, actualItem, actualPosition);
            } else if (viewHolder instanceof AddWayViewHolder) {
                bindAddWayViewHolder((AddWayViewHolder) viewHolder, actualItem, actualPosition);
            } else if (viewHolder instanceof GotoPoiViewHolder) {
                bindGotoPoiViewHolder((GotoPoiViewHolder) viewHolder, actualItem, actualPosition);
            }
        } else if (viewHolder instanceof KeywordViewHolder) {
            bindKeywordViewHolder((KeywordViewHolder) viewHolder, actualPosition);
        } else if (viewHolder instanceof HistoryRouteHolder) {
            bindHistoryRouteHolder((HistoryRouteHolder) viewHolder, actualPosition);
        }
    }

    private void bindKeywordViewHolder(KeywordViewHolder keywordViewHolder, int i) {
        keywordViewHolder.mSwipeMenuLayout.setSwipeEnable(this.mSwipeMenuEnable);
        HistoryRecordInfo historyRecordInfo = getData().get(i);
        if (TextUtils.isEmpty(historyRecordInfo.getXPPoiInfo().getName())) {
            return;
        }
        keywordViewHolder.mKeywordText.setText(historyRecordInfo.getXPPoiInfo().getName());
    }

    private void bindHistoryRouteHolder(HistoryRouteHolder historyRouteHolder, int i) {
        historyRouteHolder.mSwipeMenuLayout.setSwipeEnable(this.mSwipeMenuEnable);
        List<HistoryRecordInfo> data = getData();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) historyRouteHolder.mIvLeftShadow.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = 0;
            historyRouteHolder.mIvLeftShadow.setLayoutParams(layoutParams);
        }
        historyRouteHolder.mHistoryRouteView.updateContent(data.get(i));
    }

    private void bindDestCommonViewHolder(DestCommonViewHolder destCommonViewHolder, HistoryRecordInfo historyRecordInfo, int i) {
        destCommonViewHolder.mSwipeMenuLayout.setSwipeEnable(this.mSwipeMenuEnable);
        XPPoiInfo xPPoiInfo = historyRecordInfo.getXPPoiInfo();
        if (xPPoiInfo != null) {
            if (!TextUtils.isEmpty(xPPoiInfo.getName())) {
                destCommonViewHolder.mName.setText(xPPoiInfo.getName());
            } else {
                destCommonViewHolder.mName.setText("");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(NaviUtil.getDistanceNoSpaceString((long) xPPoiInfo.getDistance()));
            if (TextUtils.isEmpty(xPPoiInfo.getTag())) {
                sb.append(ContextUtils.getString(R.string.favorite_item_space_text));
                destCommonViewHolder.mTvAddressType.setVisibility(8);
            } else {
                sb.append(ContextUtils.getString(R.string.favorite_item_dot_text));
                destCommonViewHolder.mTvAddressType.setVisibility(0);
                destCommonViewHolder.mTvAddressType.setText(xPPoiInfo.getTag());
            }
            destCommonViewHolder.mDestDistance.setText(sb);
            destCommonViewHolder.mAddressName.setText(com.xiaopeng.montecarlo.util.Utils.getAddress(xPPoiInfo));
            destCommonViewHolder.mContainerChild.removeAllViews();
            if (CollectionUtils.isNotEmpty(xPPoiInfo.getChild())) {
                destCommonViewHolder.mContainerChild.setVisibility(0);
                showChildViews(destCommonViewHolder, xPPoiInfo, i);
                return;
            }
            destCommonViewHolder.mContainerChild.setVisibility(8);
            return;
        }
        destCommonViewHolder.mName.setText("");
        destCommonViewHolder.mAddressName.setText("");
        destCommonViewHolder.mTvAddressType.setVisibility(8);
        destCommonViewHolder.mContainerChild.setVisibility(8);
    }

    private void showChildViews(final DestCommonViewHolder destCommonViewHolder, final XPPoiInfo xPPoiInfo, final int i) {
        if (destCommonViewHolder == null || destCommonViewHolder.mContainerChild == null || xPPoiInfo == null || xPPoiInfo.getChild() == null) {
            return;
        }
        int size = xPPoiInfo.getChild().size();
        if (i == this.mSelectedIndex) {
            XPPoiInfo xPPoiInfo2 = this.mSelectedSubInfo;
        }
        destCommonViewHolder.mContainerChild.setChildViewClickListener(new ChildPoiGridView.ChildViewClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.1
            @Override // com.xiaopeng.montecarlo.views.ChildPoiGridView.ChildViewClickListener
            public void onChildClick(View view, XPPoiInfo xPPoiInfo3) {
                Object tag;
                int adapterPosition = destCommonViewHolder.getAdapterPosition();
                if (HistoryRecordAdapter.this.mAdapterCallback != null && adapterPosition != -1 && (tag = view.getTag(R.id.sup_poi_item)) != null) {
                    HistoryRecordAdapter.this.mAdapterCallback.onChildPoiClick(adapterPosition, xPPoiInfo.getChild().get(((Integer) tag).intValue()));
                }
                HistoryRecordAdapter.this.updateSelectItem(adapterPosition, xPPoiInfo3);
            }

            @Override // com.xiaopeng.montecarlo.views.ChildPoiGridView.ChildViewClickListener
            public void onExpandViewClick(boolean z) {
                if (z) {
                    HistoryRecordAdapter.this.mExpandIndexs.add(Integer.valueOf(i));
                } else {
                    HistoryRecordAdapter.this.mExpandIndexs.remove(Integer.valueOf(i));
                }
            }
        });
        destCommonViewHolder.mContainerChild.addChildViews(size, xPPoiInfo.getChild());
        destCommonViewHolder.mContainerChild.expand(this.mExpandIndexs.contains(Integer.valueOf(i)));
    }

    public void updateSelectItem(int i, XPPoiInfo xPPoiInfo) {
        XPPoiInfo xPPoiInfo2;
        if (i != this.mSelectedIndex || xPPoiInfo == null || (xPPoiInfo2 = this.mSelectedSubInfo) == null || !NaviUtil.isSamePOI(xPPoiInfo, xPPoiInfo2)) {
            final int i2 = this.mSelectedIndex;
            this.mSelectedIndex = i;
            this.mSelectedSubInfo = xPPoiInfo;
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    HistoryRecordAdapter.this.notifyItemChanged(i2);
                    HistoryRecordAdapter historyRecordAdapter = HistoryRecordAdapter.this;
                    historyRecordAdapter.notifyItemChanged(historyRecordAdapter.mSelectedIndex);
                }
            });
        }
    }

    private void bindSetViewHolder(SetViewHolder setViewHolder, HistoryRecordInfo historyRecordInfo, int i) {
        int i2 = this.mSearchDest;
        if (i2 == 1001) {
            setViewHolder.mSetHomeOfficeView.setViewType(0);
        } else if (i2 == 1002) {
            setViewHolder.mSetHomeOfficeView.setViewType(1);
        }
    }

    private void bindAddWayViewHolder(AddWayViewHolder addWayViewHolder, HistoryRecordInfo historyRecordInfo, int i) {
        if (historyRecordInfo != null && NaviUtil.isExistedViaPoi(historyRecordInfo.getXPPoiInfo())) {
            addWayViewHolder.mSetWayPointView.getContainerAddWayPoint().setVisibility(8);
            addWayViewHolder.mSetWayPointView.getContainerDeleteWayPoint().setVisibility(0);
            return;
        }
        addWayViewHolder.mSetWayPointView.getContainerAddWayPoint().setVisibility(0);
        addWayViewHolder.mSetWayPointView.getContainerDeleteWayPoint().setVisibility(8);
    }

    private void bindGotoPoiViewHolder(GotoPoiViewHolder gotoPoiViewHolder, HistoryRecordInfo historyRecordInfo, int i) {
        XPPoiInfo xPPoiInfo = historyRecordInfo != null ? historyRecordInfo.getXPPoiInfo() : null;
        if (xPPoiInfo != null && xPPoiInfo.hasDisplayLatLonInfo()) {
            gotoPoiViewHolder.mContainerGotoPoi.setVisibility(0);
            gotoPoiViewHolder.mContainerGotoPoi.setText(NaviUtil.getDistanceString(xPPoiInfo.getDistance()));
            gotoPoiViewHolder.mDestDistance.setVisibility(8);
            return;
        }
        gotoPoiViewHolder.mContainerGotoPoi.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public int getXpItemViewType(int i) {
        HistoryRecordInfo actualItem = getActualItem(i);
        if (actualItem.getHistoryType() == 1) {
            return 1;
        }
        if (actualItem.getHistoryType() == 2) {
            return 2;
        }
        return actualItem.getHistoryType() == 3 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class KeywordViewHolder extends XpSearchViewHolder implements View.OnClickListener, SwipeMenuLayout.MotionEventListener {
        @BindView(R.id.bottom_line)
        XView mBottomLine;
        @BindView(R.id.tv_kwd_delete)
        XTextView mDeleteText;
        @BindView(R.id.iv_ic_check)
        XImageView mIvIcon;
        @BindView(R.id.iv_left_shadow)
        XImageView mIvLeftShadow;
        @BindView(R.id.keyword_item_parent)
        XRelativeLayout mKeywordParent;
        @BindView(R.id.keyword_item_text)
        XTextView mKeywordText;
        @BindView(R.id.search_item_swipe)
        SwipeMenuLayout mSwipeMenuLayout;

        public KeywordViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mKeywordParent.setOnClickListener(this);
            this.mDeleteText.setOnClickListener(this);
            this.mSwipeMenuLayout.setListener(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.xiaopeng.montecarlo.scenes.searchscene.XpSearchViewHolder
        public XPPoiInfo getPoiInfo(int i) {
            HistoryRecordInfo historyRecordInfo;
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (!CollectionUtils.isNotEmpty(data) || i < 0 || i >= data.size() || (historyRecordInfo = data.get(i)) == null) {
                return null;
            }
            return historyRecordInfo.getXPPoiInfo();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int actualPosition = HistoryRecordAdapter.this.getActualPosition(getAdapterPosition());
            HistoryRecordInfo historyRecordInfo = HistoryRecordAdapter.this.getData().get(actualPosition);
            if (HistoryRecordAdapter.this.mAdapterCallback == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.keyword_item_parent) {
                if (historyRecordInfo != null) {
                    HistoryRecordAdapter.this.mAdapterCallback.onItemClick(historyRecordInfo, actualPosition);
                }
            } else if (id == R.id.tv_kwd_delete && historyRecordInfo != null) {
                HistoryRecordAdapter.this.mAdapterCallback.onDel(historyRecordInfo, actualPosition);
            }
        }

        @Override // com.xiaopeng.montecarlo.views.SwipeMenuLayout.MotionEventListener
        public void onHeightChange(int i) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIvLeftShadow.getLayoutParams();
            layoutParams.height = i;
            this.mIvLeftShadow.setLayoutParams(layoutParams);
        }

        @Override // com.xiaopeng.montecarlo.views.SwipeMenuLayout.MotionEventListener
        public void onPositionChange(int i, int i2) {
            this.mIvLeftShadow.setAlpha(i / i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIvLeftShadow.getLayoutParams();
            layoutParams.leftMargin = i;
            this.mIvLeftShadow.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class HistoryRouteHolder extends XpSearchViewHolder implements View.OnClickListener, SwipeMenuLayout.MotionEventListener {
        @BindView(R.id.container_history_route)
        XRelativeLayout mContainerHistoryRoute;
        @BindView(R.id.tv_kwd_delete)
        XTextView mDeleteText;
        @BindView(R.id.view_history_route)
        HistoryRouteView mHistoryRouteView;
        @BindView(R.id.iv_left_shadow)
        XImageView mIvLeftShadow;
        @BindView(R.id.iv_route)
        XImageView mIvRoute;
        @BindView(R.id.search_item_swipe)
        SwipeMenuLayout mSwipeMenuLayout;

        public HistoryRouteHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mContainerHistoryRoute.setOnClickListener(this);
            this.mDeleteText.setOnClickListener(this);
            this.mSwipeMenuLayout.setListener(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.xiaopeng.montecarlo.scenes.searchscene.XpSearchViewHolder
        public XPPoiInfo getPoiInfo(int i) {
            HistoryRecordInfo historyRecordInfo;
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (!CollectionUtils.isNotEmpty(data) || i < 0 || i >= data.size() || (historyRecordInfo = data.get(i)) == null) {
                return null;
            }
            return historyRecordInfo.getXPPoiInfo();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int actualPosition;
            HistoryRecordInfo historyRecordInfo;
            if (HistoryRecordAdapter.this.mAdapterCallback == null || (historyRecordInfo = HistoryRecordAdapter.this.getData().get((actualPosition = HistoryRecordAdapter.this.getActualPosition(getAdapterPosition())))) == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.container_history_route) {
                HistoryRecordAdapter.this.mAdapterCallback.onItemClick(historyRecordInfo, actualPosition);
            } else if (id != R.id.tv_kwd_delete) {
            } else {
                HistoryRecordAdapter.this.mAdapterCallback.onDel(historyRecordInfo, actualPosition);
            }
        }

        @Override // com.xiaopeng.montecarlo.views.SwipeMenuLayout.MotionEventListener
        public void onHeightChange(int i) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIvLeftShadow.getLayoutParams();
            layoutParams.height = i;
            this.mIvLeftShadow.setLayoutParams(layoutParams);
        }

        @Override // com.xiaopeng.montecarlo.views.SwipeMenuLayout.MotionEventListener
        public void onPositionChange(int i, int i2) {
            this.mIvLeftShadow.setAlpha(i / i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIvLeftShadow.getLayoutParams();
            layoutParams.leftMargin = i;
            this.mIvLeftShadow.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class DestCommonViewHolder extends XpSearchViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_dest_item_address_name)
        XTextView mAddressName;
        @BindView(R.id.bottom_line)
        View mBottomLine;
        @BindView(R.id.destination_item_container)
        XRelativeLayout mContainer;
        @BindView(R.id.container_child)
        ChildPoiGridView mContainerChild;
        @BindView(R.id.dest_item_distance)
        XTextView mDestDistance;
        @BindView(R.id.iv_location)
        XImageView mIvLocation;
        @BindView(R.id.tv_dest_item_name)
        XTextView mName;
        @BindView(R.id.search_item_swipe)
        SwipeMenuLayout mSwipeMenuLayout;
        @BindView(R.id.tv_dest_item_address_type)
        XTextView mTvAddressType;
        @BindView(R.id.tv_dest_delete)
        XTextView mTvDestDelete;

        public DestCommonViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mContainer.setOnClickListener(this);
            this.mTvDestDelete.setOnClickListener(this);
            if (com.xiaopeng.montecarlo.util.Utils.isSwipeMenuEnable(HistoryRecordAdapter.this.mSearchMode, HistoryRecordAdapter.this.mSearchDest)) {
                this.mTvDestDelete.setVuiMode(VuiMode.NORMAL);
            } else {
                this.mTvDestDelete.setVuiMode(VuiMode.DISABLED);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.xiaopeng.montecarlo.scenes.searchscene.XpSearchViewHolder
        public XPPoiInfo getPoiInfo(int i) {
            HistoryRecordInfo historyRecordInfo;
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (!CollectionUtils.isNotEmpty(data) || i < 0 || i >= data.size() || (historyRecordInfo = data.get(i)) == null) {
                return null;
            }
            return historyRecordInfo.getXPPoiInfo();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HistoryRecordInfo historyRecordInfo;
            if (HistoryRecordAdapter.this.mAdapterCallback == null) {
                return;
            }
            int actualPosition = HistoryRecordAdapter.this.getActualPosition(getAdapterPosition());
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || (historyRecordInfo = data.get(actualPosition)) == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.destination_item_container) {
                HistoryRecordAdapter.this.mAdapterCallback.onItemClick(historyRecordInfo, actualPosition);
            } else if (id != R.id.tv_dest_delete) {
            } else {
                HistoryRecordAdapter.this.mAdapterCallback.onDel(historyRecordInfo, actualPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class GotoPoiViewHolder extends DestCommonViewHolder implements GotoPoiView.GotoPoiClickListener, SwipeMenuLayout.MotionEventListener {
        @BindView(R.id.container_goto_poi_view)
        GotoPoiView mContainerGotoPoi;
        @BindView(R.id.iv_left_shadow)
        XImageView mIvLeftShadow;

        public GotoPoiViewHolder(View view) {
            super(view);
            this.mContainerGotoPoi.setListener(this);
            this.mSwipeMenuLayout.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.GotoPoiView.GotoPoiClickListener
        public void onClickGotoPoi(View view) {
            HistoryRecordInfo historyRecordInfo;
            super.onClick(view);
            if (HistoryRecordAdapter.this.mAdapterCallback == null) {
                return;
            }
            int actualPosition = HistoryRecordAdapter.this.getActualPosition(getAdapterPosition());
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || (historyRecordInfo = data.get(actualPosition)) == null) {
                return;
            }
            HistoryRecordAdapter.this.mAdapterCallback.onGotoDest(historyRecordInfo, actualPosition);
        }

        @Override // com.xiaopeng.montecarlo.views.SwipeMenuLayout.MotionEventListener
        public void onHeightChange(int i) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIvLeftShadow.getLayoutParams();
            layoutParams.height = i;
            this.mIvLeftShadow.setLayoutParams(layoutParams);
        }

        @Override // com.xiaopeng.montecarlo.views.SwipeMenuLayout.MotionEventListener
        public void onPositionChange(int i, int i2) {
            XImageView xImageView = this.mIvLeftShadow;
            if (xImageView != null && xImageView.getVisibility() != 0) {
                this.mIvLeftShadow.setVisibility(0);
            }
            this.mIvLeftShadow.setAlpha(i / i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class AddWayViewHolder extends DestCommonViewHolder implements SetWayPointView.WayPointClickListener {
        @BindView(R.id.container_set_waypoint)
        SetWayPointView mSetWayPointView;

        public AddWayViewHolder(View view) {
            super(view);
            this.mSetWayPointView.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickAddWayPoint(View view) {
            super.onClick(view);
            if (HistoryRecordAdapter.this.mAdapterCallback == null) {
                L.w(HistoryRecordAdapter.TAG, "onClickAddWayPoint, mAdapterCallback is null");
                return;
            }
            int actualPosition = HistoryRecordAdapter.this.getActualPosition(getAdapterPosition());
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size()) {
                L.Tag tag = HistoryRecordAdapter.TAG;
                L.w(tag, "onClickAddWayPoint, data.size=" + data.size() + ", pos=" + actualPosition);
                return;
            }
            HistoryRecordInfo historyRecordInfo = data.get(actualPosition);
            if (historyRecordInfo == null) {
                L.Tag tag2 = HistoryRecordAdapter.TAG;
                L.w(tag2, "onClickAddWayPoint, info is null, data.size=" + data.size() + ", pos=" + actualPosition);
                return;
            }
            if (L.ENABLE) {
                L.Tag tag3 = HistoryRecordAdapter.TAG;
                L.d(tag3, "onClickAddWayPoint this:" + this);
            }
            HistoryRecordAdapter.this.mAdapterCallback.onAddWay(historyRecordInfo, getAdapterPosition());
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickDeleteWayPoint(View view) {
            HistoryRecordInfo historyRecordInfo;
            super.onClick(view);
            if (HistoryRecordAdapter.this.mAdapterCallback == null) {
                return;
            }
            int actualPosition = HistoryRecordAdapter.this.getActualPosition(getAdapterPosition());
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || (historyRecordInfo = data.get(actualPosition)) == null) {
                return;
            }
            HistoryRecordAdapter.this.mAdapterCallback.onRemoveWay(historyRecordInfo, getAdapterPosition());
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickGotoWayPoint(View view) {
            HistoryRecordInfo historyRecordInfo;
            super.onClick(view);
            if (HistoryRecordAdapter.this.mAdapterCallback == null) {
                return;
            }
            int actualPosition = HistoryRecordAdapter.this.getActualPosition(getAdapterPosition());
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || (historyRecordInfo = data.get(actualPosition)) == null) {
                return;
            }
            HistoryRecordAdapter.this.mAdapterCallback.onNewNavi(historyRecordInfo, getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class SetViewHolder extends DestCommonViewHolder implements SetHomeOfficeView.SetHomeOfficeClickListener {
        @BindView(R.id.container_set_home_office)
        SetHomeOfficeView mSetHomeOfficeView;

        public SetViewHolder(View view) {
            super(view);
            this.mSetHomeOfficeView.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.SetHomeOfficeView.SetHomeOfficeClickListener
        public void onClickSetHome(View view) {
            HistoryRecordInfo historyRecordInfo;
            super.onClick(view);
            if (HistoryRecordAdapter.this.mAdapterCallback == null) {
                return;
            }
            int actualPosition = HistoryRecordAdapter.this.getActualPosition(getAdapterPosition());
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || (historyRecordInfo = data.get(actualPosition)) == null) {
                return;
            }
            HistoryRecordAdapter.this.mAdapterCallback.onSetHome(historyRecordInfo, actualPosition);
        }

        @Override // com.xiaopeng.montecarlo.views.SetHomeOfficeView.SetHomeOfficeClickListener
        public void onClickSetOffice(View view) {
            HistoryRecordInfo historyRecordInfo;
            super.onClick(view);
            if (HistoryRecordAdapter.this.mAdapterCallback == null) {
                return;
            }
            int actualPosition = HistoryRecordAdapter.this.getActualPosition(getAdapterPosition());
            List<HistoryRecordInfo> data = HistoryRecordAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || (historyRecordInfo = data.get(actualPosition)) == null) {
                return;
            }
            HistoryRecordAdapter.this.mAdapterCallback.onSetCompany(historyRecordInfo, actualPosition);
        }
    }
}
