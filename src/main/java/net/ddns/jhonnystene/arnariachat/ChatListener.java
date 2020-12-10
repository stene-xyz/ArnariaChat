package net.ddns.jhonnystene.arnariachat;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ChatListener {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onChat(ServerChatEvent event) {
        String message = event.getMessage();
        String username = event.getUsername();

        System.out.println("Chat message from " + username + ": " + message);

        World world = event.getPlayer().world;
        //MinecraftServer server = event.getPlayer().getServer();
        PlayerEntity sender = event.getPlayer();

        for(PlayerEntity player : world.getPlayers()) {
            if(player.getUniqueID() == sender.getUniqueID()) { // Echo to sending player
                player.sendMessage(event.getComponent());
            } else {
                if(MCUtils.getCoorinateDistance(sender.getPosition(), player.getPosition()) <= (double) BuildInfo.allowedRange) {
                    player.sendMessage(event.getComponent());
                }
            }
        }

        if(event.isCancelable())
            event.setCanceled(true);
        else
            System.out.println("FRICK! The chat event can't be cancelled!");
    }
}
