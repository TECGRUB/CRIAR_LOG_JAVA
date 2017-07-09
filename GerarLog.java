package br.com.tecgrub.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerarLog {
	
    static PrintStream out = null;   
	
    public static void LogRotate(Boolean closed){
    	
    	if ( closed == true ){
    		out.close();
    	}
    	
    	Date logdate = new Date();
    	SimpleDateFormat sf = new SimpleDateFormat("yyyyMMSdd_HHmmss");
    	try {
    		//SE VOCÊ QUISER UM CAMINHO ESPECIFICO PARA OS SEUS LOGS
			//out = new PrintStream(new File(LocaisConfiguracoes.pathLog + "MINHAAPLICACAO_"+sf.format(logdate)+".log"));
			
			//SE VOCê QUISER JOGAR NA AREA DE TRABALHO
			out = new PrintStream(new File(javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory()
					+ "\\MINHAAPLICACAO_"+sf.format(logdate)+".log"));

			;

		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
    	
    	System.setOut(out);
    	System.setErr(out);    	
       	System.out.println("=============================================================");
        System.out.println("====                                                    =====");
        System.out.println("====	T E C G R U B -- A L L -- T E C H N O L O G Y   =====");        
        System.out.println("====                                                    =====");
        System.out.println("============================================================="); 
        
    }
    
    public static void main(String[] args) {
		
    	LogRotate(false);
    	
    	System.out.println("ESCREVENDO NO LOG NA AREA DE TRABALHO" + javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory());
	}
	
}
