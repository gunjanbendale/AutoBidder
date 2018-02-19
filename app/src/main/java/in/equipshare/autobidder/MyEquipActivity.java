package in.equipshare.autobidder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.equipshare.autobidder.model.Equipments;

public class MyEquipActivity extends Fragment {
    TextView add_equip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.activity_my_equip,container,false);
        add_equip=(TextView) rootView.findViewById(R.id.add_equip);
        add_equip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AddEquipActivity.class));
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
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("My Equipments");
    }

    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
        private ArrayList<Equipments> equipments;
        private Context context;

        public DataAdapter(Context context,ArrayList<Equipments> equipments) {
            this.context = context;
            this.equipments=equipments;

        }

        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.equipment_recycler, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int i) {

            viewHolder.equipname.setText(equipments.get(i).getEquipname());
            viewHolder.equipstatus.setText(equipments.get(i).getEquipstatus());
            viewHolder.equiplikes.setText(equipments.get(i).getEquiplikes());

            setFadeAnimation(viewHolder.itemView);
        }
        private void setFadeAnimation(View view) {
            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(1000);
            view.startAnimation(anim);
        }

        @Override
        public int getItemCount() {
            return equipments.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView equipname;
            ImageView equipimage;
            TextView equiplikes;
            TextView equipstatus;
            public ViewHolder(View view) {
                super(view);
                equipname = (TextView) view.findViewById(R.id.equip_name);
                equipimage= (ImageView) view.findViewById(R.id.equip_image);
                equiplikes = (TextView)view.findViewById(R.id.equip_likes);
                equipstatus = (TextView)view.findViewById(R.id.equip_status);


            }
        }
    }

}
