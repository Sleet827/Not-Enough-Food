package net.legiblesleet827.nef.entity.turkey;

/*import com.google.common.collect.ImmutableList;
import net.legiblesleet827.nef.NotEnoughFood;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TurkeyModel extends AgeableListModel<Turkey> {
	private final ModelPart turkey;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart wings;
	private final ModelPart left_wing;
	private final ModelPart right_wing;
	private final ModelPart legs;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart tail;

	public static final ModelLayerLocation TURKEY_LAYER = new ModelLayerLocation(new ResourceLocation(NotEnoughFood.MODID, "turkey"), "main");

	public TurkeyModel(ModelPart model) {
		this.turkey = model;
		this.body = model.getChild("body");
		this.head = model.getChild("head");
		this.wings = model.getChild("wings");
		this.left_wing = this.wings.getChild("left_wing");
		this.right_wing = this.wings.getChild("right_wing");
		this.legs = model.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.right_leg = this.legs.getChild("right_leg");
		this.tail = model.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("turkey", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.0f, 22.0f, -2.0f, 0.0f, 0.0f, 0.0f));

		partDefinition.addOrReplaceChild("body", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-5.0f, -8.0f, -2.0f, 7.0f, 6.0f, 7.0f),
				PartPose.offsetAndRotation(0.0f, 22.0f, 0.0f, 0.0f, 0.0f, 0.0f));

		partDefinition.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(0, 13).addBox(-3.5f, -11.0f, -6.0f, 4.0f, 4.0f, 4.0f)
						.texOffs(24, 13).addBox(-2.5f, -9.0f, -7.0f, 2.0f, 2.0f, 1.0f)
						.texOffs(24, 16).addBox(-2.0f, -7.0f, -4.0f, 1.0f, 4.0f, 1.0f)
						.texOffs(0, 13).addBox(-2.0f, -4.0f, -3.0f, 1.0f, 1.0f, 1.0f),
				PartPose.offsetAndRotation(0.0f, 22.0f, 0.0f, 0.0f, 0.0f, 0.0f));

		PartDefinition partDefinition3 = partDefinition.addOrReplaceChild("wings", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0f, 22.0f, 0.0f, 0.0f, 0.0f, 0.0f));

		partDefinition3.addOrReplaceChild("left_wing", CubeListBuilder.create()
						.texOffs(8, 17).addBox(0.5f, -2.0f, -1.5f, 0.0f, 4.0f, 4.0f),
				PartPose.offsetAndRotation(-6.0f, -5.0f, 1.0f, 0.0f, 0.0f, 0.2618f));

		partDefinition3.addOrReplaceChild("right_wing", CubeListBuilder.create()
						.texOffs(0, 17).addBox(-0.2f, -2.0f, -2.5f, 0.0f, 4.0f, 4.0f),
				PartPose.offsetAndRotation(2.7f, -5.0f, 2.0f, 0.0f, 0.0f, -0.2618f));

		PartDefinition partDefinition6 = partDefinition.addOrReplaceChild("legs", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-1.0f, 22.0f, 2.0f, 0.0f, 0.0f, 0.0f));

		partDefinition6.addOrReplaceChild("left_leg", CubeListBuilder.create()
						.texOffs(0, 25).addBox(-2.0f, -2.0f, -1.0f, 1.0f, 4.0f, 1.0f)
						.texOffs(2, 0).addBox(-2.0f, 2.0f, -2.0f, 1.0f, 0.0f, 1.0f),
				PartPose.offsetAndRotation(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

		partDefinition6.addOrReplaceChild("right_leg", CubeListBuilder.create()
						.texOffs(24, 21).addBox(0.0f, -2.0f, -1.0f, 1.0f, 4.0f, 1.0f)
						.texOffs(3, 1).addBox(0.0f, 2.0f, -2.0f, 1.0f, 0.0f, 1.0f),
				PartPose.offsetAndRotation(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));

		partDefinition.addOrReplaceChild("tail", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-5.0f, -9.0f, 0.5f, 1.0f, 6.0f, 1.0f)
						.texOffs(20, 22).addBox(-6.0f, -10.0f, 0.5f, 1.0f, 7.0f, 1.0f)
						.texOffs(16, 13).addBox(-9.0f, -11.0f, 0.5f, 3.0f, 8.0f, 1.0f)
						.texOffs(16, 22).addBox(-10.0f, -10.0f, 0.5f, 1.0f, 7.0f, 1.0f)
						.texOffs(21, 0).addBox(-11.0f, -9.0f, 0.5f, 1.0f, 6.0f, 1.0f),
				PartPose.offsetAndRotation(6.0f, 21.0f, 4.0f, -0.1309f, 0.0f, 0.0f));

		return LayerDefinition.create(meshDefinition, 32, 32);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.turkey);
	}

	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of();
	}

	@Override
	public void setupAnim(Turkey entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Use this method to setup the animation and rotation angles
	}
}*/

import net.legiblesleet827.nef.NotEnoughFood;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import javax.annotation.Nullable;

public class TurkeyModel extends AnimatedGeoModel<Turkey> {
	@Override
	public ResourceLocation getModelLocation(Turkey object) {
		return new ResourceLocation(NotEnoughFood.MODID, "geo/entity/turkey.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(Turkey object) {
		return new ResourceLocation(NotEnoughFood.MODID, "textures/entity/turkey.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(Turkey animatable) {
		return new ResourceLocation(NotEnoughFood.MODID, "animations/entity/turkey.animation.json");
	}

	@Override
	public void setLivingAnimations(Turkey entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
		if (entity.getAge() == -24000) {
			this.getAnimationProcessor().getBone("turkey").setScaleX((float) 0.25);
			this.getAnimationProcessor().getBone("turkey").setScaleY((float) 0.25);
			this.getAnimationProcessor().getBone("turkey").setScaleZ((float) 0.25);
		}
	}
}