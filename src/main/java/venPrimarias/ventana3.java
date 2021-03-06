package venPrimarias;
//clases
import clases.datos;
import clases.guiMediaHandler;
import clases.logger;
//java
import javax.swing.JOptionPane;
//extension larga
import java.util.logging.Level;

public class ventana3 extends javax.swing.JFrame{
    public ventana3(){
        initComponents();
        new guiMediaHandler(ventana3.class.getName()).LookAndFeel(ventana3.this);
        new guiMediaHandler(ventana3.class.getName()).FormImage(picLabel);
        
        botones();
        settings();
        
        setSize(500,305);
        setLocationRelativeTo(null);
        setTitle("Descuentos y promociones");
        setResizable(false);
        pack();
    }
    
    protected void settings(){
        jTextField3.setText(".");
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
    }
    
    protected final void botones(){
        backButton.addActionListener((a)->{
            setVisible(false);
            dispose();
        });
        
        jMenuItem1.addActionListener((a)->{
            jTextField1.setText("");
            jTextField2.setText("");
            jTextArea1.setText("");
            jTextField3.setText("");
            jDateChooser1.setDate(null);
            jDateChooser2.setDate(null);
        });
        
        svdtButton.addActionListener((a)->{
            try{
                if(!jTextField1.getText().equals("")||!jTextField2.getText().equals("")||!jTextArea1.getText().equals("")||!jTextField3.getText().equals(".")||!jTextField3.getText().equals("")){
                    String codigo=jTextField1.getText();
                    String nombre=jTextField2.getText();
                    String datos=jTextArea1.getText();
                    float descuento=Float.parseFloat(jTextField3.getText());
                    java.sql.Date inicio=new java.sql.Date(jDateChooser1.getDate().getTime());
                    java.sql.Date fin=new java.sql.Date(jDateChooser2.getDate().getTime());
                    
                    new datos().insertarDatosPromo(codigo,nombre,datos,descuento,inicio,fin);
                }else{
                    JOptionPane.showMessageDialog(null,"Error:\nIngrese los datos que se solicitan","Error 18",JOptionPane.WARNING_MESSAGE);
                    new logger(Level.WARNING).staticLogger("Error 18: no se escribieron o faltan datos en los campos.\nOcurri?? en la clase '"+ventana3.class.getName()+"', en el m??todo 'botones(svdtButton)'");
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 32",JOptionPane.ERROR_MESSAGE);
                new logger(Level.SEVERE).staticLogger("Error 32: "+e.getMessage()+".\nOcurri?? en la clase '"+ventana3.class.getName()+"', en el m??todo 'botones(svdtButton)'");
                new logger(Level.SEVERE).exceptionLogger(ventana3.class.getName(),"botones.svdt-32",e.fillInStackTrace());
            }catch(NullPointerException x){
                JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 0",JOptionPane.ERROR_MESSAGE);
                new logger(Level.SEVERE).staticLogger("Error 0: "+x.getMessage()+".\nOcurri?? en la clase '"+ventana3.class.getName()+"', en el m??todo 'botones(svdtButton)'");
                new logger(Level.SEVERE).exceptionLogger(ventana3.class.getName(),"botones.svdt-0",x.fillInStackTrace());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        picLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        svdtButton = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new guiMediaHandler(ventana3.class.getName()).getIconImage());

        backButton.setText("Regresar");

        picLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("C??digo promocional:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jLabel2.setText("Nombre promocional:");

        jLabel3.setText("Datos de la promoci??n:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setText("Descuento:");

        jLabel5.setText("Inicio:");

        svdtButton.setText("Guardar datos");

        jLabel6.setText("Fin:");

        jMenu2.setText("Opciones");

        jMenuItem1.setText("Limpiar campos");
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(svdtButton, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(picLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(svdtButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(Character.isLetter(evt.getKeyChar())){
            JOptionPane.showMessageDialog(null,"Solo n??meros","Let 6",JOptionPane.WARNING_MESSAGE);
            new logger(Level.WARNING).staticLogger("Let 6: se ingresaron letras en un campo equivocado.\nOcurri?? en la clase '"+ventana3.class.getName()+"', en el m??todo 'jTextField1KeyPressed()'");
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyPressed
    
    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if(Character.isDigit(evt.getKeyChar())){
            JOptionPane.showMessageDialog(null,"Solo letras","Let 7",JOptionPane.WARNING_MESSAGE);
            new logger(Level.WARNING).staticLogger("Let 7: se ingresaron n??meros en un campo equivocado.\nOcurri?? en la clase '"+ventana3.class.getName()+"', en el m??todo 'jTextField2KeyPressed()'");
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyPressed
    
    public static void main(String args[]){
        new ventana3().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    protected javax.swing.JLabel picLabel;
    private javax.swing.JButton svdtButton;
    // End of variables declaration//GEN-END:variables
}