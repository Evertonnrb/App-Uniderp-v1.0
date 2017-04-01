package br.com.nrbsistemas.uniderpapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class AlunosActivity extends AppCompatActivity {

    private ListView listaAlunos;
    //TODO implementar a busca do banco
    ArrayAdapter<String> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);

        listaAlunos = (ListView)findViewById(R.id.list_lista_alunos);

        //populando a lista temporariamente
        ArrayList<String> al = new ArrayList<>();
        al.addAll(Arrays.asList(getResources().getStringArray(R.array.ex_aluno)));
        alunos = new ArrayAdapter<String>(AlunosActivity.this, android.R.layout.simple_list_item_1,al);
        listaAlunos.setAdapter(alunos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.menu_procurar);

        android.widget.SearchView searchView = (android.widget.SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                alunos.getFilter().filter(newText);

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}
