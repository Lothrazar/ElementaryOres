package com.lothrazar.elementaryores.world;

import com.lothrazar.elementaryores.ModRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientOreRegistry {

  @OnlyIn(Dist.CLIENT)
  public static void setup(FMLClientSetupEvent event) {
    RenderType c = RenderType.cutout();
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.COAL_NETHER.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.COPPER_NETHER.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.DIAMOND_NETHER.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.EMERALD_NETHER.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.IRON_NETHER.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.LAPIS_NETHER.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.ENDER_END.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.COAL_END.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.COPPER_END.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.DIAMOND_END.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.EMERALD_END.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.LAPIS_END.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.REDSTONE_END.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.GHAST_NETHER.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.REDSTONE_NETHER.get(), c);
    ItemBlockRenderTypes.setRenderLayer(ModRegistry.IRON_END.get(), c);
  }
}
