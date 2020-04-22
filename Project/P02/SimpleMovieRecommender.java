import java.io.*;
import java.util.*;
import java.util.regex.*;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Sets;

public class SimpleMovieRecommender implements BaseMovieRecommender {

    public Map<Integer, Movie> movies;                                                      //use for store Movie with movieid
    public Map<Integer, User> users;                                                        //use for store User with userid
    public BiMap<Integer, Integer> user_map = HashBiMap.create();                           //use for output file //same as movies map.
    public BiMap<Integer, Integer> movie_map = HashBiMap.create();                          //use for output file //same as users map.

    @Override
    public Map<Integer, Movie> loadMovies(String movieFilename) {
        // TODO Auto-generated method stub
        Map<Integer, Movie> temp = new HashMap<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(movieFilename));
            String s = "";                  /**1    ,   Toy Story       (1995)            , Adventure|Animation|Children|Comedy|Fantasy */
            Pattern regex = Pattern.compile("(\\d+)(,)(\"*)(,*)(.+)(\\()(\\d+)(\\))(\"*)(,)(.*)");
            while ((s = reader.readLine()) != null) {
                Matcher match = regex.matcher(s);
                if (match.find()) {
                    int movieid = Integer.parseInt(match.group(1));
                    String title = match.group(5);
                    int year = Integer.parseInt(match.group(7));
                    Movie mov = new Movie(movieid, title, year);//create instance of movie and add defult value.

                    String[] sp = match.group(11).split("\\|"); /**Adventure | Animation | Children | Comedy | Fantasy */
                    for (String tag : sp) {                     //add all tags in this movieid.
                        mov.addTag(tag);
                    }
                    temp.put(movieid, mov);                     //add movieid and Movie in temp map.
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return temp;                                           //return temp
    }

    @Override
    public Map<Integer, User> loadUsers(String ratingFilename) {
        // TODO Auto-generated method stub
        Map<Integer, User> temp = new HashMap<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(ratingFilename));
            String s = "";                  /**  1   , 592  ,     2.5   , 1217896043 */
            Pattern regex = Pattern.compile("(\\d+),(\\d+),(\\d+.\\d+),(\\d+)");
            while ((s = reader.readLine()) != null) {
                Matcher match = regex.matcher(s);
                if (match.find()) { // userId,movieId,rating,timestamp
                    int userid = Integer.parseInt(match.group(1));
                    int mid = Integer.parseInt(match.group(2));
                    double rating = Double.parseDouble(match.group(3));
                    long timestamp = Long.parseLong(match.group(4));

                    User use = new User(userid);
                    Movie m = movies.get(mid);
                    if (temp.get(userid) == null) {                         //check temp map contain this userid or not if not add rating
                        use.addRating(m, rating, timestamp);                //in user and put it in map
                        temp.put(userid, use);
                    } else {
                        temp.get(userid).addRating(m, rating, timestamp);   //else add another rating of movie that userid this rate in user
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return temp;
    }

    @Override
    public void loadData(String movieFilename, String userFilename) {
        movies = loadMovies(movieFilename);
        users = loadUsers(userFilename);

    }

    @Override
    public Map<Integer, Movie> getAllMovies() {
        // TODO Auto-generated method stub
        return movies;
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        // TODO Auto-generated method stub
        return users;
    }

   
    @Override
    public void trainModel(String modelFilename) {
        // TODO Auto-generated method stub

        StringBuilder data = new StringBuilder();
        FileWriter file = null;
        try {
            file = new FileWriter(new File(modelFilename));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Can't create file.");                  //if can't create file print show error.
            e.printStackTrace();
        }
        int pos = 0;
        for (User u : users.values()) {                       //add userid with index start with 0 - user.size()
            user_map.put(pos, u.uid);pos++;                   //to easy wirte for file output.
        }
        // store user id in map and append in file.
        List<Integer> temp_movieID = new ArrayList<>(movies.keySet()); // add movie id in list and sort it before store
        Collections.sort(temp_movieID);                                // in movieid map.
                                                                       
        for (int i = 0; i < movies.size(); i++) {                      //add movieid with index start with 0 - movies.size()
            movie_map.put(i, temp_movieID.get(i));                     //to easy wirte for file output.
        }
        // store movieid in map and append in file.
        data.append("@NUM_USERS " + users.size() + "\n");
        data.append("@USER_MAP " + user_map + "\n");
        data.append("@NUM_MOVIES " + movies.size() + "\n");
        data.append("@MOVIE_MAP "+movie_map+"\n");
        /** ----------------------------------- */
        System.out.println("@@@COMPUTING MATRIX");
        /** ------------------------------------------------- */
        data.append("@RATING_MATRIX\n");
        for (int i = 0; i < users.size(); i++) {
            int id = user_map.get(i);
            for (int j = 0; j < movies.size(); j++) {
                int md = movie_map.get(j);
                if (users.get(id).ratings.get(md) == null) {
                    data.append(0.0 + " ");
                } else {
                    data.append(users.get(id).ratings.get(md).rating + " ");    //append rating that user rate in each movie.

                }
            }
            data.append(users.get(id).getMeanRating() + "\n");         //Last element of array will be avg of rating that user was rate.
        }
        /** ----------------------------------- */
        System.out.println("@@@-COMPLETE-@@@\n@@@COMPUTING SIMILARITY");
        /** ------------------------------------------------- */
        data.append("@USERSIM_MATRIX\n");
        for (int i = 0; i < users.size(); i++) {
            int u = user_map.get(i);
            for (int j = 0; j < users.size(); j++) {
                int v = user_map.get(j);

                if (i == j) {                                          //if i == j means it's userself so just append 1.0
                    data.append(1.0 + " ");
                } else {
                    double sim = similarity(u, v);                     //calculate similarity of user U and V.
                        data.append(sim + " ");                        //and then append similarity.
                }
            }
            data.append("\n");
        }

        try {
            System.out.println("@@@-COMPLETE-@@@\n@@@CREATING MODEL");
            file.write(data.toString());                               //Last write file with all data that collected.
        } catch (IOException e) {
            System.out.println("Can't create file.");
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                System.out.println("@@@-COMPLETE-@@@");
            }
        }

    }

    public BiMap<Integer,Integer> mapOfUser = HashBiMap.create();        //collect information of users.  <index,userid>  *idx start w/ 0 then idx++   
    public BiMap<Integer,Integer> mapOfMovie = HashBiMap.create();       //collect information of movies. <index,movieid> *idx start w/ 0 then idx++
    public double[][] ratematrix ;                                     //collect information of ratings matrix with mean rating. *mean rating is last element of each row.
    public double[][] simmatrix ;                                      //collect information of similarity.
    @Override
    public void loadModel(String modelFilename) {
        ratematrix = new double[users.size()][movies.size()+1];
        simmatrix = new double[users.size()][users.size()];
        int count = 0; // add index in rateingmatrix and meanmatrix.
        int count2 = 0; //add index in similarity arry.
        // TODO Auto-generated method stub
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(modelFilename));
            String s = "";
            Pattern regex = Pattern.compile("(@USER_MAP)\\s(\\{)(.*)(\\})"); //@USER_MAP {0=1, 1=21, 2=475}
            Pattern regex2 =Pattern.compile("(@MOVIE_MAP)\\s(\\{)(.*)(\\})");//@MOVIE_MAP {0=1, 1=21, 2=475}
            Pattern regex3 = Pattern.compile("(-)?(\\d+.\\d+\\s)");          //Pattern of matrix.
            String[] sp = null;
            while ((s = reader.readLine()) != null) {
                /**--------------user map--------------- */
                Matcher match = regex.matcher(s);                      //if it's match @USER_MAP
                if (match.find()) { 
                    String temp = match.group(3);                     
                    sp = temp.split(","); //0=1, 1=21, 2=475
                    for (String string : sp) {
                        Pattern p = Pattern.compile("(\\d+)=(\\d+)"); //0=1 1=21 2=475
                        Matcher m = p.matcher(string);
                        m.find();
                        int key = Integer.parseInt(m.group(1));
                        int values = Integer.parseInt(m.group(2));
                        mapOfUser.put(key,values);                       //add <index and userid> in map *idx start w/ 0.
                    }
                }
                /**--------------movie map--------------- */
                Matcher match2 =regex2.matcher(s);
                if(match2.find()){                                     //if it's match @MOVIE_MAP
                    String temp = match2.group(3);
                    sp = temp.split(","); //0=1, 1=21, 2=475
                    for (String string : sp) {
                        Pattern p = Pattern.compile("(\\d+)=(\\d+)"); //0=1 1=21 2=475
                        Matcher m = p.matcher(string);
                        m.find();
                        int key = Integer.parseInt(m.group(1));
                        int values = Integer.parseInt(m.group(2));
                        mapOfMovie.put(key,values);
                    }
                }
                /**--------------matrix things--------------- */
                Matcher match3 = regex3.matcher(s);
                if(match3.find()){
                    String[] temp = s.split(" ");
                    if(temp.length == movies.size()+1){                //if temp.length equals to movies.size+1 mean it's rating matrix.
                        for (int k = 0; k < temp.length; k++) {        //then store data in ratematrix and mean rating is last element in each row.
                                ratematrix[count][k] = Double.parseDouble(temp[k]);
                        }count++;
                    }
                    if(temp.length == users.size()){                   //if temp.length equals to users.size mean it's similarity matrix.
                        for (int k = 0; k < temp.length; k++) {        //then store data in sim matrix.
                            simmatrix[count2][k] = Double.parseDouble(temp[k]);
                        }count2++;
                    }
                }
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();                                         /**Don't forget to close file. */
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();                                    //if something wrong w/ closeing file then show the error.
            }
        }


    }
    @Override
    public double predict(Movie m, User u) {
        // TODO Auto-generated method stub
        if(!mapOfUser.containsValue(u.uid)) return u.getMeanRating();    //if mapOfUser map doesn't contain userid then return mean rating.

            int userPos = mapOfUser.inverse().get(u.uid);                //let user Position be key of user id.
            int movPos = mapOfMovie.inverse().get(m.mid);                  //let movie Position be key of movie id.
            double sumofU = 0.0 , sumofD = 0.0;
            for(int y=0;y<ratematrix.length;y++) {
                if(y == userPos) continue;
                if(ratematrix[y][movPos] > 0.0) {
                        double s = simmatrix[y][userPos];
                        sumofU += s*(ratematrix[y][movPos] - ratematrix[y][ratematrix[y].length-1]);
                        sumofD += Math.abs(s);
                }
            } 
		if(sumofU == 0.0 || sumofD == 0.0) return ratematrix[userPos][ratematrix[userPos].length-1];
		double p = ratematrix[userPos][ratematrix[userPos].length-1] + (sumofU/sumofD);
		if(p > 5.0) p = 5.0;
		else if(p < 0.0) p = 0.0;
        
        return p;
    }

