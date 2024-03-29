package com.example.hydrationapp.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hydrationapp.R;
import com.example.hydrationapp.db.DatabaseHelper;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<HomeItem> homeItems;
    private Context context;

    HomeAdapter(List<HomeItem> homeItems, Context context) {
        this.homeItems = homeItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.water_list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HomeItem homeItem = homeItems.get(position);

        holder.textAge.setText(homeItem.getMedicineName());
        holder.textlitresSummary.setText(homeItem.getDosageSummary());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    holder.imageButtonDelete.setVisibility(View.VISIBLE);
                else
                    holder.imageButtonDelete.setVisibility(View.GONE);
            }
        });
        holder.imageButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(context);
                databaseHelper.deleteMedicine(holder.textAge.getText().toString());
                holder.cardView.setVisibility(View.GONE);
                Toast.makeText(context, holder.textAge.getText().toString() + " deleted", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        MaterialTextView textAge, textlitresSummary;
        MaterialCardView cardView;
        MaterialCheckBox checkBox;
        ImageButton imageButtonDelete;

        ViewHolder(View itemView)
        {
            super(itemView);

            textlitresSummary = itemView.findViewById(R.id.dosage_text_view);
            textAge = itemView.findViewById(R.id.age_text_view);
            cardView = itemView.findViewById(R.id.card_view_age);
            checkBox = itemView.findViewById(R.id.age_checkbox);
            imageButtonDelete = itemView.findViewById(R.id.water_delete_button);

        }
    }
}
