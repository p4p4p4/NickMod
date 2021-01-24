package me.p4tr1ck.nickmod;

import java.io.File;

import me.p4tr1ck.nickmod.command.NickCommand;
import me.p4tr1ck.nickmod.common.ConfigHandler;
import me.p4tr1ck.nickmod.common.NameChanger;
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
    public static final String VERSION = "1.1";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	ConfigHandler.saveFile = new File(Minecraft.getMinecraft().mcDataDir + "/config", "nickmod.cfg");
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        final ClientCommandHandler commandRegister = ClientCommandHandler.instance;
        ConfigHandler.loadSettings();
        
        commandRegister.registerCommand(new NickCommand());
    }
    
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
    	NameChanger.changeNames(event);
    }
}
