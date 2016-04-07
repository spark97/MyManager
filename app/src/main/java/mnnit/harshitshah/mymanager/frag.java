package mnnit.harshitshah.mymanager;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
public class frag extends Fragment implements OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        Button foodnote = (Button)getActivity().findViewById(R.id.foodnote);
        foodnote.setOnClickListener(this);
        Button clothesnote = (Button)getActivity().findViewById(R.id.clothesnote);
        clothesnote.setOnClickListener(this);
        Button partiesnote = (Button)getActivity().findViewById(R.id.partiesnote);
        partiesnote.setOnClickListener(this);
        Button othersnote = (Button)getActivity().findViewById(R.id.othersnote);
        othersnote.setOnClickListener(this);
        Button billnote = (Button)getActivity().findViewById(R.id.billnote);
        billnote.setOnClickListener(this);
        Button moviesnote = (Button)getActivity().findViewById(R.id.moviesnote);
        moviesnote.setOnClickListener(this);
        Button b = (Button)getActivity().findViewById(R.id.saveedit);
      /*  b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText foodedit = (EditText) getActivity().findViewById(R.id.foodedit);
                EditText clothesedit = (EditText) getActivity().findViewById(R.id.clothesedit);
                EditText moviesedit = (EditText) getActivity().findViewById(R.id.moviesedit);
                EditText partiesedit = (EditText) getActivity().findViewById(R.id.partiesedit);
                EditText rechargeedit = (EditText) getActivity().findViewById(R.id.rechargeedit);
                EditText othersedit = (EditText) getActivity().findViewById(R.id.othersedit);
                SharedPreferences expensedetails = getActivity().getSharedPreferences("expensedetails", Context.MODE_PRIVATE);
                int prevfood = expensedetails.getInt("foodspent", 0);
                int prevclothes = expensedetails.getInt("clothesspent", 0);
                int prevmovies = expensedetails.getInt("moviesspent", 0);
                int prevparties = expensedetails.getInt("partiesspent", 0);
                int prevrecharge = expensedetails.getInt("rechargespent", 0);
                int prevothers = expensedetails.getInt("othersspent", 0);
                int newfood = prevfood + Integer.parseInt(foodedit.getText().toString());
                int newclothes = prevclothes + Integer.parseInt(clothesedit.getText().toString());
                int newmovies = prevmovies + Integer.parseInt(moviesedit.getText().toString());
                int newparties = prevparties + Integer.parseInt(partiesedit.getText().toString());
                int newrecharge = prevrecharge + Integer.parseInt(rechargeedit.getText().toString());
                int newothers = prevothers + Integer.parseInt(othersedit.getText().toString());
                // Toast.makeText(this.getContext(), "Expenses Saved Successfully", Toast.LENGTH_LONG).show();
                SharedPreferences.Editor edit = expensedetails.edit();
                edit.putInt("foodspent", newfood);
                edit.putInt("clothesspent", newclothes);
                edit.putInt("moviesspent", newmovies);
                edit.putInt("partiesspent", newparties);
                edit.putInt("rechargespent", newrecharge);
                edit.putInt("othersspent", newothers);
                edit.commit();
                Toast.makeText(getActivity(), "Expenses Saved Successfully", Toast.LENGTH_LONG).show();
            }
        });*/
    }


    @Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(this.getActivity(),storenote.class);
       switch(v.getId())
       {
           case R.id.foodnote :
               i.putExtra("type", "food");
               EditText foodedit = (EditText) getActivity().findViewById(R.id.foodedit);
              // Log.d("done", "done");
               i.putExtra("value", (foodedit.getText().toString()));
               Toast.makeText(getActivity(), foodedit.getText().toString(), Toast.LENGTH_LONG).show();
               getActivity().finish();
               getActivity().startActivity(i);
               break;
           case R.id.clothesnote :
               i.putExtra("type","clothes");
               EditText clothesedit = (EditText) getActivity().findViewById(R.id.clothesedit);
               i.putExtra("value",(clothesedit.getText().toString()));
               getActivity().finish();
               getActivity().startActivity(i);
               break;
           case R.id.othersnote :
               i.putExtra("type","others");
               EditText othersedit = (EditText) getActivity().findViewById(R.id.othersedit);
               i.putExtra("value",(othersedit.getText().toString()));
               getActivity().finish();
               getActivity().startActivity(i);
               break;
           case R.id.moviesnote :
               i.putExtra("type","movies");
               EditText moviesedit = (EditText) getActivity().findViewById(R.id.moviesedit);
               i.putExtra("value",(moviesedit.getText().toString()));
               getActivity().finish();
               getActivity().startActivity(i);
               break;
           case R.id.partiesnote :
               i.putExtra("type","parties");
               EditText partiesedit = (EditText) getActivity().findViewById(R.id.partiesedit);
               i.putExtra("value",(partiesedit.getText().toString()));
               getActivity().finish();
               getActivity().startActivity(i);
               break;
           case R.id.billnote :
               i.putExtra("type","bill");
               EditText billsedit = (EditText) getActivity().findViewById(R.id.rechargeedit);
               i.putExtra("value",(billsedit.getText().toString()));
               getActivity().finish();
               getActivity().startActivity(i);
               break;
       }
    }
}
