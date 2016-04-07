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
public class  BudgetAdapter extends ArrayAdapter<String> {
    String[] type;
    Context c;

    LayoutInflater inflater;
    public BudgetAdapter(Context context, String[] type) {
        super(context,R.layout.newbudget,type);
        this.c=context;
        this.type=type;
    }
    static final public class  ViewHolder1
    {
        TextView type1;
        EditText amount1;
    }
    HashMap<String,String> amountmap = new HashMap<String,String>();
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder1 holder;
        View rowview = convertView;
        if(rowview==null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = inflater.inflate(R.layout.newbudget, null);
            holder = new ViewHolder1();
            holder.type1 = (TextView)rowview.findViewById(R.id.btype);
            holder.amount1 = (EditText) rowview.findViewById(R.id.bbudget);
            rowview.setTag(holder);
        }
        else
        {
            holder = (ViewHolder1)rowview.getTag();
        }
        holder.type1.setText(type[position]);
        holder.amount1.setText(amountmap.get(holder.type1.getText().toString()));
        holder.amount1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                amountmap.put(holder.type1.getText().toString(), holder.amount1.getText().toString());
                //Log.d("amount",holder.amount1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return rowview;
    }

}

