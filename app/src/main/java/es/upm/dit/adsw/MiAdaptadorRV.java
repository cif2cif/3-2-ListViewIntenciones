package es.upm.dit.adsw;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Ejemplo adaptador personalizado
 *
 * @author adsw
 */
public class MiAdaptadorRV extends RecyclerView.Adapter<MiAdaptadorRV.PaisesViewHolder> {
    private List<Pais> paises;
    private LayoutInflater inflater;
    private static final String TAG = MiAdaptadorRV.class.getName();
    private Context context;


    public MiAdaptadorRV(List<Pais> paises) {
        this.paises = paises;
    }

    @Override
    public PaisesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_layout, parent, false);
        PaisesViewHolder pvh = new PaisesViewHolder(itemView);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PaisesViewHolder holder, int position) {
        Pais item = paises.get(position);
        holder.bindPais(item);
    }

    @Override
    public int getItemCount() {
        return paises.size();
    }

    public void shuffle() {
        Log.d(TAG, Arrays.asList(paises).toString());
        Collections.shuffle(paises);
        Log.d(TAG, "Barajado " + Arrays.asList(paises).toString());

    }


    /**
     * Cache del view item
     */
    public class PaisesViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private ImageView bandera;
        private TextView superficie;

        public PaisesViewHolder(final View itemView) {
            super(itemView);
            this.nombre = (TextView) itemView.findViewById(R.id.nombre);
            this.bandera = (ImageView) itemView.findViewById(R.id.bandera);
            this.superficie = (TextView) itemView.findViewById(R.id.superficie);

            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicion = getAdapterPosition();
                    Log.d(TAG, "onClick " + paises.get(posicion));
                    Toast.makeText(v.getContext(), "" + paises.get(posicion), Toast.LENGTH_SHORT).show();
                }
            });
        }
        public void bindPais(Pais p) {
            this.nombre.setText(p.getNombre());
            this.bandera.setImageResource(p.getBandera());
            this.superficie.setText("Superficie: " + String.format("%,d", p.getSuperficie()));
        }
    }
}
