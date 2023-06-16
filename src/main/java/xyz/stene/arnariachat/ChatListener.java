/*
 * Arnaria Chat V1.0.1
 * Copyright (C) 2023 Johnny Stene
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package xyz.stene.arnariachat;

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
