package es.upm.dit.adsw;

/**
 * Created by cif on 2/05/16.
 */
public class Pais  {
    private String nombre;
    private int bandera;
    private int superficie;
    private int code;


    public Pais(String nombre, int bandera, int superficie, int code){
        this.nombre = nombre;
        this.bandera = bandera;
        this.superficie = superficie;
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", bandera=" + bandera +
                ", superficie=" + superficie +
                ", code=" + code +
                '}';
    }
}
