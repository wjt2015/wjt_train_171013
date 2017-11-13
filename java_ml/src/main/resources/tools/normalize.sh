#!/bin/bash


#./normalize.sh /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/entity /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/mapper /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/resources/mapper "*EntityMapper*" "s/Entity//"

#删除Entity.java内多余的内容
dir=$1
fileList=`find ${dir} -name "*Entity.java"`

strArr=(createUser createTime updateUser updateTime available "set" "get" "return" "this" "}" "java.util.Date")


for file in ${fileList[*]}
do
echo "file=${file}"
for str in ${strArr[*]}
do
echo "str=${str}"
sed -i "/${str}/d" ${file}
#删除空行
sed -i "/^$/d" ${file}

done

echo "}" >> ${file}
done


#在Entity.java内添加注解和注释
strList=("import lombok.AllArgsConstructor;"  "import lombok.Getter;"  "import lombok.NoArgsConstructor;"  "import lombok.Setter;"  "import lombok.ToString;"  "import lombok.experimental.Accessors;"  "\/\*\* @author jintao.wang `date '+Date: %Y-%m-%d Time: %p%l:%M'` "  "\*\/"  "@AllArgsConstructor"  "@NoArgsConstructor"  "@Setter"  "@Getter" "@ToString" "@Accessors(chain = true)")
javaEntityFileList=`find ${dir} -name "*Entity.java"`
for file in ${javaEntityFileList[*]}
do
for str in ${strList[*]}
do
  echo "str=${str}"
  sed -i "s/public class/${str}\npublic class/" ${file}
done
done


#为EntityMapper文件改名

#mapperJavaDir=$2
#xmlDir=$3

mapperDirList=($2 $3)

fileNamePattern=$4
renamePattern=$5


for mapperDir in ${mapperDirList[*]}
do
    mapperFileList=`find ${mapperDir} -name ${fileNamePattern}`

    for file in ${mapperFileList[*]}
    do
        #更改相应的接口/类名
	    sed -i 's/EntityMapper/Mapper/' ${file}
        #更改文件名
	    rename ${renamePattern} ${file}
    done
done

#修改成员名
sed -i 's/countofmember/countOfMember/' $(grep -rl "countofmember" ./)
sed -i "s/ByPrimaryKey//" $(grep -rl "ByPrimaryKey")


