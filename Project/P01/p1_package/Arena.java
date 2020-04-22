/** Nopparat Pengsuk
 *  6288103 Sec 2
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Arena {

	public enum Row {Front, Back};	//enum for specifying the front or back row
	public enum Team {A, B};		//enum for specifying team A or B
	
	private Player[][] teamA = null;	//two dimensional array representing the players of Team A
	private Player[][] teamB = null;	//two dimensional array representing the players of Team B
	private int numRowPlayers = 0;		//number of players in each row
	
	public static final int MAXROUNDS = 100;	//Max number of turn
	public static final int MAXEACHTYPE = 3;	//Max number of players of each type, in each team.
	private final Path logFile = Paths.get("battle_log.txt");
	
	private int numRounds = 1;	//keep track of the number of rounds so far
	
	/**
	 * Constructor. 
	 * @param _numRowPlayers is the number of players in each row.
	 */
	public Arena(int _numRowPlayers)
	{	
		//INSERT YOUR CODE HERE
		this.numRowPlayers = _numRowPlayers;
		teamA = new Player[2][_numRowPlayers];
		teamB = new Player[2][_numRowPlayers];
		
		
		////Keep this block of code. You need it for initialize the log file. 
		////(You will learn how to deal with files later)
		try {
			Files.deleteIfExists(logFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////
		
	}
	
	/**
	 * Returns true if "player" is a member of "team", false otherwise.
	 * Assumption: team can be either Team.A or Team.B
	 * @param player
	 * @param team
	 * @return
	 */
	public boolean isMemberOf(Player player, Team team)
	{
		//INSERT YOUR CODE HERE
		if(team == Team.A ) {
			for(int i=0; i<2;i++) {
				for(int j=0;j<numRowPlayers;j++) {
					if(teamA[i][j].getType().equals(player.getType())) {
						return true;
					}
				}
			}
		}
		else if(team == Team.B ) {
			for(int i=0; i<2;i++) {
				for(int j=0;j<numRowPlayers;j++) {
					if(teamB[i][j].getType().equals(player.getType())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	
	/**
	 * This methods receives a player configuration (i.e., team, type, row, and position), 
	 * creates a new player instance, and places him at the specified position.
	 * @param team is either Team.A or Team.B
	 * @param pType is one of the Player.Type  {Healer, Tank, Samurai, BlackMage, Phoenix}
	 * @param row	either Row.Front or Row.Back
	 * @param position is the position of the player in the row. Note that position starts from 1, 2, 3....
	 */
	public void addPlayer(Team team, Player.PlayerType pType, Row row, int position)
	{	
		//INSERT YOUR CODE HERE
		switch (team) {
			case A:
				switch (row) {
					case Front:
						teamA[0][position-1] = new Player(pType);
						teamA[0][position-1].setTeamRowPosition(team, row, position);
						break;
					case Back:
						teamA[1][position-1] = new Player(pType);
						teamA[1][position-1].setTeamRowPosition(team, row, position);
						break;
					default:
						break;
				}
			break;
			
			case B:
				switch (row) {
					case Front:
						teamB[0][position-1] = new Player(pType);
						teamB[0][position-1].setTeamRowPosition(team, row, position);
						break;
					case Back:
						teamB[1][position-1] = new Player(pType);
						teamB[1][position-1].setTeamRowPosition(team, row, position);
						break;
					default:
						break;
				}

			break;
			
			default:
				break;
		}
	}
	
	
	/**
	 * Validate the players in both Team A and B. Returns true if all of the following conditions hold:
	 * 
	 * 1. All the positions are filled. That is, there each team must have exactly numRow*numRowPlayers players.
	 * 2. There can be at most MAXEACHTYPE players of each type in each team. For example, if MAXEACHTYPE = 3
	 * then each team can have at most 3 Healers, 3 Tanks, 3 Samurais, 3 BlackMages, and 3 Phoenixes.
	 * 
	 * Returns true if all the conditions above are satisfied, false otherwise.
	 * @return
	 */
	public boolean validatePlayers()
	{
		//INSERT YOUR CODE HERE
		int[] checkValidA = {0,0,0,0,0,0};
		int[] checkValidB = {0,0,0,0,0,0};
		for (int i = 0; i < teamA.length; i++) {
			for (int j = 0; j < teamA[i].length; j++) {
				switch (teamA[i][j].getType()) {
					case Samurai:	checkValidA[0] += 1;break;
					case Phoenix:	checkValidA[1] += 1;break;
					case Cherry: 	checkValidA[2] += 1;break;
					case Tank: 		checkValidA[3] += 1;break;
					case Healer:	checkValidA[4] += 1;break;
					case BlackMage: checkValidA[5] += 1;break;
					default: break;
				}
			}
		}
		for (int i : checkValidA) {if(i>MAXEACHTYPE) return false;}
		for (int i = 0; i < teamB.length; i++) {
			for (int j = 0; j < teamB[i].length; j++) {
				switch (teamB[i][j].getType()) {
					case Samurai:	checkValidB[0] += 1;break;
					case Phoenix:	checkValidB[1] += 1;break;
					case Cherry: 	checkValidB[2] += 1;break;
					case Tank: 		checkValidB[3] += 1;break;
					case Healer:	checkValidB[4] += 1;break;
					case BlackMage: checkValidB[5] += 1;break;
					default: break;
				}
			}
		}
		for (int i : checkValidB) {if(i>MAXEACHTYPE) return false;}
		
		return true;
	}
	
	
	/**
	 * Returns the sum of HP of all the players in the given "team"
	 * @param team
	 * @return
	 */
	public static double getSumHP(Player[][] team)
	{
		//INSERT YOUR CODE HERE
		double hp = 0 ;
			for (int i = 0; i < team.length; i++) {for (int j = 0; j < team[i].length; j++) {hp += team[i][j].getCurrentHP();}}
		return hp;
	}
	
	/**
	 * Return the team (either teamA or teamB) whose number of alive players is higher than the other. 
	 * 
	 * If the two teams have an equal number of alive players, then the team whose sum of HP of all the
	 * players is higher is returned.
	 * 
	 * If the sums of HP of all the players of both teams are equal, return teamA.
	 * @return
	 */
	public Player[][] getWinningTeam()
	{
		//INSERT YOUR CODE HERE	

		int A=0,B=0;
		// count number of player alive in each team.
		for(int i = 0 ; i < 2 ;i++) {for(int j = 0 ; j < numRowPlayers ; j++) {if(teamA[i][j].isAlive()) {A++;}if(teamB[i][j].isAlive()) {B++;}}}
		
		if(A==B) {									//if number of hero in a and b is equal.
			if(getSumHP(teamA)>getSumHP(teamB)||getSumHP(teamA)==getSumHP(teamB)) {	//if hp of team A more than hp of B or hp of team A and B is equal. team A wins else team B wins.
				System.out.println("@@@ Team A won.");
				return teamA;
			}else									
				System.out.println("@@@ Team B won.");
				return teamB;
		}else if(A>B) {								//if number of hero in a more than b means team A wins.
			System.out.println("@@@ Team A won.");
			return teamA;
		}else										//else team B wins.
			System.out.println("@@@ Team B won.");
			return teamB;
		
	}
	
	/**
	 * This method simulates the battle between teamA and teamB. The method should have a loop that signifies
	 * a round of the battle. In each round, each player in teamA invokes the method takeAction(). The players'
	 * turns are ordered by its position in the team. Once all the players in teamA have invoked takeAction(),
	 * not it is teamB's turn to do the same. 
	 * 
	 * The battle terminates if one of the following two conditions is met:
	 * 
	 * 1. All the players in a team has been eliminated.
	 * 2. The number of rounds exceeds MAXROUNDS
	 * 
	 * After the battle terminates, report the winning team, which is determined by getWinningTeam().
	 */
	public void startBattle()
	{
		//INSERT YOUR CODE HERE
		while(numRounds <= MAXROUNDS && getSumHP(teamA) > 0 && getSumHP(teamB) > 0 ){
			System.out.println("@ Round " + (numRounds));
			//team A takeaction 
			for (int i = 0; i < teamA.length; i++) {for (int j = 0; j < numRowPlayers; j++) {if(teamA[i][j].isAlive()){teamA[i][j].takeAction(this);}}}
			//team B take action
			for (int i = 0; i < teamB.length; i++) {for (int j = 0; j < numRowPlayers; j++) {if(teamB[i][j].isAlive()){teamB[i][j].takeAction(this);}}}
			//add HP into battle log file and display and increase number of rounds.
			logAfterEachRound();displayArea(this, true);numRounds ++;
		}
		getWinningTeam();

	}
	
	
	
	/**
	 * This method displays the current area state, and is already implemented for you.
	 * In startBattle(), you should call this method once before the battle starts, and 
	 * after each round ends. 
	 * 
	 * @param arena
	 * @param verbose
	 */
	public static void displayArea(Arena arena, boolean verbose)
	{
		StringBuilder str = new StringBuilder();
		if(verbose)
		{
			str.append(String.format("%43s   %40s","Team A","")+"\t\t"+String.format("%-38s%-40s","","Team B")+"\n");
			str.append(String.format("%43s","BACK ROW")+String.format("%43s","FRONT ROW")+"  |  "+String.format("%-43s","FRONT ROW")+"\t"+String.format("%-43s","BACK ROW")+"\n");
			for(int i = 0; i < arena.numRowPlayers; i++)
			{
				str.append(String.format("%43s",arena.teamA[1][i])+String.format("%43s",arena.teamA[0][i])+"  |  "+String.format("%-43s",arena.teamB[0][i])+String.format("%-43s",arena.teamB[1][i])+"\n");
			}
		}
	
		str.append("@ Total HP of Team A = "+getSumHP(arena.teamA)+". @ Total HP of Team B = "+getSumHP(arena.teamB)+"\n\n");
		System.out.print(str.toString());
		
		
	}
	
	/**
	 * This method writes a log (as round number, sum of HP of teamA, and sum of HP of teamB) into the log file.
	 * You are not to modify this method, however, this method must be call by startBattle() after each round.
	 * 
	 * The output file will be tested against the auto-grader, so make sure the output look something like:
	 * 
	 * 1	47415.0	49923.0
	 * 2	44977.0	46990.0
	 * 3	42092.0	43525.0
	 * 4	44408.0	43210.0
	 * 
	 * Where the numbers of the first, second, and third columns specify round numbers, sum of HP of teamA, and sum of HP of teamB respectively. 
	 */
	private void logAfterEachRound()
	{
		try {
			Files.write(logFile, Arrays.asList(new String[]{numRounds+"\t"+getSumHP(teamA)+"\t"+getSumHP(teamB)}), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * this method is use to sent team
	 * @param a
	 * @return
	 */
	public Player[][] getTeam(Team a) {
		if(a.equals(Team.A))	return teamA;
			else if(a.equals(Team.B))	return teamB;
				else return null; //something worng.
	}
	
}
