package br.com.nrbsistemas.uniderpapp.model;

import java.util.ArrayList;
import java.util.List;

import br.com.nrbsistemas.uniderpapp.R;

/**
 * Created by Everton on 27/03/2017.
 */

public class Admin {
    private int img;
    private String opcao;

    public Admin(int img, String opcao) {
        this.img = img;
        this.opcao = opcao;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    /**
     *  opcoesAdm carrega na lista asopções
     *  com icones estáticos
     *
     * @return
     */
    public static List<Admin> opcoesAdm(){
        List<Admin> opc = new ArrayList<>();
        opc.add(new Admin(R.drawable.grade,"\tCadastros e alterações"));
        opc.add(new Admin(R.drawable.ic_person_add_black_24dp,"\tCadastrar professores"));
        opc.add(new Admin(R.drawable.estudande,"\tPesquisar alunos"));
       // opc.add(new Admin(R.drawable.settings,"\tConfigurações"));
        opc.add(new Admin(R.drawable.del,"\tExclusões e trancamentos "));

        return opc;
    }
}
