interface Shape {

	float getArea();

	float getPerimeter();

	String toString();
}

class Rectangle implements Shape {

	 double width; // sides
	 double length;
	 String shapeName;

	public Rectangle() {

		this(1, 1);

	}

	public Rectangle(double length, double width) {
		this.shapeName = "Rectangle";
		this.width = width;

		this.length = length;

	}

	@Override

	public float getArea() {

		// A = w * l
		System.out.println("Finding area of rectangle with length = " + length + " and width = " + width);
		return (float) (width * length);

	}

	@Override

	public float getPerimeter() {

		// P = 2(w + l)
		System.out.println("Finding perimeter of rectangle with length = " + length + " and width = " + width);
		return (float) (2 * (width + length));

	}

	public String toString() {

		return shapeName +" = [length: " + length + ", width: " + width + ", area: " + getArea() + ", perimeter: "
				+ getPerimeter() + "]";

	}

}

class Circle implements Shape {

	private final double radius;

	final float pi = (float) Math.PI;

	public Circle() {

		this(1);

	}

	public Circle(double radius) {

		this.radius = radius;

	}

	public float getArea() {

		// A = π r^2
		System.out.println("Finding area of circle with radius = " + radius);
		return (float) (pi * Math.pow(radius, 2));

	}

	public float getPerimeter() {

		// P = 2πr
		System.out.println("Finding perimeter of circle with radius = " + radius);
		return (float) (2 * pi * radius);

	}

	public String toString() {

		return "Circle = [radius: " + radius + ", area: " + String.format("%.2f", getArea()) + ", perimeter: " + String.format("%.2f", getPerimeter()) + "]";

	}

}

class Square extends Rectangle {
	
	public Square(double side) {
        super(side, side);
        this.shapeName = "Square";
        this.length = this.width = side;
    }

//	private final double side; // sides
//
//	public Square() {
//
//		this(1);
//
//	}
//
//	public Square(double side) {
//
//		this.side = side;
//
//	}
//
//	@Override
//
//	public float getArea() {
//
//		// A = w * l
//		System.out.println("Finding area of square with side = " + side );
//		return (float) (side * side);
//
//	}
//
//	@Override
//
//	public float getPerimeter() {
//
//		// P = 2(w + l)
//		System.out.println("Finding perimeter of square with side = " + side );
//		return (float) (4 * side);
//
//	}
//
//	public String toString() {
//
//		return "Square = [side: " + side + ", area: " + getArea() + ", perimeter: " + getPerimeter() + "]";
//
//	}

}

















