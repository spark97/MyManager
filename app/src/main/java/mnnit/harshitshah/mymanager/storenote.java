package mnnit.harshitshah.mymanager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class storenote extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storenote);
        final EditText n = (EditText)findViewById(R.id.note);
        Button b = (Button)findViewById(R.id.save);

        Bundle intentdata=getIntent().getExtras();
        final String type=intentdata.getString("type");
        Toast.makeText(this, type, Toast.LENGTH_LONG).show();
       final int value = Integer.parseInt(intentdata.getString("value"));
        final DBhelper mydb=new DBhelper(this);
        final Integer finalValue = value;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("food")) {
                    Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_LONG).show();
                    int prevfood;
                    SharedPreferences details = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = details.edit();
                    prevfood = details.getInt("foodspent", 0);
                    prevfood = value + prevfood;
                    edit.putInt("foodspent", prevfood);
                    edit.commit();
                }
                else if(type.equals("clothes"))
                {
                    SharedPreferences details = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = details.edit();
                    int prevclothes = details.getInt("clothesspent", 0);
                    prevclothes = value + prevclothes;
                    edit.putInt("clothesspent", prevclothes); edit.commit();
                }
                else if(type.equals("others"))
                {
                    SharedPreferences details = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = details.edit();
                    int prevothers = details.getInt("othersspent", 0);
                    prevothers = value + prevothers;
                    edit.putInt("othersspent", prevothers); edit.commit();
                }
                else if(type.equals("movies"))
                {
                    SharedPreferences details = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = details.edit();
                    int prevmovies = details.getInt("moviesspent", 0);
                    prevmovies = value + prevmovies;
                    edit.putInt("moviesspent", prevmovies); edit.commit();
                }
                else if(type.equals("bill"))
                {
                    SharedPreferences details = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = details.edit();
                    int prevrecharges = details.getInt("rechargespent", 0);
                    prevrecharges = value + prevrecharges;
                    edit.putInt("rechargespent", prevrecharges); edit.commit();
                }
                else if(type.equals("parties"))
                {
                    SharedPreferences details = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = details.edit();
                    int prevparties = details.getInt("partiesspent", 0);
                    prevparties = value + prevparties;
                    edit.putInt("partiesspent", prevparties); edit.commit();
                }
                String note = n.getText().toString();
               // mydb.insertnote(type, finalValue, note,"-");
                exitfunct();
            }
        });
    }

    private void exitfunct() {
        this.finish();
        startActivity(new Intent(this,DrawerActivity.class));
    }

    @Override
    public void onBackPressed() {
      this.finish();
        startActivity(new Intent(this, DrawerActivity.class));
    }

    @Override
    public void onClick(View v) {

    }
}
