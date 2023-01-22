package vista;

import modelo.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class VLoginAdmin extends JFrame {
    JPanel jPanel1;
    JLabel lblUser, lblPwd, jLabel1, lblImgUser, lblImgPwd;
    JTextField txtUser, txtPwd;
    JButton btnCancelar, btnIngresar;
    private static String pwd;
    private static int user;
    String usuarioAcceso = "admin";
    String passwordAcceso = "admin";


    public VLoginAdmin(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        this.setTitle("Iniciar sesión");
    }

    private void iniciarComponentes(){
        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblPwd = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPwd = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblImgUser = new javax.swing.JLabel();
        lblImgPwd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        btnIngresar.addActionListener(manejadorDeEventos);
        btnCancelar.addActionListener(manejadorDeEventos);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUser.setText("Usuario:");

        lblPwd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPwd.setText("Contraseña:");

        txtUser.setToolTipText("Ingrese su nombre de usuario");

        txtPwd.setToolTipText("Ingrese su contraseña");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/error.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cierra la aplicación");

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/llave.png"))); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setToolTipText("Inicia sesión");

        lblImgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N

        lblImgPwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lock.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(61, 61, 61)
                                                .addComponent(lblImgUser))
                                        .addComponent(lblImgPwd))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(185, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar)
                                .addGap(135, 135, 135)
                                .addComponent(btnIngresar)
                                .addGap(154, 154, 154))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1))
                                        .addComponent(lblImgUser))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblImgPwd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnIngresar))
                                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }



    public void ingresar(){
        String usuario = txtUser.getText();
        String password = txtPwd.getText();

        if(usuarioAcceso.equals(usuario) && passwordAcceso.equals(password)){
            JOptionPane.showMessageDialog(null, "Bienvenido administrador");
            VCompraProductos a = new VCompraProductos();
            a.setVisible(true);
            dispose();
        }else {
            JOptionPane.showMessageDialog(this, "USUARIO O CONTRASEÑA INCORRECTA");
        }
    }


    class ManejadorDeEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnIngresar){
                if(txtPwd.getText().equals("")||txtUser.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Por favor rellene toda la información", "Error",JOptionPane.ERROR_MESSAGE);
                }else {
                    ingresar();
                }
            } else if (e.getSource() == btnCancelar) {
                VMenu a = new VMenu();
                a.setVisible(true);
                dispose();
            }

        }
    }
}
