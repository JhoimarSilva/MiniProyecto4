package modelo;


import java.util.ArrayList;
public class Proceso {

    public Proceso() {
    }

    public ArrayList<Object> lista = new ArrayList<Object>();
    public Proceso(ArrayList<Object> lista){
        this.lista = lista;
    }

    public void agregarRegistro(Producto producto){
        this.lista.add(producto);
    }

    public void modificarRegistro(int item, Producto producto){
        this.lista.set(item, producto);
    }

    public void eliminarRegistro(int item){
        this.lista.remove(item);
    }

    public Producto obtenerRegistro(int item){
        return (Producto)lista.get(item);
    }

    public int cantidadRegistro(){
        return this.lista.size();
    }

    public int buscaCodigo(int codigo){
        for(int i = 0; i < cantidadRegistro(); i++){
            if(codigo == obtenerRegistro(i).getCodigo())return i;
        }
        return -1;
    }

}
