import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.TextView;

import mnnit.harshitshah.mymanager.R;

public class Topfragment extends Fragment {
    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences user_name=this.getActivity().getSharedPreferences("usernamefile",Context.MODE_PRIVATE);
       View view=inflater.inflate(R.layout.topfragment2, container, false);
        TextView usernamedisplay = (TextView) view.findViewById(R.id.usernamedisplay);
        usernamedisplay.setText(user_name.getString("name","").toString());
        return view;
    }
}
