package nyc.c4q.enough.network;

/**
 * Created by C4Q on 3/3/18.
 */

import nyc.c4q.enough.model.Results;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NYTAPI {

    String NYT_Top_APIKey = "d752126a9dec4034b7f3e0e71ab84825";


    @GET("svc/topstories/v2/books.json")
    Call<Results> getNYTbooks(@Query("apikey") String apikey);

    @GET("svc/topstories/v2/travel.json")
    Call<Results> getNYTtravel(@Query("apikey") String apikey);

    @GET("svc/topstories/v2/fashion.json")
    Call<Results> getNYTfashion(@Query("apikey") String apikey);


}
