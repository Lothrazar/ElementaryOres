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
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.placement.CaveEdgeConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
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
    //
   ConfiguredFeature<?> feature = Biome.createDecoratedFeature(Feature.DISK,
        new SphereReplaceConfig(OresRegistry.oreRedstoneEnd.getDefaultState(), 8, 9 ,
            Lists.newArrayList(Blocks.END_STONE.getDefaultState())),
        Placement.COUNT_RANGE, new CountRangeConfig(veinsize, minY, 0, maxY));


  feature =   Biome.createDecoratedFeature(Feature.SIMPLE_BLOCK,
            new BlockWithContextConfig(OresRegistry.oreRedstoneEnd.getDefaultState(),
                new BlockState[]{Blocks.END_STONE.getDefaultState(), Blocks.AIR.getDefaultState()},
                new BlockState[]{Blocks.END_STONE.getDefaultState()},
                new BlockState[]{Blocks.END_STONE.getDefaultState(), Blocks.AIR.getDefaultState()  }



                ),
//            Placement.CARVING_MASK, new CaveEdgeConfig(GenerationStage.Carving.LIQUID, 0.4F)

      Placement.COUNT_RANGE, new CountRangeConfig(veinsize, minY, 0, maxY)
  );



    Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, feature);
  }

  public static void addSwampClayDisks(Biome biomeIn) {
//    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.DISK,
//        new SphereReplaceConfig(Blocks.CLAY.getDefaultState(), 4, 1,
//            Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.CLAY.getDefaultState())), Placement.COUNT_TOP_SOLID, new FrequencyConfig(1)));

    //    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 80)));
    //    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 80)));
    //    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.COAL_ORE.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
    //    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.IRON_ORE.getDefaultState(), 9), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 64)));

  }
}
