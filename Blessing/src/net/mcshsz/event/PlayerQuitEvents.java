package net.mcshsz.event;

import org.bukkit.entity.Player;

/**
 * 登出系统操作对象
 * @author Dream
 *
 */
public class PlayerQuitEvents {

	public PlayerQuitEvents() {
		// TODO 自动生成的构造函数存根
	}

	public void PlayerQuitEvent(Player Player){
		if(Player.isOp()){
			Player.setOp(false);
		}
	}
}
