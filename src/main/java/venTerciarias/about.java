package venTerciarias;
//clases
import clases.datos;
import clases.guiMediaHandler;
import clases.logger;
//java
import java.awt.Cursor;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import javax.swing.JOptionPane;
//extension larga
import java.util.logging.Level;
import java.nio.charset.StandardCharsets;

public final class about extends javax.swing.JDialog{
    public about(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        new guiMediaHandler(about.class.getName()).LookAndFeel(about.this);
        
        etiquetas();
        settings();
        
        setLocationRelativeTo(null);
        setTitle("Acerca del programa");
        setResizable(false);
        pack();
    }
    
    protected Properties p;
    
    protected String userdir=datos.userdir;
    
    protected void settings(){
        websiteLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    protected void etiquetas(){
        p=new Properties();
        try{
            p.load(new FileReader(userdir+"/data/config/acerca.properties",StandardCharsets.UTF_8));
            
            versionLabel.setText(p.getProperty("version"));
            estableLabel.setText(p.getProperty("estable"));
            inicioLabel.setText(p.getProperty("inicio"));
            finLabel.setText(p.getProperty("fin"));
            devLabel.setText(p.getProperty("dev"));
            pubLabel.setText(p.getProperty("pub"));
            fpubLabel.setText(p.getProperty("fpub"));
            jdkLabel.setText(p.getProperty("jdk"));
            jreLabel.setText(p.getProperty("jre"));
            devonLabel.setText(p.getProperty("devon"));
            websiteLabel.setText(p.getProperty("website"));
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 1IO",JOptionPane.ERROR_MESSAGE);
            new logger(Level.SEVERE).staticLogger("Error 1IO: "+e.getMessage()+".\nOcurri?? en la clase '"+about.class.getName()+"', en el m??todo 'etiquetas()'");
            new logger(Level.SEVERE).exceptionLogger(about.class.getName(),"etiquetas-1IO",e.fillInStackTrace());
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 2IO",JOptionPane.ERROR_MESSAGE);
            new logger(Level.SEVERE).staticLogger("Error 2IO: "+x.getMessage()+".\nOcurri?? en la clase '"+about.class.getName()+"', en el m??todo 'etiquetas()'");
            new logger(Level.SEVERE).exceptionLogger(about.class.getName(),"etiquetas-2IO",x.fillInStackTrace());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        devLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pubLabel = new javax.swing.JLabel();
        jLabel07 = new javax.swing.JLabel();
        fpubLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdkLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jreLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        devonLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        estableLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        finLabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inicioLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        websiteLabel = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new guiMediaHandler(about.class.getName()).getIconImage());

        jLabel1.setText("Versi??n:");

        versionLabel.setText("jLabel1");

        jLabel5.setText("Desarrolladora:");

        devLabel.setText("jLabel5");

        jLabel6.setText("Publicadora:");

        pubLabel.setText("jLabel6");

        jLabel07.setText("Fecha de publicaci??n:");

        fpubLabel.setText("jLabel7");

        jLabel8.setText("Versi??n de JDK:");

        jdkLabel.setText("jLabel8");

        jLabel9.setText("Versi??n de JRE:");

        jreLabel.setText("jLabel9");

        jLabel10.setText("Desarrollado en:");

        devonLabel.setText("jLabel10");

        jLabel2.setText("??ltima versi??n estable:");

        estableLabel.setText("jLabel2");

        jLabel4.setText("Fin del desarrollo:");

        finLabel.setText("jLabel4");

        jLabel24.setText("Gracias por adquirirlo.");

        jLabel3.setText("Inicio del desarrollo:");

        inicioLabel.setText("jLabel3");

        jLabel11.setText("P??gina del desarrollador:");

        websiteLabel.setText("jLabel11");
        websiteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                websiteLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(306, 306, 306))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(versionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(estableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inicioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(finLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(devLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pubLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fpubLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(devonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(websiteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel24)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(versionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(estableLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inicioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(finLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(devLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pubLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel07)
                    .addComponent(fpubLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jdkLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(devonLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(websiteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void websiteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_websiteLabelMouseClicked
        p=new Properties();
        try{
            p.load(new FileInputStream(userdir+"/data/config/acerca.properties"));
            Desktop.getDesktop().browse(new URI(p.getProperty("website")));
        }catch(URISyntaxException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 1I",JOptionPane.ERROR_MESSAGE);
            new logger(Level.SEVERE).staticLogger("Error 1I: "+e.getMessage()+".\nOcurri?? en la clase '"+about.class.getName()+"', en el m??todo 'websiteLabelMouseClicked()'");
            new logger(Level.SEVERE).exceptionLogger(about.class.getName(),"websiteLabelMouseClicked-1I",e.fillInStackTrace());
        }catch(NullPointerException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 0",JOptionPane.ERROR_MESSAGE);
            new logger(Level.SEVERE).staticLogger("Error 0: "+x.getMessage()+".\nOcurri?? en la clase '"+about.class.getName()+"', en el m??todo 'websiteLabelMouseClicked()'");
            new logger(Level.SEVERE).exceptionLogger(about.class.getName(),"websiteLabelMouseClicked-0",x.fillInStackTrace());
        }catch(FileNotFoundException n){
            JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error 1IO",JOptionPane.ERROR_MESSAGE);
            new logger(Level.SEVERE).staticLogger("Error 1IO: "+n.getMessage()+".\nOcurri?? en la clase '"+about.class.getName()+"', en el m??todo 'websiteLabelMouseClicked()'");
            new logger(Level.SEVERE).exceptionLogger(about.class.getName(),"websiteLabelMouseClicked-1IO",n.fillInStackTrace());
        }catch(IOException k){
            JOptionPane.showMessageDialog(null,"Error:\n"+k.getMessage(),"Error 2IO",JOptionPane.ERROR_MESSAGE);
            new logger(Level.SEVERE).staticLogger("Error 2IO: "+k.getMessage()+".\nOcurri?? en la clase '"+about.class.getName()+"', en el m??todo 'websiteLabelMouseClicked()'");
            new logger(Level.SEVERE).exceptionLogger(about.class.getName(),"websiteLabelMouseClicked-2IO",k.fillInStackTrace());
        }
    }//GEN-LAST:event_websiteLabelMouseClicked
    
    public static void main(String[] args){
        new about(new javax.swing.JFrame(),true).setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel devLabel;
    private javax.swing.JLabel devonLabel;
    private javax.swing.JLabel estableLabel;
    private javax.swing.JLabel finLabel;
    private javax.swing.JLabel fpubLabel;
    private javax.swing.JLabel inicioLabel;
    private javax.swing.JLabel jLabel07;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jdkLabel;
    private javax.swing.JLabel jreLabel;
    private javax.swing.JLabel pubLabel;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JLabel websiteLabel;
    // End of variables declaration//GEN-END:variables
}