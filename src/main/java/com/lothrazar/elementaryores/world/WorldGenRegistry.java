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

  private static final int SPREAD = 50;
  public static final RuleTest OW = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
  private static final RuleTest NETHER = new BlockMatchRuleTest(Blocks.NETHERRACK); // OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER;
  private static final RuleTest END = new BlockMatchRuleTest(Blocks.END_STONE);
  // end ores
  //WHY DOES only redstone and emerald work in the end?
  public static final ConfiguredFeature<?, ?> REDSTONE_END = buildOreFeature(END, ModRegistry.REDSTONE_END.get(),
      ConfigHandler.End.REDSTONEVEINSIZE.get(), ConfigHandler.End.REDSTONEMIN.get(), ConfigHandler.End.REDSTONEMAX.get(), SPREAD);
  public static final ConfiguredFeature<?, ?> ENDER_END = buildOreFeature(END, ModRegistry.ENDER_END.get(),
      ConfigHandler.End.ENDERVEINSIZE.get(), ConfigHandler.End.ENDERMIN.get(), ConfigHandler.End.ENDERMAX.get(), SPREAD);
  public static final ConfiguredFeature<?, ?> EMERALD_END = buildOreFeature(END, ModRegistry.EMERALD_END.get(),
      ConfigHandler.End.EMERALDVEINSIZE.get(), ConfigHandler.End.EMERALDMIN.get(), ConfigHandler.End.EMERALDMAX.get(), SPREAD);
  public static final ConfiguredFeature<?, ?> DIAMOND_END = buildOreFeature(END, ModRegistry.DIAMOND_END.get(),
      ConfigHandler.End.DIAMONDVEINSIZE.get(), ConfigHandler.End.DIAMONDMIN.get(), ConfigHandler.End.DIAMONDMAX.get(), SPREAD);
  public static final ConfiguredFeature<?, ?> LAPIS_END = buildOreFeature(END, ModRegistry.LAPIS_END.get(),
      ConfigHandler.End.LAPISVEINSIZE.get(), ConfigHandler.End.LAPISMIN.get(), ConfigHandler.End.LAPISMAX.get(), SPREAD);
  //
  //nether
  public static final ConfiguredFeature<?, ?> DIAMOND_NETHER = buildOreFeature(NETHER, ModRegistry.DIAMOND_NETHER.get(),
      ConfigHandler.Nether.DIAMONDVEINSIZE.get(), ConfigHandler.Nether.DIAMONDMIN.get(), ConfigHandler.Nether.DIAMONDMAX.get(), SPREAD);
  public static final ConfiguredFeature<?, ?> LAPIS_NETHER = buildOreFeature(NETHER, ModRegistry.LAPIS_NETHER.get(),
      ConfigHandler.Nether.LAPISVEINSIZE.get(), ConfigHandler.Nether.LAPISMIN.get(), ConfigHandler.Nether.LAPISMAX.get(), SPREAD);
  public static final ConfiguredFeature<?, ?> IRON_NETHER = buildOreFeature(NETHER, ModRegistry.IRON_NETHER.get(),
      ConfigHandler.Nether.IRONVEINSIZE.get(), ConfigHandler.Nether.IRONMIN.get(), ConfigHandler.Nether.IRONMAX.get(), SPREAD);
  public static final ConfiguredFeature<?, ?> EMERALD_NETHER = buildOreFeature(NETHER, ModRegistry.EMERALD_NETHER.get(),
      ConfigHandler.Nether.EMERALDVEINSIZE.get(), ConfigHandler.Nether.EMERALDMIN.get(), ConfigHandler.Nether.EMERALDMAX.get(), SPREAD);

  public static ConfiguredFeature<?, ?> buildOreFeature(RuleTest rule, Block block, int size, int minHeight, int maxHeight, int spread) {
    return Feature.ORE.withConfiguration(new OreFeatureConfig(rule, block.getDefaultState(), size)).func_242731_b(spread).square()
        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)
        //wtf
        )); // 
  }

  public static void init() {
    Registry<ConfiguredFeature<?, ?>> r = WorldGenRegistries.CONFIGURED_FEATURE;
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "iron_nether"), IRON_NETHER);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "emerald_nether"), EMERALD_NETHER);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "diamond_nether"), DIAMOND_NETHER);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "lapis_nether"), LAPIS_NETHER);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "redstone_end"), REDSTONE_END);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "ender_end"), ENDER_END);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "emerald_end"), EMERALD_END);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "diamond_end"), DIAMOND_END);
    Registry.register(r, new ResourceLocation(ModElemOres.MODID, "lapis_end"), LAPIS_END);
  }
}
