package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMenu extends JFrame {
    JLabel jlTitulo;
    JButton btnProveedor, btnCliente, btnSalir, btnAdministracion;
    JPanel jpContenido;

    public VMenu(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu");
    }

    private void iniciarComponentes(){
        jpContenido = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        btnProveedor = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnAdministracion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        btnAdministracion.addActionListener(manejadorDeEventos);
        btnCliente.addActionListener(manejadorDeEventos);
        btnProveedor.addActionListener(manejadorDeEventos);
        btnSalir.addActionListener(manejadorDeEventos);

        jpContenido.setBackground(new java.awt.Color(204, 255, 255));

        jlTitulo.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 36)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(153, 255, 153));
        jlTitulo.setText("Supermercado univalle");

        btnProveedor.setFont(new java.awt.Font("Nirmala UI", 3, 18)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(255, 153, 255));
        btnProveedor.setText("Proveedor");

        btnCliente.setFont(new java.awt.Font("Nirmala UI", 3, 18)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 153, 255));
        btnCliente.setText("Cliente");

        btnAdministracion.setFont(new java.awt.Font("Nirmala UI", 3, 18)); // NOI18N
        btnAdministracion.setForeground(new java.awt.Color(255, 153, 255));
        btnAdministracion.setText("Administración");

        btnSalir.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        btnSalir.setText("Salir");

        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jlTitulo)
                                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addGap(184, 184, 184)
                                                .addComponent(btnAdministracion)))
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        jpContenidoLayout.setVerticalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jlTitulo)
                                .addGap(52, 52, 52)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnProveedor)
                                        .addComponent(btnCliente))
                                .addGap(44, 44, 44)
                                .addComponent(btnAdministracion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(btnSalir)
                                .addGap(23, 23, 23))
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

    class ManejadorDeEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnAdministracion){
                VLoginAdmin vLogin = new VLoginAdmin();
                vLogin.setVisible(true);
                dispose();
            } else if (e.getSource() == btnCliente) {
                VLoginCliente vLogin = new VLoginCliente();
                vLogin.setVisible(true);
                dispose();
            } else if (e.getSource() == btnProveedor) {
                VLoginProveedor vLogin = new VLoginProveedor();
                vLogin.setVisible(true);
                dispose();
            } else if (e.getSource() == btnSalir) {
                System.exit(0);
            }
        }
    }
}
