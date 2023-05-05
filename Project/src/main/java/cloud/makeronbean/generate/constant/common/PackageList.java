package cloud.makeronbean.generate.constant.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PackageList {
    BASE_COMMON_UTIL_PACKAGE(Arrays.asList("jwt", "result", "utils")), //common-util
    BASE_SERVICE_UTIL_PACKAGE(Arrays.asList("exception", "knife4j", "mp")), //service-util
    ;



    private List<String> packages;

    PackageList(List<String> packages) {
        this.packages = packages;
    }

    public List<String> getPackages() {
        return packages;
    }
}
