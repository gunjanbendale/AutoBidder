package in.equipshare.autobidder.network;

import java.util.List;

import in.equipshare.autobidder.model.Equipments;
import in.equipshare.autobidder.model.Result;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @FormUrlEncoded
    @POST("/login")
    Call<Result>login(@Field(value="username",encoded = true) String username, @Field(value="password",encoded = true) String password);
    @GET("/search")
    Call<List<Result>>search(@Field(value="searchkey",encoded = true)String searchparam);
    @GET("/equipsearch")
    Call<List<Equipments>>equipsearch(@Field(value="searchkey",encoded = true)String searchparam);
}
