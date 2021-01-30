import java.util.*;
import java.io.*;
import java.lang.*;


class City {
    int x;
    int y;
    String name;
    City nearestCityX;
    City nearestCityY;
    City nearestCity;
    
    public City(String name, int x, int y) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
}

public class Solution {
    public String[] findNearestCities(int numOfPoints, String[] points,
            int[] xCoordinates,
            int[] yCoordinates,
            int numOfQueriedPoints,
            String[] queriedPoints) {
        City[] allCities = new City[numOfPoints];
        HashMap<String, City> map = new HashMap<>();
        for (int i = 0; i < numOfPoints; i++) {
            allCities[i] = new City(points[i], xCoordinates[i], yCoordinates[i]);
            map.put(allCities[i].name, allCities[i]);
        }
        Arrays.sort(allCities, (a, b) -> a.y - b.y);
        Arrays.sort(allCities, (a, b) -> a.x - b.x);
        int j;
        for (int i = 0; i < numOfPoints;) {
            for (j = i + 1; j < numOfPoints; j++) {
                if (allCities[j].x != allCities[i].x) {
                    break;
                }
            }
            if (i + 1 < j) {
                allCities[i].nearestCityY = allCities[i + 1];
                allCities[j - 1].nearestCityY = allCities[j - 2];
            }
            for (int k = i + 1; k < j - 1; k++) {
                allCities[k].nearestCityY = allCities[k - 1];
                City p = allCities[k + 1];
                if (p.y - allCities[k].y < allCities[k].y - allCities[k].nearestCityY.y) {
                    allCities[k].nearestCityY = p;
                } else if (p.y - allCities[k].y > allCities[k].y - allCities[k].nearestCityY.y) {
                    // DO NOTHING
                } else if (p.name.compareTo(allCities[k].nearestCityY.name) < 0) {
                    allCities[k].nearestCityY = p;
                }
            }
            i = j;
        }
        Arrays.sort(allCities, (a, b) -> a.y - b.y);
        for (int i = 0; i < numOfPoints;) {
            for (j = i + 1; j < numOfPoints; j++) {
                if (allCities[j].y != allCities[i].y) {
                    break;
                }
            }
            if (i + 1 < j) {
                allCities[i].nearestCityX = allCities[i + 1];
                allCities[j - 1].nearestCityX = allCities[j - 2];
            }
            for (int k = i + 1; k < j - 1; k++) {
                allCities[k].nearestCityX = allCities[k - 1];
                City p = allCities[k + 1];
                if (p.x - allCities[k].x < allCities[k].x - allCities[k].nearestCityX.x) {
                    allCities[k].nearestCityX = p;
                } else if (p.x - allCities[k].x > allCities[k].x - allCities[k].nearestCityX.x) {
                    // DO NOTHING
                } else if (p.name.compareTo(allCities[k].nearestCityX.name) < 0) {
                    allCities[k].nearestCityX = p;
                }
            }
            i = j;
        }
        for (City city : allCities) {
            city.nearestCity = city.nearestCityX;
            City p = city.nearestCityY;
            if (city.nearestCity == null) {
                city.nearestCity = p;
            } else if (p == null) {
                // DO NOTHING
            } else if (Math.abs(p.y - city.y) < Math.abs(city.x - city.nearestCity.x)) {
                city.nearestCity = p;
            } else if (Math.abs(p.y - city.y) > Math.abs(city.x - city.nearestCity.x)) {
                // DO NOTHING
            } else if (p.name.compareTo(city.nearestCity.name) < 0) {
                city.nearestCity = p;
            }
        }
        
        String[] result = new String[numOfQueriedPoints];
        for (int i = 0; i < numOfQueriedPoints; i++) {
            City temp = map.get(queriedPoints[i]).nearestCity;
            result[i] = temp == null ? null : temp.name;
        }
        return result;
    }
}
