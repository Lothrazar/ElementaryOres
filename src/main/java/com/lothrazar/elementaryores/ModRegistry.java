package com.lothrazar.elementaryores;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
  public static final RegistryObject<Block> IRON_NETHER = BLOCKS.register("ore_iron_nether", () -> new Block(Block.Properties.of(Material.STONE).strength(Blocks.IRON_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> EMERALD_NETHER = BLOCKS.register("ore_emerald_nether", () -> new Block(Block.Properties.of(Material.STONE).strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> LAPIS_NETHER = BLOCKS.register("ore_lapis_nether", () -> new Block(Block.Properties.of(Material.STONE).strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> DIAMOND_NETHER = BLOCKS.register("ore_diamond_nether", () -> new Block(Block.Properties.of(Material.STONE).strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> EMERALD_END = BLOCKS.register("ore_emerald_end", () -> new Block(Block.Properties.of(Material.STONE).strength(Blocks.EMERALD_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> DIAMOND_END = BLOCKS.register("ore_diamond_end", () -> new Block(Block.Properties.of(Material.STONE).strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> LAPIS_END = BLOCKS.register("ore_lapis_end", () -> new Block(Block.Properties.of(Material.STONE).strength(Blocks.LAPIS_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> REDSTONE_END = BLOCKS.register("ore_redstone_end", () -> new Block(Block.Properties.of(Material.STONE).strength(Blocks.REDSTONE_ORE.defaultBlockState().destroySpeed)));
  public static final RegistryObject<Block> ENDER_END = BLOCKS.register("ore_ender_end", () -> new Block(Block.Properties.of(Material.STONE).strength(Blocks.DIAMOND_ORE.defaultBlockState().destroySpeed)));
  static {
    ITEMS.register("ore_iron_nether", () -> new BlockItem(IRON_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_emerald_nether", () -> new BlockItem(EMERALD_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_diamond_nether", () -> new BlockItem(DIAMOND_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_lapis_nether", () -> new BlockItem(LAPIS_NETHER.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_emerald_end", () -> new BlockItem(EMERALD_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_diamond_end", () -> new BlockItem(DIAMOND_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_lapis_end", () -> new BlockItem(LAPIS_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_redstone_end", () -> new BlockItem(REDSTONE_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
    ITEMS.register("ore_ender_end", () -> new BlockItem(ENDER_END.get(), new Item.Properties().tab(ModRegistry.TAB)));
  }
}
