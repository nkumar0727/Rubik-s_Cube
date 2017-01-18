//Nikhil Kumar

public class RubikCube
{
	private CubeFace front, back, left, right, top, bottom; 

	//constructs a specific cube
	public RubikCube(CubeFace front, CubeFace back, CubeFace left, CubeFace right, CubeFace top, CubeFace bottom)
	{
		this.front = front;
		this.back = back;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
	}

	//prints out cube
	public String toString()
	{
		String cube = "";
		cube+="Front:\n"+this.front.toString();
		cube+="\nBack:\n"+this.back.toString();
		cube+="\nLeft:\n"+this.left.toString();
		cube+="\nRight:\n"+this.right.toString();
		cube+="\nTop:\n"+this.top.toString();
		cube+="\nBottom:\n"+this.bottom.toString();
		return cube;
	}

	//access faces
	public CubeFace getFront()
	{
		return this.front;
	}
	public CubeFace getBack()
	{
		return this.back;
	}
	public CubeFace getTop()
	{
		return this.top;
	}
	public CubeFace getBottom()
	{
		return this.bottom;
	}
	public CubeFace getLeft()
	{
		return this.left;
	}
	public CubeFace getRight()
	{
		return this.right;
	}
	
	
	//reset faces
	public void setFront(CubeFace face)
	{
		this.front.setFace(face.getArray());
	}
	public void setBack(CubeFace face)
	{
		this.back.setFace(face.getArray());
	}
	public void setLeft(CubeFace face)
	{
		this.left.setFace(face.getArray());
	}
	public void setRight(CubeFace face)
	{
		this.right.setFace(face.getArray());
	}
	public void setTop(CubeFace face)
	{
		this.top.setFace(face.getArray());
	}
	public void setBottom(CubeFace face)
	{
		this.bottom.setFace(face.getArray());
	}
	
	
	// shifting other pieces on main movements
	
