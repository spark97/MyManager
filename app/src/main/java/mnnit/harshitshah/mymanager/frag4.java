package mnnit.harshitshah.mymanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class frag4 extends Fragment {
    DBhelper mydb;
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.frag4, container, false);
        mydb=new DBhelper(this.getActivity());
        //ArrayList array_list = mydb.getdetails();
      // String ne[]={"hi"};
      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.listview,R.id.list,array_list);
      //  Log.d("hey","hey");
       //ListView lv=(ListView)view.findViewById(R.id.details);
       // lv.setAdapter(adapter);
        ArrayList list_type=mydb.getdetails_type();
        ArrayList list_expense=mydb.getdetails_expense();
        ArrayList list_note=mydb.getdetails_note();
        ArrayList list_date=mydb.getdetails_date();
        ArrayList list_flag=mydb.getdetails_flag();
        /*String[] type = new String[1000];
        String[] note = new String[1000];
        Integer[] expense = new Integer[1000];
        int i;
        for(i=0;i<list_type.size();i++)
        {
            type[i]=list_type.get(i).toString();
        }
        for(i=0;i<list_note.size();i++)
        {
            note[i]=list_note.get(i).toString();
        }
        for(i=0;i<list_expense.size();i++)
        {
            expense[i]= (Integer) list_expense.get(i);
        }*/
        TransactionsAdapter tadapter = new TransactionsAdapter(getActivity(),list_type,list_note,list_expense,list_date,list_flag);
        ListView lv = (ListView)view.findViewById(R.id.details);
        lv.setAdapter(tadapter);
        return view;
    }
}
