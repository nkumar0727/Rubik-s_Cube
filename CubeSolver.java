
public class CubeSolver {

		private RubikCube cube;
		
		//creates a cube solver that takes in a RubikCube 
		public CubeSolver(RubikCube cube)
		{
			this.cube = cube;
		}
		
		//solves cube until "top-cross" phase is completed
		public void topCross()
		{
			char target = cube.getTop().getMainColor();
			int top, front, back, left, right, counter = 0;
			
			while(!cube.getBottom().hasCross(target))
			{
				top = topCross_clearTop(target);
				front = topCross_clearFront(target);
				back = topCross_clearBack(target);
				left = topCross_clearLeft(target);
				right = topCross_clearRight(target);
				
				//debugging crap
				System.out.println("TOP MVM: "+top);
				System.out.println("FRONT MVM: "+front);
				System.out.println("BACK MVM: "+back);
				System.out.println("LEFT MVM: "+left);
				System.out.println("RIGHT MVM: "+right);
			}
			
			//BRING UP PIECES
				
			//front face initially
			while(cube.getFront().getMainColor() != cube.getFront().getArray()[2][1])
				cube.bottom();
			
			cube.front(); cube.front();
			
			//rest of the faces
			while(counter < 3)
			{
				if(cube.getRight().getMainColor() == cube.getRight().getArray()[2][1])
				{
					cube.right(); cube.right();
					counter++;
					if(counter >= 3)
						break;
				}
				else
					cube.bottom();
				
				if(cube.getBack().getMainColor() == cube.getBack().getArray()[2][1])
				{
					cube.back(); cube.back();
					counter++;
					if(counter >= 3)
						break;
				}
				else
						cube.bottom();
				
				if(cube.getLeft().getMainColor() == cube.getLeft().getArray()[2][1])
				{
					cube.left(); cube.left();
					counter++;
					if(counter >= 3)
						break;
				}
				else
					cube.bottom();
				
				if(cube.getFront().getMainColor() == cube.getFront().getArray()[2][1])
				{
					cube.front(); cube.front();
					counter++;
				}
				else
					cube.bottom();			
			}
			System.out.println("DONE: \n"+cube.toString());
		}
		
		//moves all pieces with targetColor on the top face to bottom face
		//key topFace positions: 0,1 	1,0	    1,2      2,1
		private int topCross_clearTop(char targetColor)
		{
			int counter = 0;
			boolean stop = false;
			char[][] topArray;
			while(!stop)
			{
				topArray = cube.getTop().getArray();
				if(topArray[0][1] == targetColor)
				{
					while(cube.getBottom().getArray()[2][1] == targetColor)
						cube.bottom();
					cube.back(); cube.back();
					counter++;
				}
				else if(topArray[1][0] == targetColor)
				{
					while(cube.getBottom().getArray()[1][0] == targetColor)
						cube.bottom();
					cube.left(); cube.left();
					counter++;
				}
				else if(topArray[1][2] == targetColor)
				{
					while(cube.getBottom().getArray()[1][2] == targetColor)
						cube.bottom();
					cube.right(); cube.right();
					counter++;
				}
				else if(topArray[2][1] == targetColor)
				{
					while(cube.getBottom().getArray()[0][1] == targetColor)
						cube.bottom();
					cube.front(); cube.front();
					counter++;
				}
				else
					stop = true;
			}
			return counter;	
		}
		
		//moves all pieces with targetColor on the front to bottom face
		//key frontFace positions:  0,1 	1,0	    1,2      2,1
		private int topCross_clearFront(char targetColor)
		{
			int counter = 0;
			boolean stop = false;
			char[][] frontArray;
			while(!stop)
			{
				frontArray = cube.getFront().getArray();
				if(frontArray[0][1] == targetColor)
				{
					while(cube.getBottom().getArray()[0][1] == targetColor)
						cube.bottom();
					cube.front();
					while(cube.getBottom().getArray()[1][2] == targetColor)
						cube.bottom();
					cube.rightInverted();
					counter++;
				}
				else if(frontArray[1][0] == targetColor)
				{
					while(cube.getBottom().getArray()[1][0] == targetColor)
						cube.bottom();
					cube.left();
					counter++;
				}
				else if(frontArray[1][2] == targetColor)
				{
					while(cube.getBottom().getArray()[1][2] == targetColor)
						cube.bottom();
					cube.rightInverted();
					counter++;
				}
				else if(frontArray[2][1] == targetColor)
				{
					cube.front();
					while(cube.getBottom().getArray()[1][0] == targetColor)
						cube.bottom();
					cube.left();
					counter++;
				}
				else
					stop = true;
			}
			return counter;
		}
		
