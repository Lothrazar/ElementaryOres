package com.lothrazar.elementaryores;

import com.lothrazar.elementaryores.world.WorldGenRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModElemOres.MODID)
public class ModElemOres {

  public static final String MODID = "elementaryores";
  public static final Logger LOGGER = LogManager.getLogger();

  public ModElemOres() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    ModRegistry.BLOCKS.register(eventBus);
    ModRegistry.ITEMS.register(eventBus);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    //only for server starting
    MinecraftForge.EVENT_BUS.register(this);
    ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + ".toml"));
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
  }

  @OnlyIn(Dist.CLIENT)
  @SubscribeEvent
  public void onClientSetup(FMLClientSetupEvent e) {
    RenderType c = RenderType.getCutout();
    RenderTypeLookup.setRenderLayer(ModRegistry.EMERALD_NETHER.get(), c);
  }

  private void setup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      WorldGenRegistry.init();
    });
  }
}
