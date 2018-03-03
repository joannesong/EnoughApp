package nyc.c4q.enough.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.enough.NewsActivity;
import nyc.c4q.enough.R;
import nyc.c4q.enough.model.Results;
import nyc.c4q.enough.network.NYTAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopNewsFragment extends Fragment {


    public TopNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_top_news, container, false);
    }

}
