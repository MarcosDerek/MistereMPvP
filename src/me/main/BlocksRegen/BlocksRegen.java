package me.main.BlocksRegen;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.scheduler.BukkitRunnable;

public class BlocksRegen extends BukkitRunnable {
	ArrayList<BlockState> updateBlockList = new ArrayList<>();

	public BlocksRegen(List<Block> blocks) {
		for (Block b : blocks)
			this.updateBlockList.add(b.getState());
	}

	public void run() {
		int max = this.updateBlockList.size() - 1;
		if (max > -1) {
			if (!((BlockState) this.updateBlockList.get(max)).getType().equals(Material.TNT))
				((BlockState) this.updateBlockList.get(max)).update(true, false);
			this.updateBlockList.remove(max);
		}
	}
}
