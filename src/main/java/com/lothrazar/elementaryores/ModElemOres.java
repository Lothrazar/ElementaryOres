package com.lothrazar.elementaryores;

import com.lothrazar.elementaryores.world.ClientOreRegistry;
import com.lothrazar.elementaryores.world.ConfigHandler;
import com.lothrazar.elementaryores.world.WorldGenRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(ModElemOres.MODID)
public class ModElemOres {

  public static final String MODID = "elementaryores";

  public ModElemOres() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    ModRegistry.BLOCKS.register(eventBus);
    ModRegistry.ITEMS.register(eventBus);
    eventBus.addListener(this::setup);
    ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + ".toml"));

    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
      eventBus.addListener(ClientOreRegistry::setup);
    });
  }

  private void setup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      WorldGenRegistry.init();
    });
  }
}
