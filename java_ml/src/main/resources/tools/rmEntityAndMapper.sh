#!/bin/bash

#./rmEntityAndMapper.sh /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/entity /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/mapper /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/resources/mapper

#./rmEntityAndMapper.sh /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/UGC_projects/ims_core_provider_171106/ims-provider/ims-core-dao/src/main/java/com/qunar/hotel/ims/dao/entity/authority /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/UGC_projects/ims_core_provider_171106/ims-provider/ims-core-dao/src/main/java/com/qunar/hotel/ims/dao/mysql/authority /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/UGC_projects/ims_core_provider_171106/ims-provider/ims-core-dao/src/main/resources/mysql/authority

#设置默认目录
entityDir=/media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/entity
mapperDir=/media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/mapper
xmlDir=/media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/resources/mapper


echo "argCount=$#"
argCountNeed=3;


if test $# -ge ${argCountNeed}
then
    entityDir=$1;
    mapperDir=$2;
    xmlDir=$3;
fi
echo "entityDir=${entityDir}"
cd ${entityDir} && rm -rf *

echo "mapperDir=${mapperDir}"
cd ${mapperDir} && rm -rf *

echo "xmlDir=${xmlDir}"
cd ${xmlDir} && rm -rf *


