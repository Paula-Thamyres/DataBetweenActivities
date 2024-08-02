package com.paula.databetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editIdade;
    private EditText editAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editNome = findViewById(R.id.edit_nome);
        editIdade = findViewById(R.id.edit_idade);
        editAltura = findViewById(R.id.edit_altura);

        findViewById(R.id.btn_enviar_dados).setOnClickListener(v -> {

            String nome = editNome.getText().toString();
            int idade = Integer.parseInt(editIdade.getText().toString());
            double altura = Double.parseDouble(editAltura.getText().toString());

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setIdade(idade);
            pessoa.setAltura(altura);

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("pessoa", pessoa);
            startActivity(intent);


        });
    }
}