/** Nopparat Pengsuk
 *  6288103 Sec 2
 */
import java.util.Arrays;


public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	
	private PlayerType type; 	//Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
	private double maxHP;		//Max HP of this player
	private double currentHP;	//Current HP of this player 
	private double atk;			//Attack power of this player
	
	private int speacialturn;	//soecialturn for hero 3,4,5,8
	private int count;			//count speacialturn 

	public Arena.Team team; 	//team A or team B
	public Arena.Row row;		//front ot back
	public int position;		//position of each heros
	
	
	private boolean sleeping;  	//hero got status sleeping or not
	private boolean curse;		//hero got cursed or not
	private boolean taunt;		//hero got taunting or nor
	
	private Player targetCurses = null; // if target got cursed use this player.
	
	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	public Player(PlayerType _type)
	{	
		//INSERT YOUR CODE HERE
		switch (_type) {
			case Samurai:
				this.type = _type;
				this.currentHP = this.maxHP = 4005;
				this.atk = 368;
				this.speacialturn = 3;

				break;
			case Healer:
				this.type = _type;
				this.currentHP = this.maxHP = 4790;
				this.atk = 238; 
				this.speacialturn = 4;

				break;
			case Tank:
				this.type = _type;
				this.currentHP = this.maxHP = 5340;
				this.atk = 255;
				this.speacialturn = 4;

				break;
			case BlackMage:
				this.type = _type;
				this.currentHP = this.maxHP = 4175;
				this.atk = 303;
				this.speacialturn = 4;

				break;
			case Phoenix:
				this.type = _type;
				this.currentHP = this.maxHP = 4175;
				this.atk = 209;
				this.speacialturn = 8;

				break;
			case Cherry:
				this.type = _type;
				this.currentHP = this.maxHP = 3560;
				this.atk = 198;
				this.speacialturn = 4;

				break;
			default:
				break;
		}
		this.count = 0;
	}
	/**  this method use to set team,row, and position to use in Player class.
	*/
	public void setTeamRowPosition(Arena.Team team, Arena.Row row, int position ) {
			this.team = team;
			this.row = row;
			this.position = position;
	}
	/**
	 * Returns the current HP of this player
	 * @return
	 */
	public double getCurrentHP()
	{
		//INSERT YOUR CODE HERE
		return this.currentHP;
	}
	
	/**
	 * Returns type of this player
	 * @return
	 */
	public Player.PlayerType getType()
	{
		//INSERT YOUR CODE HERE
		return this.type;
	}
	
	/**
	 * Returns max HP of this player. 
	 * @return
	 */
	public double getMaxHP()
	{
		//INSERT YOUR CODE HERE
		
		return this.maxHP;
	}
	
	/**
	 * Returns whether this player is sleeping.
	 * @return
	 */
	public boolean isSleeping()
	{
		//INSERT YOUR CODE HERE
		
		return false;
	}
	
	/**
	 * Returns whether this player is being cursed.
	 * @return
	 */
	public boolean isCursed()
	{
		//INSERT YOUR CODE HERE
		
		return this.curse;
	}
	
	/**
	 * Returns whether this player is taunting the other team.
	 * @return
	 */
	public boolean isTaunting()
	{
		//INSERT YOUR CODE HERE
		return this.taunt;
	}
	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * @return
	 */
	public boolean isAlive()
	{
		//INSERT YOUR CODE HERE
		if(this.currentHP <= 0.0){return false;}	
		else return true;
	}
	
	
	
	public void attack(Player target)
	{	
		//INSERT YOUR CODE HERE
		
		try {							// if target is null, it's gonna print caught null ( Just wanna try nothing else )
			if(target.equals(null)){}
		} catch (NullPointerException e) {
			System.out.println("Caught Null Exception in attack ");
		}
			if(!target.equals(null)){target.currentHP -= this.atk;}
			if(target.currentHP < 0.0){ // means hero dead so reset all things.
				target.currentHP = target.count = 0;
				target.sleeping = target.curse = target.taunt = false;
			}
		
	}
	
	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam)
	{	
		//INSERT YOUR CODE HERE
		Player target = null;
		switch (this.type) {
			case Samurai:
				target = findTarget(theirTeam);
				if(target != null){
					attack(target); attack(target); // double slash
					System.out.println("# "+this.showdata()+"Double-Slashes "+ target.showdata());
				}
				break;
			case Tank:
				this.taunt = true;
				System.out.println("# "+this.showdata()+"is Taunting");
				break;
			case Healer:							// healer heals 25%
				target = findTargetBypencent(myTeam); 
				if(target.isAlive() && !target.isCursed() && target.currentHP < target.maxHP){
					target.hpIncrease(target, 0.25);
					System.out.println("# "+this.showdata()+"Heals "+target.showdata());
				}
				break;
			case BlackMage:
				target = findTarget(theirTeam);
				if(target != null && target.isAlive()){
					this.targetCurses = target; this.targetCurses.curse = true;
					System.out.println("# "+this.showdata()+"Curses "+target.showdata());
				}
				break;
			case Phoenix:
				target = findAlly(myTeam);
				if(target != null){
					target.hpIncrease(target, 0.30); // Phoenix revives hp 30%
					target.sleeping = target.curse = target.taunt = false; target.count = 0; // reset target to brand new hero.
					System.out.println("# "+this.showdata()+"Revives "+target.showdata());
				}
				break;
			case Cherry:
				for(int i=0;i<2;i++) {
					for(int j=0;j<theirTeam[0].length;j++) {
						if(theirTeam[i][j].isAlive()) {
							theirTeam[i][j].sleeping = true;	//set status to be sleep. to do nothing.
							System.out.println("# "+this.showdata() + "Feeds a Fortune Cookie to " + theirTeam[i][j].showdata());
						}
					}
				}
				break;
			default:
				break;
		}

	}

	

	

	/**
	 * This method is called by Arena when it is this player's turn to take an
	 * action. By default, the player simply just "attack(target)". However, once
	 * this player has fought for "numSpecialTurns" rounds, this player must perform
	 * "useSpecialAbility(myTeam, theirTeam)" where each player type performs his
	 * own special move.
	 * 
	 * @param arena
	 */
	public void takeAction(Arena arena)
	{	
		//INSERT YOUR CODE HERE
		Player target = null;
		if(this.type.equals(PlayerType.Tank)) this.taunt = false;
		if(this.type.equals(PlayerType.BlackMage) && this.targetCurses != null) this.targetCurses.curse = false;
		//if sleeping is false, do the action.
		if(this.sleeping == false){
			this.count += 1;						//increase turn of special ability.
			switch (this.team) {
				case A:
					if(this.type.equals(PlayerType.Cherry)) { //cherry things
						for(int i=0;i<2;i++) {
							for(int j=0;j<arena.getTeam(Arena.Team.B)[i].length;j++) {
								if(arena.getTeam(Arena.Team.B)[i][j].isAlive()) {
								arena.getTeam(Arena.Team.B)[i][j].sleeping = false; //set status to default
								}
							}
						}
					}
						if(count == speacialturn){
							useSpecialAbility(arena.getTeam(Arena.Team.A), arena.getTeam(Arena.Team.B));
							this.count = 0;
							}else{
								target = findTarget(arena.getTeam(Arena.Team.B));		//find the target to normal attack.
								if(target != null){
									attack(target);
									System.out.println("# "+this.showdata()+"Attacks "+target.showdata());
								}
							}

				
				break;
				case B:
					if(this.type.equals(PlayerType.Cherry)) { //cherry things
						for(int i=0;i<2;i++) {
							for(int j=0;j<arena.getTeam(Arena.Team.A)[i].length;j++) {
								if(arena.getTeam(Arena.Team.A)[i][j].isAlive()) {
								arena.getTeam(Arena.Team.A)[i][j].sleeping = false; //set status to default
								}
							}
						}
					}
					
						if(count == speacialturn){
							useSpecialAbility(arena.getTeam(Arena.Team.B), arena.getTeam(Arena.Team.A));
							this.count = 0;
							}else{
								target = findTarget(arena.getTeam(Arena.Team.A));
									if(target != null){
									attack(target);
									System.out.println("# "+this.showdata()+"Attacks "+target.showdata());
									}
								}
					

					break;
				default:
					break;
			}
		}
	}
	/**
	 * this method is use to find target to attack. First, target is alive and taunting if find it 
	 * return that target but if not, return first lowest hp target.
	 * @param team
	 * @return
	 */
	private Player findTarget(Player[][] team) {
		Player target = findTargetByLowest(team);
		if(target == null ) {return null;}		// if null Maybe all dead or something went wrong.
		for (int i = 0; i < team.length; i++) {
			for (int j = 0; j < team[i].length; j++) {
				if(team[i][j].isAlive() && team[i][j].isTaunting()) {
					return team[i][j];
				}
			}
		}
		return target;
	}

	/**
	 * this method is use to find target that is lowest hp.
	 * I think It's not correctly condition. I think I miss some condition of how to choose 
	 * target.
	 * @param team
	 * @return 
	 */
	private Player findTargetByLowest(Player[][] team) {
		/** check front is alive  */
		int frontisAlive = 1;	
		for (int i = 0; i < team[0].length; i++) {
			if(team[0][i].isAlive()){
				frontisAlive = 0;	// 0 means front is alive.
				break;
			}
		}
		double lowest_hp = 9000;
		/** sort the lowest hp */
		for (int i = 0; i < team[frontisAlive].length; i++) {
			if(team[frontisAlive][i].isAlive() && team[frontisAlive][i].currentHP < lowest_hp){
				lowest_hp = team[frontisAlive][i].currentHP;

			}
		}
		/**  check which hero is lowest and return that hero. */
		for (int i = 0; i < team[frontisAlive].length; i++) {
			if(lowest_hp ==  team[frontisAlive][i].currentHP){
				return team[frontisAlive][i];
			}
		}
		return null;
		}

	/**
	 * find lowest target in percent for healer.
	 * @param team
	 * @return
	 */
	private Player findTargetBypencent(Player[][] team) {
		//store the hp in percent of heros in team.
		double[] hp = new double[team[0].length * 2];
		int k = 0;
		/** store hp of heros in percent in array if hero dead make the hp to 10000(means dead) */
		for (int i = 0; i < team.length; i++) {
			for (int j = 0; j < team[i].length; j++) {
				if(team[i][j].isAlive()){
					hp[k] = (team[i][j].currentHP*100) / team[i][j].maxHP;
					k += 1; 
				}
			}
		}
		
		for (int i = 0; i < hp.length; i++) {
			if(hp[i]==0) hp[i] =100;
		}
		Arrays.sort(hp);				//Sort the array to find lowest percent.
		/** find which hero has lowest hp by percent */
		for (int i = 0; i < team.length; i++) {
			for (int j = 0; j < team[i].length; j++) {
				if(team[i][j].isAlive()&& hp[0] == (team[i][j].currentHP*100) / team[i][j].maxHP){
					return team[i][j];
				}
			}
		}
		return null;
	}

	
	/**
	 * this method is use to find first dead ally for revives.
	 * @param team
	 * @return
	 */
	private Player findAlly(Player[][] team) {

		for (int i = 0; i < team.length; i++) {for (int j = 0; j < team[i].length; j++) {if(!team[i][j].isAlive()){return team[i][j];}}}
		return null;
	}

	
	/**
	 *  this method is use to heals hero by percent 0.xx
	 * 	ans this is for cool no need to create method.
	 * @param team
	 * @param percent
	 */
	public void hpIncrease(Player team,double percent) { 
		team.currentHP += (percent* team.maxHP);
		if(team.currentHP>team.maxHP) {team.currentHP=team.maxHP;}	//in case of current hp is more than maxhp
	}



	/**
	 * this method is use to print information of the hero.
	 * { Team [row] [position] {Type} }
	 */
	public String showdata() {
		return this.team.toString() + "[" +this.row.toString() + "]" + "[" + this.position + "]"+ " {" + this.type.toString() + "} ";
	}
	/**
	 * This method overrides the default Object's toString() and is already
	 * implemented for you.
	 */
	@Override
	public String toString()
	{
		return "["+this.type.toString()+" HP:"+this.currentHP+"/"+this.maxHP+" ATK:"+this.atk+"]["
				+((this.isCursed())?"C":"")
				+((this.isTaunting())?"T":"")
				+((this.isSleeping())?"S":"")
				+"]";
	}
	
	
}
