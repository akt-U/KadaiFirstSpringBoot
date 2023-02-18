package com.techacademy;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {
    @GetMapping("/dayofweek/{dateString}")
    public String dispDayOfWeek(@PathVariable String dateString) {
        try {
            // 日付文字列をLocalDateに変換
            LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);
            // 曜日を取得
            String dayOfWeek = date.getDayOfWeek().toString();
            return dayOfWeek;
        } catch (DateTimeParseException e) {
            // 日付文字列の形式が不正な場合はエラーを返す
            return "Invalid date format. Please use yyyymmdd format.";
        }
    }
}


