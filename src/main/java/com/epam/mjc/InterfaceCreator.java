package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (String s : strings) {
                if (!Character.isUpperCase(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            List<Integer> evenValues = new ArrayList<>();
            for (Integer i : integers) {
                if (i % 2 == 0) {
                    evenValues.add(i);
                }
            }
            integers.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> stringListSort = new ArrayList<>();
            for (String string : values) {
                String[] numOfWords = string.split(" ");
                if (numOfWords.length > 3 && Character.isUpperCase(string.charAt(0)) && string.charAt(string.length() - 1) == '.') {
                    stringListSort.add(string);
                }
            }
            return stringListSort;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> {
            Map<String, Integer> mapForThatStrings = new HashMap<>();
            for (String s : strings) {
                mapForThatStrings.put(s, s.length());
            }
            return mapForThatStrings;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> {
            List<Integer> resultList = new ArrayList<>();
            resultList.addAll(integers);
            resultList.addAll(integers2);
            return resultList;
        };
    }
}
