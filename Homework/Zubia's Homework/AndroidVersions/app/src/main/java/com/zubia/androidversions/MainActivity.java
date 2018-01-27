package com.zubia.androidversions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.ListView);

        AndroidAdapter androidAdapter = new AndroidAdapter(this,getAndroids());
        listView.setAdapter(androidAdapter);
    }

    private ArrayList<Android> getAndroids() {
        ArrayList<Android> androids = new ArrayList<>();

        androids.add(new Android("Android 1.0","1.0",1,"23.Sept.2008", R.drawable.a,
                "https://4androidfans.wordpress.com/2012/08/30/android-1-0-astro/"));
        androids.add(new Android("Android 1.1","1.1",2,"9.Feb.2009", R.drawable.b,
                "https://developer.android.com/about/versions/android-1.1.html"));
        androids.add(new Android("Cupcake","1.5",3,"27.Apr.2009", R.drawable.c,
                "https://developer.android.com/about/versions/android-1.5-highlights.html"));
        androids.add(new Android("Donut","1.6",4,"15.Sept.2009", R.drawable.d,
                "https://developer.android.com/about/versions/android-1.6-highlights.html"));
        androids.add(new Android("Eclair","2.0",5,"26.Oct.2009", R.drawable.e,
                "https://developer.android.com/about/versions/android-2.0-highlights.html"));
        androids.add(new Android("Eclair 2.0.1","2.0.1",6,"3.Dec.2009", R.drawable.e,
                "https://developer.android.com/about/versions/android-2.0-highlights.html"));
        androids.add(new Android("Eclair 2.1","2.1",7,"12.Jan.2010", R.drawable.e,
                "https://developer.android.com/about/versions/android-2.0-highlights.html"));
        androids.add(new Android("Froyo","2.2",8,"20.May.2010", R.drawable.f,
                "https://developer.android.com/about/versions/android-2.2-highlights.html"));
        androids.add(new Android("Gingerbread","2.3",9,"6.Dec.2010", R.drawable.g,
                "https://developer.android.com/about/versions/android-2.3-highlights.html"));
        androids.add(new Android("Gingerbread updates","2.3.3, 2.3.4, 2.3.5, 2.3.6, 2.3.7",
                10,"9.Feb, 28.Apr, 25.July, 2.Sept and 21.Sept.2011 respectively", R.drawable.g,
                "https://developer.android.com/about/versions/android-2.3-highlights.html"));
        androids.add(new Android("Honeycomb","3.0",11,"22.Feb.2011", R.drawable.h,
                "https://developer.android.com/about/versions/android-3.0-highlights.html"));
        androids.add(new Android("Honeycomb 3.1","3.1",12,"10.May.2011", R.drawable.h,
                "https://developer.android.com/about/versions/android-3.0-highlights.html"));
        androids.add(new Android("Honeycomb 3.2","3.2, 3.2,1, 3.2.2, 3.2.3, 3.2.4, 3.2.5 and 3.2.6",
                13,"15.July, 20.Sept, 30.Aug, 30.Aug, Dec.2011, Jan and Feb.2012 resp.", R.drawable.h,
                "https://developer.android.com/about/versions/android-3.0-highlights.html"));
        androids.add(new Android("Ice Cream Sandwich","4.0, 4.0.1 and 4.0.2",14,
                "18.Oct, 21.Oct and 28.Nov.2011 resp.", R.drawable.i, "https://developer.android.com/about/versions/android-4.0-highlights.html"));
        androids.add(new Android("Ice Cream Sandwich 4.0.3","4.0.3 and 4.0.4",15,
                "16.Dec.2011 and 29.Mar.2012 resp.", R.drawable.i, "https://developer.android.com/about/versions/android-4.0-highlights.html"));
        androids.add(new Android("Jellybean 4.1","4.1, 4.1.1 and 4.1.2",16,
                "9.July, 11.July and 9.Oct.2012 resp.", R.drawable.j, "https://www.android.com/versions/jelly-bean-4-3/"));
        androids.add(new Android("Jellybean 4.2","4.2, 4.2.1 and 4.2.2",17,
                "13.Nov, 27.Nov.2012 and 11.Feb.2013 resp.", R.drawable.j, "https://www.android.com/versions/jelly-bean-4-3/"));
        androids.add(new Android("Jellybean 4.3","4.3 and 4.3.1",18,
                "24.July and 3.Oct.2013 resp.", R.drawable.j, "https://www.android.com/versions/jelly-bean-4-3/"));
        androids.add(new Android("Kitkat 4.4","4.4, 4.4.1, 4.4.2, 4.4.3 and 4.4.4",
                19,"31.Oct, 5.Dec, 9.Dec.2013, 2.June and 19.June.2014 resp.", R.drawable.k,
                "https://www.android.com/versions/kit-kat-4-4/"));
        androids.add(new Android("Kitkat 4.4W with wearable extensions","4.4W, 4.4W.1 and 4.4W.2",
                20, "25.June, 6.Sept and 21.Oct.2014 resp.", R.drawable.k, "https://www.android.com/versions/kit-kat-4-4/"));
        androids.add(new Android("Lollipop 5.0","5.0, 5.0.1 and 5.0.2",21,
                "12.Nov, 2.Dec and 19.Dec.2014 resp.", R.drawable.l, "https://www.android.com/versions/lollipop-5-0/"));
        androids.add(new Android("Lollipop 5.1","5.1 and 5.1.1",22,
                "9.Mar and 21.Apr.2015 resp.", R.drawable.l, "https://www.android.com/versions/lollipop-5-0/"));
        androids.add(new Android("Marshmallow","6.0 and 6.0.1",23,
                "5.Oct and 7.Dec.2015 resp.", R.drawable.m, "https://www.android.com/versions/marshmallow-6-0/"));
        androids.add(new Android("Nougat 7.0","7.0",24,"22.Oct.2016", R.drawable.n,
                "https://www.android.com/versions/nougat-7-0/"));
        androids.add(new Android("Nougat 7.1","7.1, 7.1.1 and 7.1.2",25,
                "4.Oct, 5.Dec.2016 and 4.Apr.2017", R.drawable.n, "https://www.android.com/versions/nougat-7-0/"));
        androids.add(new Android("Oreo","8.0",26,"21.Aug.2017", R.drawable.o,
                "https://www.android.com/versions/oreo-8-0/"));
        androids.add(new Android("Oreo 8.1","8.1",27,"5.Dec.2017", R.drawable.o,
                "https://www.android.com/versions/oreo-8-0/"));

        return androids;
    }
}
