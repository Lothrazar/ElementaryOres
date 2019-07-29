package com.lothrazar.elementaryores.world;
import com.google.common.collect.Lists;
import com.lothrazar.elementaryores.block.OresRegistry;
import com.lothrazar.elementaryores.setup.ConfigHandler;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class WorldGenRegistry {

  private static void initConfigs() {
    OresRegistry.GOLD_NETHER.setVeinSize(ConfigHandler.goldVeinSize);
    OresRegistry.GOLD_NETHER.setMinSpawnY(ConfigHandler.goldMin);
    OresRegistry.GOLD_NETHER.setMaxSpawnY(ConfigHandler.goldMax);
    OresRegistry.LAPIS_NETHER.setVeinSize(ConfigHandler.lapisVeinSize);
    OresRegistry.LAPIS_NETHER.setMinSpawnY(ConfigHandler.lapisMin);
    OresRegistry.LAPIS_NETHER.setMaxSpawnY(ConfigHandler.lapisMax);
    OresRegistry.REDSTONE_END.setVeinSize(ConfigHandler.redstoneVeinSize);
    OresRegistry.REDSTONE_END.setMinSpawnY(ConfigHandler.redstoneMin);
    OresRegistry.REDSTONE_END.setMaxSpawnY(ConfigHandler.redstoneMax);
    OresRegistry.DIAMOND_NETHER.setVeinSize(ConfigHandler.diamondVeinSize);
    OresRegistry.DIAMOND_NETHER.setMinSpawnY(ConfigHandler.diamondMin);
    OresRegistry.DIAMOND_NETHER.setMaxSpawnY(ConfigHandler.diamondMax);
    OresRegistry.EMERALD_END.setVeinSize(ConfigHandler.emeraldVeinSize);
    OresRegistry.EMERALD_END.setMinSpawnY(ConfigHandler.emeraldMin);
    OresRegistry.EMERALD_END.setMaxSpawnY(ConfigHandler.emeraldMax);
    OresRegistry.ENDER_END.setVeinSize(ConfigHandler.enderVeinSize);
    OresRegistry.ENDER_END.setMinSpawnY(ConfigHandler.enderMin);
    OresRegistry.ENDER_END.setMaxSpawnY(ConfigHandler.enderMax);
  }

  private static void initNetherOre() {
    //nether gold
    if (OresRegistry.GOLD_NETHER.getVeinSize() > 0) {
      Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
          OresRegistry.GOLD_NETHER.getDefaultState(), 16), Placement.COUNT_RANGE, new CountRangeConfig(
          OresRegistry.GOLD_NETHER.getVeinSize(), OresRegistry.GOLD_NETHER.getMinSpawnY(), 0, OresRegistry.GOLD_NETHER.getMaxSpawnY())));
    }
    //nether lapis
    if (OresRegistry.LAPIS_NETHER.getVeinSize() > 0) {
      Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
          OresRegistry.LAPIS_NETHER.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(
          OresRegistry.LAPIS_NETHER.getVeinSize(), OresRegistry.LAPIS_NETHER.getMinSpawnY(), 0, OresRegistry.LAPIS_NETHER.getMaxSpawnY()
      )));
    }
    if (OresRegistry.DIAMOND_NETHER.getVeinSize() > 0) {
      Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
          OresRegistry.DIAMOND_NETHER.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(
          OresRegistry.DIAMOND_NETHER.getVeinSize(), OresRegistry.DIAMOND_NETHER.getMinSpawnY(), 0, OresRegistry.DIAMOND_NETHER.getMaxSpawnY()
      )));
    }
  }

  private static void initEndOre() {
    //end redstone
    for (int i = 0; i < OresRegistry.REDSTONE_END.getVeinSize(); i++) {
      Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
          new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), OresRegistry.REDSTONE_END.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(
              1, OresRegistry.REDSTONE_END.getMinSpawnY(), 0, OresRegistry.REDSTONE_END.getMaxSpawnY())));
    }
    for (int i = 0; i < OresRegistry.EMERALD_END.getVeinSize(); i++) {
      Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
          new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), OresRegistry.EMERALD_END.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(
              1, OresRegistry.EMERALD_END.getMinSpawnY(), 0, OresRegistry.EMERALD_END.getMaxSpawnY())));
    }
    for (int i = 0; i < OresRegistry.ENDER_END.getVeinSize() ;i++){
      Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
          new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), OresRegistry.ENDER_END.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(
             1, OresRegistry.ENDER_END.getMinSpawnY(), 0, OresRegistry.ENDER_END.getMaxSpawnY())));
    }
  }

  public static void init() {
    initConfigs();
    initNetherOre();
    initEndOre();
  }
}
