package com.yszhdhy.generator.model.vo;

import com.yszhdhy.generator.constant.common.PackageList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageVo {

    private String packageName;

    private List<PackageVo> ChildPackage;
}
