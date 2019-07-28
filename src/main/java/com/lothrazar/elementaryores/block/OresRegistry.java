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
  public static BlockElementaryOre oreGoldNeth;
  @ObjectHolder(ModElemOres.MODID + ":ore_lapis_nether")
  public static BlockElementaryOre oreLapisNether;
  @ObjectHolder(ModElemOres.MODID + ":ore_redstone_end")
  public static BlockElementaryOre oreRedstoneEnd;

  public static Block addBlock(Block b) {
    blocks.add(b);
    return b;
  }
}