		//moves all pieces with targetColor on the back to bottom face
		//key backFace positions:  0,1 	1,0	    1,2      2,1
		private int topCross_clearBack(char targetColor)
		{
			int counter = 0; 	//sees how much have been moved
			boolean stop = false;
			char[][] backArray;
			while(!stop)
			{
				backArray = cube.getBack().getArray();
				if(backArray[0][1] == targetColor)
				{
					while(cube.getBottom().getArray()[2][1] == targetColor)
						cube.bottom();
					cube.back();
					while(cube.getBottom().getArray()[1][0] == targetColor)
						cube.bottom();
					cube.leftInverted();
					counter++;
				}
				else if(backArray[1][0] == targetColor)
				{
					while(cube.getBottom().getArray()[1][2] == targetColor)
						cube.bottom();
					cube.right();
					counter++;
				}
				else if(backArray[1][2] == targetColor)
				{
					while(cube.getBottom().getArray()[1][0] == targetColor)
						cube.bottom();
					cube.leftInverted();
					counter++;
				}
				else if(backArray[2][1] == targetColor)
				{
					cube.back();
					while(cube.getBottom().getArray()[1][2] == targetColor)
						cube.bottom();
					cube.right();
					counter++;
				}
				else
					stop = true;
			}
			return counter;
		}
		
		//moves all pieces with targetColor on the left to bottom face
		//key leftFace positions:  0,1 	1,0	    1,2      2,1
		private int topCross_clearLeft(char targetColor)
		{
			int counter = 0; 	//sees how much have been moved
			boolean stop = false;
			char[][] leftArray;
			while(!stop)
			{
				leftArray = cube.getLeft().getArray();
				if(leftArray[0][1] == targetColor)
				{
					while(cube.getBottom().getArray()[1][0] == targetColor)
						cube.bottom();
					cube.left();
					while(cube.getBottom().getArray()[0][1] == targetColor)
						cube.bottom();
					cube.frontInverted();
					counter++;
				}
				else if(leftArray[1][0] == targetColor)
				{
					while(cube.getBottom().getArray()[2][1] == targetColor)
						cube.bottom();
					cube.back();
					counter++;
				}
				else if(leftArray[1][2] == targetColor)
				{
					while(cube.getBottom().getArray()[0][1] == targetColor)
						cube.bottom();
					cube.frontInverted();
					counter++;
				}
				else if(leftArray[2][1] == targetColor)
				{
					cube.left();
					while(cube.getBottom().getArray()[2][1] == targetColor)
						cube.bottom();
					cube.back();
					counter++;
				}
				else
					stop = true;
			}
			return counter;
		}
		
		//moves all pieces with targetColor on the right to bottom face
		//key rightFace positions:  0,1 	1,0	    1,2      2,1
		private int topCross_clearRight(char targetColor)
		{
			int counter = 0; 	//sees how much have been moved
			boolean stop = false;
			char[][] rightArray;
			while(!stop)
			{
				rightArray = cube.getRight().getArray();
				if(rightArray[0][1] == targetColor)
				{
					while(cube.getBottom().getArray()[1][2] == targetColor)
						cube.bottom();
					cube.right();
					while(cube.getBottom().getArray()[2][1] == targetColor)
						cube.bottom();
					cube.backInverted();
					counter++;
				}
				else if(rightArray[1][0] == targetColor)
				{
					while(cube.getBottom().getArray()[0][1] == targetColor)
						cube.bottom();
					cube.front();
					counter++;
				}
				else if(rightArray[1][2] == targetColor)
				{
					while(cube.getBottom().getArray()[2][1] == targetColor)
						cube.bottom();
					cube.backInverted();
					counter++;
				}
				else if(rightArray[2][1] == targetColor)
				{
					cube.right();
					while(cube.getBottom().getArray()[0][1] == targetColor)
						cube.bottom();
					cube.front();
					counter++;
				}
				else
					stop = true;
			}
			return counter;
		}
		
		
		
