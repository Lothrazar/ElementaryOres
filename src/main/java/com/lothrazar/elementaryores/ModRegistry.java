package com.lothrazar.elementaryores;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
  public static ItemGroup itemGroup = new ItemGroup(ModElemOres.MODID) {

    @Override
    public ItemStack createIcon() {
      return new ItemStack(ModRegistry.EMERALD_NETHERI.get());
    }
  };
  //
  public static final RegistryObject<Block> EMERALD_NETHER = BLOCKS.register("ore_emerald_nether", () -> new Block(Block.Properties.create(Material.ROCK)));
  public static final RegistryObject<Item> EMERALD_NETHERI = ITEMS.register("ore_emerald_nether", () -> new BlockItem(EMERALD_NETHER.get(), new Item.Properties().group(ModRegistry.itemGroup)));
  //  public static final RegistryObject<Block> EMERALD_END = BLOCKS.register("ore_emerald_end", () -> new Block(Block.Properties.create(Material.ROCK)));
  //  public static final RegistryObject<Item> EMERALD_ENDI = ITEMS.register("ore_emerald_end", () -> new BlockItem(EMERALD_END.get(), new Item.Properties().group(ModRegistry.itemGroup)));
}