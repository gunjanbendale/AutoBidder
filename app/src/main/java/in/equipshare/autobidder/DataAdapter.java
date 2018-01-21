package in.equipshare.autobidder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Gunjan Bendale on 21-01-2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Leads_Details> leads_details;
    private Context context;

    public DataAdapter(ArrayList<Leads_Details> leads_details, Context context) {
        this.leads_details = leads_details;
        this.context = context;
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.drm_leads_, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return leads_details.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.name.setText(leads_details.get(i).getName());
        viewHolder.contact.setText(leads_details.get(i).getContact());
        viewHolder.buy.setText(leads_details.get(i).getBuy());
        viewHolder.nexttime.setText(leads_details.get(i).getNextTime());

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView buy;
        TextView contact;
        TextView nexttime;

        public ViewHolder(View view) {
            super(view);

            name = (TextView)view.findViewById(R.id.drm_equip_name);
            buy= (TextView)view.findViewById(R.id.drm_equip_buy);
            contact= (TextView)view.findViewById(R.id.drm_equip_contact);
            nexttime= (TextView)view.findViewById(R.id.drm_equip_nexttime);

        }
    }
}
