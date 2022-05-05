package paneles;
//clases
import clases.datos;
import clases.laf;
import clases.logger;
import clases.BackupHandler.escritorJSON;
//java
import javax.swing.JOptionPane;
//extension larga
import java.util.logging.Level;

public class delDatosPanel2 extends javax.swing.JPanel{
    public delDatosPanel2(){
        initComponents();
        new laf().LookAndFeel(delDatosPanel2.this,delDatosPanel2.class.getName(),"delDatosPanel2");
        
        botones();
    }
    
    protected void botones(){
        closeButton.addActionListener((a)->{
            setVisible(false);
        });
        
        deleteButton.addActionListener((a)->{
            try{
                if(!jTextField1.getText().equals("")){
                    int codigo=Integer.parseInt(jTextField1.getText());
                    
                    int opcion=JOptionPane.showConfirmDialog(null,"¿Deseas crear una copia de seguridad?","Notice 1",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    if(opcion==0){
                        new escritorJSON().writeDataPartnerJson(codigo);
                        new datos().eliminarDatosSocio(codigo);
                    }else if(opcion==1){
                        new datos().eliminarDatosSocio(codigo);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Escribe el número de identificación a eliminar","Error 18",JOptionPane.WARNING_MESSAGE);
                    new logger().staticLogger("Error 18: no se escribió correctamente el código del empleado a eliminar. Ocurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'botones(deleteButton)'",Level.WARNING);
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 32",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 32: "+e.getMessage()+".\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'botones(deleteButton)'",Level.WARNING);
                new logger().exceptionLogger(delDatosPanel2.class.getName(),Level.WARNING,"botones.delete-32",e.fillInStackTrace());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        closeButton.setText("Cerrar panel");

        jLabel1.setText("Código del socio:");

        deleteButton.setText("Eliminar datos");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(Character.isLetter(evt.getKeyChar())){
            JOptionPane.showMessageDialog(null,"Solo números","Let 6",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Let 6: se ingresaron letras en un campo equivocado.\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'jTextField1KeyPressed()'",Level.WARNING);
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyPressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}