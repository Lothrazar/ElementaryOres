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

    public static ForgeConfigSpec.IntValue IRONMIN;
    public static ForgeConfigSpec.IntValue IRONMAX;
    public static ForgeConfigSpec.IntValue IRONVEINSIZE;
    public static ForgeConfigSpec.IntValue LAPISMIN;
    public static ForgeConfigSpec.IntValue LAPISMAX;
    public static ForgeConfigSpec.IntValue LAPISVEINSIZE;
    public static ForgeConfigSpec.IntValue EMERALDMIN;
    public static ForgeConfigSpec.IntValue EMERALDMAX;
    public static ForgeConfigSpec.IntValue EMERALDVEINSIZE;
    public static ForgeConfigSpec.IntValue DIAMONDMIN;
    public static ForgeConfigSpec.IntValue DIAMONDMAX;
    public static ForgeConfigSpec.IntValue DIAMONDVEINSIZE;
  }

  public static class End {

    public static ForgeConfigSpec.IntValue DIAMONDMIN;
    public static ForgeConfigSpec.IntValue DIAMONDMAX;
    public static ForgeConfigSpec.IntValue DIAMONDVEINSIZE;
    public static ForgeConfigSpec.IntValue ENDERMIN;
    public static ForgeConfigSpec.IntValue ENDERMAX;
    public static ForgeConfigSpec.IntValue ENDERVEINSIZE;
    public static ForgeConfigSpec.IntValue EMERALDMIN;
    public static ForgeConfigSpec.IntValue EMERALDMAX;
    public static ForgeConfigSpec.IntValue EMERALDVEINSIZE;
    public static ForgeConfigSpec.IntValue REDSTONEMIN;
    public static ForgeConfigSpec.IntValue REDSTONEMAX;
    public static ForgeConfigSpec.IntValue REDSTONEVEINSIZE;
    public static ForgeConfigSpec.IntValue LAPISMIN;
    public static ForgeConfigSpec.IntValue LAPISMAX;
    public static ForgeConfigSpec.IntValue LAPISVEINSIZE;
  }

  static {
    initConfig();
  }

  private static void initConfig() {
    String commentLowest = "Min and max y levels for spawn";
    String commentSize = "Size of ore veins";
    CFG.comment("General settings").push(ModElemOres.MODID);
    Nether.EMERALDMIN = CFG.comment(commentLowest).defineInRange("nether.emerald.lowest", 90, 0, 256);
    Nether.EMERALDMAX = CFG.comment(commentLowest).defineInRange("nether.emerald.highest", 256, 0, 256);
    Nether.EMERALDVEINSIZE = CFG.comment(commentSize).defineInRange("nether.emerald.size", 2, 0, 64);
    Nether.IRONMIN = CFG.comment(commentLowest).defineInRange("nether.iron.lowest", 70, 0, 256);
    Nether.IRONMAX = CFG.comment(commentLowest).defineInRange("nether.iron.highest", 256, 0, 256);
    Nether.IRONVEINSIZE = CFG.comment(commentSize).defineInRange("nether.iron.size", 8, 0, 64);
    Nether.LAPISMIN = CFG.comment(commentLowest).defineInRange("nether.lapis.lowest", 0, 0, 256);
    Nether.LAPISMAX = CFG.comment(commentLowest).defineInRange("nether.lapis.highest", 60, 0, 256);
    Nether.LAPISVEINSIZE = CFG.comment(commentSize).defineInRange("nether.lapis.size", 4, 0, 64);
    Nether.DIAMONDMIN = CFG.comment(commentLowest).defineInRange("nether.diamond.lowest", 1, 0, 256);
    Nether.DIAMONDMAX = CFG.comment(commentLowest).defineInRange("nether.diamond.highest", 40, 0, 256);
    Nether.DIAMONDVEINSIZE = CFG.comment(commentSize).defineInRange("nether.diamond.size", 2, 0, 64);
    End.REDSTONEMIN = CFG.comment(commentLowest).defineInRange("end.redstone.lowest", 1, 0, 256);
    End.REDSTONEMAX = CFG.comment(commentLowest).defineInRange("end.redstone.highest", 70, 0, 256);
    End.REDSTONEVEINSIZE = CFG.comment(commentSize).defineInRange("end.redstone.size", 4, 0, 64);
    End.EMERALDMIN = CFG.comment(commentLowest).defineInRange("end.emerald.lowest", 1, 0, 256);
    End.EMERALDMAX = CFG.comment(commentLowest).defineInRange("end.emerald.highest", 60, 0, 256);
    End.EMERALDVEINSIZE = CFG.comment(commentSize).defineInRange("end.emerald.size", 4, 0, 64);
    End.ENDERMIN = CFG.comment(commentLowest).defineInRange("end.ender.lowest", 1, 0, 256);
    End.ENDERMAX = CFG.comment(commentLowest).defineInRange("end.ender.highest", 256, 0, 256);
    End.ENDERVEINSIZE = CFG.comment(commentSize).defineInRange("end.ender.size", 10, 0, 64);
    End.DIAMONDMIN = CFG.comment(commentLowest).defineInRange("end.diamond.lowest", 1, 0, 256);
    End.DIAMONDMAX = CFG.comment(commentLowest).defineInRange("end.diamond.highest", 256, 0, 256);
    End.DIAMONDVEINSIZE = CFG.comment(commentSize).defineInRange("end.diamond.size", 1, 0, 64);
    End.LAPISMIN = CFG.comment(commentLowest).defineInRange("end.lapis.lowest", 1, 0, 256);
    End.LAPISMAX = CFG.comment(commentLowest).defineInRange("end.lapis.highest", 256, 0, 256);
    End.LAPISVEINSIZE = CFG.comment(commentSize).defineInRange("end.lapis.size", 2, 0, 64);
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
