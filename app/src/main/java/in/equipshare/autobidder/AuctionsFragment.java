package in.equipshare.autobidder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuctionsFragment extends Fragment {
    public static final int FADE_DURATION=1500;
    RecyclerView recyclerView;
    DataAdapter adapter;
    Context context;
    ArrayList<UpcomingAuctionRec> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_auctions, container, false);
        rootView.getBackground().setAlpha(91);
        recyclerView=(RecyclerView) rootView.findViewById(R.id.auctions_recycler);
        data=filldatas();

        adapter=new DataAdapter(getActivity().getApplicationContext(),data);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),1));
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public ArrayList<UpcomingAuctionRec> filldatas(){
        ArrayList<UpcomingAuctionRec> data = new ArrayList<>();
        int sa=getResources().getIdentifier("dashboarditems","array",getActivity().getPackageName());
        int ia=getResources().getIdentifier("imagesnames","array",getActivity().getPackageName());
        String[] array=getResources().getStringArray(sa);
        String[] imagearray=getResources().getStringArray(ia);

        int i=0;
        while(i<array.length){
            data.add(new UpcomingAuctionRec("12345","123" ,"Lamborghini Huracan","19100000","19500000"));
            i++;
        }
        return data;
    }

    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
        private ArrayList<UpcomingAuctionRec> upcomingAuctionRecs;
        private Context context;

        public DataAdapter(Context context,ArrayList<UpcomingAuctionRec> upcomingAuctionRecs) {
            this.context = context;
            this.upcomingAuctionRecs=upcomingAuctionRecs;

        }

        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.upcomingauctionsrecycler, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {

            viewHolder.auctionid.setText(upcomingAuctionRecs.get(i).getAuction_id());
            viewHolder.auctionequip.setText(upcomingAuctionRecs.get(i).getAuction_equip());
            viewHolder.auctionbasebid.setText(upcomingAuctionRecs.get(i).getAuction_basebid());
            viewHolder.auctionimage.setImageResource(R.drawable.left);
            viewHolder.auctionimage.setClickable(true);

            viewHolder.auctioncurrentbid.setText(upcomingAuctionRecs.get(i).getAuction_currentbid());
            viewHolder.auctionbidnow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.auctionyourbid.setText(viewHolder.auctioncurrentbid.getText().toString());
                    viewHolder.auctionbidnow.setEnabled(false);
                    viewHolder.auctionbidnow.setVisibility(View.INVISIBLE);
                    viewHolder.auctionincrbid.setVisibility(View.VISIBLE);
                    viewHolder.auctionincrbid.setEnabled(true);
                    viewHolder.auctiondecrbid.setVisibility(View.VISIBLE);
                    viewHolder.auctiondecrbid.setEnabled(false);
                  /*  LayoutInflater inflater=getLayoutInflater();
                    final View alert = inflater.inflate(R.layout.bid_now_alert,null);
                    TextView equip_name=(TextView)alert.findViewById(R.id.bid_now_equip);
                    final TextView equip_curr=(TextView)alert.findViewById(R.id.bid_now_current);
                    final TextView equip_your=(TextView)alert.findViewById(R.id.bid_now_your);
                    final Button plus=(Button)alert.findViewById(R.id.bid_now_plus);
                    final Button min=(Button)alert.findViewById(R.id.bid_now_min);

                    equip_name.setText(upcomingAuctionRecs.get(i).getAuction_equip());
                    equip_curr.setText(upcomingAuctionRecs.get(i).getAuction_currentbid());
                    equip_your.setText(upcomingAuctionRecs.get(i).getAuction_currentbid());

                    if(equip_curr.getText().toString().equals(equip_your.getText().toString())){
                        min.setEnabled(false);
                    }
                    else{
                        min.setEnabled(true);
                    }
                    plus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int x= Integer.parseInt(equip_your.getText().toString())+1000;
                            equip_your.setText(Integer.toString(x));
                            min.setEnabled(true);
                        }
                    });
                    min.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int a=Integer.parseInt(equip_your.getText().toString())-1000;
                            equip_your.setText(Integer.toString(a));
                            if(equip_curr.getText().toString().equals(equip_your.getText().toString())){
                                min.setEnabled(false);

                            }
                        }
                    });
                    final AlertDialog.Builder alertbuild=new AlertDialog.Builder(getContext());

                    alertbuild.setTitle("BID Now");
                    alertbuild.setView(alert);
                    alertbuild.setCancelable(false);

                    alertbuild.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertbuild.setPositiveButton("BID Now", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AlertDialog.Builder ab=new AlertDialog.Builder(getContext());
                            ab.setTitle("BID Now");
                            ab.setView(alert);
                            ab.setCancelable(false);
                            ab.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            ab.setNeutralButton("Change BID", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            ab.setPositiveButton("Confirm BID", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getContext(),"BID Success",Toast.LENGTH_LONG).show();
                                }
                            });
                            dialog.dismiss();
                            AlertDialog dia=ab.create();
                            int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
                            int height = (int)(getResources().getDisplayMetrics().heightPixels*0.50);
                            dia.show();
                            dia.getWindow().setLayout(width,height);
                        }
                    });
                    AlertDialog dialog=alertbuild.create();
                    int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
                    int height = (int)(getResources().getDisplayMetrics().heightPixels*0.50);
                    dialog.show();
                    dialog.getWindow().setLayout(width,height);*/
                }
            });
            viewHolder.auctionincrbid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x= Integer.parseInt(viewHolder.auctionyourbid.getText().toString())+1000;
                    viewHolder.auctioncurrentbid.setText(Integer.toString(x));
                    viewHolder.auctiondecrbid.setEnabled(true);
                }
            });
            viewHolder.auctiondecrbid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a=Integer.parseInt(viewHolder.auctionyourbid.getText().toString())-1000;
                    viewHolder.auctionyourbid.setText(Integer.toString(a));
                    if(viewHolder.auctionyourbid.getText().toString().equals(viewHolder.auctioncurrentbid.getText().toString())){
                       viewHolder.auctiondecrbid.setEnabled(false);

                    }
                }
            });
            setFadeAnimation(viewHolder.itemView);

        }
        private void setFadeAnimation(View view) {
            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(FADE_DURATION);
            view.startAnimation(anim);
        }

        @Override
        public int getItemCount() {
            return upcomingAuctionRecs.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            ImageView auctionimage;
            TextView auctionid;
            Button auctionbidnow;
            TextView auctionequip;
            TextView auctionbasebid;
            TextView auctioncurrentbid;
            TextView auctionyourbid;
            Button auctionincrbid;
            Button auctiondecrbid;
            public ViewHolder(View view) {
                super(view);
                auctionid = (TextView)view.findViewById(R.id.auction_id);
                auctionbidnow = (Button)view.findViewById(R.id.auction_bid_now);
                auctionequip = (TextView)view.findViewById(R.id.auction_equip);
                auctionbasebid = (TextView)view.findViewById(R.id.auction_base_bid);
                auctionimage = (ImageView) view.findViewById(R.id.auction_image);
                auctionimage.setClickable(true);
                auctionimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(v.getContext(),CarProfileActivity.class));
                    }
                });
                auctioncurrentbid= (TextView)view.findViewById(R.id.auction_current_bid);
                auctionyourbid= (TextView) view.findViewById(R.id.auction_your_bid);
                auctionincrbid= (Button)view.findViewById(R.id.incr_bid);
                auctiondecrbid= (Button)view.findViewById(R.id.decr_bid);
            }
        }
    }


}
