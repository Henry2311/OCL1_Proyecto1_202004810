
package olc1.proyecto1_202004810;

import analizadores.Analizador_Lexico;
import analizadores.Analizador_sintactico;
import analizadores.TError;
import analizadores.Token;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class app extends javax.swing.JFrame {

    
    
    static String file="";
            File archivo = null;
            FileReader fr;
            BufferedReader br;
            String ruta="";
            String filename="";
            LinkedList<conjuntos> conj = new LinkedList<>();
            LinkedList<expresion> er = new LinkedList<>();
            LinkedList<validacion> val = new LinkedList<>();
            int contador_img = 0;
            
    public app() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Entrada");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Salida");

        button1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button1.setLabel("Generar Autómatas");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button2.setLabel("Analizar Entrada");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Documentos");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ARBOLES_202004810");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("PRUEBA");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("AFND_202004810");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("basketball");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("SIGUIENTES_202004810");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("PRUEBA");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("TRANSICIONES_202004810");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("PRUEBA");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("AFD_202004810");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("PRUEBA");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ERRORES_202004810");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("PRUEBA");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("SALIDAS_202004810");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("PRUEBA");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree2.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane4.setViewportView(jTree2);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Ver imagenes");

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Arboles", "Siguientes", "Transiciones", "AFD", "AFND" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(240, 240, 240));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 240, 240));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Anterior");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem5.setText("Nuevo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem3.setText("Guardar Como");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem4.setText("Generar JSON de salida");
        jMenuItem4.setToolTipText("");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(553, 553, 553)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(642, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(359, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try{
            this.jTextArea1.setText("");
            this.jTextArea2.setText("");
            er.clear();
            conj.clear();
            val.clear();
            ruta="";
            filename="";
            archivo=null;
            file="";
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                ruta=fc.getSelectedFile().getAbsolutePath();
                archivo = fc.getSelectedFile();
                String nombre = fc.getSelectedFile().getName();
                filename = nombre.replaceAll(".exp", "");
            }
            
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                file += "\n"+linea;
            }
            this.jTextArea2.setText(file);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if("".equals(ruta)){
            save();
        }else{
            FileWriter reporte1 = null;
            PrintWriter pw = null;
            try{
                reporte1 = new FileWriter(ruta);
                pw = new PrintWriter(reporte1);
                String contenido = this.jTextArea2.getText();
                pw.println(contenido);
                }catch(Exception e){
                            e.printStackTrace();
                }finally{
                    try{       
                        if(null != reporte1){
                            reporte1.close();
                        }
                    }catch(Exception e2){
                        e2.printStackTrace();
                    }
                }
            JOptionPane.showMessageDialog(this, "Archivo guardado correctamente");
            try {
                fr = new FileReader(ruta);
                br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    file += "\n"+linea;
                }
                this.jTextArea2.setText(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        String contenido = this.jTextArea2.getText();
        if("".equals(contenido)){
            JOptionPane.showMessageDialog(this, "No hay Contenido para analizar");
        }else{
            try{
                if("".equals(ruta)){
                    JOptionPane.showMessageDialog(this, "Guarde el archivo");
                }else if(file.length() != contenido.length()){
                    JOptionPane.showMessageDialog(this, "Guarde los cambios realizados");
                }else{
                    Analizador_Lexico lexico = new Analizador_Lexico(
                                        new BufferedReader(new FileReader(ruta)));
                    Analizador_sintactico sintactico = new Analizador_sintactico(lexico);
                    sintactico.parse();
                    Datos(sintactico);
                    JOptionPane.showMessageDialog(this, "Se ha generado los autómatas correctamente");
                    if(!sintactico.errores.isEmpty() || !lexico.errores.isEmpty()){
                        reporte(lexico.errores,sintactico.errores);
                        JOptionPane.showMessageDialog(this, "Se ha generado un archivo de errores");
                    }
                    
                    
                }
            }catch(Exception e){   
                e.printStackTrace();
            }
            
        } 
    }//GEN-LAST:event_button1ActionPerformed

    public void Datos(Analizador_sintactico syntax){
    
        Token prueba [] = new Token[syntax.tokens.size()];
        int k=0;
        for (Token t : syntax.tokens) {
            prueba[k] = t;
            k++;
        }
            
            
        Token aux;
        for (int i = 0; i < prueba.length-1; i++) {
            for (int j = 0; j < prueba.length-1; j++) {
                if(prueba[j].getLinea()>prueba[j+1].getLinea()){
                    aux=prueba[j];
                    prueba[j]=prueba[j+1];
                    prueba[j+1]=aux;
                 
                }
            }
        }
        for (int i = 0; i < prueba.length-1; i++) {
            for (int j = 0; j < prueba.length-1; j++) {
                if(prueba[j].getColumna()>prueba[j+1].getColumna() && prueba[j].getLinea()==prueba[j+1].getLinea()){
                    aux=prueba[j];
                    prueba[j]=prueba[j+1];
                    prueba[j+1]=aux;
                }
            }
        }
            
        int j = 0;
        while(j<prueba.length){
            if("conj".equals(prueba[j].getTipo())){
                int emp = j+2;
                int r = emp+2;
                String rango = "";
                for (int i = r; i < prueba.length; i++) {
                    if("puntoycoma".equals(prueba[i].getTipo())){j=i;break;}
                    else{
                        rango+=prueba[i].getLexema();
                        }
                }
                conjuntos nuevo = new conjuntos(prueba[emp].getLexema(),rango);
                conj.add(nuevo);
            }else if("id".equals(prueba[j].getTipo()) && "flecha".equals(prueba[j+1].getTipo())){
                int exp = j+2;
                String rango="";
                for (int i = exp; i < prueba.length; i++) {
                    if("puntoycoma".equals(prueba[i].getTipo())){j=i;break;}
                    else{
                        rango+=prueba[i].getLexema()+',';
                        }
                }
                rango=rango.replaceAll("\\{,","{");
                rango=rango.replaceAll(",}","}");
                String range[];
                range = rango.split(",");
                expresion nuevo = new expresion(prueba[exp-2].getLexema(),range);
                er.add(nuevo);
            }else if("id".equals(prueba[j].getTipo()) && "dospuntos".equals(prueba[j+1].getTipo())){
                validacion nuevo = new validacion(prueba[j].getLexema(),prueba[j+2].getLexema());
                val.add(nuevo);
            }
            j++;
        }
        
        for (expresion t : er) {
            t.graph();
        }
        
    }
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here: 
            er.clear();
            conj.clear();
            val.clear();
            ruta="";
            filename="";
            archivo=null;
            file="";
            this.jTextArea1.setText("");
            this.jTextArea2.setText("");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        if(er.isEmpty() || conj.isEmpty() || val.isEmpty()){
            JOptionPane.showMessageDialog(this, "No se han generado autómatas");
        }else{
            Analizar();
            
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //siguiente
        if(contador_img<er.size()-1){
        String seleccion = (String)jComboBox1.getSelectedItem();
        if(null != seleccion && !er.isEmpty())switch (seleccion) {
            case "Arboles":
                contador_img++;
                ImageIcon img = new ImageIcon("ARBOLES_202004810\\Arbol"+er.get(contador_img).getNombre()+".png");
                Image nuevo = img.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render = new ImageIcon(nuevo);
                jLabel5.setIcon(render);
                break;
            case "Siguientes":
                contador_img++;
                ImageIcon img2 = new ImageIcon("SIGUIENTES_202004810\\Siguientes"+er.get(contador_img).getNombre()+".png");
                Image nuevo2 = img2.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render2 = new ImageIcon(nuevo2);
                jLabel5.setIcon(render2);
                break;
            case "Transiciones":
                contador_img++;
                ImageIcon img3 = new ImageIcon("TRANSICIONES_202004810\\Transiciones"+er.get(contador_img).getNombre()+".png");
                Image nuevo3 = img3.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render3 = new ImageIcon(nuevo3);
                jLabel5.setIcon(render3);
                break;
            case "AFD":
                contador_img++;
                ImageIcon img4 = new ImageIcon("AFD_202004810\\AFD"+er.get(contador_img).getNombre()+".png");
                Image nuevo4 = img4.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render4 = new ImageIcon(nuevo4);
                jLabel5.setIcon(render4);
                break;
            case "AFND":
                contador_img++;
                ImageIcon img5 = new ImageIcon("AFND_202004810\\AFND"+er.get(contador_img).getNombre()+".png");
                Image nuevo5 = img5.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render5 = new ImageIcon(nuevo5);
                jLabel5.setIcon(render5);
                break;
            default:
                break;
        }else{
            JOptionPane.showMessageDialog(this, "No se han generado autómatas");
        }
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //anterior
        if(contador_img>0){
        String seleccion = (String)jComboBox1.getSelectedItem();
        if(null != seleccion && !er.isEmpty())switch (seleccion) {
            case "Arboles":
                contador_img--;
                ImageIcon img = new ImageIcon("ARBOLES_202004810\\Arbol"+er.get(contador_img).getNombre()+".png");
                Image nuevo = img.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render = new ImageIcon(nuevo);
                jLabel5.setIcon(render);
                break;
            case "Siguientes":
                contador_img--;
                ImageIcon img2 = new ImageIcon("SIGUIENTES_202004810\\Siguientes"+er.get(contador_img).getNombre()+".png");
                Image nuevo2 = img2.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render2 = new ImageIcon(nuevo2);
                jLabel5.setIcon(render2);
                break;
            case "Transiciones":
                contador_img--;
                ImageIcon img3 = new ImageIcon("TRANSICIONES_202004810\\Transiciones"+er.get(contador_img).getNombre()+".png");
                Image nuevo3 = img3.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render3 = new ImageIcon(nuevo3);
                jLabel5.setIcon(render3);
                break;
            case "AFD":
                contador_img--;
                ImageIcon img4 = new ImageIcon("AFD_202004810\\AFD"+er.get(contador_img).getNombre()+".png");
                Image nuevo4 = img4.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render4 = new ImageIcon(nuevo4);
                jLabel5.setIcon(render4);
                break;
            case "AFND":
                contador_img--;
                ImageIcon img5 = new ImageIcon("AFND_202004810\\AFND"+er.get(contador_img).getNombre()+".png");
                Image nuevo5 = img5.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render5 = new ImageIcon(nuevo5);
                jLabel5.setIcon(render5);
                break;
            default:
                break;
        }else{
            JOptionPane.showMessageDialog(this, "No se han generado autómatas");
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String seleccion = (String)jComboBox1.getSelectedItem();
        if(null != seleccion && !er.isEmpty())switch (seleccion) {
            case "Arboles":
                contador_img=0;
                ImageIcon img = new ImageIcon("ARBOLES_202004810\\Arbol"+er.get(contador_img).getNombre()+".png");
                Image nuevo = img.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render = new ImageIcon(nuevo);
                jLabel5.setIcon(render);
                break;
            case "Siguientes":
                contador_img=0;
                ImageIcon img2 = new ImageIcon("SIGUIENTES_202004810\\Siguientes"+er.get(contador_img).getNombre()+".png");
                Image nuevo2 = img2.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render2 = new ImageIcon(nuevo2);
                jLabel5.setIcon(render2);
                break;
            case "Transiciones":
                contador_img=0;
                ImageIcon img3 = new ImageIcon("TRANSICIONES_202004810\\Transiciones"+er.get(contador_img).getNombre()+".png");
                Image nuevo3 = img3.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render3 = new ImageIcon(nuevo3);
                jLabel5.setIcon(render3);
                break;
            case "AFD":
                contador_img=0;
                ImageIcon img4 = new ImageIcon("AFD_202004810\\AFD"+er.get(contador_img).getNombre()+".png");
                Image nuevo4 = img4.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render4 = new ImageIcon(nuevo4);
                jLabel5.setIcon(render4);
                break;
            case "AFND":
                contador_img=0;
                ImageIcon img5 = new ImageIcon("AFND_202004810\\AFND"+er.get(contador_img).getNombre()+".png");
                Image nuevo5 = img5.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon render5 = new ImageIcon(nuevo5);
                jLabel5.setIcon(render5);
                break;
            default:
                break;
        }else{
            JOptionPane.showMessageDialog(this, "No se han generado autómatas");
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if(er.isEmpty()){
            JOptionPane.showMessageDialog(this, "No se han generado autómatas para validación");
        }else{
            JOptionPane.showMessageDialog(this, "Se ha generado el archivo correctamente");
        }
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public void Analizar(){
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            reporte1 = new FileWriter("SALIDAS_202004810\\salida"+filename+".json");
            pw = new PrintWriter(reporte1);
            for (conjuntos c : conj) {
                String n_conjunto = Rango(c.getRango());
                c.setRango(n_conjunto);
            }
            String salida = "";
            String json = "";
            pw.println("[");
            for (validacion t : val) {
                for (expresion ex : er) {
                    if(ex.getNombre().equals(t.ER)){
                        String copy[] = ex.getPolaca().clone();
                        String arr [] = ex.getPolaca();
                        for (int j = 0; j < arr.length; j++) {
                            if(arr[j].equals("\"\\\'\"")){
                                arr[j]="\\\\\\'";
                            }else if(arr[j].equals("\"\\\"\"")){
                                arr[j]="\\\\\\\"";
                            }else if(arr[j].equals("\"\\n\"")){
                                arr[j]="\\\\n";
                            }else if(arr[j].equals("\".\"")){
                                arr[j]="\".\"";
                            }else{
                                arr[j]=arr[j].replaceAll("\"", "");
                            }
                        }
                        String convertir[]=ex.estructura(arr);
                        String temp = convertir[0];
                        temp = temp.replaceAll("\".\"", ".");
                        for (conjuntos c : conj) {
                            if(temp.contains(c.getNombre())){
                                temp = temp.replace("{"+c.getNombre()+"}", c.getRango());
                            }
                        }

                        String entrada = t.getCadena().replaceAll("\"", "");
                        Pattern pattern = Pattern.compile(temp);
                        Matcher matcher = pattern.matcher(entrada);
                        boolean match = matcher.matches();
                        
                        if (match) {
                            salida+="Cadena: "+entrada+" con ER: "+t.getER()+" es: VALIDA\n";
                            json+="{";
                            json+="\"Valor\":\""+entrada+"\",\n";
                            json+="\"ExpresionRegular\":\""+t.getER()+"\",\n";
                            json+="\"Resultado\":\"Cadena Válida\"\n";
                        }else{
                            salida+="Cadena: "+entrada+" con ER: "+t.getER()+" es: INVALIDA\n";
                            json+="{";
                            json+="\"Valor\":\""+entrada+"\",\n";
                            json+="\"ExpresionRegular\":\""+t.getER()+"\",\n";
                            json+="\"Resultado\":\"Cadena Inválida\"\n";
                        }
                        ex.setPolaca(copy);
                    }
                }
                json+="},";
            }
            json = json.substring(0, json.length()-1);
            pw.println(json);
            pw.println("]");
            this.jTextArea1.setText("");
            this.jTextArea1.setText(salida);
            }catch(Exception e){
                        e.printStackTrace();
            }finally{
                try{       
                    if(null != reporte1){
                        reporte1.close();
                    }
                }catch(Exception e2){
                    e2.printStackTrace();
                }
            }
       
    
        
    }

    public String Rango(String r){
        String nuevo_r = "";
        if(r.contains("~")){
            char temp [] = r.toCharArray();
            int first = temp[0], last = temp[temp.length-1];
            char x = (char) first, y = (char)last;
            nuevo_r = "["+x+"-"+y+"]";
        }else{
            String temp []= r.split(",");
            String rang = "";
            for (int i = 0; i < temp.length; i++) {
                if(temp[i].equals("\"\\\'\"")){
                    temp[i]="\\\\\\'";
                }else if(temp[i].equals("\"\\\"\"")){
                    temp[i]="\\\\\\\"";
                }else if(temp[i].equals("\"\\n\"")){
                    temp[i]="\\\\n";
                }else{
                    temp[i]=temp[i].replaceAll("\"", "");
                }
                rang+=temp[i]+"|";
            }
            
            rang = rang.substring(0, rang.length()-1);
            nuevo_r = "("+rang+")";
        }
        
        return nuevo_r;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTree jTree2;
    // End of variables declaration//GEN-END:variables

    private void reporte(List<TError> lexico,List<TError> sintactico) {
        
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            
        reporte1 = new FileWriter("ERRORES_202004810\\errores"+filename+".html");
        pw = new PrintWriter(reporte1);
      
        String html = "<!DOCTYPE html>\n" +
"                        <html lang=\"en\">\n" +
"                        <head>\n" +
"                            <meta charset=\"UTF-8\">\n" +
"                            <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"                            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"                            <link rel=\"stylesheet\" href=\"style.css\">\n" +
"                            <title>Reporte</title>\n" +
"                        </head>\n" +
"                        <body>\n" +
"                            <div class=\"container-table\">\n" +
"                            <div class=\"table__title1\">\n" +
"                                Reporte de Errores\n" +
"                            </div></div>";
        
        html+="<div id=\"main-container\">\n" +
"                            <table>\n" +
"                            <thead>\n" +
"				<tr>\n" +
"                                   <th style=\"border-top-left-radius: 20px;\">No.</th><th>Caracter</th><th>Tipo de Error</th><th>Descripción</th><th>Fila</th><th style=\"border-top-right-radius: 20px;\">Columna</th>\n" +
"				</tr>\n" +
"			     </thead>";    
            
            int contador_e=1;
            for (TError lexico1 : lexico) {
                html+="<tr>";
                html+="<td style=\"color: red; font-size: 1.2rem;\">"+contador_e+"</td>";
                html+=lexico1.html();
                html+="</tr>";
                contador_e++;
            }
            for (TError sintax : sintactico) {
                html+="<tr>";
                html+="<td style=\"color: red; font-size: 1.2rem;\">"+contador_e+"</td>";
                html+=sintax.html();
                html+="</tr>";
                contador_e++;
            }
        
            html+="</table></div>\n</body>\n</html>";
            pw.println(html);
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
        
    }

    private void save() {
        
       JFileChooser fc = new JFileChooser();
            int op = fc.showSaveDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                ruta=fc.getSelectedFile().getAbsolutePath();
                archivo = fc.getSelectedFile();
                String nombre = fc.getSelectedFile().getName();
                filename = nombre.replaceAll(".exp", "");
            }
            FileWriter escribir;
            try {
                escribir = new FileWriter(archivo, true);
                String cadena = this.jTextArea2.getText();
                escribir.write(cadena);
                escribir.close();

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
            }
            
            JOptionPane.showMessageDialog(this, "Se ha guardado el archivo correctamente");
    }
}
