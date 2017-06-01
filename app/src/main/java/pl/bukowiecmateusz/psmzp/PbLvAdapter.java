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

public class PbLvAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public PbLvAdapter(Context context,
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
        TextView pb;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.pb_price_item, parent, false);
        resultp = data.get(position);

        stacja = (TextView) itemView.findViewById(R.id.stacja);
        pb = (TextView) itemView.findViewById(R.id.pb);

        stacja.setText(resultp.get(PbPriceTab.STACJA));
        pb.setText(resultp.get(PbPriceTab.PB));

        itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                resultp = data.get(position);
                Intent intent = new Intent(context, PbView.class);
                intent.putExtra("stacja", resultp.get(PbPriceTab.STACJA));
                intent.putExtra("pb", resultp.get(PbPriceTab.PB));
                context.startActivity(intent);
            }
        });
        return itemView;
    }
}
