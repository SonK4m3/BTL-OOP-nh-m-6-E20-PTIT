package control;

import java.util.ArrayList;

import figure.*;
import player.*;

public class Computation {
	
	public Computation() {
		
	}
	
	/*
	 * check direction is valid or not
	 */
	public boolean isDirectionValid(Board board, ArrayList<Cell> update_direction) {
		for(Cell c : update_direction) {
			// check cell is empty to place 
			if(c.isValid() == false || board.matrix[c.getI()][c.getJ()].getValue() != 0) return false;
		}
		return true;
	}
	/*
	 * check aircraft can place in this position of board
	 */
	public String isAircraftCanBePlace(AirCraft airCraft, Board board) {
		int time = 1;
		int max_loop_time = 5;
		String direction = "";
		// loop for all directions
		while(time < max_loop_time) {
			direction = airCraft.getFirstDirectionInDeque();	
			if(isDirectionValid(board, airCraft.getPartsCoor().get(direction)) == true) break;
			time++;
		}
		// no valid direction
		if(time == max_loop_time) return "";
		return direction;
	}
	
	/*
	 * place aircraft in position player choose
	 * return result to player
	 */
	public String placeAirCraft(int xMouse, int yMouse, Player P){
		//1. get player board to place aircraft
		Board board = P.getBoardOfPlayer();
		//2. initial valid direction of aircraft and aircrafts
		String direction = "";
		AirCraft airCraft1 = P.getAircraft(1);
		AirCraft airCraft2 = P.getAircraft(2);
		//3. template of aircraft to get valid directions
		ArrayList<Cell> temp = new ArrayList<>();
		//4. convert pixel position to cell position
		Cell pos_Click = board.convertPixcelToCell(xMouse, yMouse); // return cell
		//5. start check can place aircraft or rotate aircraft
		if(pos_Click.isValid() == true) {		//kiem tra toa do click co hop le khong
			
			if(!airCraft1.isOnBoard() && !airCraft2.isOnBoard()) {
				airCraft1.setPartsCoor(pos_Click);		//set toa do cho cac bo phan
				direction = isAircraftCanBePlace(airCraft1, board);	//kiem tra xem co dat duoc may bay khong
				if(direction == "") {			//neu khong dat duoc may bay
					return "can't place";
				}
				else{			//neu dat duoc may bay
					airCraft1.setCurrentDirection(direction);		//set huong hien tai cho may bay
					board.updateMatrix(airCraft1.getPartsCoor().get(direction));	//cap nhat ma tran
					airCraft1.updateOnBoard(true);			//set trang thai da xuat hien tren ma tran cua may bay
						
					OxyCoor headOxyCoor = airCraft1.convertCellToPixel(board.getX(), board.getY(), airCraft1.getHead());  //chuyen toa do trong ma tran sang toa do Oxy de in
					airCraft1.setOxyCoor(headOxyCoor.getX(), headOxyCoor.getY());		//set toa do Oxy cho may bay
						
					P.updatePlacedAircraft(P.getPlacedAircraft()+1);			//cap nhap so may bay da dat cho nguoi choi P
					board.printMatrix();			//in ma tran de kiem tra
					return "place AC 1";
				}
			}
			else if(airCraft1.isOnBoard() && !airCraft2.isOnBoard()) {				//neu may bay 2 khong o tren ma tran, kiem tra may bay 1 co o tren ma tran khong
				
				if(airCraft1.getHead().collide(pos_Click)) {			//neu click vao dau may bay 1 thi doi huong
//					System.out.println("collide airCraft1's head");
					
					temp = airCraft1.getPartsCoor().get(airCraft1.getCurrentDirection());  //lay ra huong hien tai cua may bay 1
					board.deleteAircraft(temp);	//xoa may bay khoi ma tran
					
					direction = isAircraftCanBePlace(airCraft1, board);
					if(direction == "") {
						
						return "can't place";
					} else {
						airCraft1.setCurrentDirection(direction);
						board.updateMatrix(airCraft1.getPartsCoor().get(direction));
						
						OxyCoor headOxyCoor = airCraft1.convertCellToPixel(board.getX(), board.getY(), airCraft1.getHead());
						airCraft1.setOxyCoor(headOxyCoor.getX(), headOxyCoor.getY());
					
						board.printMatrix();
						
						return "rotate AC 1";
					}
				}
				else if(pos_Click.getValue() == 0){
					System.out.println("place aircraft 2");
					airCraft2.setPartsCoor(pos_Click);		//set toa do cho cac bo phan
					direction = isAircraftCanBePlace(airCraft2, board);	//kiem tra xem co dat duoc may bay khong
					if(direction == "") {			//neu khong dat duoc may bay
						return "can't place";
					}
					else{			//neu dat duoc may bay
						airCraft2.setCurrentDirection(direction);		//set huong hien tai cho may bay
						board.updateMatrix(airCraft2.getPartsCoor().get(direction));	//cap nhat ma tran
						airCraft2.updateOnBoard(true);			//set trang thai da xuat hien tren ma tran cua may bay
							
						OxyCoor headOxyCoor = airCraft2.convertCellToPixel(board.getX(), board.getY(), airCraft2.getHead());  //chuyen toa do trong ma tran sang toa do Oxy de in
						airCraft2.setOxyCoor(headOxyCoor.getX(), headOxyCoor.getY());		//set toa do Oxy cho may bay
							
						P.updatePlacedAircraft(P.getPlacedAircraft()+1);			//cap nhap so may bay da dat cho nguoi choi P
						board.printMatrix();			//in ma tran de kiem tra
						return "place AC 2";
					}
				}
			}
			else if(!airCraft1.isOnBoard() && airCraft2.isOnBoard()) {
				if(airCraft2.getHead().collide(pos_Click)) {			//neu click vao dau may bay 2 thi doi huong
					temp = airCraft2.getPartsCoor().get(airCraft2.getCurrentDirection());  //lay ra huong hien tai cua may bay 2
					board.deleteAircraft(temp);	//xoa may bay khoi ma tran
					
					direction = isAircraftCanBePlace(airCraft2, board);
					if(direction == "") {
						return "can't place";
					} else {
						airCraft2.setCurrentDirection(direction);
						board.updateMatrix(airCraft2.getPartsCoor().get(direction));
						
						OxyCoor headOxyCoor = airCraft2.convertCellToPixel(board.getX(), board.getY(), airCraft2.getHead());
						airCraft2.setOxyCoor(headOxyCoor.getX(), headOxyCoor.getY());
					
						board.printMatrix();
						
						return "rotate AC 2";
					}
				}
				else if(pos_Click.getValue() == 0){
					airCraft1.setPartsCoor(pos_Click);		//set toa do cho cac bo phan
					direction = isAircraftCanBePlace(airCraft1, board);	//kiem tra xem co dat duoc may bay khong
					if(direction == "") {			//neu khong dat duoc may bay
						return "can't place";
					}
					else{			//neu dat duoc may bay
						airCraft1.setCurrentDirection(direction);		//set huong hien tai cho may bay
						board.updateMatrix(airCraft1.getPartsCoor().get(direction));	//cap nhat ma tran
						airCraft1.updateOnBoard(true);			//set trang thai da xuat hien tren ma tran cua may bay
							
						OxyCoor headOxyCoor = airCraft1.convertCellToPixel(board.getX(), board.getY(), airCraft1.getHead());  //chuyen toa do trong ma tran sang toa do Oxy de in
						airCraft1.setOxyCoor(headOxyCoor.getX(), headOxyCoor.getY());		//set toa do Oxy cho may bay
							
						P.updatePlacedAircraft(P.getPlacedAircraft()+1);			//cap nhap so may bay da dat cho nguoi choi P
						board.printMatrix();			//in ma tran de kiem tra
						return "place AC 1";
					}
				}
			}
			else if(airCraft1.isOnBoard() && airCraft2.isOnBoard()) {
				if(airCraft1.getHead().collide(pos_Click)) {			//neu click vao dau may bay 1 thi doi huong
					temp = airCraft1.getPartsCoor().get(airCraft1.getCurrentDirection());  //lay ra huong hien tai cua may bay 1
					board.deleteAircraft(temp);	//xoa may bay khoi ma tran
					
					direction = isAircraftCanBePlace(airCraft1, board);
					if(direction == "") {
						
						return "can't place";
					} else {
						airCraft1.setCurrentDirection(direction);
						board.updateMatrix(airCraft1.getPartsCoor().get(direction));
						
						OxyCoor headOxyCoor = airCraft1.convertCellToPixel(board.getX(), board.getY(), airCraft1.getHead());
						airCraft1.setOxyCoor(headOxyCoor.getX(), headOxyCoor.getY());
					
						board.printMatrix();
						
						return "rotate AC 1";
					}
				}
				else if(airCraft2.getHead().collide(pos_Click)) {			//neu click vao dau may bay 2 thi doi huong
					
					
					temp = airCraft2.getPartsCoor().get(airCraft2.getCurrentDirection());  //lay ra huong hien tai cua may bay 2
					board.deleteAircraft(temp);	//xoa may bay khoi ma tran
					
					direction = isAircraftCanBePlace(airCraft2, board);
					if(direction == "") {
						return "can't place";
					} else {
						airCraft2.setCurrentDirection(direction);
						board.updateMatrix(airCraft2.getPartsCoor().get(direction));
						
						OxyCoor headOxyCoor = airCraft2.convertCellToPixel(board.getX(), board.getY(), airCraft2.getHead());
						airCraft2.setOxyCoor(headOxyCoor.getX(), headOxyCoor.getY());
					
						board.printMatrix();
						
						return "rotate AC 2";
					}
				}
			}
		}
		System.out.println("cant place");
		return "can't place";
	}
	
