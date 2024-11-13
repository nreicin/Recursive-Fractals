// this program draws three distinct flowers, each more complex than the last

public class fractalFlowers {
	
	public static void main (String [] args) {
		Turtle t = new Turtle();
		t.delay(0);
		// positioning turtle for first flower
		t.penup();
		t.backward(350);
		t.left(90);
		t.pendown();
		//drawing first flower
		simpleFlower(t, 200);
		//positioning turtle for second flower
		t.penup();
		t.right(90);
		t.forward(250);
		t.left(90);
		t.pendown();
		// drawing second flower
		fractalFlower(t, 250, 3);
		// positioning turtle for third flower
		t.penup();
		t.right(90);
		t.forward(300);
		t.left(90);
		t.pendown();
		// drawing third flower
		fractalFlower(t, 300, 4);
	}

//this method creates a simple flower design with the turtle
	public static void simpleFlower (Turtle t, double size) {
		t.forward(size* 2.0 / 3.0);
		for(int i = 0; i < 8; i++) {
			t.forward(size / 3.0);
			t.backward(size / 3.0);
			t.right(45);

		}
		t.backward(size * 2.0 / 3.0);
	}

	// this method creates a recursive fractal of a flower
    public static void fractalFlower(Turtle t, double size, int level) {       
        if (level == 0){ 
        t.backward(size); // base case
        t.forward(size);
        } else {
            for (int i = 0; i < 8; i++){   // recursive case
              t.forward(size * 1.0/3.0);
              fractalFlower(t, size / 3.0, level - 1); // draw scaled down flower at the top of each line
              t.backward(size * 1.0/3.0);
              t.right(360.0/8);
           }
        }
        t.backward(size);  // draw stem
        t.forward(size);   
}




}

