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

        Pessoa pessoa = (Pessoa) getIntent().getSerializableExtra("pessoa");

        textNome.setText(pessoa.getNome());
        textIdade.setText(String.valueOf(pessoa.getIdade()));
        textAltura.setText(String.valueOf(pessoa.getAltura()));

    }
}