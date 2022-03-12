package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ModElemOres;
import com.lothrazar.elementaryores.ModRegistry;
import com.lothrazar.elementaryores.world.ConfigHandler.Nether;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import java.util.List;

public class WorldGenRegistry {

  private static final int SPREAD = 50;
  public static final RuleTest OW = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
  private static final RuleTest NETHER = new BlockMatchTest(Blocks.NETHERRACK); // OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER;
  private static final RuleTest END = new BlockMatchTest(Blocks.END_STONE);
  // end ores
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> REDSTONE_END = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "redstone_end"),
          END, ModRegistry.REDSTONE_END.get(), ConfigHandler.End.REDSTONEVEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ENDER_END = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "ender_end"),
          END, ModRegistry.ENDER_END.get(), ConfigHandler.End.ENDERVEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> EMERALD_END = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "emerald_end"),
          END, ModRegistry.EMERALD_END.get(), ConfigHandler.End.EMERALDVEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> DIAMOND_END = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "diamond_end"),
          END, ModRegistry.DIAMOND_END.get(), ConfigHandler.End.DIAMONDVEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> LAPIS_END = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "lapis_end"),
          END, ModRegistry.LAPIS_END.get(), ConfigHandler.End.LAPISVEINSIZE.get());

  //nether
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> DIAMOND_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "diamond_nether"),
          NETHER, ModRegistry.DIAMOND_NETHER.get(), ConfigHandler.Nether.DIAMONDVEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> LAPIS_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "lapis_nether"),
          NETHER, ModRegistry.LAPIS_NETHER.get(), ConfigHandler.Nether.LAPISVEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> IRON_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "iron_nether"),
          NETHER, ModRegistry.IRON_NETHER.get(), ConfigHandler.Nether.IRONVEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> EMERALD_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "emerald_nether"),
          NETHER, ModRegistry.EMERALD_NETHER.get(), Nether.EMERALDVEINSIZE.get());

  public static Holder<ConfiguredFeature<OreConfiguration, ?>> buildOreFeature(ResourceLocation location, RuleTest rule, Block block, int size) {
    return FeatureUtils.register(location.toString(), Feature.ORE, new OreConfiguration(rule, block.defaultBlockState(), size));
  }

  public static Holder<PlacedFeature> REDSTONE_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "redstone_end").toString(),
          REDSTONE_END, generatePlacementModifiers(SPREAD, ConfigHandler.End.REDSTONEMIN.get(), ConfigHandler.End.REDSTONEMAX.get()));
  public static Holder<PlacedFeature> ENDER_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "ender_end").toString(),
          ENDER_END, generatePlacementModifiers(SPREAD, ConfigHandler.End.ENDERMIN.get(), ConfigHandler.End.ENDERMAX.get()));
  public static Holder<PlacedFeature> EMERALD_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "emerald_end").toString(),
          EMERALD_END, generatePlacementModifiers(SPREAD, ConfigHandler.End.EMERALDMIN.get(), ConfigHandler.End.EMERALDMAX.get()));
  public static Holder<PlacedFeature> DIAMOND_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "diamond_end").toString(),
          DIAMOND_END, generatePlacementModifiers(SPREAD, ConfigHandler.End.DIAMONDMIN.get(), ConfigHandler.End.DIAMONDMAX.get()));
  public static Holder<PlacedFeature> LAPIS_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "lapis_end").toString(),
          LAPIS_END, generatePlacementModifiers(SPREAD, ConfigHandler.End.LAPISMIN.get(), ConfigHandler.End.LAPISMAX.get()));
  
  public static Holder<PlacedFeature> DIAMOND_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "diamond_nether").toString(),
          DIAMOND_NETHER, generatePlacementModifiers(SPREAD, ConfigHandler.Nether.DIAMONDMIN.get(), ConfigHandler.Nether.DIAMONDMAX.get()));
  public static Holder<PlacedFeature> LAPIS_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "lapis_nether").toString(),
          LAPIS_NETHER, generatePlacementModifiers(SPREAD, ConfigHandler.Nether.LAPISMIN.get(), ConfigHandler.Nether.LAPISMAX.get()));
  public static Holder<PlacedFeature> IRON_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "iron_nether").toString(),
          IRON_NETHER, generatePlacementModifiers(SPREAD, ConfigHandler.Nether.IRONMIN.get(), ConfigHandler.Nether.IRONMAX.get()));
  public static Holder<PlacedFeature> EMERALD_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "emerald_nether").toString(),
          EMERALD_NETHER, generatePlacementModifiers(SPREAD, ConfigHandler.Nether.EMERALDMIN.get(), ConfigHandler.Nether.EMERALDMAX.get()));

  private static List<PlacementModifier> generatePlacementModifiers(int spread, int minHeight, int maxHeight) {
    return commonOrePlacement(spread, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(minHeight), VerticalAnchor.absolute(maxHeight)));
  }

  private static List<PlacementModifier> orePlacement(PlacementModifier countModifier, PlacementModifier heightPlacement) {
    return List.of(countModifier, InSquarePlacement.spread(), heightPlacement, BiomeFilter.biome());
  }

  private static List<PlacementModifier> commonOrePlacement(int spread, PlacementModifier modifier) {
    return orePlacement(CountPlacement.of(spread), modifier);
  }

  public static void init() {
    //Just here to load the class and let the features be initialized and registered
  }
}
