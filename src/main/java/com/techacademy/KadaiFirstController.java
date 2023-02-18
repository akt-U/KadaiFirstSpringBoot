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
        @GetMapping("/plus/{val1}/{val2}")
        public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
            int res = 0;
            res = val1 + val2;
            return "実行結果：" + res;
    }
        @GetMapping("/minus/{val1}/{val2}")
        public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
            int res = 0;
            res = val1 - val2;
            return "実行結果：" + res;

}
        @GetMapping("/times/{val1}/{val2}")
        public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
            int res = 0;
            res = val1 * val2;
            return "実行結果：" + res;
}
        @GetMapping("/divide/{val1}/{val2}")
        public String calcDivide(@PathVariable double val1, @PathVariable double val2) {
            double res = 0;
            /*if(val2==0) {
                throw new IllegalArgumentException("0を入力しないでください。");
            }*/
            res = val1 / val2;
            return "実行結果：" + res;
        }
}