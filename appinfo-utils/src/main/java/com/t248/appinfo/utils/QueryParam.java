package com.t248.appinfo.utils;

import lombok.Data;

@Data
public class QueryParam {

    
     private String   querySoftwareName;
            private Long queryStatus;
        private Long queryFlatformId;
            private Long queryCategoryLevel1;
        private Long queryCategoryLevel2;
            private Long queryCategoryLevel3;

            private Long createdBy;
}
