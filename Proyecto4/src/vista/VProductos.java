package vista;

import modelo.Proceso;
import modelo.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VProductos extends JFrame {
    private JButton btnBuscar, btnEliminar, btnGuardar, btnModificar, btnSalir;
    private JScrollPane jScrollPane1;
    private JLabel jlCantidad, jlCodigo, jlNombre,jlPrecio, jlTitulo, jlProveedor;
    private JPanel jpContenido;
    private JTable tablaProductos;
    private JTextField txtCantidad, txtCodigo, txtNombre, txtPrecio;
    private JComboBox jComboProveedor;
    private String ruta_txt = "Productos.txt";

    Producto producto;
    Proceso proceso;

    //int clic_tabla;
    private TableRowSorter trsfiltro;
    String filtro;

    public VProductos(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        this.setTitle("Productos");
        proceso = new Proceso();

        try{
            cargar_txt();
            listarRegistro();
            cargarCombox(jComboProveedor);
        }catch(Exception ex){
            mensaje("No existe el archivo txt");
        }
    }

    private void iniciarComponentes(){
        jpContenido = new javax.swing.JPanel();
        txtPrecio = new javax.swing.JTextField();
        jlNombre = new javax.swing.JLabel();
        jlPrecio = new javax.swing.JLabel();
        jlCodigo = new javax.swing.JLabel();
        jlCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jComboProveedor = new javax.swing.JComboBox<>();
        jlProveedor = new javax.swing.JLabel();
        jlTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        btnBuscar.addActionListener(manejadorDeEventos);
        btnEliminar.addActionListener(manejadorDeEventos);
        btnModificar.addActionListener(manejadorDeEventos);
        btnSalir.addActionListener(manejadorDeEventos);
        btnGuardar.addActionListener(manejadorDeEventos);
        tablaProductos.addMouseListener(manejadorDeEventos);
        txtCodigo.addKeyListener(manejadorDeEventos);
        txtNombre.addKeyListener(manejadorDeEventos);
        txtCantidad.addKeyListener(manejadorDeEventos);
        txtPrecio.addKeyListener(manejadorDeEventos);

        jpContenido.setBackground(new java.awt.Color(153, 153, 255));

        txtPrecio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        jlNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlNombre.setText("Nombre");

        jlPrecio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlPrecio.setText("Precio");

        jlCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlCodigo.setText("Código");

        jlCantidad.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlCantidad.setText("Cantidad");

        txtCantidad.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar ");

        btnBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar ");

        btnModificar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnModificar.setText("Modificar ");

        btnEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");

        tablaProductos.setBackground(new java.awt.Color(255, 153, 255));
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

        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnSalir.setText("Salir");

        jlProveedor.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlProveedor.setText("Proveedor");

        jlTitulo.setFont(new java.awt.Font("Rockwell", 2, 48)); // NOI18N
        jlTitulo.setText("Productos");

        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                                        .addComponent(jlCantidad)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jlCodigo)
                                                                                                .addComponent(jlNombre)
                                                                                                .addComponent(jlProveedor))
                                                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                                                        .addGap(57, 57, 57)
                                                                                                        .addComponent(jComboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                                        .addComponent(jlPrecio)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGap(128, 128, 128)
                                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(224, 224, 224)
                                                .addComponent(jlTitulo)))
                                .addContainerGap(44, Short.MAX_VALUE))
        );
        jpContenidoLayout.setVerticalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addComponent(jlTitulo)
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jlProveedor)
                                                        .addComponent(jComboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jlCodigo)
                                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jlNombre)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jlPrecio))
                                                .addGap(18, 18, 18)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jlCantidad)
                                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18))
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addComponent(btnGuardar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnBuscar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnModificar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnEliminar)
                                                .addGap(39, 39, 39)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
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
                producto.setProveedor(st.nextToken());
                proceso.agregarRegistro(producto);
            }
            lectura.close();
        }catch(Exception ex){
            mensaje("Error al cargar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void grabar_txt(){
        FileWriter fw;
        PrintWriter pw;
        try{
            fw = new FileWriter(ruta_txt);
            pw = new PrintWriter(fw);

            for(int i = 0; i < proceso.cantidadRegistro(); i++){
                producto = proceso.obtenerRegistro(i);
                pw.println(String.valueOf(producto.getCodigo()+" - "+producto.getNombre()+" - "+producto.getPrecio()+" - "+producto.getCantidad() + " - " + producto.getProveedor()));
            }
            pw.close();

        }catch(Exception ex){
            mensaje("Error al grabar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void ingresarRegistro(){
        try{
            if(leerCodigo() == -666)mensaje("El código debe ser un número entero");
            else if(leerNombre() == null)mensaje("Debe ingresar el nombre del producto");
            else if(leerPrecio() == -666) mensaje("El precio debe ser un número entero");
            else if(leerProveedor() == null)mensaje("Debe escoger un proveedor");
            else if(leerCantidad() == -666)mensaje("La cantidad debe ser un número entero");
            else{
                producto = new Producto(leerCodigo(), leerNombre(), leerPrecio(), leerCantidad(),leerProveedor());
                if(proceso.buscaCodigo(producto.getCodigo())!= -1){
                    mensaje("Este código ya existe");
                }
                else {
                    proceso.agregarRegistro(producto);
                }

                grabar_txt();
                listarRegistro();
            }
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
    }

    public void modificarRegistro(){
        try{
            if(leerCodigo() == -666)mensaje("El código debe ser un número entero");
            else if(leerNombre() == null)mensaje("Recuerde ingresar el nombre");
            else if(leerPrecio() == -666) mensaje("El precio debe ser un número");
            else if(leerProveedor() == null) mensaje("Debe seleccionar un proveedor");
            else if(leerCantidad() == -666)mensaje("Ingresar cantidad entera");
            else{
                int codigo = proceso.buscaCodigo(leerCodigo());
                producto = new Producto(leerCodigo(), leerNombre(), leerPrecio(), leerCantidad(), leerProveedor());

                if(codigo == -1){
                    JOptionPane.showMessageDialog(null,"Este código no existe"+"\nIntente registrando el producto", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    proceso.modificarRegistro(codigo, producto);
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
            if(leerCodigo() == -666) mensaje("Ingrese codigo entero");

            else{
                int codigo = proceso.buscaCodigo(leerCodigo());
                if(codigo == -1) mensaje("El código no existe");

                else{
                    int s = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este producto?","Si/No",0);
                    if(s == 0){
                        proceso.eliminarRegistro(codigo);

                        grabar_txt();
                        listarRegistro();
                    }
                }


            }
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
        limpiar();
    }

    public void listarRegistro(){
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("Precio");
        dt.addColumn("Cantidad");
        dt.addColumn("Proveedor");


        Object fila[] = new Object[dt.getColumnCount()];
        for(int i = 0; i < proceso.cantidadRegistro(); i++){
            producto = proceso.obtenerRegistro(i);
            fila[0] = producto.getCodigo();
            fila[1] = producto.getNombre();
            fila[2] = producto.getPrecio();
            fila[3] = producto.getCantidad();
            fila[4] = producto.getProveedor();
            dt.addRow(fila);
        }
        tablaProductos.setModel(dt);
        tablaProductos.setRowHeight(60);
    }

    private void cargarCombox(JComboBox jComboProveedor){
        jComboProveedor.removeAllItems();
        FileReader fileReader = null;
        try{
            String cadenaleida="";
            fileReader = new FileReader("ProveedoresRegistrados.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            cadenaleida = bufferedReader.readLine();
            while(cadenaleida != null){
                StringTokenizer st = new StringTokenizer(cadenaleida," - ");
                st.nextToken();
                String proveedor = st.nextToken();
                jComboProveedor.addItem(proveedor);
                cadenaleida = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int leerCodigo(){
        try{
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
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

    public String leerProveedor(){
        try{
            String proveedor = (String) jComboProveedor.getSelectedItem();
            return proveedor;
        }catch (Exception ex){
            return null;
        }
    }

    public double leerPrecio(){
        try{
            double precio = Double.parseDouble(txtPrecio.getText().trim());
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
    public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }

    private void filtro(){
        filtro = txtCodigo.getText();
        trsfiltro.setRowFilter(RowFilter.regexFilter(txtCodigo.getText(),0));
    }

    private void buscarRegistro(){

        if(!txtCodigo.getText().equals("")) {
            trsfiltro = new TableRowSorter(tablaProductos.getModel());
            tablaProductos.setRowSorter(trsfiltro);

            String cadena = txtCodigo.getText();
            txtCodigo.setText(cadena);
            repaint();
            filtro();
        }else{
            JOptionPane.showMessageDialog(null,"Recuerde digitar el código que busca");
        }

    }

    private void limpiar(){
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtNombre.setText("");
        txtCodigo.setText("");
    }


    class ManejadorDeEventos implements ActionListener, MouseListener,KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnGuardar){
                if(txtCodigo.getText().equals("")|| txtCantidad.getText().equals("")||txtNombre.getText().equals("")||txtPrecio.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Por favor rellene toda la información", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ingresarRegistro();
                }
                limpiar();
            }else if (e.getSource() == btnModificar){
                if(txtCodigo.getText().equals("")|| txtCantidad.getText().equals("")||txtNombre.getText().equals("")||txtPrecio.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Por favor rellene toda la información", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    modificarRegistro();
                }
            } else if (e.getSource() == btnEliminar) {
                eliminarRegistro();
            } else if (e.getSource() == btnSalir) {
                VMenu a = new VMenu();
                a.setVisible(true);
                dispose();
            } else if (e.getSource() == btnBuscar) {
                buscarRegistro();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == tablaProductos){
                int clic_tabla = tablaProductos.rowAtPoint(e.getPoint());

                int codigo = (int)tablaProductos.getValueAt(clic_tabla, 0);
                String nombre = ""+tablaProductos.getValueAt(clic_tabla, 1);
                double precio = (double)tablaProductos.getValueAt(clic_tabla, 2);
                int cantidad = (int)tablaProductos.getValueAt(clic_tabla, 3);
                String proveedor = (String)tablaProductos.getValueAt(clic_tabla,4);

                txtCodigo.setText(String.valueOf(codigo));
                txtNombre.setText(nombre);
                txtPrecio.setText(String.valueOf(precio));
                txtCantidad.setText(String.valueOf(cantidad));
                jComboProveedor.setSelectedItem(proveedor);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                if(e.getSource() == txtCodigo){
                    txtNombre.requestFocus();
                } else if (e.getSource() == txtNombre) {
                    txtPrecio.requestFocus();
                } else if (e.getSource() == txtPrecio) {
                    txtCantidad.requestFocus();
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
