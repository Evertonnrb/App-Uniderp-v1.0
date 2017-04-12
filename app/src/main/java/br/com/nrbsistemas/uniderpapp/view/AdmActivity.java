package br.com.nrbsistemas.uniderpapp.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Classe responsável pelo modulo ADM
 */
public class AdmActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<Admin> opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm);

        ListView listView = (ListView) findViewById(R.id.lista);
        /**
         * opcoesAdm();
         * metodo da classe Admin que possui a lista de opçoes
         * a ser rendererizada
         */
        opc = Admin.opcoesAdm();
        AdmAdapter adapter = new AdmAdapter(opc, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


        /**
         * Instanciando o botao voltar
         * key back press nativo do android
         */
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    /**
     * @param menu
     * @return ira retornar objto do tipo menu
     * inflando como padrao ao topo e a esquerda
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_adm, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * @param item
     * @return carrrega o id do objto
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Pegando o id do botao
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        if (item.getItemId() == R.id.menu_adm_sair) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Admin admin = opc.get(position);
        switch (position) {
            case 0:
                _opcCad();
                //startActivity(new Intent(this, ProfessoresCadastroActivity.class));
                //TODO DAO cadastro turmas
                break;
            case 1:
                //Toast.makeText(getApplicationContext(), "Implementar o cadastro de professor", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, CadProActivity.class));
                //TODO DAO cadastro de porfessor
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "Cadastrar alunos", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, AlunosActivity.class));
                //TODO DAO cadastro de alunos

                break;
            case 3:
                Toast.makeText(getApplicationContext(), "Exclusões/Trancamentos", Toast.LENGTH_SHORT).show();
                //TODO exclusoes e trancamentos
                break;
        }
        //Toast.makeText(this,"Cliclou "+opc.get(position),Toast.LENGTH_SHORT).show();

    }

    public void _opcCad() {
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Selecione")
                .setMessage("Selecine a opção de cadastro desejada")
                .setPositiveButton("Aluno", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(AdmActivity.this, AlunoCadastroActivity.class));
                    }
                })
                .setNegativeButton("Professor", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(AdmActivity.this, ProfessoresCadastroActivity.class));
                    }
                })
                .show();
    }
}
