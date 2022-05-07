package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ModElemOres;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
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
    if (event.getCategory() == Biome.BiomeCategory.NETHER) {
      if (ConfigHandler.Nether.EMERALD_VEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.EMERALD_NETHER_PLACED);
      if (ConfigHandler.Nether.DIAMOND_VEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.DIAMOND_NETHER_PLACED);
      if (ConfigHandler.Nether.LAPIS_VEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.LAPIS_NETHER_PLACED);
      if (ConfigHandler.Nether.IRON_VEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.IRON_NETHER_PLACED);
      if (ConfigHandler.Nether.COAL_VEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.COAL_NETHER_PLACED);
      if (ConfigHandler.Nether.COPPER_VEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.COPPER_NETHER_PLACED);
      if (ConfigHandler.Nether.GHAST_VEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.GHAST_NETHER_PLACED);
    }
    else if (event.getCategory() == Biome.BiomeCategory.THEEND) {
      if (ConfigHandler.End.REDSTONEVEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.REDSTONE_END_PLACED);
      if (ConfigHandler.End.EMERALDVEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.EMERALD_END_PLACED);
      if (ConfigHandler.End.DIAMONDVEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.DIAMOND_END_PLACED);
      if (ConfigHandler.End.ENDERVEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.ENDER_END_PLACED);
      if (ConfigHandler.End.LAPISVEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.LAPIS_END_PLACED);
      if (ConfigHandler.End.COALVEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.COAL_END_PLACED);
      if (ConfigHandler.End.COPPERVEINSIZE.get() > 0)
        r.addFeature(d, WorldGenRegistry.COPPER_END_PLACED);
    }
  }
}
