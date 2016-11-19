package net.mcshsz.html;

import static java.lang.System.out;  

import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.net.URL;
import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.mcshsz.config.InsertDB;  

public class HtmlHelper implements Listener{
	/**
	 * "http://skin.mcshsz.net/csl/Dream.json";
	 * @param uid 
	 * @param urlstring 传入玩家皮肤站的URL，获取玩家皮肤！
	 * @return 返回：玩家是否有皮肤！
	 */
    public static boolean WebUrl(ArrayList<String> uid, String urlstring){
    	ArrayList<String> Web = new ArrayList<String>();
    	InputStream is = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            URL url = new URL(urlstring);  
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));  

            String line = null;  
            while ((line = br.readLine()) != null) {  
            	Web.add(line);
            }
        } catch (IOException ioe) {
            //ioe.printStackTrace();  
            return false;
        } finally {  
        	try {
        		if (is != null) {
        			is.close();
        		}
        	} catch (IOException ignore) {
            	return false;
        	}  
        	try {
        		if (br != null) {
        			br.close();
        		}
        	} catch (IOException ignore) {
        		return false;
        	}  
        	try {
        		if (bw != null) {
        			bw.close();
        		}
        	} catch (IOException ignore) {
        		return false;
        	}  
        }
        int maxSplit = 2;
        String[] Webs = Web.get(0).split("errno", maxSplit);
        if(Webs.length>1){
        	return true;
        }
		return false;
    }
    
    
    
    public static boolean main(Player Player, String textures1, String textures2){
    	
  
    	
		return false;
    }
}
