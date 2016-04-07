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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Harshit Shah on 04/03/2016.
 */
public class TransactionsAdapter extends ArrayAdapter<String> {
    /*String[] type;
    String[] note;
    Integer[] expense;*/
    ArrayList type;
    ArrayList note;
    ArrayList expense;
    ArrayList date;
    ArrayList eflag;
    Context c;
    LayoutInflater inflater;
    public TransactionsAdapter(Context context,ArrayList type,ArrayList note,ArrayList expense,ArrayList date,ArrayList flag) {
        super(context,R.layout.enterexpenses,type);
        this.c=context;
        this.type=type;
        this.note=note;
        this.expense=expense;
        this.date=date;
        this.eflag=flag;
    }
    static final public class  ViewHolder
    {
        TextView etype;
        TextView eamount;
        TextView edescription;
        TextView edate;
        ImageView image;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowview = convertView;
        if (rowview == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = inflater.inflate(R.layout.transactions, null);
        }
        ViewHolder holder = new ViewHolder();
        holder.etype=(TextView)rowview.findViewById(R.id.type);
        holder.eamount=(TextView)rowview.findViewById(R.id.amount);
        holder.edescription=(TextView)rowview.findViewById(R.id.description);
        holder.edate=(TextView)rowview.findViewById(R.id.date);
        holder.image=(ImageView)rowview.findViewById(R.id.image);
        holder.etype.setText(type.get(position).toString().toUpperCase());
        holder.eamount.setText("Rs: "+expense.get(position).toString());
        holder.edescription.setText(note.get(position).toString());
        holder.edate.setText(date.get(position).toString());
        if(eflag.get(position).toString().equals("expense"))
        {
            holder.image.setImageResource(R.drawable.photo);
        }
        else{

        }
        return rowview;
    }
}

