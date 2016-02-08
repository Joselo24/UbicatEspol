package ben.dm.ubicatefiec;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class BuscarFacultad extends FragmentActivity implements GoogleMap.OnMapClickListener {

    private final LatLng ESPOL = new LatLng(-2.146363, -79.965443);
    private final LatLng FIEC  = new LatLng(-2.144820, -79.967392);
    private final LatLng FIMCP = new LatLng(-2.144250, -79.966269);//Facultad de Ingenieria Mecánica y Ciencias de la Producción
    private final LatLng FICT  = new LatLng(-2.145522, -79.965385);//Facultad de Ingeniería en Ciencias de la Tierra
    private final LatLng FCSH = new LatLng(-2.147697, -79.968625);//Facultad de Ciencias Sociales y Humanísticas
    private final LatLng CELEX = new LatLng(-2.148666, -79.967652);
    private final LatLng FCNM = new LatLng(-2.148589, -79.967203);//FACULTAD DE CIENCIAS NATURALES Y MATEMÁTICAS
    private final LatLng FIMCBOR = new LatLng(-2.147144, -79.963019); //FACULTAD DE INGENIERÍA MARÍTIMA, CIENCIAS BIOLÓGICAS, OCEÁNICAS Y RECURSOS NATURALES
    private final LatLng EDCOM = new LatLng(-2.143585, -79.962236); //ESCUELA DE DISEÑO Y COMUNICACIÓN VISUAL
    private final LatLng BIBLIO = new LatLng(-2.147176, -79.966108);//Biblioteca Central de Ingeniería
    private final LatLng RECTORADO = new LatLng(-2.147652, -79.964449);



    private GoogleMap mapa;
    private Spinner spnInicio, spnFin;
    private Button btnBuscar;
    private ClsAulas oAulas;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_buscar_facultad);
        mapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFacultad)).getMap();
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(ESPOL, 15));
        mapa.setMyLocationEnabled(true);
        mapa.getUiSettings().setZoomControlsEnabled(false);
        mapa.getUiSettings().setCompassEnabled(true);

        //Se crean las facultades
        crearFacultades(FIEC, "FIEC","FACULTAD DE INGENIERÍA EN ELECTRICIDAD Y COMPUTACIÓN");
        crearFacultades(FIMCP, "FIMCP","FACULTAD DE INGENIERÍA EN MECÁNICA Y CIENCIAS DE LA PRODUCCIÓN");
        crearFacultades(FICT, "FICT","FACULTAD DE INGENIERÍA EN CIENCIAS DE LA TIERRA");
        crearFacultades(FCSH, "FCSH","FACULTAD DE CIENCIAS SOCIALES Y HUMANÍSTICAS");
        crearFacultades(CELEX, "CELEX","CELEX");
        crearFacultades(FCNM, "FCNM","FACULTAD DE CIENCIAS NATURALES Y MATEMÁTICAS");
        crearFacultades(FIMCBOR, "FIMCBOR","FACULTAD DE INGENIERÍA MARÍTIMA, CIENCIAS BIOLÓGICAS, OCEÁNICAS Y RECURSOS NATURALES");
        crearFacultades(EDCOM, "EDCOM","ESCUELA DE DISEÑO Y COMUNICACIÓN VISUAL");
        crearFacultades(RECTORADO, "RECTORADO","RECTORADO ESPOL");
        crearFacultades(BIBLIO, "BIBLIOTECA","BIBLIOTECA CENTRAL DE INGENIERÍA");

        // mapa.setOnMapClickListener(this);
      /*  mapa.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                getDataFacultades(marker.getTitle(),marker.getSnippet());

                return false;
            }
        });
        */
        mapa.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                getAlerta(marker.getTitle(), marker.getSnippet());
            }
        });
        spnInicio=(Spinner)findViewById(R.id.spnInicio);
        spnFin=(Spinner)findViewById(R.id.spnFin);
        btnBuscar=(Button)findViewById(R.id.btnBuscarF);
        oAulas= new ClsAulas();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, oAulas.getFacultadesD());
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFin.setAdapter(adaptador);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, oAulas.getFacultadesP());
        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnInicio.setAdapter(adaptador2);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearRecorridoControlador();
            }
        });

    }


    public void crearRecorridoControlador(){
        try {
            LatLng partida = null, destino = null;

            String key = spnInicio.getSelectedItem().toString();
            String key2 =  spnFin.getSelectedItem().toString();
            mapa.clear();
            crearFacultades(FIEC, "FIEC","FACULTAD DE INGENIERÍA EN ELECTRICIDAD Y COMPUTACIÓN");
            crearFacultades(FIMCP, "FIMCP","FACULTAD DE INGENIERÍA EN MECÁNICA Y CIENCIAS DE LA PRODUCCIÓN");
            crearFacultades(FICT, "FICT","FACULTAD DE INGENIERÍA EN CIENCIAS DE LA TIERRA");
            crearFacultades(FCSH, "FCSH","FACULTAD DE CIENCIAS SOCIALES Y HUMANÍSTICAS");
            crearFacultades(CELEX, "CELEX","CELEX");
            crearFacultades(FCNM, "FCNM","FACULTAD DE CIENCIAS NATURALES Y MATEMÁTICAS");
            crearFacultades(FIMCBOR, "FIMCBOR","FACULTAD DE INGENIERÍA MARÍTIMA, CIENCIAS BIOLÓGICAS, OCEÁNICAS Y RECURSOS NATURALES");
            crearFacultades(EDCOM, "EDCOM","ESCUELA DE DISEÑO Y COMUNICACIÓN VISUAL");
            crearFacultades(RECTORADO, "RECTORADO","RECTORADO ESPOL");
            crearFacultades(BIBLIO, "BIBLIOTECA","BIBLIOTECA CENTRAL DE INGENIERÍA");


            switch (key) {
                case "FIEC":
                    partida= FIEC;
                  break;
                case "FIMCP":
                    partida= FIMCP;
                    break;
                case "FICT":
                    partida= FICT;
                    break;
                case "FCSH":
                    partida= FCSH;
                    break;
                case "CELEX":
                    partida= CELEX;
                    break;
                case "FCNM":
                    partida= FCNM;
                    break;
                case "FIMCBOR":
                    partida= FIMCBOR;
                     break;
                case "EDCOM":
                    partida= EDCOM;
                    break;
                case "RECTORADO":
                    partida= RECTORADO;
                    break;
                case "BIBLIOTECA":
                    partida= BIBLIO;
                    break;

                default:
                    break;

            }
            switch (key2) {
                case "FIEC":
                    destino= FIEC;
                    break;
                case "FIMCP":
                    destino= FIMCP;
                    break;
                case "FICT":
                    destino= FICT;
                    break;
                case "FCSH":
                    destino= FCSH;
                    break;
                case "CELEX":
                    destino= CELEX;
                    break;
                case "FCNM":
                    destino= FCNM;
                    break;
                case "FIMCBOR":
                    destino= FIMCBOR;
                    break;
                case "EDCOM":
                    destino= EDCOM;
                    break;
                case "RECTORADO":
                    destino= RECTORADO;
                    break;
                case "BIBLIOTECA":
                    destino= BIBLIO;
                    break;

                default:
                    break;

            }
            getRutas(partida,destino);

        }catch (Exception e){}
    }

    private void getAlerta(String key, String detalle){

        AlertDialog.Builder oAlerta = new AlertDialog.Builder(this);
        oAlerta.setTitle(detalle);//oAlerta.setMessage(mensaje);
        LayoutInflater inflater = getLayoutInflater();
        //oAlerta.setView(inflater.inflate(R.layout.facultad, null));
        LayoutInflater oInflater = getLayoutInflater();
        switch (key) {
            case "FIEC":
                oAlerta.setView( oInflater.inflate(R.layout.fiec, null));
                break;
            case "FIMCP":
                oAlerta.setView(inflater.inflate(R.layout.edcom, null));
                break;
            case "FICT":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "FCSH":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "CELEX":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "FCNM":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "FIMCBOR":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "EDCOM":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "RECTORADO":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;
            case "BIBLIOTECA":
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;

            default:
                oAlerta.setView( oInflater.inflate(R.layout.fimcp, null));
                break;

        }
        oAlerta.setCancelable(false);
        oAlerta.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        oAlerta.show();
    }

    private void getRutas(LatLng inicio, LatLng fin){
        PolylineOptions lineas = new PolylineOptions()
                .add(inicio)
                .add(fin);
        lineas.width(1);
        lineas.color(Color.RED);

        mapa.addPolyline(lineas);
    }

    public void crearFacultades(LatLng position, String titulo, String info){
        mapa.addMarker(new MarkerOptions()
                .position(position)
                .title(titulo)
                .snippet(info)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))//.icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_compass))//
                .anchor(0.5f, 0.5f));
    }


    public void moveCamera(View view) {//PAra centrar la camara en esta posicion
        mapa.moveCamera(CameraUpdateFactory.newLatLng(ESPOL));
    }

    public void animateCamera(View view) {//Mi ubicación
        if (mapa.getMyLocation() != null)
            mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng( mapa.getMyLocation().getLatitude(),mapa.getMyLocation().getLongitude()), 15));
    }

    public void addMarker(View view) {
        mapa.addMarker(new MarkerOptions().position(
                new LatLng(mapa.getCameraPosition().target.latitude, mapa.getCameraPosition().target.longitude)));
    }

    @Override
    public void onMapClick(LatLng puntoPulsado) {
        mapa.addMarker(new MarkerOptions().position(puntoPulsado).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
    }
}