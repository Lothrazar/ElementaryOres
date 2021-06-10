package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ModElemOres;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ModElemOres.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class BiomeLoader {

  @SubscribeEvent(priority = EventPriority.HIGH)
  public static void onBiomeLoading(BiomeLoadingEvent event) {
    if (event.getCategory() == Biome.Category.NETHER) {
      //if true // vein size > 0
      event.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, WorldGenRegistry.EMERALD_NETHER);
    }
  }
}
