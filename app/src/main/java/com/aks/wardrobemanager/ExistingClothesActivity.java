package com.aks.wardrobemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class ExistingClothesActivity extends AppCompatActivity {

    private Button btn1b, btn1c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_clothes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();
        setOnClickListeners();

    }

    private void setOnClickListeners(){


        btn1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExistingClothesActivity.this, AllTopsActivity.class);
                startActivity(intent);
            }
        });

        btn1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExistingClothesActivity.this, AllBottomsActivity.class);
                startActivity(intent);
            }
        });


    }


    private void initWidgets(){
        btn1b = (Button)findViewById(R.id.btn1b);
        btn1c = (Button)findViewById(R.id.btn1c);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
