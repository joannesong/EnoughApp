package nyc.c4q.enough.help;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.enough.R;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment {
    private final static String TAG = "RESULTS";
    private RecyclerView articleRecycler;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton scrollToTop;


    public HelpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_help, container, false);
        articleRecycler = (RecyclerView) rootView.findViewById(R.id.timeswire_recycler);
        //timeswireAdapter = new TimeswireAdapter(getContext());
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        // articleRecycler.setAdapter(timeswireAdapter);
        articleRecycler.setHasFixedSize(true);
        articleRecycler.setLayoutManager(linearLayoutManager);


        return rootView;
    }



}
