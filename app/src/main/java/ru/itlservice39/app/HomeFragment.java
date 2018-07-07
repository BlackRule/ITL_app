package ru.itlservice39.app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
//        binding = DataBindingUtil.bind(view);
//        binding.tvTitle.setText(title);
        return view;
    }
}