		//assumes that cube has already gone through topCross()
		//brings top pieces into place; solves top face of cube
		public void topCorners()
		{
			char targetColor = cube.getTop().getMainColor();
			while(!cube.getTop().sameFace())
			{
				topCorners_clearFront(targetColor);
				topCorners_clearRight(targetColor);
				topCorners_clearBack(targetColor);
				topCorners_clearLeft(targetColor);
				topCorners_clearBottom(targetColor);
			}
			System.out.println("DONE: \n"+cube.toString());
		}
		
		//topCorner HELPER METHODS
		
		//brings target piece on front face from position 0,0 to 2,0
		private void topCorners_frontFace_leftDown()
		{
			cube.frontInverted();
			cube.bottomInverted();
			cube.front();
			cube.bottom();
		}
		
		//brings target piece on front face from position 0,2 to 2,2
		private void topCorners_frontFace_rightDown()
		{
			cube.front();
			cube.bottom();
			cube.frontInverted();
			cube.bottomInverted();
		}
		
		//brings target piece on front face from position 2,0 up to top face position 2,0
		//returns true and moves if piece is in correct cube position, false if it is not
		private boolean topCorners_frontFace_leftUp()
		{
			if(cube.getBottom().getArray()[0][0] == cube.getFront().getMainColor() && cube.getLeft().getArray()[2][2] == cube.getLeft().getMainColor())
			{
				cube.bottom();
				cube.left();
				cube.bottomInverted();
				cube.leftInverted();
				return true;
			}
			return false;
		}
		
		//brings target piece on front face from position 2,2 up to top face position 2,2
		//returns true and moves if piece is in correct cube position, false if it is not
		private boolean topCorners_frontFace_rightUp()
		{
			if(cube.getBottom().getArray()[0][2] == cube.getFront().getMainColor() && cube.getRight().getArray()[2][0] == cube.getRight().getMainColor())
			{
				cube.bottomInverted();
				cube.rightInverted();
				cube.bottom();
				cube.right();
				return true;
			}
			return false;
		}
		
		//brings target piece on right face from position 0,0 t0 2,0
		private void topCorners_rightFace_leftDown()
		{
			cube.rightInverted();
			cube.bottomInverted();
			cube.right();
			cube.bottom();
		}
		
		//brings target piece on right face from position 0,2 to 2,2
		private void topCorners_rightFace_rightDown()
		{
			cube.right();
			cube.bottom();
			cube.rightInverted();
			cube.bottomInverted();
		}
		
		//brings target piece on right face from position 2,0 up to top face position 2,2
		//returns true and moves if piece is in correct cube position, false if it is not
		private boolean topCorners_rightFace_leftUp()
		{
			if(cube.getBottom().getArray()[0][2] == cube.getRight().getMainColor() && cube.getFront().getArray()[2][2] == cube.getFront().getMainColor())
			{
				cube.bottom();
				cube.front();
				cube.bottomInverted();
				cube.frontInverted();
				return true;
			}
			return false;
		}
		
		//brings target piece on right face from position 2,2 up to top face position 0,2
		//returns true and moves if piece is in correct cube position, false if it is not
		private boolean topCorners_rightFace_rightUp()
		{
			if(cube.getBottom().getArray()[2][2] == cube.getRight().getMainColor() && cube.getBack().getArray()[2][0] == cube.getBack().getMainColor())
			{
				cube.bottomInverted();
				cube.backInverted();
				cube.bottom();
				cube.back();
				return true;
			}
			return false;
		}
		
		//brings target piece on back face from position 0,0 to 2,0
		private void topCorners_backFace_leftDown()
		{
			cube.backInverted();
			cube.bottomInverted();
			cube.back();
			cube.bottom();
		}
		
		//brings target piece on back face from position 0,2 to 2,2
		private void topCorners_backFace_rightDown()
		{
			cube.back();
			cube.bottom();
			cube.backInverted();
			cube.bottomInverted();
		}
		
