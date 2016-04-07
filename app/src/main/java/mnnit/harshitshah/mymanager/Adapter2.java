package mnnit.harshitshah.mymanager;

/**
 * Created by Harshit Shah on 09/03/2016.
 */
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;

/**
 * Created by Harshit Shah on 04/03/2016.
 */
public class Adapter2 extends ArrayAdapter<String> {
    String[] type;
    Context c;
    LayoutInflater inflater;
    public Adapter2(Context context, String[] type) {
        super(context,R.layout.enterexpenses,type);
        this.c=context;
        this.type=type;
    }
    static final public class  ViewHolder
    {
        TextView type1;
        EditText amount1 ;
        EditText description1;
    }
    HashMap<String,String> amountmap = new HashMap<String,String>();
    HashMap<String,String> desmap = new HashMap<String,String>();
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
         final ViewHolder holder;
        View rowview = convertView;
        if(rowview==null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = inflater.inflate(R.layout.enterexpenses, null);
            holder = new ViewHolder();
            holder.type1 = (TextView)rowview.findViewById(R.id.etype);
            holder.amount1 = (EditText) rowview.findViewById(R.id.amount);
            holder.description1 = (EditText) rowview.findViewById(R.id.description);
            rowview.setTag(holder);
        }
     else
        {
            holder = (ViewHolder)rowview.getTag();
        }
        holder.type1.setText(type[position]);
        holder.amount1.setText(amountmap.get(holder.type1.getText().toString()));
        holder.description1.setText(desmap.get(holder.type1.getText().toString()));
        holder.amount1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                amountmap.put(holder.type1.getText().toString(), holder.amount1.getText().toString());
                Log.d("amount",holder.amount1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        holder.description1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                desmap.put(holder.type1.getText().toString(),holder.description1.getText().toString());
                Log.d("amount", holder.description1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return rowview;
    }

}

