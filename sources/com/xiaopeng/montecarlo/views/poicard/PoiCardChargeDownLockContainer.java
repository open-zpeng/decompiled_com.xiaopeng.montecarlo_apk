package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviPoiChargeStationInfo;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeDataException;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeDataProvider;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.views.poicard.PoiCardChargeDownLockContainer;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.widget.XRecyclerView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import io.reactivex.observers.DisposableObserver;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardChargeDownLockContainer extends XRelativeLayout implements BasePoiCardViewContract {
    public static final String KEY_POI_INFO = "poiInfo";
    private static final L.Tag TAG = new L.Tag("PoiCardChargeDownLock");
    ChargeDataProvider mChargeDataProvider;
    private Context mContext;
    DownLockAdapter mDownLockAdapter;
    DownLockItemDecoration mDownLockItemDecoration;
    private XRecyclerView mDownLockListV;
    private Boolean mIsSettingHomeOrOffice;
    private OnChildLayoutCompletedListener mLayoutListener;
    GridLayoutManager mLayoutManager;
    private View mNoLockV;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    public PoiCardChargeDownLockContainer(Context context) {
        super(context);
        this.mChargeDataProvider = new ChargeDataProvider();
        this.mDownLockItemDecoration = new DownLockItemDecoration();
        this.mLayoutManager = new GridLayoutManager(getContext(), 3);
    }

    public PoiCardChargeDownLockContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChargeDataProvider = new ChargeDataProvider();
        this.mDownLockItemDecoration = new DownLockItemDecoration();
        this.mLayoutManager = new GridLayoutManager(getContext(), 3);
    }

    public PoiCardChargeDownLockContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        this(context);
        this.mContext = context;
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
        this.mChargeDataProvider.cancelAllRequest();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        initView();
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.layout_charge_down_lock_for_poi_card, (ViewGroup) this, true);
        this.mNoLockV = this.mRootView.findViewById(R.id.tv_no_lock);
        this.mDownLockListV = (XRecyclerView) this.mRootView.findViewById(R.id.down_lock_list);
        this.mDownLockListV.addItemDecoration(this.mDownLockItemDecoration);
        this.mDownLockAdapter = new DownLockAdapter();
        this.mDownLockListV.setLayoutManager(this.mLayoutManager);
        this.mDownLockListV.setAdapter(this.mDownLockAdapter);
        executeAfterViewInflated(this.mRootView);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        onInitOrThemeSwitch();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
        renderDownLockInfo();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        this.mLayoutListener = onChildLayoutCompletedListener;
        formatParams(context, map);
        executeViewOperation();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void formatParams(Context context, Map<String, Object> map) {
        if (map == null) {
            throw new IllegalArgumentException("params can not be null");
        }
        if (map.get("poiInfo") != null) {
            this.mPoiInfo = (XPPoiInfo) map.get("poiInfo");
        }
        if (map.get("isSettingHomeOrOffice") != null) {
            this.mIsSettingHomeOrOffice = (Boolean) map.get("isSettingHomeOrOffice");
        }
    }

    private void renderDownLockInfo() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        XPDeepInfoPoi xPDeepInfoPoi = xPPoiInfo.getXPDeepInfoPoi();
        XPDeepCharging xPDeepCharging = null;
        if (xPDeepInfoPoi != null && xPDeepInfoPoi.getChargeData() != null && xPDeepInfoPoi.getChargeData().length > 0) {
            xPDeepCharging = xPDeepInfoPoi.getChargeData()[0];
        }
        if (xPDeepCharging != null) {
            renderChargeView(xPDeepCharging);
        }
    }

    private void renderChargeView(@NonNull XPDeepCharging xPDeepCharging) {
        if (!XPPoiCategory.isXPSelfCharge(this.mPoiInfo.getCategory()) || this.mIsSettingHomeOrOffice.booleanValue() || !XPAccountServiceWrapper.getInstance().isLoginXp() || CollectionUtils.isEmpty(xPDeepCharging.getGunInfoList())) {
            setVisibility(8);
            this.mDownLockAdapter.setData(null);
            return;
        }
        setVisibility(0);
        this.mNoLockV.setVisibility(8);
        this.mDownLockListV.setVisibility(0);
        if (hasRenderedSameGunInfo(this.mDownLockAdapter.getData(), xPDeepCharging.getGunInfoList())) {
            L.i(TAG, "gun info list is rendered,skip render");
            return;
        }
        if (TextUtils.equals(xPDeepCharging.getGunInfoList().get(0).getBookingType(), "2")) {
            if (xPDeepCharging.getGunInfoList().size() > 1) {
                L.e(TAG, "booking type booked by user more than 1!");
                return;
            } else {
                this.mLayoutManager.setSpanCount(1);
                this.mDownLockItemDecoration.setMargin(0, 0);
            }
        } else {
            this.mLayoutManager.setSpanCount(3);
            this.mDownLockItemDecoration.setMargin(getResources().getDimensionPixelOffset(R.dimen.pop_charge_down_lock_item_margin_right), getResources().getDimensionPixelOffset(R.dimen.pop_charge_down_lock_item_margin_bottom));
        }
        this.mDownLockAdapter.setData(xPDeepCharging.getGunInfoList());
    }

    private boolean hasRenderedSameGunInfo(List<NaviPoiChargeStationInfo.GunInfo> list, List<NaviPoiChargeStationInfo.GunInfo> list2) {
        if (CollectionUtils.isEmpty(list) || CollectionUtils.isEmpty(list2) || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getGunId() != list2.get(i).getGunId()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class DownLockAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public static final int VIEW_TYPE_AVAILABLE = 2;
        public static final int VIEW_TYPE_SINGLE_BOOKED = 1;
        private List<NaviPoiChargeStationInfo.GunInfo> mGunInfoList;

        DownLockAdapter() {
        }

        public void setData(List<NaviPoiChargeStationInfo.GunInfo> list) {
            this.mGunInfoList = list;
            notifyDataSetChanged();
        }

        public List<NaviPoiChargeStationInfo.GunInfo> getData() {
            return this.mGunInfoList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new BookedDownLockItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_charge_down_lock_item_booked, viewGroup, false));
            }
            return new NormalDownLockItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_charge_down_lock_item_normal, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof NormalDownLockItemHolder) {
                ((NormalDownLockItemHolder) viewHolder).bindItemData(getItem(i));
            } else if (viewHolder instanceof BookedDownLockItemHolder) {
                ((BookedDownLockItemHolder) viewHolder).bindItemData(getItem(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return TextUtils.equals(this.mGunInfoList.get(i).getBookingType(), "2") ? 1 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<NaviPoiChargeStationInfo.GunInfo> list = this.mGunInfoList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public NaviPoiChargeStationInfo.GunInfo getItem(int i) {
            if (i >= getItemCount()) {
                return null;
            }
            return this.mGunInfoList.get(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DownLockItemDecoration extends RecyclerView.ItemDecoration {
        private int mMarginBottom;
        private int mMarginRight;

        DownLockItemDecoration() {
        }

        public void setMargin(int i, int i2) {
            this.mMarginRight = i;
            this.mMarginBottom = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if ((childAdapterPosition + 1) % 3 != 0) {
                rect.right = this.mMarginRight;
            }
            if (childAdapterPosition < 3) {
                rect.bottom = this.mMarginBottom;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class BaseDownLockItemHolder extends RecyclerView.ViewHolder {
        XTextView mDownLockItem;
        NaviPoiChargeStationInfo.GunInfo mGunInfo;
        private final CountDownTimer mUnlockCountDown;

        public BaseDownLockItemHolder(@NonNull View view) {
            super(view);
            this.mUnlockCountDown = new CountDownTimer(UILooperObserver.ANR_TRIGGER_TIME, 1000L) { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardChargeDownLockContainer.BaseDownLockItemHolder.1
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    BaseDownLockItemHolder.this.mDownLockItem.setText(String.format(ContextUtils.getString(R.string.poi_charge_down_lock_processing), Long.valueOf((j / 1000) + 1)));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    BaseDownLockItemHolder.this.refreshItem();
                }
            };
            this.mDownLockItem = (XTextView) view.findViewById(R.id.down_lock_btn);
            this.mDownLockItem.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.poicard.-$$Lambda$PoiCardChargeDownLockContainer$BaseDownLockItemHolder$pvlTOuv7HwuWXHmxY_IXZDDhr48
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PoiCardChargeDownLockContainer.BaseDownLockItemHolder.this.lambda$new$0$PoiCardChargeDownLockContainer$BaseDownLockItemHolder(view2);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$PoiCardChargeDownLockContainer$BaseDownLockItemHolder(View view) {
            if (CollectionUtils.isEmpty(this.mGunInfo.getLockList())) {
                L.Tag tag = PoiCardChargeDownLockContainer.TAG;
                L.e(tag, "unlock fail! no lockList" + this.mGunInfo.getGunName());
                return;
            }
            this.mDownLockItem.setEnabled(false);
            this.mUnlockCountDown.start();
            PoiCardChargeDownLockContainer.this.mChargeDataProvider.downLock(this.mGunInfo.getLockList().get(0).getLockNo(), new DisposableObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardChargeDownLockContainer.BaseDownLockItemHolder.2
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(@io.reactivex.annotations.NonNull Boolean bool) {
                    L.Tag tag2 = PoiCardChargeDownLockContainer.TAG;
                    L.i(tag2, "downLock onNext:" + bool);
                }

                @Override // io.reactivex.Observer
                public void onError(@io.reactivex.annotations.NonNull Throwable th) {
                    if (!(th instanceof ChargeDataException)) {
                        L.Tag tag2 = PoiCardChargeDownLockContainer.TAG;
                        L.i(tag2, "downLock onError message:" + th.toString());
                        return;
                    }
                    ChargeDataException chargeDataException = (ChargeDataException) th;
                    L.Tag tag3 = PoiCardChargeDownLockContainer.TAG;
                    L.i(tag3, "downLock onError code:" + chargeDataException.getErrorCode() + " message:" + chargeDataException.getMessage());
                    if (chargeDataException.getErrorCode() == 411) {
                        XToast.show(th.getMessage());
                    }
                }
            });
        }

        public void bindItemData(@NonNull NaviPoiChargeStationInfo.GunInfo gunInfo) {
            this.mUnlockCountDown.cancel();
            this.mGunInfo = gunInfo;
            this.mDownLockItem.setVuiLabel(this.mGunInfo.getGunName());
            this.mDownLockItem.setVuiAction(PoiCardChargeDownLockContainer.this.getResources().getString(R.string.vui_action_click));
            refreshItem();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void refreshItem() {
            this.mDownLockItem.setEnabled(true);
            this.mDownLockItem.setText(this.mGunInfo.getGunName());
        }
    }

    /* loaded from: classes3.dex */
    class NormalDownLockItemHolder extends BaseDownLockItemHolder {
        public NormalDownLockItemHolder(@NonNull View view) {
            super(view);
        }
    }

    /* loaded from: classes3.dex */
    class BookedDownLockItemHolder extends BaseDownLockItemHolder {
        XTextView mDownLockItemHint;

        public BookedDownLockItemHolder(@NonNull View view) {
            super(view);
            this.mDownLockItemHint = (XTextView) view.findViewById(R.id.down_lock_hint);
        }

        @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardChargeDownLockContainer.BaseDownLockItemHolder
        public void bindItemData(@NonNull NaviPoiChargeStationInfo.GunInfo gunInfo) {
            super.bindItemData(gunInfo);
            this.mDownLockItemHint.setText(getEndTimeString(this.mGunInfo.getSurplusBookingTime()));
        }

        public String getEndTimeString(long j) {
            if (j < 0) {
                L.e(PoiCardChargeDownLockContainer.TAG, "getEndTimeString remainTime error!");
                return "";
            }
            Calendar calendar = Calendar.getInstance(Locale.getDefault());
            Calendar calendar2 = Calendar.getInstance(Locale.getDefault());
            calendar2.setTimeInMillis(calendar.getTimeInMillis() + j);
            StringBuilder sb = new StringBuilder();
            if (isSameDay(calendar, calendar2)) {
                sb.append(TimeFormatUtil.formatTime(calendar2.getTime(), TimeFormatUtil.SHORT_TIME_PATTERN_FORMAT));
            } else if ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 1000 <= TimeFormatUtil.ONE_DAY) {
                sb.append(PoiCardChargeDownLockContainer.this.getContext().getString(R.string.tomorrow));
                sb.append(TimeFormatUtil.formatTime(calendar2.getTime(), TimeFormatUtil.SHORT_TIME_PATTERN_FORMAT));
            } else {
                sb.append(TimeFormatUtil.formatTime(calendar2.getTime(), "MM月dd日HH:mm"));
            }
            return PoiCardChargeDownLockContainer.this.getContext().getString(R.string.poi_charge_book_time, sb.toString());
        }

        public boolean isSameDay(Calendar calendar, Calendar calendar2) {
            return calendar != null && calendar2 != null && calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
        }
    }
}
