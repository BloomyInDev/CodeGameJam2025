package fr.bloomyindev.cgj2024.CoordinateSystems;

public class FieldOfView {
	private float fovAngleX, fovAngleY;
	private float latCenter, lngCenter;

	private float[] TopLeftCorner, TopRightCorner, BottomLeftCorner, BottomRightCorner;

	/*
	 * Les angles sont à fournir en radians
	 */
	public FieldOfView(float centerLat, float centerLng, float fovAngleX) {
		this.fovAngleX = fovAngleX;
		this.fovAngleY = fovAngleX / (16.f / 9.f);

		this.latCenter = centerLat;
		this.lngCenter = centerLng;

		this.TopLeftCorner = new float[]{centerLng - this.fovAngleX, centerLat + this.fovAngleY};
		this.TopRightCorner = new float[]{centerLng + this.fovAngleX, centerLat + this.fovAngleY};
		this.BottomLeftCorner = new float[]{centerLng - this.fovAngleX, centerLat - this.fovAngleY};
		this.BottomRightCorner = new float[]{centerLng + this.fovAngleX, centerLat - this.fovAngleY};
	}
}
