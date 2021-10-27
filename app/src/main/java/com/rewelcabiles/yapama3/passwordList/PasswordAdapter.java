package com.rewelcabiles.yapama3.passwordList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rewelcabiles.yapama3.R;

import java.util.List;

public class PasswordAdapter extends RecyclerView.Adapter <PasswordAdapter.MyViewHolder>{
    private List<Password> passwordList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.password_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Password password = passwordList.get(position);
        holder.name.setText(password.getName());
    }

    @Override
    public int getItemCount() {
        return passwordList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.password_name);

        }
    }
    public PasswordAdapter(List<Password> passwordList) {
        this.passwordList = passwordList;
    }
}
