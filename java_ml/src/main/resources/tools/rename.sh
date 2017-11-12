#!/bin/bash

#删除Mapper文件名中的Entity
#renamePattern=''s/Entity//'

dir=$1
fileNamePattern=$2
renamePattern=$3

fileList=`find ${dir} -name ${fileNamePattern}`

for file in ${mapperFileList[*]}
do
	rename ${renamePattern} ${file}
done



