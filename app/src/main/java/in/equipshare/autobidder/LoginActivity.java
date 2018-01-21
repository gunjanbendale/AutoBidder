package in.equipshare.autobidder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void SignUp(View view){

    }
    public void forgotPassword(View view ){

    }
    public void SignIN(View view){
        finish();
        startActivity(new Intent(this,DashboardActivity.class));
    }
}
