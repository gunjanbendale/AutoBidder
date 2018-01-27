package in.equipshare.autobidder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;
import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.ArrayList;

public class CarProfileActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DataAdapter adapter;
    private final static int FADE_DURATION = 1400;
    private ArrayList<CarProfileItems> profileItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_profile);
        recyclerView=findViewById(R.id.car_profile_recycler);
        profileItems=filldata();
        adapter = new DataAdapter(getApplicationContext(),profileItems);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<CarProfileItems> filldata(){
        ArrayList<CarProfileItems> data=new ArrayList<CarProfileItems>();
        int sa=getResources().getIdentifier("carprofilemenus","array",getPackageName());
        int ia=getResources().getIdentifier("carprofileicons","array",getPackageName());
        int va=getResources().getIdentifier("carprofilevalues","array",getPackageName());
        String[] array=getResources().getStringArray(sa);
        String[] imagearray=getResources().getStringArray(ia);
        String[] valuearray=getResources().getStringArray(va);

        int i=0;
        while(i<array.length){
            MaterialDrawableBuilder.IconValue r= MaterialDrawableBuilder.IconValue.valueOf(imagearray[i]);
            data.add(new CarProfileItems(array[i],valuearray[i],r));
            i++;
        }
        return data;
    }
    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
        private ArrayList<CarProfileItems> profileItems;
        private Context context;

        public DataAdapter(Context context,ArrayList<CarProfileItems> profileItems) {
            this.context = context;
            this.profileItems=profileItems;

        }

        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.carprofilerecycler, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int i) {

            viewHolder.menuname.setText(profileItems.get(i).getId());
            viewHolder.iconView.setIcon(profileItems.get(i).getIcon());
            viewHolder.menuvalue.setText(profileItems.get(i).getValue());
            setFadeAnimation(viewHolder.itemView);
        }
        private void setFadeAnimation(View view) {
            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(FADE_DURATION);
            view.startAnimation(anim);
        }

        @Override
        public int getItemCount() {
            return profileItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView menuname;
            TextView menuvalue;
            MaterialIconView iconView;
            public ViewHolder(View view) {
                super(view);
                iconView = (MaterialIconView) view.findViewById(R.id.car_profile_icon);
                menuname = (TextView)view.findViewById(R.id.car_profile_id);
                menuvalue = (TextView)view.findViewById(R.id.car_profile_value);

            }
        }
    }
}
