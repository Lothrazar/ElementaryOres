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
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ModOres.MODID);
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ModOres.MODID);

  //a randomizer?
  // GUNPOWDER  // GLOWSTONE DUST // GHAST TEAR // BLAZE POWDER
  public static final DeferredHolder<Block, Block> COAL_NETHER = BLOCKS.registerBlock("ore_coal_nether", props -> new BlockFlib(props.strength(Blocks.COAL_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> COPPER_NETHER = BLOCKS.registerBlock("ore_copper_nether", props -> new BlockFlib(props.strength(Blocks.COPPER_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> IRON_NETHER = BLOCKS.registerBlock("ore_iron_nether", props -> new Block(props.strength(Blocks.IRON_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> EMERALD_NETHER = BLOCKS.registerBlock("ore_emerald_nether", props -> new BlockFlib(props.strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> LAPIS_NETHER = BLOCKS.registerBlock("ore_lapis_nether", props -> new BlockFlib(props.strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> DIAMOND_NETHER = BLOCKS.registerBlock("ore_diamond_nether", props -> new BlockFlib(props.strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  //
  public static final DeferredHolder<Block, Block> COAL_END = BLOCKS.registerBlock("ore_coal_end", props -> new BlockFlib(props.strength(Blocks.COAL_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> COPPER_END = BLOCKS.registerBlock("ore_copper_end", props -> new BlockFlib(props.strength(Blocks.COPPER_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> REDSTONE_END = BLOCKS.registerBlock("ore_redstone_end", props -> new BlockFlib(props.strength(Blocks.REDSTONE_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> EMERALD_END = BLOCKS.registerBlock("ore_emerald_end", props -> new BlockFlib(props.strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> LAPIS_END = BLOCKS.registerBlock("ore_lapis_end", props -> new BlockFlib(props.strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> DIAMOND_END = BLOCKS.registerBlock("ore_diamond_end", props -> new BlockFlib(props.strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  //
  public static final DeferredHolder<Block, Block> ENDER_END = BLOCKS.registerBlock("ore_ender_end", props -> new BlockFlib(props.strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  public static final DeferredHolder<Block, Block> GHAST_NETHER = BLOCKS.registerBlock("ore_ghast_nether", props -> new BlockFlib(props.strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));

  static {
    ITEMS.registerItem("ore_coal_nether", props -> new BlockItemFlib(COAL_NETHER.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_copper_nether", props -> new BlockItemFlib(COPPER_NETHER.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_iron_nether", props -> new BlockItemFlib(IRON_NETHER.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_emerald_nether", props -> new BlockItemFlib(EMERALD_NETHER.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_lapis_nether", props -> new BlockItemFlib(LAPIS_NETHER.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_diamond_nether", props -> new BlockItemFlib(DIAMOND_NETHER.get(), props.useBlockDescriptionPrefix()));
    //
    ITEMS.registerItem("ore_coal_end", props -> new BlockItemFlib(COAL_END.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_copper_end", props -> new BlockItemFlib(COPPER_END.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_redstone_end", props -> new BlockItemFlib(REDSTONE_END.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_emerald_end", props -> new BlockItemFlib(EMERALD_END.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_lapis_end", props -> new BlockItemFlib(LAPIS_END.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_diamond_end", props -> new BlockItemFlib(DIAMOND_END.get(), props.useBlockDescriptionPrefix()));
    //
    ITEMS.registerItem("ore_ender_end", props -> new BlockItemFlib(ENDER_END.get(), props.useBlockDescriptionPrefix()));
    ITEMS.registerItem("ore_ghast_nether", props -> new BlockItemFlib(GHAST_NETHER.get(), props.useBlockDescriptionPrefix()));
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
