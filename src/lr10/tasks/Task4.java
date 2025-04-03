package lr10.tasks;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Task4 {
    public static void main(String[] args) {
        String url = "https://itlearn.ru/first-steps";
        //String url = "https://httpbin.org/status/500";
        int maxAttempts = 5;
        int attemptNumber = 0;

        while (attemptNumber < maxAttempts) {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a[href]");
                JSONArray jsonArray = new JSONArray();
                for (Element link : links) {
                    String linkHref = link.attr("abs:href");
                    jsonArray.add(linkHref);
                    System.out.println(link.attr("abs:href"));
                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("links", jsonArray);
                try (FileWriter file = new FileWriter("./src/lr10/tasks/links.json")) {
                    file.write(jsonObject.toJSONString());
                    System.out.println("JSON файл успешно создан");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            } catch (IOException e) {
                attemptNumber++;
                if (attemptNumber < maxAttempts) {
                    System.out.printf("Ошибка при попытке получить HTML-код страницы. Попытка %d из %d\n", attemptNumber, maxAttempts);
                } else {
                    System.out.println("Не удалось подключиться к сайту");
                }
            }
        }

    }
}
