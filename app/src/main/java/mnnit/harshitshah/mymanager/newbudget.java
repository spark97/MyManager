package mnnit.harshitshah.mymanager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class newbudget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.addexpensetitle);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbudgetlayout);
        final SharedPreferences expensedetails = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = expensedetails.edit();
        edit.clear();
        edit.commit();
        DBhelper mydb = new DBhelper(this);
        mydb.deletetable();
        final ListView lv = (ListView)findViewById(R.id.bdetails);
        String[] titles= {"Food","Clothes","Movies","Parties","Bills","Others"};
        BudgetAdapter badapter = new BudgetAdapter(this,titles);
        lv.setAdapter(badapter);
        Button save = (Button) findViewById(R.id.savebudget);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putInt("foodspent",0);
                edit.putInt("clothesspent",0);
                edit.putInt("partiesspent",0);
                edit.putInt("moviesspent",0);
                edit.putInt("rechargespent",0);
                edit.putInt("othersspent",0);
                int item;
                for (item = 0; item < lv.getCount(); item++) {
                    // Toast.makeText(getActivity(),item,Toast.LENGTH_SHORT).show();
                    View view = lv.getAdapter().getView(item,null,null);
                    EditText amount = (EditText) view.findViewById(R.id.bbudget);
                    TextView type = (TextView)view.findViewById(R.id.btype);
                    String typestring = type.getText().toString().toLowerCase();
                    String astring = amount.getText().toString();
                    if(typestring.equals("food") && astring.equals("")==false )
                    {
                        edit.putInt("food", Integer.parseInt(astring));
                    }
                    else if(typestring.equals("clothes") && astring.equals("")==false )
                    {
                        edit.putInt("clothes", Integer.parseInt(astring));
                    }
                    else if(typestring.equals("parties") && astring.equals("")==false)
                    {
                        edit.putInt("parties", Integer.parseInt(astring));
                    }
                    else if(typestring.equals("bills") && astring.equals("")==false)
                    {
                        edit.putInt("recharge", Integer.parseInt(astring));
                    }
                    else if(typestring.equals("movies") && astring.equals("")==false)
                    {
                        edit.putInt("movies", Integer.parseInt(astring));
                    }
                    else if(typestring.equals("others") && astring.equals("")==false)
                    {
                        edit.putInt("others", Integer.parseInt(astring));
                    }
                }
                edit.commit();
                Toast.makeText(getApplicationContext(),"Details Saved Successfully",Toast.LENGTH_LONG).show();
            }
        });

    }



    @Override
    public void onBackPressed() {
        this.finish();
        startActivity(new Intent(this,check.class));
    }

    public void savedetails(View view)
    {
        DBhelper mydb= new DBhelper(this);
        EditText food = (EditText) findViewById(R.id.foodedit);
        EditText clothes = (EditText) findViewById(R.id.clothesexpense);
        EditText parties = (EditText) findViewById(R.id.partiesedit);
        EditText movies = (EditText) findViewById(R.id.moviesexpense);
        EditText recharge = (EditText) findViewById(R.id.rechargeexpense);
        EditText others = (EditText) findViewById(R.id.othersexpense);
        int  foodexp = Integer.parseInt(food.getText().toString());
        int  clothesexp = Integer.parseInt(clothes.getText().toString());
        int  partiesexp = Integer.parseInt(parties.getText().toString());
        int  moviesexp = Integer.parseInt(movies.getText().toString());
        int  rechargeexp = Integer.parseInt(recharge.getText().toString());
       int  othersexp= Integer.parseInt(others.getText().toString());
        SharedPreferences expensedetails = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = expensedetails.edit();
        edit.putInt("food",foodexp);
        edit.putInt("clothes",clothesexp);
        edit.putInt("parties",partiesexp);
        edit.putInt("movies",moviesexp);
        edit.putInt("recharge",rechargeexp);
        edit.putInt("others",rechargeexp);
        edit.putInt("foodspent",0);
        edit.putInt("clothesspent",0);
        edit.putInt("partiesspent",0);
        edit.putInt("moviesspent",0);
        edit.putInt("rechargespent",0);
        edit.putInt("othersspent",0);
        edit.commit();
        Toast.makeText(getApplicationContext(),"Details Saved Successfully",Toast.LENGTH_LONG).show();
        this.finish();
        startActivity(new Intent(this, check.class));
    }

}
