package nyc.c4q.enough.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by c4q on 3/3/18.
 */

public class NYTimesServiceGenerator {

    private static final String BASE_URL = "https://api.nytimes.com/";

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor loggingInterceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder okhttpclient = new OkHttpClient.Builder();

    public static NYTAPI createService() {
        if (!okhttpclient.interceptors().contains(loggingInterceptor)) {
            okhttpclient.addInterceptor(loggingInterceptor);
            builder.client(okhttpclient.build());
            retrofit = builder.build();
        }
        return retrofit.create(NYTAPI.class);
    }

}
