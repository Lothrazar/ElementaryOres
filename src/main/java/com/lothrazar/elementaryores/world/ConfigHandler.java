package com.lothrazar.elementaryores.world;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.elementaryores.ModElemOres;
import java.nio.file.Path;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {

  private static final ForgeConfigSpec.Builder CFG = new ForgeConfigSpec.Builder();
  public static ForgeConfigSpec COMMON_CONFIG;

  public static class Overworld {}

  public static class Nether {

    public static ForgeConfigSpec.IntValue ironMin;
    public static ForgeConfigSpec.IntValue ironMax;
    public static ForgeConfigSpec.IntValue ironVeinSize;
    public static ForgeConfigSpec.IntValue lapisMin;
    public static ForgeConfigSpec.IntValue lapisMax;
    public static ForgeConfigSpec.IntValue lapisVeinSize;
    public static ForgeConfigSpec.IntValue emeraldMin;
    public static ForgeConfigSpec.IntValue emeraldMax;
    public static ForgeConfigSpec.IntValue emeraldVeinSize;
    public static ForgeConfigSpec.IntValue diamondMin;
    public static ForgeConfigSpec.IntValue diamondMax;
    public static ForgeConfigSpec.IntValue diamondVeinSize;
  }

  public static class End {

    public static ForgeConfigSpec.IntValue diamondMin;
    public static ForgeConfigSpec.IntValue diamondMax;
    public static ForgeConfigSpec.IntValue diamondVeinSize;
    public static ForgeConfigSpec.IntValue enderMin;
    public static ForgeConfigSpec.IntValue enderMax;
    public static ForgeConfigSpec.IntValue enderVeinSize;
    public static ForgeConfigSpec.IntValue emeraldMin;
    public static ForgeConfigSpec.IntValue emeraldMax;
    public static ForgeConfigSpec.IntValue emeraldVeinSize;
    public static ForgeConfigSpec.IntValue redstoneMin;
    public static ForgeConfigSpec.IntValue redstoneMax;
    public static ForgeConfigSpec.IntValue redstoneVeinSize;
    public static ForgeConfigSpec.IntValue lapisMin;
    public static ForgeConfigSpec.IntValue lapisMax;
    public static ForgeConfigSpec.IntValue lapisVeinSize;
  }

  static {
    initConfig();
  }

  private static void initConfig() {
    String commentLowest = "Min and max y levels for spawn";
    String commentSize = "Size of ore veins";
    CFG.comment("General settings").push(ModElemOres.MODID);
    Nether.emeraldMin = CFG.comment(commentLowest).defineInRange("nether.emerald.lowest", 100, 0, 256);
    Nether.emeraldMax = CFG.comment(commentLowest).defineInRange("nether.emerald.highest", 256, 0, 256);
    Nether.emeraldVeinSize = CFG.comment(commentSize).defineInRange("nether.emerald.size", 2, 0, 64);
    Nether.ironMin = CFG.comment(commentLowest).defineInRange("nether.iron.lowest", 100, 0, 256);
    Nether.ironMax = CFG.comment(commentLowest).defineInRange("nether.iron.highest", 256, 0, 256);
    Nether.ironVeinSize = CFG.comment(commentSize).defineInRange("nether.iron.size", 3, 0, 64);
    Nether.lapisMin = CFG.comment(commentLowest).defineInRange("nether.lapis.lowest", 0, 0, 256);
    Nether.lapisMax = CFG.comment(commentLowest).defineInRange("nether.lapis.highest", 80, 0, 256);
    Nether.lapisVeinSize = CFG.comment(commentSize).defineInRange("nether.lapis.size", 4, 0, 64);
    Nether.diamondMin = CFG.comment(commentLowest).defineInRange("nether.diamond.lowest", 1, 0, 256);
    Nether.diamondMax = CFG.comment(commentLowest).defineInRange("nether.diamond.highest", 60, 0, 256);
    Nether.diamondVeinSize = CFG.comment(commentSize).defineInRange("nether.diamond.size", 2, 0, 64);
    End.redstoneMin = CFG.comment(commentLowest).defineInRange("end.redstone.lowest", 1, 0, 256);
    End.redstoneMax = CFG.comment(commentLowest).defineInRange("end.redstone.highest", 70, 0, 256);
    End.redstoneVeinSize = CFG.comment(commentSize).defineInRange("end.redstone.size", 4, 0, 64);
    End.emeraldMin = CFG.comment(commentLowest).defineInRange("end.emerald.lowest", 1, 0, 256);
    End.emeraldMax = CFG.comment(commentLowest).defineInRange("end.emerald.highest", 70, 0, 256);
    End.emeraldVeinSize = CFG.comment(commentSize).defineInRange("end.emerald.size", 4, 0, 64);
    End.enderMin = CFG.comment(commentLowest).defineInRange("end.ender.lowest", 1, 0, 256);
    End.enderMax = CFG.comment(commentLowest).defineInRange("end.ender.highest", 256, 0, 256);
    End.enderVeinSize = CFG.comment(commentSize).defineInRange("end.ender.size", 10, 0, 64);
    End.diamondMin = CFG.comment(commentLowest).defineInRange("end.diamond.lowest", 1, 0, 256);
    End.diamondMax = CFG.comment(commentLowest).defineInRange("end.diamond.highest", 127, 0, 256);
    End.diamondVeinSize = CFG.comment(commentSize).defineInRange("end.diamond.size", 1, 0, 64);
    End.lapisMin = CFG.comment(commentLowest).defineInRange("end.lapis.lowest", 50, 0, 256);
    End.lapisMax = CFG.comment(commentLowest).defineInRange("end.lapis.highest", 127, 0, 256);
    End.lapisVeinSize = CFG.comment(commentSize).defineInRange("end.lapis.size", 2, 0, 64);
    CFG.pop();
    COMMON_CONFIG = CFG.build();
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
