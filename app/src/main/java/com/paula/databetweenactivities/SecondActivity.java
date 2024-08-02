package com.paula.databetweenactivities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private TextView textNome;
    private TextView textIdade;
    private TextView textAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textNome = findViewById(R.id.text_nome);
        textIdade = findViewById(R.id.text_idade);
        textAltura = findViewById(R.id.text_altura);

        String nome = (String) getIntent().getSerializableExtra("meu_nome");
        int idade = (Integer) getIntent().getSerializableExtra("minha_idade");
        double altura = (Double) getIntent().getSerializableExtra("minha_altura");

        textNome.setText(nome);
        textIdade.setText(String.valueOf(idade));
        textAltura.setText(String.valueOf(altura));

    }
}