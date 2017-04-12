package br.com.nrbsistemas.uniderpapp.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.nrbsistemas.uniderpapp.R;
import br.com.nrbsistemas.uniderpapp.model.Professor;

public class CadProActivity extends AppCompatActivity {

    private EditText edtNomePro, edtDisciplinaPro, edtLagradouroPro, edtNumRua,
            edtCpfpro, edtTelPro;
    private Button btnSalvarCadPro, btnEstadoPro, btnCidadePro;

    Professor professor = new Professor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_pro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
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

        edtNomePro = (EditText) findViewById(R.id.edt_nome_professor);
        edtDisciplinaPro = (EditText) findViewById(R.id.edt_nome_dicplina_professor);
        edtLagradouroPro = (EditText) findViewById(R.id.edt_lagradouro_prof);
        edtNumRua = (EditText) findViewById(R.id.edt_num_rua_professor);
        edtCpfpro = (EditText) findViewById(R.id.edt_cpf_pro);
        edtTelPro = (EditText) findViewById(R.id.edt_telefone_pro);

        btnSalvarCadPro = (Button) findViewById(R.id.btn_salvar_cad_pro);
        btnCidadePro = (Button) findViewById(R.id.btn_salvar_cidade);
        btnEstadoPro = (Button) findViewById(R.id.btn_salvar_estado);

        btnEstadoPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _listarEstados();
            }
        });

        btnCidadePro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _listarCidades();
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
        if (id == android.R.id.home) {
            finish();
        }
        //confirmar a saida da aplicação
        if (id == R.id.menu_sair) {
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Atenção")
                    .setMessage("Deseja fechar a aplicação?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    })
                    .create()
                    .show();

        }

        return super.onOptionsItemSelected(item);
    }

    private void _listarEstados() {
        AlertDialog.Builder msg = new AlertDialog.Builder(CadProActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.lista_estados, null);
        msg.setTitle("Selecione um estado");
        final Spinner spn = (Spinner) mView.findViewById(R.id.spn_lista_estados);
        ArrayAdapter<String> apadpter = new ArrayAdapter<String>(CadProActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.lista_estados));
        apadpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(apadpter);
        msg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (spn.getSelectedItem().toString().equalsIgnoreCase("Selecione um estado")) {
                    Toast.makeText(getApplicationContext(), "Selecione um estado", Toast.LENGTH_SHORT).show();
                } else {
                    btnEstadoPro.setText(spn.getSelectedItem().toString());
                }
            }
        });
        msg.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        msg.setView(mView);
        msg.create();
        msg.show();
    }

    private void _listarCidades() {
        AlertDialog.Builder msg = new AlertDialog.Builder(CadProActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.lista_cidades, null);
        msg.setTitle("Selecione uma cidade");
        final Spinner spn = (Spinner) mView.findViewById(R.id.spn_lista_cidades);
        ArrayAdapter<String> apadpter = new ArrayAdapter<String>(CadProActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.lista_cidades));
        apadpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(apadpter);
        msg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (spn.getSelectedItem().toString().equalsIgnoreCase("Selecione uma cidade")) {
                    Toast.makeText(getApplicationContext(), "Selecione um curso", Toast.LENGTH_SHORT).show();
                } else {
                    btnCidadePro.setText(spn.getSelectedItem().toString());
                }
            }
        });
        msg.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        msg.setView(mView);
        msg.create();
        msg.show();
    }


}
