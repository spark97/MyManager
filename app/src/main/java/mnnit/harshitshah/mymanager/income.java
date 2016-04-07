package mnnit.harshitshah.mymanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Harshit Shah on 03/02/2016.
 */
public class income extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.income,container,false);
        final ListView details = (ListView)view.findViewById(R.id.details);
        Button btn = (Button)view.findViewById(R.id.save);
        final DBhelper mydb = new DBhelper(getActivity());
        final SharedPreferences saveddetails= getActivity().getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = saveddetails.edit();
        String[] titles= {"Food","Clothes","Movies","Parties","Bills","Others"};
        IncomeAdapter adp=new IncomeAdapter(getActivity(),titles);
        details.setAdapter(adp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String date = df.format(c.getTime()).toString();
                int item;
                for (item = 0; item < details.getCount(); item++) {
                    // Toast.makeText(getActivity(),item,Toast.LENGTH_SHORT).show();
                    View view = details.getAdapter().getView(item,null,null);
                    EditText amount = (EditText) view.findViewById(R.id.iamount);
                    EditText description = (EditText) view.findViewById(R.id.idescription);
                    TextView type = (TextView)view.findViewById(R.id.itype);
                    String typestring = type.getText().toString().toLowerCase();
                    String astring = amount.getText().toString();
                    if(typestring.equals("food") && astring.equals("")==false )
                    {
                        int prevval = saveddetails.getInt("food", 0);
                        //Log.d("reachedaaaa", astring);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("food", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("food", Integer.parseInt(astring), note, "income",date);
                    }
                    else if(typestring.equals("clothes") && astring.equals("")==false )
                    {
                        int prevval = saveddetails.getInt("clothes", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("clothes", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("clothes", Integer.parseInt(astring), note, "income",date);
                    }
                    else if(typestring.equals("parties") && astring.equals("")==false)
                    {
                        int prevval = saveddetails.getInt("parties", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("parties", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("parties", Integer.parseInt(astring), note, "income",date);
                    }
                    else if(typestring.equals("bills") && astring.equals("")==false)
                    {
                        int prevval = saveddetails.getInt("recharge", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("recharge", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("recharge", Integer.parseInt(astring), note, "income",date);
                    }
                    else if(typestring.equals("movies") && astring.equals("")==false)
                    {
                        int prevval = saveddetails.getInt("movies", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("movies", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("movies", Integer.parseInt(astring), note, "income",date);
                    }
                    else if(typestring.equals("others") && astring.equals("")==false)
                    {
                        int prevval = saveddetails.getInt("others", 0);
                        prevval = Integer.parseInt(astring) + prevval;
                        edit.putInt("others", prevval);
                        edit.commit();
                        String note = description.getText().toString();
                        mydb.insertnote("others", Integer.parseInt(astring), note, "income",date);
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onClick(View v) {
      /*  EditText incomeval = (EditText) getActivity().findViewById(R.id.income);
        EditText inote = (EditText) getActivity().findViewById(R.id.inote);
        EditText ifood = (EditText) getActivity().findViewById(R.id.ifood);
        EditText iclothes = (EditText) getActivity().findViewById(R.id.iclothes);
        EditText ibills = (EditText) getActivity().findViewById(R.id.ibills);
        EditText imovies = (EditText) getActivity().findViewById(R.id.imovies);
        EditText iparties = (EditText) getActivity().findViewById(R.id.iparties);
        EditText iothers = (EditText) getActivity().findViewById(R.id.iothers);
        switch (v.getId())
        {
            case R.id.button:
                if(incomeval.getText().toString()=="")
                {
                    Toast.makeText(getActivity(),"Please Enter The Income Amount",Toast.LENGTH_LONG).show();
                }
                else if(inote.getText().toString()=="")
                {
                    Toast.makeText(getActivity(),"Please Enter A Note",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(Integer.parseInt(ifood.getText().toString())+Integer.parseInt(iclothes.getText().toString())+Integer.parseInt(iparties.getText().toString())
                            +Integer.parseInt(ibills.getText().toString())+Integer.parseInt(imovies.getText().toString())+Integer.parseInt(iothers.getText().toString())!=
                            Integer.parseInt(incomeval.getText().toString()))
                    {
                        Toast.makeText(getActivity(),"Please Split The Income Correctly",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                            DBhelper mydb = new DBhelper(getActivity());
                       // mydb.insertnote("Income",Integer.parseInt(incomeval.getText().toString()),inote.getText().toString(),"");
                        Toast.makeText(getActivity(),"Income Saved Succesfully",Toast.LENGTH_LONG).show();
                        getActivity().finish();
                        startActivity(new Intent(getActivity(),DrawerActivity.class));
                    }
                }
        }*/
    }
}
