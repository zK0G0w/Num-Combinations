package org.example.numcombinations.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberCombinationsService {

    /**
     * 生成所有可能的数字组合
     *
     * @param oddNumbers 奇数数组
     * @param evenNumbers 偶数数组
     * @return 所有组合的列表
     */
    public List<String> generateCombinations(int[] oddNumbers, int[] evenNumbers) {
        List<String> allCombinations = new ArrayList<>();
        generateCombinationsHelper(oddNumbers, evenNumbers, "", allCombinations);
        return allCombinations;
    }

    /**
     * 辅助方法，递归生成所有组合
     *
     * @param oddNumbers 奇数数组
     * @param evenNumbers 偶数数组
     * @param currentCombination 当前组合
     * @param allCombinations 所有组合的列表
     */
    private void generateCombinationsHelper(int[] oddNumbers, int[] evenNumbers,
                                             String currentCombination, List<String> allCombinations) {
        if (currentCombination.length() == 4) {
            allCombinations.add(currentCombination);
            return;
        }

        // 添加奇数
        for (int odd : oddNumbers) {
            generateCombinationsHelper(oddNumbers, evenNumbers, currentCombination + odd, allCombinations);
        }

        // 添加偶数
        for (int even : evenNumbers) {
            generateCombinationsHelper(oddNumbers, evenNumbers, currentCombination + even, allCombinations);
        }
    }
}