package venPrimarias;
//clases
import clases.datos;
import clases.Icono;
import clases.logger;
import menus.menuDatosVentana2;
//java
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
//extension larga
import javax.swing.filechooser.FileNameExtensionFilter;

public class formulario2 extends javax.swing.JFrame{
    public formulario2(){
        initComponents();
        try{
            Properties style=new Properties();
            style.load(new FileInputStream("src/data/config/config.properties"));
            UIManager.setLookAndFeel(style.getProperty("look_and_feel"));
            SwingUtilities.updateComponentTreeUI(this);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error CNFE",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error CNFE: "+e.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'formulario2()'",Level.WARNING);
            new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"formulario2-CNFE",e.fillInStackTrace());
        }catch(InstantiationException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error IE",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error IE: "+x.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'formulario2()'",Level.WARNING);
            new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"formulario2-IE",x.fillInStackTrace());
        }catch(IllegalAccessException n){
            JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error IAE",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error IAE: "+n.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'formulario2()'",Level.WARNING);
            new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"formulario2-IAE",n.fillInStackTrace());
        }catch(UnsupportedLookAndFeelException y){
            JOptionPane.showMessageDialog(null,"Error:\n"+y.getMessage(),"Error 28",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 28: "+y.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'formulario2()'",Level.WARNING);
            new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"formulario2-28",y.fillInStackTrace());
        }catch(NullPointerException k){
            JOptionPane.showMessageDialog(null,"Error:\n"+k.getMessage(),"Error 0",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 0: "+k.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'formulario2()'",Level.WARNING);
            new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"formulario2-0",k.fillInStackTrace());
        }catch(FileNotFoundException s){
            JOptionPane.showMessageDialog(null,"Error:\n"+s.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 1IO: "+s.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'formulario2()'",Level.WARNING);
            new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"formulario2-1IO",s.fillInStackTrace());
        }catch(IOException d){
            JOptionPane.showMessageDialog(null,"Error:\n"+d.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 2IO: "+d.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'formulario2()'",Level.WARNING);
            new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"formulario2-2IO",d.fillInStackTrace());
        }
         
        botones();
        settings();
        
        setLocationRelativeTo(null);
        setTitle("Formulario 2");
        setResizable(false);
    }
    
    protected Properties p;
    protected JFileChooser jfc;
    
    protected String direccion;
    
    protected void settings(){
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
    }
    
    protected final void botones(){
        backButton.addActionListener((ae)->{
            setVisible(false);
            dispose();
        });
        
        jMenuItem1.addActionListener((ae)->{
            new menuDatosVentana2().setVisible(true);
        });
        
        miClearFields.addActionListener((a)->{
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextArea1.setText("");
            picLabel.setIcon(null);
            picLabel.setText("Foto");
        });
        
        miInsImage.addActionListener((a)->{
            try{
                p=new Properties();
                p.load(new FileInputStream("src/data/config/filechooserd.properties"));
                jfc=new JFileChooser(p.getProperty("lastdirectory_form2"));
                
                File f=jfc.getCurrentDirectory();
                
                jfc.setFileFilter(new FileNameExtensionFilter("Archivos JPG","jpg"));
                
                jfc.setCurrentDirectory(f);
                
                int n=jfc.showOpenDialog(null);
                if(JFileChooser.APPROVE_OPTION==n){
                    try{
                        f=jfc.getSelectedFile();
                        direccion=f.getPath();
                        
                        ImageIcon ii=new ImageIcon(f.toString());
                        Icon i=new ImageIcon(ii.getImage().getScaledInstance(picLabel.getWidth(),picLabel.getHeight(),Image.SCALE_DEFAULT));
                        picLabel.setText(null);
                        picLabel.setIcon(i);
                        
                        p.setProperty("lastdirectory_form2",f.getParent());
                        p.store(new BufferedWriter(new FileWriter("src/data/config/filechooserd.properties")),"JFileChooserDirection");
                    }catch(IOException e){
                        JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 24",JOptionPane.WARNING_MESSAGE);
                        new logger().staticLogger("Error 24: "+e.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'botones(miInsImage)'",Level.WARNING);
                        new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"botones.miInsImage-24",e.fillInStackTrace());
                    }
                }
            }catch(HeadlessException e){
                JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 40",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 40: "+e.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'botones(miInsImage)'",Level.WARNING);
                new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"botones.miInsImage-40",e.fillInStackTrace());
            }catch(FileNotFoundException x){
                JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 1IO: "+x.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'botones(miInsImage)'",Level.WARNING);
                new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"botones.miInsImage-1IO",x.fillInStackTrace());
            }catch(IOException n){
                JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 2IO: "+n.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'botones(miInsImage)'",Level.WARNING);
                new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"botones.miInsImage-2IO",n.fillInStackTrace());
            }
        });
        
        storeButton.addActionListener((ae)->{
            try{
                if(!jTextField1.getText().equals("")||!jTextField2.getText().equals("")||!jTextField3.getText().equals("")||!jTextField4.getText().equals("")||!jTextArea1.getText().equals("")){
                    int codigo=Integer.parseInt(jTextField1.getText());
                    String nombre=jTextField2.getText();
                    String apellidop=jTextField3.getText();
                    String apellidom=jTextField4.getText();
                    String tipo=jComboBox1.getSelectedItem().toString();
                    String datos=jTextArea1.getText();
                    InputStream foto=new FileInputStream(direccion);
                    
                    new datos().insertarDatosSocio(codigo,nombre,apellidop,apellidom,tipo,datos,foto);
                }else{
                    JOptionPane.showMessageDialog(null,"Error: escribe los datos faltantes","Error 18",JOptionPane.WARNING_MESSAGE);
                    new logger().staticLogger("Error 18: no se escribieron o faltan datos en los campos.\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'botones(storeButton)'",Level.WARNING);
                }
            }catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 1IO: "+e.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'botones(storeButton)'",Level.WARNING);
                new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"botones.store-1IO",e.fillInStackTrace());
            }catch(IOException x){
                JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 2IO: "+x.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'botones(storeButton)'",Level.WARNING);
                new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"botones.store-2IO",x.fillInStackTrace());
            }catch(NullPointerException n){
                JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error 0",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 0: "+n.getMessage()+".\nOcurrió en la clase '"+formulario2.class.getName()+"', en el método 'botones(storeButton)'",Level.WARNING);
                new logger().exceptionLogger(formulario2.class.getName(),Level.WARNING,"botones.store-0",n.fillInStackTrace());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        storeButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        picLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miInsImage = new javax.swing.JMenuItem();
        miClearFields = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new Icono().getIconImage());

        backButton.setText("Regresar");

        jLabel1.setText("Código del socio:");

        jLabel2.setText("Nombre(s):");

        jLabel3.setText("Apellido paterno:");

        jLabel4.setText("Tipo de socio:");

        jLabel5.setText("Datos extra:");

        storeButton.setText("Guardar datos");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Apellido materno:");

        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picLabel.setText("Foto");
        picLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu1.setText("Datos");

        jMenuItem1.setText("Menú de Datos");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opciones");

        miInsImage.setText("Insertar imagen");
        jMenu2.add(miInsImage);

        miClearFields.setText("Limpiar campos");
        jMenu2.add(miClearFields);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(storeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(storeButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]){
        new formulario2().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JMenuItem miClearFields;
    private javax.swing.JMenuItem miInsImage;
    public static javax.swing.JLabel picLabel;
    private javax.swing.JButton storeButton;
    // End of variables declaration//GEN-END:variables
}