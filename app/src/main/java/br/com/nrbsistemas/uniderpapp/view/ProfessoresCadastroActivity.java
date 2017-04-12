package br.com.nrbsistemas.uniderpapp.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.nrbsistemas.uniderpapp.R;
import br.com.nrbsistemas.uniderpapp.model.Disciplina;
import br.com.nrbsistemas.uniderpapp.model.Periodo;
import br.com.nrbsistemas.uniderpapp.model.Professor;

/**
 * Classe responvavél pelo cadastro
 * de professores as respectivas disciplinas
 */

public class ProfessoresCadastroActivity extends AppCompatActivity {

    private Spinner spnCursos, spnTurno;
    private EditText edtRa,edtNome,edtProfessor;
    private Button btnCadastrar, btnAlterar;

    //Periodo enum
    Periodo m = Periodo.MATUTINO;
    Periodo v = Periodo.VESPERTINO;
    Periodo n = Periodo.NOTURNO;

    Professor professor = new Professor();
    Disciplina disciplina = new Disciplina();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prof);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        spnCursos = (Spinner) findViewById(R.id.spn_cursos);
        spnTurno = (Spinner)findViewById(R.id.spn_turno);
        //edtProfessor = (EditText)findViewById(R.id.edt_ra_cad);
        //edtRa = (EditText)findViewById(R.id.edt_ra_cad);
        //edtNome = (EditText)findViewById(R.id.edt_nome_cad);
        edtProfessor = (EditText)findViewById(R.id.edt_professor_cad);
        btnCadastrar = (Button)findViewById(R.id.btn_cadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor.setNome(edtProfessor.getText().toString());
                disciplina.setNome(spnCursos.getSelectedItem().toString());

                if(spnTurno.equals(Periodo.MATUTINO)){
                    disciplina.setPeriodo(Periodo.MATUTINO);
                }else if(spnTurno.equals(Periodo.VESPERTINO)){
                    disciplina.setPeriodo(Periodo.VESPERTINO);
                }else{
                    disciplina.setPeriodo(Periodo.NOTURNO);
                }
            }
        });

        /**
         * Carregando adpter dos cursos
         */
        ArrayAdapter<CharSequence> cursos = ArrayAdapter.createFromResource(
                this, R.array.cursos, android.R.layout.simple_spinner_dropdown_item
        );
        spnCursos.setAdapter(cursos);

        /**
         * Carregando adapter do período dos cursos
         */
        ArrayAdapter<CharSequence> periodo = ArrayAdapter.createFromResource(
                this, R.array.turnos, android.R.layout.simple_spinner_dropdown_item
        );
        spnTurno.setAdapter(periodo);

    }

    /**
     * Inflando o menu
     * @param menu
     * @return carraga o menu_cad do diretorio menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cad,menu);
        return true;
    }

    /**
     *
     * @param item
     * @return ouvindo o listener do menu selecionado
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        if (id == R.id.menu_cad_sair){
            //Dialogo confirmacao saida
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
        }else if(id == R.id.menu_cad_logout){
            Toast.makeText(getApplicationContext(),"Implementar o logoff",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}