    @Override
    public List<MovieItem> recommend(User u, int fromYear, int toYear, int K) {
        // TODO Auto-generated method stub
        List<MovieItem> list = new ArrayList<MovieItem>();
            for (int i : mapOfMovie.values()) {
                int movieYear = movies.get(i).year;
                if(movieYear >= fromYear && movieYear <= toYear){
                    double predictRate = predict(movies.get(i), u);
                    MovieItem m = new MovieItem(movies.get(i),predictRate);
                    list.add(m);
                }
            }
            Collections.sort(list);                                     //sort by score.
            if(list.size() < K) return list;                            //if list size less than K return list.
            else return list.subList(0, K);                             //if list size more than K return [0,k].

    }

    /**
     * find similarity of user u,v.
     * 
     * @param userFirst  is u.
     * @param userSecond is v. 
     * @return similary of two users.
     */
    public double similarity(int userFirst, int userSecond) {

        User u = users.get(userFirst);
        User v = users.get(userSecond);

        double similarity;
        TreeSet<Integer> intersectRateMovies = new TreeSet<>();        //intersection to check if user u and user v are rate same movies then store in TreeSet.
        intersectRateMovies.addAll(Sets.intersection(u.ratings.keySet(), v.ratings.keySet()));

        // Find the sumOfUser
        double sumOfAllUser = 0;
        double underUserFirst = 0;
        double underUserSecond = 0;
        for (int mID : intersectRateMovies) {
            double uRataing = u.ratings.get(mID).rating;
            double uMean = u.getMeanRating();
            double vRating = v.ratings.get(mID).rating;
            double vMean = v.getMeanRating();
            sumOfAllUser += ((uRataing - uMean)* (vRating - vMean));
            underUserFirst += Math.pow(uRataing - uMean,2);
            underUserSecond += Math.pow(vRating - vMean,2);
            // underUserFirst += (uRataing - uMean) * (uRataing- uMean);
            // underUserSecond += (vRating - vMean) * (vRating - vMean);
        }
        // sqrt(underUserFirst) * sqrt(underUserSecond)
        double sqrtof2User = (Math.sqrt(underUserFirst * underUserSecond));

        // 𝑠(𝑢, 𝑢) ∈ [−1,1]. 𝑠(𝑢, 𝑢) = 1.0. If the denominator is 0, then 𝑠(𝑢,𝑣) = 0.
        if (sqrtof2User != 0) similarity = sumOfAllUser / sqrtof2User;
        else similarity = 0.0;

        return similarity;
    }

}