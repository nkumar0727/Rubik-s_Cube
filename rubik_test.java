import javax.swing.JOptionPane;
import java.util.*;

public class rubik_test
{
	public static void main(String[] args)
	{
		
		//CubeFace[] faces = new CubeFace[6];
		//String[] faceNames = {"Front", "Back", "Left", "Right", "Top", "Bottom"};
		//char[] colors = {'R', 'G', 'Y', 'B', 'W', 'O'};

		
		char[][] front = {{'B','G','R'},{'O','W','W'},{'O','R','G'}};
		char[][] back = {{'Y','O','G'},{'W','Y','W'},{'B','G','Y'}};
		char[][] right = {{'G','G','O'},{'R','R','B'},{'W','B','R'}};
		char[][] left = {{'W','O','R'},{'G','O','W'},{'B','Y','W'}};
		char[][] top = {{'O','Y','G'},{'B','B','O'},{'W','Y','Y'}};
		char[][] bottom = {{'B','B','R'},{'R','G','Y'},{'O','R','Y'}};
		
		RubikCube cube = new RubikCube(new CubeFace(front), new CubeFace(back), new CubeFace(left), new CubeFace(right), new CubeFace(top), new CubeFace(bottom));
		System.out.println("Current Cube: \n"+cube.toString());
		
		CubeSolver solver = new CubeSolver(cube);
		solver.topCross();
		solver.topCorners();
		
		System.out.println("Final Cube: \n"+cube.toString());
		/*
		//create new cube orientation
		for(int a = 0; a<faces.length; a++)
		{
			char[][] input = new char[3][3];
			for(int i = 0; i<input.length; i++)
			{
				for(int j = 0; j<input[i].length; j++)
				{
					char col = JOptionPane.showOptionDialog(null, "What color goes into position "+i+", "+j+"?", "Enter in CubeFace "+faceNames[a], JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, colors, colors[0]);
					input[i][j] = col;
				}
			}
			faces[a] = new CubeFace(input);
		}
		
		
		RubikCube cube = new RubikCube(faces[0], faces[1], faces[2], faces[3], faces[4], faces[5]);
		
		//RubikCube cube = new RubikCube(new CubeFace(front), new CubeFace(back), new CubeFace(left), new CubeFace(right), new CubeFace(top), new CubeFace(bottom));

		System.out.println("Current Cube: \n"+cube.toString());
		
		//cube.backInverted_Shift();
		//cube.getBack().rotateAnti();
		
		//System.out.println("New Cube (after 'left'): \n"+cube.toString());
		*/
		
		
	}
}