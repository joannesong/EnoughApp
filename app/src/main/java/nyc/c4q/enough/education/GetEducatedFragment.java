package nyc.c4q.enough.education;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.enough.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetEducatedFragment extends Fragment {


    public GetEducatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_educated, container, false);
    }

}
