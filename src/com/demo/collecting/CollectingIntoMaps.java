package com.demo.collecting;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {
    public static Stream<People> people(){
        return Stream.of(new People("Perter",1001),
                new People("Paul",1002),new People("Mary",1003));
    }

    public static void main(String[] args) {

        //通过在其中调用类的方法赋予键值对
        Map<Integer,String> idToName = people().collect(Collectors.toMap(People::getId,People::getName));
        System.out.println("idToName:"+idToName);

        //getId赋予键，Function::identity获得的是整个对象作为值
        Map<Integer,People> idToPerson = people().collect(Collectors.toMap(People::getId,Function.identity()));
        System.out.println("idToPerson："+idToPerson.getClass().getName()+idToPerson);

        //后续的内容为，如果存在两个相同的元素，就抛出异常，要不然新建一个TreeSet
        idToPerson = people().collect(Collectors.toMap(People::getId,Function.identity(),
                (existingValue,newValue)->{throw new IllegalStateException();}, TreeMap::new));
        System.out.println("idToPerson："+idToPerson.getClass().getName()+idToPerson);

        //若果存在两个相同的元素，则用老元素代替新元素
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String,String> languageName = locales.collect(Collectors.toMap(
                Locale::getDisplayLanguage,
                l->l.getDisplayLanguage(l),
                (exitingValue,newValue)->exitingValue
                ));
        System.out.println("languageName:"+languageName);

        locales = Stream.of(Locale.getAvailableLocales());
//        Map<String,Set<String>> countryLanguageSets = locales.collect(
//                Collectors.toMap(
//                        Locale::getDisplayCountry,
//                        //没有Set.of方法，可以将语言转化为list，然后通过new生成一个HashSet
//                        l-> new HashSet<>(Arrays.asList(l.getDisplayLanguage())),
//                        //前面两个参数分别对应a和b
//                        (a,b)->{
//                            Set<String> union = new HashSet<>(a);
//                            union.addAll(b);
//                            return union;
//                        }));
        Map<String,Set<String>> countryLanguageSets = locales.collect(Collectors.groupingBy(
                Locale::getDisplayCountry,
                Collectors.mapping(Locale::getDisplayLanguage,Collectors.toSet())));
        System.out.println("countryLanguageSets:"+countryLanguageSets);

        //流用完之后需要重新定义
        locales = Stream.of(Locale.getAvailableLocales());
        //使用groupingBy方法更简单的生成群组，即Map，会将具有相同键的元素放入一个列表中，键有groupBy后面的内容产生
        Map<String,List<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getCountry));
        List<Locale> swissLocales = countryToLocales.get("CH");
        System.out.println(swissLocales);

        locales = Stream.of(Locale.getAvailableLocales());
        //partitioningBy会形成两个键，true和false，分别根据判断结果进行存放元素，partitioningBy后要跟有判断条件
        Map<Boolean,List<Locale>> englishAndOtherLocales = locales.collect(
                Collectors.partitioningBy(l->l.getLanguage().equals("en")));
        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        System.out.println(englishLocales);
    }
}
