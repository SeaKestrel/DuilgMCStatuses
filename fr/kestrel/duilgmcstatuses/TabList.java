package fr.kestrel.duilgmcstatuses;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TabList {
    PacketPlayOutPlayerListHeaderFooter p;
    public TabList(Server server) {
        IChatBaseComponent h = IChatBaseComponent.a("\n"+ ChatColor.GREEN+"DUILG"+ChatColor.DARK_GREEN+"MC\n");
        IChatBaseComponent f;
        if(server.getOnlinePlayers().size() == 1) {
            f = IChatBaseComponent.a("\n  "+ ChatColor.RED+(server.getOnlinePlayers().size())+ChatColor.DARK_GRAY+"/"+ChatColor.DARK_RED+(server.getMaxPlayers())+" "+ChatColor.GRAY+"joueur connecté !  \n");
        } else {
            f = IChatBaseComponent.a("\n  "+ ChatColor.RED+(server.getOnlinePlayers().size())+ChatColor.DARK_GRAY+"/"+ChatColor.DARK_RED+(server.getMaxPlayers())+" "+ChatColor.GRAY+"joueurs connectés !  \n");
        }
        p = new PacketPlayOutPlayerListHeaderFooter(h, f);
    }

    public void sendPacket(Player player){
        ((CraftPlayer) player).getHandle().b.sendPacket(this.p);
    }
}
