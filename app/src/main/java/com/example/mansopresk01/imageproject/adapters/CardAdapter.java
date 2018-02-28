package com.example.mansopresk01.imageproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mansopresk01.imageproject.Model.DocumentCategories;
import com.example.mansopresk01.imageproject.activities.CardActivity;
import com.example.mansopresk01.imageproject.Model.documents;
import com.example.mansopresk01.imageproject.R;
import com.example.mansopresk01.imageproject.activities.RecyclerDocActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mansopresk01 on 11/4/2017.
 */



public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>
{

    private Context context;

    List<documents> documentsList;
    CardActivity cardActivity;


    public Context getContext() {
        return context;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder
    {


        private final ImageView doc_icon;
        private final TextView doc_name,image_size;


        public ViewHolder(View itemView)
        {
            super(itemView);
            doc_name=(TextView)itemView.findViewById(R.id.doc_name);

            doc_icon = (ImageView) itemView.findViewById(R.id.doc_icon);

            image_size=(TextView)itemView.findViewById(R.id.image_size);
        }
    }

    public CardAdapter(List<documents> documentsList, CardActivity cardActivity)
    {
        this.documentsList = documentsList;
        this.cardActivity=cardActivity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        // View v = LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.list_reservation, parent, false);
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rcy_item,parent,false);
        ViewHolder pvh = new ViewHolder(view);
        return pvh;
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.doc_name.setText(documentsList.get(position).getDoc_name());
        holder.image_size.setText(documentsList.get(position).getDoc_size());
        Picasso.with(cardActivity).load(documentsList.get(position).getDoc_url())
                .placeholder(R.drawable.load)
                .into(holder.doc_icon);
    }


    @Override
    public int getItemCount()
    {
        return documentsList.size() ;

    }
}