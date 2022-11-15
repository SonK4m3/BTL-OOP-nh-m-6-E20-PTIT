package control;

import java.util.ArrayList;

import figure.*;
import player.*;

public class Computation {
	
	public Computation() {
		
	}

	public boolean isDirectionValid(Board board, ArrayList<Cell> update_direction) {
		for(Cell c : update_direction) {
			if(c.isValid() == false || board.matrix[c.getI()][c.getJ()].getValue() != 0) return false;
		}
		return true;
	}
	
	public String isAircraftCanBePlace(AirCraft airCraft, Board board) {
		int time = 1;
		int max_loop_time = 5;
		String direction = "";
		while(time < max_loop_time) {
			direction = airCraft.getFirstDirectionInDeque();	
			if(isDirectionValid(board, airCraft.getPartsCoor().get(direction)) == true) break;
			time++;
		}
		if(time == max_loop_time) return "";
		return direction;
			
	}
	
	public String placeAirCraft(int xMouse, int yMouse, Player P){
		
		Board board = P.getBoardOfPlayer();
		String direction = "";
		AirCraft airCraft1 = P.getAircraft(1);
		AirCraft airCraft2 = P.getAircraft(2);
		ArrayList<Cell> temp = new ArrayList<>();
		Cell pos_Click = board.convertPixcelToCell(xMouse, yMouse); // return cell
		
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
	
	public void resetAll(Player P) {
		for(Cell[] c : P.getBoardOfPlayer().getMatrix()) {
			for(Cell t : c) t.setValue(0);
		}
		P.getAircraft(1).updateOnBoard(false);
		P.getAircraft(2).updateOnBoard(false);
		P.getBoardOfPlayer().printMatrix();
		P.updatePlacedAircraft(0);
	}
	
	public String resetOneAircraft(int xMouse, int yMouse, Player P) {
		Board board = P.getBoardOfPlayer();
		Cell pos_Click = board.convertPixcelToCell(xMouse, yMouse);
		String notice = null;
		if(pos_Click.isValid()) {
			if(P.getAircraft(1).getHead().collide(pos_Click)) {
				P.getAircraft(1).updateOnBoard(false);
				board.deleteAircraft(P.getAircraft(1).getPartsCoor().get(P.getAircraft(1).getCurrentDirection()));
				P.updatePlacedAircraft(P.getPlacedAircraft()-1);
				notice = "remove AC 1";
			}
			else if(P.getAircraft(2).getHead().collide(pos_Click)) {
				P.getAircraft(2).updateOnBoard(false);
				board.deleteAircraft(P.getAircraft(2).getPartsCoor().get(P.getAircraft(2).getCurrentDirection()));
				P.updatePlacedAircraft(P.getPlacedAircraft()-1);
				notice = "remove AC 2";
			}
			board.printMatrix();
		}
		return notice;
	}
	
	public String shootAircraft(int xMouse, int yMouse, Player P) {
		String notify = "miss";
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
			else if(board.matrix[pos_Click.getI()][pos_Click.getJ()].getValue() == 1) {
				notify = "part";
				board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].setValue(0);
				board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].setPartState();;

			}
			else {
				board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].setMissState();
				notify = "miss";
			}
			board.getMatrix()[pos_Click.getI()][pos_Click.getJ()].updateShooted(true);
			P.setState(PlayerState.shooting);
		} else {
			return null;
		}
		return notify;
	}
	
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
