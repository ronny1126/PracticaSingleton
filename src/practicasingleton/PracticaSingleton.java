package practicasingleton;

import entidades.UsuarioSingleton;
import java.sql.SQLException;
import modelo.DatoUsuarioSingleton;

/**
 *
 * @author ronny
 */
public class PracticaSingleton {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws SQLException {
        
        DatoUsuarioSingleton consultaUsuario = DatoUsuarioSingleton.getDatoUsuarioSingleton();
        // TODO code application logic here
        System.out.println("CONSULTANDO DE USUARIO EN LA BASE DE DATOS....");
        consultaUsuario.consulta();  //Consulta información a la BD
        System.out.println(consultaUsuario);
        
        System.out.println("ACTUALIZANDO EL ESTADO DEL USUARIO....");
        UsuarioSingleton usuario = UsuarioSingleton.getUsuarioSingleton();
        if (usuario.getEstado() == "A") {
            usuario.setEstado("I"); //Se setea el atributo estado para actualizar
        } else {
            usuario.setEstado("A"); //Se setea el atributo estado para actualizar
        }
        consultaUsuario.actualiza(); //Se actualiza registro en la base de datos
        
        System.out.println("SE CONSULTA NUEVAMENETE EL USUARIO EN LA BASE DE DATOS PARA CONFIRMAR CAMBIO....");
        consultaUsuario.consulta();//Consulta información a la BD
        System.out.println(consultaUsuario);        
        
    }
    
}
