import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem2 {
	
	public static void main(String...args){
		ArrayList<Problem2_PointClass> pointsOfTriangle=new ArrayList<>();
		Problem2_PointClass pointToAssesPositionOf = null;
		int countOfPoints=0;
		int a,b;
		int yMaxOfTriangle=-30000;
		int yMinOfTriangle=36000;
		int xMaxOfTriangle=-30000;
		int xMinOfTriangle=36000;
		
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter each pair "
				+ "of coordinates.Each point has an x and and y as (x,y)."
				+ "Insert the three points");
		while(countOfPoints!=3){
			try{
		a=Integer.parseInt(reader.readLine());
		b=Integer.parseInt(reader.readLine());
		pointsOfTriangle.add(new Problem2_PointClass(a,b));
		countOfPoints++;
		}
			catch(Exception e){
				e.printStackTrace();
			}
		
		
	}
		for(Problem2_PointClass point: pointsOfTriangle){
			System.out.println("("+point.getXCoordinate()+","+point.getYCoordinate()+")");
		}
		System.out.println("Now enter the coordinates for the point whose position must be assesed");
		try {
			a=Integer.parseInt(reader.readLine());
			b=Integer.parseInt(reader.readLine());
			pointToAssesPositionOf=new Problem2_PointClass(a,b);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Point to asses position of is "+ pointToAssesPositionOf.getXCoordinate() +","+ pointToAssesPositionOf.getYCoordinate());
		
		for(Problem2_PointClass point:pointsOfTriangle){
			if(point.getYCoordinate()>yMaxOfTriangle){
				yMaxOfTriangle=point.getYCoordinate();
			}
			if(point.getYCoordinate()<yMinOfTriangle){
				yMinOfTriangle=point.getYCoordinate();
			}
			if(point.getXCoordinate()>xMaxOfTriangle){
				xMaxOfTriangle=point.getXCoordinate();
			}
			if(point.getXCoordinate()<xMinOfTriangle){
				xMinOfTriangle=point.getXCoordinate();
			}
		}
		System.out.println(yMaxOfTriangle);
		System.out.println(yMinOfTriangle);
		System.out.println(xMaxOfTriangle);
		System.out.println(xMinOfTriangle);
		
		if(pointToAssesPositionOf.getXCoordinate()>xMaxOfTriangle){
			
			System.out.println("Right");
		}
		else if(pointToAssesPositionOf.getXCoordinate()<xMinOfTriangle){
			
			System.out.println("Left");
		}
		if(pointToAssesPositionOf.getYCoordinate()>yMaxOfTriangle){
			
			System.out.println("Above");
		}
		else if(pointToAssesPositionOf.getYCoordinate()<yMinOfTriangle){
			
			System.out.println("Below");
		}
		
	}
}


