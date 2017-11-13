#!/bin/bash

#删除Mapper文件名中的Entity
#dir=/media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/mapper
#fileNamePattern="*EntityMapper*"
#renamePattern='s/Entity//'

#dir=/media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/resources/mapper
#fileNamePattern="*EntityMapper*"
#renamePattern='s/Entity//'

#./rename.sh /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/mapper "*EntityMapper*" 's/Entity//'

#./rename.sh /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/resources/mapper "*EntityMapper*" 's/Entity//'

dir=$1
fileNamePattern=$2
renamePattern=$3

mapperFileList=`find ${dir} -name ${fileNamePattern}`

#mapperFileList=`grep -rl "EntityMapper" ${dir}`
#
#mapperFileList=`find ${dir} -name "*EntityMapper*"`



for file in ${mapperFileList[*]}
do
    echo "file=${file}"
    #更改相应的接口/类名
	sed -i 's/EntityMapper/Mapper' ${file}
    #更改文件名
	rename ${renamePattern} ${file}
done



