package com.example.animalsbbdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder>{class AnimalViewHolder extends RecyclerView.ViewHolder {
    private final TextView animalItemView;

    private AnimalViewHolder(View itemView) {
        super(itemView);
        animalItemView = itemView.findViewById(R.id.textView);
    }
}

    private final LayoutInflater mInflater;
    private List<Animal> mAnimals; // Cached copy of animals

    AnimalListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        if (mAnimals != null) {
            Animal current = mAnimals.get(position);
            //holder.animalItemView.setText(current.getAnimal()); TODO revisar getter a Animal
            holder.animalItemView.setText(current.getAnimal());
        } else {
            // Covers the case of data not being ready yet.
            holder.animalItemView.setText("No Animal");
        }
    }

    void setAnimals(List<Animal> animals){
        mAnimals = animals;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mAnimals has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mAnimals != null)
            return mAnimals.size();
        else return 0;
    }
}
