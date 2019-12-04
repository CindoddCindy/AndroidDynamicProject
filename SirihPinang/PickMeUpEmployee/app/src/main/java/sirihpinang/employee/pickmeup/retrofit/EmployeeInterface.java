package sirihpinang.employee.pickmeup.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import sirihpinang.employee.pickmeup.pojo.EmployeeRegisterRespon;

public interface EmployeeInterface {
    @FormUrlEncoded
    @POST("localhost:8081/employee")
    Call<EmployeeRegisterRespon> EmployeeRegister(@Field("name") String name,
                                            @Field("email") String email,
                                            @Field("password") String password,
                                            @Field("employeeid") String employeeid,
                                             @Field("employeecomname") String employeecomname);
/*
    @FormUrlEncoded
    @POST("login/views/login.php")
    Call<MSG> userLogIn(@Field("email") String email,
                        @Field("password") String password);

 */

}
