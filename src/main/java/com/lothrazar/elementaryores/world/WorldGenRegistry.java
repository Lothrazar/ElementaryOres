package com.lothrazar.elementaryores.world;
import com.lothrazar.elementaryores.block.OresRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class WorldGenRegistry {

  private static int veinsize = 16;
  private static int spawnRate =16;
  private static int minY = 1;
  private static int maxY = 255;

  public static void init() {

    Biome biome = Biomes.NETHER;
//nether gold
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
        OresRegistry.oreGoldNeth.getDefaultState(), spawnRate), Placement.COUNT_RANGE, new CountRangeConfig(veinsize, minY, 0, maxY)));
//nether lapis


    //end redstone
  }
}
