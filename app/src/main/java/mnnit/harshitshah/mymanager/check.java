package mnnit.harshitshah.mymanager;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Shader;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
public class check extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
    }
public void startnew(View view)
{
 Intent i = new Intent(this, newbudget.class);
    this.finish();
    startActivity(i);

}
    public void manage(View view)
    {
        Intent i = new Intent(this,DrawerActivity.class);
        this.finish();
        startActivity(i);
    }
}
