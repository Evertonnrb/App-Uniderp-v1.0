package br.com.nrbsistemas.uniderpapp.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.nrbsistemas.uniderpapp.R;

/**
 * Classe principal que instanciada ao fazer o login
 * Essa classe instancia o menu drawer
 * Nessa classe serao feita 80% das atividades do alunos e professores
 * Usar a orientação a objetos para validação quando necessario ao efetuar login
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**
         *
         * fab == implementar troca de msgm email entre alunos ou professores
         * botão flutuante icone da caixa de mgn
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /**
         * Instancia o menu drawer
         */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * Instancia o menu (sobrescreve o botao voltar)
     * gravity = em cima e a esquerda
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     *
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
     *
     * @param item
     * @return retoran os id dos objetos, possibilitando a manipulação
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

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

    /**
     *
     * @param item
     * @return utizando o item das opçoes selecionadas do menu drawer
     */
    //@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notas) {
            Toast.makeText(getApplicationContext(),": "+item.getClass().getName(),Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_grade) {
            Toast.makeText(getApplicationContext(),": "+item.getClass().getName(),Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_calendario) {
            Toast.makeText(getApplicationContext(),": "+item.getClass().getName(),Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, CalendarioActivity.class));
        } else if (id == R.id.nav_calc) {
            Toast.makeText(getApplicationContext(),": "+item.getClass().getName(),Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Calc2Activity.class));
        } /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/
        /**
         * Carraga uma instancia do drawer layout
         */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
