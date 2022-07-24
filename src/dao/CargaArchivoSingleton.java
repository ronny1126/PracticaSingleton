/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author ronny
 */
public class CargaArchivoSingleton {
    private Properties atributos;

    private static CargaArchivoSingleton instance = null;

    private CargaArchivoSingleton() throws IOException {
        cargaArchivoSingleton();
    }

    public Properties getAtributos() {
        return atributos;
    }

    public void setAtributos(Properties atributos) {
        this.atributos = atributos;
    }
    

    private void cargaArchivoSingleton() throws FileNotFoundException, IOException {
        atributos = new Properties();  //creación del archivo propiedades
        InputStream file = new FileInputStream("./src/dao/PropertiesBD.properties");
        atributos.load(file);
    }

    public static CargaArchivoSingleton getInstance() throws IOException {
        if (instance == null) {
            instance = new CargaArchivoSingleton();
        }
        return instance;
    }
}
