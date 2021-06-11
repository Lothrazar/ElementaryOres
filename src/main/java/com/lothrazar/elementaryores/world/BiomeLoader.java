package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ModElemOres;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ModElemOres.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class BiomeLoader {

  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void onBiomeLoading(BiomeLoadingEvent event) {
    Decoration d = Decoration.UNDERGROUND_ORES;
    BiomeGenerationSettingsBuilder r = event.getGeneration();
    if (event.getCategory() == Biome.Category.NETHER) {
      //if true // vein size > 0
      r.withFeature(d, WorldGenRegistry.EMERALD_NETHER);
      r.withFeature(d, WorldGenRegistry.DIAMOND_NETHER);
      r.withFeature(d, WorldGenRegistry.LAPIS_NETHER);
      r.withFeature(d, WorldGenRegistry.IRON_NETHER);
    }
    else if (event.getCategory() == Biome.Category.THEEND) {
      //if true // vein size > 0
      r.withFeature(d, WorldGenRegistry.REDSTONE_END);
      r.withFeature(d, WorldGenRegistry.EMERALD_END);
      r.withFeature(d, WorldGenRegistry.DIAMOND_END);
      r.withFeature(d, WorldGenRegistry.ENDER_END);
      r.withFeature(d, WorldGenRegistry.LAPIS_END);
    }
  }
}
