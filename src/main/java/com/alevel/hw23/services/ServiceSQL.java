package com.alevel.hw23.services;

import com.alevel.hw23.models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class ServiceSQL {
    private static Connection connection;
    private static Statement statement;

    public ServiceSQL() {
        try {
            connection = DriverManager.getConnection(
                    InfoSQL.URL.get(), InfoSQL.USER.get(), InfoSQL.PASSWORD.get());
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        createTables();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(id_factory) FROM factory");
            if (resultSet.next()) {
                Factory.setCountFactory(resultSet.getInt(1));
            }
            resultSet = statement.executeQuery("SELECT COUNT(id_device) FROM device");
            if (resultSet.next()) {
                Device.setCountDevice(resultSet.getInt(1));
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTables() {
        try {
            statement.execute("CREATE TABLE Factory (\n" +
                    "    id_factory int NOT NULL AUTO_INCREMENT,\n" +
                    "    name_factory varchar(35) NOT NULL,\n" +
                    "    country varchar(30) NOT NULL,\n" +
                    "    PRIMARY KEY (id_factory)\n" +
                    ");");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            statement.execute("CREATE TABLE Device (\n" +
                    "    id_device int NOT NULL AUTO_INCREMENT,\n" +
                    "    type varchar(30) NOT NULL,\n" +
                    "    name_model varchar(55) NOT NULL,\n" +
                    "    price int NOT NULL,\n" +
                    "    release_date date NOT NULL,\n" +
                    "    description varchar(255) NOT NULL,\n" +
                    "    availability boolean NOT NULL,\n" +
                    "    id_factory int NOT NULL,\n" +
                    "    PRIMARY KEY (id_device)\n" +
                    ");");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertFactories(Factory... factories) {
        if (factories == null) {
            return;
        }
        for (Factory factory : factories) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO homework.factory (name_factory, country) VALUES (?, ?);"
                );
                preparedStatement.setString(1, factory.getNameFactory());
                preparedStatement.setString(2, factory.getCountry().toString());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertDevices(Device... devices) {
        if (devices == null) {
            return;
        }
        for (Device device : devices) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO homework.device " +
                                "(type, name_model, price, release_date, description, availability, id_factory)" +
                                " VALUES (?, ?, ?, ?, ?, ?, ?);"
                );
                preparedStatement.setString(1, device.getType().toString());
                preparedStatement.setString(2, device.getNameModel());
                preparedStatement.setInt(3, device.getPrice());
                preparedStatement.setDate(4, device.getReleaseDate());
                preparedStatement.setString(5, device.getDescription());
                preparedStatement.setBoolean(6, device.isAvailability());
                preparedStatement.setInt(7, device.getIdFactory());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getInfoById(int id) {
        Device device = getDeviceById(id);
        Factory factory = getFactoryById((device != null) ? device.getIdFactory() : 0);

        if (device != null && factory != null) {
            return device.toString() + factory;
        }
        return null;
    }

    private Device getDeviceById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM device WHERE id_device=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Device(
                        resultSet.getInt("id_device"),
                        DeviceType.valueOf(resultSet.getString("type")),
                        resultSet.getString("name_model"),
                        resultSet.getInt("price"),
                        resultSet.getDate("release_date"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("availability"),
                        resultSet.getInt("id_factory")
                );
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Device> getDevicesByFactoryId(int id) {
        ArrayList<Device> list = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * " +
                    "FROM device LEFT JOIN factory " +
                    "ON device.id_factory = factory.id_factory WHERE device.id_factory=?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new Device(
                        resultSet.getInt("id_device"),
                        DeviceType.valueOf(resultSet.getString("type")),
                        resultSet.getString("name_model"),
                        resultSet.getInt("price"),
                        resultSet.getDate("release_date"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("availability"),
                        resultSet.getInt("id_factory")
                ));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    private Factory getFactoryById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM factory WHERE id_factory=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Factory(
                        resultSet.getInt("id_factory"),
                        resultSet.getString("name_factory"),
                        Country.valueOf(resultSet.getString("country"))
                );
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void factoryInfo() {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(id_device) FROM device GROUP BY id_factory");
            while (resultSet.next()) {
                System.out.println("Count: " + resultSet.getInt(1));
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDeviceById(int id) {
        Random rand = new Random();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE homework.device SET type = ?, name_model = ?, price = ?, release_date = ?," +
                            " description = ?, availability = ? WHERE (id_device = ?);\n");
            preparedStatement.setString(1, DeviceType.values()[rand.nextInt(DeviceType.values().length)].toString());
            preparedStatement.setString(2, "UpdatedModel");
            preparedStatement.setInt(3, Math.abs(rand.nextInt()));
            preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(5, "Some another description");
            preparedStatement.setBoolean(6, false);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteDeviceById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM homework.device " +
                    "WHERE (id_device = ?);\n");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Factory> readAllFactories() {
        ArrayList<Factory> list = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM factory");
            list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new Factory(
                        resultSet.getInt("id_factory"),
                        resultSet.getString("name_factory"),
                        Country.valueOf(resultSet.getString("country"))
                ));
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Device> readAllDevice() {
        ArrayList<Device> list = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM device");
            list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new Device(
                        resultSet.getInt("id_device"),
                        DeviceType.valueOf(resultSet.getString("type")),
                        resultSet.getString("name_model"),
                        resultSet.getInt("price"),
                        resultSet.getDate("release_date"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("availability"),
                        resultSet.getInt("id_factory")
                ));
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
