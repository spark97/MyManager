package mnnit.harshitshah.mymanager;

/**
 * Created by Harshit Shah on 09/03/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Harshit Shah on 04/03/2016.
 */
public class SavingsAdapter extends ArrayAdapter<String> {
    String[] titles;
    String[] details;
    Context c;
    LayoutInflater inflater;
    public SavingsAdapter(Context context, String[] titles, String[] details) {
        super(context,R.layout.savingslist,titles);
        this.c=context;
        this.titles=titles;
        this.details=details;
    }
    public class ViewHolder
    {
        TextView titles;
        TextView details;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.savingslist,null);
        }
        final ViewHolder holder = new ViewHolder();
        holder.titles= (TextView) convertView.findViewById(R.id.distext);
        holder.details=(TextView)convertView.findViewById(R.id.outtext);
        holder.titles.setText(titles[position]);
        holder.details.setText(details[position]);
        return convertView;
    }

}

