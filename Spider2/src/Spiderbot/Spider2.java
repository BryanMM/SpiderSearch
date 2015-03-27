package Spiderbot;

import java.io.BufferedReader;
import EstructurasDeDatos.Cola;
import EstructurasDeDatos.ListaCircularDoble;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.w3c.dom.html.HTMLLinkElement;
public class Spider2 extends Thread{

		private Matcher mTag, mLink;
		private Pattern pTag, pLink, tTag;
		private String url;
                private int indice=0;
                private int lvl=0;                   
		//private Cola<SpiderElement> coso = new Cola();

		private static final String HTML_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
                private static final String HTML_P="(?i)<a([^>]+)>(.+?)</a>";
		private static final String HTML_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";
                private static final String HTML_P_TAG_PATTERN="\"\\\\s*(?i)href\\\\s*=\\\\s*(\\\"([^\\\"]*\\\")|'[^']*'|([^'\\\">\\\\s]+))\"";
                public void run(){
                    try {
                        getSource(url,lvl);
                    } catch (IOException ex) {
                        Logger.getLogger(Spider2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
		public Spider2(String pUrl, int plvl) throws IOException {
			url = pUrl;
                        lvl=plvl;
			pTag = Pattern.compile(HTML_TAG_PATTERN);
			pLink = Pattern.compile(HTML_HREF_TAG_PATTERN);
                        
			//getSource(url);
		}
		public String getSource(String pUrl, int plvl) throws IOException {
                        URL url  = new URL(pUrl);
                        URLConnection yc = url.openConnection();
                        BufferedReader in = new BufferedReader(new InputStreamReader(
                        yc.getInputStream(), "UTF-8"));
                        String inputLine;
                        StringBuilder a = new StringBuilder();
                        while ((inputLine = in.readLine()) != null)
                                a.append(inputLine);
                                in.close();
                                extractHTMLLinks(a.toString(), plvl);
                                return a.toString();
        }
		public Cola<SpiderElement> extractHTMLLinks(final String sourceHtml, int pLvl) {

			Cola<SpiderElement> elements = new Cola();

			mTag = pTag.matcher(sourceHtml);
                        
			while (mTag.find()){
                            

				String href = mTag.group(1);     
				String linkElem = mTag.group(2);
                                
				mLink = pLink.matcher(href);
                               
				while (mLink.find()) {

					String link = mLink.group(1);
                                        //String _tmp = mLink.group(1);
					SpiderElement htmlLinkElement = new SpiderElement();
					htmlLinkElement.setLinkAddress(link);
					htmlLinkElement.setLinkElement(linkElem);
                                        //if(_tmp == href){
                                            htmlLinkElement.setIndice(pLvl) ;
                                        //else{
                                            
					elements.enqueue(htmlLinkElement);
                                        System.out.println(htmlLinkElement.getIndice());
					System.out.println(htmlLinkElement);

				}

			}

			return elements;

		}
	}

