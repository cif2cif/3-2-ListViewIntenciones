package es.upm.dit.adsw;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Ejemplo adaptador personalizado
 *
 * @author adsw
 */
public class MiAdaptador extends BaseAdapter {
    private List<Pais> paises;
    private LayoutInflater inflater;
    private static final String TAG = MiAdaptador.class.getName();


    public MiAdaptador(Context context, List<Pais> paises) {
        this.paises = paises;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Pais getItem(int position) {
        return paises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void shuffle() {
        Log.d(TAG, "Barajdo");
        Collections.shuffle(paises);
    }
    /**
     * Cache del view item
     */
    static class ViewHolder {
        private TextView nombre;
        private ImageView bandera;
        private  TextView superficie;

        public ViewHolder(View v) {
            this.nombre = (TextView) v.findViewById(R.id.nombre);
            this.bandera = (ImageView) v.findViewById(R.id.bandera);
            this.superficie = (TextView) v.findViewById(R.id.superficie);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView; // creamos una copia
        Pais pais = getItem(position);

        ViewHolder holder;
        if (view == null) {
            // No hay una vista en esta posición, la creamos
            view = inflater.inflate(R.layout.fila_layout, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            // Reciclamos una vista
            holder = (ViewHolder) view.getTag();
        }
        holder.nombre.setText(pais.getNombre());
        holder.bandera.setImageResource(pais.getBandera());
        holder.superficie.setText("Superficie: " + String.format("%,d", pais.getSuperficie()));
        return view;
    }

}
