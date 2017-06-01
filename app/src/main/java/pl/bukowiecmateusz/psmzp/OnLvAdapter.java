package pl.bukowiecmateusz.psmzp;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OnLvAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public OnLvAdapter(Context context,
                           ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        data = arraylist;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView stacja;
        TextView on;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.on_price_item, parent, false);
        resultp = data.get(position);

        stacja = (TextView) itemView.findViewById(R.id.stacja);
        on = (TextView) itemView.findViewById(R.id.on);

        stacja.setText(resultp.get(OnPriceTab.STACJA));
        on.setText(resultp.get(OnPriceTab.ON));

        itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                resultp = data.get(position);
                Intent intent = new Intent(context, OnView.class);
                intent.putExtra("stacja", resultp.get(OnPriceTab.STACJA));
                intent.putExtra("on",resultp.get(OnPriceTab.ON));
                context.startActivity(intent);

            }
        });
        return itemView;
    }
}