		//brings target piece on back face from position 2,0 up to top face position 0,2
		//returns true and moves if piece is in correct cube position, false if it is not
		private boolean topCorners_backFace_leftUp()
		{
			if(cube.getBottom().getArray()[2][2] == cube.getBack().getMainColor() && cube.getRight().getArray()[2][2] == cube.getRight().getMainColor())
			{
				cube.bottom();
				cube.right();
				cube.bottomInverted();
				cube.rightInverted();
				return true;
			}
			return false;
		}
		
		//brings target piece on back face from position 2,2 up to top face position 0,0
		//returns true and moves if piece is in correct cube position, false if it is not
		private boolean topCorners_backFace_rightUp()
		{
			if(cube.getBottom().getArray()[2][0] == cube.getBack().getMainColor() && cube.getLeft().getArray()[2][0] == cube.getLeft().getMainColor())
			{
				cube.bottomInverted();
				cube.leftInverted();
				cube.bottom();
				cube.left();
				return true;
			}
			return false;
		}
		
		//brings target piece on left face from position 0,0 t0 2,0
		private void topCorners_leftFace_leftDown()
		{
			cube.leftInverted();
			cube.bottom();
			cube.left();
			cube.bottomInverted();
		}
		
		//brings target piece on left face from position 0,2 to 2,2
		private void topCorners_leftFace_rightDown()
		{
			cube.left();
			cube.bottom();
			cube.leftInverted();
			cube.bottomInverted();
		}
		
		//brings target piece on left face from position 2,0 up to top face position 0,0
		//returns true and moves if piece is in correct cube position, false if it is not
		private boolean topCorners_leftFace_leftUp()
		{
			if(cube.getBottom().getArray()[2][0] == cube.getLeft().getMainColor() && cube.getBack().getArray()[2][2] == cube.getBack().getMainColor())
			{
				cube.bottom();
				cube.back();
				cube.bottomInverted();
				cube.backInverted();
				return true;
			}
			return false;
		}
		
		//brings target piece on left face from position 2,2 up to top face position 2,0
		//returns true and moves if piece is in correct cube position, false if it is not
		private boolean topCorners_leftFace_rightUp()
		{
			if(cube.getBottom().getArray()[0][0] == cube.getLeft().getMainColor() && cube.getFront().getArray()[2][0] == cube.getFront().getMainColor())
			{
				cube.bottomInverted();
				cube.frontInverted();
				cube.bottom();
				cube.front();
				return true;
			}
			return false;
		}
		/*
		assumes that piece of certain targetColor is located at position 2,0 of some face
		works to move piece up to correct location
		starting face:   front if faceOption == 0
						 right if faceOption == 1
						 back if faceOption == 2
						 left if faceOption == anything else
		*/
		private void topCorners_leftUpCycle(int faceOption)
		{
			//front face to start cycle
			if(faceOption == 0)
			{
				if(!topCorners_frontFace_leftUp())
				{
					cube.bottom();
					if(!topCorners_rightFace_leftUp())
					{
						cube.bottom();
						if(!topCorners_backFace_leftUp())
						{
							cube.bottom();
							topCorners_leftFace_leftUp();
						}
					}
				}
			}
			//right face to start cycle
			else if(faceOption == 1)
			{
				if(!topCorners_rightFace_leftUp())
				{
					cube.bottom();
					if(!topCorners_backFace_leftUp())
					{
						cube.bottom();
						if(!topCorners_leftFace_leftUp())
						{
							cube.bottom();
							topCorners_frontFace_leftUp();
						}
					}
				}
			}
			//back face to start cycle
			else if(faceOption == 2)
			{
				if(!topCorners_backFace_leftUp())
				{
					cube.bottom();
					if(!topCorners_leftFace_leftUp())
					{
						cube.bottom();
						if(!topCorners_frontFace_leftUp())
						{
							cube.bottom();
							topCorners_rightFace_leftUp();
						}
					}
				}
			}
			//left face to start cycle
			else
			{
				if(!topCorners_leftFace_leftUp())
				{
					cube.bottom();
					if(!topCorners_frontFace_leftUp())
					{
						cube.bottom();
						if(!topCorners_rightFace_leftUp())
						{
							cube.bottom();
							topCorners_backFace_leftUp();
						}
					}
				}
			}
		}
		
