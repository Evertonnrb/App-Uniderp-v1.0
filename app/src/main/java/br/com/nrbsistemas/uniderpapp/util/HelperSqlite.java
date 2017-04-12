package br.com.nrbsistemas.uniderpapp.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by Everton on 12/04/2017.
 */

public class HelperSqlite extends SQLiteOpenHelper {

    /**
     * Versao de testes
     */
    public static final String DB_APP = "db_app";
    public static final int VERSAO = 1;
    public static final String TAG = "DB";


    public HelperSqlite(Context context) {
        super(context, DB_APP,null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder tabela = new StringBuilder();
        tabela.append("CREATE TABLE aluno");
        tabela.append("codigo INTEGER PRIMARY KEY AUTOINCREMENT");
        tabela.append("nome TEXT NOT NULL");
        tabela.append("telefone TEXT ");
        tabela.append("dataNascimento DATE ");
        tabela.append("dataNascimento DATE ");
        tabela.append("ra INTEGER ");
        tabela.append("n1 DOUBLE ");
        tabela.append("n2 DOUBLE ");


        try {
            db.execSQL(tabela.toString());
            Log.i(TAG,"Tabela aluno criada com sucesso");
        }catch (Exception e){
            Log.i(TAG,"Erro ao criar tabela aluno");
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            db.execSQL("DROP TABLE aluno");
        }catch (Exception e){
            e.printStackTrace();
            Log.i(TAG,"Erro ao dropar tabela aluno");
        }finally {
            db.close();
        }
    }
}
