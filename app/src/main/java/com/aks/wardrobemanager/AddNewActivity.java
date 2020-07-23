package com.aks.wardrobemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AddNewActivity extends AppCompatActivity {

    Button btn3a,btn3b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        initWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners(){


        btn3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewActivity.this, AddTopActivity.class);
                startActivity(intent);
            }
        });

        btn3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewActivity.this, AddBottomActivity.class);
                startActivity(intent);
            }
        });


    }


    private void initWidgets(){
        btn3a = (Button)findViewById(R.id.btn3a);
        btn3b = (Button)findViewById(R.id.btn3b);
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
