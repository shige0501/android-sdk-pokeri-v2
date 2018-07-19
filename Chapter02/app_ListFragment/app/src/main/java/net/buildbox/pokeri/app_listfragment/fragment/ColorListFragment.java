package net.buildbox.pokeri.app_listfragment.fragment;

import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ColorListFragment extends ListFragment {
    public static final String TAG = ColorListFragment.class.getSimpleName();

    public ColorListFragment() {
    }

    public static ColorListFragment newInstance() {
        return new ColorListFragment();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String displayString = getListAdapter().getItem(position) + "がクリックされました";
        Toast.makeText(v.getContext(), displayString, Toast.LENGTH_SHORT).show();
    }
}
