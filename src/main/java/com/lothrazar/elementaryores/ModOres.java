package com.lothrazar.elementaryores;

import com.lothrazar.elementaryores.client.ClientConfigOres;
import com.lothrazar.elementaryores.world.ConfigRegistryOres;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(ModOres.MODID)
public class ModOres {

  public static final String MODID = "elementaryores";

  public ModOres(IEventBus bus, ModContainer modContainer) {
    modContainer.registerConfig(ModConfig.Type.COMMON, ConfigRegistryOres.CONFIG);
    modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfigOres.CONFIG);
    RegistryOres.TABS.register(bus);
    RegistryOres.BLOCKS.register(bus);
    RegistryOres.ITEMS.register(bus);
  }
}
