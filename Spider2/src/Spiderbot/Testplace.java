package Spiderbot;
import java.io.IOException;
import java.util.*;

public class Testplace {

	public static void main(String[] args) throws IOException {
		 ArrayList<String> listaurl = new ArrayList<String>();
                 listaurl.add("http://www.vadenumeros.es/primero/sistemas-gauss.htm");
                 listaurl.add("https://docs.oracle.com/javase/tutorial/essential/regex/matcher.html");
                 listaurl.add("https://docs.oracle.com/javase/tutorial/essential/regex/pattern.html");
                 listaurl.add("http://www.javaforstudents.co.uk/Loops");
                 
                 for(int i=0 ; i <listaurl.size(); i++){
                      Spider2 coso = new Spider2(listaurl.get(i),i);
                 coso.start();
                 }
		
		 
		 
		 
		

	}

}
