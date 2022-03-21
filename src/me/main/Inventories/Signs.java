package me.main.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

public class Signs implements Listener {
	private Inventory soupInv = Bukkit.getServer().createInventory(null, 36);

	private Inventory instaHealthInv = Bukkit.getServer().createInventory(null, 36);

	private Inventory strengthInv = Bukkit.getServer().createInventory(null, 36);

	private Inventory speedInv = Bukkit.getServer().createInventory(null, 36);

	public Signs() {
		byte b;
		int i;
		ItemStack[] arrayOfItemStack;
		for (i = (arrayOfItemStack = this.instaHealthInv.getContents()).length, b = 0; b < i;) {
			ItemStack itemStack = arrayOfItemStack[b];
			if (itemStack == null) {
				ItemStack instaHealth = new ItemStack(Material.POTION);
				PotionMeta instaHealthMeta = (PotionMeta) instaHealth.getItemMeta();
				// instaHealthMeta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL,
				// false, true));
				instaHealth.setItemMeta((ItemMeta) instaHealthMeta);
				this.instaHealthInv.addItem(new ItemStack[] { new ItemStack(instaHealth) });
			}
			b++;
		}
		for (i = (arrayOfItemStack = this.strengthInv.getContents()).length, b = 0; b < i;) {
			ItemStack itemStack = arrayOfItemStack[b];
			if (itemStack == null) {
				ItemStack strength = new ItemStack(Material.POTION);
				PotionMeta strengthMeta = (PotionMeta) strength.getItemMeta();
				// strengthMeta.setBasePotionData(new PotionData(PotionType.STRENGTH, true,
				// false));
				strength.setItemMeta((ItemMeta) strengthMeta);
				this.strengthInv.addItem(new ItemStack[] { new ItemStack(strength) });
			}
			b++;
		}
		for (i = (arrayOfItemStack = this.speedInv.getContents()).length, b = 0; b < i;) {
			ItemStack itemStack = arrayOfItemStack[b];
			if (itemStack == null) {
				ItemStack speed = new ItemStack(Material.POTION);
				PotionMeta speedMeta = (PotionMeta) speed.getItemMeta();
				// speedMeta.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
				speed.setItemMeta((ItemMeta) speedMeta);
				this.speedInv.addItem(new ItemStack[] { new ItemStack(speed) });
			}
			b++;
		}
		for (i = (arrayOfItemStack = this.soupInv.getContents()).length, b = 0; b < i;) {
			ItemStack itemStack = arrayOfItemStack[b];
			if (itemStack == null) {
				ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
				ItemStack itemsoup = new ItemStack(soup);
				this.soupInv.addItem(new ItemStack[] { new ItemStack(itemsoup) });
			}
			b++;
		}
	}

