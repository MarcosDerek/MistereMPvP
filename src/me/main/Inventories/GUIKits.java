package me.main.Inventories;

import java.util.Arrays;
import me.main.Kits.KitType;
import me.main.Kits.KitsManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIKits implements Listener {
  private Inventory kitsInv1;
  
  private Inventory kitsInv2;
  
  public void openGUIKits(Player p) {
    this.kitsInv1 = Bukkit.getServer().createInventory(null, 54, ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Kits");
    this.kitsInv2 = Bukkit.getServer().createInventory(null, 54, ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Kits");
    
    ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta pvpMeta = pvp.getItemMeta();
    pvpMeta.setDisplayName(ChatColor.GREEN + "PVP");
    pvpMeta.setLore(Arrays.asList(new String[] { "Use sua espada para matar seus adversarios." }));
    pvp.setItemMeta(pvpMeta);
    
    ItemStack archer = new ItemStack(Material.BOW);
    ItemMeta archerMeta = archer.getItemMeta();
    archerMeta.setDisplayName(ChatColor.GREEN + "Archer");
    archer.setItemMeta(archerMeta);
    
    ItemStack grandpa = new ItemStack(Material.STICK);
    ItemMeta grandpaMeta = grandpa.getItemMeta();
    grandpaMeta.setDisplayName(ChatColor.GREEN + "Grandpa");
    grandpaMeta.setLore(Arrays.asList(new String[] { "Jogue seus adversarios para longe com seu graveto." }));
    grandpa.setItemMeta(grandpaMeta);
    
    ItemStack anchor = new ItemStack(Material.ANVIL);
    ItemMeta anchorMeta = anchor.getItemMeta();
    anchorMeta.setDisplayName(ChatColor.GREEN + "Anchor");
    anchorMeta.setLore(Arrays.asList(new String[] { "Nao tome e nem de repulsao." }));
    anchor.setItemMeta(anchorMeta);
    
    ItemStack camel = new ItemStack(Material.SAND);
    ItemMeta camelMeta = camel.getItemMeta();
    camelMeta.setDisplayName(ChatColor.GREEN + "Camel");
    camelMeta.setLore(Arrays.asList(new String[] { "Ande sobre areia e ganhe velocidade." }));
    camel.setItemMeta(camelMeta);
    
    ItemStack endermage = new ItemStack(Material.ENDER_PORTAL_FRAME);
    ItemMeta endermageMeta = endermage.getItemMeta();
    endermageMeta.setDisplayName(ChatColor.GREEN + "Endermage");
    endermageMeta.setLore(Arrays.asList(new String[] { "Puxe seus adversarios com seu portal." }));
    endermage.setItemMeta(endermageMeta);
    
    ItemStack fireman = new ItemStack(Material.WATER_BUCKET);
    ItemMeta firemanMeta = fireman.getItemMeta();
    firemanMeta.setDisplayName(ChatColor.GREEN + "Fireman");
    firemanMeta.setLore(Arrays.asList(new String[] { "Nao tome dano de fogo e raios." }));
    fireman.setItemMeta(firemanMeta);
    
    ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
    ItemMeta fishermanMeta = fisherman.getItemMeta();
    fishermanMeta.setDisplayName(ChatColor.GREEN + "Fisherman");
    fishermanMeta.setLore(Arrays.asList(new String[] { "Puxe seus adversarios com sua vara de pesca." }));
    fisherman.setItemMeta(fishermanMeta);
    
    ItemStack flash = new ItemStack(Material.REDSTONE_TORCH_ON);
    ItemMeta flashMeta = flash.getItemMeta();
    flashMeta.setDisplayName(ChatColor.GREEN + "Flash");
    flashMeta.setLore(Arrays.asList(new String[] { "Se teletransporte com sua tocha." }));
    flash.setItemMeta(flashMeta);
    
    ItemStack gladiator = new ItemStack(Material.IRON_BARDING);
    ItemMeta gladiatorMeta = gladiator.getItemMeta();
    gladiatorMeta.setDisplayName(ChatColor.GREEN + "Gladiator");
    gladiatorMeta.setLore(Arrays.asList(new String[] { "Puxe seus adversario para 1v1." }));
    gladiator.setItemMeta(gladiatorMeta);
    
    ItemStack glider = new ItemStack(Material.FEATHER);
    ItemMeta gliderMeta = glider.getItemMeta();
    gliderMeta.setDisplayName(ChatColor.GREEN + "Glider");
    gliderMeta.setLore(Arrays.asList(new String[] { "Toda vez que cair, voce ira flutuar." }));
    glider.setItemMeta(gliderMeta);
    
    ItemStack grappler = new ItemStack(Material.LEASH);
    ItemMeta grapplerMeta = grappler.getItemMeta();
    grapplerMeta.setDisplayName(ChatColor.GREEN + "Grappler");
    grapplerMeta.setLore(Arrays.asList(new String[] { "Use seu lapara se puxar." }));
    grappler.setItemMeta(grapplerMeta);
    
    ItemStack hermit = new ItemStack(Material.BOWL);
    ItemMeta hermitMeta = hermit.getItemMeta();
    hermitMeta.setDisplayName(ChatColor.GREEN + "Hermit");
    hermitMeta.setLore(Arrays.asList(new String[] { "Ganhe 3 sopa a cada minuto e tambem quando matar um adversario." }));
    hermit.setItemMeta(hermitMeta);
    
    ItemStack hulk = new ItemStack(Material.DISPENSER);
    ItemMeta hulkMeta = hulk.getItemMeta();
    hulkMeta.setDisplayName(ChatColor.GREEN + "Hulk");
    hulkMeta.setLore(Arrays.asList(new String[] { "Pegue e lance seus adversarios." }));
    hulk.setItemMeta(hulkMeta);
    
    ItemStack kangaroo = new ItemStack(Material.FIREWORK);
    ItemMeta kangarooMeta = kangaroo.getItemMeta();
    kangarooMeta.setDisplayName(ChatColor.GREEN + "Kangaroo");
    kangarooMeta.setLore(Arrays.asList(new String[] { "Pule usando seu foguete." }));
    kangaroo.setItemMeta(kangarooMeta);
    
    ItemStack ninja = new ItemStack(Material.NETHER_STAR);
    ItemMeta ninjaMeta = ninja.getItemMeta();
    ninjaMeta.setDisplayName(ChatColor.GREEN + "Ninja");
    ninjaMeta.setLore(Arrays.asList(new String[] { "Abaixe e va para traz de seu adversario." }));
    ninja.setItemMeta(ninjaMeta);
    
    ItemStack phantom = new ItemStack(Material.FEATHER);
    ItemMeta phantomMeta = phantom.getItemMeta();
    phantomMeta.setDisplayName(ChatColor.GREEN + "Phantom");
    phantomMeta.setLore(Arrays.asList(new String[] { "Use sua pena para voar por 5 segundos." }));
    phantom.setItemMeta(phantomMeta);
    
    ItemStack poseidon = new ItemStack(Material.WATER_BUCKET);
    ItemMeta poseidonMeta = poseidon.getItemMeta();
    poseidonMeta.setDisplayName(ChatColor.GREEN + "Poseidon");
    poseidonMeta.setLore(Arrays.asList(new String[] { "" }));
    poseidon.setItemMeta(poseidonMeta);
    
    ItemStack pyro = new ItemStack(Material.FIREBALL);
    ItemMeta pyroMeta = pyro.getItemMeta();
    pyroMeta.setDisplayName(ChatColor.GREEN + "Pyro");
    pyroMeta.setLore(Arrays.asList(new String[] { "Lance bolas de fogo em seus adversarios." }));
    pyro.setItemMeta(pyroMeta);
    
    ItemStack reaper = new ItemStack(Material.WOOD_HOE);
    ItemMeta reaperMeta = reaper.getItemMeta();
    reaperMeta.setDisplayName(ChatColor.GREEN + "Reaper");
    reaperMeta.setLore(Arrays.asList(new String[] { "Use sua enxada para enfectar seu adversario com efeito do wither skeleton." }));
    reaper.setItemMeta(reaperMeta);
    
    ItemStack snail = new ItemStack(Material.SAND);
    ItemMeta snailMeta = snail.getItemMeta();
    snailMeta.setDisplayName(ChatColor.GREEN + "Snail");
    snailMeta.setLore(Arrays.asList(new String[] { "Tenha a chance de dar lentidao 2 em seus adversarios." }));
    snail.setItemMeta(snailMeta);
    
    ItemStack specialist = new ItemStack(Material.ENCHANTMENT_TABLE);
    ItemMeta specialistMeta = specialist.getItemMeta();
    specialistMeta.setDisplayName(ChatColor.GREEN + "Specialist");
    specialistMeta.setLore(Arrays.asList(new String[] { "Use sua mesa de encantamento para encantar seus equipamentos." }));
    specialist.setItemMeta(specialistMeta);
    
    ItemStack spectre = new ItemStack(Material.POTION);
    ItemMeta spectreMeta = spectre.getItemMeta();
    spectreMeta.setDisplayName(ChatColor.GREEN + "Spectre");
    spectreMeta.setLore(Arrays.asList(new String[] { "Use sua porde invisibilidade para surpriender seus inimigos." }));
    spectre.setItemMeta(spectreMeta);
    
    ItemStack stomper = new ItemStack(Material.ANVIL);
    ItemMeta stomperMeta = stomper.getItemMeta();
    stomperMeta.setDisplayName(ChatColor.GREEN + "Stomper");
    stomperMeta.setLore(Arrays.asList(new String[] { "Pule em cima de seus adversarios para matar eles." }));
    stomper.setItemMeta(stomperMeta);
    
    ItemStack switcher = new ItemStack(Material.SNOW_BALL);
    ItemMeta switcherMeta = switcher.getItemMeta();
    switcherMeta.setDisplayName(ChatColor.GREEN + "Switcher");
    switcherMeta.setLore(Arrays.asList(new String[] { "Jogue bolas de neve em seus adversarios e troque de lugar com eles." }));
    switcher.setItemMeta(switcherMeta);
    
    ItemStack tank = new ItemStack(Material.TNT);
    ItemMeta tankMeta = tank.getItemMeta();
    tankMeta.setDisplayName(ChatColor.GREEN + "Tank");
    tankMeta.setLore(Arrays.asList(new String[] { "Toda vez que morrer exploda e tenha a chance de matar seus adversarios." }));
    tank.setItemMeta(tankMeta);
    
    ItemStack thor = new ItemStack(Material.WOOD_AXE);
    ItemMeta thorMeta = thor.getItemMeta();
    thorMeta.setDisplayName(ChatColor.GREEN + "Thor");
    thorMeta.setLore(Arrays.asList(new String[] { "Use seu machado para invocar um raio." }));
    thor.setItemMeta(thorMeta);
    
    ItemStack turtle = new ItemStack(Material.BRICK);
    ItemMeta turtleMeta = turtle.getItemMeta();
    turtleMeta.setDisplayName(ChatColor.GREEN + "Turtle");
    turtleMeta.setLore(Arrays.asList(new String[] { "Abaixe e tome pouco dano." }));
    turtle.setItemMeta(turtleMeta);
    
    ItemStack urgal = new ItemStack(Material.POTION);
    ItemMeta urgalMeta = urgal.getItemMeta();
    urgalMeta.setDisplayName(ChatColor.GREEN + "Urgal");
    urgalMeta.setLore(Arrays.asList(new String[] { "Tenha a chance de ter efeito de força."}));
    urgal.setItemMeta(urgalMeta);
    
    ItemStack viking = new ItemStack(Material.DIAMOND_AXE);
    ItemMeta vikingMeta = viking.getItemMeta();
    vikingMeta.setDisplayName(ChatColor.GREEN + "Viking");
    vikingMeta.setLore(Arrays.asList(new String[] { "Mate seus inimigos com meu machado." }));
    viking.setItemMeta(vikingMeta);
    ItemStack viper = new ItemStack(Material.SPIDER_EYE);
    ItemMeta viperMeta = viper.getItemMeta();
    viperMeta.setDisplayName(ChatColor.GREEN + "Viper");
    viperMeta.setLore(Arrays.asList(new String[] { "Tenha a chance de envenenar seus adversarios." }));
    viper.setItemMeta(viperMeta);
    ItemStack nextpage = new ItemStack(Material.CARPET);
    ItemMeta nextpageMeta = nextpage.getItemMeta();
    nextpageMeta.setDisplayName(ChatColor.GREEN + "Next page");
    nextpage.setItemMeta(nextpageMeta);
    ItemStack backpage = new ItemStack(Material.CARPET);
    ItemMeta backpageMeta = backpage.getItemMeta();
    backpageMeta.setDisplayName(ChatColor.GREEN + "Back page");
    backpage.setItemMeta(backpageMeta);
    ItemStack background = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getData());
    ItemMeta backgroundMeta = background.getItemMeta();
    backgroundMeta.setDisplayName(null);
    background.setItemMeta(backgroundMeta);
    this.kitsInv1.setItem(8, nextpage);
    this.kitsInv1.setItem(11, pvp);
    this.kitsInv1.setItem(13, archer);
    this.kitsInv1.setItem(15, grandpa);
    this.kitsInv1.setItem(28, anchor);
    this.kitsInv1.setItem(30, camel);
    this.kitsInv1.setItem(31, endermage);
    this.kitsInv1.setItem(32, fireman);
    this.kitsInv1.setItem(33, fisherman);
    this.kitsInv1.setItem(34, flash);
    this.kitsInv1.setItem(37, gladiator);
    this.kitsInv1.setItem(38, glider);
    this.kitsInv1.setItem(39, grappler);
    this.kitsInv1.setItem(40, hermit);
    this.kitsInv1.setItem(41, hulk);
    this.kitsInv1.setItem(42, kangaroo);
    this.kitsInv1.setItem(0, background);
    this.kitsInv1.setItem(1, background);
    this.kitsInv1.setItem(2, background);
    this.kitsInv1.setItem(3, background);
    this.kitsInv1.setItem(4, background);
    this.kitsInv1.setItem(5, background);
    this.kitsInv1.setItem(6, background);
    this.kitsInv1.setItem(7, background);
    this.kitsInv1.setItem(9, background);
    this.kitsInv1.setItem(10, background);
    this.kitsInv1.setItem(12, background);
    this.kitsInv1.setItem(14, background);
    this.kitsInv1.setItem(16, background);
    this.kitsInv1.setItem(17, background);
    this.kitsInv1.setItem(18, background);
    this.kitsInv1.setItem(19, background);
    this.kitsInv1.setItem(20, background);
    this.kitsInv1.setItem(21, background);
    this.kitsInv1.setItem(22, background);
    this.kitsInv1.setItem(23, background);
    this.kitsInv1.setItem(24, background);
    this.kitsInv1.setItem(25, background);
    this.kitsInv1.setItem(26, background);
    this.kitsInv1.setItem(27, background);
    this.kitsInv1.setItem(35, background);
    this.kitsInv1.setItem(36, background);
    this.kitsInv1.setItem(44, background);
    this.kitsInv1.setItem(45, background);
    this.kitsInv1.setItem(46, background);
    this.kitsInv1.setItem(47, background);
    this.kitsInv1.setItem(48, background);
    this.kitsInv1.setItem(49, background);
    this.kitsInv1.setItem(50, background);
    this.kitsInv1.setItem(51, background);
    this.kitsInv1.setItem(52, background);
    this.kitsInv1.setItem(53, background);
    this.kitsInv2.setItem(0, backpage);
    this.kitsInv2.setItem(10, ninja);
    this.kitsInv2.setItem(11, phantom);
    this.kitsInv2.setItem(12, poseidon);
    this.kitsInv2.setItem(13, pyro);
    this.kitsInv2.setItem(14, reaper);
    this.kitsInv2.setItem(15, snail);
    this.kitsInv2.setItem(16, specialist);
    this.kitsInv2.setItem(19, stomper);
    this.kitsInv2.setItem(20, switcher);
    this.kitsInv2.setItem(21, tank);
    this.kitsInv2.setItem(22, thor);
    this.kitsInv2.setItem(23, turtle);
    this.kitsInv2.setItem(24, urgal);
    this.kitsInv2.setItem(25, viper);
    this.kitsInv2.setItem(1, background);
    this.kitsInv2.setItem(2, background);
    this.kitsInv2.setItem(3, background);
    this.kitsInv2.setItem(4, background);
    this.kitsInv2.setItem(5, background);
    this.kitsInv2.setItem(6, background);
    this.kitsInv2.setItem(7, background);
    this.kitsInv2.setItem(8, background);
    this.kitsInv2.setItem(9, background);
    this.kitsInv2.setItem(17, background);
    this.kitsInv2.setItem(18, background);
    this.kitsInv2.setItem(26, background);
    this.kitsInv2.setItem(27, background);
    this.kitsInv2.setItem(28, background);
    this.kitsInv2.setItem(29, background);
    this.kitsInv2.setItem(30, background);
    this.kitsInv2.setItem(31, background);
    this.kitsInv2.setItem(32, background);
    this.kitsInv2.setItem(33, background);
    this.kitsInv2.setItem(34, background);
    this.kitsInv2.setItem(35, background);
    this.kitsInv2.setItem(36, background);
    this.kitsInv2.setItem(37, background);
    this.kitsInv2.setItem(38, background);
    this.kitsInv2.setItem(39, background);
    this.kitsInv2.setItem(40, background);
    this.kitsInv2.setItem(41, background);
    this.kitsInv2.setItem(42, background);
    this.kitsInv2.setItem(43, background);
    this.kitsInv2.setItem(44, background);
    this.kitsInv2.setItem(45, background);
    this.kitsInv2.setItem(46, background);
    this.kitsInv2.setItem(47, background);
    this.kitsInv2.setItem(48, background);
    this.kitsInv2.setItem(49, background);
    this.kitsInv2.setItem(50, background);
    this.kitsInv2.setItem(51, background);
    this.kitsInv2.setItem(52, background);
    this.kitsInv2.setItem(53, background);
    p.openInventory(this.kitsInv1);
  }
  
  @EventHandler
  public void playerInteract(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    Action a = e.getAction();
    if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
      if (e.getItem() == null)
        return; 
      if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Kits")) {
        e.setCancelled(true);
        openGUIKits(p);
      } 
    } 
  }
  
  @EventHandler
  public void inventoryClick(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();
    String pn = p.getName();
    if (e.getView().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Kits") && e.getWhoClicked().getType() == EntityType.PLAYER) {
      e.setCancelled(true);
      if (e.getCurrentItem().getType() == Material.CARPET) {
        e.setCancelled(true);
        p.closeInventory();
        p.openInventory(this.kitsInv2);
      } 
      if (e.getCurrentItem().getType() == Material.CARPET) {
        e.setCancelled(true);
        p.closeInventory();
        openGUIKits(p);
      } 
      if (e.getCurrentItem().getType() == Material.ANVIL)
        if (p.hasPermission("mplugin.kits.anchor")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.ANCHOR);
          KitsManager.getKit(p, KitType.ANCHOR);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }
      if (e.getCurrentItem().getType() == Material.BOW) {
        p.closeInventory();
        p.getInventory().clear();
        KitsManager.kitpvp.put(pn, KitType.ARCHER);
        KitsManager.getKit(p, KitType.ARCHER);
      } 
      if (e.getCurrentItem().getType() == Material.SAND)
        if (p.hasPermission("mplugin.kits.camel")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.ARCHER);
          KitsManager.getKit(p, KitType.ARCHER);
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.CAMEL);
          KitsManager.getKit(p, KitType.CAMEL);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.ENDER_PORTAL_FRAME)
        if (p.hasPermission("mplugin.kits.endermage")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.ENDERMAGE);
          KitsManager.getKit(p, KitType.ENDERMAGE);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.WATER_BUCKET)
        if (p.hasPermission("mplugin.kits.fireman")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.FIREMAN);
          KitsManager.getKit(p, KitType.FIREMAN);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.FISHING_ROD)
        if (p.hasPermission("mplugin.kits.fisherman")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.FISHERMAN);
          KitsManager.getKit(p, KitType.FISHERMAN);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.REDSTONE_TORCH_ON)
        if (p.hasPermission("mplugin.kits.flash")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.FLASH);
          KitsManager.getKit(p, KitType.FLASH);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.IRON_BARDING)
        if (p.hasPermission("mplugin.kits.gladiator")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.GLADIATOR);
          KitsManager.getKit(p, KitType.GLADIATOR);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.FEATHER)
        if (p.hasPermission("mplugin.kits.glider")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.GLIDER);
          KitsManager.getKit(p, KitType.GLIDER);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.STICK && 
        p.hasPermission("mplugin.kits.grandpa")) {
        p.closeInventory();
        p.getInventory().clear();
        KitsManager.kitpvp.put(pn, KitType.GRANDPA);
        KitsManager.getKit(p, KitType.GRANDPA);
      } 
      if (e.getCurrentItem().getType() == Material.LEASH)
        if (p.hasPermission("mplugin.kits.grappler")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.GRAPPER);
          KitsManager.getKit(p, KitType.GRAPPER);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.BOWL)
        if (p.hasPermission("mplugin.kits.hermit")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.HERMIT);
          KitsManager.getKit(p, KitType.HERMIT);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.DISPENSER)
        if (p.hasPermission("mplugin.kits.hulk")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.HULK);
          KitsManager.getKit(p, KitType.HULK);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.FIREWORK)
        if (p.hasPermission("mplugin.kits.kangaroo")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.KANGAROO);
          KitsManager.getKit(p, KitType.KANGAROO);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }
      if (e.getCurrentItem().getType() == Material.NETHER_STAR)
        if (p.hasPermission("mplugin.kits.ninja")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.NINJA);
          KitsManager.getKit(p, KitType.NINJA);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.FEATHER)
        if (p.hasPermission("mplugin.kits.phantom")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.PHANTOM);
          KitsManager.getKit(p, KitType.PHANTOM);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.WATER_BUCKET)
        if (p.hasPermission("mplugin.kits.poseidon")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.POSEIDON);
          KitsManager.getKit(p, KitType.POSEIDON);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.FIREBALL)
        if (p.hasPermission("mplugin.kits.pyro")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.PYRO);
          KitsManager.getKit(p, KitType.PYRO);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
        p.closeInventory();
        p.getInventory().clear();
        KitsManager.getKit(p, KitType.PVP);
      } 
      if (e.getCurrentItem().getType() == Material.WOOD_HOE)
        if (p.hasPermission("mplugin.kits.reaper")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.REAPER);
          KitsManager.getKit(p, KitType.REAPER);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.SAND)
        if (p.hasPermission("mplugin.kits.snail")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.SNAIL);
          KitsManager.getKit(p, KitType.SNAIL);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE)
        if (p.hasPermission("mplugin.kits.specialist")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.SPECIALIST);
          KitsManager.getKit(p, KitType.SPECIALIST);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.POTION)
        if (p.hasPermission("mplugin.kits.spectre")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.SPECTRE);
          KitsManager.getKit(p, KitType.SPECTRE);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.ANVIL)
        if (p.hasPermission("mplugin.kits.stomper")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.STOMPER);
          KitsManager.getKit(p, KitType.STOMPER);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.SNOW_BALL)
        if (p.hasPermission("mplugin.kits.switcher")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.SWITCHER);
          KitsManager.getKit(p, KitType.SWITCHER);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.TNT)
        if (p.hasPermission("mplugin.kits.tank")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.TANK);
          KitsManager.getKit(p, KitType.TANK);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.WOOD_AXE)
        if (p.hasPermission("mplugin.kits.thor")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.THOR);
          KitsManager.getKit(p, KitType.THOR);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }
      if (e.getCurrentItem().getType() == Material.POTION)
        if (p.hasPermission("mplugin.kits.urgal")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.URGAL);
          KitsManager.getKit(p, KitType.URGAL);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.DIAMOND_AXE)
        if (p.hasPermission("mplugin.kits.viking")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.VIKING);
          KitsManager.getKit(p, KitType.VIKING);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
      if (e.getCurrentItem().getType() == Material.SPIDER_EYE)
        if (p.hasPermission("mplugin.kits.viper")) {
          p.closeInventory();
          p.getInventory().clear();
          KitsManager.kitpvp.put(pn, KitType.VIPER);
          KitsManager.getKit(p, KitType.VIPER);
        } else {
          p.closeInventory();
          p.sendMessage(ChatColor.RED + "Voce nao possui esse kit.");
          p.sendMessage(ChatColor.GREEN + "Compre vip em https://www.google.com");
        }  
    } 
  }
  
  @EventHandler
  public void playerDrop(PlayerDropItemEvent e) {
    Player p = e.getPlayer();
    Material t = e.getItemDrop().getItemStack().getType();
    if (KitsManager.haskit(p) && (
      t.equals(Material.BOW) || t.equals(Material.ARROW)|| t.equals(Material.ENDER_PORTAL_FRAME) || t.equals(Material.FISHING_ROD) || 
      t.equals(Material.REDSTONE_TORCH_ON) || t.equals(Material.IRON_BARDING) || t.equals(Material.FEATHER) || t.equals(Material.STICK) || t.equals(Material.LEASH) || 
      t.equals(Material.FIREWORK) || t.equals(Material.FIREBALL) || t.equals(Material.WOOD_HOE) || t.equals(Material.ENCHANTMENT_TABLE) || 
      t.equals(Material.SNOW_BALL) || t.equals(Material.WOOD_AXE) || t.equals(Material.DIAMOND_AXE)))
      e.setCancelled(true); 
  }
}
