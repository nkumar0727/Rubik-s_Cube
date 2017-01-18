//Nikhil Kumar

public class CubeFace
{
	private char[][] arrayColors;
	private char mainColor;

	//creates a face with an array of colors and a central main color
	public CubeFace(char[][] arrayInput)
	{
		arrayColors = arrayInput;
		this.mainColor = arrayInput[1][1];
	}

	//prints out actual colors on the face
	public String toString()
	{
		String face = "";
		for(int i = 0; i<arrayColors.length; i++)
		{
			for(int j = 0; j<arrayColors[i].length; j++)
			{
				face+=arrayColors[i][j]+"\t";
			}
			face+="\n";
		}
		return face;
	}
	
	//changes face into 2D array input
	public void setFace(char[][] array)
	{
		arrayColors = array;
		mainColor = array[1][1];
	}
	
	//changes one element in face 
	public void setSpot(int i, int j, char input)
	{
		arrayColors[i][j] = input;
		if(i==j && i==1)
			mainColor = input;
	}
	
	//changes element in face, and returns original element
	public char setReturnSpot(int i, int j, char input)
	{
		char original = arrayColors[i][j];
		arrayColors[i][j] = input;
		return original;
	}

	//access to array of colors
	public char[][] getArray()
	{
		return arrayColors;
	}

	//gets center color of face
	public char getMainColor()
	{
		return mainColor;
	}

	//returns an array containing the right column of the face
	public char[] rightColumn()
	{
		char[] rightArray = new char[3];
		rightArray[0] = arrayColors[0][2];
		rightArray[1] = arrayColors[1][2];
		rightArray[2] = arrayColors[2][2];
		return rightArray;
	}

	//returns an array containing the left column of the face
	public char[] leftColumn()
	{
		char[] leftArray = new char[3];
		leftArray[0] = arrayColors[0][0];
		leftArray[1] = arrayColors[1][0];
		leftArray[2] = arrayColors[2][0];
		return leftArray;
	}

	/*
	 * __________________NO CURRENT USE__________________
	//returns a linear array of the colors on the face
	public char[] linearFace()
	{
		char[] temp = new char[9];
		int count = 0;
		for(int i = 0; i < arrayColors.length; i++)
		{
			for(int j = 0; j < arrayColors[i].length; j++)
			{
				temp[count]=arrayColors[i][j];
				count++;
			}
		}
		return temp;
	}

	//returns an array that stores the corner pieces of the condensed linear array
	public char[] cornerPieces()
	{
		char[] cornerArray= new char[4];
		cornerArray[0] = arrayColors[0][0];
		cornerArray[1] = arrayColors[0][2];
		cornerArray[2] = arrayColors[2][0];
		cornerArray[3] = arrayColors[2][2];
		return cornerArray;
	}

	//returns an array that stores the side pieces of the condensed linear array
	public char[] sidePieces()
	{
		char[] sideArray= new char[4];
		sideArray[0] = arrayColors[0][1];
		sideArray[1] = arrayColors[1][0];
		sideArray[2] = arrayColors[1][2];
		sideArray[3] = arrayColors[2][1];
		return sideArray;
	}
	*  __________________NO CURRENT USE__________________
	*/
	
	//spins face 180 degrees
	public void spin180()
	{
		char[][] tempFace = new char[3][3];
		tempFace[1][1] = mainColor;
		tempFace[1][0] = arrayColors[1][2];
		tempFace[1][2] = arrayColors[1][0];
		for(int j = 0; j<3; j++)
		{
			tempFace[2][2-j]= arrayColors[0][j];
		}
		for(int j = 0; j<3; j++)
		{
			tempFace[0][2-j] = arrayColors[2][j];
		}
		setFace(tempFace);
	}
	
	//spins face anti-clockwise
	public void rotateAnti()
	{
		char[][] tempFace = new char[3][3];
		for(int i = 0; i < arrayColors.length; i++)
		{
			for(int j = 0; j < arrayColors[i].length; j++)
			{
				tempFace[2-j][i] = arrayColors[i][j];
			}
		}
		setFace(tempFace);
	}
	
	//spins face clockwise
	public void rotateClock()
	{
		char[][] tempFace = new char[3][3];
		for(int i = 0; i < arrayColors.length; i++)
		{
			for(int j = 0; j < arrayColors[i].length; j++)
			{
				if(i==0)
					tempFace[j][2] = arrayColors[i][j];
				else
					tempFace[j][i%2] = arrayColors[i][j];
			}
		}
		setFace(tempFace);
	}
	
	
	public static void main(String[] args)
	{
		char[][] array = new char[][] {
			      { 'W', 'Y', 'W'},
			      { 'R', 'G', 'Y'},
			      { 'B', 'Y', 'O'}
			    };
		CubeFace face = new CubeFace(array);
		System.out.println(face.toString());
		System.out.println(face.hasCross('a'));
	}
	
	//checks for equality amongst elements in array
	public static boolean sameElements(char[] array)
	{
		if(array.length==0)
			return true;
		char first = array[0];
		for(int i=1; i<array.length; i++)
		{
			if(array[i]!=first)
				return false;
		}
		return true;
	}
	
	//checks for equality amongst corner pieces
	public boolean sameCorners()
	{
		return (arrayColors[0][0]==arrayColors[0][2] && arrayColors[0][2]==arrayColors[2][0] && arrayColors[2][0]==arrayColors[2][2]);
		//return sameElements(cornerPieces());
	}

	//checks for equality amongst side pieces
	public boolean sameSides()
	{
		return (arrayColors[0][1]==arrayColors[1][0] && arrayColors[1][0]==arrayColors[1][2] && arrayColors[1][2]==arrayColors[2][1]);
		//return sameElements(sidePieces());
	}

	//checks for equality on one face
	public boolean sameFace()
	{
		return ((sameSides() && sameCorners()) && mainColor == arrayColors[1][1]);
		//return sameElements(linearFace());
	}

	//checks if face has identical colors in shape of a cross
	//EDIT: BROKEN
	public boolean hasCross(char targetColor)
	{
		return sameSides() && arrayColors[0][1]==targetColor;
	}
	
}
