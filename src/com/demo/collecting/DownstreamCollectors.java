package com.demo.collecting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class DownstreamCollectors {
    public static Stream <City> readCities(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                //用逗号进行分割元素
                .map(l->l.split(","))
                .map(a->new City(a[0],a[1],Integer.parseInt(a[2])));
    }

    public static void main(String[] args) throws IOException {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        //groupingBy(Locales::getCountry，toSet())生成了一个map容器，键为Locales城市名，值为Locales的Set集合
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(groupingBy(
                Locale::getCountry,toSet()));
        System.out.println("countryToLocaleSet"+countryToLocaleSet);

        locales = Stream.of(Locale.getAvailableLocales());
        //生成的键值对键为Locales的城市名，值为每一个城市名下的元素数量综合
        Map<String,Long> countryToLocaleCounts = locales.collect(groupingBy(
                Locale::getCountry,counting()));
        System.out.println("countryToLocaleCounts"+countryToLocaleCounts);

        Stream<City> cities = readCities("cities.txt");
        //键为城市的洲名，值为各个州的人口总和，summingInt(元素)，对元素内的数据进行求和
        Map<String,Integer> stateToCityPopulation = cities.collect(groupingBy(
                City::getState,summingInt(City::getPopulation)));
        System.out.println("stateToCityPopulation"+stateToCityPopulation);

        cities = readCities("cities.txt");
        //键为洲名，值为一洲之中城市名最长的城市
        Map<String, Optional<String>> stateToLongCityName = cities.collect(groupingBy(
                City::getState,mapping(City::getName,maxBy(Comparator.comparing(String::length)))));
        System.out.println("stateToLongCityName"+stateToLongCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String,Set<String>> countryToLanguages = locales.collect(groupingBy(
                Locale::getDisplayCountry,mapping(Locale::getDisplayLanguage,toSet())));
        System.out.println("countryToLanguages"+countryToLanguages);

        cities = readCities("cities.txt");
        //键为洲名，值为summarizingInt根据运算产生的所有值，包括总和，平均值，最大最小值
        Map<String,IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(groupingBy(
                City::getState,summarizingInt(City::getPopulation)));
        System.out.println("stateToCityPopulationSummary"+stateToCityPopulationSummary);
        System.out.println(stateToCityPopulationSummary.get("NY"));

        cities = readCities("cities.txt");
        Map<String,String> stateToCityName = cities.collect(groupingBy(
                City::getState,
                reducing("",City::getName,(s,t)->s.length() == 0 ? s:s+", "+t)));
        System.out.println("stateToCityName"+stateToCityName);

        cities = readCities("cities.txt");
        stateToCityName = cities.collect(groupingBy(
                City::getState,mapping(City::getName,joining(","))));
        System.out.println("stateToCityName"+stateToCityName);

        cities = readCities("cities.txt");

        Map<String,Object> stringCountsByStartingLetters = cities.collect(groupingBy(
                City::getState,collectingAndThen(toSet(),Set::size)));
        System.out.println(stringCountsByStartingLetters);
    }

}
