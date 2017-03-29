package br.com.nrbsistemas.uniderpapp.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import br.com.nrbsistemas.uniderpapp.R;

public class LoginActivity extends AppCompatActivity {

    private ToggleButton mToggle;
    private EditText edtLogin,edtSenha;
    private Button btnLogar;
    private ImageView logoLogin;
    private int atualiza = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logoLogin = (ImageView)findViewById(R.id.img_logo_login);
        logoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _logimAdm();
                if (atualiza == 10){
                    _autenticacao();
                    Toast.makeText(getApplicationContext(),"Bem vindo ADM",Toast.LENGTH_SHORT).show();
                    //_moduloAdm();
                   // _zerar();
                    //finish();
                }
                //Toast.makeText(getApplicationContext()," =: "+atualiza,Toast.LENGTH_SHORT).show();
            }
        });

        mToggle = ( ToggleButton)findViewById(R.id.toggle_id);
        mToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mToggle.getTextOn()){
                    edtLogin.setHint("Digite seu ID");
                }else if(v == mToggle.getTextOn()){
                    edtLogin.setHint("Digite seu RA");
                }
            }
        });
        edtLogin = (EditText)findViewById(R.id.edt_login);
        edtSenha = (EditText)findViewById(R.id.edt_senha);
        btnLogar = (Button)findViewById(R.id.btn_logar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                _logar();
            }
        });
    }
    public void _logar(){
        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();
        if(login.isEmpty()&&senha.isEmpty()){
            edtLogin.setError("Prencha o campo");
            edtSenha.setError("Prencha o campo");
        }else if(senha.isEmpty()){
            edtSenha.setError("Informe a senha");
            _limpar();
        }else if("adm".equals(login)&&"123".equals(senha)){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }else{
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
    public void _limpar(){
        edtLogin.setText("");
        edtSenha.setText("");
    }

    private void _autenticacao(){
        LayoutInflater li= getLayoutInflater();
        final View view = li.inflate(R.layout.autentica_adm,null);
        //String edt = view.findViewById(R.id.etd_autentica);
        EditText edt = (EditText)view.findViewById(R.id.etd_autentica);
        final String senha = edt.getText().toString();

        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Informe as senha")
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String psswd = "123";
                    //TODO corrigir bug de authencicacao
                    startActivity(new Intent(LoginActivity.this,AdmActivity.class));
                    /*
                    if(psswd.equals(senha)){
                        startActivity(new Intent(LoginActivity.this,AdmActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(),"Senha incorreta",Toast.LENGTH_SHORT).show();
                        _zerar();
                        LoginActivity loginActivity = new LoginActivity();
                    }*/
                }
            })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                })
                .setView(view)
                .create()
                .show();
    }
    private void _logimAdm(){
        atualiza += 1;
    }
    private void _zerar(){
        atualiza = 0;
    }
    public void _moduloAdm() {
        startActivity(new Intent(this, AdmActivity.class));
    }
}
