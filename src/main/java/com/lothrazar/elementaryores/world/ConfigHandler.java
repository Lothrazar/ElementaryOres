package com.lothrazar.elementaryores.world;

import java.nio.file.Path;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.elementaryores.ModElemOres;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class ConfigHandler {

  private static final ForgeConfigSpec.Builder CFG = new ForgeConfigSpec.Builder();
  public static ForgeConfigSpec COMMON_CONFIG;

  public static class Nether {

    public static ForgeConfigSpec.IntValue IRONMIN;
    public static ForgeConfigSpec.IntValue IRONMAX;
    public static ForgeConfigSpec.IntValue IRON_VEINSIZE;
    public static IntValue IRON_SPREAD;
    public static ForgeConfigSpec.IntValue REDSTONEMIN;
    public static ForgeConfigSpec.IntValue REDSTONEMAX;
    public static ForgeConfigSpec.IntValue REDSTONE_VEINSIZE;
    public static IntValue REDSTONE_SPREAD;
    public static ForgeConfigSpec.IntValue LAPISMIN;
    public static ForgeConfigSpec.IntValue LAPISMAX;
    public static ForgeConfigSpec.IntValue LAPIS_VEINSIZE;
    public static ForgeConfigSpec.IntValue EMERALDMIN;
    public static ForgeConfigSpec.IntValue EMERALDMAX;
    public static ForgeConfigSpec.IntValue EMERALD_VEINSIZE;
    public static ForgeConfigSpec.IntValue DIAMONDMIN;
    public static ForgeConfigSpec.IntValue DIAMONDMAX;
    public static ForgeConfigSpec.IntValue DIAMOND_VEINSIZE;
    public static ForgeConfigSpec.IntValue COALMIN;
    public static ForgeConfigSpec.IntValue COALMAX;
    public static ForgeConfigSpec.IntValue COAL_VEINSIZE;
    public static ForgeConfigSpec.IntValue COPPERMIN;
    public static ForgeConfigSpec.IntValue COPPERMAX;
    public static ForgeConfigSpec.IntValue COPPER_VEINSIZE;
    public static ForgeConfigSpec.IntValue GHASTMIN;
    public static ForgeConfigSpec.IntValue GHASTMAX;
    public static ForgeConfigSpec.IntValue GHAST_VEINSIZE;
    public static IntValue EMERALD_SPREAD;
    public static IntValue LAPIS_SPREAD;
    public static IntValue DIAMOND_SPREAD;
    public static IntValue COAL_SPREAD;
    public static IntValue COPPER_SPREAD;
    public static IntValue GHAST_SPREAD;
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
    public static ForgeConfigSpec.IntValue COALMIN;
    public static ForgeConfigSpec.IntValue COALMAX;
    public static ForgeConfigSpec.IntValue COALVEINSIZE;
    public static ForgeConfigSpec.IntValue COPPERMIN;
    public static ForgeConfigSpec.IntValue COPPERMAX;
    public static ForgeConfigSpec.IntValue COPPERVEINSIZE;
    public static IntValue COPPER_SPREAD;
    public static ForgeConfigSpec.IntValue IRONMIN;
    public static ForgeConfigSpec.IntValue IRONMAX;
    public static ForgeConfigSpec.IntValue IRONVEINSIZE;
    public static IntValue IRONSPREAD;
    public static IntValue REDSTONE_SPREAD;
    public static IntValue EMERALD_SPREAD;
    public static IntValue ENDER_SPREAD;
    public static IntValue DIAMOND_SPREAD;
    public static IntValue LAPIS_SPREAD;
    public static IntValue COAL_SPREAD;
  }

  static {
    initConfig();
  }

  private static void initConfig() {
    String commentSpread = "\r\n Spread area";
    String commentVert = "\r\n Min and max y levels for spawn";
    String commentSize = "\r\n Registered worldgen feature size";
    CFG.comment("General settings").push(ModElemOres.MODID);
    final int max = 256 * 16;
    final int min = max * -1;
    Nether.EMERALDMIN = CFG.comment(commentVert).defineInRange("nether.emerald.lowest", 32, min, max);
    Nether.EMERALDMAX = CFG.comment(commentVert).defineInRange("nether.emerald.highest", 128, min, max);
    Nether.EMERALD_VEINSIZE = CFG.comment(commentSize).defineInRange("nether.emerald.size", 4, 0, 64);
    Nether.EMERALD_SPREAD = CFG.comment(commentSpread).defineInRange("nether.emerald.spread", 25, 0, 64);
    Nether.IRONMIN = CFG.comment(commentVert).defineInRange("nether.iron.lowest", -8, min, max);
    Nether.IRONMAX = CFG.comment(commentVert).defineInRange("nether.iron.highest", 128, min, max);
    Nether.IRON_VEINSIZE = CFG.comment(commentSize).defineInRange("nether.iron.size", 8, 0, 64);
    Nether.IRON_SPREAD = CFG.comment(commentSpread).defineInRange("nether.iron.spread", 50, 0, 64);
    Nether.LAPISMIN = CFG.comment(commentVert).defineInRange("nether.lapis.lowest", -8, min, max);
    Nether.LAPISMAX = CFG.comment(commentVert).defineInRange("nether.lapis.highest", 90, min, max);
    Nether.LAPIS_VEINSIZE = CFG.comment(commentSize).defineInRange("nether.lapis.size", 6, 0, 64);
    Nether.LAPIS_SPREAD = CFG.comment(commentSpread).defineInRange("nether.lapis.spread", 50, 0, 64);
    Nether.DIAMONDMIN = CFG.comment(commentVert).defineInRange("nether.diamond.lowest", -8, min, max);
    Nether.DIAMONDMAX = CFG.comment(commentVert).defineInRange("nether.diamond.highest", 100, min, max);
    Nether.DIAMOND_VEINSIZE = CFG.comment(commentSize).defineInRange("nether.diamond.size", 4, 0, 64);
    Nether.DIAMOND_SPREAD = CFG.comment(commentSpread).defineInRange("nether.diamond.spread", 50, 0, 64);
    Nether.COALMIN = CFG.comment(commentVert).defineInRange("nether.coal.lowest", 60, min, max);
    Nether.COALMAX = CFG.comment(commentVert).defineInRange("nether.coal.highest", 256, min, max);
    Nether.COAL_VEINSIZE = CFG.comment(commentSize).defineInRange("nether.coal.size", 12, 0, 64);
    Nether.COAL_SPREAD = CFG.comment(commentSpread).defineInRange("nether.coal.spread", 50, 0, 64);
    Nether.COPPERMIN = CFG.comment(commentVert).defineInRange("nether.copper.lowest", -8, min, max);
    Nether.COPPERMAX = CFG.comment(commentVert).defineInRange("nether.copper.highest", 128, min, max);
    Nether.COPPER_VEINSIZE = CFG.comment(commentSize).defineInRange("nether.copper.size", 4, 0, 64);
    Nether.COPPER_SPREAD = CFG.comment(commentSpread).defineInRange("nether.copper.spread", 50, 0, 64);
    Nether.GHASTMIN = CFG.comment(commentVert).defineInRange("nether.ghast.lowest", -16, min, max);
    Nether.GHASTMAX = CFG.comment(commentVert).defineInRange("nether.ghast.highest", 64, min, max);
    Nether.GHAST_VEINSIZE = CFG.comment(commentSize).defineInRange("nether.ghast.size", 4, 0, 64);
    Nether.GHAST_SPREAD = CFG.comment(commentSpread).defineInRange("nether.ghast.spread", 50, 0, 64);
    //nether redspone defaults to super small and rare
    Nether.REDSTONEMIN = CFG.comment(commentVert).defineInRange("nether.redstone.lowest", -128, min, max);
    Nether.REDSTONEMAX = CFG.comment(commentVert).defineInRange("nether.redstone.highest", 50, min, max);
    Nether.REDSTONE_VEINSIZE = CFG.comment(commentSize).defineInRange("nether.redstone.size", 8, 0, 64);
    Nether.REDSTONE_SPREAD = CFG.comment(commentSpread).defineInRange("nether.redstone.spread", 50, 0, 64);
    //the end
    End.REDSTONEMIN = CFG.comment(commentVert).defineInRange("end.redstone.lowest", 50, min, max);
    End.REDSTONEMAX = CFG.comment(commentVert).defineInRange("end.redstone.highest", 128, min, max);
    End.REDSTONEVEINSIZE = CFG.comment(commentSize).defineInRange("end.redstone.size", 4, 0, 64);
    End.REDSTONE_SPREAD = CFG.comment(commentSpread).defineInRange("end.redstone.spread", 50, 0, 64);
    End.EMERALDMIN = CFG.comment(commentVert).defineInRange("end.emerald.lowest", 1, min, max);
    End.EMERALDMAX = CFG.comment(commentVert).defineInRange("end.emerald.highest", 64, min, max);
    End.EMERALDVEINSIZE = CFG.comment(commentSize).defineInRange("end.emerald.size", 4, 0, 64);
    End.EMERALD_SPREAD = CFG.comment(commentSpread).defineInRange("end.emerald.spread", 25, 0, 64);
    End.ENDERMIN = CFG.comment(commentVert).defineInRange("end.ender.lowest", -8, min, max);
    End.ENDERMAX = CFG.comment(commentVert).defineInRange("end.ender.highest", 128, min, max);
    End.ENDERVEINSIZE = CFG.comment(commentSize).defineInRange("end.ender.size", 16, 0, 64);
    End.ENDER_SPREAD = CFG.comment(commentSpread).defineInRange("end.ender.spread", 50, 0, 64);
    End.DIAMONDMIN = CFG.comment(commentVert).defineInRange("end.diamond.lowest", -16, min, max);
    End.DIAMONDMAX = CFG.comment(commentVert).defineInRange("end.diamond.highest", 32, min, max);
    End.DIAMONDVEINSIZE = CFG.comment(commentSize).defineInRange("end.diamond.size", 4, 0, 64);
    End.DIAMOND_SPREAD = CFG.comment(commentSpread).defineInRange("end.diamond.spread", 50, 0, 64);
    End.LAPISMIN = CFG.comment(commentVert).defineInRange("end.lapis.lowest", 1, min, max);
    End.LAPISMAX = CFG.comment(commentVert).defineInRange("end.lapis.highest", 100, min, max);
    End.LAPISVEINSIZE = CFG.comment(commentSize).defineInRange("end.lapis.size", 4, 0, 64);
    End.LAPIS_SPREAD = CFG.comment(commentSpread).defineInRange("end.lapis.spread", 50, 0, 64);
    End.COALMIN = CFG.comment(commentVert).defineInRange("end.coal.lowest", 1, min, max);
    End.COALMAX = CFG.comment(commentVert).defineInRange("end.coal.highest", 80, min, max);
    End.COALVEINSIZE = CFG.comment(commentSize).defineInRange("end.coal.size", 4, 0, 64);
    End.COAL_SPREAD = CFG.comment(commentSpread).defineInRange("end.coal.spread", 50, 0, 64);
    End.COPPERMIN = CFG.comment(commentVert).defineInRange("end.copper.lowest", 1, min, max);
    End.COPPERMAX = CFG.comment(commentVert).defineInRange("end.copper.highest", 128, min, max);
    End.COPPERVEINSIZE = CFG.comment(commentSize).defineInRange("end.copper.size", 4, 0, 64);
    End.COPPER_SPREAD = CFG.comment(commentSpread).defineInRange("end.copper.spread", 50, 0, 64);
    //newshit
    End.IRONMIN = CFG.comment(commentVert).defineInRange("end.iron.lowest", 40, min, max);
    End.IRONMAX = CFG.comment(commentVert).defineInRange("end.iron.highest", 256, min, max);
    End.IRONVEINSIZE = CFG.comment(commentSize).defineInRange("end.iron.size", 8, 0, 64);
    End.IRONSPREAD = CFG.comment(commentSpread).defineInRange("end.iron.spread", 30, 0, 64);
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
