package mnnit.harshitshah.mymanager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,37);
        calendar.set(Calendar.SECOND,0);
        Intent newi=new Intent(this,AlarmReceiver.class);
        newi.setAction("mnnit.harshitshah.mymanager");
        PendingIntent pendingintent =PendingIntent.getBroadcast(MainActivity.this,0,newi,0);
        AlarmManager am=(AlarmManager) MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),2,pendingintent);
      //  Toast.makeText(this,"Alarm Set", Toast.LENGTH_SHORT).show();
        EditText username=(EditText) findViewById(R.id.username);
        SharedPreferences user_name = getSharedPreferences("usernamefile", Context.MODE_PRIVATE);
        if(user_name.getString("name","")!="") {
            this.finish();
            Intent i = new Intent(this, check.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
    }

    public void register_func(View view) {
        EditText username = (EditText) findViewById(R.id.username);
        SharedPreferences user_name = getSharedPreferences("usernamefile", Context.MODE_PRIVATE);
        String username2 = username.getText().toString();
        SharedPreferences.Editor editor = user_name.edit();
        editor.putString("name", username2);
        editor.commit();
        this.finish();
        startActivity(new Intent(this, check.class));
    }
    }