		/*
		assumes that piece of certain targetColor is located at position 2,2 of some face
		works to move piece up to correct location
		starting face:   front if faceOption == 0
						 right if faceOption == 1
						 back if faceOption == 2
						 left if faceOption == anything else (3)
		*/
		private void topCorners_rightUpCycle(int faceOption)
		{
			//front face to start cycle
			if(faceOption == 0)
			{
				if(!topCorners_frontFace_rightUp())
				{
					cube.bottom();
					if(!topCorners_rightFace_rightUp())
					{
						cube.bottom();
						if(!topCorners_backFace_rightUp())
						{
							cube.bottom();
							topCorners_leftFace_rightUp();
						}
					}
				}
			}
			//right face to start cycle
			else if(faceOption == 1)
			{
				if(!topCorners_rightFace_rightUp())
				{
					cube.bottom();
					if(!topCorners_backFace_rightUp())
					{
						cube.bottom();
						if(!topCorners_leftFace_rightUp())
						{
							cube.bottom();
							topCorners_frontFace_rightUp();
						}
					}
				}
			}
			//back face to start cycle
			else if(faceOption == 2)
			{
				if(!topCorners_backFace_rightUp())
				{
					cube.bottom();
					if(!topCorners_leftFace_rightUp())
					{
						cube.bottom();
						if(!topCorners_frontFace_rightUp())
						{
							cube.bottom();
							topCorners_rightFace_rightUp();
						}
					}
				}
			}
			//left face to start cycle
			else
			{
				if(!topCorners_leftFace_rightUp())
				{
					cube.bottom();
					if(!topCorners_frontFace_rightUp())
					{
						cube.bottom();
						if(!topCorners_rightFace_rightUp())
						{
							cube.bottom();
							topCorners_backFace_rightUp();
						}
					}
				}
			}
		}
		
		//topCorners() helper method; clears front face
		private void topCorners_clearFront(char targetColor)
		{
			boolean stop = false;
			while(!stop)
			{
				if(cube.getFront().getArray()[0][0] == targetColor)
				{
					topCorners_frontFace_leftDown();
					topCorners_leftUpCycle(0);
				}
				else if(cube.getFront().getArray()[0][2] == targetColor)
				{
					topCorners_frontFace_rightDown();
					topCorners_rightUpCycle(0);
				}
				else if(cube.getFront().getArray()[2][0] == targetColor)
				{
					topCorners_leftUpCycle(0);
				}
				else if(cube.getFront().getArray()[2][2] == targetColor)
				{
					topCorners_rightUpCycle(0);
				}
				else
					stop = true;
			}
		}
		
		//topCorners() helper method; clears right face
		private void topCorners_clearRight(char targetColor)
		{
			boolean stop = false;
			while(!stop)
			{
			    if(cube.getRight().getArray()[0][0] == targetColor)
				{
			    	topCorners_rightFace_leftDown();
			    	topCorners_leftUpCycle(1);
				}
				else if(cube.getRight().getArray()[0][2] == targetColor)
				{
					topCorners_rightFace_rightDown();
					topCorners_rightUpCycle(1);
				}
				else if(cube.getRight().getArray()[2][0] == targetColor)
				{
					topCorners_leftUpCycle(1);
				}
				else if(cube.getRight().getArray()[2][2] == targetColor)
				{
					topCorners_rightUpCycle(1);
				}
				else
					stop = true;
			}
		}
		
		//topCorners() helper method; clears back face
		private void topCorners_clearBack(char targetColor)
		{
			boolean stop = false;
			while(!stop)
			{
			    if(cube.getBack().getArray()[0][0] == targetColor)
				{
			    	topCorners_backFace_leftDown();
			    	topCorners_leftUpCycle(2);
				}
				else if(cube.getBack().getArray()[0][2] == targetColor)
				{
					topCorners_backFace_rightDown();
					topCorners_rightUpCycle(2);
				}
				else if(cube.getBack().getArray()[2][0] == targetColor)
				{
					topCorners_leftUpCycle(2);
				}
				else if(cube.getBack().getArray()[2][2] == targetColor)
				{
					topCorners_rightUpCycle(2);
				}
				else
					stop = true;
			}
		}
		
