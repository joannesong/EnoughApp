package nyc.c4q.enough.resources;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.enough.R;
import nyc.c4q.enough.controller.HelpDataAdapter;
import nyc.c4q.enough.model.WomenDataResults;
import nyc.c4q.enough.network.WomenAPIClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResourcesFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<WomenDataResults> listWomen;

    public ResourcesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_data, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        WomenAPIClient womenAPIClient = new WomenAPIClient(recyclerView);
        womenAPIClient.start();

        return view;

    }

}
