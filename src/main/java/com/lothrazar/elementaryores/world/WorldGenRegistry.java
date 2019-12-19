package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.block.BlockElementaryOre;
import com.lothrazar.elementaryores.block.OresRegistry;
import com.lothrazar.elementaryores.setup.ConfigHandler;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
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

  private static void registerSpawnNether(BlockElementaryOre ore, int size) {
    if (ore.getVeinSize() > 0) {
      Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
          Feature.ORE.func_225566_b_(
              new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ore.getDefaultState(), size))
              .func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(
                  ore.getVeinSize(), ore.getMinSpawnY(), 0, ore.getMaxSpawnY()))));
    }
  }

  private static void registerSpawnEnd(BlockElementaryOre ore) {
    for (int i = 0; i < ore.getVeinSize(); i++) {
      Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
          Feature.EMERALD_ORE.func_225566_b_(
              new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), ore.getDefaultState()))
              .func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(
                  ore.getVeinSize(), ore.getMinSpawnY(), 0, ore.getMaxSpawnY()))));
    }
  }

  public static void init() {
    initConfigs();
    registerSpawnNether(OresRegistry.GOLD_NETHER, 16);
    registerSpawnNether(OresRegistry.LAPIS_NETHER, 8);
    registerSpawnNether(OresRegistry.DIAMOND_NETHER, 8);
    registerSpawnEnd(OresRegistry.REDSTONE_END);
    registerSpawnEnd(OresRegistry.EMERALD_END);
    registerSpawnEnd(OresRegistry.ENDER_END);
  }
}
