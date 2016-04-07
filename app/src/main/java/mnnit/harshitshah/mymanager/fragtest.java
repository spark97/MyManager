package mnnit.harshitshah.mymanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Harshit Shah on 13/03/2016.
 */
public class fragtest extends Fragment implements View.OnClickListener{
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragtest,container,false);
        String[] type= {"Food","Clothes","Movies","Parties","Bills","Others"};
        Button savexep=(Button)view.findViewById(R.id.saveexp);
        final ListView lv=(ListView)view.findViewById(R.id.slist);
        final Adapter2 adapter = new Adapter2(getActivity(),type);
        lv.setAdapter(adapter);
        final DBhelper mydb=new DBhelper(getActivity());
        final SharedPreferences details= getActivity().getSharedPreferences("expensedetails",Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = details.edit();
        savexep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String date = df.format(c.getTime()).toString();
                int item;
                for (item = 0; item < lv.getCount(); item++) {
                   // Toast.makeText(getActivity(),item,Toast.LENGTH_SHORT).show();
                    View view = lv.getAdapter().getView(item,null,null);
                   EditText amount = (EditText) view.findViewById(R.id.amount);
                   EditText description = (EditText) view.findViewById(R.id.description);
                    TextView type = (TextView)view.findViewById(R.id.etype);
                    String typestring = type.getText().toString().toLowerCase();
                    String astring = amount.getText().toString();
                    if(typestring.equals("food") && astring.equals("")==false )
                    {
                        int prevval = details.getInt("foodspent", 0);
                        Log.d("reachedaaaa",astring);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("foodspent", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("food", Integer.parseInt(astring), note, "expense",date);
                    }
                    else if(typestring.equals("clothes") && astring.equals("")==false )
                    {
                        int prevval = details.getInt("clothesspent", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("clothesspent", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("clothes", Integer.parseInt(astring), note, "expense",date);
                    }
                    else if(typestring.equals("parties") && astring.equals("")==false)
                    {
                        int prevval = details.getInt("partiesspent", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("partiesspent", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("parties", Integer.parseInt(astring), note, "expense",date);
                    }
                    else if(typestring.equals("bills") && astring.equals("")==false)
                    {
                        int prevval = details.getInt("rechargespent", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("rechargespent", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("recharge", Integer.parseInt(astring), note, "expense",date);
                    }
                    else if(typestring.equals("movies") && astring.equals("")==false)
                    {
                        int prevval = details.getInt("moviesspent", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("moviesspent", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("movies", Integer.parseInt(astring), note, "expense",date);
                    }
                    else if(typestring.equals("others") && astring.equals("")==false)
                    {
                        int prevval = details.getInt("othersspent", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("othersspent", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("others", Integer.parseInt(astring), note, "expense",date);
                    }
                }
                Toast.makeText(getActivity(),"done",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
    }
}
