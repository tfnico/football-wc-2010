/*
there are 4 teams.

Each has 3 matches.

Or there are 6 matches (touple of team A,B)

each match has a result. winner (A or B or none if draw).

Winner is defined by calculating AGoals vs BGoals.

Setup
*/
case class Team(val country:String)
object Team {
	def apply(s:String) = new Team(s)
}

class Match(val a:Team, val b:Team) {

	var aGoals:Int = 0
	var bGoals:Int = 0
	
	def winner:Team = {
		if(aGoals > bGoals ) a
		else if (bGoals > aGoals) b
		else null
	}
	
	def play {
		aGoals = 1
		bGoals = 2
	}
	
	def includes(t:Team) = {
		(a == t) || (b == t)
	}
}

object Match {
	
	def apply(a:Team,b:Team) = new Match(a,b)
	
	
}

import scala.collection.mutable.HashSet

class Group {

	val norway = Team("Norway")
	val sweden = Team("Sweden")
	val germany = Team("Germany")
	val england = Team("England")
		
	val matches:List[Match] = Match(norway,sweden)::
				Match(norway,germany)::
				Match(norway,england)::
				Match(sweden, germany)::
				Match(sweden, england)::
				Match(germany,england)::
				Nil
	
	def play {

		
		
		matches.foreach(_.play)
	}

	def matchesPlayed(team:Team) = {
		matches.filter( mat => mat.includes(team))
		
	}
		
}



val group = new Group

group.play

assert(group.matches.size == 6)
assert(group.matchesPlayed(Team("Denmark")).size == 0)
assert(group.matchesPlayed(Team("Norway")).size == 3)

println("How many goals scored which team?")
println("================================")

group.matchesPlayed.foreach println 
//(country, sum( matches(team).homeGoals)

/*
- How many points got which team?
*/

//teams.foreach println (country, matches.count(results.winner = this) * 3 + matches.count(result.winner = none)

/*
- Who is promoted to next round (given that
the first two are promoted)?
*/
//group.standings(1) and (2)

/*
- What is the final standing of the group
after 6 games (Win: 3pts, draw:
1pt, loss 0pt, 

equal in points after 6 games, goal difference decide, 
equals goal difference direct comparison, 
draw in direct comparison more shot goals,
fortune).
*/
//group.standings
