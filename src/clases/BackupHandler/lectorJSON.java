package clases.BackupHandler;

import clases.datos;
import clases.logger;
import com.google.gson.stream.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 * Clase encargada de leer los archivos creados para copia de seguridad
 * 
 * @author erick
 */
public class lectorJSON{
    protected JsonReader jsonr;
    
    protected String password;
    protected int codigoEmpleado;
    protected String nombreEmpleado;
    protected String apellidoPaternoEmpleado;
    protected String apellidoMaternoEmpleado;
    protected String domicilio;
    protected String puesto;
    protected int experiencia;
    protected String gradoEstudios;
    protected int contacto;
    protected int edad;
    protected String estado;
    protected String datosExtra;
    
    /**
     * Se encarga de leer un archivo JSON, con la estructura de la tabla de empleados, para volver a almacenar los datos en la base de datos.
     * 
     * @param nombre Nombre el archivo a leer
     */
    public void readDataWorkerJson(String nombre){
        try{
            jsonr=new JsonReader(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"/src/data/dataBackup/empleados/"+nombre+".json"),StandardCharsets.UTF_8));
            jsonr.beginObject();
            while(jsonr.hasNext()){
                String name=jsonr.nextName();
                if(name.equals("contraseña")){
                    password=jsonr.nextString();
                }else if(name.equals("codigo_emp")){
                    codigoEmpleado=jsonr.nextInt();
                }else if(name.equals("nombre_emp")){
                    nombreEmpleado=jsonr.nextString();
                }else if(name.equals("apellidop_emp")){
                    apellidoPaternoEmpleado=jsonr.nextString();
                }else if(name.equals("apellidom_emp")){
                    apellidoMaternoEmpleado=jsonr.nextString();
                }else if(name.equals("domicilio")){
                    domicilio=jsonr.nextString();
                }else if(name.equals("puesto")){
                    puesto=jsonr.nextString();
                }else if(name.equals("experiencia")){
                    experiencia=jsonr.nextInt();
                }else if(name.equals("grado_estudios")){
                    gradoEstudios=jsonr.nextString();
                }else if(name.equals("contacto")){
                    contacto=jsonr.nextInt();
                }else if(name.equals("edad")){
                    edad=jsonr.nextInt();
                }else if(name.equals("estado")){
                    estado=jsonr.nextString();
                }else if(name.equals("datos_extra")){
                    datosExtra=jsonr.nextString();
                }
            }
            new datos().insertarDatosEmpleado(password,codigoEmpleado,nombreEmpleado,apellidoPaternoEmpleado,apellidoMaternoEmpleado,domicilio,puesto,experiencia,gradoEstudios,contacto,edad,estado,datosExtra,new FileInputStream("C:\\Users\\erick\\Pictures\\5aacd4140462d64e88cb30273858510c.jpg"));
            jsonr.endObject();
            
            jsonr.close();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 1IO: "+e.getMessage()+".\nOcurrió en la clase '"+lectorJSON.class.getName()+"', en el método 'readDataWorkerJson()'",Level.WARNING);
            new logger().exceptionLogger(lectorJSON.class.getName(),Level.WARNING,"readDataWorkerJson-1IO",e.fillInStackTrace());
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 2IO: "+x.getMessage()+".\nOcurrió en la clase '"+lectorJSON.class.getName()+"', en el método 'readDataWorkerJson()'",Level.WARNING);
            new logger().exceptionLogger(lectorJSON.class.getName(),Level.WARNING,"readDataWorkerJson-2IO",x.fillInStackTrace());
        }catch(IllegalStateException n){
            JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error ISA",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error ISA: "+n.getMessage()+".\nOcurrió en la clase '"+lectorJSON.class.getName()+"', en el método 'readDataWorkerJson()'",Level.WARNING);
            new logger().exceptionLogger(lectorJSON.class.getName(),Level.WARNING,"readDataWorkerJson-ISA",n.fillInStackTrace());
        }
    }
}