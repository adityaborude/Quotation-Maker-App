package com.example.quotationmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText Profit;
    EditText ET2;
    EditText ET3;
    EditText ET4;
    TextView Total;
    LinearLayout LL3;
    float profit;
    Button submit_button;
    Button add_button;
    ItemAdapter IA;
    ArrayList<Item> items;
    float total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Profit = findViewById(R.id.profit);
        ET2 = findViewById(R.id.ET2);
        ET3 = findViewById(R.id.ET3);
        ET4 = findViewById(R.id.ET4);
        submit_button = findViewById(R.id.submit_button);
        add_button = findViewById(R.id.add_item);
        Total = findViewById(R.id.TV5);
        LL3 = findViewById(R.id.LL3);
        items = new ArrayList<>();
        IA = new ItemAdapter(items);
        final RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(IA);
        recyclerView.setHasFixedSize(true);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Item item = new Item();
                    item.setName(ET2.getText().toString());
                    item.setQuantity(Float.parseFloat(ET3.getText().toString()));
                    item.setPrice(Float.parseFloat(ET4.getText().toString()));
                    items.add(item);
                    IA.notifyDataSetChanged();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        ET2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                submit_button.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ET3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                submit_button.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ET4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                submit_button.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        submit_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {
                total = 0;
                profit = Float.parseFloat(Profit.getText().toString());
                items = IA.getItems();
                for(int i = 0; i<items.size(); i++)
                {
                    total += items.get(i).getPrice()*items.get(i).getQuantity();
                }
                total += profit*(total/100);
                Total.setText(String.format("%.2f", total));
                submit_button.setVisibility(View.INVISIBLE);
                LL3.setVisibility(View.VISIBLE);
            }
        });
    }
}
