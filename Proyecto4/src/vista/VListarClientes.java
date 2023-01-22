package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VListarClientes extends JFrame {

    JLabel jLabel1, jLabel3, jpPedirId;
    JButton btnBuscar, btnEliminar, btnModificar, btnSalir;
    JTable tablaClientes;
    JScrollPane jScrollPane1;
    JTextField txtId;
    JPanel jpContenido;

    public VListarClientes(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        this.setTitle("Lista de pacientes");
    }

    private void iniciarComponentes(){
        jpContenido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jpPedirId = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        btnBuscar.addActionListener(manejadorDeEventos);
        btnEliminar.addActionListener(manejadorDeEventos);
        btnModificar.addActionListener(manejadorDeEventos);
        btnSalir.addActionListener(manejadorDeEventos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setText("Clientes");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        txtId.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        jpPedirId.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jpPedirId.setText("Número de identificación");

        btnBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnBuscar.setText("Buscar");

        btnEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");

        btnModificar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnModificar.setText("Modificar");

        tablaClientes.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaClientes);

        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnSalir.setText("Salir");

        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                                .addComponent(jpPedirId)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(btnBuscar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnEliminar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnModificar)))
                                .addContainerGap(23, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(305, 305, 305))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                                                .addComponent(btnSalir)
                                                .addGap(57, 57, 57))))
                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel3)
                                        .addContainerGap(420, Short.MAX_VALUE)))
        );
        jpContenidoLayout.setVerticalGroup(
                jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpContenidoLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45)
                                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jpPedirId)
                                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnBuscar)
                                                .addComponent(btnEliminar)
                                                .addComponent(btnModificar)))
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(btnSalir)
                                .addGap(17, 17, 17))
                        .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpContenidoLayout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(jLabel3)
                                        .addContainerGap(585, Short.MAX_VALUE)))
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
                                .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }


    class ManejadorDeEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
