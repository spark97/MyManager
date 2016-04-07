package mnnit.harshitshah.mymanager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by Harshit Shah on 01/01/2016.
 */
public class frag2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.frag2, container, false);
        TextView total = (TextView)rootView.findViewById(R.id.total);
        SharedPreferences details = getActivity().getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
        ListView lv=(ListView)rootView.findViewById(R.id.savingslist);
        String[] titles= {"Food","Clothes","Movies","Parties","Bills","Others"};
        String[] detailsarray={String.valueOf(details.getInt("food", 0)-details.getInt("foodspent",0))
                ,String.valueOf(details.getInt("clothes", 0)-details.getInt("clothesspent",0))
                ,String.valueOf(details.getInt("movies", 0)-details.getInt("moviesspent",0))
                ,String.valueOf(details.getInt("parties", 0)-details.getInt("partiesspent",0))
                ,String.valueOf(details.getInt("recharge", 0)-details.getInt("rechargespent",0))
                ,String.valueOf(details.getInt("others", 0)-details.getInt("othersspent",0))};
        int totalsaving = details.getInt("food", 0)-details.getInt("foodspent",0)
                +details.getInt("clothes", 0)-details.getInt("clothesspent",0)
                +details.getInt("movies", 0)-details.getInt("moviesspent",0)
                +details.getInt("parties", 0)-details.getInt("partiesspent",0)
                +details.getInt("recharge", 0)-details.getInt("rechargespent",0)
                +details.getInt("others", 0)-details.getInt("othersspent",0);
        total.setText("Rs."+String.valueOf(totalsaving));
        SavingsAdapter adapter = new SavingsAdapter(getActivity(),titles,detailsarray);
        lv.setAdapter(adapter);
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
