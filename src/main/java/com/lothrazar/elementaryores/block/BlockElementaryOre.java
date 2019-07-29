package com.lothrazar.elementaryores.block;
import net.minecraft.block.Block;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.common.ForgeConfigSpec;

public class BlockElementaryOre extends Block {

  private ForgeConfigSpec.IntValue minSpawnY;
  private ForgeConfigSpec.IntValue maxSpawnY;
  private ForgeConfigSpec.IntValue veinSize;

  public BlockElementaryOre(Properties properties) {
    super(properties);
  }

  public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
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
