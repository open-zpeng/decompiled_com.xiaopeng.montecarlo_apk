package com.xiaopeng.montecarlo.scenes.searchscene;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.GotoPoiView;
import com.xiaopeng.montecarlo.views.HistoryRouteView;
import com.xiaopeng.montecarlo.views.PageRecyclerAdapter;
import com.xiaopeng.montecarlo.views.SetHomeOfficeView;
import com.xiaopeng.montecarlo.views.SetWayPointView;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SearchAdapter extends PageRecyclerAdapter<XPPoiInfo> {
    private static final int ITEM_TYPE_HEADER = 1;
    private static final int ITEM_TYPE_KEYWORD = 4;
    private static final int ITEM_TYPE_NORMAL = 2;
    private static final int ITEM_TYPE_OFFLINE = 3;
    private static final int ITEM_TYPE_PATH = 5;
    private static final L.Tag TAG = new L.Tag("SearchAdapter");
    private AdapterCallback mAdapterCallback;
    private final Context mContext;
    private View mHeaderView;
    private List<HistoryRecordInfo> mRecordInfos;
    private int mSearchDest;
    private int mSearchMode;
    private int mSearchModeView;
    private ArrayList<XPPoiInfo> mSugDatas;

    /* loaded from: classes3.dex */
    public interface AdapterCallback {
        void onAddWayPoint(int i);

        void onDeleteWayPoint(int i);

        void onGotoPoi(int i);

        void onGotoWayPoint(int i);

        void onItemClick(View view, int i);

        void onSetCompany(int i);

        void onSetHome(int i);
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
    }

    /* loaded from: classes3.dex */
    public class SetViewHolder_ViewBinding extends SuggestCommonViewHolder_ViewBinding {
        private SetViewHolder target;

        @UiThread
        public SetViewHolder_ViewBinding(SetViewHolder setViewHolder, View view) {
            super(setViewHolder, view);
            this.target = setViewHolder;
            setViewHolder.mSetHomeOfficeView = (SetHomeOfficeView) Utils.findRequiredViewAsType(view, R.id.container_set_home_office, "field 'mSetHomeOfficeView'", SetHomeOfficeView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.SuggestCommonViewHolder_ViewBinding, butterknife.Unbinder
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
    public class AddWayViewHolder_ViewBinding extends SuggestCommonViewHolder_ViewBinding {
        private AddWayViewHolder target;

        @UiThread
        public AddWayViewHolder_ViewBinding(AddWayViewHolder addWayViewHolder, View view) {
            super(addWayViewHolder, view);
            this.target = addWayViewHolder;
            addWayViewHolder.mSetWayPointView = (SetWayPointView) Utils.findRequiredViewAsType(view, R.id.container_set_waypoint, "field 'mSetWayPointView'", SetWayPointView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.SuggestCommonViewHolder_ViewBinding, butterknife.Unbinder
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
    public class GotoPoiViewHolder_ViewBinding extends SuggestCommonViewHolder_ViewBinding {
        private GotoPoiViewHolder target;

        @UiThread
        public GotoPoiViewHolder_ViewBinding(GotoPoiViewHolder gotoPoiViewHolder, View view) {
            super(gotoPoiViewHolder, view);
            this.target = gotoPoiViewHolder;
            gotoPoiViewHolder.mContainerGotoPoi = (GotoPoiView) Utils.findRequiredViewAsType(view, R.id.container_goto_poi_view, "field 'mContainerGotoPoi'", GotoPoiView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.SuggestCommonViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            GotoPoiViewHolder gotoPoiViewHolder = this.target;
            if (gotoPoiViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            gotoPoiViewHolder.mContainerGotoPoi = null;
            super.unbind();
        }
    }

    /* loaded from: classes3.dex */
    public class PathViewHolder_ViewBinding implements Unbinder {
        private PathViewHolder target;

        @UiThread
        public PathViewHolder_ViewBinding(PathViewHolder pathViewHolder, View view) {
            this.target = pathViewHolder;
            pathViewHolder.mContainerContent = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.container_content, "field 'mContainerContent'", XRelativeLayout.class);
            pathViewHolder.mIvItemType = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_item_type, "field 'mIvItemType'", XImageView.class);
            pathViewHolder.mHistoryRouteView = (HistoryRouteView) Utils.findRequiredViewAsType(view, R.id.view_history_route, "field 'mHistoryRouteView'", HistoryRouteView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PathViewHolder pathViewHolder = this.target;
            if (pathViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            pathViewHolder.mContainerContent = null;
            pathViewHolder.mIvItemType = null;
            pathViewHolder.mHistoryRouteView = null;
        }
    }

    /* loaded from: classes3.dex */
    public class SuggestCommonViewHolder_ViewBinding implements Unbinder {
        private SuggestCommonViewHolder target;

        @UiThread
        public SuggestCommonViewHolder_ViewBinding(SuggestCommonViewHolder suggestCommonViewHolder, View view) {
            this.target = suggestCommonViewHolder;
            suggestCommonViewHolder.mContainerContent = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.container_content, "field 'mContainerContent'", XRelativeLayout.class);
            suggestCommonViewHolder.mItemDetail = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.suggest_item_detail, "field 'mItemDetail'", XLinearLayout.class);
            suggestCommonViewHolder.mTvDistance = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_distance, "field 'mTvDistance'", XTextView.class);
            suggestCommonViewHolder.mTvName = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'mTvName'", XTextView.class);
            suggestCommonViewHolder.mTvCategory = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_category, "field 'mTvCategory'", XTextView.class);
            suggestCommonViewHolder.mTvAddress = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_address, "field 'mTvAddress'", XTextView.class);
            suggestCommonViewHolder.mIvItemType = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_item_type, "field 'mIvItemType'", XImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            SuggestCommonViewHolder suggestCommonViewHolder = this.target;
            if (suggestCommonViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            suggestCommonViewHolder.mContainerContent = null;
            suggestCommonViewHolder.mItemDetail = null;
            suggestCommonViewHolder.mTvDistance = null;
            suggestCommonViewHolder.mTvName = null;
            suggestCommonViewHolder.mTvCategory = null;
            suggestCommonViewHolder.mTvAddress = null;
            suggestCommonViewHolder.mIvItemType = null;
        }
    }

    public SearchAdapter(Context context, XPRecyclerView<XPPoiInfo> xPRecyclerView) {
        super(context, xPRecyclerView);
        this.mSugDatas = new ArrayList<>();
        this.mRecordInfos = new ArrayList();
        this.mSearchMode = 100;
        this.mSearchDest = 1000;
        this.mSearchModeView = 100;
        this.mHeaderView = null;
        this.mContext = context;
    }

    public void setSearchModeView(int i) {
        this.mSearchModeView = i;
    }

    public void setSearchMode(int i) {
        this.mSearchMode = i;
    }

    public void setSearchDest(int i) {
        this.mSearchDest = i;
    }

    @UiThread
    public void setSugDatas(List<XPPoiInfo> list) {
        if (list == null) {
            return;
        }
        this.mSugDatas.clear();
        this.mSugDatas.addAll(list);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mRecordInfos.size(); i++) {
            HistoryRecordInfo historyRecordInfo = this.mRecordInfos.get(i);
            arrayList.add(historyRecordInfo.getXPPoiInfo());
            if (2 == historyRecordInfo.getHistoryType()) {
                int i2 = 0;
                while (true) {
                    if (i2 < list.size()) {
                        XPPoiInfo xPPoiInfo = list.get(i2);
                        if (NaviUtil.isSamePOI(historyRecordInfo.getXPPoiInfo(), xPPoiInfo)) {
                            if (L.ENABLE) {
                                L.d(TAG, "historyRecordInfo:" + historyRecordInfo + " is same with xpPoiInfo:" + xPPoiInfo);
                            }
                            this.mSugDatas.remove(xPPoiInfo);
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        if (CollectionUtils.isNotEmpty(this.mSugDatas)) {
            arrayList.addAll(this.mSugDatas);
        }
        if (CollectionUtils.isNotEmpty(arrayList)) {
            getData().clear();
            addData(arrayList, true);
            return;
        }
        removeAllItem();
    }

    @UiThread
    public void setRecordInfos(List<HistoryRecordInfo> list) {
        if (list == null) {
            return;
        }
        this.mRecordInfos.clear();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            HistoryRecordInfo historyRecordInfo = list.get(i);
            if (historyRecordInfo != null) {
                this.mRecordInfos.add(historyRecordInfo);
                arrayList.add(historyRecordInfo.getXPPoiInfo());
            }
        }
        if (CollectionUtils.isNotEmpty(this.mSugDatas)) {
            arrayList.addAll(this.mSugDatas);
        }
        if (CollectionUtils.isNotEmpty(arrayList)) {
            getData().clear();
            addData(arrayList, true);
            return;
        }
        removeAllItem();
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public RecyclerView.ViewHolder onCreateXpViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new HeaderViewHolder(getHeaderView());
        }
        if (i == 3) {
            return new OfflineViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_suggest_offline_item, viewGroup, false));
        }
        if (i == 5) {
            return new PathViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_suggest_path_item, viewGroup, false), this.mAdapterCallback);
        }
        if (this.mSearchMode == 102 || this.mSearchModeView == 102) {
            return new AddWayViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_suggest_waypoint_item, viewGroup, false), this.mAdapterCallback);
        }
        int i2 = this.mSearchDest;
        if (i2 == 1001 || i2 == 1002) {
            return new SetViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_suggest_set_item, viewGroup, false), this.mAdapterCallback);
        }
        return new GotoPoiViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_suggest_gotopoi_item, viewGroup, false), this.mAdapterCallback);
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public int getActualPosition(int i) {
        if (this.mHeaderView != null) {
            i--;
        }
        if (showOffLineTip()) {
            i--;
        }
        List<XPPoiInfo> data = getData();
        if (i >= data.size()) {
            i = data.size() - 1;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int actualPosition = getActualPosition(i);
        if (viewHolder instanceof SuggestCommonViewHolder) {
            XPPoiInfo xPPoiInfo = getData().get(actualPosition);
            if (xPPoiInfo == null) {
                return;
            }
            bindSuggestCommonViewHolder((SuggestCommonViewHolder) viewHolder, i, actualPosition, xPPoiInfo);
            if (viewHolder instanceof AddWayViewHolder) {
                bindAddWayViewHolder((AddWayViewHolder) viewHolder, actualPosition, xPPoiInfo);
            } else if (viewHolder instanceof SetViewHolder) {
                bindSetViewHolder((SetViewHolder) viewHolder, actualPosition, xPPoiInfo);
            } else {
                bindGotoPoiViewHolder((GotoPoiViewHolder) viewHolder, actualPosition, xPPoiInfo);
            }
        } else if (viewHolder instanceof PathViewHolder) {
            bindPathViewHolder((PathViewHolder) viewHolder, actualPosition, this.mRecordInfos.get(actualPosition));
        }
    }

    private void bindSuggestCommonViewHolder(SuggestCommonViewHolder suggestCommonViewHolder, int i, int i2, XPPoiInfo xPPoiInfo) {
        if (CollectionUtils.isNotEmpty(this.mRecordInfos) && i < this.mRecordInfos.size()) {
            HistoryRecordInfo historyRecordInfo = this.mRecordInfos.get(i);
            if (historyRecordInfo == null) {
                return;
            }
            if (2 == historyRecordInfo.getHistoryType()) {
                suggestCommonViewHolder.mIvItemType.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_location));
            } else if (1 == historyRecordInfo.getHistoryType()) {
                suggestCommonViewHolder.mIvItemType.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_search_gray));
            }
        } else {
            suggestCommonViewHolder.mIvItemType.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_location));
        }
        String name = xPPoiInfo.getName();
        String key = xPPoiInfo.getKey();
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(name) && name.contains(key)) {
            SpannableString spannableString = new SpannableString(name);
            int color = ThemeWatcherUtil.getColor(R.color.common_blue);
            int indexOf = name.indexOf(key);
            spannableString.setSpan(new ForegroundColorSpan(color), indexOf, key.length() + indexOf, 33);
            suggestCommonViewHolder.mTvName.setText(spannableString);
        } else {
            suggestCommonViewHolder.mTvName.setText(name);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(NaviUtil.getDistanceNoSpaceString((long) xPPoiInfo.getDistance()));
        String tag = xPPoiInfo.getTag();
        suggestCommonViewHolder.mTvCategory.setText(tag);
        if (TextUtils.isEmpty(tag)) {
            sb.append(ContextUtils.getString(R.string.favorite_item_space_text));
            suggestCommonViewHolder.mTvCategory.setVisibility(8);
        } else {
            sb.append(ContextUtils.getString(R.string.favorite_item_dot_text));
            suggestCommonViewHolder.mTvCategory.setVisibility(0);
        }
        if (!xPPoiInfo.hasDisplayLatLonInfo()) {
            suggestCommonViewHolder.mTvDistance.setVisibility(8);
        } else {
            suggestCommonViewHolder.mTvDistance.setVisibility(0);
            suggestCommonViewHolder.mTvDistance.setText(sb);
        }
        String address = com.xiaopeng.montecarlo.util.Utils.getAddress(xPPoiInfo);
        suggestCommonViewHolder.mTvAddress.setText(address);
        if (TextUtils.isEmpty(address)) {
            suggestCommonViewHolder.mTvAddress.setVisibility(8);
        } else {
            suggestCommonViewHolder.mTvAddress.setVisibility(0);
        }
    }

    private void bindSetViewHolder(SetViewHolder setViewHolder, int i, XPPoiInfo xPPoiInfo) {
        int i2 = this.mSearchDest;
        if (i2 == 1001) {
            setViewHolder.mSetHomeOfficeView.setViewType(0);
            if (!xPPoiInfo.hasDisplayLatLonInfo()) {
                setViewHolder.mSetHomeOfficeView.setVisibility(8);
            } else {
                setViewHolder.mSetHomeOfficeView.setVisibility(0);
            }
        } else if (i2 == 1002) {
            setViewHolder.mSetHomeOfficeView.setViewType(1);
            if (!xPPoiInfo.hasDisplayLatLonInfo()) {
                setViewHolder.mSetHomeOfficeView.setVisibility(8);
            } else {
                setViewHolder.mSetHomeOfficeView.setVisibility(0);
            }
        }
    }

    private void bindAddWayViewHolder(AddWayViewHolder addWayViewHolder, int i, XPPoiInfo xPPoiInfo) {
        if (!xPPoiInfo.hasDisplayLatLonInfo()) {
            addWayViewHolder.mSetWayPointView.getContainerGotoWayPoint().setVisibility(8);
            addWayViewHolder.mSetWayPointView.getContainerAddWayPoint().setVisibility(8);
            addWayViewHolder.mSetWayPointView.getContainerDeleteWayPoint().setVisibility(8);
            return;
        }
        addWayViewHolder.mSetWayPointView.getContainerGotoWayPoint().setVisibility(0);
        if (xPPoiInfo != null && NaviUtil.isExistedViaPoi(xPPoiInfo)) {
            addWayViewHolder.mSetWayPointView.getContainerAddWayPoint().setVisibility(8);
            addWayViewHolder.mSetWayPointView.getContainerDeleteWayPoint().setVisibility(0);
            return;
        }
        addWayViewHolder.mSetWayPointView.getContainerAddWayPoint().setVisibility(0);
        addWayViewHolder.mSetWayPointView.getContainerDeleteWayPoint().setVisibility(8);
    }

    private void bindGotoPoiViewHolder(GotoPoiViewHolder gotoPoiViewHolder, int i, XPPoiInfo xPPoiInfo) {
        if (!xPPoiInfo.hasDisplayLatLonInfo()) {
            gotoPoiViewHolder.mContainerGotoPoi.setVisibility(8);
            return;
        }
        String distanceString = NaviUtil.getDistanceString(xPPoiInfo.getDistance());
        gotoPoiViewHolder.mContainerGotoPoi.setVisibility(0);
        gotoPoiViewHolder.mContainerGotoPoi.setText(distanceString);
        gotoPoiViewHolder.mTvDistance.setVisibility(8);
    }

    private void bindPathViewHolder(PathViewHolder pathViewHolder, int i, HistoryRecordInfo historyRecordInfo) {
        pathViewHolder.mIvItemType.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_historyroute));
        pathViewHolder.mHistoryRouteView.updateContent(historyRecordInfo);
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public void setHeaderView(View view) {
        this.mHeaderView = view;
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public int getXpItemViewType(int i) {
        int i2 = this.mHeaderView != null ? 1 : 0;
        if (i != 0 || this.mHeaderView == null) {
            if (i2 == i && showOffLineTip()) {
                return 3;
            }
            List<HistoryRecordInfo> list = this.mRecordInfos;
            return (list == null || i >= list.size() || 3 != this.mRecordInfos.get(i).getHistoryType()) ? 2 : 5;
        }
        return 1;
    }

    private boolean showOffLineTip() {
        return CollectionUtils.isNotEmpty(this.mSugDatas) && this.mSugDatas.get(0).isOffline();
    }

    public List<HistoryRecordInfo> getMatchedHistory() {
        return this.mRecordInfos;
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public int getXpItemCount() {
        List<XPPoiInfo> data = getData();
        if (CollectionUtils.isEmpty(data)) {
            return 0;
        }
        int size = data.size();
        if (this.mHeaderView != null) {
            size++;
        }
        return showOffLineTip() ? size + 1 : size;
    }

    public void setAdapterCallback(AdapterCallback adapterCallback) {
        this.mAdapterCallback = adapterCallback;
    }

    public void clean() {
        this.mSugDatas.clear();
        this.mRecordInfos.clear();
        setData(null);
    }

    /* loaded from: classes3.dex */
    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class PathViewHolder extends XpSearchViewHolder implements View.OnClickListener {
        AdapterCallback mCallback;
        @BindView(R.id.container_content)
        XRelativeLayout mContainerContent;
        @BindView(R.id.view_history_route)
        HistoryRouteView mHistoryRouteView;
        @BindView(R.id.iv_item_type)
        XImageView mIvItemType;

        public PathViewHolder(View view, AdapterCallback adapterCallback) {
            super(view);
            this.mCallback = null;
            ButterKnife.bind(this, view);
            this.mContainerContent.setOnClickListener(this);
            this.mCallback = adapterCallback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdapterCallback adapterCallback;
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || view.getId() != R.id.container_content || (adapterCallback = this.mCallback) == null) {
                return;
            }
            adapterCallback.onItemClick(this.mContainerContent, adapterPosition);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.xiaopeng.montecarlo.scenes.searchscene.XpSearchViewHolder
        public XPPoiInfo getPoiInfo(int i) {
            List<XPPoiInfo> data = SearchAdapter.this.getData();
            if (!CollectionUtils.isNotEmpty(data) || i < 0 || i >= data.size()) {
                return null;
            }
            return data.get(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class SuggestCommonViewHolder extends XpSearchViewHolder implements View.OnClickListener {
        AdapterCallback mCallback;
        @BindView(R.id.container_content)
        XRelativeLayout mContainerContent;
        @BindView(R.id.suggest_item_detail)
        XLinearLayout mItemDetail;
        @BindView(R.id.iv_item_type)
        XImageView mIvItemType;
        @BindView(R.id.tv_address)
        XTextView mTvAddress;
        @BindView(R.id.tv_category)
        XTextView mTvCategory;
        @BindView(R.id.tv_distance)
        XTextView mTvDistance;
        @BindView(R.id.tv_name)
        XTextView mTvName;

        public SuggestCommonViewHolder(View view, AdapterCallback adapterCallback) {
            super(view);
            this.mCallback = null;
            ButterKnife.bind(this, view);
            this.mContainerContent.setOnClickListener(this);
            this.mCallback = adapterCallback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdapterCallback adapterCallback;
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || view.getId() != R.id.container_content || (adapterCallback = this.mCallback) == null) {
                return;
            }
            adapterCallback.onItemClick(this.mContainerContent, adapterPosition);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.xiaopeng.montecarlo.scenes.searchscene.XpSearchViewHolder
        public XPPoiInfo getPoiInfo(int i) {
            List<XPPoiInfo> data = SearchAdapter.this.getData();
            if (!CollectionUtils.isNotEmpty(data) || i < 0 || i >= data.size()) {
                return null;
            }
            return data.get(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class GotoPoiViewHolder extends SuggestCommonViewHolder implements GotoPoiView.GotoPoiClickListener {
        @BindView(R.id.container_goto_poi_view)
        GotoPoiView mContainerGotoPoi;

        public GotoPoiViewHolder(View view, AdapterCallback adapterCallback) {
            super(view, adapterCallback);
            this.mContainerGotoPoi.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.GotoPoiView.GotoPoiClickListener
        public void onClickGotoPoi(View view) {
            super.onClick(view);
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || this.mCallback == null) {
                return;
            }
            this.mCallback.onGotoPoi(adapterPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class SetViewHolder extends SuggestCommonViewHolder implements SetHomeOfficeView.SetHomeOfficeClickListener {
        @BindView(R.id.container_set_home_office)
        SetHomeOfficeView mSetHomeOfficeView;

        public SetViewHolder(View view, AdapterCallback adapterCallback) {
            super(view, adapterCallback);
            this.mSetHomeOfficeView.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.SetHomeOfficeView.SetHomeOfficeClickListener
        public void onClickSetHome(View view) {
            super.onClick(view);
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || this.mCallback == null) {
                return;
            }
            this.mCallback.onSetHome(adapterPosition);
        }

        @Override // com.xiaopeng.montecarlo.views.SetHomeOfficeView.SetHomeOfficeClickListener
        public void onClickSetOffice(View view) {
            super.onClick(view);
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || this.mCallback == null) {
                return;
            }
            this.mCallback.onSetCompany(adapterPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class AddWayViewHolder extends SuggestCommonViewHolder implements SetWayPointView.WayPointClickListener {
        @BindView(R.id.container_set_waypoint)
        SetWayPointView mSetWayPointView;

        public AddWayViewHolder(View view, AdapterCallback adapterCallback) {
            super(view, adapterCallback);
            this.mSetWayPointView.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickAddWayPoint(View view) {
            super.onClick(view);
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || this.mCallback == null) {
                return;
            }
            this.mCallback.onAddWayPoint(adapterPosition);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickDeleteWayPoint(View view) {
            super.onClick(view);
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || this.mCallback == null) {
                return;
            }
            this.mCallback.onDeleteWayPoint(adapterPosition);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickGotoWayPoint(View view) {
            super.onClick(view);
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || this.mCallback == null) {
                return;
            }
            this.mCallback.onGotoWayPoint(adapterPosition);
        }
    }

    /* loaded from: classes3.dex */
    class OfflineViewHolder extends RecyclerView.ViewHolder {
        public OfflineViewHolder(View view) {
            super(view);
        }
    }
}
