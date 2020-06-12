import java.util.List;


import org.apache.commons.lang3.time.StopWatch;

public class MainController {

	public static void main(String[] args)
	{
		String usage = "Training: train <movie_filename> <train_user_filename> <model_filename>\n"
				+"Ex. java -jar MainController.jar train small/movies.csv small/users.train.0.csv small/small.simple.model\n\n"
				+"Testing: test <movie_filename> <train_user_filename> <model_filename> <test_user_filename> <report_filename>\n"
				+"Ex. java -jar MainController.jar test small/movies.csv small/users.train.0.csv small/small.simple.model small/users.test.0.csv small/small.simple.result\n\n"
				+"Recommending: recommend <movie_filename> <train_user_filename> <model_filename> <user_id>\n"
				+"Ex. java -jar MainController.jar recommend small/movies.csv small/users.train.0.csv small/small.simple.model 19\n\n"
				+"Test Parsing: parse <movie_filename> <user_filename>\n"
				+"Ex.java -jar MainController.jar parse small/movies.csv small/users.train.0.csv";
		boolean printUsage = false;

		
		StopWatch c = new StopWatch();
				c.start();
				BaseMovieRecommender b = new SimpleMovieRecommender();
				// System.out.println("Test pasrsing data.");
				// b.loadData("small/movies.csv","small/users.train.csv");
				// int numMovie = b.getAllMovies().size();
				// int numUser = b.getAllUsers().size();
				// Movie mm = b.getAllMovies().values().iterator().next();
				// User uu = b.getAllUsers().values().iterator().next();
				// System.out.println(numMovie+" movies loaded. The first movie is \n"+mm.toString());
				// System.out.println(numUser+" users loaded. The first user is \n"+uu.toString());
				
				// System.out.println("Training the recommender...");
				// b.loadData("small/movies.csv","small/users.train.csv");
				// b.trainModel("small/small.simple.model");

				
				System.out.println("Testing the recommender...");
				b.loadData("small/movies.csv","small/users.train.csv");
				b.loadModel("small/small.simple.model");
				Evaluator ee = new Evaluator(b, "small/users.test.csv");
				ee.evaluate(2010, 2015, 20, "small/small.simple.result");
				System.out.println(ee.toString());

				// System.out.println("Recommendation for "+19);
				// b.loadData("small/movies.csv","small/users.train.csv");
				// b.loadModel("small/small.aor.model");
				// List<MovieItem> itemss = b.recommend(b.getAllUsers().get(Integer.parseInt("19")), 2010, 2015, 20);
				// int coun = 1;
				// for(MovieItem ite: itemss)
				// {
				// 	System.out.println((coun++)+". "+ite.getMovie().title+" ("+ite.getMovie().year+")");
				// }
	
				c.stop();
				System.out.println("Time Used: "+c.toString());
		
		if(args[0].equalsIgnoreCase("train"))
		{
			if(args.length != 4)
			{
				System.out.println("Error: See Usage");
				printUsage = true;
			}
			else
			{	StopWatch clock = new StopWatch();
				clock.start();
				System.out.println("Training the recommender...");
				BaseMovieRecommender r = new SimpleMovieRecommender();
				r.loadData(args[1], args[2]);
				r.trainModel(args[3]);
				clock.stop();
				System.out.println("Time Used: "+clock.toString());
			}
		}
		else if(args[0].equalsIgnoreCase("test"))
		{
			if(args.length != 6)
			{
				System.out.println("Error: See Usage");
				printUsage = true;
			}
			else
			{	StopWatch clock = new StopWatch();
				clock.start();
				System.out.println("Testing the recommender...");
				BaseMovieRecommender r = new SimpleMovieRecommender();
				r.loadData(args[1], args[2]);
				r.loadModel(args[3]);
				Evaluator e = new Evaluator(r, args[4]);
				e.evaluate(2010, 2015, 20, args[5]);
				System.out.println(e.toString());
				clock.stop();
				System.out.println("Time Used: "+clock.toString());
			}
		}
		else if(args[0].equalsIgnoreCase("recommend"))
		{
			if(args.length != 5)
			{
				System.out.println("Error: See Usage");
				printUsage = true;
			}
			else
			{	StopWatch clock = new StopWatch();
				clock.start();
				System.out.println("Recommendation for "+args[4]);
				BaseMovieRecommender r = new SimpleMovieRecommender();
				r.loadData(args[1], args[2]);
				r.loadModel(args[3]);
				List<MovieItem> items = r.recommend(r.getAllUsers().get(Integer.parseInt(args[4])), 2010, 2015, 20);
				int count = 1;
				for(MovieItem item: items)
				{
					System.out.println((count++)+". "+item.getMovie().title+" ("+item.getMovie().year+")");
				}
				clock.stop();
				System.out.println("Time Used: "+clock.toString());
			}
		}
		else if(args[0].equalsIgnoreCase("parse"))
		{
			if(args.length != 3)
			{
				System.out.println("Error: See Usage");
				printUsage = true;
			}
			else
			{	StopWatch clock = new StopWatch();
				clock.start();
				System.out.println("Test pasrsing data.");
				BaseMovieRecommender r = new SimpleMovieRecommender();
				r.loadData(args[1], args[2]);
				int numMovies = r.getAllMovies().size();
				int numUsers = r.getAllUsers().size();
				Movie m = r.getAllMovies().values().iterator().next();
				User u = r.getAllUsers().values().iterator().next();
				System.out.println(numMovies+" movies loaded. The first movie is \n"+m.toString());
				System.out.println(numUsers+" users loaded. The first user is \n"+u.toString());
				clock.stop();
				System.out.println("Time Used: "+clock.toString());
				
			}
		}
		
		if(printUsage)
		{
			System.out.println(usage);
		}
		
	}

}
