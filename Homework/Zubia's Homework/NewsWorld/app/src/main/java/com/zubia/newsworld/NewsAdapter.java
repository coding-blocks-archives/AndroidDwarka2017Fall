package com.zubia.newsworld;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shahabkhan on 1/27/18.
 */

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{
    Context context;
    ArrayList<NewsDetails> newsDetailses;

    public NewsAdapter(Context context, ArrayList<NewsDetails> newsDetailses) {
        this.context = context;
        this.newsDetailses = newsDetailses;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=(LayoutInflater.from(context)).inflate(R.layout.single_news_item,parent,false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        final NewsDetails newsDetails=newsDetailses.get(position);
        holder.tvTitle.setText(newsDetails.getTITLE());
        holder.tvPublisher.setText("By : "+newsDetails.getPUBLISHER());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomTabsIntent customTabsIntent=new CustomTabsIntent.Builder().build();
                customTabsIntent.launchUrl(context, Uri.parse(newsDetails.getURL()));
//                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(newsDetails.getURL()));
//                context.startActivity(intent);
            }
        });

        String c=newsDetails.getCATEGORY(),category;
        if(c.equals("b")) category="Business";
        else if(c.equals("t")) category="Science and technology";
        else if(c.equals("e")) category="Entertainment";
        else if(c.equals("m")) category="Health";
        else category="Unknown";
        holder.tvCategory.setText("Category : "+category);
    }

    @Override
    public int getItemCount() {
        return newsDetailses.size();
    }
    class NewsHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvPublisher;
        TextView tvCategory;
        CardView cardView;
        public NewsHolder(View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardView);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvPublisher=itemView.findViewById(R.id.tvPublisher);
            tvCategory=itemView.findViewById(R.id.tvCategory);
        }
    }
}
