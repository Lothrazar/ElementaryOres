package com.lothrazar.elementaryores.world;

import java.nio.file.Path;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.elementaryores.ModElemOres;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {

  private static final ForgeConfigSpec.Builder CFG = new ForgeConfigSpec.Builder();
  public static ForgeConfigSpec COMMON_CONFIG;
  static {
    initConfig();
  }

  private static void initConfig() {
    CFG.comment("See the datapack for modifying ore spawns").push(ModElemOres.MODID);
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
