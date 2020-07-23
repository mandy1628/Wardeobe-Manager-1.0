package com.aks.wardrobemanager;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class  RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder>
{

    private CardView clothCard;

    private static final String TAG = "RecViewAdapter";

    private Context context;


    public RecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_rec_view,viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");
        viewHolder.clothCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                public void zoomImage(int position){
                    final Dialog dialog = new Dialog(GridViewActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.getWindow().setBackgroundDrawableResource(
                            android.R.color.transparent);
                    dialog.setContentView(R.layout.image_zoomdialog);
                    ImageView imageview = (ImageView) dialog.findViewById(R.id.imageView1);
                    Bitmap bmp = BitmapFactory.decodeFile(FilePathStrings[position]);
                    imageview.setImageBitmap(bmp);
                    dialog.show();
                }
            }
        });
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
;
        private CardView clothCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            CardView clothCard = (CardView) itemView.findViewById(R.id.clothCard);
        }
    }


}

