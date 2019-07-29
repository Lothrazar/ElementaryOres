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
  public static ForgeConfigSpec.IntValue diamondMin;
  public static ForgeConfigSpec.IntValue emeraldMin;
  public static ForgeConfigSpec COMMON_CONFIG;
  public static ForgeConfigSpec.IntValue goldVeinSize;
  public static ForgeConfigSpec.IntValue lapisVeinSize;
  public static ForgeConfigSpec.IntValue redstoneVeinSize;
  public static ForgeConfigSpec.IntValue enderVeinSize;
  public static ForgeConfigSpec.IntValue diamondVeinSize;
  public static ForgeConfigSpec.IntValue emeraldVeinSize;
  public static ForgeConfigSpec.IntValue goldMax;
  public static ForgeConfigSpec.IntValue lapisMax;
  public static ForgeConfigSpec.IntValue redstoneMax;
  public static ForgeConfigSpec.IntValue diamondMax;
  public static ForgeConfigSpec.IntValue emeraldMax;
  public static ForgeConfigSpec.IntValue enderMax;
  public static ForgeConfigSpec.IntValue enderMin;

  static {
    initConfig();
  }

  private static void initConfig() {
    COMMON_BUILDER.comment("General settings").push(ModElemOres.MODID);
    String veinComment = "Size of nether ore veins";
    goldVeinSize = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.gold.size"
        , 6, 0, 64
    );
    lapisVeinSize = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.lapis.size"
        , 3, 0, 64
    );
    diamondVeinSize = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.diamond.size"
        , 1, 0, 64
    );
    veinComment = "How comoon are the End ore spawns";
    redstoneVeinSize = COMMON_BUILDER.comment(veinComment).defineInRange("end.redstone.size"
        , 5, 0, 64
    );
    emeraldVeinSize = COMMON_BUILDER.comment(veinComment).defineInRange("end.emerald.size"
        , 4, 0, 64
    );
    enderVeinSize = COMMON_BUILDER.comment(veinComment).defineInRange("end.ender.size"
        , 8, 0, 64
    );
    veinComment = "Min and max y levels for spawn";
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
        , 86, 0, 256
    );
    diamondMin = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.diamond.low"
        , 1, 0, 256
    );
    diamondMax = COMMON_BUILDER.comment(veinComment).defineInRange("netherrack.diamond.high"
        , 127, 0, 256
    );
    emeraldMin = COMMON_BUILDER.comment(veinComment).defineInRange("end.emerald.low"
        , 1, 0, 256
    );
    emeraldMax = COMMON_BUILDER.comment(veinComment).defineInRange("end.emerald.high"
        , 40, 0, 256
    );
    enderMin = COMMON_BUILDER.comment(veinComment).defineInRange("end.ender.low"
        , 1, 0, 256
    );
    enderMax = COMMON_BUILDER.comment(veinComment).defineInRange("end.ender.high"
        , 127, 0, 256
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
