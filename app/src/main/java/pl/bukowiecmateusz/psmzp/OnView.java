package pl.bukowiecmateusz.psmzp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OnView extends Activity {

    String stacja;
    String on;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_price_item);

        Intent i = getIntent();
        stacja = i.getStringExtra("stacja");
        on = i.getStringExtra("on");

        TextView tvStacja = (TextView) findViewById(R.id.stacja);
        TextView tvOn = (TextView) findViewById(R.id.on);

        tvStacja.setText(stacja);
        tvOn.setText(on);

    }
}