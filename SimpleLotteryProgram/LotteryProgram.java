package SimpleLotteryProgram;

import java.util.*;

class LotteryProgram {

    public static int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }
    
    public static void createlotto(String[] l) {

        Random rd;
        int num;

        for ( int i = 0; i < 13; i++ ) {
            rd = new Random();
            l[i] = Integer.toString(rd.nextInt(5) + 1) + "/";
            
            for ( int j = 1; j < 7; j++ ) {
                rd = new Random();
                num = rd.nextInt(45) + 1;
                
                if( num < 10 )
                    l[i] += ("0" + Integer.toString(num) + ",");
                else
                    l[i] += (Integer.toString(num) + ",");
            }
        }
    }

    public static void showList(String[] l) {

        for ( int i = 0; i < 13; i++ ) {
            String [] split = l[i].split("/|,");
            System.out.print("lotto " + (i + 1) + " = ");
            
            System.out.print("Group " + split[0] + " Number: "); 
            for ( int j = 1; j < 7; j++ ) System.out.print(split[j] + " ");
            System.out.println();
        }
    }

    public static String makePhoneNumber() {

        String res = "010";
        
        for ( int i = 0; i < 2; i++) {
            Random rand= new Random();
            int PhoneNumber = rand.nextInt(10000);

            res+= "-";
            if ( PhoneNumber / 10 == 0 ) res += "000" + Integer.toString(PhoneNumber);
            else if ( PhoneNumber / 100 == 0 ) res += "00" + Integer.toString(PhoneNumber);
            else if ( PhoneNumber / 1000 == 0 ) res += "0" + Integer.toString(PhoneNumber);
            else res += PhoneNumber;
        }
        
        System.out.println(res);

        return res;
    }

    public static void purchaseLotto(HashMap<String, String> hmap, String[] l) {

        for ( int i = 0; i < randomRange(5, 13); i++ ) hmap.put(makePhoneNumber(), l[i]);
    
    }

    public static void resultLottery(HashMap<String, String> hmap, String[] l, Vector<String> win) {

        String first, second, third;
        Random[] rand = new Random[3];

        for ( int i = 0; i < 3; i++ ) rand[i] = new Random();
        int flag1 = rand[0].nextInt(l.length);
        int flag2 = rand[1].nextInt(l.length);
        int flag3 = rand[2].nextInt(l.length);

        first = l[flag1];
        second = l[flag2];
        third = l[flag3];
 
        Set<String> Keys = hmap.keySet();
        Iterator<String> it = Keys.iterator();

        while(it.hasNext()) {
            String PhoneNumber = it.next();
            String LotteryNumber = hmap.get(PhoneNumber);

            if ( LotteryNumber == first ) {
                System.out.println(PhoneNumber + " have won 1st place! Congratulation!");
                win.add("1");
                win.add(PhoneNumber);

            } else if ( LotteryNumber == second ) {
                System.out.println(PhoneNumber + " have won 2nd place! Congratulation!");
                win.add("2");
                win.add(PhoneNumber);
                
            } else if ( LotteryNumber == third ) {
                System.out.println(PhoneNumber + " have won 3rd place! Congratulation!");
                win.add("3");
                win.add(PhoneNumber);
            }
        }
        if ( win.size() == 0 ) System.out.println("No one has won.");
    }

    public static void checkPrize(Vector<String> win) {

        var prize = new HashMap<Integer, String>();
        prize.put(1, ": The prize money is 100,000,000 won.");
        prize.put(2, ": The prize money is 10,000,000 won.");
        prize.put(3, ": The prize money is 1,000,000 won.");

        for ( int i = 0; i < win.size(); i += 2 ) {
            for ( int j = 0; j < 3; j++ ) {
                if ( j + 1 == Integer.parseInt(win.get(i)) ) {
                    System.out.println(win.get(i + 1) + prize.get(j + 1));
                }
            }
        }
    }
    

    public static void main(String[] args) {

        HashMap<String, String> lottoBuyers = new HashMap<String, String>();
        String[] lottoList = new String[13];
        Vector<String> winners = new Vector<String>();

        createlotto(lottoList);
        showList(lottoList);
        purchaseLotto(lottoBuyers, lottoList);

        Set<String> Keys = lottoBuyers.keySet();
        var vecKeys = new Vector<String>(Keys);
        
        Collections.shuffle(vecKeys);
        resultLottery(lottoBuyers, lottoList, winners);
        checkPrize(winners);
    }
}
