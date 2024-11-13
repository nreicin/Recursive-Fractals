// This program contains a recursive method which draws a face, and then another set of 2 faces as ears for the first face


public class FractalMickeyMouse {
    public static void main(String[] args) {
        Turtle t = new Turtle();
        t.delay(0);

        // Draw Fractal Mickey Mouse with depth 6
        //fractalMickeyMouse(t, 200, 6);
        //mickeyFace(t, 100);
        fractalMickeyMouse(t, 100, 6);
    }

    public static void drawCircle(Turtle t, double radius) {
        double circumference = 2 * Math.PI * radius;
        double sideLength = circumference / 360; // Approximate 1 degree angle
        for (int i = 0; i < 360; i++) {
            t.forward(sideLength);
            t.right(1);
        }

    }


    public static void drawMouth(Turtle t, double radius) {
        t.penup();
        t.forward(radius);
        t.right(90);
        t.pendown();
        double circumference = 2 * Math.PI * radius;
        double sideLength = circumference / 360; // Approximate 1 degree angle
        for (int i = 0; i < 180; i++) {
            t.forward(sideLength);
            t.right(1);
        }
        t.penup();
        t.right(90);
        t.forward(radius);
        t.pendown();
    }

    public static void mickeyFace(Turtle t, double r) {
        t.penup();
        t.backward(r); // moving to edge of face from middle of face
        t.left(90);
        t.pendown();
        drawCircle(t, r); // drawing larger circle
        t.penup();
        t.right(90);
        t.forward(r);
        t.backward(.5*r);
        t.left(90);
        t.forward(.5*r); // moving to left eye
        t.right(90);
        t.pendown();
        drawCircle(t, .1*r); // drawing left eye
        t.penup();
        t.forward(1*r); // moving to right eye
        t.pendown();
        drawCircle(t, .1*r); // drawing right eye
        t.penup();
        t.backward(1.5*r);
        t.right(90);  // moving to nose position
        t.forward(.5*r);
        t.left(90);
        t.forward(r);
        t.pendown();
        drawCircle(t, .1*r); // drawing nose
        t.penup();
        t.right(90);
        t.forward(.4*r); // moving to mouth position
        t.left(90);
        drawMouth(t, .5*r); // drawing mouth
        t.penup();
        t.left(90);
        t.forward(.4*r); // returning to starting position
        t.right(90);
        t.pendown();

    }


    public static void fractalMickeyMouse(Turtle t, double r, int level) {
        if (level == 0) {
            mickeyFace(t, r);
        } else {
            mickeyFace(t, r); // draw largest face
            t.penup();
            t.left(45);
            t.forward(1.5*r); // move to right ear
            t.right(45);
            t.pendown();
            fractalMickeyMouse(t, r * .5, level - 1); // recursive call to draw right ear
            t.penup();
            t.left(45);
            t.backward(1.5*r); // move back to center and then to left ear
            t.left(90);
            t.forward(1.5*r);
            t.right(135);
            t.pendown();
            fractalMickeyMouse(t, r * .5, level - 1); // recursive call to draw left ear
            t.penup();
            t.left(135);
            t.backward(1.5*r); // back to center
            t.right(135);




        }
    }



}
