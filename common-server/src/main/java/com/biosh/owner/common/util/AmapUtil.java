package com.biosh.owner.common.util;

import com.alibaba.fastjson.JSONObject;
import com.biosh.owner.common.constants.ApplicationRetStubInfo;
import com.biosh.owner.common.constants.RetStubDetailInfo;
import java.util.List;
import org.springframework.util.Assert;
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


    private static final String params = "?origin=%s&destination=%s&extensions=base&output=json&key=%s";

    private static String DEFAULT_OUTPUT = "json";

    private static String DEFAULT_OEXTENSION = "base";

    public static String directionForDriving(String origin, String destination, String extensions,
        String output, int travelType) {
        checkOutput(output);
        checkExtensions(extensions);

        String amapUrl = null;
        switch (travelType) {
            case 0:
                amapUrl = WALKING_URL;
                break;
            case 1:
                amapUrl = BICYCLING_URL;
                break;
            case 2:
                amapUrl = TRANSIT_URL;
                break;
            case 3:
                amapUrl = DRIVING_URL;
                break;
        }
        Assert.notNull(amapUrl, "unsupported method!");

        return restTemplate
            .getForObject(amapUrl + String.format(params, origin, destination, amapKey),
                String.class);
    }

    public static void checkOutput(String output) {
        if (output.equals("json") || output.equals("xml")) {
            DEFAULT_OUTPUT = output;
        }
        throw new ApplicationRetStubInfo(RetStubDetailInfo.OUTPUT_NOT_SUPPORTED);
    }

    public static boolean checkExtensions(String extensions) {
        if (extensions.equals("base") || extensions.equals("all")) {
            return true;
        }
        throw new ApplicationRetStubInfo(RetStubDetailInfo.EXTENSION_NOT_SUPPORTED);
    }

//    public static String directionForDriving(String origin, String destination, int travelType) {
//        return directionForDriving(origin, destination, DEFAULT_OEXTENSION, DEFAULT_OUTPUT, travelType);
//    }
//
//    public static String directionForDriving(String origin, String destination, String extension, int travelType) {
//        checkExtensions(extension);
//        return directionForDriving(origin, destination, extension, DEFAULT_OUTPUT, travelType);
//    }
//
//    public static String directionForDriving(String origin, String destination, String output, int travelType) {
//        checkOutput(output)
//        return directionForDriving(origin, destination, DEFAULT_OEXTENSION, output, travelType);
//    }

    public static void main(String[] args) {

        String directionStr = directionForDriving("116.481028,39.989643", "116.465302,40.004717",
            null, null, TravelType.WALKING.getType());
        JSONObject directionJson = JSONObject.parseObject(directionStr);
        List<String> paths = directionJson.getJSONObject("route").getJSONArray("paths")
            .toJavaList(String.class);
        if (paths.size() > 0) {
            JSONObject path = JSONObject.parseObject(paths.get(0));
            System.out.println(path.getString("duration"));
        }
    }

}
