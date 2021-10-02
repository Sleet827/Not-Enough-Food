package net.legiblesleet827.nef.entity.turkey;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TurkeyRenderer extends GeoEntityRenderer<Turkey> {
    public TurkeyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TurkeyModel());
        this.shadowRadius = 0.5f;
    }
}