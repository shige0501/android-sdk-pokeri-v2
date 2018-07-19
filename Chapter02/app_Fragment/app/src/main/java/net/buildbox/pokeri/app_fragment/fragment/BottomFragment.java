package net.buildbox.pokeri.app_fragment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.buildbox.pokeri.app_fragment.R;

public class BottomFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // フラグメントのインフレート
        return inflater.inflate(R.layout.fragment_bottom, container);
    }
}
