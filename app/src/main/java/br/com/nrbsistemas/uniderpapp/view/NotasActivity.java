package br.com.nrbsistemas.uniderpapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.nrbsistemas.uniderpapp.R;

/**
 * Classe para mostrar as notas e situações dos alunos
 */
public class NotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
    }
}
