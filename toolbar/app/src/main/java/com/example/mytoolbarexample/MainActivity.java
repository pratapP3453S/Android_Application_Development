package com.example.mytoolbarexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Toolbar tool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tool = findViewById(R.id.tool);

        setSupportActionBar(tool);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("My tool My rule");
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }
        tool.setSubtitle("my toolbar subtitle");

        public boolean onCreateOptionsMenu(Menu menu){
            new MenuInflater(this).inflate(R.menu.opt_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

        public boolean onOptionsItemSelected(MenuItem item){
            int itemId = item.getItemId();

            if(itemId == R.id.first){
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
            }
            else if(itemId == R.id.second){
                Toast.makeText(this, "second", Toast.LENGTH_SHORT).show();
            }
            else if(itemId == R.id.third){
                Toast.makeText(this, "third", Toast.LENGTH_SHORT).show();
            }
            else if(itemId == R.id.fourth){
                Toast.makeText(this, "fourth", Toast.LENGTH_SHORT).show();
            }
            else{
                super.onBackPressed();
            }

            return super.onOptionsItemSelected(item);
        }
    }
}