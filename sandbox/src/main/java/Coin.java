/**
 * @author Frank Zhu
 */
public class Coin
{
   public static int getMinCount(int total, int[] coins)
   {
      int[] min = new int[total + 1];
      min[0] = 0;

      for (int i = 1; i <= total; i++) {
         int currentTotal = i;
         min[i] = Integer.MAX_VALUE;
         for (int j = 0; j < coins.length; j++) {
            int coin = coins[j];
            if (coin <= currentTotal && min[i - coin] < min[i]) {
               min[i] = min[i - coin] + 1;
            }
         }
      }

      int minCount = min[total];

      return minCount;
   }

   public static void main(String[] args) {
      System.out.println(getMinCount(100, new int[]{1,5,10,25}));
   }


}
