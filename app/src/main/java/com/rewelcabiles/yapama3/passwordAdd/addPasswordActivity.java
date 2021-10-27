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
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rewelcabiles.yapama3.R;
import com.rewelcabiles.yapama3.helper.PasswordFileManager;
import com.rewelcabiles.yapama3.passwordList.Password;

import java.lang.reflect.Array;

public class addPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);

        // Toolbar stuff
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar tBar = getSupportActionBar();
        tBar.setDisplayShowTitleEnabled(false);
        tBar.setDisplayHomeAsUpEnabled(true);

        // Button stuff
        AppCompatButton generate_button = findViewById(R.id.generate_button);
        AppCompatButton save_button = (AppCompatButton) findViewById(R.id.save_button);

        EditText input_name = findViewById(R.id.input_name);
        EditText input_password = findViewById(R.id.input_password);

        save_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                PasswordFileManager.add_password(new Password(input_name.getText().toString(), input_password.getText().toString()), getApplicationContext());

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }
}