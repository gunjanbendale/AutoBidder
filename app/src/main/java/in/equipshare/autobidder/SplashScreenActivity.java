package in.equipshare.autobidder;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import in.equipshare.autobidder.model.LoginDetails;
import in.equipshare.autobidder.model.Result;
import in.equipshare.autobidder.network.RetrofitInterface;
import in.equipshare.autobidder.utils.Constants;
import in.equipshare.autobidder.utils.SessionManagement;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashScreenActivity extends AppCompatActivity {
    SessionManagement sessionManagement;
    Gson gson = new GsonBuilder().setLenient().create();
    Result result;
    OkHttpClient client = new OkHttpClient();
    Retrofit.Builder builder=new Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create(gson));
    Retrofit retrofit=builder.build();
    RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }
    @Override
    public void onResume() {
        super.onResume();
        if (!checkInternet()) {
            new AlertDialog.Builder(SplashScreenActivity.this)
                    .setTitle("No Internet Connection")
                    .setMessage("Your device is not connected to Internet")
                    .setPositiveButton("Go To Settings", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);

                        }

                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            System.exit(0);
                        }
                    })
                    .show();
        } else {
            Splash();
        }
    }

    public boolean checkInternet() {
        boolean mobileNwInfo;
        ConnectivityManager conxMgr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        try {
            mobileNwInfo = conxMgr.getActiveNetworkInfo().isConnected();
        } catch (NullPointerException e) {
            mobileNwInfo = false;
        }
        return mobileNwInfo;
    }

    public void Splash() {
        int SPLASH_TIME_OUT = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sessionManagement = new SessionManagement(getApplicationContext());
                // Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
                sessionManagement.checkLogin(SplashScreenActivity.this);
                HashMap<String, String> user = sessionManagement.getUserDetails();
                String email = user.get(SessionManagement.KEY_MOB);
                String password = user.get(SessionManagement.KEY_PASS);
                LoginDetails loginDetails=new LoginDetails(email,password);
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("mobile", email);
                    jsonObject.put("password", password);
                    Call<Result> call = retrofitInterface.login("123","abc");

                    call.enqueue(new Callback<Result>() {
                        @Override
                        public void onResponse(Call<Result> call, retrofit2.Response<Result> response) {

                            result = response.body(); // have your all data
                            Log.e("TAG", "response 33: " + new Gson().toJson(response.body()));
                            Log.e("TAG", "response 33: " + response.body());
                            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("Result", result);
                            startActivity(intent);
                            finish();

                        }

                        @Override
                        public void onFailure(Call<Result> call, Throwable t) {

                            Log.e("TAG", "response 33: " + t.getMessage());
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    });
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}
