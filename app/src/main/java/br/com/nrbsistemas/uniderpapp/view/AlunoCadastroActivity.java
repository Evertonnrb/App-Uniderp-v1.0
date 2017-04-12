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

public class AlunoCadastroActivity extends AppCompatActivity {

    //private Spinner spnCursosAlunos;
    private EditText edtCadAlunoNome, edtCadAlunoRa, edtCadAlunoTurma;
    private Button btnCadAlunoSalvar, btnCadAlunoAlterar;
    private Button btnCadCursoAluno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_cad_sup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCadAlunoSalvar = (Button) findViewById(R.id.btn_cadastrar_aluno_salvar);
        btnCadAlunoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO DaoSalvar
                Snackbar.make(v, "Implementar save", Snackbar.LENGTH_SHORT).show();

            }
        });
        btnCadAlunoAlterar = (Button) findViewById(R.id.btn_cadastrar_aluno_alterar);
        btnCadAlunoAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO DaoAlterar
                Snackbar.make(v, "Implementar atualização", Snackbar.LENGTH_SHORT).show();
            }
        });

        /**
         * Carregando adpter dos cursos
         */
        //Substituindo spinnner por button com Alert+spinner
        //ArrayAdapter<CharSequence> cursos = ArrayAdapter.createFromResource(
        //    this, R.array.cursos, android.R.layout.simple_spinner_dropdown_item
        //);
        //spnCursosAlunos.setAdapter(cursos);
        // spnCursosAlunos = (Spinner)findViewById(R.id.spn_cadastro_curso_aluno);

        /**
         * Implenmanetando alert + spnner
         */
        btnCadCursoAluno = (Button) findViewById(R.id.btn_curso_cad_aluno);
        btnCadCursoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                _alertaCad();

            }
        });

        /**
         * Adicionando o botão voltar
         */
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //TODO implematar cadastro de novo aluno
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btn_flutuante);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //       .setAction("Action", null).show();
                Snackbar.make(view, "Implementar adicinar novo", Snackbar.LENGTH_SHORT).show();

            }
        });


    }

    /**
     * @param menu
     * @return instacia o menu voltar que está no diretorio menu
     * com suas opções até agora apenas com opção sair
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * @param item
     * @return retoran os id dos objetos, possibilitando a manipulação
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Botao voltar
        if (id == android.R.id.home) {
            finish();
        }
        //Ao selecionar a opção mostra uma caixa de dialogo para
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

    public void _alertaCad() {
        AlertDialog.Builder msg = new AlertDialog.Builder(AlunoCadastroActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.spn_cad_curso, null);
        msg.setTitle("Dialogo com spinner");
        final Spinner spn = (Spinner) mView.findViewById(R.id.spn_cadastrar_curso);
        ArrayAdapter<String> apadpter = new ArrayAdapter<String>(AlunoCadastroActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.lista_de_cursos));
        apadpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(apadpter);
        msg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (spn.getSelectedItem().toString().equalsIgnoreCase("Selecione um curso")) {
                    Toast.makeText(getApplicationContext(), "Selecione um curso", Toast.LENGTH_SHORT).show();
                } else {
                    btnCadCursoAluno.setText(spn.getSelectedItem().toString());
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
