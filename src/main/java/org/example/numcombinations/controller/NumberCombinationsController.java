package org.example.numcombinations.controller;

import org.example.numcombinations.dto.ErrorResponseDTO;
import org.example.numcombinations.dto.ResponseDTO;
import org.example.numcombinations.service.NumberCombinationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class NumberCombinationsController {

    @Autowired
    private NumberCombinationsService combinationsService;

    @GetMapping("/combinations")
    public ResponseEntity<?> getCombinations(@RequestParam("odds") String oddNumbers, @RequestParam("evens") String evenNumbers) {
        int[] oddArray = parseNumbers(oddNumbers);
        int[] evenArray = parseNumbers(evenNumbers);

        // 验证奇数数组
        String oddValidationError = validateArray(oddArray, true);
        if (oddValidationError != null) {
            return new ResponseEntity<>(new ErrorResponseDTO("false", oddValidationError), HttpStatus.BAD_REQUEST);
        }

        // 验证偶数数组
        String evenValidationError = validateArray(evenArray, false);
        if (evenValidationError != null) {
            return new ResponseEntity<>(new ErrorResponseDTO("false", evenValidationError), HttpStatus.BAD_REQUEST);
        }

        List<String> combinations = combinationsService.generateCombinations(oddArray, evenArray);

        String message = "success";
        String text = "返回了 " + combinations.size() + " 个数";

        return new ResponseEntity<>(new ResponseDTO(message, text, combinations), HttpStatus.OK);
    }

    private int[] parseNumbers(String numbers) {
        String[] parts = numbers.split(",");
        return Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
    }

    private String validateArray(int[] numbers, boolean isOdd) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : numbers) {
            if (num < 0 || num > 9) {
                return "数组中存在超出范围的数值: " + num;
            }
            if ((isOdd && num % 2 == 0) || (!isOdd && num % 2 != 0)) {
                return (isOdd ? "奇数" : "偶数") + "数组中存在不符合要求的数值: " + num;
            }
            if (!uniqueNumbers.add(num)) {
                return (isOdd ? "奇数" : "偶数") + "数组中存在重复的数值: " + num;
            }
        }
        return null; // No errors
    }
}