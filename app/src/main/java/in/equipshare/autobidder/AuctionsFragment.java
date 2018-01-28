package in.equipshare.autobidder;

import android.content.Context;
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

import java.util.ArrayList;

public class AuctionsFragment extends Fragment {
    public static final int FADE_DURATION=1500;
    RecyclerView recyclerView;
    DataAdapter adapter;
    ArrayList<UpcomingAuctionRec> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_auctions, container, false);
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
        public void onBindViewHolder(ViewHolder viewHolder, final int i) {

            viewHolder.auctionid.setText(upcomingAuctionRecs.get(i).getAuction_id());
            viewHolder.auctionequip.setText(upcomingAuctionRecs.get(i).getAuction_equip());
            viewHolder.auctionbasebid.setText(upcomingAuctionRecs.get(i).getAuction_basebid());
            viewHolder.auctionimage.setImageResource(R.drawable.left);
            viewHolder.auctioncurrentbid.setText(upcomingAuctionRecs.get(i).getAuction_currentbid());
            viewHolder.auctionbidnow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

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
            public ViewHolder(View view) {
                super(view);
                auctionid = (TextView)view.findViewById(R.id.auction_id);
                auctionbidnow = (Button)view.findViewById(R.id.auction_bid_now);
                auctionequip = (TextView)view.findViewById(R.id.auction_equip);
                auctionbasebid = (TextView)view.findViewById(R.id.auction_base_bid);
                auctionimage = (ImageView) view.findViewById(R.id.auction_image);
                auctioncurrentbid= (TextView)view.findViewById(R.id.auction_current_bid);
            }
        }
    }


}
