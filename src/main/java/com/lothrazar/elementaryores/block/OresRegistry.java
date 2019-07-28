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

  private static final List<Block> blocks = new ArrayList<>();

  public static List<Block> getBlocks() {
    return blocks;
  }

  @ObjectHolder(ModElemOres.MODID + ":ore_gold_nether")
  public static Block oreGoldNeth;

  @ObjectHolder(ModElemOres.MODID + ":ore_lapis_nether")
  public static Block oreLapisNether;
  @ObjectHolder(ModElemOres.MODID + ":ore_redstone_end")
  public static Block oreRedstoneEnd;
  public static ItemGroup itemGroup = new ItemGroup(ModElemOres.MODID) {

    @Override
    public ItemStack createIcon() {
      return new ItemStack(Blocks.GOLD_ORE);
    }
  };


  public static Block addBlock(Block b){
    blocks.add(b);
    return b;
  }



}
