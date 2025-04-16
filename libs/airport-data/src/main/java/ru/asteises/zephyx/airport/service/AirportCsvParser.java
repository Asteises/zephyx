package ru.asteises.zephyx.airport.service;

import org.springframework.stereotype.Component;
import ru.asteises.zephyx.airport.model.AirportEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Component
public class AirportCsvParser {

    public static List<AirportEntity> parse() throws IOException {
        List<AirportEntity> airports = new ArrayList<>();

        // Загрузка файла из ресурсов
        try (InputStream is = AirportCsvParser.class.getResourceAsStream("/new_apinfo.ru.csv");
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(is, Charset.forName("Windows-1251")))) {

            String line;
            boolean isHeaderSkipped = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Пропускаем пустые строки и заголовок
                if (line.isEmpty()) {
                    continue;
                }
                if (!isHeaderSkipped) {
                    isHeaderSkipped = true;
                    continue;
                }

                // Разбиваем строку с сохранением пустых значений
                String[] values = line.split("\\|", -1);

                // Создаем и заполняем объект аэропорта
                AirportEntity airport = new AirportEntity();

                // Обрабатываем каждое поле с проверкой на пустые значения
                airport.setIataCode(getValue(values, 1));          // iata_code (позиция 1)
                airport.setIcaoCode(getValue(values, 3));          // icao_code (позиция 3)
                airport.setNameRus(getValue(values, 5));           // name_rus (позиция 5)
                airport.setNameEng(getValue(values, 7));           // name_eng (позиция 7)
                airport.setCityRus(getValue(values, 9));           // city_rus (позиция 9)
                airport.setCityEng(getValue(values, 11));          // city_eng (позиция 11)
                airport.setGmtOffset(getValue(values, 13));        // gmt_offset (позиция 13)
                airport.setCountryRus(getValue(values, 15));       // country_rus (позиция 15)
                airport.setCountryEng(getValue(values, 17));       // country_eng (позиция 17)
                airport.setIsoCode(getValue(values, 19));          // iso_code (позиция 19)
                airport.setLatitude(parseDouble(values[21]));      // latitude (позиция 21)
                airport.setLongitude(parseDouble(values[23]));     // longitude (позиция 23)
                airport.setRunwayLength(parseInt(values[25]));     // runway_length (позиция 25)
                airport.setRunwayElevation(parseInt(values[27]));  // runway_elevation (позиция 27)
                airport.setPhone(getValue(values, 29));            // phone (позиция 29)
                airport.setEmail(getValue(values, 31));            // email (позиция 31)
                airport.setWebsite(getValue(values, 33));          // website (позиция 33)

                airports.add(airport);
            }
        }

        return airports;
    }

    private static String getValue(String[] values, int index) {
        if (index >= values.length || values[index] == null || values[index].trim().isEmpty()) {
            return null;
        }
        return values[index].trim();
    }

    private static Double parseDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка парсинга double: " + value);
            return null;
        }
    }

    private static Integer parseInt(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка парсинга int: " + value);
            return null;
        }
    }

}
