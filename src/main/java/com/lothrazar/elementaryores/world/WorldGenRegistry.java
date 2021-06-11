package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ModElemOres;
import com.lothrazar.elementaryores.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class WorldGenRegistry {

  public static final RuleTest OW = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
  private static final RuleTest NETHER = new BlockMatchRuleTest(Blocks.NETHERRACK); // OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER;
  private static final RuleTest END = new BlockMatchRuleTest(Blocks.END_STONE);
  public static final ConfiguredFeature<?, ?> REDSTONE_END = buildOreFeature(END, ModRegistry.REDSTONE_END.get(), ConfigHandler.End.redstoneVeinSize.get(), ConfigHandler.End.redstoneMin.get(), ConfigHandler.End.redstoneMax.get(), 100);
  public static final ConfiguredFeature<?, ?> ENDER_END = buildOreFeature(NETHER, ModRegistry.ENDER_END.get(), ConfigHandler.End.enderVeinSize.get(), ConfigHandler.End.enderMin.get(), ConfigHandler.End.enderMax.get(), 20);
  public static final ConfiguredFeature<?, ?> EMERALD_NETHER = buildOreFeature(NETHER, ModRegistry.EMERALD_NETHER.get(), ConfigHandler.Nether.emeraldVeinSize.get(), ConfigHandler.Nether.emeraldMin.get(), ConfigHandler.Nether.emeraldMax.get(), 100);
  public static final ConfiguredFeature<?, ?> EMERALD_END = buildOreFeature(END, ModRegistry.EMERALD_END.get(), ConfigHandler.End.emeraldVeinSize.get(), ConfigHandler.End.emeraldMin.get(), ConfigHandler.End.emeraldMax.get(), 50);
  public static final ConfiguredFeature<?, ?> DIAMOND_NETHER = buildOreFeature(NETHER, ModRegistry.DIAMOND_NETHER.get(), ConfigHandler.Nether.diamondVeinSize.get(), ConfigHandler.Nether.diamondMin.get(), ConfigHandler.Nether.diamondMax.get(), 100);
  public static final ConfiguredFeature<?, ?> DIAMOND_END = buildOreFeature(END, ModRegistry.DIAMOND_END.get(), ConfigHandler.End.diamondVeinSize.get(), ConfigHandler.End.diamondMin.get(), ConfigHandler.End.diamondMax.get(), 50);
  public static final ConfiguredFeature<?, ?> LAPIS_NETHER = buildOreFeature(NETHER, ModRegistry.LAPIS_NETHER.get(), ConfigHandler.Nether.lapisVeinSize.get(), ConfigHandler.Nether.lapisMin.get(), ConfigHandler.Nether.lapisMax.get(), 50);
  public static final ConfiguredFeature<?, ?> LAPIS_END = buildOreFeature(END, ModRegistry.LAPIS_END.get(), ConfigHandler.End.lapisVeinSize.get(), ConfigHandler.End.lapisMin.get(), ConfigHandler.End.lapisMax.get(), 20);
  public static final ConfiguredFeature<?, ?> IRON_NETHER = buildOreFeature(NETHER, ModRegistry.IRON_NETHER.get(), ConfigHandler.Nether.ironVeinSize.get(), ConfigHandler.Nether.ironMin.get(), ConfigHandler.Nether.ironMax.get(), 50);

  public static ConfiguredFeature<?, ?> buildOreFeature(RuleTest rule, Block block, int size, int minHeight, int maxHeight, int spread) {
    return Feature.ORE.withConfiguration(new OreFeatureConfig(rule, block.getDefaultState(), size)).range(64).func_242731_b(spread).square()
        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 1, maxHeight)));
  }

  public static void init() {
    Registry<ConfiguredFeature<?, ?>> r = WorldGenRegistries.CONFIGURED_FEATURE;
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "iron"), IRON_NETHER);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "emerald_nether"), EMERALD_NETHER);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "diamond_nether"), DIAMOND_NETHER);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "lapis_nether"), LAPIS_NETHER);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "redstone"), REDSTONE_END);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "ender"), ENDER_END);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "emerald_end"), EMERALD_END);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "diamond_end"), DIAMOND_END);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "lapis_end"), LAPIS_END);
  }
}
