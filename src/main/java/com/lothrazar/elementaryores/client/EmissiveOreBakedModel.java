package com.lothrazar.elementaryores.client;

import com.lothrazar.elementaryores.ModOres;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.BakedModelWrapper;
import net.neoforged.neoforge.client.model.data.ModelData;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class EmissiveOreBakedModel extends BakedModelWrapper<net.minecraft.client.resources.model.BakedModel> {

  // Packed lightmap value for maximum block + sky light (full bright)
  private static final int FULL_BRIGHT = 0x00F000F0;

  public EmissiveOreBakedModel(net.minecraft.client.resources.model.BakedModel wrapped) {
    super(wrapped);
  }

  @Override
  public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side,
      RandomSource rand, ModelData data, @Nullable RenderType renderType) {
    List<BakedQuad> quads = super.getQuads(state, side, rand, data, renderType);
    if (!ClientConfigOres.ENABLE_EMMISSIVE_TEXTURES.get()) {
      return quads;
    }
    return quads.stream()
        .map(quad -> isOverlayQuad(quad) ? makeEmissive(quad) : quad)
        .toList();
  }

  // Overlay quads use textures from this mod's namespace; base quads (netherrack, end_stone) are in "minecraft"
  private static boolean isOverlayQuad(BakedQuad quad) {
    return ModOres.MODID.equals(quad.getSprite().contents().name().getNamespace());
  }

  private static BakedQuad makeEmissive(BakedQuad quad) {
    int[] vertices = Arrays.copyOf(quad.getVertices(), quad.getVertices().length);
    // DefaultVertexFormat.BLOCK: 8 ints per vertex, lightmap UV is at offset 6
    for (int i = 0; i < 4; i++) {
      vertices[i * 8 + 6] = FULL_BRIGHT;
    }
    return new BakedQuad(vertices, quad.getTintIndex(), quad.getDirection(), quad.getSprite(), quad.isShade());
  }
}
