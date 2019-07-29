package com.lothrazar.elementaryores.setup;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.elementaryores.ModElemOres;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ConfigHandler {

  private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
  public static ForgeConfigSpec.IntValue goldMin;
  public static ForgeConfigSpec.IntValue redstoneMin;
  public static ForgeConfigSpec.IntValue lapisMin;
  public static ForgeConfigSpec COMMON_CONFIG;
  public static ForgeConfigSpec.IntValue goldVeinSize;
  public static ForgeConfigSpec.IntValue lapisVeinSize;
  public static ForgeConfigSpec.IntValue redstoneVeinSize;


  public static ForgeConfigSpec.IntValue goldMax;
  public static ForgeConfigSpec.IntValue lapisMax;
  public static ForgeConfigSpec.IntValue redstoneMax;

  static {
    initConfig();
  }

  private static void initConfig() {
    COMMON_BUILDER.comment("General settings").push(ModElemOres.MODID);
    final String veinComment = "Vein Size";
    goldVeinSize = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.gold.size"
        , 6, 0, 64
    );
    lapisVeinSize = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.lapis.size"
        , 3, 0, 64
    );
    redstoneVeinSize = COMMON_BUILDER.comment(veinComment).defineInRange("end.redstone.size"
        , 3, 0, 64
    );
    goldMin = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.gold.low"
        , 16, 0, 256
    );
    goldMax = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.gold.high"
        , 85, 0, 256
    );
    lapisMin = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.lapis.low"
        , 70, 0, 256
    );
    lapisMax = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.lapis.high"
        , 127, 0, 256
    );
    redstoneMin = COMMON_BUILDER.comment(veinComment).defineInRange("end.redstone.low"
        , 1, 0, 256
    );
    redstoneMax = COMMON_BUILDER.comment(veinComment).defineInRange("end.redstone.high"
        , 68, 0, 256
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
