package com.aks.wardrobemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

public class AllBottomsActivity extends AppCompatActivity {

    private String[] FilePathStrings;
    private String[] FileNameStrings;
    private File[] listFile;
    File file;
    private RecyclerView clothesRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_bottoms);



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


        clothesRecView = (RecyclerView)findViewById(R.id.clothesRecView);


        RecViewAdapter adapter = new RecViewAdapter(this);
        clothesRecView.setAdapter(adapter);
        clothesRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }


}
