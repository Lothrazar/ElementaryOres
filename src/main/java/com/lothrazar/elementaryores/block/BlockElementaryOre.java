package com.lothrazar.elementaryores.block;
import net.minecraft.block.Block;
import net.minecraft.util.BlockRenderLayer;

public class BlockElementaryOre extends Block {

  int minSpawnY = 8;
  int maxSpawnY = 256;

  int veinSize = 0;

  public BlockElementaryOre(Properties properties) {
    super(properties);
  }

  public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
  }

  public int getMinSpawnY() {
    return minSpawnY;
  }

  public void setMinSpawnY(int minSpawnY) {
    this.minSpawnY = minSpawnY;
  }

  public int getMaxSpawnY() {
    return maxSpawnY;
  }

  public void setMaxSpawnY(int maxSpawnY) {
    this.maxSpawnY = maxSpawnY;
  }

  public int getVeinSize() {
    return veinSize;
  }

  public void setVeinSize(int veinSize) {
    this.veinSize = veinSize;
  }






}
