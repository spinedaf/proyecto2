/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacion;

import capaLogica.*;
import java.sql.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pinedas
 */
public class InterfazReparaciones extends javax.swing.JFrame implements Observer, ListSelectionListener {

    private Gestor gestor;
    
    private DefaultTableModel modeloTablaTareas;
    private DefaultTableModel modeloTablaVehiculos;
    private DefaultTableModel modeloTablaOperarios;
    private DefaultTableModel modeloTablaPiezas;
    private DefaultTableModel modeloTablaSalas;
    private DefaultTableModel modeloTablaReparaciones;
    
    private DefaultComboBoxModel<String> modeloCBTareas;
    private DefaultComboBoxModel<String> modeloCBVehiculos;
    private DefaultComboBoxModel<String> modeloCBReparaciones;
    private DefaultComboBoxModel<String> modelosCBsalas;
    
    private DefaultListModel modeloOperariosAsociados;

    /**
     * Creates new form InterfazReparaciones
     */
    public InterfazReparaciones() {
        initComponents();

        iniciarComponentesPropios();
    }

    private void iniciarComponentesPropios() {
        gestor = new Gestor();
        
        modeloCBVehiculos = new DefaultComboBoxModel<String>();
        modeloCBTareas = new DefaultComboBoxModel<String>();
        modeloCBReparaciones = new DefaultComboBoxModel<String>();
        modelosCBsalas = new DefaultComboBoxModel<String>();
        
        modeloOperariosAsociados = new DefaultListModel();
        
        String encabezadosTarea[] = new String[]{"Nombre", "Descripcion", "Fecha creacion","Duracion prop.", "Duracion Real","Cod. Reparacion"};
        modeloTablaTareas = new DefaultTableModel(encabezadosTarea,0);
        String encabezadosVehiculo[] = new String[]{"Numero de placa", "Modelo", "Propietaro", "Estado"};
        modeloTablaVehiculos = new DefaultTableModel(encabezadosVehiculo,0);
        String encabezadosOperarios[] = new String[]{"Nombre","Apellido","Cedula"};
        modeloTablaOperarios = new DefaultTableModel(encabezadosOperarios,0);
        String encabezadosPiezas[] = new String[]{"Codigo","Marca","Pais Fab.", "Problema","Uni. Cambiadas", "Tarea"};
        modeloTablaPiezas = new DefaultTableModel(encabezadosPiezas,0);
        String encabezadosSalas[] = new String[]{"Descripcion","Ubicacion","Capacidad"};
        modeloTablaSalas = new DefaultTableModel(encabezadosSalas,0);
        String encabezadosReparaciones[] = new String[]{"Nombre","Codigo","Tipo"};
        modeloTablaReparaciones = new DefaultTableModel(encabezadosReparaciones,0);
        
        this.jtVehiculos.setModel(modeloTablaVehiculos);
        this.jtOperarios.setModel(modeloTablaOperarios);
        this.jtTareas.setModel(modeloTablaTareas);
        this.jtPiezas.setModel(modeloTablaPiezas);
        this.jtReparaciones.setModel(modeloTablaReparaciones);
        this.jtSalas.setModel(modeloTablaSalas);
        
        this.jcbTareasPieza.setModel(modeloCBTareas);
        this.jcbVehiculoReparacion.setModel(modeloCBVehiculos);
        this.jcbTareaReparacion.setModel(modeloCBReparaciones);
        this.jcbTareaSala.setModel(modelosCBsalas);
        
        this.jlOperariosAsociados.setModel(modeloOperariosAsociados);

        gestor.addObserver(this);

        this.actualizarVistaTabla(modeloTablaVehiculos, gestor.obtenerListaVehiculos());
        this.actualizarVistaTabla(modeloTablaOperarios, gestor.obtenerListaOperarios());
        this.actualizarVistaTabla(modeloTablaPiezas, gestor.obtenerListaPiezas());
        this.actualizarVistaTabla(modeloTablaSalas, gestor.obtenerListaSalas());
        this.actualizarVistaTabla(modeloTablaReparaciones, gestor.obtenerListaReparaciones());
        this.actualizarVistaTabla(modeloTablaTareas, gestor.obtenerListaTareas());
 
        this.actualizarVistaCB(modeloCBVehiculos, gestor.obtenerPlacasVehiculo());
        this.actualizarVistaCB(modeloCBTareas, gestor.obtenerNombresListaTareas());
        this.actualizarVistaCB(modeloCBReparaciones, gestor.obtenerNombresListaReparaciones());
        this.actualizarVistaCB(modelosCBsalas, gestor.obtenerNombresListaSalasDeReparacion());

        this.setJlStatus("");
    }

