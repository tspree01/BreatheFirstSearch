import java.util.ArrayList;
import java.util.Vector;

class Shape {
/*	int x;
	int y;
	int x2;
	int y2;
	int x3;
	int y3;
	int x4;
	int y4;*/
	//Vector<Integer> numberOfBlocksInPiece;
	ArrayList<Block> numberOfBlocksInPiece;
	boolean validMove = false;


	//make 4-block piece

	Shape(int x, int y, int x2, int y2, int x3, int y3, int x4, int y4) {
		//numberOfBlocksInPiece = new Vector<>();
		numberOfBlocksInPiece = new ArrayList<>();
/*		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.x4 = x4;
		this.y4 = y4;*/
		numberOfBlocksInPiece.add(new Block(x,y));
		numberOfBlocksInPiece.add(new Block(x2,y2));
		numberOfBlocksInPiece.add(new Block(x3,y3));
		numberOfBlocksInPiece.add(new Block(x4,y4));

/*		numberOfBlocksInPiece.add(this.x);
		numberOfBlocksInPiece.add(this.y);
		numberOfBlocksInPiece.add(this.x2);
		numberOfBlocksInPiece.add(this.y2);
		numberOfBlocksInPiece.add(this.x3);
		numberOfBlocksInPiece.add(this.y3);
		numberOfBlocksInPiece.add(this.x4);
		numberOfBlocksInPiece.add(this.y4);*/






	}

	//make 3-block piece
	Shape(int x, int y, int x2, int y2, int x3, int y3) {
		//numberOfBlocksInPiece = new Vector<>();
		numberOfBlocksInPiece = new ArrayList<>();
/*		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;*/

		numberOfBlocksInPiece.add(new Block(x,y));
		numberOfBlocksInPiece.add(new Block(x2,y2));
		numberOfBlocksInPiece.add(new Block(x3,y3));

/*		numberOfBlocksInPiece.add(this.x);
		numberOfBlocksInPiece.add(this.y);
		numberOfBlocksInPiece.add(this.x2);
		numberOfBlocksInPiece.add(this.y2);
		numberOfBlocksInPiece.add(this.x3);
		numberOfBlocksInPiece.add(this.y3);*/
	}

}
