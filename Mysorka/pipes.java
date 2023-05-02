
public class pipes {
    private int id;
    private double pipes_length;
    private double pipes_diameter;
    private int pipes_wall_thickness;

    public pipes(int id, double pipes_length, double pipes_diameter, int pipes_wall_thickness){
        this.id = id;
        this.pipes_length = pipes_length;
        this.pipes_diameter = pipes_diameter;
        this.pipes_wall_thickness = pipes_wall_thickness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLength() {
        return pipes_length;
    }

    public void setLength(double length) {
        this.pipes_length = length;
    }

    public double getWidth() {
        return pipes_diameter;
    }

    public void setWidth(double width) {
        this.pipes_diameter = width;
    }

    public int getWalls() {
        return pipes_wall_thickness;
    }

    public void setWalls(int walls) {
        this.pipes_wall_thickness = walls;
    }

    @Override
    public String toString() {
        return "Pipe{" +
                "id=" + id +
                ", length=" + pipes_length +
                ", width=" + pipes_diameter +
                ", walls=" + pipes_wall_thickness +
                '}';
    }
}