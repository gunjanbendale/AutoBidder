package in.equipshare.autobidder;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.util.ArrayList;

/**
 * Created by Gunjan Bendale on 21-01-2018.
 */

public class DRMLeadsFragment extends Fragment {

    private RecyclerView rv;
    ArrayList<Leads_Details> details;
    FloatingActionButton b;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_drmleads,container,false);
        rv = (RecyclerView) rootview.findViewById(R.id.drm_lead_recycler);
        details = new ArrayList<Leads_Details>();
        details.add(new Leads_Details("Gunjan","buy","9999999999","26Jan18"));
        details.add(new Leads_Details("Gunjan","buy","9999999999","26Jan18"));
        details.add(new Leads_Details("Gunjan","buy","9999999999","26Jan18"));
        details.add(new Leads_Details("Gunjan","buy","9999999999","26Jan18"));
        details.add(new Leads_Details("Gunjan","buy","9999999999","26Jan18"));
        DataAdapter adapter = new DataAdapter(details, getActivity().getApplicationContext());
        rv.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),2));
        rv.setAdapter(adapter);

        b=rootview.findViewById(R.id.add_lead);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),CarProfileActivity.class));
            }
        });
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
