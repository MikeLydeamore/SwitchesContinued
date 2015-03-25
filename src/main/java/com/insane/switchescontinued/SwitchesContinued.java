package com.insane.switchescontinued;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = SwitchesContinued.MODID, name = "Switches Continued", version="0.0.1")
public class SwitchesContinued {
	
	public static final String MODID = "SwitchesContinued";
	
	@Instance(MODID)
	public static SwitchesContinued instance;
	
	@SidedProxy(clientSide = "com.insane.switchescontinued.client.ClientProxy", serverSide = "com.insane.switchescontinued.CommonProxy")
	public static CommonProxy proxy;
	
	

	public static Configuration config;
	public static String[] switchTypes = {"iron_block", "emerald_block", "gold_block"};
	public static boolean enabled[] = new boolean[switchTypes.length];
	public static Block[] blockSwitch = new Block[switchTypes.length];
	
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		for (int i = 0; i < switchTypes.length; i++)
		{
			enabled[i] = config.get("switchTypes", switchTypes[i], true).getBoolean();
			blockSwitch[i] = new BlockSwitch(GameRegistry.findBlock("minecraft", switchTypes[i]), switchTypes[i].substring(0, switchTypes[i].length() - 6));
			if (enabled[i])
			{
				GameRegistry.registerBlock(blockSwitch[i], "switch_"+switchTypes[i].substring(0, switchTypes[i].length() - 6));
			}
		}
		
		if (enabled[0])
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSwitch[0], 4), "abc", "bdb", 'a', "dyeRed", 'b', "ingotIron", 'c', "dyeGreen", 'd', Blocks.lever));
		if (enabled[1])
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSwitch[1], 4), "abc", "bdb", 'a', "dyeRed", 'b', "gemEmerald", 'c', "dyeGreen", 'd', Blocks.lever));
		if (enabled[2])
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSwitch[2], 4), "abc", "bdb", 'a', "dyeRed", 'b', "ingotGold", 'c', "dyeGreen", 'd', Blocks.lever));
	}
	

}
