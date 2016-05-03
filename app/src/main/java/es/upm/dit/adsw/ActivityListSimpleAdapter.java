package es.upm.dit.adsw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityListSimpleAdapter extends AppCompatActivity {
    private static final String TAG = ActivityListSimpleAdapter.class.getName();
    List<Map<String, Object>> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        listItems = rellenaLista();
        ListView miListView = (ListView) findViewById(R.id.listView);

        String [] from = {"nombre","bandera", "superficie"};
        int [] to = {R.id.nombre, R.id.bandera, R.id.superficie};
        final SimpleAdapter adapter = new SimpleAdapter(this, listItems,
                                                        R.layout.fila_layout, from, to);
        miListView.setAdapter(adapter);
        miListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "Seleccionado " + parent.getAdapter().getItem(position);
                Log.d(TAG, msg);
                Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Borrado");
                if (listItems.size() > 1) {
                    Log.d(TAG, "Borrado primer elemento");
                    listItems.remove(0);
                    adapter.notifyDataSetChanged();
                } else {
                    Log.d(TAG, "No borrado");
                    Toast.makeText(getBaseContext(), "Lista con 1 elemento", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<Map<String, Object>> rellenaLista() {

        List<Pais> paises = new ArrayList<>();
        paises.add(new Pais("España", R.drawable.espanna, 504645, 34));
        paises.add(new Pais("Portugal", R.drawable.portugal, 92391, 351));
        paises.add(new Pais("Francia", R.drawable.francia, 675417, 33));
        paises.add(new Pais("Alemania", R.drawable.alemania, 357168, 49));
        paises.add(new Pais("Italia", R.drawable.italia, 301338, 39));
        paises.add(new Pais("Grecia", R.drawable.grecia, 131990, 30));
        paises.add(new Pais("Reino Unido", R.drawable.reinounido, 243610, 44));

        List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
        for (Pais pais : paises) {
            Map<String, Object> map = new HashMap<>();
            map.put("nombre", pais.getNombre());
            map.put("bandera", pais.getBandera());
            map.put("superficie", pais.getSuperficie());
            lista.add(map);
        }
        return lista;

    }


}
