import java.util.Scanner;

public class RestaurantManagementsystem {
    static final String DATE = "22/09/23";
    static final int A = -1;

    static int collection = 0;
    static int NoOfCustomers = 0;
    static int high = 0;

    
    static class MenuItem {
        String name;
        int price;

        public MenuItem(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    static MenuItem[] Menu = {
        new MenuItem("1. Chicken Biryani", 200),
        new MenuItem("2. Mutton Biryani", 350),
        new MenuItem("3. Biryani", 130),
        new MenuItem("4. Butter Chicken and Naan", 399),
        new MenuItem("5. Tandoori Chicken", 249),
        new MenuItem("6. Punjabi Chicken with Lachha Paratha", 359),
        new MenuItem("7. Masala Kulcha", 110),
        new MenuItem("8. Chilli Paneer", 269),
        new MenuItem("9. Chicken Hakka noodles", 210),
        new MenuItem("10. Fish Finger", 99),
        new MenuItem("11. Ice Cream", 89),
        new MenuItem("12. Soft Drink", 59)
    };

    
    static int CId = 100;
    static int[] table = new int[84];
    static Customer[] c = new Customer[100];
    static Customer head;

    static class Customer {
        String name;
        int number;
        String date;
        int[] ord = new int[5];
        int Amount;
        int tab;
        int cust;
        int TS;
        Customer next;

        public Customer(String name, int number, String date, int[] ord, int Amount, int tab, int cust, int TS) {
            this.name = name;
            this.number = number;
            this.date = date;
            this.ord = ord;
            this.Amount = Amount;
            this.tab = tab;
            this.cust = cust;
            this.TS = TS;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        int An;
        String lucky_cust = "";
        int flag = 1;
        int c;

        Scanner scanner = new Scanner(System.in);

        while (flag == 1) {
            System.out.println("--------------------------Restaurant----------------------");
            System.out.println("1. Booking \t 2. Check Table Availability \t 3. Collection");
            System.out.println("4. Total Customers \t 5. Highest Bill \t 6. Customer Details");
            System.out.println("7. Menu \t 0. Exit");
            c = scanner.nextInt();

            
            if (c == 1) {
                System.out.println("In which time slot do you want to book-");
                System.out.println("1. 11:00 to 12:00 \t 2. 12:00 to 13:00 \t 3. 13:00 to 14:00");
                System.out.println("4. 14:00 to 15:00 \t 5. 15:00 to 16:00 \t 6. 16:00 to 17:00");
                System.out.println("7. 17:00 to 18:00 \t 8. 18:00 to 19:00 \t 9. 19:00 to 20:00");
                System.out.println("10. 20:00 to 21:00 \t 11. 21:00 to 22:00 \t 12. 22:00 to 23:00");

                int TS = scanner.nextInt();
                System.out.println("Available Tables-");
                System.out.println("Table Number - Status");

                switch (TS) {
                    case 1:
                        check(0, 7);
                        break;
                    case 2:
                        check(7, 14);
                        break;
                    case 3:
                        check(14, 21);
                        break;
                    case 4:
                        check(21, 28);
                        break;
                    case 5:
                        check(28, 35);
                        break;
                    case 6:
                        check(35, 42);
                        break;
                    case 7:
                        check(42, 49);
                        break;
                    case 8:
                        check(49, 56);
                        break;
                    case 9:
                        check(56, 63);
                        break;
                    case 10:
                        check(63, 70);
                        break;
                    case 11:
                        check(70, 77);
                        break;
                    case 12:
                        check(77, 84);
                        break;
                    default:
                        System.out.println("Invalid Input");
                }

                int TN;
                System.out.println("Which table number do you want to book: ");
                TN = scanner.nextInt();
                An = A + (TS - 1) * 7;
                if (table[An + TN] == 0) {
                    booking(TN, TS);
                    table[An + TN] = 1;
                    System.out.println("Booking Successful!");
                } else {
                    System.out.println("Sorry, this table is already booked.");
                }
            }
            // Seat availability
            else if (c == 2) {
                System.out.println("Which time slot do you want to check: ");
                System.out.println("1. 11:00 to 12:00 \t 2. 12:00 to 13:00 \t 3. 13:00 to 14:00");
                System.out.println("4. 14:00 to 15:00 \t 5. 15:00 to 16:00 \t 6. 16:00 to 17:00");
                System.out.println("7. 17:00 to 18:00 \t 8. 18:00 to 19:00 \t 9. 19:00 to 20:00");
                System.out.println("10. 20:00 to 21:00 \t 11. 21:00 to 22:00 \t 12. 22:00 to 23:00");

                int TS = scanner.nextInt();
                System.out.println("Table Number - Status");

                switch (TS) {
                    case 1:
                        check(0, 7);
                        break;
                    case 2:
                        check(7, 14);
                        break;
                    case 3:
                        check(14, 21);
                        break;
                    case 4:
                        check(21, 28);
                        break;
                    case 5:
                        check(28, 35);
                        break;
                    case 6:
                        check(35, 42);
                        break;
                    case 7:
                        check(42, 49);
                        break;
                    case 8:
                        check(49, 56);
                        break;
                    case 9:
                        check(56, 63);
                        break;
                    case 10:
                        check(63, 70);
                        break;
                    case 11:
                        check(70, 77);
                        break;
                    case 12:
                        check(77, 84);
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }
            
            else if (c == 3) {
                System.out.println("Collection of the day: " + collection + " rs");
            }
            
            else if (c == 4) {
                System.out.println("Total number of customers: " + NoOfCustomers);
            }
            
            else if (c == 5) {
                int a = 0;
                Customer temp = head;
                while (a < NoOfCustomers) {
                    if (high < temp.Amount) {
                        high = temp.Amount;
                        lucky_cust = temp.name;
                    }
                    temp = temp.next;
                    a++;
                }
                System.out.println("The highest billing of the day is " + high + " rs");
                System.out.println("The lucky customer that will get a gift is " + lucky_cust);
            }
            else if (c == 6) {
                int a = 0;
                Customer temp = head;
                while (a < NoOfCustomers) {
                    System.out.println("Customer ID - " + temp.cust + "\n");
                    System.out.println("Name - " + temp.name);
                    System.out.println("Phone Number - " + temp.number);
                    System.out.println("Date - " + DATE);
                    System.out.print("Orders - ");
                    int i = 0;
                    while (temp.ord[i] != 0) {
                        System.out.print(Menu[temp.ord[i] - 1].name + ", ");
                        i++;
                    }
                    System.out.println("\nBill - " + temp.Amount);
                    System.out.println("Phone Number - " + temp.number);
                    System.out.println("Time Slot - " + temp.TS);
                    System.out.println("Table Number - " + temp.tab);
                    temp = temp.next;
                    a++;
                    System.out.println("\n\n");
                }
            }
            // Menu
            else if (c == 7) {
                displayMenu();
            }
            // Exit
            else if (c == 0) {
                flag = 0;
            }
        }
    }

    static void displayMenu() {
        System.out.println("--------------------------Menu------------------------\n\n\n");
        for (MenuItem menuItem : Menu) {
            System.out.printf("%-23s %-6drs\n", menuItem.name, menuItem.price);
        }
    }

    static void check(int n, int m) {
        for (int i = n; i < m; i++) {
            System.out.printf("%-23d ", i % 7 + 1);
            if (table[i] == 1) {
                System.out.println("Booked");
            } else {
                System.out.println("Not Booked");
            }
        }
    }

    
    static void booking(int T, int S) {
        NoOfCustomers++;
        CId++;
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Enter you phone number: ");
        int number = scanner.nextInt();
        int[] ord = new int[5];
        int Amount = 0;
        int tab = T;
        int TS = S;

        int play = 1;
        displayMenu();
        System.out.println("Do you want to order something: ");
        int i = 0;
        while (play == 1) {
            ord[i] = scanner.nextInt();
            Amount += Menu[ord[i] - 1].price;
            collection += Menu[ord[i] - 1].price;
            i++;
            System.out.println("Do you want to order something else(1-yes, 0-No): ");
            play = scanner.nextInt();
        }
        ord[i] = 0;
        i = 0;

        Customer newCustomer = new Customer(name, number, DATE, ord, Amount, tab, CId, TS);
        newCustomer.next = head;
        head = newCustomer;
        System.out.println("Customer ID - " + CId + "\n\n");
    }
}

