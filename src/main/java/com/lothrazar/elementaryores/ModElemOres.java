package com.lothrazar.elementaryores;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lothrazar.elementaryores.block.BlockElementaryOre;
import com.lothrazar.elementaryores.block.OresRegistry;
import com.lothrazar.elementaryores.setup.ClientProxy;
import com.lothrazar.elementaryores.setup.ConfigHandler;
import com.lothrazar.elementaryores.setup.IProxy;
import com.lothrazar.elementaryores.setup.ServerProxy;
import com.lothrazar.elementaryores.world.WorldGenRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("elementaryores")
public class ModElemOres {

  private String certificateFingerprint = "@FINGERPRINT@";
  public static final IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
  public static final String MODID = "elementaryores";
  private static final Logger LOGGER = LogManager.getLogger();

  public ModElemOres() {
    // Register the setup method for modloading
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    //only for server starting
    MinecraftForge.EVENT_BUS.register(this);
    ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + ".toml"));
  }

  private void setup(final FMLCommonSetupEvent event) {
    WorldGenRegistry.init();
  }

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(FMLServerStartingEvent event) {}

  // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
  // Event bus for receiving Registry Events)
  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
      // register a new block here
      event.getRegistry().register(
          OresRegistry.addBlock(new BlockElementaryOre(Block.Properties.create(Material.ROCK, MaterialColor.GOLD)
              .hardnessAndResistance(2.6F)).setRegistryName("ore_gold_nether")));
      event.getRegistry().register(
          OresRegistry.addBlock(new BlockElementaryOre(Block.Properties.create(Material.ROCK, MaterialColor.LAPIS)
              .hardnessAndResistance(2.6F)).setRegistryName("ore_lapis_nether")));
      event.getRegistry().register(
          OresRegistry.addBlock(new BlockElementaryOre(Block.Properties.create(Material.ROCK, MaterialColor.RED)
              .hardnessAndResistance(2.6F)).setRegistryName("ore_redstone_end")));
      event.getRegistry().register(
          OresRegistry.addBlock(new BlockElementaryOre(Block.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
              .hardnessAndResistance(2.6F)).setRegistryName("ore_diamond_nether")));
      event.getRegistry().register(
          OresRegistry.addBlock(new BlockElementaryOre(Block.Properties.create(Material.ROCK, MaterialColor.EMERALD)
              .hardnessAndResistance(2.6F)).setRegistryName("ore_emerald_end")));
      event.getRegistry().register(
          OresRegistry.addBlock(new BlockElementaryOre(Block.Properties.create(Material.ROCK, MaterialColor.EMERALD)
              .hardnessAndResistance(2.6F)).setRegistryName("ore_ender_end")));
    }

    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event) {
      Item.Properties properties = new Item.Properties().group(OresRegistry.itemGroup);
      List<Block> blocks = OresRegistry.getBlocks();
      for (Block b : blocks) {
        event.getRegistry().register(new BlockItem(b, properties)
            .setRegistryName(b.getRegistryName()));
      }
    }
  }

  @SubscribeEvent
  public static void onFingerprintViolation(FMLFingerprintViolationEvent event) {
    // https://tutorials.darkhax.net/tutorials/jar_signing/
    String source = (event.getSource() == null) ? "" : event.getSource().getName() + " ";
    String msg = MODID + "Invalid fingerprint detected! The file " + source + "may have been tampered with. This version will NOT be supported by the author!";
    System.out.println(msg);
  }
}
