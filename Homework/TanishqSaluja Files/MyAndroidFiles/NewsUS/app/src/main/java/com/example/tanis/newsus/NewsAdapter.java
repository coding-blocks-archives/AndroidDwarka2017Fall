package com.example.tanis.newsus;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tanis on 1/19/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    ArrayList<News> arrayList=null;
    Context context;
    NewsAdapter(Context c,ArrayList<News> list){
        this.context=c;
        this.arrayList=list;
    }
    class NewsHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,description;
        FloatingActionButton floatingActionButton;
        public NewsHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            imageView=itemView.findViewById(R.id.image);
            floatingActionButton=itemView.findViewById(R.id.fab);
        }
    }

    @Override
    public NewsAdapter.NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false));
    }

    @Override
    public void onBindViewHolder(final NewsAdapter.NewsHolder holder, int position) {
        final News news=arrayList.get(position);
        holder.title.setText(news.getTitle());
        holder.description.setText(news.getDescription());
        if(news.getPhoto()=="null")
        {
            Picasso.with(context)
                    .load(R.drawable.blank)
                    .error(R.mipmap.ic_launcher_round)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(holder.imageView);
        }
        else {
            Picasso.with(context)
                    .load(news.getPhoto())
                    .error(R.mipmap.ic_launcher_round)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(holder.imageView);
        }
        holder.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(news.getMore()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(arrayList != null)
            return arrayList.size();
        else
            return 0;
    }
}
