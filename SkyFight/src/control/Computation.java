package control;

import java.util.ArrayDeque;
import java.util.ArrayList;

import figure.*;
import player.Player;

public class Computation {
	
	public Computation() {
		
	}
	public ArrayDeque<String> whichCanRotatable(Board board, AirCraft airCraft, Cell head) {
		ArrayDeque<String> origin_valid_direction = new ArrayDeque<>();
		/*	North direction
		 * head     *
		 * left   1===    right
		 *  	  2 =
		 *  	  3===
		 */
		boolean valid = true;
		ArrayList<Cell> North = airCraft.getPartsCoor().get("North");
		for(Cell c : North) {
			if(c.isValid() == false || board.matrix[c.getI()][c.getJ()].getValue() != 0) {
				valid = false;
				break;
			}
		}
		if(valid == true) origin_valid_direction.addLast("North");
		/* East direction
		 * 		    = =
		 * 			===*
		 * 			= =
		 */
		valid = true;
		ArrayList<Cell> East = airCraft.getPartsCoor().get("East");
		for(Cell c : East) {
			if(c.isValid() == false || board.matrix[c.getI()][c.getJ()].getValue() != 0) {
				valid = false;
				break;
			}
		}
		if(valid == true) origin_valid_direction.addLast("East");
		/*	South direction
		 *     ===
		 *  	=
		 *     ===
		 *     	*
		 */
		valid = true;
		ArrayList<Cell> South = airCraft.getPartsCoor().get("South");
		for(Cell c : South) {
			if(c.isValid() == false || board.matrix[c.getI()][c.getJ()].getValue() != 0) {
				valid = false;
				break;
			}
		}
		if(valid == true) origin_valid_direction.addLast("South");
		/* West direction
		 * 		     = =
		 * 			*===
		 * 			 = =
		 */
		valid = true;
		ArrayList<Cell> West = airCraft.getPartsCoor().get("West");
		for(Cell c : West) {
			if(c.isValid() == false || board.matrix[c.getI()][c.getJ()].getValue() != 0) {
				valid = false;
				break;
			}
		}
		if(valid == true) origin_valid_direction.addLast("West");
		 
		return origin_valid_direction;
	}
	
	public boolean isDirectionValid(Board board, ArrayList<Cell> update_direction) {
		for(Cell c : update_direction) {
			if(c.isValid() == false || board.matrix[c.getI()][c.getJ()].getValue() != 0) return false;
		}
		return true;
	}
	
	public AirCraft placeAirCraft(int xMouse, int yMouse, Player P){
		
		Board board = P.getBoardOfPlayer();
		AirCraft airCraft = new AirCraft(-1, -1);
		String direction = "";
		AirCraft airCraft1 = P.getAircraft(1);
		AirCraft airCraft2 = P.getAircraft(2);
		ArrayList<Cell> temp = new ArrayList<>();
		Cell pos_Click = board.convertPixcelToCell(xMouse, yMouse); // return cell
		
		if(pos_Click.isValid() == true) {		//kiem tra toa do click co hop le khong
			if(airCraft1.isOnBoard()) {				//neu may bay 2 khong o tren ma tran, kiem tra may bay 1 co o tren ma tran khong
				if(airCraft1.getHead().collide(pos_Click)) {			//neu click vao dau may bay 1 thi doi huong
					
					temp = airCraft1.getPartsCoor().get(airCraft1.getCurrentDirection());  //lay ra huong hien tai cua may bay 1
					board.reDirectAircraft(temp);	//xoa may bay khoi ma tran
					int time = 1;
					int origin_valid_direction_size = airCraft1.origin_valid_direction.size();
					System.out.println(airCraft1.origin_valid_direction);
					while(time < origin_valid_direction_size) {
						direction = airCraft1.getFirstValidDirection();		//lay ra huong tiep theo
						if(isDirectionValid(board, airCraft1.getPartsCoor().get(direction)) == true) break;
						time++;
						
					}
					if(time == origin_valid_direction_size) {
						System.out.println("No valid Direction");
						board.updateMatrix(temp);
					}
					else{
						airCraft1.setCurrentDirection(direction);
						board.updateMatrix(airCraft1.getPartsCoor().get(direction));
						
					}
					board.printMatrix();
					OxyCoor headOxyCoor = airCraft1.convertCellToPixel(board.getX(), board.getY(), airCraft1.getHead());
					airCraft1.setPos(headOxyCoor.getX(), headOxyCoor.getY());
					
					return airCraft1;
				
				}
				else if(airCraft2.isOnBoard()) {			//neu click vao dau may bay 2 thi doi huong
					
					if(airCraft2.getHead().collide(pos_Click)) {
						
						temp = airCraft2.getPartsCoor().get(airCraft2.getCurrentDirection());    //lay ra huong hien tai cua may bay 2
						board.reDirectAircraft(temp);					//xoa may bay 2 tren ma tran
						int time = 1;
						int origin_valid_direction_size = airCraft2.origin_valid_direction.size();
						while(time < origin_valid_direction_size) {
							direction = airCraft2.getFirstValidDirection();		//lay ra huong tiep theo
							if(isDirectionValid(board, airCraft2.getPartsCoor().get(direction)) == true) break;
							time++;
						}
						if(time == origin_valid_direction_size) {
							System.out.println("No valid Direction");
							board.updateMatrix(temp);
						}
						else {
							airCraft2.setCurrentDirection(direction);
							board.updateMatrix(airCraft2.getPartsCoor().get(direction));  //cap nhat ma tran da co may bay 2
						}
						OxyCoor headOxyCoor = airCraft2.convertCellToPixel(board.getX(), board.getY(), airCraft2.getHead());
						airCraft2.setPos(headOxyCoor.getX(), headOxyCoor.getY());
						board.printMatrix();
						return airCraft2;
					}
					
				}
				else {
					System.out.println("place aircraft2");
					airCraft2.setPartsCoor(pos_Click);
					if(whichCanRotatable(board, airCraft2, pos_Click).isEmpty() == true) {
						System.out.println("Can't place here!");
						return null;
					}
					airCraft2.setAllValidDirection(whichCanRotatable(board, airCraft2, pos_Click));
					System.out.println(airCraft2.origin_valid_direction);
					direction = airCraft2.getFirstValidDirection();
					airCraft2.setCurrentDirection(direction);
					board.updateMatrix(airCraft2.getPartsCoor().get(direction));
					airCraft2.updateOnBoard(true);
					OxyCoor headOxyCoor = airCraft2.convertCellToPixel(board.getX(), board.getY(), airCraft2.getHead());
					airCraft2.setPos(headOxyCoor.getX(), headOxyCoor.getY());
					board.printMatrix();
					P.updatePlacedAircraft(P.getPlacedAircraft()+1);
					return airCraft2;
				}
			} 
			else {
				
				airCraft1.setPartsCoor(pos_Click);
					
				if(whichCanRotatable(board, airCraft1, pos_Click).isEmpty() == true) {
					System.out.println("Can't place here!");
					return null;
				}
				airCraft1.setAllValidDirection(whichCanRotatable(board, airCraft1, pos_Click));
				direction = airCraft1.getFirstValidDirection();
				airCraft1.setCurrentDirection(direction);
					airCraft1.updateOnBoard(true);
				board.updateMatrix(airCraft1.getPartsCoor().get(direction));
				
				OxyCoor headOxyCoor = airCraft1.convertCellToPixel(board.getX(), board.getY(), airCraft1.getHead());
				airCraft1.setPos(headOxyCoor.getX(), headOxyCoor.getY());
				
				board.printMatrix();
				P.updatePlacedAircraft(P.getPlacedAircraft()+1);
				return airCraft1;
			}
		}
		return null;
	}
	
