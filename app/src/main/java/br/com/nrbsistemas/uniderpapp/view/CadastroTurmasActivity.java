package br.com.nrbsistemas.uniderpapp.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.nrbsistemas.uniderpapp.R;

public class CadastroTurmasActivity extends AppCompatActivity {

    private Spinner spnCursos, spnTurno;
    private EditText edtRa,edtNome,edtProfessor;
    private Button btnCadastrar, btnAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_turmas);
        spnCursos = (Spinner) findViewById(R.id.spn_cursos);
        spnTurno = (Spinner)findViewById(R.id.spn_turno);
        edtProfessor = (EditText)findViewById(R.id.edt_ra_cad);
        edtRa = (EditText)findViewById(R.id.edt_ra_cad);
        edtNome = (EditText)findViewById(R.id.edt_nome_cad);
        btnCadastrar = (Button)findViewById(R.id.btn_cadastrar);

        //Carregando os cursos
        ArrayAdapter<CharSequence> cursos = ArrayAdapter.createFromResource(
                this, R.array.cursos, android.R.layout.simple_spinner_dropdown_item
        );
        spnCursos.setAdapter(cursos);

        //Carregando Turnos
        ArrayAdapter<CharSequence> periodo = ArrayAdapter.createFromResource(
                this, R.array.turnos, android.R.layout.simple_spinner_dropdown_item
        );
        spnTurno.setAdapter(periodo);

        //Botao voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    //inflando menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cad,menu);
        return true;
    }
    //ouvindo a seleção de menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_cad_sair){
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

