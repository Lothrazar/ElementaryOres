package com.lothrazar.elementaryores;

import com.lothrazar.library.block.BlockFlib;
import com.lothrazar.library.item.BlockItemFlib;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegistryOres {

//  private static final ResourceKey<CreativeModeTab> TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(ModOres.MODID, "tab"));
  public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModOres.MODID);
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ModOres.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, ModOres.MODID);

  //a randomizer?
  // GUNPOWDER  // GLOWSTONE DUST // GHAST TEAR // BLAZE POWDER
  public static final DeferredHolder<Block, Block> COAL_NETHER = BLOCKS.register("ore_coal_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.COAL_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> COPPER_NETHER = BLOCKS.register("ore_copper_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.COPPER_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> IRON_NETHER = BLOCKS.register("ore_iron_nether", () -> new Block(BlockFlib.Properties.of().strength(Blocks.IRON_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> EMERALD_NETHER = BLOCKS.register("ore_emerald_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> LAPIS_NETHER = BLOCKS.register("ore_lapis_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> DIAMOND_NETHER = BLOCKS.register("ore_diamond_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  //
  public static final DeferredHolder<Block, Block> COAL_END = BLOCKS.register("ore_coal_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.COAL_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> COPPER_END = BLOCKS.register("ore_copper_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.COPPER_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> REDSTONE_END = BLOCKS.register("ore_redstone_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.REDSTONE_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> EMERALD_END = BLOCKS.register("ore_emerald_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> LAPIS_END = BLOCKS.register("ore_lapis_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> DIAMOND_END = BLOCKS.register("ore_diamond_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  //
  public static final DeferredHolder<Block, Block> ENDER_END = BLOCKS.register("ore_ender_end", () -> new BlockFlib(Block.Properties.of().strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> GHAST_NETHER = BLOCKS.register("ore_ghast_nether", () -> new BlockFlib(Block.Properties.of().strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));

  static {
    ITEMS.register("ore_coal_nether", () -> new BlockItemFlib(COAL_NETHER.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_copper_nether", () -> new BlockItemFlib(COPPER_NETHER.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_iron_nether", () -> new BlockItemFlib(IRON_NETHER.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_emerald_nether", () -> new BlockItemFlib(EMERALD_NETHER.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_lapis_nether", () -> new BlockItemFlib(LAPIS_NETHER.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_diamond_nether", () -> new BlockItemFlib(DIAMOND_NETHER.get(), new Item.Properties().useBlockDescriptionPrefix()));
    //
    ITEMS.register("ore_coal_end", () -> new BlockItemFlib(COAL_END.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_copper_end", () -> new BlockItemFlib(COPPER_END.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_redstone_end", () -> new BlockItemFlib(REDSTONE_END.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_emerald_end", () -> new BlockItemFlib(EMERALD_END.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_lapis_end", () -> new BlockItemFlib(LAPIS_END.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_diamond_end", () -> new BlockItemFlib(DIAMOND_END.get(), new Item.Properties().useBlockDescriptionPrefix()));
    //
    ITEMS.register("ore_ender_end", () -> new BlockItemFlib(ENDER_END.get(), new Item.Properties().useBlockDescriptionPrefix()));
    ITEMS.register("ore_ghast_nether", () -> new BlockItemFlib(GHAST_NETHER.get(), new Item.Properties().useBlockDescriptionPrefix()));
  }

  static {
    TABS.register("tab", () -> CreativeModeTab.builder()
        .icon(() -> new ItemStack(EMERALD_NETHER.get().asItem()))
        .title(Component.translatable("itemGroup." + ModOres.MODID))
        .displayItems((enabledFlags, populator) -> {
          for (DeferredHolder<Item, ? extends Item> entry : ITEMS.getEntries()) {
            populator.accept(entry.get());
          }
        }).build());
  }
}
