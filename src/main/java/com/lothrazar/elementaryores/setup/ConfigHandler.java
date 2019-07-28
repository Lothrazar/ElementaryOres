package com.lothrazar.elementaryores.setup;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.elementaryores.ModElemOres;
import com.lothrazar.elementaryores.block.OresRegistry;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ConfigHandler {

  private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
  public static ForgeConfigSpec.IntValue GOLD_NETHERLOW  ;
  public static ForgeConfigSpec.IntValue REDSTONE_ENDLOW  ;
  public static ForgeConfigSpec.IntValue LAPIS_NETHERLOW  ;
  public static ForgeConfigSpec COMMON_CONFIG;
  public static ForgeConfigSpec.IntValue GOLD_NETHER;
  public static ForgeConfigSpec.IntValue LAPIS_NETHER;
  public static ForgeConfigSpec.IntValue REDSTONE_END;


  public static ForgeConfigSpec.IntValue GOLD_NETHERHIGH  ;
  public static ForgeConfigSpec.IntValue LAPIS_NETHERHIGH  ;
  public static ForgeConfigSpec.IntValue REDSTONE_ENDHIGH  ;

  static {
    initConfig();
  }

  private static void initConfig() {
    COMMON_BUILDER.comment("General settings").push(ModElemOres.MODID);
    final String veinComment = "Vein Size";
    GOLD_NETHER = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.gold.size"
        , 4, 0, 64
    );
    LAPIS_NETHER = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.lapis.size"
        , 2, 0, 64
    );
    REDSTONE_END = COMMON_BUILDER.comment(veinComment).defineInRange("end.redstone.size"
        , 1, 0, 64
    );
    GOLD_NETHERLOW = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.gold.low"
        , 16, 0, 64
    );
    GOLD_NETHERHIGH = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.gold.high"
        , 85, 0, 64
    );
    LAPIS_NETHERLOW = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.lapis.low"
        , 70, 0, 64
    );
    LAPIS_NETHERHIGH = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.lapis.high"
        , 127, 0, 64
    );
    REDSTONE_ENDLOW = COMMON_BUILDER.comment(veinComment).defineInRange("end.redstone.low"
        , 1, 0, 64
    );
    REDSTONE_ENDHIGH = COMMON_BUILDER.comment(veinComment).defineInRange("end.redstone.high"
        , 62, 0, 64
    );
    COMMON_BUILDER.pop();
    COMMON_CONFIG = COMMON_BUILDER.build();
  }

  public static void loadConfig(ForgeConfigSpec spec, Path path) {
    final CommentedFileConfig configData = CommentedFileConfig.builder(path)
        .sync()
        .autosave()
        .writingMode(WritingMode.REPLACE)
        .build();
    configData.load();
    spec.setConfig(configData);
  }
}
