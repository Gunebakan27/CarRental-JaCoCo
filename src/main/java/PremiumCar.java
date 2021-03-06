
/**
 * This class is an extension of the Car class
 *
 * @author Max Sova CSE1OFX Assessment 3
 */
public class PremiumCar extends Car {

    private final double INSURANCERATE = 0.05;

    /**
     *
     * @param carRate
     * @param carName
     * @param carType
     */
    public PremiumCar(double carRate, String carName, String carType) {
        super(carRate, carName, carType);

    }

    /**
     *
     * @return
     */
    @Override
    public double getCarRate() {

        this.carRate = carRate * INSURANCERATE + carRate;
        return carRate;
    }

}
