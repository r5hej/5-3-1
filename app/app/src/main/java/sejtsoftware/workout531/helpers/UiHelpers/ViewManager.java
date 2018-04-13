package sejtsoftware.workout531.helpers.UiHelpers;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.ViewGroup;

import sejtsoftware.workout531.MainActivity;
import sejtsoftware.workout531.R;

public class ViewManager {
    private static FragmentManager mFragmentManager;

    public void init(MainActivity mainActivity) {
        mFragmentManager = mainActivity.getFragmentManager();
    }

    public static void loadFragment(Fragment fragment, int containerId, String tag) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(containerId, fragment, tag).addToBackStack(null).commit();
    }
}