		//topCorners() helper method; clears left face
		private void topCorners_clearLeft(char targetColor)
		{
			boolean stop = false;
			while(!stop)
			{
			    if(cube.getLeft().getArray()[0][0] == targetColor)
				{
			    	topCorners_leftFace_leftDown();
			    	topCorners_leftUpCycle(3);
				}
				else if(cube.getLeft().getArray()[0][2] == targetColor)
				{
					topCorners_leftFace_rightDown();
					topCorners_rightUpCycle(3);
				}
				else if(cube.getLeft().getArray()[2][0] == targetColor)
				{
					topCorners_leftUpCycle(3);
				}
				else if(cube.getLeft().getArray()[2][2] == targetColor)
				{
					topCorners_rightUpCycle(3);
				}
				else
					stop = true;
			}
		}
		
		//topCorners() helper method; clears bottom face
		private void topCorners_clearBottom(char targetColor)
		{
			boolean stop = false;
			while(!stop)
			{
				System.out.println("HELLO ITS ME");
			    if(cube.getBottom().getArray()[0][0] == targetColor)
				{
			    	cube.frontInverted();
			    	cube.bottom();
			    	cube.front();
			    	topCorners_leftUpCycle(2);
				}
				else if(cube.getBottom().getArray()[0][2] == targetColor)
				{
					cube.front();
					cube.bottomInverted();
					cube.frontInverted();
					topCorners_rightUpCycle(2);
				}
				else if(cube.getBottom().getArray()[2][0] == targetColor)
				{
					cube.back();
					cube.bottomInverted();
					cube.backInverted();
					topCorners_rightUpCycle(0);
				}
				else if(cube.getBottom().getArray()[2][2] == targetColor)
				{
					cube.backInverted();
					cube.bottom();
					cube.back();
					topCorners_leftUpCycle(0);
				}
				else
					stop = true;
			}
		}
		
		//solves cube till the "middle layer" step
		public void middleLayer()
		{}
		
		// middleLayer() helper method; places piece in position 2,1 on front face onto 1,2 on front face
		private void middleLayer_front_right()
		{
			cube.bottomInverted();
			cube.back();
			cube.rightInverted();
			cube.horizontalMiddleInverted();
			cube.right();
			//fix top
			cube.frontInverted();
			cube.right();
			cube.horizontalMiddle();
			cube.rightInverted();
			cube.horizontalMiddleInverted();
			//cube.yAxisRotateClockwise();
		}
		
		// middleLayer() helper method; places piece in position 2,1 on front face onto 1,0 on front face
		private void middleLayer_front_left()
		{
			cube.bottom();
			cube.backInverted();
			cube.left();
			cube.horizontalMiddle();
			cube.leftInverted();
			//fix top
			cube.front();
			cube.leftInverted();
			cube.horizontalMiddleInverted();
			cube.left();
			cube.horizontalMiddle();
			//cube.yAxisRotateAnti();
		}
		
		// middleLayer() helper method; places piece in position 2,1 on right face onto 1,2 on right face
		private void middleLayer_right_right()
		{
			cube.bottomInverted();
			cube.left();
			cube.backInverted();
			cube.verticalMiddleInverted();
			cube.back();
			//fix top
			cube.rightInverted();
			cube.back();
			cube.verticalMiddle();
			cube.backInverted();
			cube.verticalMiddleInverted();
			//cube.xAxisRotateAnti();
		}
		
		// middleLayer() helper method: places piece in position 2,1 on right face onto 1,0 on right face
		private void middleLayer_right_left()
		{
			cube.bottom();
			cube.leftInverted();
			cube.front();
			cube.verticalMiddle();
			cube.frontInverted();
			//fix top
			cube.right();
			cube.front();
			cube.verticalMiddleInverted();
			cube.frontInverted();
			cube.verticalMiddle();
			//cube.xAxisRotateClockwise();
		}
		
		// middleLayer() helper method; places piece in position 2,1 on back face onto 1,2 on back face
		private void middleLayer_back_right()
		{
			cube.bottom();
			cube.frontInverted();
			cube.right();
			cube.horizontalMiddleInverted();
			cube.rightInverted();
			//fix top
			cube.back();
			cube.bottom();
			cube.horizontalMiddle();
			cube.bottomInverted();
			cube.horizontalMiddleInverted();
		}
		
