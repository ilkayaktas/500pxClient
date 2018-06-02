package com.ilkayaktas.makemepopular.views.activities.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ilkayaktas.makemepopular.views.adapters.ViewPagerAdapter;
import com.ilkayaktas.makemepopular.namesofAllah.R;
import com.ilkayaktas.makemepopular.views.activities.base.BaseActivity;
import com.ilkayaktas.makemepopular.views.widgets.dialogs.rateme.Config;
import com.ilkayaktas.makemepopular.views.widgets.dialogs.rateme.RateMe;
import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

	@BindView(R.id.toolbar_main) Toolbar mToolbar;
	@BindView(R.id.tablayout_main) TabLayout mTabLayout;
	@BindView(R.id.vp_main) ViewPager mViewPager;
	@BindView(R.id.toolbar_title) TextView toolbarTitle;
	@BindView(R.id.toolbar_favorites) SparkButton toolbarFavorites;
	@BindView(R.id.toolbar_mainicon) SparkButton toolbarMainIcon;

	@Inject
	MainMvpPresenter<MainMvpView> mPresenter;
	private String[] categories;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setSupportActionBar(mToolbar);

		getActivityComponent().inject(this);
		
		setUnBinder(ButterKnife.bind(this));
		
		RateMe.init(new Config(5, 10)); // 5 gün ya da 10 defa uygulama başlattıktan sonra
		
		// Attach presenter
		mPresenter.onAttach(MainActivity.this);

		categories = getResources().getStringArray(R.array.categories);
		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), categories);
		mViewPager.setAdapter(viewPagerAdapter);
		mViewPager.setOffscreenPageLimit(categories.length);
		mTabLayout.setupWithViewPager(mViewPager);
		mViewPager.addOnPageChangeListener(pageChangeListener);

		mViewPager.post(() -> pageChangeListener.onPageSelected(mViewPager.getCurrentItem()));

		initialize();

	}

	private void initialize(){
		setFont();
		setOnFavoritesClickAction();
		setOnMainIconClickAction();
	}

	ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

		}

		@Override
		public void onPageSelected(int position) {
			((ViewPagerAdapter)mViewPager.getAdapter()).updateVisibleFragment(position);
		}

		@Override
		public void onPageScrollStateChanged(int state) {

		}
	};

	@Override
	protected int getActivityLayout() {
		return R.layout.activity_main;
	}

	@Override
	protected void onStart() {
		super.onStart();
		RateMe.onStart(this);
		RateMe.showRateDialogIfNeeded(this);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mPresenter.onDetach();
	}

	@Override
	protected void onResume() {
		super.onResume();
		
	}

	public static Intent getStartIntent(Context context) {
		Intent intent = new Intent(context, MainActivity.class);
		return intent;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			
			finish();
			
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}

	private void setFont(){
		toolbarTitle.setTypeface(robotoThinText);
	}

	private void setOnFavoritesClickAction(){
		toolbarFavorites.setEventListener(new SparkEventListener(){
			@Override
			public void onEvent(ImageView button, boolean buttonState) {
				mViewPager.setCurrentItem(categories.length-1, true);
			}

			@Override
			public void onEventAnimationEnd(ImageView button, boolean buttonState) {

			}

			@Override
			public void onEventAnimationStart(ImageView button, boolean buttonState) {

			}
		});
	}

	private void setOnMainIconClickAction(){
		toolbarMainIcon.setEventListener(new SparkEventListener(){
			@Override
			public void onEvent(ImageView button, boolean buttonState) {
				mViewPager.setCurrentItem(0, true);
			}

			@Override
			public void onEventAnimationEnd(ImageView button, boolean buttonState) {

			}

			@Override
			public void onEventAnimationStart(ImageView button, boolean buttonState) {

			}
		});
	}

}
