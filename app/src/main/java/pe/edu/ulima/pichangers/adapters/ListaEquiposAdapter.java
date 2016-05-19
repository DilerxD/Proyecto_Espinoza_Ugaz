package pe.edu.ulima.pichangers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipo;
import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.views.ListaEquiposItem;

public class ListaEquiposAdapter extends BaseAdapter {

    private List<Equipo> mEquipos;
    private LayoutInflater mInflater;
    Context mContext;

    public ListaEquiposAdapter(Context context, List<Equipo> equipos){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mEquipos = equipos;
    }

    @Override
    public int getCount() {
        return mEquipos.size();
    }

    @Override
    public Object getItem(int position) {
        return mEquipos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mEquipos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_gridview, null);
            viewHolder = new ViewHolder();
            viewHolder.tviNombreEquipo = (TextView)view.findViewById(R.id.tviNombreEquipo);
            viewHolder.imgEquipo = (ListaEquiposItem) view.findViewById(R.id.imgEquipo);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Equipo equipo = mEquipos.get(position);

        viewHolder.tviNombreEquipo.setText(equipo.getNombre());
        Picasso.with(mContext)
                .load(equipo.getUrlFoto())
                .fit()
                .centerCrop()
                .into(viewHolder.imgEquipo);

        return view;
    }

    class ViewHolder{
        ListaEquiposItem imgEquipo;
        TextView tviNombreEquipo;
    }

}
