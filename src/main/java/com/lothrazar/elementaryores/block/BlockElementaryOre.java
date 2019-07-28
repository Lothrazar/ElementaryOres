package com.lothrazar.elementaryores.block;
import net.minecraft.block.Block;
import net.minecraft.util.BlockRenderLayer;

public class BlockElementaryOre extends Block {

  public BlockElementaryOre(Properties properties) {
    super(properties);

  }



  public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
  }



}
