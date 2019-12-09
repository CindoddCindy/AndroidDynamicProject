package cindy.test.apipost.retro;

import cindy.test.apipost.pojo.GetPostRespon;
import cindy.test.apipost.pojo.InsertPostRespon;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInter {

    @FormUrlEncoded
    @POST("/insert")
    Call<InsertPostRespon> insertPost(@Field("name") String name,
                                      @Field("email") String email,
                                      @Field("password") String password,
                                      @Field("data") String data);

    @GET("/insert?page=1&limit=10")
    Call<GetPostRespon> getDataInsert();




}
