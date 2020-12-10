package net.ddns.jhonnystene.arnariachat;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(BuildInfo.modId)
public class ArnariaChatMain {
    public ArnariaChatMain() {
        init();
    }

    public void init() {
        MinecraftForge.EVENT_BUS.register(new ChatListener());
    }
}
