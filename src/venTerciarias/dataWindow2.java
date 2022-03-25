package venTerciarias;
//clases
import clases.datos;
import clases.Icono;
import clases.logger;
//java
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Properties;
import javax.swing.Icon;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
//extension larga
import java.util.logging.Level;

public class dataWindow2 extends javax.swing.JDialog{
    public dataWindow2(java.awt.Frame parent,boolean modal){
        super(parent, modal);
        initComponents();
        try{
            Properties style=new Properties();
            style.load(new FileInputStream("src/data/config/config.properties"));
            UIManager.setLookAndFeel(style.getProperty("look_and_feel"));
            SwingUtilities.updateComponentTreeUI(this);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error CNFE",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error CNFE: "+e.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'dataWindow2()'",Level.WARNING);
            new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"dataWindow2-CNFE",e.fillInStackTrace());
        }catch(InstantiationException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error IE",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error IE: "+x.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'dataWindow2()'",Level.WARNING);
            new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"dataWindow2-IE",x.fillInStackTrace());
        }catch(IllegalAccessException n){
            JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error IAE",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error IAE: "+n.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'dataWindow2()'",Level.WARNING);
            new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"dataWindow2-IAE",n.fillInStackTrace());
        }catch(UnsupportedLookAndFeelException y){
            JOptionPane.showMessageDialog(null,"Error:\n"+y.getMessage(),"Error 28",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 28: "+y.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'dataWindow2()'",Level.WARNING);
            new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"dataWindow2-28",y.fillInStackTrace());
        }catch(NullPointerException k){
            JOptionPane.showMessageDialog(null,"Error:\n"+k.getMessage(),"Error 0",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 0: "+k.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'dataWindow2()'",Level.WARNING);
            new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"dataWindow2-0",k.fillInStackTrace());
        }catch(FileNotFoundException s){
            JOptionPane.showMessageDialog(null,"Error:\n"+s.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 1IO: "+s.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'dataWindow2()'",Level.WARNING);
            new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"dataWindow2-1IO",s.fillInStackTrace());
        }catch(IOException d){
            JOptionPane.showMessageDialog(null,"Error:\n"+d.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 2IO: "+d.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'dataWindow2()'",Level.WARNING);
            new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"dataWindow2-2IO",d.fillInStackTrace());
        }
        
        botones();
        datosMostrar();
        settings();
        
        setLocationRelativeTo(null);
        setTitle("Datos del socio");
        setResizable(false);
    }
    
    protected datos d;
    
    protected ResultSet rs;
    protected PreparedStatement ps;
    
    protected void settings(){
        genLabel.setVisible(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
    }
    
    protected final void datosMostrar(){
        d=new datos();
        String id=genLabel.getText();
        try{
            ps=d.getConnection().prepareStatement("select * from socios where codigo_part="+id+";");
            rs=ps.executeQuery();
            while(rs.next()){
                etiCodigo.setText(String.valueOf(rs.getInt("codigo_part")));
                etiNombre.setText(rs.getString("nombre_part"));
                etiApellidoP.setText(rs.getString("apellidop_part"));
                etiApellidoM.setText(rs.getString("apellidom_part"));
                etiTipoSocio.setText(rs.getString("tipo_socio"));
                jTextArea1.setText(rs.getString("datos_extra"));
                etiIngreso.setText(String.valueOf(rs.getDate("fecha_ingreso")));
                etiUCompra.setText(String.valueOf(rs.getDate("fecha_ucompra")));
                
                byte[] imagen=rs.getBytes("foto");
                
                Image i=Toolkit.getDefaultToolkit().createImage(imagen);
                ImageIcon im=new ImageIcon(i);
                Icon l=new ImageIcon(im.getImage().getScaledInstance(etiFoto.getWidth(),etiFoto.getHeight(),Image.SCALE_DEFAULT));
                etiFoto.setIcon(l);
                i.flush();
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 10",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 10: "+e.getMessage()+".\nOcurrió en la clase '"+dataWindow1.class.getName()+"', en el método 'datosMostrar()'",Level.WARNING);
            new logger().exceptionLogger(dataWindow1.class.getName(),Level.WARNING,"datosMostrar-10",e.fillInStackTrace());
        }catch(NullPointerException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 0",JOptionPane.WARNING_MESSAGE);
            new logger().logStaticSaver("Error 0: "+x.getMessage()+".\nOcurrió en la clase '"+dataWindow1.class.getName()+"', en el método 'datosMostrar()'",Level.WARNING);
            new logger().exceptionLogger(dataWindow1.class.getName(),Level.WARNING,"datosMostrar-0",x.fillInStackTrace());
        }
    }
    
    protected final void botones(){
        backButton.addActionListener((ae)->{
            setVisible(false);
            dispose();
        });
        
        storeImgButton.addActionListener((a)->{
            try{
                ps=new datos().getConnection().prepareStatement("select foto from socios where codigo_part='"+etiCodigo.getText()+"';");
                File f=new File("src/data/media/dataImage/socios/"+(int)(Math.random()*100000)+".jpg");
                File f2=new File("src/data/media/dataImage/socios");
                
                if(!f2.exists()){
                    f2.mkdir();
                }
                
                FileOutputStream fos=new FileOutputStream(f);
                byte[] bytes;
                Blob blob;
                rs=ps.executeQuery();
                while(rs.next()){
                    blob=rs.getBlob("foto");
                    bytes=blob.getBytes(1,(int)blob.length());
                    fos.write(bytes);
                }
                
                ps.close();
                fos.close();
                fos.flush();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 10",JOptionPane.WARNING_MESSAGE);
                new logger().logStaticSaver("Error 10: "+e.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'botones(storeImgButton)'",Level.WARNING);
                new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"botones.storeImg-10",e.fillInStackTrace());
            }catch(FileNotFoundException x){
                JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
                new logger().logStaticSaver("Error 1IO: "+x.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'botones(storeImgButton)'",Level.WARNING);
                new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"botones.storeImg-10",x.fillInStackTrace());
            }catch(IOException n){
                JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
                new logger().logStaticSaver("Error 2IO: "+n.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'botones(storeImgButton)'",Level.WARNING);
                new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"botones.storeImg-10",n.fillInStackTrace());
            }catch(NullPointerException y){
                JOptionPane.showMessageDialog(null,"Error:\n"+y.getMessage(),"Error 0",JOptionPane.WARNING_MESSAGE);
                new logger().logStaticSaver("Error o: "+y.getMessage()+".\nOcurrió en la clase '"+dataWindow2.class.getName()+"', en el método 'botones(storeImgButton)'",Level.WARNING);
                new logger().exceptionLogger(dataWindow2.class.getName(),Level.WARNING,"botones.storeImg-10",y.fillInStackTrace());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genLabel = new javax.swing.JLabel();
        storeImgButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        etiFoto = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        etiCodigo = new javax.swing.JLabel();
        etiNombre = new javax.swing.JLabel();
        etiApellidoP = new javax.swing.JLabel();
        etiApellidoM = new javax.swing.JLabel();
        etiTipoSocio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        etiIngreso = new javax.swing.JLabel();
        etiUCompra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new Icono().getIconImage());

        genLabel.setText("12347");

        storeImgButton.setText("Guardar imagen");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Datos");

        etiFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        backButton.setText("Regresar");

        jLabel2.setText("Código del socio:");

        jLabel3.setText("Nombre del socio:");

        jLabel4.setText("Apellido paterno:");

        jLabel5.setText("Apellido materno:");

        jLabel6.setText("Tipo de socio:");

        jLabel7.setText("Datos extra:");

        jLabel8.setText("Fecha de ingreso:");

        jLabel9.setText("Fecha de última compra:");

        etiCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etiNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etiApellidoP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etiApellidoM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etiTipoSocio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        etiIngreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etiUCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etiFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(etiApellidoM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiApellidoP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(etiNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etiTipoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiUCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(storeImgButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                        .addComponent(backButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(etiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 92, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(storeImgButton)
                            .addComponent(backButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(etiApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(etiApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(etiTipoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(etiIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(etiUCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]){
        new dataWindow2(new javax.swing.JFrame(),true).setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    protected javax.swing.JLabel etiApellidoM;
    protected javax.swing.JLabel etiApellidoP;
    protected javax.swing.JLabel etiCodigo;
    protected javax.swing.JLabel etiFoto;
    protected javax.swing.JLabel etiIngreso;
    protected javax.swing.JLabel etiNombre;
    protected javax.swing.JLabel etiTipoSocio;
    protected javax.swing.JLabel etiUCompra;
    public static javax.swing.JLabel genLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton storeImgButton;
    // End of variables declaration//GEN-END:variables
}