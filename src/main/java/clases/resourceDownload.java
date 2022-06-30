package clases;
//java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.URL;
import java.net.Socket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.URLConnection;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;
//extension larga
import java.util.logging.Level;

/**
 * Clase encargada de descargar los recursos necesarios para el correcto funcionamiento del programa.
 * Descarga las librerías e idiomas.
 * 
 * @author erick
 */
public class resourceDownload{
    protected boolean estado;
    
    protected BufferedInputStream bis;
    protected InputStream is;
    protected OutputStream os;
    protected File f;
    
    protected URL u;
    protected Socket s;
    protected URLConnection uc;
    
    /**
     * Esta clase se encarga de verificar si hay conectividad a internet.
     * 
     * @param url Dirección a la que se verificará la conexión.
     * @param puerto Número del puerto por el que se va a verificar la conexión.
     * 
     * @return el valor booleano si está conectado o no
     */
    public boolean checkConnection(String url,int puerto){
        try{
            s=new Socket();
            SocketAddress sa=new InetSocketAddress(url,puerto);
            
            s.bind(sa);
            s.connect(sa);
            
            estado=s.isConnected();
        }catch(UnknownHostException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 1I",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 1I: "+e.getMessage()+"\nOcurrió en la clase '"+resourceDownload.class.getName()+"', en el método 'checkConnection()'",Level.WARNING);
            new logger().exceptionLogger(resourceDownload.class.getName(),Level.WARNING,"checkConnection-1I",e.fillInStackTrace());
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 1IO: "+x.getMessage()+"\nOcurrió en la clase '"+resourceDownload.class.getName()+"', en el método 'checkConnection()'",Level.WARNING);
            new logger().exceptionLogger(resourceDownload.class.getName(),Level.WARNING,"checkConnection-1IO",x.fillInStackTrace());
        }
        return estado;
    }
    
    /**
     * Método encargado de descargar de internet las librerías(.jar).
     * 
     * @param validar Archivo que se validará y guardará
     * @param link Página web del recurso a decargar
     */
    public void downloadLibs(String validar,String link){
        f=new File(System.getProperty("user.dir")+"/src/main/resources/data/libs/test/"+validar);
        try{
            if(!f.exists()){
                f.createNewFile();
            }
            
            if(f.exists()&&f.length()==0){
                u=new URL(link);
                uc=u.openConnection();
                
                is=uc.getInputStream();
                bis=new BufferedInputStream(is);
                os=new FileOutputStream(System.getProperty("user.dir")+"/src/main/resources/data/libs/test/"+validar);
                
                new Thread(new thread(is,os)).start();
            }
            
            bis.close();
            os.flush();
            os.close();
        }catch(MalformedURLException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 1I",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 1I: "+e.getMessage()+"\nOcurrió en la clase '"+resourceDownload.class.getName()+"', en el método 'downloadLibs()'",Level.WARNING);
            new logger().exceptionLogger(resourceDownload.class.getName(),Level.WARNING,"downloadLibs-1I",e.fillInStackTrace());
        }catch(FileNotFoundException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 1IO: "+x.getMessage()+"\nOcurrió en la clase '"+resourceDownload.class.getName()+"', en el método 'downloadLibs()'",Level.WARNING);
            new logger().exceptionLogger(resourceDownload.class.getName(),Level.WARNING,"downloadLibs-1IO",x.fillInStackTrace());
        }catch(IOException k){
            JOptionPane.showMessageDialog(null,"Error:\n"+k.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 2IO: "+k.getMessage()+"\nOcurrió en la clase '"+resourceDownload.class.getName()+"', en el método 'downloadLibs()'",Level.WARNING);
            new logger().exceptionLogger(resourceDownload.class.getName(),Level.WARNING,"downloadLibs-2IO",k.fillInStackTrace());
        }
    }
}