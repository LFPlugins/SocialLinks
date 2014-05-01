package com.gmail.lfplugins.newReloadCommand;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Main plugin;
	public final Logger logger = Logger.getLogger("Minecraft");

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		getConfig().addDefault("SocialLinks.Prefix", String.valueOf("[SL]"));
		getConfig().addDefault("Links.WebsiteAdress", String.valueOf("http://www.yoursite.com/yourname"));
		getConfig().addDefault("Links.FaceBookAdress", String.valueOf("http://www.facebook.com/yourname"));
		getConfig().addDefault("Links.TwitterAdress", String.valueOf("http://www.twitter.com/yourname"));
		getConfig().addDefault("Links.InstagramAdress", String.valueOf("http://www.instagram.com/yourname"));
		getConfig().addDefault("Links.TwitchAdress", String.valueOf("http://www.twitch.tv/yourname"));
		getConfig().addDefault("Links.YouTubeAdress", String.valueOf("http://www.youtube.com/yourname"));
		getConfig().options().copyDefaults(true);
		saveConfig();
		pm.addPermission(new Permissions().Website);
		pm.addPermission(new Permissions().Instagram);
		pm.addPermission(new Permissions().FaceBook);
		pm.addPermission(new Permissions().Twitter);
		pm.addPermission(new Permissions().Twitch);
		pm.addPermission(new Permissions().YouTube);
		pm.addPermission(new Permissions().Reload);
	}

	public void onDisable() {
		PluginManager pm = getServer().getPluginManager();
		pm.removePermission(new Permissions().Website);
		pm.removePermission(new Permissions().Instagram);
		pm.removePermission(new Permissions().FaceBook);
		pm.removePermission(new Permissions().Twitter);
		pm.removePermission(new Permissions().Twitch);
		pm.removePermission(new Permissions().YouTube);
		pm.removePermission(new Permissions().Reload);
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("website")) {
			if (sender instanceof Player) {
				if (player.hasPermission(new Permissions().Website)) {

					sender.sendMessage(ChatColor.AQUA
							+ getConfig().getString("SocialLinks.Prefix") + ChatColor.GREEN
							+ " " + getConfig().getString("Links.WebsiteAdress"));
				}else{
					sender.sendMessage(ChatColor.AQUA + getConfig().getString("SocialLinks.Prefix") + ChatColor.RED + " " + getConfig().getString("SocialLinks.NoPermMsg"));
				}
			}
		} else if (commandLabel.equalsIgnoreCase("facebook")) {
			if (sender instanceof Player) {
				if (player.hasPermission(new Permissions().FaceBook)) {
					sender.sendMessage(ChatColor.AQUA
							+ getConfig().getString("SocialLinks.Prefix") + ChatColor.GREEN
							+ " " + getConfig().getString("Links.FaceBookAdress"));
				}else{
					sender.sendMessage(ChatColor.AQUA + getConfig().getString("SocialLinks.Prefix") + ChatColor.RED + " " + getConfig().getString("SocialLinks.NoPermMsg"));
				}
			}

		} else if (commandLabel.equalsIgnoreCase("Twitter")) {
			if (sender instanceof Player) {
				if (player.hasPermission(new Permissions().Twitter)) {
					sender.sendMessage(ChatColor.AQUA
							+ getConfig().getString("SocialLinks.Prefix") + ChatColor.GREEN
							+ " " + getConfig().getString("Links.TwitterAdress"));
				}else{
					sender.sendMessage(ChatColor.AQUA + getConfig().getString("SocialLinks.Prefix") + ChatColor.RED + " " + getConfig().getString("SocialLinks.NoPermMsg"));
				}
			}
		} else if (commandLabel.equalsIgnoreCase("youtube")) {
			if (sender instanceof Player) {
				if (player.hasPermission(new Permissions().YouTube)) {
					sender.sendMessage(ChatColor.AQUA
							+ getConfig().getString("SocialLinks.Prefix") + ChatColor.GREEN
							+ " " + getConfig().getString("Links.YouTubeAdress"));
				}else{
					sender.sendMessage(ChatColor.AQUA + getConfig().getString("SocialLinks.Prefix") + ChatColor.RED + " " + getConfig().getString("SocialLinks.NoPermMsg"));
				}
			}
		} else if (commandLabel.equalsIgnoreCase("twitch")) {
			if (sender instanceof Player) {
				if (player.hasPermission(new Permissions().Twitch)) {
					sender.sendMessage(ChatColor.AQUA
							+ getConfig().getString("SocialLinks.Prefix") + ChatColor.GREEN
							+ " " + getConfig().getString("Links.TwitchAdress"));
				}else{
					sender.sendMessage(ChatColor.AQUA + getConfig().getString("SocialLinks.Prefix") + ChatColor.RED + " " + getConfig().getString("SocialLinks.NoPermMsg"));
				}
			}
		} else if (commandLabel.equalsIgnoreCase("instagram")) {
			if (sender instanceof Player) {
				if (player.hasPermission(new Permissions().Instagram)) {
					sender.sendMessage(ChatColor.AQUA
							+ getConfig().getString("SocialLinks.Prefix") + ChatColor.GREEN
							+ " " + getConfig().getString("Links.InstagramAdress"));
				}else{
					sender.sendMessage(ChatColor.AQUA + getConfig().getString("SocialLinks.Prefix") + ChatColor.RED + " " + getConfig().getString("SocialLinks.NoPermMsg"));
				}
			}
		} else if (commandLabel.equalsIgnoreCase("SLReload")) {
				if (player.hasPermission(new Permissions().Reload)) {
					reloadConfig();
					saveConfig();
					sender.sendMessage(ChatColor.AQUA
							+ getConfig().getString("SocialLinks.Prefix") + " " +  ChatColor.GREEN
							+ getConfig().getString("ReloadMsg"));
				}else{
					sender.sendMessage(ChatColor.AQUA + getConfig().getString("SocialLinks.Prefix") + ChatColor.RED + " " + getConfig().getString("SocialLinks.NoPermMsg"));
				}
			
		}
		return false;
	}
}