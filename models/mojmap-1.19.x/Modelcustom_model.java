// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcustom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bb_main;

	public Modelcustom_model(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone2 = root.getChild("bone2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(34, 65)
						.addBox(-8.0F, -22.0F, -8.0F, 16.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(34, 50)
						.addBox(-8.0F, -12.0F, -8.0F, 16.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.0F, -29.0F, -8.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 9)
						.addBox(-3.0F, -28.0F, -6.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(48, 17).addBox(-8.5F, -5.0F, -3.0F, 18.0F, 14.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -32.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(72, 66)
						.addBox(-6.0F, -15.0F, -5.0F, 12.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(72, 50)
						.addBox(-6.0F, -12.0F, -5.0F, 12.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(45, 36)
						.addBox(-8.0F, -1.0F, -5.0F, 16.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 34)
						.addBox(-8.0F, -17.0F, -5.0F, 16.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(-24.0F, -12.0F, -8.0F, 2.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(0, 17)
						.addBox(-24.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-24.0F, -13.0F, -8.0F, 32.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(67, 73)
						.addBox(-4.0F, -15.0F, 0.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 75)
						.addBox(-5.0F, -22.0F, -5.0F, 10.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, -18.0F, -3.0F, 10.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}