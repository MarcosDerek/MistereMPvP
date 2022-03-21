package me.main.Events;

import me.main.Kits.KitsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {
	@EventHandler
	public void playerDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		KitsManager.kitpvp.remove(p.getName());
		e.setDeathMessage(null);
		e.getDrops().clear();
	}
}
