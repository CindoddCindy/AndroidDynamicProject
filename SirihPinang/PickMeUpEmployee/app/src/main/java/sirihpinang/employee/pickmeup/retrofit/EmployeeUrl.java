package sirihpinang.employee.pickmeup.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeUrl {

    /*

    public static final String BASE_URL = "localhost:8081/employee";
    private static Retrofit retrofit = null;



    public static Retrofit getClient() {
        if (retrofit==null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();


            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

     */

    private static Retrofit retrofit=null;
    private EmployeeUrl(){

    }

    /*  public static Retrofit getRetrofit(){
          HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
          interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
          OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
          if (retrofit ==null){
              retrofit=new Retrofit.Builder()
                      .baseUrl("https://shipsapp.co.id/apps/api/login/")
                      .client(okHttpClient.newBuilder())
                      .addConverterFactory(GsonConverterFactory.create())
                      .build();
          }
          return retrofit;
      }
      */
    public static Retrofit getRetrofit() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

// set log level
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

//add logging
        okHttpClient.addInterceptor(httpLoggingInterceptor).build();

        String BASE_URL = "http://192.168.1.43:8081";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }

}