	public void resetAll(Player P) {
		for(Cell[] c : P.getBoardOfPlayer().getMatrix()) {
			for(Cell t : c) t.setValue(0);
		}
		P.getAircraft(1).updateOnBoard(false);
		P.getAircraft(2).updateOnBoard(false);
		P.getBoardOfPlayer().printMatrix();
		P.updatePlacedAircraft(0);
	}
	
	public void resetOneAircraft(int xMouse, int yMouse, Player P) {
		Board board = P.getBoardOfPlayer();
		Cell pos_Click = board.convertPixcelToCell(xMouse, yMouse);
		if(pos_Click.isValid()) {
			if(P.getAircraft(1).getHead().collide(pos_Click)) {
				P.getAircraft(1).updateOnBoard(false);
				board.reDirectAircraft(P.getAircraft(1).getPartsCoor().get(P.getAircraft(1).getCurrentDirection()));
			}
			else if(P.getAircraft(2).getHead().collide(pos_Click)) {
				P.getAircraft(2).updateOnBoard(false);
				board.reDirectAircraft(P.getAircraft(2).getPartsCoor().get(P.getAircraft(2).getCurrentDirection()));
			}
		}
		board.printMatrix();
		P.updatePlacedAircraft(P.getPlacedAircraft()-1);
	}
	
	public String shootAircraft(int xMouse, int yMouse, Player P) {
		String notify = "";
		Board board = P.getBoardOfPlayer();
		Cell pos_Click = board.convertPixcelToCell(xMouse, yMouse);
		if(pos_Click.isValid() && board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].isShooted() == false) {
			if(P.getAircraft(1).getHead().collide(pos_Click)) {
				notify = "head";
				AirCraft airCraft1 = P.getAircraft(1);
				String current_direction = airCraft1.getCurrentDirection();
				for(Cell c : airCraft1.getPartsCoor().get(current_direction)) {
					board.getMatrix()[c.getI()][c.getJ()].setValue(0);
				}
				
			}
			else if(P.getAircraft(2).getHead().collide(pos_Click)) {
				notify = "head";
				AirCraft airCraft2 = P.getAircraft(2);
				String current_direction = airCraft2.getCurrentDirection();
				for(Cell c : airCraft2.getPartsCoor().get(current_direction)) {
					board.getMatrix()[c.getI()][c.getJ()].setValue(0);
				}
			}
			else if(board.matrix[pos_Click.getI()][pos_Click.getJ()].getValue() == 2) {
				notify = "parts";
				board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].setValue(0);
			}
			else notify = "miss";
			board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].updateShooted(true);
		}
		return notify;
	}
	public boolean gameFinished(Player P1, Player P2) {
		if(P1.getRemainAircraft() == 0 || P2.getRemainAircraft() == 0) return true;
		return false;
	}
}
