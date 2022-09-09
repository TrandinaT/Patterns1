package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        String[] ArrayOfCities = {"Абакан", "Владикавказ", "Екатеринбург", "Йошкар-Ола", "Казань", "Калининград",
                "Калуга", "Краснодар", "Красноярск", "Курган", "Махачкала", "Москва", "Петропавловск-Камчатский",
                "Сыктывкар", "Чебоксары", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Абакан", "Владимир",
                "Нарьян-Мар", "Салехард", "Абакан", "Самара", "Санкт-Петербург", "Абакан", "Ставрополь", "Хабаровск"};
        Random random = new Random();
        int city = random.nextInt(ArrayOfCities.length);
        return ArrayOfCities[city];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class registration {
        private registration() {
        }

        public static userInfo generateUser(String locale) {
            return new userInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class userInfo {
        String city;
        String name;
        String phone;
    }
}