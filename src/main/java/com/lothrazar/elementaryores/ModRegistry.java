package com.lothrazar.elementaryores;

import com.lothrazar.library.item.BlockItemFlib;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModElemOres.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModElemOres.MODID);
  public static final CreativeModeTab TAB = new CreativeModeTab(ModElemOres.MODID) {

    @Override
    public ItemStack makeIcon() {
      return new ItemStack(ModRegistry.EMERALD_NETHER.get());
    }
  };
  //a randomizer? 
  // GUNPOWDER  // GLOWSTONE DUST // GHAST TEAR // BLAZE POWDER
  public static final RegistryObject<Block> COAL_NETHER = BLOCKS.register("ore_coal_nether", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.COAL_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> COPPER_NETHER = BLOCKS.register("ore_copper_nether", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.COPPER_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> IRON_NETHER = BLOCKS.register("ore_iron_nether", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.IRON_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> EMERALD_NETHER = BLOCKS.register("ore_emerald_nether", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> LAPIS_NETHER = BLOCKS.register("ore_lapis_nether", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> DIAMOND_NETHER = BLOCKS.register("ore_diamond_nether", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> REDSTONE_NETHER = BLOCKS.register("ore_redstone_nether", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.REDSTONE_ORE.defaultBlockState().destroySpeed)));
  //
  public static final RegistryObject<Block> COAL_END = BLOCKS.register("ore_coal_end", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.COAL_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> COPPER_END = BLOCKS.register("ore_copper_end", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.COPPER_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> REDSTONE_END = BLOCKS.register("ore_redstone_end", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.REDSTONE_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> EMERALD_END = BLOCKS.register("ore_emerald_end", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> LAPIS_END = BLOCKS.register("ore_lapis_end", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> DIAMOND_END = BLOCKS.register("ore_diamond_end", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> IRON_END = BLOCKS.register("ore_iron_end", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.IRON_ORE.defaultBlockState().destroySpeed)));
  //
  public static final RegistryObject<Block> ENDER_END = BLOCKS.register("ore_ender_end", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> GHAST_NETHER = BLOCKS.register("ore_ghast_nether", () -> new BlockElemOre(Block.Properties.of(Material.STONE).strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  //ore_nether_ghast
  static {
    ITEMS.register("ore_coal_nether", () -> new BlockItemFlib(COAL_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_copper_nether", () -> new BlockItemFlib(COPPER_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_iron_nether", () -> new BlockItemFlib(IRON_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_emerald_nether", () -> new BlockItemFlib(EMERALD_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_lapis_nether", () -> new BlockItemFlib(LAPIS_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_diamond_nether", () -> new BlockItemFlib(DIAMOND_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_redstone_nether", () -> new BlockItemFlib(REDSTONE_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    //
    ITEMS.register("ore_coal_end", () -> new BlockItemFlib(COAL_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_copper_end", () -> new BlockItemFlib(COPPER_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_redstone_end", () -> new BlockItemFlib(REDSTONE_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_emerald_end", () -> new BlockItemFlib(EMERALD_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_lapis_end", () -> new BlockItemFlib(LAPIS_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_diamond_end", () -> new BlockItemFlib(DIAMOND_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_iron_end", () -> new BlockItemFlib(IRON_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    //
    ITEMS.register("ore_ender_end", () -> new BlockItemFlib(ENDER_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_ghast_nether", () -> new BlockItemFlib(GHAST_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
  }
}
