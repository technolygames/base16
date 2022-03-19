package paneles;

import clases.datos;
import clases.logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class delDatosPanel2 extends javax.swing.JPanel{
    public delDatosPanel2(){
        initComponents();
        try{
            Properties style=new Properties();
            style.load(new FileInputStream("src/data/config/config.properties"));
            UIManager.setLookAndFeel(style.getProperty("look_and_feel"));
            SwingUtilities.updateComponentTreeUI(this);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error CNFE",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error CNFE: "+e.getMessage()+".\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'delDatosPanel2()'",Level.WARNING);
            new logger().exceptionLogger(delDatosPanel2.class.getName(),Level.WARNING,"delDatosPanel2-CNFE",e.fillInStackTrace());
        }catch(InstantiationException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error IE",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error IE: "+x.getMessage()+".\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'delDatosPanel2()'",Level.WARNING);
            new logger().exceptionLogger(delDatosPanel2.class.getName(),Level.WARNING,"delDatosPanel2-IE",x.fillInStackTrace());
        }catch(IllegalAccessException n){
            JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error IAE",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error IAE: "+n.getMessage()+".\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'delDatosPanel2()'",Level.WARNING);
            new logger().exceptionLogger(delDatosPanel2.class.getName(),Level.WARNING,"delDatosPanel2-IAE",n.fillInStackTrace());
        }catch(UnsupportedLookAndFeelException y){
            JOptionPane.showMessageDialog(null,"Error:\n"+y.getMessage(),"Error 28",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 28: "+y.getMessage()+".\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'delDatosPanel2()'",Level.WARNING);
            new logger().exceptionLogger(delDatosPanel2.class.getName(),Level.WARNING,"delDatosPanel2-28",y.fillInStackTrace());
        }catch(NullPointerException k){
            JOptionPane.showMessageDialog(null,"Error:\n"+k.getMessage(),"Error 0",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 0: "+k.getMessage()+".\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'delDatosPanel2()'",Level.WARNING);
            new logger().exceptionLogger(delDatosPanel2.class.getName(),Level.WARNING,"delDatosPanel2-0",k.fillInStackTrace());
        }catch(FileNotFoundException s){
            JOptionPane.showMessageDialog(null,"Error:\n"+s.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 1IO: "+s.getMessage()+".\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'delDatosPanel2()'",Level.WARNING);
            new logger().exceptionLogger(delDatosPanel2.class.getName(),Level.WARNING,"delDatosPanel2-1IO",s.fillInStackTrace());
        }catch(IOException d){
            JOptionPane.showMessageDialog(null,"Error:\n"+d.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 2IO: "+d.getMessage()+".\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'delDatosPanel2()'",Level.WARNING);
            new logger().exceptionLogger(delDatosPanel2.class.getName(),Level.WARNING,"delDatosPanel2-2IO",d.fillInStackTrace());
        }
        
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
                    
                    new datos().eliminarDatosSocio(codigo);
                }else{
                    JOptionPane.showMessageDialog(null,"Escribe el número de identificación a eliminar","Error 18",JOptionPane.WARNING_MESSAGE);
                    new logger().logStaticSaver("Error 18: no se escribió correctamente el código del empleado a eliminar. Ocurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'botones(deleteButton)'",Level.WARNING);
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error Prueba",JOptionPane.WARNING_MESSAGE);
                new logger().logStaticSaver("Error Prueba: "+e.getMessage()+".\nOcurrió en la clase '"+delDatosPanel2.class.getName()+"', en el método 'botones(deleteButton)'",Level.WARNING);
                new logger().exceptionLogger(delDatosPanel2.class.getName(),Level.WARNING,"botones.delete-Prueba",e.fillInStackTrace());
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

        closeButton.setText("Cerrar");

        jLabel1.setText("Código del socio:");

        deleteButton.setText("Eliminar datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}