package com.example.snowhub

import com.example.snowhub.infrastructure.resort
import com.example.snowhub.infrastructure.slope
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.ZoneId

@Component
class pyeungChangCrawler {

    fun crawling(){
        var result = mutableListOf<slope>()

        var date = LocalDate.now(ZoneId.of("Asia/Seoul"))

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe")

        var options = ChromeOptions()
        options.addArguments("--headless")
        options.addArguments("--remote-allow-origins=*")

        var driver :WebDriver = ChromeDriver(options)

        var difficulty = ""
        var slopeName: String
        var day = ""
        var night = ""
        var dawn = ""

        driver.get("https://phoenixhnr.co.kr/static/pyeongchang/snowpark/slope-lift")


        var resort = resort(
                null,
                "YoungPyong"
        )

        var tbodyElement = driver.findElement(By.tagName("tbody"))
        var lst = tbodyElement.findElements(By.tagName("tr"))

        for(e in lst){

            var thElement = e.findElements(By.tagName("th"))

            if(thElement.size==2){
                difficulty = thElement.get(0).text
                slopeName = thElement.get(1).text
            }else{
                slopeName = thElement.get(0).text
            }

            var tdElement = e.findElements(By.tagName("td"))

            if(tdElement.get(3).text == ""){
                day = "CLOSE"
            }else if(tdElement.get(3).text == "CLOSED"){
                day = "CLOSE"
            }else{
                day = "OPEN"
            }

            if(tdElement.get(4).text == ""){
                night = "CLOSE"
            }else if(tdElement.get(4).text == "CLOSED"){
                night = "CLOSE"
            }else{
                night = "OPEN"
            }

            var slope = slope(
                    null,
                    slopeName,
                    difficulty,
                    null,
                    day,
                    night,
                    dawn,
                    date,
                    resort
            )
            result.add(slope)

            println(slopeName +" = "+day +", "+night)
        }
    }
}