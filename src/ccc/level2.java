package ccc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class level2 {



        public static void main(String[] args) {

            for (int i = 0; i < 5; i++) {
                Path in = Path.of("resource/level4_"+(i+1)+".in");
                Path out = Path.of("resource/level4_"+(i+1)+".out");
                int[][] a = einlesen4(in);
                level4(a, out);
            }


        }

        public static int[][] einlesen(Path path) {
            try {
                int y = Integer.parseInt(Files.readAllLines(path).toArray()[0].toString());
                int x = Integer.parseInt(Files.readAllLines(path).toArray()[1].toString());
                int[][] r = new int[y][x];
                List<String> a = Files.readAllLines(path);
                for (int i = 2; i < a.size(); i++) {
                    String[] s = a.get(i).split(" ");
                    for (int j = 0; j < x; j++) {
                        r[i-2][j] = Integer.parseInt(s[j]);
                    }
                }

                return r;
            } catch (IOException e) {
                System.out.println("problem with reading in file");
                return null;
            }
        }

        public static int[][] einlesen4(Path path) {
            try {
                int y = Integer.parseInt(Files.readAllLines(path).toArray()[0].toString())*2;
                int x = Integer.parseInt(Files.readAllLines(path).toArray()[1].toString());
                int z = Integer.parseInt(Files.readAllLines(path).toArray()[2].toString());
                int[][] r = new int[y][];
                List<String> a = Files.readAllLines(path);
                for (int i = 3; i < a.size(); i++) {
                    String[] s = a.get(i).split(" ");
                    r[i-3]= new int[i%2==0?z:x];
                    for (int j = 0; j < (i%2==0?z:x); j++) {
                        r[i-3][j] = Integer.parseInt(s[j]);
                    }
                }

                return r;
            } catch (IOException e) {
                System.out.println("problem with reading in file"+e.getMessage());
                return null;
            }
        }

        public static int[][] einlesen3(Path path) {
            try {
                int y = Integer.parseInt(Files.readAllLines(path).toArray()[0].toString());
                int x = Integer.parseInt(Files.readAllLines(path).toArray()[1].toString());
                int[][] r = new int[y][x];
                List<String> a = Files.readAllLines(path);
                for (int i = 2; i < a.size(); i++) {
                    String[] s = a.get(i).split(" ");
                    for (int j = 0; j < x; j++) {
                        r[i-2][j] = Integer.parseInt(s[j]);
                    }
                }

                return r;
            } catch (IOException e) {
                System.out.println("problem with reading in file");
                return null;
            }
        }

        public static void smallestValue(int[][] a, Path out) {
            try (BufferedWriter b = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
                for (int i = 0; i < a.length; i++) {
                    Arrays.sort(a[i]);
                    for (int j = 0; j < a[0].length; j++) {
                        int min = a[i][j];
                        if (a[i][j + 1] > min + 1) {
                            b.write(min + 1+System.lineSeparator());
                            break;
                        }
                    }
                }
            } catch (IOException e) {
            }
        }

        public static void sum(int[][] a, Path out) {
            try (BufferedWriter b = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
                for (int i = 0; i < a.length; i+=2) {int[] values = a[i];
                    int[] targets = a[i+1];
                    for (int j = 0; j < targets.length; j++) {
                        int[] solulu = twoSum(values, targets[j]);
                        b.write(solulu[0]+" "+solulu[1]+System.lineSeparator());
                    }
                }
            } catch (IOException e) {
                System.out.println("problem at level2");
            }
        }

        public static void level3(int[][] a, Path out){
            try (BufferedWriter b = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {

                String[] r = new String[100*a.length];
                for (int j = 0; j< a.length;j++) {
                    for (int i = 0; i < 100; i++) {
                        r[i+j*100] = minCoins(a[j], i + 1);
                    }
                }
                for (String string : r) {
                    b.write(string + System.lineSeparator());
                }

            } catch (IOException e) {
                System.out.println("problem at level3");
            }

        }

        public static void level4(int[][] a, Path out){
            try (BufferedWriter b = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
                String[] r = new String[100*a.length];
                for (int j = 3; j< a.length;j++) {
                    int[] values = a[j];
                    int[] targets = a[j+1];
                    for (int i = 0; i < targets.length; i++) {
                        r[i+j*targets.length] = minCoins(values, targets[i]);
                    }
                }
                for (String string : r) {
                    b.write(string + System.lineSeparator());
                }

            } catch (IOException e) {
                System.out.println("problem at level4");
            }

        }



        public static int[] twoSum(int[] nums, int target) {
            int l = nums.length;
            for(int i = 0; i < l; i++){
                for(int j = i; j < l; j++){
                    if(nums[i]+nums[j]==target) {
                        return new int[]{nums[i],nums[j]};
                    }
                }
            }
            return new int[0];


        }

        public static String minCoins(int[] coins, int target) {
            ArrayList<Integer> dp = new ArrayList<>();
            int[] coinUsed = new int[target + 1];
            dp.add(0);

            for (int i = 1; i <= target; i++) {
                dp.add(i,Integer.MAX_VALUE);
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i && dp.get(i - coins[j]) + 1 < dp.get(i)) {
                        dp.set(i,dp.get(i - coins[j]) + 1);
                        coinUsed[i] = coins[j];
                    }
                }
            }


            if (dp.get(target) == Integer.MAX_VALUE) {
                return "No solution";
            }
            dp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int current = target;
            int[] coinCount = new int[coins.length];
            while (current > 0) {
                int coin = coinUsed[current];
                for (int i = 0; i < coins.length; i++) {
                    if (coins[i] == coin) {
                        coinCount[i]++;
                        break;
                    }
                }
                current -= coin;
            }

            for (int i = 0; i < coins.length; i++) {
                if (coinCount[i] > 0) {
                    sb.append(coinCount[i]).append("x").append(coins[i]).append(" ");
                }
            }

            return sb.toString();
        }

/*public static String minCoins(int[] coins, int target) {
    int max = target + 1;
    Map<Integer, Integer> dp = new HashMap<>();
    dp.put(0, 0);

    for (int i = 1; i <= target; i++) {
        dp.put(i, max);
        for (int coin : coins) {
            if (coin <= i) {
                dp.put(i, Math.min(dp.get(i), dp.get(i - coin) + 1));
            }
        }
    }

    if (dp.get(target) == max) return "No solution";

    List<String> result = new ArrayList<>();
    int current = target;
    while (current > 0) {
        for (int coin : coins) {
            if (current >= coin && dp.get(current) == dp.get(current - coin) + 1) {
                result.add("1x" + coin);
                current -= coin;
                break;
            }
        }
    }

    return String.join(" ", result);
}*/




}
