package net.legiblesleet827.morefood.entity.turkey;

import net.legiblesleet827.morefood.MoreFood;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class TurkeyRenderer extends MobRenderer<Turkey, TurkeyModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MoreFood.MODID, "textures/entity/turkey.png");

    public TurkeyRenderer(EntityRendererProvider.Context context) {
        super(context, new TurkeyModel(context.getModelSet().bakeLayer(TurkeyModel.TURKEY_LAYER)), 0.3f);
    }

    @Nullable
    @Override
    public ResourceLocation getTextureLocation(Turkey entity) {
        return TEXTURE;
    }
}