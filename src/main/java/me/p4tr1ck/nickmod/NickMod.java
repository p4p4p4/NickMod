package me.p4tr1ck.nickmod;

import java.io.File;

import me.p4tr1ck.nickmod.commands.NickModCommand;
import me.p4tr1ck.nickmod.handlers.ChatHandler;
import me.p4tr1ck.nickmod.handlers.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = NickMod.MODID, name = NickMod.NAME, version = NickMod.VERSION)
public class NickMod {
	
    /* NickMod by p4tr1ck */
	
    public static final String MODID = "nickmod";
    public static final String NAME = "NickMod";
    public static final String VERSION = "1.2";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	ConfigHandler.saveFile = new File(Minecraft.getMinecraft().mcDataDir + "/config", "nickmod.cfg");
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        final ClientCommandHandler commandRegister = ClientCommandHandler.instance;
        ConfigHandler.loadSettings();
        
        commandRegister.registerCommand(new NickModCommand());
    }
    
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
    	ChatHandler.editChat(event);
    }
}
