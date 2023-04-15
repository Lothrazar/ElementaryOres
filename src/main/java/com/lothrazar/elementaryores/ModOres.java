package com.lothrazar.elementaryores;

import com.lothrazar.elementaryores.world.ConfigRegistryOres;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModOres.MODID)
public class ModOres {

  public static final String MODID = "elementaryores";

  public ModOres() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    RegistryOres.BLOCKS.register(eventBus);
    RegistryOres.ITEMS.register(eventBus);
    new ConfigRegistryOres();
  }
}
