package nyc.c4q.enough.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.enough.R;
import nyc.c4q.enough.model.Results;
import nyc.c4q.enough.network.NYTAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.enough.NewsActivity.apiCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelFragment extends Fragment {


    public TravelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_travel, container, false);



        getTravelData();

        return rootView;
    }

    public void getTravelData(){
        Call<Results> nytResultsCall = apiCallback.getNYTtravel(NYTAPI.NYT_Top_APIKey);
        nytResultsCall.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {

            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });
    }

}
