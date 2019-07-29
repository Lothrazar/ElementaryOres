package com.lothrazar.elementaryores.block;
import com.lothrazar.elementaryores.ModElemOres;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;

public class OresRegistry {
  public static ItemGroup itemGroup = new ItemGroup(ModElemOres.MODID) {

    @Override
    public ItemStack createIcon() {
      return new ItemStack(Blocks.GOLD_ORE);
    }
  };

  private static final List<Block> blocks = new ArrayList<>();

  public static List<Block> getBlocks() {
    return blocks;
  }

  @ObjectHolder(ModElemOres.MODID + ":ore_gold_nether")
  public static BlockElementaryOre GOLD_NETHER;
  @ObjectHolder(ModElemOres.MODID + ":ore_lapis_nether")
  public static BlockElementaryOre LAPIS_NETHER;
  @ObjectHolder(ModElemOres.MODID + ":ore_redstone_end")
  public static BlockElementaryOre REDSTONE_END;
  @ObjectHolder(ModElemOres.MODID + ":ore_diamond_nether")
  public static BlockElementaryOre DIAMOND_NETHER;
  @ObjectHolder(ModElemOres.MODID + ":ore_emerald_end")
  public static BlockElementaryOre EMERALD_END;

  public static Block addBlock(Block b) {
    blocks.add(b);
    return b;
  }
}
