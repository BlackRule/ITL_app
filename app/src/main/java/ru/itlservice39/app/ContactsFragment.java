package ru.itlservice39.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.itlservice39.app.databinding.FragContactsBinding;

/**
 * Created by yu on 2016/11/11.
 */

public class ContactsFragment extends Fragment {
    private String title;
    FragContactsBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get title
        title = getArguments().getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.frag_contacts, null);
//         bind view
        binding = DataBindingUtil.bind(view);
        binding.phoneOffice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri number = Uri.parse("tel:524666");
				Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
				startActivity(callIntent);
			}
		});
		binding.phoneMobile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri number = Uri.parse("tel:+79217104266");
				Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
				startActivity(callIntent);
			}
		});
		binding.instaButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(newInstagramProfileIntent(getContext().getPackageManager(),"http://instagram.com/itlservice39"));
			}
		});
		binding.vkButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(newVkProfileIntent(getContext().getPackageManager(),"http://vk.com/itlservice39"));
			}
		});
		binding.mapButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getContext(), MapActivity.class);
				intent.putExtra("url",
						"https://yandex.ru/maps/?um=constructor%3Ab4128fd02b1d06fad5a3004f682f56f7ecaf6209a05623fe9b6f7775b7d62312&source=constructorLink");
//				"http://yandex.ru/map-widget/v1/?um=constructor%3Ab4128fd02b1d06fad5a3004f682f56f7ecaf6209a05623fe9b6f7775b7d62312"
				startActivity(intent);
			}
		});
        return view;
    }
	/**
	 * Intent to open the official Instagram app to the user's profile. If the Instagram app is not
	 * installed then the Web Browser will be used.</p>
	 *
	 * Example usage:</p> {@code newInstagramProfileIntent(context.getPackageManager(),
	 *     "http://instagram.com/jaredrummler");}</p>
	 *
	 * @param pm
	 *            The {@link PackageManager}. You can find this class through
	 *            {@link Context#getPackageManager()}.
	 * @param url
	 *            The URL to the user's Instagram profile.
	 * @return The intent to open the Instagram app to the user's profile.
	 */
	public static Intent newInstagramProfileIntent(PackageManager pm, String url) {
		final Intent intent = new Intent(Intent.ACTION_VIEW);
		try {
			if (pm.getPackageInfo("com.instagram.android", 0) != null) {
				if (url.endsWith("/")) {
					url = url.substring(0, url.length() - 1);
				}
				final String username = url.substring(url.lastIndexOf("/") + 1);
				// http://stackoverflow.com/questions/21505941/intent-to-open-instagram-user-profile-on-android
				intent.setData(Uri.parse("http://instagram.com/_u/" + username));
				intent.setPackage("com.instagram.android");
				return intent;
			}
		} catch (PackageManager.NameNotFoundException ignored) {
		}
		intent.setData(Uri.parse(url));
		return intent;
	}
	/**
	 * Intent to open the official Vkontakte app to the user's profile. If the Vkontakte app is not
	 * installed then the Web Browser will be used.</p>
	 *
	 * Example usage:</p> {@code newInstagramProfileIntent(context.getPackageManager(),
	 *     "http://vk.com/jaredrummler");}</p>
	 *
	 * @param pm
	 *            The {@link PackageManager}. You can find this class through
	 *            {@link Context#getPackageManager()}.
	 * @param url
	 *            The URL to the user's Vkontakte profile.
	 * @return The intent to open the Vkontakte app to the user's profile.
	 */
	public static Intent newVkProfileIntent(PackageManager pm, String url) {
		final Intent intent = new Intent(Intent.ACTION_VIEW);
		try {
			if (pm.getPackageInfo("com.vkontakte.android", 0) != null) {
				if (url.endsWith("/")) {
					url = url.substring(0, url.length() - 1);
				}
				final String username = url.substring(url.lastIndexOf("/") + 1);
				// http://stackoverflow.com/questions/21505941/intent-to-open-instagram-user-profile-on-android
				intent.setData(Uri.parse(url));
				intent.setPackage("com.vkontakte.android");
				return intent;
			}
		} catch (PackageManager.NameNotFoundException ignored) {
		}
		intent.setData(Uri.parse(url));
		return intent;
	}
}
