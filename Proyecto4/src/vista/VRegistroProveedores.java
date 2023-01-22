package vista;

import modelo.Login;
import modelo.Proveedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VRegistroProveedores extends JFrame {

    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jlContraseña;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlNit;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlTelefono;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JCheckBox mostrarContraseña;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNIT;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    public ArrayList<Object> lista = new ArrayList<Object>();
    public ArrayList<Object>registrosLogin = new ArrayList<>();
    Proveedor proveedor;
    Login login;
    public VRegistroProveedores(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        cargar_txt();
        cargarLogin();
    }

    private void iniciarComponentes(){
        jpContenido = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlNit = new javax.swing.JLabel();
        txtNIT = new javax.swing.JTextField();
        jlTelefono = new javax.swing.JLabel();
        jlCorreo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jlUsuario = new javax.swing.JLabel();
        jlContraseña = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        mostrarContraseña = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        mostrarContraseña.addActionListener(manejadorDeEventos);
        btnRegistrar.addActionListener(manejadorDeEventos);
        btnCancelar.addActionListener(manejadorDeEventos);

        jlTitulo.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jlTitulo.setText("REGISTRAR PROVEEDORES");

        jlNombre.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jlNombre.setText("Nombre ");

        jlNit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jlNit.setText("NIT");

        txtNIT.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jlTelefono.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jlTelefono.setText("Teléfono");

        jlCorreo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jlCorreo.setText("Correo electrónico");

        txtNombre.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        btnCancelar.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        btnCancelar.setText("Cancelar");

        btnRegistrar.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        btnRegistrar.setText("Registrar");

        jlUsuario.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jlUsuario.setText("Usuario");

        jlContraseña.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jlContraseña.setText("Contraseña");

        txtUsuario.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        txtContraseña.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        mostrarContraseña.setText("Mostrar contraseña");

        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addComponent(jlTitulo))
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                .addComponent(jlNit)
                                                                .addGap(244, 244, 244)
                                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jlTelefono)
                                                                        .addComponent(jlCorreo)
                                                                        .addComponent(jlUsuario)
                                                                        .addComponent(jlContraseña))
                                                                .addGap(126, 126, 126)
                                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                                                        .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                                                        .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                                                        .addComponent(txtContraseña)))
                                                        .addComponent(mostrarContraseña, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap(107, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar)
                                .addGap(154, 154, 154))
        );
        jpContenidoLayout.setVerticalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jlTitulo)
                                .addGap(37, 37, 37)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlNit))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlNombre)
                                        .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlTelefono))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlCorreo))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlUsuario)
                                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlContraseña)
                                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(mostrarContraseña)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRegistrar)
                                        .addComponent(btnCancelar))
                                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jpContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void agregarProveedor(Proveedor proveedor){
        this.lista.add(proveedor);
    }

    public Proveedor obtenerCodigos(int id){
        return (Proveedor)lista.get(id);
    }
    public Login obtenerUsuario(int usuario){
        return (Login)registrosLogin.get(usuario);
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

    public int buscarUsuario(int usuario){
        for(int i = 0; i<cantidadLogin();i++){
            if(usuario == obtenerUsuario(i).getUsuario()) {
                return i;
            }
        }
        return -1;
    }

    public int cantidadLogin(){
        return this.registrosLogin.size();
    }

    public void agregarLogin(Login login){
        this.registrosLogin.add(login);
    }

    private void cargarLogin(){
        File ruta = new File("Login.txt");
        try{
            FileReader archivo = new FileReader(ruta);
            BufferedReader lectura = new BufferedReader(archivo);

            String linea = null;
            while((linea = lectura.readLine())!=null){
                StringTokenizer st = new StringTokenizer(linea, " - ");
                login = new Login();
                login.setUsuario(Integer.parseInt(st.nextToken()));
                login.setPassword(st.nextToken());
                agregarLogin(login);
            }
            lectura.close();
        } catch (Exception e){
            mensaje("Error al cargar archivo: "+e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void cargar_txt(){
        File ruta = new File("ProveedoresRegistrados.txt");
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
            fw = new FileWriter("ProveedoresRegistrados.txt");
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

    private void grabarLogin(){
        FileWriter fw;
        PrintWriter pw;
        try{
            fw = new FileWriter("Login.txt");
            pw = new PrintWriter(fw);

            for(int i = 0; i < cantidadLogin(); i++){
                login = obtenerUsuario(i);
                pw.println(String.valueOf(login.getUsuario() + " - "+login.getPassword()));
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
                proveedor = new Proveedor(leerId(), leerNombre(), leerTelefonos(), leerCorreo(), leerUsuario(), leerPass());
                String password = txtContraseña.getText();
                login = new Login(leerId(),password);
                if(buscaCodigo(proveedor.getId())!= -1){
                    mensaje("Este código ya existe");
                } else {
                    agregarProveedor(proveedor);
                    agregarLogin(login);
                    grabar_txt();
                    grabarLogin();
                    JOptionPane.showMessageDialog(null,"Se ha registrado exitosamente");
                    JOptionPane.showMessageDialog(null,"Su usuario es: " + leerId() + "\n\nSu contraseña es: " + leerPass(), "Inicio de sesión", JOptionPane.INFORMATION_MESSAGE);
                }
                limpiar();

            }
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
    }
    public int leerId(){
        try{
            int codigo = Integer.parseInt(txtNombre.getText().trim());
            return codigo;
        }catch(Exception ex){
            return -666;
        }
    }

    public String leerNombre(){
        try{
            String nombre = txtNIT.getText().trim().replace(" ", "_");
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

    public String leerUsuario(){
        try{
            String usuario = txtUsuario.getText();
            return usuario;
        }catch (Exception e){
            return null;
        }
    }

    public String leerPass(){
        try{
            String pass = txtContraseña.getText();
            return pass;
        }catch (Exception e){
            return null;
        }
    }
    public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }


    private void limpiar(){
        txtNIT.setText("");
        txtCorreo.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
    }


    class ManejadorDeEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnRegistrar) {
                ingresarRegistro();
            } else if (e.getSource() == btnCancelar) {
               VMenu a = new VMenu();
               a.setVisible(true);
               dispose();
            }
        }
    }
}
