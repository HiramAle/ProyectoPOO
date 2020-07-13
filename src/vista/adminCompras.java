package vista;

import javax.swing.JOptionPane;
import controlador.ConsultasProductoProvedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import modelo.Compra;
import java.util.Date;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

/**
 *
 * @author magic
 */
public class adminCompras extends javax.swing.JFrame {
    
    //Crea variables para el carrito de compras
    private int idProd = 0;
    private ArrayList<Double> total = new ArrayList<Double>();
    private ArrayList<Producto> productoCarrito = new ArrayList<Producto>();
    private ArrayList<String> cantidadCarrito = new ArrayList<String>();
    double totalMonto = 0;
    //Variables para la obtencion de la fecha de la pestaña de Registro
    private Calendar cal = Calendar.getInstance();
    private DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form adminCompras
     */
    public adminCompras() {
        //Inicializa los componentes
        initComponents();
        //Establece el título
        this.setTitle("Compras");
        //Escribe la fecha en el jText de la fecha de la pestaña de Registro
        txtFechaCompra.setText(formato.format(cal.getTime()).toString());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choice1 = new java.awt.Choice();
        jTextField7 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        txtFechaCompra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        txtIdCompraR = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCantidadCompra = new javax.swing.JTextField();
        btnAñadirCompra = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCarrito = new javax.swing.JTable();
        txtMontoCompra = new javax.swing.JTextField();
        txtRegistrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdCompra = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtMonto = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();

        jTextField7.setText("jTextField7");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id Compra");

        jLabel3.setText("Fecha");

        jLabel4.setText("Monto Total");

        jLabel6.setText("Proveedor");

        jLabel9.setText("Productos");

        txtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProveedorKeyTyped(evt);
            }
        });

        btnBuscarProveedor.setText("Buscar");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        txtFechaCompra.setEditable(false);
        txtFechaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaCompraActionPerformed(evt);
            }
        });

        tableProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Producto", "Marca", "Descripcion", "Precio Compra", "Existencias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProductos);

        txtIdCompraR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdCompraRKeyTyped(evt);
            }
        });

        jLabel10.setText("Cantidad");

        txtCantidadCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadCompraKeyTyped(evt);
            }
        });

        btnAñadirCompra.setText("Añadir");
        btnAñadirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirCompraActionPerformed(evt);
            }
        });

        tableCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Producto", "Marca", "Descripcion", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableCarrito);

        txtMontoCompra.setEditable(false);

        txtRegistrar.setText("Registrar Compra");
        txtRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdCompraR, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(txtFechaCompra))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarProveedor))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(jLabel10)
                                .addGap(29, 29, 29)
                                .addComponent(txtCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAñadirCompra))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtMontoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(txtRegistrar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCompraR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProveedor))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAñadirCompra)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMontoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegistrar)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(277, 277, 277))
        );

        jTabbedPane1.addTab("Registrar Compra", jPanel1);

        jLabel2.setText("Id Compra");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha");

        jLabel7.setText("Monto");

        jLabel8.setText("Productos");

        txtFecha.setEditable(false);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Producto", "Marca", "Descripcion", "Precio Compra", "Precio Mayoreo", "Precio Menudeo", "Existencias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        txtMonto.setEditable(false);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdCompra)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(txtMonto))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar Compra", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtIdCompra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Ingresa un ID"); //Valida que el campo no esté vacío
        } else {
            ConsultasProductoProvedor buscar = new ConsultasProductoProvedor();
            try {
                //Establece la fecha de compra en la pestaña de Consulta
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Compra compra = buscar.consultaCompra(Integer.parseInt(txtIdCompra.getText()));
                txtFecha.setText(dateFormat.format(compra.getFecha()));
                txtMonto.setText("$ " + compra.getMonto());
                //Establece el modelo de la tabla para que no sea editable
                DefaultTableModel modelo = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                //Aplica el modelo
                tblProductos.setModel(modelo);
                //Pone los encabezados de las columnas
                modelo.addColumn("Id Producto");
                modelo.addColumn("Marca");
                modelo.addColumn("Descripcion");
                modelo.addColumn("Precio de Compra");
                modelo.addColumn("Venta mayoreo");
                modelo.addColumn("Venta menudeo");
                modelo.addColumn("Existencias");
                //Crea un arreglo de objetos para las filas
                Object[] o = null;
                //Rellena las filas
                for (int i = 0; i < compra.getPds().size(); i++) {
                    modelo.addRow(o);
                    modelo.setValueAt(compra.getPds().get(i).getId(), i, 0);
                    modelo.setValueAt(compra.getPds().get(i).getMarca(), i, 1);
                    modelo.setValueAt(compra.getPds().get(i).getDescripcion(), i, 2);
                    modelo.setValueAt(compra.getPds().get(i).getPrecioCompra(), i, 3);
                    modelo.setValueAt(compra.getPds().get(i).getPrecioVentaMayoreo(), i, 4);
                    modelo.setValueAt(compra.getPds().get(i).getPrecioVentaMenudeo(), i, 5);
                    modelo.setValueAt(compra.getPds().get(i).getExistencias(), i, 6);
                }
            } catch (NullPointerException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "No existe Compra con ese ID");
            } finally {

            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //Limpia los campos
        txtIdCompra.setText("");
        txtFecha.setText("");
        txtFecha.setText("");
        txtMonto.setText("");
        //Establece el modelo para que la tabla no sea editable
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //Aplica el modelo a la tabla
        tblProductos.setModel(modelo);
        //Pone los encabezados de las columnas
        modelo.addColumn("Id Producto");
        modelo.addColumn("Marca");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio de Compra");
        modelo.addColumn("Venta mayoreo");
        modelo.addColumn("Venta menudeo");
        modelo.addColumn("Existencias");
        //Elimina todas las filas
        modelo.setRowCount(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        if (txtProveedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo de proveedor"); //Valida que los campos estén llenos
        } else {
            try {
                ConsultasProductoProvedor buscar = new ConsultasProductoProvedor();
                ArrayList<Producto> pds = new ArrayList<Producto>();
                pds = buscar.arrayProductos(Integer.parseInt(txtProveedor.getText()));
                if (pds.isEmpty()) {  //Revisa que esté vacío
                    JOptionPane.showMessageDialog(null, "No existe Compra con ese ID");
                    //Establece el modelo de la tabla para que no sea editable
                    DefaultTableModel modelo = new DefaultTableModel(){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    //Aplica el modelo a la tabl
                    tableProductos.setModel(modelo);
                    //Establece el nombre de las columnas
                    modelo.addColumn("Id Producto");
                    modelo.addColumn("Marca");
                    modelo.addColumn("Descripcion");
                    modelo.addColumn("Precio de Compra");
                    modelo.addColumn("Existencias");
                } else {
                    //Establece el modelo de la tabla para que no sea editable
                    DefaultTableModel modelo = new DefaultTableModel() {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    //Establece el modelo de la tabla
                    tableProductos.setModel(modelo);
                    //Establece las columnas de la tabla
                    modelo.addColumn("Id Producto");
                    modelo.addColumn("Marca");
                    modelo.addColumn("Descripcion");
                    modelo.addColumn("Precio de Compra");
                    modelo.addColumn("Existencias");
                    //Crea un arreglo de objetos para llenar la tabla
                    Object[] o = null;
                    //Llena la tabla con las filas
                    for (int i = 0; i < pds.size(); i++) {
                        modelo.addRow(o);
                        modelo.setValueAt(pds.get(i).getId(), i, 0);
                        modelo.setValueAt(pds.get(i).getMarca(), i, 1);
                        modelo.setValueAt(pds.get(i).getDescripcion(), i, 2);
                        modelo.setValueAt(pds.get(i).getPrecioCompra(), i, 3);
                        modelo.setValueAt(pds.get(i).getExistencias(), i, 4);
                    }
                }

            } catch (NullPointerException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "No existe Compra con ese ID");
            }
        }
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed


    private void tableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductosMouseClicked
        //Averigua en qué fila se hizo click
        if (tableProductos != null && tableProductos.getModel() != null) { //Revisa que la tabla no esté vacía
            //Obtiene el numero de la fila y de la columna
            int row = tableProductos.rowAtPoint(evt.getPoint());
            int col = tableProductos.columnAtPoint(evt.getPoint());
            if (tableProductos.getValueAt(row, col) != null) {
                String st = tableProductos.getModel().getValueAt(row, 0).toString();
                System.out.println(st);
                idProd = Integer.parseInt(st);
            }

        }


    }//GEN-LAST:event_tableProductosMouseClicked

    private void btnAñadirCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirCompraActionPerformed
        if (txtCantidadCompra.getText().isEmpty() || Integer.parseInt(txtCantidadCompra.getText()) == 0 || idProd == 0) { //Verifica que los campos estén llenos
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            ConsultasProductoProvedor buscar = new ConsultasProductoProvedor();
            Producto pr = new Producto();
            //Busca y mapea el producto
            pr = buscar.consultaProducto(idProd);
            //Añade el producto al carrito de compras
            productoCarrito.add(pr);
            //Calcula el total de cada compra multiplicando el precio por la cantidad
            total.add((pr.getPrecioCompra() * Double.parseDouble(txtCantidadCompra.getText())));
            //Añade la cantidad productos al arreglo del carrito de compras
            cantidadCarrito.add(txtCantidadCompra.getText());
            //Crea la Tabla con un modelo para que no sea editable
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            //Aplica el modelo
            tableCarrito.setModel(modelo);
            //Crea las columnas de la tabla
            modelo.addColumn("Id Producto");
            modelo.addColumn("Marca");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Total");
            //Crea un arreglo de objetos para las filas de la tabla
            Object[] o = null;
            //Llena la tabla con las filas
            for (int i = 0; i < productoCarrito.size(); i++) {
                modelo.addRow(o);
                modelo.setValueAt(productoCarrito.get(i).getId(), i, 0);
                modelo.setValueAt(productoCarrito.get(i).getMarca(), i, 1);
                modelo.setValueAt(productoCarrito.get(i).getDescripcion(), i, 2);
                modelo.setValueAt("$" + total.get(i), i, 3);
            }
            //Calcula el total de la compra con base a el precio de los productos
            for (int i = 0; i < total.size(); i++) {
                totalMonto += total.get(i);
            }
            //Pone el total en el jText
            txtMontoCompra.setText("$ " + Double.toString(totalMonto));
        }

    }//GEN-LAST:event_btnAñadirCompraActionPerformed

    private void txtRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistrarActionPerformed
        ConsultasProductoProvedor registro = new ConsultasProductoProvedor();
        if (txtIdCompraR.getText().isEmpty()) { //Verifica que los campos estén llenos
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            try {
                //Crea variables de fecha para guardar los datos en la Base
                java.util.Date date = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                if (registro.altaCompra(Integer.parseInt(txtIdCompraR.getText()), sqlDate, totalMonto)) { // Verifica el Alta
                    for (int i = 0; i < productoCarrito.size(); i++) { //Hace el alta de la relacion Compra-Producto 
                        registro.altaCompraProducto(Integer.parseInt(txtIdCompraR.getText()), Integer.parseInt(cantidadCarrito.get(i)), productoCarrito.get(i).getId());
                        registro.actualizarExistencias(productoCarrito.get(i).getExistencias() + Integer.parseInt(cantidadCarrito.get(i)), productoCarrito.get(i).getId());
                    }
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                }
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_txtRegistrarActionPerformed

    private void txtIdCompraRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCompraRKeyTyped
        char validar = evt.getKeyChar();
        //Verifica que solo se usen numeros
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingresar solo numeros");
        }
    }//GEN-LAST:event_txtIdCompraRKeyTyped

    private void txtProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorKeyTyped
        char validar = evt.getKeyChar();
        //Verifica que solo se usen numeros
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingresar solo numeros");
        }
    }//GEN-LAST:event_txtProveedorKeyTyped

    private void txtCantidadCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCompraKeyTyped
        char validar = evt.getKeyChar();
        //Verifica que solo se usen numeros
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingresar solo numeros");
        }
    }//GEN-LAST:event_txtCantidadCompraKeyTyped

    private void txtFechaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaCompraActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirCompra;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnLimpiar;
    private java.awt.Choice choice1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTable tableCarrito;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCantidadCompra;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaCompra;
    private javax.swing.JTextField txtIdCompra;
    private javax.swing.JTextField txtIdCompraR;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMontoCompra;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JButton txtRegistrar;
    // End of variables declaration//GEN-END:variables
}
