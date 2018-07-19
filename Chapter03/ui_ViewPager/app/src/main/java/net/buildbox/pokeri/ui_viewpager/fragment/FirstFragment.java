package net.buildbox.pokeri.ui_viewpager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.buildbox.pokeri.ui_viewpager.R;

public class FirstFragment extends Fragment {
    public static final String TAG = FirstFragment.class.getSimpleName();

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        Bundle bundle = fragment.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}
