package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ConfigHandler;
import com.lothrazar.elementaryores.ModElemOres;
import com.lothrazar.elementaryores.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class WorldGenRegistry {

  public static ConfiguredFeature<?, ?> EMERALD_NETHER = buildNetherOre(ModRegistry.EMERALD_NETHER.get(),
      ConfigHandler.emeraldVeinSize.get(), ConfigHandler.emeraldMax.get(), 60);

  public static ConfiguredFeature<?, ?> buildOverworldOre(Block bstate, int veinSize, int maxHeight, int timesRarer) {
    return Feature.ORE.withConfiguration(
        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
            bstate.getDefaultState(), veinSize))
        .withPlacement(Placement.RANGE.configure(
            new TopSolidRangeConfig(0, 0, maxHeight)))
        .square().chance(timesRarer);
  }

  public static ConfiguredFeature<?, ?> buildNetherOre(Block block, int veinSize, int maxHeight, int timesRarer) {
    return Feature.ORE.withConfiguration(
        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, block.getDefaultState(), veinSize))
        .square()
        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, maxHeight)))
        .chance(50);
  }

  public static ConfiguredFeature<?, ?> buildEndOre(BlockState bstate, int veinSize, int maxHeight, int timesRarer) {
    return Feature.ORE.withConfiguration(
        new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), bstate, veinSize))
        .square()
        .withPlacement(Placement.RANGE.configure(
            new TopSolidRangeConfig(0, 0, maxHeight)))
        .chance(timesRarer);
  }

  public static void init() {
    Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
    Registry.register(registry, new ResourceLocation(ModElemOres.MODID, "emeraldnether"), EMERALD_NETHER);
  }
}