	/*
	 * reset 2 aircrafts of player
	 */
	public void resetAll(Player P) {
		for(Cell[] c : P.getBoardOfPlayer().getMatrix()) {
			for(Cell t : c) t.setValue(0);
		}
		P.getAircraft(1).updateOnBoard(false);
		P.getAircraft(2).updateOnBoard(false);
		P.getBoardOfPlayer().printMatrix();
		P.updatePlacedAircraft(0);
	}
	/*
	 * reset aircraft to not placed
	 * return result to player
	 */
	public String resetOneAircraft(int xMouse, int yMouse, Player P) {
		//1. get player board to update value
		Board board = P.getBoardOfPlayer();
		//2. get cell is clicked
		Cell pos_Click = board.convertPixcelToCell(xMouse, yMouse);
		String notice = null;
		//3. if cell is valid 
		if(pos_Click.isValid()) {
			// check is head or not
			if(P.getAircraft(1).getHead().collide(pos_Click)) {
				// set aircraft is not on board
				P.getAircraft(1).updateOnBoard(false);
				// delete board value
				board.deleteAircraft(P.getAircraft(1).getPartsCoor().get(P.getAircraft(1).getCurrentDirection()));
				// decrease placed aircraft
				P.updatePlacedAircraft(P.getPlacedAircraft()-1);
				notice = "remove AC 1";
			}
			// do the same with aircraft 2
			else if(P.getAircraft(2).getHead().collide(pos_Click)) {
				P.getAircraft(2).updateOnBoard(false);
				board.deleteAircraft(P.getAircraft(2).getPartsCoor().get(P.getAircraft(2).getCurrentDirection()));
				P.updatePlacedAircraft(P.getPlacedAircraft()-1);
				notice = "remove AC 2";
			}
			// debug
//			board.printMatrix();
		}
		return notice;
	}
	
