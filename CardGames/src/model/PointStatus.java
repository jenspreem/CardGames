package model;

public class PointStatus {
	public final boolean bust;
	public final int points;
	PointStatus(boolean b,int i){
		this.bust=b;
		this.points=i;
	}
	PointStatus(int i){
		this.bust=false;
		this.points=i;
	}
	

}
