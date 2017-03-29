package br.com.nrbsistemas.uniderpapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.nrbsistemas.uniderpapp.R;
import br.com.nrbsistemas.uniderpapp.model.Admin;

/**
 * Created by Everton on 27/03/2017.
 */

public class AdmAdapter extends BaseAdapter {
    private final List<Admin> listaAdm;
    private final Context context;

    public AdmAdapter(List<Admin> listaAdm, Context context) {
        this.listaAdm = listaAdm;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaAdm.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAdm.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //inflando a view
        View view = LayoutInflater.from(context).inflate(R.layout.opcaoes_adm,parent,false);
        //configurando a view
        TextView txt_opc = (TextView) view.findViewById(R.id.txt_opcoes_adm);
        ImageView img_opc = (ImageView) view.findViewById(R.id.img_opc_adm);
        Admin admin = listaAdm.get(position);
        img_opc.setImageResource(admin.getImg());
        txt_opc.setText(admin.getOpcao());

        return view;
    }
}
