package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ModRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ClientOreRegistry {

  @OnlyIn(Dist.CLIENT)
  public static void setup() {
    RenderType c = RenderType.getCutout();
    RenderTypeLookup.setRenderLayer(ModRegistry.EMERALD_NETHER.get(), c);
    RenderTypeLookup.setRenderLayer(ModRegistry.DIAMOND_NETHER.get(), c);
    RenderTypeLookup.setRenderLayer(ModRegistry.LAPIS_NETHER.get(), c);
    RenderTypeLookup.setRenderLayer(ModRegistry.ENDER_END.get(), c);
    RenderTypeLookup.setRenderLayer(ModRegistry.EMERALD_END.get(), c);
    RenderTypeLookup.setRenderLayer(ModRegistry.DIAMOND_END.get(), c);
    RenderTypeLookup.setRenderLayer(ModRegistry.LAPIS_END.get(), c);
    RenderTypeLookup.setRenderLayer(ModRegistry.REDSTONE_END.get(), c);
    RenderTypeLookup.setRenderLayer(ModRegistry.IRON_NETHER.get(), c);
  }
}
