package nyc.c4q.enough.network;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.enough.controller.HelpDataAdapter;
import nyc.c4q.enough.model.WomenDataResults;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joannesong on 3/3/18.
 */

public class WomenAPIClient implements retrofit2.Callback<List<WomenDataResults>>{

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private RecyclerView recyclerView;
    private List<WomenDataResults> helpWomenResources = new ArrayList<>();

    private static final String BASE_URL = "https://data.cityofnewyork.us/";

    public WomenAPIClient(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public void start(){
        httpClient.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder().client(httpClient.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WomenAPI womenAPI = retrofit.create(WomenAPI.class);
        Call<List<WomenDataResults>> call = womenAPI.getResults();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<WomenDataResults>> call, Response<List<WomenDataResults>> response) {
        Log.d("response", "yay!");
        helpWomenResources = response.body();
        HelpDataAdapter helpDataAdapter = new HelpDataAdapter(helpWomenResources);
        recyclerView.setAdapter(helpDataAdapter);
    }

    @Override
    public void onFailure(Call<List<WomenDataResults>> call, Throwable t) {
        Log.d("response", t.toString());

    }
}
