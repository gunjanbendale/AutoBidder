package in.equipshare.autobidder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.equipshare.autobidder.model.Result;
import in.equipshare.autobidder.network.RetrofitInterface;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private EditText mobile;
    private EditText password;
    private ProgressBar progressBar;
    private TextView signUp;
    private TextView forgotpass;

    public static final String TAG = LoginActivity.class.getSimpleName();
    private String mob,pass;
    Result result;
    Context context;
    Gson gson = new GsonBuilder().setLenient().create();

    OkHttpClient client = new OkHttpClient();
    Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://35.200.128.175").client(client).addConverterFactory(GsonConverterFactory.create(gson));
    Retrofit retrofit=builder.build();
    RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mobile= (EditText) findViewById(R.id.mobile);
        password=(EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.login_progress);

        forgotpass = (TextView) findViewById(R.id.for_Pass);
        signUp = (TextView) findViewById(R.id.SignUp);
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
        context = this.getApplicationContext();
    }
    public void SignUp(View view){

    }
    public void SignIN(View view){
        mob=mobile.getText().toString();
        pass=password.getText().toString();
        //startActivity(new Intent(this, DashboardActivity.class));
        startSignin();
    }
    public void startSignin() {

        String mob = mobile.getText().toString();
        String pass = password.getText().toString();

        if (mob.isEmpty()) {
            mobile.setError("Phone is Required");
            mobile.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            password.setError("Password is Required");
            password.requestFocus();
            return;
        }
        if (password.length() < 1) {
            password.setError("Minimum length of Password should be 2 characters");
            password.requestFocus();
            return;
        }
        loginprocess();
        progressBar.setVisibility(View.VISIBLE);
    }
    private void loginprocess()
    {
        //Login login=new Login(email,password);

        Call<Result> call=retrofitInterface.login(mob,pass);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, retrofit2.Response<Result> response) {

                result=  response.body(); //    have your all data
                String name =result.getName();
                String msg=result.getMessage();
                Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                Log.e("TAG", "response 33: "+new Gson().toJson(response.body()));
                Log.e("TAG", "response 33: "+response.body());
                Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Result",result);
                startActivity(intent);

            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }

        });
    }
    Result getResult()
    {
        return result;
    }
}