	// cube.right() helper method for pos: 0,2 1,2 2,2
	private void right_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.bottom.setReturnSpot(i, 2, this.back.setReturnSpot(2-i, 0, this.top.setReturnSpot(i, 2, this.front.setReturnSpot(i, 2, this.bottom.getArray()[i][2]))));
		 }
	}
	
	// cube.rightInverted() helper method for pos: 0,2 1,2 2,2
	private void rightInverted_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.top.setReturnSpot(i, 2, this.back.setReturnSpot(2-i, 0, this.bottom.setReturnSpot(i, 2, this.front.setReturnSpot(i, 2, this.top.getArray()[i][2]))));
		 }
	}
	
	// cube.left() helper method for pos: 0,0 1,0 2,0
	private void left_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.top.setReturnSpot(i, 0, this.back.setReturnSpot(2-i, 2, this.bottom.setReturnSpot(i, 0, this.front.setReturnSpot(i, 0, this.top.getArray()[i][0]))));
		 }
	}
	
	// cube.leftInverted() helper method for pos: 0,0 1,0 2,0
	private void leftInverted_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.bottom.setReturnSpot(i, 0, this.back.setReturnSpot(2-i, 2, this.top.setReturnSpot(i, 0, this.front.setReturnSpot(i, 0, this.bottom.getArray()[i][0]))));
		 }
	}
	
	// cube.front() helper method for pos: 0,2 1,2 2,2
	private void front_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.bottom.setReturnSpot(0, i, this.right.setReturnSpot(2-i, 0, this.top.setReturnSpot(2, 2-i, this.left.setReturnSpot(i, 2, this.bottom.getArray()[0][i]))));
		 }
	}
	
	// cube.frontInverted() helper method for pos: 0,2 1,2 2,2
	private void frontInverted_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.top.setReturnSpot(2, i, this.right.setReturnSpot(i, 0, this.bottom.setReturnSpot(0, 2-i, this.left.setReturnSpot(2-i, 2, this.top.getArray()[2][i]))));
		 }
	}
	
	// cube.back() helper method for pos: 0,2 1,2 2,2 
	private void back_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.bottom.setReturnSpot(2, 2-i, this.left.setReturnSpot(2-i, 0, this.top.setReturnSpot(0, i, this.right.setReturnSpot(i, 2, this.bottom.getArray()[2][2-i]))));
		 }
	}
	
	// cube backInverted() helper method for pos: 0,2 1,2 2,2
	private void backInverted_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.top.setReturnSpot(0, 2-i, this.left.setReturnSpot(i, 0, this.bottom.setReturnSpot(2, i, this.right.setReturnSpot(2-i, 2, this.top.getArray()[0][2-i]))));
		 }
	}
	
	// cube.top() helper method for pos: 0,0 0,1 0,2
	private void top_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.right.setReturnSpot(0, i, this.back.setReturnSpot(0, i, this.left.setReturnSpot(0, i, this.front.setReturnSpot(0, i, this.right.getArray()[0][i]))));
		 }
	}
	
	// cube.topInverted() helper method for pos: 0,0 0,1 0,2
	private void topInverted_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.left.setReturnSpot(0, i, this.back.setReturnSpot(0, i, this.right.setReturnSpot(0, i, this.front.setReturnSpot(0, i, this.left.getArray()[0][i]))));
		 }
	}
	
	// cube.bottom() helper method for pos: 2,0 2,1 2,2
	private void bottom_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.bottom.setReturnSpot(2, i, this.back.setReturnSpot(2, i, this.top.setReturnSpot(2, i, this.front.setReturnSpot(2, i, this.bottom.getArray()[2][i]))));
		 }
	}
	
	// cube.bottomInverted() helper method for pos: 2,0 2,1 2,2
	private void bottomInverted_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		     this.right.setReturnSpot(2, i, this.back.setReturnSpot(2, i, this.left.setReturnSpot(2, i, this.front.setReturnSpot(2, i, this.right.getArray()[2][i]))));
		 }
	}
	
	// cube.verticalMiddle() helper method for pos: 0,1 1,1 2,1
	private void verticalMiddle_Shift()
	{
		for(int i = 0; i<=2; i++)
		{
			this.front.setReturnSpot(i, 1, this.bottom.setReturnSpot(i, 1, this.back.setReturnSpot(2-i, 1, this.top.setReturnSpot(i, 1, this.front.getArray()[i][1]))));
		}
	}
	
	// cube.verticalMiddleInverted_Shift() helper method for pos: 0,1 1,1 2,1
	private void verticalMiddleInverted_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		 		this.front.setReturnSpot(i, 1, this.top.setReturnSpot(i, 1, this.back.setReturnSpot(2-i, 1, this.bottom.setReturnSpot(i, 1, this.front.getArray()[i][1]))));
		 }
	}
	
	// cube.horizontalMiddle() helper method for pos: 1,0 1,1, 1,2 top face and other corresponding cube pieces
	private void horizontalMiddle_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		 		this.top.setReturnSpot(1, i, this.left.setReturnSpot(2-i, 1, this.bottom.setReturnSpot(1, 2-i, this.right.setReturnSpot(i, 1, this.top.getArray()[1][i]))));
		 }
	}
	
	private void horizontalMiddleInverted_Shift()
	{
		 for(int i = 0; i<=2; i++)
		 {
		  		this.top.setReturnSpot(1, i, this.right.setReturnSpot(i, 1, this.bottom.setReturnSpot(1, 2-i, this.left.setReturnSpot(2-i, 1, this.top.getArray()[1][i]))));
		 }	 
	}
	
	// MAIN MOVEMENTS
	
	
	
	public void right()
	{
		this.right.rotateClock();
		right_Shift();
		System.out.println("Move: RIGHT");
	}
	
	public void rightInverted()
	{
		this.right.rotateAnti();
		rightInverted_Shift();
		System.out.println("Move: RIGHT INVERTED");
	}
	
	public void left()
	{
		this.left.rotateClock();
		left_Shift();
		System.out.println("Move: LEFT");
	}
	
	public void leftInverted()
	{
		this.left.rotateAnti();
		leftInverted_Shift();
		System.out.println("Move: LEFT INVERTED");
	}
	
	public void front()
	{
		this.front.rotateClock();
		front_Shift();
		System.out.println("Move: FRONT");
	}
		
	public void frontInverted()
	{
		this.front.rotateAnti();
		frontInverted_Shift();
		System.out.println("Move: FRONT INVERTED");
	}
	
	public void back()
	{
		this.back.rotateClock();
		back_Shift();
		System.out.println("Move: BACK");
	}
	
	public void backInverted()
	{
		this.back.rotateAnti();
		backInverted_Shift();
		System.out.println("Move: BACK INVERTED");
	}
	
	public void top()
	{
		this.top.rotateClock();
		top_Shift();
		System.out.println("Move: TOP");
	}
	
	public void topInverted()
	{
		this.top.rotateAnti();
		topInverted_Shift();
		System.out.println("Move: TOP INVERTED");
	}
	
	public void bottom()
	{
		this.bottom.rotateClock();
		bottom_Shift();
		System.out.println("Move: BOTTOM");
	}
	
	public void bottomInverted()
	{
		this.bottom.rotateAnti();
		bottomInverted_Shift();
		System.out.println("Move: BOTTOM INVERTED");
	}
	
	public void verticalMiddle()
	{
		verticalMiddle_Shift();
		System.out.println("Move: VERTICAL MIDDLE");
	}
	
	public void verticalMiddleInverted()
	{
		verticalMiddleInverted_Shift();
		System.out.println("Move: VERTIAL MIDDLE INVERTED");
	}
	
	public void horizontalMiddle()
	{
		horizontalMiddle_Shift();
		System.out.println("Move: HORIZONTAL MIDDLE");
	}
	
	public void horizontalMiddleInverted()
	{
		horizontalMiddleInverted_Shift();
		System.out.println("Move: HORIZONTAL MIDDLE INVERTED");
	}
}
