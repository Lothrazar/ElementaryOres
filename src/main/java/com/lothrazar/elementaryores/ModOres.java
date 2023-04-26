package com.lothrazar.elementaryores;

import com.lothrazar.elementaryores.world.ConfigRegistryOres;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModOres.MODID)
public class ModOres {

  public static final String MODID = "elementaryores";

  public ModOres() {
    new ConfigRegistryOres();
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    RegistryOres.BLOCKS.register(bus);
    RegistryOres.ITEMS.register(bus);
  }
}
