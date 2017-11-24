package example.design.deeplinkin.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MobileOS> mobileOSes;
    private RecyclerAdapter adapter;
    private ListView lvItem;
    private LinearLayout llView;
    private LayoutInflater inflater;
    private TextView tvDate;
    private TextView tvNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileOSes = new ArrayList<>();
        setData();

        setUpForExapandableList();

        //setUpForListViewLikeExpandableList();



    }

    private void setUpForListViewLikeExpandableList() {

        llView = (LinearLayout) findViewById(R.id.llView);
        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        llView.removeAllViews();
        for (int i =0; i< mobileOSes.size(); i++){
            View view = inflater.inflate(R.layout.row_date, null);
            tvDate = (TextView) view.findViewById(R.id.tvDate);
            tvDate.setText(mobileOSes.get(i).getTitle());
            llView.addView(view);

            for (int j = 0; j < mobileOSes.get(i).getItems().size(); j++){
                View viewNotifications = inflater.inflate(R.layout.row_notification, null);
                tvNotification = (TextView) viewNotifications.findViewById(R.id.tvNotification);
                tvNotification.setText(mobileOSes.get(i).getItems().get(j).getName());
                llView.addView(viewNotifications);
            }

        }


    }


    private void setUpForExapandableList() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(this, mobileOSes);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        ArrayList<Phone> iphones = new ArrayList<>();
        iphones.add(new Phone("iPhone 4"));
        iphones.add(new Phone("iPhone 4S"));
        iphones.add(new Phone("iPhone 5"));
        iphones.add(new Phone("iPhone 5S"));
        iphones.add(new Phone("iPhone 6"));
        iphones.add(new Phone("iPhone 6Plus"));
        iphones.add(new Phone("iPhone 6S"));
        iphones.add(new Phone("iPhone 6S Plus"));

        ArrayList<Phone> nexus = new ArrayList<>();
        nexus.add(new Phone("Nexus One"));
        nexus.add(new Phone("Nexus S"));
        nexus.add(new Phone("Nexus 4"));
        nexus.add(new Phone("Nexus 5"));
        nexus.add(new Phone("Nexus 6"));
        nexus.add(new Phone("Nexus 5X"));
        nexus.add(new Phone("Nexus 6P"));
        nexus.add(new Phone("Nexus 7"));

        ArrayList<Phone> windowPhones = new ArrayList<>();
        windowPhones.add(new Phone("Nokia Lumia 800"));
        windowPhones.add(new Phone("Nokia Lumia 710"));
        windowPhones.add(new Phone("Nokia Lumia 900"));
        windowPhones.add(new Phone("Nokia Lumia 610"));
        windowPhones.add(new Phone("Nokia Lumia 510"));
        windowPhones.add(new Phone("Nokia Lumia 820"));
        windowPhones.add(new Phone("Nokia Lumia 920"));

        mobileOSes.add(new MobileOS("iOS", iphones));
        mobileOSes.add(new MobileOS("Android", nexus));
        mobileOSes.add(new MobileOS("Window Phone", windowPhones));
    }
}
