package mnnit.harshitshah.mymanager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by Harshit Shah on 17/01/2016.
 */
public class frag3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view=inflater.inflate(R.layout.frag3,container,false);
        super.onActivityCreated(savedInstanceState);
        SharedPreferences details=getActivity().getSharedPreferences("expensedetails",Context.MODE_PRIVATE);
        int food=details.getInt("foodspent", 0);
        int clothes=details.getInt("clothesspent",0);
        int movies=details.getInt("moviesspent",0);
        int parties=details.getInt("partiesspent",0);
        int recharge=details.getInt("rechargespent",0);
        int others=details.getInt("othersspent",0);
        ArrayList<BarEntry> data = new ArrayList<>();
        data.add(new BarEntry(food,0));
        data.add(new BarEntry(clothes,1));
        data.add(new BarEntry(movies,2));
        data.add(new BarEntry(parties,3));
        data.add(new BarEntry(recharge,4));
        data.add(new BarEntry(others,5));
        BarDataSet dataset = new BarDataSet(data,"Expenses");
        ArrayList<String> labels=new ArrayList<>();
        labels.add("Food");
        labels.add("Clothes");
        labels.add("Movies");
        labels.add("Parties");
        labels.add("Recharge");
        labels.add("Others");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarChart chart=new BarChart(this.getContext());
        chart.setDescription("Expenses Details");
        View view=chart;
        BarData chartdata= new BarData(labels,dataset);
        chart.setData(chartdata);
        return view;
    }

}
