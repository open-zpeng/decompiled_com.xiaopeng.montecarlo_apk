package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.stat.PoiPopStatUtil;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.poicard.PoiCardEntryContainer;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class PoiCardFavoriteEntry extends XLinearLayout implements XpThemeSwitchReceiver.ThemeSwitchListener, BasePoiCardViewContract, View.OnClickListener {
    private static final L.Tag TAG = new L.Tag("PoiCardFavoriteEntry");
    private XTextView mBtnFavorite;
    private LinearLayout mBtnFavoriteContainer;
    private PoiCardEntryContainer.OnPoiCardEntryContainerClickListener mClickListener;
    private Context mContext;
    private final CompositeDisposable mDisposables;
    private LayoutInflater mInflater;
    private boolean mIsSelected;
    private boolean mIsSettingHomeOrOffice;
    private OnChildLayoutCompletedListener mLayoutListener;
    private MainContext mMainContext;
    private final Observer mObserver;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;

    public PoiCardFavoriteEntry(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mDisposables = new CompositeDisposable();
        this.mObserver = new Observer() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardFavoriteEntry.1
            @Override // java.util.Observer
            public void update(Observable observable, Object obj) {
                UserInfo userInfo;
                if (L.ENABLE) {
                    L.d(PoiCardFavoriteEntry.TAG, "PoiCardManager xp account Observer ");
                }
                if (!(obj instanceof UserInfo) || (userInfo = (UserInfo) obj) == null) {
                    return;
                }
                UserInfo.InfoType infoType = userInfo.getInfoType();
                UserInfo.UserType userType = userInfo.getUserType();
                L.Tag tag = PoiCardFavoriteEntry.TAG;
                L.i(tag, "mObserver update infoType = " + infoType + ", userType = " + userType);
                if (infoType != UserInfo.InfoType.CHANGED || UserInfo.UserType.TEMP == userType) {
                    return;
                }
                PoiCardFavoriteEntry.this.updateFavoriteStar();
            }
        };
        this.mIsSelected = false;
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcherUtil.addXpThemeSwitchListener(this);
        AccountObservable.getInstance().addObserver(this.mObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this);
        AccountObservable.getInstance().deleteObserver(this.mObserver);
        this.mLayoutListener = null;
        this.mDisposables.clear();
    }

    public void updateFavoriteStar() {
        if (this.mPoiInfo != null) {
            L.i(TAG, " updateFavoriteStar");
            addFavorite(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.poi_btn_favorite && XPAccountServiceWrapper.getInstance().checkLoginState()) {
            addFavorite(true);
        }
    }

    private void addFavorite(boolean z) {
        PoiPopStatUtil.sendStatDataWhenFavorite(this.mMainContext);
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("POP=> onAddFavoriteClick  poiInfo: ");
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        sb.append(xPPoiInfo == null ? "" : xPPoiInfo.getName());
        L.i(tag, sb.toString());
        XPPoiInfo xPPoiInfo2 = this.mPoiInfo;
        if (xPPoiInfo2 != null) {
            FavoriteAddress favoriteAddress = new FavoriteAddress(xPPoiInfo2);
            long isExist = FavoriteDataManager.getInstance().isExist(favoriteAddress);
            L.Tag tag2 = TAG;
            L.i(tag2, "addFavorite id=" + isExist);
            if (isExist >= 0) {
                if (z) {
                    favoriteAddress.setId(isExist);
                    this.mMainContext.getDecoratorManager().focusByPriority(this.mMainContext.getCurrentScene(), favoriteAddress.getXPPoiInfo(), new DecoratorType[0]);
                    FavoriteDataManager.getInstance().delete(favoriteAddress);
                    updatePopFavoriteText(false);
                    return;
                }
                updatePopFavoriteText(true);
                return;
            }
            boolean insertOrReplace = FavoriteDataManager.getInstance().insertOrReplace(favoriteAddress);
            L.Tag tag3 = TAG;
            L.i(tag3, " favorite addFavorite insertSuccess = " + insertOrReplace);
            if (insertOrReplace) {
                updatePopFavoriteText(true);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
    public void onThemeSwitch(int i) {
        onInitOrThemeSwitch();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        initView();
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_entry_item_favorite, (ViewGroup) this, true);
        setOrientation(1);
        executeAfterViewInflated(this.mRootView);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mBtnFavoriteContainer = (LinearLayout) view.findViewById(R.id.poi_btn_favorite_container);
        this.mBtnFavorite = (XTextView) view.findViewById(R.id.poi_btn_favorite);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderFavorite();
        onInitOrThemeSwitch();
    }

    private void renderFavorite() {
        CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
        MainContext mainContext = this.mMainContext;
        XTextView xTextView = this.mBtnFavorite;
        commonVuiHelper.updateCheckboxStateForVui(mainContext, xTextView, xTextView, this.mIsSelected, false);
        if (!TextUtils.isEmpty(this.mPoiInfo.getAddress()) && !TextUtils.isEmpty(this.mPoiInfo.getName()) && !this.mIsSettingHomeOrOffice) {
            io.reactivex.Observable create = io.reactivex.Observable.create(new ObservableOnSubscribe<Long>() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardFavoriteEntry.2
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<Long> observableEmitter) {
                    observableEmitter.onNext(Long.valueOf(FavoriteDataManager.getInstance().isExist(new FavoriteAddress(PoiCardFavoriteEntry.this.mPoiInfo))));
                    observableEmitter.onComplete();
                }
            });
            DisposableObserver<Long> disposableObserver = new DisposableObserver<Long>() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardFavoriteEntry.3
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    L.e(PoiCardFavoriteEntry.TAG, th.getMessage());
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    PoiCardFavoriteEntry.this.showFavoriteContainer();
                    PoiCardFavoriteEntry.this.updatePopFavoriteText(l.longValue() >= 0);
                }
            };
            create.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(disposableObserver);
            this.mDisposables.add(disposableObserver);
            return;
        }
        hideFavoriteContainer();
    }

    public void hideFavoriteContainer() {
        hideBtnFavoriteContainer();
    }

    public void showFavoriteContainer() {
        showBtnFavoriteContainer();
        setVisibility(0);
    }

    public void hideBtnFavoriteContainer() {
        LinearLayout linearLayout = this.mBtnFavoriteContainer;
        if (linearLayout == null || linearLayout.getVisibility() == 8) {
            return;
        }
        this.mBtnFavoriteContainer.setVisibility(8);
    }

    public void showBtnFavoriteContainer() {
        LinearLayout linearLayout = this.mBtnFavoriteContainer;
        if (linearLayout == null || linearLayout.getVisibility() == 0) {
            return;
        }
        this.mBtnFavoriteContainer.setVisibility(0);
    }

    public void updatePopFavoriteText(final boolean z) {
        post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardFavoriteEntry.4
            @Override // java.lang.Runnable
            public void run() {
                L.Tag tag = PoiCardFavoriteEntry.TAG;
                L.i(tag, "favorite updatePopFavoriteText isadd =" + z);
                PoiCardFavoriteEntry.this.switchFavoriteBtnState(z);
                CommonVuiHelper.getInstance().updateCheckboxStateForVui(PoiCardFavoriteEntry.this.mMainContext, PoiCardFavoriteEntry.this.mBtnFavorite, PoiCardFavoriteEntry.this.mBtnFavorite, z, false);
                if (PoiCardFavoriteEntry.this.mLayoutListener != null) {
                    PoiCardFavoriteEntry.this.mLayoutListener.onChildLayoutCompleted(PoiCardFavoriteEntry.this.mRootView);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchFavoriteBtnState(boolean z) {
        Drawable drawable;
        if (this.mBtnFavorite == null || this.mIsSelected == z) {
            return;
        }
        if (z) {
            drawable = ContextUtils.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_collection_on));
            this.mBtnFavorite.setText(ContextUtils.getString(R.string.poi_collected));
        } else {
            drawable = ContextUtils.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_collection_off));
            this.mBtnFavorite.setText(ContextUtils.getString(R.string.favorite));
        }
        if (drawable != null) {
            if (L.ENABLE) {
                L.d(TAG, "switchFavoriteBtnState setCompoundDrawables");
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mBtnFavorite.setCompoundDrawables(drawable, null, null, null);
        } else {
            L.w(TAG, "favoriteDrawable is null!!");
        }
        this.mIsSelected = z;
        this.mBtnFavorite.setSelected(z);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
        XTextView xTextView = this.mBtnFavorite;
        if (xTextView != null) {
            xTextView.setOnClickListener(this);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
        Drawable drawable;
        setBtnFavoriteTextColor(ContextUtils.getColorStateList(ThemeWatcherUtil.getColorResId(R.color.poi_card_text_color_01)));
        if (this.mIsSelected) {
            drawable = ContextUtils.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_collection_on));
            this.mBtnFavorite.setText(ContextUtils.getString(R.string.poi_collected));
        } else {
            drawable = ContextUtils.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_collection_off));
            this.mBtnFavorite.setText(ContextUtils.getString(R.string.favorite));
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mBtnFavorite.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void setBtnFavoriteTextColor(ColorStateList colorStateList) {
        XTextView xTextView = this.mBtnFavorite;
        if (xTextView != null) {
            xTextView.setTextColor(colorStateList);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        this.mLayoutListener = onChildLayoutCompletedListener;
        formatParams(context, map);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener2 = this.mLayoutListener;
        if (onChildLayoutCompletedListener2 != null) {
            onChildLayoutCompletedListener2.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void formatParams(Context context, Map<String, Object> map) {
        this.mContext = context;
        if (map.get("poiInfo") != null) {
            this.mPoiInfo = (XPPoiInfo) map.get("poiInfo");
        }
        if (map.get("isSettingHomeOrOffice") != null) {
            this.mIsSettingHomeOrOffice = ((Boolean) map.get("isSettingHomeOrOffice")).booleanValue();
        }
        if (map.get("mainContext") != null) {
            this.mMainContext = (MainContext) map.get("mainContext");
        }
        if (map.get("clickListener") != null) {
            this.mClickListener = (PoiCardEntryContainer.OnPoiCardEntryContainerClickListener) map.get("clickListener");
        }
    }
}
