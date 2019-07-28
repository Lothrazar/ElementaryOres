package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.block.OresRegistry;
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

  public static void init() {
    //nether gold
    Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
        OresRegistry.oreGoldNeth.getDefaultState(), OresRegistry.oreGoldNeth.getSpawnRate()), Placement.COUNT_RANGE, new CountRangeConfig(
        OresRegistry.oreGoldNeth.getVeinSize(), OresRegistry.oreGoldNeth.getMinSpawnY(), 0, OresRegistry.oreGoldNeth.getMaxSpawnY())));
    //nether lapis
    Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
        OresRegistry.oreLapisNether.getDefaultState(), OresRegistry.oreLapisNether.getSpawnRate()), Placement.COUNT_RANGE, new CountRangeConfig(
        OresRegistry.oreLapisNether.getVeinSize(), OresRegistry.oreLapisNether.getMinSpawnY(), 0, OresRegistry.oreLapisNether.getMaxSpawnY()
    )));
    //end redstone
    Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
        new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), OresRegistry.oreRedstoneEnd.getDefaultState()),
        Placement.COUNT_RANGE, new CountRangeConfig(
            OresRegistry.oreRedstoneEnd.getVeinSize(), OresRegistry.oreRedstoneEnd.getMinSpawnY(), 0, OresRegistry.oreRedstoneEnd.getMaxSpawnY())));
  }
}
