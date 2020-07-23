package com.aks.wardrobemanager;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.File;


public class GridViewActivity extends Activity {

    private String[] FilePathStrings;
    private String[] FileNameStrings;
    private File[] listFile;
    Gallery gallerry, gallerry2;
    GridViewAdapter adapter, adapter2;
    File file;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        // Check for SD Card
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                    .show();
        } else {
            file = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "/Android/data/com.aks.wardrobemanager/files/Pictures/");
            file.mkdirs();
        }

        if (file.isDirectory()) {
            listFile = file.listFiles();
            FilePathStrings = new String[listFile.length];
            FileNameStrings = new String[listFile.length];

            for (int i = 0; i < listFile.length; i++) {
                FilePathStrings[i] = listFile[i].getAbsolutePath();
                FileNameStrings[i] = listFile[i].getName();
            }
        }

        gallerry = (Gallery) findViewById(R.id.gridview);
        adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
        gallerry.setSpacing(2);
        gallerry.setAdapter(adapter);

        gallerry.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                zoomImage(position);
            }

        });


        //second test
        gallerry2 = (Gallery) findViewById(R.id.gridview2);
        adapter2 = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
        gallerry2.setSpacing(2);
        gallerry2.setAdapter(adapter2);

        gallerry2.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                zoomImage(position);
            }

        });
    }

    private void zoomImage(int position) {
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
