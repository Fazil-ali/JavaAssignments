/*

    link : https://www.coursera.org/learn/java-programming/supplement/s3GE0/calculating-the-perimeter-of-a-shape
 */


import edu.duke.DirectoryResource;
import edu.duke.Point;
import edu.duke.Shape;
import edu.duke.FileResource;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;
        for(Point point : s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length=getPerimeter(s);
        double points=(double)getNumPoints(s);
        double averageLength=length/points;
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist>largestSide)
                largestSide=currDist;
            prevPt = currPt;
        }


        return largestSide;
    }

    public double getLargestX(Shape s) {


        int largestX=0;
        for(Point currPt : s.getPoints()){
            if(currPt.getX() > largestX)
                largestX=currPt.getX();

        }

        return (double)(largestX);
    }

    public double getLargestPerimeterMultipleFiles() {

        double largestPerimeter=0.0;
        DirectoryResource directory=new DirectoryResource();
        for(File file:directory.selectedFiles()){
            FileResource f=new FileResource(file);
            Shape shape=new Shape(f);
            double perimeter=getPerimeter(shape);
            if(perimeter > largestPerimeter){
                largestPerimeter=perimeter;
            }

        }

        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        double largestperimeter=getLargestPerimeterMultipleFiles();
        File temp=null;
        DirectoryResource directory=new DirectoryResource();

            for(File file : directory.selectedFiles()){
                FileResource f=new FileResource(file);
                Shape shape=new Shape(f);
                double perimeter=getPerimeter(shape);
                if(perimeter == largestperimeter){
                  temp=file;
            }
        }
            return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points : "+getNumPoints(s));
        System.out.println("Average length : "+getAverageLength(s));
        System.out.println( "Largest side : "+ getLargestSide(s));
        System.out.println("Largest side : "+ getLargestSide(s));
        System.out.println("Largest X coordinate : "+getLargestX(s));


    }

    public void testPerimeterMultipleFiles() {
        double perimeter=getLargestPerimeterMultipleFiles();
        System.out.println(perimeter);
    }

    public void testFileWithLargestPerimeter() {
        String fileName=getFileWithLargestPerimeter();
        System.out.println(fileName);
    }
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
             //pr.testPerimeter();
           System.out.println("Largest perimeter file name and its value");
            pr.testFileWithLargestPerimeter();
            pr.testPerimeterMultipleFiles();

    }
}