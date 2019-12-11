package cindy.test.apipost.retro;

import cindy.test.apipost.pojo.DeleteInsertRespon;
import cindy.test.apipost.pojo.GetPostResponData;
import cindy.test.apipost.pojo.InsertPostRespon;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface RetrofitInter {

    @FormUrlEncoded
    @POST("/insert")
    Call<InsertPostRespon> insertPost(@Field("name") String name,
                                      @Field("email") String email,
                                      @Field("password") String password,
                                      @Field("data") String data);

    @GET("/insert?page=1&limit=10")
    Call<GetPostResponData> getDataInsert();

    /*

    @FormUrlEncoded
    @PUT("kontak")
    Call<> putKontak(@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("nomor") String nomor);


     */
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call<DeleteInsertRespon> deleteKontak(@Field("id") String id);




}
