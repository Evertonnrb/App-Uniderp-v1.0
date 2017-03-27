package br.com.nrbsistemas.uniderpapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class LoginActivity extends AppCompatActivity {

    private ToggleButton mToggle;
    private EditText edtLogin,edtSenha;
    private Button btnLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mToggle = (ToggleButton)findViewById(R.id.toggle_id);
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


}
