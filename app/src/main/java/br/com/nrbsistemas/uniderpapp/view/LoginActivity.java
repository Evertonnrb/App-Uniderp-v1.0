package br.com.nrbsistemas.uniderpapp.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import br.com.nrbsistemas.uniderpapp.R;

/**
 * Classe da tela de login
 * Essa classe e responsavél pela validaçao de usuario
 * e do tipo que ele é
 * Alem da opção no ImageView de acessar o modulo Admin
 * Aqui que mora a gambiarra
 */
public class LoginActivity extends AppCompatActivity {

    private ToggleButton mToggle;
    private EditText edtLogin, edtSenha;
    private Button btnLogar;
    private ImageView logoLogin;
    private int atualiza = 0;
    private static final int TEMPORIZADOR = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**
         * Ao ser clicado ira apresentar uma layout de autenticação
         * para valida do modulo ADM
         */
        logoLogin = (ImageView) findViewById(R.id.img_logo_login);
        logoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               _temporizador();
            }
        });

        /**
         * mToggle ficara responsavel pela validação do tipo do ususario
         */
        mToggle = (ToggleButton) findViewById(R.id.toggle_id);
        mToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mToggle.isChecked()) {
                    edtLogin.setHint("Sou aluno RA");
                } else {
                    edtLogin.setHint("Sou professor ID");
                }
            }
        });
        edtLogin = (EditText) findViewById(R.id.edt_login);
        edtSenha = (EditText) findViewById(R.id.edt_senha);
        btnLogar = (Button) findViewById(R.id.btn_logar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                _logar();
            }
        });
    }

    /**
     * Gambiarra da nasa
     */
    public void _temporizador(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                _logimAdm();
                if (atualiza == 10) {
                    _moduloAdm();
                }
            }
        },TEMPORIZADOR);
    }

    /**
     * Valida o login do usuario
     */
    public void _logar() {

        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();
        if (login.isEmpty() && senha.isEmpty()) {
            edtLogin.setError("Prencha o campo");
            edtSenha.setError("Prencha o campo");
        } else if (senha.isEmpty()) {
            edtSenha.setError("Informe a senha");
            _limpar();
        } else if ("adm".equals(login) && "123".equals(senha)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Atenção")
                    .setMessage("Usuario e ou senha inválidos")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    })
                    .create()
                    .show();
            _limpar();
        }
    }

    /**
     * limpa os campos
     */
    //TODO mudar implemantação para o cliclo de vida
    public void _limpar() {
        edtLogin.setText("");
        edtSenha.setText("");
    }

    /**
     * Instancia o layout responsavel pela autnticação
     */
    private void _autenticacao() {
        LayoutInflater li = getLayoutInflater();
        final View view = li.inflate(R.layout.autentica_adm, null);
    }

    /**
     * Contator de clicks libera o dialogo ao ser ==10
     */
    private void _logimAdm() {
        atualiza += 1;
    }

    /**
     * Infla e autentica o modulo ADM
     */
    public void _moduloAdm() {
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.authentica_login, null);
        final EditText edtAutentica = (EditText) view.findViewById(R.id.edt_authentica);
        Button btnAutentica = (Button) view.findViewById(R.id.btn_authentica);
        AlertDialog.Builder v = new AlertDialog.Builder(this);
        v.setTitle("Autenticação necessária");
        btnAutentica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtAutentica.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Falha na autenticação", Toast.LENGTH_SHORT).show();
                    finish();
                } else if (edtAutentica.getText().toString().equals("adm")) {
                    startActivity(new Intent(LoginActivity.this, AdmActivity.class));
                    finish();

                } else {
                    edtAutentica.setError("Adm não autorizado");
                    edtAutentica.setText("");
                }
            }
        });
        v.setView(view);
        v.create();
        v.show();
    }


}
