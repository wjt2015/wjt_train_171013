#/bin/bash
#删除重复的字段和setter、getter;
#dir=/media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/entity
dir=$1
fileList=`find ${dir} -name "*Entity.java"`

strArr=(createUser createTime updateUser updateTime available ")" "return" "=" "}" "Date")


for file in ${fileList[*]}
do
echo "file=${file}"
for str in ${strArr[*]}
do
echo "str=${str}"
sed -i "/${str}/d" ${file}
echo "}" >> ${file}
#删除空行
sed -i "/^$/d" ${file}

done
done





