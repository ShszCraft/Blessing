package net.mcshsz.event;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.mcshsz.banned.bug;
import net.mcshsz.config.BssConfig;
import net.mcshsz.html.HtmlHelper;


/**
 * 登陆以后操作对象
 * @author Dream
 *
 */
public class LoginEvents {

	private String messageAdminDefault;
	private String messageAdminPrompt;
	private String messageAnnouncement0;
	private String messageAnnouncement1;
	private String messageAnnouncement2;
	private String messageAnnouncement3;
	private String messageBannedDefault;
	
	private String messageBannedPrompt;
	
	private String messageDefault;
	private String messagePrefix;
	
	private String messagePrompt;
	
	private String messageSkinPrompt;
	private String messageSkinDefault; 
	
	private String messageSetUpSkinDefault;
	private String messageSetUpSkinPrompt;
	
	public LoginEvents(String messageAdminDefault, 
			String messageAdminPrompt, 
			String messageAnnouncement0,
			String messageAnnouncement1, 
			String messageAnnouncement2, 
			String messageAnnouncement3,
			String messageBannedDefault, 
			String messageBannedPrompt, 
			String messageDefault, 
			String messagePrefix, 
			String messagePrompt, 
			String messageSkinDefault, 
			String messageSkinPrompt, 
			String messageSetUpSkinDefault, 
			String messageSetUpSkinPrompt) 
	{
		
		this.messageAdminDefault = messageAdminDefault;
		this.messageAdminPrompt = messageAdminPrompt;
		this.messageAnnouncement0 = messageAnnouncement0;
		this.messageAnnouncement1 = messageAnnouncement1;
		this.messageAnnouncement2 = messageAnnouncement2;
		this.messageAnnouncement3 = messageAnnouncement3;
		this.messageBannedDefault = messageBannedDefault;
		this.messageBannedPrompt = messageBannedPrompt;
		this.messageDefault = messageDefault;
		this.messagePrefix = messagePrefix;
		this.messagePrompt = messagePrompt;
		this.messageSkinPrompt = messageSkinPrompt;
		this.messageSkinDefault = messageSkinDefault;
		this.messageSetUpSkinDefault = messageSetUpSkinDefault;
		this.messageSetUpSkinPrompt = messageSetUpSkinPrompt;
		
		// TODO 自动生成的构造函数存根messageSetUpSkinDefault  messageSetUpSkinPrompt
	}

