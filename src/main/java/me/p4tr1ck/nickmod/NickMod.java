package me.p4tr1ck.nickmod;

import me.p4tr1ck.nickmod.command.NickCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
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
    public static final String VERSION = "1.0";
    
    public static String nickname;
    public static Boolean set = false;
    public static String cmdPrefix = EnumChatFormatting.GOLD + "[" + NAME + "] " + EnumChatFormatting.GRAY;
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        final ClientCommandHandler commandRegister = ClientCommandHandler.instance;
        
        commandRegister.registerCommand(new NickCommand());
    }
    
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
    	String message = event.message.getFormattedText();
    	
    	if(set) {
    		message = message.replace(Minecraft.getMinecraft().thePlayer.getName(), nickname);
    		Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(message));
    		event.setCanceled(true);
    	}
    }
}
