package design_pattern.constructor_factory;

public class Step01 {
	
}


enum PointType {
	POLAR, CARTESIAN
};

class Point {
	private double x, y;

	public Point(double a, double b, PointType type) {

		switch (type) {
		case POLAR:
			this.x = a * Math.cos(b);
			this.y = a * Math.sin(b);
			break;

		case CARTESIAN:
			this.x = a;
			this.y = b;
			break;
		}

	}

}