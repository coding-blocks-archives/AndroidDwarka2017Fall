package com.zubia.androidversions;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;




public class AndroidAdapter extends BaseAdapter {
    Context context;
    ArrayList<Android> androids;

    public AndroidAdapter(Context context, ArrayList<Android> androidArrayList){
        this.context = context;
        androids = androidArrayList;
    }

    @Override
    public int getCount() {
        return androids.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = LayoutInflater.from(context);

        View inflatedView;
        if(view == null)
            inflatedView = li.inflate(R.layout.item_row,viewGroup,false);
        else
            inflatedView = view;

        BindView(inflatedView,i);

        return inflatedView;
    }

    private void BindView(View view, int position){
        final Android currentAndroid = androids.get(position);

        TextView androidName = view.findViewById(R.id.androidName);
        ImageView androidPic = view.findViewById(R.id.androidPic);

        androidName.setText(currentAndroid.getName());

        //Drawable drawable = res.getDrawable(R.drawable.pic);
        //androidPic.setImageDrawable(drawable);

        androidPic.setImageResource(currentAndroid.getPic());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,currentAndroid.getName(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context,DetailActivity.class);
                i.putExtra("Name",currentAndroid.getName());
                i.putExtra("Version",currentAndroid.getVersion());
                i.putExtra("APIlevel",currentAndroid.getAPIlevel());
                i.putExtra("RelDate", currentAndroid.getRelDate());
                i.putExtra("Pic", currentAndroid.getPic());
                i.putExtra("Page",currentAndroid.getPage());
                context.startActivity(i);
            }
        });
    }
}
