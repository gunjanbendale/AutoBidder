package in.equipshare.autobidder;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import in.equipshare.autobidder.model.DealerProfile;
import in.equipshare.autobidder.model.Data;

import in.equipshare.autobidder.model.Result;
import in.equipshare.autobidder.network.RetrofitInterface;
import in.equipshare.autobidder.utils.Constants;
import in.equipshare.autobidder.utils.SessionManagement;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DealerProfileActivity extends Fragment {
    TextView dealer_name,dealer_mob,dealer_email,dealer_type,dealer_add;
    DealerProfile dealerProfile;
    SessionManagement sessionManagement;
    Gson gson = new GsonBuilder().setLenient().create();

    OkHttpClient client = new OkHttpClient();
    Retrofit.Builder builder=new Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create(gson));
    Retrofit retrofit=builder.build();
    RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_dealer_profile, container, false);
        dealer_name = (TextView) rootView.findViewById(R.id.text_name);
        dealer_mob = (TextView) rootView.findViewById(R.id.text_mob);
        dealer_email = (TextView) rootView.findViewById(R.id.text_email);
        dealer_add = (TextView) rootView.findViewById(R.id.text_add);
        dealer_type = (TextView) rootView.findViewById(R.id.text_type);
        sessionManagement= new SessionManagement(getActivity().getApplicationContext());
        Intent intent=getActivity().getIntent();
        Result result = (Result) intent.getParcelableExtra("Result");
        String id = result.getId();

        Call<DealerProfile> call = retrofitInterface.profile(id);
        call.enqueue(new Callback<DealerProfile>() {
            @Override
            public void onResponse(Call<DealerProfile> call, Response<DealerProfile> response) {
                DealerProfile d=response.body();
                Log.e("Response ", String.valueOf(response.body()));
                Log.e("TAG", "response 33: "+new Gson().toJson(response.body()));
                Log.e("TAG", "response 33: "+new Gson().toJson(response.body()));
                Data data=d.getData();
                //dealer_name.setText(data.getName());
                dealer_mob.setText(data.getMobile());
                dealer_add.setText(data.getAddress());
                dealer_type.setText(data.getCategory());
                dealer_email.setText(data.getEmail());
            }

            @Override
            public void onFailure(Call<DealerProfile> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Dealer Profile");
    }
}
