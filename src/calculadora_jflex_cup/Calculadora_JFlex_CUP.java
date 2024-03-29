/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora_jflex_cup;

import java.io.File;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author VivianaM
 */
public class Calculadora_JFlex_CUP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
             String[] archFlex={"F:/Act_Lab_UAN/Act_Docente/Asignaturas/Compiladores/Curso 2018-I/Ejemp_Clases/Calculadora_JFlex_CUP/src/calculadora_jflex_cup/an_lexico.flex"};
            jflex.Main.main(archFlex);
        
        // Generación de la clase AnalizadorSintactico.java para el analizador L�xico
            
        String archCUP="F:/Act_Lab_UAN/Act_Docente/Asignaturas/Compiladores/Curso 2018-I/Ejemp_Clases/Calculadora_JFlex_CUP/src/calculadora_jflex_cup/an_sisntactico.cup";
        String[] asintactico = {"-parser", "AnalizadorSintactico", archCUP};
        
         java_cup.Main.main(asintactico);
        
        boolean mvAS = moverArch("AnalizadorSintactico.java");
        boolean mvSym= moverArch("sym.java");  
    }
    
    public static boolean moverArch(String archNombre) {
        boolean efectuado = false;
        File arch = new File(archNombre);
        if (arch.exists()) {
            System.out.println("\n*** Moviendo " + arch + " \n***");
            Path currentRelativePath = Paths.get("");
            String nuevoDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator
                    + "calculadora_jflex_cup" + File.separator + arch.getName();
            File archViejo = new File(nuevoDir);
            archViejo.delete();
            if (arch.renameTo(new File(nuevoDir))) {
                System.out.println("\n*** Generado " + archNombre + "***\n");
                efectuado = true;
            } else {
                System.out.println("\n*** No movido " + archNombre + " ***\n");
            }

        } else {
            System.out.println("\n*** Codigo no existente ***\n");
        }
        return efectuado;
    }
    
    
}
