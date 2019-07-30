package itecafe;

import java.util.Scanner;

public class ITECafe {

    public static void main(String[] args) {
        int sum = 0;
        //準備
        //飲み物
        Item hotCoffee = new Item(1, "ホットコーヒー", 280);

        Item tea = new Item(2, "紅茶", 260);

        Item iceCoffee = new Item(3, "アイスコーヒー", 200);

        Item iceTea = new Item(4, "アイスティー", 260);

        //スイーツ
        Item shortCake = new Item(5, "ショートケーキ", 400);

        Item cheeseCake = new Item(6, "チーズケーキ", 400);

        Item chocolateCake = new Item(7, "チョコレートケーキ", 450);

        Item ChocolateBananaParfait = new Item(8, "チョコバナナパフェ", 390);

        Item ichigoParfait = new Item(9, "イチゴパフェ", 390);

        //軽食
        Item meatPasta = new Item(10, "ミートパスタ", 650);

        Item mixPizza = new Item(11, "ミックスピザ", 700);

        //パン
        Item Croissant = new Item(12, "クロワッサン", 180);

        Item toastSand = new Item(13, "トーストサンド", 200);

        Item frenchtoast = new Item(14, "フレンチトースト", 210);

        Item[] items = new Item[14];
        items[0] = hotCoffee;
        items[1] = tea;
        items[2] = iceCoffee;
        items[3] = iceTea;
        items[4] = shortCake;
        items[5] = cheeseCake;
        items[6] = chocolateCake;
        items[7] = ChocolateBananaParfait;
        items[8] = ichigoParfait;
        items[9] = meatPasta;
        items[10] = mixPizza;
        items[11] = Croissant;
        items[12] = toastSand;
        items[13] = frenchtoast;

        //メニューを表示する
        System.out.println("~ ITE Cafe システム ~");
        System.out.println(hotCoffee.getNumber() + ":" + hotCoffee.getName() + hotCoffee.getPrice() + "円");
        System.out.println(tea.getNumber() + ":" + tea.getName() + tea.getPrice() + "円");
        System.out.println(iceCoffee.getNumber() + ":" + iceCoffee.getName() + iceCoffee.getPrice() + "円");
        System.out.println(iceTea.getNumber() + ":" + iceTea.getName() + iceTea.getPrice() + "円");
        System.out.println(shortCake.getNumber() + ":" + shortCake.getName() + shortCake.getPrice() + "円");
        System.out.println(cheeseCake.getNumber() + ":" + cheeseCake.getName() + cheeseCake.getPrice() + "円");
        System.out.println(chocolateCake.getNumber() + ":" + chocolateCake.getName() + chocolateCake.getPrice() + "円");
        System.out.println(ChocolateBananaParfait.getNumber() + ":" + ChocolateBananaParfait.getName() + ChocolateBananaParfait.getPrice() + "円");
        System.out.println(ichigoParfait.getNumber() + ":" + ichigoParfait.getName() + ichigoParfait.getPrice() + "円");
        System.out.println(meatPasta.getNumber() + ":" + meatPasta.getName() + meatPasta.getPrice() + "円");
        System.out.println(mixPizza.getNumber() + ":" + mixPizza.getName() + mixPizza.getPrice() + "円");
        System.out.println(Croissant.getNumber() + ":" + Croissant.getName() + Croissant.getPrice() + "円");
        System.out.println(toastSand.getNumber() + ":" + toastSand.getName() + toastSand.getPrice() + "円");
        System.out.println(frenchtoast.getNumber() + ":" + frenchtoast.getName() + frenchtoast.getPrice() + "円");
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("商品番号を入力してください");
                String number = scan.next();
                int outNum = Integer.parseInt(number);
                //System.out.println(outNum);

                //その商品情報を表示する
                System.out.println(items[outNum - 1].getName());

                //個数を入力する
                Scanner count = new Scanner(System.in);

                System.out.println("個数を入力してください");

                String numbers = count.next();
                int outNums = Integer.parseInt(numbers);

                //合計金額をだす
                sum += outNums * items[outNum - 1].getPrice();
                System.out.println("合計金額は");
                System.out.println(sum + "円です");
                OUT:
                while (true) {
                    System.out.print("まだ購入しますか？(購入終了.0 購入を続ける.1)：");
                    String ena = count.next();
                    int ena_tmp = Integer.parseInt(ena);
                    switch (ena_tmp) {
                        case 0:
                            break OUT;
                        case 1:
                            System.out.println("商品番号を入力してください");
                            number = scan.next();
                            outNum = Integer.parseInt(number);
                            //System.out.println(outNum);

                            //その商品情報を表示する
                            System.out.println(items[outNum - 1].getName());

                            //個数を入力する
                            count = new Scanner(System.in);

                            System.out.println("個数を入力してください");

                            numbers = count.next();
                            outNums = Integer.parseInt(numbers);

                            //合計金額をだす
                            sum += outNums * items[outNum - 1].getPrice();
                            System.out.println("合計金額は");
                            System.out.println(sum + "円です");
                            break;
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("正しい数字を入力してください。");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("1から14の数字を入力してください。");
            }
        }
        //代金を入力
        Scanner counts = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("代金を入力してください");

                String num = counts.next();
                int outNumber = Integer.parseInt(num);

                if (outNumber > sum) {
                    //お釣りを表示する
                    System.out.println("お釣りは" + (outNumber - sum) + "円です。");
                    break;
                } else if (outNumber < sum) {
                    System.out.println((sum - outNumber) + "円、足りません。");
                }

            } catch (NumberFormatException e) {
                System.out.println("正しい数字を入力してください。");
            }

        }
    }
}
