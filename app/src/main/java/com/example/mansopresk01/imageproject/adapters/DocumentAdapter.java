package com.example.mansopresk01.imageproject.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mansopresk01.imageproject.Model.DocumentCategories;
import com.example.mansopresk01.imageproject.R;
import com.example.mansopresk01.imageproject.activities.RecyclerDocActivity;

import java.util.List;


/**
 * Created by Mansopresk01 on 11/3/2017.
 */

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder>
{

    public static class ViewHolder extends  RecyclerView.ViewHolder
    {



        public TextView form_txt,count_form;
        public ImageView form,form_label;

        public ViewHolder(View itemView)
        {
            super(itemView);
            form_txt=(TextView)itemView.findViewById(R.id.formtxt);
            count_form=(TextView)itemView.findViewById(R.id.countForm);
            form=(ImageView) itemView.findViewById(R.id.form);
            form_label=(ImageView) itemView.findViewById(R.id.form_labl);
        }
    }
    List<DocumentCategories> documentCategories;
    RecyclerDocActivity mainactivty;

    public DocumentAdapter(List<DocumentCategories> documentCategories, RecyclerDocActivity mainActivity)
    {
        this.documentCategories = documentCategories;
        this.mainactivty=mainActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // View v = LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.list_reservation, parent, false);
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        ViewHolder pvh = new ViewHolder(view);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.form_txt.setText(String.valueOf(documentCategories.get(position).getCat_name()));
        holder.count_form.setText(String.valueOf(documentCategories.get(position).getNum_docs()));

        if (documentCategories.get(position).getCat_background_img().equalsIgnoreCase("form_bg.png")) {
            holder.form.setImageResource(R.drawable.form_bg);

        } else  if (documentCategories.get(position).getCat_background_img().equalsIgnoreCase("images_bg.png")) {
                holder.form.setImageResource(R.drawable.images_bg);

            } else if (documentCategories.get(position).getCat_background_img().equalsIgnoreCase("mydocuments_bg.png")) {
                holder.form.setImageResource(R.drawable.mydocuments_bg);


            } else if (documentCategories.get(position).getCat_background_img().equalsIgnoreCase("bankstatement_bg.png")) {
                holder.form.setImageResource(R.drawable.bankstatement_bg);


            } else if (documentCategories.get(position).getCat_background_img().equalsIgnoreCase("otherdocuments_bg.png")) {
                holder.form.setImageResource(R.drawable.otherdocuments_bg);

            }


        if (documentCategories.get(position).getCat_icon().equalsIgnoreCase("forms_ic.png")) {
            holder.form_label.setImageResource(R.drawable.forms_ic);
        } else if (documentCategories.get(position).getCat_icon().equalsIgnoreCase("images_ic.png")) {
            holder.form_label.setImageResource(R.drawable.images_ic);
        } else if (documentCategories.get(position).getCat_icon().equalsIgnoreCase("mydocuments_ic.png")) {
            holder.form_label.setImageResource(R.drawable.mydocuments_ic);
        } else if (documentCategories.get(position).getCat_icon().equalsIgnoreCase("bankstatement_ic.png")) {
            holder.form_label.setImageResource(R.drawable.bankstatement_ic);
        } else if (documentCategories.get(position).getCat_icon().equalsIgnoreCase("otherdocuments_ic.png")) {
            holder.form_label.setImageResource(R.drawable.otherdocuments_ic);
        }

        }


    @Override
    public int getItemCount()
    {
        return documentCategories.size() ;

    }
}






