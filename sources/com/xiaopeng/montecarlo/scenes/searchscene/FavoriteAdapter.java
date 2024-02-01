package com.xiaopeng.montecarlo.scenes.searchscene;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.SystemClock;
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
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.GotoPoiView;
import com.xiaopeng.montecarlo.views.PageRecyclerAdapter;
import com.xiaopeng.montecarlo.views.SetWayPointView;
import com.xiaopeng.montecarlo.views.SwipeMenuLayout;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.List;
/* loaded from: classes3.dex */
public class FavoriteAdapter extends PageRecyclerAdapter<FavoriteAddress> {
    private static final long MULTI_CLICK_INTERVAL = 800;
    private static final L.Tag TAG = new L.Tag(FavoriteAdapter.class.getSimpleName());
    private AdapterCallback mAdapterCallback;
    private Context mContext;
    private long mLastClickTime;
    private int mSearchDest;
    private int mSearchMode;
    private int mSearchModeView;

    /* loaded from: classes3.dex */
    public interface AdapterCallback {
        void onAddWay(int i, FavoriteAddress favoriteAddress);

        void onDel(int i, FavoriteAddress favoriteAddress);

        void onGotoPoi(int i, FavoriteAddress favoriteAddress);

        void onItemClick(int i, FavoriteAddress favoriteAddress);

        void onNewNavi(int i, FavoriteAddress favoriteAddress);

        void onRemoveWay(int i, FavoriteAddress favoriteAddress);

        void onSetCompany(int i, FavoriteAddress favoriteAddress);

        void onSetHome(int i, FavoriteAddress favoriteAddress);

        void onStarIconClick(int i, FavoriteAddress favoriteAddress);
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
    }

    /* loaded from: classes3.dex */
    public class AddWayViewHolder_ViewBinding extends CommonViewHolder_ViewBinding {
        private AddWayViewHolder target;

