package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ModOres;
import com.lothrazar.library.config.ConfigTemplate;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigRegistryOres extends ConfigTemplate {

  public static final ForgeConfigSpec CONFIG;
  static {
    final ForgeConfigSpec.Builder BUILDER = builder();
    BUILDER.comment("See the datapack for modifying ore spawns").push(ModOres.MODID);
    BUILDER.define("_comment", "All worldgen controls have been moved to the mojang datapack system instead of configs.  See built-in json files inside /data/elementaryores/worldgen/ ");
    BUILDER.pop();
    CONFIG = BUILDER.build();
  }

  public ConfigRegistryOres() {
    CONFIG.setConfig(setup(ModOres.MODID));
  }
}
