package pl.bukowiecmateusz.psmzp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PbView extends Activity {
    // Declare Variables
    String stacja;
    String pb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pb_price_item);

        Intent i = getIntent();
        stacja = i.getStringExtra("stacja");
        pb = i.getStringExtra("pb");

        TextView tvStacja = (TextView) findViewById(R.id.stacja);
        TextView tvPb = (TextView) findViewById(R.id.pb);

        tvStacja.setText(stacja);
        tvPb.setText(pb);
    }
}