        @UiThread
        public AddWayViewHolder_ViewBinding(AddWayViewHolder addWayViewHolder, View view) {
            super(addWayViewHolder, view);
            this.target = addWayViewHolder;
            addWayViewHolder.mSetWayPointView = (SetWayPointView) Utils.findRequiredViewAsType(view, R.id.container_set_waypoint, "field 'mSetWayPointView'", SetWayPointView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.CommonViewHolder_ViewBinding, butterknife.Unbinder
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
    public class GotoPoiViewHolder_ViewBinding extends CommonViewHolder_ViewBinding {
        private GotoPoiViewHolder target;

        @UiThread
        public GotoPoiViewHolder_ViewBinding(GotoPoiViewHolder gotoPoiViewHolder, View view) {
            super(gotoPoiViewHolder, view);
            this.target = gotoPoiViewHolder;
            gotoPoiViewHolder.mContainerGotoPoi = (GotoPoiView) Utils.findRequiredViewAsType(view, R.id.container_goto_poi_view, "field 'mContainerGotoPoi'", GotoPoiView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.CommonViewHolder_ViewBinding, butterknife.Unbinder
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
    public class CommonViewHolder_ViewBinding implements Unbinder {
        private CommonViewHolder target;

        @UiThread
        public CommonViewHolder_ViewBinding(CommonViewHolder commonViewHolder, View view) {
            this.target = commonViewHolder;
            commonViewHolder.mSwipeMenuLayout = (SwipeMenuLayout) Utils.findRequiredViewAsType(view, R.id.search_item_swipe, "field 'mSwipeMenuLayout'", SwipeMenuLayout.class);
            commonViewHolder.mContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.favorite_item_container, "field 'mContainer'", XRelativeLayout.class);
            commonViewHolder.mTvName = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_name, "field 'mTvName'", XTextView.class);
            commonViewHolder.mFavoriteDistance = (XTextView) Utils.findRequiredViewAsType(view, R.id.favorite_item_distance, "field 'mFavoriteDistance'", XTextView.class);
            commonViewHolder.mTvAddress = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_address_name, "field 'mTvAddress'", XTextView.class);
            commonViewHolder.mTvAddressType = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_address_type, "field 'mTvAddressType'", XTextView.class);
            commonViewHolder.mDelete = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_favorite_delete, "field 'mDelete'", XTextView.class);
            commonViewHolder.mIvStar = (XImageView) Utils.findRequiredViewAsType(view, R.id.favorite_item_star_icon, "field 'mIvStar'", XImageView.class);
            commonViewHolder.mBottomLine = (XView) Utils.findRequiredViewAsType(view, R.id.bottom_line, "field 'mBottomLine'", XView.class);
            commonViewHolder.mIvLeftShadow = (XImageView) Utils.findRequiredViewAsType(view, R.id.iv_left_shadow, "field 'mIvLeftShadow'", XImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CommonViewHolder commonViewHolder = this.target;
            if (commonViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            commonViewHolder.mSwipeMenuLayout = null;
            commonViewHolder.mContainer = null;
            commonViewHolder.mTvName = null;
            commonViewHolder.mFavoriteDistance = null;
            commonViewHolder.mTvAddress = null;
            commonViewHolder.mTvAddressType = null;
            commonViewHolder.mDelete = null;
            commonViewHolder.mIvStar = null;
            commonViewHolder.mBottomLine = null;
            commonViewHolder.mIvLeftShadow = null;
        }
    }

    public FavoriteAdapter(Context context, XPRecyclerView<FavoriteAddress> xPRecyclerView, int i, int i2, int i3) {
        super(context, xPRecyclerView);
        this.mAdapterCallback = null;
        this.mSearchMode = 100;
        this.mSearchDest = 1000;
        this.mSearchModeView = 100;
        this.mContext = context;
        this.mSearchMode = i;
        this.mSearchDest = i2;
        this.mSearchModeView = i3;
    }

    public void notifyChangeForDelete(boolean z, int i) {
        if (z) {
            removeAllItem();
        } else {
            removeItem(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public RecyclerView.ViewHolder onCreateXpViewHolder(ViewGroup viewGroup, int i) {
        if (this.mSearchMode == 102 || this.mSearchModeView == 102) {
            return new AddWayViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_favorite_waypoint_item, (ViewGroup) null, false));
        }
        return new GotoPoiViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_favorite_gotopoi_item, (ViewGroup) null, false));
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int actualPosition = getActualPosition(i);
        FavoriteAddress actualItem = getActualItem(i);
        if (viewHolder instanceof CommonViewHolder) {
            onBindCommonViewHolder((CommonViewHolder) viewHolder, actualItem, actualPosition);
        }
        if (viewHolder instanceof AddWayViewHolder) {
            onBindAddWayViewHolder((AddWayViewHolder) viewHolder, actualItem, actualPosition);
        } else {
            onBindGotoPoiViewHolder((GotoPoiViewHolder) viewHolder, actualItem, actualPosition);
        }
    }

    private void onBindCommonViewHolder(CommonViewHolder commonViewHolder, FavoriteAddress favoriteAddress, int i) {
        XPPoiInfo xPPoiInfo = favoriteAddress.getXPPoiInfo();
        if (favoriteAddress.isCancelFavorite()) {
            commonViewHolder.mIvStar.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_24_normal_ic_collection_off));
        } else {
            commonViewHolder.mIvStar.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_24_normal_ic_collection_on));
        }
        if (!TextUtils.isEmpty(favoriteAddress.getBLCustomName())) {
            commonViewHolder.mTvName.setText(favoriteAddress.getBLCustomName());
        } else {
            commonViewHolder.mTvName.setText(xPPoiInfo.getName());
        }
        L.Tag tag = TAG;
        L.i(tag, "favorite item index:" + i + ",name:" + xPPoiInfo.getName());
        StringBuilder sb = new StringBuilder();
        sb.append(NaviUtil.getDistanceNoSpaceString((long) xPPoiInfo.getDistance()));
        if (TextUtils.isEmpty(xPPoiInfo.getTag())) {
            sb.append(ContextUtils.getString(R.string.favorite_item_space_text));
            commonViewHolder.mTvAddressType.setVisibility(8);
        } else {
            sb.append(ContextUtils.getString(R.string.favorite_item_dot_text));
            commonViewHolder.mTvAddressType.setVisibility(0);
            commonViewHolder.mTvAddressType.setText(xPPoiInfo.getTag());
        }
        commonViewHolder.mFavoriteDistance.setText(sb);
        commonViewHolder.mTvAddress.setText(com.xiaopeng.montecarlo.util.Utils.getAddress(xPPoiInfo));
        if (favoriteAddress.isHasClicked()) {
            ColorStateList clickTextColor = getClickTextColor();
            commonViewHolder.mTvName.setTextColor(clickTextColor);
            commonViewHolder.mFavoriteDistance.setTextColor(clickTextColor);
            commonViewHolder.mTvAddress.setTextColor(clickTextColor);
            commonViewHolder.mTvAddressType.setTextColor(clickTextColor);
        } else {
            commonViewHolder.mTvName.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
            commonViewHolder.mFavoriteDistance.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
            commonViewHolder.mTvAddressType.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
            commonViewHolder.mTvAddress.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text03));
        }
        commonViewHolder.mBottomLine.setBackgroundColor(ThemeWatcherUtil.getColor(R.color.search_divider_bg));
    }

    private ColorStateList getClickTextColor() {
        return ContextUtils.getColorStateList(R.color.primary_text03);
    }

    private void onBindGotoPoiViewHolder(GotoPoiViewHolder gotoPoiViewHolder, FavoriteAddress favoriteAddress, int i) {
        XPPoiInfo xPPoiInfo;
        if (favoriteAddress == null || (xPPoiInfo = favoriteAddress.getXPPoiInfo()) == null) {
            return;
        }
        String distanceString = NaviUtil.getDistanceString(xPPoiInfo.getDistance());
        if (xPPoiInfo.hasDisplayLatLonInfo()) {
            gotoPoiViewHolder.mContainerGotoPoi.setVisibility(0);
            gotoPoiViewHolder.mContainerGotoPoi.setText(distanceString);
            return;
        }
        gotoPoiViewHolder.mContainerGotoPoi.setVisibility(8);
    }

    private void onBindAddWayViewHolder(AddWayViewHolder addWayViewHolder, FavoriteAddress favoriteAddress, int i) {
        if (favoriteAddress != null && NaviUtil.isExistedViaPoi(favoriteAddress.getXPPoiInfo())) {
            addWayViewHolder.mSetWayPointView.getContainerAddWayPoint().setVisibility(8);
            addWayViewHolder.mSetWayPointView.getContainerDeleteWayPoint().setVisibility(0);
            return;
        }
        addWayViewHolder.mSetWayPointView.getContainerAddWayPoint().setVisibility(0);
        addWayViewHolder.mSetWayPointView.getContainerDeleteWayPoint().setVisibility(8);
    }

    public void setAdapterCallback(AdapterCallback adapterCallback) {
        this.mAdapterCallback = adapterCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean preventMultiClick() {
        boolean z = SystemClock.elapsedRealtime() - this.mLastClickTime >= MULTI_CLICK_INTERVAL;
        this.mLastClickTime = SystemClock.elapsedRealtime();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class CommonViewHolder extends XpSearchViewHolder implements View.OnClickListener, SwipeMenuLayout.MotionEventListener {
        @BindView(R.id.bottom_line)
        XView mBottomLine;
        @BindView(R.id.favorite_item_container)
        XRelativeLayout mContainer;
        @BindView(R.id.tv_favorite_delete)
        XTextView mDelete;
        @BindView(R.id.favorite_item_distance)
        XTextView mFavoriteDistance;
        @BindView(R.id.iv_left_shadow)
        XImageView mIvLeftShadow;
        @BindView(R.id.favorite_item_star_icon)
        XImageView mIvStar;
        @BindView(R.id.search_item_swipe)
        SwipeMenuLayout mSwipeMenuLayout;
        @BindView(R.id.search_result_address_name)
        XTextView mTvAddress;
        @BindView(R.id.search_result_address_type)
        XTextView mTvAddressType;
        @BindView(R.id.search_result_name)
        XTextView mTvName;

        public CommonViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mContainer.setOnClickListener(this);
            this.mDelete.setOnClickListener(this);
            this.mSwipeMenuLayout.setListener(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.xiaopeng.montecarlo.scenes.searchscene.XpSearchViewHolder
        public XPPoiInfo getPoiInfo(int i) {
            FavoriteAddress favoriteAddress;
            List<FavoriteAddress> data = FavoriteAdapter.this.getData();
            if (!CollectionUtils.isNotEmpty(data) || i < 0 || i >= data.size() || (favoriteAddress = data.get(i)) == null) {
                return null;
            }
            return favoriteAddress.getXPPoiInfo();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FavoriteAdapter.this.preventMultiClick()) {
                int actualPosition = FavoriteAdapter.this.getActualPosition(getAdapterPosition());
                List<FavoriteAddress> data = FavoriteAdapter.this.getData();
                if (actualPosition < 0 || actualPosition >= data.size() || FavoriteAdapter.this.mAdapterCallback == null) {
                    return;
                }
                FavoriteAddress favoriteAddress = data.get(actualPosition);
                int id = view.getId();
                if (id == R.id.favorite_item_container) {
                    if (favoriteAddress == null || actualPosition == -1) {
                        return;
                    }
                    FavoriteAdapter.this.mAdapterCallback.onItemClick(actualPosition, favoriteAddress);
                } else if (id == R.id.favorite_item_star_icon || id != R.id.tv_favorite_delete || favoriteAddress == null) {
                } else {
                    FavoriteAdapter.this.mAdapterCallback.onDel(actualPosition, favoriteAddress);
                }
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
            this.mIvLeftShadow.setAlpha(i2 != 0 ? i / i2 : 0.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIvLeftShadow.getLayoutParams();
            layoutParams.leftMargin = i;
            this.mIvLeftShadow.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class AddWayViewHolder extends CommonViewHolder implements SetWayPointView.WayPointClickListener {
        @BindView(R.id.container_set_waypoint)
        SetWayPointView mSetWayPointView;

        public AddWayViewHolder(View view) {
            super(view);
            this.mSetWayPointView.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickAddWayPoint(View view) {
            FavoriteAddress favoriteAddress;
            super.onClick(view);
            int actualPosition = FavoriteAdapter.this.getActualPosition(getAdapterPosition());
            List<FavoriteAddress> data = FavoriteAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || FavoriteAdapter.this.mAdapterCallback == null || (favoriteAddress = data.get(actualPosition)) == null) {
                return;
            }
            FavoriteAdapter.this.mAdapterCallback.onAddWay(actualPosition, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickDeleteWayPoint(View view) {
            FavoriteAddress favoriteAddress;
            super.onClick(view);
            int actualPosition = FavoriteAdapter.this.getActualPosition(getAdapterPosition());
            List<FavoriteAddress> data = FavoriteAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || FavoriteAdapter.this.mAdapterCallback == null || (favoriteAddress = data.get(actualPosition)) == null) {
                return;
            }
            FavoriteAdapter.this.mAdapterCallback.onRemoveWay(actualPosition, favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickGotoWayPoint(View view) {
            FavoriteAddress favoriteAddress;
            super.onClick(view);
            int actualPosition = FavoriteAdapter.this.getActualPosition(getAdapterPosition());
            List<FavoriteAddress> data = FavoriteAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || FavoriteAdapter.this.mAdapterCallback == null || (favoriteAddress = data.get(actualPosition)) == null) {
                return;
            }
            FavoriteAdapter.this.mAdapterCallback.onNewNavi(actualPosition, favoriteAddress);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class GotoPoiViewHolder extends CommonViewHolder implements GotoPoiView.GotoPoiClickListener {
        @BindView(R.id.container_goto_poi_view)
        GotoPoiView mContainerGotoPoi;

        public GotoPoiViewHolder(View view) {
            super(view);
            this.mContainerGotoPoi.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.GotoPoiView.GotoPoiClickListener
        public void onClickGotoPoi(View view) {
            FavoriteAddress favoriteAddress;
            super.onClick(view);
            int actualPosition = FavoriteAdapter.this.getActualPosition(getAdapterPosition());
            List<FavoriteAddress> data = FavoriteAdapter.this.getData();
            if (actualPosition < 0 || actualPosition >= data.size() || FavoriteAdapter.this.mAdapterCallback == null || (favoriteAddress = data.get(actualPosition)) == null) {
                return;
            }
            FavoriteAdapter.this.mAdapterCallback.onGotoPoi(actualPosition, favoriteAddress);
        }
    }
}
