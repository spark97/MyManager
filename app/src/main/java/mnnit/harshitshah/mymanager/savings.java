package mnnit.harshitshah.mymanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class savings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);
        SharedPreferences details = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
        TextView foodsave = (TextView) findViewById(R.id.foodsave);
        TextView clothessave = (TextView) findViewById(R.id.clothessave);
        TextView moviessave = (TextView) findViewById(R.id.moviessave);
        TextView partiessave = (TextView) findViewById(R.id.partiessave);
        TextView rechargessave = (TextView) findViewById(R.id.rechargesave);
        TextView otherssave = (TextView) findViewById(R.id.otherssave);
        TextView total = (TextView) findViewById(R.id.total);
        foodsave.setText(String.valueOf(details.getInt("food", 0)-details.getInt("foodspent",0)));
        clothessave.setText(String.valueOf(details.getInt("clothes", 0) - details.getInt("clothesspent", 0)));
        moviessave.setText(String.valueOf(details.getInt("movies", 0) - details.getInt("moviesspent", 0)));
        partiessave.setText(String.valueOf(details.getInt("parties", 0)-details.getInt("partiesspent",0)));
        rechargessave.setText(String.valueOf(details.getInt("recharge", 0)-details.getInt("rechargespent", 0)));
        otherssave.setText(String.valueOf(details.getInt("others",0)-details.getInt("othersspent", 0)));
        total.setText(String.valueOf(details.getInt("food", 0)-details.getInt("foodspent",0)+details.getInt("movies", 0) - details.getInt("moviesspent", 0)+details.getInt("clothes", 0) - details.getInt("clothesspent", 0)+details.getInt("parties", 0)-details.getInt("partiesspent",0)+details.getInt("recharge", 0)-details.getInt("rechargespent", 0)+details.getInt("others",0)-details.getInt("othersspent", 0)));
    }
    @Override
    public void onBackPressed() {
        this.finish();
        startActivity(new Intent(this,check.class));
    }
}
