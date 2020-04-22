
public class Similar {
    public static void main(String[] args) {
        double[][] rating = {{1.0,0,2.0,1.5},
                             {0.0,4,0.0,4.0},
                             {1.0,0.0,3.0,2.0}};
        double[][] rsim = new double[3][3];
        /**print rating */
        for (int i = 0; i < rating.length; i++) {
            for (int j = 0; j < rating[i].length; j++) {
                System.out.print(rating[i][j]+" ");
            }System.out.println();
        }
        /** calculate rsim and store in rsim array */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j ){
                    rsim[i][j] = 1.0;
                }else{
                    
                }
            }
        }
        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         System.out.print(rsim[i][j]+" ");
        //     }System.out.println();
        // }
    }
}