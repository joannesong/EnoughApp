package nyc.c4q.enough.network;

import android.util.Log;

import nyc.c4q.enough.model.Results;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joannesong on 3/3/18.
 */

public class WomenAPIClient implements retrofit2.Callback<Results>{

    private static final String BASE_URL = "https://data.cityofnewyork.us/";
    public void start(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WomenAPI womenAPI = retrofit.create(WomenAPI.class);
        Call<Results> call = womenAPI.getResults();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Results> call, Response<Results> response) {
        Log.d("response", "yay!");

    }

    @Override
    public void onFailure(Call<Results> call, Throwable t) {
        Log.d("response", "no!");
    }
}
