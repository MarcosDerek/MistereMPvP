package me.main.API;

import me.main.Main;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class TabListAPI {
	public static void broadcastHeaderAndFooter(String header, String footer) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			setHeaderAndFooter(player, header, footer);
		}
	}

	public static void setHeader(Player p, String header) {
		setHeaderAndFooter(p, header, null);
	}

	public static void setFooter(Player p, String footer) {
		setHeaderAndFooter(p, null, footer);
	}

	public static void setHeaderAndFooter(Player p, String rawHeader, String rawFooter) {
		PacketContainer packet = new PacketContainer(PacketType.Play.Server.PLAYER_LIST_HEADER_FOOTER);
		packet.getChatComponents().write(0, WrappedChatComponent.fromHandle(rawHeader));
		packet.getChatComponents().write(1, WrappedChatComponent.fromHandle(rawFooter));
		try {
			(Main.getInstace()).procotolManager.sendServerPacket(p, packet);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}