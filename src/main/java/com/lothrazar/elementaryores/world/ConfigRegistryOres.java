package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ModOres;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigRegistryOres {

  public static final ModConfigSpec CONFIG;
  static {
    final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    BUILDER.comment("See the datapack for modifying ore spawns").push(ModOres.MODID);
    BUILDER.define("_comment", "All worldgen controls have been moved to the mojang datapack system instead of configs.  See built-in json files inside /data/elementaryores/worldgen/ ");
    BUILDER.pop();
    CONFIG = BUILDER.build();
  }
}
