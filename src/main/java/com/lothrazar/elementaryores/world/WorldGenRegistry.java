package com.lothrazar.elementaryores.world;

import java.util.List;
import com.lothrazar.elementaryores.ModElemOres;
import com.lothrazar.elementaryores.ModRegistry;
import com.lothrazar.elementaryores.world.ConfigHandler.Nether;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
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

public class WorldGenRegistry {

  //  public static final RuleTest OW = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
  private static final RuleTest NETHER = new BlockMatchTest(Blocks.NETHERRACK); // OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER;
  private static final RuleTest END = new BlockMatchTest(Blocks.END_STONE);
  // end ores
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> COAL_END = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "coal_end"),
      END, ModRegistry.COAL_END.get(), ConfigHandler.End.COALVEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> COPPER_END = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "copper_end"),
      END, ModRegistry.COPPER_END.get(), ConfigHandler.End.COPPERVEINSIZE.get());
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
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> COAL_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "coal_nether"),
      NETHER, ModRegistry.COAL_NETHER.get(), ConfigHandler.Nether.COAL_VEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> COPPER_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "copper_nether"),
      NETHER, ModRegistry.COPPER_NETHER.get(), ConfigHandler.Nether.COPPER_VEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> DIAMOND_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "diamond_nether"),
      NETHER, ModRegistry.DIAMOND_NETHER.get(), ConfigHandler.Nether.DIAMOND_VEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> LAPIS_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "lapis_nether"),
      NETHER, ModRegistry.LAPIS_NETHER.get(), ConfigHandler.Nether.LAPIS_VEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> IRON_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "iron_nether"),
      NETHER, ModRegistry.IRON_NETHER.get(), ConfigHandler.Nether.IRON_VEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> EMERALD_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "emerald_nether"),
      NETHER, ModRegistry.EMERALD_NETHER.get(), Nether.EMERALD_VEINSIZE.get());
  public static final Holder<ConfiguredFeature<OreConfiguration, ?>> GHAST_NETHER = buildOreFeature(new ResourceLocation(ModElemOres.MODID, "ghast_nether"),
      NETHER, ModRegistry.GHAST_NETHER.get(), Nether.GHAST_VEINSIZE.get());
  //end placed
  public static Holder<PlacedFeature> COAL_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "coal_end").toString(),
      COAL_END, generatePlacementModifiers(ConfigHandler.End.COAL_SPREAD.get(), ConfigHandler.End.COALMIN.get(), ConfigHandler.End.COALMAX.get()));
  public static Holder<PlacedFeature> COPPER_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "copper_end").toString(),
      COPPER_END, generatePlacementModifiers(ConfigHandler.End.COPPER_SPREAD.get(), ConfigHandler.End.COPPERMIN.get(), ConfigHandler.End.COPPERMAX.get()));
  public static Holder<PlacedFeature> REDSTONE_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "redstone_end").toString(),
      REDSTONE_END, generatePlacementModifiers(ConfigHandler.End.REDSTONE_SPREAD.get(), ConfigHandler.End.REDSTONEMIN.get(), ConfigHandler.End.REDSTONEMAX.get()));
  public static Holder<PlacedFeature> ENDER_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "ender_end").toString(),
      ENDER_END, generatePlacementModifiers(ConfigHandler.End.ENDER_SPREAD.get(), ConfigHandler.End.ENDERMIN.get(), ConfigHandler.End.ENDERMAX.get()));
  public static Holder<PlacedFeature> EMERALD_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "emerald_end").toString(),
      EMERALD_END, generatePlacementModifiers(ConfigHandler.End.EMERALD_SPREAD.get(), ConfigHandler.End.EMERALDMIN.get(), ConfigHandler.End.EMERALDMAX.get()));
  public static Holder<PlacedFeature> DIAMOND_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "diamond_end").toString(),
      DIAMOND_END, generatePlacementModifiers(ConfigHandler.End.DIAMOND_SPREAD.get(), ConfigHandler.End.DIAMONDMIN.get(), ConfigHandler.End.DIAMONDMAX.get()));
  public static Holder<PlacedFeature> LAPIS_END_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "lapis_end").toString(),
      LAPIS_END, generatePlacementModifiers(ConfigHandler.End.LAPIS_SPREAD.get(), ConfigHandler.End.LAPISMIN.get(), ConfigHandler.End.LAPISMAX.get()));
  //nether placed
  public static Holder<PlacedFeature> DIAMOND_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "diamond_nether").toString(),
      DIAMOND_NETHER, generatePlacementModifiers(ConfigHandler.End.DIAMOND_SPREAD.get(), ConfigHandler.Nether.DIAMONDMIN.get(), ConfigHandler.Nether.DIAMONDMAX.get()));
  public static Holder<PlacedFeature> LAPIS_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "lapis_nether").toString(),
      LAPIS_NETHER, generatePlacementModifiers(ConfigHandler.Nether.LAPIS_SPREAD.get(), ConfigHandler.Nether.LAPISMIN.get(), ConfigHandler.Nether.LAPISMAX.get()));
  public static Holder<PlacedFeature> IRON_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "iron_nether").toString(),
      IRON_NETHER, generatePlacementModifiers(ConfigHandler.Nether.IRON_SPREAD.get(), ConfigHandler.Nether.IRONMIN.get(), ConfigHandler.Nether.IRONMAX.get()));
  public static Holder<PlacedFeature> EMERALD_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "emerald_nether").toString(),
      EMERALD_NETHER, generatePlacementModifiers(ConfigHandler.Nether.EMERALD_SPREAD.get(), ConfigHandler.Nether.EMERALDMIN.get(), ConfigHandler.Nether.EMERALDMAX.get()));
  public static Holder<PlacedFeature> GHAST_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "ghast_nether").toString(),
      GHAST_NETHER, generatePlacementModifiers(ConfigHandler.Nether.GHAST_SPREAD.get(), ConfigHandler.Nether.GHASTMIN.get(), ConfigHandler.Nether.GHASTMAX.get()));
  public static Holder<PlacedFeature> COAL_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "coal_nether").toString(),
      COAL_NETHER, generatePlacementModifiers(ConfigHandler.Nether.COAL_SPREAD.get(), ConfigHandler.Nether.COALMIN.get(), ConfigHandler.Nether.COALMAX.get()));
  public static Holder<PlacedFeature> COPPER_NETHER_PLACED = PlacementUtils.register(new ResourceLocation(ModElemOres.MODID, "copper_nether").toString(),
      COPPER_NETHER, generatePlacementModifiers(ConfigHandler.Nether.COPPER_SPREAD.get(), ConfigHandler.Nether.COPPERMIN.get(), ConfigHandler.Nether.COPPERMAX.get()));

  private static Holder<ConfiguredFeature<OreConfiguration, ?>> buildOreFeature(ResourceLocation location, RuleTest rule, Block block, int size) {
    return FeatureUtils.register(location.toString(), Feature.ORE, new OreConfiguration(rule, block.defaultBlockState(), size));
  }

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
