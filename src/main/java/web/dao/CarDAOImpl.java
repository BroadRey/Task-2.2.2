package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {
    private static List<Car> cars;

    static {
        cars = new ArrayList<>();
        cars.add(new Car("porsche", 11, 2));
        cars.add(new Car("honda", 6, 1));
        cars.add(new Car("toyota", 17, 4));
        cars.add(new Car("mitsubishi", 31, 5));
        cars.add(new Car("lada", 13, 6));
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == 0) {
            return cars;
        }

        return cars.stream()
                .limit(count)
                .toList();
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }
}
