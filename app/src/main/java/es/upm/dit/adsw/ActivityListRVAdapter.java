package es.upm.dit.adsw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityListRVAdapter extends AppCompatActivity {
    private static final String TAG = ActivityListRVAdapter.class.getName();
    private List<Pais> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        listItems = new ArrayList<Pais>();
        rellenaLista();
        ListView miListView = (ListView) findViewById(R.id.listView);
        final MiAdaptador miAdaptador = new MiAdaptador(this, listItems);
        miListView.setAdapter(miAdaptador);
        miListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pais pais = miAdaptador.getItem(position);
                Log.d(TAG, pais.toString());
                Toast.makeText(getBaseContext(), pais.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Shuffle");
                miAdaptador.shuffle();
                miAdaptador.notifyDataSetChanged();
            }
        });
    }


    private void rellenaLista() {
        listItems.add(new Pais("España", R.drawable.espanna, 504645, 34));
        listItems.add(new Pais("Portugal", R.drawable.portugal, 92391, 351));
        listItems.add(new Pais("Francia", R.drawable.francia, 675417, 33));
        listItems.add(new Pais("Alemania", R.drawable.alemania, 357168, 49));
        listItems.add(new Pais("Italia", R.drawable.italia, 301338, 39));
        listItems.add(new Pais("Grecia", R.drawable.grecia, 131990, 30));
        listItems.add(new Pais("Reino Unido", R.drawable.reinounido, 243610, 44));
    }
}
