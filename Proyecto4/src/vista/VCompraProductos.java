package vista;

import modelo.Producto;
import modelo.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class VCompraProductos extends JFrame {
    JPanel jpContenido, jpOtropanel;
    JLabel jlTitulo, jlCodigo, jlPrecio, jlNombre, jLabel3, jlCantidad, jlTotal;
    JScrollPane jScrollPane1;
    JTable tablaProductos;
    JTextField txtPrecio, txtNombre, txtCantidad;
    JButton btnEliminar, btnAgregar, btnModificar, btnSalir, btnModificar1;
    JComboBox comboCodigo;

    private String ruta_txt = "Compras";
    Producto producto;
    private TableRowSorter trsfiltro;
    String filtro;
    public ArrayList<Object> lista = new ArrayList<Object>();
    public ArrayList<Producto>productos = new ArrayList<>();


    public VCompraProductos(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        this.setTitle("Compra de productos");
        try{
            cargarCombox(comboCodigo);
            cargar_txt();
            listarRegistro();
        }catch(Exception ex){
            mensaje("No existe el archivo txt"+ ex);
        }

    }

    private void iniciarComponentes(){
        jpContenido = new javax.swing.JPanel();
        jpOtropanel = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jlCodigo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jlPrecio = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtPrecio.setEditable(false);
        jlNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNombre.setEditable(false);
        jlCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        comboCodigo = new javax.swing.JComboBox<>();

        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        btnAgregar.addActionListener(manejadorDeEventos);
        btnSalir.addActionListener(manejadorDeEventos);
        btnModificar.addActionListener(manejadorDeEventos);
        comboCodigo.addActionListener(manejadorDeEventos);
        btnModificar1.addActionListener(manejadorDeEventos);
        btnEliminar.addActionListener(manejadorDeEventos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpContenido.setBackground(new java.awt.Color(153, 255, 153));

        jlTitulo.setFont(new java.awt.Font("Rockwell", 2, 36)); // NOI18N
        jlTitulo.setText("Compra de productos");

        tablaProductos.setBackground(new java.awt.Color(204, 204, 255));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jlCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlCodigo.setText("Código");

        btnAgregar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnAgregar.setText("Añadir al carrito");

        jlPrecio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlPrecio.setText("Precio");

        jlTotal.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14));
        jlTotal.setText("Total");

        txtPrecio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        jlNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        jlCantidad.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlCantidad.setText("Cantidad");

        txtCantidad.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        btnEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar del carrito");

        btnModificar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnModificar.setText("Modificar compra");

        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnSalir.setText("Salir");

        btnModificar1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnModificar1.setText("Buscar producto");

        comboCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        comboCodigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin elección" }));
        jpOtropanel.setLayout(new GridLayout(1,2));
        jpOtropanel.add(jlTotal);
        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnSalir)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jlPrecio)
                                                                                                .addComponent(jlNombre))
                                                                                        .addGap(37, 37, 37))
                                                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                                        .addComponent(jlCodigo)
                                                                                        .addGap(31, 31, 31)))
                                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(txtNombre)
                                                                                .addComponent(txtPrecio)
                                                                                .addComponent(txtCantidad)
                                                                                .addComponent(comboCodigo, 0, 164, Short.MAX_VALUE))
                                                                        .addGap(119, 119, 119)
                                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnModificar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                .addComponent(jlCantidad)
                                                                .addGap(222, 222, 222)
                                                                .addComponent(jLabel3)))))
                                .addContainerGap(37, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlTitulo)
                                .addGap(164, 164, 164))
        );
        jpContenidoLayout.setVerticalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jlTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(btnAgregar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEliminar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnModificar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnModificar1)
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel3))
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jlCodigo)
                                                        .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jlNombre))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jlPrecio))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jlCantidad)
                                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(34, 34, 34)
                                .addComponent(btnSalir)
                                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jpContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
    public void comprarProducto(Producto producto){
        this.lista.add(producto);
    }

    public void modificarProducto(int id, Producto producto){
        this.lista.set(id, producto);
    }

    public void eliminarRegistro(int id){
        this.lista.remove(id);
    }
    public Producto obtenerCodigos(int id){
        return (Producto)lista.get(id);
    }

    public int cantidadRegistros(){
        return this.lista.size();
    }

    public int buscaCodigo(int codigo){
        for(int i = 0; i < cantidadRegistros(); i++){
            if(codigo == obtenerCodigos(i).getCodigo())return i;
        }
        return -1;
    }

    public void cargar_txt(){
        File ruta = new File(ruta_txt);
        try{

            FileReader archivo = new FileReader(ruta);
            BufferedReader lectura = new BufferedReader(archivo);


            String linea = null;
            while((linea = lectura.readLine())!=null){
                StringTokenizer st = new StringTokenizer(linea, " - ");
                producto = new Producto();
                producto.setCodigo(Integer.parseInt(st.nextToken()));
                producto.setNombre(st.nextToken());
                producto.setPrecio(Double.parseDouble(st.nextToken()));
                producto.setCantidad(Integer.parseInt(st.nextToken()));
                comprarProducto(producto);
            }
            lectura.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void grabar_txt(){
        FileWriter fw;
        PrintWriter pw;
        try{
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);

            for(int i = 0; i < cantidadRegistros(); i++){
                producto = obtenerCodigos(i);
                pw.println(String.valueOf(producto.getCodigo()+" - "+producto.getNombre()+" - "+producto.getPrecio()+" - "+producto.getCantidad()));
            }
            pw.close();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void ingresarRegistro(){
        try{
            if(leerId() == -666)mensaje("El id debe ser un número entero");
            else if(leerNombre() == null)mensaje("Debe ingresar el nombre del proveedor");
            else if(leerPrecio() == -666) mensaje("El precio debe ser un número entero");
            else if(leerCantidad() == -666)mensaje("La cantidad debe ser un número entero");
            else{
                producto = new Producto(leerId(), leerNombre(), leerPrecio(), leerCantidad(),leerProveedor());
                if(buscaCodigo(producto.getCodigo())!= -1){
                    mensaje("Este código ya existe");
                }
                else {
                    comprarProducto(producto);
                }

                grabar_txt();
                listarRegistro();
                //limpiar();

            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void modificarRegistro(){
        try{
            if(leerId() == -666)mensaje("El código debe ser un número entero");
            else if(leerNombre() == null)mensaje("Recuerde ingresar el nombre");
            else if(leerPrecio() == -666) mensaje("El precio debe ser un número");
            else if(leerCantidad() == -666)mensaje("La cantidad debe ser un número");
            else{
                int codigo = buscaCodigo(leerId());
                producto = new Producto(leerId(), leerNombre(), leerPrecio(), leerCantidad(),leerProveedor());

                if(codigo == -1){
                    JOptionPane.showMessageDialog(null,"Este código no existe"+"\nIntente registrando el producto", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    modificarProducto(codigo, producto);
                }

                grabar_txt();
                listarRegistro();
            }
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
    }

    public void eliminarRegistro(){
        try{
            if(leerId() == -666) mensaje("Ingrese codigo entero");

            else{
                int codigo = buscaCodigo(leerId());
                if(codigo == -1) mensaje("El código no existe");

                else{
                    int s = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este producto?","Si/No",0);
                    if(s == 0){
                        eliminarRegistro(codigo);

                        grabar_txt();
                        listarRegistro();
                    }
                }


            }
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
    }

    public void listarRegistro(){
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        dt.addColumn("Código");
        dt.addColumn("Nombre");
        dt.addColumn("Precio");
        dt.addColumn("Cantidad");


        Object fila[] = new Object[dt.getColumnCount()];
        for(int i = 0; i < cantidadRegistros(); i++){
            producto = obtenerCodigos(i);
            fila[0] = producto.getCodigo();
            fila[1] = producto.getNombre();
            fila[2] = producto.getPrecio();
            fila[3] = producto.getCantidad();
            dt.addRow(fila);
        }
        tablaProductos.setModel(dt);
        tablaProductos.setRowHeight(60);
    }

    public int leerId(){
        try{
            int codigo = (int) comboCodigo.getSelectedItem();
            return codigo;
        }catch(Exception ex){
            return -666;
        }
    }

    public String leerNombre(){
        try{
            String nombre = txtNombre.getText().trim().replace(" ", "_");
            return nombre;
        }catch(Exception ex){
            return null;
        }
    }

    public double leerPrecio(){
        try{
            double precio = Double.parseDouble(txtPrecio.getText());
            return precio;
        }catch(Exception ex){
            return -666;
        }

    }

    public int leerCantidad(){
        try{
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());
            return cantidad;
        }catch(Exception ex){
            return -666;
        }
    }
    public String leerProveedor(){
        try{
            String proveedor = "";
            return proveedor;
        }catch(Exception ex){
            return null;
        }
    }

    public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }

    public int PrimerCaracter (String dato){
        String resultado = "";
        int indice = 0;
            while(dato.charAt(indice + 1) != '-'){
                resultado += dato.charAt(indice);
                indice += 1;
            }
        return Integer.parseInt(resultado);
    }

    public String ValidadProducto (String codigo){
        boolean i = false;
        String actual = "";
        String posicion = "";
        System.out.println("Este es antes del try");
        System.out.println(codigo);

        try {
            BufferedReader producto = new BufferedReader(new FileReader("Productos.txt"));
            while ((posicion = producto.readLine())!=null) {
                if (posicion.indexOf(codigo) != -1) {

                    if( PrimerCaracter(posicion) == Integer.parseInt(codigo)){
                        System.out.println("Se encontró el registro " + posicion);
                        i = true;
                        actual = posicion;
                    }
                    System.out.println("Se encontró el registro " + PrimerCaracter(posicion));
                    System.out.println(codigo);
                }
                    /*if(codigo == posicion.substring(0,1)){
                        System.out.println(posicion);
                        actual = posicion;
                    }*/
                    i = true;


            }

            }catch(IOException e) {
                System.out.println(e);
            }
        return actual;
    }

    public void MostrarTexfield() {
        String  codigo =(comboCodigo.getSelectedItem().toString());
        String Validar = ValidadProducto(codigo)+" - ";
        int i = 0;
        int l = 0;
        int NoProducto = Validar.length();
        String data [] = new String[3];
        String dato = "";
        for(i=0; i<=NoProducto;i++){
            if('-'!=Validar.charAt(i)){
                dato += Validar.charAt(i);
            }
            else {
                data[l] = dato;
                System.out.println(dato);
                txtNombre.setText(data[1]);
                txtPrecio.setText(data[2]);
                l = l + 1;
                dato = "";
            }

        }

    }


    private void cargarCombox(JComboBox comboNombre){
        comboNombre.removeAllItems();
        FileReader fileReader = null;
        try{
            String cadenaleida="";
            fileReader = new FileReader("Productos.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            cadenaleida = bufferedReader.readLine();
            while(cadenaleida != null){
                StringTokenizer st = new StringTokenizer(cadenaleida," - ");
                int codigo = Integer.parseInt(st.nextToken());
                st.nextToken();
                comboNombre.addItem(codigo);
                cadenaleida = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    class ManejadorDeEventos implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAgregar) {
                if (txtPrecio.getText().equals("") || txtNombre.getText().equals("") || txtCantidad.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Recuerde rellenar toda la información", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ingresarRegistro();
                }
            } else if (e.getSource() == btnModificar) {
                if (txtPrecio.getText().equals("") || txtNombre.getText().equals("") || txtCantidad.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Recuerde rellenar toda la información", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    modificarRegistro();
                }
            } else if (e.getSource() == btnEliminar) {
                eliminarRegistro();
            } else if (e.getSource() == comboCodigo) {
                //cargartextfield();

            } else if (e.getSource() == btnSalir) {
                VMenu a = new VMenu();
                a.setVisible(true);
                dispose();
            } else if (e.getSource() == btnModificar1) {
                MostrarTexfield();
            }
        }
            @Override
            public void mouseClicked (MouseEvent e){
                if (e.getSource() == tablaProductos) {
                    int clic_tabla = tablaProductos.rowAtPoint(e.getPoint());

                    String codigo = (String) tablaProductos.getValueAt(clic_tabla, 0);
                    String nombre = "" + tablaProductos.getValueAt(clic_tabla, 1);
                    String precio = (String) tablaProductos.getValueAt(clic_tabla, 2);
                    String cantidad = (String) tablaProductos.getValueAt(clic_tabla, 3);

                    //txtCodigo.setText(codigo);
                    txtNombre.setText(nombre);
                    txtPrecio.setText(precio);
                    //txtCantidad.setText(cantidad);
                }

            }

            @Override
            public void mousePressed (MouseEvent e){

            }

            @Override
            public void mouseReleased (MouseEvent e){

            }

            @Override
            public void mouseEntered (MouseEvent e){

            }

            @Override
            public void mouseExited (MouseEvent e){

            }
        }

}
