package nyc.c4q.enough.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.enough.R;
import nyc.c4q.enough.network.WomenAPIClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    private RecyclerView recyclerView;

    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_data, container, false);

        WomenAPIClient womenAPIClient = new WomenAPIClient();

        recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        return view;

    }

}
