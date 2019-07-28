package com.lothrazar.elementaryores.world;
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
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class WorldGenRegistry {

  private static void initConfigs() {
    OresRegistry.GOLD_NETHER.setVeinSize(ConfigHandler.GOLD_NETHER.get());
    OresRegistry.LAPIS_NETHER.setVeinSize(ConfigHandler.LAPIS_NETHER.get());
    OresRegistry.REDSTONE_END.setVeinSize(ConfigHandler.REDSTONE_END.get());
  }

  public static void init() {
    initConfigs();
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
    //end redstone
    if (OresRegistry.REDSTONE_END.getVeinSize() > 0) {
      Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
          new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), OresRegistry.REDSTONE_END.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(
              OresRegistry.REDSTONE_END.getVeinSize(), OresRegistry.REDSTONE_END.getMinSpawnY(), 0, OresRegistry.REDSTONE_END.getMaxSpawnY())));
    }
  }
}
