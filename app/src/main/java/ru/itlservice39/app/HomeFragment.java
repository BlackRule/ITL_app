package ru.itlservice39.app;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.itlservice39.app.databinding.FragHomeBinding;

/**
 * Created by yu on 2016/11/11.
 */

public class HomeFragment extends Fragment {
	private String title;
	FragHomeBinding binding;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// get title
		title = getArguments().getString("title");

	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = View.inflate(getContext(), R.layout.frag_home, null);
		// bind view
		binding = DataBindingUtil.bind(view);
//        binding.tvTitle.setText(title);
		// Получаем ViewPager и устанавливаем в него адаптер
		ViewPager viewPager = binding.viewpager;
		viewPager.setAdapter(new SampleFragmentPagerAdapter(getChildFragmentManager()));

		// Передаём ViewPager в TabLayout
		TabLayout tabLayout = binding.slidingTabs;
		tabLayout.setupWithViewPager(viewPager);
		return view;
	}

	private static class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
		final int PAGE_COUNT = 3;
		private String tabTitles[] = new String[]{"Tab1", "Tab2", "Tab3"};

		public SampleFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return PAGE_COUNT;
		}

		@Override
		public Fragment getItem(int position) {
			return PageFragment.newInstance(position + 1);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// генерируем заголовок в зависимости от позиции
			return tabTitles[position];
		}
	}
}
