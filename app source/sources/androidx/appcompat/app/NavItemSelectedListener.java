package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener listener) {
        this.mListener = listener;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AdapterView<?> adapterView2 = adapterView;
        View view2 = view;
        int position = i;
        long id = j;
        if (this.mListener != null) {
            boolean onNavigationItemSelected = this.mListener.onNavigationItemSelected(position, id);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
