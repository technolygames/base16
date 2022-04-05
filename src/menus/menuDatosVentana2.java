package menus;
//clases
import clases.Icono;
import clases.laf;
import paneles.delDatosPanel2;
import paneles.modDatosPanel2;
//java
import java.awt.BorderLayout;

public class menuDatosVentana2 extends javax.swing.JFrame{
    public menuDatosVentana2(){
        initComponents();
        new laf().LookAndFeel(menuDatosVentana2.this,menuDatosVentana2.class.getName(),"menuDatosVentana2");
        
        botones();
        
        setLocationRelativeTo(null);
        setTitle("Menú de Datos");
        setResizable(false);
    }
    
    protected final void botones(){
        backButton.addActionListener((ae)->{
            setVisible(false);
            dispose();
        });
        
        miDelData.addActionListener((a)->{
           delDatosPanel2 ddp2=new delDatosPanel2(); 
           ddp2.setVisible(true);
           menuDatosVentana2.this.setLayout(new BorderLayout());
           menuDatosVentana2.this.getContentPane().add(ddp2,BorderLayout.CENTER);
        });
        
        miModData.addActionListener((a)->{
            modDatosPanel2 mdp2=new modDatosPanel2();
            mdp2.setVisible(true);
            menuDatosVentana2.this.setLayout(new BorderLayout());
            menuDatosVentana2.this.getContentPane().add(mdp2,BorderLayout.CENTER);
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miDelData = new javax.swing.JMenuItem();
        miModData = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new Icono().getIconImage());

        backButton.setText("Regresar");

        jMenu1.setText("Ventana");

        miDelData.setText("Eliminar datos");
        jMenu1.add(miDelData);

        miModData.setText("Cambiar datos");
        jMenu1.add(miModData);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(349, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]){
        new menuDatosVentana2().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miDelData;
    private javax.swing.JMenuItem miModData;
    // End of variables declaration//GEN-END:variables
}