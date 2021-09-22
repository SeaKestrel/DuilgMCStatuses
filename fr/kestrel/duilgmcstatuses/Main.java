package fr.kestrel.duilgmcstatuses;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new Chat(), this);
        new BukkitRunnable(){
            @Override
            public void run(){
                for(Player p : Bukkit.getServer().getOnlinePlayers()){
                    (new TabList(Bukkit.getServer())).sendPacket(p);
                }
            }
        }.runTaskTimerAsynchronously(this, 0, 20*60);
    }

    @EventHandler
    public void join(PlayerJoinEvent e){
        (new TabList(this.getServer())).sendPacket(e.getPlayer());
        e.setJoinMessage(ChatColor.of("#4cd137")+"+ "+e.getPlayer().getDisplayName());
    }

    @EventHandler
    public void quit(PlayerQuitEvent e){
        e.setQuitMessage(ChatColor.of("#eb2f06") +"- "+e.getPlayer().getDisplayName());
    }



}
