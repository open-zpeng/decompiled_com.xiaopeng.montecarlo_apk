package com.xiaopeng.montecarlo.scenes.searchscene;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.account.sync.FavoriteSyncUtil;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.dialog.XBaseDialog;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XRadioButton;
import com.xiaopeng.xui.widget.XRadioGroup;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class HomeCompanyConflictDialog extends XBaseDialog {
    private static final L.Tag TAG = new L.Tag("HomeCompanyConflictDialog");
    private boolean mAmapCompanyConflict;
    private XRadioButton mAmapCompanyRb;
    private boolean mAmapHomeConflict;
    private XRadioButton mAmapHomeRb;
    private XRadioGroup mCompanyGroup;
    private View mCompanyParent;
    private XTextView mConflictTitle;
    private XRadioGroup mHomeGroup;
    private View mHomeParent;
    private boolean mIsInitialized;
    private XView mLine;
    private View mRootView;
    private XRadioButton mXpCompanyRb;
    private XRadioButton mXpHomeRb;

    public HomeCompanyConflictDialog(Context context) {
        super(context);
        this.mAmapHomeConflict = false;
        this.mAmapCompanyConflict = false;
        this.mAmapHomeRb = null;
        this.mXpHomeRb = null;
        this.mAmapCompanyRb = null;
        this.mXpCompanyRb = null;
        this.mIsInitialized = false;
        initConflictDialogContentView();
        initConflictDialog();
        this.mIsInitialized = true;
    }

    private void initConflictDialog() {
        this.mAmapHomeConflict = SettingWrapper.getAmapHomeConflictStatus();
        this.mAmapCompanyConflict = SettingWrapper.getAMapCompanyConflictStatus();
        if (this.mAmapHomeConflict && this.mAmapCompanyConflict) {
            setConflictTitle(R.string.favorite_sync_home_company_dialog_title);
        } else if (this.mAmapHomeConflict) {
            setConflictTitle(R.string.favorite_sync_home_dialog_title);
        } else {
            setConflictTitle(R.string.favorite_sync_company_dialog_title);
        }
        if (this.mAmapHomeConflict) {
            FavoriteAddress amapHomeConflictAddress = FavoriteSyncUtil.getAmapHomeConflictAddress();
            if (this.mAmapHomeConflict) {
                this.mAmapHomeRb.setVisibility(0);
                if (amapHomeConflictAddress != null) {
                    this.mAmapHomeRb.setText(Utils.getNameOrAddress(amapHomeConflictAddress.getXPPoiInfo()));
                }
            } else {
                clearBottomMargin(this.mAmapHomeRb);
                this.mAmapHomeRb.setVisibility(8);
            }
            FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
            if (home != null) {
                this.mXpHomeRb.setText(Utils.getNameOrAddress(home.getXPPoiInfo()));
            }
        }
        if (this.mAmapCompanyConflict) {
            FavoriteAddress amapCompanyConflictAddress = FavoriteSyncUtil.getAmapCompanyConflictAddress();
            if (this.mAmapCompanyConflict) {
                this.mAmapCompanyRb.setVisibility(0);
                if (amapCompanyConflictAddress != null) {
                    this.mAmapCompanyRb.setText(Utils.getNameOrAddress(amapCompanyConflictAddress.getXPPoiInfo()));
                }
            } else {
                clearBottomMargin(this.mAmapCompanyRb);
                this.mAmapCompanyRb.setVisibility(8);
            }
            FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
            if (company != null) {
                this.mXpCompanyRb.setText(Utils.getNameOrAddress(company.getXPPoiInfo()));
            }
        }
        if (this.mAmapHomeConflict && this.mAmapCompanyConflict) {
            this.mHomeParent.setVisibility(0);
            this.mCompanyParent.setVisibility(0);
        } else {
            this.mLine.setVisibility(8);
            this.mHomeParent.setVisibility(this.mAmapHomeConflict ? 0 : 8);
            this.mCompanyParent.setVisibility(this.mAmapCompanyConflict ? 0 : 8);
        }
        setContentView(this.mRootView, true);
        setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.HomeCompanyConflictDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeCompanyConflictDialog.this.handleHomeCompanyConflict();
            }
        });
        this.mHomeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.HomeCompanyConflictDialog.2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                HomeCompanyConflictDialog.this.updateFinishBtnStatus();
            }
        });
        this.mCompanyGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.HomeCompanyConflictDialog.3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                HomeCompanyConflictDialog.this.updateFinishBtnStatus();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.XBaseDialog
    public void initDialog() {
        super.initDialog();
        showOkButton(true);
        setOkButtonText(R.string.do_save);
        showClose(false);
        showCancelButton(false);
        setPositiveButtonEnable(false);
    }

    private View initConflictDialogContentView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(ContextUtils.getContext()).inflate(R.layout.favorite_sync_conflict_dialog_layout, (ViewGroup) null);
            this.mHomeParent = this.mRootView.findViewById(R.id.favorite_sync_conflict_home_parent);
            this.mCompanyParent = this.mRootView.findViewById(R.id.favorite_sync_conflict_company_parent);
            this.mLine = (XView) this.mRootView.findViewById(R.id.favorite_sync_conflict_line);
            this.mConflictTitle = (XTextView) this.mRootView.findViewById(R.id.conflict_title);
            this.mAmapHomeRb = (XRadioButton) this.mRootView.findViewById(R.id.favorite_sync_conflict_amap_home);
            this.mXpHomeRb = (XRadioButton) this.mRootView.findViewById(R.id.favorite_sync_conflict_xp_home);
            this.mAmapCompanyRb = (XRadioButton) this.mRootView.findViewById(R.id.favorite_sync_conflict_amap_company);
            this.mXpCompanyRb = (XRadioButton) this.mRootView.findViewById(R.id.favorite_sync_conflict_xp_company);
            this.mHomeGroup = (XRadioGroup) this.mRootView.findViewById(R.id.favorite_sync_conflict_home_group);
            this.mCompanyGroup = (XRadioGroup) this.mRootView.findViewById(R.id.favorite_sync_conflict_company_group);
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleHomeCompanyConflict() {
        FavoriteAddress favoriteAddress;
        boolean z = this.mAmapHomeConflict;
        boolean z2 = this.mAmapCompanyConflict;
        FavoriteAddress favoriteAddress2 = null;
        if (!z) {
            favoriteAddress = null;
        } else if (this.mAmapHomeRb.isChecked()) {
            favoriteAddress = FavoriteSyncUtil.getAmapHomeConflictAddress();
        } else {
            favoriteAddress = FavoriteDataManager.getInstance().getHome();
        }
        if (z2) {
            if (this.mAmapCompanyRb.isChecked()) {
                favoriteAddress2 = FavoriteSyncUtil.getAmapCompanyConflictAddress();
            } else {
                favoriteAddress2 = FavoriteDataManager.getInstance().getCompany();
            }
        }
        if (favoriteAddress != null || favoriteAddress2 != null) {
            FavoriteDataManager.getInstance().setHomeCompany(favoriteAddress, favoriteAddress2);
        }
        FavoriteSyncUtil.resetHomeCompanyConflictStatus();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        if (r4.mAmapHomeRb.isChecked() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
        if (r4.mAmapCompanyRb.isChecked() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0065, code lost:
        if (r4.mAmapCompanyRb.isChecked() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateFinishBtnStatus() {
        /*
            r4 = this;
            com.xiaopeng.xui.widget.XRadioButton r0 = r4.mXpHomeRb
            if (r0 == 0) goto L6c
            com.xiaopeng.xui.widget.XRadioButton r1 = r4.mAmapHomeRb
            if (r1 == 0) goto L6c
            com.xiaopeng.xui.widget.XRadioButton r1 = r4.mXpCompanyRb
            if (r1 == 0) goto L6c
            com.xiaopeng.xui.widget.XRadioButton r1 = r4.mAmapCompanyRb
            if (r1 != 0) goto L11
            goto L6c
        L11:
            boolean r1 = r4.mAmapHomeConflict
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3c
            boolean r1 = r4.mAmapCompanyConflict
            if (r1 == 0) goto L3c
            boolean r0 = r0.isChecked()
            if (r0 != 0) goto L29
            com.xiaopeng.xui.widget.XRadioButton r0 = r4.mAmapHomeRb
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L3a
        L29:
            com.xiaopeng.xui.widget.XRadioButton r0 = r4.mXpCompanyRb
            boolean r0 = r0.isChecked()
            if (r0 != 0) goto L69
            com.xiaopeng.xui.widget.XRadioButton r0 = r4.mAmapCompanyRb
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L3a
            goto L69
        L3a:
            r2 = r3
            goto L69
        L3c:
            boolean r0 = r4.mAmapHomeConflict
            if (r0 == 0) goto L52
            com.xiaopeng.xui.widget.XRadioButton r0 = r4.mXpHomeRb
            boolean r0 = r0.isChecked()
            if (r0 != 0) goto L50
            com.xiaopeng.xui.widget.XRadioButton r0 = r4.mAmapHomeRb
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L52
        L50:
            r0 = r2
            goto L53
        L52:
            r0 = r3
        L53:
            boolean r1 = r4.mAmapCompanyConflict
            if (r1 == 0) goto L68
            com.xiaopeng.xui.widget.XRadioButton r0 = r4.mXpCompanyRb
            boolean r0 = r0.isChecked()
            if (r0 != 0) goto L69
            com.xiaopeng.xui.widget.XRadioButton r0 = r4.mAmapCompanyRb
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L3a
            goto L69
        L68:
            r2 = r0
        L69:
            r4.setPositiveButtonEnable(r2)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.searchscene.HomeCompanyConflictDialog.updateFinishBtnStatus():void");
    }

    private void clearBottomMargin(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = 0;
        view.setLayoutParams(layoutParams);
    }

    private void setConflictTitle(int i) {
        if (this.mConflictTitle != null) {
            getContentView().findViewById(R.id.x_dialog_title_layout).setVisibility(8);
            this.mConflictTitle.setText(i);
        }
    }
}
