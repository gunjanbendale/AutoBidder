package in.equipshare.autobidder.network;

import android.support.annotation.CallSuper;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.equipshare.autobidder.model.DealerProfile;
import in.equipshare.autobidder.model.Equipments;
import in.equipshare.autobidder.model.LoginDetails;
import in.equipshare.autobidder.model.Result;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RetrofitInterface {
    @FormUrlEncoded
    @POST("/login")
    Call<Result> login(@Field("mobile") String mobile,@Field("password") String password);
    //Call<Result> login(@Body JSONObject jsonObject);

    @FormUrlEncoded
    @POST("/signup")
    Call<Result> signup(@FieldMap Map<String,String> map);

    @GET("/profile/{id}")
    Call<DealerProfile> profile(@Path("id") String id);

    @GET("/search")
    Call<List<Result>>search(@Field(value="searchkey",encoded = true)String searchparam);
    @GET("/equipsearch")
    Call<List<Equipments>>equipsearch(@Field(value="searchkey",encoded = true)String searchparam);

    @GET("/logout")
    Call<Result> logout();
}
