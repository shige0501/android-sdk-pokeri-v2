package net.buildbox.pokeri.app_fragmenttransaction.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.buildbox.pokeri.app_fragmenttransaction.R;
import net.buildbox.pokeri.app_fragmenttransaction.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    public static final String TAG = MainFragment.class.getSimpleName();
    private static final String KEY_COUNT = "KEY_COUNT";

    private FragmentMainBinding mBinding;

    public MainFragment() {
    }

    public static MainFragment newInstance(int count) {
        MainFragment fragment = new MainFragment();
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
        }
        args.putInt(KEY_COUNT, count);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 用意したレイアウトのインフレート
        View view = inflater.inflate(R.layout.fragment_main, null);
        mBinding = DataBindingUtil.bind(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if (args == null) {
            return;
        }

        // フラグメントを呼び出した回数をカウント
        String displayCount = "count: " + args.getInt(KEY_COUNT);
        mBinding.mainCount.setText(displayCount);
    }
}
