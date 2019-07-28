package com.lothrazar.elementaryores.world;
import com.google.common.collect.Lists;
import com.lothrazar.elementaryores.block.OresRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockWithContextConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.placement.CaveEdgeConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class WorldGenRegistry {

  private static int veinsize = 16;
  private static int spawnRate = 16;
  private static int minY = 1;
  private static int maxY = 255;

  public static void init() {

    //nether gold
    Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
        OresRegistry.oreGoldNeth.getDefaultState(), spawnRate), Placement.COUNT_RANGE, new CountRangeConfig(veinsize, minY, 0, maxY)));
    //nether lapis
    Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
        OresRegistry.oreLapisNether.getDefaultState(), spawnRate),
        Placement.COUNT_RANGE, new CountRangeConfig(veinsize, minY, 0, maxY)));


    Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE,
        new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), OresRegistry.oreRedstoneEnd.getDefaultState()),
        Placement.COUNT_RANGE, new CountRangeConfig(veinsize, minY, 0, maxY)));



  }
}
