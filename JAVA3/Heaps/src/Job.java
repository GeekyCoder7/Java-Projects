/*Name: Nazareth H. Keshishian
 *Student ID: 201701143
 *Date Last Modified: 18/10/2018
 *Associated files: Heap.java. 
 * Program Description: Heap.
 */

public class Job {
private String owner;
public int length;
	public Job(String owner,int length) {
		// TODO Auto-generated constructor stub
		this.length=length;
		this.owner=owner;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String toString() {
		return "Job owner: "+owner+", job length: "+length+"\n";
	}
	

}
