package com.example.aryam.userfetcher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by aryam on 1/14/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    ArrayList<User> userArrayList = new ArrayList<>();
    Context context;
    public UserAdapter(ArrayList<User> users,Context parentContext){
        userArrayList = users;
        context = parentContext;
    }

    @Override
     public UserHolder onCreateViewHolder(ViewGroup parent, int viewType){
         View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
         UserHolder userHolder = new UserHolder(inflatedView);
         return userHolder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User currentUser = userArrayList.get(position);
        holder.login.setText(currentUser.getLogin());
        Picasso.with(holder.avatar.getContext()).load(currentUser.getAvatar()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
    public class UserHolder extends RecyclerView.ViewHolder{
        TextView login;
        de.hdodenhof.circleimageview.CircleImageView avatar;
        CardView cardView;

        public UserHolder(View itemView) {
            super(itemView);
            login = itemView.findViewById(R.id.login);
            avatar = itemView.findViewById(R.id.avatar);
            cardView = itemView.findViewById(R.id.item_card);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,ProfileActivity.class);
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.putExtra("USER",userArrayList.get(getAdapterPosition()).getUrl());
                    context.startActivity(intent);
                }
            });
        }
    }
}
