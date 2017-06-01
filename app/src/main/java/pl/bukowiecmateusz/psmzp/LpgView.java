package pl.bukowiecmateusz.psmzp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LpgView extends Activity {

    String stacja;
    String lpg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lpg_price_item);

        Intent i = getIntent();
        stacja = i.getStringExtra("stacja");
        lpg = i.getStringExtra("on");

        TextView tvStacja = (TextView) findViewById(R.id.stacja);
        TextView tvOn = (TextView) findViewById(R.id.lpg);

        tvStacja.setText(stacja);
        tvOn.setText(lpg);

    }
}