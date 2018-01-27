package com.zubia.mymovieworld;

/**
 * Created by shahabkhan on 1/20/18.
 */

import android.support.v7.widget.RecyclerView;

        import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

        import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by shahabkhan on 1/18/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    final ListItemClickListener myListItemClickListener;
    ArrayList<MovieList> movies;
    Context context;

    public RecyclerViewAdapter(ListItemClickListener mListItemClickListener , ArrayList<MovieList> movies, Context context) {
        this.movies = movies;
        this.context=context;
        this.myListItemClickListener = mListItemClickListener;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        int layouIdForListItem = R.layout.itemrow;
        LayoutInflater inflater = LayoutInflater.from(context);


        View view = inflater.inflate(layouIdForListItem,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        final MovieList currentmovie = movies.get(position);
        Log.e(TAG, "onBindViewHolder: "+ currentmovie.getImgPath());
        Picasso.with(context)
                .load("http://image.tmdb.org/t/p/w185/"+currentmovie.getImgPath())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                //.transform(new CircleTransform())
                .into(holder.myImageView);

    }




    @Override
    public int getItemCount() {
        if (movies != null)
            return movies.size();
        else
            return 0;
    }

    public interface ListItemClickListener{
        void onClick(int position,MovieList movie);
    }



    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        public ImageView myImageView;

        public MyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            myImageView = (ImageView) itemView.findViewById(R.id.imgv_movie_image);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            MovieList movie = movies.get(position);
            myListItemClickListener.onClick(position,movie);
        }
    }

}
