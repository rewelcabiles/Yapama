package com.rewelcabiles.yapama3.passwordList;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rewelcabiles.yapama3.R;
import com.rewelcabiles.yapama3.passwordAdd.addPasswordActivity;

import java.util.ArrayList;
import java.util.List;

public class PasswordListActivity extends AppCompatActivity {

    private TextView mTextView;

    private List<Password> passwordList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PasswordAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_list);

        //Action Bar Stuff
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar tbar = getSupportActionBar();
        tbar.setDisplayShowTitleEnabled(false);



        // Recycler View Stuff
        pAdapter = new PasswordAdapter(passwordList);
        recyclerView = (RecyclerView) findViewById(R.id.password_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);

        preparePasswordData();
    }

    private void preparePasswordData() {
        Password pass = new Password("Password 1", "123");
        passwordList.add(pass);

        pass = new Password("Password 2", "123");
        passwordList.add(pass);

        pAdapter.notifyDataSetChanged();
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
                Intent intent = new Intent(this, addPasswordActivity.class);
                startActivity(intent);
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return true;

    }


}