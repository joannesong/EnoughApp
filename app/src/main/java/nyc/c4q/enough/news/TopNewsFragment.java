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

import nyc.c4q.enough.NewsActivity;
import nyc.c4q.enough.R;
import nyc.c4q.enough.controller.NYTadapter;
import nyc.c4q.enough.model.NYTResults;
import nyc.c4q.enough.model.Results;
import nyc.c4q.enough.network.NYTAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.enough.NewsActivity.apiCallback;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopNewsFragment extends Fragment {
    List<Results> topResultsList = new ArrayList<>();
    RecyclerView recyclerView;

    public TopNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_top_news, container, false);

        recyclerView = view.findViewById(R.id.top_stories_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        getTopStoriesData();
        return view;
    }

    public void getTopStoriesData() {
        Call<NYTResults> nytResultsCall = apiCallback.getNYThome(NYTAPI.NYT_Top_APIKey);
        nytResultsCall.enqueue(new Callback<NYTResults>() {
            @Override
            public void onResponse(Call<NYTResults> call, Response<NYTResults> response) {
                Log.d("response", "top stories...");
                topResultsList = response.body().getResults();
                NYTadapter nyTadapter = new NYTadapter(topResultsList);
                recyclerView.setAdapter(nyTadapter);

            }

            @Override
            public void onFailure(Call<NYTResults> call, Throwable t) {

            }
        });
    }

}
