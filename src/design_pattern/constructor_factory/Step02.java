package design_pattern.constructor_factory;

public class Step02 {
	public static void main(String[] args) {
		Point2 newCartesianPoint = Point2.newCartesianPoint(11, 2);
		Point2 newPOLARPoint = Point2.newPOLARPoint(11, 2);
		
		System.out.println(newCartesianPoint.toString());
		System.out.println(newPOLARPoint.toString());
	}
	
	
}


class Point2 {
	private double x, y;

	private Point2(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public static Point2 newPOLARPoint(double a, double b) {
		return new Point2(a, b);
	}

	public static Point2 newCartesianPoint(double a, double b) {
		return new Point2(a * Math.cos(b), a * Math.sin(b));
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}