	@EventHandler
	public void signChange(SignChangeEvent event) {
		if (event.getLine(0).equalsIgnoreCase("[soup]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "FREE");
			event.setLine(2, ChatColor.GREEN + ChatColor.BOLD.toString() + "SOUPS");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
		if (event.getLine(0).equalsIgnoreCase("[insta health]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "FREE");
			event.setLine(2, ChatColor.RED + ChatColor.BOLD.toString() + "INSTA HEALTH POT");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
		if (event.getLine(0).equalsIgnoreCase("[speed]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "FREE");
			event.setLine(2, ChatColor.AQUA + ChatColor.BOLD.toString() + "SPEED POT");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
		if (event.getLine(0).equalsIgnoreCase("[strength]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "FREE");
			event.setLine(2, ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "STRENGTH POT");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
		if (event.getLine(0).equalsIgnoreCase("[sharp]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "FREE");
			event.setLine(2, ChatColor.GREEN + ChatColor.BOLD.toString() + "SHARPNESS");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
		if (event.getLine(0).equalsIgnoreCase("[knockback]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "FREE");
			event.setLine(2, ChatColor.GREEN + ChatColor.BOLD.toString() + "KNOCKBACK");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
		if (event.getLine(0).equalsIgnoreCase("[easy]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Easy Level");
			event.setLine(2, ChatColor.GREEN + ChatColor.BOLD.toString() + "Completed");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
		if (event.getLine(0).equalsIgnoreCase("[normal]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Normal Level");
			event.setLine(2, ChatColor.GREEN + ChatColor.BOLD.toString() + "Completed");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
		if (event.getLine(0).equalsIgnoreCase("[hard]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Hard Level");
			event.setLine(2, ChatColor.GREEN + ChatColor.BOLD.toString() + "Completed");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
		if (event.getLine(0).equalsIgnoreCase("[extreme]")) {
			event.setLine(0, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
			event.setLine(1, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Extreme Level");
			event.setLine(2, ChatColor.GREEN + ChatColor.BOLD.toString() + "Completed");
			event.setLine(3, ChatColor.BLACK + ChatColor.BOLD.toString() + "===============");
		}
	}

	@EventHandler
	public void openSignSoup(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;
		if (event.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) event.getClickedBlock().getState();
			if (s.getLine(2).equalsIgnoreCase(ChatColor.GREEN + ChatColor.BOLD.toString() + "SOUPS"))
				p.openInventory(this.soupInv);
			if (s.getLine(2).equalsIgnoreCase(ChatColor.RED + ChatColor.BOLD.toString() + "INSTA HEALTH POT"))
				p.openInventory(this.instaHealthInv);
			if (s.getLine(2).equalsIgnoreCase(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "STRENGTH POT"))
				p.openInventory(this.strengthInv);
			if (s.getLine(2).equalsIgnoreCase(ChatColor.AQUA + ChatColor.BOLD.toString() + "SPEED POT"))
				p.openInventory(this.speedInv);
			if (s.getLine(2).equalsIgnoreCase(ChatColor.GREEN + ChatColor.BOLD.toString() + "SHARPNESS"))
				if (p.getInventory().getItemInHand().getType() == Material.WOOD_SWORD
						|| p.getInventory().getItemInHand().getType() == Material.STONE_SWORD
						|| p.getInventory().getItemInHand().getType() == Material.IRON_SWORD
						|| p.getInventory().getItemInHand().getType() == Material.GOLD_SWORD
						|| p.getInventory().getItemInHand().getType() == Material.DIAMOND_SWORD) {
					p.getInventory().getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
				} else {
					p.sendMessage(ChatColor.RED + "This item cannot be enchanted");
				}
			if (s.getLine(2).equalsIgnoreCase(ChatColor.GREEN + ChatColor.BOLD.toString() + "KNOCKBACK"))
				if (p.getInventory().getItemInHand().getType() == Material.WOOD_SWORD
						|| p.getInventory().getItemInHand().getType() == Material.STONE_SWORD
						|| p.getInventory().getItemInHand().getType() == Material.IRON_SWORD
						|| p.getInventory().getItemInHand().getType() == Material.GOLD_SWORD
						|| p.getInventory().getItemInHand().getType() == Material.DIAMOND_SWORD) {
					p.getInventory().getItemInHand().addEnchantment(Enchantment.KNOCKBACK, 1);
				} else {
					p.sendMessage(ChatColor.RED + "This item cannot be enchanted");
				}
			if (s.getLine(1).equalsIgnoreCase(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Easy Level")) {
				p.sendMessage(ChatColor.GREEN + "Congratulations, you completed the easy level of lava challenge.");
				Location lavaSpawn = new Location(Bukkit.getServer().getWorld("lava"), 0.5D, 30.5D, 0.5D, 180.0F, 0.0F);
				p.teleport(lavaSpawn);
				p.getInventory().clear();
				p.setHealth(20.0D);
				p.setFoodLevel(20);
				p.setGameMode(GameMode.SURVIVAL);
				p.getInventory().setItem(0, new ItemStack(Material.WOOD_SWORD));
				ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
				byte b;
				int i;
				ItemStack[] arrayOfItemStack;
				for (i = (arrayOfItemStack = p.getInventory().getContents()).length, b = 0; b < i;) {
					ItemStack itemStack = arrayOfItemStack[b];
					if (itemStack == null) {
						ItemStack itemsoup = new ItemStack(soup);
						p.getInventory().addItem(new ItemStack[] { new ItemStack(itemsoup) });
					}
					b++;
				}
			}
			if (s.getLine(1).equalsIgnoreCase(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Normal Level")) {
				p.sendMessage(ChatColor.GREEN + "Congratulations, you completed the normal level of lava challenge.");
				Location lavaSpawn = new Location(Bukkit.getServer().getWorld("lava"), 0.5D, 30.5D, 0.5D, 180.0F, 0.0F);
				p.teleport(lavaSpawn);
				p.getInventory().clear();
				p.setHealth(20.0D);
				p.setFoodLevel(20);
				p.setGameMode(GameMode.SURVIVAL);
				p.getInventory().setItem(0, new ItemStack(Material.WOOD_SWORD));
				ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
				byte b;
				int i;
				ItemStack[] arrayOfItemStack;
				for (i = (arrayOfItemStack = p.getInventory().getContents()).length, b = 0; b < i;) {
					ItemStack itemStack = arrayOfItemStack[b];
					if (itemStack == null) {
						ItemStack itemsoup = new ItemStack(soup);
						p.getInventory().addItem(new ItemStack[] { new ItemStack(itemsoup) });
					}
					b++;
				}
			}
			if (s.getLine(1).equalsIgnoreCase(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Hard Level")) {
				p.sendMessage(ChatColor.GREEN + "Congratulations, you completed the hard level of lava challenge.");
				Bukkit.getServer()
						.broadcastMessage(ChatColor.BLUE + "The player " + ChatColor.DARK_BLUE + p.getName().toString()
								+ ChatColor.BLUE + " completed " + ChatColor.RED + "the hard level" + ChatColor.BLUE
								+ " of lava challenge. ");
				Location lavaSpawn = new Location(Bukkit.getServer().getWorld("lava"), 0.5D, 30.5D, 0.5D, 180.0F, 0.0F);
				p.teleport(lavaSpawn);
				p.getInventory().clear();
				p.setHealth(20.0D);
				p.setFoodLevel(20);
				p.setGameMode(GameMode.SURVIVAL);
				p.getInventory().setItem(0, new ItemStack(Material.WOOD_SWORD));
				ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
				byte b;
				int i;
				ItemStack[] arrayOfItemStack;
				for (i = (arrayOfItemStack = p.getInventory().getContents()).length, b = 0; b < i;) {
					ItemStack itemStack = arrayOfItemStack[b];
					if (itemStack == null) {
						ItemStack itemsoup = new ItemStack(soup);
						p.getInventory().addItem(new ItemStack[] { new ItemStack(itemsoup) });
					}
					b++;
				}
			}
			if (s.getLine(1).equalsIgnoreCase(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Extreme Level")) {
				p.sendMessage(ChatColor.GREEN + "Congratulations, you completed the extreme level of lava challenge.");
				Bukkit.getServer()
						.broadcastMessage(ChatColor.BLUE + "The player " + ChatColor.DARK_BLUE + p.getName().toString()
								+ ChatColor.BLUE + " completed " + ChatColor.DARK_RED + "the extreme level"
								+ ChatColor.BLUE + " of lava challenge. ");
				Location lavaSpawn = new Location(Bukkit.getServer().getWorld("lava"), 0.5D, 30.5D, 0.5D, 180.0F, 0.0F);
				p.teleport(lavaSpawn);
				p.getInventory().clear();
				p.setHealth(20.0D);
				p.setFoodLevel(20);
				p.setGameMode(GameMode.SURVIVAL);
				p.getInventory().setItem(0, new ItemStack(Material.WOOD_SWORD));
				ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
				byte b;
				int i;
				ItemStack[] arrayOfItemStack;
				for (i = (arrayOfItemStack = p.getInventory().getContents()).length, b = 0; b < i;) {
					ItemStack itemStack = arrayOfItemStack[b];
					if (itemStack == null) {
						ItemStack itemsoup = new ItemStack(soup);
						p.getInventory().addItem(new ItemStack[] { new ItemStack(itemsoup) });
					}
					b++;
				}
			}
		}
	}
}