package vista;

import modelo.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class VListarProveedores extends JFrame {

    JPanel jpContenido;
    JLabel jlTitulo, jlNombre, jlNIT, jlTelefono, jlCorreo;
    JTextField txtNIT, txtNombre, txtTelefono, txtCorreo;
    JButton btnAgregar, btnModificar, btnSalir, btnBuscar, btnEliminar;
    JScrollPane jScrollPane1;
    JTable tablaProveedores;
    private String ruta_txt = "ProveedoresRegistrados.txt";
    Proveedor proveedor;
    private TableRowSorter trsfiltro;
    String filtro;
    public ArrayList<Object> lista = new ArrayList<Object>();


    public VListarProveedores(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        this.setTitle("Registrar proveedor");
        try{
            cargar_txt();
            listarRegistro();
        }catch(Exception ex){
            mensaje("No existe el archivo txt");
        }
    }

    private void iniciarComponentes(){
        jpContenido = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jlNIT = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlTelefono = new javax.swing.JLabel();
        jlCorreo = new javax.swing.JLabel();
        txtNIT = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();

        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        btnAgregar.addActionListener(manejadorDeEventos);
        btnEliminar.addActionListener(manejadorDeEventos);
        btnModificar.addActionListener(manejadorDeEventos);
        btnSalir.addActionListener(manejadorDeEventos);
        btnBuscar.addActionListener(manejadorDeEventos);
        tablaProveedores.addMouseListener(manejadorDeEventos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpContenido.setBackground(new java.awt.Color(153, 255, 204));

        jlTitulo.setFont(new java.awt.Font("Rockwell", 2, 36)); // NOI18N
        jlTitulo.setText("PROVEEDORES");

        jlNIT.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlNIT.setText("NIT");

        jlNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlNombre.setText("NOMBRE");

        jlTelefono.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlTelefono.setText("TELÉFONO");

        jlCorreo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlCorreo.setText("CORREO");

        txtNIT.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");

        btnModificar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");

        btnBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");

        btnEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");

        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnSalir.setText("Salir");

        tablaProveedores.setBackground(new java.awt.Color(204, 255, 255));
        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaProveedores);

        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addComponent(jlNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jlTelefono)
                                                                        .addComponent(jlCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(29, 29, 29))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)))
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(174, 174, 174))
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(542, 542, 542)
                                .addComponent(btnSalir)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                .addContainerGap(45, Short.MAX_VALUE)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(224, 224, 224))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44))))
        );
        jpContenidoLayout.setVerticalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jlNIT)
                                                        .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnAgregar))
                                                .addGap(13, 13, 13)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnModificar)))
                                        .addComponent(jlNombre))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnBuscar)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlTelefono))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlCorreo)
                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnEliminar)))
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir)
                                .addGap(44, 44, 44))
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

    public void agregarProveedor(Proveedor proveedor){
        this.lista.add(proveedor);
    }

    public void modificarProveedor(int id, Proveedor proveedor){
        this.lista.set(id, proveedor);
    }

    public void eliminarRegistro(int id){
        this.lista.remove(id);
    }

    public Proveedor obtenerCodigos(int id){
        return (Proveedor)lista.get(id);
    }

    public int cantidadRegistros(){
        return this.lista.size();
    }

    public int buscaCodigo(int codigo){
        for(int i = 0; i < cantidadRegistros(); i++){
            if(codigo == obtenerCodigos(i).getId())return i;
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
                proveedor = new Proveedor();
                proveedor.setId(Integer.parseInt(st.nextToken()));
                proveedor.setNombre(st.nextToken());
                proveedor.setTelefono(Integer.parseInt(st.nextToken()));
                proveedor.setCorreo(st.nextToken());
                agregarProveedor(proveedor);
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

            for(int i = 0; i < cantidadRegistros(); i++){
                proveedor = obtenerCodigos(i);
                pw.println(String.valueOf(proveedor.getId()+" - "+proveedor.getNombre()+" - "+proveedor.getTelefono()+" - "+proveedor.getCorreo()));
            }
            pw.close();

        }catch(Exception ex){
            mensaje("Error al grabar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void ingresarRegistro(){
        try{
            if(leerId() == -666)mensaje("El id debe ser un número entero");
            else if(leerNombre() == null)mensaje("Debe ingresar el nombre del proveedor");
            else if(leerTelefonos() == -666) mensaje("El telefono debe ser un número entero");
            else if(leerCorreo() == null)mensaje("Debe ingresar el correo");
            else{
                //proveedor = new Proveedor(leerId(), leerNombre(), leerTelefonos(), leerCorreo());
                if(buscaCodigo(proveedor.getId())!= -1){
                    mensaje("Este código ya existe");
                }
                else {
                    agregarProveedor(proveedor);
                }

                grabar_txt();
                listarRegistro();
                limpiar();

            }
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
    }

    public void modificarRegistro(){
        try{
            if(leerId() == -666)mensaje("El código debe ser un número entero");
            else if(leerNombre() == null)mensaje("Recuerde ingresar el nombre");
            else if(leerTelefonos() == -666) mensaje("El precio debe ser un número");
            else if(leerCorreo() == null)mensaje("Ingresar cantidad entera");
            else{
                int codigo = buscaCodigo(leerId());
                //proveedor = new Proveedor(leerId(), leerNombre(), leerTelefonos(), leerCorreo());

                if(codigo == -1){
                    JOptionPane.showMessageDialog(null,"Este código no existe"+"\nIntente registrando el producto", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    modificarProveedor(codigo, proveedor);
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
        limpiar();
    }

    public void listarRegistro(){
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        dt.addColumn("NIT");
        dt.addColumn("Nombre");
        dt.addColumn("Teléfono");
        dt.addColumn("Correo");


        Object fila[] = new Object[dt.getColumnCount()];
        for(int i = 0; i < cantidadRegistros(); i++){
            proveedor = obtenerCodigos(i);
            fila[0] = proveedor.getId();
            fila[1] = proveedor.getNombre();
            fila[2] = proveedor.getTelefono();
            fila[3] = proveedor.getCorreo();
            dt.addRow(fila);
        }
        tablaProveedores.setModel(dt);
        tablaProveedores.setRowHeight(60);
    }

    public int leerId(){
        try{
            int codigo = Integer.parseInt(txtNIT.getText().trim());
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

    public int leerTelefonos(){
        try{
            int telefono = Integer.parseInt(txtTelefono.getText().trim());
            return telefono;
        }catch(Exception ex){
            return -666;
        }
    }

    public String leerCorreo(){
        try{
            String correo = txtCorreo.getText().trim().replace(" ", "_");
            return correo;
        }catch(Exception ex){
            return null;
        }
    }
    public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }

    private void filtro(){
        filtro = txtNIT.getText();
        trsfiltro.setRowFilter(RowFilter.regexFilter(txtNIT.getText(),0));
    }
    private void buscarProveedor(){

        if(!txtNIT.getText().equals("")) {
            trsfiltro = new TableRowSorter(tablaProveedores.getModel());
            tablaProveedores.setRowSorter(trsfiltro);

            String cadena = txtNIT.getText();
            txtNIT.setText(cadena);
            repaint();
            filtro();
        }else{
            JOptionPane.showMessageDialog(null,"Recuerde digitar el código que busca");
        }

    }

    private void limpiar(){
        txtNIT.setText("");
        txtCorreo.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
    }



    class ManejadorDeEventos implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnAgregar){
                ingresarRegistro();
            }else if (e.getSource() == btnEliminar){
                eliminarRegistro();
            } else if (e.getSource() == btnBuscar) {
                buscarProveedor();
            } else if (e.getSource() == btnModificar) {
                modificarRegistro();

            } else if (e.getSource() == btnSalir) {
                System.exit(0);
            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == tablaProveedores){
                int clic_tabla = tablaProveedores.rowAtPoint(e.getPoint());

                int nit = (int)tablaProveedores.getValueAt(clic_tabla, 0);
                String nombre = ""+tablaProveedores.getValueAt(clic_tabla, 1);
                int telefono = (int)tablaProveedores.getValueAt(clic_tabla, 2);
                String correo = "";tablaProveedores.getValueAt(clic_tabla, 3);

                txtNIT.setText(String.valueOf(nit));
                txtNombre.setText(nombre);
                txtTelefono.setText(String.valueOf(telefono));
                txtCorreo.setText(correo);
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
    }
}
