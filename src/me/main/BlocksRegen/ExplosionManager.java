package me.main.BlocksRegen;

import java.util.List;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;

import me.main.Main;

public class ExplosionManager implements Listener {
	Main plugin;

	public ExplosionManager(Main main) {
		this.plugin = main;
	}

	@EventHandler
	public void onExplotionEntity(EntityExplodeEvent e) {
		List<Block> blocks = e.blockList();
		(new BlocksRegen(blocks)).runTaskTimer((Plugin) this.plugin, 1L, 1L);
		e.setYield(0.0F);
	}

	@EventHandler
	public void onExplotionBlock(BlockExplodeEvent e) {
		List<Block> blocks = e.blockList();
		(new BlocksRegen(blocks)).runTaskTimer((Plugin) this.plugin, 1L, 1L);
		e.setYield(0.0F);
		e.getBlock().getState().getWorld().playSound(e.getBlock().getState().getLocation(), Sound.STEP_WOOD, 1.0F,
				1.0F);
	}
}