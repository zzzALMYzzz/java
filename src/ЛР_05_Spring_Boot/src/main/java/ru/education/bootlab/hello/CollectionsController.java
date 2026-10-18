package ru.education.bootlab.hello;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CollectionsController {
    private ArrayList<String> array;
    private HashMap<Integer, String> map;
    private int nextKey = 1;
    @GetMapping(value = "/update-array",
        produces = "text/plain;charset=UTF-8")
    public synchronized String updateArrayList(
        @RequestParam(name = "s") String s) {
        if (array == null) {
            array = new ArrayList<>();
        }
        array.add(s);
        return "Added to ArrayList: " + s;
    }
    @GetMapping("/show-array")
    public synchronized ArrayList<String> showArrayList() {
        return array == null
            ? new ArrayList<>() : new ArrayList<>(array);
    }
    @GetMapping(value = "/update-map",
        produces = "text/plain;charset=UTF-8")
    public synchronized String updateHashMap(
        @RequestParam(name = "s") String s) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(nextKey++, s);
        return "Added to HashMap: " + s;
    }
    @GetMapping("/show-map")
    public synchronized HashMap<Integer, String> showHashMap() {
        return map == null
            ? new HashMap<>() : new HashMap<>(map);
    }
    @GetMapping(value = "/show-all-lenght",
        produces = "text/plain;charset=UTF-8")
    public synchronized String showAllLenght() {
        int arraySize = array == null ? 0 : array.size();
        int mapSize = map == null ? 0 : map.size();
        return "ArrayList: " + arraySize + "; HashMap: " + mapSize;
    }
}
