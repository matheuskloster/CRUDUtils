package com.kloster.configuration.api.controller.mbaas;

import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mbaas")
public class ExercicioAula020324 {



    @GetMapping("/diff/days")
    public long diffDays(@RequestParam("data1") String data1, @RequestParam("data2") String data2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(data1, formatter);
        LocalDate date2 = LocalDate.parse(data2, formatter);
        return ChronoUnit.DAYS.between(date1, date2);
    }

    @GetMapping("/diff/weeks")


    public long diffWeeks(
            @ApiParam(value = "First date in the format yyyy-MM-dd", defaultValue = "2023-01-01") @RequestParam("data1") String data1,
            @ApiParam(value = "Second date in the format yyyy-MM-dd", defaultValue = "2023-01-07") @RequestParam("data2") String data2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(data1, formatter);
        LocalDate date2 = LocalDate.parse(data2, formatter);
        return ChronoUnit.WEEKS.between(date1, date2);
    }

    @GetMapping("/diff/months")
    public long diffMonths(@RequestParam("data1") String data1, @RequestParam("data2") String data2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(data1, formatter);
        LocalDate date2 = LocalDate.parse(data2, formatter);
        return ChronoUnit.MONTHS.between(date1, date2);
    }


    @GetMapping("mimificator")
    //recebe uma string e retorna as vogais substituidas por i
    public String mimificator(@RequestParam("entrada") String entrada) {
        return entrada.replaceAll("[aeouãõ]", "i")
                .replaceAll("[áéíóú]", "í")
                .replaceAll("[âêô]", "î");

    }

    @GetMapping("numbers/ascending")
    @ApiParam(value = "Numbers separated by semicolon", defaultValue = "1;2;3;4;5;6;7;8;9;10;11")
    public List<Integer> getNumbersInAscendingOrder(@RequestParam("numbers") String numbers) {
        return Arrays.stream(numbers.split(";"))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

    }


    @GetMapping("numbers/descending")
    @ApiParam(value = "Numbers separated by semicolon", defaultValue = "1;2;3;4;5;6;7;8;9;10;11")
    public List<Integer> getNumbersInDescendingOrder(@RequestParam("numbers") String numbers) {
        return Arrays.stream(numbers.split(";"))
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }


    @GetMapping("numbers/even")
    @ApiParam(value = "Numbers separated by semicolon", defaultValue = "1;2;3;4;5;6;7;8;9;10;11")
    public List<Integer> getEvenNumbers(@RequestParam("numbers") String numbers) {
        return Arrays.stream(numbers.split(";"))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
}
