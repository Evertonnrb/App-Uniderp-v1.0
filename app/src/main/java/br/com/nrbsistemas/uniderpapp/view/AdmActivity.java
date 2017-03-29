package br.com.nrbsistemas.uniderpapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        //Pegando o id do botao
        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Admin admin = opc.get(position);
        Toast.makeText(this,"Cliclou "+opc.get(position),Toast.LENGTH_SHORT).show();

    }
}