    public void actualizarVistaLista(DefaultListModel modelo, String[] lista) {
        modelo.clear();
        for (String linea : lista) {
            modelo.addElement(linea);
        }
    }

    public void actualizarVistaCB(DefaultComboBoxModel modelo, String[] lista) {
        modelo.removeAllElements();
        for (String linea : lista) {
            modelo.addElement(linea);
        }
    }
    
    public void actualizarVistaTabla(DefaultTableModel modelo, String[] lista)
    {
        int tamano = modelo.getRowCount();
        for(int i = tamano-1; i >0; i--)
        {
            modelo.removeRow(i);
        }
        
        for(String fila: lista){
            String columnas[] = fila.split(",");
            modelo.addRow(columnas);
        }
    }
    
    public void actualizarVistasCB()
    {
        actualizarVistaCB(this.modeloCBTareas,gestor.obtenerNombresListaTareas());
        actualizarVistaCB(this.modeloCBReparaciones,gestor.obtenerNombresListaReparaciones());
        actualizarVistaCB(this.modeloCBVehiculos,gestor.obtenerPlacasVehiculo());
        actualizarVistaCB(this.modelosCBsalas,gestor.obtenerNombresListaSalasDeReparacion());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlStatus = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jlTareaNombre = new javax.swing.JLabel();
        jlTareaDescripcion = new javax.swing.JLabel();
        jlTareaFechaCreacion = new javax.swing.JLabel();
        lbTareaDuracionPropuesta = new javax.swing.JLabel();
        jlTareaDuracionReal = new javax.swing.JLabel();
        jlReparacion = new javax.swing.JLabel();
        jtfTareNombre = new javax.swing.JTextField();
        jtfTareaDescripcion = new javax.swing.JTextField();
        jtfTareaFechaCreacion = new javax.swing.JFormattedTextField();
        jtfTareaDuracionPropuesta = new javax.swing.JFormattedTextField();
        jtfTareaDuracionReal = new javax.swing.JFormattedTextField();
        jbCrearTarea = new javax.swing.JButton();
        jcbTareaReparacion = new javax.swing.JComboBox();
        jlTarea = new javax.swing.JLabel();
        jcbTareaSala = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtTareas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jsAniosOp = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jtfNombreOperario = new javax.swing.JTextField();
        jtfApellidoOperario = new javax.swing.JTextField();
        jtfDireccionOp = new javax.swing.JTextField();
        jtfCargoOp = new javax.swing.JTextField();
        jtfTelefonoOp = new javax.swing.JFormattedTextField();
        jtfIDOperario = new javax.swing.JFormattedTextField();
        jbCrearOp = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtOperarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jtfCodigoPieza = new javax.swing.JTextField();
        jtfMarcaPieza = new javax.swing.JTextField();
        jtfPaisPieza = new javax.swing.JTextField();
        jtfDescripcionPieza = new javax.swing.JTextField();
        jtfCantidadPieza = new javax.swing.JTextField();
        jtfProblemaPieza = new javax.swing.JTextField();
        jlCodigoPieza = new javax.swing.JLabel();
        jlMarcaPieza = new javax.swing.JLabel();
        jlPaisPieza = new javax.swing.JLabel();
        jlDesPieza = new javax.swing.JLabel();
        jlCanPieza = new javax.swing.JLabel();
        jlProbPieza = new javax.swing.JLabel();
        jbCrearPieza = new javax.swing.JButton();
        jlIdTarea = new javax.swing.JLabel();
        jcbTareasPieza = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtPiezas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jtfDescripcionSala = new javax.swing.JTextField();
        jtfUbicacionSala = new javax.swing.JTextField();
        jsCapacidadSala = new javax.swing.JSpinner();
        jbCrearSala = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtSalas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jcbVehiculoReparacion = new javax.swing.JComboBox();
        jtfFechaReparacion = new javax.swing.JFormattedTextField();
        jtfNombreReparacion = new javax.swing.JTextField();
        jtfCodigoReparacion = new javax.swing.JTextField();
        jbCrearReparacion = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jtfTipoReparacion = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtReparaciones = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbCrearVehiculo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfPlaca = new javax.swing.JTextField();
        jtfModelo = new javax.swing.JTextField();
        jtfNombreProp = new javax.swing.JTextField();
        jtfApellidoProp = new javax.swing.JTextField();
        jtfEstadoVehi = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtVehiculos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlOperariosAsociados = new javax.swing.JList();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlStatus.setText("Hola");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tarea"));

        jlTareaNombre.setText("Nombre:");

        jlTareaDescripcion.setText("Descripción:");

        jlTareaFechaCreacion.setText("Fecha Creación:");

        lbTareaDuracionPropuesta.setText("Propuesta:");

        jlTareaDuracionReal.setText("Real:");

        jlReparacion.setText("Reparacion:");

        jtfTareaFechaCreacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jtfTareaFechaCreacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTareaFechaCreacionKeyTyped(evt);
            }
        });

        jtfTareaDuracionPropuesta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jtfTareaDuracionReal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtfTareaDuracionReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTareaDuracionRealActionPerformed(evt);
            }
        });

        jbCrearTarea.setText("Crear");
        jbCrearTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearTareaActionPerformed(evt);
            }
        });

        jcbTareaReparacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlTarea.setText("Sala:");

        jcbTareaSala.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtTareas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jtTareas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTareaDescripcion)
                            .addComponent(jlTareaNombre)
                            .addComponent(lbTareaDuracionPropuesta)
                            .addComponent(jlTareaDuracionReal)
                            .addComponent(jlReparacion)
                            .addComponent(jlTarea))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfTareaDuracionPropuesta)
                                .addComponent(jtfTareaDuracionReal)
                                .addComponent(jcbTareaReparacion, 0, 111, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfTareaDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(jtfTareNombre))
                            .addComponent(jcbTareaSala, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlTareaFechaCreacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTareaFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbCrearTarea)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTareaNombre)
                            .addComponent(jtfTareNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTareaDescripcion)
                            .addComponent(jtfTareaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTareaFechaCreacion)
                            .addComponent(jtfTareaFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTareaDuracionPropuesta)
                            .addComponent(jtfTareaDuracionPropuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTareaDuracionReal)
                            .addComponent(jtfTareaDuracionReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlReparacion)
                            .addComponent(jcbTareaReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTarea)
                            .addComponent(jcbTareaSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCrearTarea))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tarea", jPanel5);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operario"));

        jLabel6.setText("Nombre:");

        jLabel7.setText("Apellido:");

        jLabel8.setText("ID:");

        jLabel9.setText("Direccion:");

        jLabel10.setText("Teléfono:");

        jLabel11.setText("Cargo:");

        jsAniosOp.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel12.setText("Exp");

        try {
            jtfTelefonoOp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jtfIDOperario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jbCrearOp.setText("Crear");
        jbCrearOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearOpActionPerformed(evt);
            }
        });

        jtOperarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jtOperarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCrearOp)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNombreOperario, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jtfApellidoOperario)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jsAniosOp, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDireccionOp)
                            .addComponent(jtfIDOperario, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jtfTelefonoOp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfCargoOp))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfNombreOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfApellidoOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfIDOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jtfDireccionOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jtfTelefonoOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCargoOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jsAniosOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCrearOp))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Operario", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pieza"));

        jtfCodigoPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoPiezaActionPerformed(evt);
            }
        });

        jlCodigoPieza.setText("Codigo:");

        jlMarcaPieza.setText("Marca:");

        jlPaisPieza.setText("País:");

        jlDesPieza.setText("Descripción:");

        jlCanPieza.setText("Cantidad:");

        jlProbPieza.setText("Problema:");

        jbCrearPieza.setText("Crear");
        jbCrearPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearPiezaActionPerformed(evt);
            }
        });

        jlIdTarea.setText("Tarea:");

        jcbTareasPieza.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtPiezas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jtPiezas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlIdTarea)
                            .addComponent(jlProbPieza)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCodigoPieza)
                            .addComponent(jlMarcaPieza)
                            .addComponent(jlPaisPieza)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlDesPieza)
                                    .addComponent(jlCanPieza))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfCantidadPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfDescripcionPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfProblemaPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbTareasPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfPaisPieza, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addComponent(jtfCodigoPieza, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jtfMarcaPieza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbCrearPieza)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlCodigoPieza)
                                    .addComponent(jtfCodigoPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlMarcaPieza)
                                    .addComponent(jtfMarcaPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jlPaisPieza))
                            .addComponent(jtfPaisPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDesPieza)
                            .addComponent(jtfDescripcionPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCanPieza)
                            .addComponent(jtfCantidadPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlProbPieza)
                            .addComponent(jtfProblemaPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlIdTarea)
                            .addComponent(jcbTareasPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCrearPieza))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pieza", jPanel3);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Sala de Reparacion"));

        jLabel17.setText("Descripcion:");

        jLabel19.setText("Ubicacion:");

        jLabel20.setText("Capacidad:");

        jtfDescripcionSala.setText("jTextField1");

        jtfUbicacionSala.setText("jTextField2");

        jsCapacidadSala.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jbCrearSala.setText("Crear");
        jbCrearSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearSalaActionPerformed(evt);
            }
        });

        jtSalas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtSalas);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfDescripcionSala))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtfUbicacionSala, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addGap(18, 18, 18)
                            .addComponent(jsCapacidadSala, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbCrearSala))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jtfDescripcionSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jtfUbicacionSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jsCapacidadSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCrearSala))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Salas", jPanel7);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Reparacion"));

        jLabel13.setText("Codigo:");

        jLabel14.setText("Nombre:");

        jLabel15.setText("Fecha:");

        jLabel16.setText("Vehiculo:");

        jcbVehiculoReparacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtfFechaReparacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jtfNombreReparacion.setText("jTextField1");

        jtfCodigoReparacion.setText("jTextField2");

        jbCrearReparacion.setText("Crear");
        jbCrearReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearReparacionActionPerformed(evt);
            }
        });

        jLabel18.setText("Tipo:");

        jtfTipoReparacion.setText("jTextField1");

        jtReparaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jtReparaciones);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfFechaReparacion)
                            .addComponent(jtfNombreReparacion)
                            .addComponent(jtfCodigoReparacion, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jcbVehiculoReparacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(37, 37, 37)
                        .addComponent(jtfTipoReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbCrearReparacion))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jtfCodigoReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombreReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jtfTipoReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jtfFechaReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jcbVehiculoReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCrearReparacion))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reparación", jPanel6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehiculo"));

        jbCrearVehiculo.setText("Crear");
        jbCrearVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearVehiculoActionPerformed(evt);
            }
        });

        jLabel1.setText("Placa:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Modelo");

        jLabel4.setText("Apellido:");

        jLabel5.setText("Estado:");

        jtVehiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jtVehiculos);

        jlOperariosAsociados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlOperariosAsociados);

        jLabel21.setText("Operarios Asociados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtfNombreProp))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jtfApellidoProp, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1))
                                        .addGap(10, 10, 10))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jtfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfPlaca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jtfEstadoVehi))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jbCrearVehiculo))))
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtfNombreProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfApellidoProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfEstadoVehi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jbCrearVehiculo)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Vehículo", jPanel1);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehiculo"));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(711, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultas", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearPiezaActionPerformed

        String codigoPieza = this.jtfCodigoPieza.getText();
        String marcaPieza = this.jtfMarcaPieza.getText();
        String paisPieza = this.jtfPaisPieza.getText();
        String descripcionPieza = this.jtfDescripcionPieza.getText();
        int cantidadPieza = Integer.parseInt(this.jtfCantidadPieza.getText());
        String problemaPieza = this.jtfProblemaPieza.getText();
        String nombreTareaPieza = (String) this.jcbTareasPieza.getSelectedItem();
        gestor.AgregarPieza(codigoPieza, marcaPieza, paisPieza,
            descripcionPieza, cantidadPieza, problemaPieza, nombreTareaPieza);
        this.actualizarVistaTabla(modeloTablaPiezas, gestor.obtenerListaPiezas());
        this.actualizarVistaCB(modeloCBTareas, gestor.obtenerNombresListaTareas());
    }//GEN-LAST:event_jbCrearPiezaActionPerformed

    private void jtfCodigoPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoPiezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoPiezaActionPerformed

    private void jbCrearVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearVehiculoActionPerformed

        String placa = this.jtfPlaca.getText();
        String modelo = this.jtfModelo.getText();
        String nombreProp = this.jtfNombreProp.getText();
        String apellidoProp = this.jtfApellidoProp.getText();
        String estado = this.jtfEstadoVehi.getText();
        gestor.agregarVehiculo(placa, modelo, nombreProp, apellidoProp, estado);
        this.actualizarVistaTabla(modeloTablaVehiculos, gestor.obtenerListaVehiculos());
        this.actualizarVistasCB();
    }//GEN-LAST:event_jbCrearVehiculoActionPerformed

    private void jbCrearReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearReparacionActionPerformed
        String codigo = this.jtfCodigoReparacion.getText();
        String nombre = this.jtfNombreReparacion.getText();
        String tipo = this.jtfTipoReparacion.getText();
        java.util.Date fecha = (java.util.Date)this.jtfFechaReparacion.getValue();
        Date fechaSQL = new Date(fecha.getTime());
        String placa = (String)this.jcbVehiculoReparacion.getSelectedItem();

        gestor.agregarReparacion(codigo, nombre, tipo, fechaSQL, placa);
        this.actualizarVistaTabla(modeloTablaReparaciones, gestor.obtenerListaReparaciones());
        this.actualizarVistasCB();
    }//GEN-LAST:event_jbCrearReparacionActionPerformed

    private void jbCrearSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearSalaActionPerformed
        String descripcion = this.jtfDescripcionSala.getText();
        String ubicacion = this.jtfUbicacionSala.getText();
        int capacidad = (int) this.jsCapacidadSala.getValue();
        gestor.agregarSala(descripcion, ubicacion, capacidad);
        this.actualizarVistaTabla(modeloTablaSalas, gestor.obtenerListaSalas());
    }//GEN-LAST:event_jbCrearSalaActionPerformed

    private void jbCrearOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearOpActionPerformed
        String cedula = this.jtfIDOperario.getText();
        String nombre = this.jtfNombreOperario.getText();
        String apellido = this.jtfApellidoOperario.getText();
        String telefono = this.jtfTelefonoOp.getText();
        String direccion = this.jtfDireccionOp.getText();
        int anios = (int) this.jsAniosOp.getValue();
        String cargo = this.jtfCargoOp.getText();
        gestor.agregarOperario(cedula, nombre, apellido, telefono, direccion, anios, cargo);
        this.actualizarVistaTabla(modeloTablaOperarios, gestor.obtenerListaOperarios());
        this.actualizarVistasCB();
    }//GEN-LAST:event_jbCrearOpActionPerformed

    private void jbCrearTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearTareaActionPerformed

        String nombreTarea = this.jtfTareNombre.getText();
        String descripcionTarea = this.jtfTareaDescripcion.getText();
        java.util.Date fecha = (java.util.Date)this.jtfTareaFechaCreacion.getValue();
        Date fechaCreacion = new Date(fecha.getTime());
        int duracionRealTarea = Integer.parseInt(this.jtfTareaDuracionReal.getText());
        int duracionPropuestaTarea = Integer.parseInt(this.jtfTareaDuracionPropuesta.getText());
        String codigoReparacion = (String) this.jcbTareaReparacion.getSelectedItem();
        String nombreSala = (String) this.jcbTareaSala.getSelectedItem();

        gestor.agregarTarea(nombreTarea, descripcionTarea, fechaCreacion,
            duracionRealTarea, duracionPropuestaTarea, codigoReparacion, nombreSala);
        this.actualizarVistaTabla(modeloTablaTareas, gestor.obtenerListaTareas());
        
        this.actualizarVistasCB();
    }//GEN-LAST:event_jbCrearTareaActionPerformed

    private void jtfTareaDuracionRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTareaDuracionRealActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTareaDuracionRealActionPerformed

    private void jtfTareaFechaCreacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTareaFechaCreacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTareaFechaCreacionKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazReparaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazReparaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazReparaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazReparaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazReparaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbCrearOp;
    private javax.swing.JButton jbCrearPieza;
    private javax.swing.JButton jbCrearReparacion;
    private javax.swing.JButton jbCrearSala;
    private javax.swing.JButton jbCrearTarea;
    private javax.swing.JButton jbCrearVehiculo;
    private javax.swing.JComboBox jcbTareaReparacion;
    private javax.swing.JComboBox jcbTareaSala;
    private javax.swing.JComboBox jcbTareasPieza;
    private javax.swing.JComboBox jcbVehiculoReparacion;
    private javax.swing.JLabel jlCanPieza;
    private javax.swing.JLabel jlCodigoPieza;
    private javax.swing.JLabel jlDesPieza;
    private javax.swing.JLabel jlIdTarea;
    private javax.swing.JLabel jlMarcaPieza;
    private javax.swing.JList jlOperariosAsociados;
    private javax.swing.JLabel jlPaisPieza;
    private javax.swing.JLabel jlProbPieza;
    private javax.swing.JLabel jlReparacion;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JLabel jlTarea;
    private javax.swing.JLabel jlTareaDescripcion;
    private javax.swing.JLabel jlTareaDuracionReal;
    private javax.swing.JLabel jlTareaFechaCreacion;
    private javax.swing.JLabel jlTareaNombre;
    private javax.swing.JSpinner jsAniosOp;
    private javax.swing.JSpinner jsCapacidadSala;
    private javax.swing.JTable jtOperarios;
    private javax.swing.JTable jtPiezas;
    private javax.swing.JTable jtReparaciones;
    private javax.swing.JTable jtSalas;
    private javax.swing.JTable jtTareas;
    private javax.swing.JTable jtVehiculos;
    private javax.swing.JTextField jtfApellidoOperario;
    private javax.swing.JTextField jtfApellidoProp;
    private javax.swing.JTextField jtfCantidadPieza;
    private javax.swing.JTextField jtfCargoOp;
    private javax.swing.JTextField jtfCodigoPieza;
    private javax.swing.JTextField jtfCodigoReparacion;
    private javax.swing.JTextField jtfDescripcionPieza;
    private javax.swing.JTextField jtfDescripcionSala;
    private javax.swing.JTextField jtfDireccionOp;
    private javax.swing.JTextField jtfEstadoVehi;
    private javax.swing.JFormattedTextField jtfFechaReparacion;
    private javax.swing.JFormattedTextField jtfIDOperario;
    private javax.swing.JTextField jtfMarcaPieza;
    private javax.swing.JTextField jtfModelo;
    private javax.swing.JTextField jtfNombreOperario;
    private javax.swing.JTextField jtfNombreProp;
    private javax.swing.JTextField jtfNombreReparacion;
    private javax.swing.JTextField jtfPaisPieza;
    private javax.swing.JTextField jtfPlaca;
    private javax.swing.JTextField jtfProblemaPieza;
    private javax.swing.JTextField jtfTareNombre;
    private javax.swing.JTextField jtfTareaDescripcion;
    private javax.swing.JFormattedTextField jtfTareaDuracionPropuesta;
    private javax.swing.JFormattedTextField jtfTareaDuracionReal;
    private javax.swing.JFormattedTextField jtfTareaFechaCreacion;
    private javax.swing.JFormattedTextField jtfTelefonoOp;
    private javax.swing.JTextField jtfTipoReparacion;
    private javax.swing.JTextField jtfUbicacionSala;
    private javax.swing.JLabel lbTareaDuracionPropuesta;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jlStatus
     */
    public String getJlStatus() {
        return jlStatus.getText();
    }

    /**
     * @param mensaje
     */
    public void setJlStatus(String mensaje) {
        this.jlStatus.setText(mensaje);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setJlStatus((String) arg);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource() == this.jtOperarios.getSelectionModel())
        {
            
        }
    }
}