		// middleLayer() helper method; places piece in position 2,1 on back face onto 1,0 on back face
		private void middleLayer_back_left()
		{
			cube.bottomInverted();
			cube.front();
			cube.leftInverted();
			cube.horizontalMiddle();
			cube.left();
			//fix top
			cube.backInverted();
			cube.bottom();
			cube.horizontalMiddleInverted();
			cube.bottomInverted();
			cube.horizontalMiddle();
		}
		
		// middleLayer() helper method; places piece in position 2,1 on left face onto 1,2 on left face
		private void middleLayer_left_right()
		{
			cube.bottomInverted();
			cube.right();
			cube.frontInverted();
			cube.verticalMiddle();
			cube.front();
			//fix top
			cube.leftInverted();
			cube.front();
			cube.verticalMiddleInverted();
			cube.frontInverted();
			cube.verticalMiddle();
			//cube.xAxisRotateClockwise();
		}
		
		// middleLayer() helper method; places piece in position 2,1 on left face onto 1,0 on left face
		private void middleLayer_left_left()
		{
			cube.bottom();
			cube.rightInverted();
			cube.back();
			cube.verticalMiddleInverted();
			cube.backInverted();
			//fix top
			cube.left();
			cube.back();
			cube.verticalMiddle();
			cube.backInverted();
			cube.verticalMiddleInverted();
			//cube.xAxisRotateAnti();
		}
		
		private void scanBottom()
		{
			boolean stop = false;
			while(!stop)
			{
				char bottomColor = cube.getBottom().getMainColor();
				if(cube.getBottom().getArray()[0][0] != bottomColor && cube.getFront().getArray()[2][1] != bottomColor)
				{
					if(cube.getFront().getArray()[2][1] == cube.getFront().getMainColor())
					{
						//main process
						if(cube.getBottom().getArray()[0][0] == cube.getRight().getMainColor())
							middleLayer_front_right();
						else
							middleLayer_front_left();
					}
					else
					{
						cube.bottom();
						//main process
						if(cube.getRight().getArray()[2][1] == cube.getRight().getMainColor())
						{
							if(cube.getBottom().getArray()[1][2] == cube.getBack().getMainColor())
								middleLayer_right_right();
							else
								middleLayer_right_left();					
						}
						else
						{
							cube.bottom();
							if(cube.getBack().getArray()[2][1] == cube.getBack().getMainColor())
							{
								//main process
								if(cube.getRight().getMainColor() == cube.getBottom().getArray()[2][1])
									middleLayer_back_left();
								else
									middleLayer_back_right();
							}
							else
							{
								cube.bottom();
								if(cube.getBack().getMainColor() == cube.getBottom().getArray()[1][0])
									middleLayer_left_left();
								else
									middleLayer_left_right();
							}
						}
					}
				}
				else if(cube.getBottom().getArray()[1][0] != bottomColor && cube.getLeft().getArray()[2][1] != bottomColor)
				{
					if(cube.getLeft().getArray()[2][1] == cube.getLeft().getMainColor())
					{
						//main process
						if(cube.getBottom().getArray()[1][0] == cube.getFront().getMainColor())
							middleLayer_front_right();
						else
							middleLayer_front_left();
					}
					else
					{
						cube.bottom();
						//main process
						if(cube.getFront().getArray()[2][1] == cube.getFront().getMainColor())
						{
							if(cube.getBottom().getArray()[0][1] == cube.getRight().getMainColor())
								middleLayer_right_right();
							else
								middleLayer_right_left();					
						}
						else
						{
							cube.bottom();
							if(cube.getRight().getArray()[2][1] == cube.getRight().getMainColor())
							{
								//main process
								if(cube.getFront().getMainColor() == cube.getBottom().getArray()[1][2])
									middleLayer_back_left();
								else
									middleLayer_back_right();
							}
							else
							{
								cube.bottom();
								if(cube.getRight().getMainColor() == cube.getBottom().getArray()[2][1])
									middleLayer_left_left();
								else
									middleLayer_left_right();
							}
						}
					}
				}
				else if(cube.getBottom().getArray()[1][2] != bottomColor && cube.getRight().getArray()[2][1] != bottomColor)
				{}
				else if(cube.getBottom().getArray()[2][1] != bottomColor && cube.getBack().getArray()[2][1] != bottomColor)
				{}
				else
					stop = true;
			}
		}
}
		
		
		
		
		
		
		
