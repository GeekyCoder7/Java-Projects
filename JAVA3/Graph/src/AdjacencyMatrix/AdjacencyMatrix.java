package AdjacencyMatrix;

public class AdjacencyMatrix {
	private int[][] ax;

	
	public AdjacencyMatrix(int size) {
		ax= new int[size][size];
		for(int i =0;i<ax.length;i++) {
			for(int j=0; j<ax[0].length;j++) {
				ax[i][j]=Integer.MAX_VALUE;
			}
		}
	}
	
	public void deleteEdge(int i, int j) {
		ax[i][j]=Integer.MAX_VALUE;
		ax[j][i]=Integer.MAX_VALUE;
	}
	
	
	public void addEdges(int i, int j, int weight) {
		ax[i][j]=weight;
		ax[j][i]=weight;
	}
	
	public void addVertex() {
		int[][] temp = new int[ax.length+1][ax.length+1];
		for(int i =0;i<ax.length;i++) {
			for(int j=0; j<ax[0].length;j++) {
				temp[i][j]=ax[i][j];
			}
		}
		
		for(int i=0;i<ax[0].length;i++) {
			temp[ax.length-1][i]=Integer.MAX_VALUE;
		}
		ax=temp;
	}
	
	public void print() {
		for(int i =0;i<ax.length;i++) {
			for(int j=0; j<ax[0].length;j++) {
				System.out.print(ax[i][j] + " - ");
			}
			System.out.println();
		}
	}
	
	
	
	public void deleteVertex(int num) {
		int[][] temp = new int[ax.length-1][ax.length-1];
		for(int i =0;i<ax.length;i++) {
			for(int j=0; j<ax[0].length;j++) {
				if(j!=num&&i!=num) {
					temp[i][j]=ax[i][j];
				}
			}
		}
		ax=temp;
	}
	
	public int getDegree(int num) {
		int count =0;
		for(int i =0; i<ax.length;i++) {
			if(ax[num][i]!=Integer.MAX_VALUE) {
				count++;
			}
		}
		
		return count;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyMatrix am = new AdjacencyMatrix(4);
		am.addEdges(0,1,10);
		am.addEdges(0,2,20);
		am.addEdges(1,3,30);
		am.print();
		System.out.println("Degree of 0 is: "+am.getDegree(0));
	}

}
