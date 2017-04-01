package br.com.nrbsistemas.uniderpapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.nrbsistemas.uniderpapp.R;
import br.com.nrbsistemas.uniderpapp.adapters.AdmAdapter;
import br.com.nrbsistemas.uniderpapp.model.Admin;

public class AdmActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    List<Admin> opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm);

        ListView listView = (ListView)findViewById(R.id.lista);
        opc = Admin.opcoesAdm();
        AdmAdapter adapter = new AdmAdapter(opc,this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


        //ADD botao voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_adm,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Pegando o id do botao
        if(item.getItemId()==android.R.id.home){
            new LoginActivity();
        }
        if(item.getItemId() == R.id.menu_adm_sair){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Admin admin = opc.get(position);
       switch (position){
           case 0:
               Toast.makeText(getApplicationContext(),"Criar turma",Toast.LENGTH_SHORT).show();
               startActivity(new Intent(this, CadastroTurmasActivity.class));
               break;
           case 1:
               Toast.makeText(getApplicationContext(),"Adicionar aluno",Toast.LENGTH_SHORT).show();
               startActivity(new Intent(this, AlunosActivity.class));

               break;
           case 2:
               Toast.makeText(getApplicationContext(),"Configurações",Toast.LENGTH_SHORT).show();
               break;
           case 3:
               Toast.makeText(getApplicationContext(),"Exclusões/Trancamentos",Toast.LENGTH_SHORT).show();
               break;
       }
        //Toast.makeText(this,"Cliclou "+opc.get(position),Toast.LENGTH_SHORT).show();

    }
}
