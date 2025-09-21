package ru.vasilkov.LAB1.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class HelloController {

    private ArrayList<String> arrayList;
    private HashMap<Integer, String> hashMap;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "arg", defaultValue = "") String arg) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (!Objects.equals(arg, "")) {
            arrayList.add(arg);
        }
    }

    @GetMapping("/show-array")
    public ArrayList<String> showArrayList() {
        if(arrayList == null || arrayList.isEmpty()) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "arg", defaultValue = "") String arg) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (!Objects.equals(arg, "")) {
            int key = hashMap.size() + 1;
            hashMap.put(key, arg);
        }
    }

    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap() {
        if(hashMap == null || hashMap.isEmpty()) {
            return new HashMap<>();
        }
        return hashMap;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arrayListSize = 0;
        int hashMapSize = 0;
        if(arrayList != null) {
            arrayListSize = arrayList.size();
        }
        if(hashMap != null) {
            hashMapSize = hashMap.size();
        }
        return "ArrayList size: " + arrayListSize + ", HashMap size: " + hashMapSize;
    }
}
