package com.varunkumar.myapplication;



import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView grid;

    Integer[] imageIDs = {
            R.drawable.ginger, R.drawable.honeycomb, R.drawable.icecream,
            R.drawable.jellybeans, R.drawable.kitkat, R.drawable.lollipop
    };
    String[] inames={"GingerBread","Honeycomb","Ice-cream Sandwich","Jellybeans","Kitkat","Lollipop"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(new ImageAdapterGridView(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                Toast.makeText(getBaseContext(), inames[position] + " Selected", Toast.LENGTH_LONG).show();
            }
        });

    }

    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view=getLayoutInflater().inflate(R.layout.row,parent,false);
            ImageView imageView= (ImageView) view.findViewById(R.id.image);
            if (convertView == null) {
                imageView.setImageResource(imageIDs[position]);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(imageIDs[position]);
            return imageView;
        }
    }
}