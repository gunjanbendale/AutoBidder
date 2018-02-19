package in.equipshare.autobidder;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;
import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.ArrayList;
import java.util.List;

import in.equipshare.autobidder.model.MenuItems;

public class DashboardFragActivity extends Fragment implements OnChartValueSelectedListener{

    RecyclerView recyclerView;
    DataAdapter adapter;
    private ArrayList<MenuItems> menuItems;
    private final static int FADE_DURATION = 1400;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.activity_dashboard_frag, container, false);
        rootView.getBackground().setAlpha(91);
        //Set onclick Listener for buttons in Dashboard fragment
        PieChart pieChart = (PieChart) rootView.findViewById(R.id.piechart1);
        pieChart.setUsePercentValues(true);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.menurec);
        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        List<PieEntry> yvalues = new ArrayList<PieEntry>();
        yvalues .add(new PieEntry(18f, "Mustang"));
        yvalues.add(new PieEntry(15f, "Audi R8"));
        yvalues.add(new PieEntry(12f, "Bugatti Veyron"));
        yvalues.add(new PieEntry(15f, "Maserati M2"));
        yvalues.add(new PieEntry(23f, "Koeningsegg Agera R"));
        yvalues.add(new PieEntry(17f, "Lamborghini Veneno"));

        PieDataSet dataSet = new PieDataSet(yvalues, "Your Cars");

        ArrayList<String> xVals = new ArrayList<String>();
        /*
        xVals.add("Mustang");
        xVals.add("Audi R8");
        xVals.add("Bugatti Veyron");
        xVals.add("Maserati M2");
        xVals.add("Koeningsegg Agera R");
        xVals.add("Lamborghini Veneno");
        */
        PieData data = new PieData(dataSet);
        // In Percentage term
        data.setValueFormatter(new PercentFormatter());
        // Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        pieChart.setData(data);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(35f);
        pieChart.setHoleRadius(35f);
        dataSet.setColors(ColorsTemplate.COLOR_SCHEMES);
        data.setValueTextColor(Color.BLACK);
        data.setValueTextSize(10f);
        pieChart.setOnChartValueSelectedListener(this);

        pieChart.animateXY(1400, 1400);
        /*
        BarChart barChart=(BarChart) rootView.findViewById(R.id.barchart);
        ArrayList<BarEntry> barvalues = new ArrayList<BarEntry>();
        barvalues.add(new BarEntry(1f, 0));
        barvalues.add(new BarEntry(5f,1));
        barvalues.add(new BarEntry(2f, 2));
        barvalues.add(new BarEntry(5f, 3));
        barvalues.add(new BarEntry(3f, 4));
        barvalues.add(new BarEntry(7f, 5));

        BarDataSet barDataSet1=new BarDataSet(barvalues,"CarLikes");
        barDataSet1.setColor(Color.RED);

        ArrayList<BarEntry> barviewvalues = new ArrayList<BarEntry>();
        barviewvalues.add(new BarEntry(1f, 0));
        barviewvalues.add(new BarEntry(5f, 1));
        barviewvalues.add(new BarEntry(2f, 2));
        barviewvalues.add(new BarEntry(5f, 3));
        barviewvalues.add(new BarEntry(3f, 4));
        barviewvalues.add(new BarEntry(7f, 5));

        BarDataSet barDataSet2= new BarDataSet(barviewvalues,"CarViews");
        barDataSet2.setColor(Color.BLUE);

        BarData barData=new BarData(barDataSet1,barDataSet2);
        float groupSpace = 0.06f;
        float barSpace = 0.02f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
        barData.setValueFormatter(new LargeValueFormatter());
        barData.setBarWidth(barWidth);

        barChart.setData(barData);
        */

        menuItems=filldatas();
        adapter= new DataAdapter(getActivity().getApplicationContext(),menuItems);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),2));
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
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("DashBoard");
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

    public ArrayList<MenuItems> filldatas(){
        ArrayList<MenuItems> data = new ArrayList<>();
        int sa=getResources().getIdentifier("dashboarditems","array",getActivity().getPackageName());
        int ia=getResources().getIdentifier("imagesnames","array",getActivity().getPackageName());
        String[] array=getResources().getStringArray(sa);
        String[] imagearray=getResources().getStringArray(ia);

        int i=0;
        while(i<array.length){
            MaterialDrawableBuilder.IconValue r= MaterialDrawableBuilder.IconValue.valueOf(imagearray[i]);
            data.add(new MenuItems(array[i],r));
            i++;
        }
        return data;
    }

    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
        private ArrayList<MenuItems> menuItems;
        private Context context;

        public DataAdapter(Context context,ArrayList<MenuItems> menuItems) {
            this.context = context;
            this.menuItems=menuItems;

        }

        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dashboard_menus, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int i) {

            viewHolder.menuname.setText(menuItems.get(i).getMenuname());
            viewHolder.iconView.setIcon(menuItems.get(i).getMenulgo());
            setFadeAnimation(viewHolder.itemView);
        }
        private void setFadeAnimation(View view) {
            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(FADE_DURATION);
            view.startAnimation(anim);
        }

        @Override
        public int getItemCount() {
            return menuItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView menuname;
            MaterialIconView iconView;
            public ViewHolder(View view) {
                super(view);
                iconView = (MaterialIconView) view.findViewById(R.id.iconmenu);
                menuname = (TextView)view.findViewById(R.id.menutext);

            }
        }
    }
}
