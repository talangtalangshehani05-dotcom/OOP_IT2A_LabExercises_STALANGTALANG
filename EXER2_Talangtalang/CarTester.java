public class CarTester {
    public static void main(String[] args) {
        Car[] cars = new Car[10];

        cars[0] = new Car("BMW", "Germany", "BMW123", "CH001", 6000000, 250);
        cars[1] = new Car("Cadillac", "USA", "CAD456", "CH002", 7500000, 240);
        cars[2] = new Car("Daimler", "Germany", "DAI789", "CH003", 7000000, 230);
        cars[3] = new Car("Cupra", "Spain", "CUP111", "CH004", 3500000, 220);
        cars[4] = new Car("Audi", "Germany", "AUD222", "CH005", 5000000, 240);
        cars[5] = new Car("Daewoo", "Korea", "DAE333", "CH006", 1200000, 180);
        cars[6] = new Car("Brabus", "Germany", "BRA444", "CH007", 15000000, 260);
        cars[7] = new Car("BYD", "China", "BYD555", "CH008", 2000000, 200);
        cars[8] = new Car("Tesla", "USA", "TES666", "CH009", 8000000, 250);
        cars[9] = new Car("Lamborghini", "Italy", "LAM777", "CH010", 20000000, 320);

        // Display all car details
        for (Car car : cars) {
            car.displayInfo();
        }
    }
}
