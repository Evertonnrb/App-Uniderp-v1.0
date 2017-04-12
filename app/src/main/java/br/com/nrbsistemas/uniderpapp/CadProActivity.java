package br.com.nrbsistemas.uniderpapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.nrbsistemas.uniderpapp.model.Professor;

public class CadProActivity extends AppCompatActivity {

    private EditText edtNomePro,edtDisciplinaPro,edtLagradouroPro,edtNumRua,
            edtCpfpro,edtTelPro;
    private Button btnSalvarCadPro,btnEstadoPro,btnCidadePro;

    Professor professor = new Professor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_pro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        edtNomePro = (EditText)findViewById(R.id.edt_nome_professor);
        edtDisciplinaPro = (EditText)findViewById(R.id.edt_nome_dicplina_professor);
        edtLagradouroPro = (EditText)findViewById(R.id.edt_lagradouro_prof);
        edtNumRua = (EditText)findViewById(R.id.edt_num_rua_professor);
        edtCpfpro = (EditText)findViewById(R.id.edt_cpf_pro);
        edtTelPro = (EditText)findViewById(R.id.edt_telefone_pro);

        btnSalvarCadPro = (Button)findViewById(R.id.btn_salvar_cad_pro);
        btnCidadePro = (Button)findViewById(R.id.btn_salvar_cidade);
        btnEstadoPro = (Button)findViewById(R.id.btn_salvar_estado);

        btnEstadoPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCidadePro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvarCadPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Daosalvar
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
