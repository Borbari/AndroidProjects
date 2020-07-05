package com.example.frasesdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gerarNovaFrase(View view) {
        String []frases = new String[]{
                "Saber encontrar a alegria na alegria dos outros, é o segredo da felicidade.",
                "A alegria de fazer o bem é a única felicidade verdadeira.",
                "Ser feliz sem motivo é a mais autêntica forma de felicidade.",
                "A alegria não está nas coisas, está em nós.",
                "Não existe um caminho para a felicidade. A felicidade é o caminho.",
                "A alegria evita mil males e prolonga a vida."};

            int x = new Random().nextInt(6);
            TextView texto = findViewById(R.id.textResultado);
            texto.setText(frases[x]);
        }
    }

