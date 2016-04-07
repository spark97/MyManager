package mnnit.harshitshah.mymanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class manage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
    }
    @Override
    public void onBackPressed() {
        this.finish();
        startActivity(new Intent(this, check.class));
    }
    public void saveedit(View view)
    {
        EditText foodedit = (EditText) findViewById(R.id.foodedit);
        EditText clothesedit = (EditText) findViewById(R.id.clothesedit);
        EditText moviesedit = (EditText) findViewById(R.id.moviesedit);
        EditText partiesedit = (EditText) findViewById(R.id.partiesedit);
        EditText rechargeedit = (EditText) findViewById(R.id.rechargeedit);
        EditText othersedit = (EditText) findViewById(R.id.othersedit);
        SharedPreferences expensedetails = getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
        int prevfood = expensedetails.getInt("foodspent", 0);
        int prevclothes=expensedetails.getInt("clothesspent", 0);
        int prevmovies=expensedetails.getInt("moviesspent", 0);
        int prevparties=expensedetails.getInt("partiesspent", 0);
        int prevrecharge=expensedetails.getInt("rechargespent", 0);
        int prevothers=expensedetails.getInt("othersspent", 0);
        int newfood=prevfood+Integer.parseInt(foodedit.getText().toString());
        int newclothes=prevclothes+Integer.parseInt(clothesedit.getText().toString());
        int newmovies=prevmovies+Integer.parseInt(moviesedit.getText().toString());
        int newparties=prevparties+Integer.parseInt(partiesedit.getText().toString());
        int newrecharge=prevrecharge+Integer.parseInt(rechargeedit.getText().toString());
        int newothers=prevothers+Integer.parseInt(othersedit.getText().toString());
        SharedPreferences.Editor edit=expensedetails.edit();
        edit.putInt("foodspent",newfood);
        edit.putInt("clothesspent",newclothes);
        edit.putInt("moviesspent",newmovies);
        edit.putInt("partiesspent",newparties);
        edit.putInt("rechargespent",newrecharge);
        edit.putInt("othersspent",newothers);
        edit.commit();
        Toast.makeText(getApplicationContext(), "Expenses Saved Successfully", Toast.LENGTH_LONG).show();
        this.finish();
        startActivity(new Intent(this, check.class));
    }
    public void savings(View view)
    {
        this.finish();
        startActivity(new Intent(this, savings.class));
    }
}
