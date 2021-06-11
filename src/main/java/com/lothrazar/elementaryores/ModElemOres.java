package com.lothrazar.elementaryores;

import com.lothrazar.elementaryores.world.ClientOreRegistry;
import com.lothrazar.elementaryores.world.ConfigHandler;
import com.lothrazar.elementaryores.world.WorldGenRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ModElemOres.MODID)
public class ModElemOres {

  public static final String MODID = "elementaryores";
  public static final Logger LOGGER = LogManager.getLogger();

  public ModElemOres() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    ModRegistry.BLOCKS.register(eventBus);
    ModRegistry.ITEMS.register(eventBus);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
    ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + ".toml"));
  }

  @OnlyIn(Dist.CLIENT)
  public void onClientSetup(FMLClientSetupEvent e) {
    ClientOreRegistry.setup();
  }

  private void setup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      WorldGenRegistry.init();
    });
  }
}
