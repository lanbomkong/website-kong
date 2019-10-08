package com.biosh.owner.common.util;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 * @description
 * @date 2019/8/19
 */
public class AmapUtil {

    public enum TravelType {
        // 步行
        WALKING(0),

        // 骑行
        BICYCLING(1),

        // 公交
        TRANSIT(2),

        // 驾车
        DRIVING(3);

        private int type;

        TravelType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    private static RestTemplate restTemplate = new RestTemplate();

    private static final String amapKey = "86255f1c932fef2dbe8dad6b2ed0384c";

    // 步行路径规划
    private static final String WALKING_URL = "https://restapi.amap.com/v3/direction/walking";

    // 骑行路径规划
    private static final String BICYCLING_URL = "https://restapi.amap.com/v3/direction/bicycling";

    // 公交路径规划
    private static final String TRANSIT_URL = "https://restapi.amap.com/v3/direction/transit/integrated";

    // 驾车路径规划
    private static final String DRIVING_URL = "https://restapi.amap.com/v3/direction/driving";

    private static final String params = "?origin=%s&destination=%s&extensions=%s&output=%s&key=%s";

    private static String DEFAULT_OUTPUT = "json";

    private static String DEFAULT_EXTENSION = "base";


    /**
     * 调用高德路径规划接口
     *
     * @Author justk
     * @Date 9:42 2019/8/20
     * @Param origin（起点，数据格式 lng , lat） destination (终点，数据格式 lng , lat) extensions (数据扩展， base：基础数据，
     * all：所有数据) output (数据输出格式，json, xml) travelType (出行方式，０－步行, 1 - 骑行，2 - 公交， 3 - 驾车)
     * @Return 高德返回的路径规划数据
     */
    public static String directionForDriving(String origin, String destination, String extensions,
        String output, int travelType) {

        checkParams(output, extensions);

        String amapUrl;
        switch (travelType) {
            case 1:
                amapUrl = BICYCLING_URL;
                break;
            case 2:
                amapUrl = TRANSIT_URL;
                break;
            case 3:
                amapUrl = DRIVING_URL;
                break;
            default:
                amapUrl = WALKING_URL;
        }

        return restTemplate
            .getForObject(
                amapUrl + String.format(params, origin, destination, DEFAULT_EXTENSION, DEFAULT_OUTPUT, amapKey), String.class);
    }

    public static void checkParams(String output, String extension) {

        if ("xml".equals(output)) {
            DEFAULT_OUTPUT = output;
        }

        if ("all".equals(extension)) {
            DEFAULT_EXTENSION = extension;
        }

    }

    public static void main(String[] args) {

        String directionStr = directionForDriving("116.481028,39.989643", "116.465302,40.004717",
            "all", null, TravelType.WALKING.getType());
        JSONObject directionJson = JSONObject.parseObject(directionStr);
        List<String> paths = directionJson.getJSONObject("route").getJSONArray("paths")
            .toJavaList(String.class);
        if (paths.size() > 0) {
            JSONObject path = JSONObject.parseObject(paths.get(0));
            System.out.println(path.getString("duration"));
        }
    }

}
