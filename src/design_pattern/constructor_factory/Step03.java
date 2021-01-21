package design_pattern.constructor_factory;

public class Step03 {
	public static void main(String[] args) {
		Point3 newCartesianPoint = Point3.Factory.newCartesianPoint(11, 2);
		Point3 newPOLARPoint = Point3.Factory.newPOLARPoint(11, 2);
		
		System.out.println(newCartesianPoint.toString());
		System.out.println(newPOLARPoint.toString());
	}
	
	
}


class Point3 {
	private double x, y;

	private Point3(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public static class Factory {
		public static Point3 newPOLARPoint(double a, double b) {
			return new Point3(a, b);
		}

		public static Point3 newCartesianPoint(double a, double b) {
			return new Point3(a * Math.cos(b), a * Math.sin(b));
		}
	}


	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}

