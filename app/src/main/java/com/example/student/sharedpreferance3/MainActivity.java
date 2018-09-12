package com.example.student.sharedpreferance3;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int red,green,blue,violet;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.parentLayout);

        red = getResources().getColor(R.color.red);
        blue = getResources().getColor(R.color.blue);
        green = getResources().getColor(R.color.green);
        violet = getResources().getColor(R.color.violet);



        loadBG();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_manu, menu);

        return super.onCreateOptionsMenu(menu);



    }

    private void loadBG() {
        SharedPreferences sharedPreferences= getSharedPreferences("db", Context.MODE_PRIVATE);
        int color= sharedPreferences.getInt("color",red);
        linearLayout.setBackgroundColor(color);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.redBtn){
            changeBG(red);

        }
        if(item.getItemId() == R.id.blueBtn){
            changeBG(blue);

        }
        if(item.getItemId() == R.id.greenBtn){
            changeBG(green);

        }
        if(item.getItemId() == R.id.violetBtn){
            changeBG(violet);

        }
        return super.onOptionsItemSelected(item);
    }

    private void changeBG(int color) {
        linearLayout.setBackgroundColor(color);
        saveColor(color);

    }

    private void saveColor(int color) {
        SharedPreferences sharedPreferences= getSharedPreferences("db", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putInt("color", color).commit();

    }
}
