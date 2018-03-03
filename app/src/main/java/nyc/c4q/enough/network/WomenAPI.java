package nyc.c4q.enough.network;

import nyc.c4q.enough.model.Results;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by joannesong on 3/3/18.
 */

public interface WomenAPI {

    @GET("resource/386y-9exk.json")
    Call<Results> getResults();
}