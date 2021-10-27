package com.rewelcabiles.yapama3.passwordAdd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.rewelcabiles.yapama3.R;

public class addPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);

        setSupportActionBar(toolbar);
        ActionBar tBar = getSupportActionBar();
        tBar.setDisplayShowTitleEnabled(false);
        tBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            case R.id.button_new_folder:
                Toast.makeText(getApplicationContext(), "Feature In Progress", Toast.LENGTH_LONG).show();
                return true;
            case R.id.button_search:
                Toast.makeText(getApplicationContext(), "Feature In Proagress", Toast.LENGTH_LONG).show();
                return true;

            case R.id.button_new_password:
                Toast.makeText(getApplicationContext(), "Feature In Progdess", Toast.LENGTH_LONG).show();
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.add_menu, menu);
        return true;
    }
}