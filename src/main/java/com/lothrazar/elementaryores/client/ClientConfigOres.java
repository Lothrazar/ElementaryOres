package com.lothrazar.elementaryores.client;

import com.lothrazar.elementaryores.ModOres;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfigOres {

  public static final ModConfigSpec CONFIG;
  public static final ModConfigSpec.BooleanValue ENABLE_EMMISSIVE_TEXTURES;

  static {
    final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    BUILDER.push(ModOres.MODID);
    ENABLE_EMMISSIVE_TEXTURES = BUILDER
        .comment("When enabled, ore overlay textures render at full brightness regardless of light level.  Should update ingame F3+T instead of full restart")
        .define("enableEmmissiveTextures", true);
    BUILDER.pop();
    CONFIG = BUILDER.build();
  }
}
