package com.lothrazar.elementaryores;
 
import com.lothrazar.library.block.BlockFlib;
import com.lothrazar.library.item.BlockItemFlib;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryOres {

  private static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(ModOres.MODID, "tab"));
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModOres.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModOres.MODID);

  @SubscribeEvent
  public static void onCreativeModeTabRegister(RegisterEvent event) {
    event.register(Registries.CREATIVE_MODE_TAB, helper -> {
      helper.register(TAB, CreativeModeTab.builder().icon(() -> new ItemStack(EMERALD_NETHER.get().asItem()))
          .title(Component.translatable("itemGroup." + ModOres.MODID))
          .displayItems((enabledFlags, populator) -> {
            for (RegistryObject<Item> entry : ITEMS.getEntries()) {
              populator.accept(entry.get());
            }
          }).build());
    });
  }
   
  //a randomizer? 
  // GUNPOWDER  // GLOWSTONE DUST // GHAST TEAR // BLAZE POWDER
  public static final RegistryObject<Block> COAL_NETHER = BLOCKS.register("ore_coal_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.COAL_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> COPPER_NETHER = BLOCKS.register("ore_copper_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.COPPER_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> IRON_NETHER = BLOCKS.register("ore_iron_nether", () -> new Block(BlockFlib.Properties.of().strength(Blocks.IRON_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> EMERALD_NETHER = BLOCKS.register("ore_emerald_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> LAPIS_NETHER = BLOCKS.register("ore_lapis_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> DIAMOND_NETHER = BLOCKS.register("ore_diamond_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  //
  public static final RegistryObject<Block> COAL_END = BLOCKS.register("ore_coal_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.COAL_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> COPPER_END = BLOCKS.register("ore_copper_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.COPPER_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> REDSTONE_END = BLOCKS.register("ore_redstone_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.REDSTONE_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> EMERALD_END = BLOCKS.register("ore_emerald_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> LAPIS_END = BLOCKS.register("ore_lapis_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> DIAMOND_END = BLOCKS.register("ore_diamond_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  //
  public static final RegistryObject<Block> ENDER_END = BLOCKS.register("ore_ender_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> GHAST_NETHER = BLOCKS.register("ore_ghast_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  //ore_nether_ghast
  static {
    ITEMS.register("ore_coal_nether", () -> new BlockItemFlib(COAL_NETHER.get(), new Item.Properties()));
    ITEMS.register("ore_copper_nether", () -> new BlockItemFlib(COPPER_NETHER.get(), new Item.Properties()));
    ITEMS.register("ore_iron_nether", () -> new BlockItemFlib(IRON_NETHER.get(), new Item.Properties()));
    ITEMS.register("ore_emerald_nether", () -> new BlockItemFlib(EMERALD_NETHER.get(), new Item.Properties()));
    ITEMS.register("ore_lapis_nether", () -> new BlockItemFlib(LAPIS_NETHER.get(), new Item.Properties()));
    ITEMS.register("ore_diamond_nether", () -> new BlockItemFlib(DIAMOND_NETHER.get(), new Item.Properties()));
    //
    ITEMS.register("ore_coal_end", () -> new BlockItemFlib(COAL_END.get(), new Item.Properties()));
    ITEMS.register("ore_copper_end", () -> new BlockItemFlib(COPPER_END.get(), new Item.Properties()));
    ITEMS.register("ore_redstone_end", () -> new BlockItemFlib(REDSTONE_END.get(), new Item.Properties()));
    ITEMS.register("ore_emerald_end", () -> new BlockItemFlib(EMERALD_END.get(), new Item.Properties()));
    ITEMS.register("ore_lapis_end", () -> new BlockItemFlib(LAPIS_END.get(), new Item.Properties()));
    ITEMS.register("ore_diamond_end", () -> new BlockItemFlib(DIAMOND_END.get(), new Item.Properties()));
    //
    ITEMS.register("ore_ender_end", () -> new BlockItemFlib(ENDER_END.get(), new Item.Properties()));
    ITEMS.register("ore_ghast_nether", () -> new BlockItemFlib(GHAST_NETHER.get(), new Item.Properties()));
  }
}
