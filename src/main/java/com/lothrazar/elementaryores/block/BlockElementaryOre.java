package com.lothrazar.elementaryores.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ForgeConfigSpec;

public class BlockElementaryOre extends Block {

  private ForgeConfigSpec.IntValue minSpawnY;
  private ForgeConfigSpec.IntValue maxSpawnY;
  private ForgeConfigSpec.IntValue veinSize;

  public BlockElementaryOre(Properties properties) {
    super(properties);
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    //whole mod broke, cutout is gone
    return BlockRenderType.MODEL;
  }

  public int getMinSpawnY() {
    return minSpawnY.get();
  }

  public void setMinSpawnY(ForgeConfigSpec.IntValue value) {
    this.minSpawnY = value;
  }

  public int getMaxSpawnY() {
    return maxSpawnY.get();
  }

  public void setMaxSpawnY(ForgeConfigSpec.IntValue maxSpawnY) {
    this.maxSpawnY = maxSpawnY;
  }

  public int getVeinSize() {
    return veinSize.get();
  }

  public void setVeinSize(ForgeConfigSpec.IntValue veinSize) {
    this.veinSize = veinSize;
  }
}
