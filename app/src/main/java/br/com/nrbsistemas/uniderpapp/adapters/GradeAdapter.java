package br.com.nrbsistemas.uniderpapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.nrbsistemas.uniderpapp.R;

/**
 * Created by Everton on 12/04/2017.
 */

public class GradeAdapter extends BaseAdapter{

    private List<String> diaSeman;
    private Context context;

    @Override
    public int getCount() {
        return diaSeman.size();
    }

    @Override
    public Object getItem(int position) {
        return diaSeman.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.grade_seman,parent,false);
        TextView view1 = (TextView) view.findViewById(R.id.txt_dia);
        TextView view2 = (TextView) view.findViewById(R.id.txt_aula);
        //TODO terminar a grade

        return null;
    }
}
