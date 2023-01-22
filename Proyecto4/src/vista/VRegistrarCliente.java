package vista;

import modelo.Cliente;
import modelo.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VRegistrarCliente extends JFrame {
    JLabel jlTitulo, jlNombre, jlApellidos, jlNombre3, jlPassword, jlCorreo, jlTelefono, jlTipoDocumento, jlNumeroIdentificacion, jlSexo;
    JComboBox comboTipoDocumento, comboSexo;
    JButton btnRegistrar, btnCancelar;
    JPanel jpContenido;
    JTextField txtNombre, txtTelefono, txtCorreo, txtApellidos, txtCedula;
    JPasswordField txtPassword;
    JCheckBox checkMostrar;
    public ArrayList<Object> lista = new ArrayList<Object>();
    public ArrayList<Object> listaLogin = new ArrayList<Object>();
    Login login;
    Cliente cliente;

    public VRegistrarCliente(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        this.setTitle("Registro de clientes");
        cargar_txt();
        cargarLogin();
    }

    private void iniciarComponentes(){
        jpContenido = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlApellidos = new javax.swing.JLabel();
        jlTipoDocumento = new javax.swing.JLabel();
        jlNombre3 = new javax.swing.JLabel();
        jlNumeroIdentificacion = new javax.swing.JLabel();
        jlSexo = new javax.swing.JLabel();
        jlTelefono = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jlPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        checkMostrar = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jlCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        comboSexo = new javax.swing.JComboBox<>();
        comboTipoDocumento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        btnRegistrar.addActionListener(manejadorDeEventos);
        btnCancelar.addActionListener(manejadorDeEventos);

        jlTitulo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(0, 255, 102));
        jlTitulo.setText("Registro de clientes");

        jlNombre.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlNombre.setText("Nombre");

        jlApellidos.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlApellidos.setText("Apellidos");

        jlTipoDocumento.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlTipoDocumento.setText("Tipo de documento");

        jlNombre3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        jlNumeroIdentificacion.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlNumeroIdentificacion.setText("Número de identificación");

        jlSexo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlSexo.setText("Sexo");

        jlTelefono.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlTelefono.setText("Telefónico");

        jlPassword.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlPassword.setText("Contraseña");

        checkMostrar.setText("Mostrar");

        btnRegistrar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar");

        btnCancelar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");

        jlCorreo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlCorreo.setText("Correo electrónico");

        comboSexo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin definir", "Masculino", "Femenino","Prefiero no decirlo" }));

        comboTipoDocumento.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        comboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin definir", "Cédula de ciudadanía", "Cédula de extranjería","Tarjeta de identidad","Pasaporte" }));

        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(btnCancelar)
                                .addGap(150, 150, 150)
                                .addComponent(btnRegistrar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlTitulo)
                                .addGap(120, 120, 120))
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(checkMostrar)
                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                        .addComponent(jlCorreo)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                        .addComponent(jlNumeroIdentificacion)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                        .addComponent(jlSexo)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                        .addComponent(jlNombre)
                                                        .addGap(200, 200, 200)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                        .addComponent(jlTelefono)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jlApellidos)
                                                                .addComponent(jlTipoDocumento))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(txtApellidos)
                                                                .addComponent(comboTipoDocumento, 0, 187, Short.MAX_VALUE)))
                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                        .addComponent(jlPassword)
                                                                        .addGap(170, 170, 170))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                                        .addComponent(jlNombre3)
                                                                        .addGap(270, 270, 270)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 98, Short.MAX_VALUE))
        );
        jpContenidoLayout.setVerticalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jlTitulo)
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlNombre)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlApellidos)
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlTipoDocumento)
                                        .addComponent(comboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlNumeroIdentificacion)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlSexo)
                                        .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlTelefono)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlCorreo)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addComponent(jlNombre3)
                                                .addGap(61, 61, 61))
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jlPassword))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(checkMostrar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)))
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRegistrar)
                                        .addComponent(btnCancelar))
                                .addGap(27, 27, 27))
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
    public void agregarCliente(Cliente cliente){
        this.lista.add(cliente);
    }

    public Cliente obtenerCedulas(int id){
        return (Cliente) lista.get(id);
    }

    public int cantidadRegistros(){
        return this.lista.size();
    }

    public int buscaCodigo(int codigo){
        for(int i = 0; i < cantidadRegistros(); i++){
            if(codigo == obtenerCedulas(i).getCedula())return i;
        }
        return -1;
    }

    public Login obtenerUsuario(int usuario){
        return (Login)listaLogin.get(usuario);
    }

    public int cantidadLogin(){
        return this.listaLogin.size();
    }

    public void agregarLogin(Login login){
        this.listaLogin.add(login);
    }

    private void cargarLogin(){
        File ruta = new File("LoginClientes.txt");
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
        File ruta = new File("ClientesRegistrados.txt");
        try{

            FileReader archivo = new FileReader(ruta);
            BufferedReader lectura = new BufferedReader(archivo);


            String linea = null;
            while((linea = lectura.readLine())!=null){
                StringTokenizer st = new StringTokenizer(linea, " - ");
                cliente = new Cliente();
                cliente.setTipoDocumento(st.nextToken());
                cliente.setCedula(Integer.parseInt(st.nextToken()));
                cliente.setNombre(st.nextToken());
                cliente.setApellido(st.nextToken());
                cliente.setSexo(st.nextToken());
                cliente.setCelular(Integer.parseInt(st.nextToken()));
                cliente.setCorreo(st.nextToken());
                agregarCliente(cliente);
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
            fw = new FileWriter("ClientesRegistrados.txt");
            pw = new PrintWriter(fw);

            for(int i = 0; i < cantidadRegistros(); i++){
                cliente = obtenerCedulas(i);
                pw.println(String.valueOf(cliente.getTipoDocumento()+" - "+cliente.getCedula()+" - "+cliente.getNombre()+" - "+cliente.getApellido()+ " - "+cliente.getSexo()+ " - "+cliente.getCelular()+" - "+cliente.getCorreo()));
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
            fw = new FileWriter("LoginClientes.txt");
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
            else if(leerApellido() == null)mensaje("Debes ingresar los apellidos");
            else if(leerSexo() == null)mensaje("Debes seleccionar tu sexo");
            else if(leerTipoDocumento() == null)mensaje("Debes seleccionar tu tipo de documento");
            else if(leerPass() == null)mensaje("Debes ingresar una contraseña");
            else{
                cliente = new Cliente(leerTipoDocumento(), leerId(), leerNombre(),leerApellido(), leerSexo(), leerTelefonos(), leerCorreo(), leerPass());
                login = new Login(leerId(),leerPass());
                if(buscaCodigo(cliente.getCedula())!= -1){
                    mensaje("Este número de documento ya existe");
                } else {
                    agregarCliente(cliente);
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
            int codigo = Integer.parseInt(txtCedula.getText().trim());
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

    public String leerApellido(){
        try{
            String apellido = txtApellidos.getText().trim().replace(" ", "_");
            return apellido;
        }catch (Exception e){
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
            String correo = txtCorreo.getText();
            return correo;
        }catch(Exception ex){
            return null;
        }
    }

    public String leerTipoDocumento(){
        try{
            String tipo = (String) comboTipoDocumento.getSelectedItem();
            String tipoDocumento = tipo.replace(" ","_");
            return tipoDocumento;
        }catch (Exception e){
            return null;
        }
    }

    public String leerSexo(){
        try{
            String sexo = (String) comboSexo.getSelectedItem();
            String sexo2 = sexo.replace(" ", "_");
            return sexo2;
        }catch (Exception e){
            return null;
        }
    }

    public String leerPass(){
        try{
            String pass = txtPassword.getText();
            return pass;
        }catch (Exception e){
            return null;
        }
    }
    public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }


    private void limpiar(){
        txtApellidos.setText("");
        txtCorreo.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCedula.setText("");
        txtPassword.setText("");
        comboTipoDocumento.setSelectedItem("Sin definir");
        comboSexo.setSelectedItem("Sin definir");
    }


    class ManejadorDeEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnRegistrar){
                ingresarRegistro();
            } else if (e.getSource() == btnCancelar) {
                VLoginCliente a = new VLoginCliente();
                a.setVisible(true);
                dispose();
            }
        }
    }
}
