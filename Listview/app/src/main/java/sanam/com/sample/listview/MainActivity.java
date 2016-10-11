package sanam.com.sample.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button ascendingbutton;
    Button descendingbutton;
    private ListView listview;
    private TextView textview;
    private ArrayList<String> androidtextview;
    private Myadapter myadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView) findViewById(R.id.text_view);
        ascendingbutton = (Button) findViewById(R.id.ascending_button);
        descendingbutton = (Button) findViewById(R.id.descending_button);

        ascendingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doascending();
                myadapter.notifyDataSetChanged();
            }
        });
        descendingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodescending();
                myadapter.notifyDataSetChanged();
            }
        });


        listview = (ListView) findViewById(R.id.list_view);

        androidtextview = new ArrayList<>();
        androidtextview.add("JANUARY");
        androidtextview.add("FEBRUARY");
        androidtextview.add("MARCH");
        androidtextview.add("APRIL");
        androidtextview.add("MAY");
        androidtextview.add("JUNE");
        androidtextview.add("JULY");
        androidtextview.add("AUGUST");
        androidtextview.add("SEPTEMPER");
        androidtextview.add("OCTOBER");
        androidtextview.add("NOVEMBER");
        androidtextview.add("DECEMBER");


        myadapter = new Myadapter();
        listview.setAdapter(myadapter);

    }

    public class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return androidtextview.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View ConvertView, ViewGroup parent) {
            viewholder holder;
            if (ConvertView == null) {
                ConvertView = getLayoutInflater().inflate(R.layout.row_view, parent, false);
                holder = new viewholder();
                holder.bindView(ConvertView);
                ConvertView.setTag(holder);
                Log.e("Mainactivity", "convertview is null");
            } else {
                holder = (viewholder) ConvertView.getTag();

            }
            holder.textview.setText(androidtextview.get(position));
            return ConvertView;
        }


    }

    public class viewholder {
        TextView textview;


        void bindView(View convertView) {
            Log.e("MainActivity", "convertview is not null");
            textview = (TextView) convertView.findViewById(R.id.text_view);


        }

    }
    public void doascending(){
        Collections.sort(this.androidtextview);
    }
    public void dodescending(){
        Collections.sort(this.androidtextview,Collections.<String>reverseOrder());
    }

}
