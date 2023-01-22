package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VLoginCliente extends JFrame {
    JButton btnRegistrar, btnRegresar, btnIngresar, jButton1;
    JPanel jpContenido;
    JLabel jlTitulo, jlUsuario, jlPassword, jlNotienesCuenta;
    JTextField txtUsuario;
    JPasswordField txtPassword;
    JCheckBox checkMostrar;
    
    
    public VLoginCliente(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        this.setTitle("Iniciar sesión");
    }
    
    private void iniciarComponentes(){
        jButton1 = new javax.swing.JButton();
        jpContenido = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jlPassword = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        checkMostrar = new javax.swing.JCheckBox();
        jlNotienesCuenta = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        btnIngresar.addActionListener(manejadorDeEventos);
        btnRegistrar.addActionListener(manejadorDeEventos);
        btnRegresar.addActionListener(manejadorDeEventos);
        checkMostrar.addActionListener(manejadorDeEventos);

        jpContenido.setBackground(new java.awt.Color(255, 204, 255));

        jlTitulo.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(102, 255, 102));
        jlTitulo.setText("Iniciar sesión");

        jlUsuario.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jlUsuario.setText("Usuario");

        txtUsuario.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N

        jlPassword.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jlPassword.setText("Contraseña");

        btnIngresar.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        btnIngresar.setText("Ingresar");

        checkMostrar.setBackground(new java.awt.Color(255, 204, 255));
        checkMostrar.setText("Mostrar ");

        jlNotienesCuenta.setFont(new java.awt.Font("Eras Medium ITC", 0, 12)); // NOI18N
        jlNotienesCuenta.setText("¿No tienes cuenta?");

        btnRegistrar.setBackground(new java.awt.Color(255, 204, 255));
        btnRegistrar.setFont(new java.awt.Font("Eras Medium ITC", 0, 12)); // NOI18N
        btnRegistrar.setText("Regístrate");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 255, 204))); // NOI18N

        btnRegresar.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        btnRegresar.setText("Regresar");

        txtPassword.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N

        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRegresar)
                                .addGap(28, 28, 28))
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(checkMostrar)
                                                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jlTitulo)
                                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jlPassword)
                                                                .addComponent(jlUsuario))))
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(111, 111, 111)
                                                .addComponent(jlNotienesCuenta)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnRegistrar)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        jpContenidoLayout.setVerticalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jlTitulo)
                                .addGap(18, 18, 18)
                                .addComponent(jlUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jlPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkMostrar)
                                .addGap(37, 37, 37)
                                .addComponent(btnIngresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlNotienesCuenta)
                                        .addComponent(btnRegistrar))
                                .addGap(18, 18, 18)
                                .addComponent(btnRegresar)
                                .addGap(14, 14, 14))
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

    private void ingresar(){

        try{
            String fila[] = null;
            FileReader archivo = new FileReader("LoginClientes.txt");
            BufferedReader lectura = new BufferedReader(archivo);

            String linea = lectura.readLine();
            boolean respuestas = false;
            while(linea != null && !respuestas){
                fila = linea.split(" - ");
                linea = lectura.readLine();
                int user = Integer.parseInt(txtUsuario.getText());
                String password=txtPassword.getText();
                if(validarUsuario(fila, user, password)){
                   respuestas = true;
                }else {
                    respuestas = false;
                }

            }
            if(!respuestas){
                JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA O USUARIO INCORRECTO");
            }
        }catch (IOException e){
            System.out.println(e+"Este error");
        }
    }

    public boolean validarUsuario(String usuarios[], int user, String pwd) {

        boolean respuestas = false;
        for (int i = 0; i < usuarios.length; i++) {
            if ((usuarios[i].equalsIgnoreCase(String.valueOf(user)) && usuarios[i + 1].equals(pwd))) {
                JOptionPane.showMessageDialog(null,"Bienvenido");
                VCompraProductos a = new VCompraProductos();
                respuestas = true;
                a.setVisible(true);
                dispose();
            }
        }
        return respuestas;
    }
    
    class ManejadorDeEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == checkMostrar) {
                if (checkMostrar.isSelected()) {
                    //System.out.println(txtPassword);
                    txtPassword.setEchoChar((char) 0);
                } else {
                    txtPassword.setEchoChar('*');
                }
            }
            if(e.getSource() == btnIngresar){
                if(txtUsuario.getText().equals("")||txtPassword.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Por favor rellene toda la información", "Error",JOptionPane.ERROR_MESSAGE);
                }else {
                    ingresar();
                }
            } else if (e.getSource() == btnRegistrar) {
                VRegistrarCliente a = new VRegistrarCliente();
                a.setVisible(true);
                dispose();
            } else if (e.getSource() == btnRegresar) {
                VMenu a = new VMenu();
                a.setVisible(true);
                dispose();
                
            }

        }
    }
}