	public static void main(String a[]){

	}
	/**
	 * 
	 * @param Player 玩家
	 * @param WebUrl 皮肤地址
	 * @param uid	
	 * @param permission	封禁ID
	 * @param username 角色用户账户
	 * @param uid 
	 */
	public void LoginEvent(Player Player, String WebUrl, ArrayList<String> PlayerUser , ArrayList<String> PlayerName){
		String[] sourceStrArray = null;
		String[] sourceStrArrays = null;
		String permission=null;
		String email=null;

		new bug("调试类：LoginEvent; 信息：(玩家："+Player+"; Url:"+WebUrl+"; 皮肤站用户表："+PlayerUser+"; 玩家信息表："+PlayerName+")");
		if(PlayerUser!=null){
			new bug("调试类：LoginEvent; 用户表users：(发现数据："+PlayerUser+")");
			if(PlayerUser.size()>1){
				permission = PlayerUser.get(7);//permission
				email = PlayerUser.get(1);//email
				new bug("调试类：LoginEvent; 用户表users：(email："+email+"; permission:"+permission+")");
			}
			new bug("调试类：LoginEvent; 调试用户表users完成：(email："+email+"; permission:"+permission+")");
		}
		
 
		if(permission==null){
			sourceStrArray = messageSkinDefault.split("\\{WebUrl\\}");
			new bug("调试类：LoginEvent; 字符切割：(messageSkinDefault："+messageSkinDefault+"; sourceStrArray:"+sourceStrArray+")");
			if(sourceStrArray.length>1){
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+WebUrl+sourceStrArray[1]));
				new bug("调试类：LoginEvent; 打印：("+messagePrefix+sourceStrArray[0]+""+WebUrl+sourceStrArray[1]+")");
			}else{
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+messageSkinDefault));
				new bug("调试类：LoginEvent; 打印：("+messagePrefix+messageSkinDefault+")");
			}
			sourceStrArray=null;
			sourceStrArray = messageSkinPrompt.split("\\{WebUrl\\}");
			new bug("调试类：LoginEvent; 字符切割：(messageSkinPrompt："+messageSkinPrompt+"; sourceStrArray:"+sourceStrArray+")");
			if(sourceStrArray.length>1){
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+WebUrl+sourceStrArray[1]));
				new bug("调试类：LoginEvent; 打印：("+messagePrefix+sourceStrArray[0]+""+WebUrl+sourceStrArray[1]+")");
			}else{
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+messageSkinPrompt));
				new bug("调试类：LoginEvent; 打印：("+ messagePrefix+messageSkinPrompt+")");
			}
		}else if(permission.equals("1")){
			//System.out.println("角色登录");
			sourceStrArray = messageDefault.split("\\{name\\}");
			new bug("调试类：LoginEvent; 字符切割：(messageDefault："+messageDefault+"; sourceStrArray:"+sourceStrArray+")");
			if(sourceStrArray.length>1){
				for(Player P :Bukkit.getOnlinePlayers()){
					P.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+Player.getName()+sourceStrArray[1]));
				}
				new bug("调试类：LoginEvent; 打印：("+messagePrefix+sourceStrArray[0]+""+Player.getName()+sourceStrArray[1]+")");
			}else{
				for(Player P :Bukkit.getOnlinePlayers()){
					P.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+messageDefault));
				}
				new bug("调试类：LoginEvent; 打印：("+ messagePrefix+messageDefault+")");
			}
			Player.setOp(true);
			sourceStrArray=null;
			sourceStrArray = messagePrompt.split("\\{name\\}");
			new bug("调试类：LoginEvent; 字符切割：(messagePrompt："+messagePrompt+"; sourceStrArray:"+sourceStrArray+")");
			if(sourceStrArray.length>1){
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+Player.getName()+sourceStrArray[1]));
				new bug("调试类：LoginEvent; 打印：("+ messagePrefix+sourceStrArray[0]+""+Player.getName()+sourceStrArray[1]+")");
			}else{
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+messagePrompt));
				new bug("调试类：LoginEvent; 打印：("+ messagePrefix+messagePrompt+")");
			}
			sourceStrArray=null;
		}else if(permission.equals("2")){
			
			sourceStrArray = messageAdminDefault.split("\\{name\\}");
			new bug("调试类：LoginEvent; 字符切割：(messageAdminDefault："+messageAdminDefault+"; sourceStrArray:"+sourceStrArray+")");
			if(sourceStrArray.length>1){
				for(Player P :Bukkit.getOnlinePlayers()){
					P.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+Player.getName()+sourceStrArray[1]));
				}
				new bug("调试类：LoginEvent; 打印：("+ messagePrefix+sourceStrArray[0]+""+Player.getName()+sourceStrArray[1]+")");
			}else{
				for(Player P :Bukkit.getOnlinePlayers()){
					P.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+messageAdminDefault));
				}
				new bug("调试类：LoginEvent; 打印：("+ messagePrefix+messageAdminDefault+")");
			}
			Player.setOp(true);
			sourceStrArray=null;
			sourceStrArray = messageAdminPrompt.split("\\{name\\}");
			new bug("调试类：LoginEvent; 字符切割：(messageAdminPrompt："+messageAdminPrompt+"; sourceStrArray:"+sourceStrArray+")");
			if(sourceStrArray.length>1){
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+Player.getName()+sourceStrArray[1]));
				new bug("调试类：LoginEvent; 打印：("+ messagePrefix+sourceStrArray[0]+""+Player.getName()+sourceStrArray[1]+")");
			}else{
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+messageAdminPrompt));
				new bug("调试类：LoginEvent; 打印：("+ messagePrefix+messageAdminPrompt+")");
			}
			sourceStrArray=null;
				
		}else if(permission.equals("-1")){
			new bug("封禁玩家");
				
			sourceStrArray= null;
			sourceStrArray = messageBannedDefault.split("\\{username\\}");
			if(sourceStrArray.length>1){
				sourceStrArrays=null;
				sourceStrArrays = messageBannedDefault.split("\\{name\\}");
				if(sourceStrArrays.length>1){
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+email+sourceStrArray[1]+sourceStrArrays[0]+sourceStrArrays[1]));
				}else{
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+email+sourceStrArray[1]));
				}
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+email+sourceStrArray[1]));
			}else{
				Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+messageBannedDefault));
			}
			Player.setBanned(true);
			Player.kickPlayer("您已被封禁");
			//Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l[&4&l封禁管理&6&l]&c&l此帐号已被封禁，相关角色已被禁止！"));
			for(Player P :Bukkit.getOnlinePlayers()){
				P.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+"  "+messageAnnouncement0));
				P.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+"  "+messageAnnouncement1));
				P.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+"  "+messageAnnouncement2));
				P.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+"  "+messageAnnouncement3));
			}
			
		}else if(permission.equals("0")){
			new bug("查询ban");
			if((Player.isBanned())){ // TODO
				new bug("===========发现被封禁玩家============");
				Player.setBanned(false);
			}
		}
		String tid_steve1=null;
		String tid_steve2=null;
		if(PlayerName!=null){
			if(PlayerName.size()>1){
				tid_steve1 = PlayerName.get(4);
				tid_steve2 = PlayerName.get(5);
			}
		}
			
			
		if(tid_steve1!=null&tid_steve2!=null){
			new bug("tid_steve:"+tid_steve1+"    "+tid_steve2);
			if(tid_steve1.equals("0")){
				if(tid_steve2.equals("0")){
						
					sourceStrArray=null;
					sourceStrArray = messageSetUpSkinDefault.split("\\{WebUrl\\}");
					if(sourceStrArray.length>1){
						Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+WebUrl+sourceStrArray[1]));
					}else{
						Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+"  "+messageSetUpSkinDefault));
					}
						
					sourceStrArray=null;
					sourceStrArray = messageSetUpSkinPrompt.split("\\{WebUrl\\}");
					if(sourceStrArray.length>1){
						Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+sourceStrArray[0]+""+WebUrl+sourceStrArray[1]));
					}else{
						Player.sendMessage(ChatColor.translateAlternateColorCodes('&', messagePrefix+"  "+messageSetUpSkinPrompt));
					}	
				}	
			}
		}
		sourceStrArray = null;
		sourceStrArrays = null;
		permission=null;
		email=null;
	}
	
	 
}
