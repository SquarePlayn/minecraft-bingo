package com.extremelyd1.listener;

import com.extremelyd1.game.Game;
import com.extremelyd1.game.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdListener implements Listener {

    /**
     * The game instance
     */
    private final Game game;

    public MotdListener(Game game) {
        this.game = game;
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent e) {
        if (game.isMaintenance()) {
            e.setMotd(
                    Game.PREFIX + ChatColor.WHITE + "Maintenance mode"
                            + ChatColor.RESET + "\nPlayers: "
                            + ChatColor.AQUA + Bukkit.getOnlinePlayers().size()
            );
        } else {
            e.setMotd(
                    Game.PREFIX
                            + ChatColor.RESET + "\nPlayers: "
                            + ChatColor.AQUA + Bukkit.getOnlinePlayers().size()
            );
        }
    }

}
