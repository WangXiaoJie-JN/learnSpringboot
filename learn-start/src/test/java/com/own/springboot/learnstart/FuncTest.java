package com.own.springboot.learnstart;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FuncTest {

    private Logger logger = LoggerFactory.getLogger(FuncTest.class);
    /**
     * 集合转数组
     */
    @Test
    public void ListToArray(){

        List<String> list = new ArrayList<String>();
        list.add("first");
        list.add("second");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        logger.info("array="+array[0]+","+array[1]);
    }

    /**
     * 数组转换成集合（1）
     * @return
     */
    @Test
    public void ArrayToList(){
        String[] array = new String[]{"first","second"};
        List<String> list = new ArrayList<String>(array.length);
        Collections.addAll(list,array);
        logger.info("list="+list);
    }

    /**
     * 数组转换成列表2
     * @return
     */
    @Test
    public void ArrayToList2(){
        String[] array = new String[]{"first","second"};
        List<String> list = Arrays.asList(array);
        List newList = new ArrayList(list);
        newList.add("third");
        logger.info("newList="+newList);
    }

    @Test
    public void MapTest(){
        HashMap map = new HashMap(5);
        map.put("1","first");
        map.put("2","second");
        map.put("3","third");
        map.put("4","fourth");
        map.put("5","fifth");
        map.put("6","first");
        // jdk 8 遍历
        map.forEach((key,value) -> {logger.info("key="+key+";value="+value);});
        // set
        Set<String> set = new HashSet(map.values());
        set.forEach((key)->{logger.info("set-key="+key);});
        // 有序
        Set<String> orderSet = new LinkedHashSet(map.values());
        orderSet.forEach((key)->{logger.info("orderSet-key="+key);});
        // Set<Map.Entry<String,String>> entrys = map.entrySet();

    }

    /**
     *
     * java 8 代替 DATE
     */
    @Test
    public void DateJava8(){
        // DateTimeFormatter 代替 SimpleDateFormat
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Instant 代替 Date
        // Date date = new Date();
        //Instant instant = Instant.now();
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        DayOfWeek week = dateTime.getDayOfWeek();
        LocalDate dateTime2 = LocalDate.parse("2019-06-06",dtf);
        System.out.println("时间："+dtf.format(date)+";dateTime="+dtf.format(dateTime)+
                "星期几="+week.name()+";dateTime2="+dateTime2.toString());
    }

    /**
     * 随机数生成
     */
    @Test
    public void getRabdomNum(){

        // jdk 7 之前
        Random random = new Random();
        int index = 0;
        StringBuffer buf = new StringBuffer("");
        do{
            Integer num = random.nextInt(10);
            index += 1;
            buf.append(num.toString());
        }while(index < 6);
        logger.info("六位随机数："+buf);

        // ThreadLocalRandom 提升性能，是每个线程有单独的实例
        StringBuilder builder = new StringBuilder("");
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for(int i = 0; i < 6; i++){
            int localNum = threadLocalRandom.nextInt(10);
            builder.append(localNum);
        }
        logger.info("ThreadLocal 生成六位随机数："+builder.toString());
    }

    public void AtmicProperty(){
        AtomicInteger  count = new AtomicInteger(0);
    }
}
