package com.lothrazar.elementaryores.client;

import com.lothrazar.elementaryores.ModOres;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EmissiveOreBakedModel implements BlockStateModel {

  // Max per-quad light emission (BakedQuad.MaterialInfo#lightEmission is 0-15, not a packed lightmap value anymore)
  private static final int FULL_BRIGHT = 15;

  private final BlockStateModel wrapped;

  public EmissiveOreBakedModel(BlockStateModel wrapped) {
    this.wrapped = wrapped;
  }

  @Override
  public void collectParts(RandomSource random, List<BlockStateModelPart> output) {
    List<BlockStateModelPart> wrappedParts = new ArrayList<>();
    wrapped.collectParts(random, wrappedParts);
    for (BlockStateModelPart part : wrappedParts) {
      output.add(new EmissivePart(part));
    }
  }

  @Override
  public Material.Baked particleMaterial() {
    return wrapped.particleMaterial();
  }

  @Override
  public int materialFlags() {
    return wrapped.materialFlags();
  }

  private static class EmissivePart implements BlockStateModelPart {

    private final BlockStateModelPart wrapped;

    EmissivePart(BlockStateModelPart wrapped) {
      this.wrapped = wrapped;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable Direction direction) {
      List<BakedQuad> quads = wrapped.getQuads(direction);
      if (!ClientConfigOres.ENABLE_EMMISSIVE_TEXTURES.get()) {
        return quads;
      }
      List<BakedQuad> result = new ArrayList<>(quads.size());
      for (BakedQuad quad : quads) {
        result.add(isOverlayQuad(quad) ? makeEmissive(quad) : quad);
      }
      return result;
    }

    @Override
    public boolean useAmbientOcclusion() {
      return wrapped.useAmbientOcclusion();
    }

    @Override
    public Material.Baked particleMaterial() {
      return wrapped.particleMaterial();
    }

    @Override
    public int materialFlags() {
      return wrapped.materialFlags();
    }
  }

  // Overlay quads use textures from this mod's namespace; base quads (netherrack, end_stone) are in "minecraft"
  private static boolean isOverlayQuad(BakedQuad quad) {
    return ModOres.MODID.equals(quad.materialInfo().sprite().contents().name().getNamespace());
  }

  private static BakedQuad makeEmissive(BakedQuad quad) {
    BakedQuad.MaterialInfo mi = quad.materialInfo();
    BakedQuad.MaterialInfo emissiveMi = new BakedQuad.MaterialInfo(
        mi.sprite(), mi.layer(), mi.itemRenderType(), mi.tintIndex(), mi.shade(), FULL_BRIGHT, mi.ambientOcclusion());
    return new BakedQuad(quad.position0(), quad.position1(), quad.position2(), quad.position3(),
        quad.packedUV0(), quad.packedUV1(), quad.packedUV2(), quad.packedUV3(),
        quad.direction(), emissiveMi, quad.bakedNormals(), quad.bakedColors());
  }
}
