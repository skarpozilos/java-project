public class Rectangulator {
  public static void main(String[] args) {
    int length;
    int width;
    String output;

    if ( args.length != 2) {
      output = "*** ERROR. Incorrect number of parameters provided. Need 2 (length and width) ***\n\n";
    } else {
      length = Integer.parseInt(args[0]);
      width = Integer.parseInt(args[1]);

      Rectangle myRectangle = new Rectangle(length, width);

      output = String.format("*** Your Rectangle ***\n\nLength: %d\nWidth: %d\nArea: %d\nPerimeter: %d\n\n", myRectangle.length, myRectangle.width, myRectangle.getArea(), myRectangle.getPerimeter());
    }

    System.out.println(output);
  }
}
