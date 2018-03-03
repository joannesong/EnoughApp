package nyc.c4q.enough.network;

import android.util.Log;

import java.util.List;

import nyc.c4q.enough.model.Results;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joannesong on 3/3/18.
 */

public class WomenAPIClient implements retrofit2.Callback<List<Results>>{

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static final String BASE_URL = "https://data.cityofnewyork.us/";
    public void start(){
        httpClient.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder().client(httpClient.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WomenAPI womenAPI = retrofit.create(WomenAPI.class);
        Call<List<Results>> call = womenAPI.getResults();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
        Log.d("response", "yay!");

    }

    @Override
    public void onFailure(Call<List<Results>> call, Throwable t) {
        Log.d("response", t.toString());

    }
}
