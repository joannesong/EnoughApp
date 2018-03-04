package nyc.c4q.enough.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.enough.R;
import nyc.c4q.enough.controller.NYTadapter;
import nyc.c4q.enough.model.NYTResults;
import nyc.c4q.enough.model.Results;
import nyc.c4q.enough.network.NYTAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static nyc.c4q.enough.NewsActivity.apiCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelNewsFragment extends Fragment {

    private RecyclerView travelRecyclerView;
    private NYTadapter nyTadapter;
    List<Results> resultsList = new ArrayList<>();

    public TravelNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_travel, container, false);

        travelRecyclerView = rootView.findViewById(R.id.travel_stories_rv);
        nyTadapter = new NYTadapter(resultsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
        travelRecyclerView.setLayoutManager(linearLayoutManager);
        getTravelData();

        return rootView;
    }

    public void getTravelData() {
        Call<NYTResults> nytResultsCall = apiCallback.getNYTtravel(NYTAPI.NYT_Top_APIKey);
        nytResultsCall.enqueue(new Callback<NYTResults>() {
            @Override
            public void onResponse(Call<NYTResults> call, Response<NYTResults> response) {
                if(response.isSuccessful()){
                    resultsList.addAll(response.body().getResults());
                    Log.d(TAG, "onResponse: " + resultsList.get(1).getUrl());
                    NYTadapter adapter = new NYTadapter(resultsList);
                    travelRecyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<NYTResults> call, Throwable t) {

            }
        });
    }

}
