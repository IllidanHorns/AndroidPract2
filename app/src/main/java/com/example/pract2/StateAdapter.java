package com.example.pract2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pract2.StateAdapter;
import androidx.viewpager2.adapter.StatefulAdapter;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<State> states;

    StateAdapter(Context context, List<State> states)
    {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }

    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.ViewHolder holder, int position) {
        State state = states.get(position);
        holder.flagView.setImageResource(state.getFlagResource());
        holder.nameView.setText(state.getName());
        holder.capitalView.setText(state.getCapital());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(),
                    "Название: " + state.getName() + "\nСтолица: " + state.getCapital(),
                    Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView flagView;
        final TextView nameView, capitalView;

        public ViewHolder(View itemView) {
            super(itemView);
            flagView = itemView.findViewById(R.id.flag);
            nameView = itemView.findViewById(R.id.name);
            capitalView = itemView.findViewById(R.id.capital);
        }
    }
}
