package br.com.nrbsistemas.uniderpapp.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.nrbsistemas.uniderpapp.R;
import br.com.nrbsistemas.uniderpapp.model.Aluno;

/**
 * Classe para eftuar calculos das notas dos alunos
 */
public class CalcularNotasActivity extends AppCompatActivity {

    private TextView txtNomeAluno, txtSituacaoAluno, txtMediaAluno;
    private EditText edtNotaExame;
    private Button btnCalcular;

    Aluno aluno = new Aluno();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        txtNomeAluno = (TextView) findViewById(R.id.txt_calc_nome_aluno);
        txtNomeAluno.setText(aluno.getNome());
        txtMediaAluno = (TextView) findViewById(R.id.txt_media_aluno_calc);
        //txtMediaAluno.setText(aluno.getMedia());
        txtSituacaoAluno = (TextView) findViewById(R.id.txt_cal_situacao);
        txtSituacaoAluno.setText(aluno.imprimeSituacao());
        edtNotaExame = (EditText) findViewById(R.id.edt_cal_nota_exame);
        btnCalcular = (Button) findViewById(R.id.btn_cal_calcular_exame);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    public void _calculo() {
        aluno.calculaMedia(aluno.getN1(), aluno.getN2());
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
        //botao home
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


}
