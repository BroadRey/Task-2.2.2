package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAOImpl;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private CarDAOImpl carDAO;

    @Autowired
    public CarServiceImpl(CarDAOImpl carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getCars(Integer count) {
        List<Car> cars;
        if (count != null && count > 0) {
            cars = carDAO.getCars(count);
        } else {
            cars = carDAO.getAllCars();
        }
        return cars;
    }

    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }
}
