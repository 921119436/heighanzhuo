package day08_activity_demo1.myapplication.fragment;

import android.net.Uri;
import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/3/14.
 */
public class BaseFragment extends Fragment {

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
