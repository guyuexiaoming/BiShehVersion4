/**
 *
 *
 */
package com.zut.controller;

import com.zut.entity.Money;
import com.zut.service.OrdersService;
import com.zut.service.RService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import net.sf.json.JSONArray;


@Controller
@RequestMapping("eCharts")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EChartsController {

    @Resource
    private OrdersService ordersService;
    @Resource
    private RService rService;

    /**
     * 年收支分析
     *
     * @return JSON数据集
     */
    @RequestMapping(value = "getDataYear" , method = RequestMethod.POST)
    @ResponseBody
    public String getData(){
        String s = "";
        //查询时间段
        Calendar cal=Calendar.getInstance();
        int year6 = cal.get(Calendar.YEAR);
        int year5 = year6-1;
        int year4 = year6-2;
        int year3 = year6-3;
        int year2 = year6-4;
        int year1 = year6-5;
        System.out.println(String.valueOf(year1));
        //收入分析算法
        Integer oneYear = ordersService.querySumMoney(String.valueOf(year1),String.valueOf(year2));
        if (oneYear==null){
            oneYear=0;
        }
        System.out.println(oneYear);


        Money money = new Money();
        money.setMoneys(oneYear);
        s=String.valueOf(year1)+"to"+String.valueOf(year2);
        money.setTime(s);

        List<Money> moneyList = new ArrayList<>();
        moneyList.add(money);


        Integer twoYear = ordersService.querySumMoney(String.valueOf(year2),String.valueOf(year3));
        if (twoYear==null){
            twoYear=0;
        }
        Money money1 = new Money();
        money1.setMoneys(twoYear);
        s=String.valueOf(year2)+"to"+String.valueOf(year3);
        money1.setTime(s);

        moneyList.add(money1);
        Integer threeYear = ordersService.querySumMoney(String.valueOf(year3),String.valueOf(year4));
        if (threeYear==null){
            threeYear=0;
        }
        Money money2 = new Money();
        money2.setMoneys(threeYear);
        s=String.valueOf(year3)+"to"+String.valueOf(year4);
        money2.setTime(s);

        moneyList.add(money2);
        Integer fourYear = ordersService.querySumMoney(String.valueOf(year4),String.valueOf(year5));
        if (fourYear==null){
            fourYear=0;
        }
        Money money3 = new Money();
        money3.setMoneys(fourYear);
        s=String.valueOf(year4)+"to"+String.valueOf(year5);
        money3.setTime(s);

        moneyList.add(money3);
        Integer fiveYear = ordersService.querySumMoney(String.valueOf(year5),String.valueOf(year6));
        if (fiveYear==null){
            fiveYear=0;
        }
        Money money4 = new Money();
        money4.setMoneys(fiveYear);
        s=String.valueOf(year5)+"to"+String.valueOf(year6);
        money4.setTime(s);

        moneyList.add(money4);
        System.out.println("现在时刻是"+year6);


        String bu ="-00-00 00:00:00";
        //支出分析算法
        Integer oneYearOut = rService.querySumMoney(String.valueOf(year1)+bu,String.valueOf(year2)+bu);
        if (oneYearOut==null){
            oneYearOut=0;
        }
        System.out.println(oneYearOut);
        Money outMoney = new Money();
        outMoney.setMoneys(oneYearOut);
        s=String.valueOf(year1)+"to"+String.valueOf(year2);
        outMoney.setTime(s);


        moneyList.add(outMoney);


        Integer twoYearOut = rService.querySumMoney(String.valueOf(year2)+bu,String.valueOf(year3)+bu);
        if (twoYearOut==null){
            twoYearOut=0;
        }
        Money outMoney1 = new Money();
        outMoney1.setMoneys(twoYearOut);
        s=String.valueOf(year2)+"to"+String.valueOf(year3);
        outMoney1.setTime(s);

        moneyList.add(outMoney1);
        Integer threeYearOut = rService.querySumMoney(String.valueOf(year3)+bu,String.valueOf(year4)+bu);
        if (threeYearOut==null){
            threeYearOut=0;
        }
        Money outMoney2 = new Money();
        outMoney2.setMoneys(threeYearOut);
        s=String.valueOf(year3)+"to"+String.valueOf(year4);
        outMoney2.setTime(s);

        moneyList.add(outMoney2);
        Integer fourYearOut = rService.querySumMoney(String.valueOf(year4)+bu,String.valueOf(year5)+bu);
        if (fourYearOut==null){
            fourYearOut=0;
        }
        Money outMoney3 = new Money();
        outMoney3.setMoneys(fourYearOut);
        s=String.valueOf(year4)+"to"+String.valueOf(year5);
        outMoney3.setTime(s);

        moneyList.add(outMoney3);
        Integer fiveYearOut = rService.querySumMoney(String.valueOf(year5)+bu,String.valueOf(year6)+bu);
        if (fiveYearOut==null){
            fiveYearOut=0;
        }
        Money outMoney4 = new Money();
        outMoney4.setMoneys(fiveYearOut);
        s=String.valueOf(year5)+"to"+String.valueOf(year6);
        outMoney4.setTime(s);

        moneyList.add(outMoney4);
        System.out.println("现在时刻是"+year6);


        JSONArray json_data = JSONArray.fromObject(moneyList);// 转换为json数据格式
        String data = json_data.toString();
        return data;

    }

    /**
     * 季度收支分析
     *
     * @return JSON数据集
     */
    @RequestMapping(value = "getDataThreeMonth" , method = RequestMethod.POST)
    @ResponseBody
    public String getDataThreeMonth(){
        int money[] = new int[36];
        String m[] = new String[36];
        String s = "-00 00:00:00";
        //查询时间段
        Calendar cal=Calendar.getInstance();
        int year6 = cal.get(Calendar.YEAR);
        System.out.println(year6);

        int month60 = cal.get(Calendar.MONTH);
        month60++;
        System.out.println(month60);
        /**
         * 收入算法，查询时间以当前时间为基点
         */
        for(int i = 0,tm = 35;i<month60;i++){


            if(month60-i<10){
                m[tm] = String.valueOf(year6)+"-0"+String.valueOf(month60-i);
            }else {
                m[tm] = String.valueOf(year6)+"-"+String.valueOf(month60-i);
            }

            System.out.println(m[tm]+"第一次");
            tm--;

        }
        year6--;
        for(int i=35-month60,months = 12,t=0;i>0;i--,t++){
            if(months-t<1){
                t=0;
                year6--;
            }
            if(months-t<10){
                m[i] = String.valueOf(year6)+"-0"+String.valueOf(months-t);
            }else {
                m[i] = String.valueOf(year6)+"-"+String.valueOf(months-t);
            }

            System.out.println(m[i]);

        }
        List<Money> moneyList = new ArrayList<>();
        int cc = 0;
        for(int i = 35;i>1;i--){

            System.out.println(m[i]+m[i-1]);
            int moneyS = ordersService.querySumMoney(m[i-1],m[i]);
            System.out.println(moneyS+"结果********");
            Money money1 = new Money();
            money1.setMoneys(moneyS);
            String time = m[i-1]+"to"+m[i];
            money1.setTime(time);
            moneyList.add(money1);
            cc++;
        }
        System.out.println(cc);
        /**
         * 支出算法，查询时间以当前时间为基点
         */

        for(int i = 35;i>1;i--){
            System.out.println(m[i]+m[i-1]);
            int moneyS = rService.querySumMoney(m[i-1]+s,m[i]+s);
            System.out.println(moneyS+"结果********");
            Money money1 = new Money();
            money1.setMoneys(moneyS);
            String time = m[i-1]+"to"+m[i];
            money1.setTime(time);
            moneyList.add(money1);
        }

        /**
         *
        int year5 = year6-1;
        int year4 = year6-2;
        int year3 = year6-3;
        int year2 = year6-4;
        int year1 = year6-5;
        System.out.println(String.valueOf(year1));
        //收入分析算法
        Integer oneYear = ordersService.querySumMoney(String.valueOf(year1),String.valueOf(year2));
        if (oneYear==null){
            oneYear=0;
        }
        System.out.println(oneYear);


        Money money = new Money();
        money.setMoneys(oneYear);
        s=String.valueOf(year1)+"to"+String.valueOf(year2);
        money.setTime(s);

        List<Money> moneyList = new ArrayList<>();
        moneyList.add(money);


        Integer twoYear = ordersService.querySumMoney(String.valueOf(year2),String.valueOf(year3));
        if (twoYear==null){
            twoYear=0;
        }
        Money money1 = new Money();
        money1.setMoneys(twoYear);
        s=String.valueOf(year2)+"to"+String.valueOf(year3);
        money1.setTime(s);

        moneyList.add(money1);
        Integer threeYear = ordersService.querySumMoney(String.valueOf(year3),String.valueOf(year4));
        if (threeYear==null){
            threeYear=0;
        }
        Money money2 = new Money();
        money2.setMoneys(threeYear);
        s=String.valueOf(year3)+"to"+String.valueOf(year4);
        money2.setTime(s);

        moneyList.add(money2);
        Integer fourYear = ordersService.querySumMoney(String.valueOf(year4),String.valueOf(year5));
        if (fourYear==null){
            fourYear=0;
        }
        Money money3 = new Money();
        money3.setMoneys(fourYear);
        s=String.valueOf(year4)+"to"+String.valueOf(year5);
        money3.setTime(s);

        moneyList.add(money3);
        Integer fiveYear = ordersService.querySumMoney(String.valueOf(year5),String.valueOf(year6));
        if (fiveYear==null){
            fiveYear=0;
        }
        Money money4 = new Money();
        money4.setMoneys(fiveYear);
        s=String.valueOf(year5)+"to"+String.valueOf(year6);
        money4.setTime(s);

        moneyList.add(money4);
        System.out.println("现在时刻是"+year6);


        String bu ="-00-00 00:00:00";
        //支出分析算法
        Integer oneYearOut = rService.querySumMoney(String.valueOf(year1)+bu,String.valueOf(year2)+bu);
        if (oneYearOut==null){
            oneYearOut=0;
        }
        System.out.println(oneYearOut);
        Money outMoney = new Money();
        outMoney.setMoneys(oneYearOut);
        s=String.valueOf(year1)+"to"+String.valueOf(year2);
        outMoney.setTime(s);


        moneyList.add(outMoney);


        Integer twoYearOut = rService.querySumMoney(String.valueOf(year2)+bu,String.valueOf(year3)+bu);
        if (twoYearOut==null){
            twoYearOut=0;
        }
        Money outMoney1 = new Money();
        outMoney1.setMoneys(twoYearOut);
        s=String.valueOf(year2)+"to"+String.valueOf(year3);
        outMoney1.setTime(s);

        moneyList.add(outMoney1);
        Integer threeYearOut = rService.querySumMoney(String.valueOf(year3)+bu,String.valueOf(year4)+bu);
        if (threeYearOut==null){
            threeYearOut=0;
        }
        Money outMoney2 = new Money();
        outMoney2.setMoneys(threeYearOut);
        s=String.valueOf(year3)+"to"+String.valueOf(year4);
        outMoney2.setTime(s);

        moneyList.add(outMoney2);
        Integer fourYearOut = rService.querySumMoney(String.valueOf(year4)+bu,String.valueOf(year5)+bu);
        if (fourYearOut==null){
            fourYearOut=0;
        }
        Money outMoney3 = new Money();
        outMoney3.setMoneys(fourYearOut);
        s=String.valueOf(year4)+"to"+String.valueOf(year5);
        outMoney3.setTime(s);

        moneyList.add(outMoney3);
        Integer fiveYearOut = rService.querySumMoney(String.valueOf(year5)+bu,String.valueOf(year6)+bu);
        if (fiveYearOut==null){
            fiveYearOut=0;
        }
        Money outMoney4 = new Money();
        outMoney4.setMoneys(fiveYearOut);
        s=String.valueOf(year5)+"to"+String.valueOf(year6);
        outMoney4.setTime(s);

        moneyList.add(outMoney4);
        System.out.println("现在时刻是"+year6);

         */
        for (Money money1:moneyList) {

            System.out.println(money1.toString());
        }


        JSONArray json_data = JSONArray.fromObject(moneyList);// 转换为json数据格式
        String data = json_data.toString();
        return data;



    }





}