	/*
	 *  check cell is shot and return result to player
	 */
	public String shootAircraft(int xMouse, int yMouse, Player P) {
		String notify = "miss";
		// 1. get board of player is being shot
		Board board = P.getBoardOfPlayer();
		// 2. convert pixel position to cell position 
		Cell pos_Click = board.convertPixcelToCell(xMouse, yMouse);
		// 3. check cell is valid or not and is not shot
		if(pos_Click.isValid() && board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].isShooted() == false) {
			// if shot to head
			if(P.getAircraft(1).getHead().collide(pos_Click)) {
				notify = "head";
				AirCraft airCraft1 = P.getAircraft(1);
				String current_direction = airCraft1.getCurrentDirection();
				for(Cell c : airCraft1.getPartsCoor().get(current_direction)) {
					board.getMatrix()[c.getI()][c.getJ()].setValue(0);
				}
				board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].setHeadState();
				P.updateRemainAircraft(P.getRemainAircraft() - 1);
			}
			else if(P.getAircraft(2).getHead().collide(pos_Click)) {
				notify = "head";
				AirCraft airCraft2 = P.getAircraft(2);
				String current_direction = airCraft2.getCurrentDirection();
				for(Cell c : airCraft2.getPartsCoor().get(current_direction)) {
					board.getMatrix()[c.getI()][c.getJ()].setValue(0);
				}
				board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].setHeadState();
				P.updateRemainAircraft(P.getRemainAircraft() - 1);
			}
			// if shot to part
			else if(board.matrix[pos_Click.getI()][pos_Click.getJ()].getValue() == 1) {
				notify = "part";
				board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].setValue(0);
				board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].setPartState();;

			}
			// if shot miss
			else {
				board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].setMissState();
				notify = "miss";
			}
			// 4. update cell state
			board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].updateShooted(true);
			// 5. update player state to next turn
			P.setState(PlayerState.shooting);
		} else {
			return null;
		}
		return notify;
	}
	
	/*
	 * check game is finished or not
	 * and update player state win or lose
	 */
	public boolean gameFinished(Player P1, Player P2) {
		if(P1.getRemainAircraft() == 0) {
			P2.setState(PlayerState.win);
		} else if(P2.getRemainAircraft() == 0) {
			P1.setState(PlayerState.win);
		} else 
			return false;
		return true;
	}
}
