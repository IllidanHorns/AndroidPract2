package com.example.pract2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<State> states = new ArrayList<State>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        StateAdapter adapter = new StateAdapter(this, states);
        recyclerView.setAdapter(adapter);
    }
        private void setInitialData(){
            states.add(new State ("Греция", "Афины", R.drawable.greece_flag));
            states.add(new State ("Бразилия", "Бразилия", R.drawable.brazilian_flag));
            states.add(new State ("Южная корея", "Сеул", R.drawable.south_korea_flag));
        }
}