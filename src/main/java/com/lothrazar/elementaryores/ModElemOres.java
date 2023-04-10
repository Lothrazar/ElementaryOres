package com.lothrazar.elementaryores;

import com.lothrazar.elementaryores.world.ConfigHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(ModElemOres.MODID)
public class ModElemOres {

  public static final String MODID = "elementaryores";

  public ModElemOres() {
    ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + ".toml"));
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    ModRegistry.BLOCKS.register(eventBus);
    ModRegistry.ITEMS.register(eventBus);
  }
}
