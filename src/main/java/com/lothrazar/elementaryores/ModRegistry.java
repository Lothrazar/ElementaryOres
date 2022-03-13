package com.lothrazar.elementaryores;

import com.lothrazar.elementaryores.block.BlockElementaryOre;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModElemOres.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModElemOres.MODID);
  public static final ItemGroup TAB = new ItemGroup(ModElemOres.MODID) {

    @Override
    public ItemStack createIcon() {
      return new ItemStack(ModRegistry.EMERALD_NETHER.get());
    }
  };
  public static final RegistryObject<Block> IRON_NETHER = BLOCKS.register("ore_iron_nether", () -> new BlockElementaryOre(Blocks.IRON_ORE));
  public static final RegistryObject<Block> EMERALD_NETHER = BLOCKS.register("ore_emerald_nether", () -> new BlockElementaryOre(Blocks.EMERALD_ORE));
  public static final RegistryObject<Block> LAPIS_NETHER = BLOCKS.register("ore_lapis_nether", () -> new BlockElementaryOre(Blocks.LAPIS_ORE));
  public static final RegistryObject<Block> DIAMOND_NETHER = BLOCKS.register("ore_diamond_nether", () -> new BlockElementaryOre(Blocks.DIAMOND_ORE));
  public static final RegistryObject<Block> EMERALD_END = BLOCKS.register("ore_emerald_end", () -> new BlockElementaryOre(Blocks.EMERALD_ORE));
  public static final RegistryObject<Block> DIAMOND_END = BLOCKS.register("ore_diamond_end", () -> new BlockElementaryOre(Blocks.DIAMOND_ORE));
  public static final RegistryObject<Block> LAPIS_END = BLOCKS.register("ore_lapis_end", () -> new BlockElementaryOre(Blocks.LAPIS_ORE));
  public static final RegistryObject<Block> REDSTONE_END = BLOCKS.register("ore_redstone_end", () -> new BlockElementaryOre(Blocks.REDSTONE_ORE));
  public static final RegistryObject<Block> ENDER_END = BLOCKS.register("ore_ender_end", () -> new BlockElementaryOre(Blocks.DIAMOND_ORE));
  static {
    ITEMS.register("ore_iron_nether", () -> new BlockItem(IRON_NETHER.get(), new Item.Properties().group(ModRegistry.TAB)));
    ITEMS.register("ore_emerald_nether", () -> new BlockItem(EMERALD_NETHER.get(), new Item.Properties().group(ModRegistry.TAB)));
    ITEMS.register("ore_diamond_nether", () -> new BlockItem(DIAMOND_NETHER.get(), new Item.Properties().group(ModRegistry.TAB)));
    ITEMS.register("ore_lapis_nether", () -> new BlockItem(LAPIS_NETHER.get(), new Item.Properties().group(ModRegistry.TAB)));
    ITEMS.register("ore_emerald_end", () -> new BlockItem(EMERALD_END.get(), new Item.Properties().group(ModRegistry.TAB)));
    ITEMS.register("ore_diamond_end", () -> new BlockItem(DIAMOND_END.get(), new Item.Properties().group(ModRegistry.TAB)));
    ITEMS.register("ore_lapis_end", () -> new BlockItem(LAPIS_END.get(), new Item.Properties().group(ModRegistry.TAB)));
    ITEMS.register("ore_redstone_end", () -> new BlockItem(REDSTONE_END.get(), new Item.Properties().group(ModRegistry.TAB)));
    ITEMS.register("ore_ender_end", () -> new BlockItem(ENDER_END.get(), new Item.Properties().group(ModRegistry.TAB)));
  }
}
