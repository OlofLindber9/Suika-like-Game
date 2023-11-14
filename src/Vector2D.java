class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Method to subtract another vector from this one
    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    // Method to add another vector to this one
    public Vector2D add(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }
    // Method to multiply this vector by a scalar
    public Vector2D multiply(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    // Method to divide this vector by a scalar
    public Vector2D divide(double scalar) {
        if (scalar == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return new Vector2D(this.x / scalar, this.y / scalar);
    }

    // Method to set the x coordinate
    public void setX(double x) {
        this.x = x;
    }

    // Method to set the y coordinate
    public void setY(double y) {
        this.y = y;
    }

    // Method to set both coordinates at once
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // Getter for the x coordinate
    public double getX() {
        return this.x;
    }

    // Getter for the y coordinate
    public double getY() {
        return this.y;
    }
}
