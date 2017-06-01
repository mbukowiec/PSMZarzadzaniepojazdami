package pl.bukowiecmateusz.psmzp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class PbPriceTab extends AppCompatActivity {
    ListView lv_pb;
    PbLvAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    static String STACJA = "stacja";
    static String PB = "pb";
    String miasto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pb_price_tab);
        new JsoupListView().execute();

        Intent cityIntent = getIntent();
        miasto = cityIntent.getStringExtra("miasto");
    }
    String url;
    private class JsoupListView extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PbPriceTab.this);
            mProgressDialog.setTitle("Ceny paliw");
            mProgressDialog.setMessage("Pobieranie danych...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            url = String.valueOf("http://www.stacjebenzynowe.pl/search_stacje.php?action=srch&searchstacja_woj=&searchstacja_miasto="+miasto+"&tankowanie_miast=&paliwo=Pb95&sort=2");
            arraylist = new ArrayList<HashMap<String, String>>();

            try {
                Document doc = Jsoup.connect(url).get();
                for (Element table : doc.select("tr[bgcolor='#4C5662']")) {

                    for (Element row : table.select("tr:gt(1)")) {
                        HashMap<String, String> map = new HashMap<String, String>();
                        Elements tds = row.select("td");
                        map.put("stacja", tds.get(1).text());
                        map.put("pb", tds.get(2).text());
                        arraylist.add(map);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            lv_pb = (ListView) findViewById(R.id.lv_pb);
            adapter = new PbLvAdapter(PbPriceTab.this, arraylist);
            lv_pb.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }
}
