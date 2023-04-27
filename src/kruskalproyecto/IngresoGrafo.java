/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kruskalproyecto;

import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class IngresoGrafo extends javax.swing.JFrame {

    private int total;

    public IngresoGrafo() {
        initComponents();

    }
    public int i = 0;

    private final int MAX = 1005;

    private int padre[] = new int[MAX];

    private void MakeSet(int n) {
        for (int i = 1; i <= n; ++i) {
            padre[i] = i;
        }
    }

    //Método para encontrar la raiz del vértice actual 
    private int Find(int x) {
        return (x == padre[x]) ? x : (padre[x] = Find(padre[x]));
    }

    //Método para unir 2 componentes conexas
    private void Union(int x, int y) {
        padre[Find(x)] = Find(y);
    }

    //Método que me determina si 2 vértices estan o no en la misma componente conexa
    private boolean sameComponent(int x, int y) {
        if (Find(x) == Find(y)) {
            return true;
        }
        return false;
    }

    private int V, E;      //numero de vertices y aristas

    private Edge arista[] = new Edge[MAX];      //Arreglo de aristas para el uso en kruskal
    private Edge MST[] = new Edge[MAX];

    private void KruskalMST() {
        int origen, destino, peso;

        int numAristas = 0;

        MakeSet(V);           //Inicializamos cada componente
        Arrays.sort(arista, 0, E, new Edge());    //Ordenamos las aristas por su comparador

        for (int i = 0; i < E; ++i) {
            if (arista[i] != null) {
                origen = arista[i].origen;
                destino = arista[i].destino;
                peso = arista[i].peso;        //Peso de la arista actual

                
                if (!sameComponent(origen, destino)) {
                    this.total += peso;
                    MST[numAristas++] = arista[i];
                    Union(origen, destino);  //Union de ambas componentes en una sola
                }
            }
        }

        //Si el Aebol encontrado no posee todos los vértices mostramos mensaje de error
        if (V - 1 != numAristas) {
            mensaje("No existe Arbol valido para el grafo ingresado, el grafo debe ser conexo.");
            throw new NullPointerException();

        }

        for (int i = 0; i < numAristas; ++i) {
            llenarTabla(numAristas);

        }
        if(total==0){
            mensaje("No existe Arbol valido para el grafo ingresado, el grafo debe ser conexo.");
        }else{
        totalLabel.setText(" " + total);
        System.out.println(total);
        }
    }

    private void ingresarGrafo() {

        if (i < E) {
            arista[i] = new Edge();

            arista[i].origen = Integer.parseInt(OrigenTxt.getText());

            arista[i].destino = Integer.parseInt(DestinoTxt.getText());

            arista[i].peso = Integer.parseInt(PesoTxt.getText());
            i++;
        }
    }

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    DefaultTableModel modelo;

    private void llenarTabla(int numAristas) {
        this.verticesTabla.removeAll();
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Vertices");

        for (int i = 0; i < numAristas; i++) {
            if (MST[i].origen != 0) {
                addRowTable("(" + MST[i].origen + " , " + MST[i].destino + ") :  " + MST[i].peso);
            }
        }

        this.verticesTabla.setModel(modelo);

    }

    private void addRowTable(String vert) {
        modelo.addRow(new Object[]{vert});
        this.verticesTabla.setModel(modelo);
    }

    public void vaciarVector(Edge[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = null;
        }
    }

    public void vaciarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = 0;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verticeNumTxt4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        verticeNumTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AristasNumTxt = new javax.swing.JTextField();
        OrigenTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DestinoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PesoTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        agregarVerticesAristas = new javax.swing.JButton();
        AgregarPesoBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        verticesTabla = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel5.setText("Arista de destino");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        verticeNumTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                verticeNumTxtKeyTyped(evt);
            }
        });

        jLabel1.setText("Ingrese el numero de vertices del grafo");

        jLabel2.setText("Ingrese el numero de aristas del grafo");

        AristasNumTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AristasNumTxtActionPerformed(evt);
            }
        });
        AristasNumTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AristasNumTxtKeyTyped(evt);
            }
        });

        OrigenTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OrigenTxtKeyTyped(evt);
            }
        });

        jLabel3.setText("Vertice de origen");

        DestinoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinoTxtActionPerformed(evt);
            }
        });
        DestinoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DestinoTxtKeyTyped(evt);
            }
        });

        jLabel4.setText("Vertice de destino");

        PesoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PesoTxtKeyTyped(evt);
            }
        });

        jLabel6.setText("peso ");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Total: ");

        totalLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalLabel.setText("El costo minimo de todas las aristas es :");

        agregarVerticesAristas.setText("Agregar grafo");
        agregarVerticesAristas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarVerticesAristasActionPerformed(evt);
            }
        });

        AgregarPesoBtn.setText("Agregar arista");
        AgregarPesoBtn.setEnabled(false);
        AgregarPesoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPesoBtnActionPerformed(evt);
            }
        });

        verticesTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(verticesTabla);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ARBOL ");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ALGORITMO DE KRUSKAL");

        jLabel10.setText("-->");

        jLabel11.setFont(new java.awt.Font("sansserif", 2, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nota: Los vertices solamente pueden ser numeros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(OrigenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DestinoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(64, 64, 64)
                                            .addComponent(jLabel6)
                                            .addGap(194, 194, 194))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(PesoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(AgregarPesoBtn)
                                            .addGap(6, 6, 6))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalLabel)
                                .addGap(111, 111, 111))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(verticeNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(AristasNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86)
                                        .addComponent(agregarVerticesAristas)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(verticeNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AristasNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregarVerticesAristas))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DestinoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PesoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AgregarPesoBtn))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(OrigenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalLabel)
                            .addComponent(jLabel7))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarVerticesAristasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarVerticesAristasActionPerformed
        // TODO add your handling code here:
        if (camposLLenosNumVerticesAristas()) {
            V = Integer.parseInt(verticeNumTxt.getText());
            E = Integer.parseInt(AristasNumTxt.getText());
            AgregarPesoBtn.setEnabled(true);
            verticeNumTxt.setEnabled(false);
            AristasNumTxt.setEnabled(false);
            agregarVerticesAristas.setEnabled(false);
        }
    }//GEN-LAST:event_agregarVerticesAristasActionPerformed

    private void AgregarPesoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPesoBtnActionPerformed
        // TODO add your handling code here:
        if (camposLLenosParaCalculoPesos()) {
            ingresarGrafo();
            if (i == E) {
                try {
                    KruskalMST();
                } catch (Exception e) {
                    mensaje("Error!");
                    System.out.println(e);
                    e.printStackTrace();
                } finally {
                    agregarVerticesAristas.setEnabled(true);
                    verticeNumTxt.setEnabled(true);
                    AristasNumTxt.setEnabled(true);
                    verticeNumTxt.setText("");
                    AristasNumTxt.setText("");
                    OrigenTxt.setText("");
                    DestinoTxt.setText("");
                    PesoTxt.setText("");
                    vaciarVector(arista);
                    vaciarVector(MST);
                    vaciarVector(padre);
                    this.total = 0;
                    this.V = 0;
                    this.E = 0;
                    this.i = 0;
                }

            }
        }


    }//GEN-LAST:event_AgregarPesoBtnActionPerformed

    private void DestinoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DestinoTxtActionPerformed

    private void verticeNumTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verticeNumTxtKeyTyped
        // TODO add your handling code here:

        soloNumeros(evt, verticeNumTxt);

    }//GEN-LAST:event_verticeNumTxtKeyTyped

    private void AristasNumTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AristasNumTxtActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_AristasNumTxtActionPerformed

    private void AristasNumTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AristasNumTxtKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt, AristasNumTxt);
    }//GEN-LAST:event_AristasNumTxtKeyTyped

    private void OrigenTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OrigenTxtKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt, OrigenTxt);
    }//GEN-LAST:event_OrigenTxtKeyTyped

    private void DestinoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DestinoTxtKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt, DestinoTxt);
    }//GEN-LAST:event_DestinoTxtKeyTyped

    private void PesoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesoTxtKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt, PesoTxt);
    }//GEN-LAST:event_PesoTxtKeyTyped

    private void soloNumeros(java.awt.event.KeyEvent evt, JTextField text) {
        char C = evt.getKeyChar();

        if (Character.isLetter(C)) {

            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            text.setCursor(null);

        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47 || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96 || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {

            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "ingrese solo numeros");
            text.setCursor(null);

        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoGrafo().setVisible(true);
            }
        });
    }

    private boolean camposLLenosNumVerticesAristas() {
        //Validar si los campos estan llenos para pasar a agregar el peso de cada una de las aristas
        String msj = "";

        if (verticeNumTxt.getText().isEmpty() || Integer.parseInt(verticeNumTxt.getText()) <= 0) {
            msj += "Numero de vertices obligatorios\n";
        }
        if (AristasNumTxt.getText().isEmpty() || Integer.parseInt(AristasNumTxt.getText()) <= 0) {
            msj += "Numero de aristas obligatorias\n";
        }

        if (!msj.equals("")) {
            mensaje(msj);
            return false;
        }
        return true;

    }

    private boolean camposLLenosParaCalculoPesos() {
        //Validar si los campos de los vertices de destino, de origen estan llenos y de peso esten llenos
        String msj = "";

        if (OrigenTxt.getText().isEmpty()) {
            msj += "Vertice de origen obligatorio\n";
        }
        if (DestinoTxt.getText().isEmpty()) {
            msj += "Vertice de destino obligatorio\n";
        }
        if (PesoTxt.getText().isEmpty() || Integer.parseInt(PesoTxt.getText()) <= 0) {
            msj += "Peso obligatorio\n";
        }

        if (!msj.equals("")) {
            mensaje(msj);
            return false;
        }
        return true;

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarPesoBtn;
    private javax.swing.JTextField AristasNumTxt;
    private javax.swing.JTextField DestinoTxt;
    private javax.swing.JTextField OrigenTxt;
    private javax.swing.JTextField PesoTxt;
    private javax.swing.JButton agregarVerticesAristas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField verticeNumTxt;
    private javax.swing.JTextField verticeNumTxt4;
    private javax.swing.JTable verticesTabla;
    // End of variables declaration//GEN-END:variables
}
