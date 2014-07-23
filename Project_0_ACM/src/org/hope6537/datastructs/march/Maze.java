package org.hope6537.datastructs.march;

/**
 * @Describe 迷宫问题
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-3-23下午07:24:54
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Maze {
	
	
	public static void main(String[] args) {
		MazeModel m = new MazeModel(4,0,0,3,3);
		int [][] array = m.getMaze();
		for(int i = 0 ; i<array.length ; i++){
			for(int j = 0 ; j<array.length ; j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("以上为迷宫概图");
		
		int x = m.getStart_x();
		int y = m.getStart_y();
		
		System.out.print("["+x+","+y+"]→");
		
		getWay(m,x,y);
		
		
	}
	
	public static void reachPoint(MazeModel m ,int x, int y){
		int [][] array = m.getMaze();
		array[x][y] = 1;
		System.out.println("现在的迷宫");
		for(int i = 0 ; i<array.length ; i++){
			for(int j = 0 ; j<array.length ; j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		
		m.setMaze(array);
		getWay(m,x,y);
	}
	
	
	public static boolean getWay(MazeModel m,int x ,int y){
		
		int [][] array = m.getMaze();
		
		boolean isFound = false;
		
		if(x==m.getEnd_x()&&y==m.getEnd_y()){
			System.out.println("迷宫通过");
			isFound = true;
			System.out.println("aaaaaaa");
		}
		
		else if(!isFound){
			
			
			
			boolean up = (y-1>0 && y-1<array.length) && array[x][y-1] != 1;
			boolean r_up = (x+1>0 && x+1<array.length && y-1>0 && y-1<array.length) && array[x+1][y-1] != 1;
			boolean r = (x+1>0 && x+1<array.length) && array[x+1][y] != 1;
			boolean r_down = (x+1>0 && x+1<array.length && y+1>0 && y+1<array.length) && array[x+1][y+1] != 1;
			boolean down = (y+1>0 && y+1<array.length) && array[x][y+1] != 1;
			boolean l_down = (x-1>0 && x-1<array.length && y+1>0 && y+1<array.length) && array[x-1][y+1] != 1;
			boolean l = (x-1>0 && x-1<array.length) && array[x-1][y] != 1;
			boolean l_up = (x-1>0 && x-1<array.length && y-1>0 && y-1<array.length) && array[x-1][y-1] != 1;
			
			//上
			if(up){
				// up = true;
				 y = y-1;
				 System.out.print("["+x+","+y+"]→");
				 reachPoint(m,x,y);
			}
			//右上
			if(r_up){
				y = y-1;
				x = x+1;
				//r_up=true;
				System.out.print("["+x+","+y+"]→");
				reachPoint(m,x,y);
			}
			//右
			if(r){
				//r=true;
				x = x+1;
				System.out.print("["+x+","+y+"]→");
				reachPoint(m,x,y);
			}
			//右下
			if(r_down){
				//r_down = true;
				y = y+1;
				x = x+1;
				System.out.print("["+x+","+y+"]→");
				reachPoint(m,x,y);
			}
			//下
			if(down){
				
				// down = true;
				 y = y+1;
				 System.out.print("["+x+","+y+"]→");
				 reachPoint(m,x,y);
			}
			//左下 
			if(l_down){
				//l_down=true;
				y = y+1;
				x = x-1;
				System.out.print("["+x+","+y+"]→");
				reachPoint(m,x,y);
			}
			//左
			if(l){
				//l=true;
				x = x-1;
				System.out.print("["+x+","+y+"]→");
				reachPoint(m,x,y);
			}
			//左上
			if(l_up){
				//l_up=true;
				y = y-1;
				x = x-1;
				System.out.print("["+x+","+y+"]→");
				reachPoint(m,x,y);
			}
		}
		return isFound;
	}
}

/**
 * @Describe 迷宫实例
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-3-23下午07:25:11
 * @version 0.9
 * @company Changchun University&SHXT
 */
class MazeModel{
	private int [][] maze;
	
	private int start_x = 0;
	private int start_y = 0;
	
	private int end_x;
	private int end_y;
	
	public MazeModel(int length, int start_x , int start_y , int end_x ,int end_y){
		if(!(end_x ==0 || end_x == length-1) && (end_y == 0 || end_y == length-1 )){
			throw new Error();
		}
		maze = new int [length][length];
		this.end_x = end_x;
		this.end_y = end_y;
		this.start_x = start_x;
		this.start_y = start_y;
		maze = initMaze(maze);
		maze[start_x][start_y] = 0;
		maze[end_x][end_y] = 0;
		
	}
	
	public MazeModel(int length, int end_x ,int end_y){
		if(end_x!=0 && end_y != 0){
			throw new Error();
		}
		maze = new int [length][length];
		this.end_x = end_x;
		this.end_y = end_y;
		this.start_x = 0;
		this.start_y = 0;
		maze = initMaze(maze);
		maze[start_x][start_y] = 0;
		maze[end_x][end_y] = 0;
		
	}
	
	private int[][] initMaze(int [][] m){
		 for(int i = 0 ; i < m.length ; i++){
			 for(int j = 0 ; j < m.length ; j++){
				  m[i][j] = ((int)(Math.random()*10)) > 4 ? 0 : 1;
			 }
		 }
		return m;
		 
	}
	
	public int[][] getMaze() {
		return maze;
	}

	public void setMaze(int[][] maze) {
		this.maze = maze;
	}
	public int getStart_x() {
		return start_x;
	}

	public void setStart_x(int startX) {
		start_x = startX;
	}

	public int getStart_y() {
		return start_y;
	}

	public void setStart_y(int startY) {
		start_y = startY;
	}

	public int getEnd_x() {
		return end_x;
	}

	public void setEnd_x(int endX) {
		end_x = endX;
	}

	public int getEnd_y() {
		return end_y;
	}

	public void setEnd_y(int endY) {
		end_y = endY;
	}


	
	
}
