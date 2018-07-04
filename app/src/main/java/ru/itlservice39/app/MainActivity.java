package ru.itlservice39.app;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ru.itlservice39.app.R;
import ru.itlservice39.app.databinding.ActivityMainBinding;


//////////////
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MenuItem;

import ru.itlservice39.app.R;
import ru.itlservice39.app.BaseFragment;
import ru.itlservice39.app.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

//////////


//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//TODO: Attention: Something wrong on Android 4.x
public class MainActivity extends AppCompatActivity {
	private static final String TAG = MainActivity.class.getSimpleName();
	private ActivityMainBinding bind;
	private VpAdapter adapter;

	// collections
	private SparseIntArray items;// used for change ViewPager selected item
	private List<Fragment> fragments;// used for ViewPager adapter

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_with_view_pager);
		bind = DataBindingUtil.setContentView(this, R.layout.activity_main);

		initView();
		initData();
		initEvent();
	}

	/**
	 * change BottomNavigationViewEx style
	 */
	private void initView() {
		bind.bnve.setTextVisibility(true);
		bind.bnve.enableShiftingMode(false);
		bind.bnve.enableAnimation(false);
		bind.bnve.enableItemShiftingMode(false);
		bind.bnve.setIconVisibility(true);


//	//initCenterIconOnly() {
//			int centerPosition = 2;
//			// attention: you must ensure the center menu item title is empty
//			// make icon bigger at centerPosition
//			bind.bnve.setIconSizeAt(centerPosition, 48, 48);
//			bind.bnve.setItemBackground(centerPosition, R.color.colorGreen);
//			bind.bnve.setIconTintList(centerPosition,
//					getResources().getColorStateList(R.color.selector_item_gray_color));
//			bind.bnve.setIconMarginTop(centerPosition, BottomNavigationViewEx.dp2px(this, 4));
//			// you could set a listener for bind.bnve and return false when click the center item so that it won't be checked.
//


//		//initMargin() {
//
//			bind.bnve.setItemHeight(BottomNavigationViewEx.dp2px(this, 56));
//			bind.bnve.setIconsMarginTop(BottomNavigationViewEx.dp2px(this, 16));
////        bind.bnve.setIconTintList(0, getResources()
////                .getColorStateList(R.color.colorGray));
//			// set typeface : bold
//			bind.bnve.setTypeface(Typeface.DEFAULT_BOLD);
//			// you also could set typeface from file.
////        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/custom.ttf");
////        bind.bnve.setTypeface(typeface);
//			// set icon size
//			int iconSize = 36;
//			bind.bnve.setIconSize(iconSize, iconSize);
//			// set item height
//			bind.bnve.setItemHeight(BottomNavigationViewEx.dp2px(this, iconSize + 16));
//			// set text size
//			bind.bnve.setTextSize(8);
//

	}

	/**
	 * create fragments
	 */
	private void initData() {
		fragments = new ArrayList<>(3);
		items = new SparseIntArray(3);

		// create fragment and add it
		BaseFragment homeFragment = new BaseFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title", getString(R.string.title_home));
		homeFragment.setArguments(bundle);

		// create fragment and add it
		BaseFragment profileFragment = new BaseFragment();
		bundle = new Bundle();
		bundle.putString("title", getString(R.string.title_profile));
		profileFragment.setArguments(bundle);

		// create  fragment and add it
		BaseFragment contactsFragment = new BaseFragment();
		bundle = new Bundle();
		bundle.putString("title", getString(R.string.title_contacts));
		contactsFragment.setArguments(bundle);

		// create  fragment and add it
		BaseFragment purchaseFragment = new BaseFragment();
		bundle = new Bundle();
		bundle.putString("title", getString(R.string.title_purchase));
		purchaseFragment.setArguments(bundle);

		// add to fragments for adapter
		fragments.add(homeFragment);
		fragments.add(profileFragment);
		fragments.add(contactsFragment);
		fragments.add(purchaseFragment);

		// add to items for change ViewPager item
		items.put(R.id.navigation_home, 0);
		items.put(R.id.navigation_profile, 1);
		items.put(R.id.navigation_contacts, 2);
		items.put(R.id.navigation_purchase, 2);

		// set adapter
		adapter = new VpAdapter(getSupportFragmentManager(), fragments);
		bind.vp.setAdapter(adapter);
	}

	/**
	 * set listeners
	 */
	private void initEvent() {
		// set listener to change the current item of view pager when click bottom nav item
		bind.bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			private int previousPosition = -1;

			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = 0;
//                switch (item.getItemId()) {
//                    case R.id.menu_music:
//                        id = 0;
//                        break;
//                    case R.id.menu_backup:
//                        id = 1;
//                        break;
//                    case R.id.menu_friends:
//                        id = 2;
//                        break;
//                }
//                if(previousPosition != id) {
//                  bind.vp.setCurrentItem(id, false);
//                  previousPosition = id;
//                }

				// you can write as above.
				// I recommend this method. You can change the item order or counts without update code here.
				int position = items.get(item.getItemId());
				if (previousPosition != position) {
					// only set item when item changed
					previousPosition = position;
					Log.i(TAG, "-----bnve-------- previous item:" + bind.bnve.getCurrentItem() + " current item:" + position + " ------------------");
					bind.vp.setCurrentItem(position);
				}
				return true;
			}
		});

		// set listener to change the current checked item of bottom nav when scroll view pager
		bind.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				Log.i(TAG, "-----ViewPager-------- previous item:" + bind.bnve.getCurrentItem() + " current item:" + position + " ------------------");
				bind.bnve.setCurrentItem(position);
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	/**
	 * view pager adapter
	 */
	private static class VpAdapter extends FragmentPagerAdapter {
		private List<Fragment> data;

		public VpAdapter(FragmentManager fm, List<Fragment> data) {
			super(fm);
			this.data = data;
		}

		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Fragment getItem(int position) {
			return data.get(position);
		}
	}
}